/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import urml.danger.impl.MitigationImpl;

import urml.requirement.Requirement;
import urml.requirement.RequirementPackage;

import urml.service.Service;
import urml.service.ServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.requirement.impl.RequirementImpl#getImplementingServices <em>Implementing Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RequirementImpl extends MitigationImpl implements Requirement {
	/**
	 * The cached value of the '{@link #getImplementingServices() <em>Implementing Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementingServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> implementingServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getImplementingServices() {
		if (implementingServices == null) {
			implementingServices = new EObjectWithInverseResolvingEList.ManyInverse<Service>(Service.class, this,
				RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES, ServicePackage.SERVICE__SATISFIED_REQUIREMENTS);
		}
		return implementingServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getImplementingServices()).basicAdd(otherEnd,
				msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return ((InternalEList<?>) getImplementingServices()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return getImplementingServices();
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
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			getImplementingServices().clear();
			getImplementingServices().addAll((Collection<? extends Service>) newValue);
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
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			getImplementingServices().clear();
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
		case RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES:
			return implementingServices != null && !implementingServices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RequirementImpl
