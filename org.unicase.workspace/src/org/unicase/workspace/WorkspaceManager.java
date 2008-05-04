package org.unicase.workspace;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.StubConnectionManagerImpl;
import org.unicase.workspace.impl.WorkspaceFactoryImpl;
import org.unicase.workspace.impl.WorkspaceImpl;

public class WorkspaceManager {

	private static WorkspaceManager instance;

	private Workspace currentWorkspace;
	private ConnectionManager connectionManager;

	public static WorkspaceManager getInstance() {
		if (instance == null) {
			instance = new WorkspaceManager();
		}
		return instance;
	}

	public WorkspaceManager() {
		this.connectionManager = initConnectionManager();
		this.currentWorkspace = initWorkSpace();

	}

	private ConnectionManager initConnectionManager() {
		return new StubConnectionManagerImpl();
	}

	private Workspace initWorkSpace() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(Configuration.getWorkspacePath());
		File workspaceFile = new File(Configuration.getWorkspacePath());
		if (!workspaceFile.exists()) {

			// no workspace content found, create a workspace
			Resource resource = resourceSet.createResource(fileURI);
			Workspace workspace = WorkspaceFactoryImpl.eINSTANCE
					.createWorkspace();
			workspace.setConnectionManager(this.connectionManager);
			workspace.setResource(resource);
			resource.getContents().add(workspace);
			try {
				resource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				// MK Auto-generated catch block
				e.printStackTrace();
			}
			return workspace;
		}

		// if file exists load it
		Resource resource = resourceSet.getResource(fileURI, true);
		EList<EObject> directContents = resource.getContents();
		for (EObject eObject : directContents) {
			if (eObject instanceof WorkspaceImpl) {
				Workspace workspace = (Workspace) eObject;
				workspace.setConnectionManager(this.connectionManager);
				workspace.setResource(resource);
				//initialize all projectSpaces
				for (ProjectSpace projectSpace: workspace.getProjectSpaces()) {
					projectSpace.init();
				}
				return workspace;
			}
		}
		
		throw new IllegalStateException();

	}

	/**
	 * @return the workspace
	 */
	public Workspace getCurrentWorkspace() {
		return currentWorkspace;
	}

	/**
	 * @return the connectionManager
	 */
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}
}
