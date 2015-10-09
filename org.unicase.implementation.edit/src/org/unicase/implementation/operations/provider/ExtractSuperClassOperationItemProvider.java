/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.OperationsPackage;

/**
 * This is the item provider adapter for a
 * {@link org.unicase.implementation.operations.ExtractSuperClassOperation}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ExtractSuperClassOperationItemProvider
		extends
		org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.provider.SemanticCompositeOperationItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtractSuperClassOperationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	// /**
	// * @generated NOT {@inheritDoc}
	// * @see
	// org.eclipse.emf.edit.provider.ItemProviderAdapter#getChildren(java.lang.Object)
	// */
	// @Override
	// public Collection<?> getChildren(Object object) {
	// if (object instanceof ExtractSuperClassOperation) {
	// ExtractSuperClassOperation operation = (ExtractSuperClassOperation)
	// object;
	// ArrayList<Object> result = new ArrayList<Object>();
	//
	// org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory
	// factory =
	// org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory.eINSTANCE;
	// ModelElementGroup subClassesGroup = factory.createModelElementGroup();
	// subClassesGroup.setName("Subclasses");
	// subClassesGroup.getModelElements().addAll(operation.getSubClasses());
	// result.add(subClassesGroup);
	//
	// ModelElementGroup extractsGroup = factory.createModelElementGroup();
	// extractsGroup.setName("Extracted Attributes and Associations");
	// extractsGroup.getModelElements().addAll(operation.getAttributes());
	// extractsGroup.getModelElements().addAll(operation.getOutgoingAssociations());
	// extractsGroup.getModelElements().addAll(operation.getIncomingAssociations());
	// result.add(extractsGroup);
	//
	// OperationGroup detailsGroup = factory.createOperationGroup();
	// detailsGroup.setName("Additional Details");
	// detailsGroup.getOperations().addAll(operation.getSubOperations());
	// result.add(detailsGroup);
	//
	// return result;
	// }
	// return super.getChildren(object);
	// }

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

			addSubClassesPropertyDescriptor(object);
			addSuperClassNamePropertyDescriptor(object);
			addTargetPackagePropertyDescriptor(object);
			addSuperSuperClassesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Sub Classes feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSubClassesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ExtractSuperClassOperation_subClasses_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_ExtractSuperClassOperation_subClasses_feature",
								"_UI_ExtractSuperClassOperation_type"),
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES,
						true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Super Class Name feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSuperClassNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ExtractSuperClassOperation_superClassName_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_ExtractSuperClassOperation_superClassName_feature",
								"_UI_ExtractSuperClassOperation_type"),
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME,
						true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Target Package feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTargetPackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ExtractSuperClassOperation_targetPackage_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_ExtractSuperClassOperation_targetPackage_feature",
								"_UI_ExtractSuperClassOperation_type"),
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE,
						true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Super Super Classes feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSuperSuperClassesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ExtractSuperClassOperation_superSuperClasses_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_ExtractSuperClassOperation_superSuperClasses_feature",
								"_UI_ExtractSuperClassOperation_type"),
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES,
						true, false, false, null, null, null));
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
					.add(OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES);
			childrenFeatures
					.add(OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES);
			childrenFeatures
					.add(OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS);
			childrenFeatures
					.add(OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS);
			childrenFeatures
					.add(OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE);
			childrenFeatures
					.add(OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES);
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
	 * {@inheritDoc} <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(
				object,
				getResourceLocator().getImage(
						"full/obj16/ExtractSuperClassOperation.png"));
	}

	/**
	 * {@inheritDoc} This returns the label text for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof ExtractSuperClassOperation) {
			ExtractSuperClassOperation operation = (ExtractSuperClassOperation) object;
			StringBuilder builder = new StringBuilder();
			builder.append("Extracted superclass \"");
			builder.append(operation.getSuperClassName());
			builder.append("\" from ");
			int subClassesSize = operation.getSubClasses().size();
			if (subClassesSize < 4) {
				builder.append("subclasses ");
				builder.append(getModelElementNames(operation.getSubClasses()));
			} else {
				builder.append("from ");
				builder.append(subClassesSize);
				builder.append(" subclasses.");
			}
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

		switch (notification.getFeatureID(ExtractSuperClassOperation.class)) {
		case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
		case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES:
		case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
		case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
		case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE:
		case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES:
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
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES,
						org.eclipse.emf.emfstore.internal.common.model.ModelFactory.eINSTANCE
								.createModelElementId()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES,
						org.eclipse.emf.emfstore.internal.common.model.ModelFactory.eINSTANCE
								.createModelElementId()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS,
						org.eclipse.emf.emfstore.internal.common.model.ModelFactory.eINSTANCE
								.createModelElementId()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS,
						org.eclipse.emf.emfstore.internal.common.model.ModelFactory.eINSTANCE
								.createModelElementId()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE,
						org.eclipse.emf.emfstore.internal.common.model.ModelFactory.eINSTANCE
								.createModelElementId()));

		newChildDescriptors
				.add(createChildParameter(
						OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES,
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

		boolean qualify = childFeature == OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES
				|| childFeature == OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES
				|| childFeature == OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS
				|| childFeature == OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS
				|| childFeature == OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE
				|| childFeature == OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES;

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
