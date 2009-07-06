package org.unicase.docExport.views;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.workspace.util.WorkspaceUtil;


/**
 * 
 * @author Sebastian Höcht
 *
 */
public class TreeContentProvider implements ITreeContentProvider {

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Template) {
			return ((Template) parentElement).getModelElementRendererMapping().toArray();
		} else if (parentElement instanceof ModelElementRendererMapping) {
			return ((ModelElementRendererMapping) parentElement).getRenderer().getRendererOptions().toArray();
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
	    // Get the children
	    Object[] obj = getChildren(element);

	    // Return whether the parent has children
	    return obj == null ? false : obj.length > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		try {
			return TemplateRegistry.getAllTemplates().toArray();
		} catch (TemplateSaveException e) {
			WorkspaceUtil.log(
					"cannot load the templates",
					e,
					IStatus.ERROR
				);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}


}