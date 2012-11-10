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
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.Mathematical_GeophysicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;
import scrm.requirements.Feature;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scientific Problem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.ScientificProblemImpl#getRepresentingModel <em>Representing Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ScientificProblemImpl#getSolvingMethods <em>Solving Methods</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ScientificProblemImpl#getInfluencedFeature <em>Influenced Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScientificProblemImpl extends SCRMModelElementImpl implements
		ScientificProblem {
	/**
	 * The cached value of the '{@link #getRepresentingModel() <em>Representing Model</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentingModel()
	 * @generated
	 * @ordered
	 */
	protected EList<Mathematical_GeophysicalModel> representingModel;

	/**
	 * The cached value of the '{@link #getSolvingMethods() <em>Solving Methods</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolvingMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<NumericalMethod> solvingMethods;

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
	public EList<Mathematical_GeophysicalModel> getRepresentingModel() {
		if (representingModel == null) {
			representingModel = new EObjectWithInverseResolvingEList<Mathematical_GeophysicalModel>(
					Mathematical_GeophysicalModel.class,
					this,
					KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM);
		}
		return representingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumericalMethod> getSolvingMethods() {
		if (solvingMethods == null) {
			solvingMethods = new EObjectWithInverseResolvingEList<NumericalMethod>(
					NumericalMethod.class, this,
					KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS,
					KnowledgePackage.NUMERICAL_METHOD__SOLVED_PROBLEM);
		}
		return solvingMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getInfluencedFeature() {
		if (influencedFeature != null && influencedFeature.eIsProxy()) {
			InternalEObject oldInfluencedFeature = (InternalEObject) influencedFeature;
			influencedFeature = (Feature) eResolveProxy(oldInfluencedFeature);
			if (influencedFeature != oldInfluencedFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE,
							oldInfluencedFeature, influencedFeature));
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
	public NotificationChain basicSetInfluencedFeature(
			Feature newInfluencedFeature, NotificationChain msgs) {
		Feature oldInfluencedFeature = influencedFeature;
		influencedFeature = newInfluencedFeature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE,
					oldInfluencedFeature, newInfluencedFeature);
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
	public void setInfluencedFeature(Feature newInfluencedFeature) {
		if (newInfluencedFeature != influencedFeature) {
			NotificationChain msgs = null;
			if (influencedFeature != null)
				msgs = ((InternalEObject) influencedFeature).eInverseRemove(
						this, RequirementsPackage.FEATURE__INFLUENCING_PROBLEM,
						Feature.class, msgs);
			if (newInfluencedFeature != null)
				msgs = ((InternalEObject) newInfluencedFeature).eInverseAdd(
						this, RequirementsPackage.FEATURE__INFLUENCING_PROBLEM,
						Feature.class, msgs);
			msgs = basicSetInfluencedFeature(newInfluencedFeature, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE,
					newInfluencedFeature, newInfluencedFeature));
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
		case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRepresentingModel())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSolvingMethods())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
			if (influencedFeature != null)
				msgs = ((InternalEObject) influencedFeature).eInverseRemove(
						this, RequirementsPackage.FEATURE__INFLUENCING_PROBLEM,
						Feature.class, msgs);
			return basicSetInfluencedFeature((Feature) otherEnd, msgs);
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
		case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
			return ((InternalEList<?>) getRepresentingModel()).basicRemove(
					otherEnd, msgs);
		case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS:
			return ((InternalEList<?>) getSolvingMethods()).basicRemove(
					otherEnd, msgs);
		case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
			return basicSetInfluencedFeature(null, msgs);
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
		case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
			return getRepresentingModel();
		case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS:
			return getSolvingMethods();
		case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
			if (resolve)
				return getInfluencedFeature();
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
		case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
			getRepresentingModel().clear();
			getRepresentingModel()
					.addAll((Collection<? extends Mathematical_GeophysicalModel>) newValue);
			return;
		case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS:
			getSolvingMethods().clear();
			getSolvingMethods().addAll(
					(Collection<? extends NumericalMethod>) newValue);
			return;
		case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
			setInfluencedFeature((Feature) newValue);
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
		case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
			getRepresentingModel().clear();
			return;
		case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS:
			getSolvingMethods().clear();
			return;
		case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
			setInfluencedFeature((Feature) null);
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
		case KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL:
			return representingModel != null && !representingModel.isEmpty();
		case KnowledgePackage.SCIENTIFIC_PROBLEM__SOLVING_METHODS:
			return solvingMethods != null && !solvingMethods.isEmpty();
		case KnowledgePackage.SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE:
			return influencedFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //ScientificProblemImpl
