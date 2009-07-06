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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCannonizer;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Change Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangePackageImpl extends EObjectImpl implements ChangePackage {
	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> operations;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

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
	public EList<AbstractOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList.Resolving<AbstractOperation>(
					AbstractOperation.class, this,
					VersioningPackage.CHANGE_PACKAGE__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList.Resolving<Event>(Event.class,
					this, VersioningPackage.CHANGE_PACKAGE__EVENTS);
		}
		return events;
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Reverse the change package. That applying the
	 * change package and the reversed change package to a project is a nop.
	 * 
	 * @return the reversed change package <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ChangePackage reverse() {
		ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		// reverse subOperations and add in reverse order
		EList<AbstractOperation> copiedSubOperations = changePackage
				.getOperations();
		for (AbstractOperation abstractOperation : getOperations()) {
			copiedSubOperations.add(0, abstractOperation.reverse());
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
		// for (ChangeContainer changeContainer : getChangeContainers()) {
		// changeContainer.apply(project);
		// }
		for (AbstractOperation abstractOperation : getOperations()) {
			// MK FIXME hack:
			try {
				abstractOperation.apply(project);
			} catch (IllegalStateException e) {

			}
		}
	}

	/**
	 * <!-- begin-user-doc --> Cannonize the change package, that is remove all
	 * operations that are masked by later operations. <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void cannonize() {
		OperationsCannonizer.cannonize(getOperations());
	}

	// end of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			return ((InternalEList<?>) getOperations()).basicRemove(otherEnd,
					msgs);
		case VersioningPackage.CHANGE_PACKAGE__EVENTS:
			return ((InternalEList<?>) getEvents()).basicRemove(otherEnd, msgs);
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
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			return getOperations();
		case VersioningPackage.CHANGE_PACKAGE__EVENTS:
			return getEvents();
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
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			getOperations().clear();
			getOperations().addAll(
					(Collection<? extends AbstractOperation>) newValue);
			return;
		case VersioningPackage.CHANGE_PACKAGE__EVENTS:
			getEvents().clear();
			getEvents().addAll((Collection<? extends Event>) newValue);
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
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			getOperations().clear();
			return;
		case VersioningPackage.CHANGE_PACKAGE__EVENTS:
			getEvents().clear();
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
		case VersioningPackage.CHANGE_PACKAGE__OPERATIONS:
			return operations != null && !operations.isEmpty();
		case VersioningPackage.CHANGE_PACKAGE__EVENTS:
			return events != null && !events.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ChangePackageImpl
