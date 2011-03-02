/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.DataDefinition#getDefinedRequirement <em>Defined Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getDataDefinition()
 * @model
 * @generated
 */
public interface DataDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Defined Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Requirement#getDefiningData <em>Defining Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Requirement</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Requirement</em>' container reference.
	 * @see #setDefinedRequirement(Requirement)
	 * @see scrm.requirements.RequirementsPackage#getDataDefinition_DefinedRequirement()
	 * @see scrm.requirements.Requirement#getDefiningData
	 * @model opposite="definingData" transient="false"
	 * @generated
	 */
	Requirement getDefinedRequirement();

	/**
	 * Sets the value of the '{@link scrm.requirements.DataDefinition#getDefinedRequirement <em>Defined Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defined Requirement</em>' container reference.
	 * @see #getDefinedRequirement()
	 * @generated
	 */
	void setDefinedRequirement(Requirement value);

} // DataDefinition
