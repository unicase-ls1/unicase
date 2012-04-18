/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.model.Attachment;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.impl.DiagramLoadException;
import org.unicase.model.diagram.impl.DiagramStoreException;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>ME Diagram</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.diagram.MEDiagram#getElements <em>Elements</em>}</li>
 * <li>{@link org.unicase.model.diagram.MEDiagram#getGmfdiagram <em>Gmfdiagram</em>}</li>
 * <li>{@link org.unicase.model.diagram.MEDiagram#getNewElements <em>New Elements</em>}</li>
 * <li>{@link org.unicase.model.diagram.MEDiagram#getDiagramLayout <em>Diagram Layout</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram()
 * @model abstract="true"
 * @generated
 */
public interface MEDiagram extends Attachment {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.UnicaseModelElement}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram_Elements()
	 * @model
	 * @generated
	 */
	EList<UnicaseModelElement> getElements();

	/**
	 * Returns the value of the '<em><b>Gmfdiagram</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gmfdiagram</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gmfdiagram</em>' containment reference.
	 * @see #setGmfdiagram(Diagram)
	 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram_Gmfdiagram()
	 * @model containment="true" resolveProxies="true" transient="true"
	 * @generated
	 */
	Diagram getGmfdiagram();

	/**
	 * Sets the value of the '{@link org.unicase.model.diagram.MEDiagram#getGmfdiagram <em>Gmfdiagram</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Gmfdiagram</em>' containment reference.
	 * @see #getGmfdiagram()
	 * @generated
	 */
	void setGmfdiagram(Diagram value);

	/**
	 * Returns the value of the '<em><b>New Elements</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.UnicaseModelElement}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Elements</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>New Elements</em>' containment reference list.
	 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram_NewElements()
	 * @model containment="true" resolveProxies="true" transient="true"
	 * @generated
	 */
	EList<UnicaseModelElement> getNewElements();

	/**
	 * Returns the value of the '<em><b>Diagram Layout</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Layout</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Diagram Layout</em>' attribute.
	 * @see #setDiagramLayout(String)
	 * @see org.unicase.model.diagram.DiagramPackage#getMEDiagram_DiagramLayout()
	 * @model
	 * @generated
	 */
	String getDiagramLayout();

	/**
	 * Sets the value of the '{@link org.unicase.model.diagram.MEDiagram#getDiagramLayout <em>Diagram Layout</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Diagram Layout</em>' attribute.
	 * @see #getDiagramLayout()
	 * @generated
	 */
	void setDiagramLayout(String value);

	void saveDiagramLayout() throws DiagramStoreException;

	void loadDiagramLayout() throws DiagramLoadException;

	String getType();

} // MEDiagram
