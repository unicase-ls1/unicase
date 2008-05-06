/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.accesscontrol.roles;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.esmodel.accesscontrol.roles.RolesPackage
 * @generated
 */
public interface RolesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RolesFactory eINSTANCE = org.unicase.esmodel.accesscontrol.roles.impl.RolesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Reader Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reader Role</em>'.
	 * @generated
	 */
	ReaderRole createReaderRole();

	/**
	 * Returns a new object of class '<em>Writer Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Writer Role</em>'.
	 * @generated
	 */
	WriterRole createWriterRole();

	/**
	 * Returns a new object of class '<em>Project Admin Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Admin Role</em>'.
	 * @generated
	 */
	ProjectAdminRole createProjectAdminRole();

	/**
	 * Returns a new object of class '<em>Server Admin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Admin</em>'.
	 * @generated
	 */
	ServerAdmin createServerAdmin();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RolesPackage getRolesPackage();

} //RolesFactory
