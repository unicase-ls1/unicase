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
	int SCRM_MODEL_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>SCRM Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_MODEL_ELEMENT_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>Previous Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__PREVIOUS_DIAGRAM = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Next Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM__NEXT_DIAGRAM = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>SCRM Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_DIAGRAM_FEATURE_COUNT = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link scrm.SCRMSpace <em>SCRM Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.SCRMSpace
	 * @see scrm.impl.ScrmPackageImpl#getSCRMSpace()
	 * @generated
	 */
	int SCRM_SPACE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_SPACE__NAME = SCRM_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_SPACE__DESCRIPTION = SCRM_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Representing Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_SPACE__REPRESENTING_DIAGRAM = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SCRM Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRM_SPACE_FEATURE_COUNT = SCRM_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scrm.DiagramType <em>Diagram Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.DiagramType
	 * @see scrm.impl.ScrmPackageImpl#getDiagramType()
	 * @generated
	 */
	int DIAGRAM_TYPE = 3;

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
	 * Returns the meta object for the attribute '{@link scrm.SCRMModelElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see scrm.SCRMModelElement#getName()
	 * @see #getSCRMModelElement()
	 * @generated
	 */
	EAttribute getSCRMModelElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link scrm.SCRMModelElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see scrm.SCRMModelElement#getDescription()
	 * @see #getSCRMModelElement()
	 * @generated
	 */
	EAttribute getSCRMModelElement_Description();

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
	 * Returns the meta object for the reference '{@link scrm.SCRMDiagram#getPreviousDiagram <em>Previous Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Diagram</em>'.
	 * @see scrm.SCRMDiagram#getPreviousDiagram()
	 * @see #getSCRMDiagram()
	 * @generated
	 */
	EReference getSCRMDiagram_PreviousDiagram();

	/**
	 * Returns the meta object for the reference '{@link scrm.SCRMDiagram#getNextDiagram <em>Next Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Diagram</em>'.
	 * @see scrm.SCRMDiagram#getNextDiagram()
	 * @see #getSCRMDiagram()
	 * @generated
	 */
	EReference getSCRMDiagram_NextDiagram();

	/**
	 * Returns the meta object for class '{@link scrm.SCRMSpace <em>SCRM Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCRM Space</em>'.
	 * @see scrm.SCRMSpace
	 * @generated
	 */
	EClass getSCRMSpace();

	/**
	 * Returns the meta object for the reference '{@link scrm.SCRMSpace#getRepresentingDiagram <em>Representing Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Representing Diagram</em>'.
	 * @see scrm.SCRMSpace#getRepresentingDiagram()
	 * @see #getSCRMSpace()
	 * @generated
	 */
	EReference getSCRMSpace_RepresentingDiagram();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRM_MODEL_ELEMENT__NAME = eINSTANCE
				.getSCRMModelElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRM_MODEL_ELEMENT__DESCRIPTION = eINSTANCE
				.getSCRMModelElement_Description();

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
		 * The meta object literal for the '<em><b>Previous Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRM_DIAGRAM__PREVIOUS_DIAGRAM = eINSTANCE
				.getSCRMDiagram_PreviousDiagram();

		/**
		 * The meta object literal for the '<em><b>Next Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRM_DIAGRAM__NEXT_DIAGRAM = eINSTANCE
				.getSCRMDiagram_NextDiagram();

		/**
		 * The meta object literal for the '{@link scrm.SCRMSpace <em>SCRM Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.SCRMSpace
		 * @see scrm.impl.ScrmPackageImpl#getSCRMSpace()
		 * @generated
		 */
		EClass SCRM_SPACE = eINSTANCE.getSCRMSpace();

		/**
		 * The meta object literal for the '<em><b>Representing Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRM_SPACE__REPRESENTING_DIAGRAM = eINSTANCE
				.getSCRMSpace_RepresentingDiagram();

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
