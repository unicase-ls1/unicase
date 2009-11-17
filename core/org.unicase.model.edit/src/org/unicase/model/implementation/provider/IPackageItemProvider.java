/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.provider;

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
import org.unicase.model.implementation.IPackage;
import org.unicase.model.implementation.ImplementationFactory;
import org.unicase.model.implementation.ImplementationPackage;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.provider.UnicaseModelElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.unicase.model.implementation.IPackage} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class IPackageItemProvider extends UnicaseModelElementItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IPackageItemProvider(AdapterFactory adapterFactory) {
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

			addNamespacePropertyDescriptor(object);
			addParentPackagePropertyDescriptor(object);
			addSubPackagesPropertyDescriptor(object);
			addClassesPropertyDescriptor(object);
			addEnumerationsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Namespace feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamespacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_IPackage_namespace_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_IPackage_namespace_feature", "_UI_IPackage_type"),
			ImplementationPackage.Literals.IPACKAGE__NAMESPACE, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Parent Package feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addParentPackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_IPackage_parentPackage_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_IPackage_parentPackage_feature", "_UI_IPackage_type"),
			ImplementationPackage.Literals.IPACKAGE__PARENT_PACKAGE, true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Sub Packages feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSubPackagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_IPackage_subPackages_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_IPackage_subPackages_feature", "_UI_IPackage_type"),
			ImplementationPackage.Literals.IPACKAGE__SUB_PACKAGES, true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Classes feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addClassesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_IPackage_classes_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_IPackage_classes_feature", "_UI_IPackage_type"),
			ImplementationPackage.Literals.IPACKAGE__CLASSES, true, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Enumerations feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addEnumerationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_IPackage_enumerations_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_IPackage_enumerations_feature", "_UI_IPackage_type"),
			ImplementationPackage.Literals.IPACKAGE__ENUMERATIONS, true, false, false, null, null, null));
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
			childrenFeatures.add(ImplementationPackage.Literals.IPACKAGE__SUB_PACKAGES);
			childrenFeatures.add(ImplementationPackage.Literals.IPACKAGE__CLASSES);
			childrenFeatures.add(ImplementationPackage.Literals.IPACKAGE__ENUMERATIONS);
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

	/**
	 * This returns IPackage.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IPackage"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IPackage) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_IPackage_type") : getString("_UI_IPackage_type")
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

		switch (notification.getFeatureID(IPackage.class)) {
		case ImplementationPackage.IPACKAGE__NAMESPACE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ImplementationPackage.IPACKAGE__SUB_PACKAGES:
		case ImplementationPackage.IPACKAGE__CLASSES:
		case ImplementationPackage.IPACKAGE__ENUMERATIONS:
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

		newChildDescriptors.add(createChildParameter(ImplementationPackage.Literals.IPACKAGE__SUB_PACKAGES,
			ImplementationFactory.eINSTANCE.createIPackage()));

		newChildDescriptors.add(createChildParameter(ImplementationPackage.Literals.IPACKAGE__CLASSES,
			ImplementationFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add(createChildParameter(ImplementationPackage.Literals.IPACKAGE__ENUMERATIONS,
			ImplementationFactory.eINSTANCE.createIEnumeration()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ModelEditPlugin.INSTANCE;
	}

}
