/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workspace.ProjectSpace;

/**
 * Abstract handler class for all handlers dealing with a project space.
 * 
 * @author koegel
 */
public abstract class ProjectActionHandler extends AbstractHandler {

	/**
	 * Default constructor.
	 */
	public ProjectActionHandler() {
		super();
	}

	// ZH: consolidate with Action Helper
	/**
	 * Get the project space from the event.
	 * 
	 * @param event the event
	 * @return the project space
	 */
	protected ProjectSpace getProjectSpace(ExecutionEvent event) {

		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection structuredSelection = (IStructuredSelection) sel;
		if (structuredSelection.isEmpty()) {
			return null;
		}

		Object selectedElement = structuredSelection.getFirstElement();
		if (!(selectedElement instanceof ProjectSpace)) {
			return null;
		}
		return (ProjectSpace) selectedElement;
	}

}