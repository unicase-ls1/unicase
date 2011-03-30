/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.UnkownFeatureException;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Multi Attribute Set Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeSetOperationImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeSetOperationImpl#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiAttributeSetOperationImpl#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiAttributeSetOperationImpl extends FeatureOperationImpl implements MultiAttributeSetOperation {
	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object OLD_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected Object oldValue = OLD_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object NEW_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected Object newValue = NEW_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiAttributeSetOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.MULTI_ATTRIBUTE_SET_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOldValue() {
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldValue(Object newOldValue) {
		Object oldOldValue = oldValue;
		oldValue = newOldValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__OLD_VALUE, oldOldValue, oldValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(Object newNewValue) {
		Object oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__NEW_VALUE, oldNewValue, newValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__INDEX:
				return getIndex();
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__OLD_VALUE:
				return getOldValue();
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__NEW_VALUE:
				return getNewValue();
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
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__INDEX:
				setIndex((Integer)newValue);
				return;
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__OLD_VALUE:
				setOldValue(newValue);
				return;
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__NEW_VALUE:
				setNewValue(newValue);
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
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__OLD_VALUE:
				setOldValue(OLD_VALUE_EDEFAULT);
				return;
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__NEW_VALUE:
				setNewValue(NEW_VALUE_EDEFAULT);
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
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__INDEX:
				return index != INDEX_EDEFAULT;
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__OLD_VALUE:
				return OLD_VALUE_EDEFAULT == null ? oldValue != null : !OLD_VALUE_EDEFAULT.equals(oldValue);
			case OperationsPackage.MULTI_ATTRIBUTE_SET_OPERATION__NEW_VALUE:
				return NEW_VALUE_EDEFAULT == null ? newValue != null : !NEW_VALUE_EDEFAULT.equals(newValue);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (index: ");
		result.append(index);
		result.append(", oldValue: ");
		result.append(oldValue);
		result.append(", newValue: ");
		result.append(newValue);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#apply(org.unicase.metamodel.Project)
	 */
	@SuppressWarnings("unchecked")
	public void apply(Project project) {
		EObject modelElement = project.getModelElement(getModelElementId());
		if (modelElement == null) {
			return;
		}

		EAttribute feature;
		try {
			feature = (EAttribute) getFeature(modelElement);
			EList<Object> list = (EList<Object>) modelElement.eGet(feature);

			int i = getIndex();
			if ((i >= 0 && i < list.size())) {
				list.set(i, getNewValue());
			}
		} catch (UnkownFeatureException e) {
		}
	}

	@Override
	public AbstractOperation reverse() {
		MultiAttributeSetOperation attributeOperation = OperationsFactory.eINSTANCE.createMultiAttributeSetOperation();
		super.reverse(attributeOperation);
		attributeOperation.setIndex(getIndex());
		// swap old and new value
		attributeOperation.setNewValue(getOldValue());
		attributeOperation.setOldValue(getNewValue());
		return attributeOperation;
	}

} // MultiAttributeSetOperationImpl
