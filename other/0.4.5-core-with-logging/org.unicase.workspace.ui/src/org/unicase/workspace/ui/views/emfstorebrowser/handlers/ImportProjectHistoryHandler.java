/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.ui.views.emfstorebrowser.handlers;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Action to import project history to server.
 * 
 * @author hodaie
 * 
 */
public class ImportProjectHistoryHandler extends AbstractHandler {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = {
			"Unicase Project History Files (*.uph)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.uph", "*.*" };

	private static final String IMPORT_PROJECT_HISTORY_PATH = "org.unicase.workspace.ui.importProjectHistoryPath";

	private Usersession usersession;

	/**
	 * {@inheritDoc}
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		ISelection selection = activeWorkbenchWindow.getSelectionService()
				.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();

		if (!(obj instanceof TreeNode)) {
			return null;
		}
		TreeNode node = (TreeNode) obj;
		ServerInfo serverInfo = ((ServerInfo) node.getParent().getValue());
		usersession = serverInfo.getLastUsersession();

		final String absoluteFileName = showOpenFileDialog();
		if (absoluteFileName == null) {
			return null;
		}

		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());

		progressDialog.open();
		progressDialog.getProgressMonitor().beginTask(
				"Import project history...", 100);
		progressDialog.getProgressMonitor().worked(10);

		ProjectHistory projectHistory = null;
		try {
			projectHistory = getProjectHistory(absoluteFileName);
			if (usersession != null && projectHistory != null) {
				WorkspaceManager.getInstance().getConnectionManager()
						.importProjectHistoryToServer(
								usersession.getSessionId(), projectHistory);
				MessageDialog.openInformation(null, "Import",
						"Imported project history from file: "
								+ absoluteFileName);
			}

		} catch (EmfStoreException e) {
			WorkspaceUtil.logException("Error importing project history.", e);
		} catch (IOException e) {
			WorkspaceUtil.logException("Error importing project history.", e);
		} finally {

			progressDialog.getProgressMonitor().done();
			progressDialog.close();
		}
		return null;

	}

	private ProjectHistory getProjectHistory(String absoluteFileName)
			throws IOException {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI
				.createFileURI(absoluteFileName), true);
		EList<EObject> directContents = resource.getContents();
		// sanity check

		if (directContents.size() != 1
				&& (!(directContents.get(0) instanceof ProjectHistory))) {
			throw new IOException(
					"File is corrupt, does not contain a ProjectHistory.");
		}

		ProjectHistory projectHistory = (ProjectHistory) directContents.get(0);
		resource.getContents().remove(projectHistory);

		return projectHistory;

	}

	private String showOpenFileDialog() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterNames(FILTER_NAMES);
		dialog.setFilterExtensions(FILTER_EXTS);
		String initialPath = PreferenceHelper.getPreference(
				IMPORT_PROJECT_HISTORY_PATH, System.getProperty("user.home"));
		dialog.setFilterPath(initialPath);
		String fn = dialog.open();
		if (fn == null) {
			return null;
		}
		PreferenceHelper.setPreference(IMPORT_PROJECT_HISTORY_PATH, dialog
				.getFilterPath());
		String fileName = dialog.getFileName();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(dialog.getFilterPath());
		if (fileName.charAt(fileName.length() - 1) != File.separatorChar) {
			stringBuilder.append(File.separatorChar);
		}

		stringBuilder.append(fileName);
		String absoluteFileName = stringBuilder.toString();
		return absoluteFileName;
	}

	/**
	 * Sets the usersession.
	 * 
	 * @param session
	 *            user session
	 */
	public void setUsersession(Usersession session) {
		this.usersession = session;
	}

}