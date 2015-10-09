/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.eclipse.emf.ecp.explorereditorbridge.internal.EditorModelElementOpener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.diagram.MEDiagram;

/**
 * This a handler to open MEDiagrams with MEEditor. By default MEdiagrams are
 * opened using diagram editor.
 * 
 * @author hodaie
 */
public class OpenDiagramWithMEEditorHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		final IStructuredSelection ssel = (IStructuredSelection) selection;
		EObject eObject = (EObject) ssel.getFirstElement();
		if (eObject instanceof MEDiagram) {
			new EditorModelElementOpener().openModelElement(eObject, ECPUtil
					.getECPProjectManager().getProject(eObject));
		}
		return null;
	}
}
