/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.taskmanager.tasks;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.unicase.emfstore.core.MonitorProvider;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.taskmanager.Task;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;

/**
 * This task is used to clean the memory by proxifying the projectstates.
 * 
 * @author wesendon
 */
public class CleanMemoryTask extends Task {

	private static final long PERIOD = 1000 * 60 * 5;

	private final ServerSpace serverSpace;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace serverSpace
	 */
	public CleanMemoryTask(ServerSpace serverSpace) {
		super(new Date(System.currentTimeMillis() + PERIOD), PERIOD);
		this.serverSpace = serverSpace;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void executeTask() {
		synchronized (MonitorProvider.getInstance().getMonitor()) {
			// LOGGER.info("checking whether projectstates have to be unloaded.");
			ResourceSet resourceSet = serverSpace.eResource().getResourceSet();
			EList<Resource> resources = resourceSet.getResources();
			for (int i = 0; i < resources.size(); i++) {
				Resource res = resources.get(i);
				if (res.isLoaded()) {
					EList<EObject> contents = res.getContents();
					if (contents.size() == 1 && contents.get(0) instanceof Project) {
						Project project = (Project) contents.get(0);
						if (project.eContainer() instanceof Version
							&& ((Version) project.eContainer()).getNextVersion() != null) {
							ModelUtil.logInfo("unloading: " + project);
							res.unload();
						}
					}
				}
			}
			System.gc();
		}
	}

}
