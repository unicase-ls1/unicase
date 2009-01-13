/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.options;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getCoverText <em>Cover Text</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getCoverTextTextOption <em>Cover Text Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDefaultTextOption <em>Default Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionTextOption <em>Section Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAnnotations <em>Hide Annotations</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAttachments <em>Hide Attachments</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideIncomingDocumentReferences <em>Hide Incoming Document References</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getPageNumberingStyle <em>Page Numbering Style</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideModelElementImages <em>Hide Model Element Images</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getModelElementTextOption <em>Model Element Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderText <em>Header Text</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterText <em>Footer Text</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionOption <em>Section Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionFontSizeDecreaseStep <em>Section Font Size Decrease Step</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDocumentTitleTextOption <em>Document Title Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isShowModelElementTypeInSectionTitle <em>Show Model Element Type In Section Title</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getAttributeTextOption <em>Attribute Text Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getAppendixStyle <em>Appendix Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions()
 * @model
 * @generated
 */
public interface LayoutOptions extends RendererOption {
	/**
	 * Returns the value of the '<em><b>Cover Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cover Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cover Text</em>' attribute.
	 * @see #setCoverText(String)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_CoverText()
	 * @model
	 * @generated
	 */
	String getCoverText();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getCoverText <em>Cover Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cover Text</em>' attribute.
	 * @see #getCoverText()
	 * @generated
	 */
	void setCoverText(String value);

	/**
	 * Returns the value of the '<em><b>Cover Text Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cover Text Text Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cover Text Text Option</em>' containment reference.
	 * @see #setCoverTextTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_CoverTextTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getCoverTextTextOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getCoverTextTextOption <em>Cover Text Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cover Text Text Option</em>' containment reference.
	 * @see #getCoverTextTextOption()
	 * @generated
	 */
	void setCoverTextTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Default Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Text Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Text Option</em>' containment reference.
	 * @see #setDefaultTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_DefaultTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getDefaultTextOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDefaultTextOption <em>Default Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Text Option</em>' containment reference.
	 * @see #getDefaultTextOption()
	 * @generated
	 */
	void setDefaultTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Section Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Text Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section Text Option</em>' containment reference.
	 * @see #setSectionTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_SectionTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getSectionTextOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionTextOption <em>Section Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Text Option</em>' containment reference.
	 * @see #getSectionTextOption()
	 * @generated
	 */
	void setSectionTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Hide Annotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Annotations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide Annotations</em>' attribute.
	 * @see #setHideAnnotations(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideAnnotations()
	 * @model
	 * @generated
	 */
	boolean isHideAnnotations();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAnnotations <em>Hide Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide Annotations</em>' attribute.
	 * @see #isHideAnnotations()
	 * @generated
	 */
	void setHideAnnotations(boolean value);

	/**
	 * Returns the value of the '<em><b>Hide Attachments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Attachments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide Attachments</em>' attribute.
	 * @see #setHideAttachments(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideAttachments()
	 * @model
	 * @generated
	 */
	boolean isHideAttachments();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideAttachments <em>Hide Attachments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide Attachments</em>' attribute.
	 * @see #isHideAttachments()
	 * @generated
	 */
	void setHideAttachments(boolean value);

	/**
	 * Returns the value of the '<em><b>Hide Incoming Document References</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Incoming Document References</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide Incoming Document References</em>' attribute.
	 * @see #setHideIncomingDocumentReferences(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideIncomingDocumentReferences()
	 * @model
	 * @generated
	 */
	boolean isHideIncomingDocumentReferences();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideIncomingDocumentReferences <em>Hide Incoming Document References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide Incoming Document References</em>' attribute.
	 * @see #isHideIncomingDocumentReferences()
	 * @generated
	 */
	void setHideIncomingDocumentReferences(boolean value);

	/**
	 * Returns the value of the '<em><b>Page Numbering Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Numbering Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Numbering Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle
	 * @see #setPageNumberingStyle(PageNumberingStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_PageNumberingStyle()
	 * @model
	 * @generated
	 */
	PageNumberingStyle getPageNumberingStyle();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getPageNumberingStyle <em>Page Numbering Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Numbering Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.PageNumberingStyle
	 * @see #getPageNumberingStyle()
	 * @generated
	 */
	void setPageNumberingStyle(PageNumberingStyle value);

	/**
	 * Returns the value of the '<em><b>Hide Model Element Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Model Element Images</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide Model Element Images</em>' attribute.
	 * @see #setHideModelElementImages(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HideModelElementImages()
	 * @model
	 * @generated
	 */
	boolean isHideModelElementImages();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isHideModelElementImages <em>Hide Model Element Images</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide Model Element Images</em>' attribute.
	 * @see #isHideModelElementImages()
	 * @generated
	 */
	void setHideModelElementImages(boolean value);

	/**
	 * Returns the value of the '<em><b>Model Element Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Text Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Text Option</em>' containment reference.
	 * @see #setModelElementTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_ModelElementTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getModelElementTextOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getModelElementTextOption <em>Model Element Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element Text Option</em>' containment reference.
	 * @see #getModelElementTextOption()
	 * @generated
	 */
	void setModelElementTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Header Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Text</em>' attribute.
	 * @see #setHeaderText(String)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_HeaderText()
	 * @model
	 * @generated
	 */
	String getHeaderText();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getHeaderText <em>Header Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Text</em>' attribute.
	 * @see #getHeaderText()
	 * @generated
	 */
	void setHeaderText(String value);

	/**
	 * Returns the value of the '<em><b>Footer Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footer Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Footer Text</em>' attribute.
	 * @see #setFooterText(String)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_FooterText()
	 * @model
	 * @generated
	 */
	String getFooterText();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getFooterText <em>Footer Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Footer Text</em>' attribute.
	 * @see #getFooterText()
	 * @generated
	 */
	void setFooterText(String value);

	/**
	 * Returns the value of the '<em><b>Section Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section Option</em>' containment reference.
	 * @see #setSectionOption(SectionOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_SectionOption()
	 * @model containment="true"
	 * @generated
	 */
	SectionOption getSectionOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionOption <em>Section Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Option</em>' containment reference.
	 * @see #getSectionOption()
	 * @generated
	 */
	void setSectionOption(SectionOption value);

	/**
	 * Returns the value of the '<em><b>Section Font Size Decrease Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Font Size Decrease Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section Font Size Decrease Step</em>' attribute.
	 * @see #setSectionFontSizeDecreaseStep(int)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_SectionFontSizeDecreaseStep()
	 * @model
	 * @generated
	 */
	int getSectionFontSizeDecreaseStep();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getSectionFontSizeDecreaseStep <em>Section Font Size Decrease Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Font Size Decrease Step</em>' attribute.
	 * @see #getSectionFontSizeDecreaseStep()
	 * @generated
	 */
	void setSectionFontSizeDecreaseStep(int value);

	/**
	 * Returns the value of the '<em><b>Document Title Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Title Text Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Title Text Option</em>' containment reference.
	 * @see #setDocumentTitleTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_DocumentTitleTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getDocumentTitleTextOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getDocumentTitleTextOption <em>Document Title Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document Title Text Option</em>' containment reference.
	 * @see #getDocumentTitleTextOption()
	 * @generated
	 */
	void setDocumentTitleTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Show Model Element Type In Section Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Model Element Type In Section Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Model Element Type In Section Title</em>' attribute.
	 * @see #setShowModelElementTypeInSectionTitle(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_ShowModelElementTypeInSectionTitle()
	 * @model
	 * @generated
	 */
	boolean isShowModelElementTypeInSectionTitle();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#isShowModelElementTypeInSectionTitle <em>Show Model Element Type In Section Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Model Element Type In Section Title</em>' attribute.
	 * @see #isShowModelElementTypeInSectionTitle()
	 * @generated
	 */
	void setShowModelElementTypeInSectionTitle(boolean value);

	/**
	 * Returns the value of the '<em><b>Attribute Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Text Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Text Option</em>' containment reference.
	 * @see #setAttributeTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_AttributeTextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getAttributeTextOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getAttributeTextOption <em>Attribute Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Text Option</em>' containment reference.
	 * @see #getAttributeTextOption()
	 * @generated
	 */
	void setAttributeTextOption(TextOption value);

	/**
	 * Returns the value of the '<em><b>Appendix Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.docExport.exportModel.renderers.options.AppendixStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Appendix Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Appendix Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.AppendixStyle
	 * @see #setAppendixStyle(AppendixStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getLayoutOptions_AppendixStyle()
	 * @model
	 * @generated
	 */
	AppendixStyle getAppendixStyle();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions#getAppendixStyle <em>Appendix Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Appendix Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.AppendixStyle
	 * @see #getAppendixStyle()
	 * @generated
	 */
	void setAppendixStyle(AppendixStyle value);

} // LayoutOptions
