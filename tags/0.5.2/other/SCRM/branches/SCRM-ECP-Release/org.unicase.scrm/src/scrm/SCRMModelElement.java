/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCRM Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.SCRMModelElement#getName <em>Name</em>}</li>
 *   <li>{@link scrm.SCRMModelElement#getDescription <em>Description</em>}</li>
 *   <li>{@link scrm.SCRMModelElement#getDisplayingDiagrams <em>Displaying Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.ScrmPackage#getSCRMModelElement()
 * @model abstract="true"
 * @generated
 */
public interface SCRMModelElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see scrm.ScrmPackage#getSCRMModelElement_Name()
	 * @model default=""
	 *        annotation="org.eclipse.emf.ecp.editor position='left' priority='1'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link scrm.SCRMModelElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see scrm.ScrmPackage#getSCRMModelElement_Description()
	 * @model annotation="org.eclipse.emf.ecp.editor position='left' priority='2'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link scrm.SCRMModelElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * The list contents are of type {@link scrm.SCRMDiagram}.
	 * It is bidirectional and its opposite is '{@link scrm.SCRMDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Displaying Diagrams</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Displaying Diagrams</em>' reference list.
	 * @see scrm.ScrmPackage#getSCRMModelElement_DisplayingDiagrams()
	 * @see scrm.SCRMDiagram#getElements
	 * @model opposite="elements"
	 * @generated
	 */
	EList<SCRMDiagram> getDisplayingDiagrams();

} // SCRMModelElement
