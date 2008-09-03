package org.unicase.workspace.accesscontrol;

import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;

public class AccesscontrolHelper {

	private ACUser user;

	public AccesscontrolHelper(Usersession usersession) throws EmfStoreException {
		this.user = usersession.getACUser();
	}
}
