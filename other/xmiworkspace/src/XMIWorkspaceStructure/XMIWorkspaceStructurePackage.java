/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure;

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
 * @see XMIWorkspaceStructure.XMIWorkspaceStructureFactory
 * @model kind="package"
 * @generated
 */
public interface XMIWorkspaceStructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "XMIWorkspaceStructure";

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
	XMIWorkspaceStructurePackage eINSTANCE = XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link XMIWorkspaceStructure.XMIECPProject <em>XMIECP Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see XMIWorkspaceStructure.XMIECPProject
	 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPProject()
	 * @generated
	 */
	int XMIECP_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Editing Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT__EDITING_DOMAIN = 1;

	/**
	 * The number of structural features of the '<em>XMIECP Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_PROJECT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link XMIWorkspaceStructure.impl.XMIECPFileProjectImpl <em>XMIECP File Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see XMIWorkspaceStructure.impl.XMIECPFileProjectImpl
	 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPFileProject()
	 * @generated
	 */
	int XMIECP_FILE_PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FILE_PROJECT__ELEMENTS = XMIECP_PROJECT__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Editing Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FILE_PROJECT__EDITING_DOMAIN = XMIECP_PROJECT__EDITING_DOMAIN;

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
	 * The meta object id for the '{@link XMIWorkspaceStructure.impl.XMIECPContainerImpl <em>XMIECP Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see XMIWorkspaceStructure.impl.XMIECPContainerImpl
	 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPContainer()
	 * @generated
	 */
	int XMIECP_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_CONTAINER__ELEMENTS = XMIECP_PROJECT__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Editing Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_CONTAINER__EDITING_DOMAIN = XMIECP_PROJECT__EDITING_DOMAIN;

	/**
	 * The feature id for the '<em><b>Internal Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_CONTAINER__INTERNAL_PROJECTS = XMIECP_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XMIECP Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_CONTAINER_FEATURE_COUNT = XMIECP_PROJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link XMIWorkspaceStructure.impl.XMIECPVirtualContainerImpl <em>XMIECP Virtual Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see XMIWorkspaceStructure.impl.XMIECPVirtualContainerImpl
	 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPVirtualContainer()
	 * @generated
	 */
	int XMIECP_VIRTUAL_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_VIRTUAL_CONTAINER__ELEMENTS = XMIECP_CONTAINER__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Editing Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_VIRTUAL_CONTAINER__EDITING_DOMAIN = XMIECP_CONTAINER__EDITING_DOMAIN;

	/**
	 * The feature id for the '<em><b>Internal Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_VIRTUAL_CONTAINER__INTERNAL_PROJECTS = XMIECP_CONTAINER__INTERNAL_PROJECTS;

	/**
	 * The feature id for the '<em><b>Xmi File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_VIRTUAL_CONTAINER__XMI_FILE_PATH = XMIECP_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XMIECP Virtual Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_VIRTUAL_CONTAINER_FEATURE_COUNT = XMIECP_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link XMIWorkspaceStructure.impl.XMIECPFolderImpl <em>XMIECP Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see XMIWorkspaceStructure.impl.XMIECPFolderImpl
	 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPFolder()
	 * @generated
	 */
	int XMIECP_FOLDER = 4;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER__ELEMENTS = XMIECP_CONTAINER__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Editing Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER__EDITING_DOMAIN = XMIECP_CONTAINER__EDITING_DOMAIN;

	/**
	 * The feature id for the '<em><b>Internal Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER__INTERNAL_PROJECTS = XMIECP_CONTAINER__INTERNAL_PROJECTS;

	/**
	 * The feature id for the '<em><b>Xmi Directory Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER__XMI_DIRECTORY_PATH = XMIECP_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contained Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER__CONTAINED_FILES = XMIECP_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER__PROJECT_RESOURCES = XMIECP_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XMIECP Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMIECP_FOLDER_FEATURE_COUNT = XMIECP_CONTAINER_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link XMIWorkspaceStructure.XMIECPProject <em>XMIECP Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMIECP Project</em>'.
	 * @see XMIWorkspaceStructure.XMIECPProject
	 * @generated
	 */
	EClass getXMIECPProject();

	/**
	 * Returns the meta object for the attribute '{@link XMIWorkspaceStructure.XMIECPProject#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Elements</em>'.
	 * @see XMIWorkspaceStructure.XMIECPProject#getElements()
	 * @see #getXMIECPProject()
	 * @generated
	 */
	EAttribute getXMIECPProject_Elements();

	/**
	 * Returns the meta object for the attribute '{@link XMIWorkspaceStructure.XMIECPProject#getEditingDomain <em>Editing Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Editing Domain</em>'.
	 * @see XMIWorkspaceStructure.XMIECPProject#getEditingDomain()
	 * @see #getXMIECPProject()
	 * @generated
	 */
	EAttribute getXMIECPProject_EditingDomain();

	/**
	 * Returns the meta object for class '{@link XMIWorkspaceStructure.XMIECPFileProject <em>XMIECP File Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMIECP File Project</em>'.
	 * @see XMIWorkspaceStructure.XMIECPFileProject
	 * @generated
	 */
	EClass getXMIECPFileProject();

	/**
	 * Returns the meta object for the attribute '{@link XMIWorkspaceStructure.XMIECPFileProject#getXmiFilePath <em>Xmi File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmi File Path</em>'.
	 * @see XMIWorkspaceStructure.XMIECPFileProject#getXmiFilePath()
	 * @see #getXMIECPFileProject()
	 * @generated
	 */
	EAttribute getXMIECPFileProject_XmiFilePath();

	/**
	 * Returns the meta object for class '{@link XMIWorkspaceStructure.XMIECPContainer <em>XMIECP Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMIECP Container</em>'.
	 * @see XMIWorkspaceStructure.XMIECPContainer
	 * @generated
	 */
	EClass getXMIECPContainer();

	/**
	 * Returns the meta object for the attribute '{@link XMIWorkspaceStructure.XMIECPContainer#getInternalProjects <em>Internal Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Internal Projects</em>'.
	 * @see XMIWorkspaceStructure.XMIECPContainer#getInternalProjects()
	 * @see #getXMIECPContainer()
	 * @generated
	 */
	EAttribute getXMIECPContainer_InternalProjects();

	/**
	 * Returns the meta object for class '{@link XMIWorkspaceStructure.XMIECPVirtualContainer <em>XMIECP Virtual Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMIECP Virtual Container</em>'.
	 * @see XMIWorkspaceStructure.XMIECPVirtualContainer
	 * @generated
	 */
	EClass getXMIECPVirtualContainer();

	/**
	 * Returns the meta object for the attribute '{@link XMIWorkspaceStructure.XMIECPVirtualContainer#getXmiFilePath <em>Xmi File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmi File Path</em>'.
	 * @see XMIWorkspaceStructure.XMIECPVirtualContainer#getXmiFilePath()
	 * @see #getXMIECPVirtualContainer()
	 * @generated
	 */
	EAttribute getXMIECPVirtualContainer_XmiFilePath();

	/**
	 * Returns the meta object for class '{@link XMIWorkspaceStructure.XMIECPFolder <em>XMIECP Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMIECP Folder</em>'.
	 * @see XMIWorkspaceStructure.XMIECPFolder
	 * @generated
	 */
	EClass getXMIECPFolder();

	/**
	 * Returns the meta object for the attribute '{@link XMIWorkspaceStructure.XMIECPFolder#getXmiDirectoryPath <em>Xmi Directory Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmi Directory Path</em>'.
	 * @see XMIWorkspaceStructure.XMIECPFolder#getXmiDirectoryPath()
	 * @see #getXMIECPFolder()
	 * @generated
	 */
	EAttribute getXMIECPFolder_XmiDirectoryPath();

	/**
	 * Returns the meta object for the attribute '{@link XMIWorkspaceStructure.XMIECPFolder#getContainedFiles <em>Contained Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contained Files</em>'.
	 * @see XMIWorkspaceStructure.XMIECPFolder#getContainedFiles()
	 * @see #getXMIECPFolder()
	 * @generated
	 */
	EAttribute getXMIECPFolder_ContainedFiles();

	/**
	 * Returns the meta object for the reference list '{@link XMIWorkspaceStructure.XMIECPFolder#getProjectResources <em>Project Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Project Resources</em>'.
	 * @see XMIWorkspaceStructure.XMIECPFolder#getProjectResources()
	 * @see #getXMIECPFolder()
	 * @generated
	 */
	EReference getXMIECPFolder_ProjectResources();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XMIWorkspaceStructureFactory getXMIWorkspaceStructureFactory();

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
		 * The meta object literal for the '{@link XMIWorkspaceStructure.XMIECPProject <em>XMIECP Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see XMIWorkspaceStructure.XMIECPProject
		 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPProject()
		 * @generated
		 */
		EClass XMIECP_PROJECT = eINSTANCE.getXMIECPProject();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMIECP_PROJECT__ELEMENTS = eINSTANCE.getXMIECPProject_Elements();

		/**
		 * The meta object literal for the '<em><b>Editing Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMIECP_PROJECT__EDITING_DOMAIN = eINSTANCE.getXMIECPProject_EditingDomain();

		/**
		 * The meta object literal for the '{@link XMIWorkspaceStructure.impl.XMIECPFileProjectImpl <em>XMIECP File Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see XMIWorkspaceStructure.impl.XMIECPFileProjectImpl
		 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPFileProject()
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
		 * The meta object literal for the '{@link XMIWorkspaceStructure.impl.XMIECPContainerImpl <em>XMIECP Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see XMIWorkspaceStructure.impl.XMIECPContainerImpl
		 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPContainer()
		 * @generated
		 */
		EClass XMIECP_CONTAINER = eINSTANCE.getXMIECPContainer();

		/**
		 * The meta object literal for the '<em><b>Internal Projects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMIECP_CONTAINER__INTERNAL_PROJECTS = eINSTANCE.getXMIECPContainer_InternalProjects();

		/**
		 * The meta object literal for the '{@link XMIWorkspaceStructure.impl.XMIECPVirtualContainerImpl <em>XMIECP Virtual Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see XMIWorkspaceStructure.impl.XMIECPVirtualContainerImpl
		 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPVirtualContainer()
		 * @generated
		 */
		EClass XMIECP_VIRTUAL_CONTAINER = eINSTANCE.getXMIECPVirtualContainer();

		/**
		 * The meta object literal for the '<em><b>Xmi File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMIECP_VIRTUAL_CONTAINER__XMI_FILE_PATH = eINSTANCE.getXMIECPVirtualContainer_XmiFilePath();

		/**
		 * The meta object literal for the '{@link XMIWorkspaceStructure.impl.XMIECPFolderImpl <em>XMIECP Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see XMIWorkspaceStructure.impl.XMIECPFolderImpl
		 * @see XMIWorkspaceStructure.impl.XMIWorkspaceStructurePackageImpl#getXMIECPFolder()
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

		/**
		 * The meta object literal for the '<em><b>Project Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMIECP_FOLDER__PROJECT_RESOURCES = eINSTANCE.getXMIECPFolder_ProjectResources();

	}

} //XMIWorkspaceStructurePackage
