/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

import java.awt.Color;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Box Model Option</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMargin <em>Margin</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginTop <em>Margin Top</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginLeft <em>Margin Left</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginBottom <em>Margin Bottom</em>}
 * </li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginRight <em>Margin Right</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorder <em>Border</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderTop <em>Border Top</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderLeft <em>Border Left</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderBottom <em>Border Bottom</em>}
 * </li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderRight <em>Border Right</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderStyle <em>Border Style</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderColor <em>Border Color</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPadding <em>Padding</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingTop <em>Padding Top</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingLeft <em>Padding Left</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingBottom <em>Padding Bottom
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingRight <em>Padding Right</em>}
 * </li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBackgroundColor <em>Background Color
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepTogether <em>Keep Together</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepWithPrevious <em>Keep With
 * Previous</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepWithNext <em>Keep With Next</em>}
 * </li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isBreakBefore <em>Break Before</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption()
 * @model
 * @generated
 */
public interface BoxModelOption extends RendererOption {
	/**
	 * Returns the value of the '<em><b>Margin</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Margin</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Margin</em>' attribute.
	 * @see #setMargin(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_Margin()
	 * @model default="0"
	 * @generated
	 */
	double getMargin();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMargin <em>Margin</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Margin</em>' attribute.
	 * @see #getMargin()
	 * @generated
	 */
	void setMargin(double value);

	/**
	 * Returns the value of the '<em><b>Margin Top</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Margin Top</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Margin Top</em>' attribute.
	 * @see #setMarginTop(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_MarginTop()
	 * @model default="0"
	 * @generated
	 */
	double getMarginTop();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginTop <em>Margin Top</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Margin Top</em>' attribute.
	 * @see #getMarginTop()
	 * @generated
	 */
	void setMarginTop(double value);

	/**
	 * Returns the value of the '<em><b>Margin Left</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Margin Left</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Margin Left</em>' attribute.
	 * @see #setMarginLeft(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_MarginLeft()
	 * @model default="0"
	 * @generated
	 */
	double getMarginLeft();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginLeft <em>Margin Left</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Margin Left</em>' attribute.
	 * @see #getMarginLeft()
	 * @generated
	 */
	void setMarginLeft(double value);

	/**
	 * Returns the value of the '<em><b>Margin Bottom</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Margin Bottom</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Margin Bottom</em>' attribute.
	 * @see #setMarginBottom(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_MarginBottom()
	 * @model default="0"
	 * @generated
	 */
	double getMarginBottom();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginBottom <em>Margin Bottom</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Margin Bottom</em>' attribute.
	 * @see #getMarginBottom()
	 * @generated
	 */
	void setMarginBottom(double value);

	/**
	 * Returns the value of the '<em><b>Margin Right</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Margin Right</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Margin Right</em>' attribute.
	 * @see #setMarginRight(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_MarginRight()
	 * @model default="0"
	 * @generated
	 */
	double getMarginRight();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getMarginRight <em>Margin Right</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Margin Right</em>' attribute.
	 * @see #getMarginRight()
	 * @generated
	 */
	void setMarginRight(double value);

	/**
	 * Returns the value of the '<em><b>Border</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Border</em>' attribute.
	 * @see #setBorder(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_Border()
	 * @model default="0"
	 * @generated
	 */
	double getBorder();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorder <em>Border</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border</em>' attribute.
	 * @see #getBorder()
	 * @generated
	 */
	void setBorder(double value);

	/**
	 * Returns the value of the '<em><b>Border Top</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Top</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Border Top</em>' attribute.
	 * @see #setBorderTop(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_BorderTop()
	 * @model default="0"
	 * @generated
	 */
	double getBorderTop();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderTop <em>Border Top</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Top</em>' attribute.
	 * @see #getBorderTop()
	 * @generated
	 */
	void setBorderTop(double value);

	/**
	 * Returns the value of the '<em><b>Border Left</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Left</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Border Left</em>' attribute.
	 * @see #setBorderLeft(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_BorderLeft()
	 * @model default="0"
	 * @generated
	 */
	double getBorderLeft();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderLeft <em>Border Left</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Left</em>' attribute.
	 * @see #getBorderLeft()
	 * @generated
	 */
	void setBorderLeft(double value);

	/**
	 * Returns the value of the '<em><b>Border Bottom</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Bottom</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Border Bottom</em>' attribute.
	 * @see #setBorderBottom(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_BorderBottom()
	 * @model default="0"
	 * @generated
	 */
	double getBorderBottom();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderBottom <em>Border Bottom</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Bottom</em>' attribute.
	 * @see #getBorderBottom()
	 * @generated
	 */
	void setBorderBottom(double value);

	/**
	 * Returns the value of the '<em><b>Border Right</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Right</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Border Right</em>' attribute.
	 * @see #setBorderRight(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_BorderRight()
	 * @model default="0"
	 * @generated
	 */
	double getBorderRight();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderRight <em>Border Right</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Right</em>' attribute.
	 * @see #getBorderRight()
	 * @generated
	 */
	void setBorderRight(double value);

	/**
	 * Returns the value of the '<em><b>Border Style</b></em>' attribute. The default value is <code>"SOLID"</code>. The
	 * literals are from the enumeration {@link org.unicase.docExport.exportModel.renderers.options.UBorderStyle}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Style</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Border Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.UBorderStyle
	 * @see #setBorderStyle(UBorderStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_BorderStyle()
	 * @model default="SOLID"
	 * @generated
	 */
	UBorderStyle getBorderStyle();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderStyle <em>Border Style</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.UBorderStyle
	 * @see #getBorderStyle()
	 * @generated
	 */
	void setBorderStyle(UBorderStyle value);

	/**
	 * Returns the value of the '<em><b>Border Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Color</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border Color</em>' containment reference.
	 * @see #setBorderColor(UColor)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_BorderColor()
	 * @model containment="true"
	 * @generated
	 */
	UColor getBorderColor();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBorderColor <em>Border Color</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Color</em>' containment reference.
	 * @see #getBorderColor()
	 * @generated
	 */
	void setBorderColor(UColor value);

	/**
	 * Returns the value of the '<em><b>Padding</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Padding</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Padding</em>' attribute.
	 * @see #setPadding(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_Padding()
	 * @model default="0"
	 * @generated
	 */
	double getPadding();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPadding <em>Padding</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Padding</em>' attribute.
	 * @see #getPadding()
	 * @generated
	 */
	void setPadding(double value);

	/**
	 * Returns the value of the '<em><b>Padding Top</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Padding Top</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Padding Top</em>' attribute.
	 * @see #setPaddingTop(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_PaddingTop()
	 * @model default="0"
	 * @generated
	 */
	double getPaddingTop();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingTop <em>Padding Top</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Padding Top</em>' attribute.
	 * @see #getPaddingTop()
	 * @generated
	 */
	void setPaddingTop(double value);

	/**
	 * Returns the value of the '<em><b>Padding Left</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Padding Left</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Padding Left</em>' attribute.
	 * @see #setPaddingLeft(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_PaddingLeft()
	 * @model default="0"
	 * @generated
	 */
	double getPaddingLeft();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingLeft <em>Padding Left</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Padding Left</em>' attribute.
	 * @see #getPaddingLeft()
	 * @generated
	 */
	void setPaddingLeft(double value);

	/**
	 * Returns the value of the '<em><b>Padding Bottom</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Padding Bottom</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Padding Bottom</em>' attribute.
	 * @see #setPaddingBottom(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_PaddingBottom()
	 * @model default="0"
	 * @generated
	 */
	double getPaddingBottom();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingBottom <em>Padding Bottom</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Padding Bottom</em>' attribute.
	 * @see #getPaddingBottom()
	 * @generated
	 */
	void setPaddingBottom(double value);

	/**
	 * Returns the value of the '<em><b>Padding Right</b></em>' attribute. The default value is <code>"0"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Padding Right</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Padding Right</em>' attribute.
	 * @see #setPaddingRight(double)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_PaddingRight()
	 * @model default="0"
	 * @generated
	 */
	double getPaddingRight();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getPaddingRight <em>Padding Right</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Padding Right</em>' attribute.
	 * @see #getPaddingRight()
	 * @generated
	 */
	void setPaddingRight(double value);

	/**
	 * Returns the value of the '<em><b>Background Color</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Color</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Color</em>' reference.
	 * @see #setBackgroundColor(UColor)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_BackgroundColor()
	 * @model
	 * @generated
	 */
	UColor getBackgroundColor();

	// begin custom code
	/**
	 * @param color the background color
	 * @generated NOT
	 */
	void setBackgroundColor(Color color);

	// end custom code

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getBackgroundColor <em>Background Color</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color</em>' reference.
	 * @see #getBackgroundColor()
	 * @generated
	 */
	void setBackgroundColor(UColor value);

	/**
	 * Returns the value of the '<em><b>Keep Together</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keep Together</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keep Together</em>' attribute.
	 * @see #setKeepTogether(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_KeepTogether()
	 * @model
	 * @generated
	 */
	boolean isKeepTogether();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepTogether <em>Keep Together</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keep Together</em>' attribute.
	 * @see #isKeepTogether()
	 * @generated
	 */
	void setKeepTogether(boolean value);

	/**
	 * Returns the value of the '<em><b>Keep With Previous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keep With Previous</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keep With Previous</em>' attribute.
	 * @see #setKeepWithPrevious(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_KeepWithPrevious()
	 * @model
	 * @generated
	 */
	boolean isKeepWithPrevious();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepWithPrevious <em>Keep With Previous</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keep With Previous</em>' attribute.
	 * @see #isKeepWithPrevious()
	 * @generated
	 */
	void setKeepWithPrevious(boolean value);

	/**
	 * Returns the value of the '<em><b>Keep With Next</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keep With Next</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keep With Next</em>' attribute.
	 * @see #setKeepWithNext(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_KeepWithNext()
	 * @model
	 * @generated
	 */
	boolean isKeepWithNext();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isKeepWithNext <em>Keep With Next</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keep With Next</em>' attribute.
	 * @see #isKeepWithNext()
	 * @generated
	 */
	void setKeepWithNext(boolean value);

	/**
	 * Returns the value of the '<em><b>Break Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Break Before</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Break Before</em>' attribute.
	 * @see #setBreakBefore(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_BreakBefore()
	 * @model
	 * @generated
	 */
	boolean isBreakBefore();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isBreakBefore <em>Break Before</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Break Before</em>' attribute.
	 * @see #isBreakBefore()
	 * @generated
	 */
	void setBreakBefore(boolean value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_Width()
	 * @model
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Break After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Break After</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Break After</em>' attribute.
	 * @see #setBreakAfter(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBoxModelOption_BreakAfter()
	 * @model
	 * @generated
	 */
	boolean isBreakAfter();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption#isBreakAfter <em>Break After</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Break After</em>' attribute.
	 * @see #isBreakAfter()
	 * @generated
	 */
	void setBreakAfter(boolean value);

} // BoxModelOption
