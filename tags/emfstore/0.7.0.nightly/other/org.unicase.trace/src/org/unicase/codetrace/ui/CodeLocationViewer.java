/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.ui;

import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;

/**
 * Utility classes for showing specific locations
 * in eclipse. This is done by first changing to the
 * correct perspective, opening the correct file
 * and scrolling to the correct line.
 * @author kterziewa
 *
 */
public final class CodeLocationViewer {
	
	/**
	 * Utility class.
	 */
	private CodeLocationViewer(){}
	
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

}
