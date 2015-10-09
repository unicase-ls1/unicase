/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.change.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationsFactory;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.MergingSolution;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.rationale.provider.SolutionItemProvider;

/**
 * This is the item provider adapter for a {@link org.unicase.model.change.MergingSolution} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class MergingSolutionItemProvider extends SolutionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MergingSolutionItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MergingSolution.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/MergingSolution"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MergingSolution) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_MergingSolution_type")
				: getString("_UI_MergingSolution_type") + " " + label;
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

		switch (notification.getFeatureID(MergingSolution.class)) {
		case ChangePackage.MERGING_SOLUTION__APPLIED_OPERATIONS:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
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

		newChildDescriptors.add(createChildParameter(
				ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
				OperationsFactory.eINSTANCE.createCompositeOperation()));

		newChildDescriptors.add(createChildParameter(
				ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
				OperationsFactory.eINSTANCE.createCreateDeleteOperation()));

		newChildDescriptors.add(createChildParameter(
				ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
				OperationsFactory.eINSTANCE.createAttributeOperation()));

		newChildDescriptors.add(createChildParameter(
				ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
				OperationsFactory.eINSTANCE.createMultiAttributeOperation()));

		newChildDescriptors
				.add(createChildParameter(
						ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
						OperationsFactory.eINSTANCE
								.createMultiAttributeSetOperation()));

		newChildDescriptors
				.add(createChildParameter(
						ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
						OperationsFactory.eINSTANCE
								.createMultiAttributeMoveOperation()));

		newChildDescriptors.add(createChildParameter(
				ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
				OperationsFactory.eINSTANCE.createSingleReferenceOperation()));

		newChildDescriptors
				.add(createChildParameter(
						ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
						OperationsFactory.eINSTANCE
								.createMultiReferenceSetOperation()));

		newChildDescriptors.add(createChildParameter(
				ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
				OperationsFactory.eINSTANCE.createMultiReferenceOperation()));

		newChildDescriptors
				.add(createChildParameter(
						ChangePackage.Literals.MERGING_SOLUTION__APPLIED_OPERATIONS,
						OperationsFactory.eINSTANCE
								.createMultiReferenceMoveOperation()));
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
