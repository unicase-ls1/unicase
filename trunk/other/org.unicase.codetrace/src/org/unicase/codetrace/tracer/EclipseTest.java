package org.unicase.codetrace.tracer;


import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
public class EclipseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IWorkspace w = ResourcesPlugin.getWorkspace();
		w.getRoot().getProject("Arsch").getLocation();
		if(true);
	}

}
