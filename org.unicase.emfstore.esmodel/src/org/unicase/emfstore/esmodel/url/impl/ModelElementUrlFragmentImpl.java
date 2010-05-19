/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.url.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.UrlPackage;
import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Element Url Fragment</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.url.impl.ModelElementUrlFragmentImpl#getName <em>Name</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.url.impl.ModelElementUrlFragmentImpl#getModelElementId <em>Model Element Id
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelElementUrlFragmentImpl extends EObjectImpl implements ModelElementUrlFragment {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElementId() <em>Model Element Id</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelElementId()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId modelElementId;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelElementUrlFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrlPackage.Literals.MODEL_ELEMENT_URL_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__NAME, oldName,
				name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getModelElementId() {
		if (modelElementId != null && modelElementId.eIsProxy()) {
			InternalEObject oldModelElementId = (InternalEObject) modelElementId;
			modelElementId = (ModelElementId) eResolveProxy(oldModelElementId);
			if (modelElementId != oldModelElementId) {
				InternalEObject newModelElementId = (InternalEObject) modelElementId;
				NotificationChain msgs = oldModelElementId.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID, null, null);
				if (newModelElementId.eInternalContainer() == null) {
					msgs = newModelElementId.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID, oldModelElementId, modelElementId));
			}
		}
		return modelElementId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetModelElementId() {
		return modelElementId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetModelElementId(ModelElementId newModelElementId, NotificationChain msgs) {
		ModelElementId oldModelElementId = modelElementId;
		modelElementId = newModelElementId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID, oldModelElementId, newModelElementId);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setModelElementId(ModelElementId newModelElementId) {
		if (newModelElementId != modelElementId) {
			NotificationChain msgs = null;
			if (modelElementId != null)
				msgs = ((InternalEObject) modelElementId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID, null, msgs);
			if (newModelElementId != null)
				msgs = ((InternalEObject) newModelElementId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID, null, msgs);
			msgs = basicSetModelElementId(newModelElementId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID, newModelElementId, newModelElementId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID:
			return basicSetModelElementId(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__NAME:
			return getName();
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID:
			if (resolve)
				return getModelElementId();
			return basicGetModelElementId();
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
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__NAME:
			setName((String) newValue);
			return;
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID:
			setModelElementId((ModelElementId) newValue);
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
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID:
			setModelElementId((ModelElementId) null);
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
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case UrlPackage.MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID:
			return modelElementId != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	public String getUrlString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getName());
		stringBuilder.append("%");
		stringBuilder.append(getModelElementId().getId());
		return stringBuilder.toString();
	}

} // ModelElementUrlFragmentImpl
