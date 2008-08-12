/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.accesscontrol.authentication;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.emfstore.accesscontrol.AccessControlException;

/**
 * Verifies username/password using LDAP.
 * 
 * @author Wesendonk
 */
public class LDAPVerifier extends AbstractAuthenticationControl {

	private static final String ldapURL = "ldap://opendirectorybruegge.informatik.tu-muenchen.de";

	private static final String ldapBase = "dc=opendirectorybruegge,dc=informatik,dc=tu-muenchen,dc=de";

	private static final String searchDN = "uid";

	private static final String DEFAULT_CTX = "com.sun.jndi.ldap.LdapCtxFactory";

	private final Log logger;

	/**
	 * Default constructor.
	 * @param properties 
	 */
	public LDAPVerifier(Properties properties) {
		super(properties);
		logger = LogFactory.getLog(LDAPVerifier.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public
	boolean verifyPassword(String username, String password)
			throws AccessControlException {
		Properties props = new Properties();
		DirContext dirContext = null;

		// anonymous bind
		props.put("java.naming.ldap.version", "3");
		props.put(Context.INITIAL_CONTEXT_FACTORY, DEFAULT_CTX);
		props.put(Context.PROVIDER_URL, ldapURL);
		//props.put(Context.SECURITY_PROTOCOL, "ssl");
		try {
			dirContext = new InitialDirContext(props);
		} catch (NamingException e) {
			logger.info("LDAP Directory " + ldapURL + " not found.", e);
			return false;
		}

		SearchControls constraints = new SearchControls();
		constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
		NamingEnumeration results = null;
		try {
			results = dirContext.search(ldapBase, "(& (" + searchDN + "="
					+ username + ") (objectclass=*))", constraints);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Search failed, base = " + ldapBase);
			return false;
		}

		if (results == null) {
			return false;
		}

		String resolvedName = null;
		try {
			while (results.hasMoreElements()) {
				SearchResult sr = (SearchResult) results.next();
				resolvedName = sr.getName();
				break;
			}
		} catch (Exception e) {
			logger.info("Exception while iterating over the results");
			return false;
		}

		if (resolvedName == null) {
			logger.info("Distinguished name not found.");
			return false;
		}

		// TODO: use ssl? password hash?
		// Authenticated bind
		props = new Properties();
		//props.put(Context.SECURITY_PROTOCOL, "ssl");
		props.put(Context.SECURITY_AUTHENTICATION, "simple");
		props.put(Context.SECURITY_PRINCIPAL, resolvedName + ", " + ldapBase);
		props.put(Context.SECURITY_CREDENTIALS, password);
		props.put("java.naming.ldap.version", "3");
		props.put(Context.INITIAL_CONTEXT_FACTORY, DEFAULT_CTX);
		props.put(Context.PROVIDER_URL, ldapURL);
		try {
			dirContext = new InitialDirContext(props);
		} catch (NamingException e) {
			e.printStackTrace();
			logger.info("Login failed.");
			return false;
		}
		return true;
	}
}
