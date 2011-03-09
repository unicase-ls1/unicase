/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificKnowledge;

import scrm.requirements.DataDefinition;
import scrm.requirements.Feature;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.RequirementImpl#getUsedKnowledge <em>Used Knowledge</em>}</li>
 *   <li>{@link scrm.requirements.impl.RequirementImpl#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link scrm.requirements.impl.RequirementImpl#getRefinedRequirement <em>Refined Requirement</em>}</li>
 *   <li>{@link scrm.requirements.impl.RequirementImpl#getSpecifiedFeature <em>Specified Feature</em>}</li>
 *   <li>{@link scrm.requirements.impl.RequirementImpl#getDefiningData <em>Defining Data</em>}</li>
 *   <li>{@link scrm.requirements.impl.RequirementImpl#getRealizedMethod <em>Realized Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpl extends EObjectImpl implements Requirement {
	/**
	 * The cached value of the '{@link #getUsedKnowledge() <em>Used Knowledge</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedKnowledge()
	 * @generated
	 * @ordered
	 */
	protected EList<ScientificKnowledge> usedKnowledge;

	/**
	 * The cached value of the '{@link #getRefinements() <em>Refinements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> refinements;

	/**
	 * The cached value of the '{@link #getDefiningData() <em>Defining Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefiningData()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDefinition> definingData;

	/**
	 * The cached value of the '{@link #getRealizedMethod() <em>Realized Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedMethod()
	 * @generated
	 * @ordered
	 */
	protected NumericalMethod realizedMethod;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScientificKnowledge> getUsedKnowledge() {
		if (usedKnowledge == null) {
			usedKnowledge = new EObjectWithInverseResolvingEList.ManyInverse<ScientificKnowledge>(ScientificKnowledge.class, this, RequirementsPackage.REQUIREMENT__USED_KNOWLEDGE, KnowledgePackage.SCIENTIFIC_KNOWLEDGE__REQUIREMENTS);
		}
		return usedKnowledge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRefinements() {
		if (refinements == null) {
			refinements = new EObjectContainmentWithInverseEList<Requirement>(Requirement.class, this, RequirementsPackage.REQUIREMENT__REFINEMENTS, RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT);
		}
		return refinements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getRefinedRequirement() {
		if (eContainerFeatureID() != RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT) return null;
		return (Requirement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedRequirement(Requirement newRefinedRequirement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRefinedRequirement, RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedRequirement(Requirement newRefinedRequirement) {
		if (newRefinedRequirement != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT && newRefinedRequirement != null)) {
			if (EcoreUtil.isAncestor(this, newRefinedRequirement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefinedRequirement != null)
				msgs = ((InternalEObject)newRefinedRequirement).eInverseAdd(this, RequirementsPackage.REQUIREMENT__REFINEMENTS, Requirement.class, msgs);
			msgs = basicSetRefinedRequirement(newRefinedRequirement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT, newRefinedRequirement, newRefinedRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getSpecifiedFeature() {
		if (eContainerFeatureID() != RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE) return null;
		return (Feature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifiedFeature(Feature newSpecifiedFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSpecifiedFeature, RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifiedFeature(Feature newSpecifiedFeature) {
		if (newSpecifiedFeature != eInternalContainer() || (eContainerFeatureID() != RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE && newSpecifiedFeature != null)) {
			if (EcoreUtil.isAncestor(this, newSpecifiedFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecifiedFeature != null)
				msgs = ((InternalEObject)newSpecifiedFeature).eInverseAdd(this, RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS, Feature.class, msgs);
			msgs = basicSetSpecifiedFeature(newSpecifiedFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE, newSpecifiedFeature, newSpecifiedFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataDefinition> getDefiningData() {
		if (definingData == null) {
			definingData = new EObjectContainmentWithInverseEList<DataDefinition>(DataDefinition.class, this, RequirementsPackage.REQUIREMENT__DEFINING_DATA, RequirementsPackage.DATA_DEFINITION__DEFINED_REQUIREMENT);
		}
		return definingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod getRealizedMethod() {
		if (realizedMethod != null && realizedMethod.eIsProxy()) {
			InternalEObject oldRealizedMethod = (InternalEObject)realizedMethod;
			realizedMethod = (NumericalMethod)eResolveProxy(oldRealizedMethod);
			if (realizedMethod != oldRealizedMethod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENT__REALIZED_METHOD, oldRealizedMethod, realizedMethod));
			}
		}
		return realizedMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod basicGetRealizedMethod() {
		return realizedMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRealizedMethod(NumericalMethod newRealizedMethod, NotificationChain msgs) {
		NumericalMethod oldRealizedMethod = realizedMethod;
		realizedMethod = newRealizedMethod;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__REALIZED_METHOD, oldRealizedMethod, newRealizedMethod);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealizedMethod(NumericalMethod newRealizedMethod) {
		if (newRealizedMethod != realizedMethod) {
			NotificationChain msgs = null;
			if (realizedMethod != null)
				msgs = ((InternalEObject)realizedMethod).eInverseRemove(this, KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT, NumericalMethod.class, msgs);
			if (newRealizedMethod != null)
				msgs = ((InternalEObject)newRealizedMethod).eInverseAdd(this, KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT, NumericalMethod.class, msgs);
			msgs = basicSetRealizedMethod(newRealizedMethod, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__REALIZED_METHOD, newRealizedMethod, newRealizedMethod));
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
			case RequirementsPackage.REQUIREMENT__USED_KNOWLEDGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsedKnowledge()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.REQUIREMENT__REFINEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefinements()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRefinedRequirement((Requirement)otherEnd, msgs);
			case RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSpecifiedFeature((Feature)otherEnd, msgs);
			case RequirementsPackage.REQUIREMENT__DEFINING_DATA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDefiningData()).basicAdd(otherEnd, msgs);
			case RequirementsPackage.REQUIREMENT__REALIZED_METHOD:
				if (realizedMethod != null)
					msgs = ((InternalEObject)realizedMethod).eInverseRemove(this, KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT, NumericalMethod.class, msgs);
				return basicSetRealizedMethod((NumericalMethod)otherEnd, msgs);
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
			case RequirementsPackage.REQUIREMENT__USED_KNOWLEDGE:
				return ((InternalEList<?>)getUsedKnowledge()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.REQUIREMENT__REFINEMENTS:
				return ((InternalEList<?>)getRefinements()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT:
				return basicSetRefinedRequirement(null, msgs);
			case RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE:
				return basicSetSpecifiedFeature(null, msgs);
			case RequirementsPackage.REQUIREMENT__DEFINING_DATA:
				return ((InternalEList<?>)getDefiningData()).basicRemove(otherEnd, msgs);
			case RequirementsPackage.REQUIREMENT__REALIZED_METHOD:
				return basicSetRealizedMethod(null, msgs);
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
			case RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.REQUIREMENT__REFINEMENTS, Requirement.class, msgs);
			case RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE:
				return eInternalContainer().eInverseRemove(this, RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS, Feature.class, msgs);
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
			case RequirementsPackage.REQUIREMENT__USED_KNOWLEDGE:
				return getUsedKnowledge();
			case RequirementsPackage.REQUIREMENT__REFINEMENTS:
				return getRefinements();
			case RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT:
				return getRefinedRequirement();
			case RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE:
				return getSpecifiedFeature();
			case RequirementsPackage.REQUIREMENT__DEFINING_DATA:
				return getDefiningData();
			case RequirementsPackage.REQUIREMENT__REALIZED_METHOD:
				if (resolve) return getRealizedMethod();
				return basicGetRealizedMethod();
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
			case RequirementsPackage.REQUIREMENT__USED_KNOWLEDGE:
				getUsedKnowledge().clear();
				getUsedKnowledge().addAll((Collection<? extends ScientificKnowledge>)newValue);
				return;
			case RequirementsPackage.REQUIREMENT__REFINEMENTS:
				getRefinements().clear();
				getRefinements().addAll((Collection<? extends Requirement>)newValue);
				return;
			case RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT:
				setRefinedRequirement((Requirement)newValue);
				return;
			case RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE:
				setSpecifiedFeature((Feature)newValue);
				return;
			case RequirementsPackage.REQUIREMENT__DEFINING_DATA:
				getDefiningData().clear();
				getDefiningData().addAll((Collection<? extends DataDefinition>)newValue);
				return;
			case RequirementsPackage.REQUIREMENT__REALIZED_METHOD:
				setRealizedMethod((NumericalMethod)newValue);
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
			case RequirementsPackage.REQUIREMENT__USED_KNOWLEDGE:
				getUsedKnowledge().clear();
				return;
			case RequirementsPackage.REQUIREMENT__REFINEMENTS:
				getRefinements().clear();
				return;
			case RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT:
				setRefinedRequirement((Requirement)null);
				return;
			case RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE:
				setSpecifiedFeature((Feature)null);
				return;
			case RequirementsPackage.REQUIREMENT__DEFINING_DATA:
				getDefiningData().clear();
				return;
			case RequirementsPackage.REQUIREMENT__REALIZED_METHOD:
				setRealizedMethod((NumericalMethod)null);
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
			case RequirementsPackage.REQUIREMENT__USED_KNOWLEDGE:
				return usedKnowledge != null && !usedKnowledge.isEmpty();
			case RequirementsPackage.REQUIREMENT__REFINEMENTS:
				return refinements != null && !refinements.isEmpty();
			case RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT:
				return getRefinedRequirement() != null;
			case RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE:
				return getSpecifiedFeature() != null;
			case RequirementsPackage.REQUIREMENT__DEFINING_DATA:
				return definingData != null && !definingData.isEmpty();
			case RequirementsPackage.REQUIREMENT__REALIZED_METHOD:
				return realizedMethod != null;
		}
		return super.eIsSet(featureID);
	}

} //RequirementImpl
