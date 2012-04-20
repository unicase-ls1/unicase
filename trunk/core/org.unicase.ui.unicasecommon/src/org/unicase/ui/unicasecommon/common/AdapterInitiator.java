/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.emfstore.client.model.PostWorkspaceInitiator;
import org.eclipse.emf.emfstore.client.model.Workspace;

/**
 * {@link PostWorkspaceInitiator} that will add a {@link ModelElementInitAdapter} to the workspace's {@link ResourceSet}
 * after it has been initialized.
 * 
 * @author mharut
 */
public class AdapterInitiator implements PostWorkspaceInitiator {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.PostWorkspaceInitiator#workspaceInitComplete(org.eclipse.emf.emfstore.client.model.Workspace)
	 */
	public void workspaceInitComplete(Workspace workspace) {
		ResourceSet resourceSet = workspace.eResource().getResourceSet();
		resourceSet.eAdapters().add(new ModelElementInitAdapter());
	}

}
