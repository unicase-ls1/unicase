/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Track a set of dirty resources for saving.
 * 
 * @author koegel
 */
public class DirtyResourceSet {

	private Set<Resource> resources;

	/**
	 * Constructor.
	 */
	public DirtyResourceSet() {
		resources = new HashSet<Resource>();
	}

	/**
	 * Add a new dirty resource.
	 * 
	 * @param resource the resource
	 */
	public void addDirtyResource(Resource resource) {
		resources.add(resource);
	}

	/**
	 * Save all dirty resources in this set.
	 */
	public void save() {
		for (Resource resource : resources) {
			try {
				resource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				String message = "Save failed on a resource of the workspace failed!";
				WorkspaceUtil.logWarning(message, e);
			}
		}
		resources.clear();
	}

	public void saveWithProject(Project project) {
		for (Resource resource : resources) {
			try {
				if (resource instanceof XMIResource) {
					XMIResource xmiResource = (XMIResource) resource;
					for (Map.Entry<EObject, ModelElementId> e : project.getEobjectsIdMap()) {
						xmiResource.setID(e.getKey(), e.getValue().getId());
					}
					// remove project's own id map
					project.getEobjectsIdMap().clear();
					// TreeIterator<EObject> it = resource.getAllContents();
					// while (it.hasNext()) {
					// EObject o = it.next();

					// }
				}
				resource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				String message = "Save failed on a resource of the workspace failed!";
				WorkspaceUtil.logWarning(message, e);
			}
		}
		resources.clear();
	}
}
