/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Section Option</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.SectionOption#getSectionNumberingStyle <em>Section Numbering Style</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.SectionOption#isLeaveOutPreviousSectionNumbering <em>Leave Out Previous Section Numbering</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getSectionOption()
 * @model
 * @generated
 */
public interface SectionOption extends RendererOption {
	/**
	 * Returns the value of the '<em><b>Section Numbering Style</b></em>' attribute. The literals are from the
	 * enumeration {@link org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Numbering Style</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Section Numbering Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle
	 * @see #setSectionNumberingStyle(SectionNumberingStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getSectionOption_SectionNumberingStyle()
	 * @model
	 * @generated
	 */
	SectionNumberingStyle getSectionNumberingStyle();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.SectionOption#getSectionNumberingStyle <em>Section Numbering Style</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Numbering Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle
	 * @see #getSectionNumberingStyle()
	 * @generated
	 */
	void setSectionNumberingStyle(SectionNumberingStyle value);

	/**
	 * Returns the value of the '<em><b>Leave Out Previous Section Numbering</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Leave Out Previous Section Numbering</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leave Out Previous Section Numbering</em>' attribute.
	 * @see #setLeaveOutPreviousSectionNumbering(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getSectionOption_LeaveOutPreviousSectionNumbering()
	 * @model
	 * @generated
	 */
	boolean isLeaveOutPreviousSectionNumbering();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.SectionOption#isLeaveOutPreviousSectionNumbering <em>Leave Out Previous Section Numbering</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leave Out Previous Section Numbering</em>' attribute.
	 * @see #isLeaveOutPreviousSectionNumbering()
	 * @generated
	 */
	void setLeaveOutPreviousSectionNumbering(boolean value);

} // SectionOption
