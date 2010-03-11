/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.handlers;

import java.util.HashMap;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.ide.IDE;
import org.unicase.codetrace.tracer.FoundLocation;
import org.unicase.codetrace.tracer.LocationFinder;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.trace.CodeLocation;
import org.unicase.ui.common.util.ActionHelper;

/**
 * This handler changes current perspective to the java perspective 
 * and shows the code location in the editor. 
 * @author snogina
 *
 */
public class FindCodeLocationHandler extends AbstractHandler {

	/**
	 * Shows a specific line of a specific file in a workbench page.
	 * @param file the file to show
	 * @param lineNumber the line number to show
	 * @param page the workbench page in which to show the location
	 */
	public static void openTaskLocation(IFile file, int lineNumber, IWorkbenchPage page){
	
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

	/***
	 * . ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ModelElement me = ActionHelper.getModelElement(event);
		if (me instanceof CodeLocation) {
			LocationFinder finder = LocationFinder.getInstance();
			FoundLocation location = finder.find((CodeLocation)me);
			
			//change current perspective to the java perspective
			IWorkbench workbench = PlatformUI.getWorkbench();
			try {
				workbench.showPerspective("org.eclipse.jdt.ui.JavaPerspective", 
				workbench.getActiveWorkbenchWindow());
			} catch (WorkbenchException e) {			
				// TODO replace this with another exception
				e.printStackTrace();
			}
			
			IWorkbenchPage page  = workbench.getActiveWorkbenchWindow().getActivePage();
		
			openTaskLocation(location.getFile(), location.getLineNumber(), page);
		}

		return null;
	}

}
