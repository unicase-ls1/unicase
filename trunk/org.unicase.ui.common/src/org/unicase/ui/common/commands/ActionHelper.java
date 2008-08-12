/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.common.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.ModelElement;

/**
 * 
 * @author Hodaie
 * This class contains some utility method for commands and handlers.
 */
public final class ActionHelper {
	
	private static final String MEEDITOR_ID = "org.unicase.ui.meeditor";
	private static final String NAVIGATOR_ID = "org.unicase.ui.navigator.viewer";
	private static final String MEEDITOR_EVALUATIONSERVICE_VARIABLE = "activeModelelement";
	
	private ActionHelper(){
		
	}
	
	/**
	 * This extracts active model element. From MEEditor or from Navigator
	 * @param event the ExecutionEvent given by caller handler
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
			//extract model element from evaluation service variable that 
			//MEEditor has already set. (in MEEditorPage)
			Object o = HandlerUtil.getVariable(event,
					MEEDITOR_EVALUATIONSERVICE_VARIABLE);
			me = (ModelElement) o;

		} else if (partId.equals(NAVIGATOR_ID)) {
			//extract model element from current selection in navigator
			ISelection sel = HandlerUtil.getCurrentSelection(event);
			if (!(sel instanceof IStructuredSelection)) {
				return null;
			}

			IStructuredSelection ssel = (IStructuredSelection) sel;
			if (ssel.isEmpty()) {
				return null;
			}

			Object o = ssel.getFirstElement();
			if (!(o instanceof ModelElement)) {
				return null;
			}

			me = (ModelElement) o;
		}

		return me;
	}

}
