/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Trace Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.TraceEventImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.TraceEventImpl#getTargetElement <em>Target Element</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.TraceEventImpl#getFeatureName <em>Feature Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceEventImpl extends EventImpl implements TraceEvent {
	/**
	 * The cached value of the '{@link #getSourceElement() <em>Source Element</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId sourceElement;

	/**
	 * The cached value of the '{@link #getTargetElement() <em>Target Element</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId targetElement;

	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.TRACE_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getSourceElement() {
		if (sourceElement != null && sourceElement.eIsProxy()) {
			InternalEObject oldSourceElement = (InternalEObject)sourceElement;
			sourceElement = (ModelElementId)eResolveProxy(oldSourceElement);
			if (sourceElement != oldSourceElement) {
				InternalEObject newSourceElement = (InternalEObject)sourceElement;
				NotificationChain msgs = oldSourceElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.TRACE_EVENT__SOURCE_ELEMENT, null, null);
				if (newSourceElement.eInternalContainer() == null) {
					msgs = newSourceElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.TRACE_EVENT__SOURCE_ELEMENT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.TRACE_EVENT__SOURCE_ELEMENT, oldSourceElement, sourceElement));
			}
		}
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetSourceElement() {
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceElement(ModelElementId newSourceElement, NotificationChain msgs) {
		ModelElementId oldSourceElement = sourceElement;
		sourceElement = newSourceElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.TRACE_EVENT__SOURCE_ELEMENT, oldSourceElement, newSourceElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceElement(ModelElementId newSourceElement) {
		if (newSourceElement != sourceElement) {
			NotificationChain msgs = null;
			if (sourceElement != null)
				msgs = ((InternalEObject)sourceElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.TRACE_EVENT__SOURCE_ELEMENT, null, msgs);
			if (newSourceElement != null)
				msgs = ((InternalEObject)newSourceElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.TRACE_EVENT__SOURCE_ELEMENT, null, msgs);
			msgs = basicSetSourceElement(newSourceElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.TRACE_EVENT__SOURCE_ELEMENT, newSourceElement, newSourceElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getTargetElement() {
		if (targetElement != null && targetElement.eIsProxy()) {
			InternalEObject oldTargetElement = (InternalEObject)targetElement;
			targetElement = (ModelElementId)eResolveProxy(oldTargetElement);
			if (targetElement != oldTargetElement) {
				InternalEObject newTargetElement = (InternalEObject)targetElement;
				NotificationChain msgs = oldTargetElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.TRACE_EVENT__TARGET_ELEMENT, null, null);
				if (newTargetElement.eInternalContainer() == null) {
					msgs = newTargetElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.TRACE_EVENT__TARGET_ELEMENT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.TRACE_EVENT__TARGET_ELEMENT, oldTargetElement, targetElement));
			}
		}
		return targetElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetTargetElement() {
		return targetElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetElement(ModelElementId newTargetElement, NotificationChain msgs) {
		ModelElementId oldTargetElement = targetElement;
		targetElement = newTargetElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.TRACE_EVENT__TARGET_ELEMENT, oldTargetElement, newTargetElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetElement(ModelElementId newTargetElement) {
		if (newTargetElement != targetElement) {
			NotificationChain msgs = null;
			if (targetElement != null)
				msgs = ((InternalEObject)targetElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.TRACE_EVENT__TARGET_ELEMENT, null, msgs);
			if (newTargetElement != null)
				msgs = ((InternalEObject)newTargetElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.TRACE_EVENT__TARGET_ELEMENT, null, msgs);
			msgs = basicSetTargetElement(newTargetElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.TRACE_EVENT__TARGET_ELEMENT, newTargetElement, newTargetElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.TRACE_EVENT__FEATURE_NAME, oldFeatureName, featureName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventsPackage.TRACE_EVENT__SOURCE_ELEMENT:
				return basicSetSourceElement(null, msgs);
			case EventsPackage.TRACE_EVENT__TARGET_ELEMENT:
				return basicSetTargetElement(null, msgs);
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
			case EventsPackage.TRACE_EVENT__SOURCE_ELEMENT:
				if (resolve) return getSourceElement();
				return basicGetSourceElement();
			case EventsPackage.TRACE_EVENT__TARGET_ELEMENT:
				if (resolve) return getTargetElement();
				return basicGetTargetElement();
			case EventsPackage.TRACE_EVENT__FEATURE_NAME:
				return getFeatureName();
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
			case EventsPackage.TRACE_EVENT__SOURCE_ELEMENT:
				setSourceElement((ModelElementId)newValue);
				return;
			case EventsPackage.TRACE_EVENT__TARGET_ELEMENT:
				setTargetElement((ModelElementId)newValue);
				return;
			case EventsPackage.TRACE_EVENT__FEATURE_NAME:
				setFeatureName((String)newValue);
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
			case EventsPackage.TRACE_EVENT__SOURCE_ELEMENT:
				setSourceElement((ModelElementId)null);
				return;
			case EventsPackage.TRACE_EVENT__TARGET_ELEMENT:
				setTargetElement((ModelElementId)null);
				return;
			case EventsPackage.TRACE_EVENT__FEATURE_NAME:
				setFeatureName(FEATURE_NAME_EDEFAULT);
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
			case EventsPackage.TRACE_EVENT__SOURCE_ELEMENT:
				return sourceElement != null;
			case EventsPackage.TRACE_EVENT__TARGET_ELEMENT:
				return targetElement != null;
			case EventsPackage.TRACE_EVENT__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
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
		result.append(" (featureName: ");
		result.append(featureName);
		result.append(')');
		return result.toString();
	}

} // TraceEventImpl
