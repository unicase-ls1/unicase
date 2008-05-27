package org.unicase.ui.meeditor.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.ModelElement;
import org.unicase.ui.meeditor.MEEditorInput;

/**
 * 
 * @author Hodaie
 *   This handler handles openModelEelement command.
 *   This handler is to be executed indirectly using IHandlerService.executeCommand()
 *   method. The Command itself does not have any UI representation.    
 *
 */
public class OpenModelElementHandler extends AbstractHandler  {
	
	/**.
	 * ({@inheritDoc})
	 * 
	 * ZH: We added this package and command to meeditor plug-in,
	 * 	   we needed to open a model element from model.edit plug-in
	 * 	   and to avoid circular references we had to execute 
	 * 	   this command indirectly using IHandlerServise.excuteCommand
	 * 
	 * @see //org.unicase.model.edit.commands.AnnotateActionItemHandler#openActionItem()
	 */

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		//ZH: We get the required model element Through activeModelelemet variable. 
		//ZH: This variable is already set, in the method which calls execute
		//ZH: this command. 
		Object o = HandlerUtil.getVariableChecked(event, "activeModelelement");
		ModelElement me = (ModelElement) o;
		
		if (o !=null){
			MEEditorInput input = new MEEditorInput(me);
			try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().openEditor(input,
									"org.unicase.ui.meeditor", true);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return null;
	}

}
