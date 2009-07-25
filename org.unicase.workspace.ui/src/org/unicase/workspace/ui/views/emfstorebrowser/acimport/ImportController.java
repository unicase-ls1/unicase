/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.acimport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author deser, karakoc
 */
public class ImportController {

	private final AdminBroker adminBroker;

	private ImportSource importSource;

	/**
	 * @param adminBroker
	 *            the admin broker.
	 */
	public ImportController(AdminBroker adminBroker) {
		this.adminBroker = adminBroker;

	}

	/**
	 * @param wrappedOrgUnits
	 *            a list of wrapped OrgUnits, which should be imported.
	 */
	public void importOrgUnits(ArrayList<ImportWrapper> wrappedOrgUnits) {
		// TODO: would be easy to just add the already created ACOrgUnits
		// instead of wrapping around ...!
		for (int i = 0; i < wrappedOrgUnits.size(); i++) {
			ImportWrapper wrappedOrgUnit = wrappedOrgUnits.get(i);
			if (wrappedOrgUnit.getOrgUnit() instanceof ACUser) {
				// add this user to the system
				try {
					String username = wrappedOrgUnit.getOrgUnit().getName();
					if (null == existUser(username)) {
						adminBroker.createUser(username);
					}
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException(e.getMessage(), e);
					DialogHandler.showExceptionDialog(e);
				}
			} else if (wrappedOrgUnit.getOrgUnit() instanceof ACGroup) {
				// add this group to the system if it doesn't exist
				try {
					String groupname = wrappedOrgUnit.getOrgUnit().getName();
					ACOrgUnitId groupID = existGroup(groupname);

					if (null == groupID) {
						groupID = adminBroker.createGroup(groupname);
					}

					ArrayList<ImportWrapper> childrenWrappedOrgUnits = wrappedOrgUnit
							.getChildOrgUnits();

					for (int j = 0; j < childrenWrappedOrgUnits.size(); j++) {
						if (childrenWrappedOrgUnits.get(j).getOrgUnit() instanceof ACUser) {
							String username = childrenWrappedOrgUnits.get(j)
									.getOrgUnit().getName();
							ACOrgUnitId userID = existUser(username);

							if (null == userID) {
								userID = adminBroker.createUser(username);
							}
							adminBroker.addMember(groupID, userID);
						}
					}

				} catch (EmfStoreException e) {
					WorkspaceUtil.logException(e.getMessage(), e);
					DialogHandler.showExceptionDialog(e);
				}

			} else {
				// Then it must be a "plain"/"abstract" ACOrgUnit, which should
				// not be added to the system.
			}
		}
	}

	/**
	 * @param groupName
	 *            the name of group.
	 * @return A ACOrgUnitId object if the group already exist null otherwise.
	 */
	private ACOrgUnitId existGroup(final String groupName) {
		ACOrgUnitId exist = null;
		try {
			List<ACGroup> groups = getAdminBroker().getGroups();
			Iterator<ACGroup> iteratorGroup = groups.iterator();

			while (iteratorGroup.hasNext()) {
				ACGroup gr = iteratorGroup.next();
				if (gr.getName().equalsIgnoreCase((groupName))) {
					exist = gr.getId();
				}
			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return exist;
	}

	/**
	 * @param userName
	 *            the name of user.
	 * @return A ACOrgUnitId object if the user already exist null otherwise.
	 */
	private ACOrgUnitId existUser(final String userName) {
		ACOrgUnitId exist = null;
		try {
			List<ACUser> users = getAdminBroker().getUsers();
			Iterator<ACUser> iteratorUser = users.iterator();

			while (iteratorUser.hasNext()) {
				ACUser us = iteratorUser.next();
				if (us.getName().equalsIgnoreCase((userName))) {
					exist = us.getId();
				}
			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return exist;
	}

	/**
	 * @param element
	 *            the name of user.
	 * @return true if the user already exist.
	 */
	@SuppressWarnings("unused")
	private boolean existOrgUnit(final String element) {
		boolean exist = false;
		try {
			List<ACOrgUnit> orgUnits = getAdminBroker().getOrgUnits();
			Iterator<ACOrgUnit> iterator = orgUnits.iterator();

			while (iterator.hasNext()) {
				if (iterator.next().getName().equalsIgnoreCase((element))) {
					exist = true;
				}
			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return exist;
	}

	/**
	 * @return the admin broker.
	 */
	public AdminBroker getAdminBroker() {
		return adminBroker;
	}

	/**
	 * @param importSource
	 *            the import source, that should be used for the import.
	 */
	public void setImportSource(ImportSource importSource) {
		this.importSource = importSource;
	}

	/**
	 * @return the current import source.
	 */
	public ImportSource getImportSource() {
		return importSource;
	}

	/**
	 * @return a small title, that can be displayed e.g. in a GUI.
	 */
	public String getTitle() {
		// if importSource isn't initialized yet, return an empty string instead
		return null == importSource ? "" : importSource.getLabel();
	}

	/**
	 * @return Returns a small message to describe where data currently gets
	 *         imported from.
	 */
	public String getMessage() {
		// if importSource isn't initialized yet, return an empty string instead
		return null == importSource ? "" : importSource.getMessage();
	}
}
