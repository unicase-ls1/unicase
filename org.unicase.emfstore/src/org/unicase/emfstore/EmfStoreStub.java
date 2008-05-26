package org.unicase.emfstore;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.model.EsmodelFactory;
import org.unicase.emfstore.model.ProjectHistory;
import org.unicase.emfstore.model.ProjectId;
import org.unicase.emfstore.model.ProjectInfo;
import org.unicase.emfstore.model.ServerSpace;
import org.unicase.emfstore.model.SessionId;
import org.unicase.emfstore.model.changemanagment.ChangePackage;
import org.unicase.emfstore.model.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.model.changemanagment.HistoryInfo;
import org.unicase.emfstore.model.changemanagment.LogMessage;
import org.unicase.emfstore.model.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.model.changemanagment.TagVersionSpec;
import org.unicase.emfstore.model.changemanagment.Version;
import org.unicase.emfstore.model.changemanagment.VersionSpec;
import org.unicase.model.CompositeSection;
import org.unicase.model.FunctionalRequirement;
import org.unicase.model.LeafSection;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.MEDiagram;

public class EmfStoreStub implements EmfStore {

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException {
		// MK Auto-generated method stub
		return null;
	}

	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		// MK Auto-generated method stub
		return null;
	}

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		// MK Auto-generated method stub
		return null;
	}

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		return createDummyProject();
	}

	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		EList<ProjectInfo> ret = new BasicEList<ProjectInfo>();
		
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		
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
		
		//RootSection
		CompositeSection rootSection = factory.createCompositeSection();
		rootSection.setName("RAD");
		rootSection
				.setDescription("The requirements analysis document of the project");
		project.addModelElement(rootSection);

		//Functional Requirements
		LeafSection reqLeafSection = factory.createLeafSection();
		reqLeafSection.setName("Functional Requirements");
		reqLeafSection
				.setDescription("Lists all functional requirements in this project");
		reqLeafSection.setElementClass(FunctionalRequirement.class);
		reqLeafSection.setParent(rootSection);
		FunctionalRequirement fr = factory.createFunctionalRequirement();
		fr.setName("My Reuirement");
		FunctionalRequirement fr2 = factory.createFunctionalRequirement();
		fr2.setName("My Reuirement2");
		reqLeafSection.getModelElements().add(fr);
		reqLeafSection.getModelElements().add(fr2);

		//ActionItems
		LeafSection actionItemLeafSection = factory.createLeafSection();
		actionItemLeafSection.setName("Action Items");
		actionItemLeafSection.setDescription("Lists all ais of this project.");
		actionItemLeafSection.setParent(rootSection);
		actionItemLeafSection.setElementClass(FunctionalRequirement.class);
		//TODO: Create some AI«s here
		
		
		//Diagrams
		LeafSection diagramSection = factory.createLeafSection();
		diagramSection.setName("Diagrams");
		diagramSection.setDescription("Lists all diagrams of this project.");
		diagramSection.setParent(rootSection);
		diagramSection.setElementClass(FunctionalRequirement.class);
		
		DiagramFactory diagramFactory = DiagramFactory.eINSTANCE;
		MEDiagram diagram = diagramFactory.createMEDiagram();
		diagram.setName("Super Diagram");
		diagramSection.getModelElements().add(diagram);
		
		
		//Other Crap
		CompositeSection ucmCompositeSection = factory.createCompositeSection();
		ucmCompositeSection.setName("Use Case Modeling");
		ucmCompositeSection
				.setDescription("Contains sections concerning use cases.");
		ucmCompositeSection.setParent(rootSection);

		

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

		return project;
		// end of generation
	}

	public void createDummyProjectHistories(ServerSpace serverSpace) {
		EsmodelFactory esmodelFactory = EsmodelFactory.eINSTANCE;
		ProjectHistory projectHistory = esmodelFactory.createProjectHistory();
		projectHistory.setProjectDescription("This is a autogen test project");
		projectHistory.setProjectId(esmodelFactory.createProjectId());
		projectHistory.setProjectName("TestProject1");
		ChangemanagmentFactory changemanagmentFactory = ChangemanagmentFactory.eINSTANCE;
		
		//create Version
		ChangemanagmentFactory changemanagmentFactory2 = changemanagmentFactory;
		Version version = changemanagmentFactory2.createVersion();
		TagVersionSpec tagVersionSpec = changemanagmentFactory2.createTagVersionSpec();
		tagVersionSpec.setName("InitialVersion");
		version.getTagSpecs().add(tagVersionSpec);
		LogMessage logMessage = changemanagmentFactory2.createLogMessage();
		logMessage.setDate(new Date());
		logMessage.setAuthor("es");
		logMessage.setMessage("Auto generated");
		version.setLogMessage(logMessage);
		PrimaryVersionSpec primaryVersionSpec = changemanagmentFactory.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(0);
		version.setPrimarySpec(primaryVersionSpec);
		//version.setProjectState(createDummyProject());
		
		projectHistory.getVersions().add(version);
		serverSpace.getProjects().add(projectHistory);
	}


}
