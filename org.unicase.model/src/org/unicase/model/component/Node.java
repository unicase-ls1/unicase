/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.component;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.component.Node#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.component.ComponentPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.component.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see org.unicase.model.component.ComponentPackage#getNode_Components()
	 * @model
	 * @generated
	 */
	EList<Component> getComponents();

} // Node
