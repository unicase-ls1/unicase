/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.impl;

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

import org.unicase.model.urml.Feature;
import org.unicase.model.urml.UrmlPackage;

import urml.goal.Goal;
import urml.goal.GoalPackage;

import urml.requirement.FunctionalRequirement;
import urml.requirement.NonFunctionalRequirement;
import urml.requirement.RequirementPackage;

import urml.usecase.SolutionDomainUseCase;
import urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.impl.FeatureImpl#getGoals <em>Goals</em>}</li>
 *   <li>{@link org.unicase.model.urml.impl.FeatureImpl#getDetailingFunctionalRequirements <em>Detailing Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.urml.impl.FeatureImpl#getConstrainingNonFunctionalRequirements <em>Constraining Non Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.urml.impl.FeatureImpl#getDetailingUseCases <em>Detailing Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.urml.impl.FeatureImpl#getParentFeature <em>Parent Feature</em>}</li>
 *   <li>{@link org.unicase.model.urml.impl.FeatureImpl#getSubFeatures <em>Sub Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends UrmlModelElementImpl implements Feature {
	/**
	 * The cached value of the '{@link #getGoals() <em>Goals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<Goal> goals;

	/**
	 * The cached value of the '{@link #getDetailingFunctionalRequirements() <em>Detailing Functional Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailingFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalRequirement> detailingFunctionalRequirements;

	/**
	 * The cached value of the '{@link #getConstrainingNonFunctionalRequirements() <em>Constraining Non Functional Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainingNonFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<NonFunctionalRequirement> constrainingNonFunctionalRequirements;

	/**
	 * The cached value of the '{@link #getDetailingUseCases() <em>Detailing Use Cases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailingUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<SolutionDomainUseCase> detailingUseCases;

	/**
	 * The cached value of the '{@link #getSubFeatures() <em>Sub Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> subFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrmlPackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Goal> getGoals() {
		if (goals == null) {
			goals = new EObjectWithInverseResolvingEList.ManyInverse<Goal>(Goal.class, this,
				UrmlPackage.FEATURE__GOALS, GoalPackage.GOAL__REALIZED_FEATURES);
		}
		return goals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionalRequirement> getDetailingFunctionalRequirements() {
		if (detailingFunctionalRequirements == null) {
			detailingFunctionalRequirements = new EObjectWithInverseResolvingEList.ManyInverse<FunctionalRequirement>(
				FunctionalRequirement.class, this, UrmlPackage.FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS,
				RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES);
		}
		return detailingFunctionalRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NonFunctionalRequirement> getConstrainingNonFunctionalRequirements() {
		if (constrainingNonFunctionalRequirements == null) {
			constrainingNonFunctionalRequirements = new EObjectWithInverseResolvingEList.ManyInverse<NonFunctionalRequirement>(
				NonFunctionalRequirement.class, this, UrmlPackage.FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS,
				RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES);
		}
		return constrainingNonFunctionalRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SolutionDomainUseCase> getDetailingUseCases() {
		if (detailingUseCases == null) {
			detailingUseCases = new EObjectWithInverseResolvingEList<SolutionDomainUseCase>(
				SolutionDomainUseCase.class, this, UrmlPackage.FEATURE__DETAILING_USE_CASES,
				UsecasePackage.SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE);
		}
		return detailingUseCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getParentFeature() {
		if (eContainerFeatureID() != UrmlPackage.FEATURE__PARENT_FEATURE)
			return null;
		return (Feature) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetParentFeature() {
		if (eContainerFeatureID() != UrmlPackage.FEATURE__PARENT_FEATURE)
			return null;
		return (Feature) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentFeature(Feature newParentFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentFeature, UrmlPackage.FEATURE__PARENT_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentFeature(Feature newParentFeature) {
		if (newParentFeature != eInternalContainer()
			|| (eContainerFeatureID() != UrmlPackage.FEATURE__PARENT_FEATURE && newParentFeature != null)) {
			if (EcoreUtil.isAncestor(this, newParentFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentFeature != null)
				msgs = ((InternalEObject) newParentFeature).eInverseAdd(this, UrmlPackage.FEATURE__SUB_FEATURES,
					Feature.class, msgs);
			msgs = basicSetParentFeature(newParentFeature, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.FEATURE__PARENT_FEATURE,
				newParentFeature, newParentFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getSubFeatures() {
		if (subFeatures == null) {
			subFeatures = new EObjectContainmentWithInverseEList.Resolving<Feature>(Feature.class, this,
				UrmlPackage.FEATURE__SUB_FEATURES, UrmlPackage.FEATURE__PARENT_FEATURE);
		}
		return subFeatures;
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
		case UrmlPackage.FEATURE__GOALS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getGoals()).basicAdd(otherEnd, msgs);
		case UrmlPackage.FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailingFunctionalRequirements()).basicAdd(
				otherEnd, msgs);
		case UrmlPackage.FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getConstrainingNonFunctionalRequirements())
				.basicAdd(otherEnd, msgs);
		case UrmlPackage.FEATURE__DETAILING_USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailingUseCases())
				.basicAdd(otherEnd, msgs);
		case UrmlPackage.FEATURE__PARENT_FEATURE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentFeature((Feature) otherEnd, msgs);
		case UrmlPackage.FEATURE__SUB_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubFeatures()).basicAdd(otherEnd, msgs);
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
		case UrmlPackage.FEATURE__GOALS:
			return ((InternalEList<?>) getGoals()).basicRemove(otherEnd, msgs);
		case UrmlPackage.FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<?>) getDetailingFunctionalRequirements()).basicRemove(otherEnd, msgs);
		case UrmlPackage.FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<?>) getConstrainingNonFunctionalRequirements()).basicRemove(otherEnd, msgs);
		case UrmlPackage.FEATURE__DETAILING_USE_CASES:
			return ((InternalEList<?>) getDetailingUseCases()).basicRemove(otherEnd, msgs);
		case UrmlPackage.FEATURE__PARENT_FEATURE:
			return basicSetParentFeature(null, msgs);
		case UrmlPackage.FEATURE__SUB_FEATURES:
			return ((InternalEList<?>) getSubFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case UrmlPackage.FEATURE__PARENT_FEATURE:
			return eInternalContainer().eInverseRemove(this, UrmlPackage.FEATURE__SUB_FEATURES, Feature.class, msgs);
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
		case UrmlPackage.FEATURE__GOALS:
			return getGoals();
		case UrmlPackage.FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			return getDetailingFunctionalRequirements();
		case UrmlPackage.FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			return getConstrainingNonFunctionalRequirements();
		case UrmlPackage.FEATURE__DETAILING_USE_CASES:
			return getDetailingUseCases();
		case UrmlPackage.FEATURE__PARENT_FEATURE:
			if (resolve)
				return getParentFeature();
			return basicGetParentFeature();
		case UrmlPackage.FEATURE__SUB_FEATURES:
			return getSubFeatures();
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
		case UrmlPackage.FEATURE__GOALS:
			getGoals().clear();
			getGoals().addAll((Collection<? extends Goal>) newValue);
			return;
		case UrmlPackage.FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			getDetailingFunctionalRequirements().clear();
			getDetailingFunctionalRequirements().addAll((Collection<? extends FunctionalRequirement>) newValue);
			return;
		case UrmlPackage.FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			getConstrainingNonFunctionalRequirements().clear();
			getConstrainingNonFunctionalRequirements()
				.addAll((Collection<? extends NonFunctionalRequirement>) newValue);
			return;
		case UrmlPackage.FEATURE__DETAILING_USE_CASES:
			getDetailingUseCases().clear();
			getDetailingUseCases().addAll((Collection<? extends SolutionDomainUseCase>) newValue);
			return;
		case UrmlPackage.FEATURE__PARENT_FEATURE:
			setParentFeature((Feature) newValue);
			return;
		case UrmlPackage.FEATURE__SUB_FEATURES:
			getSubFeatures().clear();
			getSubFeatures().addAll((Collection<? extends Feature>) newValue);
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
		case UrmlPackage.FEATURE__GOALS:
			getGoals().clear();
			return;
		case UrmlPackage.FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			getDetailingFunctionalRequirements().clear();
			return;
		case UrmlPackage.FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			getConstrainingNonFunctionalRequirements().clear();
			return;
		case UrmlPackage.FEATURE__DETAILING_USE_CASES:
			getDetailingUseCases().clear();
			return;
		case UrmlPackage.FEATURE__PARENT_FEATURE:
			setParentFeature((Feature) null);
			return;
		case UrmlPackage.FEATURE__SUB_FEATURES:
			getSubFeatures().clear();
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
		case UrmlPackage.FEATURE__GOALS:
			return goals != null && !goals.isEmpty();
		case UrmlPackage.FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS:
			return detailingFunctionalRequirements != null && !detailingFunctionalRequirements.isEmpty();
		case UrmlPackage.FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS:
			return constrainingNonFunctionalRequirements != null && !constrainingNonFunctionalRequirements.isEmpty();
		case UrmlPackage.FEATURE__DETAILING_USE_CASES:
			return detailingUseCases != null && !detailingUseCases.isEmpty();
		case UrmlPackage.FEATURE__PARENT_FEATURE:
			return basicGetParentFeature() != null;
		case UrmlPackage.FEATURE__SUB_FEATURES:
			return subFeatures != null && !subFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FeatureImpl
