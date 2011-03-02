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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;

import scrm.requirements.Feature;
import scrm.requirements.IRequirement;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scientific Problem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.ScientificProblemImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ScientificProblemImpl#getRepresentingModel <em>Representing Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ScientificProblemImpl#getSolvingMethod <em>Solving Method</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ScientificProblemImpl#getInfluencedFeature <em>Influenced Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScientificProblemImpl extends EObjectImpl implements ScientificProblem {
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
	 * The cached value of the '{@link #getRepresentingModel() <em>Representing Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentingModel()
	 * @generated
	 * @ordered
	 */
	protected MathematicalModel representingModel;

	/**
	 * The cached value of the '{@link #getSolvingMethod() <em>Solving Method</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolvingMethod()
	 * @generated
	 * @ordered
	 */
	protected NumericalMethod solvingMethod;

	/**
	 * The cached value of the '{@link #getInfluencedFeature() <em>Influenced Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluencedFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature influencedFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScientificProblemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KnowledgePackage.Literals.SCIENTIFIC_PROBLEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectWithInverseResolvingEList.ManyInverse<IRequirement>(IRequirement.class, this, KnowledgePackage.SCIENTIFIC_PROBLEM__REQUIREMENTS, RequirementsPackage.IREQUIREMENT__USED_KNOWLEDGE);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModel getRepresentingModel() {
		return representingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepresentingModel(MathematicalModel newRepresentingModel, NotificationChain msgs) {
		MathematicalModel oldRepresentingModel = representingModel;
		representingModel = newRepresentingModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL, oldRepresentingModel, newRepresentingModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentingModel(MathematicalModel newRepresentingModel) {
		if (newRepresentingModel != representingModel) {
			NotificationChain msgs = null;
			if (representingModel != null)
				msgs = ((InternalEObject)representingModel).eInverseRemove(this, KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM, MathematicalModel.class, msgs);
			if (newRepresentingModel != null)
				msgs = ((InternalEObject)newRepresentingModel).eInverseAdd(this, KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM, MathematicalModel.class, msgs);
			msgs = basicSetRepresentingModel(newRepresentingModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL, newRepresentingModel, newRepresentingModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod getSolvingMethod() {
		return solvingMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSolvingMethod(NumericalMethod newSolvingMethod, NotificationChain msgs) {
		NumericalMethod oldSolvingMethod = solvingMethod;
		solvingMethod = newSolvingMethod;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD, oldSolvingMethod, newSolvingMethod);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolvingMethod(NumericalMethod newSolvingMethod) {
		if (newSolvingMethod != solvingMethod) {
			NotificationChain msgs = null;
			if (solvingMethod != null)
				msgs = ((InternalEObject)solvingMethod).eInverseRemove(this, KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM, NumericalMethod.class, msgs);
			if (newSolvingMethod != null)
				msgs = ((InternalEObject)newSolvingMethod).eInverseAdd(this, KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM, NumericalMethod.class, msgs);
			msgs = basicSetSolvingMethod(newSolvingMethod, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD, newSolvingMethod, newSolvingMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getInfluencedFeature() {
		if (influencedFeature != null && influencedFeature.eIsProxy()) {
			InternalEObject oldInfluencedFeature = (InternalEObject)influencedFeature;
			influencedFeature = (Feature)eResolveProxy(oldInfluencedFeature);
			if (influencedFeature != oldInfluencedFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE, oldInfluencedFeature, influencedFeature));
			}
		}
		return influencedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetInfluencedFeature() {
		return influencedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfluencedFeature(Feature newInfluencedFeature) {
		Feature oldInfluencedFeature = influencedFeature;
		influencedFeature = newInfluencedFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE, oldInfluencedFeature, influencedFeature));
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
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequirements()).basicAdd(otherEnd, msgs);
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
				if (representingModel != null)
					msgs = ((InternalEObject)representingModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL, null, msgs);
				return basicSetRepresentingModel((MathematicalModel)otherEnd, msgs);
			case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD:
				if (solvingMethod != null)
					msgs = ((InternalEObject)solvingMethod).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD, null, msgs);
				return basicSetSolvingMethod((NumericalMethod)otherEnd, msgs);
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
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
				return basicSetRepresentingModel(null, msgs);
			case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD:
				return basicSetSolvingMethod(null, msgs);
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
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REQUIREMENTS:
				return getRequirements();
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
				return getRepresentingModel();
			case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD:
				return getSolvingMethod();
			case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
				if (resolve) return getInfluencedFeature();
				return basicGetInfluencedFeature();
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
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends IRequirement>)newValue);
				return;
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
				setRepresentingModel((MathematicalModel)newValue);
				return;
			case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD:
				setSolvingMethod((NumericalMethod)newValue);
				return;
			case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
				setInfluencedFeature((Feature)newValue);
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
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REQUIREMENTS:
				getRequirements().clear();
				return;
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
				setRepresentingModel((MathematicalModel)null);
				return;
			case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD:
				setSolvingMethod((NumericalMethod)null);
				return;
			case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
				setInfluencedFeature((Feature)null);
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
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
				return representingModel != null;
			case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHOD:
				return solvingMethod != null;
			case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
				return influencedFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //ScientificProblemImpl
