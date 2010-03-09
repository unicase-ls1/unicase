package org.unicase.cutpaste.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;

public class PasteHandler extends AbstractHandler {

	private ModelElement meSource, meTarget;
	private Clipboard clipboard;
	private Transferable transferable;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
			
		meTarget =  ActionHelper.getModelElement(event);
		
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		transferable = clipboard.getContents(null); 

		canPasteString();
		canPasteImage();
		canPasteModelElement();
		paste (meTarget);
	
		return null;
	}


	public void paste (ModelElement meTarget){

		try{
			meSource = (ModelElement) transferable.getTransferData(new DataFlavor(org.unicase.metamodel.ModelElement.class, "UnicaseModelElement"));
			}
			catch (Exception e){e.printStackTrace();
			}
		meSource.eSet(meSource.eContainingFeature(), meTarget.eContainingFeature());
	}
	
	public void canPasteString(){
		try{
			if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor))
				{
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Can paste String.");
				}
			else {
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Cannot paste String.");
			}
				
			}
			catch (Exception e){
				e.printStackTrace();
			}
	}
	public void canPasteImage(){
		try{
			if (transferable.isDataFlavorSupported(DataFlavor.imageFlavor))
				{
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Can paste Image.");
				}
			else {
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Cannot paste Image.");
			}
				
			}
			catch (Exception e){
				e.printStackTrace();
			}
	}
	public void canPasteModelElement(){
		try{
			if (transferable.isDataFlavorSupported(new DataFlavor(org.unicase.metamodel.ModelElement.class, "UnicaseModelElement")))
				{
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Can paste ME.");
				}
			else {
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Cannot paste ME.");
			}
				
			}
			catch (Exception e){
				e.printStackTrace();
			}
	}
}