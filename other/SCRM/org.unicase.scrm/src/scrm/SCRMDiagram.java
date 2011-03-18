/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCRM Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.SCRMDiagram#getElements <em>Elements</em>}</li>
 *   <li>{@link scrm.SCRMDiagram#getNewElements <em>New Elements</em>}</li>
 *   <li>{@link scrm.SCRMDiagram#getDiagramLayout <em>Diagram Layout</em>}</li>
 *   <li>{@link scrm.SCRMDiagram#getGmfdiagram <em>Gmfdiagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.ScrmPackage#getSCRMDiagram()
 * @model
 * @generated
 */
public interface SCRMDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link scrm.SCRMModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see scrm.ScrmPackage#getSCRMDiagram_Elements()
	 * @model
	 * @generated
	 */
	EList<SCRMModelElement> getElements();

	/**
	 * Returns the value of the '<em><b>New Elements</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.SCRMModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Elements</em>' containment reference list.
	 * @see scrm.ScrmPackage#getSCRMDiagram_NewElements()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<SCRMModelElement> getNewElements();

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
	 * @see scrm.ScrmPackage#getSCRMDiagram_DiagramLayout()
	 * @model
	 * @generated
	 */
	String getDiagramLayout();

	/**
	 * Sets the value of the '{@link scrm.SCRMDiagram#getDiagramLayout <em>Diagram Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Layout</em>' attribute.
	 * @see #getDiagramLayout()
	 * @generated
	 */
	void setDiagramLayout(String value);

	/**
	 * Returns the value of the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gmfdiagram</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gmfdiagram</em>' containment reference.
	 * @see #setGmfdiagram(Diagram)
	 * @see scrm.ScrmPackage#getSCRMDiagram_Gmfdiagram()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	Diagram getGmfdiagram();

	/**
	 * Sets the value of the '{@link scrm.SCRMDiagram#getGmfdiagram <em>Gmfdiagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gmfdiagram</em>' containment reference.
	 * @see #getGmfdiagram()
	 * @generated
	 */
	void setGmfdiagram(Diagram value);

} // SCRMDiagram