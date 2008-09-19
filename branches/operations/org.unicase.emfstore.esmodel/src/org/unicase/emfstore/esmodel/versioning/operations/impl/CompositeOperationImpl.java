/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl#getAtomicOperations <em>Atomic Operations</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl#getCompositeName <em>Composite Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl#getCompositeDescription <em>Composite Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeOperationImpl extends AbstractOperationImpl implements
		CompositeOperation {
	/**
	 * The cached value of the '{@link #getAtomicOperations() <em>Atomic Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtomicOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> atomicOperations;

	/**
	 * The default value of the '{@link #getCompositeName() <em>Composite Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeName()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPOSITE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCompositeName() <em>Composite Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeName()
	 * @generated
	 * @ordered
	 */
	protected String compositeName = COMPOSITE_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getCompositeDescription() <em>Composite Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPOSITE_DESCRIPTION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCompositeDescription() <em>Composite Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeDescription()
	 * @generated
	 * @ordered
	 */
	protected String compositeDescription = COMPOSITE_DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.COMPOSITE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractOperation> getAtomicOperations() {
		if (atomicOperations == null) {
			atomicOperations = new EObjectContainmentEList.Resolving<AbstractOperation>(
					AbstractOperation.class, this,
					OperationsPackage.COMPOSITE_OPERATION__ATOMIC_OPERATIONS);
		}
		return atomicOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompositeName() {
		return compositeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeName(String newCompositeName) {
		String oldCompositeName = compositeName;
		compositeName = newCompositeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME,
					oldCompositeName, compositeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompositeDescription() {
		return compositeDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeDescription(String newCompositeDescription) {
		String oldCompositeDescription = compositeDescription;
		compositeDescription = newCompositeDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION,
					oldCompositeDescription, compositeDescription));
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
		case OperationsPackage.COMPOSITE_OPERATION__ATOMIC_OPERATIONS:
			return ((InternalEList<?>) getAtomicOperations()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.COMPOSITE_OPERATION__ATOMIC_OPERATIONS:
			return getAtomicOperations();
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME:
			return getCompositeName();
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION:
			return getCompositeDescription();
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
		case OperationsPackage.COMPOSITE_OPERATION__ATOMIC_OPERATIONS:
			getAtomicOperations().clear();
			getAtomicOperations().addAll(
					(Collection<? extends AbstractOperation>) newValue);
			return;
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME:
			setCompositeName((String) newValue);
			return;
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION:
			setCompositeDescription((String) newValue);
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
		case OperationsPackage.COMPOSITE_OPERATION__ATOMIC_OPERATIONS:
			getAtomicOperations().clear();
			return;
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME:
			setCompositeName(COMPOSITE_NAME_EDEFAULT);
			return;
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION:
			setCompositeDescription(COMPOSITE_DESCRIPTION_EDEFAULT);
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
		case OperationsPackage.COMPOSITE_OPERATION__ATOMIC_OPERATIONS:
			return atomicOperations != null && !atomicOperations.isEmpty();
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME:
			return COMPOSITE_NAME_EDEFAULT == null ? compositeName != null
					: !COMPOSITE_NAME_EDEFAULT.equals(compositeName);
		case OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION:
			return COMPOSITE_DESCRIPTION_EDEFAULT == null ? compositeDescription != null
					: !COMPOSITE_DESCRIPTION_EDEFAULT
							.equals(compositeDescription);
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
		result.append(" (compositeName: ");
		result.append(compositeName);
		result.append(", compositeDescription: ");
		result.append(compositeDescription);
		result.append(')');
		return result.toString();
	}

	@Override
	public void apply(Project project) {
		
	}

	@Override
	public boolean canApply(Project project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractOperation reverse() {
		// TODO Auto-generated method stub
		return null;
	}

} //CompositeOperationImpl
