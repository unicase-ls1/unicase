/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see scrm.requirements.dataProcess.DataProcessPackage
 * @generated
 */
public interface DataProcessFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataProcessFactory eINSTANCE = scrm.requirements.dataProcess.impl.DataProcessFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Input Data Reading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Data Reading</em>'.
	 * @generated
	 */
	InputDataReading createInputDataReading();

	/**
	 * Returns a new object of class '<em>Results Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Results Output</em>'.
	 * @generated
	 */
	ResultsOutput createResultsOutput();

	/**
	 * Returns a new object of class '<em>Error Handling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Handling</em>'.
	 * @generated
	 */
	ErrorHandling createErrorHandling();

	/**
	 * Returns a new object of class '<em>Status Monitoring</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Status Monitoring</em>'.
	 * @generated
	 */
	StatusMonitoring createStatusMonitoring();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	Process createProcess();

	/**
	 * Returns a new object of class '<em>Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Space</em>'.
	 * @generated
	 */
	DataProcessSpace createDataProcessSpace();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataProcessPackage getDataProcessPackage();

} //DataProcessFactory
