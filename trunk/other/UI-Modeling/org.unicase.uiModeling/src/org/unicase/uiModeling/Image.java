/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Image</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.Image#getImageUrl <em>Image Url</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getImage()
 * @model
 * @generated
 */
public interface Image extends Widget {
	/**
	 * Returns the value of the '<em><b>Image Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Url</em>' attribute.
	 * @see #setImageUrl(String)
	 * @see org.unicase.uiModeling.UiModelingPackage#getImage_ImageUrl()
	 * @model
	 * @generated
	 */
	String getImageUrl();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Image#getImageUrl <em>Image Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Url</em>' attribute.
	 * @see #getImageUrl()
	 * @generated
	 */
	void setImageUrl(String value);

} // Image
