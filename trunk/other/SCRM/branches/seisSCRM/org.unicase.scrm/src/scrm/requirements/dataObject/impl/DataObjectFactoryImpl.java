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

import scrm.requirements.dataObject.ComputationalMesh;
import scrm.requirements.dataObject.ControlParameter;
import scrm.requirements.dataObject.DataDefinition;
import scrm.requirements.dataObject.DataObjectFactory;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataObject.SeismicSource;
import scrm.requirements.dataObject.Station;
import scrm.requirements.dataObject.SyntheticSeismogram;

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
		case DataObjectPackage.DATA_DEFINITION:
			return createDataDefinition();
		case DataObjectPackage.SEISMIC_SOURCE:
			return createSeismicSource();
		case DataObjectPackage.COMPUTATIONAL_MESH:
			return createComputationalMesh();
		case DataObjectPackage.SYNTHETIC_SEISMOGRAM:
			return createSyntheticSeismogram();
		case DataObjectPackage.STATION:
			return createStation();
		case DataObjectPackage.CONTROL_PARAMETER:
			return createControlParameter();
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
	public DataDefinition createDataDefinition() {
		DataDefinitionImpl dataDefinition = new DataDefinitionImpl();
		return dataDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeismicSource createSeismicSource() {
		SeismicSourceImpl seismicSource = new SeismicSourceImpl();
		return seismicSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationalMesh createComputationalMesh() {
		ComputationalMeshImpl computationalMesh = new ComputationalMeshImpl();
		return computationalMesh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntheticSeismogram createSyntheticSeismogram() {
		SyntheticSeismogramImpl syntheticSeismogram = new SyntheticSeismogramImpl();
		return syntheticSeismogram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Station createStation() {
		StationImpl station = new StationImpl();
		return station;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlParameter createControlParameter() {
		ControlParameterImpl controlParameter = new ControlParameterImpl();
		return controlParameter;
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
