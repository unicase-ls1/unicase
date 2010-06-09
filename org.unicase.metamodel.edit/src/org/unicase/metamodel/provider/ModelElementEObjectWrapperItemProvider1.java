/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the item provider adapter for a {@link org.unicase.metamodel.ModelElementEObjectWrapper} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ModelElementEObjectWrapperItemProvider1 extends IdentifiableElementItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {

	public ModelElementEObjectWrapperItemProvider1(AdapterFactory adapterFactory) {
		super(adapterFactory);
		// TODO Auto-generated constructor stub
	}
	// /**
	// * This constructs an instance from a factory and a notifier.
	// * <!-- begin-user-doc --> <!-- end-user-doc -->
	// * @generated
	// */
	// public ModelElementEObjectWrapperItemProvider(AdapterFactory adapterFactory) {
	// super(adapterFactory);
	// }
	//
	// /**
	// * This returns the property descriptors for the adapted class.
	// * <!-- begin-user-doc --> <!-- end-user-doc -->
	// * @generated
	// */
	// @Override
	// public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
	// if (itemPropertyDescriptors == null) {
	// super.getPropertyDescriptors(object);
	//
	// addWrappedEObjectPropertyDescriptor(object);
	// }
	// return itemPropertyDescriptors;
	// }
	//
	// /**
	// * This adds a property descriptor for the Wrapped EObject feature.
	// * <!-- begin-user-doc --> <!-- end-user-doc -->
	// * @generated
	// */
	// protected void addWrappedEObjectPropertyDescriptor(Object object) {
	// itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
	// .getRootAdapterFactory(), getResourceLocator(),
	// getString("_UI_ModelElementEObjectWrapper_wrappedEObject_feature"), getString(
	// "_UI_PropertyDescriptor_description", "_UI_ModelElementEObjectWrapper_wrappedEObject_feature",
	// "_UI_ModelElementEObjectWrapper_type"),
	// MetamodelPackage.Literals.MODEL_ELEMENT_EOBJECT_WRAPPER__WRAPPED_EOBJECT, true, false, true, null, null,
	// null));
	// }
	//
	// /**
	// * This returns ModelElementEObjectWrapper.gif.
	// * <!-- begin-user-doc --> <!-- end-user-doc -->
	// * @generated
	// */
	// @Override
	// public Object getImage(Object object) {
	// return overlayImage(object, getResourceLocator().getImage("full/obj16/ModelElementEObjectWrapper"));
	// }
	//
	// /**
	// * This returns the label text for the adapted class.
	// * <!-- begin-user-doc --> <!-- end-user-doc -->
	// * @generated
	// */
	// @Override
	// public String getText(Object object) {
	// String label = ((ModelElementEObjectWrapper) object).getIdentifier();
	// return label == null || label.length() == 0 ? getString("_UI_ModelElementEObjectWrapper_type")
	// : getString("_UI_ModelElementEObjectWrapper_type") + " " + label;
	// }
	//
	// /**
	// * This handles model notifications by calling {@link #updateChildren} to update any cached children and by
	// creating
	// * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	// * -->
	// *
	// * @generated
	// */
	// @Override
	// public void notifyChanged(Notification notification) {
	// updateChildren(notification);
	// super.notifyChanged(notification);
	// }
	//
	// /**
	// * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	// * that can be created under this object.
	// * <!-- begin-user-doc --> <!-- end-user-doc -->
	// * @generated
	// */
	// @Override
	// protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
	// super.collectNewChildDescriptors(newChildDescriptors, object);
	// }

}
