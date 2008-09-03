package org.unicase.workspace.accesscontrol;

import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ServerAdmin;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Usersession;

public class AccesscontrolHelper {

	private ACUser user;

	public AccesscontrolHelper(Usersession usersession)
			throws EmfStoreException {
		this.user = usersession.getACUser();
	}

	public void checkWriteAccess(ProjectId projectId) throws EmfStoreException {
		for (Role role : user.getRoles()) {
			if (role.canDelete(projectId, null)
					|| role.canCreate(projectId, null)
					|| role.canModify(projectId, null)) {
				return;
			}
		}
		throw new AccessControlException();
	}

	public void checkProjectAdminAccess(ProjectId projectId)
			throws EmfStoreException {
		for (Role role : user.getRoles()) {
			if (role.canAdministrate(projectId)) {
				return;
			}
		}
		throw new AccessControlException();
	}

	public void checkServerAdminAccess(ProjectId projectId)
			throws EmfStoreException {
		for (Role role : user.getRoles()) {
			if (role instanceof ServerAdmin) {
				return;
			}
		}
		throw new AccessControlException();
	}
}
