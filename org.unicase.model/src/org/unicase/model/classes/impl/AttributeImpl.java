/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.classes.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.ScopeType;
import org.unicase.model.classes.VisibilityType;
import org.unicase.model.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getDefiningClass <em>Defining Class</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends ModelElementImpl implements Attribute {

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final VisibilityType VISIBILITY_EDEFAULT = VisibilityType.UNDEFINED;
	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected VisibilityType visibility = VISIBILITY_EDEFAULT;
	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final ScopeType SCOPE_EDEFAULT = ScopeType.CLASS;
	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected ScopeType scope = SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignature() <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNATURE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = "";
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;
	/**
	 * The default value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTIES_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected String properties = PROPERTIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class getDefiningClass() {
		if (eContainerFeatureID != ClassesPackage.ATTRIBUTE__DEFINING_CLASS)
			return null;
		return (org.unicase.model.classes.Class) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class basicGetDefiningClass() {
		if (eContainerFeatureID != ClassesPackage.ATTRIBUTE__DEFINING_CLASS)
			return null;
		return (org.unicase.model.classes.Class) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefiningClass(
			org.unicase.model.classes.Class newDefiningClass,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newDefiningClass,
				ClassesPackage.ATTRIBUTE__DEFINING_CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefiningClass(
			org.unicase.model.classes.Class newDefiningClass) {
		if (newDefiningClass != eInternalContainer()
				|| (eContainerFeatureID != ClassesPackage.ATTRIBUTE__DEFINING_CLASS && newDefiningClass != null)) {
			if (EcoreUtil.isAncestor(this, newDefiningClass))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDefiningClass != null)
				msgs = ((InternalEObject) newDefiningClass).eInverseAdd(this,
						ClassesPackage.CLASS__ATTRIBUTES,
						org.unicase.model.classes.Class.class, msgs);
			msgs = basicSetDefiningClass(newDefiningClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ATTRIBUTE__DEFINING_CLASS, newDefiningClass,
					newDefiningClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VisibilityType getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(VisibilityType newVisibility) {
		VisibilityType oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT
				: newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ATTRIBUTE__VISIBILITY, oldVisibility,
					visibility));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeType getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(ScopeType newScope) {
		ScopeType oldScope = scope;
		scope = newScope == null ? SCOPE_EDEFAULT : newScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ATTRIBUTE__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @return the signature of the method
	 * 
	 */
	public String getSignature() {
		String signature;

		signature = "";

		if (visibility != VisibilityType.UNDEFINED) {
			signature += visibility.getLiteral();
		}
		if (name != null && name.length() > 0) {
			signature = insertSpace(signature);
			signature += name;
		}
		if (type != null && type.length() > 0) {
			signature = insertSpace(signature);
			signature += ": ";
			signature += type;
		}

		if (defaultValue != null && defaultValue.length() > 0) {
			signature = insertSpace(signature);
			signature += "= ";
			signature += defaultValue;
		}

		if (properties != null && properties.length() > 0) {
			signature = insertSpace(signature);
			signature += "{";
			signature += properties;
			signature += "}";
		}

		return signature;
	}

	private String insertSpace(String signature) {
		if (signature.length() > 0) {
			signature += " ";
		}
		return signature;
	}

	/**
	 * <!-- begin-user-doc --> Sets and tries to parse the label. If it can be
	 * parsed, label attribute stays null and signature is used instead. <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 * @param newLabel
	 *            the input string which will be parsed.
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		if (!newLabel.equals(oldLabel)) {
			label = newLabel;

			String validSignatureRegExp;

			validSignatureRegExp = "";
			validSignatureRegExp += "(\\+|\\$|-|~)?\\s*"; // group1 ->
			// visibility
			validSignatureRegExp += "(\\w+)\\s*"; // group2 -> name
			validSignatureRegExp += "(?::\\s*(\\w+))?\\s*"; // group3 -> type
			validSignatureRegExp += "(?:=\\s*(\\w+))?\\s*"; // group4 ->
			// defaultValue
			validSignatureRegExp += "(?:\\{(.*)\\})?\\s*"; // group5 ->
			// annotations

			Pattern p = Pattern.compile(validSignatureRegExp);
			Matcher m = p.matcher(newLabel);
			boolean b = m.matches();

			if (b) {
				String literalString = m.group(1);
				if (literalString != null) {
					this.setVisibility(VisibilityType.get(literalString));
				} else {
					this.setVisibility(VisibilityType.UNDEFINED);
				}

				String nameString = m.group(2);
				if (nameString != null) {
					this.setName(nameString);
				} else {
					this.setName("Unnamed");
				}

				String returnTypeString = m.group(3);
				this.setType(returnTypeString);

				String defaultValueString = m.group(4);

				this.setDefaultValue(defaultValueString);

				String propertyString = m.group(5);

				this.setProperties(propertyString);

				label = null;
			}

			if (eNotificationRequired()) {
				eNotify(new ENotificationImpl(this, Notification.SET,
						ClassesPackage.ATTRIBUTE__SIGNATURE, oldLabel,
						getLabel()));
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> .<!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ATTRIBUTE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ATTRIBUTE__DEFAULT_VALUE, oldDefaultValue,
					defaultValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(String newProperties) {
		String oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ATTRIBUTE__PROPERTIES, oldProperties,
					properties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * If the label can not be parsed it is a string field. otherwise this returns the signature.
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> .<!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetDefiningClass(
					(org.unicase.model.classes.Class) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			return basicSetDefiningClass(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID) {
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			return eInternalContainer().eInverseRemove(this,
					ClassesPackage.CLASS__ATTRIBUTES,
					org.unicase.model.classes.Class.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			if (resolve)
				return getDefiningClass();
			return basicGetDefiningClass();
		case ClassesPackage.ATTRIBUTE__VISIBILITY:
			return getVisibility();
		case ClassesPackage.ATTRIBUTE__SCOPE:
			return getScope();
		case ClassesPackage.ATTRIBUTE__SIGNATURE:
			return getSignature();
		case ClassesPackage.ATTRIBUTE__TYPE:
			return getType();
		case ClassesPackage.ATTRIBUTE__DEFAULT_VALUE:
			return getDefaultValue();
		case ClassesPackage.ATTRIBUTE__PROPERTIES:
			return getProperties();
		case ClassesPackage.ATTRIBUTE__LABEL:
			return getLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			setDefiningClass((org.unicase.model.classes.Class) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__VISIBILITY:
			setVisibility((VisibilityType) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__SCOPE:
			setScope((ScopeType) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__TYPE:
			setType((String) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__DEFAULT_VALUE:
			setDefaultValue((String) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__PROPERTIES:
			setProperties((String) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__LABEL:
			setLabel((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			setDefiningClass((org.unicase.model.classes.Class) null);
			return;
		case ClassesPackage.ATTRIBUTE__VISIBILITY:
			setVisibility(VISIBILITY_EDEFAULT);
			return;
		case ClassesPackage.ATTRIBUTE__SCOPE:
			setScope(SCOPE_EDEFAULT);
			return;
		case ClassesPackage.ATTRIBUTE__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case ClassesPackage.ATTRIBUTE__DEFAULT_VALUE:
			setDefaultValue(DEFAULT_VALUE_EDEFAULT);
			return;
		case ClassesPackage.ATTRIBUTE__PROPERTIES:
			setProperties(PROPERTIES_EDEFAULT);
			return;
		case ClassesPackage.ATTRIBUTE__LABEL:
			setLabel(LABEL_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			return basicGetDefiningClass() != null;
		case ClassesPackage.ATTRIBUTE__VISIBILITY:
			return visibility != VISIBILITY_EDEFAULT;
		case ClassesPackage.ATTRIBUTE__SCOPE:
			return scope != SCOPE_EDEFAULT;
		case ClassesPackage.ATTRIBUTE__SIGNATURE:
			return SIGNATURE_EDEFAULT == null ? getSignature() != null
					: !SIGNATURE_EDEFAULT.equals(getSignature());
		case ClassesPackage.ATTRIBUTE__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT
					.equals(type);
		case ClassesPackage.ATTRIBUTE__DEFAULT_VALUE:
			return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null
					: !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
		case ClassesPackage.ATTRIBUTE__PROPERTIES:
			return PROPERTIES_EDEFAULT == null ? properties != null
					: !PROPERTIES_EDEFAULT.equals(properties);
		case ClassesPackage.ATTRIBUTE__LABEL:
			return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT
					.equals(label);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(", scope: ");
		result.append(scope);
		result.append(", type: ");
		result.append(type);
		result.append(", defaultValue: ");
		result.append(defaultValue);
		result.append(", properties: ");
		result.append(properties);
		result.append(", label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} // AttributeImpl
