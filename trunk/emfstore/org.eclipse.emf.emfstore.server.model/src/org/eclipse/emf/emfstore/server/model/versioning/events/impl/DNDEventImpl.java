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
import org.eclipse.emf.emfstore.server.model.versioning.events.DNDEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DND Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.DNDEventImpl#getSourceView <em>Source View
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.DNDEventImpl#getTargetView <em>Target View
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.DNDEventImpl#getDragSourceElement <em>Drag
 * Source Element</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.DNDEventImpl#getDropTargetElement <em>Drop
 * Target Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DNDEventImpl extends EventImpl implements DNDEvent {
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
	 * The default value of the '{@link #getTargetView() <em>Target View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTargetView()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_VIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetView() <em>Target View</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTargetView()
	 * @generated
	 * @ordered
	 */
	protected String targetView = TARGET_VIEW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDragSourceElement() <em>Drag Source Element</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDragSourceElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId dragSourceElement;

	/**
	 * The cached value of the '{@link #getDropTargetElement() <em>Drop Target Element</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDropTargetElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId dropTargetElement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DNDEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.DND_EVENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.DND_EVENT__SOURCE_VIEW, oldSourceView,
				sourceView));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getTargetView() {
		return targetView;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTargetView(String newTargetView) {
		String oldTargetView = targetView;
		targetView = newTargetView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.DND_EVENT__TARGET_VIEW, oldTargetView,
				targetView));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getDragSourceElement() {
		if (dragSourceElement != null && dragSourceElement.eIsProxy()) {
			InternalEObject oldDragSourceElement = (InternalEObject) dragSourceElement;
			dragSourceElement = (ModelElementId) eResolveProxy(oldDragSourceElement);
			if (dragSourceElement != oldDragSourceElement) {
				InternalEObject newDragSourceElement = (InternalEObject) dragSourceElement;
				NotificationChain msgs = oldDragSourceElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT, null, null);
				if (newDragSourceElement.eInternalContainer() == null) {
					msgs = newDragSourceElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT, oldDragSourceElement, dragSourceElement));
			}
		}
		return dragSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetDragSourceElement() {
		return dragSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDragSourceElement(ModelElementId newDragSourceElement, NotificationChain msgs) {
		ModelElementId oldDragSourceElement = dragSourceElement;
		dragSourceElement = newDragSourceElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT, oldDragSourceElement, newDragSourceElement);
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
	public void setDragSourceElement(ModelElementId newDragSourceElement) {
		if (newDragSourceElement != dragSourceElement) {
			NotificationChain msgs = null;
			if (dragSourceElement != null)
				msgs = ((InternalEObject) dragSourceElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT, null, msgs);
			if (newDragSourceElement != null)
				msgs = ((InternalEObject) newDragSourceElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT, null, msgs);
			msgs = basicSetDragSourceElement(newDragSourceElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT,
				newDragSourceElement, newDragSourceElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getDropTargetElement() {
		if (dropTargetElement != null && dropTargetElement.eIsProxy()) {
			InternalEObject oldDropTargetElement = (InternalEObject) dropTargetElement;
			dropTargetElement = (ModelElementId) eResolveProxy(oldDropTargetElement);
			if (dropTargetElement != oldDropTargetElement) {
				InternalEObject newDropTargetElement = (InternalEObject) dropTargetElement;
				NotificationChain msgs = oldDropTargetElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT, null, null);
				if (newDropTargetElement.eInternalContainer() == null) {
					msgs = newDropTargetElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT, oldDropTargetElement, dropTargetElement));
			}
		}
		return dropTargetElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetDropTargetElement() {
		return dropTargetElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDropTargetElement(ModelElementId newDropTargetElement, NotificationChain msgs) {
		ModelElementId oldDropTargetElement = dropTargetElement;
		dropTargetElement = newDropTargetElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT, oldDropTargetElement, newDropTargetElement);
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
	public void setDropTargetElement(ModelElementId newDropTargetElement) {
		if (newDropTargetElement != dropTargetElement) {
			NotificationChain msgs = null;
			if (dropTargetElement != null)
				msgs = ((InternalEObject) dropTargetElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT, null, msgs);
			if (newDropTargetElement != null)
				msgs = ((InternalEObject) newDropTargetElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT, null, msgs);
			msgs = basicSetDropTargetElement(newDropTargetElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT,
				newDropTargetElement, newDropTargetElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT:
			return basicSetDragSourceElement(null, msgs);
		case EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT:
			return basicSetDropTargetElement(null, msgs);
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
		case EventsPackage.DND_EVENT__SOURCE_VIEW:
			return getSourceView();
		case EventsPackage.DND_EVENT__TARGET_VIEW:
			return getTargetView();
		case EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT:
			if (resolve)
				return getDragSourceElement();
			return basicGetDragSourceElement();
		case EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT:
			if (resolve)
				return getDropTargetElement();
			return basicGetDropTargetElement();
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
		case EventsPackage.DND_EVENT__SOURCE_VIEW:
			setSourceView((String) newValue);
			return;
		case EventsPackage.DND_EVENT__TARGET_VIEW:
			setTargetView((String) newValue);
			return;
		case EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT:
			setDragSourceElement((ModelElementId) newValue);
			return;
		case EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT:
			setDropTargetElement((ModelElementId) newValue);
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
		case EventsPackage.DND_EVENT__SOURCE_VIEW:
			setSourceView(SOURCE_VIEW_EDEFAULT);
			return;
		case EventsPackage.DND_EVENT__TARGET_VIEW:
			setTargetView(TARGET_VIEW_EDEFAULT);
			return;
		case EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT:
			setDragSourceElement((ModelElementId) null);
			return;
		case EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT:
			setDropTargetElement((ModelElementId) null);
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
		case EventsPackage.DND_EVENT__SOURCE_VIEW:
			return SOURCE_VIEW_EDEFAULT == null ? sourceView != null : !SOURCE_VIEW_EDEFAULT.equals(sourceView);
		case EventsPackage.DND_EVENT__TARGET_VIEW:
			return TARGET_VIEW_EDEFAULT == null ? targetView != null : !TARGET_VIEW_EDEFAULT.equals(targetView);
		case EventsPackage.DND_EVENT__DRAG_SOURCE_ELEMENT:
			return dragSourceElement != null;
		case EventsPackage.DND_EVENT__DROP_TARGET_ELEMENT:
			return dropTargetElement != null;
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
		result.append(", targetView: ");
		result.append(targetView);
		result.append(')');
		return result.toString();
	}

} // DNDEventImpl
