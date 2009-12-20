/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
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
import org.unicase.emfstore.esmodel.versioning.operations.ContainmentType;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationGroup;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.metamodel.ModelElement;

/**
 * This is the item provider adapter for a
 * {@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class CreateDeleteOperationItemProvider extends AbstractOperationItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CreateDeleteOperationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * @see org.unicase.emfstore.esmodel.versioning.operations.provider.AbstractOperationItemProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		if (object instanceof CreateDeleteOperation) {
			CreateDeleteOperation operation = (CreateDeleteOperation) object;
			ArrayList<Object> ret = new ArrayList<Object>();
			ret.add(operation.getModelElementId());
			List<ReferenceOperation> subOps = operation.getSubOperations();
			if (subOps.size() > 0) {
				OperationGroup operationGroup = OperationsFactory.eINSTANCE.createOperationGroup();
				if (operation.isDelete()) {
					operationGroup.setName("Deleted Cross-References");
				} else {
					operationGroup.setName("Created Cross-References");
				}
				operationGroup.getOperations().addAll(subOps);
				ret.add(operationGroup);
			}
			return ret;
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

			addDeletePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Delete feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDeletePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_CreateDeleteOperation_delete_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_CreateDeleteOperation_delete_feature",
				"_UI_CreateDeleteOperation_type"), OperationsPackage.Literals.CREATE_DELETE_OPERATION__DELETE, true,
			false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(OperationsPackage.Literals.CREATE_DELETE_OPERATION__MODEL_ELEMENT);
			childrenFeatures.add(OperationsPackage.Literals.CREATE_DELETE_OPERATION__SUB_OPERATIONS);
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
		CreateDeleteOperation op = (CreateDeleteOperation) object;
		Object image = null;
		if (op.isDelete()) {
			image = getResourceLocator().getImage("full/obj16/DeleteOperation.png");
		} else {
			image = getResourceLocator().getImage("full/obj16/CreateOperation.png");
		}
		return overlayImage(object, image);
	}

	// end of custom code

	/**
	 * {@inheritDoc} This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof CreateDeleteOperation) {
			CreateDeleteOperation op = (CreateDeleteOperation) object;
			ModelElement modelElement = op.getModelElement();
			int childrenCount = modelElement.getAllContainedModelElements().size();
			String description;

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(modelElement.eClass().getName());
			stringBuilder.append(getModelElementName(op.getModelElementId()));
			String elementClassAndName = stringBuilder.toString();
			if (op.isDelete()) {
				description = "Deleted " + elementClassAndName;
			} else {
				description = "Created " + elementClassAndName;
			}
			if (childrenCount > 0) {
				description += " including " + childrenCount + " sibling(s)";
			}

			EList<ReferenceOperation> subOperations = op.getSubOperations();
			int subOperationCount = subOperations.size();
			if (op.isDelete() && subOperationCount > 0) {
				ReferenceOperation referenceOperation = subOperations.get(subOperationCount - 1);
				if (referenceOperation.getContainmentType().equals(ContainmentType.CONTAINMENT)) {
					description += " from its parent "
						+ getModelElementClassAndName(referenceOperation.getModelElementId());
				}
			}
			return description;
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

		switch (notification.getFeatureID(CreateDeleteOperation.class)) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
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

		newChildDescriptors.add(createChildParameter(
			OperationsPackage.Literals.CREATE_DELETE_OPERATION__SUB_OPERATIONS, OperationsFactory.eINSTANCE
				.createSingleReferenceOperation()));

		newChildDescriptors.add(createChildParameter(
			OperationsPackage.Literals.CREATE_DELETE_OPERATION__SUB_OPERATIONS, OperationsFactory.eINSTANCE
				.createMultiReferenceOperation()));
	}

}
