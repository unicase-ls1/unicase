/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.Bundle;
import org.unicase.emfstore.emailnotifier.Activator;
import org.unicase.emfstore.emailnotifier.email.MailerInfo;
import org.unicase.emfstore.emailnotifier.exception.EMailNotifierException;
import org.unicase.emfstore.emailnotifier.store.EMailNotifierStore;
import org.unicase.emfstore.emailnotifier.store.ENSFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;

/**
 * Backend entry point for the Notification Proxy Client.
 * 
 * @author staudta
 */
public class EMailNotifier implements IApplication {
	
	/**
	 * The default extension for a notification proxy client store.
	 */
	public static final String EXTENSION = "notifierStore";
	
	/**
	 * The Unicase folder, where the projects and templates are stored.
	 */
	private static final String UNICASE_FOLDER = Configuration.getWorkspaceDirectory();
	
	/**
	 * The folder within the Unicase folder, where the notifier proxy client files are stored.
	 */
	private static final String NOTIFIER_FOLDER = "notifier";
	
	/**
	 * The path where all notification proxy client related files should be saved.
	 */
	public static final String NOTIFIER_FOLDER_PATH = UNICASE_FOLDER + NOTIFIER_FOLDER + File.separatorChar;
	
	/**
	 * The file name of the configuration file for the notifier proxy client.
	 */
	private static final String NOTIFIER_CONFIG_FILE = "emailNotifier.properties";
	
	/**
	 * The path where the configuration file for the notification proxy client will be found.
	 */
	public static final String NOTIFIER_CONFIG_PATH = NOTIFIER_FOLDER_PATH + NOTIFIER_CONFIG_FILE;
	
	/**
	 * A list of all available configuration sections from the ini file.
	 */
	private List<EMFStoreInfo> emfStoreInfos = new ArrayList<EMFStoreInfo>();
	
	/**
	 * The path to the sample ini file. This file will be created if no ini is found.
	 */
	private static final String SAMPLE_CONFIG_FILE_PATH = "emailNotifier.example.properties";
	
	/**
	 * Constructor.
	 */
	public EMailNotifier() {
		try {
			// does config file exist?
			File configFile = new File( NOTIFIER_CONFIG_PATH );
			if( !configFile.exists() ) {
				createConfigFile(configFile);
			}
			
			Properties propertyFile = new Properties();
			InputStream inStream = new FileInputStream(configFile);
			propertyFile.load(inStream);
			String allSections = propertyFile.getProperty("sections");
			if( allSections == null ) {
				throw new EMailNotifierException(NOTIFIER_CONFIG_FILE+ " has an invalid file format.");
			}
			
			String[] sections = allSections.split(",");
			for(String section: sections) {
				section = section.trim();
				
				// if section is empty or contains whitespace it is invalid
				if( section.length() == 0 || section.matches(".+\\s.+") ) {
					throw new EMailNotifierException("Section '"+ section +"' is invalid.");
				}
				
				// EMF store server properties
				String url = propertyFile.getProperty(section+".url");
				int port;
				try {
					String portString = propertyFile.getProperty(section+".port");
					port = Integer.valueOf(portString);
				} catch(NumberFormatException e) {
					port = 0;
				}
				
				String certificate = propertyFile.getProperty(section+".certificate");
				String username = propertyFile.getProperty(section+".username");
				String password = propertyFile.getProperty(section+".password");
				int backchannelPort;
				try {
					String backchannelPortString = propertyFile.getProperty(section+".backchannelPort");
					backchannelPort = Integer.valueOf(backchannelPortString);
				} catch(NumberFormatException e) {
					backchannelPort = 0;
				}
				
				// mailer properties
	    		String smtpHost = propertyFile.getProperty(section+".SMTPhost");
	    		int smtpPort;
	    		try {
	    			String smtpPortString = propertyFile.getProperty(section+".SMTPport");
	    			smtpPort = Integer.valueOf(smtpPortString);
	    		} catch(NumberFormatException e) {
	    			smtpPort = 0;
	    		}
	    		String smtpUser = propertyFile.getProperty(section+".SMTPuser");
	    		String smtpPassword = propertyFile.getProperty(section+".SMTPpassword");
	    		boolean smtpUseSSL = Boolean.valueOf( propertyFile.getProperty(section+".SMTPuseSSL") );
	    		String smtpSender = propertyFile.getProperty(section+".SMTPsender");
				
	    		// server info
	    		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
				serverInfo.setUrl( url );
				serverInfo.setPort( port );
				serverInfo.setCertificateAlias( certificate );
				
				// mailer info
				MailerInfo mailerInfo = new MailerInfo(smtpHost, smtpPort, smtpUser, smtpPassword, smtpUseSSL, smtpSender);
				
				// validation of this section
				EMFStoreInfo emfStoreInfo = new EMFStoreInfo(section, serverInfo, username, password, backchannelPort, mailerInfo);
				
				emfStoreInfos.add(emfStoreInfo);
			}
			
		} catch(EMailNotifierException e) {
			// log message and terminate - serious error occurred
			Activator.log(IStatus.ERROR, e.getMessage());
			System.exit(1);
			
		} catch (FileNotFoundException e) {
			// log exception and terminate - serious error occurred
			Activator.logException(e);
			System.exit(1);
			
		} catch (IOException e) {
			// log exception and terminate - serious error occurred
			Activator.logException(e);
			System.exit(1);
		}
		
	}
	
	private void createConfigFile(File configFile) throws EMailNotifierException {
		Activator.log(IStatus.INFO, "Used config file: "+ configFile.toString());
		
		// ini file doesn't exist. Create a dummy file.
		try {
			if( !configFile.getParentFile().exists() ) {
				if(  !configFile.getParentFile().mkdirs() ) {
					throw new EMailNotifierException("Sample configuration file could be created. Expected location: '"+NOTIFIER_CONFIG_PATH+"'.");
				}
			}
			
			if( !configFile.createNewFile() ) {
				throw new EMailNotifierException("Sample configuration file could be created. Expected location: '"+NOTIFIER_CONFIG_PATH+"'.");
			}
			
			Activator.log(IStatus.ERROR, "Configuration file does not exist. (Path: "+ configFile +")");
			
			// copy notifierProxyClient.example.ini to destination
			Bundle bundle = Activator.getDefault().getBundle();
			URL url = bundle.getEntry( SAMPLE_CONFIG_FILE_PATH );
			InputStream sampleFileInputStream = url.openStream();
			
			String content = "";
			String line = null;
			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(sampleFileInputStream) );
			while( (line = bufferedReader.readLine()) != null ) {
				content += line + "\r\n";
			}
			bufferedReader.close();
			sampleFileInputStream.close();
			
			BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(configFile) );
			bufferedWriter.write(content);
			bufferedWriter.flush();
			bufferedWriter.close();
			
			Activator.log(IStatus.INFO, "Example configuration file created.");
			
		} catch (IOException e) {
			Activator.logException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) {
		try {
			entryPoint();
		
		} catch (EMailNotifierException e) {
			Activator.logException(e);
		}
		return IApplication.EXIT_OK;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
	
	/**
	 * For each configuration section will be a connection to this emf store established.
	 * For each project inside of this emf store is a backchannel initialized (for new notifications) and 
	 * an additional thread, that will check if notifications should be sent.
	 * @throws EMailNotifierException a wrapper for email notifier related exceptions
	 */
	public void entryPoint() throws EMailNotifierException {
		try {
			for(EMFStoreInfo configSection: emfStoreInfos) {
				final Usersession usersession = configSection.getUsersession();
	    		final ServerInfo backchannelServerInfo = configSection.getBackchannelServerInfo();
				
	    		// Create ProxyClient per Repository
				String npcRepositoryLocation = NOTIFIER_FOLDER_PATH + configSection.getSectionName() + "." + EXTENSION;
				EMailNotifierStore emailNotifierStore = createNPCStore(npcRepositoryLocation);
	    		
				// create repository specific ProxyClient time supervisor
	    		EMailNotifierRepositoryTimer notifierProxyClientRepositoryTimer = new EMailNotifierRepositoryTimer(emailNotifierStore, usersession, configSection.getMailerInfo());
	    		Thread notifierProxyClientRepositoryTimerThread = new Thread(notifierProxyClientRepositoryTimer, "notifierProxyClientRepositoryTimerThread");
	    					
	    		// Create repository specific ProxyClient Notification gatherer
				EMailNotifierRepositoryListener notifierProxyClientRepositoryListener = new EMailNotifierRepositoryListener(emailNotifierStore, usersession, backchannelServerInfo, configSection.getMailerInfo(), notifierProxyClientRepositoryTimerThread);
	    		notifierProxyClientRepositoryListener.createBackchannels();
	
				// start notifierProxyClientRepositoryTimerThread after EMailNotifierRepositoryListener, otherwise the WorkspaceManger will not be 
	    		// initialized correctly. The projects will be checked out first, than the WorkspaceManger can return
	    		// WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces()
	    		// with set usersession in a ProjectSpace object.
	    		notifierProxyClientRepositoryTimerThread.start();
			}
			
			Activator.log(IStatus.INFO, "E-Mail Notifier is running...");
			
			// Main Application must not terminate
			synchronized(Thread.currentThread()) {
				try {
					Thread.currentThread().wait();
				
				} catch (InterruptedException e) {
					Activator.logException(e);
				}
			}
			
		} catch(EmfStoreException e) {
			Activator.log(IStatus.ERROR, "Backchannel is not accessible.");
			Activator.logException(e);
		}
	}
	
	/**
	 * An empty Notifier Proxy Client store will be created.
	 * 
	 * @param npcRepositoryHomeLocation location of the new NPC store 
	 * @return NPC store
	 * @throws EMailNotifierException 
	 */
	private static EMailNotifierStore createNPCStore(String npcRepositoryHomeLocation) throws EMailNotifierException {
		// Create a resource set
		ResourceSet resourceSet = new ResourceSetImpl();

		// register plugin extension to XMI serialization
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			EMailNotifier.EXTENSION, new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(npcRepositoryHomeLocation);

		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);
		
		// try to load from file if content exists
		EMailNotifierStore notifierProxyClientStore = null;
		try {
			resource.load(Collections.EMPTY_MAP);
			if (resource.getContents().size() > 0) {
				EObject eObject = resource.getContents().get(0);
				if (eObject instanceof EMailNotifierStore) {
					notifierProxyClientStore = (EMailNotifierStore) eObject;
				} else {
					throw new EMailNotifierException("EMailNotifierStore seams to be broken.");
				}
			}
		} catch (IOException e) {
			// store does not exist yet, can be ignored. Will be created in the next step.
		}

		try {
			// create new NPC-Store
			if (notifierProxyClientStore == null) {
				// Add the initial model object to the contents.
				notifierProxyClientStore = ENSFactory.eINSTANCE.createEMailNotifierStore();
				resource.getContents().add(notifierProxyClientStore);

				resource.save(Collections.EMPTY_MAP);
			}
			return notifierProxyClientStore;

		} catch (IOException e) {
			throw new EMailNotifierException("IOException on creating a new Notifier Proxy Client store.", e);
		}
	}

}
