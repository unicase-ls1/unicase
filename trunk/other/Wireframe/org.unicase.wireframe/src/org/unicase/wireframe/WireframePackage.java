/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.DiagramPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.wireframe.WireframeFactory
 * @model kind="package"
 * @generated
 */
public interface WireframePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wireframe";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/wireframe";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.wireframe";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	WireframePackage eINSTANCE = org.unicase.wireframe.impl.WireframePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.impl.StoryboardImpl <em>Storyboard</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.wireframe.impl.StoryboardImpl
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getStoryboard()
	 * @generated
	 */
	int STORYBOARD = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__NAME = DiagramPackage.ME_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__DESCRIPTION = DiagramPackage.ME_DIAGRAM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__ANNOTATIONS = DiagramPackage.ME_DIAGRAM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__ATTACHMENTS = DiagramPackage.ME_DIAGRAM__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__INCOMING_DOCUMENT_REFERENCES = DiagramPackage.ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__STATE = DiagramPackage.ME_DIAGRAM__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__APPLIED_STEREOTYPE_INSTANCES = DiagramPackage.ME_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__COMMENTS = DiagramPackage.ME_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__CREATION_DATE = DiagramPackage.ME_DIAGRAM__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__CREATOR = DiagramPackage.ME_DIAGRAM__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__REFERRING_MODEL_ELEMENTS = DiagramPackage.ME_DIAGRAM__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__ELEMENTS = DiagramPackage.ME_DIAGRAM__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__GMFDIAGRAM = DiagramPackage.ME_DIAGRAM__GMFDIAGRAM;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__NEW_ELEMENTS = DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__DIAGRAM_LAYOUT = DiagramPackage.ME_DIAGRAM__DIAGRAM_LAYOUT;

	/**
	 * The feature id for the '<em><b>Panels</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORYBOARD__PANELS = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Storyboard</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STORYBOARD_FEATURE_COUNT = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.impl.PanelImpl <em>Panel</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.wireframe.impl.PanelImpl
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getPanel()
	 * @generated
	 */
	int PANEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__NAME = DiagramPackage.ME_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__DESCRIPTION = DiagramPackage.ME_DIAGRAM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PANEL__ANNOTATIONS = DiagramPackage.ME_DIAGRAM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PANEL__ATTACHMENTS = DiagramPackage.ME_DIAGRAM__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__INCOMING_DOCUMENT_REFERENCES = DiagramPackage.ME_DIAGRAM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__STATE = DiagramPackage.ME_DIAGRAM__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PANEL__APPLIED_STEREOTYPE_INSTANCES = DiagramPackage.ME_DIAGRAM__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__COMMENTS = DiagramPackage.ME_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__CREATION_DATE = DiagramPackage.ME_DIAGRAM__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__CREATOR = DiagramPackage.ME_DIAGRAM__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__REFERRING_MODEL_ELEMENTS = DiagramPackage.ME_DIAGRAM__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__ELEMENTS = DiagramPackage.ME_DIAGRAM__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__GMFDIAGRAM = DiagramPackage.ME_DIAGRAM__GMFDIAGRAM;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__NEW_ELEMENTS = DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__DIAGRAM_LAYOUT = DiagramPackage.ME_DIAGRAM__DIAGRAM_LAYOUT;

	/**
	 * The feature id for the '<em><b>Storyboard</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__STORYBOARD = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__X = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__Y = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__WIDGETS = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Panel</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_FEATURE_COUNT = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.impl.WidgetImpl <em>Widget</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.wireframe.impl.WidgetImpl
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WIDGET__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WIDGET__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WIDGET__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__ID = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__X = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__Y = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__WIDTH = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__HEIGHT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__TEXT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__PANEL = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.impl.WindowImpl <em>Window</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.wireframe.impl.WindowImpl
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getWindow()
	 * @generated
	 */
	int WINDOW = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOW__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOW__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOW__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__PANEL = WIDGET__PANEL;

	/**
	 * The feature id for the '<em><b>Has Close</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__HAS_CLOSE = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Maximize</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__HAS_MAXIMIZE = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Minimize</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__HAS_MINIMIZE = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Window</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.impl.LabelImpl <em>Label</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.wireframe.impl.LabelImpl
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LABEL__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LABEL__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LABEL__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__PANEL = WIDGET__PANEL;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.impl.TextFieldImpl <em>Text Field</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.wireframe.impl.TextFieldImpl
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getTextField()
	 * @generated
	 */
	int TEXT_FIELD = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD__PANEL = WIDGET__PANEL;

	/**
	 * The number of structural features of the '<em>Text Field</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_FIELD_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.impl.ButtonImpl <em>Button</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.wireframe.impl.ButtonImpl
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getButton()
	 * @generated
	 */
	int BUTTON = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUTTON__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUTTON__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUTTON__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__PANEL = WIDGET__PANEL;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__STYLE = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Button</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see org.unicase.wireframe.impl.TextImpl
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getText()
	 * @generated
	 */
	int TEXT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__PANEL = WIDGET__PANEL;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.impl.ImageImpl <em>Image</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.wireframe.impl.ImageImpl
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__PANEL = WIDGET__PANEL;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__URI = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.wireframe.ButtonStyle <em>Button Style</em>}' enum. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.wireframe.ButtonStyle
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getButtonStyle()
	 * @generated
	 */
	int BUTTON_STYLE = 9;

	/**
	 * The meta object id for the '<em>Image URI</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.unicase.wireframe.impl.WireframePackageImpl#getImageURI()
	 * @generated
	 */
	int IMAGE_URI = 10;

	/**
	 * Returns the meta object for class '{@link org.unicase.wireframe.Storyboard <em>Storyboard</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Storyboard</em>'.
	 * @see org.unicase.wireframe.Storyboard
	 * @generated
	 */
	EClass getStoryboard();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.wireframe.Storyboard#getPanels <em>Panels</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Panels</em>'.
	 * @see org.unicase.wireframe.Storyboard#getPanels()
	 * @see #getStoryboard()
	 * @generated
	 */
	EReference getStoryboard_Panels();

	/**
	 * Returns the meta object for class '{@link org.unicase.wireframe.Panel <em>Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Panel</em>'.
	 * @see org.unicase.wireframe.Panel
	 * @generated
	 */
	EClass getPanel();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.wireframe.Panel#getStoryboard <em>Storyboard</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Storyboard</em>'.
	 * @see org.unicase.wireframe.Panel#getStoryboard()
	 * @see #getPanel()
	 * @generated
	 */
	EReference getPanel_Storyboard();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Panel#getX <em>X</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.unicase.wireframe.Panel#getX()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_X();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Panel#getY <em>Y</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.unicase.wireframe.Panel#getY()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_Y();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.wireframe.Panel#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widgets</em>'.
	 * @see org.unicase.wireframe.Panel#getWidgets()
	 * @see #getPanel()
	 * @generated
	 */
	EReference getPanel_Widgets();

	/**
	 * Returns the meta object for class '{@link org.unicase.wireframe.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see org.unicase.wireframe.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Widget#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.unicase.wireframe.Widget#getId()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Widget#getX <em>X</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.unicase.wireframe.Widget#getX()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_X();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Widget#getY <em>Y</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.unicase.wireframe.Widget#getY()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Widget#getWidth <em>Width</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.unicase.wireframe.Widget#getWidth()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Widget#getHeight <em>Height</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.unicase.wireframe.Widget#getHeight()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Widget#getText <em>Text</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.unicase.wireframe.Widget#getText()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Text();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.wireframe.Widget#getPanel <em>Panel</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Panel</em>'.
	 * @see org.unicase.wireframe.Widget#getPanel()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_Panel();

	/**
	 * Returns the meta object for class '{@link org.unicase.wireframe.Window <em>Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Window</em>'.
	 * @see org.unicase.wireframe.Window
	 * @generated
	 */
	EClass getWindow();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Window#isHasClose <em>Has Close</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Close</em>'.
	 * @see org.unicase.wireframe.Window#isHasClose()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_HasClose();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Window#isHasMaximize <em>Has Maximize</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Maximize</em>'.
	 * @see org.unicase.wireframe.Window#isHasMaximize()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_HasMaximize();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Window#isHasMinimize <em>Has Minimize</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Minimize</em>'.
	 * @see org.unicase.wireframe.Window#isHasMinimize()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_HasMinimize();

	/**
	 * Returns the meta object for class '{@link org.unicase.wireframe.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see org.unicase.wireframe.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for class '{@link org.unicase.wireframe.TextField <em>Text Field</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Text Field</em>'.
	 * @see org.unicase.wireframe.TextField
	 * @generated
	 */
	EClass getTextField();

	/**
	 * Returns the meta object for class '{@link org.unicase.wireframe.Button <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Button</em>'.
	 * @see org.unicase.wireframe.Button
	 * @generated
	 */
	EClass getButton();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Button#getStyle <em>Style</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see org.unicase.wireframe.Button#getStyle()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Style();

	/**
	 * Returns the meta object for class '{@link org.unicase.wireframe.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see org.unicase.wireframe.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for class '{@link org.unicase.wireframe.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.unicase.wireframe.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.wireframe.Image#getUri <em>Uri</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.unicase.wireframe.Image#getUri()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Uri();

	/**
	 * Returns the meta object for enum '{@link org.unicase.wireframe.ButtonStyle <em>Button Style</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Button Style</em>'.
	 * @see org.unicase.wireframe.ButtonStyle
	 * @generated
	 */
	EEnum getButtonStyle();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>Image URI</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Image URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getImageURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WireframeFactory getWireframeFactory();

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
		 * The meta object literal for the '{@link org.unicase.wireframe.impl.StoryboardImpl <em>Storyboard</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.wireframe.impl.StoryboardImpl
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getStoryboard()
		 * @generated
		 */
		EClass STORYBOARD = eINSTANCE.getStoryboard();

		/**
		 * The meta object literal for the '<em><b>Panels</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STORYBOARD__PANELS = eINSTANCE.getStoryboard_Panels();

		/**
		 * The meta object literal for the '{@link org.unicase.wireframe.impl.PanelImpl <em>Panel</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.wireframe.impl.PanelImpl
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getPanel()
		 * @generated
		 */
		EClass PANEL = eINSTANCE.getPanel();

		/**
		 * The meta object literal for the '<em><b>Storyboard</b></em>' container reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PANEL__STORYBOARD = eINSTANCE.getPanel_Storyboard();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__X = eINSTANCE.getPanel_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__Y = eINSTANCE.getPanel_Y();

		/**
		 * The meta object literal for the '<em><b>Widgets</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PANEL__WIDGETS = eINSTANCE.getPanel_Widgets();

		/**
		 * The meta object literal for the '{@link org.unicase.wireframe.impl.WidgetImpl <em>Widget</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.wireframe.impl.WidgetImpl
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__ID = eINSTANCE.getWidget_Id();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__X = eINSTANCE.getWidget_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__Y = eINSTANCE.getWidget_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__WIDTH = eINSTANCE.getWidget_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__HEIGHT = eINSTANCE.getWidget_Height();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__TEXT = eINSTANCE.getWidget_Text();

		/**
		 * The meta object literal for the '<em><b>Panel</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__PANEL = eINSTANCE.getWidget_Panel();

		/**
		 * The meta object literal for the '{@link org.unicase.wireframe.impl.WindowImpl <em>Window</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.wireframe.impl.WindowImpl
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getWindow()
		 * @generated
		 */
		EClass WINDOW = eINSTANCE.getWindow();

		/**
		 * The meta object literal for the '<em><b>Has Close</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__HAS_CLOSE = eINSTANCE.getWindow_HasClose();

		/**
		 * The meta object literal for the '<em><b>Has Maximize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__HAS_MAXIMIZE = eINSTANCE.getWindow_HasMaximize();

		/**
		 * The meta object literal for the '<em><b>Has Minimize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__HAS_MINIMIZE = eINSTANCE.getWindow_HasMinimize();

		/**
		 * The meta object literal for the '{@link org.unicase.wireframe.impl.LabelImpl <em>Label</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.wireframe.impl.LabelImpl
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '{@link org.unicase.wireframe.impl.TextFieldImpl <em>Text Field</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.wireframe.impl.TextFieldImpl
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getTextField()
		 * @generated
		 */
		EClass TEXT_FIELD = eINSTANCE.getTextField();

		/**
		 * The meta object literal for the '{@link org.unicase.wireframe.impl.ButtonImpl <em>Button</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.wireframe.impl.ButtonImpl
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getButton()
		 * @generated
		 */
		EClass BUTTON = eINSTANCE.getButton();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__STYLE = eINSTANCE.getButton_Style();

		/**
		 * The meta object literal for the '{@link org.unicase.wireframe.impl.TextImpl <em>Text</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.wireframe.impl.TextImpl
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '{@link org.unicase.wireframe.impl.ImageImpl <em>Image</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.wireframe.impl.ImageImpl
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__URI = eINSTANCE.getImage_Uri();

		/**
		 * The meta object literal for the '{@link org.unicase.wireframe.ButtonStyle <em>Button Style</em>}' enum. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.wireframe.ButtonStyle
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getButtonStyle()
		 * @generated
		 */
		EEnum BUTTON_STYLE = eINSTANCE.getButtonStyle();

		/**
		 * The meta object literal for the '<em>Image URI</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.unicase.wireframe.impl.WireframePackageImpl#getImageURI()
		 * @generated
		 */
		EDataType IMAGE_URI = eINSTANCE.getImageURI();

	}

} // WireframePackage
