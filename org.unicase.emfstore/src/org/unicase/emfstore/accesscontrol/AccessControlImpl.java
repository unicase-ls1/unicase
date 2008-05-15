package org.unicase.emfstore.accesscontrol;

import org.unicase.esmodel.EsmodelFactory;
import org.unicase.esmodel.SessionId;

public class AccessControlImpl implements AccessControl {

	public SessionId logIn(String username, String password)
			throws AccessControlException {
		return EsmodelFactory.eINSTANCE.createSessionId();
	}

}
