/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.provider;

import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.unicase.workspace.ServerInfo;

/**
 * @see ILightweightLabelDecorator
 */
public class ESBrowserLabelDecorator implements ILightweightLabelDecorator {

	/**
	 * {@inheritDoc} Decorates the label of a {@link ServerInfo} object according to its login state.
	 */
	public void decorate(Object element, IDecoration decoration) {

		ServerInfo server;
		if (element instanceof ServerInfo) {
			server = (ServerInfo) element;
		} else {
			return;
		}
		String suffix = "[" + server.getUrl() + "]";
		if (server.getLastUsersession() != null && server.getLastUsersession().isLoggedIn()) {
			suffix = "[" + server.getLastUsersession().getUsername() + "@" + server.getUrl() + "] logged in ";
		}
		decoration.addSuffix(suffix);

	}

	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
	}
}
