/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Annotation Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.AnnotationEventImpl#getAnnotatedElement <em>Annotated
 * Element</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.AnnotationEventImpl#getAnnotation <em>Annotation</em>}
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
	 * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getAnnotation()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId annotation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AnnotationEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.ANNOTATION_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getAnnotatedElement() {
		if (annotatedElement != null && annotatedElement.eIsProxy()) {
			InternalEObject oldAnnotatedElement = (InternalEObject) annotatedElement;
			annotatedElement = (ModelElementId) eResolveProxy(oldAnnotatedElement);
			if (annotatedElement != oldAnnotatedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT, oldAnnotatedElement, annotatedElement));
			}
		}
		return annotatedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetAnnotatedElement() {
		return annotatedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAnnotatedElement(ModelElementId newAnnotatedElement) {
		ModelElementId oldAnnotatedElement = annotatedElement;
		annotatedElement = newAnnotatedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT,
				oldAnnotatedElement, annotatedElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getAnnotation() {
		if (annotation != null && annotation.eIsProxy()) {
			InternalEObject oldAnnotation = (InternalEObject) annotation;
			annotation = (ModelElementId) eResolveProxy(oldAnnotation);
			if (annotation != oldAnnotation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.ANNOTATION_EVENT__ANNOTATION, oldAnnotation, annotation));
			}
		}
		return annotation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetAnnotation() {
		return annotation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAnnotation(ModelElementId newAnnotation) {
		ModelElementId oldAnnotation = annotation;
		annotation = newAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.ANNOTATION_EVENT__ANNOTATION,
				oldAnnotation, annotation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT:
			if (resolve)
				return getAnnotatedElement();
			return basicGetAnnotatedElement();
		case EventsPackage.ANNOTATION_EVENT__ANNOTATION:
			if (resolve)
				return getAnnotation();
			return basicGetAnnotation();
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
		case EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT:
			setAnnotatedElement((ModelElementId) newValue);
			return;
		case EventsPackage.ANNOTATION_EVENT__ANNOTATION:
			setAnnotation((ModelElementId) newValue);
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
		case EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT:
			setAnnotatedElement((ModelElementId) null);
			return;
		case EventsPackage.ANNOTATION_EVENT__ANNOTATION:
			setAnnotation((ModelElementId) null);
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
		case EventsPackage.ANNOTATION_EVENT__ANNOTATED_ELEMENT:
			return annotatedElement != null;
		case EventsPackage.ANNOTATION_EVENT__ANNOTATION:
			return annotation != null;
		}
		return super.eIsSet(featureID);
	}

} // AnnotationEventImpl
