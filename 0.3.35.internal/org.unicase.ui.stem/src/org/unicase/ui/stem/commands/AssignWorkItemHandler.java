/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.views.statusview.StatusView;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * This is handler for assign work item to users on user tab of status view.
 * 
 * @author Hodaie
 */
public abstract class AssignWorkItemHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ModelElement me = ActionHelper.getModelElement(event);
		if (!(me instanceof OrgUnit)) {
			return null;
		}

		final OrgUnit user = (OrgUnit) me;
		final StatusView statusView = (StatusView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
			.getActivePart();
		final ModelElement currentOpenME = statusView.getCurrentInput();

		final Project project = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace()
			.getProject();

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				WorkItem workItem = assignWorkItem(currentOpenME, user, project);
				ActionHelper.openModelElement(workItem, statusView.getSite().getId());
			}
		}.run();

		return null;
	}

	/**
	 * This will be implemented by sub-classes.
	 * 
	 * @param project current project
	 * @param user assignee
	 * @param currentOpenME model element currently open in status view
	 * @return newly created work item
	 */
	protected abstract WorkItem assignWorkItem(ModelElement currentOpenME, OrgUnit user, Project project);
}
