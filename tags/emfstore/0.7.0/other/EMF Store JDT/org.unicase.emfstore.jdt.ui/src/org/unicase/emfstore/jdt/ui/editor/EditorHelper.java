/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.unicase.emfstore.jdt.eclipseworkspace.ResourceCommitHolder;
import org.unicase.emfstore.jdt.eclipseworkspace.StructuredEMFStoreURI;
import org.unicase.emfstore.jdt.exception.EMFStoreURIMalformedException;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Helper that finds out the right and adapted editor reference.
 * 
 * @author Adrian Staudt
 */
public final class EditorHelper {

	private EditorHelper() {
	}

	/**
	 * Returns a list of editors that have opened a given file.
	 * 
	 * @param file An eclipse workspace file.
	 * @return A list of editor references.
	 */
	public static List<IEditorReference> getEditorFor(IFile file) {
		IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
			.getEditorReferences();

		List<IEditorReference> editors = new ArrayList<IEditorReference>();
		for (IEditorReference editorReference : editorReferences) {
			try {
				IEditorInput editorInput = editorReference.getEditorInput();
				if (editorInput instanceof FileEditorInput) {
					FileEditorInput fileEditorInput = (FileEditorInput) editorInput;
					IFile fileEditorInputFile = fileEditorInput.getFile();
					if (fileEditorInputFile.getLocation().equals(file.getLocation())) {
						editors.add(editorReference);
					}

				} else if (editorInput instanceof URIEditorInput) {
					URIEditorInput uriEditorInput = (URIEditorInput) editorInput;
					URI uri = uriEditorInput.getURI();
					try {
						StructuredEMFStoreURI structuredEMFStoreURI = new StructuredEMFStoreURI(uri);
						List<IFile> matchedFiles = ResourceCommitHolder.getFilesInWorkspace(structuredEMFStoreURI);
						for (IFile matchedFile : matchedFiles) {
							if (matchedFile.equals(file)) {
								editors.add(editorReference);
								continue;
							}
						}

					} catch (EMFStoreURIMalformedException e) {
						// was not an EMF Store uri, so keep the editor open
					}
				}

			} catch (PartInitException e) {
				ModelUtil.logException(e);
			}
		}

		return editors;
	}

	/**
	 * Closes an editor in the eclipse workbench by its editor reference.
	 * 
	 * @param editor An editor reference.
	 */
	public static void closeEditor(IEditorReference editor) {
		final IEditorPart editorPart = editor.getEditor(false);
		editorPart.getSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				// close editor
				editorPart.getSite().getPage().closeEditor(editorPart, false);
				editorPart.dispose();
			}
		});
	}

	/**
	 * Opens an editor with an file in the eclipse workbench by its editor id.
	 * 
	 * @param editorId An editor id.
	 * @param file An eclipse workspace file.
	 */
	public static void openEditor(String editorId, IFile file) {
		try {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			page.openEditor(new FileEditorInput(file), editorId);

		} catch (PartInitException e) {
			ModelUtil.logException(e);
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			MessageDialog.openError(shell, "Reopen editor",
				"Failed to reopen the editor with the new content. Please reopen manually.");
		}
	}
}
