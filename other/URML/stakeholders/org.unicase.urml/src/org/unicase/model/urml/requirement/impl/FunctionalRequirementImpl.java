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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.urml.feature.AbstractFeature;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.requirement.FunctionalRequirement;
import org.unicase.model.urml.requirement.RequirementPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Functional Requirement</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl#getDetailedFeatures <em>Detailed Features</em>}</li>
 *   <li>{@link org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl#getSubFunctionalRequirements <em>Sub Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.urml.requirement.impl.FunctionalRequirementImpl#getParentFunctionalRequirement <em>Parent Functional Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionalRequirementImpl extends RequirementImpl implements
		FunctionalRequirement {
	/**
	 * The cached value of the '{@link #getDetailedFeatures() <em>Detailed Features</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDetailedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> detailedFeatures;

	/**
	 * The cached value of the '{@link #getSubFunctionalRequirements() <em>Sub Functional Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalRequirement> subFunctionalRequirements;

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
	public EList<AbstractFeature> getDetailedFeatures() {
		if (detailedFeatures == null) {
			detailedFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(
					AbstractFeature.class,
					this,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES,
					FeaturePackage.ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS);
		}
		return detailedFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionalRequirement> getSubFunctionalRequirements() {
		if (subFunctionalRequirements == null) {
			subFunctionalRequirements = new EObjectContainmentWithInverseEList.Resolving<FunctionalRequirement>(
					FunctionalRequirement.class,
					this,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT);
		}
		return subFunctionalRequirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement getParentFunctionalRequirement() {
		if (eContainerFeatureID() != RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT)
			return null;
		return (FunctionalRequirement) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement basicGetParentFunctionalRequirement() {
		if (eContainerFeatureID() != RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT)
			return null;
		return (FunctionalRequirement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentFunctionalRequirement(
			FunctionalRequirement newParentFunctionalRequirement,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newParentFunctionalRequirement,
				RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentFunctionalRequirement(
			FunctionalRequirement newParentFunctionalRequirement) {
		if (newParentFunctionalRequirement != eInternalContainer()
				|| (eContainerFeatureID() != RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT && newParentFunctionalRequirement != null)) {
			if (EcoreUtil.isAncestor(this, newParentFunctionalRequirement))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentFunctionalRequirement != null)
				msgs = ((InternalEObject) newParentFunctionalRequirement)
						.eInverseAdd(
								this,
								RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS,
								FunctionalRequirement.class, msgs);
			msgs = basicSetParentFunctionalRequirement(
					newParentFunctionalRequirement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT,
					newParentFunctionalRequirement,
					newParentFunctionalRequirement));
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailedFeatures())
					.basicAdd(otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubFunctionalRequirements())
					.basicAdd(otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentFunctionalRequirement(
					(FunctionalRequirement) otherEnd, msgs);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return ((InternalEList<?>) getDetailedFeatures()).basicRemove(
					otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<?>) getSubFunctionalRequirements())
					.basicRemove(otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT:
			return basicSetParentFunctionalRequirement(null, msgs);
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
		switch (eContainerFeatureID()) {
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT:
			return eInternalContainer()
					.eInverseRemove(
							this,
							RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS,
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return getDetailedFeatures();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS:
			return getSubFunctionalRequirements();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT:
			if (resolve)
				return getParentFunctionalRequirement();
			return basicGetParentFunctionalRequirement();
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			getDetailedFeatures().clear();
			getDetailedFeatures().addAll(
					(Collection<? extends AbstractFeature>) newValue);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS:
			getSubFunctionalRequirements().clear();
			getSubFunctionalRequirements().addAll(
					(Collection<? extends FunctionalRequirement>) newValue);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT:
			setParentFunctionalRequirement((FunctionalRequirement) newValue);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			getDetailedFeatures().clear();
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS:
			getSubFunctionalRequirements().clear();
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT:
			setParentFunctionalRequirement((FunctionalRequirement) null);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return detailedFeatures != null && !detailedFeatures.isEmpty();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_FUNCTIONAL_REQUIREMENTS:
			return subFunctionalRequirements != null
					&& !subFunctionalRequirements.isEmpty();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_FUNCTIONAL_REQUIREMENT:
			return basicGetParentFunctionalRequirement() != null;
		}
		return super.eIsSet(featureID);
	}

} // FunctionalRequirementImpl
