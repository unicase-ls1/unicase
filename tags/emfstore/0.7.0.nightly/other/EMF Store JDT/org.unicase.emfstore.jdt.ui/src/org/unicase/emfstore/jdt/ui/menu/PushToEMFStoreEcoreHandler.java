/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.EMFStoreUtil;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.PushToEMFStoreUtil;
import org.unicase.emfstore.jdt.exception.CannotConvertToEObjectException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.exception.ProjectInfoNotFoundException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;
import org.unicase.emfstore.jdt.ui.decorator.EMFStoreJDTEntryDecorator;
import org.unicase.emfstore.jdt.ui.dialog.SelectionDialog;
import org.unicase.emfstore.jdt.ui.editor.EditorHelper;
import org.unicase.emfstore.jdt.ui.exception.NoProjectSelectedException;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;

/**
 * The handler that pushes a file to an EMF Store. This handler is independent from the used team provider.
 * 
 * @author Adrian Staudt
 */
public class PushToEMFStoreEcoreHandler extends AbstractHandler {

	/**
	 * Pushes the file (that will be retrieved from the event) to an EMFStore. For this the target project space has to
	 * be checked out and the file has to added to that project. {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
		Object[] selectedObjects = selection.toArray();
		List<IFile> selectedFiles = new ArrayList<IFile>();
		for (Object selectedObject : selectedObjects) {
			if (selectedObject instanceof IFile) {
				IFile selectedFile = (IFile) selectedObject;
				selectedFiles.add(selectedFile);
			}
		}

		Map<IFile, List<IEditorReference>> openedEditorsForFile = new HashMap<IFile, List<IEditorReference>>();

		// check if file is opened in an editor
		for (IFile file : selectedFiles) {
			List<IEditorReference> editors = EditorHelper.getEditorFor(file);
			openedEditorsForFile.put(file, editors);

			for (IEditorReference editor : editors) {
				// check if editor is dirty
				if (editor.isDirty()) {
					MessageDialog.openError(shell, "File is opended and dirty", "The file " + file.getName()
						+ " cannot be pushed. Please save first.");
					return null;
				}
			}
		}

		// check if file is pushed
		// open dialog to let the user select the target project
		SelectionDialog dialog = new SelectionDialog(shell);
		dialog.create();

		if (dialog.open() == Window.OK) {
			ProjectInfo selectedProjectInfo;
			ServerInfo selectedServerInfo;
			try {
				selectedProjectInfo = dialog.getSelectedProjectInfo();
				selectedServerInfo = dialog.getSelectedServerInfo();

			} catch (NoProjectSelectedException e) {
				return null;
			}

			for (IFile file : selectedFiles) {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration;
				try {
					// get the configuration file
					emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file.getProject());
				} catch (NoEMFStoreJDTConfigurationException e) {
					// no configuration file exists - a configuration will be created
					emfStoreJDTConfiguration = ConfigurationManager.createConfiguration(file.getProject());
				}

				try {
					ProjectSpace projectSpace = getProject(file, emfStoreJDTConfiguration, selectedProjectInfo,
						selectedServerInfo);
					addFileToProject(file, projectSpace, emfStoreJDTConfiguration);

					// reload editors that have opened the file
					List<IEditorReference> editors = openedEditorsForFile.get(file);
					for (IEditorReference editor : editors) {
						final String editorId = editor.getId();
						EditorHelper.closeEditor(editor);
						EditorHelper.openEditor(editorId, file);
					}

					refreshUI(file);

				} catch (ProjectSpaceNotFoundException e) {
					// should not occur - write to log
					ModelUtil.logException(e);
					MessageDialog.openError(shell, "Error while retrieving an EMFStore project",
						"The selected project cannot be checked out from the EMFStore.");

				} catch (CannotConvertToEObjectException e) {
					// log exception and show user an error message
					ModelUtil.logException(e);
					MessageDialog
						.openError(
							shell,
							"Error in file",
							"The current selected file cannot be instanciated to an EObject. To get more information take a look into the error log.");
				}
			}
		}

		return null;
	}

	private ProjectSpace getProject(IFile file, EMFStoreJDTConfiguration emfStoreJDTConfiguration,
		ProjectInfo selectedProjectInfo, ServerInfo selectedServerInfo) throws ProjectSpaceNotFoundException {

		ProjectSpace projectSpace;
		try {
			projectSpace = EMFStoreUtil.getProjectSpace(selectedServerInfo, selectedProjectInfo);

		} catch (ProjectSpaceNotFoundException e) {
			// project is locally not available - check it out
			try {
				Usersession usersession = selectedServerInfo.getLastUsersession();
				projectSpace = EMFStoreUtil.checkout(usersession, selectedProjectInfo);

			} catch (ProjectInfoNotFoundException ex) {
				throw new ProjectSpaceNotFoundException();
			}
		}

		return projectSpace;
	}

	private void addFileToProject(IFile file, ProjectSpace projectSpace,
		EMFStoreJDTConfiguration emfStoreJDTConfiguration) throws CannotConvertToEObjectException {

		ModelElementId modelElementId = PushToEMFStoreUtil.push(file, projectSpace);
		ServerInfo serverInfo = projectSpace.getUsersession().getServerInfo();
		ProjectId projectId = projectSpace.getProjectId();
		PushToEMFStoreUtil.addEntry(emfStoreJDTConfiguration, file, serverInfo, projectId, modelElementId);
	}

	private void refreshUI(IFile file) {
		// refresh UI
		try {
			file.getProject().getFile(".emfstoreconf").refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
			file.getProject().refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
		} catch (CoreException e) {
			ModelUtil.logException(e);
		}

		EMFStoreJDTEntryDecorator.refreshDecorator();
	}
}
