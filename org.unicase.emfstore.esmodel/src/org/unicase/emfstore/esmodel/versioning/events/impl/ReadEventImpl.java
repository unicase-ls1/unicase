/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Read Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl#getSourceView <em>Source View</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.ReadEventImpl#getReadView <em>Read View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReadEventImpl extends EventImpl implements ReadEvent {
	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId modelElement;

	/**
	 * The default value of the '{@link #getSourceView() <em>Source View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSourceView()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_VIEW_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSourceView() <em>Source View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSourceView()
	 * @generated
	 * @ordered
	 */
	protected String sourceView = SOURCE_VIEW_EDEFAULT;

	/**
	 * The default value of the '{@link #getReadView() <em>Read View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getReadView()
	 * @generated
	 * @ordered
	 */
	protected static final String READ_VIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReadView() <em>Read View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getReadView()
	 * @generated
	 * @ordered
	 */
	protected String readView = READ_VIEW_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.READ_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject)modelElement;
			modelElement = (ModelElementId)eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				InternalEObject newModelElement = (InternalEObject)modelElement;
				NotificationChain msgs = oldModelElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.READ_EVENT__MODEL_ELEMENT, null, null);
				if (newModelElement.eInternalContainer() == null) {
					msgs = newModelElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.READ_EVENT__MODEL_ELEMENT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.READ_EVENT__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElement(ModelElementId newModelElement, NotificationChain msgs) {
		ModelElementId oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.READ_EVENT__MODEL_ELEMENT, oldModelElement, newModelElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElement(ModelElementId newModelElement) {
		if (newModelElement != modelElement) {
			NotificationChain msgs = null;
			if (modelElement != null)
				msgs = ((InternalEObject)modelElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.READ_EVENT__MODEL_ELEMENT, null, msgs);
			if (newModelElement != null)
				msgs = ((InternalEObject)newModelElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.READ_EVENT__MODEL_ELEMENT, null, msgs);
			msgs = basicSetModelElement(newModelElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.READ_EVENT__MODEL_ELEMENT, newModelElement, newModelElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceView() {
		return sourceView;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceView(String newSourceView) {
		String oldSourceView = sourceView;
		sourceView = newSourceView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.READ_EVENT__SOURCE_VIEW, oldSourceView, sourceView));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getReadView() {
		return readView;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadView(String newReadView) {
		String oldReadView = readView;
		readView = newReadView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.READ_EVENT__READ_VIEW, oldReadView, readView));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventsPackage.READ_EVENT__MODEL_ELEMENT:
				return basicSetModelElement(null, msgs);
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
			case EventsPackage.READ_EVENT__MODEL_ELEMENT:
				if (resolve) return getModelElement();
				return basicGetModelElement();
			case EventsPackage.READ_EVENT__SOURCE_VIEW:
				return getSourceView();
			case EventsPackage.READ_EVENT__READ_VIEW:
				return getReadView();
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
			case EventsPackage.READ_EVENT__MODEL_ELEMENT:
				setModelElement((ModelElementId)newValue);
				return;
			case EventsPackage.READ_EVENT__SOURCE_VIEW:
				setSourceView((String)newValue);
				return;
			case EventsPackage.READ_EVENT__READ_VIEW:
				setReadView((String)newValue);
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
			case EventsPackage.READ_EVENT__MODEL_ELEMENT:
				setModelElement((ModelElementId)null);
				return;
			case EventsPackage.READ_EVENT__SOURCE_VIEW:
				setSourceView(SOURCE_VIEW_EDEFAULT);
				return;
			case EventsPackage.READ_EVENT__READ_VIEW:
				setReadView(READ_VIEW_EDEFAULT);
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
			case EventsPackage.READ_EVENT__MODEL_ELEMENT:
				return modelElement != null;
			case EventsPackage.READ_EVENT__SOURCE_VIEW:
				return SOURCE_VIEW_EDEFAULT == null ? sourceView != null : !SOURCE_VIEW_EDEFAULT.equals(sourceView);
			case EventsPackage.READ_EVENT__READ_VIEW:
				return READ_VIEW_EDEFAULT == null ? readView != null : !READ_VIEW_EDEFAULT.equals(readView);
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
		result.append(" (sourceView: ");
		result.append(sourceView);
		result.append(", readView: ");
		result.append(readView);
		result.append(')');
		return result.toString();
	}

} // ReadEventImpl
