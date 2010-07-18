/**
 * <copyright> </copyright> $Id$
 */
package urml.feature.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import urml.feature.FeaturePackage;
import urml.feature.ManyOutManyRule;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Many Out Many Rule</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link urml.feature.impl.ManyOutManyRuleImpl#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ManyOutManyRuleImpl extends VariationPointRuleImpl implements ManyOutManyRule {
	/**
	 * The default value of the '{@link #getConstraint() <em>Constraint</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final int CONSTRAINT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected int constraint = CONSTRAINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ManyOutManyRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturePackage.Literals.MANY_OUT_MANY_RULE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraint(int newConstraint) {
		int oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.MANY_OUT_MANY_RULE__CONSTRAINT,
				oldConstraint, constraint));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FeaturePackage.MANY_OUT_MANY_RULE__CONSTRAINT:
			return getConstraint();
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
		case FeaturePackage.MANY_OUT_MANY_RULE__CONSTRAINT:
			setConstraint((Integer) newValue);
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
		case FeaturePackage.MANY_OUT_MANY_RULE__CONSTRAINT:
			setConstraint(CONSTRAINT_EDEFAULT);
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
		case FeaturePackage.MANY_OUT_MANY_RULE__CONSTRAINT:
			return constraint != CONSTRAINT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (constraint: ");
		result.append(constraint);
		result.append(')');
		return result.toString();
	}

} // ManyOutManyRuleImpl
