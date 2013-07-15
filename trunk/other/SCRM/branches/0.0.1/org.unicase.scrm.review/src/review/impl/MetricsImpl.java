/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package review.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import review.Metrics;
import review.ReviewPackage;

import scrm.SCRMModelElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metrics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link review.impl.MetricsImpl#isCorrect <em>Correct</em>}</li>
 *   <li>{@link review.impl.MetricsImpl#isEasyToUnderstand <em>Easy To Understand</em>}</li>
 *   <li>{@link review.impl.MetricsImpl#isUnambiguous <em>Unambiguous</em>}</li>
 *   <li>{@link review.impl.MetricsImpl#getMeasuredRequirement <em>Measured Requirement</em>}</li>
 *   <li>{@link review.impl.MetricsImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricsImpl extends EObjectImpl implements Metrics {
	/**
	 * The default value of the '{@link #isCorrect() <em>Correct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCorrect()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CORRECT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCorrect() <em>Correct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCorrect()
	 * @generated
	 * @ordered
	 */
	protected boolean correct = CORRECT_EDEFAULT;

	/**
	 * The default value of the '{@link #isEasyToUnderstand() <em>Easy To Understand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEasyToUnderstand()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EASY_TO_UNDERSTAND_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEasyToUnderstand() <em>Easy To Understand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEasyToUnderstand()
	 * @generated
	 * @ordered
	 */
	protected boolean easyToUnderstand = EASY_TO_UNDERSTAND_EDEFAULT;

	/**
	 * The default value of the '{@link #isUnambiguous() <em>Unambiguous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnambiguous()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNAMBIGUOUS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUnambiguous() <em>Unambiguous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnambiguous()
	 * @generated
	 * @ordered
	 */
	protected boolean unambiguous = UNAMBIGUOUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMeasuredRequirement() <em>Measured Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredRequirement()
	 * @generated
	 * @ordered
	 */
	protected SCRMModelElement measuredRequirement;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReviewPackage.Literals.METRICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrect(boolean newCorrect) {
		boolean oldCorrect = correct;
		correct = newCorrect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReviewPackage.METRICS__CORRECT, oldCorrect, correct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEasyToUnderstand() {
		return easyToUnderstand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEasyToUnderstand(boolean newEasyToUnderstand) {
		boolean oldEasyToUnderstand = easyToUnderstand;
		easyToUnderstand = newEasyToUnderstand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReviewPackage.METRICS__EASY_TO_UNDERSTAND, oldEasyToUnderstand, easyToUnderstand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnambiguous() {
		return unambiguous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnambiguous(boolean newUnambiguous) {
		boolean oldUnambiguous = unambiguous;
		unambiguous = newUnambiguous;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReviewPackage.METRICS__UNAMBIGUOUS, oldUnambiguous, unambiguous));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCRMModelElement getMeasuredRequirement() {
		if (measuredRequirement != null && measuredRequirement.eIsProxy()) {
			InternalEObject oldMeasuredRequirement = (InternalEObject)measuredRequirement;
			measuredRequirement = (SCRMModelElement)eResolveProxy(oldMeasuredRequirement);
			if (measuredRequirement != oldMeasuredRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReviewPackage.METRICS__MEASURED_REQUIREMENT, oldMeasuredRequirement, measuredRequirement));
			}
		}
		return measuredRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCRMModelElement basicGetMeasuredRequirement() {
		return measuredRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasuredRequirement(SCRMModelElement newMeasuredRequirement) {
		SCRMModelElement oldMeasuredRequirement = measuredRequirement;
		measuredRequirement = newMeasuredRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReviewPackage.METRICS__MEASURED_REQUIREMENT, oldMeasuredRequirement, measuredRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReviewPackage.METRICS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReviewPackage.METRICS__CORRECT:
				return isCorrect();
			case ReviewPackage.METRICS__EASY_TO_UNDERSTAND:
				return isEasyToUnderstand();
			case ReviewPackage.METRICS__UNAMBIGUOUS:
				return isUnambiguous();
			case ReviewPackage.METRICS__MEASURED_REQUIREMENT:
				if (resolve) return getMeasuredRequirement();
				return basicGetMeasuredRequirement();
			case ReviewPackage.METRICS__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ReviewPackage.METRICS__CORRECT:
				setCorrect((Boolean)newValue);
				return;
			case ReviewPackage.METRICS__EASY_TO_UNDERSTAND:
				setEasyToUnderstand((Boolean)newValue);
				return;
			case ReviewPackage.METRICS__UNAMBIGUOUS:
				setUnambiguous((Boolean)newValue);
				return;
			case ReviewPackage.METRICS__MEASURED_REQUIREMENT:
				setMeasuredRequirement((SCRMModelElement)newValue);
				return;
			case ReviewPackage.METRICS__ID:
				setId((String)newValue);
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
			case ReviewPackage.METRICS__CORRECT:
				setCorrect(CORRECT_EDEFAULT);
				return;
			case ReviewPackage.METRICS__EASY_TO_UNDERSTAND:
				setEasyToUnderstand(EASY_TO_UNDERSTAND_EDEFAULT);
				return;
			case ReviewPackage.METRICS__UNAMBIGUOUS:
				setUnambiguous(UNAMBIGUOUS_EDEFAULT);
				return;
			case ReviewPackage.METRICS__MEASURED_REQUIREMENT:
				setMeasuredRequirement((SCRMModelElement)null);
				return;
			case ReviewPackage.METRICS__ID:
				setId(ID_EDEFAULT);
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
			case ReviewPackage.METRICS__CORRECT:
				return correct != CORRECT_EDEFAULT;
			case ReviewPackage.METRICS__EASY_TO_UNDERSTAND:
				return easyToUnderstand != EASY_TO_UNDERSTAND_EDEFAULT;
			case ReviewPackage.METRICS__UNAMBIGUOUS:
				return unambiguous != UNAMBIGUOUS_EDEFAULT;
			case ReviewPackage.METRICS__MEASURED_REQUIREMENT:
				return measuredRequirement != null;
			case ReviewPackage.METRICS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (correct: ");
		result.append(correct);
		result.append(", easyToUnderstand: ");
		result.append(easyToUnderstand);
		result.append(", unambiguous: ");
		result.append(unambiguous);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //MetricsImpl
