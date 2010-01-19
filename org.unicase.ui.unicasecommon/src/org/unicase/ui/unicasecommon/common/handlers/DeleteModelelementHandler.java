/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.document.Section;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.UiUtil;
import org.unicase.ui.meeditor.commands.DeleteModelElementCommand;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;

/**
 * . This is the Handler to delete a ModelElement
 * 
 * @author Helming
 */
public class DeleteModelelementHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ModelElement me = ActionHelper.getModelElement(event);
		if (me == null) {
			return null;
		}

		// if it is a section check if user has administrative rights
		if (me instanceof Section) {
			ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(me);
			Usersession userSession = projectSpace.getUsersession();
			if (!UiUtil.isProjectAdmin(userSession, projectSpace)) {
				MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Access denied",
					"You must have administrative rights on this project to delete a section!");

				return null;
			}
		}

		deleteModelElement(me);

		return null;
	}

	private void deleteModelElement(final ModelElement me) {
		new DeleteModelElementCommand(me).run();
	}

}
