/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.unicase.docExport.exportModel.renderers.RenderersFactory
 * @model kind="package"
 * @generated
 */
public interface RenderersPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "renderers";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/docExport/exportModel/renderers";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.docExport.exportModel.renderers";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	RenderersPackage eINSTANCE = org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl
	 * <em>Model Element Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getModelElementRenderer()
	 * @generated
	 */
	int MODEL_ELEMENT_RENDERER = 0;

	/**
	 * The feature id for the '<em><b>Renderer Options</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS = 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_RENDERER__TEMPLATE = 1;

	/**
	 * The feature id for the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING = 2;

	/**
	 * The number of structural features of the '<em>Model Element Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_RENDERER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl
	 * <em>Attribute Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getAttributeRenderer()
	 * @generated
	 */
	int ATTRIBUTE_RENDERER = 1;

	/**
	 * The feature id for the '<em><b>Attribute Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION = 0;

	/**
	 * The number of structural features of the '<em>Attribute Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_RENDERER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.impl.DocumentRendererImpl
	 * <em>Document Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.impl.DocumentRendererImpl
	 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getDocumentRenderer()
	 * @generated
	 */
	int DOCUMENT_RENDERER = 2;

	/**
	 * The number of structural features of the '<em>Document Renderer</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_RENDERER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererMappingImpl
	 * <em>Model Element Renderer Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererMappingImpl
	 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getModelElementRendererMapping()
	 * @generated
	 */
	int MODEL_ELEMENT_RENDERER_MAPPING = 3;

	/**
	 * The feature id for the '<em><b>Renderer</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_RENDERER_MAPPING__RENDERER = 0;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_RENDERER_MAPPING__ECLASS_NAME = 1;

	/**
	 * The number of structural features of the '<em>Model Element Renderer Mapping</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_RENDERER_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.impl.AttributeRendererMappingImpl
	 * <em>Attribute Renderer Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.impl.AttributeRendererMappingImpl
	 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getAttributeRendererMapping()
	 * @generated
	 */
	int ATTRIBUTE_RENDERER_MAPPING = 4;

	/**
	 * The feature id for the '<em><b>Attribute Renderer</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER = 0;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_RENDERER_MAPPING__FEATURE_NAME = 1;

	/**
	 * The number of structural features of the '<em>Attribute Renderer Mapping</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_RENDERER_MAPPING_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer
	 * <em>Model Element Renderer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Element Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer
	 * @generated
	 */
	EClass getModelElementRenderer();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getRendererOptions
	 * <em>Renderer Options</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Renderer Options</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getRendererOptions()
	 * @see #getModelElementRenderer()
	 * @generated
	 */
	EReference getModelElementRenderer_RendererOptions();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getTemplate <em>Template</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Template</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getTemplate()
	 * @see #getModelElementRenderer()
	 * @generated
	 */
	EReference getModelElementRenderer_Template();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getAttributeRendererMapping
	 * <em>Attribute Renderer Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Attribute Renderer Mapping</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getAttributeRendererMapping()
	 * @see #getModelElementRenderer()
	 * @generated
	 */
	EReference getModelElementRenderer_AttributeRendererMapping();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.AttributeRenderer
	 * <em>Attribute Renderer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.AttributeRenderer
	 * @generated
	 */
	EClass getAttributeRenderer();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.AttributeRenderer#getAttributeOption
	 * <em>Attribute Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.AttributeRenderer#getAttributeOption()
	 * @see #getAttributeRenderer()
	 * @generated
	 */
	EReference getAttributeRenderer_AttributeOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.DocumentRenderer
	 * <em>Document Renderer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Document Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.DocumentRenderer
	 * @generated
	 */
	EClass getDocumentRenderer();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping
	 * <em>Model Element Renderer Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Element Renderer Mapping</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping
	 * @generated
	 */
	EClass getModelElementRendererMapping();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping#getRenderer <em>Renderer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping#getRenderer()
	 * @see #getModelElementRendererMapping()
	 * @generated
	 */
	EReference getModelElementRendererMapping_Renderer();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping#getEClassName
	 * <em>EClass Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>EClass Name</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping#getEClassName()
	 * @see #getModelElementRendererMapping()
	 * @generated
	 */
	EAttribute getModelElementRendererMapping_EClassName();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping
	 * <em>Attribute Renderer Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Renderer Mapping</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.AttributeRendererMapping
	 * @generated
	 */
	EClass getAttributeRendererMapping();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping#getAttributeRenderer
	 * <em>Attribute Renderer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Attribute Renderer</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.AttributeRendererMapping#getAttributeRenderer()
	 * @see #getAttributeRendererMapping()
	 * @generated
	 */
	EReference getAttributeRendererMapping_AttributeRenderer();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping#getFeatureName <em>Feature Name</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.AttributeRendererMapping#getFeatureName()
	 * @see #getAttributeRendererMapping()
	 * @generated
	 */
	EAttribute getAttributeRendererMapping_FeatureName();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RenderersFactory getRenderersFactory();

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
		 * {@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl
		 * <em>Model Element Renderer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getModelElementRenderer()
		 * @generated
		 */
		EClass MODEL_ELEMENT_RENDERER = eINSTANCE.getModelElementRenderer();

		/**
		 * The meta object literal for the '<em><b>Renderer Options</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS = eINSTANCE.getModelElementRenderer_RendererOptions();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_ELEMENT_RENDERER__TEMPLATE = eINSTANCE.getModelElementRenderer_Template();

		/**
		 * The meta object literal for the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING = eINSTANCE
			.getModelElementRenderer_AttributeRendererMapping();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl <em>Attribute Renderer</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getAttributeRenderer()
		 * @generated
		 */
		EClass ATTRIBUTE_RENDERER = eINSTANCE.getAttributeRenderer();

		/**
		 * The meta object literal for the '<em><b>Attribute Option</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION = eINSTANCE.getAttributeRenderer_AttributeOption();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.impl.DocumentRendererImpl <em>Document Renderer</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.impl.DocumentRendererImpl
		 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getDocumentRenderer()
		 * @generated
		 */
		EClass DOCUMENT_RENDERER = eINSTANCE.getDocumentRenderer();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererMappingImpl
		 * <em>Model Element Renderer Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererMappingImpl
		 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getModelElementRendererMapping()
		 * @generated
		 */
		EClass MODEL_ELEMENT_RENDERER_MAPPING = eINSTANCE.getModelElementRendererMapping();

		/**
		 * The meta object literal for the '<em><b>Renderer</b></em>' containment reference feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_ELEMENT_RENDERER_MAPPING__RENDERER = eINSTANCE.getModelElementRendererMapping_Renderer();

		/**
		 * The meta object literal for the '<em><b>EClass Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_RENDERER_MAPPING__ECLASS_NAME = eINSTANCE.getModelElementRendererMapping_EClassName();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.impl.AttributeRendererMappingImpl
		 * <em>Attribute Renderer Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.impl.AttributeRendererMappingImpl
		 * @see org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl#getAttributeRendererMapping()
		 * @generated
		 */
		EClass ATTRIBUTE_RENDERER_MAPPING = eINSTANCE.getAttributeRendererMapping();

		/**
		 * The meta object literal for the '<em><b>Attribute Renderer</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER = eINSTANCE
			.getAttributeRendererMapping_AttributeRenderer();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_RENDERER_MAPPING__FEATURE_NAME = eINSTANCE.getAttributeRendererMapping_FeatureName();

	}

} // RenderersPackage
