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

import urml.feature.AbstractFeature;
import urml.feature.FeaturePackage;
import urml.feature.VariationPoint;
import urml.feature.VariationPointInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link urml.feature.impl.VariationPointImpl#getVariety <em>Variety</em>}</li>
 *   <li>{@link urml.feature.impl.VariationPointImpl#getVarietyMultiplicity <em>Variety Multiplicity</em>}</li>
 *   <li>{@link urml.feature.impl.VariationPointImpl#getInstances <em>Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariationPointImpl extends AbstractFeatureImpl implements VariationPoint {
	/**
	 * The cached value of the '{@link #getVariety() <em>Variety</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariety()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> variety;

	/**
	 * The default value of the '{@link #getVarietyMultiplicity() <em>Variety Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarietyMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final int VARIETY_MULTIPLICITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVarietyMultiplicity() <em>Variety Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarietyMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected int varietyMultiplicity = VARIETY_MULTIPLICITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationPointInstance> instances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturePackage.Literals.VARIATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractFeature> getVariety() {
		if (variety == null) {
			variety = new EObjectWithInverseResolvingEList<AbstractFeature>(AbstractFeature.class, this,
				FeaturePackage.VARIATION_POINT__VARIETY, FeaturePackage.ABSTRACT_FEATURE__VARIATION_POINT);
		}
		return variety;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVarietyMultiplicity() {
		return varietyMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarietyMultiplicity(int newVarietyMultiplicity) {
		int oldVarietyMultiplicity = varietyMultiplicity;
		varietyMultiplicity = newVarietyMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.VARIATION_POINT__VARIETY_MULTIPLICITY,
				oldVarietyMultiplicity, varietyMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FeaturePackage.VARIATION_POINT__VARIETY:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getVariety()).basicAdd(otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInstances()).basicAdd(otherEnd, msgs);
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
		case FeaturePackage.VARIATION_POINT__VARIETY:
			return ((InternalEList<?>) getVariety()).basicRemove(otherEnd, msgs);
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return ((InternalEList<?>) getInstances()).basicRemove(otherEnd, msgs);
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
		case FeaturePackage.VARIATION_POINT__VARIETY:
			return getVariety();
		case FeaturePackage.VARIATION_POINT__VARIETY_MULTIPLICITY:
			return getVarietyMultiplicity();
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return getInstances();
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
		case FeaturePackage.VARIATION_POINT__VARIETY:
			getVariety().clear();
			getVariety().addAll((Collection<? extends AbstractFeature>) newValue);
			return;
		case FeaturePackage.VARIATION_POINT__VARIETY_MULTIPLICITY:
			setVarietyMultiplicity((Integer) newValue);
			return;
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			getInstances().clear();
			getInstances().addAll((Collection<? extends VariationPointInstance>) newValue);
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
		case FeaturePackage.VARIATION_POINT__VARIETY:
			getVariety().clear();
			return;
		case FeaturePackage.VARIATION_POINT__VARIETY_MULTIPLICITY:
			setVarietyMultiplicity(VARIETY_MULTIPLICITY_EDEFAULT);
			return;
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			getInstances().clear();
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
		case FeaturePackage.VARIATION_POINT__VARIETY:
			return variety != null && !variety.isEmpty();
		case FeaturePackage.VARIATION_POINT__VARIETY_MULTIPLICITY:
			return varietyMultiplicity != VARIETY_MULTIPLICITY_EDEFAULT;
		case FeaturePackage.VARIATION_POINT__INSTANCES:
			return instances != null && !instances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (varietyMultiplicity: ");
		result.append(varietyMultiplicity);
		result.append(')');
		return result.toString();
	}

} //VariationPointImpl
