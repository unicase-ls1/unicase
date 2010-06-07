/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
 *   <li>{@link urml.danger.impl.AssetImpl#getEndangeredBy <em>Endangered By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AssetImpl extends UrmlModelElementImpl implements Asset {
	/**
	 * The cached value of the '{@link #getEndangeredBy() <em>Endangered By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndangeredBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Danger> endangeredBy;

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
	public EList<Danger> getEndangeredBy() {
		if (endangeredBy == null) {
			endangeredBy = new EObjectWithInverseResolvingEList.ManyInverse<Danger>(
					Danger.class, this, DangerPackage.ASSET__ENDANGERED_BY,
					DangerPackage.DANGER__HARMED_ASSETS);
		}
		return endangeredBy;
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
		case DangerPackage.ASSET__ENDANGERED_BY:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getEndangeredBy())
					.basicAdd(otherEnd, msgs);
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
		case DangerPackage.ASSET__ENDANGERED_BY:
			return ((InternalEList<?>) getEndangeredBy()).basicRemove(otherEnd,
					msgs);
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
		case DangerPackage.ASSET__ENDANGERED_BY:
			return getEndangeredBy();
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
		case DangerPackage.ASSET__ENDANGERED_BY:
			getEndangeredBy().clear();
			getEndangeredBy().addAll((Collection<? extends Danger>) newValue);
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
		case DangerPackage.ASSET__ENDANGERED_BY:
			getEndangeredBy().clear();
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
		case DangerPackage.ASSET__ENDANGERED_BY:
			return endangeredBy != null && !endangeredBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AssetImpl
