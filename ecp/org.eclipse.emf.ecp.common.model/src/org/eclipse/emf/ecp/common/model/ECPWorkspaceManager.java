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
	private ECPCompositeWorkspace currentWorkspace;

	/**
	 * Singleton Pattern.
	 * 
	 * @return the instance
	 */
	public static ECPWorkspaceManager getInstance() {
		if (instance == null) {
			instance = new ECPWorkspaceManager();
			instance.init();
		}
		return instance;
	}

	private void init() {
		currentWorkspace = new ECPCompositeWorkspace();
		currentWorkspace.notifyECPPostWorkspaceInitiators();
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
	public ECPCompositeWorkspace getWorkSpace() throws NoWorkspaceException {
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
		try {
			return getInstance().getWorkSpace().getObserverBus();
		} catch (NoWorkspaceException e) {
			// TODO make NoWorkspaceException a runtime exception?
			throw new RuntimeException(e);
		}
	}
}
