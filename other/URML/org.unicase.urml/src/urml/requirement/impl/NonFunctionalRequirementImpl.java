/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement.impl;

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

import urml.feature.AbstractFeature;
import urml.feature.FeaturePackage;

import urml.requirement.NonFunctionalRequirement;
import urml.requirement.RequirementPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Functional Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.requirement.impl.NonFunctionalRequirementImpl#getConstrainedFeatures <em>Constrained Features</em>}</li>
 *   <li>{@link urml.requirement.impl.NonFunctionalRequirementImpl#getSubNonFunctionalRequirements <em>Sub Non Functional Requirements</em>}</li>
 *   <li>{@link urml.requirement.impl.NonFunctionalRequirementImpl#getParentNonFunctionalRequirement <em>Parent Non Functional Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NonFunctionalRequirementImpl extends RequirementImpl implements NonFunctionalRequirement {
	/**
	 * The cached value of the '{@link #getConstrainedFeatures() <em>Constrained Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> constrainedFeatures;

	/**
	 * The cached value of the '{@link #getSubNonFunctionalRequirements() <em>Sub Non Functional Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubNonFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<NonFunctionalRequirement> subNonFunctionalRequirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonFunctionalRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.NON_FUNCTIONAL_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractFeature> getConstrainedFeatures() {
		if (constrainedFeatures == null) {
			constrainedFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(
				AbstractFeature.class, this, RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES,
				FeaturePackage.ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS);
		}
		return constrainedFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NonFunctionalRequirement> getSubNonFunctionalRequirements() {
		if (subNonFunctionalRequirements == null) {
			subNonFunctionalRequirements = new EObjectContainmentWithInverseEList.Resolving<NonFunctionalRequirement>(
				NonFunctionalRequirement.class, this,
				RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS,
				RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT);
		}
		return subNonFunctionalRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonFunctionalRequirement getParentNonFunctionalRequirement() {
		if (eContainerFeatureID() != RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT)
			return null;
		return (NonFunctionalRequirement) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonFunctionalRequirement basicGetParentNonFunctionalRequirement() {
		if (eContainerFeatureID() != RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT)
			return null;
		return (NonFunctionalRequirement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentNonFunctionalRequirement(
		NonFunctionalRequirement newParentNonFunctionalRequirement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentNonFunctionalRequirement,
			RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentNonFunctionalRequirement(NonFunctionalRequirement newParentNonFunctionalRequirement) {
		if (newParentNonFunctionalRequirement != eInternalContainer()
			|| (eContainerFeatureID() != RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT && newParentNonFunctionalRequirement != null)) {
			if (EcoreUtil.isAncestor(this, newParentNonFunctionalRequirement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentNonFunctionalRequirement != null)
				msgs = ((InternalEObject) newParentNonFunctionalRequirement).eInverseAdd(this,
					RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS,
					NonFunctionalRequirement.class, msgs);
			msgs = basicSetParentNonFunctionalRequirement(newParentNonFunctionalRequirement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT,
				newParentNonFunctionalRequirement, newParentNonFunctionalRequirement));
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getConstrainedFeatures()).basicAdd(otherEnd,
				msgs);
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubNonFunctionalRequirements()).basicAdd(
				otherEnd, msgs);
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentNonFunctionalRequirement((NonFunctionalRequirement) otherEnd, msgs);
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			return ((InternalEList<?>) getConstrainedFeatures()).basicRemove(otherEnd, msgs);
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS:
			return ((InternalEList<?>) getSubNonFunctionalRequirements()).basicRemove(otherEnd, msgs);
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT:
			return basicSetParentNonFunctionalRequirement(null, msgs);
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT:
			return eInternalContainer().eInverseRemove(this,
				RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS,
				NonFunctionalRequirement.class, msgs);
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			return getConstrainedFeatures();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS:
			return getSubNonFunctionalRequirements();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT:
			if (resolve)
				return getParentNonFunctionalRequirement();
			return basicGetParentNonFunctionalRequirement();
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			getConstrainedFeatures().clear();
			getConstrainedFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS:
			getSubNonFunctionalRequirements().clear();
			getSubNonFunctionalRequirements().addAll((Collection<? extends NonFunctionalRequirement>) newValue);
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT:
			setParentNonFunctionalRequirement((NonFunctionalRequirement) newValue);
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			getConstrainedFeatures().clear();
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS:
			getSubNonFunctionalRequirements().clear();
			return;
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT:
			setParentNonFunctionalRequirement((NonFunctionalRequirement) null);
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
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES:
			return constrainedFeatures != null && !constrainedFeatures.isEmpty();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__SUB_NON_FUNCTIONAL_REQUIREMENTS:
			return subNonFunctionalRequirements != null && !subNonFunctionalRequirements.isEmpty();
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__PARENT_NON_FUNCTIONAL_REQUIREMENT:
			return basicGetParentNonFunctionalRequirement() != null;
		}
		return super.eIsSet(featureID);
	}

} //NonFunctionalRequirementImpl
