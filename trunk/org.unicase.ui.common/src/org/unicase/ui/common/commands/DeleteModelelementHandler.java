/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.Configuration;

/**
 * . This is the Handler to delete a ModelElement
 * 
 * @author Helming
 * 
 */
public class DeleteModelelementHandler extends AbstractHandler {

	/**
	 * Command to delete a modelelement.
	 * 
	 * @author helming
	 * 
	 */
	private final class DeleteCommand extends RecordingCommand {
		private final ModelElement me;

		private DeleteCommand(TransactionalEditingDomain domain, ModelElement me) {
			super(domain);
			this.me = me;
		}

		protected void doExecute() {
			MessageDialog dialog = new MessageDialog(null, "Confirmation",
					null, "Do you really want to delete " + me.getName(),
					MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
			int result = dialog.open();
			if (result == 0) {

				// FIXME MK OW how do we delete model elements
				
				Resource resource = me.eResource();
				EcoreUtil.delete(me, true);
				resource.getContents().remove(me);
				try {
					resource.save(Configuration.getResourceSaveOptions());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ModelElement me = ActionHelper.getModelElement(event);
		if (me != null) {
			// check if this model element is already opened in an editor
			// and if yes, prompt to close editor.
			if (closeEditor(me)) {
				deleteModelElement(me);
			}

		}
		return null;
	}

	private boolean closeEditor(ModelElement me) {

		boolean result = true;

		// we could find editors with this ME as input
		// but we don't want to have a dependency on meeditor plug-in
		// Therefore we have no access to MEEditorInput class
		IEditorReference[] openEditors = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();

		List<IEditorReference> toCloseEditors = new ArrayList<IEditorReference>();
		for (int i = 0; i < openEditors.length; i++) {
			try {
				if (openEditors[i].getEditorInput().getAdapter(
						ModelElement.class).equals(me)) {
					toCloseEditors.add(openEditors[i]);
				}
			} catch (PartInitException e) {
				DialogHandler.showExceptionDialog(e);
				result = false;
			}
		}

		if (toCloseEditors.size() > 0) {
			result = PlatformUI
					.getWorkbench()
					.getActiveWorkbenchWindow()
					.getActivePage()
					.closeEditors(
							toCloseEditors
									.toArray(new IEditorReference[toCloseEditors
											.size()]), true);

		}

		return result;
	}

	private void deleteModelElement(final ModelElement me) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new DeleteCommand(domain, me));

	}

}
