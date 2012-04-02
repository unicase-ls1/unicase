/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.changetracking.exceptions.MisuseException;

/**
 * Abstract base class for all command handlers which run on Eclipse resources.
 * Provides convenience methods for retrieving the set of selected projects
 * quickly.
 * 
 * @author jfinis
 * 
 */
public abstract class ResourceCommandHandler extends ChangeTrackingCommandHandler {

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
					
					//Allow only open projects!
					if(!r.isOpen()){
						throw new MisuseException("Cannot perform selected action on a closed project");
					}
					resources.add(r);
				}
			}
		}
		return (IProject[]) resources.toArray(new IProject[resources.size()]);
	}
}
