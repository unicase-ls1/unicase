package org.unicase.cutpaste.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.cutpaste.stuff.UnicaseTransferable;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;

public class CutHandler extends AbstractHandler {
	
	private String teststr = "test"; 
	private ModelElement testme;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ModelElement meSource =  ActionHelper.getModelElement(event);

		try {
			cutModelElement(meSource);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
		
		return null;
	}
	
	private void cutModelElement(final ModelElement meSource) throws Exception {
			
		Transferable copytrans = new UnicaseTransferable(meSource);
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(copytrans, null);
/*		
//		Testcode
		
		teststr = "false";
		
		Transferable trans = cb.getContents(null); 
		teststr = (String) trans.getTransferData(DataFlavor.stringFlavor);
		testme = (ModelElement) trans.getTransferData(DataFlavor.javaFileListFlavor);
		MessageDialog.openInformation(
			null,
			"w@iglt info_box",
			testme.toString());
	
*/
	}
}
