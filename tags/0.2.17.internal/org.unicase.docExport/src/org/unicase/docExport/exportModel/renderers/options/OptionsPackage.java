/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.options;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsFactory
 * @model kind="package"
 * @generated
 */
public interface OptionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "options";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/docExport/exportModel/renderers/options";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.docExport.exportModel.renderers.options";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OptionsPackage eINSTANCE = org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.RendererOptionImpl <em>Renderer Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.RendererOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getRendererOption()
	 * @generated
	 */
	int RENDERER_OPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERER_OPTION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Renderer Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERER_OPTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl <em>Attribute Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getAttributeOption()
	 * @generated
	 */
	int ATTRIBUTE_OPTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION__HIDE = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl <em>Reference Attribute Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getReferenceAttributeOption()
	 * @generated
	 */
	int REFERENCE_ATTRIBUTE_OPTION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__NAME = ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__HIDE = ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__CONTAINED = ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION = ATTRIBUTE_OPTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Attribute Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT = ATTRIBUTE_OPTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl <em>Single Reference Attribute Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getSingleReferenceAttributeOption()
	 * @generated
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__NAME = REFERENCE_ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__HIDE = REFERENCE_ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__CONTAINED = REFERENCE_ATTRIBUTE_OPTION__CONTAINED;

	/**
	 * The feature id for the '<em><b>Reference Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION = REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION;

	/**
	 * The feature id for the '<em><b>Global Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION = REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Single Reference Attribute Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT = REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl <em>Multi Reference Attribute Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getMultiReferenceAttributeOption()
	 * @generated
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__NAME = REFERENCE_ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__HIDE = REFERENCE_ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = REFERENCE_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__CONTAINED = REFERENCE_ATTRIBUTE_OPTION__CONTAINED;

	/**
	 * The feature id for the '<em><b>Reference Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION = REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION;

	/**
	 * The feature id for the '<em><b>Global Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION = REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>List Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION = REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multi Reference Attribute Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT = REFERENCE_ATTRIBUTE_OPTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceOptionImpl <em>Reference Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.ReferenceOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getReferenceOption()
	 * @generated
	 */
	int REFERENCE_OPTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPTION__TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl <em>String Attribute Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getStringAttributeOption()
	 * @generated
	 */
	int STRING_ATTRIBUTE_OPTION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__NAME = ATTRIBUTE_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__HIDE = ATTRIBUTE_OPTION__HIDE;

	/**
	 * The feature id for the '<em><b>Overwrite Global Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION;

	/**
	 * The feature id for the '<em><b>Global Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__GLOBAL_OPTION = ATTRIBUTE_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION__TEXT_OPTION = ATTRIBUTE_OPTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>String Attribute Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_OPTION_FEATURE_COUNT = ATTRIBUTE_OPTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl <em>Layout Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getLayoutOptions()
	 * @generated
	 */
	int LAYOUT_OPTIONS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Cover Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__COVER_TEXT = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cover Text Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Section Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__SECTION_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hide Annotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_ANNOTATIONS = RENDERER_OPTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Hide Attachments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_ATTACHMENTS = RENDERER_OPTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Hide Incoming Document References</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES = RENDERER_OPTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Page Numbering Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__PAGE_NUMBERING_STYLE = RENDERER_OPTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Hide Model Element Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES = RENDERER_OPTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Model Element Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION = RENDERER_OPTION_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Layout Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPTIONS_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.ListOptionImpl <em>List Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.ListOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getListOption()
	 * @generated
	 */
	int LIST_OPTION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>List Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_OPTION__LIST_STYLE = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl <em>Text Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getTextOption()
	 * @generated
	 */
	int TEXT_OPTION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__FONT_FAMILY = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__FONT_SIZE = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__BOLD = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Underline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__UNDERLINE = RENDERER_OPTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION__FONT_COLOR = RENDERER_OPTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Text Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPTION_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.UColorImpl <em>UColor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.UColorImpl
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getUColor()
	 * @generated
	 */
	int UCOLOR = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCOLOR__NAME = RENDERER_OPTION__NAME;

	/**
	 * The feature id for the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCOLOR__RED = RENDERER_OPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCOLOR__GREEN = RENDERER_OPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCOLOR__BLUE = RENDERER_OPTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>UColor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCOLOR_FEATURE_COUNT = RENDERER_OPTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.FontFamily <em>Font Family</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.FontFamily
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getFontFamily()
	 * @generated
	 */
	int FONT_FAMILY = 11;


	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.ListStyle <em>List Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.ListStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getListStyle()
	 * @generated
	 */
	int LIST_STYLE = 12;


	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle <em>Page Numbering Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle
	 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getPageNumberingStyle()
	 * @generated
	 */
	int PAGE_NUMBERING_STYLE = 13;


	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.RendererOption <em>Renderer Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Renderer Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.RendererOption
	 * @generated
	 */
	EClass getRendererOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.RendererOption#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.RendererOption#getName()
	 * @see #getRendererOption()
	 * @generated
	 */
	EAttribute getRendererOption_Name();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption <em>Attribute Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.AttributeOption
	 * @generated
	 */
	EClass getAttributeOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#isHide <em>Hide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.AttributeOption#isHide()
	 * @see #getAttributeOption()
	 * @generated
	 */
	EAttribute getAttributeOption_Hide();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#isOverwriteGlobalOption <em>Overwrite Global Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overwrite Global Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.AttributeOption#isOverwriteGlobalOption()
	 * @see #getAttributeOption()
	 * @generated
	 */
	EAttribute getAttributeOption_OverwriteGlobalOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption <em>Single Reference Attribute Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Reference Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption
	 * @generated
	 */
	EClass getSingleReferenceAttributeOption();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption#getGlobalOption <em>Global Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Global Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption#getGlobalOption()
	 * @see #getSingleReferenceAttributeOption()
	 * @generated
	 */
	EReference getSingleReferenceAttributeOption_GlobalOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption <em>Multi Reference Attribute Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Reference Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption
	 * @generated
	 */
	EClass getMultiReferenceAttributeOption();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption#getGlobalOption <em>Global Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Global Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption#getGlobalOption()
	 * @see #getMultiReferenceAttributeOption()
	 * @generated
	 */
	EReference getMultiReferenceAttributeOption_GlobalOption();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption#getListOption <em>List Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>List Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption#getListOption()
	 * @see #getMultiReferenceAttributeOption()
	 * @generated
	 */
	EReference getMultiReferenceAttributeOption_ListOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.ReferenceOption <em>Reference Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceOption
	 * @generated
	 */
	EClass getReferenceOption();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.docExport.exportModel.renderers.options.ReferenceOption#getTextOption <em>Text Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceOption#getTextOption()
	 * @see #getReferenceOption()
	 * @generated
	 */
	EReference getReferenceOption_TextOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption <em>String Attribute Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.StringAttributeOption
	 * @generated
	 */
	EClass getStringAttributeOption();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption#getGlobalOption <em>Global Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Global Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.StringAttributeOption#getGlobalOption()
	 * @see #getStringAttributeOption()
	 * @generated
	 */
	EReference getStringAttributeOption_GlobalOption();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption#getTextOption <em>Text Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.StringAttributeOption#getTextOption()
	 * @see #getStringAttributeOption()
	 * @generated
	 */
	EReference getStringAttributeOption_TextOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions <em>Layout Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout Options</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions
	 * @generated
	 */
	EClass getLayoutOptions();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getCoverText <em>Cover Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cover Text</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getCoverText()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_CoverText();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getCoverTextTextOption <em>Cover Text Text Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cover Text Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getCoverTextTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_CoverTextTextOption();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDefaultTextOption <em>Default Text Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDefaultTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_DefaultTextOption();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionTextOption <em>Section Text Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Section Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_SectionTextOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAnnotations <em>Hide Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide Annotations</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAnnotations()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideAnnotations();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAttachments <em>Hide Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide Attachments</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAttachments()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideAttachments();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideIncomingDocumentReferences <em>Hide Incoming Document References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide Incoming Document References</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideIncomingDocumentReferences()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideIncomingDocumentReferences();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getPageNumberingStyle <em>Page Numbering Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Numbering Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getPageNumberingStyle()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_PageNumberingStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideModelElementImages <em>Hide Model Element Images</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide Model Element Images</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideModelElementImages()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EAttribute getLayoutOptions_HideModelElementImages();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getModelElementTextOption <em>Model Element Text Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Element Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getModelElementTextOption()
	 * @see #getLayoutOptions()
	 * @generated
	 */
	EReference getLayoutOptions_ModelElementTextOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.ListOption <em>List Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ListOption
	 * @generated
	 */
	EClass getListOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.ListOption#getListStyle <em>List Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>List Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ListOption#getListStyle()
	 * @see #getListOption()
	 * @generated
	 */
	EAttribute getListOption_ListStyle();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.TextOption <em>Text Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption
	 * @generated
	 */
	EClass getTextOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontFamily <em>Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Family</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#getFontFamily()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_FontFamily();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontSize <em>Font Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Size</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#getFontSize()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_FontSize();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontColor <em>Font Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Font Color</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#getFontColor()
	 * @see #getTextOption()
	 * @generated
	 */
	EReference getTextOption_FontColor();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#isBold <em>Bold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bold</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#isBold()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_Bold();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#isUnderline <em>Underline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Underline</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption#isUnderline()
	 * @see #getTextOption()
	 * @generated
	 */
	EAttribute getTextOption_Underline();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption <em>Reference Attribute Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Attribute Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption
	 * @generated
	 */
	EClass getReferenceAttributeOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#isContained <em>Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contained</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#isContained()
	 * @see #getReferenceAttributeOption()
	 * @generated
	 */
	EAttribute getReferenceAttributeOption_Contained();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#getReferenceOption <em>Reference Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference Option</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#getReferenceOption()
	 * @see #getReferenceAttributeOption()
	 * @generated
	 */
	EReference getReferenceAttributeOption_ReferenceOption();

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.renderers.options.UColor <em>UColor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UColor</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.UColor
	 * @generated
	 */
	EClass getUColor();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.UColor#getRed <em>Red</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Red</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.UColor#getRed()
	 * @see #getUColor()
	 * @generated
	 */
	EAttribute getUColor_Red();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.UColor#getGreen <em>Green</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Green</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.UColor#getGreen()
	 * @see #getUColor()
	 * @generated
	 */
	EAttribute getUColor_Green();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.renderers.options.UColor#getBlue <em>Blue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blue</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.UColor#getBlue()
	 * @see #getUColor()
	 * @generated
	 */
	EAttribute getUColor_Blue();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.FontFamily <em>Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Font Family</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.FontFamily
	 * @generated
	 */
	EEnum getFontFamily();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.ListStyle <em>List Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>List Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.ListStyle
	 * @generated
	 */
	EEnum getListStyle();

	/**
	 * Returns the meta object for enum '{@link org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle <em>Page Numbering Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Page Numbering Style</em>'.
	 * @see org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle
	 * @generated
	 */
	EEnum getPageNumberingStyle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OptionsFactory getOptionsFactory();

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
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.RendererOptionImpl <em>Renderer Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.RendererOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getRendererOption()
		 * @generated
		 */
		EClass RENDERER_OPTION = eINSTANCE.getRendererOption();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RENDERER_OPTION__NAME = eINSTANCE.getRendererOption_Name();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl <em>Attribute Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getAttributeOption()
		 * @generated
		 */
		EClass ATTRIBUTE_OPTION = eINSTANCE.getAttributeOption();

		/**
		 * The meta object literal for the '<em><b>Hide</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPTION__HIDE = eINSTANCE.getAttributeOption_Hide();

		/**
		 * The meta object literal for the '<em><b>Overwrite Global Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION = eINSTANCE.getAttributeOption_OverwriteGlobalOption();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl <em>Single Reference Attribute Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.SingleReferenceAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getSingleReferenceAttributeOption()
		 * @generated
		 */
		EClass SINGLE_REFERENCE_ATTRIBUTE_OPTION = eINSTANCE.getSingleReferenceAttributeOption();

		/**
		 * The meta object literal for the '<em><b>Global Option</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION = eINSTANCE.getSingleReferenceAttributeOption_GlobalOption();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl <em>Multi Reference Attribute Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.MultiReferenceAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getMultiReferenceAttributeOption()
		 * @generated
		 */
		EClass MULTI_REFERENCE_ATTRIBUTE_OPTION = eINSTANCE.getMultiReferenceAttributeOption();

		/**
		 * The meta object literal for the '<em><b>Global Option</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION = eINSTANCE.getMultiReferenceAttributeOption_GlobalOption();

		/**
		 * The meta object literal for the '<em><b>List Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION = eINSTANCE.getMultiReferenceAttributeOption_ListOption();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceOptionImpl <em>Reference Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.ReferenceOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getReferenceOption()
		 * @generated
		 */
		EClass REFERENCE_OPTION = eINSTANCE.getReferenceOption();

		/**
		 * The meta object literal for the '<em><b>Text Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_OPTION__TEXT_OPTION = eINSTANCE.getReferenceOption_TextOption();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl <em>String Attribute Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.StringAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getStringAttributeOption()
		 * @generated
		 */
		EClass STRING_ATTRIBUTE_OPTION = eINSTANCE.getStringAttributeOption();

		/**
		 * The meta object literal for the '<em><b>Global Option</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_ATTRIBUTE_OPTION__GLOBAL_OPTION = eINSTANCE.getStringAttributeOption_GlobalOption();

		/**
		 * The meta object literal for the '<em><b>Text Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_ATTRIBUTE_OPTION__TEXT_OPTION = eINSTANCE.getStringAttributeOption_TextOption();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl <em>Layout Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getLayoutOptions()
		 * @generated
		 */
		EClass LAYOUT_OPTIONS = eINSTANCE.getLayoutOptions();

		/**
		 * The meta object literal for the '<em><b>Cover Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__COVER_TEXT = eINSTANCE.getLayoutOptions_CoverText();

		/**
		 * The meta object literal for the '<em><b>Cover Text Text Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION = eINSTANCE.getLayoutOptions_CoverTextTextOption();

		/**
		 * The meta object literal for the '<em><b>Default Text Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION = eINSTANCE.getLayoutOptions_DefaultTextOption();

		/**
		 * The meta object literal for the '<em><b>Section Text Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__SECTION_TEXT_OPTION = eINSTANCE.getLayoutOptions_SectionTextOption();

		/**
		 * The meta object literal for the '<em><b>Hide Annotations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_ANNOTATIONS = eINSTANCE.getLayoutOptions_HideAnnotations();

		/**
		 * The meta object literal for the '<em><b>Hide Attachments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_ATTACHMENTS = eINSTANCE.getLayoutOptions_HideAttachments();

		/**
		 * The meta object literal for the '<em><b>Hide Incoming Document References</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES = eINSTANCE.getLayoutOptions_HideIncomingDocumentReferences();

		/**
		 * The meta object literal for the '<em><b>Page Numbering Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__PAGE_NUMBERING_STYLE = eINSTANCE.getLayoutOptions_PageNumberingStyle();

		/**
		 * The meta object literal for the '<em><b>Hide Model Element Images</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES = eINSTANCE.getLayoutOptions_HideModelElementImages();

		/**
		 * The meta object literal for the '<em><b>Model Element Text Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION = eINSTANCE.getLayoutOptions_ModelElementTextOption();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.ListOptionImpl <em>List Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.ListOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getListOption()
		 * @generated
		 */
		EClass LIST_OPTION = eINSTANCE.getListOption();

		/**
		 * The meta object literal for the '<em><b>List Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST_OPTION__LIST_STYLE = eINSTANCE.getListOption_ListStyle();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl <em>Text Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.TextOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getTextOption()
		 * @generated
		 */
		EClass TEXT_OPTION = eINSTANCE.getTextOption();

		/**
		 * The meta object literal for the '<em><b>Font Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_OPTION__FONT_FAMILY = eINSTANCE.getTextOption_FontFamily();

		/**
		 * The meta object literal for the '<em><b>Font Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_OPTION__FONT_SIZE = eINSTANCE.getTextOption_FontSize();

		/**
		 * The meta object literal for the '<em><b>Font Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_OPTION__FONT_COLOR = eINSTANCE.getTextOption_FontColor();

		/**
		 * The meta object literal for the '<em><b>Bold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_OPTION__BOLD = eINSTANCE.getTextOption_Bold();

		/**
		 * The meta object literal for the '<em><b>Underline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_OPTION__UNDERLINE = eINSTANCE.getTextOption_Underline();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl <em>Reference Attribute Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getReferenceAttributeOption()
		 * @generated
		 */
		EClass REFERENCE_ATTRIBUTE_OPTION = eINSTANCE.getReferenceAttributeOption();

		/**
		 * The meta object literal for the '<em><b>Contained</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_ATTRIBUTE_OPTION__CONTAINED = eINSTANCE.getReferenceAttributeOption_Contained();

		/**
		 * The meta object literal for the '<em><b>Reference Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION = eINSTANCE.getReferenceAttributeOption_ReferenceOption();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.impl.UColorImpl <em>UColor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.UColorImpl
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getUColor()
		 * @generated
		 */
		EClass UCOLOR = eINSTANCE.getUColor();

		/**
		 * The meta object literal for the '<em><b>Red</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UCOLOR__RED = eINSTANCE.getUColor_Red();

		/**
		 * The meta object literal for the '<em><b>Green</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UCOLOR__GREEN = eINSTANCE.getUColor_Green();

		/**
		 * The meta object literal for the '<em><b>Blue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UCOLOR__BLUE = eINSTANCE.getUColor_Blue();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.FontFamily <em>Font Family</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.FontFamily
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getFontFamily()
		 * @generated
		 */
		EEnum FONT_FAMILY = eINSTANCE.getFontFamily();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.ListStyle <em>List Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.ListStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getListStyle()
		 * @generated
		 */
		EEnum LIST_STYLE = eINSTANCE.getListStyle();

		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle <em>Page Numbering Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle
		 * @see org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl#getPageNumberingStyle()
		 * @generated
		 */
		EEnum PAGE_NUMBERING_STYLE = eINSTANCE.getPageNumberingStyle();

	}

} //OptionsPackage
