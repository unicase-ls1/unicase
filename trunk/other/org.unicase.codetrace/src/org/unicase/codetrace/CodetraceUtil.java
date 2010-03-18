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
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.trace.CodeLocation;
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
					"No code location found. \nThe code location was deleted or project was not checked out.");
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
	 * Returns the path of the workspace root. 
	 * @return the path of the workspace
	 */
	public static String getWorkspaceRootPath(){
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		return root.toString();
	}
	
	
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
				"No unicase project is active at the moment. \n Please open a unicase project and try again.");
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
}
