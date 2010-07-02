/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.client;

import org.unicase.emfstore.emailnotifier.email.MailerInfo;
import org.unicase.emfstore.emailnotifier.exception.EMailNotifierException;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;

/**
 * NPC ConfigSectionInfo will check if a configuration section of the ini file is valid.
 * It will be checked if a connection could be established to the emf store and if the login is valid.
 * It will be also checked if all necessary values are set.
 * 
 * @author staudta
 */
public class EMFStoreInfo {

	private final String sectionName;
	private final int backchannelPort;
	private final ServerInfo serverInfo;
	private final MailerInfo mailerInfo;

	private Usersession usersession;
	private ServerInfo backchannelServerInfo;
		
	/**
	 * Constructor.
	 * 
	 * @param sectionName section name
	 * @param serverInfo server info carries information for the EMF store location
	 * @param username user name to login to the EMF store
	 * @param password password for the user name
	 * @param backchannelPort port for the backchannel
	 * @param mailerInfo mailer info
	 * @throws EMailNotifierException will be thrown on misconfigured ini section
	 */
	public EMFStoreInfo(String sectionName, ServerInfo serverInfo, String username, String password, int backchannelPort, MailerInfo mailerInfo) throws EMailNotifierException {
		this.sectionName = sectionName;
		this.serverInfo = serverInfo;
		this.backchannelPort = backchannelPort;
		this.mailerInfo = mailerInfo;
		
		// try to login - validation of login data
		try {
			usersession = WorkspaceFactory.eINSTANCE.createUsersession();
			usersession.setServerInfo( serverInfo );
    		usersession.setUsername( username );
    		usersession.setPassword( password );
    		usersession.logIn();
    		
		} catch(AccessControlException e) {
			throw new EMailNotifierException( e.getMessage() );
		
		} catch (EmfStoreException e) {
			throw new EMailNotifierException( e.getMessage() );
		}
		
	}
	
	/**
	 * Get ini section name.
	 * 
	 * @return section name
	 */
	public String getSectionName() {
		return sectionName;
	}
	
	/**
	 * Get the usersession. A login will be established to check credentials. This login usersession will returned.
	 * 
	 * @return usersession
	 */
	public Usersession getUsersession() {
		return usersession;
	}
	
	/**
	 * Get backchannel server info.
	 * 
	 * @return backchannel server info
	 */
	public ServerInfo getBackchannelServerInfo() {
		if( backchannelServerInfo == null ) {
			backchannelServerInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
			backchannelServerInfo.setUrl( serverInfo.getUrl() );
			backchannelServerInfo.setPort( backchannelPort );
		}
		
		return backchannelServerInfo;
	}
	
	/**
	 * Get mailer info for current ini section.
	 * 
	 * @return mailer info
	 */
	public MailerInfo getMailerInfo() {
		return mailerInfo;
	}

}
