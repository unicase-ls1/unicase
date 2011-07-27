/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.papyrus;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.uml2.uml.UMLPackage;

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
 * @see org.unicase.papyrus.PapyrusFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrusPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "papyrus";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/papyrus";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.papyrus";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrusPackage eINSTANCE = org.unicase.papyrus.impl.PapyrusPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.papyrus.impl.UMLModelImpl <em>UML Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.papyrus.impl.UMLModelImpl
	 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getUMLModel()
	 * @generated
	 */
	int UML_MODEL = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__EANNOTATIONS = UMLPackage.MODEL__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_ELEMENT = UMLPackage.MODEL__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNER = UMLPackage.MODEL__OWNER;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_COMMENT = UMLPackage.MODEL__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NAME = UMLPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__VISIBILITY = UMLPackage.MODEL__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__QUALIFIED_NAME = UMLPackage.MODEL__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__CLIENT_DEPENDENCY = UMLPackage.MODEL__CLIENT_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NAMESPACE = UMLPackage.MODEL__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NAME_EXPRESSION = UMLPackage.MODEL__NAME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Element Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__ELEMENT_IMPORT = UMLPackage.MODEL__ELEMENT_IMPORT;

	/**
	 * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PACKAGE_IMPORT = UMLPackage.MODEL__PACKAGE_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_RULE = UMLPackage.MODEL__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__MEMBER = UMLPackage.MODEL__MEMBER;

	/**
	 * The feature id for the '<em><b>Imported Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__IMPORTED_MEMBER = UMLPackage.MODEL__IMPORTED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owned Member</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_MEMBER = UMLPackage.MODEL__OWNED_MEMBER;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNING_TEMPLATE_PARAMETER = UMLPackage.MODEL__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__TEMPLATE_PARAMETER = UMLPackage.MODEL__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__TEMPLATE_BINDING = UMLPackage.MODEL__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_TEMPLATE_SIGNATURE = UMLPackage.MODEL__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__OWNED_TYPE = UMLPackage.MODEL__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Package Merge</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PACKAGE_MERGE = UMLPackage.MODEL__PACKAGE_MERGE;

	/**
	 * The feature id for the '<em><b>Packaged Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PACKAGED_ELEMENT = UMLPackage.MODEL__PACKAGED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NESTED_PACKAGE = UMLPackage.MODEL__NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NESTING_PACKAGE = UMLPackage.MODEL__NESTING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Profile Application</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PROFILE_APPLICATION = UMLPackage.MODEL__PROFILE_APPLICATION;

	/**
	 * The feature id for the '<em><b>Viewpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__VIEWPOINT = UMLPackage.MODEL__VIEWPOINT;

	/**
	 * The feature id for the '<em><b>Gmf Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__GMF_DIAGRAM = UMLPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Diagram Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__DIAGRAM_TYPE = UMLPackage.MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__DIAGRAM_LAYOUT = UMLPackage.MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>UML Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL_FEATURE_COUNT = UMLPackage.MODEL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.papyrus.UMLDiagramType <em>UML Diagram Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.papyrus.UMLDiagramType
	 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getUMLDiagramType()
	 * @generated
	 */
	int UML_DIAGRAM_TYPE = 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.papyrus.UMLModel <em>UML Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Model</em>'.
	 * @see org.unicase.papyrus.UMLModel
	 * @generated
	 */
	EClass getUMLModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.papyrus.UMLModel#getGmfDiagram <em>Gmf Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gmf Diagram</em>'.
	 * @see org.unicase.papyrus.UMLModel#getGmfDiagram()
	 * @see #getUMLModel()
	 * @generated
	 */
	EReference getUMLModel_GmfDiagram();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.papyrus.UMLModel#getDiagramType <em>Diagram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Type</em>'.
	 * @see org.unicase.papyrus.UMLModel#getDiagramType()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_DiagramType();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.papyrus.UMLModel#getDiagramLayout <em>Diagram Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Layout</em>'.
	 * @see org.unicase.papyrus.UMLModel#getDiagramLayout()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_DiagramLayout();

	/**
	 * Returns the meta object for enum '{@link org.unicase.papyrus.UMLDiagramType <em>UML Diagram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>UML Diagram Type</em>'.
	 * @see org.unicase.papyrus.UMLDiagramType
	 * @generated
	 */
	EEnum getUMLDiagramType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrusFactory getPapyrusFactory();

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
		 * The meta object literal for the '{@link org.unicase.papyrus.impl.UMLModelImpl <em>UML Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.papyrus.impl.UMLModelImpl
		 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getUMLModel()
		 * @generated
		 */
		EClass UML_MODEL = eINSTANCE.getUMLModel();

		/**
		 * The meta object literal for the '<em><b>Gmf Diagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_MODEL__GMF_DIAGRAM = eINSTANCE.getUMLModel_GmfDiagram();

		/**
		 * The meta object literal for the '<em><b>Diagram Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_MODEL__DIAGRAM_TYPE = eINSTANCE
				.getUMLModel_DiagramType();

		/**
		 * The meta object literal for the '<em><b>Diagram Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_MODEL__DIAGRAM_LAYOUT = eINSTANCE
				.getUMLModel_DiagramLayout();

		/**
		 * The meta object literal for the '{@link org.unicase.papyrus.UMLDiagramType <em>UML Diagram Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.papyrus.UMLDiagramType
		 * @see org.unicase.papyrus.impl.PapyrusPackageImpl#getUMLDiagramType()
		 * @generated
		 */
		EEnum UML_DIAGRAM_TYPE = eINSTANCE.getUMLDiagramType();

	}

} //PapyrusPackage
