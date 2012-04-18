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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The handler for the document export command.
 * 
 * @author Sebastian Hoecht
 */
public class ExportDocument extends AbstractHandler {

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
		if (!(o instanceof UnicaseModelElement)) {
			return null;
		}

		final UnicaseModelElementImpl modelElement = (UnicaseModelElementImpl) o;

		final Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				ExportDialog dialog;
				dialog = new ExportDialog(shell, DefaultRenderersFactory.eINSTANCE.createDefaultDocumentRenderer(),
					modelElement);
				dialog.open();
			}
		}.run();

		return null;

	}
}
