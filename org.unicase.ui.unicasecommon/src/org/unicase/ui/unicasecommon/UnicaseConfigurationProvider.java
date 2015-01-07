/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfstore.client.ESServer;
import org.eclipse.emf.emfstore.client.exceptions.ESCertificateException;
import org.eclipse.emf.emfstore.client.provider.ESClientConfigurationProvider;
import org.eclipse.emf.emfstore.client.provider.ESKeyStoreManager;
import org.eclipse.emf.emfstore.internal.client.model.ModelFactory;
import org.eclipse.emf.emfstore.internal.client.model.ServerInfo;
import org.eclipse.emf.emfstore.internal.client.model.connectionmanager.KeyStoreManager;
import org.eclipse.emf.emfstore.internal.common.model.util.FileUtil;
import org.osgi.framework.Bundle;

/**
 * Default configuration provider for unicase. At the moment default
 * {@link ServerInfo} can be set and certificates can be initialized.
 * 
 * @author wesendon
 */
public class UnicaseConfigurationProvider implements
		ESClientConfigurationProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.util.ConfigurationProvider#getDefaultServerInfos()
	 */
	public List<ESServer> getDefaultServerInfos() {
		List<ESServer> serverInfos = new ArrayList<ESServer>();

		if (isUnicaseReleaseVersion()) {
			serverInfos.add(getReleaseServerInfo());
		}
		if (isInternalUnicaseReleaseVersion()) {
			serverInfos.add(getInternalServerInfo());
		}
		return (serverInfos.size() == 0) ? null : serverInfos;
	}

	private static ESServer getReleaseServerInfo() {
		ServerInfo serverInfo = ModelFactory.eINSTANCE.createServerInfo();
		serverInfo.setName("unicase Server");
		serverInfo.setPort(443);
		serverInfo.setUrl("unicase.in.tum.de");
		return (ESServer) serverInfo;
	}

	private static boolean isUnicaseReleaseVersion() {
		if (isInternalUnicaseReleaseVersion()) {
			return false;
		}
		Bundle unicaseBundle = Platform
				.getBundle("org.unicase.ui.unicasecommon");
		String unicaseVersionString = unicaseBundle.getHeaders().get(
				org.osgi.framework.Constants.BUNDLE_VERSION);
		return !unicaseVersionString.endsWith("qualifier");
	}

	private static boolean isInternalUnicaseReleaseVersion() {
		Bundle unicaseBundle = Platform
				.getBundle("org.unicase.ui.unicasecommon");
		String unicaseVersionString = unicaseBundle.getHeaders().get(
				org.osgi.framework.Constants.BUNDLE_VERSION);
		return unicaseVersionString.endsWith("internal");
	}

	private static ESServer getInternalServerInfo() {
		ServerInfo serverInfo = ModelFactory.eINSTANCE.createServerInfo();
		serverInfo.setName("unicase Developer Server");
		serverInfo.setPort(8080);
		serverInfo.setUrl("unicase-internal2.informatik.tu-muenchen.de");
		return (ESServer) serverInfo;
	}

	public void initDefaultCertificates(ESKeyStoreManager keyStoreManager) {
		try {
			if (keyStoreManager.getDefaultCertificate().equals(
					KeyStoreManager.DEFAULT_CERTIFICATE)) {
				File clientKeyTarget = new File(
						((KeyStoreManager) keyStoreManager).getPathToKeyStore());
				clientKeyTarget.delete();
				InputStream inputStream = getClass().getResourceAsStream(
						"/keystore/" + KeyStoreManager.KEYSTORENAME);
				FileUtil.copyFile(inputStream, clientKeyTarget);
				((KeyStoreManager) keyStoreManager).reloadKeyStore();
			}
		} catch (ESCertificateException e) {

		} catch (IOException e) {

		}
	}
}