/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.events;

import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent#getAnnotatedElement <em>Annotated Element</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getAnnotationEvent()
 * @model
 * @generated
 */
public interface AnnotationEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated Element</em>' reference.
	 * @see #setAnnotatedElement(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getAnnotationEvent_AnnotatedElement()
	 * @model
	 * @generated
	 */
	ModelElementId getAnnotatedElement();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent#getAnnotatedElement <em>Annotated Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotated Element</em>' reference.
	 * @see #getAnnotatedElement()
	 * @generated
	 */
	void setAnnotatedElement(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' reference.
	 * @see #setAnnotation(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getAnnotationEvent_Annotation()
	 * @model
	 * @generated
	 */
	ModelElementId getAnnotation();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent#getAnnotation <em>Annotation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation</em>' reference.
	 * @see #getAnnotation()
	 * @generated
	 */
	void setAnnotation(ModelElementId value);

} // AnnotationEvent
