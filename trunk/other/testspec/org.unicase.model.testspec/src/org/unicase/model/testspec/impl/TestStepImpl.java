/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestspecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepImpl#getInputParamter <em>Input Paramter</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepImpl#getOutputParameter <em>Output Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestStepImpl extends ModelElementImpl implements TestStep {
	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected String exception = EXCEPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInputParamter() <em>Input Paramter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParamter()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_PARAMTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputParamter() <em>Input Paramter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParamter()
	 * @generated
	 * @ordered
	 */
	protected String inputParamter = INPUT_PARAMTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputParameter() <em>Output Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameter()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_PARAMETER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputParameter() <em>Output Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameter()
	 * @generated
	 * @ordered
	 */
	protected String outputParameter = OUTPUT_PARAMETER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestspecPackage.Literals.TEST_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setException(String newException) {
		String oldException = exception;
		exception = newException;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_STEP__EXCEPTION, oldException, exception));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputParamter() {
		return inputParamter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputParamter(String newInputParamter) {
		String oldInputParamter = inputParamter;
		inputParamter = newInputParamter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_STEP__INPUT_PARAMTER, oldInputParamter, inputParamter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputParameter() {
		return outputParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputParameter(String newOutputParameter) {
		String oldOutputParameter = outputParameter;
		outputParameter = newOutputParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_STEP__OUTPUT_PARAMETER, oldOutputParameter, outputParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestspecPackage.TEST_STEP__EXCEPTION:
				return getException();
			case TestspecPackage.TEST_STEP__INPUT_PARAMTER:
				return getInputParamter();
			case TestspecPackage.TEST_STEP__OUTPUT_PARAMETER:
				return getOutputParameter();
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
			case TestspecPackage.TEST_STEP__EXCEPTION:
				setException((String)newValue);
				return;
			case TestspecPackage.TEST_STEP__INPUT_PARAMTER:
				setInputParamter((String)newValue);
				return;
			case TestspecPackage.TEST_STEP__OUTPUT_PARAMETER:
				setOutputParameter((String)newValue);
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
			case TestspecPackage.TEST_STEP__EXCEPTION:
				setException(EXCEPTION_EDEFAULT);
				return;
			case TestspecPackage.TEST_STEP__INPUT_PARAMTER:
				setInputParamter(INPUT_PARAMTER_EDEFAULT);
				return;
			case TestspecPackage.TEST_STEP__OUTPUT_PARAMETER:
				setOutputParameter(OUTPUT_PARAMETER_EDEFAULT);
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
			case TestspecPackage.TEST_STEP__EXCEPTION:
				return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
			case TestspecPackage.TEST_STEP__INPUT_PARAMTER:
				return INPUT_PARAMTER_EDEFAULT == null ? inputParamter != null : !INPUT_PARAMTER_EDEFAULT.equals(inputParamter);
			case TestspecPackage.TEST_STEP__OUTPUT_PARAMETER:
				return OUTPUT_PARAMETER_EDEFAULT == null ? outputParameter != null : !OUTPUT_PARAMETER_EDEFAULT.equals(outputParameter);
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
		result.append(" (exception: ");
		result.append(exception);
		result.append(", inputParamter: ");
		result.append(inputParamter);
		result.append(", outputParameter: ");
		result.append(outputParameter);
		result.append(')');
		return result.toString();
	}

} //TestStepImpl
