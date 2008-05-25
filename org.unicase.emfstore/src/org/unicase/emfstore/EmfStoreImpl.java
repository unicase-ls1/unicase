package org.unicase.emfstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.storage.ResourceStorage;
import org.unicase.esmodel.EsmodelFactory;
import org.unicase.esmodel.ProjectId;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.ChangePackage;
import org.unicase.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.esmodel.changemanagment.HeadVersionSpec;
import org.unicase.esmodel.changemanagment.HistoryInfo;
import org.unicase.esmodel.changemanagment.LogMessage;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.esmodel.changemanagment.impl.ChangemanagmentFactoryImpl;
import org.unicase.model.CompositeSection;
import org.unicase.model.FunctionalRequirement;
import org.unicase.model.LeafSection;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.task.ActionItem;

public class EmfStoreImpl implements EmfStore {

	private final Resource resource;
	
	private final static Logger logger = Logger.getLogger(EmfStoreImpl.class);
	
	public EmfStoreImpl(ResourceStorage storage, Properties properties) {
		
		URI resourceUri = storage.init(properties);
		ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(resourceUri);

	}

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException {
		throw new UnsupportedOperationException();
	}

	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		throw new UnsupportedOperationException();
	}

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		throw new UnsupportedOperationException();
	}

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		return createDummyProject();
	}

	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		EList<ProjectInfo> ret = new BasicEList<ProjectInfo>();
		
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		
		HeadVersionSpec headVersionSpec = ChangemanagmentFactoryImpl.eINSTANCE.createHeadVersionSpec();
		
		ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("TestProject");
		projectInfo.setDescription("A test Project");
		projectInfo.setProjectId(projectId);
		projectInfo.setVersion(ChangemanagmentFactory.eINSTANCE.createPrimaryVersionSpec());
		
		ret.add(projectInfo);
		return ret;
	}

	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			VersionSpec versionSpec) throws EmfStoreException {
		PrimaryVersionSpec primaryVersionSpec = ChangemanagmentFactory.eINSTANCE.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(1);
		return primaryVersionSpec;
	}
	
	private Project createDummyProject() {
		// Generate the elements of the model
		
		ModelFactory factory = ModelFactory.eINSTANCE;
		Project project = factory.createProject();
		CompositeSection rootSection = factory.createCompositeSection();
		rootSection.setName("RAD");
		rootSection
				.setDescription("The requirements analysis document of the project");

		LeafSection reqLeafSection = factory.createLeafSection();
		reqLeafSection.setName("Functional Requirements");
		reqLeafSection
				.setDescription("Lists all functional requirements in this project");
		reqLeafSection.setElementClass(FunctionalRequirement.class);

		reqLeafSection.setParent(rootSection);

		LeafSection scenLeafSection = factory.createLeafSection();
		scenLeafSection.setName("Scenarios");
		scenLeafSection.setDescription("Lists all scenarios of this project.");
		scenLeafSection.setParent(rootSection);
		scenLeafSection.setElementClass(FunctionalRequirement.class);
		
		CompositeSection ucmCompositeSection = factory.createCompositeSection();
		ucmCompositeSection.setName("Use Case Modeling");
		ucmCompositeSection
				.setDescription("Contains sections concerning use cases.");
		ucmCompositeSection.setParent(rootSection);

		LeafSection actorLeafSection = factory.createLeafSection();
		actorLeafSection.setName("Actors");
		actorLeafSection.setDescription("Lists all actors of this project.");
		actorLeafSection.setParent(ucmCompositeSection);
		actorLeafSection.setElementClass(FunctionalRequirement.class);

		LeafSection useCaseLeafSection = factory.createLeafSection();
		useCaseLeafSection.setName("Use Cases");
		useCaseLeafSection
				.setDescription("Lists all use cases of this project.");
		useCaseLeafSection.setParent(ucmCompositeSection);
		useCaseLeafSection.setElementClass(FunctionalRequirement.class);

		LeafSection useCaseDiagramLeafSection = factory.createLeafSection();
		useCaseDiagramLeafSection.setName("Use Case Diagrams");
		useCaseDiagramLeafSection
				.setDescription("Lists all use case diagrams of this project.");
		useCaseDiagramLeafSection.setParent(ucmCompositeSection);
		useCaseDiagramLeafSection.setElementClass(FunctionalRequirement.class);
		
		
		useCaseDiagramLeafSection.setName("Use Case Diagrams");
		useCaseDiagramLeafSection
				.setDescription("Lists all use case diagrams of this project.");
		useCaseDiagramLeafSection.setParent(ucmCompositeSection);
		useCaseDiagramLeafSection.setElementClass(FunctionalRequirement.class);

		FunctionalRequirement fr = factory.createFunctionalRequirement();
		fr.setName("My Reuirement");
		
		FunctionalRequirement fr2 = factory.createFunctionalRequirement();
		fr2.setName("My Reuirement2");
		
		


		EList<ModelElement> projectElements = project.getModelElements();
		projectElements.add(fr);
		projectElements.add(fr2);
		projectElements.add(rootSection);
		return project;
		// end of generation
	}

}
