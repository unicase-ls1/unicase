/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.tracer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

public class EclipseWorkspaceManager {

	private IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
	
	static{
		IWorkspace w = ResourcesPlugin.getWorkspace();
		w.getRoot().getProject("test").getLocation();
		if(true);
	}
	
	/**
	 * 
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
	 * Gets the name of the project location.
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
	 * Returns the name of the workspace root. 
	 * @return the name of the workspace
	 */
	public static String getWorkspace(){
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		return root.toString();
	}
}
