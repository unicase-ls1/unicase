/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.ui.common.util.UiUtil;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Handles the export of ModelElements from a project.
 */
public class ExportModelHandler extends AbstractHandler {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "Unicase Project Files (*.ucm)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ucm", "*.*" };

	private static final String EXPORT_MODEL_PATH = "org.unicase.workspace.ui.exportModelPath";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final List<ModelElement> exportModelElements = getSelfContainedModelElementTree(event);

		if (exportModelElements.size() > 0) {

			String filePath = getFilePathByFileDialog(UiUtil.getNameForModelElement(exportModelElements.get(0)));

			if (filePath == null) {
				return null;
			}

			PreferenceHelper.setPreference(EXPORT_MODEL_PATH, new File(filePath).getParent());

			runCommand(exportModelElements, filePath);

		}

		return null;
	}

	private void runCommand(final List<ModelElement> exportModelElements, String filePath) {
		final File file = new File(filePath);

		final URI uri = URI.createFileURI(filePath);

		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask("Export modelelement...", 100);
					progressDialog.getProgressMonitor().worked(10);
					ModelUtil.saveObjectToResource(exportModelElements, uri);
					MessageDialog.openInformation(null, "Export", "Exported modelelement to file " + file.getName());
				} catch (IOException e) {
					DialogHandler.showExceptionDialog(e);
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
			}
		}.run();
	}

	private List<ModelElement> getSelfContainedModelElementTree(ExecutionEvent event) {
		List<ModelElement> result = new ArrayList<ModelElement>();

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection strucSel = null;
		ModelElement copyModelElement = null;

		if (selection != null && selection instanceof IStructuredSelection) {
			strucSel = (IStructuredSelection) selection;
			Object firstElement = strucSel.getFirstElement();
			if (firstElement instanceof ModelElement) {

				copyModelElement = ModelUtil.copy((ModelElement) firstElement);

				// only export the rootnode makes xml with references, otherwise (see (commented) line two) the children
				// will be "real" nested as containments of the node (is not necessary)
				result.add(copyModelElement);
				// result.addAll(copyModelElement.getAllContainedModelElements());

			} else {
				// do nothing System.out.println("NOT A MODELELEMENT");
			}
		}

		return result;
	}

	private String getFilePathByFileDialog(String modelElementName) {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFilterNames(FILTER_NAMES);
		dialog.setFilterExtensions(FILTER_EXTS);
		String initialPath = PreferenceHelper.getPreference(EXPORT_MODEL_PATH, System.getProperty("user.home"));
		dialog.setFilterPath(initialPath);
		dialog.setOverwrite(true);

		try {
			// String initialFileName = projectSpace.getProjectName() + "@"
			// + projectSpace.getBaseVersion().getIdentifier() + ".ucp";
			String initialFileName = "ModelElement_" + modelElementName + ".ucm";
			dialog.setFileName(initialFileName);

		} catch (NullPointerException e) {
			// do nothing
		}

		String filePath = dialog.open();

		return filePath;
	}

}
