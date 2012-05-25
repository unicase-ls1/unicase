/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess;

import scrm.requirements.DataFlow;
import scrm.requirements.Requirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.Process#getDataFlow <em>Data Flow</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.Process#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.Process#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.Process#getContainingDataProcessSpace <em>Containing Data Process Space</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.Process#getErrorHandling <em>Error Handling</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.Process#getStatusMonitoring <em>Status Monitoring</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.dataProcess.DataProcessPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends Requirement {
	/**
	 * Returns the value of the '<em><b>Data Flow</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.DataFlow#getSpecifiedProcess <em>Specified Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Flow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Flow</em>' reference.
	 * @see #setDataFlow(DataFlow)
	 * @see scrm.requirements.dataProcess.DataProcessPackage#getProcess_DataFlow()
	 * @see scrm.requirements.DataFlow#getSpecifiedProcess
	 * @model opposite="specifiedProcess"
	 *        annotation="org.eclipse.emf.ecp.editor position='left' priority='15'"
	 * @generated
	 */
	DataFlow getDataFlow();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataProcess.Process#getDataFlow <em>Data Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Flow</em>' reference.
	 * @see #getDataFlow()
	 * @generated
	 */
	void setDataFlow(DataFlow value);

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
	 *        annotation="org.eclipse.emf.ecp.editor position='left' priority='15'"
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
	 *        annotation="org.eclipse.emf.ecp.editor position='left' priority='20'"
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
	 * Returns the value of the '<em><b>Containing Data Process Space</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataProcess.DataProcessSpace#getContainedDataProcessSteps <em>Contained Data Process Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Data Process Space</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Data Process Space</em>' container reference.
	 * @see #setContainingDataProcessSpace(DataProcessSpace)
	 * @see scrm.requirements.dataProcess.DataProcessPackage#getProcess_ContainingDataProcessSpace()
	 * @see scrm.requirements.dataProcess.DataProcessSpace#getContainedDataProcessSteps
	 * @model opposite="containedDataProcessSteps" transient="false"
	 *        annotation="org.eclipse.emf.ecp.editor position='left' priority='10'"
	 * @generated
	 */
	DataProcessSpace getContainingDataProcessSpace();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataProcess.Process#getContainingDataProcessSpace <em>Containing Data Process Space</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Data Process Space</em>' container reference.
	 * @see #getContainingDataProcessSpace()
	 * @generated
	 */
	void setContainingDataProcessSpace(DataProcessSpace value);

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

	/**
	 * Returns the value of the '<em><b>Status Monitoring</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataProcess.StatusMonitoring#getMonitoredProcess <em>Monitored Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Monitoring</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Monitoring</em>' reference.
	 * @see #setStatusMonitoring(StatusMonitoring)
	 * @see scrm.requirements.dataProcess.DataProcessPackage#getProcess_StatusMonitoring()
	 * @see scrm.requirements.dataProcess.StatusMonitoring#getMonitoredProcess
	 * @model opposite="monitoredProcess"
	 * @generated
	 */
	StatusMonitoring getStatusMonitoring();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataProcess.Process#getStatusMonitoring <em>Status Monitoring</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Monitoring</em>' reference.
	 * @see #getStatusMonitoring()
	 * @generated
	 */
	void setStatusMonitoring(StatusMonitoring value);

} // Process
