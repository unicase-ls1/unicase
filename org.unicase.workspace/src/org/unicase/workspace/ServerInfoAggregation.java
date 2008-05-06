/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Info Aggregation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.ServerInfoAggregation#getServerInfos <em>Server Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.WorkspacePackage#getServerInfoAggregation()
 * @model
 * @generated
 */
public interface ServerInfoAggregation extends EObject {
	/**
	 * Returns the value of the '<em><b>Server Infos</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.workspace.ServerInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Infos</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Infos</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getServerInfoAggregation_ServerInfos()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServerInfo> getServerInfos();

} // ServerInfoAggregation
