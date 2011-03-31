/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.UnkownFeatureException;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Multi Reference Set Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceSetOperationImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceSetOperationImpl#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceSetOperationImpl#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiReferenceSetOperationImpl extends ReferenceOperationImpl implements MultiReferenceSetOperation {
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
	 * The cached value of the '{@link #getOldValue() <em>Old Value</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId oldValue;

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId newValue;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiReferenceSetOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.MULTI_REFERENCE_SET_OPERATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getOldValue() {
		if (oldValue != null && oldValue.eIsProxy()) {
			InternalEObject oldOldValue = (InternalEObject)oldValue;
			oldValue = (ModelElementId)eResolveProxy(oldOldValue);
			if (oldValue != oldOldValue) {
				InternalEObject newOldValue = (InternalEObject)oldValue;
				NotificationChain msgs = oldOldValue.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, null, null);
				if (newOldValue.eInternalContainer() == null) {
					msgs = newOldValue.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, oldOldValue, oldValue));
			}
		}
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetOldValue() {
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOldValue(ModelElementId newOldValue, NotificationChain msgs) {
		ModelElementId oldOldValue = oldValue;
		oldValue = newOldValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, oldOldValue, newOldValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldValue(ModelElementId newOldValue) {
		if (newOldValue != oldValue) {
			NotificationChain msgs = null;
			if (oldValue != null)
				msgs = ((InternalEObject)oldValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, null, msgs);
			if (newOldValue != null)
				msgs = ((InternalEObject)newOldValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, null, msgs);
			msgs = basicSetOldValue(newOldValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE, newOldValue, newOldValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getNewValue() {
		if (newValue != null && newValue.eIsProxy()) {
			InternalEObject oldNewValue = (InternalEObject)newValue;
			newValue = (ModelElementId)eResolveProxy(oldNewValue);
			if (newValue != oldNewValue) {
				InternalEObject newNewValue = (InternalEObject)newValue;
				NotificationChain msgs = oldNewValue.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, null, null);
				if (newNewValue.eInternalContainer() == null) {
					msgs = newNewValue.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, oldNewValue, newValue));
			}
		}
		return newValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewValue(ModelElementId newNewValue, NotificationChain msgs) {
		ModelElementId oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, oldNewValue, newNewValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(ModelElementId newNewValue) {
		if (newNewValue != newValue) {
			NotificationChain msgs = null;
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, null, msgs);
			if (newNewValue != null)
				msgs = ((InternalEObject)newNewValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, null, msgs);
			msgs = basicSetNewValue(newNewValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE, newNewValue, newNewValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
				return basicSetOldValue(null, msgs);
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
				return basicSetNewValue(null, msgs);
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
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX:
				return getIndex();
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
				if (resolve) return getOldValue();
				return basicGetOldValue();
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
				if (resolve) return getNewValue();
				return basicGetNewValue();
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
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX:
				setIndex((Integer)newValue);
				return;
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
				setOldValue((ModelElementId)newValue);
				return;
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
				setNewValue((ModelElementId)newValue);
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
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
				setOldValue((ModelElementId)null);
				return;
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
				setNewValue((ModelElementId)null);
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
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__INDEX:
				return index != INDEX_EDEFAULT;
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__OLD_VALUE:
				return oldValue != null;
			case OperationsPackage.MULTI_REFERENCE_SET_OPERATION__NEW_VALUE:
				return newValue != null;
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
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation#apply(org.unicase.metamodel.Project)
	 */
	public void apply(Project project) {
		EObject parentElement = project.getModelElement(getModelElementId());
		if (parentElement == null) {
			// fail silently
			return;
		}
		EReference reference;
		try {
			reference = (EReference) this.getFeature(parentElement);
		} catch (UnkownFeatureException e) {
			// fail silently
			return;
		}
		Object object = parentElement.eGet(reference);
		@SuppressWarnings("unchecked")
		EList<EObject> list = (EList<EObject>) object;

		EObject newElement = project.getModelElement(getNewValue());
		EObject oldElement = project.getModelElement(getOldValue());

		if (newElement == null || oldElement == null) {
			// fail silently
			return;
		}

		int indexOf = list.indexOf(oldElement);
		if (indexOf == -1) {
			return;
		}
		list.remove(indexOf);
		list.add(indexOf, newElement);

	}

	@Override
	public AbstractOperation reverse() {
		MultiReferenceSetOperation operation = OperationsFactory.eINSTANCE.createMultiReferenceSetOperation();
		super.reverse(operation);
		operation.setIndex(getIndex());
		// swap old and new value
		operation.setNewValue(getOldValue());
		operation.setOldValue(getNewValue());
		return operation;
	}

	@Override
	public Set<ModelElementId> getOtherInvolvedModelElements() {
		HashSet<ModelElementId> result = new HashSet<ModelElementId>();
		result.add(getNewValue());
		result.add(getOldValue());
		return result;
	}

} // MultiReferenceSetOperationImpl
