/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.client;

import java.util.List;

import org.eclipse.core.runtime.Status;
import org.unicase.backchannel.client.BackchannelConnectionManager;
import org.unicase.emfstore.emailnotifier.Activator;
import org.unicase.emfstore.emailnotifier.client.util.Helper;
import org.unicase.emfstore.emailnotifier.email.MailerInfo;
import org.unicase.emfstore.emailnotifier.exception.EMailNotifierException;
import org.unicase.emfstore.emailnotifier.exception.ProjectNotFoundException;
import org.unicase.emfstore.emailnotifier.store.EMailNotifierStore;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;

/**
 * This class is responsible for a dedicated EMF store. Each of these repositories contains several projects.
 * Fore each project is a backchannel registrated.
 * 
 * @author staudta
 */
public class EMailNotifierRepositoryListener {

	private final EMailNotifierStore emailNotifierStore;
	private final Usersession usersession;
	private final ServerInfo backchannelServerInfo;
	private final MailerInfo mailerInfo;
	private final Thread notifierProxyClientRepositoryTimerThread;
	
	/**
	 * Constructor.
	 * 
	 * @param emailNotifierStore email notifier store
	 * @param usersession current user session
	 * @param backchannelServerInfo server info for the backchannel
	 * @param mailerInfo mailer info, is needed for "immediately" sending
	 * @param notifierProxyClientRepositoryTimerThread the thread that observes a certain repository
	 * @throws EMailNotifierException an unexpected exception
	 */
	public EMailNotifierRepositoryListener(final EMailNotifierStore emailNotifierStore, final Usersession usersession, final ServerInfo backchannelServerInfo, final MailerInfo mailerInfo, Thread notifierProxyClientRepositoryTimerThread) throws EMailNotifierException {
		this.emailNotifierStore = emailNotifierStore;
		this.usersession = usersession;
		this.backchannelServerInfo = backchannelServerInfo;
		this.mailerInfo = mailerInfo;
		this.notifierProxyClientRepositoryTimerThread = notifierProxyClientRepositoryTimerThread;
		
		// check if all remote project are also locally available
		try {
			// get all remote projects
			List<ProjectInfo> remoteProjectInfoList = usersession.getRemoteProjectList();
			for (ProjectInfo remoteProject: remoteProjectInfoList) {
				try {
					Helper.getLocalProject(usersession, remoteProject.getProjectId() );
				
				} catch(ProjectNotFoundException e) {
					Helper.checkout(usersession, remoteProject);
				}
			}


		} catch (EmfStoreException e) {
			throw new EMailNotifierException("EMF Store Exception during getting project information.", e);
		}
	}
	
	/**
	 * Adds a backchannel to each project to be able to listen to server events.
	 * @throws EmfStoreException will be throw if the backchannel is not accessible
	 */
	public void createBackchannels() throws EmfStoreException {
		// backchannel handling
		BackchannelConnectionManager manager = new BackchannelConnectionManager();
		manager.initConnection(backchannelServerInfo, usersession.getSessionId());

		// register backchannel listener
		EMFStoreEventListener listener = new EMailNotifierProjectListener(emailNotifierStore, usersession, mailerInfo, notifierProxyClientRepositoryTimerThread);
		
		// backchannel registration for all projects
		for (ProjectInfo projectInfo: usersession.getRemoteProjectList()) {
			manager.registerRemoteListener(usersession.getSessionId(), listener, projectInfo.getProjectId());
			Activator.log(Status.INFO, "Listener registered at project: " + projectInfo.getName());
		}
	}
}
