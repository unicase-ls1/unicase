/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.ProjectId;
import org.unicase.workspace.connectionmanager.ConnectionException;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace</b></em>'.
 * @implements IAdaptable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.Workspace#getProjectSpaces <em>Project Spaces</em>}</li>
 *   <li>{@link org.unicase.workspace.Workspace#getServerInfoAggregation <em>Server Info Aggregation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.WorkspacePackage#getWorkspace()
 * @model
 * @generated
 */
public interface Workspace extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Project Spaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.workspace.ProjectSpace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Spaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Spaces</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_ProjectSpaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProjectSpace> getProjectSpaces();

	/**
	 * Returns the value of the '<em><b>Server Info Aggregation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Info Aggregation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Info Aggregation</em>' containment reference.
	 * @see #setServerInfoAggregation(ServerInfoAggregation)
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_ServerInfoAggregation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ServerInfoAggregation getServerInfoAggregation();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Workspace#getServerInfoAggregation <em>Server Info Aggregation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Info Aggregation</em>' containment reference.
	 * @see #getServerInfoAggregation()
	 * @generated
	 */
	void setServerInfoAggregation(ServerInfoAggregation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ConnectionException 
	 * @throws EmfStoreException 
	 * @model
	 * @generated NOT
	 */
	ProjectSpace checkout(Usersession usersession, ProjectId projectId, VersionSpec version) throws EmfStoreException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void save();
	
	/**
	 * @param connectionManager
	 *
	 * @generated NOT
	 */
	public void setConnectionManager(ConnectionManager connectionManager);

	/**
	 * @param resource
	 *
	 * @generated NOT
	 */
	public void setResource(Resource resource);
	
} // Workspace
