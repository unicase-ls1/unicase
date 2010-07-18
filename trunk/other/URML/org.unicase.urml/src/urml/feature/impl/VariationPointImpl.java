/**
 * <copyright> </copyright> $Id$
 */
package urml.feature.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import urml.feature.AbstractFeature;
import urml.feature.FeaturePackage;
import urml.feature.VariationPoint;
import urml.feature.VariationPointInstance;
import urml.feature.VariationPointRule;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variation Point</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link urml.feature.impl.VariationPointImpl#getFeatures <em>Features</em>}</li>
 * <li>{@link urml.feature.impl.VariationPointImpl#getInstances <em>Instances</em>}</li>
 * <li>{@link urml.feature.impl.VariationPointImpl#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VariationPointImpl extends AbstractFeatureImpl implements VariationPoint {
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> features;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationPointInstance> instances;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationPointRule> rules;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturePackage.Literals.VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractFeature> getFeatures() {
		if (features == null) {
			features = new EObjectWithInverseResolvingEList.ManyInverse<AbstractFeature>(AbstractFeature.class, this,
				FeaturePackage.VARIATION_POINT__FEATURES, FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINTS);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VariationPointInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectWithInverseResolvingEList<VariationPointInstance>(VariationPointInstance.class,
				this, FeaturePackage.VARIATION_POINT__INSTANCES,
				FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VariationPointRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentWithInverseEList.Resolving<VariationPointRule>(VariationPointRule.class,
				this, FeaturePackage.VARIATION_POINT__RULES, FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT);
		}
		return rules;
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
		case FeaturePackage.VARIATION_POINT__FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getFeatures()).basicAdd(otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInstances()).basicAdd(otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__RULES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRules()).basicAdd(otherEnd, msgs);
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
		case FeaturePackage.VARIATION_POINT__FEATURES:
			return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return ((InternalEList<?>) getInstances()).basicRemove(otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__RULES:
			return ((InternalEList<?>) getRules()).basicRemove(otherEnd, msgs);
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
		case FeaturePackage.VARIATION_POINT__FEATURES:
			return getFeatures();
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return getInstances();
		case FeaturePackage.VARIATION_POINT__RULES:
			return getRules();
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
		case FeaturePackage.VARIATION_POINT__FEATURES:
			getFeatures().clear();
			getFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			getInstances().clear();
			getInstances().addAll((Collection<? extends VariationPointInstance>) newValue);
			return;
		case FeaturePackage.VARIATION_POINT__RULES:
			getRules().clear();
			getRules().addAll((Collection<? extends VariationPointRule>) newValue);
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
		case FeaturePackage.VARIATION_POINT__FEATURES:
			getFeatures().clear();
			return;
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			getInstances().clear();
			return;
		case FeaturePackage.VARIATION_POINT__RULES:
			getRules().clear();
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
		case FeaturePackage.VARIATION_POINT__FEATURES:
			return features != null && !features.isEmpty();
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return instances != null && !instances.isEmpty();
		case FeaturePackage.VARIATION_POINT__RULES:
			return rules != null && !rules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // VariationPointImpl
