/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature.impl;

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
import org.unicase.model.urml.feature.AbstractFeature;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.VariationPoint;
import org.unicase.model.urml.feature.VariationPointInstance;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variation Point</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.urml.feature.impl.VariationPointImpl#getVariety <em>Variety</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.impl.VariationPointImpl#getVarietyMultiplicity <em>Variety Multiplicity
 * </em>}</li>
 * <li>{@link org.unicase.model.urml.feature.impl.VariationPointImpl#getInstances <em>Instances</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VariationPointImpl extends AbstractFeatureImpl implements
		VariationPoint {
	/**
	 * The cached value of the '{@link #getOptionalSubFeatures() <em>Optional Sub Features</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOptionalSubFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> optionalSubFeatures;

	/**
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final int MULTIPLICITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected int multiplicity = MULTIPLICITY_EDEFAULT;

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
	public EList<AbstractFeature> getOptionalSubFeatures() {
		if (optionalSubFeatures == null) {
			optionalSubFeatures = new EObjectContainmentWithInverseEList.Resolving<AbstractFeature>(
					AbstractFeature.class,
					this,
					FeaturePackage.VARIATION_POINT__OPTIONAL_SUB_FEATURES,
					FeaturePackage.ABSTRACT_FEATURE__OPTIONAL_PARENT_VARIATION_POINT);
		}
		return optionalSubFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(int newMultiplicity) {
		int oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					FeaturePackage.VARIATION_POINT__MULTIPLICITY,
					oldMultiplicity, multiplicity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariationPointInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectWithInverseResolvingEList<VariationPointInstance>(
					VariationPointInstance.class, this,
					FeaturePackage.VARIATION_POINT__INSTANCES,
					FeaturePackage.VARIATION_POINT_INSTANCE__VARIATION_POINT);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FeaturePackage.VARIATION_POINT__OPTIONAL_SUB_FEATURES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOptionalSubFeatures())
					.basicAdd(otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInstances())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FeaturePackage.VARIATION_POINT__OPTIONAL_SUB_FEATURES:
			return ((InternalEList<?>) getOptionalSubFeatures()).basicRemove(
					otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return ((InternalEList<?>) getInstances()).basicRemove(otherEnd,
					msgs);
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
		case FeaturePackage.VARIATION_POINT__OPTIONAL_SUB_FEATURES:
			return getOptionalSubFeatures();
		case FeaturePackage.VARIATION_POINT__MULTIPLICITY:
			return getMultiplicity();
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return getInstances();
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
		case FeaturePackage.VARIATION_POINT__OPTIONAL_SUB_FEATURES:
			getOptionalSubFeatures().clear();
			getOptionalSubFeatures().addAll(
					(Collection<? extends AbstractFeature>) newValue);
			return;
		case FeaturePackage.VARIATION_POINT__MULTIPLICITY:
			setMultiplicity((Integer) newValue);
			return;
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			getInstances().clear();
			getInstances().addAll(
					(Collection<? extends VariationPointInstance>) newValue);
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
		case FeaturePackage.VARIATION_POINT__OPTIONAL_SUB_FEATURES:
			getOptionalSubFeatures().clear();
			return;
		case FeaturePackage.VARIATION_POINT__MULTIPLICITY:
			setMultiplicity(MULTIPLICITY_EDEFAULT);
			return;
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			getInstances().clear();
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
		case FeaturePackage.VARIATION_POINT__OPTIONAL_SUB_FEATURES:
			return optionalSubFeatures != null
					&& !optionalSubFeatures.isEmpty();
		case FeaturePackage.VARIATION_POINT__MULTIPLICITY:
			return multiplicity != MULTIPLICITY_EDEFAULT;
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return instances != null && !instances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (multiplicity: ");
		result.append(multiplicity);
		result.append(')');
		return result.toString();
	}

} // VariationPointImpl
