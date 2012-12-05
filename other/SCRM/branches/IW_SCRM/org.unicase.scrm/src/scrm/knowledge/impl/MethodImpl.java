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
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.impl.SCRMModelElementImpl;
import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.Method;
import scrm.knowledge.Model;
import scrm.knowledge.ScientificProblem;
import scrm.requirements.Performance;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.MethodImpl#getSolvedProblem <em>Solved Problem</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MethodImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MethodImpl#getRealizingRequirement <em>Realizing Requirement</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MethodImpl#getUsingModel <em>Using Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MethodImpl#getPerformance <em>Performance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodImpl extends SCRMModelElementImpl implements Method {
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
	 * The cached value of the '{@link #getUsingModel() <em>Using Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsingModel()
	 * @generated
	 * @ordered
	 */
	protected Model usingModel;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KnowledgePackage.Literals.METHOD;
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
							KnowledgePackage.METHOD__SOLVED_PROBLEM,
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
					Notification.SET, KnowledgePackage.METHOD__SOLVED_PROBLEM,
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
					KnowledgePackage.METHOD__SOLVED_PROBLEM, newSolvedProblem,
					newSolvedProblem));
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
					KnowledgePackage.METHOD__DEPENDENCIES,
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KnowledgePackage.METHOD__REALIZING_REQUIREMENT,
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
					KnowledgePackage.METHOD__REALIZING_REQUIREMENT,
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
					KnowledgePackage.METHOD__REALIZING_REQUIREMENT,
					newRealizingRequirement, newRealizingRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getUsingModel() {
		if (usingModel != null && usingModel.eIsProxy()) {
			InternalEObject oldUsingModel = (InternalEObject) usingModel;
			usingModel = (Model) eResolveProxy(oldUsingModel);
			if (usingModel != oldUsingModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KnowledgePackage.METHOD__USING_MODEL,
							oldUsingModel, usingModel));
			}
		}
		return usingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetUsingModel() {
		return usingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsingModel(Model newUsingModel,
			NotificationChain msgs) {
		Model oldUsingModel = usingModel;
		usingModel = newUsingModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, KnowledgePackage.METHOD__USING_MODEL,
					oldUsingModel, newUsingModel);
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
	public void setUsingModel(Model newUsingModel) {
		if (newUsingModel != usingModel) {
			NotificationChain msgs = null;
			if (usingModel != null)
				msgs = ((InternalEObject) usingModel).eInverseRemove(this,
						KnowledgePackage.MODEL__USED_IN_METHODS, Model.class,
						msgs);
			if (newUsingModel != null)
				msgs = ((InternalEObject) newUsingModel).eInverseAdd(this,
						KnowledgePackage.MODEL__USED_IN_METHODS, Model.class,
						msgs);
			msgs = basicSetUsingModel(newUsingModel, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.METHOD__USING_MODEL, newUsingModel,
					newUsingModel));
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
							KnowledgePackage.METHOD__PERFORMANCE,
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
	public void setPerformance(Performance newPerformance) {
		Performance oldPerformance = performance;
		performance = newPerformance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.METHOD__PERFORMANCE, oldPerformance,
					performance));
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
		case KnowledgePackage.METHOD__SOLVED_PROBLEM:
			if (solvedProblem != null)
				msgs = ((InternalEObject) solvedProblem).eInverseRemove(this,
						KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS,
						ScientificProblem.class, msgs);
			return basicSetSolvedProblem((ScientificProblem) otherEnd, msgs);
		case KnowledgePackage.METHOD__DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependencies())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.METHOD__REALIZING_REQUIREMENT:
			if (realizingRequirement != null)
				msgs = ((InternalEObject) realizingRequirement).eInverseRemove(
						this, RequirementsPackage.REQUIREMENT__REALIZED_METHOD,
						Requirement.class, msgs);
			return basicSetRealizingRequirement((Requirement) otherEnd, msgs);
		case KnowledgePackage.METHOD__USING_MODEL:
			if (usingModel != null)
				msgs = ((InternalEObject) usingModel).eInverseRemove(this,
						KnowledgePackage.MODEL__USED_IN_METHODS, Model.class,
						msgs);
			return basicSetUsingModel((Model) otherEnd, msgs);
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
		case KnowledgePackage.METHOD__SOLVED_PROBLEM:
			return basicSetSolvedProblem(null, msgs);
		case KnowledgePackage.METHOD__DEPENDENCIES:
			return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd,
					msgs);
		case KnowledgePackage.METHOD__REALIZING_REQUIREMENT:
			return basicSetRealizingRequirement(null, msgs);
		case KnowledgePackage.METHOD__USING_MODEL:
			return basicSetUsingModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KnowledgePackage.METHOD__SOLVED_PROBLEM:
			if (resolve)
				return getSolvedProblem();
			return basicGetSolvedProblem();
		case KnowledgePackage.METHOD__DEPENDENCIES:
			return getDependencies();
		case KnowledgePackage.METHOD__REALIZING_REQUIREMENT:
			if (resolve)
				return getRealizingRequirement();
			return basicGetRealizingRequirement();
		case KnowledgePackage.METHOD__USING_MODEL:
			if (resolve)
				return getUsingModel();
			return basicGetUsingModel();
		case KnowledgePackage.METHOD__PERFORMANCE:
			if (resolve)
				return getPerformance();
			return basicGetPerformance();
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
		case KnowledgePackage.METHOD__SOLVED_PROBLEM:
			setSolvedProblem((ScientificProblem) newValue);
			return;
		case KnowledgePackage.METHOD__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll(
					(Collection<? extends Assumption>) newValue);
			return;
		case KnowledgePackage.METHOD__REALIZING_REQUIREMENT:
			setRealizingRequirement((Requirement) newValue);
			return;
		case KnowledgePackage.METHOD__USING_MODEL:
			setUsingModel((Model) newValue);
			return;
		case KnowledgePackage.METHOD__PERFORMANCE:
			setPerformance((Performance) newValue);
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
		case KnowledgePackage.METHOD__SOLVED_PROBLEM:
			setSolvedProblem((ScientificProblem) null);
			return;
		case KnowledgePackage.METHOD__DEPENDENCIES:
			getDependencies().clear();
			return;
		case KnowledgePackage.METHOD__REALIZING_REQUIREMENT:
			setRealizingRequirement((Requirement) null);
			return;
		case KnowledgePackage.METHOD__USING_MODEL:
			setUsingModel((Model) null);
			return;
		case KnowledgePackage.METHOD__PERFORMANCE:
			setPerformance((Performance) null);
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
		case KnowledgePackage.METHOD__SOLVED_PROBLEM:
			return solvedProblem != null;
		case KnowledgePackage.METHOD__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		case KnowledgePackage.METHOD__REALIZING_REQUIREMENT:
			return realizingRequirement != null;
		case KnowledgePackage.METHOD__USING_MODEL:
			return usingModel != null;
		case KnowledgePackage.METHOD__PERFORMANCE:
			return performance != null;
		}
		return super.eIsSet(featureID);
	}

} //MethodImpl
