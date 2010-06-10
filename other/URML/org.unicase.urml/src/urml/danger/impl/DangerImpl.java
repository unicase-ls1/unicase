/**
 * <copyright> </copyright> $Id$
 */
package urml.danger.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.urml.impl.UrmlModelElementImpl;

import urml.danger.Asset;
import urml.danger.Danger;
import urml.danger.DangerPackage;
import urml.danger.Mitigation;

import urml.usecase.Actor;
import urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Danger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.danger.impl.DangerImpl#getTriggeringActors <em>Triggering Actors</em>}</li>
 *   <li>{@link urml.danger.impl.DangerImpl#getHarmedAssets <em>Harmed Assets</em>}</li>
 *   <li>{@link urml.danger.impl.DangerImpl#getMitigations <em>Mitigations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DangerImpl extends UrmlModelElementImpl implements Danger {
	/**
	 * The cached value of the '{@link #getTriggeringActors() <em>Triggering Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggeringActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> triggeringActors;

	/**
	 * The cached value of the '{@link #getHarmedAssets() <em>Harmed Assets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHarmedAssets()
	 * @generated
	 * @ordered
	 */
	protected EList<Asset> harmedAssets;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DangerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DangerPackage.Literals.DANGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getTriggeringActors() {
		if (triggeringActors == null) {
			triggeringActors = new EObjectWithInverseResolvingEList.ManyInverse<Actor>(Actor.class, this,
				DangerPackage.DANGER__TRIGGERING_ACTORS, UsecasePackage.ACTOR__TRIGGERED_DANGERS);
		}
		return triggeringActors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Asset> getHarmedAssets() {
		if (harmedAssets == null) {
			harmedAssets = new EObjectWithInverseResolvingEList.ManyInverse<Asset>(Asset.class, this,
				DangerPackage.DANGER__HARMED_ASSETS, DangerPackage.ASSET__ENDANGERED_BY);
		}
		return harmedAssets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mitigation> getMitigations() {
		if (mitigations == null) {
			mitigations = new EObjectWithInverseResolvingEList.ManyInverse<Mitigation>(Mitigation.class, this,
				DangerPackage.DANGER__MITIGATIONS, DangerPackage.MITIGATION__MITIGATED_DANGERS);
		}
		return mitigations;
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
		case DangerPackage.DANGER__TRIGGERING_ACTORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getTriggeringActors()).basicAdd(otherEnd, msgs);
		case DangerPackage.DANGER__HARMED_ASSETS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getHarmedAssets()).basicAdd(otherEnd, msgs);
		case DangerPackage.DANGER__MITIGATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getMitigations()).basicAdd(otherEnd, msgs);
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
		case DangerPackage.DANGER__TRIGGERING_ACTORS:
			return ((InternalEList<?>) getTriggeringActors()).basicRemove(otherEnd, msgs);
		case DangerPackage.DANGER__HARMED_ASSETS:
			return ((InternalEList<?>) getHarmedAssets()).basicRemove(otherEnd, msgs);
		case DangerPackage.DANGER__MITIGATIONS:
			return ((InternalEList<?>) getMitigations()).basicRemove(otherEnd, msgs);
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
		case DangerPackage.DANGER__TRIGGERING_ACTORS:
			return getTriggeringActors();
		case DangerPackage.DANGER__HARMED_ASSETS:
			return getHarmedAssets();
		case DangerPackage.DANGER__MITIGATIONS:
			return getMitigations();
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
		case DangerPackage.DANGER__TRIGGERING_ACTORS:
			getTriggeringActors().clear();
			getTriggeringActors().addAll((Collection<? extends Actor>) newValue);
			return;
		case DangerPackage.DANGER__HARMED_ASSETS:
			getHarmedAssets().clear();
			getHarmedAssets().addAll((Collection<? extends Asset>) newValue);
			return;
		case DangerPackage.DANGER__MITIGATIONS:
			getMitigations().clear();
			getMitigations().addAll((Collection<? extends Mitigation>) newValue);
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
		case DangerPackage.DANGER__TRIGGERING_ACTORS:
			getTriggeringActors().clear();
			return;
		case DangerPackage.DANGER__HARMED_ASSETS:
			getHarmedAssets().clear();
			return;
		case DangerPackage.DANGER__MITIGATIONS:
			getMitigations().clear();
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
		case DangerPackage.DANGER__TRIGGERING_ACTORS:
			return triggeringActors != null && !triggeringActors.isEmpty();
		case DangerPackage.DANGER__HARMED_ASSETS:
			return harmedAssets != null && !harmedAssets.isEmpty();
		case DangerPackage.DANGER__MITIGATIONS:
			return mitigations != null && !mitigations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DangerImpl
