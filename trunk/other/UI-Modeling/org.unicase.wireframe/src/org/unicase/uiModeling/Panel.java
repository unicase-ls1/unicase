/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.diagram.MEDiagram;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Panel</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.Panel#getStoryboard <em>Storyboard</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Panel#getX <em>X</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Panel#getY <em>Y</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Panel#getWidth <em>Width</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Panel#getHeight <em>Height</em>}</li>
 *   <li>{@link org.unicase.uiModeling.Panel#getWidgets <em>Widgets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getPanel()
 * @model
 * @generated
 */
public interface Panel extends MEDiagram {
	/**
	 * Returns the value of the '<em><b>Storyboard</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.uiModeling.Storyboard#getPanels <em>Panels</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storyboard</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storyboard</em>' container reference.
	 * @see #setStoryboard(Storyboard)
	 * @see org.unicase.uiModeling.UiModelingPackage#getPanel_Storyboard()
	 * @see org.unicase.uiModeling.Storyboard#getPanels
	 * @model opposite="panels" transient="false"
	 * @generated
	 */
	Storyboard getStoryboard();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Panel#getStoryboard <em>Storyboard</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storyboard</em>' container reference.
	 * @see #getStoryboard()
	 * @generated
	 */
	void setStoryboard(Storyboard value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getPanel_X()
	 * @model
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Panel#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getPanel_Y()
	 * @model
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Panel#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getPanel_Width()
	 * @model
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Panel#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getPanel_Height()
	 * @model
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Panel#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Widgets</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.uiModeling.Widget}.
	 * It is bidirectional and its opposite is '{@link org.unicase.uiModeling.Widget#getPanel <em>Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widgets</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widgets</em>' containment reference list.
	 * @see org.unicase.uiModeling.UiModelingPackage#getPanel_Widgets()
	 * @see org.unicase.uiModeling.Widget#getPanel
	 * @model opposite="panel" containment="true"
	 * @generated
	 */
	EList<Widget> getWidgets();

} // Panel
