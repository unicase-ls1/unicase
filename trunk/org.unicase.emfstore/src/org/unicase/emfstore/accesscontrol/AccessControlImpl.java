package org.unicase.emfstore.accesscontrol;

import org.unicase.emfstore.model.EsmodelFactory;
import org.unicase.emfstore.model.SessionId;

public class AccessControlImpl implements AccessControl {

	public SessionId logIn(String username, String password)
			throws AccessControlException {
		return EsmodelFactory.eINSTANCE.createSessionId();
	}

}
