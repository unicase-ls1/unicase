/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.ui.util.ActionHelper;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFileProjectImpl;

/**
 * Handler for delete project menu item.
 * 
 * @author maierma, kraftm
 */
public class DeleteProjectHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final XMIECPFileProjectImpl project = ActionHelper.getEventElementByClass(event, XMIECPFileProjectImpl.class);
		if (project == null) {
			new XMIWorkspaceException("Event not associated with XMI-Project.");
			return null;
		}
		
		//TODO Implement a window that says something like: Do you really want to delete the project?
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				XMIECPWorkspace ws = (XMIECPWorkspace) project.getWorkspace();
				ws.removeProject(project);
			}
		}.run();
		return null;
	}
}
