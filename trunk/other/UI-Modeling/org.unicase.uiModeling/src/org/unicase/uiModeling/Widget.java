/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Widget</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.Widget#getX <em>X</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Widget#getY <em>Y</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Widget#getWidth <em>Width</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Widget#getHeight <em>Height</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Widget#getText <em>Text</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Widget#getPanel <em>Panel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getWidget()
 * @model abstract="true"
 * @generated
 */
public interface Widget extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute. The default value is <code>"-1"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getWidget_X()
	 * @model default="-1"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Widget#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute. The default value is <code>"-1"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getWidget_Y()
	 * @model default="-1"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Widget#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute. The default value is <code>"-1"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getWidget_Width()
	 * @model default="-1"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Widget#getWidth <em>Width</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute. The default value is <code>"-1"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getWidget_Height()
	 * @model default="-1"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Widget#getHeight <em>Height</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.unicase.uiModeling.UiModelingPackage#getWidget_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Widget#getText <em>Text</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Panel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.uiModeling.Panel#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Panel</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panel</em>' container reference.
	 * @see #setPanel(Panel)
	 * @see org.unicase.uiModeling.UiModelingPackage#getWidget_Panel()
	 * @see org.unicase.uiModeling.Panel#getWidgets
	 * @model opposite="widgets" transient="false"
	 * @generated
	 */
	Panel getPanel();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Widget#getPanel <em>Panel</em>}' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Panel</em>' container reference.
	 * @see #getPanel()
	 * @generated
	 */
	void setPanel(Panel value);

} // Widget
