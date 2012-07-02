/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>UML Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.papyrus.UMLModel#getGmfDiagram <em>Gmf Diagram</em>}</li>
 * <li>{@link org.unicase.papyrus.UMLModel#getDiagramType <em>Diagram Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.papyrus.PapyrusPackage#getUMLModel()
 * @model
 * @generated
 */
public interface UMLModel extends Model {
	/**
	 * Returns the value of the '<em><b>Gmf Diagram</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gmf Diagram</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gmf Diagram</em>' containment reference.
	 * @see #setGmfDiagram(Diagram)
	 * @see org.unicase.papyrus.PapyrusPackage#getUMLModel_GmfDiagram()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Diagram getGmfDiagram();

	/**
	 * Sets the value of the '{@link org.unicase.papyrus.UMLModel#getGmfDiagram <em>Gmf Diagram</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Gmf Diagram</em>' containment reference.
	 * @see #getGmfDiagram()
	 * @generated
	 */
	void setGmfDiagram(Diagram value);

	/**
	 * Returns the value of the '<em><b>Diagram Type</b></em>' attribute. The default value is <code>""</code>. The
	 * literals are from the enumeration {@link org.unicase.papyrus.UMLDiagramType}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Type</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Diagram Type</em>' attribute.
	 * @see org.unicase.papyrus.UMLDiagramType
	 * @see #setDiagramType(UMLDiagramType)
	 * @see org.unicase.papyrus.PapyrusPackage#getUMLModel_DiagramType()
	 * @model default=""
	 * @generated
	 */
	UMLDiagramType getDiagramType();

	/**
	 * Sets the value of the '{@link org.unicase.papyrus.UMLModel#getDiagramType <em>Diagram Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Diagram Type</em>' attribute.
	 * @see org.unicase.papyrus.UMLDiagramType
	 * @see #getDiagramType()
	 * @generated
	 */
	void setDiagramType(UMLDiagramType value);

} // UMLModel
