/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.UnicaseModelElement;

import scrm.SCRMModelElement;
import scrm.requirements.IRequirement;
import scrm.requirements.Requirement;
import scrm.requirements.dataProcess.BuildingModelConstructionProcess;
import scrm.requirements.dataProcess.ControlSystemDesignProcess;
import scrm.requirements.dataProcess.CostMinimizationCalculationProcess;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataVisualizationProcess;
import scrm.requirements.dataProcess.EnergyUsageCalculationProcess;
import scrm.requirements.dataProcess.ErrorHandling;
import scrm.requirements.dataProcess.ReportGenerationProcess;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see scrm.requirements.dataProcess.DataProcessPackage
 * @generated
 */
public class DataProcessAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataProcessPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DataProcessPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataProcessSwitch<Adapter> modelSwitch = new DataProcessSwitch<Adapter>() {
		@Override
		public Adapter caseProcess(scrm.requirements.dataProcess.Process object) {
			return createProcessAdapter();
		}

		@Override
		public Adapter caseDataVisualizationProcess(
				DataVisualizationProcess object) {
			return createDataVisualizationProcessAdapter();
		}

		@Override
		public Adapter caseReportGenerationProcess(
				ReportGenerationProcess object) {
			return createReportGenerationProcessAdapter();
		}

		@Override
		public Adapter caseErrorHandling(ErrorHandling object) {
			return createErrorHandlingAdapter();
		}

		@Override
		public Adapter caseBuildingModelConstructionProcess(
				BuildingModelConstructionProcess object) {
			return createBuildingModelConstructionProcessAdapter();
		}

		@Override
		public Adapter caseCostMinimizationCalculationProcess(
				CostMinimizationCalculationProcess object) {
			return createCostMinimizationCalculationProcessAdapter();
		}

		@Override
		public Adapter caseControlSystemDesignProcess(
				ControlSystemDesignProcess object) {
			return createControlSystemDesignProcessAdapter();
		}

		@Override
		public Adapter caseEnergyUsageCalculationProcess(
				EnergyUsageCalculationProcess object) {
			return createEnergyUsageCalculationProcessAdapter();
		}

		@Override
		public Adapter caseUnicaseModelElement(UnicaseModelElement object) {
			return createUnicaseModelElementAdapter();
		}

		@Override
		public Adapter caseSCRMModelElement(SCRMModelElement object) {
			return createSCRMModelElementAdapter();
		}

		@Override
		public Adapter caseIRequirement(IRequirement object) {
			return createIRequirementAdapter();
		}

		@Override
		public Adapter caseRequirement(Requirement object) {
			return createRequirementAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.ErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.ErrorHandling
	 * @generated
	 */
	public Adapter createErrorHandlingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.BuildingModelConstructionProcess <em>Building Model Construction Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.BuildingModelConstructionProcess
	 * @generated
	 */
	public Adapter createBuildingModelConstructionProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.CostMinimizationCalculationProcess <em>Cost Minimization Calculation Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.CostMinimizationCalculationProcess
	 * @generated
	 */
	public Adapter createCostMinimizationCalculationProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.ControlSystemDesignProcess <em>Control System Design Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.ControlSystemDesignProcess
	 * @generated
	 */
	public Adapter createControlSystemDesignProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.EnergyUsageCalculationProcess <em>Energy Usage Calculation Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.EnergyUsageCalculationProcess
	 * @generated
	 */
	public Adapter createEnergyUsageCalculationProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.Process
	 * @generated
	 */
	public Adapter createProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.DataVisualizationProcess <em>Data Visualization Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.DataVisualizationProcess
	 * @generated
	 */
	public Adapter createDataVisualizationProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.ReportGenerationProcess <em>Report Generation Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.ReportGenerationProcess
	 * @generated
	 */
	public Adapter createReportGenerationProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.UnicaseModelElement <em>Unicase Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.UnicaseModelElement
	 * @generated
	 */
	public Adapter createUnicaseModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.SCRMModelElement <em>SCRM Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.SCRMModelElement
	 * @generated
	 */
	public Adapter createSCRMModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.IRequirement <em>IRequirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.IRequirement
	 * @generated
	 */
	public Adapter createIRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DataProcessAdapterFactory
