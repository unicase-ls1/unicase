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
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT__PROJECT_NAME = 0;

	/**
	 * The number of structural features of the '<em>XMIECP Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT_FEATURE_COUNT = 1;

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
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FILE_PROJECT__PROJECT_NAME = XMIECP_PROJECT__PROJECT_NAME;

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
	 * The meta object id for the '{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPProjectContainerImpl <em>XMIECP Project Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.xmi.xmiworkspacestructure.impl.XMIECPProjectContainerImpl
	 * @see org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructurePackageImpl#getXMIECPProjectContainer()
	 * @generated
	 */
	int XMIECP_PROJECT_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Internal Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT_CONTAINER__INTERNAL_PROJECTS = 0;

	/**
	 * The number of structural features of the '<em>XMIECP Project Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFolderImpl <em>XMIECP Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFolderImpl
	 * @see org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructurePackageImpl#getXMIECPFolder()
	 * @generated
	 */
	int XMIECP_FOLDER = 3;

	/**
	 * The feature id for the '<em><b>Internal Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER__INTERNAL_PROJECTS = XMIECP_PROJECT_CONTAINER__INTERNAL_PROJECTS;

	/**
	 * The feature id for the '<em><b>Xmi Directory Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER__XMI_DIRECTORY_PATH = XMIECP_PROJECT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contained Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER__CONTAINED_FILES = XMIECP_PROJECT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XMIECP Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER_FEATURE_COUNT = XMIECP_PROJECT_CONTAINER_FEATURE_COUNT + 2;


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
	 * Returns the meta object for class '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer <em>XMIECP Project Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMIECP Project Container</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer
	 * @generated
	 */
	EClass getXMIECPProjectContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer#getInternalProjects <em>Internal Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Projects</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer#getInternalProjects()
	 * @see #getXMIECPProjectContainer()
	 * @generated
	 */
	EReference getXMIECPProjectContainer_InternalProjects();

	/**
	 * Returns the meta object for class '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFolder <em>XMIECP Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMIECP Folder</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPFolder
	 * @generated
	 */
	EClass getXMIECPFolder();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFolder#getXmiDirectoryPath <em>Xmi Directory Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmi Directory Path</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPFolder#getXmiDirectoryPath()
	 * @see #getXMIECPFolder()
	 * @generated
	 */
	EAttribute getXMIECPFolder_XmiDirectoryPath();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFolder#getContainedFiles <em>Contained Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contained Files</em>'.
	 * @see org.unicase.xmi.xmiworkspacestructure.XMIECPFolder#getContainedFiles()
	 * @see #getXMIECPFolder()
	 * @generated
	 */
	EAttribute getXMIECPFolder_ContainedFiles();

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

		/**
		 * The meta object literal for the '{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPProjectContainerImpl <em>XMIECP Project Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.xmi.xmiworkspacestructure.impl.XMIECPProjectContainerImpl
		 * @see org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructurePackageImpl#getXMIECPProjectContainer()
		 * @generated
		 */
		EClass XMIECP_PROJECT_CONTAINER = eINSTANCE.getXMIECPProjectContainer();

		/**
		 * The meta object literal for the '<em><b>Internal Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMIECP_PROJECT_CONTAINER__INTERNAL_PROJECTS = eINSTANCE.getXMIECPProjectContainer_InternalProjects();

		/**
		 * The meta object literal for the '{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFolderImpl <em>XMIECP Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFolderImpl
		 * @see org.unicase.xmi.xmiworkspacestructure.impl.XmiworkspacestructurePackageImpl#getXMIECPFolder()
		 * @generated
		 */
		EClass XMIECP_FOLDER = eINSTANCE.getXMIECPFolder();

		/**
		 * The meta object literal for the '<em><b>Xmi Directory Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMIECP_FOLDER__XMI_DIRECTORY_PATH = eINSTANCE.getXMIECPFolder_XmiDirectoryPath();

		/**
		 * The meta object literal for the '<em><b>Contained Files</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMIECP_FOLDER__CONTAINED_FILES = eINSTANCE.getXMIECPFolder_ContainedFiles();

	}

} //XmiworkspacestructurePackage
