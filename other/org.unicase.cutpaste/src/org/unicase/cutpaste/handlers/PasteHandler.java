package org.unicase.cutpaste.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.util.UnicaseCommand;


public class PasteHandler extends AbstractHandler {

	public ModelElement meClip;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
			
		ModelElement meTarget =  ActionHelper.getModelElement(event);
		
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable trans = cb.getContents(null); 
		
		try{
		meClip = (ModelElement) trans.getTransferData(DataFlavor.javaFileListFlavor);
		}
		catch (Exception e){
			MessageDialog.openInformation(
				null,
				"w@iglt info_box",
				e.toString());
		}

		paste (meClip, meTarget);
	
		return null;
	}


	public void paste (ModelElement meSource, ModelElement meTarget){

		meSource.eSet(meTarget.eContainingFeature(), meTarget);

	}
}