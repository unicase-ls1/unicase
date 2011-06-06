package org.eclipse.emf.emfstore.client.core;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.client.ProjectSpace;
import org.eclipse.emf.emfstore.client.WorkspaceManager;
import org.eclipse.emf.emfstore.client.connectionmanager.ConnectionManager;
import org.eclipse.emf.emfstore.client.exceptions.ProjectUrlResolutionException;
import org.eclipse.emf.emfstore.client.exceptions.ServerUrlResolutionException;
import org.eclipse.emf.emfstore.client.exceptions.UnkownProjectException;
import org.eclipse.emf.emfstore.client.model.ProjectData;
import org.eclipse.emf.emfstore.client.model.ProjectSpaceData;
import org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal;
import org.eclipse.emf.emfstore.client.util.Configuration;
import org.eclipse.emf.emfstore.client.util.ResourceHelper;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.ServerUrl;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;

public class WorkspaceControllerImpl implements WorkspaceControllerInternal {

	private final WorkspaceDataInternal internalWorkspaceData;
	private HashMap<ProjectData, ProjectSpace> projectToProjectSpaceMap;
	private ConnectionManager connectionManager;

	public WorkspaceControllerImpl(WorkspaceDataInternal internalWorkspaceData) {
		this.internalWorkspaceData = internalWorkspaceData;
		init();
	}

	public List<ProjectSpace> getProjectSpaces() {
		EList<ProjectSpaceDataInternal> internalProjectSpaces = internalWorkspaceData
				.getInternalProjectSpaces();
		return null;
		// TODO
		// Collections.copy(arg0, arg1)
		// internalProjectSpaces.
	}

	public ProjectSpace getActiveProjectSpace() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setActiveProjectSpace(ProjectSpace newActiveProjectSpace) {
		// TODO Auto-generated method stub

	}

	public ProjectSpace getProjectSpace(Project project)
			throws UnkownProjectException {
		ProjectSpace projectSpace = projectToProjectSpaceMap.get(project);
		if (projectSpace == null) {
			throw new UnkownProjectException();
		}
		return projectSpace;
	}

	public ProjectSpace checkout(Usersession usersession,
			ProjectInfo projectInfo) throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public ProjectSpaceInternal checkout(Usersession usersession,
			ProjectInfo projectInfo, PrimaryVersionSpec targetSpec)
			throws EmfStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public ProjectSpace importProject(String absoluteFileName)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ProjectSpace importProject(Project project, String name,
			String description) {
		// TODO Auto-generated method stub
		return null;
	}

	public void exportProject(ProjectSpace projectSpace, String absoluteFileName)
			throws IOException {
		// TODO Auto-generated method stub

	}

	public void exportProjectSpace(ProjectSpace projectSpace,
			String absoluteFileName) throws IOException {
		// TODO Auto-generated method stub

	}

	public void exportWorkSpace(String absoluteFileName) throws IOException {
		WorkspaceDataInternal copy = ModelUtil.clone(internalWorkspaceData);

		int i = 0;

		for (ProjectSpaceDataInternal copiedProjectSpace : copy
				.getInternalProjectSpaces()) {
			Project orgProject = WorkspaceManager.getInstance()
					.getCurrentWorkspace().getProjectSpaces().get(i++)
					.getProject();
			copiedProjectSpace.setProject(ModelUtil.clone(orgProject));
		}

		ResourceHelper.putWorkspaceIntoNewResource(absoluteFileName, copy);
	}

	public ProjectSpace importProjectSpace(String absoluteFileName)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ProjectSpace createLocalProject(String projectName,
			String projectDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<ProjectSpace> resolve(ProjectUrlFragment projectUrlFragment)
			throws ProjectUrlResolutionException {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<ServerInfo> resolve(ServerUrl serverUrl)
			throws ServerUrlResolutionException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProjectSpace(ProjectSpaceInternal projectSpace)
			throws IOException {
		// TODO Auto-generated method stub

	}

	public void save() {
		try {
			internalWorkspaceData.eResource().save(
					Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			// MK Auto-generated catch block
			// FIXME OW MK: also insert code for dangling href handling here
		}
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	private void init() {
		projectToProjectSpaceMap = new HashMap<ProjectData, ProjectSpace>();
		// initialize all projectSpaces
		for (ProjectSpaceDataInternal data : internalWorkspaceData
				.getInternalProjectSpaces()) {

			ProjectSpaceControllerInternal controller = new ProjectSpaceControllerImpl(
					data);

			ProjectSpace newProxyInstance = (ProjectSpace) Proxy
					.newProxyInstance(this.getClass().getClassLoader(),
							new Class[] { ProjectSpace.class,
									ProjectSpaceInternal.class,
									ProjectSpaceData.class,
									ProjectSpaceInternal.class,
									ProjectSpaceController.class,
									ProjectSpaceControllerInternal.class },
							new ProjectSpaceInvocationHandler(controller, data));

			// TODO fix key, might not be unique
			projectToProjectSpaceMap.put((ProjectData) data, newProxyInstance);
		}
		// projectSpace.init();
		// projectToProjectSpaceMap.put(projectSpace.getProject(),
		// projectSpace);
		// // add plugin start event
		// PluginStartEvent event = EventsFactory.eINSTANCE
		// .createPluginStartEvent();
		// event.setPluginId("org.eclipse.emf.emfstore.client");
		// event.setTimestamp(new Date());
		// // projectSpace.addEvent(event);
		// }
	}

	private final class ProjectSpaceInvocationHandler implements
			InvocationHandler {

		private final ProjectSpaceControllerInternal controller;
		private final ProjectSpaceDataInternal data;
		private Map<Method, Object> methodMapping;

		public ProjectSpaceInvocationHandler(
				ProjectSpaceControllerInternal controller,
				ProjectSpaceDataInternal data) {
			this.controller = controller;
			this.data = data;
			this.methodMapping = new HashMap<Method, Object>();
			initMethodMapping();
		}

		private void initMethodMapping() {

			for (Method method : ProjectSpaceControllerInternal.class
					.getMethods()) {
				methodMapping.put(method, controller);
			}

			for (Method method : ProjectSpaceDataInternal.class.getMethods()) {
				methodMapping.put(method, data);
			}
		}

		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			return method.invoke(methodMapping.get(method), args);
		}
	}

	public void exportProject(ProjectSpaceData projectSpace,
			String absoluteFileName) throws IOException {
		// TODO Auto-generated method stub

	}

	public void exportProjectSpace(ProjectSpaceData projectSpace,
			String absoluteFileName) throws IOException {
		// TODO Auto-generated method stub

	}

}
