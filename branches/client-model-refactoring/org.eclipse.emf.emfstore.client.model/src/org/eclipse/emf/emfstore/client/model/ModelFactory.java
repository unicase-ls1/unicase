/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.client.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = org.eclipse.emf.emfstore.client.model.impl.ModelFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Workspace Data Internal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workspace Data Internal</em>'.
	 * @generated
	 */
	WorkspaceDataInternal createWorkspaceDataInternal();

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
	 * Returns a new object of class '<em>Project Space Data Internal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Space Data Internal</em>'.
	 * @generated
	 */
	ProjectSpaceDataInternal createProjectSpaceDataInternal();

	/**
	 * Returns a new object of class '<em>Operation Composite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Composite</em>'.
	 * @generated
	 */
	OperationComposite createOperationComposite();

	/**
	 * Returns a new object of class '<em>Pending File Transfer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pending File Transfer</em>'.
	 * @generated
	 */
	PendingFileTransfer createPendingFileTransfer();

	/**
	 * Returns a new object of class '<em>Project Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Data</em>'.
	 * @generated
	 */
	ProjectData createProjectData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
