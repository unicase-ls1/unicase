/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.usecase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.urml.usecase.*;
import org.unicase.model.urml.usecase.Actor;
import org.unicase.model.urml.usecase.ApplicationDomainUseCase;
import org.unicase.model.urml.usecase.SolutionDomainUseCase;
import org.unicase.model.urml.usecase.UsecaseFactory;
import org.unicase.model.urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class UsecaseFactoryImpl extends EFactoryImpl implements UsecaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static UsecaseFactory init() {
		try {
			UsecaseFactory theUsecaseFactory = (UsecaseFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/model/urml/usecase");
			if (theUsecaseFactory != null) {
				return theUsecaseFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UsecaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UsecaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case UsecasePackage.APPLICATION_DOMAIN_USE_CASE:
			return createApplicationDomainUseCase();
		case UsecasePackage.SOLUTION_DOMAIN_USE_CASE:
			return createSolutionDomainUseCase();
		case UsecasePackage.ACTOR:
			return createActor();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationDomainUseCase createApplicationDomainUseCase() {
		ApplicationDomainUseCaseImpl applicationDomainUseCase = new ApplicationDomainUseCaseImpl();
		return applicationDomainUseCase;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SolutionDomainUseCase createSolutionDomainUseCase() {
		SolutionDomainUseCaseImpl solutionDomainUseCase = new SolutionDomainUseCaseImpl();
		return solutionDomainUseCase;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UsecasePackage getUsecasePackage() {
		return (UsecasePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UsecasePackage getPackage() {
		return UsecasePackage.eINSTANCE;
	}

} // UsecaseFactoryImpl
