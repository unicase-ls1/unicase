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
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.util.UnicaseCommand;

public class PasteHandler extends AbstractHandler {

	private ModelElement meSource, meTarget;
	private Clipboard clipboard;
	private Transferable transferable;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
			
		meTarget =  ActionHelper.getModelElement(event);
		
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		transferable = clipboard.getContents(null); 

		if(	! (canPasteString(false) &&	canPasteImage(false) &&	canPasteModelElement(false) )) // if no errors occur, show no dialog boxes
			{canPasteString(true); 	canPasteImage(true); 	canPasteModelElement(true);}
		
		paste (meTarget);

		return null;
	}
	
	public void paste (final ModelElement meTarget){
		
		try{
			meSource = (ModelElement) transferable.getTransferData(new DataFlavor(org.unicase.metamodel.ModelElement.class, "UnicaseModelElement"));
			}
		catch (Exception e){
			e.printStackTrace();
			}
		final EReference theRef = getTargetRef(meTarget, meSource);
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				meSource.eSet(theRef.getEOpposite(), meTarget);
				}
			}.run();
			}
	
	public boolean canPasteString(boolean b){
		try{
			if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor))
				{ if (b)
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Can paste String.");
				return true;
				}
			else {
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Cannot paste String.");
				return false;
			}
				
			}
			catch (Exception e){
				e.printStackTrace();
			}
		return false;
	}
	public boolean canPasteImage(boolean b){
		try{
			if (transferable.isDataFlavorSupported(DataFlavor.imageFlavor))
				{ if (b)
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Can paste Image.");
				return true;
				}
			else {
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Cannot paste Image.");
				return false;
			}
				
			}
			catch (Exception e){
				e.printStackTrace();
			}
			return false;
	}
	public boolean canPasteModelElement(boolean b){
		try{
			if (transferable.isDataFlavorSupported(new DataFlavor(org.unicase.metamodel.ModelElement.class, "UnicaseModelElement")))
				{ if (b)
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Can paste ME.");
				return true;
				}
			else {
				MessageDialog.openInformation(
					null,
					"w@iglt info_box",
					"Cannot paste ME.");
				return true;
			}
			}
			catch (Exception e){
				e.printStackTrace();
			}
			return false;
	}
	private EReference getTargetRef(EObject targetContainer, ModelElement me) {

		List<EReference> refs = targetContainer.eClass().getEAllContainments();
		for (EReference ref : refs) {
			if (ref.isContainer()) {
				continue;
			}
			if (ref.getEReferenceType().equals(me.eClass())
				|| ref.getEReferenceType().isSuperTypeOf(me.eClass())) {
				return ref;
			}
		}
		return null;

	}
}