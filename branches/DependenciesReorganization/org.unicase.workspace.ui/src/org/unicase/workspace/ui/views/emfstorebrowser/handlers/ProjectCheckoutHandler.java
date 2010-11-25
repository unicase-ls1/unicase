/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.util.ActionHelper;
import org.unicase.util.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.ui.views.emfstorebrowser.views.ESBrowserView;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Handler for a project checkout.
 * 
 * @author Shterev
 */
public class ProjectCheckoutHandler extends AbstractHandler {

	private ProjectInfo projectInfo;

	private ServerInfo serverInfo;

	/**
	 * Command for checkout.
	 * 
	 * @author koegel
	 */
	private final class CheckoutCommand extends UnicaseCommand {

		@Override
		protected void doRun() {
			final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
			try {
				progressDialog.open();
				progressDialog.getProgressMonitor().beginTask("Checkout project...", IProgressMonitor.UNKNOWN);
				ProjectSpace projectSpace = serverInfo.getLastUsersession().checkout(projectInfo);
				WorkspaceUtil.logCheckout(projectSpace, projectSpace.getBaseVersion());
				ActionHelper.openDashboard(projectSpace);
			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				DialogHandler.showExceptionDialog(e);
				WorkspaceUtil.logWarning("RuntimeException in " + ESBrowserView.class.getName(), e);
				// END SUPRESS CATCH EXCEPTION
			} finally {
				progressDialog.getProgressMonitor().done();
				progressDialog.close();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelection selection = activeWorkbenchWindow.getSelectionService().getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		TreeNode node = (TreeNode) obj;
		projectInfo = (ProjectInfo) node.getValue();
		serverInfo = (ServerInfo) node.getParent().getValue();

		new CheckoutCommand().run();

		// open the navigator if closed
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		String viewId = "org.unicase.ui.navigator.viewer";
		try {
			page.showView(viewId);
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return null;
	}
}