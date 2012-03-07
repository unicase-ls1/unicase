/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>List Option</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.ListOption#getListStyle <em>List Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getListOption()
 * @model
 * @generated
 */
public interface ListOption extends RendererOption {

	/**
	 * Returns the value of the '<em><b>List Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.docExport.exportModel.renderers.options.ListStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Style</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.ListStyle
	 * @see #setListStyle(ListStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getListOption_ListStyle()
	 * @model
	 * @generated
	 */
	ListStyle getListStyle();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.ListOption#getListStyle <em>List Style</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>List Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.ListStyle
	 * @see #getListStyle()
	 * @generated
	 */
	void setListStyle(ListStyle value);
} // ListOption
