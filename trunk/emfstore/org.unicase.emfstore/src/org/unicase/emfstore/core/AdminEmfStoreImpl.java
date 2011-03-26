/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.server.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.ReaderRole;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.AdminEmfStore;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidInputException;
import org.unicase.emfstore.exceptions.StorageException;

/**
 * Implementation of {@link AdminEmfStore} interface.
 * 
 * @author Wesendonk
 */
// TODO: bring this interface in new subinterface structure and refactor it
public class AdminEmfStoreImpl extends AbstractEmfstoreInterface implements AdminEmfStore {

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace the serverspace
	 * @param authorizationControl the authoriazationcontrol
	 * @throws FatalEmfStoreException in case of failure
	 */
	public AdminEmfStoreImpl(ServerSpace serverSpace, AuthorizationControl authorizationControl)
		throws FatalEmfStoreException {
		super(serverSpace, authorizationControl);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACGroup> getGroups(SessionId sessionId) throws EmfStoreException {
		if (sessionId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		List<ACGroup> result = new ArrayList<ACGroup>();
		for (ACGroup group : getServerSpace().getGroups()) {

			// quickfix
			ACGroup copy = EcoreUtil.copy(group);
			clearMembersFromGroup(copy);
			result.add(copy);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACGroup> getGroups(SessionId sessionId, ACOrgUnitId orgUnitId) throws EmfStoreException {
		if (sessionId == null || orgUnitId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		List<ACGroup> result = new ArrayList<ACGroup>();
		ACOrgUnit orgUnit = getOrgUnit(orgUnitId);
		for (ACGroup group : getServerSpace().getGroups()) {
			if (group.getMembers().contains(orgUnit)) {

				// quickfix
				ACGroup copy = EcoreUtil.copy(group);
				clearMembersFromGroup(copy);
				result.add(copy);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnitId createGroup(SessionId sessionId, String name) throws EmfStoreException {
		if (sessionId == null || name == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		if (groupExists(name)) {
			throw new InvalidInputException("group already exists.");
		}
		ACGroup acGroup = AccesscontrolFactory.eINSTANCE.createACGroup();
		acGroup.setName(name);
		acGroup.setDescription("");
		getServerSpace().getGroups().add(acGroup);
		save();
		return EcoreUtil.copy(acGroup.getId());
	}

	private boolean groupExists(String name) {
		for (ACGroup group : getServerSpace().getGroups()) {
			if (group.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeGroup(SessionId sessionId, ACOrgUnitId user, ACOrgUnitId group) throws EmfStoreException {
		if (sessionId == null || user == null || group == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		getGroup(group).getMembers().remove(getOrgUnit(user));
		save();
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteGroup(SessionId sessionId, ACOrgUnitId group) throws EmfStoreException {
		if (sessionId == null || group == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		for (Iterator<ACGroup> iter = getServerSpace().getGroups().iterator(); iter.hasNext();) {
			ACGroup next = iter.next();
			if (next.getId().equals(group)) {
				EcoreUtil.delete(next);
				save();
				return;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getMembers(SessionId sessionId, ACOrgUnitId groupId) throws EmfStoreException {
		if (sessionId == null || groupId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);

		// quickfix
		List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
		for (ACOrgUnit orgUnit : getGroup(groupId).getMembers()) {
			result.add(EcoreUtil.copy(orgUnit));
		}
		clearMembersFromGroups(result);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		if (sessionId == null || group == null || member == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		ACGroup acGroup = getGroup(group);
		ACOrgUnit acMember = getOrgUnit(member);
		acGroup.getMembers().add(acMember);
		save();

	}

	/**
	 * {@inheritDoc}
	 */
	public void removeMember(SessionId sessionId, ACOrgUnitId group, ACOrgUnitId member) throws EmfStoreException {
		if (sessionId == null || group == null || member == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		ACGroup acGroup = getGroup(group);
		ACOrgUnit acMember = getOrgUnit(member);
		if (acGroup.getMembers().contains(acMember)) {
			acGroup.getMembers().remove(acMember);
			save();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getParticipants(SessionId sessionId, ProjectId projectId) throws EmfStoreException {
		if (sessionId == null || projectId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkProjectAdminAccess(sessionId, projectId);
		List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
		for (ACOrgUnit orgUnit : getServerSpace().getUsers()) {
			for (Role role : orgUnit.getRoles()) {
				if (isServerAdmin(role) || role.getProjects().contains(projectId)) {
					result.add(EcoreUtil.copy(orgUnit));
				}
			}
		}
		for (ACOrgUnit orgUnit : getServerSpace().getGroups()) {
			for (Role role : orgUnit.getRoles()) {
				if (isServerAdmin(role) || role.getProjects().contains(projectId)) {
					result.add(EcoreUtil.copy(orgUnit));
				}
			}
		}
		// quickfix
		clearMembersFromGroups(result);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant)
		throws EmfStoreException {
		if (sessionId == null || projectId == null || participant == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		projectId = getProjectId(projectId);
		ACOrgUnit orgUnit = getOrgUnit(participant);
		for (Role role : orgUnit.getRoles()) {
			if (role.getProjects().contains(projectId)) {
				return;
			}
		}
		// check whether reader role exists
		for (Role role : orgUnit.getRoles()) {
			if (isReader(role)) {
				role.getProjects().add(EcoreUtil.copy(projectId));
				save();
				return;
			}
		}
		// else create new reader role
		ReaderRole reader = RolesFactory.eINSTANCE.createReaderRole();
		reader.getProjects().add(EcoreUtil.copy(projectId));
		orgUnit.getRoles().add(reader);
		save();
	}

	private ProjectId getProjectId(ProjectId projectId) throws EmfStoreException {
		for (ProjectHistory projectHistory : getServerSpace().getProjects()) {
			if (projectHistory.getProjectId().equals(projectId)) {
				return projectHistory.getProjectId();
			}
		}
		throw new EmfStoreException("Unknown ProjectId.");
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeParticipant(SessionId sessionId, ProjectId projectId, ACOrgUnitId participant)
		throws EmfStoreException {
		if (sessionId == null || projectId == null || participant == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		projectId = getProjectId(projectId);
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
	public Role getRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnitId) throws EmfStoreException {
		if (sessionId == null || projectId == null || orgUnitId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		projectId = getProjectId(projectId);
		ACOrgUnit oUnit = getOrgUnit(orgUnitId);
		for (Role role : oUnit.getRoles()) {
			if (isServerAdmin(role) || role.getProjects().contains(projectId)) {
				return role;
			}
		}
		throw new EmfStoreException("Couldn't find given OrgUnit.");
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeRole(SessionId sessionId, ProjectId projectId, ACOrgUnitId orgUnitId, EClass roleClass)
		throws EmfStoreException {
		if (sessionId == null || projectId == null || orgUnitId == null || roleClass == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		projectId = getProjectId(projectId);
		ACOrgUnit orgUnit = getOrgUnit(orgUnitId);
		// delete old role first
		Role role = getRole(projectId, orgUnit);
		if (role != null) {
			role.getProjects().remove(projectId);
			if (role.getProjects().size() == 0) {
				orgUnit.getRoles().remove(role);
			}
		}
		// if server admin
		if (roleClass.getName().equals(RolesPackage.Literals.SERVER_ADMIN.getName())) {
			orgUnit.getRoles().add(RolesFactory.eINSTANCE.createServerAdmin());
			save();
			return;
		}
		// add project to role if it exists
		for (Role role1 : orgUnit.getRoles()) {
			if (role1.eClass().getName().equals(roleClass.getName())) {
				role1.getProjects().add(EcoreUtil.copy(projectId));
				save();
				return;
			}
		}
		// create role if does not exists
		Role newRole = (Role) RolesPackage.eINSTANCE.getEFactoryInstance().create(
			(EClass) RolesPackage.eINSTANCE.getEClassifier(roleClass.getName()));
		newRole.getProjects().add(EcoreUtil.copy(projectId));
		orgUnit.getRoles().add(newRole);
		save();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACUser> getUsers(SessionId sessionId) throws EmfStoreException {
		if (sessionId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		List<ACUser> result = new ArrayList<ACUser>();
		for (ACUser user : getServerSpace().getUsers()) {
			result.add(user);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ACOrgUnit> getOrgUnits(SessionId sessionId) throws EmfStoreException {
		if (sessionId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		List<ACOrgUnit> result = new ArrayList<ACOrgUnit>();
		for (ACOrgUnit user : getServerSpace().getUsers()) {
			result.add(EcoreUtil.copy(user));
		}
		for (ACOrgUnit group : getServerSpace().getGroups()) {
			result.add(EcoreUtil.copy(group));
		}
		// quickfix
		clearMembersFromGroups(result);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectInfos(SessionId sessionId) throws EmfStoreException {
		if (sessionId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		List<ProjectInfo> result = new ArrayList<ProjectInfo>();
		for (ProjectHistory ph : getServerSpace().getProjects()) {
			result.add(getProjectInfo(ph));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnitId createUser(SessionId sessionId, String name) throws EmfStoreException {
		if (sessionId == null || name == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		if (userExists(name)) {
			throw new InvalidInputException("username '" + name + "' already exists.");
		}
		ACUser acUser = AccesscontrolFactory.eINSTANCE.createACUser();
		// acUser.setId(AccesscontrolFactory.eINSTANCE.createACOrgUnitId());
		acUser.setName(name);
		acUser.setDescription(" ");
		getServerSpace().getUsers().add(acUser);
		save();
		return EcoreUtil.copy(acUser.getId());
	}

	private boolean userExists(String name) {
		for (ACUser user : getServerSpace().getUsers()) {
			if (user.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteUser(SessionId sessionId, ACOrgUnitId user) throws EmfStoreException {
		if (sessionId == null || user == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		for (Iterator<ACUser> iter = getServerSpace().getUsers().iterator(); iter.hasNext();) {
			ACUser next = iter.next();
			if (next.getId().equals(user)) {
				EcoreUtil.delete(next);
				save();
				return;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void changeOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId, String name, String description)
		throws EmfStoreException {
		if (sessionId == null || orgUnitId == null || name == null || description == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		ACOrgUnit ou = getOrgUnit(orgUnitId);
		ou.setName(name);
		ou.setDescription(description);
		save();

	}

	/**
	 * {@inheritDoc}
	 */
	public ACOrgUnit getOrgUnit(SessionId sessionId, ACOrgUnitId orgUnitId) throws EmfStoreException {
		if (sessionId == null || orgUnitId == null) {
			throw new InvalidInputException();
		}
		getAuthorizationControl().checkServerAdminAccess(sessionId);
		// quickfix
		ACOrgUnit orgUnit = EcoreUtil.copy(getOrgUnit(orgUnitId));
		clearMembersFromGroup(orgUnit);
		return orgUnit;
	}

	/**
	 * This method is used as fix for the containment issue of group.
	 */
	private void clearMembersFromGroups(Collection<ACOrgUnit> orgUnits) {
		for (ACOrgUnit orgUnit : orgUnits) {
			clearMembersFromGroup(orgUnit);
		}
	}

	/**
	 * This method is used as fix for the containment issue of group.
	 */
	private void clearMembersFromGroup(ACOrgUnit orgUnit) {
		if (orgUnit instanceof ACGroup) {
			((ACGroup) orgUnit).getMembers().clear();
		}
	}

	private boolean isServerAdmin(Role role) {
		return role.eClass().getName().equals(RolesPackage.Literals.SERVER_ADMIN.getName());
	}

	private boolean isReader(Role role) {
		return role.eClass().getName().equals(RolesPackage.Literals.READER_ROLE.getName());
	}

	private ProjectInfo getProjectInfo(ProjectHistory project) {
		ProjectInfo info = ModelFactory.eINSTANCE.createProjectInfo();
		info.setName(project.getProjectName());
		info.setDescription(project.getProjectDescription());
		info.setProjectId(EcoreUtil.copy(project.getProjectId()));
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
			if (isServerAdmin(role) || role.getProjects().contains(projectId)) {
				// return (Role) EcoreUtil.copy(role);
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

	/**
	 * {@inheritDoc}.
	 * 
	 * @see org.unicase.emfstore.core.AbstractEmfstoreInterface#initSubInterfaces()
	 */
	@Override
	protected void initSubInterfaces() throws FatalEmfStoreException {
	}
}
