/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.popup.actions;

import java.util.HashMap;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.unicase.codetrace.tracer.FoundLocation;
import org.unicase.codetrace.tracer.LocationFinder;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.trace.CodeLocation;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * This action loads all code locations from unicase project and sets the markers.
 * If there ist already a marker for a code location, old marker will be deleted and the new one will be set. 
 * 
 * @author snogina
 * 
 * 
 *
 */
public class UpdateMarkersAction implements IEditorActionDelegate {

	private IEditorPart editorPart;
	
	private HashMap<String, IMarker> map = null;

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IEditorInput editorInput = editorPart.getEditorInput();
		
		IResource resource = ResourceUtil.getResource(editorInput);
		//register a listener to workspace changes
	//	IWorkspace workspace = ResourcesPlugin.getWorkspace();
	//	 workspace.addResourceChangeListener(new MarkerUpdater());
		
		if(map == null){
			map = new HashMap<String, IMarker>();
			}
		 getAllCodeLocationsForProject(resource);
		

	}
	
	/**
	 * This method searches for all code locations in this project.
	 */
	private void getAllCodeLocationsForProject(IResource resource){
		//get active unicase project
		Project activeUnicaseProject = WorkspaceManager.getInstance().getCurrentWorkspace().
		getActiveProjectSpace().getProject();
		
		EList<ModelElement> elements;

		elements = activeUnicaseProject.getAllModelElements();
		
		IMarker tmp;
		for(ModelElement element: elements){
			if(element instanceof CodeLocation){
				//find the code line for this code location
				LocationFinder finder = LocationFinder.getInstance();
				FoundLocation location = finder.find((CodeLocation)element);
				
				if(map.containsKey(getCodeLocationId(((CodeLocation)element)))){
					try {
						map.get(getCodeLocationId((CodeLocation)element)).delete();
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
				tmp =setMarkerForCodeLocation(location,((CodeLocation)element), resource);
				map.put(getCodeLocationId(((CodeLocation)element)), tmp);
				
			}
		}
	}
		
		private IMarker setMarkerForCodeLocation(FoundLocation location, CodeLocation codeLocation, IResource resource){
			HashMap map = new HashMap();
			map.put(IMarker.LINE_NUMBER, location.getLineNumber());
			map.put(IMarker.MESSAGE, location.getLineNumber());
			map.put(IMarker.LOCATION, getCodeLocationId(codeLocation));

			IMarker marker = null;
			
			
			try {			
				MarkerUtilities.createMarker(location.getFile(), map,
						"org.unicase.taskmarker");
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return marker;
		}
		
		public static String getCodeLocationId(ModelElement codeLocation){
			
			// Get model element id
			String meId = codeLocation.getModelElementId().getId();

			ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();

			String projectId = ""; //ps.getProjectId().getId();

//			String serverUrl = ps.getUsersession().getServerInfo().getUrl();
//			int serverPort = ps.getUsersession().getServerInfo().getPort();

			// Assemble the link
			String link = "/" + projectId + "/" + meId;
			return link;
		}
		

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	public void init(IViewPart view) {
		
		// TODO Auto-generated method stub
	}

	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editorPart = targetEditor;

	}

}

