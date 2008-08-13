/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**.
 * This is the Handler to delete a ModelElement
 * @author Helming
 *
 */
public class DeleteModelelementHandler extends AbstractHandler {

	/**.
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ModelElement me = ActionHelper.getModelElement(event);
		if (me != null) {
			//check if this model element is already opened in an editor
			//and if yes, prompt to close editor.
			if(closeEditor(me)){
				deleteModelElement(me);
			}
			
		}
		return null;
	}

	
	
	private boolean closeEditor(ModelElement me) {

		boolean result = true; 

		//find editors with this ME as input
		MEEditorInput input = new MEEditorInput(me);
		IEditorReference[] editorRefs = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().findEditors(input,
						null, IWorkbenchPage.MATCH_INPUT);
		if (editorRefs.length > 0) {
			result = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().closeEditors(editorRefs, true);

		}

		return result;
	}

	
	private void deleteModelElement(final ModelElement me) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				MessageDialog dialog = new MessageDialog(null, "Confirmation",
						null, "Do you really want to delete " + me.getName(),
						MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
				int result = dialog.open();
				if (result == 0) {
					ProjectSpace projectSpace = WorkspaceManager
							.getProjectSpace(me);
					EcoreUtil.delete(me, true);
					projectSpace.save();
				}
			}
		});

	}

}
