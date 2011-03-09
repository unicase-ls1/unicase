/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard;

import java.util.List;

import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.ui.dashboard.view.DashboardEditorInput;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.PostWorkspaceInitiator;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.observers.CheckoutObserver;
import org.unicase.workspace.observers.DeleteProjectSpaceObserver;
import org.unicase.workspace.observers.UpdateObserver;

/**
 * Performs a cleanup before a project is deleted.
 * 
 * @author Shterev
 * @author wesendon
 */
public class DashboardProjectObserver implements DeleteProjectSpaceObserver, CheckoutObserver, UpdateObserver,
	PostWorkspaceInitiator {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.PostWorkspaceInitiator#workspaceInitComplete(org.unicase.workspace.Workspace)
	 */
	public void workspaceInitComplete(Workspace workspace) {
		WorkspaceManager.getObserverBus().register(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void projectDeleted(ProjectSpace projectSpace) {
		// close all open editors before deleting
		IWorkbenchPage wbpage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] editors = wbpage.getEditorReferences();
		for (IEditorReference editorReference : editors) {
			try {
				if (editorReference.getEditorInput() instanceof DashboardEditorInput) {
					DashboardEditorInput editorInput = (DashboardEditorInput) editorReference.getEditorInput();
					if (projectSpace.equals(editorInput.getProjectSpace())) {
						wbpage.closeEditor(editorReference.getEditor(false), false);
					}
				}
			} catch (PartInitException e) {
				// Just print the stacktrace
				e.printStackTrace();
			}
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CheckoutObserver#checkoutDone(org.unicase.workspace.ProjectSpace)
	 */
	public void checkoutDone(ProjectSpace projectSpace) {
		UnicaseActionHelper.openDashboard(projectSpace);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.UpdateObserver#updateCompleted(org.unicase.workspace.ProjectSpace)
	 */
	public void updateCompleted(ProjectSpace projectSpace) {
		UnicaseActionHelper.openDashboard(projectSpace);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.UpdateObserver#inspectChanges(org.unicase.workspace.ProjectSpace,
	 *      java.util.List)
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, List<ChangePackage> changePackages) {
		return true;
	}
}
