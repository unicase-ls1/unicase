/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.papyrus;

import java.io.IOException;

import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sys ML Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.papyrus.SysMLClass#getGmfDiagram <em>Gmf Diagram</em>}</li>
 *   <li>{@link org.unicase.papyrus.SysMLClass#getDiagramLayout <em>Diagram Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.papyrus.PapyrusPackage#getSysMLClass()
 * @model
 * @generated
 */
public interface SysMLClass extends org.eclipse.uml2.uml.Class {

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
	 * @see org.unicase.papyrus.PapyrusPackage#getSysMLClass_GmfDiagram()
	 * @model containment="true" resolveProxies="true" transient="true"
	 * @generated
	 */
	Diagram getGmfDiagram();

	/**
	 * Sets the value of the '{@link org.unicase.papyrus.SysMLClass#getGmfDiagram <em>Gmf Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gmf Diagram</em>' containment reference.
	 * @see #getGmfDiagram()
	 * @generated
	 */
	void setGmfDiagram(Diagram value);

	/**
	 * Returns the value of the '<em><b>Diagram Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Layout</em>' attribute.
	 * @see #setDiagramLayout(String)
	 * @see org.unicase.papyrus.PapyrusPackage#getSysMLClass_DiagramLayout()
	 * @model dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getDiagramLayout();

	/**
	 * Sets the value of the '{@link org.unicase.papyrus.SysMLClass#getDiagramLayout <em>Diagram Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Layout</em>' attribute.
	 * @see #getDiagramLayout()
	 * @generated
	 */
	void setDiagramLayout(String value);
	
	void saveDiagramLayout() throws IOException;

	void loadDiagramLayout() throws IOException;

} // SysMLClass
