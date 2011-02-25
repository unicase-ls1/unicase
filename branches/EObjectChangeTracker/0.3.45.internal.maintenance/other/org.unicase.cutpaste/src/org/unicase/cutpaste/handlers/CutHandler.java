package org.unicase.cutpaste.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.meeditor.commands.DeleteModelElementCommand;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CutHandler extends AbstractHandler {

	/**
	 * The constructor.
	 */
	public CutHandler() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		ModelElement me = ActionHelper.getModelElement(event);
		
		deleteModelElement(me);
					
		MessageDialog.openInformation(
				null,
				"w@iglt info_box",
				"Your object has been cut.") ;
		return null;
	}
	
	public void deleteModelElement(final ModelElement me) {
		new DeleteModelElementCommand(me).run();
	}
	
}