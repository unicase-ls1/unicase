/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.model;

import java.lang.reflect.Method;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPCompositeWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.util.ECPWorkspaceProvider;
import org.eclipse.emf.emfstore.common.observer.ObserverBus;

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
		currentWorkspace = new ECPCompositeWorkspace();
		initObserverBus();
	}

	private void initObserverBus() {
		// TODO make more general
		if ("org.eclipse.emf.ecp.emfstorebridge.EMFECPWorkspace".equals(currentWorkspace.getClass().getName())) {
			try {
				Method method = currentWorkspace.getClass().getMethod("getObserverBus");
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

	/**
	 * Uses the Workspace to lookup a modelement. This method delegates to {@link ECPWorkspace#getProject(EObject)}.
	 * 
	 * @param modelElement
	 *            me
	 * @return project or null
	 */
	public static ECPProject getECPProject(EObject modelElement) {
		try {
			return getInstance().getWorkSpace().getProject(modelElement);
		} catch (NoWorkspaceException e) {
			// TODO make NoWorkspaceException a runtime exception?
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("static-access")
	public static ObserverBus getObserverBus() {
		return getInstance().observerBus;
	}

	private void notifyECPPostWorkspaceInitiators() {
		IConfigurationElement[] workspaceObservers = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.ecp.model.postinit");
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
