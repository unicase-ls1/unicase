/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecp.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.util.ECPWorkspaceProvider;
import org.unicase.util.observer.ObserverBus;

/**
 * Class to provide access to a registered Workspace.
 * 
 * @author helming
 */
public final class WorkspaceManager {

	private static WorkspaceManager instance;
	private static ObserverBus observerBus;

	/**
	 * Singleton Pattern.
	 * 
	 * @return the instance
	 */
	public static WorkspaceManager getInstance() {
		if (instance == null) {
			instance = new WorkspaceManager();
			instance.init();
		}
		return instance;
	}

	private void init() {
		observerBus = new ObserverBus();
	}

	private ECPWorkspace workspace;

	private WorkspaceManager() {
		IConfigurationElement[] confs = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.navigator.ecpWorkspaceProvider");
		if (confs.length > 1) {
			Exception exception = new IllegalStateException("Duplicate Workspace registered");
			Activator.getDefault().logException(exception.getMessage(), exception);
		}
		if (confs.length < 1) {
			Exception exception = new IllegalStateException("No Workspace registered");
			Activator.getDefault().logException(exception.getMessage(), exception);
		}
		try {
			workspace = ((ECPWorkspaceProvider) confs[0].createExecutableExtension("class")).getECPWorkspace();
		} catch (CoreException e) {
			Activator.getDefault().logException(e.getMessage(), e);
		}
	}

	/**
	 * Returns the registered workspace.
	 * 
	 * @return workspace
	 * @throws NoWorkspaceException if there is no workspace
	 */
	public ECPWorkspace getWorkSpace() throws NoWorkspaceException {
		if (workspace == null) {
			throw new NoWorkspaceException();
		}
		return workspace;
	}
	
	@SuppressWarnings("static-access")
	public static ObserverBus getObserverBus() {
		return getInstance().observerBus;
	}

}
