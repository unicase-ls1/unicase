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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.uiModeling.UiModelingFactory;
import org.unicase.uiModeling.UiModelingPackage;
import org.unicase.uiModeling.Window;

/**
 * This is the item provider adapter for a {@link org.unicase.uiModeling.Window} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WindowItemProvider
	extends WidgetItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(UiModelingPackage.Literals.WINDOW__WIDGETS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Window.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Window"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Window)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Window_type") :
			getString("_UI_Window_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Window.class)) {
			case UiModelingPackage.WINDOW__WIDGETS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createWindow()));

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createLabel()));

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createTextField()));

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createButton()));

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createText()));

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createImage()));

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createRadioGroup()));

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createCheckboxGroup()));

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createDropdownList()));

		newChildDescriptors.add
			(createChildParameter
				(UiModelingPackage.Literals.WINDOW__WIDGETS,
				 UiModelingFactory.eINSTANCE.createImageButton()));
	}

}
