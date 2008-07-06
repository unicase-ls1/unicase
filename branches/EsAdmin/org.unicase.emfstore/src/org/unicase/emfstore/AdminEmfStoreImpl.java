/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;

/**
 * 
 * @author Wesendonk
 */
public class AdminEmfStoreImpl implements AdminEmfStore {

	private ServerSpace serverSpace;

	public AdminEmfStoreImpl(ServerSpace serverSpace,
			AuthorizationControl authorizationControl, Properties properties) {
		this.serverSpace = serverSpace;
	}
	
	public void addGroup(SessionId sessionId, ACUser user, ACGroup group) {
		// TODO Auto-generated method stub

	}

	
	public void addParticipant(SessionId sessionId, ProjectInfo project,
			ACOrgUnit participant) {
		// TODO Auto-generated method stub

	}

	
	public void changeRole(SessionId sessionId, ProjectInfo projectInfo,
			ACOrgUnit orgUnit, EClass role) {
		// TODO Auto-generated method stub

	}

	
	public List<ACGroup> getGroups(SessionId sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<ACGroup> getGroups(SessionId sessionId, ACUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<ACOrgUnit> getOrgUnits(SessionId sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<ACOrgUnit> getParticipants(SessionId sessionId,
			ProjectInfo project) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<ProjectInfo> getProjectInfos(SessionId sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Role getRole(SessionId sessionId, ProjectInfo project,
			ACOrgUnit orgUnit) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<ACUser> getUsers(SessionId sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void removeGroup(SessionId sessionId, ACUser user, ACGroup group) {
		// TODO Auto-generated method stub

	}

	
	public void removeParticipant(SessionId sessionId, ProjectInfo project,
			ACOrgUnit participant) {
		// TODO Auto-generated method stub

	}
	
	private ServerSpace getServerSpace() {
		return serverSpace;
	}

}
