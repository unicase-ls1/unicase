/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.xmiworkspacestructure.provider;


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

import org.unicase.ecp.model.workSpaceModel.provider.ECPProjectItemProvider;
import org.unicase.xmi.workspace.XmiUtil.PROJECT_STATUS;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage;

/**
 * This is the item provider adapter for a {@link org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class XMIECPFileProjectItemProvider
	extends ECPProjectItemProvider
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
	public XMIECPFileProjectItemProvider(AdapterFactory adapterFactory) {
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

			addProjectNamePropertyDescriptor(object);
			addProjectDescriptionPropertyDescriptor(object);
			addXmiFilePathPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	
	/**
	 * not needed in this implementation
	 */
	@Override
	protected void addRootObjectPropertyDescriptor(Object object) {
		//do nothing
	}

	/**
	 * This adds a property descriptor for the Project Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProjectNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_XMIECPProject_projectName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_XMIECPProject_projectName_feature", "_UI_XMIECPProject_type"),
				 XmiworkspacestructurePackage.Literals.XMIECP_PROJECT__PROJECT_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Project Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProjectDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_XMIECPProject_projectDescription_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_XMIECPProject_projectDescription_feature", "_UI_XMIECPProject_type"),
				 XmiworkspacestructurePackage.Literals.XMIECP_PROJECT__PROJECT_DESCRIPTION,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Xmi File Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addXmiFilePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_XMIECPFileProject_xmiFilePath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_XMIECPFileProject_xmiFilePath_feature", "_UI_XMIECPFileProject_type"),
				 XmiworkspacestructurePackage.Literals.XMIECP_FILE_PROJECT__XMI_FILE_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns XMIECPFileProject.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public Object getImage(Object object) {
		if(object instanceof XMIECPFileProject) {
			XMIECPFileProject pro = (XMIECPFileProject) object;
			
			if(pro.getProjectStatus() == PROJECT_STATUS.FAILED || pro.getProjectStatus() == PROJECT_STATUS.DUPLICATED) {
				return overlayImage(object, getResourceLocator().getImage("full/obj16/projectFailed.png"));
			}
		}
		return overlayImage(object, getResourceLocator().getImage("full/obj16/project.png"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private String getTextGen(Object object) {
		String label = ((XMIECPFileProject)object).getProjectName();
		return label == null || label.length() == 0 ?
			getString("_UI_XMIECPFileProject_type") :
			getString("_UI_XMIECPFileProject_type") + " " + label;
	}
	
	/**
	 * {@inheritDoc}
	 * @generated not
	 */
	@Override
	public String getText(Object object) {
		String label = getTextGen(object);
		PROJECT_STATUS projectStatus = ((XMIECPFileProject)object).getProjectStatus();
		if(projectStatus == PROJECT_STATUS.FAILED) {
			return "[" + label + "]";
		}
		
		if(projectStatus == PROJECT_STATUS.DUPLICATED) {
			return label + " [DUPLICATED]";
		}
		
		return label;
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

		switch (notification.getFeatureID(XMIECPFileProject.class)) {
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME:
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION:
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return XMIWorkspaceEditPlugin.INSTANCE;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		
		if(object instanceof XMIECPFileProject) {
			XMIECPFileProject project = (XMIECPFileProject) object;
			return project.getRootLevel();
		}
		
		return super.getChildren(object);
	}

}
