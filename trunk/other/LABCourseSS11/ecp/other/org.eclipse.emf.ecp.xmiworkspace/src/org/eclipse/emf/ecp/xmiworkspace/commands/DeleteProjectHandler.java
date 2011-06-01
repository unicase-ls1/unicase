/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.emf.ecp.xmiworkspace.exceptions.XMIWorkspaceException;
import org.eclipse.emf.ecp.xmiworkspace.structure.impl.XMIECPFileProjectImpl;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Handler for delete project menu item.
 * @author maierma, kraftm
 */
public class DeleteProjectHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final XMIECPFileProjectImpl project = UiUtil.getEventElementByClass(event, XMIECPFileProjectImpl.class);
		if (project == null) {
			new XMIWorkspaceException("Event not associated with XMI-Project.");
			return null;
		}
		
		// Do you really want to delete the project?
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Do you really want to delete the \"");
		stringBuilder.append(project.getProjectName());
		stringBuilder.append("\"-project?");
		String message = stringBuilder.toString();
		
		MessageDialog dialog = new MessageDialog(null, "Confirmation", null, message, MessageDialog.QUESTION,
			new String[] { "Yes", "No" }, 0);
		int result = dialog.open();
		
		// check whether the user clicked "yes", otherwise do nothing
		if(result == 0) {
			final ECPWorkspace ws = project.getWorkspace();
			new ECPCommand(ws) {
				@Override
				protected void doRun() {
					// takes care of project removal
					project.projectDeleted();
					ws.getProjects().remove(project);
				}
			}.run(false);
		}
		return null;
	}
}
