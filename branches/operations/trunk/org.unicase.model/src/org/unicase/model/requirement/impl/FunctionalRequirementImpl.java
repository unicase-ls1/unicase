/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement.impl;

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
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Functional Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.impl.FunctionalRequirementImpl#getStoryPoints <em>Story Points</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.FunctionalRequirementImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.FunctionalRequirementImpl#getRefiningRequirements <em>Refining Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.FunctionalRequirementImpl#getRefinedRequirement <em>Refined Requirement</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.FunctionalRequirementImpl#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.FunctionalRequirementImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.FunctionalRequirementImpl#isReviewed <em>Reviewed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionalRequirementImpl extends ModelElementImpl implements
		FunctionalRequirement {

	/**
	 * The default value of the '{@link #getStoryPoints() <em>Story Points</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected static final int STORY_POINTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStoryPoints() <em>Story Points</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected int storyPoints = STORY_POINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefiningRequirements()
	 * <em>Refining Requirements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRefiningRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalRequirement> refiningRequirements;

	/**
	 * The cached value of the '{@link #getUseCases() <em>Use Cases</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCases;

	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> scenarios;

	/**
	 * The default value of the '{@link #isReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isReviewed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REVIEWED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isReviewed()
	 * @generated
	 * @ordered
	 */
	protected boolean reviewed = REVIEWED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionalRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.FUNCTIONAL_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReviewed() {
		return reviewed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReviewed(boolean newReviewed) {
		boolean oldReviewed = reviewed;
		reviewed = newReviewed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__REVIEWED,
					oldReviewed, reviewed));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getStoryPoints() {
		return storyPoints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoryPoints(int newStoryPoints) {
		int oldStoryPoints = storyPoints;
		storyPoints = newStoryPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS,
					oldStoryPoints, storyPoints));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__PRIORITY,
					oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionalRequirement> getRefiningRequirements() {
		if (refiningRequirements == null) {
			refiningRequirements = new EObjectContainmentWithInverseEList.Resolving<FunctionalRequirement>(
					FunctionalRequirement.class,
					this,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT);
		}
		return refiningRequirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement getRefinedRequirement() {
		if (eContainerFeatureID != RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT)
			return null;
		return (FunctionalRequirement) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement basicGetRefinedRequirement() {
		if (eContainerFeatureID != RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT)
			return null;
		return (FunctionalRequirement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedRequirement(
			FunctionalRequirement newRefinedRequirement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRefinedRequirement,
				RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedRequirement(
			FunctionalRequirement newRefinedRequirement) {
		if (newRefinedRequirement != eInternalContainer()
				|| (eContainerFeatureID != RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT && newRefinedRequirement != null)) {
			if (EcoreUtil.isAncestor(this, newRefinedRequirement))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefinedRequirement != null)
				msgs = ((InternalEObject) newRefinedRequirement)
						.eInverseAdd(
								this,
								RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS,
								FunctionalRequirement.class, msgs);
			msgs = basicSetRefinedRequirement(newRefinedRequirement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT,
					newRefinedRequirement, newRefinedRequirement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getUseCases() {
		if (useCases == null) {
			useCases = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(
					UseCase.class, this,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__USE_CASES,
					RequirementPackage.USE_CASE__FUNCTIONAL_REQUIREMENTS);
		}
		return useCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectWithInverseResolvingEList.ManyInverse<Scenario>(
					Scenario.class, this,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__SCENARIOS,
					RequirementPackage.SCENARIO__FUNCTIONAL_REQUIREMENTS);
		}
		return scenarios;
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRefiningRequirements())
					.basicAdd(otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRefinedRequirement((FunctionalRequirement) otherEnd,
					msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getUseCases())
					.basicAdd(otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SCENARIOS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getScenarios())
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
			return ((InternalEList<?>) getRefiningRequirements()).basicRemove(
					otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
			return basicSetRefinedRequirement(null, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__USE_CASES:
			return ((InternalEList<?>) getUseCases()).basicRemove(otherEnd,
					msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SCENARIOS:
			return ((InternalEList<?>) getScenarios()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID) {
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
			return eInternalContainer()
					.eInverseRemove(
							this,
							RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS,
							FunctionalRequirement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS:
			return new Integer(getStoryPoints());
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PRIORITY:
			return new Integer(getPriority());
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
			return getRefiningRequirements();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
			if (resolve)
				return getRefinedRequirement();
			return basicGetRefinedRequirement();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__USE_CASES:
			return getUseCases();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SCENARIOS:
			return getScenarios();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REVIEWED:
			return isReviewed() ? Boolean.TRUE : Boolean.FALSE;
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS:
			setStoryPoints(((Integer) newValue).intValue());
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PRIORITY:
			setPriority(((Integer) newValue).intValue());
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
			getRefiningRequirements().clear();
			getRefiningRequirements().addAll(
					(Collection<? extends FunctionalRequirement>) newValue);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
			setRefinedRequirement((FunctionalRequirement) newValue);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__USE_CASES:
			getUseCases().clear();
			getUseCases().addAll((Collection<? extends UseCase>) newValue);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SCENARIOS:
			getScenarios().clear();
			getScenarios().addAll((Collection<? extends Scenario>) newValue);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REVIEWED:
			setReviewed(((Boolean) newValue).booleanValue());
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS:
			setStoryPoints(STORY_POINTS_EDEFAULT);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
			getRefiningRequirements().clear();
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
			setRefinedRequirement((FunctionalRequirement) null);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__USE_CASES:
			getUseCases().clear();
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SCENARIOS:
			getScenarios().clear();
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REVIEWED:
			setReviewed(REVIEWED_EDEFAULT);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__STORY_POINTS:
			return storyPoints != STORY_POINTS_EDEFAULT;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS:
			return refiningRequirements != null
					&& !refiningRequirements.isEmpty();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT:
			return basicGetRefinedRequirement() != null;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__USE_CASES:
			return useCases != null && !useCases.isEmpty();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SCENARIOS:
			return scenarios != null && !scenarios.isEmpty();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__REVIEWED:
			return reviewed != REVIEWED_EDEFAULT;
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
		result.append(" (storyPoints: ");
		result.append(storyPoints);
		result.append(", priority: ");
		result.append(priority);
		result.append(", reviewed: ");
		result.append(reviewed);
		result.append(')');
		return result.toString();
	}

} // FunctionalRequirementImpl
