/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Image</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.uiModeling.Image#getImageURL <em>Image URL</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.uiModeling.UiModelingPackage#getImage()
 * @model
 * @generated
 */
public interface Image extends Widget {
	/**
	 * Returns the value of the '<em><b>Image URL</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image URL</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Image URL</em>' attribute.
	 * @see #setImageURL(String)
	 * @see org.unicase.uiModeling.UiModelingPackage#getImage_ImageURL()
	 * @model
	 * @generated
	 */
	String getImageURL();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Image#getImageURL <em>Image URL</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Image URL</em>' attribute.
	 * @see #getImageURL()
	 * @generated
	 */
	void setImageURL(String value);

} // Image
