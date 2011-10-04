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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.impl.SCRMModelElementImpl;

import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;

import scrm.requirements.Performance;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getContainingKnowledgeSpace <em>Containing Knowledge Space</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getSolvedProblem <em>Solved Problem</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getRealizingRequirement <em>Realizing Requirement</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getMathematicalModel <em>Mathematical Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getPerformance <em>Performance</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getTheory <em>Theory</em>}</li>
 *   <li>{@link scrm.knowledge.impl.NumericalMethodImpl#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalMethodImpl extends SCRMModelElementImpl implements
		NumericalMethod {
	/**
	 * The cached value of the '{@link #getSolvedProblem() <em>Solved Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolvedProblem()
	 * @generated
	 * @ordered
	 */
	protected ScientificProblem solvedProblem;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
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
	 * The cached value of the '{@link #getMathematicalModel() <em>Mathematical Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMathematicalModel()
	 * @generated
	 * @ordered
	 */
	protected MathematicalModel mathematicalModel;

	/**
	 * The cached value of the '{@link #getPerformance() <em>Performance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformance()
	 * @generated
	 * @ordered
	 */
	protected Performance performance;

	/**
	 * The default value of the '{@link #getTheory() <em>Theory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheory()
	 * @generated
	 * @ordered
	 */
	protected static final String THEORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTheory() <em>Theory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheory()
	 * @generated
	 * @ordered
	 */
	protected String theory = THEORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String algorithm = ALGORITHM_EDEFAULT;

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
	public KnowledgeSpace getContainingKnowledgeSpace() {
		if (eContainerFeatureID() != KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE)
			return null;
		return (KnowledgeSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSpace basicGetContainingKnowledgeSpace() {
		if (eContainerFeatureID() != KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE)
			return null;
		return (KnowledgeSpace) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingKnowledgeSpace(
			KnowledgeSpace newContainingKnowledgeSpace, NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newContainingKnowledgeSpace,
				KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingKnowledgeSpace(
			KnowledgeSpace newContainingKnowledgeSpace) {
		if (newContainingKnowledgeSpace != eInternalContainer()
				|| (eContainerFeatureID() != KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE && newContainingKnowledgeSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingKnowledgeSpace))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingKnowledgeSpace != null)
				msgs = ((InternalEObject) newContainingKnowledgeSpace)
						.eInverseAdd(
								this,
								KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_KNOWLEDGE,
								KnowledgeSpace.class, msgs);
			msgs = basicSetContainingKnowledgeSpace(
					newContainingKnowledgeSpace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE,
					newContainingKnowledgeSpace, newContainingKnowledgeSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificProblem getSolvedProblem() {
		if (solvedProblem != null && solvedProblem.eIsProxy()) {
			InternalEObject oldSolvedProblem = (InternalEObject) solvedProblem;
			solvedProblem = (ScientificProblem) eResolveProxy(oldSolvedProblem);
			if (solvedProblem != oldSolvedProblem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM,
							oldSolvedProblem, solvedProblem));
			}
		}
		return solvedProblem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificProblem basicGetSolvedProblem() {
		return solvedProblem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSolvedProblem(
			ScientificProblem newSolvedProblem, NotificationChain msgs) {
		ScientificProblem oldSolvedProblem = solvedProblem;
		solvedProblem = newSolvedProblem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM,
					oldSolvedProblem, newSolvedProblem);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolvedProblem(ScientificProblem newSolvedProblem) {
		if (newSolvedProblem != solvedProblem) {
			NotificationChain msgs = null;
			if (solvedProblem != null)
				msgs = ((InternalEObject) solvedProblem).eInverseRemove(this,
						KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS,
						ScientificProblem.class, msgs);
			if (newSolvedProblem != null)
				msgs = ((InternalEObject) newSolvedProblem).eInverseAdd(this,
						KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS,
						ScientificProblem.class, msgs);
			msgs = basicSetSolvedProblem(newSolvedProblem, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM,
					newSolvedProblem, newSolvedProblem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assumption> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectWithInverseResolvingEList<Assumption>(
					Assumption.class, this,
					KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES,
					KnowledgePackage.ASSUMPTION__DEPENDING_METHOD);
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
			InternalEObject oldRealizingRequirement = (InternalEObject) realizingRequirement;
			realizingRequirement = (Requirement) eResolveProxy(oldRealizingRequirement);
			if (realizingRequirement != oldRealizingRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT,
							oldRealizingRequirement, realizingRequirement));
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
	public NotificationChain basicSetRealizingRequirement(
			Requirement newRealizingRequirement, NotificationChain msgs) {
		Requirement oldRealizingRequirement = realizingRequirement;
		realizingRequirement = newRealizingRequirement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT,
					oldRealizingRequirement, newRealizingRequirement);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
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
				msgs = ((InternalEObject) realizingRequirement).eInverseRemove(
						this, RequirementsPackage.REQUIREMENT__REALIZED_METHOD,
						Requirement.class, msgs);
			if (newRealizingRequirement != null)
				msgs = ((InternalEObject) newRealizingRequirement).eInverseAdd(
						this, RequirementsPackage.REQUIREMENT__REALIZED_METHOD,
						Requirement.class, msgs);
			msgs = basicSetRealizingRequirement(newRealizingRequirement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT,
					newRealizingRequirement, newRealizingRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModel getMathematicalModel() {
		if (mathematicalModel != null && mathematicalModel.eIsProxy()) {
			InternalEObject oldMathematicalModel = (InternalEObject) mathematicalModel;
			mathematicalModel = (MathematicalModel) eResolveProxy(oldMathematicalModel);
			if (mathematicalModel != oldMathematicalModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL,
							oldMathematicalModel, mathematicalModel));
			}
		}
		return mathematicalModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModel basicGetMathematicalModel() {
		return mathematicalModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMathematicalModel(
			MathematicalModel newMathematicalModel, NotificationChain msgs) {
		MathematicalModel oldMathematicalModel = mathematicalModel;
		mathematicalModel = newMathematicalModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL,
					oldMathematicalModel, newMathematicalModel);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMathematicalModel(MathematicalModel newMathematicalModel) {
		if (newMathematicalModel != mathematicalModel) {
			NotificationChain msgs = null;
			if (mathematicalModel != null)
				msgs = ((InternalEObject) mathematicalModel).eInverseRemove(
						this,
						KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS,
						MathematicalModel.class, msgs);
			if (newMathematicalModel != null)
				msgs = ((InternalEObject) newMathematicalModel).eInverseAdd(
						this,
						KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS,
						MathematicalModel.class, msgs);
			msgs = basicSetMathematicalModel(newMathematicalModel, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL,
					newMathematicalModel, newMathematicalModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Performance getPerformance() {
		if (performance != null && performance.eIsProxy()) {
			InternalEObject oldPerformance = (InternalEObject) performance;
			performance = (Performance) eResolveProxy(oldPerformance);
			if (performance != oldPerformance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE,
							oldPerformance, performance));
			}
		}
		return performance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Performance basicGetPerformance() {
		return performance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPerformance(Performance newPerformance,
			NotificationChain msgs) {
		Performance oldPerformance = performance;
		performance = newPerformance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE,
					oldPerformance, newPerformance);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerformance(Performance newPerformance) {
		if (newPerformance != performance) {
			NotificationChain msgs = null;
			if (performance != null)
				msgs = ((InternalEObject) performance).eInverseRemove(this,
						RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD,
						Performance.class, msgs);
			if (newPerformance != null)
				msgs = ((InternalEObject) newPerformance).eInverseAdd(this,
						RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD,
						Performance.class, msgs);
			msgs = basicSetPerformance(newPerformance, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE,
					newPerformance, newPerformance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTheory() {
		return theory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheory(String newTheory) {
		String oldTheory = theory;
		theory = newTheory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__THEORY, oldTheory,
					theory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.NUMERICAL_METHOD__ALGORITHM, oldAlgorithm,
					algorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingKnowledgeSpace((KnowledgeSpace) otherEnd,
					msgs);
		case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
			if (solvedProblem != null)
				msgs = ((InternalEObject) solvedProblem).eInverseRemove(this,
						KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS,
						ScientificProblem.class, msgs);
			return basicSetSolvedProblem((ScientificProblem) otherEnd, msgs);
		case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependencies())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
			if (realizingRequirement != null)
				msgs = ((InternalEObject) realizingRequirement).eInverseRemove(
						this, RequirementsPackage.REQUIREMENT__REALIZED_METHOD,
						Requirement.class, msgs);
			return basicSetRealizingRequirement((Requirement) otherEnd, msgs);
		case KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL:
			if (mathematicalModel != null)
				msgs = ((InternalEObject) mathematicalModel).eInverseRemove(
						this,
						KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS,
						MathematicalModel.class, msgs);
			return basicSetMathematicalModel((MathematicalModel) otherEnd, msgs);
		case KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE:
			if (performance != null)
				msgs = ((InternalEObject) performance).eInverseRemove(this,
						RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD,
						Performance.class, msgs);
			return basicSetPerformance((Performance) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE:
			return basicSetContainingKnowledgeSpace(null, msgs);
		case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
			return basicSetSolvedProblem(null, msgs);
		case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
			return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd,
					msgs);
		case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
			return basicSetRealizingRequirement(null, msgs);
		case KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL:
			return basicSetMathematicalModel(null, msgs);
		case KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE:
			return basicSetPerformance(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_KNOWLEDGE,
							KnowledgeSpace.class, msgs);
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
		case KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE:
			if (resolve)
				return getContainingKnowledgeSpace();
			return basicGetContainingKnowledgeSpace();
		case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
			if (resolve)
				return getSolvedProblem();
			return basicGetSolvedProblem();
		case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
			return getDependencies();
		case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
			if (resolve)
				return getRealizingRequirement();
			return basicGetRealizingRequirement();
		case KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL:
			if (resolve)
				return getMathematicalModel();
			return basicGetMathematicalModel();
		case KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE:
			if (resolve)
				return getPerformance();
			return basicGetPerformance();
		case KnowledgePackage.NUMERICAL_METHOD__THEORY:
			return getTheory();
		case KnowledgePackage.NUMERICAL_METHOD__ALGORITHM:
			return getAlgorithm();
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
		case KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE:
			setContainingKnowledgeSpace((KnowledgeSpace) newValue);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
			setSolvedProblem((ScientificProblem) newValue);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll(
					(Collection<? extends Assumption>) newValue);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
			setRealizingRequirement((Requirement) newValue);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL:
			setMathematicalModel((MathematicalModel) newValue);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE:
			setPerformance((Performance) newValue);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__THEORY:
			setTheory((String) newValue);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__ALGORITHM:
			setAlgorithm((String) newValue);
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
		case KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE:
			setContainingKnowledgeSpace((KnowledgeSpace) null);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
			setSolvedProblem((ScientificProblem) null);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
			getDependencies().clear();
			return;
		case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
			setRealizingRequirement((Requirement) null);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL:
			setMathematicalModel((MathematicalModel) null);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE:
			setPerformance((Performance) null);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__THEORY:
			setTheory(THEORY_EDEFAULT);
			return;
		case KnowledgePackage.NUMERICAL_METHOD__ALGORITHM:
			setAlgorithm(ALGORITHM_EDEFAULT);
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
		case KnowledgePackage.NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE:
			return basicGetContainingKnowledgeSpace() != null;
		case KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM:
			return solvedProblem != null;
		case KnowledgePackage.NUMERICAL_METHOD__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		case KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT:
			return realizingRequirement != null;
		case KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL:
			return mathematicalModel != null;
		case KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE:
			return performance != null;
		case KnowledgePackage.NUMERICAL_METHOD__THEORY:
			return THEORY_EDEFAULT == null ? theory != null : !THEORY_EDEFAULT
					.equals(theory);
		case KnowledgePackage.NUMERICAL_METHOD__ALGORITHM:
			return ALGORITHM_EDEFAULT == null ? algorithm != null
					: !ALGORITHM_EDEFAULT.equals(algorithm);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (theory: ");
		result.append(theory);
		result.append(", algorithm: ");
		result.append(algorithm);
		result.append(')');
		return result.toString();
	}

} //NumericalMethodImpl
