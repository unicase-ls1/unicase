/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.operations.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
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
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationGroup;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.metamodel.util.ModelUtil;

/**
 * This is the item provider adapter for a {@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class CompositeOperationItemProvider extends AbstractOperationItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompositeOperationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.provider.AbstractOperationItemProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		if (object instanceof CompositeOperation) {
			CompositeOperation cop = (CompositeOperation) object;
			ArrayList<Object> ret = new ArrayList<Object>();
			if (cop.getMainOperation() != null) {
				ret.addAll(super.getChildren(cop.getMainOperation()));
				List<AbstractOperation> subOps = ModelUtil.flatCloneList(cop.getSubOperations());
				if (subOps.size() > 0) {
					subOps.remove(cop.getMainOperation());
					OperationGroup operationGroup = OperationsFactory.eINSTANCE.createOperationGroup();
					operationGroup.setName("Additional Details");
					operationGroup.getOperations().addAll(subOps);
					ret.add(operationGroup);
				}
				return ret;
			} else {
				return cop.getSubOperations();
			}
		}
		return super.getChildren(object);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addMainOperationPropertyDescriptor(object);
			addCompositeNamePropertyDescriptor(object);
			addCompositeDescriptionPropertyDescriptor(object);
			addReversedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Main Operation feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMainOperationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_CompositeOperation_mainOperation_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_CompositeOperation_mainOperation_feature",
				"_UI_CompositeOperation_type"), OperationsPackage.Literals.COMPOSITE_OPERATION__MAIN_OPERATION, true,
			false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Composite Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCompositeNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_CompositeOperation_compositeName_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_CompositeOperation_compositeName_feature",
				"_UI_CompositeOperation_type"), OperationsPackage.Literals.COMPOSITE_OPERATION__COMPOSITE_NAME, true,
			false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Composite Description feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addCompositeDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_CompositeOperation_compositeDescription_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_CompositeOperation_compositeDescription_feature",
				"_UI_CompositeOperation_type"), OperationsPackage.Literals.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION,
			true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Reversed feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addReversedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_CompositeOperation_reversed_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_CompositeOperation_reversed_feature",
				"_UI_CompositeOperation_type"), OperationsPackage.Literals.COMPOSITE_OPERATION__REVERSED, true, false,
			false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS);
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
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	// begin of custom code
	/**
	 * @param object the object
	 * @return This returns the image.
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CompositeOperation.png"));
	}

	// end of custom code

	/**
	 * {@inheritDoc} This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof CompositeOperation) {
			CompositeOperation compositeOperation = (CompositeOperation) object;
			return compositeOperation.getDescription();
		}
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

		switch (notification.getFeatureID(CompositeOperation.class)) {
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME:
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION:
		case OperationsPackage.COMPOSITE_OPERATION__REVERSED:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case OperationsPackage.COMPOSITE_OPERATION__SUB_OPERATIONS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createCompositeOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createCreateDeleteOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createAttributeOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createMultiAttributeOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createMultiAttributeSetOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createMultiAttributeMoveOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createSingleReferenceOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createMultiReferenceSetOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createMultiReferenceOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createMultiReferenceMoveOperation()));

		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.COMPOSITE_OPERATION__SUB_OPERATIONS,
			OperationsFactory.eINSTANCE.createDiagramLayoutOperation()));
	}

}
