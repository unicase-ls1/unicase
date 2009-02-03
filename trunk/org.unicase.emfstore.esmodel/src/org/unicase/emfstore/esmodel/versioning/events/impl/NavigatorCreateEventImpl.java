/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent;
import org.unicase.model.ModelElementId;

/*
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Navigator Create Event</b></em>'. <!--
 * end-user-doc --> <p> The following features are implemented: <ul> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.events.impl.NavigatorCreateEventImpl#getCreatedElement <em>Created
 * Element</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.events.impl.NavigatorCreateEventImpl#getSourceSection <em>Source
 * Section</em>}</li> <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.NavigatorCreateEventImpl#isDynamic
 * <em>Dynamic</em>}</li> </ul> </p>
 * @generated
 */
public class NavigatorCreateEventImpl extends EventImpl implements NavigatorCreateEvent {
	/**
	 * The cached value of the '{@link #getCreatedElement() <em>Created Element</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getCreatedElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId createdElement;

	/**
	 * The cached value of the '{@link #getSourceSection() <em>Source Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
			InternalEObject oldCreatedElement = (InternalEObject) createdElement;
			createdElement = (ModelElementId) eResolveProxy(oldCreatedElement);
			if (createdElement != oldCreatedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT, oldCreatedElement, createdElement));
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
	public void setCreatedElement(ModelElementId newCreatedElement) {
		ModelElementId oldCreatedElement = createdElement;
		createdElement = newCreatedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT, oldCreatedElement, createdElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getSourceSection() {
		if (sourceSection != null && sourceSection.eIsProxy()) {
			InternalEObject oldSourceSection = (InternalEObject) sourceSection;
			sourceSection = (ModelElementId) eResolveProxy(oldSourceSection);
			if (sourceSection != oldSourceSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION, oldSourceSection, sourceSection));
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
	public void setSourceSection(ModelElementId newSourceSection) {
		ModelElementId oldSourceSection = sourceSection;
		sourceSection = newSourceSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION,
				oldSourceSection, sourceSection));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.NAVIGATOR_CREATE_EVENT__DYNAMIC,
				oldDynamic, dynamic));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EventsPackage.NAVIGATOR_CREATE_EVENT__CREATED_ELEMENT:
			if (resolve)
				return getCreatedElement();
			return basicGetCreatedElement();
		case EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION:
			if (resolve)
				return getSourceSection();
			return basicGetSourceSection();
		case EventsPackage.NAVIGATOR_CREATE_EVENT__DYNAMIC:
			return isDynamic() ? Boolean.TRUE : Boolean.FALSE;
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
			setCreatedElement((ModelElementId) newValue);
			return;
		case EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION:
			setSourceSection((ModelElementId) newValue);
			return;
		case EventsPackage.NAVIGATOR_CREATE_EVENT__DYNAMIC:
			setDynamic(((Boolean) newValue).booleanValue());
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
			setCreatedElement((ModelElementId) null);
			return;
		case EventsPackage.NAVIGATOR_CREATE_EVENT__SOURCE_SECTION:
			setSourceSection((ModelElementId) null);
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dynamic: ");
		result.append(dynamic);
		result.append(')');
		return result.toString();
	}

} // NavigatorCreateEventImpl
