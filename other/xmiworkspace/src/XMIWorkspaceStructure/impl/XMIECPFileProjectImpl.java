/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure.impl;

import java.util.Collection;

import XMIWorkspaceStructure.XMIECPFileProject;
import XMIWorkspaceStructure.XMIWorkspaceStructurePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.navigator.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP File Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPFileProjectImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPFileProjectImpl#getEditingDomain <em>Editing Domain</em>}</li>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPFileProjectImpl#getXmiFilePath <em>Xmi File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMIECPFileProjectImpl extends EObjectImpl implements XMIECPFileProject {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<?> elements;

	/**
	 * The default value of the '{@link #getEditingDomain() <em>Editing Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditingDomain()
	 * @generated
	 * @ordered
	 */
	protected static final String EDITING_DOMAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditingDomain() <em>Editing Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditingDomain()
	 * @generated
	 * @ordered
	 */
	protected String editingDomain = EDITING_DOMAIN_EDEFAULT;

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
	public EList<?> getElements() {
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElements(EList<?> newElements) {
		EList<?> oldElements = elements;
		elements = newElements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__ELEMENTS, oldElements, elements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditingDomain(String newEditingDomain) {
		String oldEditingDomain = editingDomain;
		editingDomain = newEditingDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__EDITING_DOMAIN, oldEditingDomain, editingDomain));
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
	public EList<?> getAllElements() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__ELEMENTS:
				return getElements();
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__EDITING_DOMAIN:
				return getEditingDomain();
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
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__ELEMENTS:
				setElements((EList<?>)newValue);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__EDITING_DOMAIN:
				setEditingDomain((String)newValue);
				return;
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
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__ELEMENTS:
				setElements((EList<?>)null);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__EDITING_DOMAIN:
				setEditingDomain(EDITING_DOMAIN_EDEFAULT);
				return;
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
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__ELEMENTS:
				return elements != null;
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT__EDITING_DOMAIN:
				return EDITING_DOMAIN_EDEFAULT == null ? editingDomain != null : !EDITING_DOMAIN_EDEFAULT.equals(editingDomain);
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
		result.append(" (elements: ");
		result.append(elements);
		result.append(", editingDomain: ");
		result.append(editingDomain);
		result.append(", xmiFilePath: ");
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

} //XMIECPFileProjectImpl
