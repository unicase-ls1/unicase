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
import org.eclipse.emf.emfstore.server.model.versioning.events.AnnotationEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Annotation Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.AnnotationEventImpl#getAnnotatedElement <em>Annotated
 * Element</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.AnnotationEventImpl#getAnnotation <em>Annotation</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AnnotationEventImpl extends EventImpl implements AnnotationEvent {
	/**
	 * The cached value of the '{@link #getAnnotatedElement() <em>Annotated Element</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAnnotatedElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId annotatedElement;

	/**
	 * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getAnnotation()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId annotation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.ANNOTATION_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getAnnotatedElement() {
		if (annotatedElement != null && annotatedElement.eIsProxy()) {
			InternalEObject oldAnnotatedElement = (InternalEObject)annotatedElement;
			annotatedElement = (ModelElementId)eResolveProxy(oldAnnotatedElement);
			if (annotatedElement != oldAnnotatedElement) {
				InternalEObject newAnnotatedElement = (InternalEObject)annotatedElement;
				NotificationChain msgs = oldAnnotatedElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT, null, null);
				if (newAnnotatedElement.eInternalContainer() == null) {
					msgs = newAnnotatedElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT, oldAnnotatedElement, annotatedElement));
			}
		}
		return annotatedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetAnnotatedElement() {
		return annotatedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotatedElement(ModelElementId newAnnotatedElement, NotificationChain msgs) {
		ModelElementId oldAnnotatedElement = annotatedElement;
		annotatedElement = newAnnotatedElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT, oldAnnotatedElement, newAnnotatedElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotatedElement(ModelElementId newAnnotatedElement) {
		if (newAnnotatedElement != annotatedElement) {
			NotificationChain msgs = null;
			if (annotatedElement != null)
				msgs = ((InternalEObject)annotatedElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT, null, msgs);
			if (newAnnotatedElement != null)
				msgs = ((InternalEObject)newAnnotatedElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT, null, msgs);
			msgs = basicSetAnnotatedElement(newAnnotatedElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT, newAnnotatedElement, newAnnotatedElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getAnnotation() {
		if (annotation != null && annotation.eIsProxy()) {
			InternalEObject oldAnnotation = (InternalEObject)annotation;
			annotation = (ModelElementId)eResolveProxy(oldAnnotation);
			if (annotation != oldAnnotation) {
				InternalEObject newAnnotation = (InternalEObject)annotation;
				NotificationChain msgs = oldAnnotation.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.ANNOTATION_EVENT__ANNOTATION, null, null);
				if (newAnnotation.eInternalContainer() == null) {
					msgs = newAnnotation.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.ANNOTATION_EVENT__ANNOTATION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.ANNOTATION_EVENT__ANNOTATION, oldAnnotation, annotation));
			}
		}
		return annotation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetAnnotation() {
		return annotation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotation(ModelElementId newAnnotation, NotificationChain msgs) {
		ModelElementId oldAnnotation = annotation;
		annotation = newAnnotation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.ANNOTATION_EVENT__ANNOTATION, oldAnnotation, newAnnotation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotation(ModelElementId newAnnotation) {
		if (newAnnotation != annotation) {
			NotificationChain msgs = null;
			if (annotation != null)
				msgs = ((InternalEObject)annotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.ANNOTATION_EVENT__ANNOTATION, null, msgs);
			if (newAnnotation != null)
				msgs = ((InternalEObject)newAnnotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.ANNOTATION_EVENT__ANNOTATION, null, msgs);
			msgs = basicSetAnnotation(newAnnotation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.ANNOTATION_EVENT__ANNOTATION, newAnnotation, newAnnotation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT:
				return basicSetAnnotatedElement(null, msgs);
			case EventsPackage.ANNOTATION_EVENT__ANNOTATION:
				return basicSetAnnotation(null, msgs);
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
			case EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT:
				if (resolve) return getAnnotatedElement();
				return basicGetAnnotatedElement();
			case EventsPackage.ANNOTATION_EVENT__ANNOTATION:
				if (resolve) return getAnnotation();
				return basicGetAnnotation();
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
			case EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT:
				setAnnotatedElement((ModelElementId)newValue);
				return;
			case EventsPackage.ANNOTATION_EVENT__ANNOTATION:
				setAnnotation((ModelElementId)newValue);
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
			case EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT:
				setAnnotatedElement((ModelElementId)null);
				return;
			case EventsPackage.ANNOTATION_EVENT__ANNOTATION:
				setAnnotation((ModelElementId)null);
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
			case EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT:
				return annotatedElement != null;
			case EventsPackage.ANNOTATION_EVENT__ANNOTATION:
				return annotation != null;
		}
		return super.eIsSet(featureID);
	}

} // AnnotationEventImpl
