/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * Import all user from LDDAP to the project.
 * 
 * @author helming
 */
public class ImportUserHandler extends AbstractHandler {
	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				try {
					List<ACOrgUnit> participants = projectSpace.getUsersession().getAdminBroker().getParticipants(
						projectSpace.getProjectId());
					if (participants != null) {
						addToProject(participants, projectSpace);
					}
				} catch (ConnectionException e) {
					DialogHandler.showExceptionDialog(e);
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}

			}
		});

		return null;
	}

	/**
	 * Adds a list of acUsers to a project.
	 * 
	 * @param participants The list of ACUser
	 * @param projectSpace The projectSpace which contains the project
	 */
	protected void addToProject(List<ACOrgUnit> participants, ProjectSpace projectSpace) {
		HashMap<String, User> userIdMap = new HashMap<String, User>();
		HashMap<String, User> userNameMap = new HashMap<String, User>();
		List<ACUser> importUserList = new ArrayList<ACUser>();
		Project project = projectSpace.getProject();
		EList<User> existingUsers = new BasicEList<User>();
		project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), existingUsers);
		// Put existing users in a map
		for (User user : existingUsers) {
			userIdMap.put(user.getAcOrgId(), user);
			userNameMap.put(user.getName(), user);
		}
		// Convert list to flat user list
		convertList(participants, importUserList, projectSpace);
		// List to save ids to check dengling users in the project later and
		// remove their acId
		List<String> acUserIds = new ArrayList<String>();
		for (ACUser acuser : importUserList) {
			ACOrgUnitId id = acuser.getId();
			acUserIds.add(id.getId());
			User user = userIdMap.get(id.getId());
			if (user == null) {
				user = userNameMap.get(acuser.getName());
				// If user not found create it
				if (user == null) {
					user = OrganizationFactory.eINSTANCE.createUser();
					user.setName(acuser.getName());
					user.setDescription(acuser.getDescription());
					project.addModelElement(user);
				}
				user.setAcOrgId(id.getId());
			}

		}
		// Remove all acIds which are no longer in th group
		for (User user : existingUsers) {
			if (!acUserIds.contains(user.getAcOrgId())) {
				user.setAcOrgId(null);
			}
		}

	}

	private void convertList(List<ACOrgUnit> participants, List<ACUser> importUserList, ProjectSpace projectSpace) {
		for (ACOrgUnit orgUnit : participants) {
			if (orgUnit instanceof ACUser) {
				importUserList.add((ACUser) orgUnit);
			}
			if (orgUnit instanceof ACGroup) {
				List<ACOrgUnit> recursiveList = null;
				try {
					recursiveList = projectSpace.getUsersession().getAdminBroker().getMembers(orgUnit.getId());
				} catch (ConnectionException e) {
					DialogHandler.showExceptionDialog(e);
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
				if (recursiveList != null) {
					convertList(recursiveList, importUserList, projectSpace);
				}

			}
		}

	}

}
