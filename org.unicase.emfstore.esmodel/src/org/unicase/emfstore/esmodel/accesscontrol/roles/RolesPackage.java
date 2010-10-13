/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.accesscontrol.roles;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.RolesFactory
 * @model kind="package"
 * @generated
 */
public interface RolesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "roles";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/accesscontrol/roles";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.accesscontrol.roles";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	RolesPackage eINSTANCE = org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RoleImpl
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 0;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__PROJECTS = 0;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ReaderRoleImpl <em>Reader Role</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ReaderRoleImpl
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getReaderRole()
	 * @generated
	 */
	int READER_ROLE = 1;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_ROLE__PROJECTS = ROLE__PROJECTS;

	/**
	 * The number of structural features of the '<em>Reader Role</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int READER_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.WriterRoleImpl <em>Writer Role</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.WriterRoleImpl
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getWriterRole()
	 * @generated
	 */
	int WRITER_ROLE = 2;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITER_ROLE__PROJECTS = ROLE__PROJECTS;

	/**
	 * The number of structural features of the '<em>Writer Role</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WRITER_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ProjectAdminRoleImpl <em>Project Admin Role</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ProjectAdminRoleImpl
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getProjectAdminRole()
	 * @generated
	 */
	int PROJECT_ADMIN_ROLE = 3;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ADMIN_ROLE__PROJECTS = ROLE__PROJECTS;

	/**
	 * The number of structural features of the '<em>Project Admin Role</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ADMIN_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ServerAdminImpl <em>Server Admin</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ServerAdminImpl
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getServerAdmin()
	 * @generated
	 */
	int SERVER_ADMIN = 4;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_ADMIN__PROJECTS = ROLE__PROJECTS;

	/**
	 * The number of structural features of the '<em>Server Admin</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_ADMIN_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.Role <em>Role</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.Role#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.Role#getProjects()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Projects();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.ReaderRole <em>Reader Role</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reader Role</em>'.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.ReaderRole
	 * @generated
	 */
	EClass getReaderRole();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.WriterRole <em>Writer Role</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Writer Role</em>'.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.WriterRole
	 * @generated
	 */
	EClass getWriterRole();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.ProjectAdminRole <em>Project Admin Role</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Admin Role</em>'.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.ProjectAdminRole
	 * @generated
	 */
	EClass getProjectAdminRole();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.ServerAdmin <em>Server Admin</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Admin</em>'.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.ServerAdmin
	 * @generated
	 */
	EClass getServerAdmin();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RolesFactory getRolesFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RoleImpl
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ROLE__PROJECTS = eINSTANCE.getRole_Projects();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ReaderRoleImpl <em>Reader Role</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ReaderRoleImpl
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getReaderRole()
		 * @generated
		 */
		EClass READER_ROLE = eINSTANCE.getReaderRole();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.WriterRoleImpl <em>Writer Role</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.WriterRoleImpl
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getWriterRole()
		 * @generated
		 */
		EClass WRITER_ROLE = eINSTANCE.getWriterRole();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ProjectAdminRoleImpl <em>Project Admin Role</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ProjectAdminRoleImpl
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getProjectAdminRole()
		 * @generated
		 */
		EClass PROJECT_ADMIN_ROLE = eINSTANCE.getProjectAdminRole();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ServerAdminImpl <em>Server Admin</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.ServerAdminImpl
		 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl#getServerAdmin()
		 * @generated
		 */
		EClass SERVER_ADMIN = eINSTANCE.getServerAdmin();

	}

} // RolesPackage
