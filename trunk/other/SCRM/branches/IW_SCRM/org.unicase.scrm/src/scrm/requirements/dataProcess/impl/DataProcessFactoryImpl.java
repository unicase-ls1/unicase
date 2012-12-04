/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import scrm.requirements.dataProcess.BuildingModelConstructionProcess;
import scrm.requirements.dataProcess.ControlSystemDesignProcess;
import scrm.requirements.dataProcess.CostMinimizationCalculationProcess;
import scrm.requirements.dataProcess.DataProcessFactory;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataVisualizationProcess;
import scrm.requirements.dataProcess.EnergyUsageCalculationProcess;
import scrm.requirements.dataProcess.ErrorHandling;
import scrm.requirements.dataProcess.ReportGenerationProcess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataProcessFactoryImpl extends EFactoryImpl implements
		DataProcessFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataProcessFactory init() {
		try {
			DataProcessFactory theDataProcessFactory = (DataProcessFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/model/scrm/requirements/dataProcess");
			if (theDataProcessFactory != null) {
				return theDataProcessFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataProcessFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessFactoryImpl() {
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
		case DataProcessPackage.PROCESS:
			return createProcess();
		case DataProcessPackage.DATA_VISUALIZATION_PROCESS:
			return createDataVisualizationProcess();
		case DataProcessPackage.REPORT_GENERATION_PROCESS:
			return createReportGenerationProcess();
		case DataProcessPackage.ERROR_HANDLING:
			return createErrorHandling();
		case DataProcessPackage.BUILDING_MODEL_CONSTRUCTION_PROCESS:
			return createBuildingModelConstructionProcess();
		case DataProcessPackage.COST_MINIMIZATION_CALCULATION_PROCESS:
			return createCostMinimizationCalculationProcess();
		case DataProcessPackage.CONTROL_SYSTEM_DESIGN_PROCESS:
			return createControlSystemDesignProcess();
		case DataProcessPackage.ENERGY_USAGE_CALCULATION_PROCESS:
			return createEnergyUsageCalculationProcess();
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
	public ErrorHandling createErrorHandling() {
		ErrorHandlingImpl errorHandling = new ErrorHandlingImpl();
		return errorHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildingModelConstructionProcess createBuildingModelConstructionProcess() {
		BuildingModelConstructionProcessImpl buildingModelConstructionProcess = new BuildingModelConstructionProcessImpl();
		return buildingModelConstructionProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostMinimizationCalculationProcess createCostMinimizationCalculationProcess() {
		CostMinimizationCalculationProcessImpl costMinimizationCalculationProcess = new CostMinimizationCalculationProcessImpl();
		return costMinimizationCalculationProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlSystemDesignProcess createControlSystemDesignProcess() {
		ControlSystemDesignProcessImpl controlSystemDesignProcess = new ControlSystemDesignProcessImpl();
		return controlSystemDesignProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnergyUsageCalculationProcess createEnergyUsageCalculationProcess() {
		EnergyUsageCalculationProcessImpl energyUsageCalculationProcess = new EnergyUsageCalculationProcessImpl();
		return energyUsageCalculationProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataVisualizationProcess createDataVisualizationProcess() {
		DataVisualizationProcessImpl dataVisualizationProcess = new DataVisualizationProcessImpl();
		return dataVisualizationProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportGenerationProcess createReportGenerationProcess() {
		ReportGenerationProcessImpl reportGenerationProcess = new ReportGenerationProcessImpl();
		return reportGenerationProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessPackage getDataProcessPackage() {
		return (DataProcessPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataProcessPackage getPackage() {
		return DataProcessPackage.eINSTANCE;
	}

} //DataProcessFactoryImpl
