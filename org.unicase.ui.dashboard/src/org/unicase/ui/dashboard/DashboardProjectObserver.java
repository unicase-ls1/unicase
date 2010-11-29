/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.ui.dashboard.view.DashboardEditorInput;
import org.unicase.util.DialogHandler;
import org.unicase.workspace.PostWorkspaceInitiator;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.observers.CheckoutObserver;
import org.unicase.workspace.observers.DeleteProjectSpaceObserver;
import org.unicase.workspace.observers.ObserverBus;
import org.unicase.workspace.observers.UpdateObserver;

/**
 * Performs a cleanup before a project is deleted.
 * 
 * @author Shterev
 * @author wesendon
 */
public class DashboardProjectObserver implements DeleteProjectSpaceObserver, CheckoutObserver, UpdateObserver,
	PostWorkspaceInitiator {

	public void workspaceInitComplete(Workspace workspace) {
		ObserverBus.register(this);
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

	public void checkoutDone(ProjectSpace projectSpace) {
		openDashboard(projectSpace);
	}

	public void updateCompleted(ProjectSpace projectSpace) {
		openDashboard(projectSpace);
	}

	/**
	 * TODO Chainsaw . The following code has been copied from ActionHelper to here and hasn't been refactored yet. This
	 * move was necessary to divide EMFStore, ECP and UNICASE.
	 */

	private static final String DASHBOARD_CONTEXT_VARIABLE = "org.unicase.ui.dashboardInput";
	private static final String DASHBOARD_COMMAND = "org.unicase.ui.dashboard.showDashboard";

	/**
	 * TODO Chainsaw . The following code has been copied from ActionHelper to here and hasn't been refactored yet. This
	 * move was necessary to divide EMFStore, ECP and UNICASE.<br>
	 * <br>
	 * Opens the dashboard for the currently selected projectspace.
	 */
	public static void openDashboard() {
		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		openDashboard(projectSpace);
	}

	/**
	 * TODO Chainsaw . The following code has been copied from ActionHelper to here and hasn't been refactored yet. This
	 * move was necessary to divide EMFStore, ECP and UNICASE. <br>
	 * <br>
	 * Opens the dashboard for the given project.
	 * 
	 * @param projectSpace the project space.
	 */
	public static void openDashboard(ProjectSpace projectSpace) {
		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

		IEvaluationContext context = handlerService.getCurrentState();
		context.addVariable(DASHBOARD_CONTEXT_VARIABLE, projectSpace);

		try {
			handlerService.executeCommand(DASHBOARD_COMMAND, null);

		} catch (ExecutionException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotDefinedException e) {
			// DialogHandler.showExceptionDialog(e);
		} catch (NotEnabledException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (NotHandledException e) {
			DialogHandler.showExceptionDialog(e);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			DialogHandler.showExceptionDialog(e);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	public boolean inspectChanges(ProjectSpace projectSpace, List<ChangePackage> changePackages) {
		return true;
	}
}
