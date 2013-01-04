/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Window</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.wireframe.Window#isHasClose <em>Has Close</em>}</li>
 *   <li>{@link org.unicase.wireframe.Window#isHasMaximize <em>Has Maximize</em>}</li>
 *   <li>{@link org.unicase.wireframe.Window#isHasMinimize <em>Has Minimize</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.wireframe.WireframePackage#getWindow()
 * @model
 * @generated
 */
public interface Window extends Widget {
	/**
	 * Returns the value of the '<em><b>Has Close</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Close</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Close</em>' attribute.
	 * @see #setHasClose(boolean)
	 * @see org.unicase.wireframe.WireframePackage#getWindow_HasClose()
	 * @model
	 * @generated
	 */
	boolean isHasClose();

	/**
	 * Sets the value of the '{@link org.unicase.wireframe.Window#isHasClose <em>Has Close</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Has Close</em>' attribute.
	 * @see #isHasClose()
	 * @generated
	 */
	void setHasClose(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Maximize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Maximize</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Maximize</em>' attribute.
	 * @see #setHasMaximize(boolean)
	 * @see org.unicase.wireframe.WireframePackage#getWindow_HasMaximize()
	 * @model
	 * @generated
	 */
	boolean isHasMaximize();

	/**
	 * Sets the value of the '{@link org.unicase.wireframe.Window#isHasMaximize <em>Has Maximize</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Has Maximize</em>' attribute.
	 * @see #isHasMaximize()
	 * @generated
	 */
	void setHasMaximize(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Minimize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Minimize</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Minimize</em>' attribute.
	 * @see #setHasMinimize(boolean)
	 * @see org.unicase.wireframe.WireframePackage#getWindow_HasMinimize()
	 * @model
	 * @generated
	 */
	boolean isHasMinimize();

	/**
	 * Sets the value of the '{@link org.unicase.wireframe.Window#isHasMinimize <em>Has Minimize</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Has Minimize</em>' attribute.
	 * @see #isHasMinimize()
	 * @generated
	 */
	void setHasMinimize(boolean value);

} // Window
