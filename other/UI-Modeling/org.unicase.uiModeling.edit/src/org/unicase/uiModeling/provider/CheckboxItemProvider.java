/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.model.provider.UnicaseModelElementItemProvider;
import org.unicase.uiModeling.Checkbox;
import org.unicase.uiModeling.UiModelingPackage;

/**
 * This is the item provider adapter for a {@link org.unicase.uiModeling.Checkbox} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class CheckboxItemProvider extends UnicaseModelElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CheckboxItemProvider(AdapterFactory adapterFactory) {
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

			addTextPropertyDescriptor(object);
			addCheckedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Text feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_Checkbox_text_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_Checkbox_text_feature", "_UI_Checkbox_type"),
			UiModelingPackage.Literals.CHECKBOX__TEXT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
			null, null));
	}

	/**
	 * This adds a property descriptor for the Checked feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCheckedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_Checkbox_checked_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_Checkbox_checked_feature", "_UI_Checkbox_type"),
			UiModelingPackage.Literals.CHECKBOX__CHECKED, true, false, false,
			ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns an image for checkboxes, depending on whether they are selected or not.
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		if (object instanceof Checkbox) {
			Checkbox checkbox = (Checkbox) object;
			if (checkbox.isChecked()) {
				return overlayImage(object, getResourceLocator().getImage("full/obj16/CheckboxChecked"));
			}
		}
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Checkbox"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Checkbox) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Checkbox_type") : getString("_UI_Checkbox_type")
			+ " " + label;
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

		switch (notification.getFeatureID(Checkbox.class)) {
		case UiModelingPackage.CHECKBOX__TEXT:
		case UiModelingPackage.CHECKBOX__CHECKED:
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
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return UiModelingEditPlugin.INSTANCE;
	}

}
