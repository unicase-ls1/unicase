/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.diagram;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.diagram.MEDiagram;

/**
 * Diagram opener.
 */
public class DiagramOpener {

	/**
	 * {@inheritDoc}
	 */
	public void openDiagram(MEDiagram diagram, String id) {
		URI uri = EcoreUtil.getURI(diagram);
		uri.appendFragment(diagram.eResource().getURIFragment(diagram));
		URIEditorInput input = new URIEditorInput(uri, diagram.getName());

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage()
					.showView("org.eclipse.ui.views.PropertySheet");
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(input, id, true);

		} catch (PartInitException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Error",
					e.getMessage(), e.getStatus());
		}

	}

}
