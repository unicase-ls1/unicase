/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.*;

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
			case ModelPackage.MODEL_ELEMENT_ID: return createModelElementId();
			case ModelPackage.READER_INFO: return createReaderInfo();
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId createModelElementId() {
		ModelElementIdImpl modelElementId = new ModelElementIdImpl();
		return modelElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReaderInfo createReaderInfo() {
		ReaderInfoImpl readerInfo = new ReaderInfoImpl();
		return readerInfo;
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

		LeafSection reqLeafSection = this.createLeafSection();
		reqLeafSection.setName("Functional Requirements");
		reqLeafSection
				.setDescription("Lists all functional requirements in this project");
		reqLeafSection.setElementClass(FunctionalRequirement.class);

		reqLeafSection.setParent(rootSection);

		LeafSection scenLeafSection = this.createLeafSection();
		scenLeafSection.setName("Scenarios");
		scenLeafSection.setDescription("Lists all scenarios of this project.");
		scenLeafSection.setParent(rootSection);
		scenLeafSection.setElementClass(FunctionalRequirement.class);

		CompositeSection ucmCompositeSection = this.createCompositeSection();
		ucmCompositeSection.setName("Use Case Modeling");
		ucmCompositeSection
				.setDescription("Contains sections concerning use cases.");
		ucmCompositeSection.setParent(rootSection);

		LeafSection actorLeafSection = this.createLeafSection();
		actorLeafSection.setName("Actors");
		actorLeafSection.setDescription("Lists all actors of this project.");
		actorLeafSection.setParent(ucmCompositeSection);
		actorLeafSection.setElementClass(FunctionalRequirement.class);

		LeafSection useCaseLeafSection = this.createLeafSection();
		useCaseLeafSection.setName("Use Cases");
		useCaseLeafSection
				.setDescription("Lists all use cases of this project.");
		useCaseLeafSection.setParent(ucmCompositeSection);
		useCaseLeafSection.setElementClass(FunctionalRequirement.class);

		LeafSection useCaseDiagramLeafSection = this.createLeafSection();
		useCaseDiagramLeafSection.setName("Use Case Diagrams");
		useCaseDiagramLeafSection
				.setDescription("Lists all use case diagrams of this project.");
		useCaseDiagramLeafSection.setParent(ucmCompositeSection);
		useCaseDiagramLeafSection.setElementClass(FunctionalRequirement.class);

		FunctionalRequirement fr = this.createFunctionalRequirement();
		fr.setName("My Reuirement");
		
		FunctionalRequirement fr2 = this.createFunctionalRequirement();
		fr2.setName("My Reuirement2");


		EList<ModelElement> projectElements = projectElement.getProjectElements();
		projectElements.add(fr);
		projectElements.add(fr2);
		projectElements.add(rootSection);
		return projectElement;
		// end of generation
	}

} // ModelFactoryImpl
