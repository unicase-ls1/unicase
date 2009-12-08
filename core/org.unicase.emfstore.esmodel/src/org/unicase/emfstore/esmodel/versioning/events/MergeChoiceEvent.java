/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Merge Choice Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getMyChanges <em>My Changes</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getTheirChanges <em>Their Changes</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getContextModelElement <em>Context Model
 * Element</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getSelection <em>Selection</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getContextFeature <em>Context Feature
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getCreatedIssue <em>Created Issue</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getMergeChoiceEvent()
 * @model
 * @generated
 */
public interface MergeChoiceEvent extends Event {
	/**
	 * Returns the value of the '<em><b>My Changes</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.OperationId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Changes</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>My Changes</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getMergeChoiceEvent_MyChanges()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<OperationId> getMyChanges();

	/**
	 * Returns the value of the '<em><b>Their Changes</b></em>' containment reference list. The list contents are of
	 * type {@link org.unicase.emfstore.esmodel.versioning.operations.OperationId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Their Changes</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Their Changes</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getMergeChoiceEvent_TheirChanges()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<OperationId> getTheirChanges();

	/**
	 * Returns the value of the '<em><b>Context Model Element</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Model Element</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Context Model Element</em>' containment reference.
	 * @see #setContextModelElement(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getMergeChoiceEvent_ContextModelElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getContextModelElement();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getContextModelElement
	 * <em>Context Model Element</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Context Model Element</em>' containment reference.
	 * @see #getContextModelElement()
	 * @generated
	 */
	void setContextModelElement(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Selection</b></em>' attribute. The literals are from the enumeration
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Selection</em>' attribute.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection
	 * @see #setSelection(MergeChoiceSelection)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getMergeChoiceEvent_Selection()
	 * @model
	 * @generated
	 */
	MergeChoiceSelection getSelection();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getSelection
	 * <em>Selection</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Selection</em>' attribute.
	 * @see org.unicase.emfstore.esmodel.versioning.events.MergeChoiceSelection
	 * @see #getSelection()
	 * @generated
	 */
	void setSelection(MergeChoiceSelection value);

	/**
	 * Returns the value of the '<em><b>Context Feature</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Feature</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Context Feature</em>' attribute.
	 * @see #setContextFeature(String)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getMergeChoiceEvent_ContextFeature()
	 * @model
	 * @generated
	 */
	String getContextFeature();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getContextFeature
	 * <em>Context Feature</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Context Feature</em>' attribute.
	 * @see #getContextFeature()
	 * @generated
	 */
	void setContextFeature(String value);

	/**
	 * Returns the value of the '<em><b>Created Issue</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created Issue</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Created Issue</em>' containment reference.
	 * @see #setCreatedIssue(ModelElementId)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getMergeChoiceEvent_CreatedIssue()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getCreatedIssue();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent#getCreatedIssue
	 * <em>Created Issue</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Created Issue</em>' containment reference.
	 * @see #getCreatedIssue()
	 * @generated
	 */
	void setCreatedIssue(ModelElementId value);

} // MergeChoiceEvent
