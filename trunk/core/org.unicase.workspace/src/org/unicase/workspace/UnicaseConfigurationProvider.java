/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import static org.unicase.workspace.Configuration.isDeveloperVersion;
import static org.unicase.workspace.Configuration.isInternalReleaseVersion;
import static org.unicase.workspace.Configuration.isReleaseVersion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.unicase.metamodel.util.FileUtil;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.exceptions.CertificateStoreException;

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
	 * @see org.unicase.workspace.ConfigurationProvider#getDefaultServerInfos()
	 */
	public List<ServerInfo> getDefaultServerInfos() {
		List<ServerInfo> serverInfos = new ArrayList<ServerInfo>();

		if (isReleaseVersion()) {
			serverInfos.add(getReleaseServerInfo());
		}
		if (isInternalReleaseVersion()) {
			serverInfos.add(getInternalServerInfo());
		}
		if (isDeveloperVersion()) {
			serverInfos.add(getLocalhostServerInfo());
		}
		return serverInfos;
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

	private static ServerInfo getLocalhostServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setName("Localhost Server");
		serverInfo.setPort(8080);
		serverInfo.setUrl("localhost");

		Usersession superUsersession = WorkspaceFactory.eINSTANCE.createUsersession();
		superUsersession.setServerInfo(serverInfo);
		superUsersession.setPassword("super");
		superUsersession.setSavePassword(true);
		superUsersession.setUsername("super");
		serverInfo.setLastUsersession(superUsersession);

		return serverInfo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ConfigurationProvider#initDefaultCertificates(org.unicase.workspace.connectionmanager.KeyStoreManager)
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
