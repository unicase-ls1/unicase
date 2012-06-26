/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsFactory
 * @model kind="package"
 * @generated
 */
public interface OptionsPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "options";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/docExport/exportModel/renderers/options";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.docExport.exportModel.renderers.options";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	OptionsPackage eINSTANCE = org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.RendererOptionImpl
	 * <em>Renderer Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.RendererOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getRendererOption()
	 * @generated
	 */
	int RENDERER_OPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RENDERER_OPTION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Renderer Option</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RENDERER_OPTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl
	 * <em>Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getAttributeOption()
	 * @generated
	 */
	int ATTRIBUTE_OPTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION__HIDE = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attribute Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION__ATTRIBUTE_TEXT = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION__ORDER_NUMBER = RENDERER_OPTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Attribute Option</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl
	 * <em>Reference Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getReferenceAttributeOption()
	 * @generated
	 */
	int REFERENCE_ATTRIBUTE_OPTION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__NAME = ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__HIDE = ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Attribute Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__ATTRIBUTE_TEXT = ATTRIBUTE_OPTION__ATTRIBUTE_TEXT;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__ORDER_NUMBER = ATTRIBUTE_OPTION__ORDER_NUMBER;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__CONTAINED = ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION = ATTRIBUTE_OPTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Attribute Option</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT = ATTRIBUTE_OPTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl
	 * <em>Single Reference Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getSingleReferenceAttributeOption()
	 * @generated
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__NAME = REFERENCE_ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__HIDE = REFERENCE_ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Attribute Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__ATTRIBUTE_TEXT = REFERENCE_ATTRIBUTE_OPTION__ATTRIBUTE_TEXT;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__ORDER_NUMBER = REFERENCE_ATTRIBUTE_OPTION__ORDER_NUMBER;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__CONTAINED = REFERENCE_ATTRIBUTE_OPTION__CONTAINED;

	/**
	 * The feature id for the '<em><b>Reference Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION = REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION;

	/**
	 * The number of structural features of the '<em>Single Reference Attribute Option</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT = REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl
	 * <em>Multi Reference Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getMultiReferenceAttributeOption()
	 * @generated
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__NAME = REFERENCE_ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__HIDE = REFERENCE_ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Attribute Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__ATTRIBUTE_TEXT = REFERENCE_ATTRIBUTE_OPTION__ATTRIBUTE_TEXT;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__ORDER_NUMBER = REFERENCE_ATTRIBUTE_OPTION__ORDER_NUMBER;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__CONTAINED = REFERENCE_ATTRIBUTE_OPTION__CONTAINED;

	/**
	 * The feature id for the '<em><b>Reference Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION = REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION;

	/**
	 * The feature id for the '<em><b>List Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION = REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multi Reference Attribute Option</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT = REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceOptionImpl
	 * <em>Reference Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.ReferenceOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getReferenceOption()
	 * @generated
	 */
	int REFERENCE_OPTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The number of structural features of the '<em>Reference Option</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl
	 * <em>String Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getStringAttributeOption()
	 * @generated
	 */
	int STRING_ATTRIBUTE_OPTION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__NAME = ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__HIDE = ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Attribute Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__ATTRIBUTE_TEXT = ATTRIBUTE_OPTION__ATTRIBUTE_TEXT;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__ORDER_NUMBER = ATTRIBUTE_OPTION__ORDER_NUMBER;

	/**
	 * The number of structural features of the '<em>String Attribute Option</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION_FEATURE_COUNT = ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl
	 * <em>Layout Options</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getLayoutOptions()
	 * @generated
	 */
	int LAYOUT_OPTIONS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Header Text Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HEADER_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Text Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Section Text Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__SECTION_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hide Annotations</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_ANNOTATIONS = RENDERER_OPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hide Attachments</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_ATTACHMENTS = RENDERER_OPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Hide Incoming Document References</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES = RENDERER_OPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Hide Model Element Images</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES = RENDERER_OPTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Model Element Text Option</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Header Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HEADER_TEXT = RENDERER_OPTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Footer Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__FOOTER_TEXT = RENDERER_OPTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Section Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__SECTION_OPTION = RENDERER_OPTION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Section Font Size Decrease Step</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP = RENDERER_OPTION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Document Title Text Option</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Show Model Element Type In Section Title</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE = RENDERER_OPTION_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Appendix Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__APPENDIX_STYLE = RENDERER_OPTION_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Logo Image</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__LOGO_IMAGE = RENDERER_OPTION_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Footer Text Option</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__FOOTER_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Footer Show Document Title</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE = RENDERER_OPTION_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Page Citation Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__PAGE_CITATION_STYLE = RENDERER_OPTION_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Header Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HEADER_STYLE = RENDERER_OPTION_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Logo Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__LOGO_WIDTH = RENDERER_OPTION_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Logo Height</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__LOGO_HEIGHT = RENDERER_OPTION_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Logo On Cover Page</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE = RENDERER_OPTION_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Table Of Contents Text Option</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Hide Table Of Contents</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS = RENDERER_OPTION_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Hide Header And Footer On Cover Page</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE = RENDERER_OPTION_FEATURE_COUNT + 25;

	/**
	 * The number of structural features of the '<em>Layout Options</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 26;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.ListOptionImpl
	 * <em>List Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.ListOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getListOption()
	 * @generated
	 */
	int LIST_OPTION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIST_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>List Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIST_OPTION__LIST_STYLE = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Option</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIST_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl
	 * <em>Text Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getTextOption()
	 * @generated
	 */
	int TEXT_OPTION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__FONT_FAMILY = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__FONT_SIZE = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bold</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__BOLD = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Underline</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__UNDERLINE = RENDERER_OPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__FONT_COLOR = RENDERER_OPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Text Align</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__TEXT_ALIGN = RENDERER_OPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Italics</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__ITALICS = RENDERER_OPTION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Text Option</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.UColorImpl
	 * <em>UColor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.UColorImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getUColor()
	 * @generated
	 */
	int UCOLOR = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UCOLOR__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Red</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UCOLOR__RED = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Green</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UCOLOR__GREEN = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Blue</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UCOLOR__BLUE = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>UColor</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UCOLOR_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl
	 * <em>Box Model Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getBoxModelOption()
	 * @generated
	 */
	int BOX_MODEL_OPTION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Margin</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__MARGIN = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Margin Top</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__MARGIN_TOP = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Margin Left</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__MARGIN_LEFT = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Margin Bottom</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__MARGIN_BOTTOM = RENDERER_OPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Margin Right</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__MARGIN_RIGHT = RENDERER_OPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Border</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BORDER = RENDERER_OPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Border Top</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BORDER_TOP = RENDERER_OPTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Border Left</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BORDER_LEFT = RENDERER_OPTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Border Bottom</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BORDER_BOTTOM = RENDERER_OPTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Border Right</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BORDER_RIGHT = RENDERER_OPTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Border Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BORDER_STYLE = RENDERER_OPTION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BORDER_COLOR = RENDERER_OPTION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Padding</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__PADDING = RENDERER_OPTION_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Padding Top</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__PADDING_TOP = RENDERER_OPTION_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Padding Left</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__PADDING_LEFT = RENDERER_OPTION_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Padding Bottom</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__PADDING_BOTTOM = RENDERER_OPTION_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Padding Right</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__PADDING_RIGHT = RENDERER_OPTION_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BACKGROUND_COLOR = RENDERER_OPTION_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Keep Together</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__KEEP_TOGETHER = RENDERER_OPTION_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Keep With Previous</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS = RENDERER_OPTION_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Keep With Next</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__KEEP_WITH_NEXT = RENDERER_OPTION_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Break Before</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BREAK_BEFORE = RENDERER_OPTION_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__WIDTH = RENDERER_OPTION_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Break After</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION__BREAK_AFTER = RENDERER_OPTION_FEATURE_COUNT + 23;

	/**
	 * The number of structural features of the '<em>Box Model Option</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOX_MODEL_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 24;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.SectionOptionImpl
	 * <em>Section Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.SectionOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getSectionOption()
	 * @generated
	 */
	int SECTION_OPTION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECTION_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Section Numbering Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECTION_OPTION__SECTION_NUMBERING_STYLE = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Leave Out Previous Section Numbering</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECTION_OPTION__LEAVE_OUT_PREVIOUS_SECTION_NUMBERING = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Section Option</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECTION_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.impl.BooleanAttributeOptionImpl
	 * <em>Boolean Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.BooleanAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getBooleanAttributeOption()
	 * @generated
	 */
	int BOOLEAN_ATTRIBUTE_OPTION = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ATTRIBUTE_OPTION__NAME = ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ATTRIBUTE_OPTION__HIDE = ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Attribute Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ATTRIBUTE_OPTION__ATTRIBUTE_TEXT = ATTRIBUTE_OPTION__ATTRIBUTE_TEXT;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ATTRIBUTE_OPTION__ORDER_NUMBER = ATTRIBUTE_OPTION__ORDER_NUMBER;

	/**
	 * The feature id for the '<em><b>Boolean Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ATTRIBUTE_OPTION__BOOLEAN_STYLE = ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Attribute Option</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_ATTRIBUTE_OPTION_FEATURE_COUNT = ATTRIBUTE_OPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.impl.DateAttributeOptionImpl
	 * <em>Date Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.DateAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getDateAttributeOption()
	 * @generated
	 */
	int DATE_ATTRIBUTE_OPTION = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATE_ATTRIBUTE_OPTION__NAME = ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATE_ATTRIBUTE_OPTION__HIDE = ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Attribute Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATE_ATTRIBUTE_OPTION__ATTRIBUTE_TEXT = ATTRIBUTE_OPTION__ATTRIBUTE_TEXT;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATE_ATTRIBUTE_OPTION__ORDER_NUMBER = ATTRIBUTE_OPTION__ORDER_NUMBER;

	/**
	 * The feature id for the '<em><b>Date Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATE_ATTRIBUTE_OPTION__DATE_STYLE = ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Date Attribute Option</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATE_ATTRIBUTE_OPTION_FEATURE_COUNT = ATTRIBUTE_OPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.PageCitationStyle
	 * <em>Page Citation Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.PageCitationStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getPageCitationStyle()
	 * @generated
	 */
	int PAGE_CITATION_STYLE = 15;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.HeaderStyle
	 * <em>Header Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.HeaderStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getHeaderStyle()
	 * @generated
	 */
	int HEADER_STYLE = 16;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.AppendixStyle
	 * <em>Appendix Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.AppendixStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getAppendixStyle()
	 * @generated
	 */
	int APPENDIX_STYLE = 17;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.FontFamily
	 * <em>Font Family</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.FontFamily
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getFontFamily()
	 * @generated
	 */
	int FONT_FAMILY = 18;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.ListStyle
	 * <em>List Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.ListStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getListStyle()
	 * @generated
	 */
	int LIST_STYLE = 19;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.UBorderStyle
	 * <em>UBorder Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.UBorderStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getUBorderStyle()
	 * @generated
	 */
	int UBORDER_STYLE = 20;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle
	 * <em>Section Numbering Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getSectionNumberingStyle()
	 * @generated
	 */
	int SECTION_NUMBERING_STYLE = 21;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.TextAlign
	 * <em>Text Align</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.TextAlign
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getTextAlign()
	 * @generated
	 */
	int TEXT_ALIGN = 22;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.BooleanStyle
	 * <em>Boolean Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.BooleanStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getBooleanStyle()
	 * @generated
	 */
	int BOOLEAN_STYLE = 23;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.DateStyle
	 * <em>Date Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.renderers.options.DateStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getDateStyle()
	 * @generated
	 */
	int DATE_STYLE = 24;

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.RendererOption
	 * <em>Renderer Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Renderer Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.RendererOption
	 * @generated
	 */
	EClass getRendererOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.RendererOption#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.RendererOption#getName()
	 * @see #getRendererOption()
	 * @generated
	 */
	EAttribute getRendererOption_Name();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption
	 * <em>Attribute Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.AttributeOption
	 * @generated
	 */
	EClass getAttributeOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#isHide <em>Hide</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hide</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.AttributeOption#isHide()
	 * @see #getAttributeOption()
	 * @generated
	 */
	EAttribute getAttributeOption_Hide();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#isOverwriteGlobalOption
	 * <em>Overwrite Global Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Overwrite Global Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.AttributeOption#isOverwriteGlobalOption()
	 * @see #getAttributeOption()
	 * @generated
	 */
	EAttribute getAttributeOption_OverwriteGlobalOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#getAttributeText
	 * <em>Attribute Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Attribute Text</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.AttributeOption#getAttributeText()
	 * @see #getAttributeOption()
	 * @generated
	 */
	EAttribute getAttributeOption_AttributeText();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#getOrderNumber <em>Order Number</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Order Number</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.AttributeOption#getOrderNumber()
	 * @see #getAttributeOption()
	 * @generated
	 */
	EAttribute getAttributeOption_OrderNumber();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption
	 * <em>Single Reference Attribute Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Single Reference Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption
	 * @generated
	 */
	EClass getSingleReferenceAttributeOption();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption
	 * <em>Multi Reference Attribute Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Multi Reference Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption
	 * @generated
	 */
	EClass getMultiReferenceAttributeOption();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption#getListOption
	 * <em>List Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>List Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption#getListOption()
	 * @see #getMultiReferenceAttributeOption()
	 * @generated
	 */
	EReference getMultiReferenceAttributeOption_ListOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.ReferenceOption
	 * <em>Reference Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Reference Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceOption
	 * @generated
	 */
	EClass getReferenceOption();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption
	 * <em>String Attribute Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.StringAttributeOption
	 * @generated
	 */
	EClass getStringAttributeOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions
	 * <em>Layout Options</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Layout Options</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions
	 * @generated
	 */
	EClass getLayoutOptions();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderTextOption
	 * <em>Header Text Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Header Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_HeaderTextOption();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDefaultTextOption
	 * <em>Default Text Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Default Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDefaultTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_DefaultTextOption();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionTextOption
	 * <em>Section Text Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Section Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_SectionTextOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAnnotations
	 * <em>Hide Annotations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hide Annotations</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAnnotations()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideAnnotations();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAttachments
	 * <em>Hide Attachments</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hide Attachments</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAttachments()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideAttachments();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideIncomingDocumentReferences
	 * <em>Hide Incoming Document References</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hide Incoming Document References</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideIncomingDocumentReferences()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideIncomingDocumentReferences();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideModelElementImages
	 * <em>Hide Model Element Images</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hide Model Element Images</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideModelElementImages()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideModelElementImages();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getModelElementTextOption
	 * <em>Model Element Text Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Model Element Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getModelElementTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_ModelElementTextOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderText <em>Header Text</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Header Text</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderText()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HeaderText();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterText <em>Footer Text</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Footer Text</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterText()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_FooterText();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionOption
	 * <em>Section Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Section Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_SectionOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionFontSizeDecreaseStep
	 * <em>Section Font Size Decrease Step</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Section Font Size Decrease Step</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionFontSizeDecreaseStep()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_SectionFontSizeDecreaseStep();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDocumentTitleTextOption
	 * <em>Document Title Text Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Document Title Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDocumentTitleTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_DocumentTitleTextOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isShowModelElementTypeInSectionTitle
	 * <em>Show Model Element Type In Section Title</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Show Model Element Type In Section Title</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isShowModelElementTypeInSectionTitle()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_ShowModelElementTypeInSectionTitle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getAppendixStyle
	 * <em>Appendix Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Appendix Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getAppendixStyle()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_AppendixStyle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoImage <em>Logo Image</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Logo Image</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoImage()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_LogoImage();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterTextOption
	 * <em>Footer Text Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Footer Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_FooterTextOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isFooterShowDocumentTitle
	 * <em>Footer Show Document Title</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Footer Show Document Title</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isFooterShowDocumentTitle()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_FooterShowDocumentTitle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getPageCitationStyle
	 * <em>Page Citation Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Page Citation Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getPageCitationStyle()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_PageCitationStyle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderStyle <em>Header Style</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Header Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderStyle()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HeaderStyle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoWidth <em>Logo Width</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Logo Width</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoWidth()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_LogoWidth();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoHeight <em>Logo Height</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Logo Height</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoHeight()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_LogoHeight();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isLogoOnCoverPage
	 * <em>Logo On Cover Page</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Logo On Cover Page</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isLogoOnCoverPage()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_LogoOnCoverPage();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getTableOfContentsTextOption
	 * <em>Table Of Contents Text Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Table Of Contents Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getTableOfContentsTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_TableOfContentsTextOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideTableOfContents
	 * <em>Hide Table Of Contents</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hide Table Of Contents</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideTableOfContents()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideTableOfContents();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideHeaderAndFooterOnCoverPage
	 * <em>Hide Header And Footer On Cover Page</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Hide Header And Footer On Cover Page</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideHeaderAndFooterOnCoverPage()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideHeaderAndFooterOnCoverPage();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.ListOption
	 * <em>List Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>List Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ListOption
	 * @generated
	 */
	EClass getListOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.ListOption#getListStyle <em>List Style</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>List Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ListOption#getListStyle()
	 * @see #getListOption()
	 * @generated
	 */
	EAttribute getListOption_ListStyle();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.TextOption
	 * <em>Text Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption
	 * @generated
	 */
	EClass getTextOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontFamily <em>Font Family</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Font Family</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#getFontFamily()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_FontFamily();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontSize <em>Font Size</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Font Size</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#getFontSize()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_FontSize();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontColor <em>Font Color</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Font Color</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#getFontColor()
	 * @see #getTextOption()
	 * @generated
	 */
	EReference getTextOption_FontColor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.TextOption#getTextAlign <em>Text Align</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text Align</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#getTextAlign()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_TextAlign();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.TextOption#isItalics <em>Italics</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Italics</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#isItalics()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_Italics();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.TextOption#isBold <em>Bold</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Bold</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#isBold()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_Bold();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.TextOption#isUnderline <em>Underline</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Underline</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#isUnderline()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_Underline();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption
	 * <em>Reference Attribute Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Reference Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption
	 * @generated
	 */
	EClass getReferenceAttributeOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#isContained
	 * <em>Contained</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Contained</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#isContained()
	 * @see #getReferenceAttributeOption()
	 * @generated
	 */
	EAttribute getReferenceAttributeOption_Contained();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#getReferenceOption
	 * <em>Reference Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Reference Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#getReferenceOption()
	 * @see #getReferenceAttributeOption()
	 * @generated
	 */
	EReference getReferenceAttributeOption_ReferenceOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.UColor
	 * <em>UColor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UColor</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.UColor
	 * @generated
	 */
	EClass getUColor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.UColor#getRed <em>Red</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Red</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.UColor#getRed()
	 * @see #getUColor()
	 * @generated
	 */
	EAttribute getUColor_Red();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.UColor#getGreen <em>Green</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Green</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.UColor#getGreen()
	 * @see #getUColor()
	 * @generated
	 */
	EAttribute getUColor_Green();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.UColor#getBlue <em>Blue</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Blue</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.UColor#getBlue()
	 * @see #getUColor()
	 * @generated
	 */
	EAttribute getUColor_Blue();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption
	 * <em>Box Model Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Box Model Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption
	 * @generated
	 */
	EClass getBoxModelOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMargin <em>Margin</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Margin</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMargin()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_Margin();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginTop <em>Margin Top</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Margin Top</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginTop()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_MarginTop();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginLeft <em>Margin Left</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Margin Left</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginLeft()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_MarginLeft();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginBottom <em>Margin Bottom</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Margin Bottom</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginBottom()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_MarginBottom();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginRight <em>Margin Right</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Margin Right</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginRight()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_MarginRight();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorder <em>Border</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Border</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorder()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_Border();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderTop <em>Border Top</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Border Top</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderTop()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_BorderTop();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderLeft <em>Border Left</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Border Left</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderLeft()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_BorderLeft();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderBottom <em>Border Bottom</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Border Bottom</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderBottom()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_BorderBottom();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderRight <em>Border Right</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Border Right</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderRight()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_BorderRight();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderStyle <em>Border Style</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Border Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderStyle()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_BorderStyle();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderColor <em>Border Color</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Border Color</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderColor()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EReference getBoxModelOption_BorderColor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPadding <em>Padding</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Padding</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPadding()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_Padding();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingTop <em>Padding Top</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Padding Top</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingTop()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_PaddingTop();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingLeft <em>Padding Left</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Padding Left</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingLeft()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_PaddingLeft();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingBottom
	 * <em>Padding Bottom</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Padding Bottom</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingBottom()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_PaddingBottom();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingRight <em>Padding Right</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Padding Right</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingRight()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_PaddingRight();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBackgroundColor
	 * <em>Background Color</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Background Color</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBackgroundColor()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EReference getBoxModelOption_BackgroundColor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepTogether <em>Keep Together</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Keep Together</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepTogether()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_KeepTogether();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepWithPrevious
	 * <em>Keep With Previous</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Keep With Previous</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepWithPrevious()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_KeepWithPrevious();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepWithNext <em>Keep With Next</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Keep With Next</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepWithNext()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_KeepWithNext();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isBreakBefore <em>Break Before</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Break Before</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isBreakBefore()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_BreakBefore();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getWidth <em>Width</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getWidth()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_Width();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isBreakAfter <em>Break After</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Break After</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isBreakAfter()
	 * @see #getBoxModelOption()
	 * @generated
	 */
	EAttribute getBoxModelOption_BreakAfter();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.SectionOption
	 * <em>Section Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Section Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.SectionOption
	 * @generated
	 */
	EClass getSectionOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.SectionOption#getSectionNumberingStyle
	 * <em>Section Numbering Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Section Numbering Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.SectionOption#getSectionNumberingStyle()
	 * @see #getSectionOption()
	 * @generated
	 */
	EAttribute getSectionOption_SectionNumberingStyle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.SectionOption#isLeaveOutPreviousSectionNumbering
	 * <em>Leave Out Previous Section Numbering</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Leave Out Previous Section Numbering</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.SectionOption#isLeaveOutPreviousSectionNumbering()
	 * @see #getSectionOption()
	 * @generated
	 */
	EAttribute getSectionOption_LeaveOutPreviousSectionNumbering();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption
	 * <em>Boolean Attribute Option</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Boolean Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption
	 * @generated
	 */
	EClass getBooleanAttributeOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption#getBooleanStyle
	 * <em>Boolean Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Boolean Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption#getBooleanStyle()
	 * @see #getBooleanAttributeOption()
	 * @generated
	 */
	EAttribute getBooleanAttributeOption_BooleanStyle();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.DateAttributeOption <em>Date Attribute Option</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Date Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.DateAttributeOption
	 * @generated
	 */
	EClass getDateAttributeOption();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.docExport.exportModel.renderers.options.DateAttributeOption#getDateStyle <em>Date Style</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Date Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.DateAttributeOption#getDateStyle()
	 * @see #getDateAttributeOption()
	 * @generated
	 */
	EAttribute getDateAttributeOption_DateStyle();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.PageCitationStyle
	 * <em>Page Citation Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Page Citation Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.PageCitationStyle
	 * @generated
	 */
	EEnum getPageCitationStyle();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.HeaderStyle
	 * <em>Header Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Header Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.HeaderStyle
	 * @generated
	 */
	EEnum getHeaderStyle();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.AppendixStyle
	 * <em>Appendix Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Appendix Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.AppendixStyle
	 * @generated
	 */
	EEnum getAppendixStyle();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.FontFamily
	 * <em>Font Family</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Font Family</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.FontFamily
	 * @generated
	 */
	EEnum getFontFamily();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.ListStyle
	 * <em>List Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>List Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ListStyle
	 * @generated
	 */
	EEnum getListStyle();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.UBorderStyle
	 * <em>UBorder Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>UBorder Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.UBorderStyle
	 * @generated
	 */
	EEnum getUBorderStyle();

	/**
	 * Returns the meta object for enum '
	 * {@link org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle
	 * <em>Section Numbering Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Section Numbering Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle
	 * @generated
	 */
	EEnum getSectionNumberingStyle();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.TextAlign
	 * <em>Text Align</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Text Align</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextAlign
	 * @generated
	 */
	EEnum getTextAlign();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.BooleanStyle
	 * <em>Boolean Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Boolean Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.BooleanStyle
	 * @generated
	 */
	EEnum getBooleanStyle();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.DateStyle
	 * <em>Date Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Date Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.DateStyle
	 * @generated
	 */
	EEnum getDateStyle();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OptionsFactory getOptionsFactory();

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
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.RendererOptionImpl <em>Renderer Option</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.RendererOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getRendererOption()
		 * @generated
		 */
		EClass RENDERER_OPTION = eINSTANCE.getRendererOption();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RENDERER_OPTION__NAME = eINSTANCE.getRendererOption_Name();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl
		 * <em>Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getAttributeOption()
		 * @generated
		 */
		EClass ATTRIBUTE_OPTION = eINSTANCE.getAttributeOption();

		/**
		 * The meta object literal for the '<em><b>Hide</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPTION__HIDE = eINSTANCE.getAttributeOption_Hide();

		/**
		 * The meta object literal for the '<em><b>Overwrite Global Option</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = eINSTANCE.getAttributeOption_OverwriteGlobalOption();

		/**
		 * The meta object literal for the '<em><b>Attribute Text</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPTION__ATTRIBUTE_TEXT = eINSTANCE.getAttributeOption_AttributeText();

		/**
		 * The meta object literal for the '<em><b>Order Number</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPTION__ORDER_NUMBER = eINSTANCE.getAttributeOption_OrderNumber();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl
		 * <em>Single Reference Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getSingleReferenceAttributeOption()
		 * @generated
		 */
		EClass SINGLE_REFERENCE_ATTRIBUTE_OPTION = eINSTANCE.getSingleReferenceAttributeOption();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl
		 * <em>Multi Reference Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getMultiReferenceAttributeOption()
		 * @generated
		 */
		EClass MULTI_REFERENCE_ATTRIBUTE_OPTION = eINSTANCE.getMultiReferenceAttributeOption();

		/**
		 * The meta object literal for the '<em><b>List Option</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION = eINSTANCE
			.getMultiReferenceAttributeOption_ListOption();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceOptionImpl
		 * <em>Reference Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.ReferenceOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getReferenceOption()
		 * @generated
		 */
		EClass REFERENCE_OPTION = eINSTANCE.getReferenceOption();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl
		 * <em>String Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getStringAttributeOption()
		 * @generated
		 */
		EClass STRING_ATTRIBUTE_OPTION = eINSTANCE.getStringAttributeOption();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl <em>Layout Options</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getLayoutOptions()
		 * @generated
		 */
		EClass LAYOUT_OPTIONS = eINSTANCE.getLayoutOptions();

		/**
		 * The meta object literal for the '<em><b>Header Text Option</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__HEADER_TEXT_OPTION = eINSTANCE.getLayoutOptions_HeaderTextOption();

		/**
		 * The meta object literal for the '<em><b>Default Text Option</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION = eINSTANCE.getLayoutOptions_DefaultTextOption();

		/**
		 * The meta object literal for the '<em><b>Section Text Option</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__SECTION_TEXT_OPTION = eINSTANCE.getLayoutOptions_SectionTextOption();

		/**
		 * The meta object literal for the '<em><b>Hide Annotations</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_ANNOTATIONS = eINSTANCE.getLayoutOptions_HideAnnotations();

		/**
		 * The meta object literal for the '<em><b>Hide Attachments</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_ATTACHMENTS = eINSTANCE.getLayoutOptions_HideAttachments();

		/**
		 * The meta object literal for the '<em><b>Hide Incoming Document References</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES = eINSTANCE
			.getLayoutOptions_HideIncomingDocumentReferences();

		/**
		 * The meta object literal for the '<em><b>Hide Model Element Images</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES = eINSTANCE.getLayoutOptions_HideModelElementImages();

		/**
		 * The meta object literal for the '<em><b>Model Element Text Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION = eINSTANCE.getLayoutOptions_ModelElementTextOption();

		/**
		 * The meta object literal for the '<em><b>Header Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HEADER_TEXT = eINSTANCE.getLayoutOptions_HeaderText();

		/**
		 * The meta object literal for the '<em><b>Footer Text</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__FOOTER_TEXT = eINSTANCE.getLayoutOptions_FooterText();

		/**
		 * The meta object literal for the '<em><b>Section Option</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__SECTION_OPTION = eINSTANCE.getLayoutOptions_SectionOption();

		/**
		 * The meta object literal for the '<em><b>Section Font Size Decrease Step</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP = eINSTANCE
			.getLayoutOptions_SectionFontSizeDecreaseStep();

		/**
		 * The meta object literal for the '<em><b>Document Title Text Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION = eINSTANCE.getLayoutOptions_DocumentTitleTextOption();

		/**
		 * The meta object literal for the '<em><b>Show Model Element Type In Section Title</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE = eINSTANCE
			.getLayoutOptions_ShowModelElementTypeInSectionTitle();

		/**
		 * The meta object literal for the '<em><b>Appendix Style</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__APPENDIX_STYLE = eINSTANCE.getLayoutOptions_AppendixStyle();

		/**
		 * The meta object literal for the '<em><b>Logo Image</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__LOGO_IMAGE = eINSTANCE.getLayoutOptions_LogoImage();

		/**
		 * The meta object literal for the '<em><b>Footer Text Option</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__FOOTER_TEXT_OPTION = eINSTANCE.getLayoutOptions_FooterTextOption();

		/**
		 * The meta object literal for the '<em><b>Footer Show Document Title</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE = eINSTANCE.getLayoutOptions_FooterShowDocumentTitle();

		/**
		 * The meta object literal for the '<em><b>Page Citation Style</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__PAGE_CITATION_STYLE = eINSTANCE.getLayoutOptions_PageCitationStyle();

		/**
		 * The meta object literal for the '<em><b>Header Style</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HEADER_STYLE = eINSTANCE.getLayoutOptions_HeaderStyle();

		/**
		 * The meta object literal for the '<em><b>Logo Width</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__LOGO_WIDTH = eINSTANCE.getLayoutOptions_LogoWidth();

		/**
		 * The meta object literal for the '<em><b>Logo Height</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__LOGO_HEIGHT = eINSTANCE.getLayoutOptions_LogoHeight();

		/**
		 * The meta object literal for the '<em><b>Logo On Cover Page</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE = eINSTANCE.getLayoutOptions_LogoOnCoverPage();

		/**
		 * The meta object literal for the '<em><b>Table Of Contents Text Option</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION = eINSTANCE
			.getLayoutOptions_TableOfContentsTextOption();

		/**
		 * The meta object literal for the '<em><b>Hide Table Of Contents</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS = eINSTANCE.getLayoutOptions_HideTableOfContents();

		/**
		 * The meta object literal for the '<em><b>Hide Header And Footer On Cover Page</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE = eINSTANCE
			.getLayoutOptions_HideHeaderAndFooterOnCoverPage();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.ListOptionImpl <em>List Option</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.ListOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getListOption()
		 * @generated
		 */
		EClass LIST_OPTION = eINSTANCE.getListOption();

		/**
		 * The meta object literal for the '<em><b>List Style</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIST_OPTION__LIST_STYLE = eINSTANCE.getListOption_ListStyle();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl <em>Text Option</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getTextOption()
		 * @generated
		 */
		EClass TEXT_OPTION = eINSTANCE.getTextOption();

		/**
		 * The meta object literal for the '<em><b>Font Family</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEXT_OPTION__FONT_FAMILY = eINSTANCE.getTextOption_FontFamily();

		/**
		 * The meta object literal for the '<em><b>Font Size</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEXT_OPTION__FONT_SIZE = eINSTANCE.getTextOption_FontSize();

		/**
		 * The meta object literal for the '<em><b>Font Color</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEXT_OPTION__FONT_COLOR = eINSTANCE.getTextOption_FontColor();

		/**
		 * The meta object literal for the '<em><b>Text Align</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEXT_OPTION__TEXT_ALIGN = eINSTANCE.getTextOption_TextAlign();

		/**
		 * The meta object literal for the '<em><b>Italics</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEXT_OPTION__ITALICS = eINSTANCE.getTextOption_Italics();

		/**
		 * The meta object literal for the '<em><b>Bold</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEXT_OPTION__BOLD = eINSTANCE.getTextOption_Bold();

		/**
		 * The meta object literal for the '<em><b>Underline</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEXT_OPTION__UNDERLINE = eINSTANCE.getTextOption_Underline();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl
		 * <em>Reference Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getReferenceAttributeOption()
		 * @generated
		 */
		EClass REFERENCE_ATTRIBUTE_OPTION = eINSTANCE.getReferenceAttributeOption();

		/**
		 * The meta object literal for the '<em><b>Contained</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REFERENCE_ATTRIBUTE_OPTION__CONTAINED = eINSTANCE.getReferenceAttributeOption_Contained();

		/**
		 * The meta object literal for the '<em><b>Reference Option</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION = eINSTANCE
			.getReferenceAttributeOption_ReferenceOption();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.UColorImpl
		 * <em>UColor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.UColorImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getUColor()
		 * @generated
		 */
		EClass UCOLOR = eINSTANCE.getUColor();

		/**
		 * The meta object literal for the '<em><b>Red</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UCOLOR__RED = eINSTANCE.getUColor_Red();

		/**
		 * The meta object literal for the '<em><b>Green</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UCOLOR__GREEN = eINSTANCE.getUColor_Green();

		/**
		 * The meta object literal for the '<em><b>Blue</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UCOLOR__BLUE = eINSTANCE.getUColor_Blue();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl <em>Box Model Option</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getBoxModelOption()
		 * @generated
		 */
		EClass BOX_MODEL_OPTION = eINSTANCE.getBoxModelOption();

		/**
		 * The meta object literal for the '<em><b>Margin</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__MARGIN = eINSTANCE.getBoxModelOption_Margin();

		/**
		 * The meta object literal for the '<em><b>Margin Top</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__MARGIN_TOP = eINSTANCE.getBoxModelOption_MarginTop();

		/**
		 * The meta object literal for the '<em><b>Margin Left</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__MARGIN_LEFT = eINSTANCE.getBoxModelOption_MarginLeft();

		/**
		 * The meta object literal for the '<em><b>Margin Bottom</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__MARGIN_BOTTOM = eINSTANCE.getBoxModelOption_MarginBottom();

		/**
		 * The meta object literal for the '<em><b>Margin Right</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__MARGIN_RIGHT = eINSTANCE.getBoxModelOption_MarginRight();

		/**
		 * The meta object literal for the '<em><b>Border</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__BORDER = eINSTANCE.getBoxModelOption_Border();

		/**
		 * The meta object literal for the '<em><b>Border Top</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__BORDER_TOP = eINSTANCE.getBoxModelOption_BorderTop();

		/**
		 * The meta object literal for the '<em><b>Border Left</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__BORDER_LEFT = eINSTANCE.getBoxModelOption_BorderLeft();

		/**
		 * The meta object literal for the '<em><b>Border Bottom</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__BORDER_BOTTOM = eINSTANCE.getBoxModelOption_BorderBottom();

		/**
		 * The meta object literal for the '<em><b>Border Right</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__BORDER_RIGHT = eINSTANCE.getBoxModelOption_BorderRight();

		/**
		 * The meta object literal for the '<em><b>Border Style</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__BORDER_STYLE = eINSTANCE.getBoxModelOption_BorderStyle();

		/**
		 * The meta object literal for the '<em><b>Border Color</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BOX_MODEL_OPTION__BORDER_COLOR = eINSTANCE.getBoxModelOption_BorderColor();

		/**
		 * The meta object literal for the '<em><b>Padding</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__PADDING = eINSTANCE.getBoxModelOption_Padding();

		/**
		 * The meta object literal for the '<em><b>Padding Top</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__PADDING_TOP = eINSTANCE.getBoxModelOption_PaddingTop();

		/**
		 * The meta object literal for the '<em><b>Padding Left</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__PADDING_LEFT = eINSTANCE.getBoxModelOption_PaddingLeft();

		/**
		 * The meta object literal for the '<em><b>Padding Bottom</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__PADDING_BOTTOM = eINSTANCE.getBoxModelOption_PaddingBottom();

		/**
		 * The meta object literal for the '<em><b>Padding Right</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__PADDING_RIGHT = eINSTANCE.getBoxModelOption_PaddingRight();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' reference feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BOX_MODEL_OPTION__BACKGROUND_COLOR = eINSTANCE.getBoxModelOption_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Keep Together</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__KEEP_TOGETHER = eINSTANCE.getBoxModelOption_KeepTogether();

		/**
		 * The meta object literal for the '<em><b>Keep With Previous</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS = eINSTANCE.getBoxModelOption_KeepWithPrevious();

		/**
		 * The meta object literal for the '<em><b>Keep With Next</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__KEEP_WITH_NEXT = eINSTANCE.getBoxModelOption_KeepWithNext();

		/**
		 * The meta object literal for the '<em><b>Break Before</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__BREAK_BEFORE = eINSTANCE.getBoxModelOption_BreakBefore();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__WIDTH = eINSTANCE.getBoxModelOption_Width();

		/**
		 * The meta object literal for the '<em><b>Break After</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOX_MODEL_OPTION__BREAK_AFTER = eINSTANCE.getBoxModelOption_BreakAfter();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.SectionOptionImpl <em>Section Option</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.SectionOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getSectionOption()
		 * @generated
		 */
		EClass SECTION_OPTION = eINSTANCE.getSectionOption();

		/**
		 * The meta object literal for the '<em><b>Section Numbering Style</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SECTION_OPTION__SECTION_NUMBERING_STYLE = eINSTANCE.getSectionOption_SectionNumberingStyle();

		/**
		 * The meta object literal for the '<em><b>Leave Out Previous Section Numbering</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SECTION_OPTION__LEAVE_OUT_PREVIOUS_SECTION_NUMBERING = eINSTANCE
			.getSectionOption_LeaveOutPreviousSectionNumbering();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.BooleanAttributeOptionImpl
		 * <em>Boolean Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.BooleanAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getBooleanAttributeOption()
		 * @generated
		 */
		EClass BOOLEAN_ATTRIBUTE_OPTION = eINSTANCE.getBooleanAttributeOption();

		/**
		 * The meta object literal for the '<em><b>Boolean Style</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOOLEAN_ATTRIBUTE_OPTION__BOOLEAN_STYLE = eINSTANCE.getBooleanAttributeOption_BooleanStyle();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.impl.DateAttributeOptionImpl
		 * <em>Date Attribute Option</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.DateAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getDateAttributeOption()
		 * @generated
		 */
		EClass DATE_ATTRIBUTE_OPTION = eINSTANCE.getDateAttributeOption();

		/**
		 * The meta object literal for the '<em><b>Date Style</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATE_ATTRIBUTE_OPTION__DATE_STYLE = eINSTANCE.getDateAttributeOption_DateStyle();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.PageCitationStyle <em>Page Citation Style</em>}'
		 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.PageCitationStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getPageCitationStyle()
		 * @generated
		 */
		EEnum PAGE_CITATION_STYLE = eINSTANCE.getPageCitationStyle();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.HeaderStyle
		 * <em>Header Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.HeaderStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getHeaderStyle()
		 * @generated
		 */
		EEnum HEADER_STYLE = eINSTANCE.getHeaderStyle();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.AppendixStyle
		 * <em>Appendix Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.AppendixStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getAppendixStyle()
		 * @generated
		 */
		EEnum APPENDIX_STYLE = eINSTANCE.getAppendixStyle();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.FontFamily
		 * <em>Font Family</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.FontFamily
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getFontFamily()
		 * @generated
		 */
		EEnum FONT_FAMILY = eINSTANCE.getFontFamily();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.ListStyle
		 * <em>List Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.ListStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getListStyle()
		 * @generated
		 */
		EEnum LIST_STYLE = eINSTANCE.getListStyle();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.UBorderStyle
		 * <em>UBorder Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.UBorderStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getUBorderStyle()
		 * @generated
		 */
		EEnum UBORDER_STYLE = eINSTANCE.getUBorderStyle();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle
		 * <em>Section Numbering Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getSectionNumberingStyle()
		 * @generated
		 */
		EEnum SECTION_NUMBERING_STYLE = eINSTANCE.getSectionNumberingStyle();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.TextAlign
		 * <em>Text Align</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.TextAlign
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getTextAlign()
		 * @generated
		 */
		EEnum TEXT_ALIGN = eINSTANCE.getTextAlign();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.BooleanStyle
		 * <em>Boolean Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.BooleanStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getBooleanStyle()
		 * @generated
		 */
		EEnum BOOLEAN_STYLE = eINSTANCE.getBooleanStyle();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.DateStyle
		 * <em>Date Style</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.renderers.options.DateStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getDateStyle()
		 * @generated
		 */
		EEnum DATE_STYLE = eINSTANCE.getDateStyle();

	}

} // OptionsPackage
