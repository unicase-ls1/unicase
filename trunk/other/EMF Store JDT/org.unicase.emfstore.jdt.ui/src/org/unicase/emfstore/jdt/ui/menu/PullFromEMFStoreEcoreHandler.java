/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.menu;

import java.io.InputStream;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.PushToEMFStoreUtil;
import org.unicase.emfstore.jdt.exception.CannotOpenEObjectException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;
import org.unicase.emfstore.jdt.ui.dialog.JDTModelElementSelectDialog;
import org.unicase.emfstore.jdt.ui.exception.NoProjectSelectedException;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;

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
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
		IContainer selectedContainer = null;
		Object[] selectedObjects = selection.toArray();
		for (Object selectedObject : selectedObjects) {
			if (selectedObject instanceof IContainer) {
				selectedContainer = (IContainer) selectedObject;
				break;
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
		ECPModelelementContext context = new EMFStoreModelelementContext((EObject) selectProjectSpace.getProject());
		ModelElementSelectionDialog meSelectionDialog = new JDTModelElementSelectDialog(context);
		meSelectionDialog.create();
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

		EMFStoreJDTConfiguration emfStoreJDTConfiguration;
		try {
			emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file.getProject());

		} catch (NoEMFStoreJDTConfigurationException e) {
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
