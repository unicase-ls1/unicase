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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.hazard.EvalStatus;
import org.unicase.model.hazard.Hazard;
import org.unicase.model.hazard.HazardCause;
import org.unicase.model.hazard.HazardPackage;
import org.unicase.model.hazard.Mitigation;
import org.unicase.model.impl.ModelElementImpl;

/*
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Mitigation</b></em>'. <!-- end-user-doc --> <p>
 * The following features are implemented: <ul> <li>{@link org.unicase.model.hazard.impl.MitigationImpl#getTechnique
 * <em>Technique</em>}</li> <li>{@link org.unicase.model.hazard.impl.MitigationImpl#getEvaluationStatus <em>Evaluation
 * Status</em>}</li> <li>{@link org.unicase.model.hazard.impl.MitigationImpl#getCauses <em>Causes</em>}</li> <li>{@link
 * org.unicase.model.hazard.impl.MitigationImpl#getHazards <em>Hazards</em>}</li> </ul> </p>
 * @generated
 */
public class MitigationImpl extends ModelElementImpl implements Mitigation {
	/**
	 * The default value of the '{@link #getTechnique() <em>Technique</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTechnique()
	 * @generated
	 * @ordered
	 */
	protected static final String TECHNIQUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTechnique() <em>Technique</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTechnique()
	 * @generated
	 * @ordered
	 */
	protected String technique = TECHNIQUE_EDEFAULT;

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
	 * The cached value of the '{@link #getCauses() <em>Causes</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCauses()
	 * @generated
	 * @ordered
	 */
	protected EList<HazardCause> causes;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MitigationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HazardPackage.Literals.MITIGATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTechnique() {
		return technique;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTechnique(String newTechnique) {
		String oldTechnique = technique;
		technique = newTechnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HazardPackage.MITIGATION__TECHNIQUE, oldTechnique,
				technique));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HazardPackage.MITIGATION__EVALUATION_STATUS,
				oldEvaluationStatus, evaluationStatus));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HazardCause> getCauses() {
		if (causes == null) {
			causes = new EObjectWithInverseResolvingEList.ManyInverse<HazardCause>(HazardCause.class, this,
				HazardPackage.MITIGATION__CAUSES, HazardPackage.HAZARD_CAUSE__MITIGATIONS);
		}
		return causes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hazard> getHazards() {
		if (hazards == null) {
			hazards = new EObjectWithInverseResolvingEList.ManyInverse<Hazard>(Hazard.class, this,
				HazardPackage.MITIGATION__HAZARDS, HazardPackage.HAZARD__MITIGATIONS);
		}
		return hazards;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case HazardPackage.MITIGATION__CAUSES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getCauses()).basicAdd(otherEnd, msgs);
		case HazardPackage.MITIGATION__HAZARDS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getHazards()).basicAdd(otherEnd, msgs);
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
		case HazardPackage.MITIGATION__CAUSES:
			return ((InternalEList<?>) getCauses()).basicRemove(otherEnd, msgs);
		case HazardPackage.MITIGATION__HAZARDS:
			return ((InternalEList<?>) getHazards()).basicRemove(otherEnd, msgs);
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
		case HazardPackage.MITIGATION__TECHNIQUE:
			return getTechnique();
		case HazardPackage.MITIGATION__EVALUATION_STATUS:
			return getEvaluationStatus();
		case HazardPackage.MITIGATION__CAUSES:
			return getCauses();
		case HazardPackage.MITIGATION__HAZARDS:
			return getHazards();
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
		case HazardPackage.MITIGATION__TECHNIQUE:
			setTechnique((String) newValue);
			return;
		case HazardPackage.MITIGATION__EVALUATION_STATUS:
			setEvaluationStatus((EvalStatus) newValue);
			return;
		case HazardPackage.MITIGATION__CAUSES:
			getCauses().clear();
			getCauses().addAll((Collection<? extends HazardCause>) newValue);
			return;
		case HazardPackage.MITIGATION__HAZARDS:
			getHazards().clear();
			getHazards().addAll((Collection<? extends Hazard>) newValue);
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
		case HazardPackage.MITIGATION__TECHNIQUE:
			setTechnique(TECHNIQUE_EDEFAULT);
			return;
		case HazardPackage.MITIGATION__EVALUATION_STATUS:
			setEvaluationStatus(EVALUATION_STATUS_EDEFAULT);
			return;
		case HazardPackage.MITIGATION__CAUSES:
			getCauses().clear();
			return;
		case HazardPackage.MITIGATION__HAZARDS:
			getHazards().clear();
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
		case HazardPackage.MITIGATION__TECHNIQUE:
			return TECHNIQUE_EDEFAULT == null ? technique != null : !TECHNIQUE_EDEFAULT.equals(technique);
		case HazardPackage.MITIGATION__EVALUATION_STATUS:
			return evaluationStatus != EVALUATION_STATUS_EDEFAULT;
		case HazardPackage.MITIGATION__CAUSES:
			return causes != null && !causes.isEmpty();
		case HazardPackage.MITIGATION__HAZARDS:
			return hazards != null && !hazards.isEmpty();
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
		result.append(" (technique: ");
		result.append(technique);
		result.append(", evaluationStatus: ");
		result.append(evaluationStatus);
		result.append(')');
		return result.toString();
	}

} // MitigationImpl
