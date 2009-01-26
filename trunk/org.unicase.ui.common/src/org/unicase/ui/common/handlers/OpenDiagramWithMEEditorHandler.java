/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.util.ActionHelper;

/**
 * . This a handler to open MEDiagrams with MEEditor. By default MEdiagrams are opened using diagram editor.
 * 
 * @author hodaie
 */
public class OpenDiagramWithMEEditorHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ModelElement me = ActionHelper.getSelectedModelElement();
		if (me instanceof MEDiagram) {
			ActionHelper.openMEDiagram((MEDiagram) me, true);
		}

		return null;
	}

}
