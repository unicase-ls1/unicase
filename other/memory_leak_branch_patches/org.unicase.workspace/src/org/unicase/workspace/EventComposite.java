/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.versioning.events.Event;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Event Composite</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.workspace.EventComposite#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.workspace.WorkspacePackage#getEventComposite()
 * @model
 * @generated
 */
public interface EventComposite extends EObject {
	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.emfstore.esmodel.versioning.events.Event}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getEventComposite_Events()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Event> getEvents();

} // EventComposite
