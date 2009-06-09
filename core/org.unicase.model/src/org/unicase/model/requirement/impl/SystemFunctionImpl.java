/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.SystemFunction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>System Function</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.requirement.impl.SystemFunctionImpl#getInput <em>Input</em>}</li>
 * <li>{@link org.unicase.model.requirement.impl.SystemFunctionImpl#getOutput <em>Output</em>}</li>
 * <li>{@link org.unicase.model.requirement.impl.SystemFunctionImpl#getException <em>Exception</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SystemFunctionImpl extends ModelElementImpl implements SystemFunction {
	/**
	 * The default value of the '{@link #getInput() <em>Input</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected String input = INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutput() <em>Output</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected String output = OUTPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected String exception = EXCEPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SystemFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.SYSTEM_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInput(String newInput) {
		String oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementPackage.SYSTEM_FUNCTION__INPUT, oldInput,
				input));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOutput(String newOutput) {
		String oldOutput = output;
		output = newOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementPackage.SYSTEM_FUNCTION__OUTPUT,
				oldOutput, output));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setException(String newException) {
		String oldException = exception;
		exception = newException;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementPackage.SYSTEM_FUNCTION__EXCEPTION,
				oldException, exception));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementPackage.SYSTEM_FUNCTION__INPUT:
			return getInput();
		case RequirementPackage.SYSTEM_FUNCTION__OUTPUT:
			return getOutput();
		case RequirementPackage.SYSTEM_FUNCTION__EXCEPTION:
			return getException();
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
		case RequirementPackage.SYSTEM_FUNCTION__INPUT:
			setInput((String) newValue);
			return;
		case RequirementPackage.SYSTEM_FUNCTION__OUTPUT:
			setOutput((String) newValue);
			return;
		case RequirementPackage.SYSTEM_FUNCTION__EXCEPTION:
			setException((String) newValue);
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
		case RequirementPackage.SYSTEM_FUNCTION__INPUT:
			setInput(INPUT_EDEFAULT);
			return;
		case RequirementPackage.SYSTEM_FUNCTION__OUTPUT:
			setOutput(OUTPUT_EDEFAULT);
			return;
		case RequirementPackage.SYSTEM_FUNCTION__EXCEPTION:
			setException(EXCEPTION_EDEFAULT);
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
		case RequirementPackage.SYSTEM_FUNCTION__INPUT:
			return INPUT_EDEFAULT == null ? input != null : !INPUT_EDEFAULT.equals(input);
		case RequirementPackage.SYSTEM_FUNCTION__OUTPUT:
			return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
		case RequirementPackage.SYSTEM_FUNCTION__EXCEPTION:
			return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
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
		result.append(" (input: ");
		result.append(input);
		result.append(", output: ");
		result.append(output);
		result.append(", exception: ");
		result.append(exception);
		result.append(')');
		return result.toString();
	}

} // SystemFunctionImpl
