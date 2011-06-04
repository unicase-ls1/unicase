/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Read Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getModelElement <em>Model Element</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getSourceView <em>Source View</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getReadView <em>Read View</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getReadEvent()
 * @model
 * @generated
 */
public interface ReadEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Element</em>' containment reference.
	 * @see #setModelElement(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getReadEvent_ModelElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getModelElement();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getModelElement
	 * <em>Model Element</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Element</em>' containment reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Source View</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source View</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source View</em>' attribute.
	 * @see #setSourceView(String)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getReadEvent_SourceView()
	 * @model
	 * @generated
	 */
	String getSourceView();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getSourceView
	 * <em>Source View</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source View</em>' attribute.
	 * @see #getSourceView()
	 * @generated
	 */
	void setSourceView(String value);

	/**
	 * Returns the value of the '<em><b>Read View</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read View</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Read View</em>' attribute.
	 * @see #setReadView(String)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getReadEvent_ReadView()
	 * @model
	 * @generated
	 */
	String getReadView();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent#getReadView
	 * <em>Read View</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Read View</em>' attribute.
	 * @see #getReadView()
	 * @generated
	 */
	void setReadView(String value);

} // ReadEvent
