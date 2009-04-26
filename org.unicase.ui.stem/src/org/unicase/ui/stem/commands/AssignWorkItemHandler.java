/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.UnicaseUiUtil;
import org.unicase.ui.stem.views.statusview.StatusView;
import org.unicase.workspace.WorkspaceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * This is handler for assign work item to users on user tab of status view.
 * 
 * @author Hodaie
 */
public class AssignWorkItemHandler extends AbstractHandler {

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
		StatusView statusView = (StatusView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
			.getActivePart();
		final ModelElement currentOpenME = statusView.getCurrentInput();

		Project project = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject();
		EClass workItemEClass = TaskPackage.eINSTANCE.getWorkItem();
		Object[] objs = UnicaseUiUtil.showMESelectionDialog(Display.getCurrent().getActiveShell(), workItemEClass,
			project, true);
		final List<WorkItem> workItems = new ArrayList<WorkItem>();
		for (int i = 0; i < objs.length; i++) {
			if (objs[i] instanceof WorkItem) {
				workItems.add((WorkItem) objs[i]);
			}
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				for (WorkItem workItem : workItems) {
					if (currentOpenME instanceof WorkPackage) {
						((WorkPackage) currentOpenME).getContainedWorkItems().add(workItem);
					}
					workItem.setAssignee(user);
				}

			}

		});

		return null;
	}
}
