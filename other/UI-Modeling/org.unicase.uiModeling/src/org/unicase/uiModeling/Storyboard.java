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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Storyboard</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.Storyboard#getPanels <em>Panels</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getStoryboard()
 * @model
 * @generated
 */
public interface Storyboard extends MEDiagram {
	/**
	 * Returns the value of the '<em><b>Panels</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.uiModeling.Panel}.
	 * It is bidirectional and its opposite is '{@link org.unicase.uiModeling.Panel#getStoryboard <em>Storyboard</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Panels</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Panels</em>' containment reference list.
	 * @see org.unicase.uiModeling.UiModelingPackage#getStoryboard_Panels()
	 * @see org.unicase.uiModeling.Panel#getStoryboard
	 * @model opposite="storyboard" containment="true"
	 * @generated
	 */
	EList<Panel> getPanels();

} // Storyboard
