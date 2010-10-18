/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import org.unicase.emfstore.accesscontrol.authentication.AbstractAuthenticationControl;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.AccessControlException;

/**
 * @author stefan
 */
public class SimpleAuth extends AbstractAuthenticationControl {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.accesscontrol.authentication.AbstractAuthenticationControl#verifyPassword(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	protected boolean verifyPassword(String username, String password) throws AccessControlException {
		if (!password.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public SessionId logIn(String username, String password, ClientVersionInfo clientVersionInfo)
		throws AccessControlException {
		if (verifySuperUser(username, password) || verifyPassword(username, password)) {
			return EsmodelFactory.eINSTANCE.createSessionId();
		}
		return null;
	}

}
