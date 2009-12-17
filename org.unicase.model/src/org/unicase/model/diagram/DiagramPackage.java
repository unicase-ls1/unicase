/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.unicase.model.diagram.DiagramFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "diagram";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/diagram";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.diagram";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	DiagramPackage eINSTANCE = org.unicase.model.diagram.impl.DiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.impl.MEDiagramImpl <em>ME Diagram</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.diagram.impl.MEDiagramImpl
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getMEDiagram()
	 * @generated
	 */
	int ME_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__IDENTIFIER = ModelPackage.ATTACHMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__CREATOR = ModelPackage.ATTACHMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__CREATION_DATE = ModelPackage.ATTACHMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__NAME = ModelPackage.ATTACHMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__DESCRIPTION = ModelPackage.ATTACHMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__ANNOTATIONS = ModelPackage.ATTACHMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__ATTACHMENTS = ModelPackage.ATTACHMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES = ModelPackage.ATTACHMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__LEAF_SECTION = ModelPackage.ATTACHMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__STATE = ModelPackage.ATTACHMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.ATTACHMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__COMMENTS = ModelPackage.ATTACHMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__REFERRING_MODEL_ELEMENTS = ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__ELEMENTS = ModelPackage.ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__GMFDIAGRAM = ModelPackage.ATTACHMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__NEW_ELEMENTS = ModelPackage.ATTACHMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__TYPE = ModelPackage.ATTACHMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__DIAGRAM_LAYOUT = ModelPackage.ATTACHMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>ME Diagram</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM_FEATURE_COUNT = ModelPackage.ATTACHMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.DiagramType <em>Type</em>}' enum. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.model.diagram.DiagramType
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getDiagramType()
	 * @generated
	 */
	int DIAGRAM_TYPE = 1;

	/**
	 * Returns the meta object for class ' {@link org.unicase.model.diagram.MEDiagram <em>ME Diagram</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>ME Diagram</em>'.
	 * @see org.unicase.model.diagram.MEDiagram
	 * @generated
	 */
	EClass getMEDiagram();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.diagram.MEDiagram#getElements
	 * <em>Elements</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getElements()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EReference getMEDiagram_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.model.diagram.MEDiagram#getGmfdiagram
	 * <em>Gmfdiagram</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Gmfdiagram</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getGmfdiagram()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EReference getMEDiagram_Gmfdiagram();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.model.diagram.MEDiagram#getNewElements <em>New Elements</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>New Elements</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getNewElements()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EReference getMEDiagram_NewElements();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.diagram.MEDiagram#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getType()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EAttribute getMEDiagram_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.diagram.MEDiagram#getDiagramLayout
	 * <em>Diagram Layout</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Diagram Layout</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getDiagramLayout()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EAttribute getMEDiagram_DiagramLayout();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.diagram.DiagramType <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see org.unicase.model.diagram.DiagramType
	 * @generated
	 */
	EEnum getDiagramType();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramFactory getDiagramFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.MEDiagramImpl <em>ME Diagram</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.diagram.impl.MEDiagramImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getMEDiagram()
		 * @generated
		 */
		EClass ME_DIAGRAM = eINSTANCE.getMEDiagram();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ME_DIAGRAM__ELEMENTS = eINSTANCE.getMEDiagram_Elements();

		/**
		 * The meta object literal for the '<em><b>Gmfdiagram</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ME_DIAGRAM__GMFDIAGRAM = eINSTANCE.getMEDiagram_Gmfdiagram();

		/**
		 * The meta object literal for the '<em><b>New Elements</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ME_DIAGRAM__NEW_ELEMENTS = eINSTANCE.getMEDiagram_NewElements();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ME_DIAGRAM__TYPE = eINSTANCE.getMEDiagram_Type();

		/**
		 * The meta object literal for the '<em><b>Diagram Layout</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ME_DIAGRAM__DIAGRAM_LAYOUT = eINSTANCE.getMEDiagram_DiagramLayout();

		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.DiagramType <em>Type</em>}' enum. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.model.diagram.DiagramType
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getDiagramType()
		 * @generated
		 */
		EEnum DIAGRAM_TYPE = eINSTANCE.getDiagramType();

	}

} // DiagramPackage
