/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.testspec.model.ConcreteInputParameter;
import org.unicase.testspec.model.InputParameter;
import org.unicase.testspec.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Input Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.impl.ConcreteInputParameterImpl#getInputParameter <em>Input Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteInputParameterImpl extends ConcreteParameterImpl implements ConcreteInputParameter {
	/**
	 * The cached value of the '{@link #getInputParameter() <em>Input Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameter()
	 * @generated
	 * @ordered
	 */
	protected InputParameter inputParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteInputParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CONCRETE_INPUT_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputParameter getInputParameter() {
		if (inputParameter != null && inputParameter.eIsProxy()) {
			InternalEObject oldInputParameter = (InternalEObject)inputParameter;
			inputParameter = (InputParameter)eResolveProxy(oldInputParameter);
			if (inputParameter != oldInputParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.CONCRETE_INPUT_PARAMETER__INPUT_PARAMETER, oldInputParameter, inputParameter));
			}
		}
		return inputParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputParameter basicGetInputParameter() {
		return inputParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated 
	 */
	public void setInputParameter(InputParameter newInputParameter) {
		InputParameter oldInputParameter = inputParameter;
		inputParameter = newInputParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONCRETE_INPUT_PARAMETER__INPUT_PARAMETER, oldInputParameter, inputParameter));
		
	
		
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.CONCRETE_INPUT_PARAMETER__INPUT_PARAMETER:
				if (resolve) return getInputParameter();
				return basicGetInputParameter();
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
			case ModelPackage.CONCRETE_INPUT_PARAMETER__INPUT_PARAMETER:
				setInputParameter((InputParameter)newValue);
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
			case ModelPackage.CONCRETE_INPUT_PARAMETER__INPUT_PARAMETER:
				setInputParameter((InputParameter)null);
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
			case ModelPackage.CONCRETE_INPUT_PARAMETER__INPUT_PARAMETER:
				return inputParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //ConcreteInputParameterImpl
