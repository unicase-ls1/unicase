/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.accesscontrol.AccessControlImpl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIAdminConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIConnectionHandler;
import org.unicase.emfstore.connection.xmlrpc.XmlRpcAdminConnectionHander;
import org.unicase.emfstore.connection.xmlrpc.XmlRpcConnectionHandler;
import org.unicase.emfstore.core.AdminEmfStoreImpl;
import org.unicase.emfstore.core.EmfStoreImpl;
import org.unicase.emfstore.core.helper.HistoryCache;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesFactory;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.StorageException;
import org.unicase.emfstore.startup.EmfStoreValidator;
import org.unicase.emfstore.startup.ExtensionManager;
import org.unicase.emfstore.startup.MigrationManager;
import org.unicase.emfstore.storage.ResourceStorage;
import org.unicase.emfstore.taskmanager.TaskManager;
import org.unicase.emfstore.taskmanager.tasks.CleanMemoryTask;
import org.unicase.metamodel.util.FileUtil;
import org.unicase.metamodel.util.ModelUtil;

/**
 * The {@link EmfStoreController} is controlling startup and shutdown of the EmfStore.
 * 
 * @author koegel
 * @author wesendonk
 */
public class EmfStoreController implements IApplication, Runnable {

	private EmfStore emfStore;
	private AdminEmfStore adminEmfStore;
	private AccessControlImpl accessControl;
	private Set<ConnectionHandler<? extends EmfStoreInterface>> connectionHandlers;
	private Properties properties;
	private ServerSpace serverSpace;
	private Resource resource;

	private static EmfStoreController instance;

	private HistoryCache historyCache;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws FatalEmfStoreException {

		run(true);
		instance = null;
		ModelUtil.logInfo("Server is STOPPED.");
		return IApplication.EXIT_OK;

	}

	/**
	 * Run the server.
	 * 
	 * @param waitForTermination true if the server should force the calling thread to wait for its termination
	 * @throws FatalEmfStoreException if the server fails fatally
	 */
	public void run(boolean waitForTermination) throws FatalEmfStoreException {
		if (instance != null) {
			throw new FatalEmfStoreException("Another EmfStore Controller seems to be running already!");
		}

		instance = this;

		serverHeader();

		initLogging();

		// copy es.properties file to workspace if not existent
		copyFileToWorkspace(ServerConfiguration.getConfFile(), "es.properties",
			"Couldn't copy es.properties file to config folder.",
			"Default es.properties file was copied to config folder.");

		properties = initProperties();

		new MigrationManager().migrateModel();

		this.serverSpace = initServerSpace();

		handleStartupListener();

		historyCache = initHistoryCache();

		accessControl = initAccessControl(serverSpace);
		emfStore = new EmfStoreImpl(serverSpace, accessControl);
		adminEmfStore = new AdminEmfStoreImpl(serverSpace, accessControl);

		// copy keystore file to workspace if not existent
		copyFileToWorkspace(ServerConfiguration.getServerKeyStorePath(), "unicaseServer.keystore",
			"Failed to copy keystore.", "Keystore was copied to server workspace.");

		ExtensionManager.checkModel();

		connectionHandlers = initConnectionHandlers();

		TaskManager taskManager = TaskManager.getInstance();
		taskManager.addTask(new CleanMemoryTask(serverSpace));
		// taskManager.addTask(new MemoryPlotter(new Date(), 20 * 1000));
		taskManager.start();

		handlePostStartupListener();

		ModelUtil.logInfo("Initialitation COMPLETE.");
		ModelUtil.logInfo("Server is RUNNING...");

		if (waitForTermination) {
			waitForTermination();
		}
	}

	private void initLogging() {
		Platform.getLog(Platform.getBundle("org.unicase.metamodel")).addLogListener(new ILogListener() {

			public void logging(IStatus status, String plugin) {
				if (status.getSeverity() == IStatus.INFO) {
					System.out.println(status.getMessage());
				} else if (!status.isOK()) {
					System.err.println(status.getMessage());
					status.getException().printStackTrace(System.err);
				}
			}

		});
	}

	private void handleStartupListener() {
		String property = ServerConfiguration.getProperties().getProperty(ServerConfiguration.LOAD_STARTUP_LISTENER,
			ServerConfiguration.LOAD_STARTUP_LISTENER_DEFAULT);
		if (ServerConfiguration.TRUE.equals(property)) {
			ModelUtil.logInfo("Notifying startup listener");
			ExtensionManager.notifyStartupListener(serverSpace.getProjects());
		}
	}

	private void handlePostStartupListener() {
		String property = ServerConfiguration.getProperties().getProperty(
			ServerConfiguration.LOAD_POST_STARTUP_LISTENER, ServerConfiguration.LOAD_STARTUP_LISTENER_DEFAULT);
		if (ServerConfiguration.TRUE.equals(property)) {
			ModelUtil.logInfo("Notifying post startup listener");
			ExtensionManager.notifyPostStartupListener(serverSpace, accessControl, connectionHandlers);
		}
	}

	private void copyFileToWorkspace(String target, String source, String failure, String success) {
		File keyStore = new File(target);
		if (!keyStore.exists()) {
			try {
				FileUtil.copyFile(getClass().getResourceAsStream(source), keyStore);
			} catch (IOException e) {
				ModelUtil.logWarning("Copy of file from " + source + " to " + target + " failed", e);
			}
		}
	}

	private HistoryCache initHistoryCache() {
		HistoryCache cache = new HistoryCache();
		cache.initCache(serverSpace.getProjects());
		ModelUtil.logInfo("History cache has been initialized.");
		return cache;
	}

	private Set<ConnectionHandler<? extends EmfStoreInterface>> initConnectionHandlers() throws FatalEmfStoreException {
		Set<ConnectionHandler<? extends EmfStoreInterface>> connectionHandlers = new HashSet<ConnectionHandler<? extends EmfStoreInterface>>();

		// create RMI connection handler for emfstore
		RMIConnectionHandler rmiConnectionHandler = new RMIConnectionHandler();
		rmiConnectionHandler.init(emfStore, accessControl);
		connectionHandlers.add(rmiConnectionHandler);

		// create RMI connection handler for admin emfstore
		RMIAdminConnectionHandler rmiAdminConnectionHandler = new RMIAdminConnectionHandler();
		rmiAdminConnectionHandler.init(adminEmfStore, accessControl);
		connectionHandlers.add(rmiAdminConnectionHandler);

		// crate XML RPC connection handlers
		XmlRpcConnectionHandler xmlRpcConnectionHander = new XmlRpcConnectionHandler();
		xmlRpcConnectionHander.init(emfStore, accessControl);
		connectionHandlers.add(xmlRpcConnectionHander);

		XmlRpcAdminConnectionHander xmlRpcAdminConnectionHander = new XmlRpcAdminConnectionHander();
		xmlRpcAdminConnectionHander.init(adminEmfStore, accessControl);
		connectionHandlers.add(xmlRpcAdminConnectionHander);

		return connectionHandlers;
	}

	/**
	 * Returns the history cache.
	 * 
	 * @return the history cache.
	 */
	public HistoryCache getHistoryCache() {
		return historyCache;
	}

	private ServerSpace initServerSpace() throws FatalEmfStoreException {
		ResourceStorage storage = initStorage();
		URI resourceUri = storage.init(properties);
		ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.getResource(resourceUri, true);
		try {
			resource.load(resourceSet.getLoadOptions());

			if (properties.getProperty(ServerConfiguration.VALIDATE_SERVERSPACE_ON_SERVERSTART, "true").equals("true")) {
				ModelUtil.logInfo("Validating serverspace ...");
				validateServerSpace(resource);
				ModelUtil.logInfo("Validation complete.");
			}
		} catch (IOException e) {
			throw new FatalEmfStoreException(StorageException.NOLOAD, e);
		}

		ServerSpace result = null;
		EList<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			if (content instanceof ServerSpace) {
				result = (ServerSpace) content;
				break;
			}
		}

		if (result != null) {
			result.setResource(resource);
		} else {
			// if no serverspace can be loaded, create one
			ModelUtil.logInfo("Creating initial server space...");
			result = EsmodelFactory.eINSTANCE.createServerSpace();

			result.setResource(resource);
			resource.getContents().add(result);

			try {
				result.save();
			} catch (IOException e) {
				throw new FatalEmfStoreException(StorageException.NOSAVE, e);
			}
		}

		return result;
	}

	private void validateServerSpace(Resource resource) throws FatalEmfStoreException {
		EList<EObject> contents = resource.getContents();
		for (EObject object : contents) {
			if (object instanceof ServerSpace) {
				EmfStoreValidator emfStoreValidator = new EmfStoreValidator((ServerSpace) object);
				String[] excludedProjects = ServerConfiguration.getSplittedProperty(
					ServerConfiguration.VALIDATION_PROJECT_EXCLUDE,
					ServerConfiguration.VALIDATION_PROJECT_EXCLUDE_DEFAULT);
				emfStoreValidator.setExcludedProjects(Arrays.asList(excludedProjects));
				try {
					String level = ServerConfiguration.getProperties().getProperty(
						ServerConfiguration.VALIDATION_LEVEL, ServerConfiguration.VALIDATION_LEVEL_DEFAULT);
					emfStoreValidator.validate(Integer.parseInt(level));
				} catch (NumberFormatException e) {
					emfStoreValidator.validate(Integer.parseInt(ServerConfiguration.VALIDATION_LEVEL_DEFAULT));
				}
			}
		}
	}

	/**
	 * Return the singleton instance of EmfStoreControler.
	 * 
	 * @return the instance
	 */
	public static EmfStoreController getInstance() {
		return instance;
	}

	private ResourceStorage initStorage() throws FatalEmfStoreException {
		String className = properties.getProperty(ServerConfiguration.RESOURCE_STORAGE,
			ServerConfiguration.RESOURCE_STORAGE_DEFAULT);

		ResourceStorage resourceStorage;
		final String failMessage = "Failed loading ressource storage!";
		try {
			ModelUtil.logInfo("Using RessourceStorage \"" + className + "\".");
			resourceStorage = (ResourceStorage) Class.forName(className).getConstructor().newInstance();
			return resourceStorage;
		} catch (IllegalArgumentException e) {
			ModelUtil.logException(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (SecurityException e) {
			ModelUtil.logException(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (InstantiationException e) {
			ModelUtil.logException(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (IllegalAccessException e) {
			ModelUtil.logException(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (InvocationTargetException e) {
			ModelUtil.logException(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (NoSuchMethodException e) {
			ModelUtil.logException(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (ClassNotFoundException e) {
			ModelUtil.logException(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		}
	}

	private AccessControlImpl initAccessControl(ServerSpace serverSpace) throws FatalEmfStoreException {
		setSuperUser(serverSpace);
		return new AccessControlImpl(serverSpace);
	}

	private void setSuperUser(ServerSpace serverSpace) throws FatalEmfStoreException {
		String superuser = ServerConfiguration.getProperties().getProperty(ServerConfiguration.SUPER_USER,
			ServerConfiguration.SUPER_USER_DEFAULT);
		for (ACUser user : serverSpace.getUsers()) {
			if (user.getName().equals(superuser)) {
				return;
			}
		}
		ACUser superUser = AccesscontrolFactory.eINSTANCE.createACUser();
		superUser.setName(superuser);
		superUser.setFirstName("super");
		superUser.setLastName("user");
		superUser.setDescription("default server admin (superuser)");
		superUser.getRoles().add(RolesFactory.eINSTANCE.createServerAdmin());
		serverSpace.getUsers().add(superUser);
		try {
			serverSpace.save();
		} catch (IOException e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}
		ModelUtil.logInfo("added superuser " + superuser);
	}

	private Properties initProperties() {
		File propertyFile = new File(ServerConfiguration.getConfFile());
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propertyFile);
			properties.load(fis);
			ServerConfiguration.setProperties(properties);
			fis.close();
			ModelUtil.logInfo("Property file read. (" + propertyFile.getAbsolutePath() + ")");
		} catch (IOException e) {
			ModelUtil.logWarning("Property initialization failed, using default properties.", e);
		}
		return properties;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		wakeForTermination();
		for (ConnectionHandler<? extends EmfStoreInterface> handler : connectionHandlers) {
			handler.stop(false);
		}
		ModelUtil.logInfo("Server was stopped.");
		instance = null;
		wakeForTermination();
	}

	/**
	 * Shutdown EmfStore due to an fatal exception.
	 * 
	 * @param exception the fatal exception that triggered the shutdown
	 * @generated NOT
	 */
	public void shutdown(FatalEmfStoreException exception) {
		ModelUtil.logWarning("Stopping all connection handlers...");
		for (ConnectionHandler<? extends EmfStoreInterface> handler : connectionHandlers) {
			ModelUtil.logWarning("Stopping connection handler \"" + handler.getName() + "\".");
			handler.stop(true);
			ModelUtil.logWarning("Connection handler \"" + handler.getName() + "\" stopped.");
		}
		ModelUtil.logException("Server was forcefully stopped.", exception);
		ModelUtil.logException("Cause for server shutdown: ", exception.getCause());
		wakeForTermination();
	}

	private synchronized void waitForTermination() {
		try {
			wait();
		} catch (InterruptedException e) {
			ModelUtil.logWarning("Waiting for termination was interrupted", e);
		}
	}

	private synchronized void wakeForTermination() {
		notify();
	}

	private void serverHeader() {
		InputStream inputStream = getClass().getResourceAsStream("unicase.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
		}

		System.out.println("*------------------*");
		System.out.println("| unicase EmfStore |");
		System.out.println("*------------------*");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			run(false);
		} catch (FatalEmfStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * starts the server a new thread.
	 * 
	 * @throws FatalEmfStoreException in case of failure
	 */
	public static void runAsNewThread() throws FatalEmfStoreException {
		Thread thread = new Thread(new EmfStoreController());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
