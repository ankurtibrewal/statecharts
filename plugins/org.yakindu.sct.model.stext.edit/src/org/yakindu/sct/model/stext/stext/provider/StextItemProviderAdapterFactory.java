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
package org.yakindu.sct.model.stext.stext.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.yakindu.sct.model.stext.stext.util.StextAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StextItemProviderAdapterFactory extends StextAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable
{
  /**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ComposedAdapterFactory parentAdapterFactory;

  /**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected IChangeNotifier changeNotifier = new ChangeNotifier();

  /**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected Collection<Object> supportedTypes = new ArrayList<Object>();

  /**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StextItemProviderAdapterFactory()
  {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.Root} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected RootItemProvider rootItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.Root}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createRootAdapter()
  {
		if (rootItemProvider == null) {
			rootItemProvider = new RootItemProvider(this);
		}

		return rootItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.DefRoot} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DefRootItemProvider defRootItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.DefRoot}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createDefRootAdapter()
  {
		if (defRootItemProvider == null) {
			defRootItemProvider = new DefRootItemProvider(this);
		}

		return defRootItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.StatechartRoot} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected StatechartRootItemProvider statechartRootItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.StatechartRoot}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createStatechartRootAdapter()
  {
		if (statechartRootItemProvider == null) {
			statechartRootItemProvider = new StatechartRootItemProvider(this);
		}

		return statechartRootItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.StateRoot} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected StateRootItemProvider stateRootItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.StateRoot}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createStateRootAdapter()
  {
		if (stateRootItemProvider == null) {
			stateRootItemProvider = new StateRootItemProvider(this);
		}

		return stateRootItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.TransitionRoot} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TransitionRootItemProvider transitionRootItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.TransitionRoot}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createTransitionRootAdapter()
  {
		if (transitionRootItemProvider == null) {
			transitionRootItemProvider = new TransitionRootItemProvider(this);
		}

		return transitionRootItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.StatechartSpecification} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected StatechartSpecificationItemProvider statechartSpecificationItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.StatechartSpecification}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createStatechartSpecificationAdapter()
  {
		if (statechartSpecificationItemProvider == null) {
			statechartSpecificationItemProvider = new StatechartSpecificationItemProvider(this);
		}

		return statechartSpecificationItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.StateSpecification} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected StateSpecificationItemProvider stateSpecificationItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.StateSpecification}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createStateSpecificationAdapter()
  {
		if (stateSpecificationItemProvider == null) {
			stateSpecificationItemProvider = new StateSpecificationItemProvider(this);
		}

		return stateSpecificationItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.TransitionSpecification} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TransitionSpecificationItemProvider transitionSpecificationItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.TransitionSpecification}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createTransitionSpecificationAdapter()
  {
		if (transitionSpecificationItemProvider == null) {
			transitionSpecificationItemProvider = new TransitionSpecificationItemProvider(this);
		}

		return transitionSpecificationItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.StatechartScope} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected StatechartScopeItemProvider statechartScopeItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.StatechartScope}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createStatechartScopeAdapter()
  {
		if (statechartScopeItemProvider == null) {
			statechartScopeItemProvider = new StatechartScopeItemProvider(this);
		}

		return statechartScopeItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.InterfaceScope} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected InterfaceScopeItemProvider interfaceScopeItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.InterfaceScope}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createInterfaceScopeAdapter()
  {
		if (interfaceScopeItemProvider == null) {
			interfaceScopeItemProvider = new InterfaceScopeItemProvider(this);
		}

		return interfaceScopeItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.InternalScope} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected InternalScopeItemProvider internalScopeItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.InternalScope}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createInternalScopeAdapter()
  {
		if (internalScopeItemProvider == null) {
			internalScopeItemProvider = new InternalScopeItemProvider(this);
		}

		return internalScopeItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.ImportScope} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ImportScopeItemProvider importScopeItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.ImportScope}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createImportScopeAdapter()
  {
		if (importScopeItemProvider == null) {
			importScopeItemProvider = new ImportScopeItemProvider(this);
		}

		return importScopeItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.Import} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ImportItemProvider importItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.Import}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createImportAdapter()
  {
		if (importItemProvider == null) {
			importItemProvider = new ImportItemProvider(this);
		}

		return importItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.EventDefinition} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EventDefinitionItemProvider eventDefinitionItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.EventDefinition}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createEventDefinitionAdapter()
  {
		if (eventDefinitionItemProvider == null) {
			eventDefinitionItemProvider = new EventDefinitionItemProvider(this);
		}

		return eventDefinitionItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.VariableDefinition} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected VariableDefinitionItemProvider variableDefinitionItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.VariableDefinition}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createVariableDefinitionAdapter()
  {
		if (variableDefinitionItemProvider == null) {
			variableDefinitionItemProvider = new VariableDefinitionItemProvider(this);
		}

		return variableDefinitionItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.OperationDefinition} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected OperationDefinitionItemProvider operationDefinitionItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.OperationDefinition}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createOperationDefinitionAdapter()
  {
		if (operationDefinitionItemProvider == null) {
			operationDefinitionItemProvider = new OperationDefinitionItemProvider(this);
		}

		return operationDefinitionItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.TypeAliasDefinition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeAliasDefinitionItemProvider typeAliasDefinitionItemProvider;

		/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.TypeAliasDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTypeAliasDefinitionAdapter() {
		if (typeAliasDefinitionItemProvider == null) {
			typeAliasDefinitionItemProvider = new TypeAliasDefinitionItemProvider(this);
		}

		return typeAliasDefinitionItemProvider;
	}

		/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.LocalReaction} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LocalReactionItemProvider localReactionItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.LocalReaction}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createLocalReactionAdapter()
  {
		if (localReactionItemProvider == null) {
			localReactionItemProvider = new LocalReactionItemProvider(this);
		}

		return localReactionItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.TransitionReaction} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TransitionReactionItemProvider transitionReactionItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.TransitionReaction}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createTransitionReactionAdapter()
  {
		if (transitionReactionItemProvider == null) {
			transitionReactionItemProvider = new TransitionReactionItemProvider(this);
		}

		return transitionReactionItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.Guard} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected GuardItemProvider guardItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.Guard}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createGuardAdapter()
  {
		if (guardItemProvider == null) {
			guardItemProvider = new GuardItemProvider(this);
		}

		return guardItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.EntryPointSpec} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EntryPointSpecItemProvider entryPointSpecItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.EntryPointSpec}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createEntryPointSpecAdapter()
  {
		if (entryPointSpecItemProvider == null) {
			entryPointSpecItemProvider = new EntryPointSpecItemProvider(this);
		}

		return entryPointSpecItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.ExitPointSpec} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ExitPointSpecItemProvider exitPointSpecItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.ExitPointSpec}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createExitPointSpecAdapter()
  {
		if (exitPointSpecItemProvider == null) {
			exitPointSpecItemProvider = new ExitPointSpecItemProvider(this);
		}

		return exitPointSpecItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.EventSpec} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EventSpecItemProvider eventSpecItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.EventSpec}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createEventSpecAdapter()
  {
		if (eventSpecItemProvider == null) {
			eventSpecItemProvider = new EventSpecItemProvider(this);
		}

		return eventSpecItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.RegularEventSpec} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected RegularEventSpecItemProvider regularEventSpecItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.RegularEventSpec}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createRegularEventSpecAdapter()
  {
		if (regularEventSpecItemProvider == null) {
			regularEventSpecItemProvider = new RegularEventSpecItemProvider(this);
		}

		return regularEventSpecItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.TimeEventSpec} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TimeEventSpecItemProvider timeEventSpecItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.TimeEventSpec}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createTimeEventSpecAdapter()
  {
		if (timeEventSpecItemProvider == null) {
			timeEventSpecItemProvider = new TimeEventSpecItemProvider(this);
		}

		return timeEventSpecItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.BuiltinEventSpec} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected BuiltinEventSpecItemProvider builtinEventSpecItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.BuiltinEventSpec}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createBuiltinEventSpecAdapter()
  {
		if (builtinEventSpecItemProvider == null) {
			builtinEventSpecItemProvider = new BuiltinEventSpecItemProvider(this);
		}

		return builtinEventSpecItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.EntryEvent} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EntryEventItemProvider entryEventItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.EntryEvent}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createEntryEventAdapter()
  {
		if (entryEventItemProvider == null) {
			entryEventItemProvider = new EntryEventItemProvider(this);
		}

		return entryEventItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.ExitEvent} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ExitEventItemProvider exitEventItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.ExitEvent}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createExitEventAdapter()
  {
		if (exitEventItemProvider == null) {
			exitEventItemProvider = new ExitEventItemProvider(this);
		}

		return exitEventItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.AlwaysEvent} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AlwaysEventItemProvider alwaysEventItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.AlwaysEvent}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createAlwaysEventAdapter()
  {
		if (alwaysEventItemProvider == null) {
			alwaysEventItemProvider = new AlwaysEventItemProvider(this);
		}

		return alwaysEventItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.SimpleScope} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SimpleScopeItemProvider simpleScopeItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.SimpleScope}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createSimpleScopeAdapter()
  {
		if (simpleScopeItemProvider == null) {
			simpleScopeItemProvider = new SimpleScopeItemProvider(this);
		}

		return simpleScopeItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.ReactionTrigger} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ReactionTriggerItemProvider reactionTriggerItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.ReactionTrigger}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createReactionTriggerAdapter()
  {
		if (reactionTriggerItemProvider == null) {
			reactionTriggerItemProvider = new ReactionTriggerItemProvider(this);
		}

		return reactionTriggerItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.DefaultTrigger} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DefaultTriggerItemProvider defaultTriggerItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.DefaultTrigger}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createDefaultTriggerAdapter()
  {
		if (defaultTriggerItemProvider == null) {
			defaultTriggerItemProvider = new DefaultTriggerItemProvider(this);
		}

		return defaultTriggerItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.ReactionEffect} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ReactionEffectItemProvider reactionEffectItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.ReactionEffect}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createReactionEffectAdapter()
  {
		if (reactionEffectItemProvider == null) {
			reactionEffectItemProvider = new ReactionEffectItemProvider(this);
		}

		return reactionEffectItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.EventRaisingExpression} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EventRaisingExpressionItemProvider eventRaisingExpressionItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.EventRaisingExpression}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createEventRaisingExpressionAdapter()
  {
		if (eventRaisingExpressionItemProvider == null) {
			eventRaisingExpressionItemProvider = new EventRaisingExpressionItemProvider(this);
		}

		return eventRaisingExpressionItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.EventValueReferenceExpression} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EventValueReferenceExpressionItemProvider eventValueReferenceExpressionItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.EventValueReferenceExpression}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createEventValueReferenceExpressionAdapter()
  {
		if (eventValueReferenceExpressionItemProvider == null) {
			eventValueReferenceExpressionItemProvider = new EventValueReferenceExpressionItemProvider(this);
		}

		return eventValueReferenceExpressionItemProvider;
	}

  /**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression} instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ActiveStateReferenceExpressionItemProvider activeStateReferenceExpressionItemProvider;

  /**
	 * This creates an adapter for a {@link org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter createActiveStateReferenceExpressionAdapter()
  {
		if (activeStateReferenceExpressionItemProvider == null) {
			activeStateReferenceExpressionItemProvider = new ActiveStateReferenceExpressionItemProvider(this);
		}

		return activeStateReferenceExpressionItemProvider;
	}

  /**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ComposeableAdapterFactory getRootAdapterFactory()
  {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

  /**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
  {
		this.parentAdapterFactory = parentAdapterFactory;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object type)
  {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

  /**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Adapter adapt(Notifier notifier, Object type)
  {
		return super.adapt(notifier, this);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object adapt(Object object, Object type)
  {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

  /**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void addListener(INotifyChangedListener notifyChangedListener)
  {
		changeNotifier.addListener(notifyChangedListener);
	}

  /**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void removeListener(INotifyChangedListener notifyChangedListener)
  {
		changeNotifier.removeListener(notifyChangedListener);
	}

  /**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void fireNotifyChanged(Notification notification)
  {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

  /**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void dispose()
  {
		if (rootItemProvider != null) rootItemProvider.dispose();
		if (defRootItemProvider != null) defRootItemProvider.dispose();
		if (statechartRootItemProvider != null) statechartRootItemProvider.dispose();
		if (stateRootItemProvider != null) stateRootItemProvider.dispose();
		if (transitionRootItemProvider != null) transitionRootItemProvider.dispose();
		if (statechartSpecificationItemProvider != null) statechartSpecificationItemProvider.dispose();
		if (stateSpecificationItemProvider != null) stateSpecificationItemProvider.dispose();
		if (transitionSpecificationItemProvider != null) transitionSpecificationItemProvider.dispose();
		if (statechartScopeItemProvider != null) statechartScopeItemProvider.dispose();
		if (interfaceScopeItemProvider != null) interfaceScopeItemProvider.dispose();
		if (internalScopeItemProvider != null) internalScopeItemProvider.dispose();
		if (importScopeItemProvider != null) importScopeItemProvider.dispose();
		if (importItemProvider != null) importItemProvider.dispose();
		if (eventDefinitionItemProvider != null) eventDefinitionItemProvider.dispose();
		if (variableDefinitionItemProvider != null) variableDefinitionItemProvider.dispose();
		if (operationDefinitionItemProvider != null) operationDefinitionItemProvider.dispose();
		if (typeAliasDefinitionItemProvider != null) typeAliasDefinitionItemProvider.dispose();
		if (localReactionItemProvider != null) localReactionItemProvider.dispose();
		if (transitionReactionItemProvider != null) transitionReactionItemProvider.dispose();
		if (guardItemProvider != null) guardItemProvider.dispose();
		if (entryPointSpecItemProvider != null) entryPointSpecItemProvider.dispose();
		if (exitPointSpecItemProvider != null) exitPointSpecItemProvider.dispose();
		if (eventSpecItemProvider != null) eventSpecItemProvider.dispose();
		if (regularEventSpecItemProvider != null) regularEventSpecItemProvider.dispose();
		if (timeEventSpecItemProvider != null) timeEventSpecItemProvider.dispose();
		if (builtinEventSpecItemProvider != null) builtinEventSpecItemProvider.dispose();
		if (entryEventItemProvider != null) entryEventItemProvider.dispose();
		if (exitEventItemProvider != null) exitEventItemProvider.dispose();
		if (alwaysEventItemProvider != null) alwaysEventItemProvider.dispose();
		if (simpleScopeItemProvider != null) simpleScopeItemProvider.dispose();
		if (reactionTriggerItemProvider != null) reactionTriggerItemProvider.dispose();
		if (defaultTriggerItemProvider != null) defaultTriggerItemProvider.dispose();
		if (reactionEffectItemProvider != null) reactionEffectItemProvider.dispose();
		if (eventRaisingExpressionItemProvider != null) eventRaisingExpressionItemProvider.dispose();
		if (eventValueReferenceExpressionItemProvider != null) eventValueReferenceExpressionItemProvider.dispose();
		if (activeStateReferenceExpressionItemProvider != null) activeStateReferenceExpressionItemProvider.dispose();
	}

}
