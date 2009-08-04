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

import org.unicase.testspec.model.ConcreteOutputParameter;
import org.unicase.testspec.model.ModelPackage;
import org.unicase.testspec.model.OutputParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Output Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.impl.ConcreteOutputParameterImpl#getOutputParameter <em>Output Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteOutputParameterImpl extends ConcreteParameterImpl implements ConcreteOutputParameter {
	/**
	 * The cached value of the '{@link #getOutputParameter() <em>Output Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameter()
	 * @generated
	 * @ordered
	 */
	protected OutputParameter outputParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteOutputParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CONCRETE_OUTPUT_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputParameter getOutputParameter() {
		if (outputParameter != null && outputParameter.eIsProxy()) {
			InternalEObject oldOutputParameter = (InternalEObject)outputParameter;
			outputParameter = (OutputParameter)eResolveProxy(oldOutputParameter);
			if (outputParameter != oldOutputParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.CONCRETE_OUTPUT_PARAMETER__OUTPUT_PARAMETER, oldOutputParameter, outputParameter));
			}
		}
		return outputParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputParameter basicGetOutputParameter() {
		return outputParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputParameter(OutputParameter newOutputParameter) {
		OutputParameter oldOutputParameter = outputParameter;
		outputParameter = newOutputParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONCRETE_OUTPUT_PARAMETER__OUTPUT_PARAMETER, oldOutputParameter, outputParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.CONCRETE_OUTPUT_PARAMETER__OUTPUT_PARAMETER:
				if (resolve) return getOutputParameter();
				return basicGetOutputParameter();
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
			case ModelPackage.CONCRETE_OUTPUT_PARAMETER__OUTPUT_PARAMETER:
				setOutputParameter((OutputParameter)newValue);
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
			case ModelPackage.CONCRETE_OUTPUT_PARAMETER__OUTPUT_PARAMETER:
				setOutputParameter((OutputParameter)null);
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
			case ModelPackage.CONCRETE_OUTPUT_PARAMETER__OUTPUT_PARAMETER:
				return outputParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //ConcreteOutputParameterImpl
