/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Layout Options</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderTextOption <em>Header Text
 * Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDefaultTextOption <em>Default Text
 * Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionTextOption <em>Section Text
 * Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAnnotations <em>Hide Annotations
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAttachments <em>Hide Attachments
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideIncomingDocumentReferences <em>
 * Hide Incoming Document References</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideModelElementImages <em>Hide Model
 * Element Images</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getModelElementTextOption <em>Model
 * Element Text Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderText <em>Header Text</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterText <em>Footer Text</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionOption <em>Section Option
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionFontSizeDecreaseStep <em>
 * Section Font Size Decrease Step</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDocumentTitleTextOption <em>Document
 * Title Text Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isShowModelElementTypeInSectionTitle
 * <em>Show Model Element Type In Section Title</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getAppendixStyle <em>Appendix Style
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoImage <em>Logo Image</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterTextOption <em>Footer Text
 * Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isFooterShowDocumentTitle <em>Footer
 * Show Document Title</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getPageCitationStyle <em>Page Citation
 * Style</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderStyle <em>Header Style</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoWidth <em>Logo Width</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoHeight <em>Logo Height</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isLogoOnCoverPage <em>Logo On Cover Page
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getTableOfContentsTextOption <em>Table
 * Of Contents Text Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideTableOfContents <em>Hide Table Of
 * Contents</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideHeaderAndFooterOnCoverPage <em>
 * Hide Header And Footer On Cover Page</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions()
 * @model
 * @generated
 */
public interface LayoutOptions extends RendererOption {
	/**
	 * Returns the value of the '<em><b>Header Text Option</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Text Option</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Header Text Option</em>' containment reference.
	 * @see #setHeaderTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HeaderTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getHeaderTextOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderTextOption
	 * <em>Header Text Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Header Text Option</em>' containment reference.
	 * @see #getHeaderTextOption()
	 * @generated
	 */
	void setHeaderTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Default Text Option</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Text Option</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default Text Option</em>' containment reference.
	 * @see #setDefaultTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_DefaultTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getDefaultTextOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDefaultTextOption
	 * <em>Default Text Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Default Text Option</em>' containment reference.
	 * @see #getDefaultTextOption()
	 * @generated
	 */
	void setDefaultTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Section Text Option</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Text Option</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Section Text Option</em>' containment reference.
	 * @see #setSectionTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_SectionTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getSectionTextOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionTextOption
	 * <em>Section Text Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Section Text Option</em>' containment reference.
	 * @see #getSectionTextOption()
	 * @generated
	 */
	void setSectionTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Hide Annotations</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Annotations</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hide Annotations</em>' attribute.
	 * @see #setHideAnnotations(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideAnnotations()
	 * @model
	 * @generated
	 */
	boolean isHideAnnotations();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAnnotations
	 * <em>Hide Annotations</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Hide Annotations</em>' attribute.
	 * @see #isHideAnnotations()
	 * @generated
	 */
	void setHideAnnotations(boolean value);

	/**
	 * Returns the value of the '<em><b>Hide Attachments</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Attachments</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hide Attachments</em>' attribute.
	 * @see #setHideAttachments(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideAttachments()
	 * @model
	 * @generated
	 */
	boolean isHideAttachments();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAttachments
	 * <em>Hide Attachments</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Hide Attachments</em>' attribute.
	 * @see #isHideAttachments()
	 * @generated
	 */
	void setHideAttachments(boolean value);

	/**
	 * Returns the value of the '<em><b>Hide Incoming Document References</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Incoming Document References</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hide Incoming Document References</em>' attribute.
	 * @see #setHideIncomingDocumentReferences(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideIncomingDocumentReferences()
	 * @model
	 * @generated
	 */
	boolean isHideIncomingDocumentReferences();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideIncomingDocumentReferences
	 * <em>Hide Incoming Document References</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Hide Incoming Document References</em>' attribute.
	 * @see #isHideIncomingDocumentReferences()
	 * @generated
	 */
	void setHideIncomingDocumentReferences(boolean value);

	/**
	 * Returns the value of the '<em><b>Hide Model Element Images</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Model Element Images</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hide Model Element Images</em>' attribute.
	 * @see #setHideModelElementImages(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideModelElementImages()
	 * @model
	 * @generated
	 */
	boolean isHideModelElementImages();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideModelElementImages
	 * <em>Hide Model Element Images</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Hide Model Element Images</em>' attribute.
	 * @see #isHideModelElementImages()
	 * @generated
	 */
	void setHideModelElementImages(boolean value);

	/**
	 * Returns the value of the '<em><b>Model Element Text Option</b></em>' containment reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Model Element Text Option</em>' containment reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Element Text Option</em>' containment reference.
	 * @see #setModelElementTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_ModelElementTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getModelElementTextOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getModelElementTextOption
	 * <em>Model Element Text Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Element Text Option</em>' containment reference.
	 * @see #getModelElementTextOption()
	 * @generated
	 */
	void setModelElementTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Header Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Text</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Header Text</em>' attribute.
	 * @see #setHeaderText(String)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HeaderText()
	 * @model
	 * @generated
	 */
	String getHeaderText();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderText
	 * <em>Header Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Header Text</em>' attribute.
	 * @see #getHeaderText()
	 * @generated
	 */
	void setHeaderText(String value);

	/**
	 * Returns the value of the '<em><b>Footer Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footer Text</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Footer Text</em>' attribute.
	 * @see #setFooterText(String)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_FooterText()
	 * @model
	 * @generated
	 */
	String getFooterText();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterText
	 * <em>Footer Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Footer Text</em>' attribute.
	 * @see #getFooterText()
	 * @generated
	 */
	void setFooterText(String value);

	/**
	 * Returns the value of the '<em><b>Section Option</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Option</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Section Option</em>' containment reference.
	 * @see #setSectionOption(SectionOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_SectionOption()
	 * @model containment="true"
	 * @generated
	 */
	SectionOption getSectionOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionOption
	 * <em>Section Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Section Option</em>' containment reference.
	 * @see #getSectionOption()
	 * @generated
	 */
	void setSectionOption(SectionOption value);

	/**
	 * Returns the value of the '<em><b>Section Font Size Decrease Step</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Font Size Decrease Step</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Section Font Size Decrease Step</em>' attribute.
	 * @see #setSectionFontSizeDecreaseStep(int)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_SectionFontSizeDecreaseStep()
	 * @model
	 * @generated
	 */
	int getSectionFontSizeDecreaseStep();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionFontSizeDecreaseStep
	 * <em>Section Font Size Decrease Step</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Section Font Size Decrease Step</em>' attribute.
	 * @see #getSectionFontSizeDecreaseStep()
	 * @generated
	 */
	void setSectionFontSizeDecreaseStep(int value);

	/**
	 * Returns the value of the '<em><b>Document Title Text Option</b></em>' containment reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Document Title Text Option</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Document Title Text Option</em>' containment reference.
	 * @see #setDocumentTitleTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_DocumentTitleTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getDocumentTitleTextOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDocumentTitleTextOption
	 * <em>Document Title Text Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Document Title Text Option</em>' containment reference.
	 * @see #getDocumentTitleTextOption()
	 * @generated
	 */
	void setDocumentTitleTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Show Model Element Type In Section Title</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Model Element Type In Section Title</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Show Model Element Type In Section Title</em>' attribute.
	 * @see #setShowModelElementTypeInSectionTitle(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_ShowModelElementTypeInSectionTitle()
	 * @model
	 * @generated
	 */
	boolean isShowModelElementTypeInSectionTitle();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isShowModelElementTypeInSectionTitle
	 * <em>Show Model Element Type In Section Title</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Show Model Element Type In Section Title</em>' attribute.
	 * @see #isShowModelElementTypeInSectionTitle()
	 * @generated
	 */
	void setShowModelElementTypeInSectionTitle(boolean value);

	/**
	 * Returns the value of the '<em><b>Appendix Style</b></em>' attribute. The literals are from the enumeration
	 * {@link org.unicase.docExport.exportModel.renderers.options.AppendixStyle}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Appendix Style</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Appendix Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.AppendixStyle
	 * @see #setAppendixStyle(AppendixStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_AppendixStyle()
	 * @model
	 * @generated
	 */
	AppendixStyle getAppendixStyle();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getAppendixStyle
	 * <em>Appendix Style</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Appendix Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.AppendixStyle
	 * @see #getAppendixStyle()
	 * @generated
	 */
	void setAppendixStyle(AppendixStyle value);

	/**
	 * Returns the value of the '<em><b>Logo Image</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logo Image</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Logo Image</em>' attribute.
	 * @see #setLogoImage(String)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_LogoImage()
	 * @model
	 * @generated
	 */
	String getLogoImage();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoImage
	 * <em>Logo Image</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Logo Image</em>' attribute.
	 * @see #getLogoImage()
	 * @generated
	 */
	void setLogoImage(String value);

	/**
	 * Returns the value of the '<em><b>Footer Text Option</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footer Text Option</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Footer Text Option</em>' containment reference.
	 * @see #setFooterTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_FooterTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getFooterTextOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterTextOption
	 * <em>Footer Text Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Footer Text Option</em>' containment reference.
	 * @see #getFooterTextOption()
	 * @generated
	 */
	void setFooterTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Footer Show Document Title</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footer Show Document Title</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Footer Show Document Title</em>' attribute.
	 * @see #setFooterShowDocumentTitle(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_FooterShowDocumentTitle()
	 * @model
	 * @generated
	 */
	boolean isFooterShowDocumentTitle();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isFooterShowDocumentTitle
	 * <em>Footer Show Document Title</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Footer Show Document Title</em>' attribute.
	 * @see #isFooterShowDocumentTitle()
	 * @generated
	 */
	void setFooterShowDocumentTitle(boolean value);

	/**
	 * Returns the value of the '<em><b>Page Citation Style</b></em>' attribute. The literals are from the enumeration
	 * {@link org.unicase.docExport.exportModel.renderers.options.PageCitationStyle}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Citation Style</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Page Citation Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.PageCitationStyle
	 * @see #setPageCitationStyle(PageCitationStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_PageCitationStyle()
	 * @model
	 * @generated
	 */
	PageCitationStyle getPageCitationStyle();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getPageCitationStyle
	 * <em>Page Citation Style</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Page Citation Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.PageCitationStyle
	 * @see #getPageCitationStyle()
	 * @generated
	 */
	void setPageCitationStyle(PageCitationStyle value);

	/**
	 * Returns the value of the '<em><b>Header Style</b></em>' attribute. The literals are from the enumeration
	 * {@link org.unicase.docExport.exportModel.renderers.options.HeaderStyle}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Style</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Header Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.HeaderStyle
	 * @see #setHeaderStyle(HeaderStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HeaderStyle()
	 * @model
	 * @generated
	 */
	HeaderStyle getHeaderStyle();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderStyle
	 * <em>Header Style</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Header Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.HeaderStyle
	 * @see #getHeaderStyle()
	 * @generated
	 */
	void setHeaderStyle(HeaderStyle value);

	/**
	 * Returns the value of the '<em><b>Logo Width</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logo Width</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Logo Width</em>' attribute.
	 * @see #setLogoWidth(int)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_LogoWidth()
	 * @model
	 * @generated
	 */
	int getLogoWidth();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoWidth
	 * <em>Logo Width</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Logo Width</em>' attribute.
	 * @see #getLogoWidth()
	 * @generated
	 */
	void setLogoWidth(int value);

	/**
	 * Returns the value of the '<em><b>Logo Height</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logo Height</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Logo Height</em>' attribute.
	 * @see #setLogoHeight(int)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_LogoHeight()
	 * @model
	 * @generated
	 */
	int getLogoHeight();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getLogoHeight
	 * <em>Logo Height</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Logo Height</em>' attribute.
	 * @see #getLogoHeight()
	 * @generated
	 */
	void setLogoHeight(int value);

	/**
	 * Returns the value of the '<em><b>Logo On Cover Page</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logo On Cover Page</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Logo On Cover Page</em>' attribute.
	 * @see #setLogoOnCoverPage(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_LogoOnCoverPage()
	 * @model
	 * @generated
	 */
	boolean isLogoOnCoverPage();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isLogoOnCoverPage
	 * <em>Logo On Cover Page</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Logo On Cover Page</em>' attribute.
	 * @see #isLogoOnCoverPage()
	 * @generated
	 */
	void setLogoOnCoverPage(boolean value);

	/**
	 * Returns the value of the '<em><b>Table Of Contents Text Option</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table Of Contents Text Option</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Table Of Contents Text Option</em>' containment reference.
	 * @see #setTableOfContentsTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_TableOfContentsTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getTableOfContentsTextOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getTableOfContentsTextOption
	 * <em>Table Of Contents Text Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Table Of Contents Text Option</em>' containment reference.
	 * @see #getTableOfContentsTextOption()
	 * @generated
	 */
	void setTableOfContentsTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Hide Table Of Contents</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Table Of Contents</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hide Table Of Contents</em>' attribute.
	 * @see #setHideTableOfContents(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideTableOfContents()
	 * @model
	 * @generated
	 */
	boolean isHideTableOfContents();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideTableOfContents
	 * <em>Hide Table Of Contents</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Hide Table Of Contents</em>' attribute.
	 * @see #isHideTableOfContents()
	 * @generated
	 */
	void setHideTableOfContents(boolean value);

	/**
	 * Returns the value of the '<em><b>Hide Header And Footer On Cover Page</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Hide Header And Footer On Cover Page</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hide Header And Footer On Cover Page</em>' attribute.
	 * @see #setHideHeaderAndFooterOnCoverPage(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideHeaderAndFooterOnCoverPage()
	 * @model
	 * @generated
	 */
	boolean isHideHeaderAndFooterOnCoverPage();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideHeaderAndFooterOnCoverPage
	 * <em>Hide Header And Footer On Cover Page</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Hide Header And Footer On Cover Page</em>' attribute.
	 * @see #isHideHeaderAndFooterOnCoverPage()
	 * @generated
	 */
	void setHideHeaderAndFooterOnCoverPage(boolean value);

} // LayoutOptions
