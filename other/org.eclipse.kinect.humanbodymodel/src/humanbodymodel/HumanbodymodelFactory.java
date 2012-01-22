/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package humanbodymodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see humanbodymodel.HumanbodymodelPackage
 * @generated
 */
public interface HumanbodymodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HumanbodymodelFactory eINSTANCE = humanbodymodel.impl.HumanbodymodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Human</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Human</em>'.
	 * @generated
	 */
	Human createHuman();

	/**
	 * Returns a new object of class '<em>Positioned Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Positioned Element</em>'.
	 * @generated
	 */
	PositionedElement createPositionedElement();

	/**
	 * Returns a new object of class '<em>Human Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Human Container</em>'.
	 * @generated
	 */
	HumanContainer createHumanContainer();

	/**
	 * Returns a new object of class '<em>Human Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Human Link</em>'.
	 * @generated
	 */
	HumanLink createHumanLink();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HumanbodymodelPackage getHumanbodymodelPackage();

} //HumanbodymodelFactory
