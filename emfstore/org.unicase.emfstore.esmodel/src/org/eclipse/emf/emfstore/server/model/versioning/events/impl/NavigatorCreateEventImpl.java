/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.NavigatorCreateEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Navigator Create Event</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.NavigatorCreateEventImpl#getCreatedElement <em>Created Element</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.NavigatorCreateEventImpl#getSourceSection <em>Source Section</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.NavigatorCreateEventImpl#isDynamic <em>Dynamic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NavigatorCreateEventImpl extends EventImpl implements NavigatorCreateEvent {
	/**
	 * The cached value of the '{@link #getCreatedElement() <em>Created Element</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreatedElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId createdElement;

	/**
	 * The cached value of the '{@link #getSourceSection() <em>Source Section</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceSection()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId sourceSection;

	/**
	 * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DYNAMIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected boolean dynamic = DYNAMIC_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigatorCreateEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.NAVIGATOR_CREATE_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getCreatedElement() {
		if (createdElement != null && createdElement.eIsProxy()) {
			InternalEObject oldCreatedElement = (InternalEObject)createdElement;
			createdElement = (ModelElementId)eResolveProxy(oldCreatedElement);
			if (createdElement != oldCreatedElement) {
				InternalEObject newCreatedElement = (InternalEObject)createdElement;
				NotificationChain msgs = oldCreatedElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT, null, null);
				if (newCreatedElement.eInternalContainer() == null) {
					msgs = newCreatedElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT, oldCreatedElement, createdElement));
			}
		}
		return createdElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetCreatedElement() {
		return createdElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCreatedElement(ModelElementId newCreatedElement, NotificationChain msgs) {
		ModelElementId oldCreatedElement = createdElement;
		createdElement = newCreatedElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT, oldCreatedElement, newCreatedElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedElement(ModelElementId newCreatedElement) {
		if (newCreatedElement != createdElement) {
			NotificationChain msgs = null;
			if (createdElement != null)
				msgs = ((InternalEObject)createdElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT, null, msgs);
			if (newCreatedElement != null)
				msgs = ((InternalEObject)newCreatedElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT, null, msgs);
			msgs = basicSetCreatedElement(newCreatedElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT, newCreatedElement, newCreatedElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getSourceSection() {
		if (sourceSection != null && sourceSection.eIsProxy()) {
			InternalEObject oldSourceSection = (InternalEObject)sourceSection;
			sourceSection = (ModelElementId)eResolveProxy(oldSourceSection);
			if (sourceSection != oldSourceSection) {
				InternalEObject newSourceSection = (InternalEObject)sourceSection;
				NotificationChain msgs = oldSourceSection.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION, null, null);
				if (newSourceSection.eInternalContainer() == null) {
					msgs = newSourceSection.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION, oldSourceSection, sourceSection));
			}
		}
		return sourceSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetSourceSection() {
		return sourceSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceSection(ModelElementId newSourceSection, NotificationChain msgs) {
		ModelElementId oldSourceSection = sourceSection;
		sourceSection = newSourceSection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION, oldSourceSection, newSourceSection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceSection(ModelElementId newSourceSection) {
		if (newSourceSection != sourceSection) {
			NotificationChain msgs = null;
			if (sourceSection != null)
				msgs = ((InternalEObject)sourceSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION, null, msgs);
			if (newSourceSection != null)
				msgs = ((InternalEObject)newSourceSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION, null, msgs);
			msgs = basicSetSourceSection(newSourceSection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION, newSourceSection, newSourceSection));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamic(boolean newDynamic) {
		boolean oldDynamic = dynamic;
		dynamic = newDynamic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.NAVIGATOR_CREATE_EVENT__DYNAMIC, oldDynamic, dynamic));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT:
				return basicSetCreatedElement(null, msgs);
			case EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION:
				return basicSetSourceSection(null, msgs);
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
			case EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT:
				if (resolve) return getCreatedElement();
				return basicGetCreatedElement();
			case EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION:
				if (resolve) return getSourceSection();
				return basicGetSourceSection();
			case EventsPackage.NAVIGATOR_CREATE_EVENT__DYNAMIC:
				return isDynamic();
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
			case EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT:
				setCreatedElement((ModelElementId)newValue);
				return;
			case EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION:
				setSourceSection((ModelElementId)newValue);
				return;
			case EventsPackage.NAVIGATOR_CREATE_EVENT__DYNAMIC:
				setDynamic((Boolean)newValue);
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
			case EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT:
				setCreatedElement((ModelElementId)null);
				return;
			case EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION:
				setSourceSection((ModelElementId)null);
				return;
			case EventsPackage.NAVIGATOR_CREATE_EVENT__DYNAMIC:
				setDynamic(DYNAMIC_EDEFAULT);
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
			case EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT:
				return createdElement != null;
			case EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION:
				return sourceSection != null;
			case EventsPackage.NAVIGATOR_CREATE_EVENT__DYNAMIC:
				return dynamic != DYNAMIC_EDEFAULT;
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
		result.append(" (dynamic: ");
		result.append(dynamic);
		result.append(')');
		return result.toString();
	}

} // NavigatorCreateEventImpl
