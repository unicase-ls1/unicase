/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DND Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getSourceView <em>Source View</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getTargetView <em>Target View</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getDragSourceElement <em>Drag Source Element</em>}
 * </li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getDropTargetElement <em>Drop Target Element</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getDNDEvent()
 * @model
 * @generated
 */
public interface DNDEvent extends Event {
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
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getDNDEvent_SourceView()
	 * @model
	 * @generated
	 */
	String getSourceView();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getSourceView
	 * <em>Source View</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source View</em>' attribute.
	 * @see #getSourceView()
	 * @generated
	 */
	void setSourceView(String value);

	/**
	 * Returns the value of the '<em><b>Target View</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target View</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target View</em>' attribute.
	 * @see #setTargetView(String)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getDNDEvent_TargetView()
	 * @model
	 * @generated
	 */
	String getTargetView();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getTargetView
	 * <em>Target View</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target View</em>' attribute.
	 * @see #getTargetView()
	 * @generated
	 */
	void setTargetView(String value);

	/**
	 * Returns the value of the '<em><b>Drag Source Element</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drag Source Element</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Drag Source Element</em>' containment reference.
	 * @see #setDragSourceElement(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getDNDEvent_DragSourceElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getDragSourceElement();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getDragSourceElement
	 * <em>Drag Source Element</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Drag Source Element</em>' containment reference.
	 * @see #getDragSourceElement()
	 * @generated
	 */
	void setDragSourceElement(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Drop Target Element</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drop Target Element</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Drop Target Element</em>' containment reference.
	 * @see #setDropTargetElement(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getDNDEvent_DropTargetElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getDropTargetElement();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent#getDropTargetElement
	 * <em>Drop Target Element</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Drop Target Element</em>' containment reference.
	 * @see #getDropTargetElement()
	 * @generated
	 */
	void setDropTargetElement(ModelElementId value);

} // DNDEvent
