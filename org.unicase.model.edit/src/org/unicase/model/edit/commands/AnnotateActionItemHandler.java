package org.unicase.model.edit.commands;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.WorkbenchActivityHelper;
import org.eclipse.ui.internal.Workbench;


public class AnnotateActionItemHandler implements IHandler {

	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new IEditorInput(){

				public boolean exists() {
					// TODO Auto-generated method stub
					return false;
				}

				public ImageDescriptor getImageDescriptor() {
					// TODO Auto-generated method stub
					return null;
				}

				public String getName() {
					// TODO Auto-generated method stub
					return "Halli Hallo";
				}

				public IPersistableElement getPersistable() {
					// TODO Auto-generated method stub
					return null;
				}

				public String getToolTipText() {
					// TODO Auto-generated method stub
					return "";
				}

				public Object getAdapter(Class adapter) {
					// TODO Auto-generated method stub
					return null;
				}
				
			}, "org.unicase.mediagram",true);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
