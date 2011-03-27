/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.menu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.EMFStoreLocation;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.eclipseworkspace.StructuredEMFStoreURI;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.ui.editor.EditorHelper;

/**
 * The handler that rejects a file from an EMF Store. This handler is independent from the used team provider.
 * 
 * @author Adrian Staudt
 */
public class RejectFromEMFStoreEcoreHandler extends AbstractCommanHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
		Object[] selectedObjects = selection.toArray();
		List<IFile> selectedFiles = new ArrayList<IFile>();
		for (Object selectedObject : selectedObjects) {
			if (selectedObject instanceof IFile) {
				IFile selectedFile = (IFile) selectedObject;
				selectedFiles.add(selectedFile);
			}
		}

		// close all editors where the file is opened
		for (IFile file : selectedFiles) {
			List<IEditorReference> editors = EditorHelper.getEditorFor(file);
			for (IEditorReference editor : editors) {
				EditorHelper.closeEditor(editor);
			}

			EMFStoreJDTConfiguration emfStoreJDTConfiguration;
			try {
				// get entry to remove
				emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file.getProject());
				Entry entryToRemove = ConfigurationManager.getEntry(emfStoreJDTConfiguration, file);

				// mark entry for deletion
				entryToRemove.setMarkedForDeletion(true);

				// remove from ProjectSpace
				StructuredEMFStoreURI structuredEMFStoreURI = ConfigurationManager.getEMFStoreURI(entryToRemove);
				ProjectSpaceUtil.removeEObject(structuredEMFStoreURI);

				// add to force EMFStore to commit (so that the deleted EObject can be removed)
				EMFStoreLocation emfStoreLocationClone = ModelUtil.clone(entryToRemove.getEObjectLocation()
					.getEMFStoreLocation());
				ConfigurationManager.addToAnywayCommit(emfStoreJDTConfiguration, emfStoreLocationClone);

				// save changes
				emfStoreJDTConfiguration.save();

				// refresh UI
				refreshUI(file);

			} catch (NoEMFStoreJDTConfigurationException e) {
				// should not append, but if so write to log
				ModelUtil.logException(e);

			} catch (EntryNotFoundException e) {
				// should not append, but if so write to log
				ModelUtil.logException(e);
			}
		}

		return null;
	}
}
