/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.model.CompositeSection;
import org.unicase.model.FunctionalRequirement;
import org.unicase.model.LeafSection;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.ProjectId;
import org.unicase.model.Section;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionalRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leafSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectIdEClass = null;

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
	 * @see org.unicase.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElement() {
		return modelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_Name() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_Description() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_Id() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_Project() {
		return (EReference)modelElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionalRequirement() {
		return functionalRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionalRequirement_Reviewed() {
		return (EAttribute)functionalRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionalRequirement_StoryPoints() {
		return (EAttribute)functionalRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionalRequirement_Priority() {
		return (EAttribute)functionalRequirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionalRequirement_Date() {
		return (EAttribute)functionalRequirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionalRequirement_RefiningRequirements() {
		return (EReference)functionalRequirementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionalRequirement_RefinedRequirement() {
		return (EReference)functionalRequirementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLeafSection() {
		return leafSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLeafSection_ElementClass() {
		return (EAttribute)leafSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeSection() {
		return compositeSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeSection_Subsections() {
		return (EReference)compositeSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSection() {
		return sectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSection_Parent() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject() {
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Name() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Description() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_ProjectElements() {
		return (EReference)projectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Identifier() {
		return (EReference)projectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectId() {
		return projectIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectId_Identifier() {
		return (EAttribute)projectIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
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
		modelElementEClass = createEClass(MODEL_ELEMENT);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__NAME);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__DESCRIPTION);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__ID);
		createEReference(modelElementEClass, MODEL_ELEMENT__PROJECT);

		functionalRequirementEClass = createEClass(FUNCTIONAL_REQUIREMENT);
		createEAttribute(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__REVIEWED);
		createEAttribute(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__STORY_POINTS);
		createEAttribute(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__PRIORITY);
		createEAttribute(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__DATE);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT);

		leafSectionEClass = createEClass(LEAF_SECTION);
		createEAttribute(leafSectionEClass, LEAF_SECTION__ELEMENT_CLASS);

		compositeSectionEClass = createEClass(COMPOSITE_SECTION);
		createEReference(compositeSectionEClass, COMPOSITE_SECTION__SUBSECTIONS);

		sectionEClass = createEClass(SECTION);
		createEReference(sectionEClass, SECTION__PARENT);

		projectEClass = createEClass(PROJECT);
		createEAttribute(projectEClass, PROJECT__NAME);
		createEAttribute(projectEClass, PROJECT__DESCRIPTION);
		createEReference(projectEClass, PROJECT__PROJECT_ELEMENTS);
		createEReference(projectEClass, PROJECT__IDENTIFIER);

		projectIdEClass = createEClass(PROJECT_ID);
		createEAttribute(projectIdEClass, PROJECT_ID__IDENTIFIER);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		functionalRequirementEClass.getESuperTypes().add(this.getModelElement());
		leafSectionEClass.getESuperTypes().add(this.getSection());
		compositeSectionEClass.getESuperTypes().add(this.getSection());
		sectionEClass.getESuperTypes().add(this.getModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(modelElementEClass, ModelElement.class, "ModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElement_Id(), ecorePackage.getEString(), "id", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElement_Project(), this.getProject(), this.getProject_ProjectElements(), "project", null, 1, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionalRequirementEClass, FunctionalRequirement.class, "FunctionalRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionalRequirement_Reviewed(), ecorePackage.getEBoolean(), "reviewed", null, 0, 1, FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionalRequirement_StoryPoints(), ecorePackage.getEInt(), "storyPoints", null, 0, 1, FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionalRequirement_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionalRequirement_Date(), ecorePackage.getEDate(), "date", null, 0, 1, FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionalRequirement_RefiningRequirements(), this.getFunctionalRequirement(), this.getFunctionalRequirement_RefinedRequirement(), "refiningRequirements", null, 0, -1, FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionalRequirement_RefinedRequirement(), this.getFunctionalRequirement(), this.getFunctionalRequirement_RefiningRequirements(), "refinedRequirement", null, 0, 1, FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(leafSectionEClass, LeafSection.class, "LeafSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(this.getModelElement());
		g2.setEUpperBound(g3);
		initEAttribute(getLeafSection_ElementClass(), g1, "elementClass", null, 0, 1, LeafSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeSectionEClass, CompositeSection.class, "CompositeSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeSection_Subsections(), this.getSection(), this.getSection_Parent(), "subsections", null, 0, -1, CompositeSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sectionEClass, Section.class, "Section", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSection_Parent(), this.getCompositeSection(), this.getCompositeSection_Subsections(), "parent", null, 0, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_Description(), ecorePackage.getEString(), "description", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_ProjectElements(), this.getModelElement(), this.getModelElement_Project(), "projectElements", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Identifier(), this.getProjectId(), null, "Identifier", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(projectEClass, null, "addModelElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElement(), "modelElement", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(projectIdEClass, ProjectId.class, "ProjectId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProjectId_Identifier(), ecorePackage.getEString(), "identifier", null, 1, 1, ProjectId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// https://www.sysiphus.org/Visibility
		createVisibilityAnnotations();
		// http://www.sysiphus.org/Visibility
		createVisibility_1Annotations();
		// http://www.unicase.org/view
		createViewAnnotations();
	}

	/**
	 * Initializes the annotations for <b>https://www.sysiphus.org/Visibility</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createVisibilityAnnotations() {
		String source = "https://www.sysiphus.org/Visibility";		
		addAnnotation
		  (getModelElement_Name(), 
		   source, 
		   new String[] {
			 "VisibilityValue", "MANDATORY"
		   });			
	}

	/**
	 * Initializes the annotations for <b>http://www.sysiphus.org/Visibility</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createVisibility_1Annotations() {
		String source = "http://www.sysiphus.org/Visibility";			
		addAnnotation
		  (getModelElement_Description(), 
		   source, 
		   new String[] {
			 "VisibilityValue", "VIEWWHENSET"
		   });			
		addAnnotation
		  (getModelElement_Id(), 
		   source, 
		   new String[] {
			 "VisibilityValue", "INVISIBLE"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.unicase.org/view</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createViewAnnotations() {
		String source = "http://www.unicase.org/view";				
		addAnnotation
		  (getModelElement_Description(), 
		   source, 
		   new String[] {
			 "type", "TEXT_AREA"
		   });	
	}

} //ModelPackageImpl
