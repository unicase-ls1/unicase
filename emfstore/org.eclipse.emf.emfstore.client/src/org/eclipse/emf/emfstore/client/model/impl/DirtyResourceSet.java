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
package org.eclipse.emf.emfstore.client.model.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;

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
	 * @param resource
	 *            the resource
	 */
	public void addDirtyResource(Resource resource) {
		resources.add(resource);
	}

	/**
	 * Save all dirty resources in this set.
	 */
	public void save() {
		for (Resource resource : resources) {
			if (resource.getURI() == null) {
				continue;
			}
			try {
				resource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				String message = "Save failed on a resource of the workspace failed!";
				WorkspaceUtil.logWarning(message, e);
			}
		}
		resources.clear();
	}
}
