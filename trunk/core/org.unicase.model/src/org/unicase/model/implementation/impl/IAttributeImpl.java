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
import org.unicase.model.implementation.IAttribute;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IEnumeration;
import org.unicase.model.implementation.IPrimitiveType;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IAttribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.implementation.impl.IAttributeImpl#getParentClass <em>Parent Class</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IAttributeImpl#isId <em>Id</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IAttributeImpl#getType <em>Type</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IAttributeImpl#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IAttributeImpl extends IFeatureImpl implements IAttribute {
	/**
	 * The default value of the '{@link #isId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isId()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isId()
	 * @generated
	 * @ordered
	 */
	protected boolean id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final IPrimitiveType TYPE_EDEFAULT = IPrimitiveType.STRING;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected IPrimitiveType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnumeration() <em>Enumeration</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getEnumeration()
	 * @generated
	 * @ordered
	 */
	protected IEnumeration enumeration;

	/**
	 * This is true if the Enumeration reference has been set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean enumerationESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.IATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IClass getParentClass() {
		if (eContainerFeatureID() != ImplementationPackage.IATTRIBUTE__PARENT_CLASS)
			return null;
		return (IClass) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IClass basicGetParentClass() {
		if (eContainerFeatureID() != ImplementationPackage.IATTRIBUTE__PARENT_CLASS)
			return null;
		return (IClass) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParentClass(IClass newParentClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentClass, ImplementationPackage.IATTRIBUTE__PARENT_CLASS,
			msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentClass(IClass newParentClass) {
		if (newParentClass != eInternalContainer()
			|| (eContainerFeatureID() != ImplementationPackage.IATTRIBUTE__PARENT_CLASS && newParentClass != null)) {
			if (EcoreUtil.isAncestor(this, newParentClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentClass != null)
				msgs = ((InternalEObject) newParentClass).eInverseAdd(this, ImplementationPackage.ICLASS__ATTRIBUTES,
					IClass.class, msgs);
			msgs = basicSetParentClass(newParentClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IATTRIBUTE__PARENT_CLASS,
				newParentClass, newParentClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(boolean newId) {
		boolean oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IATTRIBUTE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IPrimitiveType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(IPrimitiveType newType) {
		IPrimitiveType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IATTRIBUTE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IEnumeration getEnumeration() {
		if (enumeration != null && enumeration.eIsProxy()) {
			InternalEObject oldEnumeration = (InternalEObject) enumeration;
			enumeration = (IEnumeration) eResolveProxy(oldEnumeration);
			if (enumeration != oldEnumeration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						ImplementationPackage.IATTRIBUTE__ENUMERATION, oldEnumeration, enumeration));
			}
		}
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IEnumeration basicGetEnumeration() {
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetEnumeration(IEnumeration newEnumeration, NotificationChain msgs) {
		IEnumeration oldEnumeration = enumeration;
		enumeration = newEnumeration;
		boolean oldEnumerationESet = enumerationESet;
		enumerationESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				ImplementationPackage.IATTRIBUTE__ENUMERATION, oldEnumeration, newEnumeration, !oldEnumerationESet);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEnumeration(IEnumeration newEnumeration) {
		if (newEnumeration != enumeration) {
			NotificationChain msgs = null;
			if (enumeration != null)
				msgs = ((InternalEObject) enumeration).eInverseRemove(this,
					ImplementationPackage.IENUMERATION__ATTRIBUTES, IEnumeration.class, msgs);
			if (newEnumeration != null)
				msgs = ((InternalEObject) newEnumeration).eInverseAdd(this,
					ImplementationPackage.IENUMERATION__ATTRIBUTES, IEnumeration.class, msgs);
			msgs = basicSetEnumeration(newEnumeration, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else {
			boolean oldEnumerationESet = enumerationESet;
			enumerationESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IATTRIBUTE__ENUMERATION,
					newEnumeration, newEnumeration, !oldEnumerationESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicUnsetEnumeration(NotificationChain msgs) {
		IEnumeration oldEnumeration = enumeration;
		enumeration = null;
		boolean oldEnumerationESet = enumerationESet;
		enumerationESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET,
				ImplementationPackage.IATTRIBUTE__ENUMERATION, oldEnumeration, null, oldEnumerationESet);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetEnumeration() {
		if (enumeration != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject) enumeration).eInverseRemove(this, ImplementationPackage.IENUMERATION__ATTRIBUTES,
				IEnumeration.class, msgs);
			msgs = basicUnsetEnumeration(msgs);
			if (msgs != null)
				msgs.dispatch();
		} else {
			boolean oldEnumerationESet = enumerationESet;
			enumerationESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, ImplementationPackage.IATTRIBUTE__ENUMERATION,
					null, null, oldEnumerationESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetEnumeration() {
		return enumerationESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ImplementationPackage.IATTRIBUTE__PARENT_CLASS:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentClass((IClass) otherEnd, msgs);
		case ImplementationPackage.IATTRIBUTE__ENUMERATION:
			if (enumeration != null)
				msgs = ((InternalEObject) enumeration).eInverseRemove(this,
					ImplementationPackage.IENUMERATION__ATTRIBUTES, IEnumeration.class, msgs);
			return basicSetEnumeration((IEnumeration) otherEnd, msgs);
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
		case ImplementationPackage.IATTRIBUTE__PARENT_CLASS:
			return basicSetParentClass(null, msgs);
		case ImplementationPackage.IATTRIBUTE__ENUMERATION:
			return basicUnsetEnumeration(msgs);
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
		case ImplementationPackage.IATTRIBUTE__PARENT_CLASS:
			return eInternalContainer().eInverseRemove(this, ImplementationPackage.ICLASS__ATTRIBUTES, IClass.class,
				msgs);
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
		case ImplementationPackage.IATTRIBUTE__PARENT_CLASS:
			if (resolve)
				return getParentClass();
			return basicGetParentClass();
		case ImplementationPackage.IATTRIBUTE__ID:
			return isId();
		case ImplementationPackage.IATTRIBUTE__TYPE:
			return getType();
		case ImplementationPackage.IATTRIBUTE__ENUMERATION:
			if (resolve)
				return getEnumeration();
			return basicGetEnumeration();
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
		case ImplementationPackage.IATTRIBUTE__PARENT_CLASS:
			setParentClass((IClass) newValue);
			return;
		case ImplementationPackage.IATTRIBUTE__ID:
			setId((Boolean) newValue);
			return;
		case ImplementationPackage.IATTRIBUTE__TYPE:
			setType((IPrimitiveType) newValue);
			return;
		case ImplementationPackage.IATTRIBUTE__ENUMERATION:
			setEnumeration((IEnumeration) newValue);
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
		case ImplementationPackage.IATTRIBUTE__PARENT_CLASS:
			setParentClass((IClass) null);
			return;
		case ImplementationPackage.IATTRIBUTE__ID:
			setId(ID_EDEFAULT);
			return;
		case ImplementationPackage.IATTRIBUTE__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case ImplementationPackage.IATTRIBUTE__ENUMERATION:
			unsetEnumeration();
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
		case ImplementationPackage.IATTRIBUTE__PARENT_CLASS:
			return basicGetParentClass() != null;
		case ImplementationPackage.IATTRIBUTE__ID:
			return id != ID_EDEFAULT;
		case ImplementationPackage.IATTRIBUTE__TYPE:
			return type != TYPE_EDEFAULT;
		case ImplementationPackage.IATTRIBUTE__ENUMERATION:
			return isSetEnumeration();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} // IAttributeImpl
