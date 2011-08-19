/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.emfstore.common.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.provider.SemanticCompositeOperationItemProvider;
import org.unicase.implementation.operations.ExtractClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.OperationsPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.implementation.operations.ExtractClassOperation} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ExtractClassOperationItemProvider extends SemanticCompositeOperationItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtractClassOperationItemProvider(AdapterFactory adapterFactory) {
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

			addCompositionNamePropertyDescriptor(object);
			addClassNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Composition Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompositionNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExtractClassOperation_compositionName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExtractClassOperation_compositionName_feature", "_UI_ExtractClassOperation_type"),
				 OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__COMPOSITION_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Class Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExtractClassOperation_className_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExtractClassOperation_className_feature", "_UI_ExtractClassOperation_type"),
				 OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__CLASS_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS);
			childrenFeatures.add(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__ATTRIBUTES);
			childrenFeatures.add(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS);
			childrenFeatures.add(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS);
			childrenFeatures.add(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE);
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
	 * {@inheritDoc}<!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ExtractClassOperation.png"));
	}

	/**
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof ExtractClassOperation) {
			ExtractClassOperation operation = (ExtractClassOperation) object;
			StringBuilder builder = new StringBuilder();
			builder.append("Extracted class \"");
			builder.append(operation.getClassName());
			builder.append("\" from class ");
			builder.append(getModelElementName(operation.getContextClass()));
			builder.append(" over association \"");
			builder.append(operation.getCompositionName());
			builder.append("\"");
			return builder.toString();
		} else {
			return super.getText(object);
		}
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

		switch (notification.getFeatureID(ExtractClassOperation.class)) {
			case OperationsPackage.EXTRACT_CLASS_OPERATION__COMPOSITION_NAME:
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CLASS_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS:
			case OperationsPackage.EXTRACT_CLASS_OPERATION__ATTRIBUTES:
			case OperationsPackage.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
			case OperationsPackage.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
			case OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
				 OperationsFactory.eINSTANCE.createExtractSuperClassOperation()));

		newChildDescriptors.add
			(createChildParameter
				(org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
				 OperationsFactory.eINSTANCE.createInlineSuperClassOperation()));

		newChildDescriptors.add
			(createChildParameter
				(org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
				 OperationsFactory.eINSTANCE.createExtractClassOperation()));

		newChildDescriptors.add
			(createChildParameter
				(org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
				 OperationsFactory.eINSTANCE.createInlineClassOperation()));

		newChildDescriptors.add
			(createChildParameter
				(org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
				 OperationsFactory.eINSTANCE.createPartitionAssociationOperation()));

		newChildDescriptors.add
			(createChildParameter
				(org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
				 OperationsFactory.eINSTANCE.createPushDownOperation()));

		newChildDescriptors.add
			(createChildParameter
				(org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
				 OperationsFactory.eINSTANCE.createPullUpOperation()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS,
				 ModelFactory.eINSTANCE.createModelElementId()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__ATTRIBUTES,
				 ModelFactory.eINSTANCE.createModelElementId()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS,
				 ModelFactory.eINSTANCE.createModelElementId()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS,
				 ModelFactory.eINSTANCE.createModelElementId()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE,
				 ModelFactory.eINSTANCE.createModelElementId()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS ||
			childFeature == OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__ATTRIBUTES ||
			childFeature == OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS ||
			childFeature == OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS ||
			childFeature == OperationsPackage.Literals.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OperationsEditPlugin.INSTANCE;
	}

}
