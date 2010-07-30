/**
 * <copyright> </copyright> $Id$
 */
package urml.feature.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.urml.impl.UrmlModelElementImpl;

import urml.feature.FeaturePackage;
import urml.feature.Product;
import urml.feature.VariationPointInstance;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Product</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link urml.feature.impl.ProductImpl#getVariationPointInstances <em>Variation Point Instances</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProductImpl extends UrmlModelElementImpl implements Product {
	/**
	 * The cached value of the '{@link #getVariationPointInstances() <em>Variation Point Instances</em>}' reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVariationPointInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationPointInstance> variationPointInstances;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProductImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturePackage.Literals.PRODUCT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VariationPointInstance> getVariationPointInstances() {
		if (variationPointInstances == null) {
			variationPointInstances = new EObjectWithInverseResolvingEList<VariationPointInstance>(
				VariationPointInstance.class, this, FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES,
				FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT);
		}
		return variationPointInstances;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getVariationPointInstances()).basicAdd(
				otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES:
			return ((InternalEList<?>) getVariationPointInstances()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES:
			return getVariationPointInstances();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES:
			getVariationPointInstances().clear();
			getVariationPointInstances().addAll((Collection<? extends VariationPointInstance>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES:
			getVariationPointInstances().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES:
			return variationPointInstances != null && !variationPointInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ProductImpl
