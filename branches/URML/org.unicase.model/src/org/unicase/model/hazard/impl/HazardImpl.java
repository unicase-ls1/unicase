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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.hazard.Hazard;
import org.unicase.model.hazard.HazardCause;
import org.unicase.model.hazard.HazardPackage;
import org.unicase.model.hazard.Mitigation;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.requirement.Actor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Hazard</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.hazard.impl.HazardImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.unicase.model.hazard.impl.HazardImpl#getInvolvedClasses <em>Involved Classes</em>}</li>
 *   <li>{@link org.unicase.model.hazard.impl.HazardImpl#getTargetedActors <em>Targeted Actors</em>}</li>
 *   <li>{@link org.unicase.model.hazard.impl.HazardImpl#getCauses <em>Causes</em>}</li>
 *   <li>{@link org.unicase.model.hazard.impl.HazardImpl#getMitigations <em>Mitigations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HazardImpl extends ModelElementImpl implements Hazard {
	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final int SEVERITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected int severity = SEVERITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInvolvedClasses() <em>Involved Classes</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInvolvedClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.unicase.model.classes.Class> involvedClasses;

	/**
	 * The cached value of the '{@link #getTargetedActors() <em>Targeted Actors</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetedActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> targetedActors;

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
	protected HazardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HazardPackage.Literals.HAZARD;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(int newSeverity) {
		int oldSeverity = severity;
		severity = newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HazardPackage.HAZARD__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.unicase.model.classes.Class> getInvolvedClasses() {
		if (involvedClasses == null) {
			involvedClasses = new EObjectResolvingEList<org.unicase.model.classes.Class>(
				org.unicase.model.classes.Class.class, this, HazardPackage.HAZARD__INVOLVED_CLASSES);
		}
		return involvedClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getTargetedActors() {
		if (targetedActors == null) {
			targetedActors = new EObjectResolvingEList<Actor>(Actor.class, this, HazardPackage.HAZARD__TARGETED_ACTORS);
		}
		return targetedActors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HazardCause> getCauses() {
		if (causes == null) {
			causes = new EObjectWithInverseResolvingEList.ManyInverse<HazardCause>(HazardCause.class, this,
				HazardPackage.HAZARD__CAUSES, HazardPackage.HAZARD_CAUSE__HAZARDS);
		}
		return causes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mitigation> getMitigations() {
		if (mitigations == null) {
			mitigations = new EObjectWithInverseResolvingEList.ManyInverse<Mitigation>(Mitigation.class, this,
				HazardPackage.HAZARD__MITIGATIONS, HazardPackage.MITIGATION__HAZARDS);
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
		case HazardPackage.HAZARD__CAUSES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getCauses()).basicAdd(otherEnd, msgs);
		case HazardPackage.HAZARD__MITIGATIONS:
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
		case HazardPackage.HAZARD__CAUSES:
			return ((InternalEList<?>) getCauses()).basicRemove(otherEnd, msgs);
		case HazardPackage.HAZARD__MITIGATIONS:
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
		case HazardPackage.HAZARD__SEVERITY:
			return getSeverity();
		case HazardPackage.HAZARD__INVOLVED_CLASSES:
			return getInvolvedClasses();
		case HazardPackage.HAZARD__TARGETED_ACTORS:
			return getTargetedActors();
		case HazardPackage.HAZARD__CAUSES:
			return getCauses();
		case HazardPackage.HAZARD__MITIGATIONS:
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
		case HazardPackage.HAZARD__SEVERITY:
			setSeverity((Integer) newValue);
			return;
		case HazardPackage.HAZARD__INVOLVED_CLASSES:
			getInvolvedClasses().clear();
			getInvolvedClasses().addAll((Collection<? extends org.unicase.model.classes.Class>) newValue);
			return;
		case HazardPackage.HAZARD__TARGETED_ACTORS:
			getTargetedActors().clear();
			getTargetedActors().addAll((Collection<? extends Actor>) newValue);
			return;
		case HazardPackage.HAZARD__CAUSES:
			getCauses().clear();
			getCauses().addAll((Collection<? extends HazardCause>) newValue);
			return;
		case HazardPackage.HAZARD__MITIGATIONS:
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
		case HazardPackage.HAZARD__SEVERITY:
			setSeverity(SEVERITY_EDEFAULT);
			return;
		case HazardPackage.HAZARD__INVOLVED_CLASSES:
			getInvolvedClasses().clear();
			return;
		case HazardPackage.HAZARD__TARGETED_ACTORS:
			getTargetedActors().clear();
			return;
		case HazardPackage.HAZARD__CAUSES:
			getCauses().clear();
			return;
		case HazardPackage.HAZARD__MITIGATIONS:
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
		case HazardPackage.HAZARD__SEVERITY:
			return severity != SEVERITY_EDEFAULT;
		case HazardPackage.HAZARD__INVOLVED_CLASSES:
			return involvedClasses != null && !involvedClasses.isEmpty();
		case HazardPackage.HAZARD__TARGETED_ACTORS:
			return targetedActors != null && !targetedActors.isEmpty();
		case HazardPackage.HAZARD__CAUSES:
			return causes != null && !causes.isEmpty();
		case HazardPackage.HAZARD__MITIGATIONS:
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
		result.append(" (severity: ");
		result.append(severity);
		result.append(')');
		return result.toString();
	}

} // HazardImpl
