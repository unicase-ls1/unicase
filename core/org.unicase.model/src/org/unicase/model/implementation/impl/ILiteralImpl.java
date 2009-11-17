/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.model.implementation.IEnumeration;
import org.unicase.model.implementation.ILiteral;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>ILiteral</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.implementation.impl.ILiteralImpl#getParentEnumeration <em>Parent Enumeration</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.ILiteralImpl#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ILiteralImpl extends UnicaseModelElementImpl implements ILiteral {
	/**
	 * The default value of the '{@link #getLiteral() <em>Literal</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLiteral() <em>Literal</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLiteral()
	 * @generated
	 * @ordered
	 */
	protected String literal = LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ILiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.ILITERAL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IEnumeration getParentEnumeration() {
		if (eContainerFeatureID() != ImplementationPackage.ILITERAL__PARENT_ENUMERATION)
			return null;
		return (IEnumeration) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IEnumeration basicGetParentEnumeration() {
		if (eContainerFeatureID() != ImplementationPackage.ILITERAL__PARENT_ENUMERATION)
			return null;
		return (IEnumeration) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParentEnumeration(IEnumeration newParentEnumeration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentEnumeration,
			ImplementationPackage.ILITERAL__PARENT_ENUMERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentEnumeration(IEnumeration newParentEnumeration) {
		if (newParentEnumeration != eInternalContainer()
			|| (eContainerFeatureID() != ImplementationPackage.ILITERAL__PARENT_ENUMERATION && newParentEnumeration != null)) {
			if (EcoreUtil.isAncestor(this, newParentEnumeration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentEnumeration != null)
				msgs = ((InternalEObject) newParentEnumeration).eInverseAdd(this,
					ImplementationPackage.IENUMERATION__LITERALS, IEnumeration.class, msgs);
			msgs = basicSetParentEnumeration(newParentEnumeration, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.ILITERAL__PARENT_ENUMERATION,
				newParentEnumeration, newParentEnumeration));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLiteral(String newLiteral) {
		String oldLiteral = literal;
		literal = newLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.ILITERAL__LITERAL, oldLiteral,
				literal));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ImplementationPackage.ILITERAL__PARENT_ENUMERATION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentEnumeration((IEnumeration) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ImplementationPackage.ILITERAL__PARENT_ENUMERATION:
			return basicSetParentEnumeration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ImplementationPackage.ILITERAL__PARENT_ENUMERATION:
			return eInternalContainer().eInverseRemove(this, ImplementationPackage.IENUMERATION__LITERALS,
				IEnumeration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ImplementationPackage.ILITERAL__PARENT_ENUMERATION:
			if (resolve)
				return getParentEnumeration();
			return basicGetParentEnumeration();
		case ImplementationPackage.ILITERAL__LITERAL:
			return getLiteral();
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
		case ImplementationPackage.ILITERAL__PARENT_ENUMERATION:
			setParentEnumeration((IEnumeration) newValue);
			return;
		case ImplementationPackage.ILITERAL__LITERAL:
			setLiteral((String) newValue);
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
		case ImplementationPackage.ILITERAL__PARENT_ENUMERATION:
			setParentEnumeration((IEnumeration) null);
			return;
		case ImplementationPackage.ILITERAL__LITERAL:
			setLiteral(LITERAL_EDEFAULT);
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
		case ImplementationPackage.ILITERAL__PARENT_ENUMERATION:
			return basicGetParentEnumeration() != null;
		case ImplementationPackage.ILITERAL__LITERAL:
			return LITERAL_EDEFAULT == null ? literal != null : !LITERAL_EDEFAULT.equals(literal);
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
		result.append(" (literal: ");
		result.append(literal);
		result.append(')');
		return result.toString();
	}

} // ILiteralImpl
