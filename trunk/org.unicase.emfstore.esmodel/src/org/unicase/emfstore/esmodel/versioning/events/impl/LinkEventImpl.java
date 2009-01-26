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
import org.unicase.emfstore.esmodel.versioning.events.LinkEvent;
import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Link Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.LinkEventImpl#getSourceView <em>Source View</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.LinkEventImpl#getSourceElement <em>Source Element
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.LinkEventImpl#getTargetElement <em>Target Element
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.LinkEventImpl#isCreatedNew <em>Created New</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class LinkEventImpl extends EventImpl implements LinkEvent {
	/**
	 * The default value of the '{@link #getSourceView() <em>Source View</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getSourceView()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_VIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceView() <em>Source View</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getSourceView()
	 * @generated
	 * @ordered
	 */
	protected String sourceView = SOURCE_VIEW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceElement() <em>Source Element</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSourceElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId sourceElement;

	/**
	 * The cached value of the '{@link #getTargetElement() <em>Target Element</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTargetElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId targetElement;

	/**
	 * The default value of the '{@link #isCreatedNew() <em>Created New</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isCreatedNew()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CREATED_NEW_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCreatedNew() <em>Created New</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isCreatedNew()
	 * @generated
	 * @ordered
	 */
	protected boolean createdNew = CREATED_NEW_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LinkEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.LINK_EVENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.LINK_EVENT__SOURCE_VIEW, oldSourceView,
				sourceView));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getSourceElement() {
		if (sourceElement != null && sourceElement.eIsProxy()) {
			InternalEObject oldSourceElement = (InternalEObject) sourceElement;
			sourceElement = (ModelElementId) eResolveProxy(oldSourceElement);
			if (sourceElement != oldSourceElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.LINK_EVENT__SOURCE_ELEMENT,
						oldSourceElement, sourceElement));
			}
		}
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetSourceElement() {
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSourceElement(ModelElementId newSourceElement) {
		ModelElementId oldSourceElement = sourceElement;
		sourceElement = newSourceElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.LINK_EVENT__SOURCE_ELEMENT,
				oldSourceElement, sourceElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getTargetElement() {
		if (targetElement != null && targetElement.eIsProxy()) {
			InternalEObject oldTargetElement = (InternalEObject) targetElement;
			targetElement = (ModelElementId) eResolveProxy(oldTargetElement);
			if (targetElement != oldTargetElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.LINK_EVENT__TARGET_ELEMENT,
						oldTargetElement, targetElement));
			}
		}
		return targetElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetTargetElement() {
		return targetElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTargetElement(ModelElementId newTargetElement) {
		ModelElementId oldTargetElement = targetElement;
		targetElement = newTargetElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.LINK_EVENT__TARGET_ELEMENT,
				oldTargetElement, targetElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isCreatedNew() {
		return createdNew;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCreatedNew(boolean newCreatedNew) {
		boolean oldCreatedNew = createdNew;
		createdNew = newCreatedNew;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.LINK_EVENT__CREATED_NEW, oldCreatedNew,
				createdNew));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EventsPackage.LINK_EVENT__SOURCE_VIEW:
			return getSourceView();
		case EventsPackage.LINK_EVENT__SOURCE_ELEMENT:
			if (resolve)
				return getSourceElement();
			return basicGetSourceElement();
		case EventsPackage.LINK_EVENT__TARGET_ELEMENT:
			if (resolve)
				return getTargetElement();
			return basicGetTargetElement();
		case EventsPackage.LINK_EVENT__CREATED_NEW:
			return isCreatedNew() ? Boolean.TRUE : Boolean.FALSE;
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
		case EventsPackage.LINK_EVENT__SOURCE_VIEW:
			setSourceView((String) newValue);
			return;
		case EventsPackage.LINK_EVENT__SOURCE_ELEMENT:
			setSourceElement((ModelElementId) newValue);
			return;
		case EventsPackage.LINK_EVENT__TARGET_ELEMENT:
			setTargetElement((ModelElementId) newValue);
			return;
		case EventsPackage.LINK_EVENT__CREATED_NEW:
			setCreatedNew(((Boolean) newValue).booleanValue());
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
		case EventsPackage.LINK_EVENT__SOURCE_VIEW:
			setSourceView(SOURCE_VIEW_EDEFAULT);
			return;
		case EventsPackage.LINK_EVENT__SOURCE_ELEMENT:
			setSourceElement((ModelElementId) null);
			return;
		case EventsPackage.LINK_EVENT__TARGET_ELEMENT:
			setTargetElement((ModelElementId) null);
			return;
		case EventsPackage.LINK_EVENT__CREATED_NEW:
			setCreatedNew(CREATED_NEW_EDEFAULT);
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
		case EventsPackage.LINK_EVENT__SOURCE_VIEW:
			return SOURCE_VIEW_EDEFAULT == null ? sourceView != null : !SOURCE_VIEW_EDEFAULT.equals(sourceView);
		case EventsPackage.LINK_EVENT__SOURCE_ELEMENT:
			return sourceElement != null;
		case EventsPackage.LINK_EVENT__TARGET_ELEMENT:
			return targetElement != null;
		case EventsPackage.LINK_EVENT__CREATED_NEW:
			return createdNew != CREATED_NEW_EDEFAULT;
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
		result.append(", createdNew: ");
		result.append(createdNew);
		result.append(')');
		return result.toString();
	}

} // LinkEventImpl
