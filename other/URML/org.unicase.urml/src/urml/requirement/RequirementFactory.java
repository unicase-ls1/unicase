/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see urml.requirement.RequirementPackage
 * @generated
 */
public interface RequirementFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	RequirementFactory eINSTANCE = urml.requirement.impl.RequirementFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Functional Requirement</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Functional Requirement</em>'.
	 * @generated
	 */
	FunctionalRequirement createFunctionalRequirement();

	/**
	 * Returns a new object of class '<em>Non Functional Requirement</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Non Functional Requirement</em>'.
	 * @generated
	 */
	NonFunctionalRequirement createNonFunctionalRequirement();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	RequirementPackage getRequirementPackage();

} // RequirementFactory
