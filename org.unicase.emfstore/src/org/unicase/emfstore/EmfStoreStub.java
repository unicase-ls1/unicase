package org.unicase.emfstore;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.HistoryInfo;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.Version;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;

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
		projectInfo.setVersion(ChangemanagmentFactory.eINSTANCE
				.createPrimaryVersionSpec());

		ret.add(projectInfo);
		return ret;
	}

	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException {
		PrimaryVersionSpec primaryVersionSpec = ChangemanagmentFactory.eINSTANCE
				.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(1);
		return primaryVersionSpec;
	}

	public static Project createDummyProject() {
		// Generate the elements of the model

		ModelFactory factory = ModelFactory.eINSTANCE;
		DocumentFactory documentFactory = DocumentFactory.eINSTANCE;
		RequirementFactory requirementFactory = RequirementFactory.eINSTANCE;
		Project project = factory.createProject();

		// RootSection
		CompositeSection rootSection = documentFactory.createCompositeSection();
		rootSection.setName("RAD");
		rootSection
				.setDescription("The requirements analysis document of the project");
		project.addModelElement(rootSection);

		// Functional Requirements
		LeafSection reqLeafSection = documentFactory.createLeafSection();
		reqLeafSection.setName("Functional Requirements");
		reqLeafSection
				.setDescription("Lists all functional requirements in this project");
		reqLeafSection.setElementClass(FunctionalRequirement.class);
		reqLeafSection.setParent(rootSection);
		FunctionalRequirement fr = requirementFactory
				.createFunctionalRequirement();
		fr.setName("My Reuirement");
		FunctionalRequirement fr2 = requirementFactory
				.createFunctionalRequirement();
		fr2.setName("My Reuirement2");
		reqLeafSection.getModelElements().add(fr);
		reqLeafSection.getModelElements().add(fr2);

		// ActionItems
		LeafSection actionItemLeafSection = documentFactory.createLeafSection();
		actionItemLeafSection.setName("Action Items");
		actionItemLeafSection.setDescription("Lists all ais of this project.");
		actionItemLeafSection.setParent(rootSection);
		actionItemLeafSection.setElementClass(FunctionalRequirement.class);
		// TODO: Create some AI�s here

		// Diagrams
		LeafSection diagramSection = documentFactory.createLeafSection();
		diagramSection.setName("Diagrams");
		diagramSection.setDescription("Lists all diagrams of this project.");
		diagramSection.setParent(rootSection);
		diagramSection.setElementClass(FunctionalRequirement.class);

		DiagramFactory diagramFactory = DiagramFactory.eINSTANCE;
		MEDiagram diagram = diagramFactory.createMEDiagram();
		diagram.setName("Super Diagram");
		diagramSection.getModelElements().add(diagram);

		// Other Crap
		CompositeSection ucmCompositeSection = documentFactory
				.createCompositeSection();
		ucmCompositeSection.setName("Use Case Modeling");
		ucmCompositeSection
				.setDescription("Contains sections concerning use cases.");
		ucmCompositeSection.setParent(rootSection);

		LeafSection useCaseLeafSection = documentFactory.createLeafSection();
		useCaseLeafSection.setName("Use Cases");
		useCaseLeafSection
				.setDescription("Lists all use cases of this project.");
		useCaseLeafSection.setParent(ucmCompositeSection);
		useCaseLeafSection.setElementClass(FunctionalRequirement.class);

		LeafSection useCaseDiagramLeafSection = documentFactory
				.createLeafSection();
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

	public static void createDummyProjectHistories(ServerSpace serverSpace) {
		EsmodelFactory esmodelFactory = EsmodelFactory.eINSTANCE;
		ProjectHistory projectHistory = esmodelFactory.createProjectHistory();
		projectHistory.setProjectDescription("This is a autogen test project");
		projectHistory.setProjectId(esmodelFactory.createProjectId());
		projectHistory.setProjectName("TestProject1");
		ChangemanagmentFactory changemanagmentFactory = ChangemanagmentFactory.eINSTANCE;

		// create Version
		ChangemanagmentFactory changemanagmentFactory2 = changemanagmentFactory;
		Version version = changemanagmentFactory2.createVersion();
		TagVersionSpec tagVersionSpec = changemanagmentFactory2
				.createTagVersionSpec();
		tagVersionSpec.setName("InitialVersion");
		version.getTagSpecs().add(tagVersionSpec);
		LogMessage logMessage = changemanagmentFactory2.createLogMessage();
		logMessage.setDate(new Date());
		logMessage.setAuthor("es");
		logMessage.setMessage("Auto generated");
		version.setLogMessage(logMessage);
		PrimaryVersionSpec primaryVersionSpec = changemanagmentFactory
				.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(0);
		version.setPrimarySpec(primaryVersionSpec);
		version.setProjectState(createDummyProject());

		projectHistory.getVersions().add(version);
		serverSpace.getProjects().add(projectHistory);
	}

	public ProjectInfo createProject(SessionId sessionId, String name,
			String description, LogMessage logMessage) throws EmfStoreException {
		ProjectHistory projectHistory = EsmodelFactory.eINSTANCE
				.createProjectHistory();
		projectHistory.setProjectName(name);
		projectHistory.setProjectDescription(description);
		projectHistory.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());

		Version firstVersion = ChangemanagmentFactory.eINSTANCE.createVersion();
		firstVersion.setLogMessage(logMessage);

		PrimaryVersionSpec primary = ChangemanagmentFactory.eINSTANCE
				.createPrimaryVersionSpec();
		primary.setIdentifier(0);
		firstVersion.setPrimarySpec(primary);

		firstVersion.setProjectState(ModelFactory.eINSTANCE.createProject());

		projectHistory.getVersions().add(firstVersion);

		return getProjectInfo(projectHistory);
	}

	private ProjectInfo getProjectInfo(ProjectHistory project) {
		ProjectInfo info = EsmodelFactory.eINSTANCE.createProjectInfo();
		info.setName(project.getProjectName());
		info.setDescription(project.getProjectDescription());
		info.setProjectId(project.getProjectId());
		info.setVersion(project.getVersions().get(0).getPrimarySpec());
		return info;
	}

}
