/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.exceptions.AccessControlException;

/**
 * Verifies username/password using LDAP.
 * 
 * @author Wesendonk
 */
public class LDAPVerifier extends AbstractAuthenticationControl {

	private String ldapUrl;

	private String ldapBase;

	private String searchDn;

	private static final String DEFAULT_CTX = "com.sun.jndi.ldap.LdapCtxFactory";

	private final Log logger;

	/**
	 * Default constructor.
	 * 
	 * @param properties
	 */
	public LDAPVerifier() {
		super();
		logger = LogFactory.getLog(LDAPVerifier.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verifyPassword(String username, String password) throws AccessControlException {
		Properties properties = ServerConfiguration.getProperties();

		int count = 1;
		while (count != -1) {

			ldapUrl = properties.getProperty(ServerConfiguration.AUTHENTICATION_LDAP_PREFIX + "." + count + "."
				+ ServerConfiguration.AUTHENTICATION_LDAP_URL);
			ldapBase = properties.getProperty(ServerConfiguration.AUTHENTICATION_LDAP_PREFIX + "." + count + "."
				+ ServerConfiguration.AUTHENTICATION_LDAP_BASE);
			searchDn = properties.getProperty(ServerConfiguration.AUTHENTICATION_LDAP_PREFIX + "." + count + "."
				+ ServerConfiguration.AUTHENTICATION_LDAP_SEARCHDN);

			if (ldapUrl != null && ldapBase != null && searchDn != null) {
				if (verifyPasswordWithLdap(username, password)) {
					return true;
				}
				count++;
			} else {
				count = -1;
			}
		}
		return false;
	}

	private boolean verifyPasswordWithLdap(String username, String password) {
		Properties props = new Properties();
		DirContext dirContext = null;

		// anonymous bind
		props.put("java.naming.ldap.version", "3");
		props.put(Context.INITIAL_CONTEXT_FACTORY, DEFAULT_CTX);
		props.put(Context.PROVIDER_URL, ldapUrl);
		// props.put(Context.SECURITY_PROTOCOL, "ssl");
		try {
			dirContext = new InitialDirContext(props);
		} catch (NamingException e) {
			logger.info("LDAP Directory " + ldapUrl + " not found.", e);
			return false;
		}

		SearchControls constraints = new SearchControls();
		constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
		NamingEnumeration<SearchResult> results = null;
		try {
			results = dirContext.search(ldapBase, "(& (" + searchDn + "=" + username + ") (objectclass=*))",
				constraints);
		} catch (NamingException e) {
			logger.error("Search failed, base = " + ldapBase, e);
			return false;
		}

		if (results == null) {
			return false;
		}

		String resolvedName = null;
		try {
			while (results.hasMoreElements()) {
				SearchResult sr = results.next();
				if (sr != null) {
					resolvedName = sr.getName();
				}
				break;
			}
		} catch (NamingException e) {
			logger.error("Search returned invalid results, base = " + ldapBase, e);
			return false;
		}

		if (resolvedName == null) {
			logger.info("Distinguished name not found on " + ldapBase);
			return false;
		}

		// OW: use ssl? password hash?
		// Authenticated bind
		props = new Properties();
		// props.put(Context.SECURITY_PROTOCOL, "ssl");
		props.put(Context.SECURITY_AUTHENTICATION, "simple");
		props.put(Context.SECURITY_PRINCIPAL, resolvedName + ", " + ldapBase);
		props.put(Context.SECURITY_CREDENTIALS, password);
		props.put("java.naming.ldap.version", "3");
		props.put(Context.INITIAL_CONTEXT_FACTORY, DEFAULT_CTX);
		props.put(Context.PROVIDER_URL, ldapUrl);
		try {
			dirContext = new InitialDirContext(props);
		} catch (NamingException e) {
			logger.info("Login failed on " + ldapBase + " .");
			return false;
		}
		return true;
	}
}
