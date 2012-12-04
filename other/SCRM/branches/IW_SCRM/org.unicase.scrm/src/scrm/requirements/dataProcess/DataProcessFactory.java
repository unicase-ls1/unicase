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
	 * Returns a new object of class '<em>Error Handling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Handling</em>'.
	 * @generated
	 */
	ErrorHandling createErrorHandling();

	/**
	 * Returns a new object of class '<em>Building Model Construction Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Building Model Construction Process</em>'.
	 * @generated
	 */
	BuildingModelConstructionProcess createBuildingModelConstructionProcess();

	/**
	 * Returns a new object of class '<em>Cost Minimization Calculation Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cost Minimization Calculation Process</em>'.
	 * @generated
	 */
	CostMinimizationCalculationProcess createCostMinimizationCalculationProcess();

	/**
	 * Returns a new object of class '<em>Control System Design Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control System Design Process</em>'.
	 * @generated
	 */
	ControlSystemDesignProcess createControlSystemDesignProcess();

	/**
	 * Returns a new object of class '<em>Energy Usage Calculation Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Energy Usage Calculation Process</em>'.
	 * @generated
	 */
	EnergyUsageCalculationProcess createEnergyUsageCalculationProcess();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	Process createProcess();

	/**
	 * Returns a new object of class '<em>Data Visualization Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Visualization Process</em>'.
	 * @generated
	 */
	DataVisualizationProcess createDataVisualizationProcess();

	/**
	 * Returns a new object of class '<em>Report Generation Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Report Generation Process</em>'.
	 * @generated
	 */
	ReportGenerationProcess createReportGenerationProcess();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataProcessPackage getDataProcessPackage();

} //DataProcessFactory
