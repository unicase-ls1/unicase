/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.xmi.xmiworkspacestructure.XMIECPFolder;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFolderImpl#getXmiDirectoryPath <em>Xmi Directory Path</em>}</li>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFolderImpl#getContainedFiles <em>Contained Files</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMIECPFolderImpl extends XMIECPProjectContainerImpl implements XMIECPFolder {
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
	@Override
	protected EClass eStaticClass() {
		return XmiworkspacestructurePackage.Literals.XMIECP_FOLDER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH, oldXmiDirectoryPath, xmiDirectoryPath));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES, oldContainedFiles, containedFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				return getXmiDirectoryPath();
			case XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				return getContainedFiles();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				setXmiDirectoryPath((String)newValue);
				return;
			case XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				setContainedFiles((EList<?>)newValue);
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
			case XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				setXmiDirectoryPath(XMI_DIRECTORY_PATH_EDEFAULT);
				return;
			case XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				setContainedFiles((EList<?>)null);
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
			case XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				return XMI_DIRECTORY_PATH_EDEFAULT == null ? xmiDirectoryPath != null : !XMI_DIRECTORY_PATH_EDEFAULT.equals(xmiDirectoryPath);
			case XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				return containedFiles != null;
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

} //XMIECPFolderImpl
