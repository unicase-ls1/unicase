/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.XMIWorkspaceStructure.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.navigator.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.XMIWorkspaceStructure.XMIECPFileProject;
import org.unicase.xmi.XMIWorkspaceStructure.XMIECPFolder;
import org.unicase.xmi.XMIWorkspaceStructure.XMIWorkspaceStructurePackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.navigator.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.xmi.XMIWorkspaceStructure.impl.XMIECPFolderImpl#getXmiDirectoryPath <em>Xmi Directory Path</em>}</li>
 *   <li>{@link org.unicase.xmi.XMIWorkspaceStructure.impl.XMIECPFolderImpl#getContainedFiles <em>Contained Files</em>}</li>
 *   <li>{@link org.unicase.xmi.XMIWorkspaceStructure.impl.XMIECPFolderImpl#getProjectResources <em>Project Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMIECPFolderImpl extends XMIECPContainerImpl implements XMIECPFolder {
	/**
	 * The default value of the '{@link #getXmiDirectoryPath() <em>Xmi Directory Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiDirectoryPath()
	 * @generated
	 * @ordered
	 */
	protected static final String XMI_DIRECTORY_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXmiDirectoryPath() <em>Xmi Directory Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiDirectoryPath()
	 * @generated
	 * @ordered
	 */
	protected String xmiDirectoryPath = XMI_DIRECTORY_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContainedFiles() <em>Contained Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<?> containedFiles;

	/**
	 * The cached value of the '{@link #getProjectResources() <em>Project Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectResources()
	 * @generated
	 * @ordered
	 */
	protected EList<XMIECPFileProject> projectResources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMIECPFolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXmiDirectoryPath() {
		return xmiDirectoryPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXmiDirectoryPath(String newXmiDirectoryPath) {
		String oldXmiDirectoryPath = xmiDirectoryPath;
		xmiDirectoryPath = newXmiDirectoryPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XMIWorkspaceStructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH, oldXmiDirectoryPath, xmiDirectoryPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> getContainedFiles() {
		return containedFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedFiles(EList<?> newContainedFiles) {
		EList<?> oldContainedFiles = containedFiles;
		containedFiles = newContainedFiles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XMIWorkspaceStructurePackage.XMIECP_FOLDER__CONTAINED_FILES, oldContainedFiles, containedFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XMIECPFileProject> getProjectResources() {
		if (projectResources == null) {
			projectResources = new EObjectResolvingEList<XMIECPFileProject>(XMIECPFileProject.class, this, XMIWorkspaceStructurePackage.XMIECP_FOLDER__PROJECT_RESOURCES);
		}
		return projectResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				return getXmiDirectoryPath();
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				return getContainedFiles();
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__PROJECT_RESOURCES:
				return getProjectResources();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				setXmiDirectoryPath((String)newValue);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				setContainedFiles((EList<?>)newValue);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__PROJECT_RESOURCES:
				getProjectResources().clear();
				getProjectResources().addAll((Collection<? extends XMIECPFileProject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				setXmiDirectoryPath(XMI_DIRECTORY_PATH_EDEFAULT);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				setContainedFiles((EList<?>)null);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__PROJECT_RESOURCES:
				getProjectResources().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				return XMI_DIRECTORY_PATH_EDEFAULT == null ? xmiDirectoryPath != null : !XMI_DIRECTORY_PATH_EDEFAULT.equals(xmiDirectoryPath);
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				return containedFiles != null;
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER__PROJECT_RESOURCES:
				return projectResources != null && !projectResources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (xmiDirectoryPath: ");
		result.append(xmiDirectoryPath);
		result.append(", containedFiles: ");
		result.append(containedFiles);
		result.append(')');
		return result.toString();
	}

	public void addECPProjectListener(ECPProjectListener listener) {
		// TODO Auto-generated method stub
		
	}

	public boolean contains(EObject eObject) {
		// TODO Auto-generated method stub
		return false;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public Collection<EObject> getAllModelElement() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, BasicEList<EObject> basicEList) {
		// TODO Auto-generated method stub
		return null;
	}

	public EObject getRootObject() {
		// TODO Auto-generated method stub
		return null;
	}

	public ECPWorkspace getWorkspace() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isNonDomainElement(EObject eObject) {
		// TODO Auto-generated method stub
		return false;
	}

	public void modelelementDeleted(EObject eobject) {
		// TODO Auto-generated method stub
		
	}

	public void projectChanged() {
		// TODO Auto-generated method stub
		
	}

	public void projectDeleted() {
		// TODO Auto-generated method stub
		
	}

	public void removeECPProjectListener(ECPProjectListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void setRootObject(EObject value) {
		// TODO Auto-generated method stub
		
	}

	public void setWorkspace(ECPWorkspace value) {
		// TODO Auto-generated method stub
		
	}

	public Collection<EObject> getAllModelElements() {
		// TODO Auto-generated method stub
		return null;
	}

	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		// TODO Auto-generated method stub
		return null;
	}

	public EditingDomain getEditingDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	public MetaModelElementContext getMetaModelElementContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAssociationClassElement(EObject eObject) {
		// TODO Auto-generated method stub
		return false;
	}

} //XMIECPFolderImpl
