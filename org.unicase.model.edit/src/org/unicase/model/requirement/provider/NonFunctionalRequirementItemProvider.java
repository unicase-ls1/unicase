/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.rationale.provider.CriterionItemProvider;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.model.requirement.NonFunctionalRequirement} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class NonFunctionalRequirementItemProvider extends CriterionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NonFunctionalRequirementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addRestrictedScenariosPropertyDescriptor(object);
			addRestrictedUseCasesPropertyDescriptor(object);
			addSystemFunctionsPropertyDescriptor(object);
			addUserTasksPropertyDescriptor(object);
			addDonePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Restricted Scenarios feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addRestrictedScenariosPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_NonFunctionalRequirement_restrictedScenarios_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_NonFunctionalRequirement_restrictedScenarios_feature",
								"_UI_NonFunctionalRequirement_type"),
						RequirementPackage.Literals.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Restricted Use Cases feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addRestrictedUseCasesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_NonFunctionalRequirement_restrictedUseCases_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_NonFunctionalRequirement_restrictedUseCases_feature",
								"_UI_NonFunctionalRequirement_type"),
						RequirementPackage.Literals.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the System Functions feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemFunctionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_NonFunctionalRequirement_systemFunctions_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_NonFunctionalRequirement_systemFunctions_feature",
								"_UI_NonFunctionalRequirement_type"),
						RequirementPackage.Literals.NON_FUNCTIONAL_REQUIREMENT__SYSTEM_FUNCTIONS,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the User Tasks feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserTasksPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_NonFunctionalRequirement_userTasks_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_NonFunctionalRequirement_userTasks_feature",
								"_UI_NonFunctionalRequirement_type"),
						RequirementPackage.Literals.NON_FUNCTIONAL_REQUIREMENT__USER_TASKS,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Done feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDonePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_NonFunctionalRequirement_done_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_NonFunctionalRequirement_done_feature",
						"_UI_NonFunctionalRequirement_type"),
				RequirementPackage.Literals.NON_FUNCTIONAL_REQUIREMENT__DONE,
				true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This returns NonFunctionalRequirement.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(
				object,
				getResourceLocator().getImage(
						"full/obj16/NonFunctionalRequirement"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(NonFunctionalRequirement.class)) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__DONE:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ModelEditPlugin.INSTANCE;
	}

}
