/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

class Statemachine {
	
	@Inject extension Naming cNaming
	@Inject extension Navigation
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension GenmodelEntries
	@Inject extension INamingService
	@Inject extension ConstantInitializationResolver
	
	def generateStatemachineH(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		 flow.initializeNamingService
		 fsa.generateFile(flow.module.h, flow.statemachineHContent(entry) )
	}
	
	def statemachineHContent(ExecutionFlow it,  GeneratorEntry entry) '''
			«entry.licenseText»
			
			#ifndef «module.define»_H_
			#define «module.define»_H_

			#include "«typesModule.h»"
			
			#ifdef __cplusplus
			extern "C" { 
			#endif 

			/*! \file Header of the state machine '«name»'.
			*/
			
			«statesEnumDecl»
			
			«FOR s : it.scopes»«s.scopeTypeDecl»«ENDFOR»
			
			«statemachineTypeDecl»

			/*! Initializes the «type» state machine data structures. Must be called before first usage.*/
			extern void «functionPrefix»init(«scHandleDecl»);
			
			/*! Activates the state machine */
			extern void «functionPrefix»enter(«scHandleDecl»);
			
			/*! Deactivates the state machine */
			extern void «functionPrefix»exit(«scHandleDecl»);
			
			/*! Performs a 'run to completion' step. */
			extern void «functionPrefix»runCycle(«scHandleDecl»);

			«IF timed»
				/*! Raises a time event. */
				extern void «raiseTimeEventFctID»(«scHandleDecl», sc_eventid evid);
			«ENDIF»
			
			«FOR s : it.scopes.filter( typeof(InterfaceScope) )»
				«s.scopeFunctionPrototypes»
			«ENDFOR»
			
			/*!
			 * Checks if the statemachine is active (until 2.4.1 this method was used for states).
			 * A statemachine is active if it was entered. It is inactive if it has not been entered at all or if it was exited.
			 */
			extern sc_boolean «isActiveFctID»(const «scHandleDecl»);
			
			/*!
			 * Checks if all active states are final. 
			 * If there are no active states then the statemachine is considered as inactive and this method returns false.
			 */
			extern sc_boolean «isFinalFctID»(const «scHandleDecl»);
			
			/*! Checks if the specified state is active (until 2.4.1 the used method for states was calles isActive()). */
			extern sc_boolean «stateActiveFctID»(const «scHandleDecl», «statesEnumType» state);
			
			#ifdef __cplusplus
			}
			#endif 
			
			#endif /* «module.define»_H_ */
	'''

	def statesEnumDecl(ExecutionFlow it) '''
		/*! Enumeration of all states */ 
		typedef enum {
			«FOR state : states »
			«state.shortName»,
			«ENDFOR»
			«null_state»
		} «statesEnumType»;
	'''


	def dispatch structDeclaration(EventDefinition it) '''
		sc_boolean «name.asIdentifier»_raised;
		«IF type != null && type.name != 'void'»«type.targetLanguageName» «name.asIdentifier»_value;«ENDIF»
	'''

	def dispatch structDeclaration(TimeEvent it) '''
		sc_boolean «shortName.raised»;
	'''

	def dispatch structDeclaration(VariableDefinition it) '''
		«IF type.name != 'void' && !isConst»«type.targetLanguageName» «name.asEscapedIdentifier»;«ENDIF»
	'''
	
	def dispatch structDeclaration(Declaration it) ''''''
	
	
	def scopeTypeDecl(Scope it) '''
		/*! Type definition of the data structure for the «type» interface scope. */
		typedef struct {
			«FOR d : declarations »
			«d.structDeclaration»
			«ENDFOR»
		} «it.type»;
		
		/* Declaration of constants for scope «type». */
		«FOR d : declarations.filter(typeof(VariableDefinition)).filter[const]»
			«IF d.type.name != 'void'»const «d.type.targetLanguageName» «d.constantName» = «d.initialValue.resolveConstants»;«ENDIF»
		«ENDFOR»

	'''

	def statemachineTypeDecl(ExecutionFlow it) '''
		/*! Define dimension of the state configuration vector for orthogonal states. */
		#define «type.toUpperCase»_MAX_ORTHOGONAL_STATES «stateVector.size»
		«IF hasHistory»
		/*! Define dimension of the state configuration vector for history states. */
		#define «type.toUpperCase»_MAX_HISTORY_STATES «historyVector.size»«ENDIF»
		
		/*! 
		 * Type definition of the data structure for the «type» state machine.
		 * This data structure has to be allocated by the client code. 
		 */
		typedef struct {
			«statesEnumType» stateConfVector[«type.toUpperCase»_MAX_ORTHOGONAL_STATES];
			«IF hasHistory»«statesEnumType» historyVector[«type.toUpperCase»_MAX_HISTORY_STATES];«ENDIF»
			sc_ushort stateConfVectorPosition; 
			
			«FOR iScope : scopes »
			«iScope.type» «iScope.instance»;
			«ENDFOR»			
		} «type»;
	'''


	def dispatch scopeFunctionPrototypes(StatechartScope it) '''
		«FOR d : declarations »
		«d.functionPrototypes »
		«ENDFOR»
	'''	

	def dispatch scopeFunctionPrototypes(Object it) ''''''	
	

	def dispatch functionPrototypes(Declaration it) ''''''

	def dispatch functionPrototypes(EventDefinition it) '''
		«IF direction == Direction::IN»
		/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */ 
		extern void «asRaiser»(«scHandleDecl»«valueParams»);
		
		«ELSE»
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */ 
			extern sc_boolean «asRaised»(const «scHandleDecl»);
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */ 
				extern «type.targetLanguageName» «asGetter»(const «scHandleDecl»);
				
			«ENDIF»
		«ENDIF»
	'''

	def dispatch functionPrototypes(VariableDefinition it) '''
		/*! Gets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
		extern «type.targetLanguageName» «it.asGetter»(const «scHandleDecl»);
		«IF !readonly && !const»
			/*! Sets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
			extern void «asSetter»(«scHandleDecl», «type.targetLanguageName» value);
		«ENDIF»
	'''
}