/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.usecase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.model.urml.usecase.UsecasePackage
 * @generated
 */
public interface UsecaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	UsecaseFactory eINSTANCE = org.unicase.model.urml.usecase.impl.UsecaseFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Application Domain Use Case</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Application Domain Use Case</em>'.
	 * @generated
	 */
	ApplicationDomainUseCase createApplicationDomainUseCase();

	/**
	 * Returns a new object of class '<em>Solution Domain Use Case</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Solution Domain Use Case</em>'.
	 * @generated
	 */
	SolutionDomainUseCase createSolutionDomainUseCase();

	/**
	 * Returns a new object of class '<em>Actor</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor</em>'.
	 * @generated
	 */
	Actor createActor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UsecasePackage getUsecasePackage();

} // UsecaseFactory
