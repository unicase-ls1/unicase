/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Process#getDataFlow <em>Data Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends Requirement {
	/**
	 * Returns the value of the '<em><b>Data Flow</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.DataFlow#getSpecifiedProcess <em>Specified Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Flow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Flow</em>' containment reference.
	 * @see #setDataFlow(DataFlow)
	 * @see scrm.requirements.RequirementsPackage#getProcess_DataFlow()
	 * @see scrm.requirements.DataFlow#getSpecifiedProcess
	 * @model opposite="specifiedProcess" containment="true"
	 * @generated
	 */
	DataFlow getDataFlow();

	/**
	 * Sets the value of the '{@link scrm.requirements.Process#getDataFlow <em>Data Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Flow</em>' containment reference.
	 * @see #getDataFlow()
	 * @generated
	 */
	void setDataFlow(DataFlow value);

} // Process
