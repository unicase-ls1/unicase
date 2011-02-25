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

import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.metamodel.util.ModelUtil;

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

	/**
	 * Default constructor.
	 * 
	 * @param ldapUrl url
	 * @param ldapBase base
	 * @param searchDn dn
	 */
	public LDAPVerifier(String ldapUrl, String ldapBase, String searchDn) {
		this.ldapUrl = ldapUrl;
		this.ldapBase = ldapBase;
		this.searchDn = searchDn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verifyPassword(String username, String password) throws AccessControlException {

		// under construction 10.04.2010

		if (verifyPasswordWithLdap(username, password)) {
			return true;
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
			ModelUtil.logWarning("LDAP Directory " + ldapUrl + " not found.", e);
			return false;
		}

		SearchControls constraints = new SearchControls();
		constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
		NamingEnumeration<SearchResult> results = null;
		try {
			results = dirContext.search(ldapBase, "(& (" + searchDn + "=" + username + ") (objectclass=*))",
				constraints);
		} catch (NamingException e) {
			ModelUtil.logWarning("Search failed, base = " + ldapBase, e);
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
			ModelUtil.logException("Search returned invalid results, base = " + ldapBase, e);
			return false;
		}

		if (resolvedName == null) {
			ModelUtil.logWarning("Distinguished name not found on " + ldapBase);
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
			ModelUtil.logWarning("Login failed on " + ldapBase + " .", e);
			return false;
		}
		return true;
	}
}
