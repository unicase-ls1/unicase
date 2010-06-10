package org.unicase.proxyclient.notifier.client;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

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
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.proxyclient.ProxyClient;
import org.unicase.proxyclient.notifier.email.MailerInfo;
import org.unicase.proxyclient.notifier.store.model.NPCFactory;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.connectionmanager.KeyStoreManager;

/**
 * @author Adrian Staudt <staudta@in.tum.de>
 */
public class NotifierProxyClientEntryPoint extends ProxyClient {
	
	public static final String DEFAULT_EXTENSION = "notifierStore";

	public void run() throws Exception {
		try {
			String workspaceDirectory = org.unicase.workspace.Configuration.getWorkspaceDirectory();
			String propertyFile = workspaceDirectory + "notifierProxyClient.ini";

			Ini ini = new Ini(new File(propertyFile));
			IniPreferences iniPreferences = new IniPreferences( ini );
	        for(String section: iniPreferences.childrenNames() ) {
	    		final String url = iniPreferences.node( section ).get("url", null);
	    		final int port = iniPreferences.node( section ).getInt("port", 0);
	    		final String certificate = iniPreferences.node( section ).get("certificate", null);
	    		final String username = iniPreferences.node( section ).get("username", null);
	    		final String password = iniPreferences.node( section ).get("password", null);
	    		final int backchannelPort = iniPreferences.node( section ).getInt("backchannelPort", 0);
	    		
	    		if( section.trim().equals("") )
	    			throw new NotificationProxyClientException("All sections must haven a name.");
	    		if( url == null || port == 0 || certificate == null || username == null || password == null || backchannelPort == 0 )
	    			throw new NotificationProxyClientException("Section '"+section+"' in ini file is incomplete.");
	    		
	    		// ServerInfo
	    		final ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
	    		serverInfo.setUrl( url );
	    		serverInfo.setPort( port );
	    		serverInfo.setCertificateAlias( KeyStoreManager.DEFAULT_DEV_CERTIFICATE );
	    		
	    		// Usersession
	    		final Usersession usersession = WorkspaceFactory.eINSTANCE.createUsersession();
	    		usersession.setServerInfo( serverInfo );
	    		usersession.setUsername( username );
	    		usersession.setPassword( password );
	    		
	    		// login
	    		try {
	    			usersession.logIn();
	    		} catch(AccessControlException e) {
	    			throw new NotificationProxyClientException( e.getMessage() );
	    		}
	    		
	    		// Backchannel ServerInfo
	    		final ServerInfo backChannelServerInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
	    		backChannelServerInfo.setUrl( url );
	    		backChannelServerInfo.setPort( backchannelPort );
	    		
	    		// Create ProxyClient per Repository
	    		{
	    			String npcRepositoryHomeLocation = workspaceDirectory + section + "." + DEFAULT_EXTENSION;
		    		
	    			// Create repository specific ProxyClient Notification gatherer
		    		NotifierProxyClientStore createNPCStore = createNPCStore(npcRepositoryHomeLocation);
					NotifierProxyClientRepository notifierProxyClientRepository = new NotifierProxyClientRepository(createNPCStore, usersession, backChannelServerInfo);
					Map<ProjectId, ProjectInfo> projectInfoMap = notifierProxyClientRepository.getProjectInfoMap();
					Map<ProjectId, ProjectSpace> projectSpaceMap = notifierProxyClientRepository.getProjectSpaceMap();
					
		    		// create repository specific ProxyClient time supervisor
		    		final String smtpHost = iniPreferences.node( section ).get("SMTPhost", null);
		    		final int smtpPort = iniPreferences.node( section ).getInt("SMTPport", 0);
		    		final String smtpUser = iniPreferences.node( section ).get("SMTPuser", null);
		    		final String smtpPassword = iniPreferences.node( section ).get("SMTPpassword", null);
		    		final boolean smtpUseSSL = iniPreferences.node( section ).getBoolean("SMTPuseSSL", false);
		    		final String smtpSender = iniPreferences.node( section ).get("SMTPsender", null);
					
		    		MailerInfo mailerInfo = new MailerInfo(smtpHost, smtpPort, smtpUser, smtpPassword, smtpUseSSL, smtpSender);
					new NotifierProxyClientRepositoryTimer(createNPCStore, projectInfoMap, projectSpaceMap, mailerInfo).run();
	    		}
	        }
		
		} catch(NotificationProxyClientException e) {
			System.err.println( e.getMessage() );
		}
	}
	
	private static NotifierProxyClientStore createNPCStore(String npcRepositoryHomeLocation) {
		IPath path = Path.fromOSString("file://" + npcRepositoryHomeLocation);
		IWorkspaceRoot rootWorkspace = ResourcesPlugin.getWorkspace().getRoot();
		IFile newFile = rootWorkspace.getFile(path);

		// Create a resource set
		ResourceSet resourceSet = new ResourceSetImpl();

		// register plugin extension to XMI serialization
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			NotifierProxyClientEntryPoint.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

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
			// store does not exist yet
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
			throw new NotificationProxyClientException(e.getMessage());
		}
	}

}
