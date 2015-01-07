/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.emfstore.internal.common.model.ModelElementId;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.PullUpOperation;

/**
 * This is the item provider adapter for a
 * {@link org.unicase.implementation.operations.PullUpOperation} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class PullUpOperationItemProvider
		extends
		org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.provider.SemanticCompositeOperationItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PullUpOperationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(OperationsPackage.Literals.PULL_UP_OPERATION__SUPER_CLASS);
			childrenFeatures
					.add(OperationsPackage.Literals.PULL_UP_OPERATION__ATTRIBUTES);
			childrenFeatures
					.add(OperationsPackage.Literals.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS);
			childrenFeatures
					.add(OperationsPackage.Literals.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * {@inheritDoc}. This returns PullUpOperation.gif. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/PullUpOperation.png"));
	}

	/**
	 * {@inheritDoc}. This returns the label text for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof PullUpOperation) {
			PullUpOperation operation = (PullUpOperation) object;
			StringBuilder builder = new StringBuilder();
			builder.append("Pulled up ");

			boolean hasAttributes = operation.getAttributes().size() > 0;
			if (hasAttributes) {
				builder.append(" attribute(s) ");
				builder.append(getModelElementNames(operation.getAttributes()));
			}

			boolean hasAssociations = operation.getIncomingAssociations()
					.size() + operation.getOutgoingAssociations().size() > 0;
			if (hasAssociations) {
				if (hasAttributes) {
					builder.append(" and");
				}
				builder.append(" association(s) ");
				List<ModelElementId> ids = new ArrayList<ModelElementId>();
				ids.addAll(operation.getOutgoingAssociations());
				ids.addAll(operation.getOutgoingAssociations());
				builder.append(getModelElementNames(ids));
			}

			builder.append(" to superclass ");
			builder.append(getModelElementName(operation.getSuperClass()));

			return builder.toString();
		} else {
			return super.getText(object);
		}
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(PullUpOperation.class)) {
		case OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS:
		case OperationsPackage.PULL_UP_OPERATION__ATTRIBUTES:
		case OperationsPackage.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS:
		case OperationsPackage.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(createChildParameter(
						org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
						OperationsFactory.eINSTANCE
								.createExtractSuperClassOperation()));

		newChildDescriptors
				.add(createChildParameter(
						org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
						OperationsFactory.eINSTANCE
								.createInlineSuperClassOperation()));

		newChildDescriptors
				.add(createChildParameter(
						org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
						OperationsFactory.eINSTANCE
								.createExtractClassOperation()));

		newChildDescriptors
				.add(createChildParameter(
						org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
						OperationsFactory.eINSTANCE
								.createInlineClassOperation()));

		newChildDescriptors
				.add(createChildParameter(
						org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
						OperationsFactory.eINSTANCE
								.createPartitionAssociationOperation()));

		newChildDescriptors
				.add(createChildParameter(
						org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
						OperationsFactory.eINSTANCE.createPushDownOperation()));

		newChildDescriptors
				.add(createChildParameter(
						org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
						OperationsFactory.eINSTANCE.createPullUpOperation()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.PULL_UP_OPERATION__SUPER_CLASS,
						org.eclipse.emf.emfstore.internal.common.model.ModelFactory.eINSTANCE
								.createModelElementId()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.PULL_UP_OPERATION__ATTRIBUTES,
						org.eclipse.emf.emfstore.internal.common.model.ModelFactory.eINSTANCE
								.createModelElementId()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS,
						org.eclipse.emf.emfstore.internal.common.model.ModelFactory.eINSTANCE
								.createModelElementId()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS,
						org.eclipse.emf.emfstore.internal.common.model.ModelFactory.eINSTANCE
								.createModelElementId()));
	}

	/**
	 * This returns the label text for
	 * {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == OperationsPackage.Literals.PULL_UP_OPERATION__SUPER_CLASS
				|| childFeature == OperationsPackage.Literals.PULL_UP_OPERATION__ATTRIBUTES
				|| childFeature == OperationsPackage.Literals.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS
				|| childFeature == OperationsPackage.Literals.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] {
					getTypeText(childObject), getFeatureText(childFeature),
					getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OperationsEditPlugin.INSTANCE;
	}

}
