package org.unicase.emfstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.rmi.RMITest;
import org.unicase.emfstore.storage.ResourceStorage;
import org.unicase.emfstore.storage.TeneoStorage;

public class StartEmfStore implements IApplication {

	private EmfStore emfStore;
	
	public Object start(IApplicationContext context) throws Exception {

		System.out.print("Initialization...");
		
		new RMITest();
		
		/**
		 * RMI now works with Strings. A new problem occurred while trying
		 * to send ME's.
		 */
		//new RMIClientTest();
		
		// keep the server running
		for(int i = 0; i < 10;i++) {
			System.out.print(".");
			Thread.sleep(1000);
		}
		
//		Properties properties = initProperties();
//		ResourceStorage storage = initStorage(properties);
//		emfStore = new EmfStore(storage, properties);
//		Thread serverThread = new Thread(emfStore);
//			
//		System.out.println("COMPLETE");
//		
//		serverThread.start();
//		
//		System.out.println("Server is running...");
//		
//		serverThread.join();
		return IApplication.EXIT_OK;
	}

	private ResourceStorage initStorage(Properties properties) {
		String className = properties.getProperty(ServerConfiguration.RESOURCE_STORAGE);
		if (className==null) {
			return new TeneoStorage();
		}
		ResourceStorage resourceStorage;
		try {
			resourceStorage = (ResourceStorage)Class.forName(className).getConstructor().newInstance();
			return resourceStorage;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		throw new RuntimeException();
	}

	private Properties initProperties() {
		File propertyFile = new File(ServerConfiguration.getConfFile());
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propertyFile);
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties;
	}

	public void stop() {
		emfStore.stop();
		emfStore=null;
		System.out.println("Server was stopped.");
	}

}
