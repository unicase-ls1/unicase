/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.accesscontrol.authentication;


import java.util.Properties;

import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.SessionId;

/**
 * Abstract class for authentication.
 * 
 * @author wesendonk
 */
public abstract class AbstractAuthenticationControl implements
		AuthenticationControl {

	public static final String SUPER_USER = "super";
	
	public static final String SUPER_USER_PW = "super";
	
	public AbstractAuthenticationControl(Properties properties) {
	
	}

	public SessionId logIn(String username, String password)
			throws AccessControlException {
		if((username.equals(SUPER_USER) && password.equals(SUPER_USER_PW)) || verifyPassword(username, password)) {
			return EsmodelFactory.eINSTANCE.createSessionId();
		}
		throw new AccessControlException();
	}
	
	abstract boolean verifyPassword(String username, String password) throws AccessControlException;

}
