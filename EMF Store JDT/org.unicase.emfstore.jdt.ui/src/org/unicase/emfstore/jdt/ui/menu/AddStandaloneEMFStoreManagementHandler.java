package org.unicase.emfstore.jdt.ui.menu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.PushToEMFStoreUtil;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.ui.editor.EditorHelper;

public class AddStandaloneEMFStoreManagementHandler extends AbstractHandler {

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
				emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file.getProject());

			} catch (NoEMFStoreJDTConfigurationException ex) {
				emfStoreJDTConfiguration = ConfigurationManager.createConfiguration(file.getProject());
			}

			PushToEMFStoreUtil.addEntry(emfStoreJDTConfiguration, file);

			emfStoreJDTConfiguration.save();
		}

		return null;
	}

}
