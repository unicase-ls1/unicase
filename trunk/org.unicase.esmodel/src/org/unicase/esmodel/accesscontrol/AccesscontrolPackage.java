/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.accesscontrol;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.esmodel.accesscontrol.AccesscontrolFactory
 * @model kind="package"
 * @generated
 */
public interface AccesscontrolPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "accesscontrol";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/accesscontrol";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.accesscontrol";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AccesscontrolPackage eINSTANCE = org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.accesscontrol.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.accesscontrol.impl.UserImpl
	 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getUser()
	 * @generated
	 */
	int USER = 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LAST_NAME = 1;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.accesscontrol.impl.OrgUnitImpl <em>Org Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.accesscontrol.impl.OrgUnitImpl
	 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getOrgUnit()
	 * @generated
	 */
	int ORG_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT__IDENTIFIER = 1;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT__ROLES = 2;

	/**
	 * The number of structural features of the '<em>Org Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.accesscontrol.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.accesscontrol.impl.GroupImpl
	 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = ORG_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__IDENTIFIER = ORG_UNIT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ROLES = ORG_UNIT__ROLES;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__MEMBERS = ORG_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = ORG_UNIT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.accesscontrol.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.accesscontrol.impl.RoleImpl
	 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 3;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__PROJECTS = 0;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.accesscontrol.impl.ReaderRoleImpl <em>Reader Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.accesscontrol.impl.ReaderRoleImpl
	 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getReaderRole()
	 * @generated
	 */
	int READER_ROLE = 4;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_ROLE__PROJECTS = ROLE__PROJECTS;

	/**
	 * The number of structural features of the '<em>Reader Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.accesscontrol.impl.WriterRoleImpl <em>Writer Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.accesscontrol.impl.WriterRoleImpl
	 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getWriterRole()
	 * @generated
	 */
	int WRITER_ROLE = 5;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITER_ROLE__PROJECTS = ROLE__PROJECTS;

	/**
	 * The number of structural features of the '<em>Writer Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITER_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.accesscontrol.impl.ProjectAdminRoleImpl <em>Project Admin Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.accesscontrol.impl.ProjectAdminRoleImpl
	 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getProjectAdminRole()
	 * @generated
	 */
	int PROJECT_ADMIN_ROLE = 6;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ADMIN_ROLE__PROJECTS = ROLE__PROJECTS;

	/**
	 * The number of structural features of the '<em>Project Admin Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ADMIN_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.accesscontrol.impl.ServerAdminImpl <em>Server Admin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.accesscontrol.impl.ServerAdminImpl
	 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getServerAdmin()
	 * @generated
	 */
	int SERVER_ADMIN = 7;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_ADMIN__PROJECTS = ROLE__PROJECTS;

	/**
	 * The number of structural features of the '<em>Server Admin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_ADMIN_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.accesscontrol.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.unicase.esmodel.accesscontrol.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.accesscontrol.User#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.unicase.esmodel.accesscontrol.User#getFirstName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.accesscontrol.User#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.unicase.esmodel.accesscontrol.User#getLastName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_LastName();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.accesscontrol.OrgUnit <em>Org Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Org Unit</em>'.
	 * @see org.unicase.esmodel.accesscontrol.OrgUnit
	 * @generated
	 */
	EClass getOrgUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.accesscontrol.OrgUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.esmodel.accesscontrol.OrgUnit#getName()
	 * @see #getOrgUnit()
	 * @generated
	 */
	EAttribute getOrgUnit_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.accesscontrol.OrgUnit#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.unicase.esmodel.accesscontrol.OrgUnit#getIdentifier()
	 * @see #getOrgUnit()
	 * @generated
	 */
	EAttribute getOrgUnit_Identifier();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.esmodel.accesscontrol.OrgUnit#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Roles</em>'.
	 * @see org.unicase.esmodel.accesscontrol.OrgUnit#getRoles()
	 * @see #getOrgUnit()
	 * @generated
	 */
	EReference getOrgUnit_Roles();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.accesscontrol.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.unicase.esmodel.accesscontrol.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.esmodel.accesscontrol.Group#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Members</em>'.
	 * @see org.unicase.esmodel.accesscontrol.Group#getMembers()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Members();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.accesscontrol.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.unicase.esmodel.accesscontrol.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.esmodel.accesscontrol.Role#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Projects</em>'.
	 * @see org.unicase.esmodel.accesscontrol.Role#getProjects()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Projects();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.accesscontrol.ReaderRole <em>Reader Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reader Role</em>'.
	 * @see org.unicase.esmodel.accesscontrol.ReaderRole
	 * @generated
	 */
	EClass getReaderRole();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.accesscontrol.WriterRole <em>Writer Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Writer Role</em>'.
	 * @see org.unicase.esmodel.accesscontrol.WriterRole
	 * @generated
	 */
	EClass getWriterRole();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.accesscontrol.ProjectAdminRole <em>Project Admin Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Admin Role</em>'.
	 * @see org.unicase.esmodel.accesscontrol.ProjectAdminRole
	 * @generated
	 */
	EClass getProjectAdminRole();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.accesscontrol.ServerAdmin <em>Server Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Admin</em>'.
	 * @see org.unicase.esmodel.accesscontrol.ServerAdmin
	 * @generated
	 */
	EClass getServerAdmin();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AccesscontrolFactory getAccesscontrolFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.accesscontrol.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.accesscontrol.impl.UserImpl
		 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__FIRST_NAME = eINSTANCE.getUser_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__LAST_NAME = eINSTANCE.getUser_LastName();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.accesscontrol.impl.OrgUnitImpl <em>Org Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.accesscontrol.impl.OrgUnitImpl
		 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getOrgUnit()
		 * @generated
		 */
		EClass ORG_UNIT = eINSTANCE.getOrgUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORG_UNIT__NAME = eINSTANCE.getOrgUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORG_UNIT__IDENTIFIER = eINSTANCE.getOrgUnit_Identifier();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORG_UNIT__ROLES = eINSTANCE.getOrgUnit_Roles();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.accesscontrol.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.accesscontrol.impl.GroupImpl
		 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__MEMBERS = eINSTANCE.getGroup_Members();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.accesscontrol.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.accesscontrol.impl.RoleImpl
		 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__PROJECTS = eINSTANCE.getRole_Projects();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.accesscontrol.impl.ReaderRoleImpl <em>Reader Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.accesscontrol.impl.ReaderRoleImpl
		 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getReaderRole()
		 * @generated
		 */
		EClass READER_ROLE = eINSTANCE.getReaderRole();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.accesscontrol.impl.WriterRoleImpl <em>Writer Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.accesscontrol.impl.WriterRoleImpl
		 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getWriterRole()
		 * @generated
		 */
		EClass WRITER_ROLE = eINSTANCE.getWriterRole();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.accesscontrol.impl.ProjectAdminRoleImpl <em>Project Admin Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.accesscontrol.impl.ProjectAdminRoleImpl
		 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getProjectAdminRole()
		 * @generated
		 */
		EClass PROJECT_ADMIN_ROLE = eINSTANCE.getProjectAdminRole();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.accesscontrol.impl.ServerAdminImpl <em>Server Admin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.accesscontrol.impl.ServerAdminImpl
		 * @see org.unicase.esmodel.accesscontrol.impl.AccesscontrolPackageImpl#getServerAdmin()
		 * @generated
		 */
		EClass SERVER_ADMIN = eINSTANCE.getServerAdmin();

	}

} //AccesscontrolPackage
