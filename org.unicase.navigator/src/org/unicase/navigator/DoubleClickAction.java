package org.unicase.navigator;



import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;



public class DoubleClickAction extends Action implements ISelectionChangedListener{
	SelectionChangedEvent event;
	@Override
	public void run() {
		MEEditorInput input = new MEEditorInput((ModelElement)((TreeSelection)event.getSelection()).getFirstElement());
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, "symphusion.meEditor",true);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void runWithEvent(Event event) {
		// TODO Auto-generated method stub
		super.runWithEvent(event);
	}



	public void selectionChanged(SelectionChangedEvent event) {
		this.event=event;
	}
}
