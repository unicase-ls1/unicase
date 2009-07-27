/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.testspec.model.InputParameter;
import org.unicase.testspec.model.ModelPackage;
import org.unicase.testspec.model.OutputParameter;
import org.unicase.testspec.model.TestStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.impl.TestStepImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestStepImpl#getOutputParameter <em>Output Parameter</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestStepImpl#getInputparameter <em>Inputparameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestStepImpl extends EObjectImpl implements TestStep {
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
	 * The cached value of the '{@link #getOutputParameter() <em>Output Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputParameter> outputParameter;

	/**
	 * The cached value of the '{@link #getInputparameter() <em>Inputparameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputparameter()
	 * @generated
	 * @ordered
	 */
	protected EList<InputParameter> inputparameter;

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
		return ModelPackage.Literals.TEST_STEP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_STEP__EXCEPTION, oldException, exception));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputParameter> getOutputParameter() {
		if (outputParameter == null) {
			outputParameter = new EObjectContainmentEList<OutputParameter>(OutputParameter.class, this, ModelPackage.TEST_STEP__OUTPUT_PARAMETER);
		}
		return outputParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputParameter> getInputparameter() {
		if (inputparameter == null) {
			inputparameter = new EObjectContainmentEList<InputParameter>(InputParameter.class, this, ModelPackage.TEST_STEP__INPUTPARAMETER);
		}
		return inputparameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.TEST_STEP__OUTPUT_PARAMETER:
				return ((InternalEList<?>)getOutputParameter()).basicRemove(otherEnd, msgs);
			case ModelPackage.TEST_STEP__INPUTPARAMETER:
				return ((InternalEList<?>)getInputparameter()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.TEST_STEP__EXCEPTION:
				return getException();
			case ModelPackage.TEST_STEP__OUTPUT_PARAMETER:
				return getOutputParameter();
			case ModelPackage.TEST_STEP__INPUTPARAMETER:
				return getInputparameter();
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
			case ModelPackage.TEST_STEP__EXCEPTION:
				setException((String)newValue);
				return;
			case ModelPackage.TEST_STEP__OUTPUT_PARAMETER:
				getOutputParameter().clear();
				getOutputParameter().addAll((Collection<? extends OutputParameter>)newValue);
				return;
			case ModelPackage.TEST_STEP__INPUTPARAMETER:
				getInputparameter().clear();
				getInputparameter().addAll((Collection<? extends InputParameter>)newValue);
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
			case ModelPackage.TEST_STEP__EXCEPTION:
				setException(EXCEPTION_EDEFAULT);
				return;
			case ModelPackage.TEST_STEP__OUTPUT_PARAMETER:
				getOutputParameter().clear();
				return;
			case ModelPackage.TEST_STEP__INPUTPARAMETER:
				getInputparameter().clear();
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
			case ModelPackage.TEST_STEP__EXCEPTION:
				return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
			case ModelPackage.TEST_STEP__OUTPUT_PARAMETER:
				return outputParameter != null && !outputParameter.isEmpty();
			case ModelPackage.TEST_STEP__INPUTPARAMETER:
				return inputparameter != null && !inputparameter.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //TestStepImpl
