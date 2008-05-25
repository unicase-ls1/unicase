package org.unicase.workspace.connectionmanager;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.exceptions.ConnectionException;
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
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.workspace.ServerInfo;

public class StubConnectionManagerImpl implements ConnectionManager {

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws ConnectionException {
		throw new UnsupportedOperationException();
	}

	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws ConnectionException {
		throw new UnsupportedOperationException();
	}

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target) throws ConnectionException {
		throw new UnsupportedOperationException();
	}

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws ConnectionException {
		return createDummyProject();
	}

	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws ConnectionException {
		List<ProjectInfo> ret = new ArrayList<ProjectInfo>();
		
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		
		HeadVersionSpec headVersionSpec = ChangemanagmentFactoryImpl.eINSTANCE.createHeadVersionSpec();
		
		ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("TestProject");
		projectInfo.setDescription("A test Project");
		projectInfo.setProjectId(projectId);
		projectInfo.setVersion(resolveVersionSpec(sessionId, headVersionSpec));
		
		ret.add(projectInfo);
		return ret;
	}

	public SessionId logIn(String username, String password,
			ServerInfo severInfo) throws ConnectionException {
		return EsmodelFactory.eINSTANCE.createSessionId();
	}

	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId, VersionSpec versionSpec) {
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

}
