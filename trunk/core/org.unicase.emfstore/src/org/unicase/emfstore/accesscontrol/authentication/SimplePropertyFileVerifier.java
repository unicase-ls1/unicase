/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.accesscontrol.authentication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * This verifyer can be used to store user and passwords in a property file. Entries in the property file look should
 * look like this: <b>user = password</b>
 * 
 * @author wesendonk
 */
public class SimplePropertyFileVerifier extends AbstractAuthenticationControl {

	private Properties passwordFile;

	private final Log logger;

	private final Hash hash;

	/**
	 * Hash algorithms supported by spfv verifier.
	 * 
	 * @author wesendon
	 */
	public enum Hash {
		/**
		 * NONE - no hash, MD5 - md5 hash, SHA1 - sha1 hash.
		 */
		NONE, MD5, SHA1
	}

	/**
	 * Default constructor. No hash will be used for passwords
	 * 
	 * @see #SimplePropertyFileVerifier(String, Hash)
	 * @param filePath path to password file
	 * @throws FatalEmfStoreException in case of failure
	 */
	public SimplePropertyFileVerifier(String filePath) throws FatalEmfStoreException {
		this(filePath, Hash.NONE);
	}

	/**
	 * Constructor with ability to select hash algorithm for password.
	 * 
	 * @param filePath path to file
	 * @param hash selected hash
	 * @throws FatalEmfStoreException if hash is null
	 */
	public SimplePropertyFileVerifier(String filePath, Hash hash) throws FatalEmfStoreException {
		super();
		if (hash == null) {
			throw new FatalEmfStoreException("Hash may not be null for verifier.");
		}
		this.hash = hash;
		logger = LogFactory.getLog(SimplePropertyFileVerifier.class);
		passwordFile = new Properties();
		try {
			File propertyFile = new File(filePath);
			FileInputStream fis = new FileInputStream(propertyFile);
			passwordFile.load(fis);
			fis.close();
		} catch (IOException e) {
			logger.warn("Couldn't load password file from path: " + filePath);
			// Run with empty password file
			// throw new AccessControlException("Couldn't load password file from path: "+filePath);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean verifyPassword(String username, String password) throws AccessControlException {
		String expectedPassword = passwordFile.getProperty(username);
		password = hashPassword(password);
		if (expectedPassword == null || !expectedPassword.equals(password)) {
			return false;
		}
		return true;
	}

	private String hashPassword(String password) {
		if (password == null || hash.equals(Hash.NONE)) {
			return password;
		} else {
			try {
				MessageDigest md = null;
				switch (hash) {
				case SHA1:
					md = MessageDigest.getInstance("SHA-1");
					break;
				case MD5:
					md = MessageDigest.getInstance("MD5");
					break;
				default:
				}
				if (md != null) {
					return new String(md.digest(password.getBytes()));
				}
			} catch (NoSuchAlgorithmException e) {
			}
		}
		return null;
	}
}
