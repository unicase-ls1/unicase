/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.events;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Merge Event</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent#getNumberOfConflicts <em>Number Of Conflicts</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent#getTotalTime <em>Total Time</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent#getTargetVersion <em>Target Version</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent#getLocalChanges <em>Local Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeEvent()
 * @model
 * @generated
 */
public interface MergeEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Number Of Conflicts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Conflicts</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Conflicts</em>' attribute.
	 * @see #setNumberOfConflicts(int)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeEvent_NumberOfConflicts()
	 * @model
	 * @generated
	 */
	int getNumberOfConflicts();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent#getNumberOfConflicts <em>Number Of Conflicts</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Conflicts</em>' attribute.
	 * @see #getNumberOfConflicts()
	 * @generated
	 */
	void setNumberOfConflicts(int value);

	/**
	 * Returns the value of the '<em><b>Total Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Time</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Time</em>' attribute.
	 * @see #setTotalTime(int)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeEvent_TotalTime()
	 * @model
	 * @generated
	 */
	int getTotalTime();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent#getTotalTime <em>Total Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Time</em>' attribute.
	 * @see #getTotalTime()
	 * @generated
	 */
	void setTotalTime(int value);

	/**
	 * Returns the value of the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Version</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Version</em>' containment reference.
	 * @see #setBaseVersion(PrimaryVersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeEvent_BaseVersion()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getBaseVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent#getBaseVersion <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Version</em>' containment reference.
	 * @see #getBaseVersion()
	 * @generated
	 */
	void setBaseVersion(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Target Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Version</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Version</em>' containment reference.
	 * @see #setTargetVersion(PrimaryVersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeEvent_TargetVersion()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getTargetVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeEvent#getTargetVersion <em>Target Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Version</em>' containment reference.
	 * @see #getTargetVersion()
	 * @generated
	 */
	void setTargetVersion(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Local Changes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Changes</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Changes</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getMergeEvent_LocalChanges()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<AbstractOperation> getLocalChanges();

} // MergeEvent
