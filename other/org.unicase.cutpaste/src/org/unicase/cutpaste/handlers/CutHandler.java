package org.unicase.cutpaste.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CutHandler extends AbstractHandler {
	
	public String testss = "test";
	/**
	 * The constructor.
	 */
	public CutHandler() {
	
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ModelElement meSource =  ActionHelper.getModelElement(event);


		try {
			cutModelElement(meSource);
		} catch (Exception e) {
			MessageDialog.openInformation(
				null,
				"w@iglt info_box",
				"exception: "+e.toString());
		} 
	
		
		return null;
	}
	
	private void cutModelElement(final ModelElement meSource) throws Exception {
			
		ClipObjectTransferable co = new ClipObjectTransferable(meSource);
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(co, null);
		
		DataFlavor dFlavor[] = co.getTransferDataFlavors();

		if((cb.isDataFlavorAvailable(dFlavor[0]))){
			MessageDialog.openInformation(
				null,
				"w@iglt info_box",
				"data flavor available.");
			}
		else{
		MessageDialog.openInformation(
			null,
			"w@iglt info_box",
			cb.getAvailableDataFlavors()[0].toString());
		}

		
		// Transferable co2 = cb.getContents(null);
		// ModelElement me2 = (ModelElement) co2;
		// me2.delete();
	}
}
