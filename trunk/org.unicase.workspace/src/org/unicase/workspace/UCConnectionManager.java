package org.unicase.workspace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.model.CompositeSection;
import org.unicase.model.FunctionalRequirement;
import org.unicase.model.LeafSection;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.ProjectId;
import org.unicase.model.impl.ModelFactoryImpl;

/**
 * How to get retrieve a Project
 * 
 * create a new UserSession (a serverinfo can be obtained from UserSession.getDefaultServerInfo)
 * call logIn on usersession to log in
 * call getProjectList on the usersession to get a list of available projects
 * call checkOut on UserSession to get a Workspace
 * call getProject on UCWorkSpace to get a Project
 * 
 * @author koegel
 *
 */
public class UCConnectionManager {

	private static UCConnectionManager instance;
	private UCWorkspace currentWorkspace;
	private String workspaceDir;

	private UCConnectionManager() {
		this.workspaceDir = UCConfiguration.getWorkspaceDirectory();
	}

	public static UCConnectionManager getInstance() {
		if (instance == null) {
			instance = new UCConnectionManager();
		}
		return instance;
	}

	public SessionId logIn(ServerInfo serverInfo, String username,
			String password) {
		return new SessionId("someId");
	}

	public List<ProjectInfo> getProjectList(SessionId sessionId) {
		List<ProjectInfo> ret = new ArrayList<ProjectInfo>();
		ProjectId projectId = ModelFactoryImpl.eINSTANCE.createProjectId();
		ret.add(new ProjectInfo(projectId, "TestProjec", "A test project"));
		return ret;
	}

	public UCWorkspace checkOut(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec version) {
		URI uri = URI.createFileURI(workspaceDir + "projectID");
		Project project = createDummyProject();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource ecoreResource = resourceSet.createResource(uri);
		// add root element of the model to the resource
		ecoreResource.getContents().add(project);
		// save the resource
		Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		try {
			ecoreResource.save(saveOptions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UCWorkspace workspace = new UCWorkspace(sessionId, projectId, version,
				ecoreResource, this);
		
		return workspace;
	}

	public UCWorkspace getCurrentWorkspace() {
		return currentWorkspace;
	}

	public List<ChangePackage> getChanges(SessionId sessionId,
			VersionSpec sourceVersion, VersionSpec targetVersion) {
		throw new NoSuchMethodError();
	}

	public List<HistoryInfo> getHistoryInfos(SessionId sessionId,
			VersionSpec sourceVersion, VersionSpec targetVersion) {
		throw new NoSuchMethodError();
	}

	private Project createDummyProject() {
		// Generate the elements of the model

		ModelFactory factory = ModelFactoryImpl.eINSTANCE;
		Project projectElement = factory.createProject();
		projectElement.setName("Sysiphus EMF Evaluation");
		projectElement
				.setDescription("This model is part of the effort to evaluate the EMF Framework.");

		CompositeSection rootSection = factory.createCompositeSection();
		rootSection.setName("RAD");
		rootSection
				.setDescription("The requirements analysis document of the project");
		rootSection.setId("1");

		LeafSection reqLeafSection = factory.createLeafSection();
		reqLeafSection.setName("Functional Requirements");
		reqLeafSection
				.setDescription("Lists all functional requirements in this project");
		reqLeafSection.setElementType(FunctionalRequirement.class);

		reqLeafSection.setId("2");
		reqLeafSection.setParent(rootSection);

		LeafSection scenLeafSection = factory.createLeafSection();
		scenLeafSection.setName("Scenarios");
		scenLeafSection.setDescription("Lists all scenarios of this project.");
		scenLeafSection.setId("3");
		scenLeafSection.setParent(rootSection);
		scenLeafSection.setElementType(FunctionalRequirement.class);

		CompositeSection ucmCompositeSection = factory.createCompositeSection();
		ucmCompositeSection.setName("Use Case Modeling");
		ucmCompositeSection
				.setDescription("Contains sections concerning use cases.");
		ucmCompositeSection.setId("4");
		ucmCompositeSection.setParent(rootSection);

		LeafSection actorLeafSection = factory.createLeafSection();
		actorLeafSection.setName("Actors");
		actorLeafSection.setDescription("Lists all actors of this project.");
		actorLeafSection.setId("5");
		actorLeafSection.setParent(ucmCompositeSection);
		actorLeafSection.setElementType(FunctionalRequirement.class);

		LeafSection useCaseLeafSection = factory.createLeafSection();
		useCaseLeafSection.setName("Use Cases");
		useCaseLeafSection
				.setDescription("Lists all use cases of this project.");
		useCaseLeafSection.setId("6");
		useCaseLeafSection.setParent(ucmCompositeSection);
		useCaseLeafSection.setElementType(FunctionalRequirement.class);

		LeafSection useCaseDiagramLeafSection = factory.createLeafSection();
		useCaseDiagramLeafSection.setName("Use Case Diagrams");
		useCaseDiagramLeafSection
				.setDescription("Lists all use case diagrams of this project.");
		useCaseDiagramLeafSection.setId("7");
		useCaseDiagramLeafSection.setParent(ucmCompositeSection);
		useCaseDiagramLeafSection.setElementType(FunctionalRequirement.class);

		FunctionalRequirement fr = factory.createFunctionalRequirement();
		fr.setName("My Reuirement");
		fr.setId("8");
		fr.setProject(projectElement);
		FunctionalRequirement fr2 = factory.createFunctionalRequirement();
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

}
