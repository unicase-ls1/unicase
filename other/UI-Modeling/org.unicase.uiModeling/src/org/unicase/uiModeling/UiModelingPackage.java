/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.unicase.uiModeling.UiModelingFactory
 * @model kind="package"
 * @generated
 */
public interface UiModelingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uiModeling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/uiModeling";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.uiModeling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	UiModelingPackage eINSTANCE = org.unicase.uiModeling.impl.UiModelingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.StoryboardImpl <em>Storyboard</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.StoryboardImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getStoryboard()
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
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.PanelImpl <em>Panel</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.PanelImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getPanel()
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
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__WIDTH = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__HEIGHT = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__WIDGETS = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Positioning Enabled</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PANEL__POSITIONING_ENABLED = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Sizing Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__SIZING_ENABLED = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Layout Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL__LAYOUT_ENABLED = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Panel</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_FEATURE_COUNT = DiagramPackage.ME_DIAGRAM_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.WidgetImpl <em>Widget</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.WidgetImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getWidget()
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
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__X = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__Y = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__WIDTH = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__HEIGHT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__TEXT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__PANEL = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.WindowImpl <em>Window</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.WindowImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getWindow()
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
	 * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__WIDGETS = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Window</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.LabelImpl <em>Label</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.LabelImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getLabel()
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
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.TextFieldImpl <em>Text Field</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.TextFieldImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getTextField()
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
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.ButtonImpl <em>Button</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.ButtonImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getButton()
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
	 * The number of structural features of the '<em>Button</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.TextImpl <em>Text</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.TextImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getText()
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
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.ImageImpl <em>Image</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.ImageImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getImage()
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
	 * The feature id for the '<em><b>Image Url</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__IMAGE_URL = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.RadioGroupImpl <em>Radio Group</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.RadioGroupImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getRadioGroup()
	 * @generated
	 */
	int RADIO_GROUP = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__PANEL = WIDGET__PANEL;

	/**
	 * The feature id for the '<em><b>Buttons</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__BUTTONS = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selected Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__SELECTED_ITEM = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Radio Group</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.RadioButtonImpl <em>Radio Button</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.uiModeling.impl.RadioButtonImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getRadioButton()
	 * @generated
	 */
	int RADIO_BUTTON = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__TEXT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON__GROUP = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Radio Button</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RADIO_BUTTON_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.CheckboxGroupImpl <em>Checkbox Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.uiModeling.impl.CheckboxGroupImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getCheckboxGroup()
	 * @generated
	 */
	int CHECKBOX_GROUP = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__PANEL = WIDGET__PANEL;

	/**
	 * The feature id for the '<em><b>Boxes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP__BOXES = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Checkbox Group</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_GROUP_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.CheckboxImpl <em>Checkbox</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.uiModeling.impl.CheckboxImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getCheckbox()
	 * @generated
	 */
	int CHECKBOX = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__GROUP = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__TEXT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__CHECKED = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Checkbox</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.DropdownListImpl <em>Dropdown List</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.uiModeling.impl.DropdownListImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getDropdownList()
	 * @generated
	 */
	int DROPDOWN_LIST = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__PANEL = WIDGET__PANEL;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__ITEMS = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selected Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST__SELECTED_ITEM = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dropdown List</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_LIST_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.DropdownItemImpl <em>Dropdown Item</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.uiModeling.impl.DropdownItemImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getDropdownItem()
	 * @generated
	 */
	int DROPDOWN_ITEM = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>List</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__LIST = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM__TEXT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dropdown Item</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROPDOWN_ITEM_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.uiModeling.impl.ImageButtonImpl <em>Image Button</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.uiModeling.impl.ImageButtonImpl
	 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getImageButton()
	 * @generated
	 */
	int IMAGE_BUTTON = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__DESCRIPTION = WIDGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__ANNOTATIONS = WIDGET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__ATTACHMENTS = WIDGET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__INCOMING_DOCUMENT_REFERENCES = WIDGET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__STATE = WIDGET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__APPLIED_STEREOTYPE_INSTANCES = WIDGET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__COMMENTS = WIDGET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__CREATION_DATE = WIDGET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__CREATOR = WIDGET__CREATOR;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__X = WIDGET__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__Y = WIDGET__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__WIDTH = WIDGET__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__HEIGHT = WIDGET__HEIGHT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__TEXT = WIDGET__TEXT;

	/**
	 * The feature id for the '<em><b>Panel</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__PANEL = WIDGET__PANEL;

	/**
	 * The feature id for the '<em><b>Image Url</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON__IMAGE_URL = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image Button</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_BUTTON_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.Storyboard <em>Storyboard</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Storyboard</em>'.
	 * @see org.unicase.uiModeling.Storyboard
	 * @generated
	 */
	EClass getStoryboard();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.uiModeling.Storyboard#getPanels <em>Panels</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Panels</em>'.
	 * @see org.unicase.uiModeling.Storyboard#getPanels()
	 * @see #getStoryboard()
	 * @generated
	 */
	EReference getStoryboard_Panels();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.Panel <em>Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Panel</em>'.
	 * @see org.unicase.uiModeling.Panel
	 * @generated
	 */
	EClass getPanel();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.uiModeling.Panel#getStoryboard <em>Storyboard</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Storyboard</em>'.
	 * @see org.unicase.uiModeling.Panel#getStoryboard()
	 * @see #getPanel()
	 * @generated
	 */
	EReference getPanel_Storyboard();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Panel#getX <em>X</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.unicase.uiModeling.Panel#getX()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_X();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Panel#getY <em>Y</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.unicase.uiModeling.Panel#getY()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Panel#getWidth <em>Width</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.unicase.uiModeling.Panel#getWidth()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Panel#getHeight <em>Height</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.unicase.uiModeling.Panel#getHeight()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_Height();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.uiModeling.Panel#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widgets</em>'.
	 * @see org.unicase.uiModeling.Panel#getWidgets()
	 * @see #getPanel()
	 * @generated
	 */
	EReference getPanel_Widgets();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Panel#isPositioningEnabled <em>Positioning Enabled</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Positioning Enabled</em>'.
	 * @see org.unicase.uiModeling.Panel#isPositioningEnabled()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_PositioningEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Panel#isSizingEnabled <em>Sizing Enabled</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sizing Enabled</em>'.
	 * @see org.unicase.uiModeling.Panel#isSizingEnabled()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_SizingEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Panel#isLayoutEnabled <em>Layout Enabled</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout Enabled</em>'.
	 * @see org.unicase.uiModeling.Panel#isLayoutEnabled()
	 * @see #getPanel()
	 * @generated
	 */
	EAttribute getPanel_LayoutEnabled();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see org.unicase.uiModeling.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Widget#getX <em>X</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.unicase.uiModeling.Widget#getX()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_X();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Widget#getY <em>Y</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.unicase.uiModeling.Widget#getY()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Widget#getWidth <em>Width</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.unicase.uiModeling.Widget#getWidth()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Widget#getHeight <em>Height</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.unicase.uiModeling.Widget#getHeight()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Widget#getText <em>Text</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.unicase.uiModeling.Widget#getText()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Text();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.uiModeling.Widget#getPanel <em>Panel</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Panel</em>'.
	 * @see org.unicase.uiModeling.Widget#getPanel()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_Panel();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.Window <em>Window</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Window</em>'.
	 * @see org.unicase.uiModeling.Window
	 * @generated
	 */
	EClass getWindow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.uiModeling.Window#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widgets</em>'.
	 * @see org.unicase.uiModeling.Window#getWidgets()
	 * @see #getWindow()
	 * @generated
	 */
	EReference getWindow_Widgets();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see org.unicase.uiModeling.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.TextField <em>Text Field</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Text Field</em>'.
	 * @see org.unicase.uiModeling.TextField
	 * @generated
	 */
	EClass getTextField();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.Button <em>Button</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Button</em>'.
	 * @see org.unicase.uiModeling.Button
	 * @generated
	 */
	EClass getButton();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see org.unicase.uiModeling.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.unicase.uiModeling.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Image#getImageUrl <em>Image Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Url</em>'.
	 * @see org.unicase.uiModeling.Image#getImageUrl()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_ImageUrl();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.RadioGroup <em>Radio Group</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Radio Group</em>'.
	 * @see org.unicase.uiModeling.RadioGroup
	 * @generated
	 */
	EClass getRadioGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.uiModeling.RadioGroup#getButtons <em>Buttons</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buttons</em>'.
	 * @see org.unicase.uiModeling.RadioGroup#getButtons()
	 * @see #getRadioGroup()
	 * @generated
	 */
	EReference getRadioGroup_Buttons();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.uiModeling.RadioGroup#getSelectedItem <em>Selected Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Selected Item</em>'.
	 * @see org.unicase.uiModeling.RadioGroup#getSelectedItem()
	 * @see #getRadioGroup()
	 * @generated
	 */
	EReference getRadioGroup_SelectedItem();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.RadioButton <em>Radio Button</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Radio Button</em>'.
	 * @see org.unicase.uiModeling.RadioButton
	 * @generated
	 */
	EClass getRadioButton();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.RadioButton#getText <em>Text</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.unicase.uiModeling.RadioButton#getText()
	 * @see #getRadioButton()
	 * @generated
	 */
	EAttribute getRadioButton_Text();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.uiModeling.RadioButton#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Group</em>'.
	 * @see org.unicase.uiModeling.RadioButton#getGroup()
	 * @see #getRadioButton()
	 * @generated
	 */
	EReference getRadioButton_Group();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.CheckboxGroup <em>Checkbox Group</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Checkbox Group</em>'.
	 * @see org.unicase.uiModeling.CheckboxGroup
	 * @generated
	 */
	EClass getCheckboxGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.uiModeling.CheckboxGroup#getBoxes <em>Boxes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boxes</em>'.
	 * @see org.unicase.uiModeling.CheckboxGroup#getBoxes()
	 * @see #getCheckboxGroup()
	 * @generated
	 */
	EReference getCheckboxGroup_Boxes();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.Checkbox <em>Checkbox</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Checkbox</em>'.
	 * @see org.unicase.uiModeling.Checkbox
	 * @generated
	 */
	EClass getCheckbox();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.uiModeling.Checkbox#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Group</em>'.
	 * @see org.unicase.uiModeling.Checkbox#getGroup()
	 * @see #getCheckbox()
	 * @generated
	 */
	EReference getCheckbox_Group();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Checkbox#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.unicase.uiModeling.Checkbox#getText()
	 * @see #getCheckbox()
	 * @generated
	 */
	EAttribute getCheckbox_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.Checkbox#isChecked <em>Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checked</em>'.
	 * @see org.unicase.uiModeling.Checkbox#isChecked()
	 * @see #getCheckbox()
	 * @generated
	 */
	EAttribute getCheckbox_Checked();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.DropdownList <em>Dropdown List</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Dropdown List</em>'.
	 * @see org.unicase.uiModeling.DropdownList
	 * @generated
	 */
	EClass getDropdownList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.uiModeling.DropdownList#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.unicase.uiModeling.DropdownList#getItems()
	 * @see #getDropdownList()
	 * @generated
	 */
	EReference getDropdownList_Items();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.uiModeling.DropdownList#getSelectedItem <em>Selected Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Selected Item</em>'.
	 * @see org.unicase.uiModeling.DropdownList#getSelectedItem()
	 * @see #getDropdownList()
	 * @generated
	 */
	EReference getDropdownList_SelectedItem();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.DropdownItem <em>Dropdown Item</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Dropdown Item</em>'.
	 * @see org.unicase.uiModeling.DropdownItem
	 * @generated
	 */
	EClass getDropdownItem();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.uiModeling.DropdownItem#getList <em>List</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>List</em>'.
	 * @see org.unicase.uiModeling.DropdownItem#getList()
	 * @see #getDropdownItem()
	 * @generated
	 */
	EReference getDropdownItem_List();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.DropdownItem#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.unicase.uiModeling.DropdownItem#getText()
	 * @see #getDropdownItem()
	 * @generated
	 */
	EAttribute getDropdownItem_Text();

	/**
	 * Returns the meta object for class '{@link org.unicase.uiModeling.ImageButton <em>Image Button</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Image Button</em>'.
	 * @see org.unicase.uiModeling.ImageButton
	 * @generated
	 */
	EClass getImageButton();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.uiModeling.ImageButton#getImageUrl <em>Image Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Url</em>'.
	 * @see org.unicase.uiModeling.ImageButton#getImageUrl()
	 * @see #getImageButton()
	 * @generated
	 */
	EAttribute getImageButton_ImageUrl();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UiModelingFactory getUiModelingFactory();

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
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.StoryboardImpl <em>Storyboard</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.uiModeling.impl.StoryboardImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getStoryboard()
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
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.PanelImpl <em>Panel</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.uiModeling.impl.PanelImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getPanel()
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
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__WIDTH = eINSTANCE.getPanel_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__HEIGHT = eINSTANCE.getPanel_Height();

		/**
		 * The meta object literal for the '<em><b>Widgets</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PANEL__WIDGETS = eINSTANCE.getPanel_Widgets();

		/**
		 * The meta object literal for the '<em><b>Positioning Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__POSITIONING_ENABLED = eINSTANCE.getPanel_PositioningEnabled();

		/**
		 * The meta object literal for the '<em><b>Sizing Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__SIZING_ENABLED = eINSTANCE.getPanel_SizingEnabled();

		/**
		 * The meta object literal for the '<em><b>Layout Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANEL__LAYOUT_ENABLED = eINSTANCE.getPanel_LayoutEnabled();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.WidgetImpl <em>Widget</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.uiModeling.impl.WidgetImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

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
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.WindowImpl <em>Window</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.uiModeling.impl.WindowImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getWindow()
		 * @generated
		 */
		EClass WINDOW = eINSTANCE.getWindow();

		/**
		 * The meta object literal for the '<em><b>Widgets</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WINDOW__WIDGETS = eINSTANCE.getWindow_Widgets();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.LabelImpl <em>Label</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.uiModeling.impl.LabelImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.TextFieldImpl <em>Text Field</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.uiModeling.impl.TextFieldImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getTextField()
		 * @generated
		 */
		EClass TEXT_FIELD = eINSTANCE.getTextField();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.ButtonImpl <em>Button</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.uiModeling.impl.ButtonImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getButton()
		 * @generated
		 */
		EClass BUTTON = eINSTANCE.getButton();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.TextImpl <em>Text</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.uiModeling.impl.TextImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.ImageImpl <em>Image</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.uiModeling.impl.ImageImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Image Url</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__IMAGE_URL = eINSTANCE.getImage_ImageUrl();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.RadioGroupImpl <em>Radio Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.uiModeling.impl.RadioGroupImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getRadioGroup()
		 * @generated
		 */
		EClass RADIO_GROUP = eINSTANCE.getRadioGroup();

		/**
		 * The meta object literal for the '<em><b>Buttons</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RADIO_GROUP__BUTTONS = eINSTANCE.getRadioGroup_Buttons();

		/**
		 * The meta object literal for the '<em><b>Selected Item</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RADIO_GROUP__SELECTED_ITEM = eINSTANCE.getRadioGroup_SelectedItem();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.RadioButtonImpl <em>Radio Button</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.uiModeling.impl.RadioButtonImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getRadioButton()
		 * @generated
		 */
		EClass RADIO_BUTTON = eINSTANCE.getRadioButton();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute RADIO_BUTTON__TEXT = eINSTANCE.getRadioButton_Text();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RADIO_BUTTON__GROUP = eINSTANCE.getRadioButton_Group();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.CheckboxGroupImpl <em>Checkbox Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.uiModeling.impl.CheckboxGroupImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getCheckboxGroup()
		 * @generated
		 */
		EClass CHECKBOX_GROUP = eINSTANCE.getCheckboxGroup();

		/**
		 * The meta object literal for the '<em><b>Boxes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CHECKBOX_GROUP__BOXES = eINSTANCE.getCheckboxGroup_Boxes();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.CheckboxImpl <em>Checkbox</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.uiModeling.impl.CheckboxImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getCheckbox()
		 * @generated
		 */
		EClass CHECKBOX = eINSTANCE.getCheckbox();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKBOX__GROUP = eINSTANCE.getCheckbox_Group();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKBOX__TEXT = eINSTANCE.getCheckbox_Text();

		/**
		 * The meta object literal for the '<em><b>Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKBOX__CHECKED = eINSTANCE.getCheckbox_Checked();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.DropdownListImpl <em>Dropdown List</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.uiModeling.impl.DropdownListImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getDropdownList()
		 * @generated
		 */
		EClass DROPDOWN_LIST = eINSTANCE.getDropdownList();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DROPDOWN_LIST__ITEMS = eINSTANCE.getDropdownList_Items();

		/**
		 * The meta object literal for the '<em><b>Selected Item</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DROPDOWN_LIST__SELECTED_ITEM = eINSTANCE.getDropdownList_SelectedItem();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.DropdownItemImpl <em>Dropdown Item</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.uiModeling.impl.DropdownItemImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getDropdownItem()
		 * @generated
		 */
		EClass DROPDOWN_ITEM = eINSTANCE.getDropdownItem();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DROPDOWN_ITEM__LIST = eINSTANCE.getDropdownItem_List();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DROPDOWN_ITEM__TEXT = eINSTANCE.getDropdownItem_Text();

		/**
		 * The meta object literal for the '{@link org.unicase.uiModeling.impl.ImageButtonImpl <em>Image Button</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.uiModeling.impl.ImageButtonImpl
		 * @see org.unicase.uiModeling.impl.UiModelingPackageImpl#getImageButton()
		 * @generated
		 */
		EClass IMAGE_BUTTON = eINSTANCE.getImageButton();

		/**
		 * The meta object literal for the '<em><b>Image Url</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_BUTTON__IMAGE_URL = eINSTANCE.getImageButton_ImageUrl();

	}

} // UiModelingPackage
