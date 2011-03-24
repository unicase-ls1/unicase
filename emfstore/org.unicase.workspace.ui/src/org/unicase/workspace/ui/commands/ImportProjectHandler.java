/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Workspace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.util.FileUtil;
import org.unicase.ui.util.DialogHandler;
import org.unicase.ui.util.PreferenceHelper;

/**
 * Handler for import project menu item.
 * 
 * @author helming
 */
public class ImportProjectHandler extends AbstractHandler {

	private static final String IMPORT_PROJECT_PATH = "org.unicase.workspace.ui.importProjectPath";

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "Unicase Project Files (*.ucp)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ucp", "*.*" };

	private String projectName;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final String absoluteFileName = showOpenFileDialog();

		if (absoluteFileName == null) {
			return null;
		}

		projectName = showProjectNameDialog(absoluteFileName
			.substring(absoluteFileName.lastIndexOf(File.separator) + 1));
		if (projectName == null) {
			return null;
		}

		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());

		try {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					try {
						progressDialog.open();
						progressDialog.getProgressMonitor().beginTask("Import project...", 100);
						progressDialog.getProgressMonitor().worked(10);
						Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
						ProjectSpace projectSpace = currentWorkspace.importProject(absoluteFileName);

						projectSpace.setProjectName(projectName);

					} catch (IOException e) {
						DialogHandler.showExceptionDialog(e);
					} finally {
						progressDialog.getProgressMonitor().done();
						progressDialog.close();
					}
				}
			}.run(false);
			// TODO: EM
		} catch (Throwable t) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					File projectFile = new File(absoluteFileName);
					File tempFile;
					try {
						tempFile = File.createTempFile("migrateProject", ".tmp");
						FileUtil.copyFile(projectFile, tempFile);
						WorkspaceManager.getInstance().migrate(tempFile.getAbsolutePath());
						Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
						ProjectSpace projectSpace = currentWorkspace.importProject(tempFile.getAbsolutePath());
						projectSpace.setProjectName(projectName);
					} catch (IOException e) {
						DialogHandler.showExceptionDialog(e);
					}
				}
			}.run();
		}

		MessageDialog.openInformation(null, "Import", "Imported project from file: " + absoluteFileName);
		return null;
	}

	private String showOpenFileDialog() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterNames(ImportProjectHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ImportProjectHandler.FILTER_EXTS);
		String initialPath = PreferenceHelper.getPreference(IMPORT_PROJECT_PATH, System.getProperty("user.home"));
		dialog.setFilterPath(initialPath);
		String fn = dialog.open();
		if (fn == null) {
			return null;
		}

		final File file = new File(dialog.getFilterPath(), dialog.getFileName());
		PreferenceHelper.setPreference(IMPORT_PROJECT_PATH, file.getParent());

		return file.getAbsolutePath();
	}

	/**
	 * Shows a dialog so that user can provide a name for imported project. Suggests a default name.
	 * 
	 * @param initialValue
	 * @return
	 */
	private String showProjectNameDialog(String initialValue) {

		int extensionIndex = initialValue.length();
		if (initialValue.contains(".")) {
			extensionIndex = initialValue.lastIndexOf(".");
		}
		if (initialValue.contains("@")) {
			extensionIndex = initialValue.lastIndexOf("@");
		}
		initialValue = initialValue.substring(0, extensionIndex);

		IInputValidator inputValidator = new IInputValidator() {
			public String isValid(String newText) {
				if (newText == null || newText.equals("") || newText.matches("\\s*")) {
					return "No project name provided!";
				}
				return null;
			}

		};
		InputDialog inputDialog = new InputDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
			"Project Name", "Please enter a name for the imported project:", initialValue, inputValidator);

		if (inputDialog.open() == Dialog.OK) {
			return inputDialog.getValue();
		} else {
			return null;
		}

	}

}
