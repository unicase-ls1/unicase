/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.events;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Merge Global Choice Event</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceEvent#getSelection <em>Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeGlobalChoiceEvent()
 * @model
 * @generated
 */
public interface MergeGlobalChoiceEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Selection</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceSelection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' attribute.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceSelection
	 * @see #setSelection(MergeGlobalChoiceSelection)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeGlobalChoiceEvent_Selection()
	 * @model
	 * @generated
	 */
	MergeGlobalChoiceSelection getSelection();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceEvent#getSelection <em>Selection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection</em>' attribute.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.MergeGlobalChoiceSelection
	 * @see #getSelection()
	 * @generated
	 */
	void setSelection(MergeGlobalChoiceSelection value);

} // MergeGlobalChoiceEvent
