/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.usecase.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.metamodel.MetamodelPackage;

import org.unicase.model.ModelPackage;

import org.unicase.model.requirement.RequirementPackage;

import org.unicase.model.usecase.ActorStep;
import org.unicase.model.usecase.Option;
import org.unicase.model.usecase.SystemStep;
import org.unicase.model.usecase.UseCase;
import org.unicase.model.usecase.UsecaseFactory;
import org.unicase.model.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UsecasePackageImpl extends EPackageImpl implements UsecasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemStepEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.usecase.UsecasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UsecasePackageImpl() {
		super(eNS_URI, UsecaseFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UsecasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UsecasePackage init() {
		if (isInited) return (UsecasePackage)EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI);

		// Obtain or create and register package
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UsecasePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUsecasePackage.createPackageContents();

		// Initialize created meta-data
		theUsecasePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUsecasePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UsecasePackage.eNS_URI, theUsecasePackage);
		return theUsecasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseCase() {
		return useCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCase_ActorSteps() {
		return (EReference)useCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCase_SystemSteps() {
		return (EReference)useCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCase_Precon() {
		return (EAttribute)useCaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCase_Postcon() {
		return (EAttribute)useCaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCase_Rul() {
		return (EAttribute)useCaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCase_Exc() {
		return (EAttribute)useCaseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseCase_Sync() {
		return (EAttribute)useCaseEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCase_UseCases() {
		return (EReference)useCaseEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOption() {
		return optionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOption_TargetStep() {
		return (EReference)optionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOption_SourceStep() {
		return (EReference)optionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOption_IncludedUseCase() {
		return (EReference)optionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorStep() {
		return actorStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorStep_Options() {
		return (EReference)actorStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorStep_UseCase() {
		return (EReference)actorStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemStep() {
		return systemStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemStep_Exception() {
		return (EAttribute)systemStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemStep_IncludedSystemFunction() {
		return (EReference)systemStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemStep_LinkedStep() {
		return (EReference)systemStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemStep_UseCase() {
		return (EReference)systemStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsecaseFactory getUsecaseFactory() {
		return (UsecaseFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		useCaseEClass = createEClass(USE_CASE);
		createEReference(useCaseEClass, USE_CASE__ACTOR_STEPS);
		createEReference(useCaseEClass, USE_CASE__SYSTEM_STEPS);
		createEAttribute(useCaseEClass, USE_CASE__PRECON);
		createEAttribute(useCaseEClass, USE_CASE__POSTCON);
		createEAttribute(useCaseEClass, USE_CASE__RUL);
		createEAttribute(useCaseEClass, USE_CASE__EXC);
		createEAttribute(useCaseEClass, USE_CASE__SYNC);
		createEReference(useCaseEClass, USE_CASE__USE_CASES);

		optionEClass = createEClass(OPTION);
		createEReference(optionEClass, OPTION__TARGET_STEP);
		createEReference(optionEClass, OPTION__SOURCE_STEP);
		createEReference(optionEClass, OPTION__INCLUDED_USE_CASE);

		actorStepEClass = createEClass(ACTOR_STEP);
		createEReference(actorStepEClass, ACTOR_STEP__OPTIONS);
		createEReference(actorStepEClass, ACTOR_STEP__USE_CASE);

		systemStepEClass = createEClass(SYSTEM_STEP);
		createEAttribute(systemStepEClass, SYSTEM_STEP__EXCEPTION);
		createEReference(systemStepEClass, SYSTEM_STEP__INCLUDED_SYSTEM_FUNCTION);
		createEReference(systemStepEClass, SYSTEM_STEP__LINKED_STEP);
		createEReference(systemStepEClass, SYSTEM_STEP__USE_CASE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RequirementPackage theRequirementPackage = (RequirementPackage)EPackage.Registry.INSTANCE.getEPackage(RequirementPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		useCaseEClass.getESuperTypes().add(theRequirementPackage.getUseCase());
		optionEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		optionEClass.getESuperTypes().add(theMetamodelPackage.getNonDomainElement());
		actorStepEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		actorStepEClass.getESuperTypes().add(theMetamodelPackage.getNonDomainElement());
		systemStepEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		systemStepEClass.getESuperTypes().add(theMetamodelPackage.getNonDomainElement());

		// Initialize classes and features; add operations and parameters
		initEClass(useCaseEClass, UseCase.class, "UseCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCase_ActorSteps(), this.getActorStep(), this.getActorStep_UseCase(), "actorSteps", null, 0, -1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_ActorSteps().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getUseCase_SystemSteps(), this.getSystemStep(), this.getSystemStep_UseCase(), "systemSteps", null, 0, -1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_SystemSteps().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEAttribute(getUseCase_Precon(), ecorePackage.getEString(), "precon", null, 0, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCase_Postcon(), ecorePackage.getEString(), "postcon", null, 0, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCase_Rul(), ecorePackage.getEString(), "rul", null, 0, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCase_Exc(), ecorePackage.getEString(), "exc", null, 0, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseCase_Sync(), ecorePackage.getEString(), "sync", null, 0, 1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCase_UseCases(), this.getUseCase(), null, "useCases", null, 0, -1, UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionEClass, Option.class, "Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOption_TargetStep(), theModelPackage.getUnicaseModelElement(), null, "targetStep", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOption_SourceStep(), this.getActorStep(), this.getActorStep_Options(), "sourceStep", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getOption_SourceStep().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getOption_IncludedUseCase(), this.getUseCase(), null, "includedUseCase", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorStepEClass, ActorStep.class, "ActorStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActorStep_Options(), this.getOption(), this.getOption_SourceStep(), "options", null, 0, -1, ActorStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getActorStep_Options().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getActorStep_UseCase(), this.getUseCase(), this.getUseCase_ActorSteps(), "useCase", null, 0, 1, ActorStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getActorStep_UseCase().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(systemStepEClass, SystemStep.class, "SystemStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystemStep_Exception(), ecorePackage.getEString(), "exception", null, 0, 1, SystemStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemStep_IncludedSystemFunction(), theRequirementPackage.getSystemFunction(), null, "includedSystemFunction", null, 0, 1, SystemStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSystemStep_IncludedSystemFunction().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getSystemStep_LinkedStep(), theModelPackage.getUnicaseModelElement(), null, "linkedStep", null, 0, 1, SystemStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemStep_UseCase(), this.getUseCase(), this.getUseCase_SystemSteps(), "useCase", null, 0, 1, SystemStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSystemStep_UseCase().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// org.unicase.ui.meeditor
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.unicase.ui.meeditor</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.unicase.ui.meeditor";		
		addAnnotation
		  (getUseCase_ActorSteps(), 
		   source, 
		   new String[] {
			 "priority", "1.0",
			 "position", "right"
		   });		
		addAnnotation
		  (getUseCase_Precon(), 
		   source, 
		   new String[] {
			 "priority", "1.1",
			 "position", "left"
		   });		
		addAnnotation
		  (getUseCase_Postcon(), 
		   source, 
		   new String[] {
			 "priority", "1.3",
			 "position", "left"
		   });		
		addAnnotation
		  (getUseCase_Rul(), 
		   source, 
		   new String[] {
			 "priority", "1.2",
			 "position", "left"
		   });		
		addAnnotation
		  (getUseCase_Exc(), 
		   source, 
		   new String[] {
			 "priority", "1.4",
			 "position", "left"
		   });		
		addAnnotation
		  (getUseCase_UseCases(), 
		   source, 
		   new String[] {
			 "priority", "1.1",
			 "position", "right"
		   });
	}

} //UsecasePackageImpl
