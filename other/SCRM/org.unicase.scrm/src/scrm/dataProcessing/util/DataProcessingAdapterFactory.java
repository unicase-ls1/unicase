/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.dataProcessing.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import scrm.SCRMModelElement;

import scrm.dataProcessing.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see scrm.dataProcessing.DataProcessingPackage
 * @generated
 */
public class DataProcessingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataProcessingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DataProcessingPackage.eINSTANCE;
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
	protected DataProcessingSwitch<Adapter> modelSwitch = new DataProcessingSwitch<Adapter>() {
		@Override
		public Adapter caseDataProcessing(DataProcessing object) {
			return createDataProcessingAdapter();
		}

		@Override
		public Adapter caseInputDataReading(InputDataReading object) {
			return createInputDataReadingAdapter();
		}

		@Override
		public Adapter caseDataHandling(DataHandling object) {
			return createDataHandlingAdapter();
		}

		@Override
		public Adapter caseResultsOutput(ResultsOutput object) {
			return createResultsOutputAdapter();
		}

		@Override
		public Adapter caseErrorHandling(ErrorHandling object) {
			return createErrorHandlingAdapter();
		}

		@Override
		public Adapter caseStatusMonitoring(StatusMonitoring object) {
			return createStatusMonitoringAdapter();
		}

		@Override
		public Adapter caseSCRMModelElement(SCRMModelElement object) {
			return createSCRMModelElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link scrm.dataProcessing.DataProcessing <em>Data Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.dataProcessing.DataProcessing
	 * @generated
	 */
	public Adapter createDataProcessingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.dataProcessing.InputDataReading <em>Input Data Reading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.dataProcessing.InputDataReading
	 * @generated
	 */
	public Adapter createInputDataReadingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.dataProcessing.DataHandling <em>Data Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.dataProcessing.DataHandling
	 * @generated
	 */
	public Adapter createDataHandlingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.dataProcessing.ResultsOutput <em>Results Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.dataProcessing.ResultsOutput
	 * @generated
	 */
	public Adapter createResultsOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.dataProcessing.ErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.dataProcessing.ErrorHandling
	 * @generated
	 */
	public Adapter createErrorHandlingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.dataProcessing.StatusMonitoring <em>Status Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.dataProcessing.StatusMonitoring
	 * @generated
	 */
	public Adapter createStatusMonitoringAdapter() {
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

} //DataProcessingAdapterFactory
