/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.unicase.ecp.model.workSpaceModel.WorkSpaceModelPackage;

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
 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory
 * @model kind="package"
 * @generated
 */
public interface XmiworkspacestructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xmiworkspacestructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/xmiworkspace/structureModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.xmi.structureModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XmiworkspacestructurePackage eINSTANCE = org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject <em>XMIECP Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPProject
	 * @see org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructurePackageImpl#getXMIECPProject()
	 * @generated
	 */
	int XMIECP_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Workspace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT__WORKSPACE = WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE;

	/**
	 * The feature id for the '<em><b>Root Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT__ROOT_OBJECT = WorkSpaceModelPackage.ECP_PROJECT__ROOT_OBJECT;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT__PROJECT_NAME = WorkSpaceModelPackage.ECP_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT__PROJECT_DESCRIPTION = WorkSpaceModelPackage.ECP_PROJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XMIECP Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT_FEATURE_COUNT = WorkSpaceModelPackage.ECP_PROJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFileProjectImpl <em>XMIECP File Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFileProjectImpl
	 * @see org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructurePackageImpl#getXMIECPFileProject()
	 * @generated
	 */
	int XMIECP_FILE_PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Workspace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FILE_PROJECT__WORKSPACE = XMIECP_PROJECT__WORKSPACE;

	/**
	 * The feature id for the '<em><b>Root Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FILE_PROJECT__ROOT_OBJECT = XMIECP_PROJECT__ROOT_OBJECT;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FILE_PROJECT__PROJECT_NAME = XMIECP_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION = XMIECP_PROJECT__PROJECT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Xmi File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FILE_PROJECT__XMI_FILE_PATH = XMIECP_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XMIECP File Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FILE_PROJECT_FEATURE_COUNT = XMIECP_PROJECT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject <em>XMIECP Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMIECP Project</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPProject
	 * @generated
	 */
	EClass getXMIECPProject();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPProject#getProjectName()
	 * @see #getXMIECPProject()
	 * @generated
	 */
	EAttribute getXMIECPProject_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject#getProjectDescription <em>Project Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Description</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPProject#getProjectDescription()
	 * @see #getXMIECPProject()
	 * @generated
	 */
	EAttribute getXMIECPProject_ProjectDescription();

	/**
	 * Returns the meta object for class '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject <em>XMIECP File Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMIECP File Project</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject
	 * @generated
	 */
	EClass getXMIECPFileProject();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject#getXmiFilePath <em>Xmi File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmi File Path</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject#getXmiFilePath()
	 * @see #getXMIECPFileProject()
	 * @generated
	 */
	EAttribute getXMIECPFileProject_XmiFilePath();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XmiworkspacestructureFactory getXmiworkspacestructureFactory();

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
		 * The meta object literal for the '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject <em>XMIECP Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPProject
		 * @see org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructurePackageImpl#getXMIECPProject()
		 * @generated
		 */
		EClass XMIECP_PROJECT = eINSTANCE.getXMIECPProject();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMIECP_PROJECT__PROJECT_NAME = eINSTANCE.getXMIECPProject_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Project Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMIECP_PROJECT__PROJECT_DESCRIPTION = eINSTANCE.getXMIECPProject_ProjectDescription();

		/**
		 * The meta object literal for the '{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFileProjectImpl <em>XMIECP File Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFileProjectImpl
		 * @see org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructurePackageImpl#getXMIECPFileProject()
		 * @generated
		 */
		EClass XMIECP_FILE_PROJECT = eINSTANCE.getXMIECPFileProject();

		/**
		 * The meta object literal for the '<em><b>Xmi File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMIECP_FILE_PROJECT__XMI_FILE_PATH = eINSTANCE.getXMIECPFileProject_XmiFilePath();

	}

} //XmiworkspacestructurePackage
