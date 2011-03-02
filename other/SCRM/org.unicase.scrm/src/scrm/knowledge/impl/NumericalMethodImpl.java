/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.impl;

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

import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;

import scrm.requirements.IRequirement;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getSolvedProblem <em>Solved Problem</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getRealizingRequirement <em>Realizing Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalMethodImpl extends EObjectImpl implements NumericalMethod {
	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<IRequirement> requirements;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Assumption> dependencies;

	/**
	 * The cached value of the '{@link #getRealizingRequirement() <em>Realizing Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizingRequirement()
	 * @generated
	 * @ordered
	 */
	protected Requirement realizingRequirement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericalMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KnowledgePackage.Literals.NUMERICAL_METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectWithInverseResolvingEList.ManyInverse<IRequirement>(IRequirement.class, this, KnowledgePackage.NUMERICAL_METHOD__REQUIREMENTS, RequirementsPackage.IREQUIREMENT__USED_KNOWLEDGE);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificProblem getSolvedProblem() {
		if (eContainerFeatureID() != KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM) return null;
		return (ScientificProblem)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSolvedProblem(ScientificProblem newSolvedProblem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSolvedProblem, KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolvedProblem(ScientificProblem newSolvedProblem) {
		if (newSolvedProblem != eInternalContainer() || (eContainerFeatureID() != KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM && newSolvedProblem != null)) {
			if (EcoreUtil.isAncestor(this, newSolvedProblem))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSolvedProblem != null)
				msgs = ((InternalEObject)newSolvedProblem).eInverseAdd(this, KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD, ScientificProblem.class, msgs);
			msgs = basicSetSolvedProblem(newSolvedProblem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM, newSolvedProblem, newSolvedProblem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assumption> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentWithInverseEList<Assumption>(Assumption.class, this, KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES, KnowledgePackage.ASSUMPTION__DEPENDING_METHOD);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getRealizingRequirement() {
		if (realizingRequirement != null && realizingRequirement.eIsProxy()) {
			InternalEObject oldRealizingRequirement = (InternalEObject)realizingRequirement;
			realizingRequirement = (Requirement)eResolveProxy(oldRealizingRequirement);
			if (realizingRequirement != oldRealizingRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT, oldRealizingRequirement, realizingRequirement));
			}
		}
		return realizingRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement basicGetRealizingRequirement() {
		return realizingRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRealizingRequirement(Requirement newRealizingRequirement, NotificationChain msgs) {
		Requirement oldRealizingRequirement = realizingRequirement;
		realizingRequirement = newRealizingRequirement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT, oldRealizingRequirement, newRealizingRequirement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealizingRequirement(Requirement newRealizingRequirement) {
		if (newRealizingRequirement != realizingRequirement) {
			NotificationChain msgs = null;
			if (realizingRequirement != null)
				msgs = ((InternalEObject)realizingRequirement).eInverseRemove(this, RequirementsPackage.REQUIREMENT__REALIZED_METHOD, Requirement.class, msgs);
			if (newRealizingRequirement != null)
				msgs = ((InternalEObject)newRealizingRequirement).eInverseAdd(this, RequirementsPackage.REQUIREMENT__REALIZED_METHOD, Requirement.class, msgs);
			msgs = basicSetRealizingRequirement(newRealizingRequirement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT, newRealizingRequirement, newRealizingRequirement));
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
			case KnowledgePackage.NUMERICAL_METHOD__REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequirements()).basicAdd(otherEnd, msgs);
			case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSolvedProblem((ScientificProblem)otherEnd, msgs);
			case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependencies()).basicAdd(otherEnd, msgs);
			case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
				if (realizingRequirement != null)
					msgs = ((InternalEObject)realizingRequirement).eInverseRemove(this, RequirementsPackage.REQUIREMENT__REALIZED_METHOD, Requirement.class, msgs);
				return basicSetRealizingRequirement((Requirement)otherEnd, msgs);
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
			case KnowledgePackage.NUMERICAL_METHOD__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
			case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
				return basicSetSolvedProblem(null, msgs);
			case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
				return basicSetRealizingRequirement(null, msgs);
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
			case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD, ScientificProblem.class, msgs);
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
			case KnowledgePackage.NUMERICAL_METHOD__REQUIREMENTS:
				return getRequirements();
			case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
				return getSolvedProblem();
			case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
				return getDependencies();
			case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
				if (resolve) return getRealizingRequirement();
				return basicGetRealizingRequirement();
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
			case KnowledgePackage.NUMERICAL_METHOD__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends IRequirement>)newValue);
				return;
			case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
				setSolvedProblem((ScientificProblem)newValue);
				return;
			case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends Assumption>)newValue);
				return;
			case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
				setRealizingRequirement((Requirement)newValue);
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
			case KnowledgePackage.NUMERICAL_METHOD__REQUIREMENTS:
				getRequirements().clear();
				return;
			case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
				setSolvedProblem((ScientificProblem)null);
				return;
			case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
				getDependencies().clear();
				return;
			case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
				setRealizingRequirement((Requirement)null);
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
			case KnowledgePackage.NUMERICAL_METHOD__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
				return getSolvedProblem() != null;
			case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
				return realizingRequirement != null;
		}
		return super.eIsSet(featureID);
	}

} //NumericalMethodImpl
