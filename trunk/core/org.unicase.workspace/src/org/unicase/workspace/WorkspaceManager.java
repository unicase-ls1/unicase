/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelVersion;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.FileUtil;
import org.unicase.metamodel.util.MalformedModelVersionException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.util.UnicaseUtil;
import org.unicase.util.observer.ObserverBus;
import org.unicase.workspace.changeTracking.commands.EMFStoreBasicCommandStack;
import org.unicase.workspace.connectionmanager.AdminConnectionManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.connectionmanager.xmlrpc.XmlRpcAdminConnectionManager;
import org.unicase.workspace.connectionmanager.xmlrpc.XmlRpcConnectionManager;
import org.unicase.workspace.util.EditingDomainProvider;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

import edu.tum.cs.cope.migration.execution.MigrationException;
import edu.tum.cs.cope.migration.execution.Migrator;
import edu.tum.cs.cope.migration.execution.MigratorRegistry;
import edu.tum.cs.cope.migration.execution.ReleaseUtil;

/**
 * Controller for workspaces. Workspace Manager is a singleton.
 * 
 * @author Maximilian Koegel
 * @generated NOT
 */
public final class WorkspaceManager {

	private static WorkspaceManager instance;

	private Workspace currentWorkspace;
	private ConnectionManager connectionManager;
	private AdminConnectionManager adminConnectionManager;

	private ObserverBus observerBus;

	/**
	 * Get an instance of the workspace manager. Will create an instance if no workspace manager is present.
	 * 
	 * @return the workspace manager singleton
	 * @generated NOT
	 */
	public static synchronized WorkspaceManager getInstance() {
		if (instance == null) {
			try {
				instance = new WorkspaceManager();
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SURPRESS CATCH EXCEPTION
				ModelUtil.logException("Workspace Initialization failed, shutting down", e);
				throw e;
			}

			// init ecore packages
			UnicaseUtil.getAllModelElementEClasses();

			// notify post workspace observers
			instance.notifyPostWorkspaceInitiators();
		}
		return instance;
	}

	/**
	 * Initialize the Workspace Manager singleton.
	 */
	public static synchronized void init() {
		getInstance();
	}

	/**
	 * Default constructor.
	 * 
	 * @generated NOT
	 */
	private WorkspaceManager() {
		this.connectionManager = initConnectionManager();
		this.adminConnectionManager = initAdminConnectionManager();
		this.currentWorkspace = initWorkSpace();
		this.observerBus = new ObserverBus();
	}

	private void notifyPostWorkspaceInitiators() {
		IConfigurationElement[] workspaceObservers = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.workspace.notify.postinit");
		for (IConfigurationElement element : workspaceObservers) {
			try {
				PostWorkspaceInitiator workspaceObserver = (PostWorkspaceInitiator) element
					.createExecutableExtension("class");
				workspaceObserver.workspaceInitComplete(currentWorkspace);
			} catch (CoreException e) {
				WorkspaceUtil.logException(e.getMessage(), e);
			}
		}
	}

	/**
	 * Initialize the connection manager of the workspace. The connection manager connects the workspace with the emf
	 * store.
	 * 
	 * @return the connection manager
	 * @generated NOT
	 */
	private ConnectionManager initConnectionManager() {
		KeyStoreManager.getInstance().setupKeys();
		// return new RMIConnectionManagerImpl();
		return new XmlRpcConnectionManager();
	}

	/**
	 * Initialize the connection manager of the workspace. The connection manager connects the workspace with the emf
	 * store.
	 * 
	 * @return the admin connection manager
	 * @generated NOT
	 */
	private AdminConnectionManager initAdminConnectionManager() {
		// return new RMIAdminConnectionManagerImpl();
		return new XmlRpcAdminConnectionManager();
	}

	/**
	 * Initialize the workspace. Loads workspace from persistent storage if present. There is always one current
	 * Workspace.
	 * 
	 * @return the workspace
	 * @generated NOT
	 */
	private Workspace initWorkSpace() {
		ResourceSet resourceSet = new ResourceSetImpl();

		// register an editing domain on the ressource
		Configuration.setEditingDomain(createEditingDomain(resourceSet));

		URI fileURI = URI.createFileURI(Configuration.getWorkspacePath());
		File workspaceFile = new File(Configuration.getWorkspacePath());
		final Workspace workspace;
		final Resource resource;
		if (!workspaceFile.exists()) {

			workspace = createNewWorkspace(resourceSet, fileURI);

		} else {
			// file exists load it
			// check if a migration is needed
			migrateModel(resourceSet);

			resource = resourceSet.getResource(fileURI, true);
			EList<EObject> directContents = resource.getContents();
			// MK cast
			workspace = (Workspace) directContents.get(0);
		}

		workspace.setConnectionManager(this.connectionManager);
		workspace.setWorkspaceResourceSet(resourceSet);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				workspace.init();
			}
		}.run(true);

		return workspace;

	}

	private EditingDomain createEditingDomain(ResourceSet resourceSet) {
		EditingDomainProvider domainProvider = getDomainProvider();
		if (domainProvider != null) {
			return domainProvider.getEditingDomain(resourceSet);
		} else {
			AdapterFactoryEditingDomain domain = new AdapterFactoryEditingDomain(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE), new EMFStoreBasicCommandStack(), resourceSet);
			resourceSet.eAdapters().add(new AdapterFactoryEditingDomain.EditingDomainProvider(domain));
			return domain;
		}
	}

	private EditingDomainProvider getDomainProvider() {
		IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.workspace.editingDomainProvider");
		for (IConfigurationElement extension : rawExtensions) {
			try {
				EditingDomainProvider provider = (EditingDomainProvider) extension.createExecutableExtension("class");
				if (provider != null) {
					return provider;
				}
			} catch (CoreException e) {
				// fail silently
			}
		}
		return null;
	}

	private Workspace createNewWorkspace(ResourceSet resourceSet, URI fileURI) {
		final Workspace workspace;
		final Resource resource;
		// no workspace content found, create a workspace
		resource = resourceSet.createResource(fileURI);
		workspace = WorkspaceFactory.eINSTANCE.createWorkspace();
		workspace.getServerInfos().addAll(Configuration.getDefaultServerInfos());
		EList<Usersession> usersessions = workspace.getUsersessions();
		for (ServerInfo serverInfo : workspace.getServerInfos()) {
			Usersession lastUsersession = serverInfo.getLastUsersession();
			if (lastUsersession != null) {
				usersessions.add(lastUsersession);
			}
		}

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				resource.getContents().add(workspace);
			}
		}.run(true);

		try {
			resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			WorkspaceUtil.logException(
				"Creating new workspace failed! Delete workspace folder: " + Configuration.getWorkspaceDirectory(), e);
		}
		int modelVersionNumber;
		try {
			modelVersionNumber = ModelUtil.getModelVersionNumber();
			stampCurrentVersionNumber(modelVersionNumber);
		} catch (MalformedModelVersionException e1) {
			WorkspaceUtil.logException("Loading model version failed!", e1);
		}
		return workspace;
	}

	private void stampCurrentVersionNumber(int modelReleaseNumber) {
		URI versionFileUri = URI.createFileURI(Configuration.getModelReleaseNumberFileName());
		Resource versionResource = new ResourceSetImpl().createResource(versionFileUri);
		ModelVersion modelVersion = MetamodelFactory.eINSTANCE.createModelVersion();
		modelVersion.setReleaseNumber(modelReleaseNumber);
		versionResource.getContents().add(modelVersion);
		try {
			versionResource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			WorkspaceUtil.logException(
				"Version stamping workspace failed! Delete workspace folder: " + Configuration.getWorkspaceDirectory(),
				e);
		}
	}

	private void migrateModel(ResourceSet resourceSet) {
		ModelVersion workspaceModelVersion = getWorkspaceModelVersion();
		int modelVersionNumber;
		try {
			modelVersionNumber = ModelUtil.getModelVersionNumber();
			stampCurrentVersionNumber(modelVersionNumber);
		} catch (MalformedModelVersionException e1) {
			WorkspaceUtil.logException("Loading model version failed, migration skipped!", e1);
			return;
		}
		if (workspaceModelVersion.getReleaseNumber() == modelVersionNumber) {
			return;
		} else if (workspaceModelVersion.getReleaseNumber() > modelVersionNumber) {
			backupAndRecreateWorkspace(resourceSet);
			WorkspaceUtil.logException("Model conforms to a newer version, update client! New workspace was backuped!",
				new IllegalStateException());
			return;
		}

		// we need to migrate
		backupWorkspace(false);
		File workspaceFile = new File(Configuration.getWorkspaceDirectory());
		for (File file : workspaceFile.listFiles()) {
			if (file.getName().startsWith(Configuration.getProjectSpaceDirectoryPrefix())) {
				String projectFilePath = file.getAbsolutePath() + File.separatorChar
					+ Configuration.getProjectFolderName() + File.separatorChar + 0
					+ Configuration.getProjectFragmentFileExtension();
				URI projectURI = URI.createFileURI(projectFilePath);
				String operationsFilePath = null;
				File[] listFiles = file.listFiles();
				if (listFiles == null) {
					WorkspaceUtil.logException("The migration of the project in projectspace at " + projectFilePath
						+ " failed!", new IllegalStateException("Broken projectSpace!"));
					continue;
				}
				for (File subDirFile : listFiles) {
					if (subDirFile.getName().endsWith(Configuration.getOperationCompositeFileExtension())) {
						operationsFilePath = subDirFile.getAbsolutePath();
					}
				}
				if (operationsFilePath == null) {
					WorkspaceUtil.logException("The migration of the project in projectspace at " + projectFilePath
						+ " failed!", new IllegalStateException("Broken workspace!"));
					backupAndRecreateWorkspace(resourceSet);
				}
				URI operationsURI = URI.createFileURI(operationsFilePath);
				try {
					migrate(projectURI, operationsURI, workspaceModelVersion.getReleaseNumber());
				} catch (MigrationException e) {
					WorkspaceUtil.logException("The migration of the project in projectspace at " + projectFilePath
						+ " failed!", e);
					backupAndRecreateWorkspace(resourceSet);
				}
			}
		}

		stampCurrentVersionNumber(modelVersionNumber);
	}

	public void migrate(String absoluteFilename) {
		URI projectURI = URI.createFileURI(absoluteFilename);
		String namespaceURI = ReleaseUtil.getNamespaceURI(projectURI);
		Migrator migrator = MigratorRegistry.getInstance().getMigrator(namespaceURI);
		if (migrator == null) {
			return;
		}
		List<URI> modelURIs = new ArrayList<URI>();
		modelURIs.add(projectURI);
		// MK: build in progress monitor for migration here
		ModelVersion workspaceModelVersion = getWorkspaceModelVersion();

		try {
			migrator.migrateAndSave(modelURIs, workspaceModelVersion.getReleaseNumber() - 1, Integer.MAX_VALUE,
				new NullProgressMonitor());
		} catch (MigrationException e) {
			WorkspaceUtil.logException("The migration of the project in the file " + absoluteFilename + " failed!", e);
		}
	}

	private void backupAndRecreateWorkspace(ResourceSet resourceSet) {
		backupWorkspace(true);
		URI fileURI = URI.createFileURI(Configuration.getWorkspacePath());
		createNewWorkspace(resourceSet, fileURI);
	}

	private void backupWorkspace(boolean move) {
		String workspaceDirectory = Configuration.getWorkspaceDirectory();
		File workspacePath = new File(workspaceDirectory);

		// String newWorkspaceDirectory = Configuration.getUserHome() + "unicase_backup_" + System.currentTimeMillis()
		// + "_" + new Date();
		// TODO: if you want the date included in the backup folder you should change the format. the default format
		// does not work with every os due to : and other characters.
		String newWorkspaceDirectory = Configuration.getLocationProvider().getBackupDirectory() + "unicase_backup_"
			+ System.currentTimeMillis();

		File workspacebackupPath = new File(newWorkspaceDirectory);
		if (move) {
			workspacePath.renameTo(workspacebackupPath);
		} else {
			try {
				FileUtil.copyDirectory(workspacePath, workspacebackupPath);
			} catch (IOException e) {
				WorkspaceUtil.logException("Workspace backup failed!", e);
			}
		}
	}

	private ModelVersion getWorkspaceModelVersion() {
		// check for legacy workspace
		File versionFile = new File(Configuration.getModelReleaseNumberFileName());
		if (!versionFile.exists()) {
			int modelVersionNumber;
			try {
				modelVersionNumber = ModelUtil.getModelVersionNumber();
				stampCurrentVersionNumber(modelVersionNumber);
			} catch (MalformedModelVersionException e1) {
				WorkspaceUtil.logException("Loading model version failed!", e1);
			}
		}

		// check if we need to migrate
		URI versionFileUri = URI.createFileURI(Configuration.getModelReleaseNumberFileName());
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			Resource resource = resourceSet.getResource(versionFileUri, true);
			EList<EObject> directContents = resource.getContents();
			ModelVersion modelVersion = (ModelVersion) directContents.get(0);
			return modelVersion;
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			// resource can not be loaded, assume version number before metamodel split
			ModelVersion modelVersion = MetamodelFactory.eINSTANCE.createModelVersion();
			modelVersion.setReleaseNumber(4);
			return modelVersion;
		}

	}

	/**
	 * Migrate the model instance if neccessary.
	 * 
	 * @param projectURI the uri of the project state
	 * @param changesURI the uri of the local changes of the project state
	 * @param sourceModelReleaseNumber
	 * @throws ModelMigrationException
	 */
	private void migrate(URI projectURI, URI changesURI, int sourceModelReleaseNumber) throws MigrationException {
		String namespaceURI = ReleaseUtil.getNamespaceURI(projectURI);
		Migrator migrator = MigratorRegistry.getInstance().getMigrator(namespaceURI);
		if (migrator == null) {
			return;
		}
		List<URI> modelURIs = new ArrayList<URI>();
		modelURIs.add(projectURI);
		modelURIs.add(changesURI);
		// MK: build in progress monitor for migration here
		migrator.migrateAndSave(modelURIs, sourceModelReleaseNumber, Integer.MAX_VALUE, new NullProgressMonitor());
	}

	/**
	 * Get the current workspace. There is always one current workspace.
	 * 
	 * @return the workspace
	 */
	public Workspace getCurrentWorkspace() {
		return currentWorkspace;
	}

	/**
	 * Get the connection manager. Return the connection manager for this workspace.
	 * 
	 * @return the connectionManager
	 */
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * Set the connectionmanager.
	 * 
	 * @param manager connection manager.
	 */
	public void setConnectionManager(ConnectionManager manager) {
		connectionManager = manager;
	}

	/**
	 * Get the admin connection manager. Return the admin connection manager for this workspace.
	 * 
	 * @return the connectionManager
	 */
	public AdminConnectionManager getAdminConnectionManager() {
		return adminConnectionManager;
	}

	/**
	 * Retrieve the project space for a model element.
	 * 
	 * @param modelElement the model element
	 * @return the project space
	 */
	public static ProjectSpace getProjectSpace(EObject modelElement) {

		if (modelElement == null) {
			throw new IllegalArgumentException("The model element is null");
		} else if (modelElement instanceof ProjectSpace) {
			return (ProjectSpace) modelElement;
		}

		Project project = ModelUtil.getProject(modelElement);

		if (project == null) {
			throw new IllegalArgumentException("The model element " + modelElement + " has no project");
		}
		return getProjectSpace(project);
	}

	/**
	 * Retrieve the project space for a project.
	 * 
	 * @param project the project
	 * @return the project space
	 */
	public static ProjectSpace getProjectSpace(Project project) {
		if (project == null) {
			throw new IllegalArgumentException("The project is null");
		}
		// check if my container is a project space
		if (WorkspacePackage.eINSTANCE.getProjectSpace().isInstance(project.eContainer())) {
			return (ProjectSpace) project.eContainer();
		} else {
			throw new IllegalStateException("Project is not contained by any project space");
		}
	}

	/**
	 * Returns the {@link ObserverBus}.
	 * 
	 * @return observer bus
	 */
	public static ObserverBus getObserverBus() {
		return getInstance().observerBus;
	}
}
