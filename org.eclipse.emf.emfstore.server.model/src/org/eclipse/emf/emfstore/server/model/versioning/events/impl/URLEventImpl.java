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
package org.eclipse.emf.emfstore.server.model.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.URLEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>URL Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.URLEventImpl#getSourceModelElement <em>Source
 * Model Element</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.URLEventImpl#getSourceView <em>Source View
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.URLEventImpl#getSourceURL <em>Source URL
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class URLEventImpl extends EventImpl implements URLEvent {
	/**
	 * The cached value of the '{@link #getSourceModelElement() <em>Source Model Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceModelElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId sourceModelElement;

	/**
	 * The default value of the '{@link #getSourceView() <em>Source View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getSourceView()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_VIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceView() <em>Source View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getSourceView()
	 * @generated
	 * @ordered
	 */
	protected String sourceView = SOURCE_VIEW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceURL() <em>Source URL</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceURL()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId sourceURL;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected URLEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.URL_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getSourceModelElement() {
		if (sourceModelElement != null && sourceModelElement.eIsProxy()) {
			InternalEObject oldSourceModelElement = (InternalEObject) sourceModelElement;
			sourceModelElement = (ModelElementId) eResolveProxy(oldSourceModelElement);
			if (sourceModelElement != oldSourceModelElement) {
				InternalEObject newSourceModelElement = (InternalEObject) sourceModelElement;
				NotificationChain msgs = oldSourceModelElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT, null, null);
				if (newSourceModelElement.eInternalContainer() == null) {
					msgs = newSourceModelElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT, oldSourceModelElement, sourceModelElement));
			}
		}
		return sourceModelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetSourceModelElement() {
		return sourceModelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSourceModelElement(ModelElementId newSourceModelElement, NotificationChain msgs) {
		ModelElementId oldSourceModelElement = sourceModelElement;
		sourceModelElement = newSourceModelElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT, oldSourceModelElement, newSourceModelElement);
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
	public void setSourceModelElement(ModelElementId newSourceModelElement) {
		if (newSourceModelElement != sourceModelElement) {
			NotificationChain msgs = null;
			if (sourceModelElement != null)
				msgs = ((InternalEObject) sourceModelElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT, null, msgs);
			if (newSourceModelElement != null)
				msgs = ((InternalEObject) newSourceModelElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT, null, msgs);
			msgs = basicSetSourceModelElement(newSourceModelElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT,
				newSourceModelElement, newSourceModelElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSourceView() {
		return sourceView;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSourceView(String newSourceView) {
		String oldSourceView = sourceView;
		sourceView = newSourceView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.URL_EVENT__SOURCE_VIEW, oldSourceView,
				sourceView));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getSourceURL() {
		if (sourceURL != null && sourceURL.eIsProxy()) {
			InternalEObject oldSourceURL = (InternalEObject) sourceURL;
			sourceURL = (ModelElementId) eResolveProxy(oldSourceURL);
			if (sourceURL != oldSourceURL) {
				InternalEObject newSourceURL = (InternalEObject) sourceURL;
				NotificationChain msgs = oldSourceURL.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.URL_EVENT__SOURCE_URL, null, null);
				if (newSourceURL.eInternalContainer() == null) {
					msgs = newSourceURL.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.URL_EVENT__SOURCE_URL,
						null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.URL_EVENT__SOURCE_URL,
						oldSourceURL, sourceURL));
			}
		}
		return sourceURL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetSourceURL() {
		return sourceURL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSourceURL(ModelElementId newSourceURL, NotificationChain msgs) {
		ModelElementId oldSourceURL = sourceURL;
		sourceURL = newSourceURL;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.URL_EVENT__SOURCE_URL, oldSourceURL, newSourceURL);
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
	public void setSourceURL(ModelElementId newSourceURL) {
		if (newSourceURL != sourceURL) {
			NotificationChain msgs = null;
			if (sourceURL != null)
				msgs = ((InternalEObject) sourceURL).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.URL_EVENT__SOURCE_URL, null, msgs);
			if (newSourceURL != null)
				msgs = ((InternalEObject) newSourceURL).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.URL_EVENT__SOURCE_URL, null, msgs);
			msgs = basicSetSourceURL(newSourceURL, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.URL_EVENT__SOURCE_URL, newSourceURL,
				newSourceURL));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT:
			return basicSetSourceModelElement(null, msgs);
		case EventsPackage.URL_EVENT__SOURCE_URL:
			return basicSetSourceURL(null, msgs);
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
		case EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT:
			if (resolve)
				return getSourceModelElement();
			return basicGetSourceModelElement();
		case EventsPackage.URL_EVENT__SOURCE_VIEW:
			return getSourceView();
		case EventsPackage.URL_EVENT__SOURCE_URL:
			if (resolve)
				return getSourceURL();
			return basicGetSourceURL();
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
		case EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT:
			setSourceModelElement((ModelElementId) newValue);
			return;
		case EventsPackage.URL_EVENT__SOURCE_VIEW:
			setSourceView((String) newValue);
			return;
		case EventsPackage.URL_EVENT__SOURCE_URL:
			setSourceURL((ModelElementId) newValue);
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
		case EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT:
			setSourceModelElement((ModelElementId) null);
			return;
		case EventsPackage.URL_EVENT__SOURCE_VIEW:
			setSourceView(SOURCE_VIEW_EDEFAULT);
			return;
		case EventsPackage.URL_EVENT__SOURCE_URL:
			setSourceURL((ModelElementId) null);
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
		case EventsPackage.URL_EVENT__SOURCE_MODEL_ELEMENT:
			return sourceModelElement != null;
		case EventsPackage.URL_EVENT__SOURCE_VIEW:
			return SOURCE_VIEW_EDEFAULT == null ? sourceView != null : !SOURCE_VIEW_EDEFAULT.equals(sourceView);
		case EventsPackage.URL_EVENT__SOURCE_URL:
			return sourceURL != null;
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
		result.append(" (sourceView: ");
		result.append(sourceView);
		result.append(')');
		return result.toString();
	}

} // URLEventImpl
