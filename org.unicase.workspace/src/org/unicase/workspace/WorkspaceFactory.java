/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.workspace.WorkspacePackage
 * @generated
 */
public interface WorkspaceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkspaceFactory eINSTANCE = org.unicase.workspace.impl.WorkspaceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Workspace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workspace</em>'.
	 * @generated
	 */
	Workspace createWorkspace();

	/**
	 * Returns a new object of class '<em>Server Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Info</em>'.
	 * @generated
	 */
	ServerInfo createServerInfo();

	/**
	 * Returns a new object of class '<em>Usersession</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Usersession</em>'.
	 * @generated
	 */
	Usersession createUsersession();

	/**
	 * Returns a new object of class '<em>Project Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Space</em>'.
	 * @generated
	 */
	ProjectSpace createProjectSpace();

	/**
	 * Returns a new object of class '<em>Server Info Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Info Aggregation</em>'.
	 * @generated
	 */
	ServerInfoAggregation createServerInfoAggregation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WorkspacePackage getWorkspacePackage();

} //WorkspaceFactory
