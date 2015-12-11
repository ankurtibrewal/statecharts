/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.transformation.test;

import org.junit.Before;
import org.yakindu.sct.domain.generic.modules.GenericSequencerModule;
import org.yakindu.sct.model.sexec.naming.DefaultNamingService;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.StructureMapping;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author axel terfloth
 * 
 */
public class ModelSequencerTest extends Assert {

	@Inject
	protected IModelSequencer sequencer;

	@Inject
	protected BehaviorMapping behaviorMapping;

	@Inject
	protected StructureMapping structureMapping;

	@Before
	public void setup() {
		Module m = Modules.override(new GenericSequencerModule()).with(new Module(){
			@Override
			public void configure(Binder binder) {
				binder.bind(INamingService.class).to(DefaultNamingService.class);
			}
		});
		Injector injector = Guice.createInjector(m);
		injector.injectMembers(this);
	}

}
