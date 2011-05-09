/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.urml.feature.Feature;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.Product;
import org.unicase.model.urml.feature.VariationPointInstance;
import org.unicase.model.urml.impl.UrmlModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Product</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.urml.feature.impl.ProductImpl#getVariationPointInstances <em>Variation Point Instances
 * </em>}</li>
 * <li>{@link org.unicase.model.urml.feature.impl.ProductImpl#getFeatures <em>Features</em>}</li>
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
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

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
			variationPointInstances = new EObjectWithInverseResolvingEList.ManyInverse<VariationPointInstance>(
				VariationPointInstance.class, this, FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES,
				FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCTS);
		}
		return variationPointInstances;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectWithInverseResolvingEList.ManyInverse<Feature>(Feature.class, this,
				FeaturePackage.PRODUCT__FEATURES, FeaturePackage.FEATURE__PRODUCTS);
		}
		return features;
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
		case FeaturePackage.PRODUCT__FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getFeatures()).basicAdd(otherEnd, msgs);
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
		case FeaturePackage.PRODUCT__FEATURES:
			return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd, msgs);
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
		case FeaturePackage.PRODUCT__FEATURES:
			return getFeatures();
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
		case FeaturePackage.PRODUCT__FEATURES:
			getFeatures().clear();
			getFeatures().addAll((Collection<? extends Feature>) newValue);
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
		case FeaturePackage.PRODUCT__FEATURES:
			getFeatures().clear();
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
		case FeaturePackage.PRODUCT__FEATURES:
			return features != null && !features.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ProductImpl
