/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.util;

import static org.eclipse.emf.emfstore.client.model.Configuration.isInternalReleaseVersion;
import static org.eclipse.emf.emfstore.client.model.Configuration.isReleaseVersion;
import static org.eclipse.emf.emfstore.client.model.Configuration.isTesting;

import org.eclipse.emf.emfstore.server.DefaultServerWorkspaceLocationProvider;
import org.eclipse.emf.emfstore.server.LocationProvider;

/**
 * This is the default workspace location provider. If no other location provider is registered, this provider is used.
 * The default location provider offers profiles, which allows to have multiple workspaces within one root folder.
 * Allowing this isn't mandatory. It is encouraged to subclass this class when implementing an own location provider,
 * since it offers convenience methods. By convention, every path should end with an folder separator char.
 * 
 * @author wesendon
 */
public class DefaultWorkspaceLocationProvider extends DefaultServerWorkspaceLocationProvider implements
	LocationProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.DefaultServerWorkspaceLocationProvider#getRootDirectory()
	 */
	@Override
	protected String getRootDirectory() {
		return addFolders(getUserHome(), ".emfstore", "client");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.DefaultServerWorkspaceLocationProvider#getSelectedProfile()
	 */
	@Override
	protected String getSelectedProfile() {
		String parameter = getStartParameter("-profile");
		if (parameter == null) {
			parameter = "default";
			if (isTesting()) {
				parameter += "_test";
			} else if (!isReleaseVersion()) {
				if (isInternalReleaseVersion()) {
					parameter += "_internal";
				} else {
					parameter += "_dev";
				}
			}
		}
		return parameter;
	}
}
