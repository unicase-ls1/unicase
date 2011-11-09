/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status Monitoring</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.StatusMonitoring#getMonitoredProcess <em>Monitored Process</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.dataProcess.DataProcessPackage#getStatusMonitoring()
 * @model
 * @generated
 */
public interface StatusMonitoring extends scrm.requirements.dataProcess.Process {

	/**
	 * Returns the value of the '<em><b>Monitored Process</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataProcess.Process#getStatusMonitoring <em>Status Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitored Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitored Process</em>' reference.
	 * @see #setMonitoredProcess(scrm.requirements.dataProcess.Process)
	 * @see scrm.requirements.dataProcess.DataProcessPackage#getStatusMonitoring_MonitoredProcess()
	 * @see scrm.requirements.dataProcess.Process#getStatusMonitoring
	 * @model opposite="statusMonitoring"
	 * @generated
	 */
	scrm.requirements.dataProcess.Process getMonitoredProcess();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataProcess.StatusMonitoring#getMonitoredProcess <em>Monitored Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitored Process</em>' reference.
	 * @see #getMonitoredProcess()
	 * @generated
	 */
	void setMonitoredProcess(scrm.requirements.dataProcess.Process value);
} // StatusMonitoring
