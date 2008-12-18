/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.docExport.exportModel.ExportModelPackage;
import org.unicase.docExport.exportModel.impl.ExportModelPackageImpl;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UColor;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl;









/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OptionsPackageImpl extends EPackageImpl implements OptionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rendererOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleReferenceAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiReferenceAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutOptionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uColorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fontFamilyEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum listStyleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum pageNumberingStyleEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OptionsPackageImpl() {
		super(eNS_URI, OptionsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OptionsPackage init() {
		if (isInited) return (OptionsPackage)EPackage.Registry.INSTANCE.getEPackage(OptionsPackage.eNS_URI);

		// Obtain or create and register package
		OptionsPackageImpl theOptionsPackage = (OptionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof OptionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new OptionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ExportModelPackageImpl theExportModelPackage = (ExportModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExportModelPackage.eNS_URI) instanceof ExportModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExportModelPackage.eNS_URI) : ExportModelPackage.eINSTANCE);
		RenderersPackageImpl theRenderersPackage = (RenderersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RenderersPackage.eNS_URI) instanceof RenderersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RenderersPackage.eNS_URI) : RenderersPackage.eINSTANCE);
		DefaultRenderersPackageImpl theDefaultRenderersPackage = (DefaultRenderersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DefaultRenderersPackage.eNS_URI) instanceof DefaultRenderersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DefaultRenderersPackage.eNS_URI) : DefaultRenderersPackage.eINSTANCE);
		SpecialRenderersPackageImpl theSpecialRenderersPackage = (SpecialRenderersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SpecialRenderersPackage.eNS_URI) instanceof SpecialRenderersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SpecialRenderersPackage.eNS_URI) : SpecialRenderersPackage.eINSTANCE);

		// Create package meta-data objects
		theOptionsPackage.createPackageContents();
		theExportModelPackage.createPackageContents();
		theRenderersPackage.createPackageContents();
		theDefaultRenderersPackage.createPackageContents();
		theSpecialRenderersPackage.createPackageContents();

		// Initialize created meta-data
		theOptionsPackage.initializePackageContents();
		theExportModelPackage.initializePackageContents();
		theRenderersPackage.initializePackageContents();
		theDefaultRenderersPackage.initializePackageContents();
		theSpecialRenderersPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOptionsPackage.freeze();

		return theOptionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRendererOption() {
		return rendererOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRendererOption_Name() {
		return (EAttribute)rendererOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeOption() {
		return attributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOption_Hide() {
		return (EAttribute)attributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOption_OverwriteGlobalOption() {
		return (EAttribute)attributeOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleReferenceAttributeOption() {
		return singleReferenceAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceAttributeOption_GlobalOption() {
		return (EReference)singleReferenceAttributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiReferenceAttributeOption() {
		return multiReferenceAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiReferenceAttributeOption_GlobalOption() {
		return (EReference)multiReferenceAttributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiReferenceAttributeOption_ListOption() {
		return (EReference)multiReferenceAttributeOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceOption() {
		return referenceOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceOption_TextOption() {
		return (EReference)referenceOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringAttributeOption() {
		return stringAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringAttributeOption_GlobalOption() {
		return (EReference)stringAttributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringAttributeOption_TextOption() {
		return (EReference)stringAttributeOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayoutOptions() {
		return layoutOptionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_CoverText() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_CoverTextTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_DefaultTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_SectionTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideAnnotations() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideAttachments() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideIncomingDocumentReferences() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_PageNumberingStyle() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideModelElementImages() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_ModelElementTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListOption() {
		return listOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getListOption_ListStyle() {
		return (EAttribute)listOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextOption() {
		return textOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_FontFamily() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_FontSize() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextOption_FontColor() {
		return (EReference)textOptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_Bold() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_Underline() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceAttributeOption() {
		return referenceAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceAttributeOption_Contained() {
		return (EAttribute)referenceAttributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceAttributeOption_ReferenceOption() {
		return (EReference)referenceAttributeOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUColor() {
		return uColorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUColor_Red() {
		return (EAttribute)uColorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUColor_Green() {
		return (EAttribute)uColorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUColor_Blue() {
		return (EAttribute)uColorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFontFamily() {
		return fontFamilyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getListStyle() {
		return listStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPageNumberingStyle() {
		return pageNumberingStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionsFactory getOptionsFactory() {
		return (OptionsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		rendererOptionEClass = createEClass(RENDERER_OPTION);
		createEAttribute(rendererOptionEClass, RENDERER_OPTION__NAME);

		attributeOptionEClass = createEClass(ATTRIBUTE_OPTION);
		createEAttribute(attributeOptionEClass, ATTRIBUTE_OPTION__HIDE);
		createEAttribute(attributeOptionEClass, ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION);

		singleReferenceAttributeOptionEClass = createEClass(SINGLE_REFERENCE_ATTRIBUTE_OPTION);
		createEReference(singleReferenceAttributeOptionEClass, SINGLE_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION);

		multiReferenceAttributeOptionEClass = createEClass(MULTI_REFERENCE_ATTRIBUTE_OPTION);
		createEReference(multiReferenceAttributeOptionEClass, MULTI_REFERENCE_ATTRIBUTE_OPTION__GLOBAL_OPTION);
		createEReference(multiReferenceAttributeOptionEClass, MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION);

		referenceOptionEClass = createEClass(REFERENCE_OPTION);
		createEReference(referenceOptionEClass, REFERENCE_OPTION__TEXT_OPTION);

		stringAttributeOptionEClass = createEClass(STRING_ATTRIBUTE_OPTION);
		createEReference(stringAttributeOptionEClass, STRING_ATTRIBUTE_OPTION__GLOBAL_OPTION);
		createEReference(stringAttributeOptionEClass, STRING_ATTRIBUTE_OPTION__TEXT_OPTION);

		layoutOptionsEClass = createEClass(LAYOUT_OPTIONS);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__COVER_TEXT);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__COVER_TEXT_TEXT_OPTION);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__SECTION_TEXT_OPTION);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_ANNOTATIONS);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_ATTACHMENTS);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__PAGE_NUMBERING_STYLE);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION);

		listOptionEClass = createEClass(LIST_OPTION);
		createEAttribute(listOptionEClass, LIST_OPTION__LIST_STYLE);

		textOptionEClass = createEClass(TEXT_OPTION);
		createEAttribute(textOptionEClass, TEXT_OPTION__FONT_FAMILY);
		createEAttribute(textOptionEClass, TEXT_OPTION__FONT_SIZE);
		createEAttribute(textOptionEClass, TEXT_OPTION__BOLD);
		createEAttribute(textOptionEClass, TEXT_OPTION__UNDERLINE);
		createEReference(textOptionEClass, TEXT_OPTION__FONT_COLOR);

		referenceAttributeOptionEClass = createEClass(REFERENCE_ATTRIBUTE_OPTION);
		createEAttribute(referenceAttributeOptionEClass, REFERENCE_ATTRIBUTE_OPTION__CONTAINED);
		createEReference(referenceAttributeOptionEClass, REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION);

		uColorEClass = createEClass(UCOLOR);
		createEAttribute(uColorEClass, UCOLOR__RED);
		createEAttribute(uColorEClass, UCOLOR__GREEN);
		createEAttribute(uColorEClass, UCOLOR__BLUE);

		// Create enums
		fontFamilyEEnum = createEEnum(FONT_FAMILY);
		listStyleEEnum = createEEnum(LIST_STYLE);
		pageNumberingStyleEEnum = createEEnum(PAGE_NUMBERING_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		attributeOptionEClass.getESuperTypes().add(this.getRendererOption());
		singleReferenceAttributeOptionEClass.getESuperTypes().add(this.getReferenceAttributeOption());
		multiReferenceAttributeOptionEClass.getESuperTypes().add(this.getReferenceAttributeOption());
		referenceOptionEClass.getESuperTypes().add(this.getRendererOption());
		stringAttributeOptionEClass.getESuperTypes().add(this.getAttributeOption());
		layoutOptionsEClass.getESuperTypes().add(this.getRendererOption());
		listOptionEClass.getESuperTypes().add(this.getRendererOption());
		textOptionEClass.getESuperTypes().add(this.getRendererOption());
		referenceAttributeOptionEClass.getESuperTypes().add(this.getAttributeOption());
		uColorEClass.getESuperTypes().add(this.getRendererOption());

		// Initialize classes and features; add operations and parameters
		initEClass(rendererOptionEClass, RendererOption.class, "RendererOption", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRendererOption_Name(), theEcorePackage.getEString(), "name", null, 0, 1, RendererOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeOptionEClass, AttributeOption.class, "AttributeOption", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeOption_Hide(), theEcorePackage.getEBoolean(), "hide", "false", 0, 1, AttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeOption_OverwriteGlobalOption(), theEcorePackage.getEBoolean(), "overwriteGlobalOption", "false", 0, 1, AttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleReferenceAttributeOptionEClass, SingleReferenceAttributeOption.class, "SingleReferenceAttributeOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleReferenceAttributeOption_GlobalOption(), this.getSingleReferenceAttributeOption(), null, "globalOption", null, 0, 1, SingleReferenceAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiReferenceAttributeOptionEClass, MultiReferenceAttributeOption.class, "MultiReferenceAttributeOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiReferenceAttributeOption_GlobalOption(), this.getMultiReferenceAttributeOption(), null, "globalOption", null, 0, 1, MultiReferenceAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiReferenceAttributeOption_ListOption(), this.getListOption(), null, "listOption", null, 0, 1, MultiReferenceAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceOptionEClass, ReferenceOption.class, "ReferenceOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceOption_TextOption(), this.getTextOption(), null, "textOption", null, 0, 1, ReferenceOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringAttributeOptionEClass, StringAttributeOption.class, "StringAttributeOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStringAttributeOption_GlobalOption(), this.getStringAttributeOption(), null, "globalOption", null, 0, 1, StringAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringAttributeOption_TextOption(), this.getTextOption(), null, "textOption", null, 0, 1, StringAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(layoutOptionsEClass, LayoutOptions.class, "LayoutOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLayoutOptions_CoverText(), theEcorePackage.getEString(), "coverText", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_CoverTextTextOption(), this.getTextOption(), null, "coverTextTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_DefaultTextOption(), this.getTextOption(), null, "defaultTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_SectionTextOption(), this.getTextOption(), null, "sectionTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideAnnotations(), theEcorePackage.getEBoolean(), "hideAnnotations", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideAttachments(), theEcorePackage.getEBoolean(), "hideAttachments", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideIncomingDocumentReferences(), theEcorePackage.getEBoolean(), "hideIncomingDocumentReferences", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_PageNumberingStyle(), this.getPageNumberingStyle(), "pageNumberingStyle", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideModelElementImages(), theEcorePackage.getEBoolean(), "hideModelElementImages", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_ModelElementTextOption(), this.getTextOption(), null, "modelElementTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listOptionEClass, ListOption.class, "ListOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getListOption_ListStyle(), this.getListStyle(), "listStyle", null, 0, 1, ListOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textOptionEClass, TextOption.class, "TextOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextOption_FontFamily(), this.getFontFamily(), "fontFamily", "", 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextOption_FontSize(), theEcorePackage.getEInt(), "fontSize", "12", 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextOption_Bold(), theEcorePackage.getEBoolean(), "bold", null, 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextOption_Underline(), theEcorePackage.getEBoolean(), "underline", null, 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextOption_FontColor(), this.getUColor(), null, "fontColor", null, 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceAttributeOptionEClass, ReferenceAttributeOption.class, "ReferenceAttributeOption", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceAttributeOption_Contained(), theEcorePackage.getEBoolean(), "contained", null, 0, 1, ReferenceAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceAttributeOption_ReferenceOption(), this.getReferenceOption(), null, "referenceOption", null, 0, 1, ReferenceAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uColorEClass, UColor.class, "UColor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUColor_Red(), theEcorePackage.getEInt(), "red", null, 0, 1, UColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUColor_Green(), theEcorePackage.getEInt(), "green", null, 0, 1, UColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUColor_Blue(), theEcorePackage.getEInt(), "blue", null, 0, 1, UColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(fontFamilyEEnum, FontFamily.class, "FontFamily");
		addEEnumLiteral(fontFamilyEEnum, FontFamily.ARIAL);
		addEEnumLiteral(fontFamilyEEnum, FontFamily.VERDANA);
		addEEnumLiteral(fontFamilyEEnum, FontFamily.TIMES_NEW_ROMAN);
		addEEnumLiteral(fontFamilyEEnum, FontFamily.HELVETICA);

		initEEnum(listStyleEEnum, ListStyle.class, "ListStyle");
		addEEnumLiteral(listStyleEEnum, ListStyle.BULLETED);
		addEEnumLiteral(listStyleEEnum, ListStyle.JUST_NEW_LINES);
		addEEnumLiteral(listStyleEEnum, ListStyle.SEPERATED_LIST);
		addEEnumLiteral(listStyleEEnum, ListStyle.NUMBERED);
		addEEnumLiteral(listStyleEEnum, ListStyle.ALPHA);

		initEEnum(pageNumberingStyleEEnum, PageNumberingStyle.class, "PageNumberingStyle");
		addEEnumLiteral(pageNumberingStyleEEnum, PageNumberingStyle.PAGE_ONLY);
		addEEnumLiteral(pageNumberingStyleEEnum, PageNumberingStyle.PAGE_OF_PAGE_COUNT);
		addEEnumLiteral(pageNumberingStyleEEnum, PageNumberingStyle.EMPTY);
	}

} //OptionsPackageImpl
