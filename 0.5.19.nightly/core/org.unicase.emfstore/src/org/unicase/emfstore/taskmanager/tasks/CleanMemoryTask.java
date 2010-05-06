/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.taskmanager.tasks;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.unicase.emfstore.core.MonitorProvider;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
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

	private static final long PERIOD = 60 * 1000;

	private static final boolean LOGUNLOADING = false;

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
			boolean unloadedSomething = false;
			// LOGGER.info("checking whether projectstates have to be unloaded.");
			ResourceSet resourceSet = serverSpace.eResource().getResourceSet();
			EList<Resource> resources = resourceSet.getResources();
			for (int i = 0; i < resources.size(); i++) {
				Resource res = resources.get(i);
				if (res.isLoaded()) {

					// unload projecstates except current
					Project project = getElement(res, Project.class);
					if (project != null) {
						Version version = getParent(project, Version.class);
						if (version != null && version.getNextVersion() != null) {
							log("unloading: " + project);
							unload(res);
							unloadedSomething = true;
						}
					}

					// unload changepackages except last 25
					int keep = 25;
					ChangePackage cp = getElement(res, ChangePackage.class);
					if (cp != null) {
						Version version = getParent(cp, Version.class);
						ProjectHistory history = getParent(version, ProjectHistory.class);
						if (version != null && history != null
							&& version.getPrimarySpec().getIdentifier() > (history.getVersions().size() - keep)) {
							log("unloading: " + cp);
							unload(res);
							unloadedSomething = true;
						}
					}
				}
			}
			if (unloadedSomething) {
				System.gc();
			}
		}
	}

	private void log(String str) {
		if (LOGUNLOADING) {
			ModelUtil.logInfo(str);
		}
	}

	@SuppressWarnings("unchecked")
	private <T> T getElement(Resource res, Class<T> clazz) {
		if (res.getContents().size() == 1 && clazz.isInstance(res.getContents().get(0))) {
			return (T) res.getContents().get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private <T> T getParent(EObject obj, Class<T> clazz) {
		if (obj != null && obj.eContainer() != null && clazz.isInstance(obj.eContainer())) {
			return (T) obj.eContainer();
		}
		return null;
	}

	private void unload(Resource res) {
		// sanity check: this check is specific to our 1 element per resource structure for projects and changepackages
		if (res.getContents().size() != 1) {
			return;
		}
		EObject eObject = res.getContents().get(0);

		// unload to proxify
		res.unload();

		// sanity check
		if (!eObject.eIsProxy()) {
			ModelUtil.logWarning("Couldn't unload: " + eObject);
			return;
		}

		// unset all contained childs.
		for (EReference child : eObject.eClass().getEAllContainments()) {
			eObject.eUnset(child);
		}
	}
}
