/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.accesscontrol.authentication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.ClientVersionOutOfDateException;
import org.unicase.emfstore.exceptions.DecryptException;

/**
 * Abstract class for authentication.
 * 
 * @author wesendonk
 */
public abstract class AbstractAuthenticationControl implements AuthenticationControl {

	private String superuser;
	private String superuserpw;
	private final Log myLogger;

	/**
	 * Default constructor.
	 */
	public AbstractAuthenticationControl() {
		superuser = ServerConfiguration.getProperties().getProperty(ServerConfiguration.SUPER_USER,
			ServerConfiguration.SUPER_USER_DEFAULT);
		superuserpw = ServerConfiguration.getProperties().getProperty(ServerConfiguration.SUPER_USER_PASSWORD,
			ServerConfiguration.SUPER_USER_PASSWORD_DEFAULT);
		myLogger = LogFactory.getLog(AbstractAuthenticationControl.class);
	}

	/**
	 * Decrypts a password .
	 * 
	 * @param encryptedPsw The encrypted password
	 * @param key PrivateKey
	 * @return the decrypted password
	 * @throws DecryptException AccessControlException
	 */
	private String deCrypt(String encryptedPsw, PrivateKey key) throws DecryptException {
		byte[] outBytes;

		try {
			outBytes = Base64.decodeBase64(encryptedPsw.getBytes());
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptedByteAr = cipher.doFinal(outBytes);
			return new String(decryptedByteAr);

		} catch (NoSuchAlgorithmException e) {
			myLogger.error("NoSuchAlgorithmException", e);
			throw new DecryptException();
		} catch (NoSuchPaddingException e) {
			myLogger.error("NoSuchPaddingException", e);
			throw new DecryptException();
		} catch (InvalidKeyException e) {
			myLogger.error("InvalidKeyException", e);
			throw new DecryptException();
		} catch (IllegalBlockSizeException e) {
			myLogger.error("IllegalBlockSizeException", e);
			throw new DecryptException();
		} catch (BadPaddingException e) {
			myLogger.error("BadPaddingException", e);
			throw new DecryptException();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public SessionId logIn(String username, String password, ClientVersionInfo clientVersionInfo)
		throws AccessControlException {
		checkClientVersion(clientVersionInfo);
		KeyStore keyStore;
		try {
			keyStore = KeyStore.getInstance("JKS");
			keyStore.load(new FileInputStream(ServerConfiguration.getServerKeyStorePath()), "av374tb$VBGGtrgwa7tosdfa"
				.toCharArray());
			PrivateKey key = (PrivateKey) keyStore.getKey("testkeygeneratedbyotto", "av374tb$VBGGtrgwa7tosdfa"
				.toCharArray());
			password = deCrypt(password, key);
		} catch (KeyStoreException e) {
			myLogger.error("KeyStoreException", e);
			throw new DecryptException();
		} catch (NoSuchAlgorithmException e) {
			myLogger.error("NoSuchAlgorithmException", e);
			throw new DecryptException();
		} catch (CertificateException e) {
			myLogger.error("CertificateException", e);
			throw new DecryptException();
		} catch (FileNotFoundException e) {
			myLogger.error("FileNotFoundException", e);
			throw new DecryptException();
		} catch (IOException e) {
			myLogger.error("IOException", e);
			throw new DecryptException();
		} catch (UnrecoverableKeyException e) {
			myLogger.error("UnrecoverableKeyException", e);
			throw new DecryptException();
		}

		if ((username.equals(superuser) && password.equals(superuserpw)) || verifyPassword(username, password)) {
			return EsmodelFactory.eINSTANCE.createSessionId();
		}
		throw new AccessControlException();
	}

	// TODO include client name in verification
	private void checkClientVersion(ClientVersionInfo clientVersionInfo) throws ClientVersionOutOfDateException {
		if (clientVersionInfo == null) {
			throw new ClientVersionOutOfDateException("No client version recieved.");
		}
		String versions = ServerConfiguration.getProperties().getProperty(ServerConfiguration.ACCEPTED_VERSIONS);
		if (versions == null) {
			if (!ServerConfiguration.isReleaseVersion()) {
				return;
			}
			throw new ClientVersionOutOfDateException("No server versions supplied");
		}
		String[] splitedVersions = versions.split(ServerConfiguration.MULTI_PROPERTY_SEPERATOR);
		for (String str : splitedVersions) {
			str = str.trim();
			if (str.equals(clientVersionInfo.getVersion()) || str.equals(ServerConfiguration.ACCEPTED_VERSIONS_ANY)) {
				return;
			}
		}
		throw new ClientVersionOutOfDateException("Client version: " + clientVersionInfo.getVersion()
			+ " - Accepted versions: " + versions);
	}

	/**
	 * This method must be implemented by subclasses in order to verify a pair of username and password. When using
	 * authentication you should use {@link AuthenticationControl#logIn(String, String)} in order to gain a session id.
	 * 
	 * @param username the username
	 * @param password the password
	 * @return boolean true if authentication was successful
	 * @throws AccessControlException an exception
	 */
	protected abstract boolean verifyPassword(String username, String password) throws AccessControlException;

}
