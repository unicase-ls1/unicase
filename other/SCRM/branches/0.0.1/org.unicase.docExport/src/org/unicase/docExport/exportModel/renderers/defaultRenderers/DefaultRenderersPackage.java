/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers;

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
 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory
 * @model kind="package"
 * @generated
 */
public interface DefaultRenderersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "defaultRenderers";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/docExport/exportModel/renderers/defaultRenderers";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.docExport.exportModel.renderers.defaultRenderers";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DefaultRenderersPackage eINSTANCE = org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultModelElementRendererImpl <em>Default Model Element Renderer</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultModelElementRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl#getDefaultModelElementRenderer()
	 * @generated
	 */
	int DEFAULT_MODEL_ELEMENT_RENDERER = 0;

	/**
	 * The feature id for the '<em><b>Renderer Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS = RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_MODEL_ELEMENT_RENDERER__TEMPLATE = RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFAULT_MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING = RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING;

	/**
	 * The number of structural features of the '<em>Default Model Element Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_MODEL_ELEMENT_RENDERER_FEATURE_COUNT = RenderersPackage.MODEL_ELEMENT_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultAttributeRendererImpl <em>Default Attribute Renderer</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultAttributeRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl#getDefaultAttributeRenderer()
	 * @generated
	 */
	int DEFAULT_ATTRIBUTE_RENDERER = 1;

	/**
	 * The feature id for the '<em><b>Attribute Option</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION = RenderersPackage.ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION;

	/**
	 * The number of structural features of the '<em>Default Attribute Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ATTRIBUTE_RENDERER_FEATURE_COUNT = RenderersPackage.ATTRIBUTE_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultDocumentRendererImpl <em>Default Document Renderer</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultDocumentRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl#getDefaultDocumentRenderer()
	 * @generated
	 */
	int DEFAULT_DOCUMENT_RENDERER = 2;

	/**
	 * The number of structural features of the '<em>Default Document Renderer</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_DOCUMENT_RENDERER_FEATURE_COUNT = RenderersPackage.DOCUMENT_RENDERER_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer <em>Default Model Element Renderer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Model Element Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer
	 * @generated
	 */
	EClass getDefaultModelElementRenderer();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultAttributeRenderer <em>Default Attribute Renderer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Attribute Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultAttributeRenderer
	 * @generated
	 */
	EClass getDefaultAttributeRenderer();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultDocumentRenderer <em>Default Document Renderer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Document Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultDocumentRenderer
	 * @generated
	 */
	EClass getDefaultDocumentRenderer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DefaultRenderersFactory getDefaultRenderersFactory();

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
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultModelElementRendererImpl <em>Default Model Element Renderer</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultModelElementRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl#getDefaultModelElementRenderer()
		 * @generated
		 */
		EClass DEFAULT_MODEL_ELEMENT_RENDERER = eINSTANCE.getDefaultModelElementRenderer();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultAttributeRendererImpl <em>Default Attribute Renderer</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultAttributeRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl#getDefaultAttributeRenderer()
		 * @generated
		 */
		EClass DEFAULT_ATTRIBUTE_RENDERER = eINSTANCE.getDefaultAttributeRenderer();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultDocumentRendererImpl <em>Default Document Renderer</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultDocumentRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl#getDefaultDocumentRenderer()
		 * @generated
		 */
		EClass DEFAULT_DOCUMENT_RENDERER = eINSTANCE.getDefaultDocumentRenderer();

	}

} // DefaultRenderersPackage
