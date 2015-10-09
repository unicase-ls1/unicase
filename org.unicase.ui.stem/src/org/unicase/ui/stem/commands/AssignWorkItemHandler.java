/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.stem.views.statusview.StatusView;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * users on user tab of status view.
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

		UnicaseModelElement me = UnicaseActionHelper.getModelElement(event);
		if (!(me instanceof OrgUnit)) {
			return null;
		}

		final OrgUnit user = (OrgUnit) me;
		final StatusView statusView = (StatusView) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActivePart();
		final UnicaseModelElement currentOpenME = statusView.getCurrentInput();

		final Project project = ModelUtil.getProject(currentOpenME);

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				WorkItem workItem = assignWorkItem(currentOpenME, user, project);
				UnicaseActionHelper.openModelElement(workItem, statusView
						.getSite().getId());
			}
		}.run();

		return null;
	}

	/**
	 * This will be implemented by sub-classes.
	 * 
	 * @param project
	 *            current project
	 * @param user
	 *            assignee
	 * @param currentOpenME
	 *            model element currently open in status view
	 * @return newly created work item
	 */
	protected abstract WorkItem assignWorkItem(
			UnicaseModelElement currentOpenME, OrgUnit user, Project project);
}
