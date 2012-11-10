/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see scrm.ScrmFactory
 * @model kind="package"
 * @generated
 */
public interface ScrmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scrm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/scrm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.scrm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScrmPackage eINSTANCE = scrm.impl.ScrmPackageImpl.init();

	/**
	 * The meta object id for the '{@link scrm.impl.SCRMModelElementImpl <em>SCRM Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.impl.SCRMModelElementImpl
	 * @see scrm.impl.ScrmPackageImpl#getSCRMModelElement()
	 * @generated
	 */
	int SCRM_MODEL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SCRM Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scrm.impl.SCRMDiagramImpl <em>SCRM Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.impl.SCRMDiagramImpl
	 * @see scrm.impl.ScrmPackageImpl#getSCRMDiagram()
	 * @generated
	 */
	int SCRM_DIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__NAME = SCRM_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__DESCRIPTION = SCRM_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__ANNOTATIONS = SCRM_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__ATTACHMENTS = SCRM_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__INCOMING_DOCUMENT_REFERENCES = SCRM_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__LEAF_SECTION = SCRM_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__STATE = SCRM_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__COMMENTS = SCRM_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__CREATION_DATE = SCRM_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__CREATOR = SCRM_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__DISPLAYING_DIAGRAMS = SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__ELEMENTS = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__GMFDIAGRAM = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__NEW_ELEMENTS = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__DIAGRAM_LAYOUT = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Diagram Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__DIAGRAM_TYPE = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SCRM Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM_FEATURE_COUNT = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link scrm.DiagramType <em>Diagram Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.DiagramType
	 * @see scrm.impl.ScrmPackageImpl#getDiagramType()
	 * @generated
	 */
	int DIAGRAM_TYPE = 2;

	/**
	 * Returns the meta object for class '{@link scrm.SCRMModelElement <em>SCRM Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCRM Model Element</em>'.
	 * @see scrm.SCRMModelElement
	 * @generated
	 */
	EClass getSCRMModelElement();

	/**
	 * Returns the meta object for the reference list '{@link scrm.SCRMModelElement#getDisplayingDiagrams <em>Displaying Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Displaying Diagrams</em>'.
	 * @see scrm.SCRMModelElement#getDisplayingDiagrams()
	 * @see #getSCRMModelElement()
	 * @generated
	 */
	EReference getSCRMModelElement_DisplayingDiagrams();

	/**
	 * Returns the meta object for class '{@link scrm.SCRMDiagram <em>SCRM Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCRM Diagram</em>'.
	 * @see scrm.SCRMDiagram
	 * @generated
	 */
	EClass getSCRMDiagram();

	/**
	 * Returns the meta object for the reference list '{@link scrm.SCRMDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see scrm.SCRMDiagram#getElements()
	 * @see #getSCRMDiagram()
	 * @generated
	 */
	EReference getSCRMDiagram_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.SCRMDiagram#getNewElements <em>New Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>New Elements</em>'.
	 * @see scrm.SCRMDiagram#getNewElements()
	 * @see #getSCRMDiagram()
	 * @generated
	 */
	EReference getSCRMDiagram_NewElements();

	/**
	 * Returns the meta object for the attribute '{@link scrm.SCRMDiagram#getDiagramLayout <em>Diagram Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Layout</em>'.
	 * @see scrm.SCRMDiagram#getDiagramLayout()
	 * @see #getSCRMDiagram()
	 * @generated
	 */
	EAttribute getSCRMDiagram_DiagramLayout();

	/**
	 * Returns the meta object for the attribute '{@link scrm.SCRMDiagram#getDiagramType <em>Diagram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Type</em>'.
	 * @see scrm.SCRMDiagram#getDiagramType()
	 * @see #getSCRMDiagram()
	 * @generated
	 */
	EAttribute getSCRMDiagram_DiagramType();

	/**
	 * Returns the meta object for enum '{@link scrm.DiagramType <em>Diagram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Diagram Type</em>'.
	 * @see scrm.DiagramType
	 * @generated
	 */
	EEnum getDiagramType();

	/**
	 * Returns the meta object for the containment reference '{@link scrm.SCRMDiagram#getGmfdiagram <em>Gmfdiagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gmfdiagram</em>'.
	 * @see scrm.SCRMDiagram#getGmfdiagram()
	 * @see #getSCRMDiagram()
	 * @generated
	 */
	EReference getSCRMDiagram_Gmfdiagram();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScrmFactory getScrmFactory();

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
		 * The meta object literal for the '{@link scrm.impl.SCRMModelElementImpl <em>SCRM Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.impl.SCRMModelElementImpl
		 * @see scrm.impl.ScrmPackageImpl#getSCRMModelElement()
		 * @generated
		 */
		EClass SCRM_MODEL_ELEMENT = eINSTANCE.getSCRMModelElement();

		/**
		 * The meta object literal for the '<em><b>Displaying Diagrams</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS = eINSTANCE
				.getSCRMModelElement_DisplayingDiagrams();

		/**
		 * The meta object literal for the '{@link scrm.impl.SCRMDiagramImpl <em>SCRM Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.impl.SCRMDiagramImpl
		 * @see scrm.impl.ScrmPackageImpl#getSCRMDiagram()
		 * @generated
		 */
		EClass SCRM_DIAGRAM = eINSTANCE.getSCRMDiagram();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRM_DIAGRAM__ELEMENTS = eINSTANCE.getSCRMDiagram_Elements();

		/**
		 * The meta object literal for the '<em><b>New Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRM_DIAGRAM__NEW_ELEMENTS = eINSTANCE
				.getSCRMDiagram_NewElements();

		/**
		 * The meta object literal for the '<em><b>Diagram Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRM_DIAGRAM__DIAGRAM_LAYOUT = eINSTANCE
				.getSCRMDiagram_DiagramLayout();

		/**
		 * The meta object literal for the '<em><b>Diagram Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRM_DIAGRAM__DIAGRAM_TYPE = eINSTANCE
				.getSCRMDiagram_DiagramType();

		/**
		 * The meta object literal for the '{@link scrm.DiagramType <em>Diagram Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.DiagramType
		 * @see scrm.impl.ScrmPackageImpl#getDiagramType()
		 * @generated
		 */
		EEnum DIAGRAM_TYPE = eINSTANCE.getDiagramType();

		/**
		 * The meta object literal for the '<em><b>Gmfdiagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRM_DIAGRAM__GMFDIAGRAM = eINSTANCE
				.getSCRMDiagram_Gmfdiagram();

	}

} //ScrmPackage
