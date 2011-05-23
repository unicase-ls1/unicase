/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Abstract base class for all command handlers which run on Eclipse resources.
 * Provides convenience methods for retrieving the set of selected projects
 * quickly.
 * 
 * @author jfinis
 * 
 */
public abstract class ResourceCommandHandler extends AbstractHandler {

	/**
	 * Retrieves the selected projects.
	 * 
	 * @param event execution event
	 * @return selected projects
	 */
	protected IProject[] getSelectedProjects(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		// Get the selected resource
		if (selection.isEmpty() || !(selection instanceof StructuredSelection)) {
			return new IProject[0];
		}
		StructuredSelection struct = (StructuredSelection) selection;
		Object[] select = struct.toArray();
		IProject[] resources = getProjects(select);
		return resources;
	}

	/**
	 * Returns the list of resources contained in the given elements.
	 * 
	 * @param elements
	 * @return the list of resources contained in the given elements.
	 */
	private static IProject[] getProjects(Object[] elements) {
		List<IResource> resources = new ArrayList<IResource>();
		for (int i = 0; i < elements.length; i++) {
			Object element = elements[i];
			if (element instanceof IAdaptable) {
				IProject r = (IProject) ((IAdaptable) element).getAdapter(IProject.class);
				if (r != null) {
					resources.add(r);
				}
			}
		}
		return (IProject[]) resources.toArray(new IProject[resources.size()]);
	}
}
