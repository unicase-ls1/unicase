/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.notation.NotationPackage;
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
 * @see org.unicase.model.diagram.DiagramFactory
 * @model kind="package"
 *        annotation="http://www.cs.tum.edu/cope historyURI='../../org.unicase.model/model/model.history'"
 * @generated
 */
public interface DiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/diagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.diagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DiagramPackage eINSTANCE = org.unicase.model.diagram.impl.DiagramPackageImpl
			.init();

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__NAME = ModelPackage.ATTACHMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES = ModelPackage.ATTACHMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__LEAF_SECTION = ModelPackage.ATTACHMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__COMMENTS = ModelPackage.ATTACHMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__CREATION_DATE = ModelPackage.ATTACHMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__CREATOR = ModelPackage.ATTACHMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__REFERRING_MODEL_ELEMENTS = ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__ELEMENTS = ModelPackage.ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__GMFDIAGRAM = ModelPackage.ATTACHMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__NEW_ELEMENTS = ModelPackage.ATTACHMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__DIAGRAM_LAYOUT = ModelPackage.ATTACHMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>ME Diagram</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM_FEATURE_COUNT = ModelPackage.ATTACHMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.diagram.impl.ClassDiagramImpl
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getClassDiagram()
	 * @generated
	 */
	int CLASS_DIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__NAME = ME_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__DESCRIPTION = ME_DIAGRAM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__ANNOTATIONS = ME_DIAGRAM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__ATTACHMENTS = ME_DIAGRAM__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__INCOMING_DOCUMENT_REFERENCES = ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__LEAF_SECTION = ME_DIAGRAM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__STATE = ME_DIAGRAM__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES = ME_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__COMMENTS = ME_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__CREATION_DATE = ME_DIAGRAM__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__CREATOR = ME_DIAGRAM__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__REFERRING_MODEL_ELEMENTS = ME_DIAGRAM__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__ELEMENTS = ME_DIAGRAM__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__GMFDIAGRAM = ME_DIAGRAM__GMFDIAGRAM;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__NEW_ELEMENTS = ME_DIAGRAM__NEW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__DIAGRAM_LAYOUT = ME_DIAGRAM__DIAGRAM_LAYOUT;

	/**
	 * The number of structural features of the '<em>Class Diagram</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM_FEATURE_COUNT = ME_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.impl.UseCaseDiagramImpl <em>Use Case Diagram</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.diagram.impl.UseCaseDiagramImpl
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getUseCaseDiagram()
	 * @generated
	 */
	int USE_CASE_DIAGRAM = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__NAME = ME_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__DESCRIPTION = ME_DIAGRAM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__ANNOTATIONS = ME_DIAGRAM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__ATTACHMENTS = ME_DIAGRAM__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__INCOMING_DOCUMENT_REFERENCES = ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__LEAF_SECTION = ME_DIAGRAM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__STATE = ME_DIAGRAM__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES = ME_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__COMMENTS = ME_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__CREATION_DATE = ME_DIAGRAM__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__CREATOR = ME_DIAGRAM__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__REFERRING_MODEL_ELEMENTS = ME_DIAGRAM__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__ELEMENTS = ME_DIAGRAM__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__GMFDIAGRAM = ME_DIAGRAM__GMFDIAGRAM;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__NEW_ELEMENTS = ME_DIAGRAM__NEW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM__DIAGRAM_LAYOUT = ME_DIAGRAM__DIAGRAM_LAYOUT;

	/**
	 * The number of structural features of the '<em>Use Case Diagram</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_DIAGRAM_FEATURE_COUNT = ME_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.impl.ComponentDiagramImpl <em>Component Diagram</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.diagram.impl.ComponentDiagramImpl
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getComponentDiagram()
	 * @generated
	 */
	int COMPONENT_DIAGRAM = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__NAME = ME_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__DESCRIPTION = ME_DIAGRAM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__ANNOTATIONS = ME_DIAGRAM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__ATTACHMENTS = ME_DIAGRAM__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__INCOMING_DOCUMENT_REFERENCES = ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__LEAF_SECTION = ME_DIAGRAM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__STATE = ME_DIAGRAM__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES = ME_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__COMMENTS = ME_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__CREATION_DATE = ME_DIAGRAM__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__CREATOR = ME_DIAGRAM__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__REFERRING_MODEL_ELEMENTS = ME_DIAGRAM__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__ELEMENTS = ME_DIAGRAM__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__GMFDIAGRAM = ME_DIAGRAM__GMFDIAGRAM;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__NEW_ELEMENTS = ME_DIAGRAM__NEW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM__DIAGRAM_LAYOUT = ME_DIAGRAM__DIAGRAM_LAYOUT;

	/**
	 * The number of structural features of the '<em>Component Diagram</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_DIAGRAM_FEATURE_COUNT = ME_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.impl.StateDiagramImpl <em>State Diagram</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.diagram.impl.StateDiagramImpl
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getStateDiagram()
	 * @generated
	 */
	int STATE_DIAGRAM = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__NAME = ME_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__DESCRIPTION = ME_DIAGRAM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__ANNOTATIONS = ME_DIAGRAM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__ATTACHMENTS = ME_DIAGRAM__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__INCOMING_DOCUMENT_REFERENCES = ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__LEAF_SECTION = ME_DIAGRAM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__STATE = ME_DIAGRAM__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES = ME_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__COMMENTS = ME_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__CREATION_DATE = ME_DIAGRAM__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__CREATOR = ME_DIAGRAM__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__REFERRING_MODEL_ELEMENTS = ME_DIAGRAM__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__ELEMENTS = ME_DIAGRAM__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__GMFDIAGRAM = ME_DIAGRAM__GMFDIAGRAM;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__NEW_ELEMENTS = ME_DIAGRAM__NEW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM__DIAGRAM_LAYOUT = ME_DIAGRAM__DIAGRAM_LAYOUT;

	/**
	 * The number of structural features of the '<em>State Diagram</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DIAGRAM_FEATURE_COUNT = ME_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.impl.ActivityDiagramImpl <em>Activity Diagram</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.diagram.impl.ActivityDiagramImpl
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getActivityDiagram()
	 * @generated
	 */
	int ACTIVITY_DIAGRAM = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__NAME = ME_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__DESCRIPTION = ME_DIAGRAM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__ANNOTATIONS = ME_DIAGRAM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__ATTACHMENTS = ME_DIAGRAM__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__INCOMING_DOCUMENT_REFERENCES = ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__LEAF_SECTION = ME_DIAGRAM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__STATE = ME_DIAGRAM__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES = ME_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__COMMENTS = ME_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__CREATION_DATE = ME_DIAGRAM__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__CREATOR = ME_DIAGRAM__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__REFERRING_MODEL_ELEMENTS = ME_DIAGRAM__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__ELEMENTS = ME_DIAGRAM__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__GMFDIAGRAM = ME_DIAGRAM__GMFDIAGRAM;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__NEW_ELEMENTS = ME_DIAGRAM__NEW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM__DIAGRAM_LAYOUT = ME_DIAGRAM__DIAGRAM_LAYOUT;

	/**
	 * The number of structural features of the '<em>Activity Diagram</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM_FEATURE_COUNT = ME_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.impl.WorkItemDiagramImpl <em>Work Item Diagram</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.diagram.impl.WorkItemDiagramImpl
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getWorkItemDiagram()
	 * @generated
	 */
	int WORK_ITEM_DIAGRAM = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__NAME = ME_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__DESCRIPTION = ME_DIAGRAM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__ANNOTATIONS = ME_DIAGRAM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__ATTACHMENTS = ME_DIAGRAM__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__INCOMING_DOCUMENT_REFERENCES = ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__LEAF_SECTION = ME_DIAGRAM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__STATE = ME_DIAGRAM__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES = ME_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__COMMENTS = ME_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__CREATION_DATE = ME_DIAGRAM__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__CREATOR = ME_DIAGRAM__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__REFERRING_MODEL_ELEMENTS = ME_DIAGRAM__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__ELEMENTS = ME_DIAGRAM__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__GMFDIAGRAM = ME_DIAGRAM__GMFDIAGRAM;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__NEW_ELEMENTS = ME_DIAGRAM__NEW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM__DIAGRAM_LAYOUT = ME_DIAGRAM__DIAGRAM_LAYOUT;

	/**
	 * The number of structural features of the '<em>Work Item Diagram</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_ITEM_DIAGRAM_FEATURE_COUNT = ME_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.impl.MERelativeBendpointsImpl <em>ME Relative Bendpoints</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.diagram.impl.MERelativeBendpointsImpl
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getMERelativeBendpoints()
	 * @generated
	 */
	int ME_RELATIVE_BENDPOINTS = 7;

	/**
	 * The feature id for the '<em><b>Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_RELATIVE_BENDPOINTS__POINTS = NotationPackage.RELATIVE_BENDPOINTS__POINTS;

	/**
	 * The number of structural features of the '<em>ME Relative Bendpoints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_RELATIVE_BENDPOINTS_FEATURE_COUNT = NotationPackage.RELATIVE_BENDPOINTS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>ME Relative Bendpoint</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.diagram.impl.MERelativeBendpoint
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getMERelativeBendpoint()
	 * @generated
	 */
	int ME_RELATIVE_BENDPOINT = 8;

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
	 * Returns the meta object for the reference list '{@link org.unicase.model.diagram.MEDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getElements()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EReference getMEDiagram_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.model.diagram.MEDiagram#getGmfdiagram <em>Gmfdiagram</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gmfdiagram</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getGmfdiagram()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EReference getMEDiagram_Gmfdiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.diagram.MEDiagram#getNewElements <em>New Elements</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>New Elements</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getNewElements()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EReference getMEDiagram_NewElements();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.diagram.MEDiagram#getDiagramLayout <em>Diagram Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Layout</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getDiagramLayout()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EAttribute getMEDiagram_DiagramLayout();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.diagram.ClassDiagram <em>Class Diagram</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Class Diagram</em>'.
	 * @see org.unicase.model.diagram.ClassDiagram
	 * @generated
	 */
	EClass getClassDiagram();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.diagram.UseCaseDiagram <em>Use Case Diagram</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Diagram</em>'.
	 * @see org.unicase.model.diagram.UseCaseDiagram
	 * @generated
	 */
	EClass getUseCaseDiagram();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.diagram.ComponentDiagram <em>Component Diagram</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Diagram</em>'.
	 * @see org.unicase.model.diagram.ComponentDiagram
	 * @generated
	 */
	EClass getComponentDiagram();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.diagram.StateDiagram <em>State Diagram</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>State Diagram</em>'.
	 * @see org.unicase.model.diagram.StateDiagram
	 * @generated
	 */
	EClass getStateDiagram();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.diagram.ActivityDiagram <em>Activity Diagram</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Diagram</em>'.
	 * @see org.unicase.model.diagram.ActivityDiagram
	 * @generated
	 */
	EClass getActivityDiagram();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.diagram.WorkItemDiagram <em>Work Item Diagram</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Work Item Diagram</em>'.
	 * @see org.unicase.model.diagram.WorkItemDiagram
	 * @generated
	 */
	EClass getWorkItemDiagram();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.diagram.MERelativeBendpoints <em>ME Relative Bendpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ME Relative Bendpoints</em>'.
	 * @see org.unicase.model.diagram.MERelativeBendpoints
	 * @generated
	 */
	EClass getMERelativeBendpoints();

	/**
	 * Returns the meta object for data type '{@link org.unicase.model.diagram.impl.MERelativeBendpoint <em>ME Relative Bendpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ME Relative Bendpoint</em>'.
	 * @see org.unicase.model.diagram.impl.MERelativeBendpoint
	 * @model instanceClass="org.unicase.model.diagram.impl.MERelativeBendpoint"
	 * @generated
	 */
	EDataType getMERelativeBendpoint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.MEDiagramImpl <em>ME Diagram</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.MEDiagramImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getMEDiagram()
		 * @generated
		 */
		EClass ME_DIAGRAM = eINSTANCE.getMEDiagram();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
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
		EReference ME_DIAGRAM__NEW_ELEMENTS = eINSTANCE
				.getMEDiagram_NewElements();

		/**
		 * The meta object literal for the '<em><b>Diagram Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ME_DIAGRAM__DIAGRAM_LAYOUT = eINSTANCE
				.getMEDiagram_DiagramLayout();

		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.ClassDiagramImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getClassDiagram()
		 * @generated
		 */
		EClass CLASS_DIAGRAM = eINSTANCE.getClassDiagram();

		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.UseCaseDiagramImpl <em>Use Case Diagram</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.UseCaseDiagramImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getUseCaseDiagram()
		 * @generated
		 */
		EClass USE_CASE_DIAGRAM = eINSTANCE.getUseCaseDiagram();

		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.ComponentDiagramImpl <em>Component Diagram</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.ComponentDiagramImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getComponentDiagram()
		 * @generated
		 */
		EClass COMPONENT_DIAGRAM = eINSTANCE.getComponentDiagram();

		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.StateDiagramImpl <em>State Diagram</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.StateDiagramImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getStateDiagram()
		 * @generated
		 */
		EClass STATE_DIAGRAM = eINSTANCE.getStateDiagram();

		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.ActivityDiagramImpl <em>Activity Diagram</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.ActivityDiagramImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getActivityDiagram()
		 * @generated
		 */
		EClass ACTIVITY_DIAGRAM = eINSTANCE.getActivityDiagram();

		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.WorkItemDiagramImpl <em>Work Item Diagram</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.WorkItemDiagramImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getWorkItemDiagram()
		 * @generated
		 */
		EClass WORK_ITEM_DIAGRAM = eINSTANCE.getWorkItemDiagram();

		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.MERelativeBendpointsImpl <em>ME Relative Bendpoints</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.MERelativeBendpointsImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getMERelativeBendpoints()
		 * @generated
		 */
		EClass ME_RELATIVE_BENDPOINTS = eINSTANCE.getMERelativeBendpoints();

		/**
		 * The meta object literal for the '<em>ME Relative Bendpoint</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.MERelativeBendpoint
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getMERelativeBendpoint()
		 * @generated
		 */
		EDataType ME_RELATIVE_BENDPOINT = eINSTANCE.getMERelativeBendpoint();

	}

} // DiagramPackage
