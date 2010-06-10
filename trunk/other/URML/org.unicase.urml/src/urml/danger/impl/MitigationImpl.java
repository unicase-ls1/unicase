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

import urml.danger.Danger;
import urml.danger.DangerPackage;
import urml.danger.Mitigation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mitigation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.danger.impl.MitigationImpl#getMitigatedDangers <em>Mitigated Dangers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MitigationImpl extends UrmlModelElementImpl implements Mitigation {
	/**
	 * The cached value of the '{@link #getMitigatedDangers() <em>Mitigated Dangers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMitigatedDangers()
	 * @generated
	 * @ordered
	 */
	protected EList<Danger> mitigatedDangers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MitigationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DangerPackage.Literals.MITIGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Danger> getMitigatedDangers() {
		if (mitigatedDangers == null) {
			mitigatedDangers = new EObjectWithInverseResolvingEList.ManyInverse<Danger>(Danger.class, this,
				DangerPackage.MITIGATION__MITIGATED_DANGERS, DangerPackage.DANGER__MITIGATIONS);
		}
		return mitigatedDangers;
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
		case DangerPackage.MITIGATION__MITIGATED_DANGERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getMitigatedDangers()).basicAdd(otherEnd, msgs);
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
		case DangerPackage.MITIGATION__MITIGATED_DANGERS:
			return ((InternalEList<?>) getMitigatedDangers()).basicRemove(otherEnd, msgs);
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
		case DangerPackage.MITIGATION__MITIGATED_DANGERS:
			return getMitigatedDangers();
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
		case DangerPackage.MITIGATION__MITIGATED_DANGERS:
			getMitigatedDangers().clear();
			getMitigatedDangers().addAll((Collection<? extends Danger>) newValue);
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
		case DangerPackage.MITIGATION__MITIGATED_DANGERS:
			getMitigatedDangers().clear();
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
		case DangerPackage.MITIGATION__MITIGATED_DANGERS:
			return mitigatedDangers != null && !mitigatedDangers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MitigationImpl
