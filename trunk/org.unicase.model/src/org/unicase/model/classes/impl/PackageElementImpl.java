/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
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
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.PackageElement;
import org.unicase.model.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Package Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.classes.impl.PackageElementImpl#getParentPackage <em>Parent Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PackageElementImpl extends ModelElementImpl implements
		PackageElement {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.PACKAGE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Package getParentPackage() {
		if (eContainerFeatureID != ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE)
			return null;
		return (org.unicase.model.classes.Package) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentPackage(
			org.unicase.model.classes.Package newParentPackage,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentPackage,
				ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentPackage(
			org.unicase.model.classes.Package newParentPackage) {
		if (newParentPackage != eInternalContainer()
				|| (eContainerFeatureID != ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE && newParentPackage != null)) {
			if (EcoreUtil.isAncestor(this, newParentPackage))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentPackage != null)
				msgs = ((InternalEObject) newParentPackage).eInverseAdd(this,
						ClassesPackage.PACKAGE__CONTAINED_PACKAGE_ELEMENTS,
						org.unicase.model.classes.Package.class, msgs);
			msgs = basicSetParentPackage(newParentPackage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE,
					newParentPackage, newParentPackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentPackage(
					(org.unicase.model.classes.Package) otherEnd, msgs);
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
		case ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE:
			return basicSetParentPackage(null, msgs);
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
		case ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE:
			return eInternalContainer().eInverseRemove(this,
					ClassesPackage.PACKAGE__CONTAINED_PACKAGE_ELEMENTS,
					org.unicase.model.classes.Package.class, msgs);
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
		case ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE:
			return getParentPackage();
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
		case ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE:
			setParentPackage((org.unicase.model.classes.Package) newValue);
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
		case ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE:
			setParentPackage((org.unicase.model.classes.Package) null);
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
		case ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE:
			return getParentPackage() != null;
		}
		return super.eIsSet(featureID);
	}

} // PackageElementImpl
