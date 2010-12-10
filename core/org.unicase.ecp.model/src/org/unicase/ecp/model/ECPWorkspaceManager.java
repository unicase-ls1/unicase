/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecp.model;

import java.lang.reflect.Method;

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
public final class ECPWorkspaceManager {

	private static ECPWorkspaceManager instance;
	private static ObserverBus observerBus;
	private ECPWorkspace currentWorkspace;

	/**
	 * Singleton Pattern.
	 * 
	 * @return the instance
	 */
	public static ECPWorkspaceManager getInstance() {
		if (instance == null) {
			instance = new ECPWorkspaceManager();
			instance.init();
			instance.notifyECPPostWorkspaceInitiators();
		}
		return instance;
	}

	private void init() {
		IConfigurationElement[] confs = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"org.unicase.ecp.model.ecpWorkspaceProvider");
		if (confs.length > 1) {
			Exception exception = new IllegalStateException(
					"Duplicate Workspace registered");
			Activator.getDefault().logException(exception.getMessage(),
					exception);
		}
		if (confs.length < 1) {
			Exception exception = new IllegalStateException(
					"No Workspace registered");
			Activator.getDefault().logException(exception.getMessage(),
					exception);
		}
		try {
			currentWorkspace = ((ECPWorkspaceProvider) confs[0]
					.createExecutableExtension("class")).getECPWorkspace();
		} catch (CoreException e) {
			Activator.getDefault().logException(e.getMessage(), e);
		}
		initObserverBus();
	}

	private void initObserverBus() {
		// TODO make more general
		if ("org.unicase.ecpemfstorebridge.EMFECPWorkspace"
				.equals(currentWorkspace.getClass().getName())) {
			try {
				Method method = currentWorkspace.getClass().getMethod(
						"getObserverBus");
				Object invoke = method.invoke(currentWorkspace);
				if (invoke instanceof ObserverBus) {
					observerBus = (ObserverBus) invoke;
				}
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (Exception e) {
				// fail silently
			}
			// END SUPRESS CATCH EXCEPTION
		}
		if (observerBus == null) {
			observerBus = new ObserverBus();
		}
	}

	private ECPWorkspaceManager() {
	}

	/**
	 * Returns the registered workspace.
	 * 
	 * @return workspace
	 * @throws NoWorkspaceException
	 *             if there is no workspace
	 */
	public ECPWorkspace getWorkSpace() throws NoWorkspaceException {
		if (currentWorkspace == null) {
			throw new NoWorkspaceException();
		}
		return currentWorkspace;
	}

	@SuppressWarnings("static-access")
	public static ObserverBus getObserverBus() {
		return getInstance().observerBus;
	}

	private void notifyECPPostWorkspaceInitiators() {
		IConfigurationElement[] workspaceObservers = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						"org.unicase.ecp.model.postinit");
		for (IConfigurationElement element : workspaceObservers) {
			try {
				PostECPWorkspaceInitiator workspaceObserver = (PostECPWorkspaceInitiator) element
						.createExecutableExtension("class");
				workspaceObserver.workspaceInitComplete(currentWorkspace);
			} catch (CoreException e) {
				Activator.getDefault().logException(e.getMessage(), e);
			}
		}
	}

}
