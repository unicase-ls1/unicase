/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * 
 * @author Hodaie
 * @author Wesendonk
 */
public interface AdminEmfStore {
	List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException;
	List<ACGroup> getGroups(SessionId sessionId) throws EmfStoreException;
	List<ACUser> getUsers(SessionId sessionId) throws EmfStoreException;
	List<ACOrgUnit> getOrgUnits(SessionId sessionId) throws EmfStoreException;
	
	List<ACGroup> getGroups(SessionId sessionId, ACUser user) throws EmfStoreException;
	void addGroup(SessionId sessionId, ACUser user, ACGroup group) throws EmfStoreException;
	void removeGroup(SessionId sessionId, ACUser user, ACGroup group) throws EmfStoreException;
	
	List<ACOrgUnit> getParticipants(SessionId sessionId, ProjectInfo project) throws EmfStoreException;
	
	void addParticipant(SessionId sessionId, ProjectInfo project, ACOrgUnit participant) throws EmfStoreException;
	void removeParticipant(SessionId sessionId, ProjectInfo project, ACOrgUnit participant) throws EmfStoreException;
	
	Role getRole(SessionId sessionId, ProjectInfo project, ACOrgUnit orgUnit) throws EmfStoreException;
	void changeRole(SessionId sessionId, ProjectInfo projectInfo, ACOrgUnit orgUnit, EClass role) throws EmfStoreException;
}
