/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.ui.menu;

import java.io.InputStream;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationManager;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreTeamProviderConfiguration;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.emfstore.PushToEMFStoreUtil;
import org.eclipse.emf.emfstore.teamprovider.exception.CannotOpenEObjectException;
import org.eclipse.emf.emfstore.teamprovider.exception.NoEMFStoreTeamProviderConfigurationException;
import org.eclipse.emf.emfstore.teamprovider.exception.ProjectSpaceNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.ui.dialog.TeamProviderModelElementSelectDialog;
import org.eclipse.emf.emfstore.teamprovider.ui.exception.NoProjectSelectedException;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * The handler that pushes a file to an EMF Store. This handler is independent from the used team provider.
 * 
 * @author Adrian Staudt
 */
public class PullFromEMFStoreEcoreHandler extends AbstractEMFStoreInteractionHandler {

	private Shell shell;

	/**
	 * Pushes the file (that will be retrieved from the event) to an EMFStore. For this the target project space has to
	 * be checked out and the file has to added to that project. {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
		IContainer selectedContainer = null;
		Object[] selectedObjects = selection.toArray();
		for (Object selectedObject : selectedObjects) {
			// The view "PackageExplorer" has the selection set to IProjectNature, whereas
			// the view "Navigator" provides directly an IContainer when selecting a project.
			// Folder are returned from both as IContainer.
			if (selectedObject instanceof IProjectNature) {
				IProjectNature iProjectNature = (IProjectNature) selectedObject;
				selectedContainer = iProjectNature.getProject();
				break;

			} else if (selectedObject instanceof IContainer) {
				selectedContainer = (IContainer) selectedObject;
				break;
			} else {
				ModelUtil.logWarning("No resource container has been provided, but a container was expected.");
				MessageDialog.openError(shell, "Error",
					"No resource container has been provided, but a container was expected.");
				return null;
			}
		}

		// open dialog to let the user select the target project
		ProjectSpace selectProjectSpace;
		try {
			selectProjectSpace = selectProject(shell);
			EObject selectEObject = selectModelElementToPull(selectProjectSpace);
			if (selectEObject != null) {
				InputDialog inputDialog = new InputDialog(shell, "File name",
					"Please enter the name of the output file.", "name.ecore", null);
				inputDialog.create();
				if (inputDialog.open() == Window.OK) {
					String fileString = inputDialog.getValue();
					IPath filePath = new Path(fileString);
					IFile file = selectedContainer.getFile(filePath);

					pullEObjectToFile(selectProjectSpace, selectEObject, file);
				}
			}

		} catch (NoProjectSelectedException e) {
			// cancel push
			return null;

		} catch (ProjectSpaceNotFoundException e) {
			// should not occur - write to log
			ModelUtil.logException(e);
			MessageDialog.openError(shell, "Error while retrieving an EMFStore project",
				"The selected project cannot be checked out from the EMFStore.");
		}

		return null;
	}

	private EObject selectModelElementToPull(ProjectSpace selectProjectSpace) {
		TeamProviderModelElementSelectDialog meSelectionDialog = new TeamProviderModelElementSelectDialog(shell, selectProjectSpace
			.getProject());
		if (meSelectionDialog.open() == Window.OK) {
			if (meSelectionDialog.getFirstResult() != null) {
				return (EObject) meSelectionDialog.getFirstResult();
			}
		}

		return null;
	}

	private void pullEObjectToFile(ProjectSpace projectSpace, EObject selectEObject, IFile file) {
		ServerInfo serverInfo = getSelectedServerInfo();
		ProjectId projectId = projectSpace.getProjectId();
		ModelElementId selectEObjectId = projectSpace.getProject().getModelElementId(selectEObject);

		EMFStoreTeamProviderConfiguration emfStoreJDTConfiguration;
		try {
			emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file.getProject());

		} catch (NoEMFStoreTeamProviderConfigurationException e) {
			emfStoreJDTConfiguration = ConfigurationManager.createConfiguration(file.getProject());
		}

		// create meta-data
		PushToEMFStoreUtil.addEntry(emfStoreJDTConfiguration, file, serverInfo, projectId, selectEObjectId);
		InputStream eObjectAsInputStream;
		try {
			eObjectAsInputStream = ProjectSpaceUtil.eObjectAsInputStream(selectEObject);
			if (file.exists()) {
				boolean overwriteQuestion = MessageDialog.openQuestion(shell, "Overwrite file", "The file "
					+ file.getName() + " exists. Do you want to overwrite it?");
				if (overwriteQuestion) {
					file.setContents(eObjectAsInputStream, IResource.FORCE, new NullProgressMonitor());
				} else {
					MessageDialog.openError(shell, "Export canceled.", "The object has not been pulled out.");
				}

			} else {
				file.create(eObjectAsInputStream, IResource.FORCE, new NullProgressMonitor());
			}
			refreshUI(file);

		} catch (CannotOpenEObjectException e) {
			ModelUtil.logException(e);
			MessageDialog
				.openError(shell, "Error while retrieving content from EMFStore.",
					"An error occured while serializing the EMF object. Detailed information is available in the error log.");

		} catch (CoreException e) {
			ModelUtil.logException(e);
			MessageDialog
				.openError(
					shell,
					"Error while retrieving content from EMFStore.",
					"An error occured writing to local file. The EMF object cannot be serialized. Detailed information is available in the error log.");
		}
	}
}
