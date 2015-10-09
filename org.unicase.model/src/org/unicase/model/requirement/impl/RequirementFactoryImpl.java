/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.requirement.*;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.ActorInstance;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.SystemFunction;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.UserTask;
import org.unicase.model.requirement.Workspace;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class RequirementFactoryImpl extends EFactoryImpl implements
		RequirementFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementFactory init() {
		try {
			RequirementFactory theRequirementFactory = (RequirementFactory) EPackage.Registry.INSTANCE
					.getEFactory(RequirementPackage.eNS_URI);
			if (theRequirementFactory != null) {
				return theRequirementFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RequirementFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case RequirementPackage.NON_FUNCTIONAL_REQUIREMENT:
			return createNonFunctionalRequirement();
		case RequirementPackage.FUNCTIONAL_REQUIREMENT:
			return createFunctionalRequirement();
		case RequirementPackage.USE_CASE:
			return createUseCase();
		case RequirementPackage.SCENARIO:
			return createScenario();
		case RequirementPackage.ACTOR:
			return createActor();
		case RequirementPackage.ACTOR_INSTANCE:
			return createActorInstance();
		case RequirementPackage.STEP:
			return createStep();
		case RequirementPackage.SYSTEM_FUNCTION:
			return createSystemFunction();
		case RequirementPackage.USER_TASK:
			return createUserTask();
		case RequirementPackage.WORKSPACE:
			return createWorkspace();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NonFunctionalRequirement createNonFunctionalRequirement() {
		NonFunctionalRequirementImpl nonFunctionalRequirement = new NonFunctionalRequirementImpl();
		return nonFunctionalRequirement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement createFunctionalRequirement() {
		FunctionalRequirementImpl functionalRequirement = new FunctionalRequirementImpl();
		return functionalRequirement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase createUseCase() {
		UseCaseImpl useCase = new UseCaseImpl();
		return useCase;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario createScenario() {
		ScenarioImpl scenario = new ScenarioImpl();
		return scenario;
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
	public ActorInstance createActorInstance() {
		ActorInstanceImpl actorInstance = new ActorInstanceImpl();
		return actorInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Step createStep() {
		StepImpl step = new StepImpl();
		return step;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SystemFunction createSystemFunction() {
		SystemFunctionImpl systemFunction = new SystemFunctionImpl();
		return systemFunction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UserTask createUserTask() {
		UserTaskImpl userTask = new UserTaskImpl();
		return userTask;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Workspace createWorkspace() {
		WorkspaceImpl workspace = new WorkspaceImpl();
		return workspace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementPackage getRequirementPackage() {
		return (RequirementPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RequirementPackage getPackage() {
		return RequirementPackage.eINSTANCE;
	}

} // RequirementFactoryImpl
