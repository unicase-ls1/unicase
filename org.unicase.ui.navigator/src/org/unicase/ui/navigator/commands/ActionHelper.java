/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.navigator.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.ModelElement;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorInput;

/**
 * 
 * @author Hodaie
 * This class contains some utility method for commands and handlers.
 *
 */
public final class ActionHelper {

	
	private ActionHelper(){
	}
	
	/**
	 * This opens the model element. 
	 * @param newMEInstance ModelElement to open
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

	/**.
	 * Extract the selected ModelElement in navigator or other StructuredViewer
	 * This will be called from Handler classes.
	 * @param event The ExecutionEvent
	 * @return the selected ModelElement or null
	 */
	public static ModelElement getSelection(ExecutionEvent event) {
		ModelElement result = null;
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object obj = ssel.getFirstElement();
		if(obj instanceof ModelElement){
			result = (ModelElement) obj;
		}
		
		return result;
	}

}
