/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.emfstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.accesscontrol.AccessControlImpl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIAdminConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIConnectionHandler;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.VersionInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesFactory;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.StorageException;
import org.unicase.emfstore.storage.ResourceStorage;
import org.unicase.emfstore.taskmanager.TaskManager;
import org.unicase.emfstore.taskmanager.tasks.CleanMemoryTask;
import org.unicase.emfstore.update.UpdateController;

/**
 * The {@link EmfStoreController} is controlling startup and shutdown of the EmfStore.
 * 
 * @author koegel
 * @author wesendonk
 */
public class EmfStoreController implements IApplication {

	private EmfStore emfStore;
	private AdminEmfStore adminEmfStore;
	private AccessControlImpl accessControl;
	private Set<ConnectionHandler<? extends EmfStoreInterface>> connectionHandlers;
	private Properties properties;
	private static Log logger;
	private ServerSpace serverSpace;
	private Resource resource;

	private static EmfStoreController instance;
	private VersionInfo versionInfo;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws EmfStoreException, FatalEmfStoreException {

		if (instance != null) {
			throw new FatalEmfStoreException("Another EmfStore Controller seems to be ruinning already!");
		}
		instance = this;

		System.out.println("*------------------*");
		System.out.println("| unicase EmfStore |");
		System.out.println("*------------------*");

		initLogging();

		properties = initProperties();
		this.serverSpace = initServerSpace();
		versionInfo = initVersionInfo();

		performNecessaryUpdates();

		accessControl = initAccessControl(serverSpace);
		emfStore = new EmfStoreImpl(serverSpace, accessControl);
		adminEmfStore = new AdminEmfStoreImpl(serverSpace, accessControl);

		connectionHandlers = initConnectionHandlers();

		TaskManager taskManager = TaskManager.getInstance();
		taskManager.addTask(new CleanMemoryTask(emfStore));
		taskManager.start();

		logger.info("Initialitation COMPLETE.");
		logger.info("Server is RUNNING...");

		waitForTermination();

		instance = null;
		logger.info("Server is STOPPED.");
		return IApplication.EXIT_OK;
	}

	private Set<ConnectionHandler<? extends EmfStoreInterface>> initConnectionHandlers() throws FatalEmfStoreException,
		EmfStoreException {
		Set<ConnectionHandler<? extends EmfStoreInterface>> connectionHandlers = new HashSet<ConnectionHandler<? extends EmfStoreInterface>>();

		// create RMI connection handler for emfstore
		RMIConnectionHandler rmiConnectionHandler = new RMIConnectionHandler();
		rmiConnectionHandler.init(emfStore, accessControl);
		connectionHandlers.add(rmiConnectionHandler);

		// create RMI connection handler for admin emfstore
		RMIAdminConnectionHandler rmiAdminConnectionHandler = new RMIAdminConnectionHandler();
		rmiAdminConnectionHandler.init(adminEmfStore, accessControl);
		connectionHandlers.add(rmiAdminConnectionHandler);

		return connectionHandlers;
	}

	private void performNecessaryUpdates() throws FatalEmfStoreException {
		int compareTo = versionInfo.getEmfStoreVersion().compareTo(EmfStoreImpl.getModelVersion());
		if (compareTo < 0) {
			System.out
				.println("Your model is not up to date. Do you want to update now and did you backup your emfstore folder? (y/n)");

			byte[] buffer = new byte[1];
			String input = "";
			int read = 0;

			try {
				read = System.in.read(buffer, 0, 1);
			} catch (IOException e) {
				throw new FatalEmfStoreException("Cannot read from input", e);
			}

			input = new String(buffer, 0, read);
			if (input.equalsIgnoreCase("y")) {
				UpdateController updateController = new UpdateController();
				updateController.updateServerSpace(serverSpace, versionInfo);
			} else {
				String message = "Server shutting down, model update is mandatory.";
				System.out.println(message);
				throw new FatalEmfStoreException(message);
			}
		}
	}

	private VersionInfo initVersionInfo() throws FatalEmfStoreException {
		VersionInfo versionInformation = null;
		for (EObject content : resource.getContents()) {
			if (content instanceof VersionInfo) {
				versionInformation = (VersionInfo) content;
				break;
			}
		}

		// only happens after initial creation of serverspace
		if (versionInformation == null) {
			versionInformation = EsmodelFactory.eINSTANCE.createVersionInfo();
			versionInformation.setEmfStoreVersionString(EmfStoreImpl.getModelVersion().toString());
			resource.getContents().add(versionInformation);

			try {
				serverSpace.save();
			} catch (IOException e) {
				throw new FatalEmfStoreException(StorageException.NOSAVE, e);
			}
		}

		return versionInformation;
	}

	private ServerSpace initServerSpace() throws FatalEmfStoreException {
		ResourceStorage storage = initStorage();
		URI resourceUri = storage.init(properties);
		ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.getResource(resourceUri, true);
		try {
			resource.load(resourceSet.getLoadOptions());

			if (properties.getProperty(ServerConfiguration.VALIDATE_SERVERSPACE_ON_SERVERSTART, "true").equals("true")) {
				logger.info("Validating serverspace ...");
				validateServerSpace(resource);
				logger.info("Validation complete.");
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
			logger.debug("Creating initial server space...");
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
				EList<ProjectHistory> projects = ((ServerSpace) object).getProjects();
				for (ProjectHistory projectHistory : projects) {
					EList<Version> versions = projectHistory.getVersions();
					for (Version version : versions) {
						TreeIterator<EObject> allContents = version.eResource().getAllContents();
						while (allContents.hasNext()) {
							allContents.next();

						}
					}
				}
			}
		}

		EList<Diagnostic> errors = new BasicEList<Diagnostic>();
		EList<Resource> resources = resource.getResourceSet().getResources();
		for (Resource currentResource : resources) {
			errors.addAll(currentResource.getErrors());
		}

		if (errors.size() > 0) {
			throw new FatalEmfStoreException(StorageException.NOLOAD + " : " + errors.get(0).getMessage());
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

	private void initLogging() {
		logger = LogFactory.getLog(EmfStoreController.class);

		// OW: fix logging config
		// ConsoleAppender console = new ConsoleAppender(new SimpleLayout());
		// try {
		// FileAppender fileLog = new FileAppender(new SimpleLayout(),
		// ServerConfiguration.getServerHome() + "emfstore.log", true);
		// Logger rootLogger = Logger.getRootLogger();
		// rootLogger.addAppender(console);
		// rootLogger.addAppender(fileLog);
		// rootLogger.setLevel(Level.ALL);
		// } catch (IOException e) {
		// String message =
		// "Logging initialization failed! Logging might be disabled!";
		// logger.warn(message, e);
		// }
	}

	private ResourceStorage initStorage() throws FatalEmfStoreException {
		String className = properties.getProperty(ServerConfiguration.RESOURCE_STORAGE,
			ServerConfiguration.RESOURCE_STORAGE_DEFAULT);

		ResourceStorage resourceStorage;
		final String failMessage = "Failed loading ressource storage!";
		try {
			logger.debug("Using RessourceStorage \"" + className + "\".");
			resourceStorage = (ResourceStorage) Class.forName(className).getConstructor().newInstance();
			return resourceStorage;
		} catch (IllegalArgumentException e) {
			logger.fatal(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (SecurityException e) {
			logger.fatal(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (InstantiationException e) {
			logger.fatal(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (IllegalAccessException e) {
			logger.fatal(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (InvocationTargetException e) {
			logger.fatal(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (NoSuchMethodException e) {
			logger.fatal(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		} catch (ClassNotFoundException e) {
			logger.fatal(failMessage, e);
			throw new FatalEmfStoreException(failMessage, e);
		}
	}

	private AccessControlImpl initAccessControl(ServerSpace serverSpace) throws EmfStoreException,
		FatalEmfStoreException {
		setSuperUser(serverSpace);
		return new AccessControlImpl(serverSpace);
	}

	private void setSuperUser(ServerSpace serverSpace) throws StorageException {
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
			throw new StorageException(StorageException.NOSAVE, e);
		}
		logger.info("added superuser " + superuser);
	}

	private Properties initProperties() {
		File propertyFile = new File(ServerConfiguration.getConfFile());
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propertyFile);
			properties.load(fis);
			ServerConfiguration.setProperties(properties);
			fis.close();
			logger.info("Property file read.");
		} catch (IOException e) {
			logger.warn("Property initialization failed, using default properties.");
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
		logger.info("Server was stopped.");
		wakeForTermination();
	}

	/**
	 * Shutdown EmfStore due to an fatal exception.
	 * 
	 * @param exception the fatal exception that triggered the shutdown
	 * @generated NOT
	 */
	public void shutdown(FatalEmfStoreException exception) {
		logger.debug("Stopping all connection handlers...");
		for (ConnectionHandler<? extends EmfStoreInterface> handler : connectionHandlers) {
			logger.debug("Stopping connection handler \"" + handler.getName() + "\".");
			handler.stop(true);
			logger.debug("Connection handler \"" + handler.getName() + "\" stopped.");
		}
		logger.fatal("Server was forcefully stopped.", exception);
		logger.fatal("Cause: ", exception.getCause());
		wakeForTermination();
	}

	private synchronized void waitForTermination() {
		try {
			wait();
		} catch (InterruptedException e) {
			logger.warn("Waiting for termination was interrupted", e);
		}
	}

	private synchronized void wakeForTermination() {
		notify();
	}

}
