/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.unicase.codetrace.CodetraceUtil;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Change listener that updates markers whenever a file resource is saved.
 * 
 * This listener is currently registered in the plugin's start method.
 * Maybe that is too late because the markers are not updated until the plugin is loaded
 * (which is not before any code-location specific action was executed)
 * @author jfinis
 *
 */
public class MarkerUpdater implements IResourceChangeListener {
   
	/**
	 * This visitor goes down in the resource delta tree until it finds
	 * changed files and returns a list of those files (so they can be updated afterwards).
	 * @author jfinis
	 */
	private static class Visitor implements IResourceDeltaVisitor {
		
		private ArrayList<IResource> resources = new ArrayList<IResource>(2);
		
		public List<IResource> getResources(IResourceDelta delta){
			try {
				delta.accept(this);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resources;
		}
		
	     public boolean visit(IResourceDelta delta) {
	    	 if(delta.getResource().getType() == IResource.FILE && delta.getKind() == IResourceDelta.CHANGED){
	    		 resources.add(delta.getResource());
	    		 return false;
	    	 }
	         return true;
	     }
	 }

	/**
	 * Updates the markers for this resource.
	 * @param event the event
	 */
    public synchronized void resourceChanged(IResourceChangeEvent event) {
		//Get the resources
		List<IResource> resources = new Visitor().getResources(event.getDelta());
		
		//No files? skip!
		if(resources.isEmpty()){
			return;
		}
		
		// get active unicase project
		ProjectSpace projectSpace = WorkspaceManager.getInstance()
		.getCurrentWorkspace().getActiveProjectSpace();
		
		//No unicase project open? Do nothing
		if(projectSpace == null){
			return;
		}
		Project activeUnicaseProject = projectSpace.getProject();
		
		//do the update		
		for(IResource resource: resources){
			CodetraceUtil.updateFileMarkers((IFile) resource, activeUnicaseProject, true);
		}
		      
    }
 }
