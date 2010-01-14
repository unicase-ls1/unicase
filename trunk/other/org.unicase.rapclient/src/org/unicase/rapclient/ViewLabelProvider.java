package org.unicase.rapclient;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.Project;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class ViewLabelProvider extends LabelProvider {

	public String getText(Object element) {
		if (element instanceof Workspace) {
			return "Workspace";
		} else if (element instanceof ProjectSpace) {
			return ((ProjectSpace) element).getProjectName();
		} else if (element instanceof Project) {
			return WorkspaceManager.getInstance()
				.getProjectSpace((Project) element).getProjectName();
		} else if (element instanceof WorkItem) {
			return ((WorkItem) element).getName(); 
		}
		
		return null;
	}
	
	public String getDescription(Object anElement) {
		String text = getText(anElement);
		return "This is a description of " + text;
	}
	
	public Image getImage(Object obj) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		
		if (obj instanceof Project) {
		   imageKey = ISharedImages.IMG_OBJ_FOLDER;
		}
		
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
}

