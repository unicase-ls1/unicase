/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see scrm.requirements.dataObject.DataObjectPackage
 * @generated
 */
public interface DataObjectFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataObjectFactory eINSTANCE = scrm.requirements.dataObject.impl.DataObjectFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data</em>'.
	 * @generated
	 */
	Data createData();

	/**
	 * Returns a new object of class '<em>Weather Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Weather Data</em>'.
	 * @generated
	 */
	WeatherData createWeatherData();

	/**
	 * Returns a new object of class '<em>Power Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Consumption</em>'.
	 * @generated
	 */
	PowerConsumption createPowerConsumption();

	/**
	 * Returns a new object of class '<em>HVAC Operation Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HVAC Operation Information</em>'.
	 * @generated
	 */
	HVACOperationInformation createHVACOperationInformation();

	/**
	 * Returns a new object of class '<em>Building Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Building Model</em>'.
	 * @generated
	 */
	BuildingModel createBuildingModel();

	/**
	 * Returns a new object of class '<em>Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Report</em>'.
	 * @generated
	 */
	Report createReport();

	/**
	 * Returns a new object of class '<em>Control Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Schedule</em>'.
	 * @generated
	 */
	ControlSchedule createControlSchedule();

	/**
	 * Returns a new object of class '<em>Geometry Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Geometry Data</em>'.
	 * @generated
	 */
	GeometryData createGeometryData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataObjectPackage getDataObjectPackage();

} //DataObjectFactory
