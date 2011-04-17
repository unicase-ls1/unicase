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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationManager;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreTeamProviderConfiguration;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreLocation;
import org.eclipse.emf.emfstore.teamprovider.configuration.Entry;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.StructuredEMFStoreURI;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.eclipse.emf.emfstore.teamprovider.exception.EntryNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.NoEMFStoreTeamProviderConfigurationException;
import org.eclipse.emf.emfstore.teamprovider.ui.editor.EditorHelper;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.handlers.HandlerUtil;

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

			EMFStoreTeamProviderConfiguration emfStoreJDTConfiguration;
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

			} catch (NoEMFStoreTeamProviderConfigurationException e) {
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
