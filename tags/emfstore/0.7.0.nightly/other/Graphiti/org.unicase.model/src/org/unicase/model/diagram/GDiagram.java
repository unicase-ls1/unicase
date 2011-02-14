/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram;

import org.eclipse.graphiti.mm.pictograms.Diagram;

import org.unicase.model.Attachment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GDiagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.diagram.GDiagram#getGraphitiDiagram <em>Graphiti Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.diagram.DiagramPackage#getGDiagram()
 * @model abstract="true"
 * @generated
 */
public interface GDiagram extends Attachment {
	/**
	 * Returns the value of the '<em><b>Graphiti Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphiti Diagram</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphiti Diagram</em>' containment reference.
	 * @see #setGraphitiDiagram(Diagram)
	 * @see org.unicase.model.diagram.DiagramPackage#getGDiagram_GraphitiDiagram()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Diagram getGraphitiDiagram();

	/**
	 * Sets the value of the '{@link org.unicase.model.diagram.GDiagram#getGraphitiDiagram <em>Graphiti Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphiti Diagram</em>' containment reference.
	 * @see #getGraphitiDiagram()
	 * @generated
	 */
	void setGraphitiDiagram(Diagram value);

} // GDiagram
