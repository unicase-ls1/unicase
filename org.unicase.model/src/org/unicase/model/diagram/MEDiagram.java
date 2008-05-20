/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.diagram;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ME Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.diagram.MEDiagram#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram()
 * @model
 * @generated
 */
public interface MEDiagram extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram_Elements()
	 * @model
	 * @generated
	 */
	EList<ModelElement> getElements();

} // MEDiagram
