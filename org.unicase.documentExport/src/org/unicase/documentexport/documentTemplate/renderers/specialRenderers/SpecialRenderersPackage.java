/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.specialRenderers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.unicase.documentexport.documentTemplate.renderers.RenderersPackage;

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
 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.SpecialRenderersFactory
 * @model kind="package"
 * @generated
 */
public interface SpecialRenderersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "specialRenderers";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/documentExport/documentTemplate/renderers/specialRenderers";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.documentExport.documentTemplate.renderers.specialRenderers";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpecialRenderersPackage eINSTANCE = org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.SpecialRenderersPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.MeetingRendererImpl <em>Meeting Renderer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.MeetingRendererImpl
	 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMeetingRenderer()
	 * @generated
	 */
	int MEETING_RENDERER = 0;

	/**
	 * The feature id for the '<em><b>Renderer Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING_RENDERER__RENDERER_OPTIONS = RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING_RENDERER__TEMPLATE = RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE;

	/**
	 * The number of structural features of the '<em>Meeting Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEETING_RENDERER_FEATURE_COUNT = RenderersPackage.MODEL_ELEMENT_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.MilestoneRendererImpl <em>Milestone Renderer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.MilestoneRendererImpl
	 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMilestoneRenderer()
	 * @generated
	 */
	int MILESTONE_RENDERER = 1;

	/**
	 * The feature id for the '<em><b>Renderer Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE_RENDERER__RENDERER_OPTIONS = RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE_RENDERER__TEMPLATE = RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE;

	/**
	 * The number of structural features of the '<em>Milestone Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE_RENDERER_FEATURE_COUNT = RenderersPackage.MODEL_ELEMENT_RENDERER_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.unicase.documentexport.documentTemplate.renderers.specialRenderers.MeetingRenderer <em>Meeting Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meeting Renderer</em>'.
	 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.MeetingRenderer
	 * @generated
	 */
	EClass getMeetingRenderer();

	/**
	 * Returns the meta object for class '{@link org.unicase.documentexport.documentTemplate.renderers.specialRenderers.MilestoneRenderer <em>Milestone Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Milestone Renderer</em>'.
	 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.MilestoneRenderer
	 * @generated
	 */
	EClass getMilestoneRenderer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpecialRenderersFactory getSpecialRenderersFactory();

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
		 * The meta object literal for the '{@link org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.MeetingRendererImpl <em>Meeting Renderer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.MeetingRendererImpl
		 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMeetingRenderer()
		 * @generated
		 */
		EClass MEETING_RENDERER = eINSTANCE.getMeetingRenderer();

		/**
		 * The meta object literal for the '{@link org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.MilestoneRendererImpl <em>Milestone Renderer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.MilestoneRendererImpl
		 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.SpecialRenderersPackageImpl#getMilestoneRenderer()
		 * @generated
		 */
		EClass MILESTONE_RENDERER = eINSTANCE.getMilestoneRenderer();

	}

} //SpecialRenderersPackage
