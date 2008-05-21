/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.organization;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;

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
 * @see org.unicase.model.organization.OrganizationFactory
 * @model kind="package"
 * @generated
 */
public interface OrganizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "organization";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/organization";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.organization";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OrganizationPackage eINSTANCE = org.unicase.model.organization.impl.OrganizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.organization.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.organization.impl.UserImpl
	 * @see org.unicase.model.organization.impl.OrganizationPackageImpl#getUser()
	 * @generated
	 */
	int USER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ACTION_ITEMS = ModelPackage.MODEL_ELEMENT__ACTION_ITEMS;

	/**
	 * The feature id for the '<em><b>Org Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ORG_ID = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.unicase.model.organization.impl.OrgUnitImpl <em>Org Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.organization.impl.OrgUnitImpl
	 * @see org.unicase.model.organization.impl.OrganizationPackageImpl#getOrgUnit()
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
	int ORG_UNIT__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT__ACTION_ITEMS = ModelPackage.MODEL_ELEMENT__ACTION_ITEMS;

	/**
	 * The feature id for the '<em><b>Org Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT__ORG_ID = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Org Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.organization.impl.OrgUnitIdImpl <em>Org Unit Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.organization.impl.OrgUnitIdImpl
	 * @see org.unicase.model.organization.impl.OrganizationPackageImpl#getOrgUnitId()
	 * @generated
	 */
	int ORG_UNIT_ID = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_ID__ID = ModelPackage.UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Org Unit Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORG_UNIT_ID_FEATURE_COUNT = ModelPackage.UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.model.organization.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.organization.impl.GroupImpl
	 * @see org.unicase.model.organization.impl.OrganizationPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = ORG_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DESCRIPTION = ORG_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__IDENTIFIER = ORG_UNIT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__READER_INFOS = ORG_UNIT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ACTION_ITEMS = ORG_UNIT__ACTION_ITEMS;

	/**
	 * The feature id for the '<em><b>Org Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ORG_ID = ORG_UNIT__ORG_ID;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = ORG_UNIT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.organization.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.unicase.model.organization.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.organization.OrgUnit <em>Org Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Org Unit</em>'.
	 * @see org.unicase.model.organization.OrgUnit
	 * @generated
	 */
	EClass getOrgUnit();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.model.organization.OrgUnit#getOrgId <em>Org Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Org Id</em>'.
	 * @see org.unicase.model.organization.OrgUnit#getOrgId()
	 * @see #getOrgUnit()
	 * @generated
	 */
	EReference getOrgUnit_OrgId();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.organization.OrgUnitId <em>Org Unit Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Org Unit Id</em>'.
	 * @see org.unicase.model.organization.OrgUnitId
	 * @generated
	 */
	EClass getOrgUnitId();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.organization.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.unicase.model.organization.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OrganizationFactory getOrganizationFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.organization.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.organization.impl.UserImpl
		 * @see org.unicase.model.organization.impl.OrganizationPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();
		/**
		 * The meta object literal for the '{@link org.unicase.model.organization.impl.OrgUnitImpl <em>Org Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.organization.impl.OrgUnitImpl
		 * @see org.unicase.model.organization.impl.OrganizationPackageImpl#getOrgUnit()
		 * @generated
		 */
		EClass ORG_UNIT = eINSTANCE.getOrgUnit();
		/**
		 * The meta object literal for the '<em><b>Org Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORG_UNIT__ORG_ID = eINSTANCE.getOrgUnit_OrgId();
		/**
		 * The meta object literal for the '{@link org.unicase.model.organization.impl.OrgUnitIdImpl <em>Org Unit Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.organization.impl.OrgUnitIdImpl
		 * @see org.unicase.model.organization.impl.OrganizationPackageImpl#getOrgUnitId()
		 * @generated
		 */
		EClass ORG_UNIT_ID = eINSTANCE.getOrgUnitId();
		/**
		 * The meta object literal for the '{@link org.unicase.model.organization.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.organization.impl.GroupImpl
		 * @see org.unicase.model.organization.impl.OrganizationPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

	}

} //OrganizationPackage
