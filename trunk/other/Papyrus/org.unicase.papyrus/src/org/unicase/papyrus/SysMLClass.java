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
 * A representation of the model object '<em><b>Sys ML Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.papyrus.SysMLClass#getGmfDiagram <em>Gmf Diagram</em>}</li>
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
	 * @model containment="true" resolveProxies="true"
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

} // SysMLClass
