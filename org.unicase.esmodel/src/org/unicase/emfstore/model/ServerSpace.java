/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.model.accesscontrol.ACOrgUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.model.ServerSpace#getOrgUnits <em>Org Units</em>}</li>
 *   <li>{@link org.unicase.emfstore.model.ServerSpace#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.unicase.emfstore.model.ServerSpace#getOpenSessions <em>Open Sessions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.model.EsmodelPackage#getServerSpace()
 * @model
 * @generated
 */
public interface ServerSpace extends EObject {
	/**
	 * Returns the value of the '<em><b>Org Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.model.accesscontrol.ACOrgUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Org Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Org Units</em>' containment reference list.
	 * @see org.unicase.emfstore.model.EsmodelPackage#getServerSpace_OrgUnits()
	 * @model containment="true"
	 * @generated
	 */
	EList<ACOrgUnit> getOrgUnits();

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.model.ProjectHistory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see org.unicase.emfstore.model.EsmodelPackage#getServerSpace_Projects()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProjectHistory> getProjects();

	/**
	 * Returns the value of the '<em><b>Open Sessions</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.model.SessionId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Sessions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Sessions</em>' containment reference list.
	 * @see org.unicase.emfstore.model.EsmodelPackage#getServerSpace_OpenSessions()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<SessionId> getOpenSessions();

} // ServerSpace
