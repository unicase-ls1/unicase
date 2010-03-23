/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.accesscontrol.authentication.factory;

import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.accesscontrol.authentication.AbstractAuthenticationControl;
import org.unicase.emfstore.accesscontrol.authentication.LDAPVerifier;
import org.unicase.emfstore.accesscontrol.authentication.SimplePropertyFileVerifier;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidPropertyException;

/**
 * Default authentication control factory.
 * 
 * @author wesendon
 */
public class AuthenticationControlFactoryImpl implements AuthenticationControlFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.accesscontrol.authentication.factory.AuthenticationControlFactory#createAuthenticationControl()
	 */
	public AbstractAuthenticationControl createAuthenticationControl() throws FatalEmfStoreException {
		String property = ServerConfiguration.getProperties().getProperty(ServerConfiguration.AUTHENTICATION_POLICY,
			ServerConfiguration.AUTHENTICATION_POLICY_DEFAULT);
		if (property.equals(ServerConfiguration.AUTHENTICATION_LDAP)) {
			return new LDAPVerifier();
		} else if (property.equals(ServerConfiguration.AUTHENTICATION_SPFV)) {
			return new SimplePropertyFileVerifier(ServerConfiguration.getProperties().getProperty(
				ServerConfiguration.AUTHENTICATION_SPFV_FILEPATH, ServerConfiguration.getDefaultSPFVFilePath()));
		} else {
			throw new InvalidPropertyException();
		}
	}

}
