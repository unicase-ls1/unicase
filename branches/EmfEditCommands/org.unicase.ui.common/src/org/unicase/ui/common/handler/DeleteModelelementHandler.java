/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.impl.EObjectToChangesMapEntryImpl;
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.commands.DeleteModelElementCommand;
import org.unicase.ui.common.util.ActionHelper;

/**
 * . This is the Handler to delete a ModelElement
 * 
 * @author Helming
 */
public class DeleteModelelementHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//Paste command from emf edit
		
	Object toValidate = ActionHelper.getModelElement(event);
//		org.eclipse.emf.edit.command.PasteFromClipboardCommand dc3 = (PasteFromClipboardCommand) org.eclipse.emf.edit.command.PasteFromClipboardCommand.create(org.unicase.workspace.Configuration.getEditingDomain(),
//			toValidate,toValidate);
//		org.unicase.workspace.Configuration.getEditingDomain()
//				.getCommandStack().execute(dc3);
		
		
		
		//delete command from emf edit
		
		 org.eclipse.emf.edit.command.DeleteCommand dc2 = (DeleteCommand)
		 org.eclipse.emf.edit.command.DeleteCommand
		 .create(org.unicase.workspace.Configuration.getEditingDomain(),
		 toValidate);
		 org.unicase.workspace.Configuration.getEditingDomain()
		 .getCommandStack().execute(dc2);
//		
//		ModelElement me = ActionHelper.getModelElement(event);
//		if (me == null) {
//			return null;
//		}
//
//
//		deleteModelElement(me);
//
//return null;
//	}
//
//	private void deleteModelElement(final ModelElement me) {
//		new DeleteModelElementCommand(me).run();
//	}
		return null;

}
}
