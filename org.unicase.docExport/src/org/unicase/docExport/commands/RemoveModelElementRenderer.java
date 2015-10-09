/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;

/**
 * The handler for the import template command.
 */
public class RemoveModelElementRenderer extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		if (!(o instanceof ModelElementRendererMapping)) {
			return null;
		}

		ModelElementRendererMapping mapping = (ModelElementRendererMapping) o;

		TemplateEditor editor = (TemplateEditor) HandlerUtil.getActiveEditor(event);
		editor.getTemplate().removeModelElementRenderer(
			ModelElementRendererRegistry.getEClassOfString(mapping.getEClassName()));

		return null;
	}
}
