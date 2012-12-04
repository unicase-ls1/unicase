/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import scrm.requirements.dataObject.BuildingModel;
import scrm.requirements.dataObject.ControlSchedule;
import scrm.requirements.dataObject.Data;
import scrm.requirements.dataObject.DataObjectFactory;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataObject.GeometryData;
import scrm.requirements.dataObject.HVACOperationInformation;
import scrm.requirements.dataObject.PowerConsumption;
import scrm.requirements.dataObject.Report;
import scrm.requirements.dataObject.WeatherData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataObjectFactoryImpl extends EFactoryImpl implements
		DataObjectFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataObjectFactory init() {
		try {
			DataObjectFactory theDataObjectFactory = (DataObjectFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/model/scrm/requirements/dataObject");
			if (theDataObjectFactory != null) {
				return theDataObjectFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataObjectFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObjectFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case DataObjectPackage.DATA:
			return createData();
		case DataObjectPackage.WEATHER_DATA:
			return createWeatherData();
		case DataObjectPackage.POWER_CONSUMPTION:
			return createPowerConsumption();
		case DataObjectPackage.HVAC_OPERATION_INFORMATION:
			return createHVACOperationInformation();
		case DataObjectPackage.BUILDING_MODEL:
			return createBuildingModel();
		case DataObjectPackage.REPORT:
			return createReport();
		case DataObjectPackage.CONTROL_SCHEDULE:
			return createControlSchedule();
		case DataObjectPackage.GEOMETRY_DATA:
			return createGeometryData();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data createData() {
		DataImpl data = new DataImpl();
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeatherData createWeatherData() {
		WeatherDataImpl weatherData = new WeatherDataImpl();
		return weatherData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerConsumption createPowerConsumption() {
		PowerConsumptionImpl powerConsumption = new PowerConsumptionImpl();
		return powerConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HVACOperationInformation createHVACOperationInformation() {
		HVACOperationInformationImpl hvacOperationInformation = new HVACOperationInformationImpl();
		return hvacOperationInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildingModel createBuildingModel() {
		BuildingModelImpl buildingModel = new BuildingModelImpl();
		return buildingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Report createReport() {
		ReportImpl report = new ReportImpl();
		return report;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlSchedule createControlSchedule() {
		ControlScheduleImpl controlSchedule = new ControlScheduleImpl();
		return controlSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryData createGeometryData() {
		GeometryDataImpl geometryData = new GeometryDataImpl();
		return geometryData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObjectPackage getDataObjectPackage() {
		return (DataObjectPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataObjectPackage getPackage() {
		return DataObjectPackage.eINSTANCE;
	}

} //DataObjectFactoryImpl
