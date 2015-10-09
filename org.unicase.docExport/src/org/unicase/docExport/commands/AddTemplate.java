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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.editors.TemplateEditorInput;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultDocumentTemplateFactory;

/**
 * The handler for the add template command.
 * 
 * @author Sebastian Hoecht
 */
public class AddTemplate extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();

		Template newTemplate = DefaultDocumentTemplateFactory.build();
		newTemplate.setName("new Template");

		TemplateEditorInput input = new TemplateEditorInput(newTemplate);
		try {
			page.openEditor(input, TemplateEditor.ID);
		} catch (PartInitException e) {
			WorkspaceUtil.log("Template editor failure", e, IStatus.ERROR);
		}

		return null;
	}

}
