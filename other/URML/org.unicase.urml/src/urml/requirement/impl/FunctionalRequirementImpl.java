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

import org.unicase.model.urml.Feature;
import org.unicase.model.urml.UrmlPackage;

import urml.requirement.FunctionalRequirement;
import urml.requirement.RequirementPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functional Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.requirement.impl.FunctionalRequirementImpl#getDetailedFeatures <em>Detailed Features</em>}</li>
 *   <li>{@link urml.requirement.impl.FunctionalRequirementImpl#getSubRequirements <em>Sub Requirements</em>}</li>
 *   <li>{@link urml.requirement.impl.FunctionalRequirementImpl#getParentRequirement <em>Parent Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionalRequirementImpl extends RequirementImpl implements FunctionalRequirement {
	/**
	 * The cached value of the '{@link #getDetailedFeatures() <em>Detailed Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> detailedFeatures;

	/**
	 * The cached value of the '{@link #getSubRequirements() <em>Sub Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalRequirement> subRequirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionalRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.FUNCTIONAL_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getDetailedFeatures() {
		if (detailedFeatures == null) {
			detailedFeatures = new EObjectWithInverseResolvingEList.ManyInverse<Feature>(Feature.class, this,
				RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES,
				UrmlPackage.FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS);
		}
		return detailedFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionalRequirement> getSubRequirements() {
		if (subRequirements == null) {
			subRequirements = new EObjectContainmentWithInverseEList.Resolving<FunctionalRequirement>(
				FunctionalRequirement.class, this, RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS,
				RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT);
		}
		return subRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement getParentRequirement() {
		if (eContainerFeatureID() != RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT)
			return null;
		return (FunctionalRequirement) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement basicGetParentRequirement() {
		if (eContainerFeatureID() != RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT)
			return null;
		return (FunctionalRequirement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentRequirement(FunctionalRequirement newParentRequirement,
		NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentRequirement,
			RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentRequirement(FunctionalRequirement newParentRequirement) {
		if (newParentRequirement != eInternalContainer()
			|| (eContainerFeatureID() != RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT && newParentRequirement != null)) {
			if (EcoreUtil.isAncestor(this, newParentRequirement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentRequirement != null)
				msgs = ((InternalEObject) newParentRequirement).eInverseAdd(this,
					RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS, FunctionalRequirement.class, msgs);
			msgs = basicSetParentRequirement(newParentRequirement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT, newParentRequirement,
				newParentRequirement));
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDetailedFeatures()).basicAdd(otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubRequirements()).basicAdd(otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentRequirement((FunctionalRequirement) otherEnd, msgs);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return ((InternalEList<?>) getDetailedFeatures()).basicRemove(otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS:
			return ((InternalEList<?>) getSubRequirements()).basicRemove(otherEnd, msgs);
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT:
			return basicSetParentRequirement(null, msgs);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT:
			return eInternalContainer().eInverseRemove(this,
				RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS, FunctionalRequirement.class, msgs);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return getDetailedFeatures();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS:
			return getSubRequirements();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT:
			if (resolve)
				return getParentRequirement();
			return basicGetParentRequirement();
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			getDetailedFeatures().clear();
			getDetailedFeatures().addAll((Collection<? extends Feature>) newValue);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS:
			getSubRequirements().clear();
			getSubRequirements().addAll((Collection<? extends FunctionalRequirement>) newValue);
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT:
			setParentRequirement((FunctionalRequirement) newValue);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			getDetailedFeatures().clear();
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS:
			getSubRequirements().clear();
			return;
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT:
			setParentRequirement((FunctionalRequirement) null);
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
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES:
			return detailedFeatures != null && !detailedFeatures.isEmpty();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS:
			return subRequirements != null && !subRequirements.isEmpty();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT:
			return basicGetParentRequirement() != null;
		}
		return super.eIsSet(featureID);
	}

} //FunctionalRequirementImpl
