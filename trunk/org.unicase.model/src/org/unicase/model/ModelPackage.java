/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

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
 * @see org.unicase.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.unicase.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.ModelElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.ModelElementImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__IDENTIFIER = 2;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__READER_INFOS = 3;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__ACTION_ITEMS = 4;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.ProjectImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Model Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__MODEL_ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.unicase.model.impl.UniqueIdentifierImpl <em>Unique Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.UniqueIdentifierImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getUniqueIdentifier()
	 * @generated
	 */
	int UNIQUE_IDENTIFIER = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_IDENTIFIER__ID = 0;

	/**
	 * The number of structural features of the '<em>Unique Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_IDENTIFIER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.ModelElementIdImpl <em>Element Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.ModelElementIdImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getModelElementId()
	 * @generated
	 */
	int MODEL_ELEMENT_ID = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ID__ID = UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Element Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ID_FEATURE_COUNT = UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.unicase.model.impl.ReaderInfoImpl <em>Reader Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.ReaderInfoImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getReaderInfo()
	 * @generated
	 */
	int READER_INFO = 4;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_INFO__DATE = 0;

	/**
	 * The feature id for the '<em><b>Reader Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_INFO__READER_ID = 1;

	/**
	 * The number of structural features of the '<em>Reader Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READER_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.TestForDiagramImpl <em>Test For Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.TestForDiagramImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getTestForDiagram()
	 * @generated
	 */
	int TEST_FOR_DIAGRAM = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FOR_DIAGRAM__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FOR_DIAGRAM__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FOR_DIAGRAM__IDENTIFIER = MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FOR_DIAGRAM__READER_INFOS = MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FOR_DIAGRAM__ACTION_ITEMS = MODEL_ELEMENT__ACTION_ITEMS;

	/**
	 * The number of structural features of the '<em>Test For Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FOR_DIAGRAM_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.ModelElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.unicase.model.ModelElement
	 * @generated
	 */
	EClass getModelElement();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.ModelElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.model.ModelElement#getName()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.ModelElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.model.ModelElement#getDescription()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Description();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.model.ModelElement#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.unicase.model.ModelElement#getIdentifier()
	 * @see #getModelElement()
	 * @generated
	 */
	EReference getModelElement_Identifier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.ModelElement#getReaderInfos <em>Reader Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reader Infos</em>'.
	 * @see org.unicase.model.ModelElement#getReaderInfos()
	 * @see #getModelElement()
	 * @generated
	 */
	EReference getModelElement_ReaderInfos();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.ModelElement#getActionItems <em>Action Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Action Items</em>'.
	 * @see org.unicase.model.ModelElement#getActionItems()
	 * @see #getModelElement()
	 * @generated
	 */
	EReference getModelElement_ActionItems();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.unicase.model.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.Project#getModelElements <em>Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elements</em>'.
	 * @see org.unicase.model.Project#getModelElements()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ModelElements();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.ModelElementId <em>Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Id</em>'.
	 * @see org.unicase.model.ModelElementId
	 * @generated
	 */
	EClass getModelElementId();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.UniqueIdentifier <em>Unique Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Identifier</em>'.
	 * @see org.unicase.model.UniqueIdentifier
	 * @generated
	 */
	EClass getUniqueIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.UniqueIdentifier#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.unicase.model.UniqueIdentifier#getId()
	 * @see #getUniqueIdentifier()
	 * @generated
	 */
	EAttribute getUniqueIdentifier_Id();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.ReaderInfo <em>Reader Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reader Info</em>'.
	 * @see org.unicase.model.ReaderInfo
	 * @generated
	 */
	EClass getReaderInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.ReaderInfo#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.unicase.model.ReaderInfo#getDate()
	 * @see #getReaderInfo()
	 * @generated
	 */
	EAttribute getReaderInfo_Date();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.ReaderInfo#getReaderId <em>Reader Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reader Id</em>'.
	 * @see org.unicase.model.ReaderInfo#getReaderId()
	 * @see #getReaderInfo()
	 * @generated
	 */
	EReference getReaderInfo_ReaderId();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.TestForDiagram <em>Test For Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test For Diagram</em>'.
	 * @see org.unicase.model.TestForDiagram
	 * @generated
	 */
	EClass getTestForDiagram();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.impl.ModelElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.ModelElementImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getModelElement()
		 * @generated
		 */
		EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__NAME = eINSTANCE.getModelElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__DESCRIPTION = eINSTANCE.getModelElement_Description();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT__IDENTIFIER = eINSTANCE.getModelElement_Identifier();

		/**
		 * The meta object literal for the '<em><b>Reader Infos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT__READER_INFOS = eINSTANCE.getModelElement_ReaderInfos();

		/**
		 * The meta object literal for the '<em><b>Action Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT__ACTION_ITEMS = eINSTANCE.getModelElement_ActionItems();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.ProjectImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Model Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__MODEL_ELEMENTS = eINSTANCE.getProject_ModelElements();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.ModelElementIdImpl <em>Element Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.ModelElementIdImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getModelElementId()
		 * @generated
		 */
		EClass MODEL_ELEMENT_ID = eINSTANCE.getModelElementId();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.UniqueIdentifierImpl <em>Unique Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.UniqueIdentifierImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getUniqueIdentifier()
		 * @generated
		 */
		EClass UNIQUE_IDENTIFIER = eINSTANCE.getUniqueIdentifier();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIQUE_IDENTIFIER__ID = eINSTANCE.getUniqueIdentifier_Id();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.ReaderInfoImpl <em>Reader Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.ReaderInfoImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getReaderInfo()
		 * @generated
		 */
		EClass READER_INFO = eINSTANCE.getReaderInfo();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READER_INFO__DATE = eINSTANCE.getReaderInfo_Date();

		/**
		 * The meta object literal for the '<em><b>Reader Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READER_INFO__READER_ID = eINSTANCE.getReaderInfo_ReaderId();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.TestForDiagramImpl <em>Test For Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.TestForDiagramImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getTestForDiagram()
		 * @generated
		 */
		EClass TEST_FOR_DIAGRAM = eINSTANCE.getTestForDiagram();

	}

} //ModelPackage
