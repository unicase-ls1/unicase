package org.unicase.emfstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.accesscontrol.AccessControlImpl;
import org.unicase.emfstore.connection.rmi.RMIConnectionHandler;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.storage.ResourceStorage;

public class StartEmfStore implements IApplication {

	private EmfStoreImpl emfStore;
	private Logger logger;

	public Object start(IApplicationContext context) throws Exception {

		System.out.println("unicase EmfStore");
		
		Properties properties = initProperties();
		
		initLogging(properties);
		logger = Logger.getLogger(this.getClass());
				
		ResourceStorage storage = initStorage(properties);
		emfStore = new EmfStoreImpl(storage, properties);

		new RMIConnectionHandler().init(emfStore, new AccessControlImpl());

		Thread serverThread = new Thread(emfStore);

		logger.info("Initialitation COMPLETE.");

		serverThread.start();

		logger.info("Server is RUNNING...");

		serverThread.join();
		return IApplication.EXIT_OK;
	}

	private void initLogging(Properties properties) {
		ConsoleAppender console = new ConsoleAppender(new SimpleLayout());
		try {
			FileAppender fileLog = new FileAppender(new SimpleLayout(),
					ServerConfiguration.getServerHome() + "emfstore.log", true);
			Logger rootLogger = Logger.getRootLogger();
			rootLogger.addAppender(console);
			rootLogger.addAppender(fileLog);
			rootLogger.setLevel(Level.ALL);
		} catch (IOException e) {
			String message = "Logging initialization failed! Logging might be disabled!";
			logger.warn(message, e);
		}
	}

	private ResourceStorage initStorage(Properties properties) throws FatalEmfStoreException {
		String className = properties.getProperty(
				ServerConfiguration.RESOURCE_STORAGE,
				ServerConfiguration.DEFAULT_RESOURCE_STORAGE);

		ResourceStorage resourceStorage;
		final String failMessage = "Failed loading ressource storage!";
		try {
			logger.debug("Using RessourceStorage \"" + className + "\".");
			resourceStorage = (ResourceStorage) Class.forName(className)
					.getConstructor().newInstance();
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

	private Properties initProperties() {
		File propertyFile = new File(ServerConfiguration.getConfFile());
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propertyFile);
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			System.out.println("Property initialization failed: " + e.toString());
		}
		return properties;
	}

	public void stop() {
		emfStore.stop();
		emfStore = null;
		System.out.println("Server was stopped.");
	}

}
