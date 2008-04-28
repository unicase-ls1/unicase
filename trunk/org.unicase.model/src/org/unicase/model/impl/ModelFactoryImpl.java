/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.CompositeSection;
import org.unicase.model.FunctionalRequirement;
import org.unicase.model.LeafSection;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.ProjectId;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/model"); 
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelPackage.FUNCTIONAL_REQUIREMENT: return createFunctionalRequirement();
			case ModelPackage.LEAF_SECTION: return createLeafSection();
			case ModelPackage.COMPOSITE_SECTION: return createCompositeSection();
			case ModelPackage.PROJECT: return createProject();
			case ModelPackage.PROJECT_ID: return createProjectId();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	public LeafSection createLeafSection() {
		LeafSectionImpl leafSection = new LeafSectionImpl();
		return leafSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSection createCompositeSection() {
		CompositeSectionImpl compositeSection = new CompositeSectionImpl();
		return compositeSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId createProjectId() {
		ProjectIdImpl projectId = new ProjectIdImpl();
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

	public Project createDummyProject() {
		// Generate the elements of the model

		Project projectElement = this.createProject();
		projectElement.setName("Sysiphus EMF Evaluation");
		projectElement
				.setDescription("This model is part of the effort to evaluate the EMF Framework.");

		CompositeSection rootSection = this.createCompositeSection();
		rootSection.setName("RAD");
		rootSection
				.setDescription("The requirements analysis document of the project");
		rootSection.setId("1");

		LeafSection reqLeafSection = this.createLeafSection();
		reqLeafSection.setName("Functional Requirements");
		reqLeafSection
				.setDescription("Lists all functional requirements in this project");
		reqLeafSection.setElementType(FunctionalRequirement.class);

		reqLeafSection.setId("2");
		reqLeafSection.setParent(rootSection);

		LeafSection scenLeafSection = this.createLeafSection();
		scenLeafSection.setName("Scenarios");
		scenLeafSection.setDescription("Lists all scenarios of this project.");
		scenLeafSection.setId("3");
		scenLeafSection.setParent(rootSection);
		scenLeafSection.setElementType(FunctionalRequirement.class);

		CompositeSection ucmCompositeSection = this.createCompositeSection();
		ucmCompositeSection.setName("Use Case Modeling");
		ucmCompositeSection
				.setDescription("Contains sections concerning use cases.");
		ucmCompositeSection.setId("4");
		ucmCompositeSection.setParent(rootSection);

		LeafSection actorLeafSection = this.createLeafSection();
		actorLeafSection.setName("Actors");
		actorLeafSection.setDescription("Lists all actors of this project.");
		actorLeafSection.setId("5");
		actorLeafSection.setParent(ucmCompositeSection);
		actorLeafSection.setElementType(FunctionalRequirement.class);

		LeafSection useCaseLeafSection = this.createLeafSection();
		useCaseLeafSection.setName("Use Cases");
		useCaseLeafSection
				.setDescription("Lists all use cases of this project.");
		useCaseLeafSection.setId("6");
		useCaseLeafSection.setParent(ucmCompositeSection);
		useCaseLeafSection.setElementType(FunctionalRequirement.class);

		LeafSection useCaseDiagramLeafSection = this.createLeafSection();
		useCaseDiagramLeafSection.setName("Use Case Diagrams");
		useCaseDiagramLeafSection
				.setDescription("Lists all use case diagrams of this project.");
		useCaseDiagramLeafSection.setId("7");
		useCaseDiagramLeafSection.setParent(ucmCompositeSection);
		useCaseDiagramLeafSection.setElementType(FunctionalRequirement.class);

		FunctionalRequirement fr = this.createFunctionalRequirement();
		fr.setName("My Reuirement");
		fr.setId("8");
		fr.setProject(projectElement);
		FunctionalRequirement fr2 = this.createFunctionalRequirement();
		fr2.setName("My Reuirement2");
		fr2.setId("9");
		fr2.setProject(projectElement);

		rootSection.setProject(projectElement);
		reqLeafSection.setProject(projectElement);
		scenLeafSection.setProject(projectElement);
		ucmCompositeSection.setProject(projectElement);
		actorLeafSection.setProject(projectElement);
		useCaseLeafSection.setProject(projectElement);
		useCaseDiagramLeafSection.setProject(projectElement);

		return projectElement;
		// end of generation
	}

} // ModelFactoryImpl
