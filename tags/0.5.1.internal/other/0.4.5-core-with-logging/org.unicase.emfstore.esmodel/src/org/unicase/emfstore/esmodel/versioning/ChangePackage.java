/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Change Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getOperations <em>Operations</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getEvents <em>Events</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getLogMessage <em>Log Message</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getNotifications <em>Notifications</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getVersionProperties <em>Version Properties</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage()
 * @model
 * @generated
 */
public interface ChangePackage extends EObject {

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage_Operations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<AbstractOperation> getOperations();

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
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage_Events()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Log Message</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Message</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Log Message</em>' containment reference.
	 * @see #setLogMessage(LogMessage)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage_LogMessage()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	LogMessage getLogMessage();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getLogMessage
	 * <em>Log Message</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Log Message</em>' containment reference.
	 * @see #getLogMessage()
	 * @generated
	 */
	void setLogMessage(LogMessage value);

	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference list. The list contents are of
	 * type {@link org.unicase.emfstore.esmodel.notification.ESNotification}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Notifications</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage_Notifications()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ESNotification> getNotifications();

	/**
	 * Returns the value of the '<em><b>Version Properties</b></em>' containment reference list. The list contents are
	 * of type {@link org.unicase.emfstore.esmodel.versioning.VersionProperty}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Properties</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Version Properties</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getChangePackage_VersionProperties()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<VersionProperty> getVersionProperties();

	/**
	 * Apply all operations in the change package to the given project.
	 * 
	 * @param project the project
	 */
	void apply(Project project);

	/**
	 * Apply all operations in the change package to the given project. Additional you can force the operations to be
	 * applied with illegal operations being ignored.
	 * 
	 * @param project the project
	 * @param force if true, illegal Operations won't stop the other to be applied
	 */
	void apply(Project project, boolean force);

	/**
	 * Remove all operations from the change package that are masked by later operations in the same package.
	 */
	void cannonize();

	/**
	 * Reverse the change package. Applying a change package and then its reversed change package does not change a
	 * project in effect.
	 * 
	 * @return the reverse change package
	 */
	ChangePackage reverse();

	/**
	 * Retrieve a copy of all operations in the change package.
	 */
	List<AbstractOperation> getCopyOfOperations();

	/**
	 * Get all leaf operations of a change package, decomposing all composite operations. The effect of the leaf
	 * operations on a project is the same as the effect of the root operations of this change package.
	 * 
	 * @return a list of leaf operations.
	 */
	List<AbstractOperation> getLeafOperations();

	/**
	 * Returns all model elements that are involved in this change package.
	 * 
	 * @return a set of model element ids
	 */
	Set<ModelElementId> getAllInvolvedModelElements();

	/**
	 * Get all operations of a change package, that are touching the given model element id
	 * 
	 * @return a list of leaf operations.
	 */
	List<AbstractOperation> getTouchingOperations(ModelElementId modelElementId);

} // ChangePackage
