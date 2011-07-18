/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcessing;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see scrm.requirements.dataProcessing.DataProcessingPackage
 * @generated
 */
public interface DataProcessingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataProcessingFactory eINSTANCE = scrm.requirements.dataProcessing.impl.DataProcessingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Input Data Reading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Data Reading</em>'.
	 * @generated
	 */
	InputDataReading createInputDataReading();

	/**
	 * Returns a new object of class '<em>Data Handling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Handling</em>'.
	 * @generated
	 */
	DataHandling createDataHandling();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataProcessingPackage getDataProcessingPackage();

} //DataProcessingFactory
