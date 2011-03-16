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
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.ConstraintImpl#getUsedKnowledge <em>Used Knowledge</em>}</li>
 *   <li>{@link scrm.requirements.impl.ConstraintImpl#getRestrictedFeature <em>Restricted Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends SCRMModelElementImpl implements Constraint {
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
	public ScientificKnowledge getUsedKnowledge() {
		if (eContainerFeatureID() != RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE) return null;
		return (ScientificKnowledge)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsedKnowledge(ScientificKnowledge newUsedKnowledge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUsedKnowledge, RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedKnowledge(ScientificKnowledge newUsedKnowledge) {
		if (newUsedKnowledge != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE && newUsedKnowledge != null)) {
			if (EcoreUtil.isAncestor(this, newUsedKnowledge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUsedKnowledge != null)
				msgs = ((InternalEObject)newUsedKnowledge).eInverseAdd(this, KnowledgePackage.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS, ScientificKnowledge.class, msgs);
			msgs = basicSetUsedKnowledge(newUsedKnowledge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE, newUsedKnowledge, newUsedKnowledge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getRestrictedFeature() {
		if (eContainerFeatureID() != RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE) return null;
		return (Feature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRestrictedFeature(Feature newRestrictedFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRestrictedFeature, RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedFeature(Feature newRestrictedFeature) {
		if (newRestrictedFeature != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE && newRestrictedFeature != null)) {
			if (EcoreUtil.isAncestor(this, newRestrictedFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
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
			case RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUsedKnowledge((ScientificKnowledge)otherEnd, msgs);
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
			case RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE:
				return basicSetUsedKnowledge(null, msgs);
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
			case RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS, ScientificKnowledge.class, msgs);
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.FEATURE__CONSTRAINTS, Feature.class, msgs);
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
			case RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE:
				return getUsedKnowledge();
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				return getRestrictedFeature();
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
			case RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE:
				setUsedKnowledge((ScientificKnowledge)newValue);
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
			case RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE:
				setUsedKnowledge((ScientificKnowledge)null);
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
			case RequirementsPackage.CONSTRAINT__USED_KNOWLEDGE:
				return getUsedKnowledge() != null;
			case RequirementsPackage.CONSTRAINT__RESTRICTED_FEATURE:
				return getRestrictedFeature() != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstraintImpl
