/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.ganttview.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.ganttview.views.GanttView;
import org.unicase.workspace.WorkspaceManager;

public class ShowGanttViewHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		Object obj = ActionHelper.getModelElement(event);

		try {
			GanttView ganttView = (GanttView) page.showView(GanttView.ID);

			// if obj == null, Project was selected
			if (obj == null) {
				ganttView.setInput(WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace()
					.getProject());
			} else if (obj instanceof WorkPackage) {
				ganttView.setInput((WorkPackage) obj);
			}
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}

		return null;

	}

}
