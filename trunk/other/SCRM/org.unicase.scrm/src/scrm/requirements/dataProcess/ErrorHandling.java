/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Handling</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.ErrorHandling#getHandledProcess <em>Handled Process</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.dataProcess.DataProcessPackage#getErrorHandling()
 * @model
 * @generated
 */
public interface ErrorHandling extends scrm.requirements.dataProcess.Process {

	/**
	 * Returns the value of the '<em><b>Handled Process</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataProcess.Process#getErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handled Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handled Process</em>' reference.
	 * @see #setHandledProcess(scrm.requirements.dataProcess.Process)
	 * @see scrm.requirements.dataProcess.DataProcessPackage#getErrorHandling_HandledProcess()
	 * @see scrm.requirements.dataProcess.Process#getErrorHandling
	 * @model opposite="errorHandling"
	 * @generated
	 */
	scrm.requirements.dataProcess.Process getHandledProcess();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataProcess.ErrorHandling#getHandledProcess <em>Handled Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handled Process</em>' reference.
	 * @see #getHandledProcess()
	 * @generated
	 */
	void setHandledProcess(scrm.requirements.dataProcess.Process value);
} // ErrorHandling
