/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
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
import org.eclipse.emf.emfstore.internal.client.model.ServerInfo;
import org.eclipse.emf.emfstore.internal.client.model.connectionmanager.KeyStoreManager;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreClientUtil;
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

	private static boolean isUnicaseReleaseVersion() {
		if (isInternalUnicaseReleaseVersion()) {
			return false;
		}
		Bundle unicaseBundle = Platform
				.getBundle("org.unicase.ui.unicasecommon");
		String unicaseVersionString = unicaseBundle.getHeaders().get(
				org.osgi.framework.Constants.BUNDLE_VERSION);
		return unicaseVersionString.endsWith("qualifier");
	}

	private static boolean isInternalUnicaseReleaseVersion() {
		Bundle unicaseBundle = Platform
				.getBundle("org.unicase.ui.unicasecommon");
		String unicaseVersionString = unicaseBundle.getHeaders().get(
				org.osgi.framework.Constants.BUNDLE_VERSION);
		return unicaseVersionString.endsWith("internal");
	}

	@SuppressWarnings("restriction")
	private static ESServer getInternalServerInfo() {
		ServerInfo serverInfo = EMFStoreClientUtil.createServerInfo(
				"unicase-internal2.informatik.tu-muenchen.de", 8080,
				KeyStoreManager.DEFAULT_CERTIFICATE);
		serverInfo.setName("unicase developer server");
		return serverInfo.toAPI();
	}

	private static ESServer getReleaseServerInfo() {
		ServerInfo serverInfo = EMFStoreClientUtil.createServerInfo(
				"unicase.in.tum.de", 443, KeyStoreManager.DEFAULT_CERTIFICATE);
		serverInfo.setName("unicase server");
		return serverInfo.toAPI();
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