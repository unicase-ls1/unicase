/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.connectionmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Enumeration;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.unicase.workspace.Configuration;

/**
 * The KeyStoreManager manages the client's keystore in which the ssl
 * certificates for multiple unicase server can be stored.
 * 
 * @author Wesendonk
 */
public final class KeyStoreManager {

	private static KeyStoreManager instance;

	private static final String KEYSTOREPASSWORD = "jsFTga3rGTR833329GFQEfas";
//	private static final String KEYSTOREPASSWORD = "123456";

	private static final String KEYSTORENAME = "unicaseClient.keystore";

	private KeyStore keyStore;

	private KeyStoreManager() {
	}

	/**
	 * Returns an instance of the {@link KeyStoreManager}.
	 * 
	 * @return {@link KeyStoreManager}
	 */
	public static KeyStoreManager getInstance() {
		if (instance == null) {
			instance = new KeyStoreManager();
		}
		return instance;
	}

	/**
	 * This method sets the jvm properties in order to use ssl encryption.
	 */
	public void setupKeys() {
		if (!keyStoreExists()) {
			// create directory ~/.unicase/ if necessary
			File unicasedir = new File(Configuration.getWorkspaceDirectory());
			if (!unicasedir.exists()) {
				unicasedir.mkdir();
			}

			// prepare loading of file from bundle
			URL clientKeyURL = FileLocator.find(Platform
					.getBundle("org.unicase.workspace"), new Path(
					"keystore/unicaseClient.keystore"), null);
			try {
				// configure file
				URL localClientKeyURL = FileLocator.toFileURL(clientKeyURL);
				File clientKeySource = new File(localClientKeyURL.getPath());

				File clientKeyTarget = new File(Configuration
						.getWorkspaceDirectory()
						+ "unicaseClient.keystore");

				// copy to destination
				org.unicase.model.util.FileUtil.copyFile(clientKeySource,
						clientKeyTarget);
			} catch (IOException e) {
				// TODO OW: exception? - now the user will be alerted to the
				// problem as soon as he tries to connect.
				// throw new ConnectionException("Couldn't find keystore.");
			}
		}
		
		System.setProperty("javax.net.ssl.trustStore", getPathToKeyStore());
		System.setProperty("javax.net.ssl.keyStore", getPathToKeyStore());
		System.setProperty("javax.net.ssl.keyStorePassword", KEYSTOREPASSWORD);
	}

	/**
	 * Lists all certificates in the client's keystore.
	 * 
	 * @return string representation of the certificates
	 */
	public ArrayList<String> getCertificates() {
		loadKeyStore();
		ArrayList<String> certificates = new ArrayList<String>();
		try {
			Enumeration<String> aliases = keyStore.aliases();
			for (; aliases.hasMoreElements();) {
				String tmp = aliases.nextElement();
				certificates.add(tmp + " - " + keyStore.getCreationDate(tmp));
			}
		} catch (KeyStoreException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		}
		return certificates;
	}

	/**
	 * Deletes a certificate in the keystore.
	 * 
	 * @param alias
	 *            alias of certificate
	 */
	public void deleteCertificate(String alias) {
		loadKeyStore();
		try {
			keyStore.deleteEntry(alias);
		} catch (KeyStoreException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		}
		storeKeyStore();
	}

	/**
	 * Adds a certificate to the keystore.
	 * 
	 * @param alias alias for the certificate
	 * @param path path to the certificate file
	 */
	public void addCertificate(String alias, String path) {
		loadKeyStore();
		try {
			CertificateFactory factory = CertificateFactory
					.getInstance("X.509");
			Certificate newCertificate = factory
					.generateCertificate(new FileInputStream(path));
			keyStore.setCertificateEntry(alias, newCertificate);
		} catch (CertificateException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void storeKeyStore() {
		loadKeyStore();
		try {
			keyStore.store(new FileOutputStream(getPathToKeyStore()),
					KEYSTOREPASSWORD.toCharArray());
		} catch (KeyStoreException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// OW Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadKeyStore() {
		if (keyStore == null) {
			try {
				keyStore = KeyStore.getInstance("JKS");
				keyStore.load(new FileInputStream(getPathToKeyStore()),
						KEYSTOREPASSWORD.toCharArray());
			} catch (KeyStoreException e) {
				// OW Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// OW Auto-generated catch block
				e.printStackTrace();
			} catch (CertificateException e) {
				// OW Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// OW Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// OW Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * True if a keystore file exists.
	 * 
	 * @return boolean
	 */
	public boolean keyStoreExists() {
		File keyStore = new File(getPathToKeyStore());
		return keyStore.exists();
	}

	/**
	 * Returns the path to the keystore.
	 * 
	 * @return a path
	 */
	public String getPathToKeyStore() {
		return Configuration.getWorkspaceDirectory() + KEYSTORENAME;
	}
}
