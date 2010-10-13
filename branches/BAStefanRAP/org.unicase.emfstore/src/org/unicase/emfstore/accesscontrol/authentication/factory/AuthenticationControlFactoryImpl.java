/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.accesscontrol.authentication.factory;

import java.util.Properties;

import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.accesscontrol.authentication.AbstractAuthenticationControl;
import org.unicase.emfstore.accesscontrol.authentication.LDAPVerifier;
import org.unicase.emfstore.accesscontrol.authentication.SimplePropertyFileVerifier;
import org.unicase.emfstore.accesscontrol.authentication.VerifierChain;
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

		// under construction
		// this factory reproduces the legacy behavior of unicase until new config is implemented

		String property = ServerConfiguration.getProperties().getProperty(ServerConfiguration.AUTHENTICATION_POLICY,
			ServerConfiguration.AUTHENTICATION_POLICY_DEFAULT);

		if (property.equals(ServerConfiguration.AUTHENTICATION_LDAP)) {
			VerifierChain chain = new VerifierChain();
			Properties properties = ServerConfiguration.getProperties();
			int count = 1;
			while (count != -1) {

				String ldapUrl = properties.getProperty(ServerConfiguration.AUTHENTICATION_LDAP_PREFIX + "." + count
					+ "." + ServerConfiguration.AUTHENTICATION_LDAP_URL);
				String ldapBase = properties.getProperty(ServerConfiguration.AUTHENTICATION_LDAP_PREFIX + "." + count
					+ "." + ServerConfiguration.AUTHENTICATION_LDAP_BASE);
				String searchDn = properties.getProperty(ServerConfiguration.AUTHENTICATION_LDAP_PREFIX + "." + count
					+ "." + ServerConfiguration.AUTHENTICATION_LDAP_SEARCHDN);

				if (ldapUrl != null && ldapBase != null && searchDn != null) {
					LDAPVerifier ldapVerifier = new LDAPVerifier(ldapUrl, ldapBase, searchDn);
					chain.getVerifier().add(ldapVerifier);
					count++;
				} else {
					count = -1;
				}
			}

			return chain;

		} else if (property.equals(ServerConfiguration.AUTHENTICATION_SPFV)) {

			return new SimplePropertyFileVerifier(ServerConfiguration.getProperties().getProperty(
				ServerConfiguration.AUTHENTICATION_SPFV_FILEPATH, ServerConfiguration.getDefaultSPFVFilePath()));

		} else {
			throw new InvalidPropertyException();
		}
	}

}
