/**
 * <copyright> </copyright> $Id$
 */
package urml.feature.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.urml.impl.UrmlModelElementImpl;

import urml.feature.AbstractFeature;
import urml.feature.FeaturePackage;
import urml.feature.Product;
import urml.feature.VariationPoint;
import urml.feature.VariationPointInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variation Point Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.feature.impl.VariationPointInstanceImpl#getVariationPoint <em>Variation Point</em>}</li>
 *   <li>{@link urml.feature.impl.VariationPointInstanceImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link urml.feature.impl.VariationPointInstanceImpl#getSelectedFeatures <em>Selected Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariationPointInstanceImpl extends UrmlModelElementImpl implements VariationPointInstance {
	/**
	 * The cached value of the '{@link #getVariationPoint() <em>Variation Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariationPoint()
	 * @generated
	 * @ordered
	 */
	protected VariationPoint variationPoint;

	/**
	 * The cached value of the '{@link #getProduct() <em>Product</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected Product product;

	/**
	 * The cached value of the '{@link #getSelectedFeatures() <em>Selected Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> selectedFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariationPointInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturePackage.Literals.VARIATION_POINT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPoint getVariationPoint() {
		if (variationPoint != null && variationPoint.eIsProxy()) {
			InternalEObject oldVariationPoint = (InternalEObject) variationPoint;
			variationPoint = (VariationPoint) eResolveProxy(oldVariationPoint);
			if (variationPoint != oldVariationPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT, oldVariationPoint, variationPoint));
			}
		}
		return variationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPoint basicGetVariationPoint() {
		return variationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariationPoint(VariationPoint newVariationPoint, NotificationChain msgs) {
		VariationPoint oldVariationPoint = variationPoint;
		variationPoint = newVariationPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT, oldVariationPoint, newVariationPoint);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariationPoint(VariationPoint newVariationPoint) {
		if (newVariationPoint != variationPoint) {
			NotificationChain msgs = null;
			if (variationPoint != null)
				msgs = ((InternalEObject) variationPoint).eInverseRemove(this,
					FeaturePackage.VARIATION_POINT__INSTANCES, VariationPoint.class, msgs);
			if (newVariationPoint != null)
				msgs = ((InternalEObject) newVariationPoint).eInverseAdd(this,
					FeaturePackage.VARIATION_POINT__INSTANCES, VariationPoint.class, msgs);
			msgs = basicSetVariationPoint(newVariationPoint, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT, newVariationPoint, newVariationPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product getProduct() {
		if (product != null && product.eIsProxy()) {
			InternalEObject oldProduct = (InternalEObject) product;
			product = (Product) eResolveProxy(oldProduct);
			if (product != oldProduct) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT, oldProduct, product));
			}
		}
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product basicGetProduct() {
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProduct(Product newProduct, NotificationChain msgs) {
		Product oldProduct = product;
		product = newProduct;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT, oldProduct, newProduct);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProduct(Product newProduct) {
		if (newProduct != product) {
			NotificationChain msgs = null;
			if (product != null)
				msgs = ((InternalEObject) product).eInverseRemove(this,
					FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES, Product.class, msgs);
			if (newProduct != null)
				msgs = ((InternalEObject) newProduct).eInverseAdd(this,
					FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES, Product.class, msgs);
			msgs = basicSetProduct(newProduct, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT,
				newProduct, newProduct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractFeature> getSelectedFeatures() {
		if (selectedFeatures == null) {
			selectedFeatures = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(AbstractFeature.class,
				this, FeaturePackage.VARIATION_POINT_INSTANCE__SELECTED_FEATURES,
				FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES);
		}
		return selectedFeatures;
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
		case FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT:
			if (variationPoint != null)
				msgs = ((InternalEObject) variationPoint).eInverseRemove(this,
					FeaturePackage.VARIATION_POINT__INSTANCES, VariationPoint.class, msgs);
			return basicSetVariationPoint((VariationPoint) otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT:
			if (product != null)
				msgs = ((InternalEObject) product).eInverseRemove(this,
					FeaturePackage.PRODUCT__VARIATION_POINT_INSTANCES, Product.class, msgs);
			return basicSetProduct((Product) otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT_INSTANCE__SELECTED_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSelectedFeatures()).basicAdd(otherEnd, msgs);
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
		case FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT:
			return basicSetVariationPoint(null, msgs);
		case FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT:
			return basicSetProduct(null, msgs);
		case FeaturePackage.VARIATION_POINT_INSTANCE__SELECTED_FEATURES:
			return ((InternalEList<?>) getSelectedFeatures()).basicRemove(otherEnd, msgs);
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
		case FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT:
			if (resolve)
				return getVariationPoint();
			return basicGetVariationPoint();
		case FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT:
			if (resolve)
				return getProduct();
			return basicGetProduct();
		case FeaturePackage.VARIATION_POINT_INSTANCE__SELECTED_FEATURES:
			return getSelectedFeatures();
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
		case FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT:
			setVariationPoint((VariationPoint) newValue);
			return;
		case FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT:
			setProduct((Product) newValue);
			return;
		case FeaturePackage.VARIATION_POINT_INSTANCE__SELECTED_FEATURES:
			getSelectedFeatures().clear();
			getSelectedFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
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
		case FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT:
			setVariationPoint((VariationPoint) null);
			return;
		case FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT:
			setProduct((Product) null);
			return;
		case FeaturePackage.VARIATION_POINT_INSTANCE__SELECTED_FEATURES:
			getSelectedFeatures().clear();
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
		case FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT:
			return variationPoint != null;
		case FeaturePackage.VARIATION_POINT_INSTANCE__PRODUCT:
			return product != null;
		case FeaturePackage.VARIATION_POINT_INSTANCE__SELECTED_FEATURES:
			return selectedFeatures != null && !selectedFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VariationPointInstanceImpl
