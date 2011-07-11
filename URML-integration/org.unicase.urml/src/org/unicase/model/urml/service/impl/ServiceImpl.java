/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.service.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.urml.danger.impl.AssetImpl;
import org.unicase.model.urml.requirement.Requirement;
import org.unicase.model.urml.requirement.RequirementPackage;
import org.unicase.model.urml.service.Service;
import org.unicase.model.urml.service.ServicePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Service</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.urml.service.impl.ServiceImpl#getSatisfiedRequirements <em>Satisfied Requirements</em>}</li>
 * <li>{@link org.unicase.model.urml.service.impl.ServiceImpl#getParentService <em>Parent Service</em>}</li>
 * <li>{@link org.unicase.model.urml.service.impl.ServiceImpl#getSubServices <em>Sub Services</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ServiceImpl extends AssetImpl implements Service {
	/**
	 * The cached value of the '{@link #getSatisfiedRequirements() <em>Satisfied Requirements</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSatisfiedRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> satisfiedRequirements;

	/**
	 * The cached value of the '{@link #getSubServices() <em>Sub Services</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> subServices;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Requirement> getSatisfiedRequirements() {
		if (satisfiedRequirements == null) {
			satisfiedRequirements = new EObjectWithInverseResolvingEList.ManyInverse<Requirement>(Requirement.class,
				this, ServicePackage.SERVICE__SATISFIED_REQUIREMENTS,
				RequirementPackage.REQUIREMENT__IMPLEMENTING_SERVICES);
		}
		return satisfiedRequirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Service getParentService() {
		if (eContainerFeatureID() != ServicePackage.SERVICE__PARENT_SERVICE)
			return null;
		return (Service) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Service basicGetParentService() {
		if (eContainerFeatureID() != ServicePackage.SERVICE__PARENT_SERVICE)
			return null;
		return (Service) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParentService(Service newParentService, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentService, ServicePackage.SERVICE__PARENT_SERVICE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentService(Service newParentService) {
		if (newParentService != eInternalContainer()
			|| (eContainerFeatureID() != ServicePackage.SERVICE__PARENT_SERVICE && newParentService != null)) {
			if (EcoreUtil.isAncestor(this, newParentService))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentService != null)
				msgs = ((InternalEObject) newParentService).eInverseAdd(this, ServicePackage.SERVICE__SUB_SERVICES,
					Service.class, msgs);
			msgs = basicSetParentService(newParentService, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.SERVICE__PARENT_SERVICE,
				newParentService, newParentService));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Service> getSubServices() {
		if (subServices == null) {
			subServices = new EObjectContainmentWithInverseEList.Resolving<Service>(Service.class, this,
				ServicePackage.SERVICE__SUB_SERVICES, ServicePackage.SERVICE__PARENT_SERVICE);
		}
		return subServices;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSatisfiedRequirements()).basicAdd(otherEnd,
				msgs);
		case ServicePackage.SERVICE__PARENT_SERVICE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentService((Service) otherEnd, msgs);
		case ServicePackage.SERVICE__SUB_SERVICES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubServices()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			return ((InternalEList<?>) getSatisfiedRequirements()).basicRemove(otherEnd, msgs);
		case ServicePackage.SERVICE__PARENT_SERVICE:
			return basicSetParentService(null, msgs);
		case ServicePackage.SERVICE__SUB_SERVICES:
			return ((InternalEList<?>) getSubServices()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ServicePackage.SERVICE__PARENT_SERVICE:
			return eInternalContainer().eInverseRemove(this, ServicePackage.SERVICE__SUB_SERVICES, Service.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			return getSatisfiedRequirements();
		case ServicePackage.SERVICE__PARENT_SERVICE:
			if (resolve)
				return getParentService();
			return basicGetParentService();
		case ServicePackage.SERVICE__SUB_SERVICES:
			return getSubServices();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			getSatisfiedRequirements().clear();
			getSatisfiedRequirements().addAll((Collection<? extends Requirement>) newValue);
			return;
		case ServicePackage.SERVICE__PARENT_SERVICE:
			setParentService((Service) newValue);
			return;
		case ServicePackage.SERVICE__SUB_SERVICES:
			getSubServices().clear();
			getSubServices().addAll((Collection<? extends Service>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			getSatisfiedRequirements().clear();
			return;
		case ServicePackage.SERVICE__PARENT_SERVICE:
			setParentService((Service) null);
			return;
		case ServicePackage.SERVICE__SUB_SERVICES:
			getSubServices().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ServicePackage.SERVICE__SATISFIED_REQUIREMENTS:
			return satisfiedRequirements != null && !satisfiedRequirements.isEmpty();
		case ServicePackage.SERVICE__PARENT_SERVICE:
			return basicGetParentService() != null;
		case ServicePackage.SERVICE__SUB_SERVICES:
			return subServices != null && !subServices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ServiceImpl
