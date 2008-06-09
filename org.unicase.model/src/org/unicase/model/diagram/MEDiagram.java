/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.diagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ME Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.diagram.MEDiagram#getElements <em>Elements</em>}</li>
 *   <li>{@link org.unicase.model.diagram.MEDiagram#getGmfdiagram <em>Gmfdiagram</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gmfdiagram</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gmfdiagram</em>' containment reference.
	 * @see #setGmfdiagram(ActionItem)
	 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram_Gmfdiagram()
	 * @model containment="true"
	 * @generated
	 */
	ActionItem getGmfdiagram();

	/**
	 * Sets the value of the '{@link org.unicase.model.diagram.MEDiagram#getGmfdiagram <em>Gmfdiagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gmfdiagram</em>' containment reference.
	 * @see #getGmfdiagram()
	 * @generated
	 */
	void setGmfdiagram(ActionItem value);

} // MEDiagram
