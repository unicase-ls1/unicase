/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.common.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.ModelElement;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorInput;

/**
 * 
 * @author Hodaie This class contains some utility method for commands and
 *         handlers.
 */
public final class ActionHelper {

	private static final String MEEDITOR_ID = "org.unicase.ui.meeditor";
	// private static final String NAVIGATOR_ID = "org.unicase.ui.navigator.viewer";
	

	private ActionHelper() {

	}

	/**
	 * This extracts active model element. From MEEditor or from Navigator
	 * 
	 * @param event
	 *            the ExecutionEvent given by caller handler
	 * @return active model element
	 */
	public static ModelElement getModelElement(ExecutionEvent event) {

		ModelElement me = null;

		// ZH: determine the place from which
		// the command is run (UC Navigator context menu or MEEeditor)
		// This decision is should be made to extract the model element
		// for attaching action item accordingly.
		// I think a better way was to have two different handlers for
		// for this two locations.
		String partId = HandlerUtil.getActivePartId(event);
		if (partId.equals(MEEDITOR_ID)) {
			//extract model element from editor input
			IEditorInput editorInput = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor().getEditorInput();
			MEEditorInput meeditorInput;
			if (editorInput instanceof MEEditorInput) {
				meeditorInput = (MEEditorInput) editorInput;
				me = meeditorInput.getModelElement();
			}

		} else {
			// extract model element from current selection in navigator

			EObject eObject = getSelection(event);
			if (!(eObject instanceof ModelElement)) {
				return null;
			}

			me = (ModelElement) eObject;
		}

		return me;
	}

	/**
	 * This opens the model element.
	 * 
	 * @param newMEInstance
	 *            ModelElement to open
	 */
	public static void openModelElement(ModelElement newMEInstance) {

		MEEditorInput input = new MEEditorInput(newMEInstance);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(input, MEEditor.ID, true);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * . Extract the selected ModelElement in navigator or other
	 * StructuredViewer This will be called from Handler classes.
	 * 
	 * @param event
	 *            The ExecutionEvent
	 * @return the selected ModelElement or null
	 */
	public static EObject getSelection(ExecutionEvent event) {
		EObject result = null;
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object obj = ssel.getFirstElement();
		if (obj instanceof EObject) {
			result = (EObject) obj;
		}

		return result;
	}

}
