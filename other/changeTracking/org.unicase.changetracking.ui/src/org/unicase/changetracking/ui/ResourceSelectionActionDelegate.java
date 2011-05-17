/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.resources.mapping.ResourceMappingContext;
import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public abstract class ResourceSelectionActionDelegate implements IObjectActionDelegate{
	
	private ISelection selection;
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}
	
	protected IResource[] getSelectedResources(){
		//Get the selected resource
		if(selection.isEmpty() || !(selection instanceof StructuredSelection)){
			return new IResource[0];
		}
		StructuredSelection struct = (StructuredSelection)selection;
		Object[] selection = struct.toArray();
		IResource[] resources = getResources(selection);
		return resources;
	}
	
	protected void errorMessage(String message){
		MessageDialog.openError(
				PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getShell(),
				"Error",
				message);
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
			if (element instanceof IResource) {
				resources.add((IResource) element);
            } else if (element instanceof ResourceMapping) {
                getResources((ResourceMapping)element,resources);
			} else if (element != null) {
               throw new IllegalArgumentException("An element that is neither a resource nor a mapping was found");
			}
		}
		return (IResource[]) resources.toArray(new IResource[resources.size()]);
	}

}
