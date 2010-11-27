/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure.impl;

import java.util.Collection;

import XMIWorkspaceStructure.XMIECPVirtualContainer;
import XMIWorkspaceStructure.XMIWorkspaceStructurePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.navigator.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP Virtual Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPVirtualContainerImpl#getXmiFilePath <em>Xmi File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMIECPVirtualContainerImpl extends XMIECPContainerImpl implements XMIECPVirtualContainer {
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
	protected XMIECPVirtualContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XMIWorkspaceStructurePackage.Literals.XMIECP_VIRTUAL_CONTAINER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XMIWorkspaceStructurePackage.XMIECP_VIRTUAL_CONTAINER__XMI_FILE_PATH, oldXmiFilePath, xmiFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XMIWorkspaceStructurePackage.XMIECP_VIRTUAL_CONTAINER__XMI_FILE_PATH:
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
			case XMIWorkspaceStructurePackage.XMIECP_VIRTUAL_CONTAINER__XMI_FILE_PATH:
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
			case XMIWorkspaceStructurePackage.XMIECP_VIRTUAL_CONTAINER__XMI_FILE_PATH:
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
			case XMIWorkspaceStructurePackage.XMIECP_VIRTUAL_CONTAINER__XMI_FILE_PATH:
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

} //XMIECPVirtualContainerImpl
