/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ReaderRole;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * 
 * @author Wesendonk
 */
public class AdminEmfStoreImpl implements AdminEmfStore {

	private ServerSpace serverSpace;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace
	 *            the serverspace
	 * @param authorizationControl
	 *            the authoriazationcontrol
	 * @param properties
	 *            the properties
	 */
	public AdminEmfStoreImpl(ServerSpace serverSpace,
			AuthorizationControl authorizationControl, Properties properties) {
		this.serverSpace = serverSpace;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACGroup> getGroups(SessionId sessionId) {
		List<ACGroup> result = new ArrayList<ACGroup>();
		for (ACGroup group : getServerSpace().getGroups()) {
			result.add(group);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACGroup> getGroups(SessionId sessionId, ACUser user) {
		List<ACGroup> result = new ArrayList<ACGroup>();
		for (ACGroup group : getServerSpace().getGroups()) {
			// FIXME: does contains work after deserialization? maybe adapt
			// equals method
			if (group.getMembers().contains(user)) {
				result.add(group);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addGroup(SessionId sessionId, ACUser user, ACGroup group) throws EmfStoreException {
		getGroup(group).getMembers().add(user);

	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGroup(SessionId sessionId, ACUser user, ACGroup group) throws EmfStoreException {
		getGroup(group).getMembers().remove(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getParticipants(SessionId sessionId,
			ProjectInfo project) {
		List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
		for (ACOrgUnit orgUnit : getServerSpace().getUsers()) {
			for (Role role : orgUnit.getRoles()) {
				if (role.getProjects().contains(project.getProjectId())) {
					result.add(orgUnit);
				}
			}
		}
		for (ACOrgUnit orgUnit : getServerSpace().getGroups()) {
			for (Role role : orgUnit.getRoles()) {
				if (role.getProjects().contains(project.getProjectId())) {
					result.add(orgUnit);
				}
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addParticipant(SessionId sessionId, ProjectInfo project,
		ACOrgUnit participant) throws EmfStoreException {
		ACOrgUnit orgUnit = getOrgUnit(participant);
		for(Role role : orgUnit.getRoles()) {
			if(role.getProjects().contains(project.getProjectId())) {
				return;
			}
		}
		ReaderRole reader = RolesFactory.eINSTANCE.createReaderRole();
		reader.getProjects().add(project.getProjectId());
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeParticipant(SessionId sessionId, ProjectInfo project,
			ACOrgUnit participant) throws EmfStoreException {
		ACOrgUnit orgUnit = getOrgUnit(participant);
		for(Role role : orgUnit.getRoles()) {
			if(role.getProjects().contains(project.getProjectId())) {
				role.getProjects().remove(project.getProjectId());
				return;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Role getRole(SessionId sessionId, ProjectInfo project,
			ACOrgUnit orgUnit) throws EmfStoreException {
		ACOrgUnit oUnit = getOrgUnit(orgUnit);
		for(Role role : oUnit.getRoles()) {
			if(role.getProjects().contains(project.getProjectId())) {
				return role;
			}
		}
		throw new EmfStoreException("Couldn't find given OrgUnit.");
	}

	public void changeRole(SessionId sessionId, ProjectInfo projectInfo,
			ACOrgUnit orgUnit, EClass role) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACUser> getUsers(SessionId sessionId) {
		List<ACUser> result = new ArrayList<ACUser>();
		for (ACUser user : getServerSpace().getUsers()) {
			result.add(user);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getOrgUnits(SessionId sessionId) {
		List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
		for (ACOrgUnit user : getServerSpace().getUsers()) {
			result.add(user);
		}
		for (ACOrgUnit group : getServerSpace().getGroups()) {
			result.add(group);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectInfos(SessionId sessionId) {
		List<ProjectInfo> result = new ArrayList<ProjectInfo>();
		for (ProjectHistory ph : getServerSpace().getProjects()) {
			result.add(getProjectInfo(ph));
		}
		return result;
	}

	private ServerSpace getServerSpace() {
		return serverSpace;
	}

	private ProjectInfo getProjectInfo(ProjectHistory project) {
		ProjectInfo info = EsmodelFactory.eINSTANCE.createProjectInfo();
		info.setName(project.getProjectName());
		info.setDescription(project.getProjectDescription());
		info.setProjectId(project.getProjectId());
		info.setVersion(project.getLastVersion().getPrimarySpec());
		return info;
	}

	private ACGroup getGroup(ACGroup acGroup) throws EmfStoreException {
		for (ACGroup group : getServerSpace().getGroups()) {
			if (group.equals(acGroup)) {
				return group;
			}
		}
		throw new EmfStoreException("Given group doesn't exist.");
	}
	
	private ACOrgUnit getOrgUnit(ACOrgUnit orgUnit) throws EmfStoreException {
		for(ACOrgUnit unit : getServerSpace().getUsers()) {
			if(unit.equals(orgUnit)) {
				return unit;
			}
		}
		for(ACOrgUnit unit : getServerSpace().getGroups()) {
			if(unit.equals(orgUnit)) {
				return unit;
			}
		}
		throw new EmfStoreException("Given OrgUnit doesn't exist.");
	}

}
