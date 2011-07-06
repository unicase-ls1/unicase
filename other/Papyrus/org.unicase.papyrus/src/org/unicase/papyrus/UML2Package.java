/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.papyrus;

import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML2 Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.papyrus.UML2Package#getGmfDiagram <em>Gmf Diagram</em>}</li>
 *   <li>{@link org.unicase.papyrus.UML2Package#getDiagramType <em>Diagram Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.papyrus.PapyrusPackage#getUML2Package()
 * @model
 * @generated
 */
public interface UML2Package extends org.eclipse.uml2.uml.Package {
	/**
	 * Returns the value of the '<em><b>Gmf Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gmf Diagram</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gmf Diagram</em>' containment reference.
	 * @see #setGmfDiagram(Diagram)
	 * @see org.unicase.papyrus.PapyrusPackage#getUML2Package_GmfDiagram()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Diagram getGmfDiagram();

	/**
	 * Sets the value of the '{@link org.unicase.papyrus.UML2Package#getGmfDiagram <em>Gmf Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gmf Diagram</em>' containment reference.
	 * @see #getGmfDiagram()
	 * @generated
	 */
	void setGmfDiagram(Diagram value);

	/**
	 * Returns the value of the '<em><b>Diagram Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.unicase.papyrus.UMLDiagramType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Type</em>' attribute.
	 * @see org.unicase.papyrus.UMLDiagramType
	 * @see #setDiagramType(UMLDiagramType)
	 * @see org.unicase.papyrus.PapyrusPackage#getUML2Package_DiagramType()
	 * @model default=""
	 * @generated
	 */
	UMLDiagramType getDiagramType();

	/**
	 * Sets the value of the '{@link org.unicase.papyrus.UML2Package#getDiagramType <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Type</em>' attribute.
	 * @see org.unicase.papyrus.UMLDiagramType
	 * @see #getDiagramType()
	 * @generated
	 */
	void setDiagramType(UMLDiagramType value);

} // UML2Package
