/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.workpackagetransfer;

import java.util.List;

import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author mkagel This final class contains the utility method for moving the WorkItems from one WorkPackage to another.
 */
public final class WorkItemTransferOperator {

	private WorkItemTransferOperator() {
	};

	/**
	 * Static Method which moves the WorkItems from the source-WorkPackage to the target-WorkPackage.
	 * 
	 * @param selectedWorkItems List of workItems which should be moved from source to target
	 * @param targetWorkPackage here the workItems should be moved to
	 * @param sourceWorkPackage from here the workItems come from
	 */
	public static void moveWorkItems(List<WorkItem> selectedWorkItems, WorkPackage targetWorkPackage,
		WorkPackage sourceWorkPackage) {

		final Project project = ModelUtil.getProject(targetWorkPackage);
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(project);
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());

		try {
			progressDialog.open();
			progressDialog.getProgressMonitor().beginTask("Move workitems...", 100);

			CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();

			for (WorkItem selectedWorkItem : selectedWorkItems) {
				// Don't move the source-WorkPackage itself
				if (selectedWorkItem instanceof WorkPackage
					&& ((WorkPackage) selectedWorkItem).equals(sourceWorkPackage)) {
					// do nothing
					continue;
				}

				// Don't move WorkItems when their parent-WorkPackages also selected for moving because here moving of
				// the containing-WorkPackages implied the moving of the WorkItem
				// AND the containing WorkPackage of the WorkItem isn't the source-WorkPackage because the
				// sourceWorkPackage won't be moved, so the former rule doesn't work
				else if (selectedWorkItems.contains(selectedWorkItem.getContainingWorkpackage())
					&& !selectedWorkItem.getContainingWorkpackage().equals(sourceWorkPackage)) {
					// do nothing
					continue;
				}
				// all other WorkItems move
				else {
					targetWorkPackage.getContainedWorkItems().add(selectedWorkItem);
				}

				progressDialog.getProgressMonitor().worked(10);
			}

			try {
				operationHandle.end("Move WorkItems", "Move " + selectedWorkItems.size() + " WorkItems to WorkPackage "
					+ targetWorkPackage.getName(), ModelUtil.getProject(targetWorkPackage).getModelElementId(
					targetWorkPackage));
			} catch (InvalidHandleException e) {
				WorkspaceUtil.logException("Composite Operation failed!", e);
			}
		} finally {
			progressDialog.getProgressMonitor().done();
			progressDialog.close();
		}
	}

}
