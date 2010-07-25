/**
 * <copyright> </copyright> $Id$
 */
package urml.danger;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see urml.danger.DangerPackage
 * @generated
 */
public interface DangerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DangerFactory eINSTANCE = urml.danger.impl.DangerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Danger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Danger</em>'.
	 * @generated
	 */
	Danger createDanger();

	/**
	 * Returns a new object of class '<em>Procedural Mitigation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Procedural Mitigation</em>'.
	 * @generated
	 */
	ProceduralMitigation createProceduralMitigation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DangerPackage getDangerPackage();

} //DangerFactory
