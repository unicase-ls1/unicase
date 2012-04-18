/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.observer.ModelElementOpenObserver;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.navigatormeeditorbridge.ModelElementOpener;

/**
 * This a handler to open MEDiagrams with MEEditor. By default MEdiagrams are opened using diagram editor.
 * 
 * @author hodaie
 */
public class OpenDiagramWithMEEditorHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject me = ActionHelper.getSelectedModelElement();
		if (me instanceof MEDiagram) {
			ECPWorkspaceManager.getObserverBus().notify(ModelElementOpenObserver.class).onOpen(me,
				"org.unicase.ui.unicasecommon.OpenDiagramWithMEEditor", "org.unicase.ui.meeditor.MEEditor");
			new ModelElementOpener().openModelElement(me);
		}

		return null;
	}
}
