/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure.impl;

import XMIWorkspaceStructure.XMIECPFileProject;
import XMIWorkspaceStructure.XMIECPFolder;
import XMIWorkspaceStructure.XMIWorkspaceStructurePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPFolderImpl#getXmiDirectoryPath <em>Xmi Directory Path</em>}</li>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPFolderImpl#getContainedFiles <em>Contained Files</em>}</li>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPFolderImpl#getProjectResources <em>Project Resources</em>}</li>
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
	@Override
	protected EClass eStaticClass() {
		return XMIWorkspaceStructurePackage.Literals.XMIECP_FOLDER;
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

} //XMIECPFolderImpl
