/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
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
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>ME Diagram</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.diagram.MEDiagram#getElements <em>Elements</em>}
 * </li>
 * <li>{@link org.unicase.model.diagram.MEDiagram#getGmfdiagram <em>Gmfdiagram
 * </em>}</li>
 * <li>{@link org.unicase.model.diagram.MEDiagram#getNewElements <em>New
 * Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram()
 * @model
 * @generated
 */
public interface MEDiagram extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list. The
	 * list contents are of type {@link org.unicase.model.ModelElement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram_Elements()
	 * @model
	 * @generated
	 */
	EList<ModelElement> getElements();

	/**
	 * Returns the value of the '<em><b>Gmfdiagram</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gmfdiagram</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gmfdiagram</em>' containment reference.
	 * @see #setGmfdiagram(Diagram)
	 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram_Gmfdiagram()
	 * @model containment="true"
	 * @generated
	 */
	Diagram getGmfdiagram();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.diagram.MEDiagram#getGmfdiagram
	 * <em>Gmfdiagram</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Gmfdiagram</em>' containment
	 *            reference.
	 * @see #getGmfdiagram()
	 * @generated
	 */
	void setGmfdiagram(Diagram value);

	/**
	 * Returns the value of the '<em><b>New Elements</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Elements</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>New Elements</em>' containment reference.
	 * @see #setNewElements(ModelElement)
	 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram_NewElements()
	 * @model containment="true"
	 * @generated
	 */
	ModelElement getNewElements();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.diagram.MEDiagram#getNewElements
	 * <em>New Elements</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>New Elements</em>' containment
	 *            reference.
	 * @see #getNewElements()
	 * @generated
	 */
	void setNewElements(ModelElement value);

} // MEDiagram
