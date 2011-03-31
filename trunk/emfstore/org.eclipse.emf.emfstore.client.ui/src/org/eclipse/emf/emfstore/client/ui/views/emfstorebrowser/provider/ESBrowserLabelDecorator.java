/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.provider;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.ui.Activator;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.TreeNode;

/**
 * @see ILightweightLabelDecorator
 */
public class ESBrowserLabelDecorator implements ILightweightLabelDecorator {

	/**
	 * {@inheritDoc} Decorates the label of a {@link ServerInfo} object
	 * according to its login state.
	 */
	public void decorate(Object element, IDecoration decoration) {

		if (element instanceof TreeNode) {
			TreeNode node = (TreeNode) element;
			if (node.getValue() instanceof ServerInfo) {
				ServerInfo server = (ServerInfo) node.getValue();
				if (server.getLastUsersession() != null
						&& server.getLastUsersession().isLoggedIn()) {
					decoration.addOverlay(Activator
							.getImageDescriptor("icons/bullet_green.png"),
							IDecoration.BOTTOM_RIGHT);
				} else {
					decoration.addOverlay(Activator
							.getImageDescriptor("icons/bullet_delete.png"),
							IDecoration.BOTTOM_RIGHT);
				}
			}
		}

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
