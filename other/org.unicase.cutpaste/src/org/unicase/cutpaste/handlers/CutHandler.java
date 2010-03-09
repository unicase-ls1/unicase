package org.unicase.cutpaste.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.cutpaste.stuff.UnicaseTransferable;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;

public class CutHandler extends AbstractHandler {
		
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ModelElement meSource =  ActionHelper.getModelElement(event);

		try {
			cutModelElement(meSource);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return null;
	}
	
	private void cutModelElement(final ModelElement meSource){
			
		Transferable transferable = new UnicaseTransferable(meSource);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(transferable, null);

	}
}
