/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.provider;

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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.ProjectInfo;

/**
 * This is the item provider adapter for a {@link org.unicase.emfstore.esmodel.ProjectInfo} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ProjectInfoItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectInfoItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addProjectIdPropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_ProjectInfo_name_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectInfo_name_feature", "_UI_ProjectInfo_type"),
			EsmodelPackage.Literals.PROJECT_INFO__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
			null, null));
	}

	/**
	 * This adds a property descriptor for the Description feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_ProjectInfo_description_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectInfo_description_feature",
				"_UI_ProjectInfo_type"), EsmodelPackage.Literals.PROJECT_INFO__DESCRIPTION, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Project Id feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProjectIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors
			.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ProjectInfo_projectId_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ProjectInfo_projectId_feature",
					"_UI_ProjectInfo_type"), EsmodelPackage.Literals.PROJECT_INFO__PROJECT_ID, true, false, true, null,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Version feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_ProjectInfo_version_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_ProjectInfo_version_feature", "_UI_ProjectInfo_type"),
			EsmodelPackage.Literals.PROJECT_INFO__VERSION, true, false, true, null, null, null));
	}

	/**
	 * This returns ProjectInfo.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ProjectInfo"));
	}

	// begin of custom code
	/**
	 * This returns the label text for the adapted class.
	 * 
	 * @param object the object the label is based upon.
	 * @return the label for the object
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		ProjectInfo projectInfo = ((ProjectInfo) object);
		String ret = "";
		if (projectInfo.getName() == null || projectInfo.getName().length() == 0) {
			ret = getString("_UI_ProjectInfo_type");
		} else {
			ret = projectInfo.getName() + "[Revision: " + ((ProjectInfo) object).getVersion().getIdentifier() + "]";
		}
		return ret;
	}

	// end of custom code

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

		switch (notification.getFeatureID(ProjectInfo.class)) {
		case EsmodelPackage.PROJECT_INFO__NAME:
		case EsmodelPackage.PROJECT_INFO__DESCRIPTION:
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
		return EsmodelEditPlugin.INSTANCE;
	}

}
