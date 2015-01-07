/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.docExport.exportModel.ExportModelPackage;
import org.unicase.docExport.exportModel.impl.ExportModelPackageImpl;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.options.AppendixStyle;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.BooleanStyle;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.DateAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.DateStyle;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.HeaderStyle;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.PageCitationStyle;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.SectionOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.docExport.exportModel.renderers.options.UColor;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class OptionsPackageImpl extends EPackageImpl implements OptionsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rendererOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleReferenceAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiReferenceAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutOptionsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uColorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boxModelOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sectionOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dateAttributeOptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum pageCitationStyleEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum headerStyleEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum appendixStyleEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fontFamilyEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum listStyleEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum uBorderStyleEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sectionNumberingStyleEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum textAlignEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum booleanStyleEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dateStyleEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OptionsPackageImpl() {
		super(eNS_URI, OptionsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OptionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OptionsPackage init() {
		if (isInited) return (OptionsPackage)EPackage.Registry.INSTANCE.getEPackage(OptionsPackage.eNS_URI);

		// Obtain or create and register package
		OptionsPackageImpl theOptionsPackage = (OptionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OptionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OptionsPackageImpl());

		isInited = true;

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

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OptionsPackage.eNS_URI, theOptionsPackage);
		return theOptionsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRendererOption() {
		return rendererOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRendererOption_Name() {
		return (EAttribute)rendererOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeOption() {
		return attributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOption_Hide() {
		return (EAttribute)attributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOption_OverwriteGlobalOption() {
		return (EAttribute)attributeOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOption_AttributeText() {
		return (EAttribute)attributeOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOption_OrderNumber() {
		return (EAttribute)attributeOptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleReferenceAttributeOption() {
		return singleReferenceAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiReferenceAttributeOption() {
		return multiReferenceAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiReferenceAttributeOption_ListOption() {
		return (EReference)multiReferenceAttributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceOption() {
		return referenceOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringAttributeOption() {
		return stringAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayoutOptions() {
		return layoutOptionsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_HeaderTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_DefaultTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_SectionTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideAnnotations() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideAttachments() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideIncomingDocumentReferences() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideModelElementImages() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_ModelElementTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HeaderText() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_FooterText() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_SectionOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_SectionFontSizeDecreaseStep() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_DocumentTitleTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_ShowModelElementTypeInSectionTitle() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_AppendixStyle() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_LogoImage() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_FooterTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_FooterShowDocumentTitle() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_PageCitationStyle() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HeaderStyle() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_LogoWidth() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_LogoHeight() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_LogoOnCoverPage() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutOptions_TableOfContentsTextOption() {
		return (EReference)layoutOptionsEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideTableOfContents() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayoutOptions_HideHeaderAndFooterOnCoverPage() {
		return (EAttribute)layoutOptionsEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListOption() {
		return listOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getListOption_ListStyle() {
		return (EAttribute)listOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextOption() {
		return textOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_FontFamily() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_FontSize() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextOption_FontColor() {
		return (EReference)textOptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_TextAlign() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_Italics() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_Bold() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextOption_Underline() {
		return (EAttribute)textOptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceAttributeOption() {
		return referenceAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceAttributeOption_Contained() {
		return (EAttribute)referenceAttributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceAttributeOption_ReferenceOption() {
		return (EReference)referenceAttributeOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUColor() {
		return uColorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUColor_Red() {
		return (EAttribute)uColorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUColor_Green() {
		return (EAttribute)uColorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUColor_Blue() {
		return (EAttribute)uColorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoxModelOption() {
		return boxModelOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_Margin() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_MarginTop() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_MarginLeft() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_MarginBottom() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_MarginRight() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_Border() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_BorderTop() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_BorderLeft() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_BorderBottom() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_BorderRight() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_BorderStyle() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoxModelOption_BorderColor() {
		return (EReference)boxModelOptionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_Padding() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_PaddingTop() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_PaddingLeft() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_PaddingBottom() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_PaddingRight() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoxModelOption_BackgroundColor() {
		return (EReference)boxModelOptionEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_KeepTogether() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_KeepWithPrevious() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_KeepWithNext() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_BreakBefore() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_Width() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoxModelOption_BreakAfter() {
		return (EAttribute)boxModelOptionEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSectionOption() {
		return sectionOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSectionOption_SectionNumberingStyle() {
		return (EAttribute)sectionOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSectionOption_LeaveOutPreviousSectionNumbering() {
		return (EAttribute)sectionOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanAttributeOption() {
		return booleanAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanAttributeOption_BooleanStyle() {
		return (EAttribute)booleanAttributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDateAttributeOption() {
		return dateAttributeOptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDateAttributeOption_DateStyle() {
		return (EAttribute)dateAttributeOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPageCitationStyle() {
		return pageCitationStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHeaderStyle() {
		return headerStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAppendixStyle() {
		return appendixStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFontFamily() {
		return fontFamilyEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getListStyle() {
		return listStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUBorderStyle() {
		return uBorderStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSectionNumberingStyle() {
		return sectionNumberingStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTextAlign() {
		return textAlignEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBooleanStyle() {
		return booleanStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDateStyle() {
		return dateStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OptionsFactory getOptionsFactory() {
		return (OptionsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		createEAttribute(attributeOptionEClass, ATTRIBUTE_OPTION__ATTRIBUTE_TEXT);
		createEAttribute(attributeOptionEClass, ATTRIBUTE_OPTION__ORDER_NUMBER);

		singleReferenceAttributeOptionEClass = createEClass(SINGLE_REFERENCE_ATTRIBUTE_OPTION);

		multiReferenceAttributeOptionEClass = createEClass(MULTI_REFERENCE_ATTRIBUTE_OPTION);
		createEReference(multiReferenceAttributeOptionEClass, MULTI_REFERENCE_ATTRIBUTE_OPTION__LIST_OPTION);

		referenceOptionEClass = createEClass(REFERENCE_OPTION);

		stringAttributeOptionEClass = createEClass(STRING_ATTRIBUTE_OPTION);

		layoutOptionsEClass = createEClass(LAYOUT_OPTIONS);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__HEADER_TEXT_OPTION);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__SECTION_TEXT_OPTION);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_ANNOTATIONS);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_ATTACHMENTS);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HEADER_TEXT);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__FOOTER_TEXT);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__SECTION_OPTION);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__APPENDIX_STYLE);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__LOGO_IMAGE);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__FOOTER_TEXT_OPTION);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__PAGE_CITATION_STYLE);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HEADER_STYLE);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__LOGO_WIDTH);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__LOGO_HEIGHT);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE);
		createEReference(layoutOptionsEClass, LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS);
		createEAttribute(layoutOptionsEClass, LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE);

		listOptionEClass = createEClass(LIST_OPTION);
		createEAttribute(listOptionEClass, LIST_OPTION__LIST_STYLE);

		textOptionEClass = createEClass(TEXT_OPTION);
		createEAttribute(textOptionEClass, TEXT_OPTION__FONT_FAMILY);
		createEAttribute(textOptionEClass, TEXT_OPTION__FONT_SIZE);
		createEAttribute(textOptionEClass, TEXT_OPTION__BOLD);
		createEAttribute(textOptionEClass, TEXT_OPTION__UNDERLINE);
		createEReference(textOptionEClass, TEXT_OPTION__FONT_COLOR);
		createEAttribute(textOptionEClass, TEXT_OPTION__TEXT_ALIGN);
		createEAttribute(textOptionEClass, TEXT_OPTION__ITALICS);

		referenceAttributeOptionEClass = createEClass(REFERENCE_ATTRIBUTE_OPTION);
		createEAttribute(referenceAttributeOptionEClass, REFERENCE_ATTRIBUTE_OPTION__CONTAINED);
		createEReference(referenceAttributeOptionEClass, REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION);

		uColorEClass = createEClass(UCOLOR);
		createEAttribute(uColorEClass, UCOLOR__RED);
		createEAttribute(uColorEClass, UCOLOR__GREEN);
		createEAttribute(uColorEClass, UCOLOR__BLUE);

		boxModelOptionEClass = createEClass(BOX_MODEL_OPTION);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__MARGIN);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__MARGIN_TOP);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__MARGIN_LEFT);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__MARGIN_BOTTOM);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__MARGIN_RIGHT);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__BORDER);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__BORDER_TOP);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__BORDER_LEFT);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__BORDER_BOTTOM);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__BORDER_RIGHT);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__BORDER_STYLE);
		createEReference(boxModelOptionEClass, BOX_MODEL_OPTION__BORDER_COLOR);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__PADDING);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__PADDING_TOP);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__PADDING_LEFT);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__PADDING_BOTTOM);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__PADDING_RIGHT);
		createEReference(boxModelOptionEClass, BOX_MODEL_OPTION__BACKGROUND_COLOR);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__KEEP_TOGETHER);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__KEEP_WITH_NEXT);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__BREAK_BEFORE);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__WIDTH);
		createEAttribute(boxModelOptionEClass, BOX_MODEL_OPTION__BREAK_AFTER);

		sectionOptionEClass = createEClass(SECTION_OPTION);
		createEAttribute(sectionOptionEClass, SECTION_OPTION__SECTION_NUMBERING_STYLE);
		createEAttribute(sectionOptionEClass, SECTION_OPTION__LEAVE_OUT_PREVIOUS_SECTION_NUMBERING);

		booleanAttributeOptionEClass = createEClass(BOOLEAN_ATTRIBUTE_OPTION);
		createEAttribute(booleanAttributeOptionEClass, BOOLEAN_ATTRIBUTE_OPTION__BOOLEAN_STYLE);

		dateAttributeOptionEClass = createEClass(DATE_ATTRIBUTE_OPTION);
		createEAttribute(dateAttributeOptionEClass, DATE_ATTRIBUTE_OPTION__DATE_STYLE);

		// Create enums
		pageCitationStyleEEnum = createEEnum(PAGE_CITATION_STYLE);
		headerStyleEEnum = createEEnum(HEADER_STYLE);
		appendixStyleEEnum = createEEnum(APPENDIX_STYLE);
		fontFamilyEEnum = createEEnum(FONT_FAMILY);
		listStyleEEnum = createEEnum(LIST_STYLE);
		uBorderStyleEEnum = createEEnum(UBORDER_STYLE);
		sectionNumberingStyleEEnum = createEEnum(SECTION_NUMBERING_STYLE);
		textAlignEEnum = createEEnum(TEXT_ALIGN);
		booleanStyleEEnum = createEEnum(BOOLEAN_STYLE);
		dateStyleEEnum = createEEnum(DATE_STYLE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

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
		boxModelOptionEClass.getESuperTypes().add(this.getRendererOption());
		sectionOptionEClass.getESuperTypes().add(this.getRendererOption());
		booleanAttributeOptionEClass.getESuperTypes().add(this.getAttributeOption());
		dateAttributeOptionEClass.getESuperTypes().add(this.getAttributeOption());

		// Initialize classes and features; add operations and parameters
		initEClass(rendererOptionEClass, RendererOption.class, "RendererOption", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRendererOption_Name(), ecorePackage.getEString(), "name", null, 0, 1, RendererOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeOptionEClass, AttributeOption.class, "AttributeOption", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeOption_Hide(), ecorePackage.getEBoolean(), "hide", "false", 0, 1, AttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeOption_OverwriteGlobalOption(), ecorePackage.getEBoolean(), "overwriteGlobalOption", "false", 0, 1, AttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeOption_AttributeText(), ecorePackage.getEString(), "attributeText", null, 0, 1, AttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeOption_OrderNumber(), ecorePackage.getEInt(), "orderNumber", null, 0, 1, AttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleReferenceAttributeOptionEClass, SingleReferenceAttributeOption.class, "SingleReferenceAttributeOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multiReferenceAttributeOptionEClass, MultiReferenceAttributeOption.class, "MultiReferenceAttributeOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiReferenceAttributeOption_ListOption(), this.getListOption(), null, "listOption", null, 0, 1, MultiReferenceAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceOptionEClass, ReferenceOption.class, "ReferenceOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringAttributeOptionEClass, StringAttributeOption.class, "StringAttributeOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(layoutOptionsEClass, LayoutOptions.class, "LayoutOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayoutOptions_HeaderTextOption(), this.getTextOption(), null, "headerTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_DefaultTextOption(), this.getTextOption(), null, "defaultTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_SectionTextOption(), this.getTextOption(), null, "sectionTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideAnnotations(), ecorePackage.getEBoolean(), "hideAnnotations", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideAttachments(), ecorePackage.getEBoolean(), "hideAttachments", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideIncomingDocumentReferences(), ecorePackage.getEBoolean(), "hideIncomingDocumentReferences", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideModelElementImages(), ecorePackage.getEBoolean(), "hideModelElementImages", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_ModelElementTextOption(), this.getTextOption(), null, "modelElementTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HeaderText(), ecorePackage.getEString(), "headerText", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_FooterText(), ecorePackage.getEString(), "footerText", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_SectionOption(), this.getSectionOption(), null, "sectionOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_SectionFontSizeDecreaseStep(), ecorePackage.getEInt(), "sectionFontSizeDecreaseStep", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_DocumentTitleTextOption(), this.getTextOption(), null, "documentTitleTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_ShowModelElementTypeInSectionTitle(), ecorePackage.getEBoolean(), "showModelElementTypeInSectionTitle", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_AppendixStyle(), this.getAppendixStyle(), "appendixStyle", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_LogoImage(), ecorePackage.getEString(), "logoImage", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_FooterTextOption(), this.getTextOption(), null, "footerTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_FooterShowDocumentTitle(), ecorePackage.getEBoolean(), "footerShowDocumentTitle", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_PageCitationStyle(), this.getPageCitationStyle(), "pageCitationStyle", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HeaderStyle(), this.getHeaderStyle(), "headerStyle", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_LogoWidth(), ecorePackage.getEInt(), "logoWidth", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_LogoHeight(), ecorePackage.getEInt(), "logoHeight", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_LogoOnCoverPage(), ecorePackage.getEBoolean(), "logoOnCoverPage", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayoutOptions_TableOfContentsTextOption(), this.getTextOption(), null, "tableOfContentsTextOption", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideTableOfContents(), ecorePackage.getEBoolean(), "hideTableOfContents", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayoutOptions_HideHeaderAndFooterOnCoverPage(), ecorePackage.getEBoolean(), "hideHeaderAndFooterOnCoverPage", null, 0, 1, LayoutOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listOptionEClass, ListOption.class, "ListOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getListOption_ListStyle(), this.getListStyle(), "listStyle", null, 0, 1, ListOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textOptionEClass, TextOption.class, "TextOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextOption_FontFamily(), this.getFontFamily(), "fontFamily", null, 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextOption_FontSize(), ecorePackage.getEInt(), "fontSize", "12", 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextOption_Bold(), ecorePackage.getEBoolean(), "bold", null, 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextOption_Underline(), ecorePackage.getEBoolean(), "underline", null, 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextOption_FontColor(), this.getUColor(), null, "fontColor", null, 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextOption_TextAlign(), this.getTextAlign(), "textAlign", null, 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextOption_Italics(), ecorePackage.getEBoolean(), "italics", null, 0, 1, TextOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceAttributeOptionEClass, ReferenceAttributeOption.class, "ReferenceAttributeOption", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceAttributeOption_Contained(), ecorePackage.getEBoolean(), "contained", null, 0, 1, ReferenceAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceAttributeOption_ReferenceOption(), this.getReferenceOption(), null, "referenceOption", null, 0, 1, ReferenceAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uColorEClass, UColor.class, "UColor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUColor_Red(), ecorePackage.getEInt(), "red", null, 0, 1, UColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUColor_Green(), ecorePackage.getEInt(), "green", null, 0, 1, UColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUColor_Blue(), ecorePackage.getEInt(), "blue", null, 0, 1, UColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boxModelOptionEClass, BoxModelOption.class, "BoxModelOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoxModelOption_Margin(), ecorePackage.getEDouble(), "margin", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_MarginTop(), ecorePackage.getEDouble(), "marginTop", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_MarginLeft(), ecorePackage.getEDouble(), "marginLeft", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_MarginBottom(), ecorePackage.getEDouble(), "marginBottom", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_MarginRight(), ecorePackage.getEDouble(), "marginRight", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_Border(), ecorePackage.getEDouble(), "border", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_BorderTop(), ecorePackage.getEDouble(), "borderTop", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_BorderLeft(), ecorePackage.getEDouble(), "borderLeft", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_BorderBottom(), ecorePackage.getEDouble(), "borderBottom", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_BorderRight(), ecorePackage.getEDouble(), "borderRight", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_BorderStyle(), this.getUBorderStyle(), "borderStyle", null, 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoxModelOption_BorderColor(), this.getUColor(), null, "borderColor", null, 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_Padding(), ecorePackage.getEDouble(), "padding", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_PaddingTop(), ecorePackage.getEDouble(), "paddingTop", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_PaddingLeft(), ecorePackage.getEDouble(), "paddingLeft", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_PaddingBottom(), ecorePackage.getEDouble(), "paddingBottom", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_PaddingRight(), ecorePackage.getEDouble(), "paddingRight", "0", 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoxModelOption_BackgroundColor(), this.getUColor(), null, "backgroundColor", null, 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_KeepTogether(), ecorePackage.getEBoolean(), "keepTogether", null, 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_KeepWithPrevious(), ecorePackage.getEBoolean(), "keepWithPrevious", null, 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_KeepWithNext(), ecorePackage.getEBoolean(), "keepWithNext", null, 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_BreakBefore(), ecorePackage.getEBoolean(), "breakBefore", null, 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_Width(), ecorePackage.getEInt(), "width", null, 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoxModelOption_BreakAfter(), ecorePackage.getEBoolean(), "breakAfter", null, 0, 1, BoxModelOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sectionOptionEClass, SectionOption.class, "SectionOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSectionOption_SectionNumberingStyle(), this.getSectionNumberingStyle(), "sectionNumberingStyle", null, 0, 1, SectionOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSectionOption_LeaveOutPreviousSectionNumbering(), ecorePackage.getEBoolean(), "leaveOutPreviousSectionNumbering", null, 0, 1, SectionOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanAttributeOptionEClass, BooleanAttributeOption.class, "BooleanAttributeOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanAttributeOption_BooleanStyle(), this.getBooleanStyle(), "booleanStyle", null, 0, 1, BooleanAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dateAttributeOptionEClass, DateAttributeOption.class, "DateAttributeOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDateAttributeOption_DateStyle(), this.getDateStyle(), "dateStyle", null, 0, 1, DateAttributeOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(pageCitationStyleEEnum, PageCitationStyle.class, "PageCitationStyle");
		addEEnumLiteral(pageCitationStyleEEnum, PageCitationStyle.PAGE);
		addEEnumLiteral(pageCitationStyleEEnum, PageCitationStyle.EMPTY);
		addEEnumLiteral(pageCitationStyleEEnum, PageCitationStyle.PAGE_AND_LAST_PAGE);

		initEEnum(headerStyleEEnum, HeaderStyle.class, "HeaderStyle");
		addEEnumLiteral(headerStyleEEnum, HeaderStyle.ONLY_TEXT);
		addEEnumLiteral(headerStyleEEnum, HeaderStyle.TEXT_AND_LOGO);

		initEEnum(appendixStyleEEnum, AppendixStyle.class, "AppendixStyle");
		addEEnumLiteral(appendixStyleEEnum, AppendixStyle.HIDE);
		addEEnumLiteral(appendixStyleEEnum, AppendixStyle.SHOW_FLAT);
		addEEnumLiteral(appendixStyleEEnum, AppendixStyle.SHOW_RECURSIVE);

		initEEnum(fontFamilyEEnum, FontFamily.class, "FontFamily");
		addEEnumLiteral(fontFamilyEEnum, FontFamily.SANS_SERIF);
		addEEnumLiteral(fontFamilyEEnum, FontFamily.SERIF);
		addEEnumLiteral(fontFamilyEEnum, FontFamily.TIMES_NEW_ROMAN);
		addEEnumLiteral(fontFamilyEEnum, FontFamily.HELVETICA);
		addEEnumLiteral(fontFamilyEEnum, FontFamily.COURIER);

		initEEnum(listStyleEEnum, ListStyle.class, "ListStyle");
		addEEnumLiteral(listStyleEEnum, ListStyle.BULLETED);
		addEEnumLiteral(listStyleEEnum, ListStyle.JUST_NEW_LINES);
		addEEnumLiteral(listStyleEEnum, ListStyle.SEPERATED_LIST);
		addEEnumLiteral(listStyleEEnum, ListStyle.NUMBERED);
		addEEnumLiteral(listStyleEEnum, ListStyle.ALPHA);
		addEEnumLiteral(listStyleEEnum, ListStyle.TABLE);

		initEEnum(uBorderStyleEEnum, UBorderStyle.class, "UBorderStyle");
		addEEnumLiteral(uBorderStyleEEnum, UBorderStyle.HIDDEN);
		addEEnumLiteral(uBorderStyleEEnum, UBorderStyle.DOTTED);
		addEEnumLiteral(uBorderStyleEEnum, UBorderStyle.DASHED);
		addEEnumLiteral(uBorderStyleEEnum, UBorderStyle.DOUBLE);
		addEEnumLiteral(uBorderStyleEEnum, UBorderStyle.GROOVE);
		addEEnumLiteral(uBorderStyleEEnum, UBorderStyle.RIDGE);
		addEEnumLiteral(uBorderStyleEEnum, UBorderStyle.INSET);
		addEEnumLiteral(uBorderStyleEEnum, UBorderStyle.OUTSET);
		addEEnumLiteral(uBorderStyleEEnum, UBorderStyle.SOLID);

		initEEnum(sectionNumberingStyleEEnum, SectionNumberingStyle.class, "SectionNumberingStyle");
		addEEnumLiteral(sectionNumberingStyleEEnum, SectionNumberingStyle.NUMERICAL);
		addEEnumLiteral(sectionNumberingStyleEEnum, SectionNumberingStyle.ALPHA);
		addEEnumLiteral(sectionNumberingStyleEEnum, SectionNumberingStyle.ROMAN);
		addEEnumLiteral(sectionNumberingStyleEEnum, SectionNumberingStyle.NONE);

		initEEnum(textAlignEEnum, TextAlign.class, "TextAlign");
		addEEnumLiteral(textAlignEEnum, TextAlign.START);
		addEEnumLiteral(textAlignEEnum, TextAlign.CENTER);
		addEEnumLiteral(textAlignEEnum, TextAlign.END);
		addEEnumLiteral(textAlignEEnum, TextAlign.JUSTIFY);

		initEEnum(booleanStyleEEnum, BooleanStyle.class, "BooleanStyle");
		addEEnumLiteral(booleanStyleEEnum, BooleanStyle.IMAGE);
		addEEnumLiteral(booleanStyleEEnum, BooleanStyle.YES_NO);
		addEEnumLiteral(booleanStyleEEnum, BooleanStyle.TRUE_FALSE);
		addEEnumLiteral(booleanStyleEEnum, BooleanStyle.NUMBERS);

		initEEnum(dateStyleEEnum, DateStyle.class, "DateStyle");
		addEEnumLiteral(dateStyleEEnum, DateStyle.NICE1);
		addEEnumLiteral(dateStyleEEnum, DateStyle.FULL);
		addEEnumLiteral(dateStyleEEnum, DateStyle.NUMERIC_TIME_WITH_SECONDS);
		addEEnumLiteral(dateStyleEEnum, DateStyle.NUMERIC_TIME);
		addEEnumLiteral(dateStyleEEnum, DateStyle.NUMERIC_DAY);
		addEEnumLiteral(dateStyleEEnum, DateStyle.NUMERIC_MONTH);
		addEEnumLiteral(dateStyleEEnum, DateStyle.NUMERIC_YEAR);
	}

} // OptionsPackageImpl
