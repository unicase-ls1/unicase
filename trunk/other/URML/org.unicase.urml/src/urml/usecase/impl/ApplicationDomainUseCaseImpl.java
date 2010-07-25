/**
 * <copyright> </copyright> $Id$
 */
package urml.usecase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import urml.goal.Goal;
import urml.goal.GoalPackage;

import urml.usecase.ApplicationDomainUseCase;
import urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Domain Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.usecase.impl.ApplicationDomainUseCaseImpl#getDetailedGoal <em>Detailed Goal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationDomainUseCaseImpl extends UseCaseImpl implements ApplicationDomainUseCase {
	/**
	 * The cached value of the '{@link #getDetailedGoal() <em>Detailed Goal</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailedGoal()
	 * @generated
	 * @ordered
	 */
	protected EList<Goal> detailedGoal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationDomainUseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.APPLICATION_DOMAIN_USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Goal> getDetailedGoal() {
		if (detailedGoal == null) {
			detailedGoal = new EObjectWithInverseResolvingEList<Goal>(Goal.class, this,
				UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL, GoalPackage.GOAL__DETAILING_USE_CASES);
		}
		return detailedGoal;
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
		case UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailedGoal()).basicAdd(otherEnd, msgs);
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
		case UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL:
			return ((InternalEList<?>) getDetailedGoal()).basicRemove(otherEnd, msgs);
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
		case UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL:
			return getDetailedGoal();
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
		case UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL:
			getDetailedGoal().clear();
			getDetailedGoal().addAll((Collection<? extends Goal>) newValue);
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
		case UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL:
			getDetailedGoal().clear();
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
		case UsecasePackage.APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL:
			return detailedGoal != null && !detailedGoal.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ApplicationDomainUseCaseImpl
