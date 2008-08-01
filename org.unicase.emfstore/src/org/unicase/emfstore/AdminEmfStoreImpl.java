/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ReaderRole;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
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
	public List<ACGroup> getGroups(SessionId sessionId,  ACOrgUnitId orgUnitId) {
		List<ACGroup> result = new ArrayList<ACGroup>();
		for (ACGroup group : getServerSpace().getGroups()) {
			// FIXME: does contains work after deserialization? maybe adapt
			// equals method
			for(ACOrgUnit orgUnit : group.getMembers()) {
				if(orgUnit.getId().equals(orgUnitId) && orgUnit instanceof ACGroup) {
					result.add((ACGroup) group);
				}
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addGroup(SessionId sessionId, ACUser user, ACOrgUnitId orgUnitId) throws EmfStoreException {
		getGroup(orgUnitId).getMembers().add(user);

	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGroup(SessionId sessionId,  ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException {
		getGroup(group).getMembers().remove(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getParticipants(SessionId sessionId,
			ProjectId projectId) {
		List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
		for (ACOrgUnit orgUnit : getServerSpace().getUsers()) {
			for (Role role : orgUnit.getRoles()) {
				if (role.getProjects().contains(projectId)) {
					result.add(orgUnit);
				}
			}
		}
		for (ACOrgUnit orgUnit : getServerSpace().getGroups()) {
			for (Role role : orgUnit.getRoles()) {
				if (role.getProjects().contains(projectId)) {
					result.add(orgUnit);
				}
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addParticipant(SessionId sessionId, ProjectId projectId,
			 ACOrgUnitId participant) throws EmfStoreException {
		ACOrgUnit orgUnit = getOrgUnit(participant);
		for(Role role : orgUnit.getRoles()) {
			if(role.getProjects().contains(projectId)) {
				return;
			}
		}
		ReaderRole reader = RolesFactory.eINSTANCE.createReaderRole();
		reader.getProjects().add(projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeParticipant(SessionId sessionId, ProjectId projectId,
			 ACOrgUnitId participant) throws EmfStoreException {
		ACOrgUnit orgUnit = getOrgUnit(participant);
		for(Role role : orgUnit.getRoles()) {
			if(role.getProjects().contains(projectId)) {
				role.getProjects().remove(projectId);
				return;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Role getRole(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId orgUnitId) throws EmfStoreException {
		ACOrgUnit oUnit = getOrgUnit(orgUnitId);
		for(Role role : oUnit.getRoles()) {
			if(role.getProjects().contains(projectId)) {
				return role;
			}
		}
		throw new EmfStoreException("Couldn't find given OrgUnit.");
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeRole(SessionId sessionId, ProjectId projectId,
			 ACOrgUnitId orgUnitId, EClass roleClass) throws EmfStoreException {
		ACOrgUnit orgUnit = getOrgUnit(orgUnitId);
		// delete old role first
		Role role = getRole(projectId, orgUnit);
		if(role!=null) {
			role.getProjects().remove(projectId);			
		}
		// add project to role if existant
		for(Role role1 : orgUnit.getRoles()) {
			if (role1.getClass().equals(roleClass)) {
				role1.getProjects().add(projectId);
				return;
			}
		}
		// create role if not existant
		Role newRole = (Role)RolesPackage.eINSTANCE.getEFactoryInstance().create(roleClass);
		newRole.getProjects().add(projectId);
		orgUnit.getRoles().add(newRole);
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

	private ACGroup getGroup(ACOrgUnitId orgUnitId) throws EmfStoreException {
		for (ACGroup group : getServerSpace().getGroups()) {
			if (group.getId().equals(orgUnitId)) {
				return group;
			}
		}
		throw new EmfStoreException("Given group doesn't exist.");
	}
	
	private ACOrgUnit getOrgUnit(ACOrgUnitId orgUnitId) throws EmfStoreException {
		for(ACOrgUnit unit : getServerSpace().getUsers()) {
			if(unit.getId().equals(orgUnitId)) {
				return unit;
			}
		}
		for(ACOrgUnit unit : getServerSpace().getGroups()) {
			if(unit.getId().equals(orgUnitId)) {
				return unit;
			}
		}
		throw new EmfStoreException("Given OrgUnit doesn't exist.");
	}
	
	private Role getRole(ProjectId projectId, ACOrgUnit orgUnit) {
		for(Role role : orgUnit.getRoles()) {
			if(role.getProjects().contains(projectId)) {
				return role;
			}
		}
		return null;
	}

	@Override
	public void addGroup(SessionId sessionId, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(SessionId sessionId, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeGroup(SessionId sessionId, ACOrgUnitId group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(SessionId sessionId, ACOrgUnitId user) {
		// TODO Auto-generated method stub
		
	}

}
