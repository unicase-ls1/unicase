/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure.impl;

import XMIWorkspaceStructure.XMIECPFileProject;
import XMIWorkspaceStructure.XMIWorkspaceStructurePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP File Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPFileProjectImpl#getXmiFilePath <em>Xmi File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMIECPFileProjectImpl extends EObjectImpl implements XMIECPFileProject {
	/**
	 * The default value of the '{@link #getXmiFilePath() <em>Xmi File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String XMI_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXmiFilePath() <em>Xmi File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiFilePath()
	 * @generated
	 * @ordered
	 */
	protected String xmiFilePath = XMI_FILE_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMIECPFileProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XMIWorkspaceStructurePackage.Literals.XMIECP_FILE_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXmiFilePath() {
		return xmiFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXmiFilePath(String newXmiFilePath) {
		String oldXmiFilePath = xmiFilePath;
		xmiFilePath = newXmiFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH, oldXmiFilePath, xmiFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
				return getXmiFilePath();
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
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
				setXmiFilePath((String)newValue);
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
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
				setXmiFilePath(XMI_FILE_PATH_EDEFAULT);
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
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
				return XMI_FILE_PATH_EDEFAULT == null ? xmiFilePath != null : !XMI_FILE_PATH_EDEFAULT.equals(xmiFilePath);
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
		result.append(" (xmiFilePath: ");
		result.append(xmiFilePath);
		result.append(')');
		return result.toString();
	}

} //XMIECPFileProjectImpl
