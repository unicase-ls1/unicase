/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import scrm.impl.SCRMModelElementImpl;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.ScientificKnowledge;

import scrm.requirements.Constraint;
import scrm.requirements.Feature;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.ConstraintImpl#getContainingRequirementSpace <em>Containing Requirement Space</em>}</li>
 *   <li>{@link scrm.requirements.impl.ConstraintImpl#getRestrictedFeature <em>Restricted Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends SCRMModelElementImpl implements Constraint {
	/**
	 * The cached value of the '{@link #getRestrictedFeature() <em>Restricted Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature restrictedFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace getContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE) return null;
		return (RequirementSpace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace basicGetContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE) return null;
		return (RequirementSpace)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingRequirementSpace(RequirementSpace newContainingRequirementSpace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingRequirementSpace, RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingRequirementSpace(RequirementSpace newContainingRequirementSpace) {
		if (newContainingRequirementSpace != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE && newContainingRequirementSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingRequirementSpace))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingRequirementSpace != null)
				msgs = ((InternalEObject)newContainingRequirementSpace).eInverseAdd(this, RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS, RequirementSpace.class, msgs);
			msgs = basicSetContainingRequirementSpace(newContainingRequirementSpace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE, newContainingRequirementSpace, newContainingRequirementSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getRestrictedFeature() {
		if (restrictedFeature != null && restrictedFeature.eIsProxy()) {
			InternalEObject oldRestrictedFeature = (InternalEObject)restrictedFeature;
			restrictedFeature = (Feature)eResolveProxy(oldRestrictedFeature);
			if (restrictedFeature != oldRestrictedFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE, oldRestrictedFeature, restrictedFeature));
			}
		}
		return restrictedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetRestrictedFeature() {
		return restrictedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRestrictedFeature(Feature newRestrictedFeature, NotificationChain msgs) {
		Feature oldRestrictedFeature = restrictedFeature;
		restrictedFeature = newRestrictedFeature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE, oldRestrictedFeature, newRestrictedFeature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedFeature(Feature newRestrictedFeature) {
		if (newRestrictedFeature != restrictedFeature) {
			NotificationChain msgs = null;
			if (restrictedFeature != null)
				msgs = ((InternalEObject)restrictedFeature).eInverseRemove(this, RequirementsPackage.FEATURE__CONSTRAINTS, Feature.class, msgs);
			if (newRestrictedFeature != null)
				msgs = ((InternalEObject)newRestrictedFeature).eInverseAdd(this, RequirementsPackage.FEATURE__CONSTRAINTS, Feature.class, msgs);
			msgs = basicSetRestrictedFeature(newRestrictedFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE, newRestrictedFeature, newRestrictedFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingRequirementSpace((RequirementSpace)otherEnd, msgs);
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				if (restrictedFeature != null)
					msgs = ((InternalEObject)restrictedFeature).eInverseRemove(this, RequirementsPackage.FEATURE__CONSTRAINTS, Feature.class, msgs);
				return basicSetRestrictedFeature((Feature)otherEnd, msgs);
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
			case RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE:
				return basicSetContainingRequirementSpace(null, msgs);
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				return basicSetRestrictedFeature(null, msgs);
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
			case RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS, RequirementSpace.class, msgs);
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
			case RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE:
				if (resolve) return getContainingRequirementSpace();
				return basicGetContainingRequirementSpace();
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				if (resolve) return getRestrictedFeature();
				return basicGetRestrictedFeature();
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
			case RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE:
				setContainingRequirementSpace((RequirementSpace)newValue);
				return;
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				setRestrictedFeature((Feature)newValue);
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
			case RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE:
				setContainingRequirementSpace((RequirementSpace)null);
				return;
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				setRestrictedFeature((Feature)null);
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
			case RequirementsPackage.CONSTRAINT__CONTAINING_REQUIREMENT_SPACE:
				return basicGetContainingRequirementSpace() != null;
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				return restrictedFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstraintImpl
