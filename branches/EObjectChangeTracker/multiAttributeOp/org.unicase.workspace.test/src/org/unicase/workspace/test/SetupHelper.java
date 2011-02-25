/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.FileUtil;
import org.unicase.model.organization.User;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.AdminConnectionManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.impl.WorkspaceImpl;
import org.unicase.workspace.test.integration.forward.IntegrationTestHelper;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Helper class for setup/cleanup test fixtures.
 * 
 * @author hodaie
 */
public class SetupHelper {

	private static final Logger LOGGER = Logger.getLogger("org.unicase.workspace.test.SetupHelper");

	private TransactionalEditingDomain domain;
	private Workspace workSpace;
	private ProjectSpace testProjectSpace;
	private Project testProject;
	private Usersession usersession;

	private ProjectId projectId;
	private Project compareProject;

	private String projectPath;
	private TestProjectEnum projectTemplate;

	/**
	 * @param projectTemplate test project to initialize SetupHelper
	 */
	public SetupHelper(TestProjectEnum projectTemplate) {

		this.projectTemplate = projectTemplate;
		LOGGER.log(Level.INFO, "SetupHelper instantiated with " + projectTemplate);
	}

	/**
	 * @param absolutePath The absolute path of an exported project (.ucp file). This project will then be imported and
	 *            used as test project.
	 */
	public SetupHelper(String absolutePath) {

		projectPath = absolutePath;
		LOGGER.log(Level.INFO, "SetupHelper instantiated with " + absolutePath);
	}

	/**
	 * Starts the server.
	 */
	public static void startSever() {
		try {
			ServerConfiguration.setTesting(true);
			// Properties properties = ServerConfiguration.getProperties();
			// little hack, there is a flaw in server configuration
			// properties.setProperty(ServerConfiguration.RMI_ENCRYPTION, ServerConfiguration.FALSE);
			EmfStoreController.runAsNewThread();
			LOGGER.log(Level.INFO, "server started. ");
		} catch (FatalEmfStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stops the server.
	 */
	public static void stopServer() {
		EmfStoreController server = EmfStoreController.getInstance();
		if (server != null) {
			server.stop();
		}
		try {
			// give the server some time to unbind from it's ips. Not the nicest solution ...
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Copies user.properties in server directory.
	 * 
	 * @param override true if old file should be deleted first.
	 */
	public static void addUserFileToServer(boolean override) {
		try {
			File file = new File(ServerConfiguration.getProperties().getProperty(
				ServerConfiguration.AUTHENTICATION_SPFV_FILEPATH, ServerConfiguration.getDefaultSPFVFilePath()));
			if (override && file.exists()) {
				file.delete();
			}
			FileUtil.copyFile(SetupHelper.class.getResourceAsStream("user.properties"), file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param sessionId sessionId
	 * @param username username
	 * @return acorgunitid
	 * @throws EmfStoreException in case of failure
	 */
	public static ACOrgUnitId createUserOnServer(SessionId sessionId, String username) throws EmfStoreException {
		AdminConnectionManager adminConnectionManager = WorkspaceManager.getInstance().getAdminConnectionManager();
		return adminConnectionManager.createUser(sessionId, username);
	}

	/**
	 * @param sessionId sessionid
	 * @param orgUnitId orgunitid
	 * @param role role
	 * @param projectId projectid, can be null, if role is serveradmin
	 * @throws EmfStoreException in case of failure
	 */
	public static void setUsersRole(SessionId sessionId, ACOrgUnitId orgUnitId, EClass role, ProjectId projectId)
		throws EmfStoreException {
		AdminConnectionManager adminConnectionManager = WorkspaceManager.getInstance().getAdminConnectionManager();
		adminConnectionManager.changeRole(sessionId, projectId, orgUnitId, role);
	}

	private static void copyDirectory(File sourceLocation, File targetLocation) throws IOException {

		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}

			String[] children = sourceLocation.list();
			for (int i = 0; i < children.length; i++) {
				copyDirectory(new File(sourceLocation, children[i]), new File(targetLocation, children[i]));
			}
		} else {

			InputStream in = new FileInputStream(sourceLocation);
			OutputStream out = new FileOutputStream(targetLocation);

			// Copy the bits from instream to outstream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
	}

	/**
	 * Setups server space.
	 */
	public static void setupServerSpace() {
		// 1.
		// create a new server space

		// import project history from local folder (it is located in our test plug-in)

		// add the history to server space

		// ===============================
		// 2.
		// copy whole folders and storage from file system to .unicase.test/emfstore

		ServerConfiguration.setTesting(true);
		String serverPath = ServerConfiguration.getServerHome();
		File targetLocation = new File(serverPath);
		String path = "TestProjects/Projects";
		String srcPath = Activator.getDefault().getBundle().getLocation() + path;
		if (File.separator.equals("/")) {
			srcPath = srcPath.replace("reference:file:", "");

		} else {
			srcPath = srcPath.replace("reference:file:/", "");
		}
		File sourceLocation = new File(srcPath);

		try {
			copyDirectory(sourceLocation, targetLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// start server.

		try {
			Properties properties = ServerConfiguration.getProperties();
			properties.setProperty(ServerConfiguration.RMI_ENCRYPTION, ServerConfiguration.FALSE);
			EmfStoreController.runAsNewThread();
		} catch (FatalEmfStoreException e) {
			e.printStackTrace();
		}
		LOGGER.log(Level.INFO, "setup server space finished");

	}

	/**
	 * log in the test server.
	 */
	public void loginServer() {
		if (usersession == null) {
			usersession = WorkspaceFactory.eINSTANCE.createUsersession();

			ServerInfo serverInfo = getServerInfo();
			usersession.setServerInfo(serverInfo);
			usersession.setUsername("super");
			usersession.setPassword("super");
		}

		if (!usersession.isLoggedIn()) {
			try {
				usersession.logIn();
			} catch (AccessControlException e) {
				e.printStackTrace();
			} catch (EmfStoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Returns server info.
	 * 
	 * @return server info
	 */
	public static ServerInfo getServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(8080);
		// serverInfo.setUrl("127.0.0.1");
		serverInfo.setUrl("localhost");
		serverInfo.setCertificateAlias("unicase.org test test(!!!) certificate");

		return serverInfo;
	}

	/**
	 * Setups workspace.
	 */
	public void setupWorkSpace() {
		LOGGER.log(Level.INFO, "setting up workspace...");
		Configuration.setTesting(true);
		workSpace = WorkspaceManager.getInstance().getCurrentWorkspace();
		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		LOGGER.log(Level.INFO, "workspace initialized");

	}

	/**
	 * Creates an empty project space.
	 */
	public void createEmptyTestProjectSpace() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
				projectSpace.setProject(MetamodelFactory.eINSTANCE.createProject());
				projectSpace.setProjectName("Testproject");
				projectSpace.setProjectDescription("Test description");
				projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());

				projectSpace.initResources(workSpace.eResource().getResourceSet());

				((WorkspaceImpl) workSpace).addProjectSpace(projectSpace);
				workSpace.save();
				testProjectSpace = projectSpace;

			}
		}.run();
	}

	/**
	 * Setups a new test project space by importing one of template test projects.
	 */
	public void setupTestProjectSpace() {
		LOGGER.log(Level.INFO, "setting up projectspace...");
		if (projectTemplate != null) {
			// we are using a project template
			setupTestProjectSpace(projectTemplate);
		} else {
			// we are using the absolute path of an exported unicase project (.ucp file)
			setupTestProjectSpace(projectPath);
		}
		LOGGER.log(Level.INFO, "projectspace initialized");

	}

	private void setupTestProjectSpace(TestProjectEnum template) {
		final String path;
		path = template.getPath();

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				String uriString = Activator.getDefault().getBundle().getLocation() + path;
				if (File.separator.equals("/")) {
					uriString = uriString.replace("reference:file:", "");

				} else {
					uriString = uriString.replace("reference:file:/", "");
					uriString = uriString.replace("/", File.separator);
				}
				try {
					testProjectSpace = importProject(uriString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

		testProject = testProjectSpace.getProject();
	}

	/**
	 * Setups a new test project space by importing a project file located at absolutePath.
	 * 
	 * @param absolutePath absolutePath to a project to import.
	 */
	private void setupTestProjectSpace(final String absolutePath) {

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				try {
					testProjectSpace = importProject(absolutePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

		testProject = testProjectSpace.getProject();

	}

	/**
	 * @throws EmfStoreException if any error occurs
	 */
	public void setupTestProjectOnServer() throws EmfStoreException {
		System.out.println("**********************************************************");
		System.out.println("*                                                        *");
		System.out.println("*     Creating a random project with given parameters    *");
		System.out.println("*                                                        *");
		System.out.println("**********************************************************");

		// running the server
		startSever();
		// logging in on server
		loginServer();
		// create a new project id
		projectId = EsmodelFactory.eINSTANCE.createProjectId();
		// visual check if null
		System.out.println("-> Session id is: " + usersession.getSessionId().getId());
		System.out.println("-> Project id is: " + projectId.getId());
		// create a log message

		ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();
		ProjectInfo projectInfo = connectionManager.createEmptyProject(usersession.getSessionId(),
			projectId.toString(), "test_project", createLogMessage("test", "log this!"));

		WorkspaceManager.getInstance().getCurrentWorkspace().checkout(usersession, projectInfo);

	}

	/**
	 * Cleans server up.
	 */
	public static void cleanupServer() {
		String serverPath = ServerConfiguration.getServerHome();
		File serverDirectory = new File(serverPath);
		FileFilter serverFileFilter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().startsWith("project-");
			}

		};
		File[] filesToDeleteOnServer = serverDirectory.listFiles(serverFileFilter);
		for (int i = 0; i < filesToDeleteOnServer.length; i++) {
			try {
				FileUtil.deleteFolder(filesToDeleteOnServer[i]);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		new File(serverPath + "storage.uss").delete();
		LOGGER.log(Level.INFO, "serverspce cleaned.");

	}

	/**
	 * Cleans workspace up.
	 */
	public static void cleanupWorkspace() {

		String workspacePath = Configuration.getWorkspaceDirectory();
		File workspaceDirectory = new File(workspacePath);
		FileFilter workspaceFileFilter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().startsWith("ps-");
			}

		};
		File[] filesToDelete = workspaceDirectory.listFiles(workspaceFileFilter);
		for (int i = 0; i < filesToDelete.length; i++) {
			try {
				FileUtil.deleteFolder(filesToDelete[i]);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		new File(workspacePath + "workspace.ucw").delete();
		LOGGER.log(Level.INFO, "workspace cleaned.");
	}

	/**
	 * Imports a project space from an exported project file.
	 * 
	 * @param absolutePath path to an exported project file
	 * @return project space
	 * @throws IOException IOException
	 */
	public ProjectSpace importProject(String absolutePath) throws IOException {
		return workSpace.importProject(absolutePath);
	}

	/**
	 * Imports a project space from an exported project file.
	 * 
	 * @param projectTemplate project template
	 */
	public void importProject(TestProjectEnum projectTemplate) {
		final String path;
		path = projectTemplate.getPath();

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				String uriString = Activator.getDefault().getBundle().getLocation() + path;
				if (File.separator.equals("/")) {
					uriString = uriString.replace("reference:file:", "");

				} else {
					uriString = uriString.replace("reference:file:/", "");
				}
				try {
					testProjectSpace = workSpace.importProject(uriString);
					testProject = testProjectSpace.getProject();
					projectId = testProjectSpace.getProjectId();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

	}

	/**
	 * This shares test project with server.
	 */
	public void shareProject() {
		LOGGER.log(Level.INFO, "sharing project...");
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				if (usersession == null) {
					usersession = WorkspaceFactory.eINSTANCE.createUsersession();
					ServerInfo serverInfo = getServerInfo();
					usersession.setServerInfo(serverInfo);
					usersession.setUsername("super");
					usersession.setPassword("super");
					WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(usersession);
				}
				try {
					if (!usersession.isLoggedIn()) {
						usersession.logIn();
					}

					getTestProjectSpace().shareProject(usersession);
					LOGGER.log(Level.INFO, "project shared.");
				} catch (EmfStoreException e) {
					e.printStackTrace();
				}
				projectId = testProjectSpace.getProjectId();
			}
		}.run();
	}

	/**
	 * Commits the changes to server.
	 */
	public void commitChanges() {
		final LogMessage logMessage = createLogMessage(usersession.getUsername(), "some message");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				System.out.println(IntegrationTestHelper.getChangePackage(getTestProjectSpace().getOperations(), true,
					false).getOperations().size()
					+ " operations.");
				try {
					getTestProjectSpace().commit(logMessage);
					System.out.println("commit successful!");
				} catch (NoLocalChangesException e) {
					// do nothing
				} catch (EmfStoreException e) {
					e.printStackTrace();
				}

			}
		});

	}

	/**
	 * Create LogMessage.
	 * 
	 * @param name name
	 * @param message message
	 * @return LogMessage
	 */
	public static LogMessage createLogMessage(String name, String message) {
		final LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(name);
		logMessage.setDate(Calendar.getInstance().getTime());
		logMessage.setClientDate(Calendar.getInstance().getTime());
		logMessage.setMessage(message);
		return logMessage;
	}

	/**
	 * Returns project to be compared with test project. This is project that lies on server after committing the
	 * changes. We check out and return it.
	 * 
	 * @return project lying on the server
	 * @throws EmfStoreException EmfStoreException
	 */
	public Project getCompareProject() throws EmfStoreException {
		LOGGER.log(Level.INFO, "retrieving compare project...");
		final ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("CompareProject");
		projectInfo.setDescription("compare project description");
		projectInfo.setProjectId(projectId);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				try {
					compareProject = WorkspaceManager.getInstance().getCurrentWorkspace().checkout(usersession,
						projectInfo).getProject();
					LOGGER.log(Level.INFO, "compare project checked out.");
				} catch (EmfStoreException e) {
					e.printStackTrace();
				}

			}

		});
		return compareProject;
	}

	/**
	 * @return the testProject
	 */
	public Project getTestProject() {
		return testProject;
	}

	/**
	 * @return test project space
	 */
	public ProjectSpace getTestProjectSpace() {
		return testProjectSpace;
	}

	/**
	 * @return workspace
	 */
	public Workspace getWorkSpace() {
		return workSpace;
	}

	/**
	 * @return editing domain
	 */
	public TransactionalEditingDomain getDomain() {
		return domain;
	}

	/**
	 * @return the usersession
	 */
	public Usersession getUsersession() {
		return usersession;
	}

	/**
	 * Creates a versionsepc.
	 * 
	 * @param i verion
	 * @return versionspec
	 */
	public static PrimaryVersionSpec createPrimaryVersionSpec(int i) {
		PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		versionSpec.setIdentifier(i);
		return versionSpec;
	}

	/**
	 * Creates a new Usersession and adds it to the workspace.
	 * 
	 * @param user the session is initialized with this User's name
	 * @return the session
	 */
	public Usersession createUsersession(User user) {
		Usersession session = WorkspaceFactory.eINSTANCE.createUsersession();
		getWorkSpace().getUsersessions().add(session);
		session.setServerInfo(getServerInfo());
		session.setUsername(user.getName());
		session.setPassword("foo");
		return session;
	}

	/**
	 * Creates a new project id.
	 */
	public void createNewProjectId() {
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testProjectSpace.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
				projectId = testProjectSpace.getProjectId();
			}
		});
	}
}
