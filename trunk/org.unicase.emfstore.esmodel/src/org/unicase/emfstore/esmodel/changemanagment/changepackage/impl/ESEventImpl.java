/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent;
import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ES Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESEventImpl#getModelElementId <em>Model Element Id</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESEventImpl#getFeatureId <em>Feature Id</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ESEventImpl#getModelElementClass <em>Model Element Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ESEventImpl extends EObjectImpl implements ESEvent {
	/**
	 * The cached value of the '{@link #getModelElementId() <em>Model Element Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementId()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId modelElementId;

	/**
	 * The default value of the '{@link #getFeatureId() <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureId()
	 * @generated
	 * @ordered
	 */
	protected static final int FEATURE_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFeatureId() <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureId()
	 * @generated
	 * @ordered
	 */
	protected int featureId = FEATURE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElementClass() <em>Model Element Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementClass()
	 * @generated
	 * @ordered
	 */
	protected Class<?> modelElementClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangepackagePackage.Literals.ES_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getModelElementId() {
		return modelElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElementId(
			ModelElementId newModelElementId, NotificationChain msgs) {
		ModelElementId oldModelElementId = modelElementId;
		modelElementId = newModelElementId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_ID,
					oldModelElementId, newModelElementId);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementId(ModelElementId newModelElementId) {
		if (newModelElementId != modelElementId) {
			NotificationChain msgs = null;
			if (modelElementId != null)
				msgs = ((InternalEObject) modelElementId)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_ID,
								null, msgs);
			if (newModelElementId != null)
				msgs = ((InternalEObject) newModelElementId)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_ID,
								null, msgs);
			msgs = basicSetModelElementId(newModelElementId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_ID,
					newModelElementId, newModelElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFeatureId() {
		return featureId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureId(int newFeatureId) {
		int oldFeatureId = featureId;
		featureId = newFeatureId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangepackagePackage.ES_EVENT__FEATURE_ID, oldFeatureId,
					featureId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<?> getModelElementClass() {
		return modelElementClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementClass(Class<?> newModelElementClass) {
		Class<?> oldModelElementClass = modelElementClass;
		modelElementClass = newModelElementClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_CLASS,
					oldModelElementClass, modelElementClass));
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
		case ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_ID:
			return basicSetModelElementId(null, msgs);
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
		case ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_ID:
			return getModelElementId();
		case ChangepackagePackage.ES_EVENT__FEATURE_ID:
			return new Integer(getFeatureId());
		case ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_CLASS:
			return getModelElementClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_ID:
			setModelElementId((ModelElementId) newValue);
			return;
		case ChangepackagePackage.ES_EVENT__FEATURE_ID:
			setFeatureId(((Integer) newValue).intValue());
			return;
		case ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_CLASS:
			setModelElementClass((Class<?>) newValue);
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
		case ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_ID:
			setModelElementId((ModelElementId) null);
			return;
		case ChangepackagePackage.ES_EVENT__FEATURE_ID:
			setFeatureId(FEATURE_ID_EDEFAULT);
			return;
		case ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_CLASS:
			setModelElementClass((Class<?>) null);
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
		case ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_ID:
			return modelElementId != null;
		case ChangepackagePackage.ES_EVENT__FEATURE_ID:
			return featureId != FEATURE_ID_EDEFAULT;
		case ChangepackagePackage.ES_EVENT__MODEL_ELEMENT_CLASS:
			return modelElementClass != null;
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
		result.append(" (featureId: ");
		result.append(featureId);
		result.append(", modelElementClass: ");
		result.append(modelElementClass);
		result.append(')');
		return result.toString();
	}

} //ESEventImpl
