/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.ui.unicasecommon.common.dialogs.METypeTreeSelectionDialog;

/**
 * The handler for the AddModelElement command.
 * 
 * @author Sebastian Hoecht
 */
public class AddModelElementRenderer extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		TemplateEditor editor = (TemplateEditor) HandlerUtil.getActiveEditor(event);

		METypeTreeSelectionDialog dialog = new METypeTreeSelectionDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell(), false);

		if (dialog.open() == METypeTreeSelectionDialog.OK) {
			editor.getModelElementRenderersTabItem().chooseModelElementType(dialog.getResult()[0]);
		}
		return null;
	}
}
