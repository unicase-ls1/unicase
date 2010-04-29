/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.connectionmanager;

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
import org.unicase.metamodel.util.FileUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.exceptions.CertificateStoreException;
import org.unicase.workspace.exceptions.InvalidCertificateException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * The KeyStoreManager manages the client's KeyStore in which the SSL certificates for multiple unicase server can be
 * stored.
 * 
 * @author Wesendonk
 */

public final class KeyStoreManager {

	private static KeyStoreManager instance;

	private static final String KEYSTORENAME = "unicaseClient.keystore";

	private static final String KEYSTOREPASSWORD = "jsFTga3rGTR833329GFQEfas";

	private static final String CERTIFICATE_TYPE = "X.509";

	private static final String CIPHER_ALGORITHM = "RSA";

	private static final String DEFAULT_UNICASE_CERTIFICATE = "unicase.org 2010#1";

	/**
	 * Certificate Alias for devevelopment test certificate.
	 */
	public static final String DEFAULT_DEV_CERTIFICATE = "unicase.org test test(!!!) certificate";

	private KeyStore keyStore;

	private KeyStoreManager() {
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
			// create directory ~/.unicase/ if necessary
			File unicasedir = new File(Configuration.getWorkspaceDirectory());
			if (!unicasedir.exists()) {
				unicasedir.mkdir();
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
		} else {
			try {
				// if default certificate is not contained in keystore, keystore will be deleted and recopied from the
				// plugin. This is done, because one assumes that the default key is in the plugin's keystore. It would
				// be nicer to add the default certificate to the given keystore.
				if (getCertificate(getDefaultCertificate()) == null) {
					File clientKeyTarget = new File(getPathToKeyStore());
					clientKeyTarget.delete();
					InputStream inputStream = getClass().getResourceAsStream(KEYSTORENAME);
					FileUtil.copyFile(inputStream, clientKeyTarget);
					keyStore = null;
				}
			} catch (CertificateStoreException e) {
			} catch (IOException e) {
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
	 * @throws CertificateStoreException is thrown when problems occur with the CertificateStore, i.e. illegal
	 *             operations.
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
	 * @param alias alias of certificate
	 * @throws CertificateStoreException is thrown when problems occur with the CertificateStore, i.e. illegal
	 *             operations.
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
	 * @param alias alias for the certificate
	 * @param path path to the certificate file
	 * @throws InvalidCertificateException certificate cannot be found, accessed or identified
	 * @throws CertificateStoreException is thrown when problems occur with the CertificateStore, i.e. illegal
	 *             operations.
	 */
	public void addCertificate(String alias, String path) throws InvalidCertificateException, CertificateStoreException {
		if (!isDefaultCertificate(alias)) {
			loadKeyStore();
			try {
				CertificateFactory factory = CertificateFactory.getInstance(CERTIFICATE_TYPE);
				Certificate newCertificate = factory.generateCertificate(new FileInputStream(path));
				keyStore.setCertificateEntry(alias, newCertificate);
			} catch (CertificateException e) {
				String message = "Please choose a valid certificate!";
				throw new InvalidCertificateException(message);
			} catch (KeyStoreException e) {
				String message = "Storing certificate failed!";
				WorkspaceUtil.logException(message, e);
				throw new CertificateStoreException(message, e);
			} catch (FileNotFoundException e) {
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
	 * Returns a SSL Context. This is need for encryption, used by the SSLSocketFactory.
	 * 
	 * @return SSL Context
	 * @throws CertificateStoreException in case of failure retrieving the context
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
	 * @param password String
	 * @param serverInfo ServerInfo
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
			// TODO: OW When new login proxy object with encryption handler is implemented, handle exceptions
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

	private boolean isDefaultCertificate(String alias) {
		return alias.equals(DEFAULT_DEV_CERTIFICATE) || alias.equals(DEFAULT_UNICASE_CERTIFICATE);
	}

	private String getDefaultCertificate() {
		if (Configuration.isDeveloperVersion()) {
			return DEFAULT_DEV_CERTIFICATE;
		} else {
			return DEFAULT_UNICASE_CERTIFICATE;
		}
	}

	/**
	 * Returns true if the given alias maps to an existing certificate.
	 * 
	 * @param alias Certificate alias
	 * @return boolean
	 * @throws CertificateStoreException is thrown when problems occur with the CertificateStore, i.e. illegal
	 *             operations.
	 */
	public boolean contains(String alias) throws CertificateStoreException {
		if (getCertificate(alias) == null) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the certificate mapped by the given alias. Returns null if no such certificate exists.
	 * 
	 * @param alias String
	 * @return Certificate
	 * @throws CertificateStoreException is thrown when problems occur with the CertificateStore, i.e. illegal
	 *             operations.
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
}
