/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Text Option</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontFamily <em>Font Family</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontSize <em>Font Size</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.TextOption#isBold <em>Bold</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.TextOption#isUnderline <em>Underline</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getTextAlign <em>Text Align</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.TextOption#isItalics <em>Italics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getTextOption()
 * @model
 * @generated
 */
public interface TextOption extends RendererOption {
	/**
	 * Returns the value of the '<em><b>Font Family</b></em>' attribute. The default value is <code>""</code>. The
	 * literals are from the enumeration {@link org.unicase.docExport.exportModel.renderers.options.FontFamily}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Family</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Font Family</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.FontFamily
	 * @see #setFontFamily(FontFamily)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getTextOption_FontFamily()
	 * @model default=""
	 * @generated
	 */
	FontFamily getFontFamily();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontFamily <em>Font Family</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Family</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.FontFamily
	 * @see #getFontFamily()
	 * @generated
	 */
	void setFontFamily(FontFamily value);

	/**
	 * Returns the value of the '<em><b>Font Size</b></em>' attribute. The default value is <code>"12"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Size</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Font Size</em>' attribute.
	 * @see #setFontSize(int)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getTextOption_FontSize()
	 * @model default="12"
	 * @generated
	 */
	int getFontSize();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontSize <em>Font Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Size</em>' attribute.
	 * @see #getFontSize()
	 * @generated
	 */
	void setFontSize(int value);

	/**
	 * Returns the value of the '<em><b>Font Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Color</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Color</em>' containment reference.
	 * @see #setFontColor(UColor)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getTextOption_FontColor()
	 * @model containment="true"
	 * @generated
	 */
	UColor getFontColor();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getFontColor <em>Font Color</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Color</em>' containment reference.
	 * @see #getFontColor()
	 * @generated
	 */
	void setFontColor(UColor value);

	/**
	 * Returns the value of the '<em><b>Text Align</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.docExport.exportModel.renderers.options.TextAlign}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Align</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Align</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextAlign
	 * @see #setTextAlign(TextAlign)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getTextOption_TextAlign()
	 * @model
	 * @generated
	 */
	TextAlign getTextAlign();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#getTextAlign <em>Text Align</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Align</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextAlign
	 * @see #getTextAlign()
	 * @generated
	 */
	void setTextAlign(TextAlign value);

	/**
	 * Returns the value of the '<em><b>Italics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Italics</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Italics</em>' attribute.
	 * @see #setItalics(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getTextOption_Italics()
	 * @model
	 * @generated
	 */
	boolean isItalics();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#isItalics <em>Italics</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Italics</em>' attribute.
	 * @see #isItalics()
	 * @generated
	 */
	void setItalics(boolean value);

	/**
	 * Returns the value of the '<em><b>Bold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bold</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bold</em>' attribute.
	 * @see #setBold(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getTextOption_Bold()
	 * @model
	 * @generated
	 */
	boolean isBold();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#isBold <em>Bold</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bold</em>' attribute.
	 * @see #isBold()
	 * @generated
	 */
	void setBold(boolean value);

	/**
	 * Returns the value of the '<em><b>Underline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Underline</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Underline</em>' attribute.
	 * @see #setUnderline(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getTextOption_Underline()
	 * @model
	 * @generated
	 */
	boolean isUnderline();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.TextOption#isUnderline <em>Underline</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Underline</em>' attribute.
	 * @see #isUnderline()
	 * @generated
	 */
	void setUnderline(boolean value);

} // TextOption
