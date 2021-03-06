/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess;

import scrm.requirements.Requirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.Process#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.Process#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.Process#getErrorHandling <em>Error Handling</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.dataProcess.DataProcessPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends Requirement {
	/**
	 * Returns the value of the '<em><b>Predecessor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataProcess.Process#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor</em>' reference.
	 * @see #setPredecessor(Process)
	 * @see scrm.requirements.dataProcess.DataProcessPackage#getProcess_Predecessor()
	 * @see scrm.requirements.dataProcess.Process#getSuccessor
	 * @model opposite="successor"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	Process getPredecessor();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataProcess.Process#getPredecessor <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor</em>' reference.
	 * @see #getPredecessor()
	 * @generated
	 */
	void setPredecessor(Process value);

	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataProcess.Process#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(Process)
	 * @see scrm.requirements.dataProcess.DataProcessPackage#getProcess_Successor()
	 * @see scrm.requirements.dataProcess.Process#getPredecessor
	 * @model opposite="predecessor"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	Process getSuccessor();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataProcess.Process#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(Process value);

	/**
	 * Returns the value of the '<em><b>Error Handling</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataProcess.ErrorHandling#getHandledProcess <em>Handled Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Handling</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Handling</em>' reference.
	 * @see #setErrorHandling(ErrorHandling)
	 * @see scrm.requirements.dataProcess.DataProcessPackage#getProcess_ErrorHandling()
	 * @see scrm.requirements.dataProcess.ErrorHandling#getHandledProcess
	 * @model opposite="handledProcess"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='20'"
	 * @generated
	 */
	ErrorHandling getErrorHandling();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataProcess.Process#getErrorHandling <em>Error Handling</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Handling</em>' reference.
	 * @see #getErrorHandling()
	 * @generated
	 */
	void setErrorHandling(ErrorHandling value);

} // Process
