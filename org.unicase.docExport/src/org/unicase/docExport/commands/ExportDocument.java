/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.docExport.exceptions.TemplatesFileNotFoundException;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.model.ModelElement;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.workspace.util.WorkspaceUtil;

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
		if (!(o instanceof ModelElement)) {
			return null;
		}

		final ModelElementImpl modelElement = (ModelElementImpl) o;

		final Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				ExportDialog dialog;
				try {
					dialog = new ExportDialog(shell, DefaultRenderersFactory.eINSTANCE.createDefaultDocumentRenderer(),
						modelElement);
					dialog.open();
				} catch (TemplatesFileNotFoundException e) {
					WorkspaceUtil.log("The templates file could not be found or created", e, IStatus.ERROR);

					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("Couldn't find any Template");
					messageBox.open();
				}

			}
		});

		return null;

	}
}
