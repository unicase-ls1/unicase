/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.urml.feature.Feature;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.Product;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.urml.feature.impl.FeatureImpl#getProducts <em>Products</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FeatureImpl extends AbstractFeatureImpl implements Feature {
	/**
	 * The cached value of the '{@link #getProducts() <em>Products</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProducts()
	 * @generated
	 * @ordered
	 */
	protected Product products;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturePackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Product getProducts() {
		if (products != null && products.eIsProxy()) {
			InternalEObject oldProducts = (InternalEObject) products;
			products = (Product) eResolveProxy(oldProducts);
			if (products != oldProducts) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturePackage.FEATURE__PRODUCTS,
						oldProducts, products));
			}
		}
		return products;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Product basicGetProducts() {
		return products;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProducts(Product newProducts, NotificationChain msgs) {
		Product oldProducts = products;
		products = newProducts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				FeaturePackage.FEATURE__PRODUCTS, oldProducts, newProducts);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProducts(Product newProducts) {
		if (newProducts != products) {
			NotificationChain msgs = null;
			if (products != null)
				msgs = ((InternalEObject) products).eInverseRemove(this, FeaturePackage.PRODUCT__FEATURES,
					Product.class, msgs);
			if (newProducts != null)
				msgs = ((InternalEObject) newProducts).eInverseAdd(this, FeaturePackage.PRODUCT__FEATURES,
					Product.class, msgs);
			msgs = basicSetProducts(newProducts, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.FEATURE__PRODUCTS, newProducts,
				newProducts));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FeaturePackage.FEATURE__PRODUCTS:
			if (products != null)
				msgs = ((InternalEObject) products).eInverseRemove(this, FeaturePackage.PRODUCT__FEATURES,
					Product.class, msgs);
			return basicSetProducts((Product) otherEnd, msgs);
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
		case FeaturePackage.FEATURE__PRODUCTS:
			return basicSetProducts(null, msgs);
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
		case FeaturePackage.FEATURE__PRODUCTS:
			if (resolve)
				return getProducts();
			return basicGetProducts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case FeaturePackage.FEATURE__PRODUCTS:
			setProducts((Product) newValue);
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
		case FeaturePackage.FEATURE__PRODUCTS:
			setProducts((Product) null);
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
		case FeaturePackage.FEATURE__PRODUCTS:
			return products != null;
		}
		return super.eIsSet(featureID);
	}

} // FeatureImpl
