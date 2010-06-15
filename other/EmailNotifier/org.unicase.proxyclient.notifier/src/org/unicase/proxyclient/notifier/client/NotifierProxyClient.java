/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.prefs.BackingStoreException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.InvalidFileFormatException;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.proxyclient.notifier.email.MailerInfo;
import org.unicase.proxyclient.notifier.store.model.NPCFactory;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;

/**
 * Backend entry point for the Notification Proxy Client.
 * 
 * @author staudta
 */
public class NotifierProxyClient {
	
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
	private static final String NOTIFIER_CONFIG_FILE = "notifierProxyClient.ini";
	
	/**
	 * The path where the configuration file for the notification proxy client will be found.
	 */
	public static final String NOTIFIER_CONFIG_PATH = NOTIFIER_FOLDER_PATH + NOTIFIER_CONFIG_FILE;
	
	/**
	 * A list of all available configuration sections from the ini file.
	 */
	private List<NotifierProxyClientConfigSectionInfo> configSectionInfos = new ArrayList<NotifierProxyClientConfigSectionInfo>();
	
	/**
	 * Constructor.
	 * 
	 * @throws NotificationProxyClientException will be thrown on configuration error. Review your ini file.
	 */
	public NotifierProxyClient() throws NotificationProxyClientException {
		// does file exist?
		File configFile = new File( NOTIFIER_CONFIG_PATH );
		if( !configFile.exists() ) {
			throw new NotificationProxyClientException("Configuration file not found. Expected location: '"+NOTIFIER_CONFIG_PATH+"'.");
		}
		
		// are all mandatory iniPreferences set?
		try {
			Ini ini = new Ini( configFile );
			IniPreferences iniPreferences = new IniPreferences(ini);
			for (String section : iniPreferences.childrenNames()) {
				// EMF store server properties
				final String url = iniPreferences.node(section).get("url", null);
				final int port = iniPreferences.node(section).getInt("port", 0);
				final String certificate = iniPreferences.node(section).get("certificate", null);
				final String username = iniPreferences.node(section).get("username", null);
				final String password = iniPreferences.node(section).get("password", null);
				final int backchannelPort = iniPreferences.node(section).getInt("backchannelPort", 0);
				
				// mailer properties
	    		final String smtpHost = iniPreferences.node( section ).get("SMTPhost", null);
	    		final int smtpPort = iniPreferences.node( section ).getInt("SMTPport", 0);
	    		final String smtpUser = iniPreferences.node( section ).get("SMTPuser", null);
	    		final String smtpPassword = iniPreferences.node( section ).get("SMTPpassword", null);
	    		final boolean smtpUseSSL = iniPreferences.node( section ).getBoolean("SMTPuseSSL", false);
	    		final String smtpSender = iniPreferences.node( section ).get("SMTPsender", null);
				
	    		// server info
	    		final ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
				serverInfo.setUrl( url );
				serverInfo.setPort( port );
				serverInfo.setCertificateAlias( certificate );
				
				// mailer info
				final MailerInfo mailerInfo = new MailerInfo(smtpHost, smtpPort, smtpUser, smtpPassword, smtpUseSSL, smtpSender);
				
				// validation of this section
				NotifierProxyClientConfigSectionInfo configSectionInfo = new NotifierProxyClientConfigSectionInfo(section, serverInfo, username, password, backchannelPort, mailerInfo);
				
				configSectionInfos.add(configSectionInfo);
			}
			 
		} catch (InvalidFileFormatException e) {
			throw new NotificationProxyClientException( "Ini file is not well formatted.", e );
		} catch (IOException e) {
			throw new NotificationProxyClientException( "IOException, something is wrong with the ini file.", e );
		} catch (BackingStoreException e) {
			throw new NotificationProxyClientException( "Problem with the EMF store.", e );
		}
		
	}
	
	/**
	 * For each configuration section will be a connection to this emf store established.
	 * For each project inside of this emf store is a backchannel initialized (for new notifications) and 
	 * an additional thread, that will check if notifications should be sended.
	 * @throws NotificationProxyClientException 
	 */
	public void run() throws NotificationProxyClientException {
		for(NotifierProxyClientConfigSectionInfo configSection: configSectionInfos) {
			final Usersession usersession = configSection.getUsersession();
    		final ServerInfo backchannelServerInfo = configSection.getBackchannelServerInfo();
			
    		// Create ProxyClient per Repository
			String npcRepositoryLocation = NOTIFIER_FOLDER_PATH + configSection.getSectionName() + "." + EXTENSION;
    		
			// Create repository specific ProxyClient Notification gatherer
    		NotifierProxyClientStore createNPCStore = createNPCStore(npcRepositoryLocation);
    		NotifierProxyClientRepository notifierProxyClientRepository = new NotifierProxyClientRepository(createNPCStore, usersession, backchannelServerInfo);
			Thread notifierProxyClientRepositoryThread = new Thread(notifierProxyClientRepository, "notifierProxyClientRepositoryThread");
    		notifierProxyClientRepositoryThread.start();
			
    		// wait until map is set
    		Map<ProjectId, ProjectSpace> projectSpaceMap = null;
    		do {
				projectSpaceMap = notifierProxyClientRepository.getProjectSpaceMap();
				
    		} while(projectSpaceMap == null);
    		
    		// create repository specific ProxyClient time supervisor
    		NotifierProxyClientRepositoryTimer notifierProxyClientRepositoryTimer = new NotifierProxyClientRepositoryTimer(createNPCStore, projectSpaceMap, configSection.getMailerInfo());
			Thread notifierProxyClientRepositoryTimerThread = new Thread(notifierProxyClientRepositoryTimer, "notifierProxyClientRepositoryTimerThread");
			notifierProxyClientRepositoryTimerThread.start();
		}
	}
	
	/**
	 * An empty Notifier Proxy Client store will be created.
	 * 
	 * @param npcRepositoryHomeLocation location of the new NPC store 
	 * @return NPC store
	 * @throws NotificationProxyClientException 
	 */
	private static NotifierProxyClientStore createNPCStore(String npcRepositoryHomeLocation) throws NotificationProxyClientException {
		IPath path = Path.fromOSString("file://" + npcRepositoryHomeLocation);
		IWorkspaceRoot rootWorkspace = ResourcesPlugin.getWorkspace().getRoot();
		IFile newFile = rootWorkspace.getFile(path);

		// Create a resource set
		ResourceSet resourceSet = new ResourceSetImpl();

		// register plugin extension to XMI serialization
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			NotifierProxyClient.EXTENSION, new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(newFile.getFullPath().toOSString());

		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);

		// try to load from file if content exists
		NotifierProxyClientStore notifierProxyClientStore = null;
		try {
			resource.load(Collections.EMPTY_MAP);
			if (resource.getContents().size() > 0) {
				EObject eObject = resource.getContents().get(0);
				if (eObject instanceof NotifierProxyClientStore) {
					notifierProxyClientStore = (NotifierProxyClientStore) eObject;
				}
			}
		} catch (IOException e) {
			// store does not exist yet, can be ignored. Will be created in the next step.
		}

		try {
			// create new NPC-Store
			if (notifierProxyClientStore == null) {
				// Add the initial model object to the contents.
				notifierProxyClientStore = NPCFactory.eINSTANCE.createNotifierProxyClientStore();
				resource.getContents().add(notifierProxyClientStore);

				resource.save(Collections.EMPTY_MAP);
			}
			return notifierProxyClientStore;

		} catch (IOException e) {
			throw new NotificationProxyClientException("IOException on creating a new Notifier Proxy Client store.", e);
		}
	}

}
