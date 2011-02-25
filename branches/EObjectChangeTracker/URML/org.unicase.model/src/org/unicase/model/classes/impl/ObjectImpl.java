/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.classes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.impl.ModelElementImpl;

/*
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Object</b></em>'. <!-- end-user-doc --> <p> The
 * following features are implemented: <ul> <li>{@link org.unicase.model.classes.impl.ObjectImpl#getClass_
 * <em>Class</em>}</li> </ul> </p>
 * @generated
 */
public class ObjectImpl extends ModelElementImpl implements org.unicase.model.classes.Object {
	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected org.unicase.model.classes.Class class_;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.OBJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject) class_;
			class_ = (org.unicase.model.classes.Class) eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.OBJECT__CLASS, oldClass,
						class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClass(org.unicase.model.classes.Class newClass, NotificationChain msgs) {
		org.unicase.model.classes.Class oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				ClassesPackage.OBJECT__CLASS, oldClass, newClass);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(org.unicase.model.classes.Class newClass) {
		if (newClass != class_) {
			NotificationChain msgs = null;
			if (class_ != null)
				msgs = ((InternalEObject) class_).eInverseRemove(this, ClassesPackage.CLASS__INSTANCES,
					org.unicase.model.classes.Class.class, msgs);
			if (newClass != null)
				msgs = ((InternalEObject) newClass).eInverseAdd(this, ClassesPackage.CLASS__INSTANCES,
					org.unicase.model.classes.Class.class, msgs);
			msgs = basicSetClass(newClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.OBJECT__CLASS, newClass, newClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.OBJECT__CLASS:
			if (class_ != null)
				msgs = ((InternalEObject) class_).eInverseRemove(this, ClassesPackage.CLASS__INSTANCES,
					org.unicase.model.classes.Class.class, msgs);
			return basicSetClass((org.unicase.model.classes.Class) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.OBJECT__CLASS:
			return basicSetClass(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ClassesPackage.OBJECT__CLASS:
			if (resolve)
				return getClass_();
			return basicGetClass();
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
		case ClassesPackage.OBJECT__CLASS:
			setClass((org.unicase.model.classes.Class) newValue);
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
		case ClassesPackage.OBJECT__CLASS:
			setClass((org.unicase.model.classes.Class) null);
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
		case ClassesPackage.OBJECT__CLASS:
			return class_ != null;
		}
		return super.eIsSet(featureID);
	}

} // ObjectImpl
