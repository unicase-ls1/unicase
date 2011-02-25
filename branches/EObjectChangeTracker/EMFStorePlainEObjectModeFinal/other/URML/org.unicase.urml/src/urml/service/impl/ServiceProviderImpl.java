/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.service.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import urml.danger.impl.AssetImpl;

import urml.service.Service;
import urml.service.ServicePackage;
import urml.service.ServiceProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.service.impl.ServiceProviderImpl#getProvidedServices <em>Provided Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceProviderImpl extends AssetImpl implements ServiceProvider {
	/**
	 * The cached value of the '{@link #getProvidedServices() <em>Provided Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> providedServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.SERVICE_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getProvidedServices() {
		if (providedServices == null) {
			providedServices = new EObjectContainmentWithInverseEList.Resolving<Service>(
					Service.class, this,
					ServicePackage.SERVICE_PROVIDER__PROVIDED_SERVICES,
					ServicePackage.SERVICE__SERVICE_PROVIDER);
		}
		return providedServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ServicePackage.SERVICE_PROVIDER__PROVIDED_SERVICES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getProvidedServices())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ServicePackage.SERVICE_PROVIDER__PROVIDED_SERVICES:
			return ((InternalEList<?>) getProvidedServices()).basicRemove(
					otherEnd, msgs);
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
		case ServicePackage.SERVICE_PROVIDER__PROVIDED_SERVICES:
			return getProvidedServices();
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
		case ServicePackage.SERVICE_PROVIDER__PROVIDED_SERVICES:
			getProvidedServices().clear();
			getProvidedServices().addAll(
					(Collection<? extends Service>) newValue);
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
		case ServicePackage.SERVICE_PROVIDER__PROVIDED_SERVICES:
			getProvidedServices().clear();
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
		case ServicePackage.SERVICE_PROVIDER__PROVIDED_SERVICES:
			return providedServices != null && !providedServices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServiceProviderImpl
