package org.unicase.changetracking.ui.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.resources.mapping.ResourceMappingContext;
import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class ResourceCommandHandler extends AbstractHandler{
	protected IResource[] getSelectedResources(ExecutionEvent event){
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		//Get the selected resource
		if(selection.isEmpty() || !(selection instanceof StructuredSelection)){
			return new IResource[0];
		}
		StructuredSelection struct = (StructuredSelection)selection;
		Object[] select = struct.toArray();
		IResource[] resources = getResources(select);
		return resources;
	}
	
	
    private static void getResources(ResourceMapping element, List<IResource> resources) {
        try {
            ResourceTraversal[] traversals = element.getTraversals(ResourceMappingContext.LOCAL_CONTEXT, null);
            for (int k = 0; k < traversals.length; k++) {
                ResourceTraversal traversal = traversals[k];
                IResource[] resourceArray = traversal.getResources();
                for (int j = 0; j < resourceArray.length; j++) {
                    IResource resource = resourceArray[j];
                    resources.add(resource);
                }
            }
        } catch (CoreException e) {
        	throw new RuntimeException(e);
        }
    }
    
	/**
	 * Returns the list of resources contained in the given elements.
	 * @param elements
	 * @return the list of resources contained in the given elements.
	 */
	private static IResource[] getResources(Object[] elements) {
		List<IResource> resources = new ArrayList<IResource>();
		for (int i = 0; i < elements.length; i++) {
			Object element = elements[i];
			if(element instanceof IJavaProject){
				//FIXME make this generically
				resources.add(((IJavaProject) element).getProject());
			}
		}
		return (IResource[]) resources.toArray(new IResource[resources.size()]);
	}
}
