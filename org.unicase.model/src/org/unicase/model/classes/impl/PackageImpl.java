/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.classes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.PackageElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.classes.impl.PackageImpl#getContainedPackageElements <em>Contained Package Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageImpl extends PackageElementImpl implements
		org.unicase.model.classes.Package {
	/**
	 * The cached value of the '{@link #getContainedPackageElements()
	 * <em>Contained Package Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContainedPackageElements()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageElement> containedPackageElements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.PACKAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageElement> getContainedPackageElements() {
		if (containedPackageElements == null) {
			containedPackageElements = new EObjectContainmentWithInverseEList<PackageElement>(
					PackageElement.class, this,
					ClassesPackage.PACKAGE__CONTAINED_PACKAGE_ELEMENTS,
					ClassesPackage.PACKAGE_ELEMENT__PARENT_PACKAGE);
		}
		return containedPackageElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ClassesPackage.PACKAGE__CONTAINED_PACKAGE_ELEMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getContainedPackageElements())
					.basicAdd(otherEnd, msgs);
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
		case ClassesPackage.PACKAGE__CONTAINED_PACKAGE_ELEMENTS:
			return ((InternalEList<?>) getContainedPackageElements())
					.basicRemove(otherEnd, msgs);
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
		case ClassesPackage.PACKAGE__CONTAINED_PACKAGE_ELEMENTS:
			return getContainedPackageElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ClassesPackage.PACKAGE__CONTAINED_PACKAGE_ELEMENTS:
			getContainedPackageElements().clear();
			getContainedPackageElements().addAll(
					(Collection<? extends PackageElement>) newValue);
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
		case ClassesPackage.PACKAGE__CONTAINED_PACKAGE_ELEMENTS:
			getContainedPackageElements().clear();
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
		case ClassesPackage.PACKAGE__CONTAINED_PACKAGE_ELEMENTS:
			return containedPackageElements != null
					&& !containedPackageElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // PackageImpl
