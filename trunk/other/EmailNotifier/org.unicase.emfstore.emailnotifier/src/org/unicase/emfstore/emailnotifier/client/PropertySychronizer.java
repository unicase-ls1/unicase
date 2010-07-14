/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.unicase.emailnotifierpreferences.properties.EMailNotifierKey;
import org.unicase.emfstore.emailnotifier.Activator;
import org.unicase.emfstore.emailnotifier.client.util.Flag;
import org.unicase.emfstore.emailnotifier.client.util.Helper;
import org.unicase.emfstore.emailnotifier.exception.ENSNotificationGroupNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.ENSNotificationProjectNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.ENSUserNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.ProjectNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.PropertyNotFoundException;
import org.unicase.emfstore.emailnotifier.exception.UserEMailNotSetException;
import org.unicase.emfstore.emailnotifier.store.EMailNotifierStore;
import org.unicase.emfstore.emailnotifier.store.ENSFactory;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup;
import org.unicase.emfstore.emailnotifier.store.ENSNotificationProject;
import org.unicase.emfstore.emailnotifier.store.ENSUser;
import org.unicase.emfstore.emailnotifier.store.SendOption;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.model.emailnotificationgroup.AggregatedSettings;
import org.unicase.model.emailnotificationgroup.NotificationGroup;
import org.unicase.model.emailnotificationgroup.Weekdays;
import org.unicase.model.organization.User;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * Synchronizes ENS with user properties. Creates, deletes and modifies ENSNotificationGroups.
 * 
 * @author staudta
 *
 */
final class PropertySychronizer {
	
	private PropertySychronizer() {}
	
	/**
	 * Method will synchronize ENS with ACUser properties.
	 * 
	 * @param emailNotifierStore email notifier store
	 * @param acUser the ac user for that the properties will be gathered
	 * @param projectId the project id that will be updated. Should match the project if of the ensNotificationProject
	 * @param remoteProjectVersion current project version on the emf store
	 * @return true if ENS is dirty, false otherwise
	 */
	public static boolean synchronize(final EMailNotifierStore emailNotifierStore, final ACUser acUser, final ProjectId projectId, PrimaryVersionSpec remoteProjectVersion) {
		boolean isENSDirty = false;
		final List<OrgUnitProperty> projectProperties = Helper.getProjectProperties(acUser, projectId);
		
		boolean shouldMarkAllENSNGForInstantlySending = shouldMarkAllENSNGForInstantlySending(emailNotifierStore, acUser, projectId, projectProperties);
		Flag wasCreatedENSNP = new Flag(false);
		ENSNotificationProject ensNotificationProject = Helper.obtainENSNotificationProject(emailNotifierStore, projectId, wasCreatedENSNP);
		if( wasCreatedENSNP.getFlag() ) {
			// if it was made dirty, the ENS project has been just created. The current version of the project must be retrieved.
			// if the parameter remoteProjectVersion is set, the version will be written to the ENS Project. Only the EMailNotifierRepositoryTimer will give an remoteProjectVersion
			if( remoteProjectVersion != null ) {
				ensNotificationProject.setLatestVersion( remoteProjectVersion.getIdentifier() );
			}
			
			isENSDirty = true;
		}
		
		if( shouldMarkAllENSNGForInstantlySending ) {
			try {
				ENSUser ensUser = Helper.getENSUser(ensNotificationProject, acUser.getName());
				boolean wasMadeDirty = Helper.markUserNotificationGroupsForInstantlySending(ensUser);
				if( wasMadeDirty ) {
					isENSDirty = true;
				}
				
			} catch (ENSUserNotFoundException e) {
				// not necessary to mark for instantly sending, can be ignored
			}

			
		} else {
			try {
				if( !isUserAllowedToAccessProject(acUser, projectId) ) {
					// user is not allowed to acces project
					return isENSDirty;
				}
				
				ProjectSpace projectSpace = Helper.getLocalProject(projectId);
				User user = OrgUnitHelper.getUser(projectSpace, acUser.getName());
				Flag wasCreatedENSUser = new Flag(false);
				ENSUser ensUser = Helper.obtainENSUser(ensNotificationProject, acUser, user, wasCreatedENSUser);
				if( wasCreatedENSUser.getFlag() ) {
					isENSDirty = true;
				}
				
				Helper.getProperty(EMailNotifierKey.ACTIVATED, projectProperties); // just to be sure, that this property exists, 
				// and that it has been handled by the shouldMarkForInstantlySending method
				OrgUnitProperty propertyNG = Helper.getProperty(EMailNotifierKey.NOTIFICATIONGROUPS, projectProperties);
				List<NotificationGroup> notificationGroups = new LinkedList<NotificationGroup>();
				propertyNG.getEObjectListProperty(notificationGroups);
				if( synchronizeNewNotificationGroups(notificationGroups, ensNotificationProject, ensUser) ) {
					isENSDirty = true;
				}
				if( synchronizeDeletedNotificationGroups(notificationGroups, ensNotificationProject, ensUser) ) {
					isENSDirty = true;
				}
				if( synchronizeModifiedNotificationGroups(notificationGroups, ensNotificationProject, ensUser) ) {
					isENSDirty = true;
				}
				
			} catch(CannotMatchUserInProjectException e) {
				// ignore this user
			} catch (PropertyNotFoundException e) {
				// ignore this user
			} catch (UserEMailNotSetException e) {
				// ignore this user
			} catch (ProjectNotFoundException e) {
				// should not happen, but can happen, if a new remote project is created during runtime
				Activator.logException(e);
			}
		}
		
		return isENSDirty;
	}
	
	/**
	 * Identifies if for this user all stored ENS NotificationGroups should be marked for instantly sending.
	 * Instantly sending != immediately sending.
	 * 
	 * @param emailNotifierStore
	 * @param acUser
	 * @param projectId
	 * @param projectProperties
	 * @return
	 */
	private static boolean shouldMarkAllENSNGForInstantlySending(EMailNotifierStore emailNotifierStore, ACUser acUser, ProjectId projectId, List<OrgUnitProperty> projectProperties) {
		boolean sendAllNGNow = false;
		boolean userIsAllowedToAccessProject = isUserAllowedToAccessProject(acUser, projectId);
		if( !userIsAllowedToAccessProject ) {
			sendAllNGNow = true;
		
		} else {
			// user is allowed to access project
			try {
				OrgUnitProperty propertyActivated = Helper.getProperty(EMailNotifierKey.ACTIVATED, projectProperties);
				sendAllNGNow = !propertyActivated.getBooleanProperty();
				
				if (!sendAllNGNow) {
					OrgUnitProperty propertyNG = Helper.getProperty(EMailNotifierKey.NOTIFICATIONGROUPS, projectProperties);
					List<NotificationGroup> notificationGroups = new LinkedList<NotificationGroup>();
					propertyNG.getEObjectListProperty(notificationGroups);
					if (notificationGroups.isEmpty()) {
						sendAllNGNow = true;
					} else {
						return false; // no further checks necessary
					}
				}
				
			} catch (PropertyNotFoundException e) {
				sendAllNGNow = true;
			}
		}
		
		ENSNotificationProject ensNotificationProject = null;
		try {
			ensNotificationProject = Helper.getENSNotificationProject(emailNotifierStore, projectId);
		} catch (ENSNotificationProjectNotFoundException e) {
			if( sendAllNGNow ) {
				// nothing must be set for instantly sending
				return false;
				
			} else {
				// for synchronization, a ENSNotificationProject is needed
				ensNotificationProject = Helper.obtainENSNotificationProject(emailNotifierStore, projectId, null);
				emailNotifierStore.getProjects().add( ensNotificationProject );
			}
		}
		
		try {
			Helper.getENSUser(ensNotificationProject, acUser.getName());
		} catch(ENSUserNotFoundException e) {
			if( sendAllNGNow ) {
				// nothing must be set for instantly sending, user doesn't exist
				return false;
			}
		}
		
		return sendAllNGNow;
	}
	
	/**
	 * Check if there are new notification groups.
	 * 
	 * @param notificationGroups
	 * @param ensNotificationProject
	 * @param ensUser
	 */
	private static boolean synchronizeNewNotificationGroups(List<NotificationGroup> notificationGroups, ENSNotificationProject ensNotificationProject, ENSUser ensUser) {
		boolean isENSDirty = false;
		
		List<NotificationGroup> newNotificationGroups = getNewNotificationGroups(notificationGroups, ensUser);
		if( !newNotificationGroups.isEmpty() ) {
			isENSDirty = true;
		}
		for(NotificationGroup notificationGroup: newNotificationGroups) {
			ENSNotificationGroup newENSNotificationGroup = ENSFactory.eINSTANCE.createENSNotificationGroup();
			newENSNotificationGroup.setName(notificationGroup.getNotificationGroupName());
			
			if( notificationGroup.getSendOption().equals( org.unicase.model.emailnotificationgroup.SendSettings.IMMEDIATELY ) ) {
				newENSNotificationGroup.setBaseVersion( ensNotificationProject.getLatestVersion() );
				newENSNotificationGroup.setSendOption( SendOption.IMMEDIATELY );
				
			} else if (notificationGroup.getSendOption().equals( org.unicase.model.emailnotificationgroup.SendSettings.AGGREGATED )) {
				newENSNotificationGroup.setSendOption( SendOption.AGGREGATED );
				newENSNotificationGroup.setBaseVersion( ensNotificationProject.getLatestVersion() );
				Date nextSendingDate = calcNextSending(notificationGroup);
				newENSNotificationGroup.setNextSendingDate(nextSendingDate);
			}
			
			ensUser.getGroups().add( newENSNotificationGroup );
		}
		
		return isENSDirty;
	}
	
	/**
	 * Check if the user has deleted some notification groups.
	 * 
	 * @param notificationGroups
	 * @param ensNotificationProject
	 * @param ensUser
	 */
	private static boolean synchronizeDeletedNotificationGroups(List<NotificationGroup> notificationGroups, ENSNotificationProject ensNotificationProject, ENSUser ensUser) {
		boolean isENSDirty = false;
		final Date now = new Date();
		
		List<ENSNotificationGroup> deletedENSNotificationGroups = getDeletedENSNotificationGroups(notificationGroups, ensUser);
		if( !deletedENSNotificationGroups.isEmpty() ) {
			isENSDirty = true;
		}
		
		List<ENSNotificationGroup> ensNotificationGroupsToRemove = new ArrayList<ENSNotificationGroup>();
		for(ENSNotificationGroup ensNotificationGroup: deletedENSNotificationGroups) {
			// set them to be sent now
			if( ensNotificationGroup.getSendOption().equals( SendOption.AGGREGATED ) ) {
				// if sending setting == aggregated
				ensNotificationGroup.setNextSendingDate( now );
			} else if( ensNotificationGroup.getSendOption().equals( SendOption.IMMEDIATELY ) ) {
				// if sending setting == immediately
				// remove notification group directly from the store
				ensNotificationGroupsToRemove.add(ensNotificationGroup);
			}
		}
		ensUser.getGroups().removeAll(ensNotificationGroupsToRemove);
		
		return isENSDirty;
	}
	
	private static boolean synchronizeModifiedNotificationGroups(List<NotificationGroup> notificationGroups, ENSNotificationProject ensNotificationProject, ENSUser ensUser) {
		boolean isENSDirty = false;
		
		// check if the user has modified notification properties for notification groups
		for(NotificationGroup notificationGroup: notificationGroups) {
			try {
				ENSNotificationGroup ensNotficationGroup = Helper.getENSNotficationGroup(ensUser.getGroups(), notificationGroup.getNotificationGroupName());
				
				if( notificationGroup.getSendOption().equals( org.unicase.model.emailnotificationgroup.SendSettings.IMMEDIATELY )
					&&
					ensNotficationGroup.getSendOption().equals( SendOption.IMMEDIATELY ) ) {
					// okay, everything is fine
				
				} else if(notificationGroup.getSendOption().equals( org.unicase.model.emailnotificationgroup.SendSettings.AGGREGATED )
					&&
					ensNotficationGroup.getSendOption().equals( SendOption.AGGREGATED )) {
					// check if time has changed
					Date currentNextSending = ensNotficationGroup.getNextSendingDate();
					Date newCalcNextSending = calcNextSending(notificationGroup);
					
					// compare only the date not the time
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
					String currentNextSendingString = sdf.format( currentNextSending ); 
					String newCalcNextSendingString = sdf.format( newCalcNextSending ); 
					if( !currentNextSendingString.equals( newCalcNextSendingString ) ) {
						ensNotficationGroup.setNextSendingDate( newCalcNextSending );
						isENSDirty = true;
					}
					
				} else if(notificationGroup.getSendOption().equals( org.unicase.model.emailnotificationgroup.SendSettings.IMMEDIATELY )
					&&
					ensNotficationGroup.getSendOption().equals( SendOption.AGGREGATED )) {
					// was aggregated but is set to immediately
					ensNotficationGroup.setSendOption( SendOption.IMMEDIATELY );
					ensNotficationGroup.setNextSendingDate(null);
					isENSDirty = true;
					
				} else if(notificationGroup.getSendOption().equals( org.unicase.model.emailnotificationgroup.SendSettings.AGGREGATED )
					&&
					ensNotficationGroup.getSendOption().equals( SendOption.IMMEDIATELY )) {
					// was immediately but is set to aggregated
					ensNotficationGroup.setSendOption( SendOption.AGGREGATED );
					Date nextSendingDate = calcNextSending(notificationGroup);
					ensNotficationGroup.setNextSendingDate(nextSendingDate);
					isENSDirty = true;
				}
				
			} catch(ENSNotificationGroupNotFoundException e) {
				Activator.logException(e);
			}
		}
		
		return isENSDirty;
	}
	
	private static List<NotificationGroup> getNewNotificationGroups(List<NotificationGroup> notificationGroups, ENSUser ensUser) {
		List<NotificationGroup> newNotificationGroups = new LinkedList<NotificationGroup>();
		
		for(NotificationGroup notificationGroup: notificationGroups) {
			boolean isContained = false;
			for(ENSNotificationGroup ensNotificationGroup: ensUser.getGroups()) {
				if( notificationGroup.getNotificationGroupName().equals( ensNotificationGroup.getName() ) ) {
					isContained = true;
					break;
				}
			}
			
			if( !isContained ) {
				newNotificationGroups.add( notificationGroup );
			}
		}
		return newNotificationGroups;
	}
	
	private static List<ENSNotificationGroup> getDeletedENSNotificationGroups(List<NotificationGroup> notificationGroups, ENSUser ensUser) {
		List<ENSNotificationGroup> deletedENSNotificationGroups = new LinkedList<ENSNotificationGroup>();
		
		for(ENSNotificationGroup ensNotificationGroup: ensUser.getGroups()) {
			boolean isContained = false;
			for(NotificationGroup notificationGroup: notificationGroups) {
				if( ensNotificationGroup.getName().equals( notificationGroup.getNotificationGroupName() ) ) {
					isContained = true;
					break;
				}
			}
			
			if( !isContained ) {
				deletedENSNotificationGroups.add( ensNotificationGroup );
			}
		}
		
		return deletedENSNotificationGroups;
	}
	
	private static Date calcNextSending(NotificationGroup notificationGroup) {
		// calc next Sending
		Date nextSending = null;
		if( notificationGroup.getSendOption() == org.unicase.model.emailnotificationgroup.SendSettings.IMMEDIATELY ) {
			nextSending = new Date();
		} else if( notificationGroup.getSendOption() == org.unicase.model.emailnotificationgroup.SendSettings.AGGREGATED ) {
			if( notificationGroup.getAggregatedOption() == AggregatedSettings.DAYS ) {
				int days = notificationGroup.getDaysCount();
				nextSending = Helper.addDays(new Date(), days);
				
			} else if( notificationGroup.getAggregatedOption() == AggregatedSettings.WEEKDAY ) {
				Weekdays weekday = notificationGroup.getWeekdayOption();
				nextSending = Helper.nextWeekday(new Date(), weekday);
			}
		}
		
		return nextSending;
	}
	
	private static boolean isUserAllowedToAccessProject(ACUser acUser, ProjectId projectId) {
		EList<Role> roles = acUser.getRoles();
		for(Role role: roles) {
			if( role.canRead(projectId, null) ) {
				return true;
			}
		}
		
		return false;
	}
}
