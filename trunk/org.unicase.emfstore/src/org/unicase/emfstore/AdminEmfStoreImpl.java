/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.io.IOException;
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
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ReaderRole;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.StorageException;

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
	public List<ACGroup> getGroups(SessionId sessionId, ACOrgUnitId orgUnitId) {
		List<ACGroup> result = new ArrayList<ACGroup>();
		try {
			ACOrgUnit orgUnit = getOrgUnit(orgUnitId);
			for (ACGroup group : getServerSpace().getGroups()) {
				if (group.getMembers().contains(orgUnit)){
						result.add((ACGroup) group);
				}
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGroup(SessionId sessionId, ACOrgUnitId user,
		ACOrgUnitId group) throws EmfStoreException {
		getGroup(group).getMembers().remove(getOrgUnit(user));
		save();
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
		for (Role role : orgUnit.getRoles()) {
			if (role.getProjects().contains(projectId)) {
				return;
			}
		}
		// check whether reader role exists
		for (Role role : orgUnit.getRoles()) {
			if (role.eClass().equals(RolesPackage.eINSTANCE.getReaderRole())) {
				role.getProjects().add(projectId);
				save();
				return;
			}
		}
		// else create new reader role
		ReaderRole reader = RolesFactory.eINSTANCE.createReaderRole();
		reader.getProjects().add(projectId);
		orgUnit.getRoles().add(reader);
		save();
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeParticipant(SessionId sessionId, ProjectId projectId,
			ACOrgUnitId participant) throws EmfStoreException {
		ACOrgUnit orgUnit = getOrgUnit(participant);
		for (Role role : orgUnit.getRoles()) {
			if (role.getProjects().contains(projectId)) {
				role.getProjects().remove(projectId);
				save();
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
		for (Role role : oUnit.getRoles()) {
			if (role.getProjects().contains(projectId)) {
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
		if (role != null) {
			role.getProjects().remove(projectId);
		}
		// add project to role if existant
		for (Role role1 : orgUnit.getRoles()) {
			if (role1.eClass().equals(roleClass)) {
				role1.getProjects().add(projectId);
				save();
				return;
			}
		}
		// create role if not existant
		Role newRole = (Role) RolesPackage.eINSTANCE.getEFactoryInstance()
				.create(
						(EClass) RolesPackage.eINSTANCE
								.getEClassifier(roleClass.getName()));
		newRole.getProjects().add(projectId);
		orgUnit.getRoles().add(newRole);
		save();
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

	/**
	 * {@inheritDoc}
	 */
	public void createGroup(SessionId sessionId, String name)
			throws EmfStoreException {
		ACGroup acGroup = AccesscontrolFactory.eINSTANCE.createACGroup();
		// acGroup.setId(AccesscontrolFactory.eINSTANCE.createACOrgUnitId());
		acGroup.setName(name);
		getServerSpace().getGroups().add(acGroup);
		save();
	}

	/**
	 * {@inheritDoc}
	 */
	public void createUser(SessionId sessionId, String name)
			throws EmfStoreException {
		ACUser acUser = AccesscontrolFactory.eINSTANCE.createACUser();
		// acUser.setId(AccesscontrolFactory.eINSTANCE.createACOrgUnitId());
		acUser.setName(name);
		getServerSpace().getUsers().add(acUser);
		save();
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteGroup(SessionId sessionId, ACOrgUnitId group)
			throws EmfStoreException {
		for (Iterator<ACGroup> iter = getServerSpace().getGroups().iterator(); iter
				.hasNext();) {
			ACGroup next = iter.next();
			if (next.getId().equals(group)) {
				iter.remove();
				save();
				return;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteUser(SessionId sessionId, ACOrgUnitId user)
			throws EmfStoreException {
		for (Iterator<ACUser> iter = getServerSpace().getUsers().iterator(); iter
				.hasNext();) {
			ACUser next = iter.next();
			if (next.getId().equals(user)) {
				iter.remove();
				save();
				return;
			}
		}
	}

	public void addMember(SessionId sessionId, ACOrgUnitId group,
		ACOrgUnitId member) throws EmfStoreException {
		
		ACGroup acGroup = getGroup(group);
		ACOrgUnit acMember = getOrgUnit(member);
		acGroup.getMembers().add(acMember);
		save();
		
	}
	
	public void removeMember(SessionId sessionId, ACOrgUnitId group,
			ACOrgUnitId member) throws EmfStoreException {
		
		ACGroup acGroup = getGroup(group);
		ACOrgUnit acMember = getOrgUnit(member);
		if(acGroup.getMembers().contains(acMember)){
			acGroup.getMembers().remove(acMember);
			save();
		}
		
		
	}
	
	public void changeOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId,
			String name, String description) throws EmfStoreException {
		// TODO Auto-generated method stub
		
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

	private ACOrgUnit getOrgUnit(ACOrgUnitId orgUnitId)
			throws EmfStoreException {
		for (ACOrgUnit unit : getServerSpace().getUsers()) {
			if (unit.getId().equals(orgUnitId)) {
				return unit;
			}
		}
		for (ACOrgUnit unit : getServerSpace().getGroups()) {
			if (unit.getId().equals(orgUnitId)) {
				return unit;
			}
		}
		throw new EmfStoreException("Given OrgUnit doesn't exist.");
	}

	private Role getRole(ProjectId projectId, ACOrgUnit orgUnit) {
		for (Role role : orgUnit.getRoles()) {
			if (role.getProjects().contains(projectId)) {
				return role;
			}
		}
		return null;
	}

	private void save() throws EmfStoreException {
		try {
			getServerSpace().save();
		} catch (IOException e) {
			throw new StorageException(StorageException.NOSAVE, e);
		} catch (NullPointerException e) {
			throw new StorageException(StorageException.NOSAVE, e);
		}
	}

	public List<ACOrgUnit> getMembers(SessionId sessionId, ACOrgUnitId groupId)
			throws EmfStoreException {
		
		return getGroup(groupId).getMembers();
		
	}
}
