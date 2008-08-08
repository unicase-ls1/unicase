/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.model.classes.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.Method;
import org.unicase.model.classes.MethodArgument;
import org.unicase.model.classes.ScopeType;
import org.unicase.model.classes.VisibilityType;
import org.unicase.model.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.classes.impl.MethodImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodImpl#getDefiningClass <em>Defining Class</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated NOT
 */
public class MethodImpl extends ModelElementImpl implements Method, Adapter {
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
	 * The default value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected static final String RETURN_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected String returnType = RETURN_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignature() <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNATURE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<MethodArgument> arguments;

	/**
	 * The default value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected String properties = PROPERTIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MethodImpl() {
		super();
		this.eAdapters().add((Adapter) this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */

	public void notifyChanged(Notification notification) {
		Method method = (Method) notification.getNotifier();
		if (method.equals(this)) {
			int featureId = notification.getFeatureID(Method.class);

			if (featureId == ClassesPackage.METHOD__RETURN_TYPE
					|| featureId == ClassesPackage.METHOD__NAME
					|| featureId == ClassesPackage.METHOD__VISIBILITY) {

				String oldLabel = getLabel();

				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.SET,
							ClassesPackage.METHOD__LABEL, oldLabel, oldLabel));
				}

			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.METHOD;
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
					ClassesPackage.METHOD__VISIBILITY, oldVisibility,
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
					ClassesPackage.METHOD__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class getDefiningClass() {
		if (eContainerFeatureID != ClassesPackage.METHOD__DEFINING_CLASS)
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
				ClassesPackage.METHOD__DEFINING_CLASS, msgs);
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
				|| (eContainerFeatureID != ClassesPackage.METHOD__DEFINING_CLASS && newDefiningClass != null)) {
			if (EcoreUtil.isAncestor(this, newDefiningClass))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDefiningClass != null)
				msgs = ((InternalEObject) newDefiningClass).eInverseAdd(this,
						ClassesPackage.CLASS__METHODS,
						org.unicase.model.classes.Class.class, msgs);
			msgs = basicSetDefiningClass(newDefiningClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.METHOD__DEFINING_CLASS, newDefiningClass,
					newDefiningClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(String newReturnType) {
		String oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.METHOD__RETURN_TYPE, oldReturnType,
					returnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSignature() {
		String signature;

		signature = "";

		// a signature has the form
		// Visibility methodName (argument1, argument2) : returnType {properties}

		if (this.getVisibility() != VisibilityType.UNDEFINED) {
			signature += this.getVisibility().getLiteral();
			signature += " ";
		}

		if (this.getName() != null) {
			signature += this.getName();
			signature += " ";
		}

		if (arguments != null && !arguments.isEmpty()) {
			signature += "(";
			for (Iterator<MethodArgument> argumentIterator = this
					.getArguments().iterator(); argumentIterator.hasNext();) {
				MethodArgument currentArgument = (MethodArgument) argumentIterator
						.next();
				signature += currentArgument.getLabel();

				if (argumentIterator.hasNext()) {
					signature += ", ";
				}
			}

			signature += ") ";
		}

		if (returnType != null && returnType.length() > 0) {
			signature += ": ";
			signature += this.getReturnType();
			signature += " ";
		}

		if (properties != null && properties.length() > 0) {
			signature += "{";
			signature += this.getProperties();
			signature += "}";
		}

		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MethodArgument> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<MethodArgument>(
					MethodArgument.class, this,
					ClassesPackage.METHOD__ARGUMENTS);
		}
		return arguments;
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
		case ClassesPackage.METHOD__DEFINING_CLASS:
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
		case ClassesPackage.METHOD__DEFINING_CLASS:
			return basicSetDefiningClass(null, msgs);
		case ClassesPackage.METHOD__ARGUMENTS:
			return ((InternalEList<?>) getArguments()).basicRemove(otherEnd,
					msgs);
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
		case ClassesPackage.METHOD__DEFINING_CLASS:
			return eInternalContainer().eInverseRemove(this,
					ClassesPackage.CLASS__METHODS,
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
		case ClassesPackage.METHOD__VISIBILITY:
			return getVisibility();
		case ClassesPackage.METHOD__SCOPE:
			return getScope();
		case ClassesPackage.METHOD__DEFINING_CLASS:
			return getDefiningClass();
		case ClassesPackage.METHOD__RETURN_TYPE:
			return getReturnType();
		case ClassesPackage.METHOD__SIGNATURE:
			return getSignature();
		case ClassesPackage.METHOD__ARGUMENTS:
			return getArguments();
		case ClassesPackage.METHOD__PROPERTIES:
			return getProperties();
		case ClassesPackage.METHOD__LABEL:
			return getLabel();
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
		case ClassesPackage.METHOD__VISIBILITY:
			setVisibility((VisibilityType) newValue);
			return;
		case ClassesPackage.METHOD__SCOPE:
			setScope((ScopeType) newValue);
			return;
		case ClassesPackage.METHOD__DEFINING_CLASS:
			setDefiningClass((org.unicase.model.classes.Class) newValue);
			return;
		case ClassesPackage.METHOD__RETURN_TYPE:
			setReturnType((String) newValue);
			return;
		case ClassesPackage.METHOD__ARGUMENTS:
			getArguments().clear();
			getArguments().addAll(
					(Collection<? extends MethodArgument>) newValue);
			return;
		case ClassesPackage.METHOD__PROPERTIES:
			setProperties((String) newValue);
			return;
		case ClassesPackage.METHOD__LABEL:
			setLabel((String) newValue);
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
		case ClassesPackage.METHOD__VISIBILITY:
			setVisibility(VISIBILITY_EDEFAULT);
			return;
		case ClassesPackage.METHOD__SCOPE:
			setScope(SCOPE_EDEFAULT);
			return;
		case ClassesPackage.METHOD__DEFINING_CLASS:
			setDefiningClass((org.unicase.model.classes.Class) null);
			return;
		case ClassesPackage.METHOD__RETURN_TYPE:
			setReturnType(RETURN_TYPE_EDEFAULT);
			return;
		case ClassesPackage.METHOD__ARGUMENTS:
			getArguments().clear();
			return;
		case ClassesPackage.METHOD__PROPERTIES:
			setProperties(PROPERTIES_EDEFAULT);
			return;
		case ClassesPackage.METHOD__LABEL:
			setLabel(LABEL_EDEFAULT);
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
		case ClassesPackage.METHOD__VISIBILITY:
			return visibility != VISIBILITY_EDEFAULT;
		case ClassesPackage.METHOD__SCOPE:
			return scope != SCOPE_EDEFAULT;
		case ClassesPackage.METHOD__DEFINING_CLASS:
			return getDefiningClass() != null;
		case ClassesPackage.METHOD__RETURN_TYPE:
			return RETURN_TYPE_EDEFAULT == null ? returnType != null
					: !RETURN_TYPE_EDEFAULT.equals(returnType);
		case ClassesPackage.METHOD__SIGNATURE:
			return SIGNATURE_EDEFAULT == null ? getSignature() != null
					: !SIGNATURE_EDEFAULT.equals(getSignature());
		case ClassesPackage.METHOD__ARGUMENTS:
			return arguments != null && !arguments.isEmpty();
		case ClassesPackage.METHOD__PROPERTIES:
			return PROPERTIES_EDEFAULT == null ? properties != null
					: !PROPERTIES_EDEFAULT.equals(properties);
		case ClassesPackage.METHOD__LABEL:
			return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT
					.equals(label);
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
		result.append(", returnType: ");
		result.append(returnType);
		result.append(", properties: ");
		result.append(properties);
		result.append(", label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(String newProperties) {
		String oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.METHOD__PROPERTIES, oldProperties,
					properties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		if (label != null) {
			return label;
		} else {
			return this.getSignature();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLabel(String newLabel) {
		String oldLabel = getLabel();
		if (!newLabel.equals(oldLabel)) {
			label = newLabel;

			String signatureRegExp;

			signatureRegExp = "";
			signatureRegExp += "(?:\\+|\\-|\\~|\\#)?\\s*"; //visibility 
			signatureRegExp += "\\w+\\s*"; //name
			signatureRegExp += "(?:\\("; //opening parenthesis 
			signatureRegExp += "(?:.*\\,)*(?:.*)"; //arguments separated by commas				
			signatureRegExp += "\\))?\\s*"; //matching closing parenthesis 
			signatureRegExp += "(:\\s*\\w+)?\\s*"; //returnType 					
			signatureRegExp += "(\\{.*\\})?\\s*"; //properties

			if (newLabel.matches(signatureRegExp)) {
				//Get the visibility
				String visibilityRegExp;
				visibilityRegExp = "(?:\\+|\\-|\\~|\\#)?";

				Pattern p = Pattern.compile(visibilityRegExp);
				Matcher m = p.matcher(newLabel);
				boolean b = m.find();

				if (b) {
					String literalString = m.group();
					this.setVisibility(VisibilityType.get(literalString));
				}

				//Get the method name
				String methodRegExp;
				methodRegExp = "\\w+";

				p = Pattern.compile(methodRegExp);
				m = p.matcher(newLabel);
				b = m.find();

				if (b) {
					String nameString = m.group();
					this.setName(nameString);
				}

				//Get the arguments
				String argumentRegExp;

				argumentRegExp = "\\("; //opening parenthesis 
				argumentRegExp += "(?:.*\\,)*(?:.*)"; //arguments separated by commas				
				argumentRegExp += "\\)"; //matching closing parenthesis
				argumentRegExp += "(?!\\w*\\})";

				p = Pattern.compile(argumentRegExp);
				m = p.matcher(newLabel);
				b = m.find();

				if (b) {
					String argumentString = m.group();
					argumentString = argumentString.replaceAll("\\(", "");
					argumentString = argumentString.replaceAll("\\)", "");

					String argumentStrings[] = argumentString.split(",");

					this.getArguments().removeAll(this.getArguments());

					for (String string : argumentStrings) {
						MethodArgument newMethodArgument = new MethodArgumentImpl();
						newMethodArgument.setLabel(string);

						this.getArguments().add(newMethodArgument);
					}
				}

				//Get the return type
				String returnTypeRegExp;
				returnTypeRegExp = "(?<=\\:\\s{0,5})";
				//Ah, I love Java RegExp!
				//We are using alternating width! lookbehinds to make sure the returnType
				//is depicted after a colon

				returnTypeRegExp += "(\\w+)";
				returnTypeRegExp += "(?![^\\{]*\\))"; //returnType 	

				p = Pattern.compile(returnTypeRegExp);
				m = p.matcher(newLabel);
				b = m.find();

				if (b) {
					String returnTypeString = m.group();
					this.setReturnType(returnTypeString);
				}

				//Get the properties
				String propertyRegExp;
				propertyRegExp = "(?<=\\{)(.+)(?=\\})";

				p = Pattern.compile(propertyRegExp);
				m = p.matcher(newLabel);
				b = m.find();

				if (b) {
					String propertyString = m.group();
					this.setProperties(propertyString);
				}

				label = null;
			}
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.METHOD__SIGNATURE, oldLabel, getLabel()));
	}

	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAdapterForType(Object type) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub

	}

} //MethodImpl
