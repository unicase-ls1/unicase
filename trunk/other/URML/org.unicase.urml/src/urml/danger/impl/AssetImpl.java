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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.danger.impl.AssetImpl#getTriggeredDangers <em>Triggered Dangers</em>}</li>
 *   <li>{@link urml.danger.impl.AssetImpl#getHarmingDangers <em>Harming Dangers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AssetImpl extends UrmlModelElementImpl implements Asset {
	/**
	 * The cached value of the '{@link #getTriggeredDangers() <em>Triggered Dangers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggeredDangers()
	 * @generated
	 * @ordered
	 */
	protected EList<Danger> triggeredDangers;

	/**
	 * The cached value of the '{@link #getHarmingDangers() <em>Harming Dangers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHarmingDangers()
	 * @generated
	 * @ordered
	 */
	protected EList<Danger> harmingDangers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DangerPackage.Literals.ASSET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Danger> getTriggeredDangers() {
		if (triggeredDangers == null) {
			triggeredDangers = new EObjectWithInverseResolvingEList.ManyInverse<Danger>(Danger.class, this,
				DangerPackage.ASSET__TRIGGERED_DANGERS, DangerPackage.DANGER__TRIGGERING_ASSETS);
		}
		return triggeredDangers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Danger> getHarmingDangers() {
		if (harmingDangers == null) {
			harmingDangers = new EObjectWithInverseResolvingEList.ManyInverse<Danger>(Danger.class, this,
				DangerPackage.ASSET__HARMING_DANGERS, DangerPackage.DANGER__HARMED_ASSETS);
		}
		return harmingDangers;
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
		case DangerPackage.ASSET__TRIGGERED_DANGERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getTriggeredDangers()).basicAdd(otherEnd, msgs);
		case DangerPackage.ASSET__HARMING_DANGERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getHarmingDangers()).basicAdd(otherEnd, msgs);
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
		case DangerPackage.ASSET__TRIGGERED_DANGERS:
			return ((InternalEList<?>) getTriggeredDangers()).basicRemove(otherEnd, msgs);
		case DangerPackage.ASSET__HARMING_DANGERS:
			return ((InternalEList<?>) getHarmingDangers()).basicRemove(otherEnd, msgs);
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
		case DangerPackage.ASSET__TRIGGERED_DANGERS:
			return getTriggeredDangers();
		case DangerPackage.ASSET__HARMING_DANGERS:
			return getHarmingDangers();
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
		case DangerPackage.ASSET__TRIGGERED_DANGERS:
			getTriggeredDangers().clear();
			getTriggeredDangers().addAll((Collection<? extends Danger>) newValue);
			return;
		case DangerPackage.ASSET__HARMING_DANGERS:
			getHarmingDangers().clear();
			getHarmingDangers().addAll((Collection<? extends Danger>) newValue);
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
		case DangerPackage.ASSET__TRIGGERED_DANGERS:
			getTriggeredDangers().clear();
			return;
		case DangerPackage.ASSET__HARMING_DANGERS:
			getHarmingDangers().clear();
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
		case DangerPackage.ASSET__TRIGGERED_DANGERS:
			return triggeredDangers != null && !triggeredDangers.isEmpty();
		case DangerPackage.ASSET__HARMING_DANGERS:
			return harmingDangers != null && !harmingDangers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AssetImpl
