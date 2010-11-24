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

import org.unicase.emfstore.connection.ServerKeyStoreManager;
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
	private boolean useSSL;

	private static final String DEFAULT_CTX = "com.sun.jndi.ldap.LdapCtxFactory";

	/**
	 * Default constructor.
	 * 
	 * @param ldapUrl url, if url starts with ldaps:// SSL is used.
	 * @param ldapBase base
	 * @param searchDn dn
	 */
	public LDAPVerifier(String ldapUrl, String ldapBase, String searchDn) {
		this.ldapUrl = ldapUrl;
		this.ldapBase = ldapBase;
		this.searchDn = searchDn;

		if (ldapUrl.startsWith("ldaps://")) {
			useSSL = true;
			ServerKeyStoreManager.getInstance().setJavaSSLProperties();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verifyPassword(String username, String password) throws AccessControlException {
		DirContext dirContext = null;

		// anonymous bind and resolve user
		try {
			dirContext = new InitialDirContext(anonymousBind());
		} catch (NamingException e) {
			ModelUtil.logWarning("LDAP Directory " + ldapUrl + " not found.", e);
			return false;
		}
		String resolvedName = resolveUser(username, dirContext);
		if (resolvedName == null) {
			return false;
		}

		// Authenticated bind and check user's password
		try {
			dirContext = new InitialDirContext(authenticatedBind(resolvedName, password));
		} catch (NamingException e) {
			e.printStackTrace();
			ModelUtil.logWarning("Login failed on " + ldapBase + " .", e);
			return false;
		}
		return true;
	}

	private Properties anonymousBind() {
		Properties props = new Properties();
		props.put("java.naming.ldap.version", "3");
		props.put(Context.INITIAL_CONTEXT_FACTORY, DEFAULT_CTX);
		props.put(Context.PROVIDER_URL, ldapUrl);

		if (useSSL()) {
			props.put(Context.SECURITY_PROTOCOL, "ssl");
		}

		return props;
	}

	private boolean useSSL() {
		return useSSL;
	}

	private Properties authenticatedBind(String principal, String credentials) {
		Properties bind = anonymousBind();

		bind.put(Context.SECURITY_AUTHENTICATION, "simple");
		bind.put(Context.SECURITY_PRINCIPAL, principal + ", " + ldapBase);
		bind.put(Context.SECURITY_CREDENTIALS, credentials);

		return bind;
	}

	private String resolveUser(String username, DirContext dirContext) {
		SearchControls constraints = new SearchControls();
		constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
		NamingEnumeration<SearchResult> results = null;
		try {
			results = dirContext.search(ldapBase, "(& (" + searchDn + "=" + username + ") (objectclass=*))",
				constraints);
		} catch (NamingException e) {
			ModelUtil.logWarning("Search failed, base = " + ldapBase, e);
			return null;
		}

		if (results == null) {
			return null;
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
			return null;
		}

		if (resolvedName == null) {
			ModelUtil.logWarning("Distinguished name not found on " + ldapBase);
			return null;
		}
		return resolvedName;
	}
}
