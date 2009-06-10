/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.hazard.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.ModelElement;
import org.unicase.model.hazard.EvalStatus;
import org.unicase.model.hazard.Hazard;
import org.unicase.model.hazard.HazardCause;
import org.unicase.model.hazard.HazardPackage;
import org.unicase.model.hazard.Mitigation;
import org.unicase.model.impl.ModelElementImpl;

/*
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cause</b></em>'. <!-- end-user-doc --> <p> The
 * following features are implemented: <ul> <li>{@link org.unicase.model.hazard.impl.HazardCauseImpl#getHazards
 * <em>Hazards</em>}</li> <li>{@link org.unicase.model.hazard.impl.HazardCauseImpl#getHazardousModelElements
 * <em>Hazardous Model Elements</em>}</li> <li>{@link org.unicase.model.hazard.impl.HazardCauseImpl#getEvaluationStatus
 * <em>Evaluation Status</em>}</li> <li>{@link org.unicase.model.hazard.impl.HazardCauseImpl#getLikelihood
 * <em>Likelihood</em>}</li> <li>{@link org.unicase.model.hazard.impl.HazardCauseImpl#getMitigations
 * <em>Mitigations</em>}</li> </ul> </p>
 * @generated
 */
public class HazardCauseImpl extends ModelElementImpl implements HazardCause {
	/**
	 * The cached value of the '{@link #getHazards() <em>Hazards</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getHazards()
	 * @generated
	 * @ordered
	 */
	protected EList<Hazard> hazards;

	/**
	 * The cached value of the '{@link #getHazardousModelElements() <em>Hazardous Model Elements</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHazardousModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElement> hazardousModelElements;

	/**
	 * The default value of the '{@link #getEvaluationStatus() <em>Evaluation Status</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEvaluationStatus()
	 * @generated
	 * @ordered
	 */
	protected static final EvalStatus EVALUATION_STATUS_EDEFAULT = EvalStatus.NEW;

	/**
	 * The cached value of the '{@link #getEvaluationStatus() <em>Evaluation Status</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEvaluationStatus()
	 * @generated
	 * @ordered
	 */
	protected EvalStatus evaluationStatus = EVALUATION_STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLikelihood() <em>Likelihood</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikelihood()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> likelihood;

	/**
	 * The cached value of the '{@link #getMitigations() <em>Mitigations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMitigations()
	 * @generated
	 * @ordered
	 */
	protected EList<Mitigation> mitigations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected HazardCauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HazardPackage.Literals.HAZARD_CAUSE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hazard> getHazards() {
		if (hazards == null) {
			hazards = new EObjectWithInverseResolvingEList.ManyInverse<Hazard>(Hazard.class, this,
				HazardPackage.HAZARD_CAUSE__HAZARDS, HazardPackage.HAZARD__CAUSES);
		}
		return hazards;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> getHazardousModelElements() {
		if (hazardousModelElements == null) {
			hazardousModelElements = new EObjectResolvingEList<ModelElement>(ModelElement.class, this,
				HazardPackage.HAZARD_CAUSE__HAZARDOUS_MODEL_ELEMENTS);
		}
		return hazardousModelElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EvalStatus getEvaluationStatus() {
		return evaluationStatus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvaluationStatus(EvalStatus newEvaluationStatus) {
		EvalStatus oldEvaluationStatus = evaluationStatus;
		evaluationStatus = newEvaluationStatus == null ? EVALUATION_STATUS_EDEFAULT : newEvaluationStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HazardPackage.HAZARD_CAUSE__EVALUATION_STATUS,
				oldEvaluationStatus, evaluationStatus));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getLikelihood() {
		if (likelihood == null) {
			likelihood = new EDataTypeUniqueEList<Integer>(Integer.class, this, HazardPackage.HAZARD_CAUSE__LIKELIHOOD);
		}
		return likelihood;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mitigation> getMitigations() {
		if (mitigations == null) {
			mitigations = new EObjectWithInverseResolvingEList.ManyInverse<Mitigation>(Mitigation.class, this,
				HazardPackage.HAZARD_CAUSE__MITIGATIONS, HazardPackage.MITIGATION__CAUSES);
		}
		return mitigations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case HazardPackage.HAZARD_CAUSE__HAZARDS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getHazards()).basicAdd(otherEnd, msgs);
		case HazardPackage.HAZARD_CAUSE__MITIGATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getMitigations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case HazardPackage.HAZARD_CAUSE__HAZARDS:
			return ((InternalEList<?>) getHazards()).basicRemove(otherEnd, msgs);
		case HazardPackage.HAZARD_CAUSE__MITIGATIONS:
			return ((InternalEList<?>) getMitigations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case HazardPackage.HAZARD_CAUSE__HAZARDS:
			return getHazards();
		case HazardPackage.HAZARD_CAUSE__HAZARDOUS_MODEL_ELEMENTS:
			return getHazardousModelElements();
		case HazardPackage.HAZARD_CAUSE__EVALUATION_STATUS:
			return getEvaluationStatus();
		case HazardPackage.HAZARD_CAUSE__LIKELIHOOD:
			return getLikelihood();
		case HazardPackage.HAZARD_CAUSE__MITIGATIONS:
			return getMitigations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case HazardPackage.HAZARD_CAUSE__HAZARDS:
			getHazards().clear();
			getHazards().addAll((Collection<? extends Hazard>) newValue);
			return;
		case HazardPackage.HAZARD_CAUSE__HAZARDOUS_MODEL_ELEMENTS:
			getHazardousModelElements().clear();
			getHazardousModelElements().addAll((Collection<? extends ModelElement>) newValue);
			return;
		case HazardPackage.HAZARD_CAUSE__EVALUATION_STATUS:
			setEvaluationStatus((EvalStatus) newValue);
			return;
		case HazardPackage.HAZARD_CAUSE__LIKELIHOOD:
			getLikelihood().clear();
			getLikelihood().addAll((Collection<? extends Integer>) newValue);
			return;
		case HazardPackage.HAZARD_CAUSE__MITIGATIONS:
			getMitigations().clear();
			getMitigations().addAll((Collection<? extends Mitigation>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case HazardPackage.HAZARD_CAUSE__HAZARDS:
			getHazards().clear();
			return;
		case HazardPackage.HAZARD_CAUSE__HAZARDOUS_MODEL_ELEMENTS:
			getHazardousModelElements().clear();
			return;
		case HazardPackage.HAZARD_CAUSE__EVALUATION_STATUS:
			setEvaluationStatus(EVALUATION_STATUS_EDEFAULT);
			return;
		case HazardPackage.HAZARD_CAUSE__LIKELIHOOD:
			getLikelihood().clear();
			return;
		case HazardPackage.HAZARD_CAUSE__MITIGATIONS:
			getMitigations().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case HazardPackage.HAZARD_CAUSE__HAZARDS:
			return hazards != null && !hazards.isEmpty();
		case HazardPackage.HAZARD_CAUSE__HAZARDOUS_MODEL_ELEMENTS:
			return hazardousModelElements != null && !hazardousModelElements.isEmpty();
		case HazardPackage.HAZARD_CAUSE__EVALUATION_STATUS:
			return evaluationStatus != EVALUATION_STATUS_EDEFAULT;
		case HazardPackage.HAZARD_CAUSE__LIKELIHOOD:
			return likelihood != null && !likelihood.isEmpty();
		case HazardPackage.HAZARD_CAUSE__MITIGATIONS:
			return mitigations != null && !mitigations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (evaluationStatus: ");
		result.append(evaluationStatus);
		result.append(", likelihood: ");
		result.append(likelihood);
		result.append(')');
		return result.toString();
	}

} // HazardCauseImpl
