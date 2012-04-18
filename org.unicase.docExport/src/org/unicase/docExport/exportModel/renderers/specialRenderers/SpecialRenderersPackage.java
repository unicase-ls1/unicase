/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;

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
 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory
 * @model kind="package"
 * @generated
 */
public interface SpecialRenderersPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "specialRenderers";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/docExport/exportModel/renderers/specialRenderers";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.docExport.exportModel.renderers.specialRenderers";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	SpecialRenderersPackage eINSTANCE = org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl
		.init();

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MeetingRendererImpl
	 * <em>Meeting Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MeetingRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMeetingRenderer()
	 * @generated
	 */
	int MEETING_RENDERER = 0;

	/**
	 * The feature id for the '<em><b>Renderer Options</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEETING_RENDERER__RENDERER_OPTIONS = RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEETING_RENDERER__TEMPLATE = RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEETING_RENDERER__ATTRIBUTE_RENDERER_MAPPING = RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING;

	/**
	 * The number of structural features of the '<em>Meeting Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEETING_RENDERER_FEATURE_COUNT = RenderersPackage.MODEL_ELEMENT_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MilestoneRendererImpl
	 * <em>Milestone Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MilestoneRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMilestoneRenderer()
	 * @generated
	 */
	int MILESTONE_RENDERER = 1;

	/**
	 * The feature id for the '<em><b>Renderer Options</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MILESTONE_RENDERER__RENDERER_OPTIONS = RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MILESTONE_RENDERER__TEMPLATE = RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MILESTONE_RENDERER__ATTRIBUTE_RENDERER_MAPPING = RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING;

	/**
	 * The number of structural features of the '<em>Milestone Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MILESTONE_RENDERER_FEATURE_COUNT = RenderersPackage.MODEL_ELEMENT_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.StepsAttributeRendererImpl
	 * <em>Steps Attribute Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.StepsAttributeRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getStepsAttributeRenderer()
	 * @generated
	 */
	int STEPS_ATTRIBUTE_RENDERER = 2;

	/**
	 * The feature id for the '<em><b>Attribute Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEPS_ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION = RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION;

	/**
	 * The number of structural features of the '<em>Steps Attribute Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEPS_ATTRIBUTE_RENDERER_FEATURE_COUNT = RenderersPackage.ATTRIBUTE_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MethodRendererImpl
	 * <em>Method Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MethodRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMethodRenderer()
	 * @generated
	 */
	int METHOD_RENDERER = 3;

	/**
	 * The feature id for the '<em><b>Attribute Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int METHOD_RENDERER__ATTRIBUTE_OPTION = RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION;

	/**
	 * The number of structural features of the '<em>Method Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int METHOD_RENDERER_FEATURE_COUNT = RenderersPackage.ATTRIBUTE_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.PackageFlatRendererImpl
	 * <em>Package Flat Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.PackageFlatRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getPackageFlatRenderer()
	 * @generated
	 */
	int PACKAGE_FLAT_RENDERER = 4;

	/**
	 * The feature id for the '<em><b>Renderer Options</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FLAT_RENDERER__RENDERER_OPTIONS = RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FLAT_RENDERER__TEMPLATE = RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FLAT_RENDERER__ATTRIBUTE_RENDERER_MAPPING = RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING;

	/**
	 * The number of structural features of the '<em>Package Flat Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FLAT_RENDERER_FEATURE_COUNT = RenderersPackage.MODEL_ELEMENT_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.ClassRendererImpl
	 * <em>Class Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.ClassRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getClassRenderer()
	 * @generated
	 */
	int CLASS_RENDERER = 5;

	/**
	 * The feature id for the '<em><b>Renderer Options</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_RENDERER__RENDERER_OPTIONS = RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_RENDERER__TEMPLATE = RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_RENDERER__ATTRIBUTE_RENDERER_MAPPING = RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING;

	/**
	 * The number of structural features of the '<em>Class Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_RENDERER_FEATURE_COUNT = RenderersPackage.MODEL_ELEMENT_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.ClassAttributesRendererImpl
	 * <em>Class Attributes Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.ClassAttributesRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getClassAttributesRenderer()
	 * @generated
	 */
	int CLASS_ATTRIBUTES_RENDERER = 6;

	/**
	 * The feature id for the '<em><b>Attribute Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTES_RENDERER__ATTRIBUTE_OPTION = RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION;

	/**
	 * The number of structural features of the '<em>Class Attributes Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASS_ATTRIBUTES_RENDERER_FEATURE_COUNT = RenderersPackage.ATTRIBUTE_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.FhmMeetingRendererImpl
	 * <em>Fhm Meeting Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.FhmMeetingRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getFhmMeetingRenderer()
	 * @generated
	 */
	int FHM_MEETING_RENDERER = 7;

	/**
	 * The feature id for the '<em><b>Renderer Options</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FHM_MEETING_RENDERER__RENDERER_OPTIONS = MEETING_RENDERER__RENDERER_OPTIONS;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FHM_MEETING_RENDERER__TEMPLATE = MEETING_RENDERER__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FHM_MEETING_RENDERER__ATTRIBUTE_RENDERER_MAPPING = MEETING_RENDERER__ATTRIBUTE_RENDERER_MAPPING;

	/**
	 * The number of structural features of the '<em>Fhm Meeting Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FHM_MEETING_RENDERER_FEATURE_COUNT = MEETING_RENDERER_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer <em>Meeting Renderer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Meeting Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer
	 * @generated
	 */
	EClass getMeetingRenderer();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer
	 * <em>Milestone Renderer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Milestone Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer
	 * @generated
	 */
	EClass getMilestoneRenderer();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer
	 * <em>Steps Attribute Renderer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Steps Attribute Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer
	 * @generated
	 */
	EClass getStepsAttributeRenderer();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer <em>Method Renderer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Method Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer
	 * @generated
	 */
	EClass getMethodRenderer();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer
	 * <em>Package Flat Renderer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Package Flat Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer
	 * @generated
	 */
	EClass getPackageFlatRenderer();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer <em>Class Renderer</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Class Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer
	 * @generated
	 */
	EClass getClassRenderer();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.ClassAttributesRenderer
	 * <em>Class Attributes Renderer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Class Attributes Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.ClassAttributesRenderer
	 * @generated
	 */
	EClass getClassAttributesRenderer();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.FhmMeetingRenderer
	 * <em>Fhm Meeting Renderer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Fhm Meeting Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.FhmMeetingRenderer
	 * @generated
	 */
	EClass getFhmMeetingRenderer();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpecialRenderersFactory getSpecialRenderersFactory();

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
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MeetingRendererImpl
		 * <em>Meeting Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MeetingRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMeetingRenderer()
		 * @generated
		 */
		EClass MEETING_RENDERER = eINSTANCE.getMeetingRenderer();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MilestoneRendererImpl
		 * <em>Milestone Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MilestoneRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMilestoneRenderer()
		 * @generated
		 */
		EClass MILESTONE_RENDERER = eINSTANCE.getMilestoneRenderer();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.StepsAttributeRendererImpl
		 * <em>Steps Attribute Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.StepsAttributeRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getStepsAttributeRenderer()
		 * @generated
		 */
		EClass STEPS_ATTRIBUTE_RENDERER = eINSTANCE.getStepsAttributeRenderer();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MethodRendererImpl
		 * <em>Method Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.MethodRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMethodRenderer()
		 * @generated
		 */
		EClass METHOD_RENDERER = eINSTANCE.getMethodRenderer();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.PackageFlatRendererImpl
		 * <em>Package Flat Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.PackageFlatRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getPackageFlatRenderer()
		 * @generated
		 */
		EClass PACKAGE_FLAT_RENDERER = eINSTANCE.getPackageFlatRenderer();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.ClassRendererImpl
		 * <em>Class Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.ClassRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getClassRenderer()
		 * @generated
		 */
		EClass CLASS_RENDERER = eINSTANCE.getClassRenderer();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.ClassAttributesRendererImpl
		 * <em>Class Attributes Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.ClassAttributesRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getClassAttributesRenderer()
		 * @generated
		 */
		EClass CLASS_ATTRIBUTES_RENDERER = eINSTANCE.getClassAttributesRenderer();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.impl.FhmMeetingRendererImpl
		 * <em>Fhm Meeting Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.FhmMeetingRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getFhmMeetingRenderer()
		 * @generated
		 */
		EClass FHM_MEETING_RENDERER = eINSTANCE.getFhmMeetingRenderer();

	}

} // SpecialRenderersPackage
