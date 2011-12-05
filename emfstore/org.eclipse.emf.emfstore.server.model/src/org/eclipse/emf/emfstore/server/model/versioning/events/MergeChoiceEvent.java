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
package org.eclipse.emf.emfstore.server.model.versioning.events;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Merge Choice Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getMyChanges <em>My Changes</em>}
 * </li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getTheirChanges <em>Their Changes
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getContextModelElement <em>
 * Context Model Element</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getSelection <em>Selection</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getContextFeature <em>Context
 * Feature </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getCreatedIssue <em>Created Issue
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeChoiceEvent()
 * @model
 * @generated
 */
public interface MergeChoiceEvent extends Event {
	/**
	 * Returns the value of the '<em><b>My Accepted Changes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Accepted Changes</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>My Accepted Changes</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeChoiceEvent_MyAcceptedChanges()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<OperationId> getMyAcceptedChanges();

	/**
	 * Returns the value of the '<em><b>Their Rejected Changes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Their Rejected Changes</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Their Rejected Changes</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeChoiceEvent_TheirRejectedChanges()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<OperationId> getTheirRejectedChanges();

	/**
	 * Returns the value of the '<em><b>Context Model Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Model Element</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Context Model Element</em>' containment reference.
	 * @see #setContextModelElement(ModelElementId)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeChoiceEvent_ContextModelElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getContextModelElement();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getContextModelElement
	 * <em>Context Model Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Context Model Element</em>' containment reference.
	 * @see #getContextModelElement()
	 * @generated
	 */
	void setContextModelElement(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Selection</b></em>' attribute.
	 * The literals are from the enumeration
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceSelection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Selection</em>' attribute.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceSelection
	 * @see #setSelection(MergeChoiceSelection)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeChoiceEvent_Selection()
	 * @model
	 * @generated
	 */
	MergeChoiceSelection getSelection();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getSelection <em>Selection</em>}'
	 * attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Selection</em>' attribute.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceSelection
	 * @see #getSelection()
	 * @generated
	 */
	void setSelection(MergeChoiceSelection value);

	/**
	 * Returns the value of the '<em><b>Context Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Feature</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Context Feature</em>' attribute.
	 * @see #setContextFeature(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeChoiceEvent_ContextFeature()
	 * @model
	 * @generated
	 */
	String getContextFeature();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getContextFeature
	 * <em>Context Feature</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Context Feature</em>' attribute.
	 * @see #getContextFeature()
	 * @generated
	 */
	void setContextFeature(String value);

	/**
	 * Returns the value of the '<em><b>Created Issue Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created Issue Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Created Issue Name</em>' attribute.
	 * @see #setCreatedIssueName(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeChoiceEvent_CreatedIssueName()
	 * @model
	 * @generated
	 */
	String getCreatedIssueName();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent#getCreatedIssueName
	 * <em>Created Issue Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Created Issue Name</em>' attribute.
	 * @see #getCreatedIssueName()
	 * @generated
	 */
	void setCreatedIssueName(String value);

} // MergeChoiceEvent
