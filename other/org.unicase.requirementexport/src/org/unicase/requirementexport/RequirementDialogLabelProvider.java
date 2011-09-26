package org.unicase.requirementexport;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.document.LeafSection;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.provider.WorkspaceEditPlugin;

/**
 * Label provider for {@link ExportRequirementDialog}.
 * 
 * @author mharut
 */
public class RequirementDialogLabelProvider extends LabelProvider {

	public Image getImage(Object element) {
		if (element instanceof ProjectSpace) {
			// return project icon
			Object obj = WorkspaceEditPlugin.INSTANCE.getImage("prj_obj");
			if (obj instanceof URL) {
				return ImageDescriptor.createFromURL((URL) obj).createImage();
			}
		} else if (element instanceof LeafSection) {
			// return leaf section icon
			Object obj = ModelEditPlugin.INSTANCE.getImage("full/obj16/LeafSection");
			if (obj instanceof URL) {
				return ImageDescriptor.createFromURL((URL) obj).createImage();
			}
		}
		// this shouldn't happen, dialog only shows project spaces and leaf sections
		return null;
	}

	public String getText(Object element) {
		if (element instanceof ProjectSpace) {
			return ((ProjectSpace) element).getProjectName();
		} else if (element instanceof LeafSection) {
			return ((LeafSection) element).getName();
		}
		// this shouldn't happen, dialog only shows project spaces and leaf sections
		return "";
	}
}
