/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCRM Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.SCRMSpace#getRepresentingDiagram <em>Representing Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.ScrmPackage#getSCRMSpace()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SCRMSpace extends SCRMModelElement {
	/**
	 * Returns the value of the '<em><b>Representing Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representing Diagram</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representing Diagram</em>' reference.
	 * @see #setRepresentingDiagram(SCRMDiagram)
	 * @see scrm.ScrmPackage#getSCRMSpace_RepresentingDiagram()
	 * @model
	 * @generated
	 */
	SCRMDiagram getRepresentingDiagram();

	/**
	 * Sets the value of the '{@link scrm.SCRMSpace#getRepresentingDiagram <em>Representing Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representing Diagram</em>' reference.
	 * @see #getRepresentingDiagram()
	 * @generated
	 */
	void setRepresentingDiagram(SCRMDiagram value);

	/**
	 * Returns the value of the '<em><b>Contained Model Elements</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.SCRMModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Model Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Model Elements</em>' containment reference list.
	 * @see scrm.ScrmPackage#getSCRMSpace_ContainedModelElements()
	 * @model containment="true" resolveProxies="true"
	 * @generated NOT
	 */
	EList<SCRMModelElement> getContainedModelElements();

} // SCRMSpace
