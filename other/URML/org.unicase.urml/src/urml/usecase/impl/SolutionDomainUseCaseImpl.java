/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.usecase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.model.urml.Feature;
import org.unicase.model.urml.UrmlPackage;

import urml.usecase.SolutionDomainUseCase;
import urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution Domain Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.usecase.impl.SolutionDomainUseCaseImpl#getDetailedFeature <em>Detailed Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SolutionDomainUseCaseImpl extends UseCaseImpl implements
		SolutionDomainUseCase {
	/**
	 * The cached value of the '{@link #getDetailedFeature() <em>Detailed Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailedFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature detailedFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionDomainUseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.SOLUTION_DOMAIN_USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getDetailedFeature() {
		if (detailedFeature != null && detailedFeature.eIsProxy()) {
			InternalEObject oldDetailedFeature = (InternalEObject) detailedFeature;
			detailedFeature = (Feature) eResolveProxy(oldDetailedFeature);
			if (detailedFeature != oldDetailedFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE,
							oldDetailedFeature, detailedFeature));
			}
		}
		return detailedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetDetailedFeature() {
		return detailedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDetailedFeature(
			Feature newDetailedFeature, NotificationChain msgs) {
		Feature oldDetailedFeature = detailedFeature;
		detailedFeature = newDetailedFeature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE,
					oldDetailedFeature, newDetailedFeature);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDetailedFeature(Feature newDetailedFeature) {
		if (newDetailedFeature != detailedFeature) {
			NotificationChain msgs = null;
			if (detailedFeature != null)
				msgs = ((InternalEObject) detailedFeature).eInverseRemove(this,
						UrmlPackage.FEATURE__DETAILING_USE_CASES,
						Feature.class, msgs);
			if (newDetailedFeature != null)
				msgs = ((InternalEObject) newDetailedFeature).eInverseAdd(this,
						UrmlPackage.FEATURE__DETAILING_USE_CASES,
						Feature.class, msgs);
			msgs = basicSetDetailedFeature(newDetailedFeature, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE,
					newDetailedFeature, newDetailedFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE:
			if (detailedFeature != null)
				msgs = ((InternalEObject) detailedFeature).eInverseRemove(this,
						UrmlPackage.FEATURE__DETAILING_USE_CASES,
						Feature.class, msgs);
			return basicSetDetailedFeature((Feature) otherEnd, msgs);
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
		case UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE:
			return basicSetDetailedFeature(null, msgs);
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
		case UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE:
			if (resolve)
				return getDetailedFeature();
			return basicGetDetailedFeature();
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
		case UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE:
			setDetailedFeature((Feature) newValue);
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
		case UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE:
			setDetailedFeature((Feature) null);
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
		case UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE:
			return detailedFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //SolutionDomainUseCaseImpl