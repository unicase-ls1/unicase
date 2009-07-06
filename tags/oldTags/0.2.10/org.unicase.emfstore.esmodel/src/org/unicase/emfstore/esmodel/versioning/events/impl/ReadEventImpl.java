/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Read Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReadEventImpl extends EventImpl implements ReadEvent {
	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId modelElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.READ_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject) modelElement;
			modelElement = (ModelElementId) eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				InternalEObject newModelElement = (InternalEObject) modelElement;
				NotificationChain msgs = oldModelElement.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- EventsPackage.READ_EVENT__MODEL_ELEMENT,
						null, null);
				if (newModelElement.eInternalContainer() == null) {
					msgs = newModelElement.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE
									- EventsPackage.READ_EVENT__MODEL_ELEMENT,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EventsPackage.READ_EVENT__MODEL_ELEMENT,
							oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElement(
			ModelElementId newModelElement, NotificationChain msgs) {
		ModelElementId oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, EventsPackage.READ_EVENT__MODEL_ELEMENT,
					oldModelElement, newModelElement);
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
	public void setModelElement(ModelElementId newModelElement) {
		if (newModelElement != modelElement) {
			NotificationChain msgs = null;
			if (modelElement != null)
				msgs = ((InternalEObject) modelElement).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- EventsPackage.READ_EVENT__MODEL_ELEMENT,
						null, msgs);
			if (newModelElement != null)
				msgs = ((InternalEObject) newModelElement).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- EventsPackage.READ_EVENT__MODEL_ELEMENT,
						null, msgs);
			msgs = basicSetModelElement(newModelElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EventsPackage.READ_EVENT__MODEL_ELEMENT, newModelElement,
					newModelElement));
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
		case EventsPackage.READ_EVENT__MODEL_ELEMENT:
			return basicSetModelElement(null, msgs);
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
		case EventsPackage.READ_EVENT__MODEL_ELEMENT:
			if (resolve)
				return getModelElement();
			return basicGetModelElement();
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
		case EventsPackage.READ_EVENT__MODEL_ELEMENT:
			setModelElement((ModelElementId) newValue);
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
		case EventsPackage.READ_EVENT__MODEL_ELEMENT:
			setModelElement((ModelElementId) null);
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
		case EventsPackage.READ_EVENT__MODEL_ELEMENT:
			return modelElement != null;
		}
		return super.eIsSet(featureID);
	}

} //ReadEventImpl
