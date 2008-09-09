/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Change Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getChangeContainers <em>Change Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangePackageImpl extends EObjectImpl implements ChangePackage {
	/**
	 * The cached value of the '{@link #getChangeContainers()
	 * <em>Change Containers</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChangeContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<ChangeContainer> changeContainers;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.CHANGE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChangeContainer> getChangeContainers() {
		if (changeContainers == null) {
			changeContainers = new EObjectContainmentEList.Resolving<ChangeContainer>(
					ChangeContainer.class, this,
					VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS);
		}
		return changeContainers;
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ChangePackage reverse() {
		ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		//add reversed change containers in reversed order
		for (ChangeContainer changeContainer : getChangeContainers()) {
			changePackage.getChangeContainers().add(0,
					changeContainer.reverse());
		}
		return changePackage;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.ChangePackage#apply(org.unicase.model.Project)
	 * @generated NOT
	 */
	public void apply(Project project) {
		for (ChangeContainer changeContainer : getChangeContainers()) {
			changeContainer.apply(project);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void init(Project project,
			ChangeDescription backwardChangeDescription) {
		ChangeContainer changeContainer = ChangeContainerFactory.eINSTANCE
				.createChangeContainer();
		changeContainer.init(project, backwardChangeDescription);
		getChangeContainers().add(changeContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<AbstractOperation> getOperations() {
		// TODO: implement this method
		// it is perhaps a helper method to directly get all operations contained 
		// in a change package. 
		// without this method, one should go through all ChangeConatainers of a
		// ChangePackage and gather all operations contained in each of them. 

		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			return ((InternalEList<?>) getChangeContainers()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			return getChangeContainers();
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
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			getChangeContainers().clear();
			getChangeContainers().addAll(
					(Collection<? extends ChangeContainer>) newValue);
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
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			getChangeContainers().clear();
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
		case VersioningPackage.CHANGE_PACKAGE__CHANGE_CONTAINERS:
			return changeContainers != null && !changeContainers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ChangePackageImpl
