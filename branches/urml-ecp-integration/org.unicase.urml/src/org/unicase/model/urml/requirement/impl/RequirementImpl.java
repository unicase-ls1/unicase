/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.urml.danger.impl.MitigationImpl;
import org.unicase.model.urml.requirement.Requirement;
import org.unicase.model.urml.requirement.RequirementPackage;
import org.unicase.model.urml.service.Service;
import org.unicase.model.urml.service.ServicePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.requirement.impl.RequirementImpl#getImplementingServices <em>Implementing Services</em>}</li>
 *   <li>{@link org.unicase.model.urml.requirement.impl.RequirementImpl#isTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RequirementImpl extends MitigationImpl implements
		Requirement {
	/**
	 * The cached value of the '{@link #getImplementingServices() <em>Implementing Services</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImplementingServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> implementingServices;

	/**
	 * The default value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isTerminal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TERMINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isTerminal()
	 * @generated
	 * @ordered
	 */
	protected boolean terminal = TERMINAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getImplementingServices() {
		if (implementingServices == null) {
			implementingServices = new EObjectWithInverseResolvingEList.ManyInverse<Service>(
					Service.class, this,
					RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES,
					ServicePackage.SERVICE__SATISFIED_REQUIREMENTS);
		}
		return implementingServices;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTerminal() {
		return terminal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTerminal(boolean newTerminal) {
		boolean oldTerminal = terminal;
		terminal = newTerminal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.REQUIREMENT__TERMINAL, oldTerminal,
					terminal));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getImplementingServices())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return ((InternalEList<?>) getImplementingServices()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return getImplementingServices();
		case RequirementPackage.REQUIREMENT__TERMINAL:
			return isTerminal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			getImplementingServices().clear();
			getImplementingServices().addAll(
					(Collection<? extends Service>) newValue);
			return;
		case RequirementPackage.REQUIREMENT__TERMINAL:
			setTerminal((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			getImplementingServices().clear();
			return;
		case RequirementPackage.REQUIREMENT__TERMINAL:
			setTerminal(TERMINAL_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return implementingServices != null
					&& !implementingServices.isEmpty();
		case RequirementPackage.REQUIREMENT__TERMINAL:
			return terminal != TERMINAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (terminal: ");
		result.append(terminal);
		result.append(')');
		return result.toString();
	}

} // RequirementImpl
