/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.UnkownFeatureException;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Multi Attribute Move Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeMoveOperationImpl#getOldIndex
 * <em>Old Index</em>}</li>
 * <li>
 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeMoveOperationImpl#getNewIndex
 * <em>New Index</em>}</li>
 * <li>
 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeMoveOperationImpl#getReferencedValue
 * <em>Referenced Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MultiAttributeMoveOperationImpl extends FeatureOperationImpl implements MultiAttributeMoveOperation {
	/**
	 * The default value of the '{@link #getOldIndex() <em>Old Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOldIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int OLD_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOldIndex() <em>Old Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOldIndex()
	 * @generated
	 * @ordered
	 */
	protected int oldIndex = OLD_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewIndex() <em>New Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int NEW_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNewIndex() <em>New Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewIndex()
	 * @generated
	 * @ordered
	 */
	protected int newIndex = NEW_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferencedValue() <em>Referenced Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getReferencedValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object REFERENCED_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferencedValue() <em>Referenced Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getReferencedValue()
	 * @generated
	 * @ordered
	 */
	protected Object referencedValue = REFERENCED_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiAttributeMoveOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.MULTI_ATTRIBUTE_MOVE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getOldIndex() {
		return oldIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOldIndex(int newOldIndex) {
		int oldOldIndex = oldIndex;
		oldIndex = newOldIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX, oldOldIndex, oldIndex));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getNewIndex() {
		return newIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNewIndex(int newNewIndex) {
		int oldNewIndex = newIndex;
		newIndex = newNewIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX, oldNewIndex, newIndex));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getReferencedValue() {
		return referencedValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReferencedValue(Object newReferencedValue) {
		Object oldReferencedValue = referencedValue;
		referencedValue = newReferencedValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__REFERENCED_VALUE, oldReferencedValue, referencedValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX:
			return getOldIndex();
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX:
			return getNewIndex();
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__REFERENCED_VALUE:
			return getReferencedValue();
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
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX:
			setOldIndex((Integer) newValue);
			return;
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX:
			setNewIndex((Integer) newValue);
			return;
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__REFERENCED_VALUE:
			setReferencedValue(newValue);
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
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX:
			setOldIndex(OLD_INDEX_EDEFAULT);
			return;
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX:
			setNewIndex(NEW_INDEX_EDEFAULT);
			return;
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__REFERENCED_VALUE:
			setReferencedValue(REFERENCED_VALUE_EDEFAULT);
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
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX:
			return oldIndex != OLD_INDEX_EDEFAULT;
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX:
			return newIndex != NEW_INDEX_EDEFAULT;
		case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION__REFERENCED_VALUE:
			return REFERENCED_VALUE_EDEFAULT == null ? referencedValue != null : !REFERENCED_VALUE_EDEFAULT
				.equals(referencedValue);
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
		result.append(" (oldIndex: ");
		result.append(oldIndex);
		result.append(", newIndex: ");
		result.append(newIndex);
		result.append(", referencedValue: ");
		result.append(referencedValue);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#apply(org.eclipse.emf.emfstore.common.model.Project)
	 */
	public void apply(IdEObjectCollection project) {
		EObject modelElement = project.getModelElement(getModelElementId());
		if (modelElement == null) {
			return;
		}

		if (getNewIndex() < 0 || getOldIndex() < 0) {
			return;
		}

		EAttribute feature;
		try {
			feature = (EAttribute) getFeature(modelElement);
			@SuppressWarnings("unchecked")
			EList<Object> list = (EList<Object>) modelElement.eGet(feature);
			if (list.size() > getOldIndex() && list.size() > getNewIndex()) {
				list.move(getNewIndex(), getOldIndex());
			}

		} catch (UnkownFeatureException e) {
			// we ignore any non applicable o
		}
	}

	@Override
	public AbstractOperation reverse() {
		MultiAttributeMoveOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeMoveOperation();
		super.reverse(operation);
		operation.setNewIndex(getOldIndex());
		operation.setOldIndex(getNewIndex());
		operation.setReferencedValue(getReferencedValue());
		return operation;
	}

} // MultiAttributeMoveOperationImpl
