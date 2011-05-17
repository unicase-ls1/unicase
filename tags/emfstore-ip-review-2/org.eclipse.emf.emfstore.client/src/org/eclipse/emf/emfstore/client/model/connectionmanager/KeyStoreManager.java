/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.connectionmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.exceptions.CertificateStoreException;
import org.eclipse.emf.emfstore.client.model.exceptions.InvalidCertificateException;
import org.eclipse.emf.emfstore.client.model.util.ConfigurationProvider;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.util.FileUtil;

/**
 * The KeyStoreManager manages the client's KeyStore in which the SSL
 * certificates for multiple EMFStore servers can be stored.
 * 
 * @author Wesendonk
 */

public final class KeyStoreManager {

	private static KeyStoreManager instance;

	/**
	 * Name of keyStore file.
	 */
	public static final String KEYSTORENAME = "emfstoreClient.keystore";

	private static final String KEYSTOREPASSWORD = "654321";

	private static final String CERTIFICATE_TYPE = "X.509";

	private static final String CIPHER_ALGORITHM = "RSA";

	/**
	 * Certificate Alias for devevelopment test certificate.
	 */
	public static final String DEFAULT_CERTIFICATE = "emfstore test certificate (do not use in production!)"; // "EMFStore Test Certificate (DO NOT USE IN PRODUCTION!)";

	private String defaultCertificate;

	private KeyStore keyStore;

	private KeyStoreManager() {
		defaultCertificate = null;
		setupKeys();
		loadConfiguration();
	}

	private void loadConfiguration() {
		IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.emfstore.client.defaultConfigurationProvider");
		ConfigurationProvider provider = null;
		for (IConfigurationElement extension : rawExtensions) {
			try {
				provider = (ConfigurationProvider) extension.createExecutableExtension("providerClass");
			} catch (CoreException e) {
				// fail silently
			}
		}
		if (provider == null) {
			return;
		}
		provider.initDefaultCertificates(this);

	}

	/**
	 * Returns an instance of the {@link KeyStoreManager}.
	 * 
	 * @return {@link KeyStoreManager}
	 */
	public static synchronized KeyStoreManager getInstance() {
		if (instance == null) {
			instance = new KeyStoreManager();
		}
		return instance;
	}

	/**
	 * This method sets the JVM properties in order to use SSL encryption.
	 */
	public void setupKeys() {
		// No changes to exception handling here, due to call nature.
		if (!keyStoreExists()) {
			// create directory ~/.emfstore/ if necessary
			File emfstoreDir = new File(Configuration.getWorkspaceDirectory());
			if (!emfstoreDir.exists()) {
				emfstoreDir.mkdir();
			}
			try {
				// configure file
				InputStream inputStream = getClass().getResourceAsStream(KEYSTORENAME);
				File clientKeyTarget = new File(Configuration.getWorkspaceDirectory() + KEYSTORENAME);
				// copy to destination
				FileUtil.copyFile(inputStream, clientKeyTarget);
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
	 * Lists all certificates in the client's KeyStore.
	 * 
	 * @return string representation of the certificates
	 * @throws CertificateStoreException
	 *             is thrown when problems occur with the CertificateStore, i.e.
	 *             illegal operations.
	 */
	public ArrayList<String> getCertificates() throws CertificateStoreException {
		loadKeyStore();
		ArrayList<String> certificates = new ArrayList<String>();
		try {
			Enumeration<String> aliases = keyStore.aliases();
			for (; aliases.hasMoreElements();) {
				String tmp = aliases.nextElement();
				certificates.add(tmp);
			}
		} catch (KeyStoreException e) {
			String message = "Loading certificates failed!";
			WorkspaceUtil.logException(message, e);
			throw new CertificateStoreException(message, e);
		}
		return certificates;
	}

	/**
	 * Deletes a certificate in the keystore.
	 * 
	 * @param alias
	 *            alias of certificate
	 * @throws CertificateStoreException
	 *             is thrown when problems occur with the CertificateStore, i.e.
	 *             illegal operations.
	 */
	public void deleteCertificate(String alias) throws CertificateStoreException {
		if (isDefaultCertificate(alias)) {
			throw new CertificateStoreException("Cannot delete default certificate!");
		} else {
			loadKeyStore();
			try {
				keyStore.deleteEntry(alias);
				storeKeyStore();
			} catch (KeyStoreException e) {
				String message = "Deleting certificate failed!";
				WorkspaceUtil.logException(message, e);
				throw new CertificateStoreException(message, e);
			}
		}
	}

	/**
	 * Adds a certificate to the KeyStore.
	 * 
	 * @param alias
	 *            alias for the certificate
	 * @param path
	 *            path to the certificate file
	 * @throws InvalidCertificateException
	 *             certificate cannot be found, accessed or identified
	 * @throws CertificateStoreException
	 *             is thrown when problems occur with the CertificateStore, i.e.
	 *             illegal operations.
	 */
	public void addCertificate(String alias, String path) throws InvalidCertificateException, CertificateStoreException {
		try {
			addCertificate(alias, new FileInputStream(path));
		} catch (FileNotFoundException e) {
			String message = "Storing certificate failed!";
			WorkspaceUtil.logException(message, e);
			throw new CertificateStoreException(message, e);
		}
	}

	/**
	 * Adds a certificate to the KeyStore.
	 * 
	 * @param alias
	 *            alias for the certificate
	 * @param certificate
	 *            inputstream delivering the certificate. Stream is used by
	 *            {@link CertificateFactory#generateCertificate(InputStream)}.
	 * @throws InvalidCertificateException
	 *             certificate cannot be found, accessed or identified
	 * @throws CertificateStoreException
	 *             is thrown when problems occur with the CertificateStore, i.e.
	 *             illegal operations
	 */
	public void addCertificate(String alias, InputStream certificate) throws InvalidCertificateException,
		CertificateStoreException {
		if (!isDefaultCertificate(alias)) {
			loadKeyStore();
			try {
				CertificateFactory factory = CertificateFactory.getInstance(CERTIFICATE_TYPE);
				Certificate newCertificate = factory.generateCertificate(certificate);
				keyStore.setCertificateEntry(alias, newCertificate);
				storeKeyStore();
			} catch (CertificateException e) {
				String message = "Please choose a valid certificate!";
				throw new InvalidCertificateException(message);
			} catch (KeyStoreException e) {
				String message = "Storing certificate failed!";
				WorkspaceUtil.logException(message, e);
				throw new CertificateStoreException(message, e);
			}
		}
	}

	private void storeKeyStore() throws CertificateStoreException {
		loadKeyStore();
		try {
			keyStore.store(new FileOutputStream(getPathToKeyStore()), KEYSTOREPASSWORD.toCharArray());
		} catch (KeyStoreException e) {
			String message = "Storing certificate failed!";
			WorkspaceUtil.logWarning(message, e);
			throw new CertificateStoreException(message, e);
		} catch (NoSuchAlgorithmException e) {
			String message = "Storing certificate failed!";
			WorkspaceUtil.logWarning(message, e);
			throw new CertificateStoreException(message, e);
		} catch (CertificateException e) {
			String message = "Storing certificate failed!";
			WorkspaceUtil.logWarning(message, e);
			throw new CertificateStoreException(message, e);
		} catch (FileNotFoundException e) {
			String message = "Storing certificate failed!";
			WorkspaceUtil.logWarning(message, e);
			throw new CertificateStoreException(message, e);
		} catch (IOException e) {
			String message = "Storing certificate failed!";
			WorkspaceUtil.logWarning(message, e);
			throw new CertificateStoreException(message, e);
		}
	}

	/**
	 * Reloads the keystore.
	 * 
	 * @throws CertificateStoreException
	 *             in case of failure
	 */
	public void reloadKeyStore() throws CertificateStoreException {
		keyStore = null;
		loadKeyStore();
	}

	private void loadKeyStore() throws CertificateStoreException {
		if (keyStore == null) {
			try {
				keyStore = KeyStore.getInstance("JKS");
				keyStore.load(new FileInputStream(getPathToKeyStore()), KEYSTOREPASSWORD.toCharArray());
			} catch (KeyStoreException e) {
				String message = "Loading certificate failed!";
				WorkspaceUtil.logWarning(message, e);
				throw new CertificateStoreException(message, e);
			} catch (NoSuchAlgorithmException e) {
				String message = "Loading certificate failed!";
				WorkspaceUtil.logWarning(message, e);
				throw new CertificateStoreException(message, e);
			} catch (CertificateException e) {
				String message = "Loading certificate failed!";
				WorkspaceUtil.logWarning(message, e);
				throw new CertificateStoreException(message, e);
			} catch (FileNotFoundException e) {
				String message = "Loading certificate failed!";
				WorkspaceUtil.logWarning(message, e);
				throw new CertificateStoreException(message, e);
			} catch (IOException e) {
				String message = "Loading certificate failed!";
				WorkspaceUtil.logWarning(message, e);
				throw new CertificateStoreException(message, e);
			}
		}
	}

	/**
	 * Returns a SSL Context. This is need for encryption, used by the
	 * SSLSocketFactory.
	 * 
	 * @return SSL Context
	 * @throws CertificateStoreException
	 *             in case of failure retrieving the context
	 */
	public SSLContext getSSLContext() throws CertificateStoreException {
		try {
			loadKeyStore();
			KeyManagerFactory managerFactory = KeyManagerFactory.getInstance("SunX509");
			managerFactory.init(keyStore, KEYSTOREPASSWORD.toCharArray());
			TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
			trustManagerFactory.init(keyStore);
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(managerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});

			return sslContext;
		} catch (NoSuchAlgorithmException e) {
			throw new CertificateStoreException("Loading certificate failed!", e);
		} catch (UnrecoverableKeyException e) {
			throw new CertificateStoreException("Loading certificate failed!", e);
		} catch (KeyStoreException e) {
			throw new CertificateStoreException("Loading certificate failed!", e);
		} catch (KeyManagementException e) {
			throw new CertificateStoreException("Loading certificate failed!", e);
		}
	}

	/**
	 * True if a KeyStore file exists.
	 * 
	 * @return boolean
	 */
	public boolean keyStoreExists() {
		File keyStore = new File(getPathToKeyStore());
		return keyStore.exists();
	}

	/**
	 * Returns the path to the KeyStore.
	 * 
	 * @return a path
	 */
	public String getPathToKeyStore() {
		return Configuration.getWorkspaceDirectory() + KEYSTORENAME;
	}

	/**
	 * Encrypts a password.
	 * 
	 * @param password
	 *            String
	 * @param serverInfo
	 *            ServerInfo
	 * @return String
	 */
	public String encrypt(String password, ServerInfo serverInfo) {
		try {
			Certificate publicKey = getCertificateForEncryption(serverInfo);
			PublicKey key = publicKey.getPublicKey();
			byte[] inpBytes;
			inpBytes = password.getBytes();
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptededByteAr = cipher.doFinal(inpBytes);
			byte[] base64EncodedByteAr = Base64.encodeBase64(encryptededByteAr);
			return new String(base64EncodedByteAr);
			// TODO: OW When new login proxy object with encryption handler is
			// implemented, handle exceptions
		} catch (NoSuchAlgorithmException e) {
			// nothing to do
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// nothing to do
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// nothing to do
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// nothing to do
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// nothing to do
			e.printStackTrace();
		} catch (CertificateStoreException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		WorkspaceUtil.logException("Couldn't encrypt password.", new CertificateStoreException(
			"Couldn't encrypt password."));
		return "";
	}

	private Certificate getCertificateForEncryption(ServerInfo serverInfo) throws CertificateStoreException {
		if (serverInfo == null) {
			throw new CertificateStoreException("Server info is null.");
		}
		Certificate publicKey = getCertificate(serverInfo.getCertificateAlias());
		if (publicKey == null) {
			publicKey = getCertificate(getDefaultCertificate());
			if (publicKey == null) {
				throw new CertificateStoreException("Unable to get certificate for password encryption.");
			}
		}
		return publicKey;
	}

	/**
	 * Test whether a given alias is the default certificate alias.
	 * 
	 * @param alias
	 *            alias under test
	 * @return true if default, false else
	 */
	public boolean isDefaultCertificate(String alias) {
		return getDefaultCertificate().equals(alias);
	}

	/**
	 * Returns the default certificate alias.
	 * 
	 * @return alias
	 */
	public String getDefaultCertificate() {
		if (defaultCertificate != null) {
			return defaultCertificate;
		} else if (Configuration.isDeveloperVersion()) {
			return DEFAULT_CERTIFICATE;
		} else {
			return DEFAULT_CERTIFICATE;
		}
	}

	/**
	 * Returns true if the given alias maps to an existing certificate.
	 * 
	 * @param alias
	 *            Certificate alias
	 * @return boolean
	 * @throws CertificateStoreException
	 *             is thrown when problems occur with the CertificateStore, i.e.
	 *             illegal operations.
	 */
	public boolean contains(String alias) throws CertificateStoreException {
		if (getCertificate(alias) == null) {
			return false;
		}
		return true;
	}

	/**
	 * Sets the alias for the default certificate.
	 * 
	 * @param defaultCertificate
	 *            certificate alias, use null to unset
	 */
	public void setDefaultCertificate(String defaultCertificate) {
		this.defaultCertificate = defaultCertificate;
	}

	/**
	 * Returns the certificate mapped by the given alias. Returns null if no
	 * such certificate exists.
	 * 
	 * @param alias
	 *            String
	 * @return Certificate
	 * @throws CertificateStoreException
	 *             is thrown when problems occur with the CertificateStore, i.e.
	 *             illegal operations.
	 */
	public Certificate getCertificate(String alias) throws CertificateStoreException {
		if (alias == null) {
			return null;
		}
		loadKeyStore();
		try {
			return keyStore.getCertificate(alias);
		} catch (KeyStoreException e) {
			throw new CertificateStoreException("Loading certificate failed!");
		}
	}

	/**
	 * Checks whether a certificate for a given alias exists.
	 * 
	 * @param alias
	 *            to check
	 * @return true if exists
	 * @throws CertificateStoreException
	 *             in case of failure
	 */
	public boolean certificateExists(String alias) throws CertificateStoreException {
		try {
			return getCertificate(alias) != null;
		} catch (CertificateStoreException e) {
			if (!(e.getCause() instanceof FileNotFoundException)) {
				throw e;
			}
		}
		return false;
	}
}
