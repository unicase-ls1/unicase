/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.docExport.exportModel.renderers.options.AppendixStyle;
import org.unicase.docExport.exportModel.renderers.options.HeaderStyle;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.PageCitationStyle;
import org.unicase.docExport.exportModel.renderers.options.SectionOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Layout Options</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getHeaderTextOption <em>Header Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getDefaultTextOption <em>Default Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getSectionTextOption <em>Section Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideAnnotations <em>Hide Annotations</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideAttachments <em>Hide Attachments</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideIncomingDocumentReferences <em>Hide Incoming Document References</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideModelElementImages <em>Hide Model Element Images</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getModelElementTextOption <em>Model Element Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getHeaderText <em>Header Text</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getFooterText <em>Footer Text</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getSectionOption <em>Section Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getSectionFontSizeDecreaseStep <em>Section Font Size Decrease Step</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getDocumentTitleTextOption <em>Document Title Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isShowModelElementTypeInSectionTitle <em>Show Model Element Type In Section Title</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getAppendixStyle <em>Appendix Style</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getLogoImage <em>Logo Image</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getFooterTextOption <em>Footer Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isFooterShowDocumentTitle <em>Footer Show Document Title</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getPageCitationStyle <em>Page Citation Style</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getHeaderStyle <em>Header Style</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getLogoWidth <em>Logo Width</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getLogoHeight <em>Logo Height</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isLogoOnCoverPage <em>Logo On Cover Page</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#getTableOfContentsTextOption <em>Table Of Contents Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideTableOfContents <em>Hide Table Of Contents</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.LayoutOptionsImpl#isHideHeaderAndFooterOnCoverPage <em>Hide Header And Footer On Cover Page</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayoutOptionsImpl extends RendererOptionImpl implements LayoutOptions {
	/**
	 * The cached value of the '{@link #getHeaderTextOption() <em>Header Text Option</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHeaderTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption headerTextOption;

	/**
	 * The cached value of the '{@link #getDefaultTextOption() <em>Default Text Option</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDefaultTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption defaultTextOption;

	/**
	 * The cached value of the '{@link #getSectionTextOption() <em>Section Text Option</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSectionTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption sectionTextOption;

	/**
	 * The default value of the '{@link #isHideAnnotations() <em>Hide Annotations</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #isHideAnnotations()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_ANNOTATIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideAnnotations() <em>Hide Annotations</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #isHideAnnotations()
	 * @generated
	 * @ordered
	 */
	protected boolean hideAnnotations = HIDE_ANNOTATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isHideAttachments() <em>Hide Attachments</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #isHideAttachments()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_ATTACHMENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideAttachments() <em>Hide Attachments</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #isHideAttachments()
	 * @generated
	 * @ordered
	 */
	protected boolean hideAttachments = HIDE_ATTACHMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isHideIncomingDocumentReferences() <em>Hide Incoming Document References</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isHideIncomingDocumentReferences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_INCOMING_DOCUMENT_REFERENCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideIncomingDocumentReferences() <em>Hide Incoming Document References</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isHideIncomingDocumentReferences()
	 * @generated
	 * @ordered
	 */
	protected boolean hideIncomingDocumentReferences = HIDE_INCOMING_DOCUMENT_REFERENCES_EDEFAULT;

	/**
	 * The default value of the '{@link #isHideModelElementImages() <em>Hide Model Element Images</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isHideModelElementImages()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_MODEL_ELEMENT_IMAGES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideModelElementImages() <em>Hide Model Element Images</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isHideModelElementImages()
	 * @generated
	 * @ordered
	 */
	protected boolean hideModelElementImages = HIDE_MODEL_ELEMENT_IMAGES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElementTextOption() <em>Model Element Text Option</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getModelElementTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption modelElementTextOption;

	/**
	 * The default value of the '{@link #getHeaderText() <em>Header Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getHeaderText()
	 * @generated
	 * @ordered
	 */
	protected static final String HEADER_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeaderText() <em>Header Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getHeaderText()
	 * @generated
	 * @ordered
	 */
	protected String headerText = HEADER_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFooterText() <em>Footer Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFooterText()
	 * @generated
	 * @ordered
	 */
	protected static final String FOOTER_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFooterText() <em>Footer Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFooterText()
	 * @generated
	 * @ordered
	 */
	protected String footerText = FOOTER_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSectionOption() <em>Section Option</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSectionOption()
	 * @generated
	 * @ordered
	 */
	protected SectionOption sectionOption;

	/**
	 * The default value of the '{@link #getSectionFontSizeDecreaseStep() <em>Section Font Size Decrease Step</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSectionFontSizeDecreaseStep()
	 * @generated
	 * @ordered
	 */
	protected static final int SECTION_FONT_SIZE_DECREASE_STEP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSectionFontSizeDecreaseStep() <em>Section Font Size Decrease Step</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSectionFontSizeDecreaseStep()
	 * @generated
	 * @ordered
	 */
	protected int sectionFontSizeDecreaseStep = SECTION_FONT_SIZE_DECREASE_STEP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDocumentTitleTextOption() <em>Document Title Text Option</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDocumentTitleTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption documentTitleTextOption;

	/**
	 * The default value of the '{@link #isShowModelElementTypeInSectionTitle() <em>Show Model Element Type In Section Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isShowModelElementTypeInSectionTitle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShowModelElementTypeInSectionTitle() <em>Show Model Element Type In Section Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isShowModelElementTypeInSectionTitle()
	 * @generated
	 * @ordered
	 */
	protected boolean showModelElementTypeInSectionTitle = SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAppendixStyle() <em>Appendix Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppendixStyle()
	 * @generated
	 * @ordered
	 */
	protected static final AppendixStyle APPENDIX_STYLE_EDEFAULT = AppendixStyle.HIDE;

	/**
	 * The cached value of the '{@link #getAppendixStyle() <em>Appendix Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppendixStyle()
	 * @generated
	 * @ordered
	 */
	protected AppendixStyle appendixStyle = APPENDIX_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogoImage() <em>Logo Image</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLogoImage()
	 * @generated
	 * @ordered
	 */
	protected static final String LOGO_IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogoImage() <em>Logo Image</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLogoImage()
	 * @generated
	 * @ordered
	 */
	protected String logoImage = LOGO_IMAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFooterTextOption() <em>Footer Text Option</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFooterTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption footerTextOption;

	/**
	 * The default value of the '{@link #isFooterShowDocumentTitle() <em>Footer Show Document Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFooterShowDocumentTitle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOOTER_SHOW_DOCUMENT_TITLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFooterShowDocumentTitle() <em>Footer Show Document Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFooterShowDocumentTitle()
	 * @generated
	 * @ordered
	 */
	protected boolean footerShowDocumentTitle = FOOTER_SHOW_DOCUMENT_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageCitationStyle() <em>Page Citation Style</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPageCitationStyle()
	 * @generated
	 * @ordered
	 */
	protected static final PageCitationStyle PAGE_CITATION_STYLE_EDEFAULT = PageCitationStyle.PAGE;

	/**
	 * The cached value of the '{@link #getPageCitationStyle() <em>Page Citation Style</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPageCitationStyle()
	 * @generated
	 * @ordered
	 */
	protected PageCitationStyle pageCitationStyle = PAGE_CITATION_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeaderStyle() <em>Header Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderStyle()
	 * @generated
	 * @ordered
	 */
	protected static final HeaderStyle HEADER_STYLE_EDEFAULT = HeaderStyle.ONLY_TEXT;

	/**
	 * The cached value of the '{@link #getHeaderStyle() <em>Header Style</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getHeaderStyle()
	 * @generated
	 * @ordered
	 */
	protected HeaderStyle headerStyle = HEADER_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogoWidth() <em>Logo Width</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLogoWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int LOGO_WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLogoWidth() <em>Logo Width</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLogoWidth()
	 * @generated
	 * @ordered
	 */
	protected int logoWidth = LOGO_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogoHeight() <em>Logo Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLogoHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int LOGO_HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLogoHeight() <em>Logo Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLogoHeight()
	 * @generated
	 * @ordered
	 */
	protected int logoHeight = LOGO_HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #isLogoOnCoverPage() <em>Logo On Cover Page</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isLogoOnCoverPage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOGO_ON_COVER_PAGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLogoOnCoverPage() <em>Logo On Cover Page</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #isLogoOnCoverPage()
	 * @generated
	 * @ordered
	 */
	protected boolean logoOnCoverPage = LOGO_ON_COVER_PAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTableOfContentsTextOption() <em>Table Of Contents Text Option</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTableOfContentsTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption tableOfContentsTextOption;

	/**
	 * The default value of the '{@link #isHideTableOfContents() <em>Hide Table Of Contents</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isHideTableOfContents()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_TABLE_OF_CONTENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideTableOfContents() <em>Hide Table Of Contents</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isHideTableOfContents()
	 * @generated
	 * @ordered
	 */
	protected boolean hideTableOfContents = HIDE_TABLE_OF_CONTENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isHideHeaderAndFooterOnCoverPage() <em>Hide Header And Footer On Cover Page</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isHideHeaderAndFooterOnCoverPage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHideHeaderAndFooterOnCoverPage() <em>Hide Header And Footer On Cover Page</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isHideHeaderAndFooterOnCoverPage()
	 * @generated
	 * @ordered
	 */
	protected boolean hideHeaderAndFooterOnCoverPage = HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected LayoutOptionsImpl() {
		super();
		headerTextOption = OptionsFactory.eINSTANCE.createTextOption();
		footerTextOption = OptionsFactory.eINSTANCE.createTextOption();
		defaultTextOption = OptionsFactory.eINSTANCE.createTextOption();
		sectionTextOption = OptionsFactory.eINSTANCE.createTextOption();
		modelElementTextOption = OptionsFactory.eINSTANCE.createTextOption();
		sectionOption = OptionsFactory.eINSTANCE.createSectionOption();
		documentTitleTextOption = OptionsFactory.eINSTANCE.createTextOption();
		tableOfContentsTextOption = OptionsFactory.eINSTANCE.createTextOption();
		footerText = "";
		headerText = "";
	}

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.LAYOUT_OPTIONS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getHeaderTextOption() {
		return headerTextOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeaderTextOption(TextOption newHeaderTextOption, NotificationChain msgs) {
		TextOption oldHeaderTextOption = headerTextOption;
		headerTextOption = newHeaderTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION, oldHeaderTextOption, newHeaderTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderTextOption(TextOption newHeaderTextOption) {
		if (newHeaderTextOption != headerTextOption) {
			NotificationChain msgs = null;
			if (headerTextOption != null)
				msgs = ((InternalEObject)headerTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION, null, msgs);
			if (newHeaderTextOption != null)
				msgs = ((InternalEObject)newHeaderTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION, null, msgs);
			msgs = basicSetHeaderTextOption(newHeaderTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION, newHeaderTextOption, newHeaderTextOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getDefaultTextOption() {
		return defaultTextOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultTextOption(TextOption newDefaultTextOption, NotificationChain msgs) {
		TextOption oldDefaultTextOption = defaultTextOption;
		defaultTextOption = newDefaultTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION, oldDefaultTextOption, newDefaultTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTextOption(TextOption newDefaultTextOption) {
		if (newDefaultTextOption != defaultTextOption) {
			NotificationChain msgs = null;
			if (defaultTextOption != null)
				msgs = ((InternalEObject)defaultTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION, null, msgs);
			if (newDefaultTextOption != null)
				msgs = ((InternalEObject)newDefaultTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION, null, msgs);
			msgs = basicSetDefaultTextOption(newDefaultTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION, newDefaultTextOption, newDefaultTextOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getSectionTextOption() {
		return sectionTextOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSectionTextOption(TextOption newSectionTextOption, NotificationChain msgs) {
		TextOption oldSectionTextOption = sectionTextOption;
		sectionTextOption = newSectionTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION, oldSectionTextOption, newSectionTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSectionTextOption(TextOption newSectionTextOption) {
		if (newSectionTextOption != sectionTextOption) {
			NotificationChain msgs = null;
			if (sectionTextOption != null)
				msgs = ((InternalEObject)sectionTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION, null, msgs);
			if (newSectionTextOption != null)
				msgs = ((InternalEObject)newSectionTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION, null, msgs);
			msgs = basicSetSectionTextOption(newSectionTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION, newSectionTextOption, newSectionTextOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideAnnotations() {
		return hideAnnotations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideAnnotations(boolean newHideAnnotations) {
		boolean oldHideAnnotations = hideAnnotations;
		hideAnnotations = newHideAnnotations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS, oldHideAnnotations, hideAnnotations));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideAttachments() {
		return hideAttachments;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideAttachments(boolean newHideAttachments) {
		boolean oldHideAttachments = hideAttachments;
		hideAttachments = newHideAttachments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS, oldHideAttachments, hideAttachments));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideIncomingDocumentReferences() {
		return hideIncomingDocumentReferences;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideIncomingDocumentReferences(boolean newHideIncomingDocumentReferences) {
		boolean oldHideIncomingDocumentReferences = hideIncomingDocumentReferences;
		hideIncomingDocumentReferences = newHideIncomingDocumentReferences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES, oldHideIncomingDocumentReferences, hideIncomingDocumentReferences));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideModelElementImages() {
		return hideModelElementImages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideModelElementImages(boolean newHideModelElementImages) {
		boolean oldHideModelElementImages = hideModelElementImages;
		hideModelElementImages = newHideModelElementImages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES, oldHideModelElementImages, hideModelElementImages));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getModelElementTextOption() {
		return modelElementTextOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElementTextOption(TextOption newModelElementTextOption, NotificationChain msgs) {
		TextOption oldModelElementTextOption = modelElementTextOption;
		modelElementTextOption = newModelElementTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION, oldModelElementTextOption, newModelElementTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementTextOption(TextOption newModelElementTextOption) {
		if (newModelElementTextOption != modelElementTextOption) {
			NotificationChain msgs = null;
			if (modelElementTextOption != null)
				msgs = ((InternalEObject)modelElementTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION, null, msgs);
			if (newModelElementTextOption != null)
				msgs = ((InternalEObject)newModelElementTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION, null, msgs);
			msgs = basicSetModelElementTextOption(newModelElementTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION, newModelElementTextOption, newModelElementTextOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeaderText() {
		return headerText;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderText(String newHeaderText) {
		String oldHeaderText = headerText;
		headerText = newHeaderText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT, oldHeaderText, headerText));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFooterText() {
		return footerText;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFooterText(String newFooterText) {
		String oldFooterText = footerText;
		footerText = newFooterText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT, oldFooterText, footerText));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SectionOption getSectionOption() {
		return sectionOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSectionOption(SectionOption newSectionOption, NotificationChain msgs) {
		SectionOption oldSectionOption = sectionOption;
		sectionOption = newSectionOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__SECTION_OPTION, oldSectionOption, newSectionOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSectionOption(SectionOption newSectionOption) {
		if (newSectionOption != sectionOption) {
			NotificationChain msgs = null;
			if (sectionOption != null)
				msgs = ((InternalEObject)sectionOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__SECTION_OPTION, null, msgs);
			if (newSectionOption != null)
				msgs = ((InternalEObject)newSectionOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__SECTION_OPTION, null, msgs);
			msgs = basicSetSectionOption(newSectionOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__SECTION_OPTION, newSectionOption, newSectionOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getSectionFontSizeDecreaseStep() {
		return sectionFontSizeDecreaseStep;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSectionFontSizeDecreaseStep(int newSectionFontSizeDecreaseStep) {
		int oldSectionFontSizeDecreaseStep = sectionFontSizeDecreaseStep;
		sectionFontSizeDecreaseStep = newSectionFontSizeDecreaseStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP, oldSectionFontSizeDecreaseStep, sectionFontSizeDecreaseStep));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getDocumentTitleTextOption() {
		return documentTitleTextOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDocumentTitleTextOption(TextOption newDocumentTitleTextOption,
		NotificationChain msgs) {
		TextOption oldDocumentTitleTextOption = documentTitleTextOption;
		documentTitleTextOption = newDocumentTitleTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION, oldDocumentTitleTextOption, newDocumentTitleTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentTitleTextOption(TextOption newDocumentTitleTextOption) {
		if (newDocumentTitleTextOption != documentTitleTextOption) {
			NotificationChain msgs = null;
			if (documentTitleTextOption != null)
				msgs = ((InternalEObject)documentTitleTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION, null, msgs);
			if (newDocumentTitleTextOption != null)
				msgs = ((InternalEObject)newDocumentTitleTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION, null, msgs);
			msgs = basicSetDocumentTitleTextOption(newDocumentTitleTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION, newDocumentTitleTextOption, newDocumentTitleTextOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowModelElementTypeInSectionTitle() {
		return showModelElementTypeInSectionTitle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowModelElementTypeInSectionTitle(boolean newShowModelElementTypeInSectionTitle) {
		boolean oldShowModelElementTypeInSectionTitle = showModelElementTypeInSectionTitle;
		showModelElementTypeInSectionTitle = newShowModelElementTypeInSectionTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE, oldShowModelElementTypeInSectionTitle, showModelElementTypeInSectionTitle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AppendixStyle getAppendixStyle() {
		return appendixStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppendixStyle(AppendixStyle newAppendixStyle) {
		AppendixStyle oldAppendixStyle = appendixStyle;
		appendixStyle = newAppendixStyle == null ? APPENDIX_STYLE_EDEFAULT : newAppendixStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__APPENDIX_STYLE, oldAppendixStyle, appendixStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogoImage() {
		return logoImage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogoImage(String newLogoImage) {
		String oldLogoImage = logoImage;
		logoImage = newLogoImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__LOGO_IMAGE, oldLogoImage, logoImage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getFooterTextOption() {
		return footerTextOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFooterTextOption(TextOption newFooterTextOption, NotificationChain msgs) {
		TextOption oldFooterTextOption = footerTextOption;
		footerTextOption = newFooterTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION, oldFooterTextOption, newFooterTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFooterTextOption(TextOption newFooterTextOption) {
		if (newFooterTextOption != footerTextOption) {
			NotificationChain msgs = null;
			if (footerTextOption != null)
				msgs = ((InternalEObject)footerTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION, null, msgs);
			if (newFooterTextOption != null)
				msgs = ((InternalEObject)newFooterTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION, null, msgs);
			msgs = basicSetFooterTextOption(newFooterTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION, newFooterTextOption, newFooterTextOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFooterShowDocumentTitle() {
		return footerShowDocumentTitle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFooterShowDocumentTitle(boolean newFooterShowDocumentTitle) {
		boolean oldFooterShowDocumentTitle = footerShowDocumentTitle;
		footerShowDocumentTitle = newFooterShowDocumentTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE, oldFooterShowDocumentTitle, footerShowDocumentTitle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PageCitationStyle getPageCitationStyle() {
		return pageCitationStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageCitationStyle(PageCitationStyle newPageCitationStyle) {
		PageCitationStyle oldPageCitationStyle = pageCitationStyle;
		pageCitationStyle = newPageCitationStyle == null ? PAGE_CITATION_STYLE_EDEFAULT : newPageCitationStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__PAGE_CITATION_STYLE, oldPageCitationStyle, pageCitationStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderStyle getHeaderStyle() {
		return headerStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderStyle(HeaderStyle newHeaderStyle) {
		HeaderStyle oldHeaderStyle = headerStyle;
		headerStyle = newHeaderStyle == null ? HEADER_STYLE_EDEFAULT : newHeaderStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HEADER_STYLE, oldHeaderStyle, headerStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getLogoWidth() {
		return logoWidth;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogoWidth(int newLogoWidth) {
		int oldLogoWidth = logoWidth;
		logoWidth = newLogoWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__LOGO_WIDTH, oldLogoWidth, logoWidth));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getLogoHeight() {
		return logoHeight;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogoHeight(int newLogoHeight) {
		int oldLogoHeight = logoHeight;
		logoHeight = newLogoHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__LOGO_HEIGHT, oldLogoHeight, logoHeight));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLogoOnCoverPage() {
		return logoOnCoverPage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogoOnCoverPage(boolean newLogoOnCoverPage) {
		boolean oldLogoOnCoverPage = logoOnCoverPage;
		logoOnCoverPage = newLogoOnCoverPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE, oldLogoOnCoverPage, logoOnCoverPage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getTableOfContentsTextOption() {
		return tableOfContentsTextOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTableOfContentsTextOption(TextOption newTableOfContentsTextOption,
		NotificationChain msgs) {
		TextOption oldTableOfContentsTextOption = tableOfContentsTextOption;
		tableOfContentsTextOption = newTableOfContentsTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION, oldTableOfContentsTextOption, newTableOfContentsTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableOfContentsTextOption(TextOption newTableOfContentsTextOption) {
		if (newTableOfContentsTextOption != tableOfContentsTextOption) {
			NotificationChain msgs = null;
			if (tableOfContentsTextOption != null)
				msgs = ((InternalEObject)tableOfContentsTextOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION, null, msgs);
			if (newTableOfContentsTextOption != null)
				msgs = ((InternalEObject)newTableOfContentsTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION, null, msgs);
			msgs = basicSetTableOfContentsTextOption(newTableOfContentsTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION, newTableOfContentsTextOption, newTableOfContentsTextOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideTableOfContents() {
		return hideTableOfContents;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideTableOfContents(boolean newHideTableOfContents) {
		boolean oldHideTableOfContents = hideTableOfContents;
		hideTableOfContents = newHideTableOfContents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS, oldHideTableOfContents, hideTableOfContents));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHideHeaderAndFooterOnCoverPage() {
		return hideHeaderAndFooterOnCoverPage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideHeaderAndFooterOnCoverPage(boolean newHideHeaderAndFooterOnCoverPage) {
		boolean oldHideHeaderAndFooterOnCoverPage = hideHeaderAndFooterOnCoverPage;
		hideHeaderAndFooterOnCoverPage = newHideHeaderAndFooterOnCoverPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE, oldHideHeaderAndFooterOnCoverPage, hideHeaderAndFooterOnCoverPage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION:
				return basicSetHeaderTextOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				return basicSetDefaultTextOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				return basicSetSectionTextOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				return basicSetModelElementTextOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_OPTION:
				return basicSetSectionOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION:
				return basicSetDocumentTitleTextOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION:
				return basicSetFooterTextOption(null, msgs);
			case OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION:
				return basicSetTableOfContentsTextOption(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION:
				return getHeaderTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				return getDefaultTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				return getSectionTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS:
				return isHideAnnotations();
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS:
				return isHideAttachments();
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES:
				return isHideIncomingDocumentReferences();
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES:
				return isHideModelElementImages();
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				return getModelElementTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT:
				return getHeaderText();
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT:
				return getFooterText();
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_OPTION:
				return getSectionOption();
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP:
				return getSectionFontSizeDecreaseStep();
			case OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION:
				return getDocumentTitleTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE:
				return isShowModelElementTypeInSectionTitle();
			case OptionsPackage.LAYOUT_OPTIONS__APPENDIX_STYLE:
				return getAppendixStyle();
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_IMAGE:
				return getLogoImage();
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION:
				return getFooterTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE:
				return isFooterShowDocumentTitle();
			case OptionsPackage.LAYOUT_OPTIONS__PAGE_CITATION_STYLE:
				return getPageCitationStyle();
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_STYLE:
				return getHeaderStyle();
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_WIDTH:
				return getLogoWidth();
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_HEIGHT:
				return getLogoHeight();
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE:
				return isLogoOnCoverPage();
			case OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION:
				return getTableOfContentsTextOption();
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS:
				return isHideTableOfContents();
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE:
				return isHideHeaderAndFooterOnCoverPage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION:
				setHeaderTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				setDefaultTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				setSectionTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS:
				setHideAnnotations((Boolean)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS:
				setHideAttachments((Boolean)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES:
				setHideIncomingDocumentReferences((Boolean)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES:
				setHideModelElementImages((Boolean)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				setModelElementTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT:
				setHeaderText((String)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT:
				setFooterText((String)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_OPTION:
				setSectionOption((SectionOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP:
				setSectionFontSizeDecreaseStep((Integer)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION:
				setDocumentTitleTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE:
				setShowModelElementTypeInSectionTitle((Boolean)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__APPENDIX_STYLE:
				setAppendixStyle((AppendixStyle)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_IMAGE:
				setLogoImage((String)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION:
				setFooterTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE:
				setFooterShowDocumentTitle((Boolean)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__PAGE_CITATION_STYLE:
				setPageCitationStyle((PageCitationStyle)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_STYLE:
				setHeaderStyle((HeaderStyle)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_WIDTH:
				setLogoWidth((Integer)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_HEIGHT:
				setLogoHeight((Integer)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE:
				setLogoOnCoverPage((Boolean)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION:
				setTableOfContentsTextOption((TextOption)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS:
				setHideTableOfContents((Boolean)newValue);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE:
				setHideHeaderAndFooterOnCoverPage((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION:
				setHeaderTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				setDefaultTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				setSectionTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS:
				setHideAnnotations(HIDE_ANNOTATIONS_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS:
				setHideAttachments(HIDE_ATTACHMENTS_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES:
				setHideIncomingDocumentReferences(HIDE_INCOMING_DOCUMENT_REFERENCES_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES:
				setHideModelElementImages(HIDE_MODEL_ELEMENT_IMAGES_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				setModelElementTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT:
				setHeaderText(HEADER_TEXT_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT:
				setFooterText(FOOTER_TEXT_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_OPTION:
				setSectionOption((SectionOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP:
				setSectionFontSizeDecreaseStep(SECTION_FONT_SIZE_DECREASE_STEP_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION:
				setDocumentTitleTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE:
				setShowModelElementTypeInSectionTitle(SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__APPENDIX_STYLE:
				setAppendixStyle(APPENDIX_STYLE_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_IMAGE:
				setLogoImage(LOGO_IMAGE_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION:
				setFooterTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE:
				setFooterShowDocumentTitle(FOOTER_SHOW_DOCUMENT_TITLE_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__PAGE_CITATION_STYLE:
				setPageCitationStyle(PAGE_CITATION_STYLE_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_STYLE:
				setHeaderStyle(HEADER_STYLE_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_WIDTH:
				setLogoWidth(LOGO_WIDTH_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_HEIGHT:
				setLogoHeight(LOGO_HEIGHT_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE:
				setLogoOnCoverPage(LOGO_ON_COVER_PAGE_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION:
				setTableOfContentsTextOption((TextOption)null);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS:
				setHideTableOfContents(HIDE_TABLE_OF_CONTENTS_EDEFAULT);
				return;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE:
				setHideHeaderAndFooterOnCoverPage(HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT_OPTION:
				return headerTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__DEFAULT_TEXT_OPTION:
				return defaultTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_TEXT_OPTION:
				return sectionTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ANNOTATIONS:
				return hideAnnotations != HIDE_ANNOTATIONS_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_ATTACHMENTS:
				return hideAttachments != HIDE_ATTACHMENTS_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_INCOMING_DOCUMENT_REFERENCES:
				return hideIncomingDocumentReferences != HIDE_INCOMING_DOCUMENT_REFERENCES_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_MODEL_ELEMENT_IMAGES:
				return hideModelElementImages != HIDE_MODEL_ELEMENT_IMAGES_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__MODEL_ELEMENT_TEXT_OPTION:
				return modelElementTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_TEXT:
				return HEADER_TEXT_EDEFAULT == null ? headerText != null : !HEADER_TEXT_EDEFAULT.equals(headerText);
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT:
				return FOOTER_TEXT_EDEFAULT == null ? footerText != null : !FOOTER_TEXT_EDEFAULT.equals(footerText);
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_OPTION:
				return sectionOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__SECTION_FONT_SIZE_DECREASE_STEP:
				return sectionFontSizeDecreaseStep != SECTION_FONT_SIZE_DECREASE_STEP_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__DOCUMENT_TITLE_TEXT_OPTION:
				return documentTitleTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE:
				return showModelElementTypeInSectionTitle != SHOW_MODEL_ELEMENT_TYPE_IN_SECTION_TITLE_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__APPENDIX_STYLE:
				return appendixStyle != APPENDIX_STYLE_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_IMAGE:
				return LOGO_IMAGE_EDEFAULT == null ? logoImage != null : !LOGO_IMAGE_EDEFAULT.equals(logoImage);
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_TEXT_OPTION:
				return footerTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__FOOTER_SHOW_DOCUMENT_TITLE:
				return footerShowDocumentTitle != FOOTER_SHOW_DOCUMENT_TITLE_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__PAGE_CITATION_STYLE:
				return pageCitationStyle != PAGE_CITATION_STYLE_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__HEADER_STYLE:
				return headerStyle != HEADER_STYLE_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_WIDTH:
				return logoWidth != LOGO_WIDTH_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_HEIGHT:
				return logoHeight != LOGO_HEIGHT_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__LOGO_ON_COVER_PAGE:
				return logoOnCoverPage != LOGO_ON_COVER_PAGE_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__TABLE_OF_CONTENTS_TEXT_OPTION:
				return tableOfContentsTextOption != null;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_TABLE_OF_CONTENTS:
				return hideTableOfContents != HIDE_TABLE_OF_CONTENTS_EDEFAULT;
			case OptionsPackage.LAYOUT_OPTIONS__HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE:
				return hideHeaderAndFooterOnCoverPage != HIDE_HEADER_AND_FOOTER_ON_COVER_PAGE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hideAnnotations: ");
		result.append(hideAnnotations);
		result.append(", hideAttachments: ");
		result.append(hideAttachments);
		result.append(", hideIncomingDocumentReferences: ");
		result.append(hideIncomingDocumentReferences);
		result.append(", hideModelElementImages: ");
		result.append(hideModelElementImages);
		result.append(", headerText: ");
		result.append(headerText);
		result.append(", footerText: ");
		result.append(footerText);
		result.append(", sectionFontSizeDecreaseStep: ");
		result.append(sectionFontSizeDecreaseStep);
		result.append(", showModelElementTypeInSectionTitle: ");
		result.append(showModelElementTypeInSectionTitle);
		result.append(", appendixStyle: ");
		result.append(appendixStyle);
		result.append(", logoImage: ");
		result.append(logoImage);
		result.append(", footerShowDocumentTitle: ");
		result.append(footerShowDocumentTitle);
		result.append(", pageCitationStyle: ");
		result.append(pageCitationStyle);
		result.append(", headerStyle: ");
		result.append(headerStyle);
		result.append(", logoWidth: ");
		result.append(logoWidth);
		result.append(", logoHeight: ");
		result.append(logoHeight);
		result.append(", logoOnCoverPage: ");
		result.append(logoOnCoverPage);
		result.append(", hideTableOfContents: ");
		result.append(hideTableOfContents);
		result.append(", hideHeaderAndFooterOnCoverPage: ");
		result.append(hideHeaderAndFooterOnCoverPage);
		result.append(')');
		return result.toString();
	}

} // LayoutOptionsImpl
