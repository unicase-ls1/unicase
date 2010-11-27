/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure.impl;

import XMIWorkspaceStructure.XMIECPContainer;
import XMIWorkspaceStructure.XMIWorkspaceStructurePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPContainerImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPContainerImpl#getEditingDomain <em>Editing Domain</em>}</li>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPContainerImpl#getInternalProjects <em>Internal Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class XMIECPContainerImpl extends EObjectImpl implements XMIECPContainer {
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
	 * The cached value of the '{@link #getInternalProjects() <em>Internal Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<?> internalProjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMIECPContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XMIWorkspaceStructurePackage.Literals.XMIECP_CONTAINER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XMIWorkspaceStructurePackage.XMIECP_CONTAINER__ELEMENTS, oldElements, elements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditingDomain() {
		return editingDomain;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XMIWorkspaceStructurePackage.XMIECP_CONTAINER__EDITING_DOMAIN, oldEditingDomain, editingDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> getInternalProjects() {
		return internalProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalProjects(EList<?> newInternalProjects) {
		EList<?> oldInternalProjects = internalProjects;
		internalProjects = newInternalProjects;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS, oldInternalProjects, internalProjects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> getContainedProjects() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__ELEMENTS:
				return getElements();
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__EDITING_DOMAIN:
				return getEditingDomain();
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS:
				return getInternalProjects();
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
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__ELEMENTS:
				setElements((EList<?>)newValue);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__EDITING_DOMAIN:
				setEditingDomain((String)newValue);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS:
				setInternalProjects((EList<?>)newValue);
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
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__ELEMENTS:
				setElements((EList<?>)null);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__EDITING_DOMAIN:
				setEditingDomain(EDITING_DOMAIN_EDEFAULT);
				return;
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS:
				setInternalProjects((EList<?>)null);
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
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__ELEMENTS:
				return elements != null;
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__EDITING_DOMAIN:
				return EDITING_DOMAIN_EDEFAULT == null ? editingDomain != null : !EDITING_DOMAIN_EDEFAULT.equals(editingDomain);
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS:
				return internalProjects != null;
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
		result.append(", internalProjects: ");
		result.append(internalProjects);
		result.append(')');
		return result.toString();
	}

} //XMIECPContainerImpl
