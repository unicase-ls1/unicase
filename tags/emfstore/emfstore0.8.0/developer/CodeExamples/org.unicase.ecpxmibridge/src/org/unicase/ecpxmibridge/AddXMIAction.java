package org.unicase.ecpxmibridge;


import org.eclipse.core.internal.resources.File;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IActionDelegate;

public class AddXMIAction implements IActionDelegate {

	private ISelection selection;

	public void run(IAction action) {
		if(selection instanceof TreeSelection) {
			Object firstElement = ((TreeSelection) selection).getFirstElement();
			if (firstElement instanceof File){
				File file = (File) firstElement;
				//TODO: Add to workspace
			}
		}
		
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;

		
	}

	

	
}
