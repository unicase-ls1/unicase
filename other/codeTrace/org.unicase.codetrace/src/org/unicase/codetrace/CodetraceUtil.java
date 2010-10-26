/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace;

import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.ide.IDE;
import org.unicase.codetrace.tracer.FoundLocation;
import org.unicase.codetrace.tracer.LocationFinder;
import org.unicase.codetrace.ui.ChooseModelElementDialog;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.trace.CodeLocation;
import org.unicase.model.trace.TracePackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Utility class that provides various methods for code tracing.
 * @author kterziewa
 * @author snogina
 * @author jfinis
 *
 */
public final class CodetraceUtil {
	
	/**
	 * Unique ID for code location markers.
	 */
	public static final String CODE_LOCATION_MARKER_ID = "org.unicase.codetrace.locationmarker";

	/**
	 * Utility class.
	 */
	private CodetraceUtil() {}
	
	/**
	 * Shows a specific line of a specific file in a workbench page.
	 * @param file the file to show
	 * @param lineNumber the line number to show
	 * @param page the workbench page in which to show the location
	 */
	private static void openTaskLocation(IFile file, int lineNumber, IWorkbenchPage page){
	
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put(IMarker.LINE_NUMBER, lineNumber);
		
		IMarker marker;
		try {
			marker = file.createMarker(IMarker.TEXT);
			marker.setAttributes(map);
			IDE.openEditor(page, marker); 
			marker.delete();

		} catch (CoreException e) {
			e.printStackTrace();
		}	
		
	}
	
	/**
	 * Tries to find a code location and if a location was found,
	 * switch to the java perspective and show the code location.
	 * @param me the code location to be found
	 */
	public static void findCodeLocation(CodeLocation me){
		LocationFinder finder = LocationFinder.getInstance();
		FoundLocation location = finder.find((CodeLocation)me);
		if(location == null){
			MessageDialog.openError(
					PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(),
					"Error",
					"Code location couldn't be found. \nEither the code location has been deleted or its containing project is not checked out.");
			return;

		}
		
		//change current perspective to the java perspective
		IWorkbench workbench = PlatformUI.getWorkbench();
		try {
			workbench.showPerspective("org.eclipse.jdt.ui.JavaPerspective", 
			workbench.getActiveWorkbenchWindow());
		} catch (WorkbenchException e) {	
			WorkspaceUtil.logException(e.getMessage(), e);
		}
		
		IWorkbenchPage page  = workbench.getActiveWorkbenchWindow().getActivePage();
	
		openTaskLocation(location.getFile(), location.getLineNumber(), page);

	}
	
	
	/**
	 * Returns the path of a file in a project if the project exists.
	 * If no project with the specified name exists, null is returned.
	 * @param projectName the name of the project
	 * @param pathInProject the file path in the project
	 * @return the path of the file 
	 */
	
	public static String getPathOfFile(String projectName, String pathInProject){
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject p = root.getProject(projectName);
		if(p == null) {
			return null;
		}
		return p.getLocation().toString() + "/" + pathInProject;	
	}
	
	/**
	 * Gets an IFile by specifying a project's name and the path in the project.
	 * @param projectName the project's name
	 * @param pathInProject the path inside the project
	 * @return an IFile with that path.
	 */
	public static IFile getIFile(String projectName, String pathInProject){
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject p = root.getProject(projectName);
		if(p == null || !p.exists()) {
			return null;
		}
		return p.getFile(pathInProject);
	}
	
	/**
	 * Gets the path of a project.
	 * @param projectName the name of the project
	 * @return the name of the project location
	 */
	public static String getProjectOfFile(String projectName){
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject p = root.getProject(projectName);
		if(p == null) {
			return null;
		}
		return p.getLocation().toString();	
	}
	
	/**
	 * Returns the active unicase project or null if none is active.
	 * @return the active unicase project
	 */
	private static Project getActiveProject() {
		final ProjectSpace ps = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace();
		if(ps == null) {
			return null;
		}
		if (ps.getProject() != null) {
			return ps.getProject();
		} else {
			return null;
		}

	}

	/**
	 * Shows a dialog to select a model element to attach a code location to.
	 * @return the chosen model element
	 */
	public static UnicaseModelElement showChooseMEForCodeLocationDialog() {
		Project p = getActiveProject();
		if(p == null){
			MessageDialog.openError(
				PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getShell(),
				"Error",
				"No unicase project is active at the moment.\nPlease open a unicase project and try again.");
			return null;
		}
		ChooseModelElementDialog cmed = new ChooseModelElementDialog(
				p, "Choose Model Element for code location!");
		if (cmed.open() == Window.OK) {
			Object[] result = cmed.getResult();

			if (result.length > 0) {
				for (Object o : result) {
					if (o instanceof UnicaseModelElement ) {
						return (UnicaseModelElement)o;
					}
				}
			}
		}
		
		return null;

	}
	
	/**
	 * Creates a marker for a code location. This function does not check if the marker is already existant for
	 * this resouce and code location.
	 * @param codeLocation the code location for which to create the marker
	 * @param resource the file in which to create the marker
	 * @param line the line where to create the marker
	 * @return the created marker or null if a core exception occurred
	 * @throws CoreException if a coreexception occurs (normally never)
	 */
	public static IMarker createMarker(CodeLocation codeLocation, IFile resource, int line) throws CoreException{
		IMarker m;
		m = resource.createMarker(CODE_LOCATION_MARKER_ID);
		m.setAttribute(IMarker.LINE_NUMBER, line);
		m.setAttribute(IMarker.MESSAGE, "This code location was linked to unicase.");
		m.setAttribute("modelElementId", codeLocation.getModelElementId().getId());
		return m;
	}
	
	/**
	 * Creates a marker for a code location. If such a marker exists
	 * it is instead moved to this location.
	 * @param codeLocation the code location for which to create the marker
	 * @param resource the resource in which to create the marker.
	 * @param line the line where to place / move the marker.
	 * @return the created marker, or, if it already existed, the updated marker, or null if a core exception occurred
	 * @throws CoreException if a coreexception occurs (normally never)
	 */
	public static IMarker createMarkerIfNotExistant(CodeLocation codeLocation, IFile resource, int line) throws CoreException{
		IMarker[] markers;
		//Get markers
		markers = resource.findMarkers(CODE_LOCATION_MARKER_ID, false, IResource.DEPTH_ZERO);

		
		String id = codeLocation.getModelElementId().getId();
		for(IMarker m: markers){
			if(id.equals(m.getAttribute("modelElementId"))){
				//Marker exists! Update it
				m.setAttribute(IMarker.LINE_NUMBER, line);
				return m;
			}
		}
		
		//Marker does not exist, create it
		return createMarker(codeLocation,resource,line);
	}
	
	/**
	 * Updates all code location markers in a file. Also tries to move markers to other files
	 * if a code location has travelled (because cut&paste for example)
	 * @param resource the file for which to update markers
	 * @param unicaseProject a unicase project in which to search the code locations.
	 * @param deleteIfNotFound if true, markers for which the code location was not found will be deleted.
	 */
	public static void updateFileMarkers(IFile resource, Project unicaseProject, boolean deleteIfNotFound) {

		//Get markers
		try {
			IMarker[] markers;
			markers = resource.findMarkers(CODE_LOCATION_MARKER_ID, false, IResource.DEPTH_INFINITE);
		

			LocationFinder finder = LocationFinder.getInstance();
			ModelElementId mid = MetamodelFactory.eINSTANCE.createModelElementId();
			for(IMarker m: markers){
				//Try to get the model element for this marker
				String id = (String) m.getAttribute("modelElementId");
				
				//Marker has no id? Delete (this cannot happen normally)
				if(id == null){
					m.delete();
				}		
				
				//Get the associated code location in the project
				mid.setId(id);
				CodeLocation loc = (CodeLocation) unicaseProject.getModelElement(mid);
				
				if(loc == null){
					//No location? So it is either in another unicase project or was deleted.
					if(deleteIfNotFound) {
						m.delete();
					}
					continue;
				}
				
				//Try to find the location (and hand the file where the marker is as alternative file)
				FoundLocation location = finder.find(loc,resource);
				
				//Location has vanished? Delete marker
				if(location == null){
					m.delete();
					continue;
				}
				
				//The location was found in another resource? Delete this marker
				if(!location.getFile().equals(m.getResource())){
					m.delete();
					
					//Create the marker in the other resource
					createMarkerIfNotExistant(loc,location.getFile(),location.getLineNumber());
					continue;						
				}
				//Everything seems fine, so just update the marker's line
				m.setAttribute(IMarker.LINE_NUMBER, location.getLineNumber());
			}
		}catch(CoreException e){
			WorkspaceUtil.logException("Could not update code location markers for resource " + resource.getName(), e);		
		}
	}
		
	/**
	 * Refreshes all code location markers in the workspace for code locations in a specific unicase project.
	 * @param unicaseProject Unicase project for which to update the markers.
	 */
	public void refreshAllMarkers(Project unicaseProject){
		//Delete old markers
		try {
			ResourcesPlugin.getWorkspace().getRoot().deleteMarkers(CODE_LOCATION_MARKER_ID, false, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			WorkspaceUtil.logException("Could not update code location markers, because old markers could not be deleted.", e);	
			return;
		}
		
		//Get all code locations in the current project
		EList<CodeLocation> elements = unicaseProject.getAllModelElementsbyClass(TracePackage.Literals.CODE_LOCATION,new BasicEList<CodeLocation>());
		
		
		LocationFinder finder = LocationFinder.getInstance();
		for(CodeLocation cl : elements){
			//Find this location
			FoundLocation fl = finder.find(cl);
			if(fl == null){
				continue;
			}
			
			//Set the marker
			try {
				createMarker(cl, fl.getFile(), fl.getLineNumber());
			} catch (CoreException e) {
				WorkspaceUtil.logException("Could not create code location marker while updating all code location markers.", e);	
			}
			
		}
	
	}

	/**
	 * Retrieves a code location associated with a code location marker.
	 * Will return null if a core exception occurred (almost never), the location was deleted or in a project which is not checked out.
	 * @param marker the marker for which to retrieve the associated code location
	 * @return the associated code location or null if none was found 
	 */
	public static CodeLocation getLocationFromMarker(IMarker marker) {
		try {
			//No code location marker? Skip!
			if(!marker.isSubtypeOf(CODE_LOCATION_MARKER_ID)) {
				return null;
			}
			
			//Marker has no model element id attached? -> Marker broken (should not happen at all)
			String midString = marker.getAttribute("modelElementId", null);
			if(midString == null){
				return null;
			}
						
			//Create model element id
			ModelElementId mid = MetamodelFactory.eINSTANCE.createModelElementId();
			mid.setId(midString);
			
			//Search the corresponding code location.
			CodeLocation cl = null;
			EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
			for(ProjectSpace ps: projectSpaces){
				Project p = ps.getProject();
				if(p == null) {
					continue;
				}
				cl = (CodeLocation)p.getModelElement(mid);				
			}
			
			//Return if found (otherwise cl will be null)
			return cl;
		} catch (CoreException e) {
			//This exception is not handled since it virtually never appears (it is even ignored in eclipse's core code)
			return null;
		}
		
	}
}
