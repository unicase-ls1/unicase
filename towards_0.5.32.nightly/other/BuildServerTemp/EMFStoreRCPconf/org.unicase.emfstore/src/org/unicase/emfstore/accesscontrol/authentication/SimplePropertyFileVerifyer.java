/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.accesscontrol.authentication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.emfstore.exceptions.AccessControlException;

/**
 * This verifyer can be used to store user and passwords in a property file. Entries in the property file look should
 * look like this: <b>user = password</b> WARNING: passwords are not hashed yet.
 * 
 * @author wesendonk
 */
public class SimplePropertyFileVerifyer extends AbstractAuthenticationControl {

	private Properties passwordFile;

	private final Log logger;

	/**
	 * Default constructor.
	 * 
	 * @param filePath path to password file
	 */
	public SimplePropertyFileVerifyer(String filePath) {
		super();
		logger = LogFactory.getLog(SimplePropertyFileVerifyer.class);
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
		if (expectedPassword == null || !expectedPassword.equals(password)) {
			throw new AccessControlException();
		}
		return true;
	}

}
