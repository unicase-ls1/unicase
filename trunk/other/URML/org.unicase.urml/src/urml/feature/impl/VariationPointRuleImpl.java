/**
 * <copyright> </copyright> $Id$
 */
package urml.feature.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.urml.impl.UrmlModelElementImpl;

import urml.feature.FeaturePackage;
import urml.feature.VariationPoint;
import urml.feature.VariationPointRule;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variation Point Rule</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link urml.feature.impl.VariationPointRuleImpl#getVariationPoint <em>Variation Point</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class VariationPointRuleImpl extends UrmlModelElementImpl implements VariationPointRule {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VariationPointRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturePackage.Literals.VARIATION_POINT_RULE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariationPoint getVariationPoint() {
		if (eContainerFeatureID() != FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT)
			return null;
		return (VariationPoint) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariationPoint basicGetVariationPoint() {
		if (eContainerFeatureID() != FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT)
			return null;
		return (VariationPoint) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetVariationPoint(VariationPoint newVariationPoint, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newVariationPoint,
			FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setVariationPoint(VariationPoint newVariationPoint) {
		if (newVariationPoint != eInternalContainer()
			|| (eContainerFeatureID() != FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT && newVariationPoint != null)) {
			if (EcoreUtil.isAncestor(this, newVariationPoint))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newVariationPoint != null)
				msgs = ((InternalEObject) newVariationPoint).eInverseAdd(this, FeaturePackage.VARIATION_POINT__RULES,
					VariationPoint.class, msgs);
			msgs = basicSetVariationPoint(newVariationPoint, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT,
				newVariationPoint, newVariationPoint));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetVariationPoint((VariationPoint) otherEnd, msgs);
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
		case FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT:
			return basicSetVariationPoint(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT:
			return eInternalContainer().eInverseRemove(this, FeaturePackage.VARIATION_POINT__RULES,
				VariationPoint.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT:
			if (resolve)
				return getVariationPoint();
			return basicGetVariationPoint();
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
		case FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT:
			setVariationPoint((VariationPoint) newValue);
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
		case FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT:
			setVariationPoint((VariationPoint) null);
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
		case FeaturePackage.VARIATION_POINT_RULE__VARIATION_POINT:
			return basicGetVariationPoint() != null;
		}
		return super.eIsSet(featureID);
	}

} // VariationPointRuleImpl
