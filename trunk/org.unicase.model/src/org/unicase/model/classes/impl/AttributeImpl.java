/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.model.classes.impl;

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
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getDefiningClass <em>Defining Class</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.AttributeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends ModelElementImpl implements Attribute {

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final VisibilityType VISIBILITY_EDEFAULT = VisibilityType.UNDEFINED;
	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected VisibilityType visibility = VISIBILITY_EDEFAULT;
	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final ScopeType SCOPE_EDEFAULT = ScopeType.UNDEFINED;
	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected ScopeType scope = SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignature() <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected String signature = SIGNATURE_EDEFAULT;
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = "";
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class getDefiningClass() {
		if (eContainerFeatureID != ClassesPackage.ATTRIBUTE__DEFINING_CLASS)
			return null;
		return (org.unicase.model.classes.Class) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisibilityType getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeType getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSignature() {
		String constructedSignature;

		if (signature != null) {
			return signature;
		}

		constructedSignature = "";

		if (visibility != VisibilityType.UNDEFINED) {
			constructedSignature += visibility.getLiteral();
			constructedSignature += " ";
		}

		if (name != null) {
			constructedSignature += name;
			constructedSignature += " ";
		}

		if (type != null) {
			constructedSignature += ": ";
			constructedSignature += type;
		}

		return constructedSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSignature(String newSignature) {
		String oldSignature = signature;
		signature = newSignature;

		String visibilityLiteral;
		String validSignatureRegExp;

		validSignatureRegExp = "";
		validSignatureRegExp += "(?:\\+|\\#|-|~)?\\s*";
		validSignatureRegExp += "\\w*\\s*";
		validSignatureRegExp += "(?::\\s*\\w*)?\\s*";
		validSignatureRegExp += "(?:=\\s*\\w*)?\\s*";
		validSignatureRegExp += "(?:\\{.*\\})?\\s*";

		if (newSignature.matches(validSignatureRegExp)) {
			if (newSignature.matches("(\\+|\\$|-|~)\\s.*")) {
				visibilityLiteral = newSignature.substring(0, 1);
				visibility = VisibilityType.get(visibilityLiteral);

				newSignature = newSignature
						.replaceFirst("(\\+|\\$|-|~)\\s", "");
			}

			newSignature = newSignature.trim();
			name = newSignature;

			signature = null;
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.ATTRIBUTE__SIGNATURE, oldSignature,
					getSignature()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			return getDefiningClass();
		case ClassesPackage.ATTRIBUTE__VISIBILITY:
			return getVisibility();
		case ClassesPackage.ATTRIBUTE__SCOPE:
			return getScope();
		case ClassesPackage.ATTRIBUTE__SIGNATURE:
			return getSignature();
		case ClassesPackage.ATTRIBUTE__TYPE:
			return getType();
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
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			setDefiningClass((org.unicase.model.classes.Class) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__VISIBILITY:
			setVisibility((VisibilityType) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__SCOPE:
			setScope((ScopeType) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__SIGNATURE:
			setSignature((String) newValue);
			return;
		case ClassesPackage.ATTRIBUTE__TYPE:
			setType((String) newValue);
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
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			setDefiningClass((org.unicase.model.classes.Class) null);
			return;
		case ClassesPackage.ATTRIBUTE__VISIBILITY:
			setVisibility(VISIBILITY_EDEFAULT);
			return;
		case ClassesPackage.ATTRIBUTE__SCOPE:
			setScope(SCOPE_EDEFAULT);
			return;
		case ClassesPackage.ATTRIBUTE__SIGNATURE:
			setSignature(SIGNATURE_EDEFAULT);
			return;
		case ClassesPackage.ATTRIBUTE__TYPE:
			setType(TYPE_EDEFAULT);
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
		case ClassesPackage.ATTRIBUTE__DEFINING_CLASS:
			return getDefiningClass() != null;
		case ClassesPackage.ATTRIBUTE__VISIBILITY:
			return visibility != VISIBILITY_EDEFAULT;
		case ClassesPackage.ATTRIBUTE__SCOPE:
			return scope != SCOPE_EDEFAULT;
		case ClassesPackage.ATTRIBUTE__SIGNATURE:
			return SIGNATURE_EDEFAULT == null ? signature != null
					: !SIGNATURE_EDEFAULT.equals(signature);
		case ClassesPackage.ATTRIBUTE__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT
					.equals(type);
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(", scope: ");
		result.append(scope);
		result.append(", signature: ");
		result.append(signature);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl
