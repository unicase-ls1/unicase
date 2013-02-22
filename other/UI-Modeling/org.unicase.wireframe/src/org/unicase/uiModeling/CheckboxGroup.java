/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Checkbox Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.uiModeling.CheckboxGroup#getBoxes <em>Boxes</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.uiModeling.UiModelingPackage#getCheckboxGroup()
 * @model
 * @generated
 */
public interface CheckboxGroup extends Widget {
	/**
	 * Returns the value of the '<em><b>Boxes</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.uiModeling.Checkbox}. It is bidirectional and its opposite is '
	 * {@link org.unicase.uiModeling.Checkbox#getGroup <em>Group</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boxes</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Boxes</em>' containment reference list.
	 * @see org.unicase.uiModeling.UiModelingPackage#getCheckboxGroup_Boxes()
	 * @see org.unicase.uiModeling.Checkbox#getGroup
	 * @model opposite="group" containment="true"
	 * @generated
	 */
	EList<Checkbox> getBoxes();

} // CheckboxGroup
