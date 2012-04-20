/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.classes.ArgumentDirectionType;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.MethodArgument;
import org.unicase.model.impl.UnicaseModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Method Argument</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getType <em>Type</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getDirection <em>Direction</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getDefaultValue <em>Default Value</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getSignature <em>Signature</em>}</li>
 * <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MethodArgumentImpl extends UnicaseModelElementImpl implements MethodArgument {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final ArgumentDirectionType DIRECTION_EDEFAULT = ArgumentDirectionType.UNDEFINED;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected ArgumentDirectionType direction = DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignature() <em>Signature</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNATURE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MethodArgumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.METHOD_ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_ARGUMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ArgumentDirectionType getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDirection(ArgumentDirectionType newDirection) {
		ArgumentDirectionType oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_ARGUMENT__DIRECTION,
				oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE,
				oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @return the signature
	 */
	public String getSignature() {
		String signature = "";

		if (this.getDirection() != ArgumentDirectionType.UNDEFINED) {
			signature += this.getDirection().getLiteral();
		}

		if (this.getName() != null) {
			if (signature.length() > 0) {
				signature += " ";
			}
			signature += this.getName();
		}

		if (this.getType() != null) {
			if (signature.length() > 0) {
				signature += " ";
			}
			signature += ": ";
			signature += this.getType();
		}

		if (this.getDefaultValue() != null) {
			if (signature.length() > 0) {
				signature += " ";
			}
			signature += "= ";
			signature += this.getDefaultValue();
		}

		return signature;
	}

	/**
	 * <!-- begin-user-doc --> If the label can not be parsed it is a string field. otherwise this returns the
	 * signature. <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @return The displayable label.
	 */
	public String getLabel() {
		if (label != null) {
			return label;
		} else {
			return this.getSignature();
		}
	}

	/**
	 * <!-- begin-user-doc --> Sets and tries to parse the label. If it can be parsed, label attribute stays null and
	 * signature is used instead. <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @param newLabel the input string which will be parsed.
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;

		String validSignatureRegExp;

		validSignatureRegExp = "";
		validSignatureRegExp += "\\s*(in|out|inout)?\\s*"; // group1 ->
		// direction
		validSignatureRegExp += "(\\w+)\\s*"; // group2 -> name
		validSignatureRegExp += "(?::\\s*(\\w+))?\\s*"; // group3 -> type
		validSignatureRegExp += "(?:=\\s*(\\w+))?\\s*"; // group4 ->
		// defaultValue

		Pattern p = Pattern.compile(validSignatureRegExp);
		Matcher m = p.matcher(newLabel);
		boolean b = m.matches();

		if (b) {
			String directionLiteral = m.group(1);
			if (directionLiteral != null && directionLiteral.length() > 0) {
				this.setDirection(ArgumentDirectionType.get(directionLiteral));
			} else {
				this.setDirection(ArgumentDirectionType.UNDEFINED);
			}

			String nameString = m.group(2);
			if (nameString != null && nameString.length() > 0) {
				this.setName(nameString);
			} else {
				this.setName("Unnamed");
			}

			String typeString = m.group(3);
			this.setType(typeString);

			String defaultValueString = m.group(4);
			this.setDefaultValue(defaultValueString);

			label = null;
		}

		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_ARGUMENT__LABEL, oldLabel,
				label));
		}
	}

	/**
	 * <!-- begin-user-doc --> .<!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ClassesPackage.METHOD_ARGUMENT__TYPE:
			return getType();
		case ClassesPackage.METHOD_ARGUMENT__DIRECTION:
			return getDirection();
		case ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE:
			return getDefaultValue();
		case ClassesPackage.METHOD_ARGUMENT__SIGNATURE:
			return getSignature();
		case ClassesPackage.METHOD_ARGUMENT__LABEL:
			return getLabel();
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
		case ClassesPackage.METHOD_ARGUMENT__TYPE:
			setType((String) newValue);
			return;
		case ClassesPackage.METHOD_ARGUMENT__DIRECTION:
			setDirection((ArgumentDirectionType) newValue);
			return;
		case ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE:
			setDefaultValue((String) newValue);
			return;
		case ClassesPackage.METHOD_ARGUMENT__LABEL:
			setLabel((String) newValue);
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
		case ClassesPackage.METHOD_ARGUMENT__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case ClassesPackage.METHOD_ARGUMENT__DIRECTION:
			setDirection(DIRECTION_EDEFAULT);
			return;
		case ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE:
			setDefaultValue(DEFAULT_VALUE_EDEFAULT);
			return;
		case ClassesPackage.METHOD_ARGUMENT__LABEL:
			setLabel(LABEL_EDEFAULT);
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
		case ClassesPackage.METHOD_ARGUMENT__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		case ClassesPackage.METHOD_ARGUMENT__DIRECTION:
			return direction != DIRECTION_EDEFAULT;
		case ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE:
			return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
		case ClassesPackage.METHOD_ARGUMENT__SIGNATURE:
			return SIGNATURE_EDEFAULT == null ? getSignature() != null : !SIGNATURE_EDEFAULT.equals(getSignature());
		case ClassesPackage.METHOD_ARGUMENT__LABEL:
			return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", direction: ");
		result.append(direction);
		result.append(", defaultValue: ");
		result.append(defaultValue);
		result.append(", label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} // MethodArgumentImpl
