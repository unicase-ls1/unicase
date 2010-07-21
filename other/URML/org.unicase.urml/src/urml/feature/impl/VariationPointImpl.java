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
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationPointInstance> instances;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected VariationPointRule rules;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected VariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturePackage.Literals.VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	public VariationPointRule getRules() {
		if (rules != null && rules.eIsProxy()) {
			InternalEObject oldRules = (InternalEObject) rules;
			rules = (VariationPointRule) eResolveProxy(oldRules);
			if (rules != oldRules) {
				InternalEObject newRules = (InternalEObject) rules;
				NotificationChain msgs = oldRules.eInverseRemove(this,
					FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT, VariationPointRule.class, null);
				if (newRules.eInternalContainer() == null) {
					msgs = newRules.eInverseAdd(this, FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT,
						VariationPointRule.class, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturePackage.VARIATION_POINT__RULES,
						oldRules, rules));
			}
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPointRule basicGetRules() {
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRules(VariationPointRule newRules, NotificationChain msgs) {
		VariationPointRule oldRules = rules;
		rules = newRules;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				FeaturePackage.VARIATION_POINT__RULES, oldRules, newRules);
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
	public void setRules(VariationPointRule newRules) {
		if (newRules != rules) {
			NotificationChain msgs = null;
			if (rules != null)
				msgs = ((InternalEObject) rules).eInverseRemove(this,
					FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT, VariationPointRule.class, msgs);
			if (newRules != null)
				msgs = ((InternalEObject) newRules).eInverseAdd(this,
					FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT, VariationPointRule.class, msgs);
			msgs = basicSetRules(newRules, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.VARIATION_POINT__RULES, newRules,
				newRules));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInstances()).basicAdd(otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__RULES:
			if (rules != null)
				msgs = ((InternalEObject) rules).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- FeaturePackage.VARIATION_POINT__RULES, null, msgs);
			return basicSetRules((VariationPointRule) otherEnd, msgs);
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
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return ((InternalEList<?>) getInstances()).basicRemove(otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__RULES:
			return basicSetRules(null, msgs);
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
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return getInstances();
		case FeaturePackage.VARIATION_POINT__RULES:
			if (resolve)
				return getRules();
			return basicGetRules();
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
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			getInstances().clear();
			getInstances().addAll((Collection<? extends VariationPointInstance>) newValue);
			return;
		case FeaturePackage.VARIATION_POINT__RULES:
			setRules((VariationPointRule) newValue);
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
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			getInstances().clear();
			return;
		case FeaturePackage.VARIATION_POINT__RULES:
			setRules((VariationPointRule) null);
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
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return instances != null && !instances.isEmpty();
		case FeaturePackage.VARIATION_POINT__RULES:
			return rules != null;
		}
		return super.eIsSet(featureID);
	}

} // VariationPointImpl
