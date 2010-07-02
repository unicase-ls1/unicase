/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
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
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;

/**
 * This is the item provider adapter for a {@link org.unicase.metamodel.ModelElement} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ModelElementItemProvider extends IdentifiableElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
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

			addCreatorPropertyDescriptor(object);
			addCreationDatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Creator feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCreatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_ModelElement_creator_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_ModelElement_creator_feature", "_UI_ModelElement_type"),
			MetamodelPackage.Literals.MODEL_ELEMENT__CREATOR, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Creation Date feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCreationDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_ModelElement_creationDate_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ModelElement_creationDate_feature",
				"_UI_ModelElement_type"), MetamodelPackage.Literals.MODEL_ELEMENT__CREATION_DATE, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ModelElement) object).getIdentifier();
		return label == null || label.length() == 0 ? getString("_UI_ModelElement_type")
			: getString("_UI_ModelElement_type") + " " + label;
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

		switch (notification.getFeatureID(ModelElement.class)) {
		case MetamodelPackage.MODEL_ELEMENT__CREATOR:
		case MetamodelPackage.MODEL_ELEMENT__CREATION_DATE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * @return the ImageDescriptor for this class.
	 * @generated NOT {@inheritDoc}
	 */
	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/ModelElement");
	}

	/**
	 * {@inheritDoc} <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	protected boolean isWrappingNeeded(Object object) {

		wrappingNeeded = super.isWrappingNeeded(object);
		for (EStructuralFeature f : getChildrenFeatures(object)) {
			if (f instanceof EReference && !(((EReference) f).isContainment())) {
				wrappingNeeded = Boolean.TRUE;
				break;
			}
		}

		return wrappingNeeded;
	}
}
