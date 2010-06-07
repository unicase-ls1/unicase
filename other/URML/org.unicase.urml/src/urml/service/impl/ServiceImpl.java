/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.service.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import urml.danger.impl.MitigationImpl;

import urml.requirement.Requirement;
import urml.requirement.RequirementPackage;

import urml.service.Service;
import urml.service.ServicePackage;
import urml.service.ServiceProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.service.impl.ServiceImpl#getServiceProvider <em>Service Provider</em>}</li>
 *   <li>{@link urml.service.impl.ServiceImpl#getSatisfiedRequirements <em>Satisfied Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends MitigationImpl implements Service {
	/**
	 * The cached value of the '{@link #getSatisfiedRequirements() <em>Satisfied Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSatisfiedRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> satisfiedRequirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceProvider getServiceProvider() {
		if (eContainerFeatureID() != ServicePackage.SERVICE__SERVICE_PROVIDER)
			return null;
		return (ServiceProvider) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceProvider basicGetServiceProvider() {
		if (eContainerFeatureID() != ServicePackage.SERVICE__SERVICE_PROVIDER)
			return null;
		return (ServiceProvider) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceProvider(
			ServiceProvider newServiceProvider, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newServiceProvider,
				ServicePackage.SERVICE__SERVICE_PROVIDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceProvider(ServiceProvider newServiceProvider) {
		if (newServiceProvider != eInternalContainer()
				|| (eContainerFeatureID() != ServicePackage.SERVICE__SERVICE_PROVIDER && newServiceProvider != null)) {
			if (EcoreUtil.isAncestor(this, newServiceProvider))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newServiceProvider != null)
				msgs = ((InternalEObject) newServiceProvider).eInverseAdd(this,
						ServicePackage.SERVICE_PROVIDER__PROVIDED_SERVICES,
						ServiceProvider.class, msgs);
			msgs = basicSetServiceProvider(newServiceProvider, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServicePackage.SERVICE__SERVICE_PROVIDER,
					newServiceProvider, newServiceProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getSatisfiedRequirements() {
		if (satisfiedRequirements == null) {
			satisfiedRequirements = new EObjectWithInverseResolvingEList.ManyInverse<Requirement>(
					Requirement.class, this,
					ServicePackage.SERVICE__SATISFIED_REQUIREMENTS,
					RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES);
		}
		return satisfiedRequirements;
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
		case ServicePackage.SERVICE__SERVICE_PROVIDER:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetServiceProvider((ServiceProvider) otherEnd, msgs);
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSatisfiedRequirements())
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
		case ServicePackage.SERVICE__SERVICE_PROVIDER:
			return basicSetServiceProvider(null, msgs);
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			return ((InternalEList<?>) getSatisfiedRequirements()).basicRemove(
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
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ServicePackage.SERVICE__SERVICE_PROVIDER:
			return eInternalContainer().eInverseRemove(this,
					ServicePackage.SERVICE_PROVIDER__PROVIDED_SERVICES,
					ServiceProvider.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ServicePackage.SERVICE__SERVICE_PROVIDER:
			if (resolve)
				return getServiceProvider();
			return basicGetServiceProvider();
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			return getSatisfiedRequirements();
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
		case ServicePackage.SERVICE__SERVICE_PROVIDER:
			setServiceProvider((ServiceProvider) newValue);
			return;
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			getSatisfiedRequirements().clear();
			getSatisfiedRequirements().addAll(
					(Collection<? extends Requirement>) newValue);
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
		case ServicePackage.SERVICE__SERVICE_PROVIDER:
			setServiceProvider((ServiceProvider) null);
			return;
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			getSatisfiedRequirements().clear();
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
		case ServicePackage.SERVICE__SERVICE_PROVIDER:
			return basicGetServiceProvider() != null;
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			return satisfiedRequirements != null
					&& !satisfiedRequirements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServiceImpl
