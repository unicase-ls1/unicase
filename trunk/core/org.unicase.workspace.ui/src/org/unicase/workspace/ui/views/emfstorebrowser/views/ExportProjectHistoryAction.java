/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.ui.views.emfstorebrowser.views;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.commands.ExportProjectHandler;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Action for to export project history from server.
 * 
 * @author hodaie
 */
public class ExportProjectHistoryAction extends Action {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "Unicase Project Files (*.uph)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.uph", "*.*" };

	private Usersession usersession;
	private ProjectInfo projectInfo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		final String absoluteFileName = showSaveFileDialog();
		if (absoluteFileName == null) {
			return;
		}

		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());

		progressDialog.open();
		progressDialog.getProgressMonitor().beginTask("Export project history...", 100);
		progressDialog.getProgressMonitor().worked(10);

		ProjectHistory projectHistory = null;
		try {
			if (usersession != null) {
				projectHistory = WorkspaceManager.getInstance().getConnectionManager().exportProjectHistoryFromServer(
					usersession.getSessionId(), projectInfo.getProjectId());
				saveProjectHistory(projectHistory, absoluteFileName);

				MessageDialog.openInformation(null, "Import", "Exported project history to file: " + absoluteFileName);
			}

		} catch (EmfStoreException e) {
			WorkspaceUtil.logException("Error exporting project history.", e);
		} catch (IOException e) {
			WorkspaceUtil.logException("Error exporting project history.", e);
		} finally {

			progressDialog.getProgressMonitor().done();
			progressDialog.close();
		}

	}

	private void saveProjectHistory(ProjectHistory projectHistory, String absoluteFileName) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI(absoluteFileName));
		resource.getContents().add(projectHistory);
		resource.save(null);

	}

	private String showSaveFileDialog() {

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFilterNames(ExportProjectHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ExportProjectHandler.FILTER_EXTS);
		dialog.setOverwrite(true);
		String initialFileName = projectInfo.getName() + ".uph";
		dialog.setFileName(initialFileName);

		// dialog
		String fn = dialog.open();
		if (fn == null) {
			return null;
		}

		final File file = new File(fn);

		return file.getAbsolutePath();
	}

	/**
	 * Sets the user sesssion.
	 * 
	 * @param session user session
	 */
	public void setUsersession(Usersession session) {
		this.usersession = session;
	}

	/**
	 * Sets the project info, whose history will be exported.
	 * 
	 * @param projectInfo project info
	 */
	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;

	}
}