/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon;

import static org.unicase.workspace.Configuration.isInternalReleaseVersion;
import static org.unicase.workspace.Configuration.isReleaseVersion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.unicase.metamodel.util.FileUtil;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.exceptions.CertificateStoreException;
import org.unicase.workspace.util.ConfigurationProvider;

/**
 * Default configuration provider for unicase. At the moment default {@link ServerInfo} can be set and certificates can
 * be initialized.
 * 
 * @author wesendon
 */
public class UnicaseConfigurationProvider implements ConfigurationProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.util.ConfigurationProvider#getDefaultServerInfos()
	 */
	public List<ServerInfo> getDefaultServerInfos() {
		List<ServerInfo> serverInfos = new ArrayList<ServerInfo>();

		if (isReleaseVersion()) {
			serverInfos.add(getReleaseServerInfo());
		}
		if (isInternalReleaseVersion()) {
			serverInfos.add(getInternalServerInfo());
		}
		return (serverInfos.size() == 0) ? null : serverInfos;
	}

	private static ServerInfo getReleaseServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setName("unicase Server");
		serverInfo.setPort(443);
		serverInfo.setUrl("unicase.in.tum.de");
		return serverInfo;
	}

	private static ServerInfo getInternalServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setName("unicase Developer Server");
		serverInfo.setPort(443);
		serverInfo.setUrl("unicase-internal.informatik.tu-muenchen.de");
		return serverInfo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.util.ConfigurationProvider#initDefaultCertificates(org.unicase.workspace.connectionmanager.KeyStoreManager)
	 */
	public void initDefaultCertificates(KeyStoreManager keyStoreManager) {
		try {
			// TODO: add certificate rather then replacing the keystore and reloading:
			// if default certificate is not contained in keystore, keystore will be deleted and recopied from the
			// plugin. This is done, because one assumes that the default key is in the plugin's keystore. It would
			// be nicer to add the default certificate to the given keystore.
			if (!keyStoreManager.certificateExists(keyStoreManager.getDefaultCertificate())) {
				File clientKeyTarget = new File(keyStoreManager.getPathToKeyStore());
				clientKeyTarget.delete();
				InputStream inputStream = getClass().getResourceAsStream(KeyStoreManager.KEYSTORENAME);
				FileUtil.copyFile(inputStream, clientKeyTarget);
				keyStoreManager.reloadKeyStore();
			}
		} catch (CertificateStoreException e) {
		} catch (IOException e) {
		}
	}
}
