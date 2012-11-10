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
	 * Returns a new object of class '<em>Data Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Definition</em>'.
	 * @generated
	 */
	DataDefinition createDataDefinition();

	/**
	 * Returns a new object of class '<em>Seismic Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Seismic Source</em>'.
	 * @generated
	 */
	SeismicSource createSeismicSource();

	/**
	 * Returns a new object of class '<em>Computational Mesh</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computational Mesh</em>'.
	 * @generated
	 */
	ComputationalMesh createComputationalMesh();

	/**
	 * Returns a new object of class '<em>Synthetic Seismogram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Synthetic Seismogram</em>'.
	 * @generated
	 */
	SyntheticSeismogram createSyntheticSeismogram();

	/**
	 * Returns a new object of class '<em>Station</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Station</em>'.
	 * @generated
	 */
	Station createStation();

	/**
	 * Returns a new object of class '<em>Control Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Parameter</em>'.
	 * @generated
	 */
	ControlParameter createControlParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataObjectPackage getDataObjectPackage();

} //DataObjectFactory
