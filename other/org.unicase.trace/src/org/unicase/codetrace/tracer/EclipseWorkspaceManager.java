package org.unicase.codetrace.tracer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

public class EclipseWorkspaceManager {

	private IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
	
	static{
		IWorkspace w = ResourcesPlugin.getWorkspace();
		w.getRoot().getProject("Arsch").getLocation();
		if(true);
	}
	
	public static String getPathOfFile(String projectName, String pathInProject){
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject p = root.getProject(projectName);
		if(p == null) return null;
		return p.getLocation().toString() + "/" + pathInProject;	
	}
}
