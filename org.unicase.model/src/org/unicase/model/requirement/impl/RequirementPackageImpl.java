/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.impl.AttachmentPackageImpl;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.bug.impl.BugPackageImpl;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.impl.ChangePackageImpl;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.impl.ClassesPackageImpl;
import org.unicase.model.component.ComponentPackage;
import org.unicase.model.component.impl.ComponentPackageImpl;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.impl.DiagramPackageImpl;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.impl.DocumentPackageImpl;
import org.unicase.model.impl.ModelPackageImpl;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.meeting.impl.MeetingPackageImpl;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.impl.OrganizationPackageImpl;
import org.unicase.model.profile.ProfilePackage;
import org.unicase.model.profile.impl.ProfilePackageImpl;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.impl.RationalePackageImpl;
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
import org.unicase.model.state.StatePackage;
import org.unicase.model.state.impl.StatePackageImpl;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.impl.TaskPackageImpl;
import org.unicase.model.util.UtilPackage;
import org.unicase.model.util.impl.UtilPackageImpl;

/*
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class RequirementPackageImpl extends EPackageImpl implements RequirementPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass nonFunctionalRequirementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass functionalRequirementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass useCaseEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass scenarioEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass actorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass actorInstanceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stepEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass systemFunctionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass userTaskEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.requirement.RequirementPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RequirementPackageImpl() {
		super(eNS_URI, RequirementFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * Simple dependencies are satisfied by calling this method on all dependent packages before doing anything else.
	 * This method drives initialization for interdependent packages directly, in parallel with this package, itself.
	 * <p>
	 * Of this package and its interdependencies, all packages which have not yet been registered by their URI values
	 * are first created and registered. The packages are then initialized in two steps: meta-model objects for all of
	 * the packages are created before any are initialized, since one package's meta-model objects may refer to those of
	 * another.
	 * <p>
	 * Invocation of this method will not affect any packages that have already been initialized. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RequirementPackage init() {
		if (isInited)
			return (RequirementPackage) EPackage.Registry.INSTANCE.getEPackage(RequirementPackage.eNS_URI);

		// Obtain or create and register package
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI)
			: new RequirementPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		OrganizationPackageImpl theOrganizationPackage = (OrganizationPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(OrganizationPackage.eNS_URI) instanceof OrganizationPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(OrganizationPackage.eNS_URI) : OrganizationPackage.eINSTANCE);
		TaskPackageImpl theTaskPackage = (TaskPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(TaskPackage.eNS_URI) instanceof TaskPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(TaskPackage.eNS_URI)
			: TaskPackage.eINSTANCE);
		DiagramPackageImpl theDiagramPackage = (DiagramPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(DiagramPackage.eNS_URI) instanceof DiagramPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(DiagramPackage.eNS_URI) : DiagramPackage.eINSTANCE);
		ClassesPackageImpl theClassesPackage = (ClassesPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ClassesPackage.eNS_URI) instanceof ClassesPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ClassesPackage.eNS_URI) : ClassesPackage.eINSTANCE);
		DocumentPackageImpl theDocumentPackage = (DocumentPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(DocumentPackage.eNS_URI) instanceof DocumentPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(DocumentPackage.eNS_URI) : DocumentPackage.eINSTANCE);
		RationalePackageImpl theRationalePackage = (RationalePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RationalePackage.eNS_URI) instanceof RationalePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RationalePackage.eNS_URI) : RationalePackage.eINSTANCE);
		ChangePackageImpl theChangePackage = (ChangePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ChangePackage.eNS_URI) instanceof ChangePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ChangePackage.eNS_URI) : ChangePackage.eINSTANCE);
		BugPackageImpl theBugPackage = (BugPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(BugPackage.eNS_URI) instanceof BugPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(BugPackage.eNS_URI)
			: BugPackage.eINSTANCE);
		ComponentPackageImpl theComponentPackage = (ComponentPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ComponentPackage.eNS_URI) instanceof ComponentPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ComponentPackage.eNS_URI) : ComponentPackage.eINSTANCE);
		MeetingPackageImpl theMeetingPackage = (MeetingPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(MeetingPackage.eNS_URI) instanceof MeetingPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(MeetingPackage.eNS_URI) : MeetingPackage.eINSTANCE);
		StatePackageImpl theStatePackage = (StatePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(StatePackage.eNS_URI) instanceof StatePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(StatePackage.eNS_URI) : StatePackage.eINSTANCE);
		AttachmentPackageImpl theAttachmentPackage = (AttachmentPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(AttachmentPackage.eNS_URI) instanceof AttachmentPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(AttachmentPackage.eNS_URI) : AttachmentPackage.eINSTANCE);
		ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ProfilePackage.eNS_URI) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ProfilePackage.eNS_URI) : ProfilePackage.eINSTANCE);
		UtilPackageImpl theUtilPackage = (UtilPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UtilPackage.eNS_URI)
			: UtilPackage.eINSTANCE);

		// Create package meta-data objects
		theRequirementPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theOrganizationPackage.createPackageContents();
		theTaskPackage.createPackageContents();
		theDiagramPackage.createPackageContents();
		theClassesPackage.createPackageContents();
		theDocumentPackage.createPackageContents();
		theRationalePackage.createPackageContents();
		theChangePackage.createPackageContents();
		theBugPackage.createPackageContents();
		theComponentPackage.createPackageContents();
		theMeetingPackage.createPackageContents();
		theStatePackage.createPackageContents();
		theAttachmentPackage.createPackageContents();
		theProfilePackage.createPackageContents();
		theUtilPackage.createPackageContents();

		// Initialize created meta-data
		theRequirementPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theOrganizationPackage.initializePackageContents();
		theTaskPackage.initializePackageContents();
		theDiagramPackage.initializePackageContents();
		theClassesPackage.initializePackageContents();
		theDocumentPackage.initializePackageContents();
		theRationalePackage.initializePackageContents();
		theChangePackage.initializePackageContents();
		theBugPackage.initializePackageContents();
		theComponentPackage.initializePackageContents();
		theMeetingPackage.initializePackageContents();
		theStatePackage.initializePackageContents();
		theAttachmentPackage.initializePackageContents();
		theProfilePackage.initializePackageContents();
		theUtilPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRequirementPackage.freeze();

		return theRequirementPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNonFunctionalRequirement() {
		return nonFunctionalRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNonFunctionalRequirement_RestrictedScenarios() {
		return (EReference) nonFunctionalRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNonFunctionalRequirement_RestrictedUseCases() {
		return (EReference) nonFunctionalRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getFunctionalRequirement() {
		return functionalRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFunctionalRequirement_Reviewed() {
		return (EAttribute) functionalRequirementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getFunctionalRequirement_Stakeholder() {
		return (EReference) functionalRequirementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFunctionalRequirement_Cost() {
		return (EAttribute) functionalRequirementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFunctionalRequirement_StoryPoints() {
		return (EAttribute) functionalRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFunctionalRequirement_Priority() {
		return (EAttribute) functionalRequirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getFunctionalRequirement_RefiningRequirements() {
		return (EReference) functionalRequirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getFunctionalRequirement_RefinedRequirement() {
		return (EReference) functionalRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getFunctionalRequirement_UseCases() {
		return (EReference) functionalRequirementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getFunctionalRequirement_Scenarios() {
		return (EReference) functionalRequirementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUseCase() {
		return useCaseEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_InitiatingActor() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_Scenarios() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_FunctionalRequirements() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_NonFunctionalRequirements() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_IdentifiedClasses() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_IncludedUseCases() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_ExtendedUseCases() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_ParticipatingActors() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_RealizedUserTask() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUseCase_Precondition() {
		return (EAttribute) useCaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCase_UseCaseSteps() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUseCase_Postcondition() {
		return (EAttribute) useCaseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUseCase_Rules() {
		return (EAttribute) useCaseEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUseCase_Exception() {
		return (EAttribute) useCaseEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getScenario() {
		return scenarioEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getScenario_Steps() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getScenario_InitiatingActorInstance() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getScenario_ParticipatingActorInstances() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getScenario_InstantiatedUseCases() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getScenario_FunctionalRequirements() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getScenario_NonFunctionalRequirements() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getScenario_ParticipatingMethods() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getScenario_ParticipatingClasses() {
		return (EReference) scenarioEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActor_InitiatedUserTask() {
		return (EReference) actorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActor_ParticipatedUserTasks() {
		return (EReference) actorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActor_InitiatedUseCases() {
		return (EReference) actorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActor_ParticipatedUseCases() {
		return (EReference) actorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActor_Instances() {
		return (EReference) actorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActorInstance() {
		return actorInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActorInstance_InitiatedScenarios() {
		return (EReference) actorInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActorInstance_ParticipatedScenarios() {
		return (EReference) actorInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActorInstance_InstantiatedActor() {
		return (EReference) actorInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStep() {
		return stepEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStep_UserStep() {
		return (EAttribute) stepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStep_IncludedUseCase() {
		return (EReference) stepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStep_IncludedSystemFunction() {
		return (EReference) stepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStep_UseCase() {
		return (EReference) stepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSystemFunction() {
		return systemFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSystemFunction_Input() {
		return (EAttribute) systemFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSystemFunction_Output() {
		return (EAttribute) systemFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSystemFunction_Exception() {
		return (EAttribute) systemFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUserTask() {
		return userTaskEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUserTask_InitiatingActor() {
		return (EReference) userTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUserTask_ParticipatingActor() {
		return (EReference) userTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUserTask_RealizingUseCases() {
		return (EReference) userTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementFactory getRequirementFactory() {
		return (RequirementFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
	 * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		nonFunctionalRequirementEClass = createEClass(NON_FUNCTIONAL_REQUIREMENT);
		createEReference(nonFunctionalRequirementEClass, NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS);
		createEReference(nonFunctionalRequirementEClass, NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_USE_CASES);

		functionalRequirementEClass = createEClass(FUNCTIONAL_REQUIREMENT);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT);
		createEAttribute(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__STORY_POINTS);
		createEAttribute(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__PRIORITY);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__USE_CASES);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__SCENARIOS);
		createEAttribute(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__REVIEWED);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__STAKEHOLDER);
		createEAttribute(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__COST);

		useCaseEClass = createEClass(USE_CASE);
		createEReference(useCaseEClass, USE_CASE__INITIATING_ACTOR);
		createEReference(useCaseEClass, USE_CASE__PARTICIPATING_ACTORS);
		createEReference(useCaseEClass, USE_CASE__REALIZED_USER_TASK);
		createEAttribute(useCaseEClass, USE_CASE__PRECONDITION);
		createEReference(useCaseEClass, USE_CASE__USE_CASE_STEPS);
		createEAttribute(useCaseEClass, USE_CASE__POSTCONDITION);
		createEAttribute(useCaseEClass, USE_CASE__RULES);
		createEAttribute(useCaseEClass, USE_CASE__EXCEPTION);
		createEReference(useCaseEClass, USE_CASE__SCENARIOS);
		createEReference(useCaseEClass, USE_CASE__FUNCTIONAL_REQUIREMENTS);
		createEReference(useCaseEClass, USE_CASE__NON_FUNCTIONAL_REQUIREMENTS);
		createEReference(useCaseEClass, USE_CASE__IDENTIFIED_CLASSES);
		createEReference(useCaseEClass, USE_CASE__INCLUDED_USE_CASES);
		createEReference(useCaseEClass, USE_CASE__EXTENDED_USE_CASES);

		scenarioEClass = createEClass(SCENARIO);
		createEReference(scenarioEClass, SCENARIO__STEPS);
		createEReference(scenarioEClass, SCENARIO__INITIATING_ACTOR_INSTANCE);
		createEReference(scenarioEClass, SCENARIO__PARTICIPATING_ACTOR_INSTANCES);
		createEReference(scenarioEClass, SCENARIO__INSTANTIATED_USE_CASES);
		createEReference(scenarioEClass, SCENARIO__FUNCTIONAL_REQUIREMENTS);
		createEReference(scenarioEClass, SCENARIO__NON_FUNCTIONAL_REQUIREMENTS);
		createEReference(scenarioEClass, SCENARIO__PARTICIPATING_METHODS);
		createEReference(scenarioEClass, SCENARIO__PARTICIPATING_CLASSES);

		actorEClass = createEClass(ACTOR);
		createEReference(actorEClass, ACTOR__INITIATED_USER_TASK);
		createEReference(actorEClass, ACTOR__PARTICIPATED_USER_TASKS);
		createEReference(actorEClass, ACTOR__INITIATED_USE_CASES);
		createEReference(actorEClass, ACTOR__PARTICIPATED_USE_CASES);
		createEReference(actorEClass, ACTOR__INSTANCES);

		actorInstanceEClass = createEClass(ACTOR_INSTANCE);
		createEReference(actorInstanceEClass, ACTOR_INSTANCE__INITIATED_SCENARIOS);
		createEReference(actorInstanceEClass, ACTOR_INSTANCE__PARTICIPATED_SCENARIOS);
		createEReference(actorInstanceEClass, ACTOR_INSTANCE__INSTANTIATED_ACTOR);

		stepEClass = createEClass(STEP);
		createEAttribute(stepEClass, STEP__USER_STEP);
		createEReference(stepEClass, STEP__INCLUDED_USE_CASE);
		createEReference(stepEClass, STEP__INCLUDED_SYSTEM_FUNCTION);
		createEReference(stepEClass, STEP__USE_CASE);

		systemFunctionEClass = createEClass(SYSTEM_FUNCTION);
		createEAttribute(systemFunctionEClass, SYSTEM_FUNCTION__INPUT);
		createEAttribute(systemFunctionEClass, SYSTEM_FUNCTION__OUTPUT);
		createEAttribute(systemFunctionEClass, SYSTEM_FUNCTION__EXCEPTION);

		userTaskEClass = createEClass(USER_TASK);
		createEReference(userTaskEClass, USER_TASK__INITIATING_ACTOR);
		createEReference(userTaskEClass, USER_TASK__PARTICIPATING_ACTOR);
		createEReference(userTaskEClass, USER_TASK__REALIZING_USE_CASES);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
	 * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RationalePackage theRationalePackage = (RationalePackage) EPackage.Registry.INSTANCE
			.getEPackage(RationalePackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		OrganizationPackage theOrganizationPackage = (OrganizationPackage) EPackage.Registry.INSTANCE
			.getEPackage(OrganizationPackage.eNS_URI);
		ClassesPackage theClassesPackage = (ClassesPackage) EPackage.Registry.INSTANCE
			.getEPackage(ClassesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		nonFunctionalRequirementEClass.getESuperTypes().add(theRationalePackage.getCriterion());
		functionalRequirementEClass.getESuperTypes().add(theModelPackage.getModelElement());
		useCaseEClass.getESuperTypes().add(theModelPackage.getModelElement());
		scenarioEClass.getESuperTypes().add(theModelPackage.getModelElement());
		actorEClass.getESuperTypes().add(theModelPackage.getModelElement());
		actorInstanceEClass.getESuperTypes().add(theModelPackage.getModelElement());
		stepEClass.getESuperTypes().add(theModelPackage.getModelElement());
		stepEClass.getESuperTypes().add(theModelPackage.getNonDomainElement());
		systemFunctionEClass.getESuperTypes().add(theModelPackage.getModelElement());
		systemFunctionEClass.getESuperTypes().add(theModelPackage.getNonDomainElement());
		userTaskEClass.getESuperTypes().add(theModelPackage.getModelElement());
		userTaskEClass.getESuperTypes().add(theModelPackage.getNonDomainElement());

		// Initialize classes and features; add operations and parameters
		initEClass(nonFunctionalRequirementEClass, NonFunctionalRequirement.class, "NonFunctionalRequirement",
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNonFunctionalRequirement_RestrictedScenarios(), this.getScenario(), this
			.getScenario_NonFunctionalRequirements(), "restrictedScenarios", null, 0, -1,
			NonFunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getNonFunctionalRequirement_RestrictedScenarios().getEKeys().add(
			theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getNonFunctionalRequirement_RestrictedUseCases(), this.getUseCase(), this
			.getUseCase_NonFunctionalRequirements(), "restrictedUseCases", null, 0, -1, NonFunctionalRequirement.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getNonFunctionalRequirement_RestrictedUseCases().getEKeys().add(
			theModelPackage.getIdentifiableElement_Identifier());

		initEClass(functionalRequirementEClass, FunctionalRequirement.class, "FunctionalRequirement", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionalRequirement_RefinedRequirement(), this.getFunctionalRequirement(), this
			.getFunctionalRequirement_RefiningRequirements(), "refinedRequirement", null, 0, 1,
			FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFunctionalRequirement_RefinedRequirement().getEKeys().add(
			theModelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getFunctionalRequirement_StoryPoints(), ecorePackage.getEInt(), "storyPoints", null, 0, 1,
			FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionalRequirement_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1,
			FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionalRequirement_RefiningRequirements(), this.getFunctionalRequirement(), this
			.getFunctionalRequirement_RefinedRequirement(), "refiningRequirements", null, 0, -1,
			FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFunctionalRequirement_RefiningRequirements().getEKeys().add(
			theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getFunctionalRequirement_UseCases(), this.getUseCase(),
			this.getUseCase_FunctionalRequirements(), "useCases", null, 0, -1, FunctionalRequirement.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getFunctionalRequirement_UseCases().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getFunctionalRequirement_Scenarios(), this.getScenario(), this
			.getScenario_FunctionalRequirements(), "scenarios", null, 0, -1, FunctionalRequirement.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getFunctionalRequirement_Scenarios().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getFunctionalRequirement_Reviewed(), ecorePackage.getEBoolean(), "reviewed", null, 0, 1,
			FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionalRequirement_Stakeholder(), theOrganizationPackage.getOrgUnit(), null,
			"stakeholder", null, 0, 1, FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFunctionalRequirement_Stakeholder().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getFunctionalRequirement_Cost(), ecorePackage.getEInt(), "cost", null, 0, 1,
			FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		initEClass(useCaseEClass, UseCase.class, "UseCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCase_InitiatingActor(), this.getActor(), this.getActor_InitiatedUseCases(),
			"initiatingActor", null, 0, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_InitiatingActor().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getUseCase_ParticipatingActors(), this.getActor(), this.getActor_ParticipatedUseCases(),
			"participatingActors", null, 0, -1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_ParticipatingActors().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getUseCase_RealizedUserTask(), this.getUserTask(), this.getUserTask_RealizingUseCases(),
			"realizedUserTask", null, 0, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_RealizedUserTask().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getUseCase_Precondition(), ecorePackage.getEString(), "precondition", null, 0, 1, UseCase.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCase_UseCaseSteps(), this.getStep(), this.getStep_UseCase(), "useCaseSteps", null, 0, -1,
			UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_UseCaseSteps().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getUseCase_Postcondition(), ecorePackage.getEString(), "postcondition", null, 0, 1,
			UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		initEAttribute(getUseCase_Rules(), ecorePackage.getEString(), "rules", "", 0, 1, UseCase.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCase_Exception(), ecorePackage.getEString(), "exception", null, 0, 1, UseCase.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCase_Scenarios(), this.getScenario(), this.getScenario_InstantiatedUseCases(),
			"scenarios", null, 0, -1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_Scenarios().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getUseCase_FunctionalRequirements(), this.getFunctionalRequirement(), this
			.getFunctionalRequirement_UseCases(), "functionalRequirements", null, 0, -1, UseCase.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getUseCase_FunctionalRequirements().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getUseCase_NonFunctionalRequirements(), this.getNonFunctionalRequirement(), this
			.getNonFunctionalRequirement_RestrictedUseCases(), "nonFunctionalRequirements", null, 0, -1, UseCase.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getUseCase_NonFunctionalRequirements().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getUseCase_IdentifiedClasses(), theClassesPackage.getClass_(), theClassesPackage
			.getClass_ParticipatedUseCases(), "identifiedClasses", null, 0, -1, UseCase.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getUseCase_IdentifiedClasses().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getUseCase_IncludedUseCases(), this.getUseCase(), null, "includedUseCases", null, 0, -1,
			UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_IncludedUseCases().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getUseCase_ExtendedUseCases(), this.getUseCase(), null, "extendedUseCases", null, 0, -1,
			UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_ExtendedUseCases().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());

		initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScenario_Steps(), this.getStep(), null, "steps", null, 0, -1, Scenario.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getScenario_Steps().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getScenario_InitiatingActorInstance(), this.getActorInstance(), this
			.getActorInstance_InitiatedScenarios(), "initiatingActorInstance", null, 0, 1, Scenario.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getScenario_InitiatingActorInstance().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getScenario_ParticipatingActorInstances(), this.getActorInstance(), this
			.getActorInstance_ParticipatedScenarios(), "participatingActorInstances", null, 0, -1, Scenario.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getScenario_ParticipatingActorInstances().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getScenario_InstantiatedUseCases(), this.getUseCase(), this.getUseCase_Scenarios(),
			"instantiatedUseCases", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getScenario_InstantiatedUseCases().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getScenario_FunctionalRequirements(), this.getFunctionalRequirement(), this
			.getFunctionalRequirement_Scenarios(), "functionalRequirements", null, 0, -1, Scenario.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getScenario_FunctionalRequirements().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getScenario_NonFunctionalRequirements(), this.getNonFunctionalRequirement(), this
			.getNonFunctionalRequirement_RestrictedScenarios(), "nonFunctionalRequirements", null, 0, -1,
			Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getScenario_NonFunctionalRequirements().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getScenario_ParticipatingMethods(), theClassesPackage.getMethod(), theClassesPackage
			.getMethod_DemoParticipations(), "participatingMethods", null, 0, -1, Scenario.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getScenario_ParticipatingMethods().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getScenario_ParticipatingClasses(), theClassesPackage.getClass_(), theClassesPackage
			.getClass_DemoParticipations(), "participatingClasses", null, 0, -1, Scenario.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getScenario_ParticipatingClasses().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());

		initEClass(actorEClass, Actor.class, "Actor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActor_InitiatedUserTask(), this.getUserTask(), this.getUserTask_InitiatingActor(),
			"initiatedUserTask", null, 0, 1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getActor_InitiatedUserTask().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getActor_ParticipatedUserTasks(), this.getUserTask(), this.getUserTask_ParticipatingActor(),
			"participatedUserTasks", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getActor_ParticipatedUserTasks().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getActor_InitiatedUseCases(), this.getUseCase(), this.getUseCase_InitiatingActor(),
			"initiatedUseCases", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getActor_InitiatedUseCases().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getActor_ParticipatedUseCases(), this.getUseCase(), this.getUseCase_ParticipatingActors(),
			"participatedUseCases", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getActor_ParticipatedUseCases().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getActor_Instances(), this.getActorInstance(), this.getActorInstance_InstantiatedActor(),
			"instances", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getActor_Instances().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());

		initEClass(actorInstanceEClass, ActorInstance.class, "ActorInstance", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActorInstance_InitiatedScenarios(), this.getScenario(), this
			.getScenario_InitiatingActorInstance(), "initiatedScenarios", null, 0, -1, ActorInstance.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getActorInstance_InitiatedScenarios().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getActorInstance_ParticipatedScenarios(), this.getScenario(), this
			.getScenario_ParticipatingActorInstances(), "participatedScenarios", null, 0, -1, ActorInstance.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getActorInstance_ParticipatedScenarios().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getActorInstance_InstantiatedActor(), this.getActor(), this.getActor_Instances(),
			"instantiatedActor", null, 0, 1, ActorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getActorInstance_InstantiatedActor().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());

		initEClass(stepEClass, Step.class, "Step", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStep_UserStep(), ecorePackage.getEBoolean(), "userStep", null, 0, 1, Step.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStep_IncludedUseCase(), this.getUseCase(), null, "includedUseCase", null, 0, 1, Step.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getStep_IncludedUseCase().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getStep_IncludedSystemFunction(), this.getSystemFunction(), null, "includedSystemFunction",
			null, 0, 1, Step.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStep_IncludedSystemFunction().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getStep_UseCase(), this.getUseCase(), this.getUseCase_UseCaseSteps(), "useCase", null, 0, 1,
			Step.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
			IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStep_UseCase().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());

		initEClass(systemFunctionEClass, SystemFunction.class, "SystemFunction", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystemFunction_Input(), ecorePackage.getEString(), "input", null, 0, 1, SystemFunction.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemFunction_Output(), ecorePackage.getEString(), "output", null, 0, 1,
			SystemFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemFunction_Exception(), ecorePackage.getEString(), "exception", null, 0, 1,
			SystemFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		initEClass(userTaskEClass, UserTask.class, "UserTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserTask_InitiatingActor(), this.getActor(), this.getActor_InitiatedUserTask(),
			"initiatingActor", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUserTask_InitiatingActor().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getUserTask_ParticipatingActor(), this.getActor(), this.getActor_ParticipatedUserTasks(),
			"participatingActor", null, 0, -1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUserTask_ParticipatingActor().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getUserTask_RealizingUseCases(), this.getUseCase(), this.getUseCase_RealizedUserTask(),
			"realizingUseCases", null, 0, -1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUserTask_RealizingUseCases().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());

		// Create annotations
		// org.unicase.ui.meeditor
		createOrgAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.unicase.ui.meeditor</b>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.unicase.ui.meeditor";
		addAnnotation(getNonFunctionalRequirement_RestrictedScenarios(), source, new String[] { "priority", "9.1",
			"position", "right" });
		addAnnotation(getNonFunctionalRequirement_RestrictedUseCases(), source, new String[] { "priority", "9.2",
			"position", "right" });
		addAnnotation(getFunctionalRequirement_RefinedRequirement(), source, new String[] { "priority", "10.0",
			"position", "left" });
		addAnnotation(getFunctionalRequirement_Priority(), source, new String[] { "priority", "12.0", "position",
			"left" });
		addAnnotation(getFunctionalRequirement_RefiningRequirements(), source, new String[] { "priority", "12.0",
			"position", "right" });
		addAnnotation(getFunctionalRequirement_UseCases(), source, new String[] { "priority", "10.0", "position",
			"right" });
		addAnnotation(getFunctionalRequirement_Scenarios(), source, new String[] { "priority", "11.0", "position",
			"right" });
		addAnnotation(getFunctionalRequirement_Reviewed(), source, new String[] { "priority", "13.0", "position",
			"left" });
		addAnnotation(getFunctionalRequirement_Stakeholder(), source, new String[] { "priority", "11.0", "position",
			"left" });
		addAnnotation(getUseCase_InitiatingActor(), source, new String[] { "priority", "10.0", "position", "left" });
		addAnnotation(getUseCase_ParticipatingActors(), source, new String[] { "priority", "11.0", "position", "left" });
		addAnnotation(getUseCase_Scenarios(), source, new String[] { "priority", "10.0", "position", "right" });
		addAnnotation(getUseCase_FunctionalRequirements(), source, new String[] { "priority", "11.0", "position",
			"right" });
		addAnnotation(getUseCase_NonFunctionalRequirements(), source, new String[] { "priority", "12.0", "position",
			"right" });
		addAnnotation(getUseCase_IdentifiedClasses(), source, new String[] { "priority", "13.0", "position", "right" });
		addAnnotation(getUseCase_IncludedUseCases(), source, new String[] { "priority", "12.0", "position", "left" });
		addAnnotation(getUseCase_ExtendedUseCases(), source, new String[] { "priority", "13.0", "position", "left" });
		addAnnotation(getScenario_InitiatingActorInstance(), source, new String[] { "priority", "10.0", "position",
			"left" });
		addAnnotation(getScenario_ParticipatingActorInstances(), source, new String[] { "priority", "11.0", "position",
			"left" });
		addAnnotation(getScenario_InstantiatedUseCases(), source, new String[] { "priority", "10.0", "position",
			"right" });
		addAnnotation(getScenario_FunctionalRequirements(), source, new String[] { "priority", "11.0", "position",
			"right" });
		addAnnotation(getScenario_NonFunctionalRequirements(), source, new String[] { "priority", "12.0", "position",
			"right" });
		addAnnotation(getActor_InitiatedUseCases(), source, new String[] { "priority", "10.0", "position", "right" });
		addAnnotation(getActor_ParticipatedUseCases(), source, new String[] { "priority", "11.0", "position", "right" });
		addAnnotation(getActor_Instances(), source, new String[] { "priority", "12.0", "position", "right" });
		addAnnotation(getActorInstance_InitiatedScenarios(), source, new String[] { "priority", "10.0", "position",
			"right" });
		addAnnotation(getActorInstance_ParticipatedScenarios(), source, new String[] { "priority", "11.0", "position",
			"right" });
		addAnnotation(getActorInstance_InstantiatedActor(), source, new String[] { "priority", "10.0", "position",
			"left" });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation(getActorInstance_ParticipatedScenarios(), source, new String[] {});
	}

} // RequirementPackageImpl
