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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.ide.IDE;

public class TaskLocationLoader {
	
	public static void openTaskLocation(IFile file, int lineNumber, IWorkbenchPage page){
	
		HashMap map = new HashMap();
		map.put(IMarker.LINE_NUMBER, lineNumber);
		
		IMarker marker;
		try {
			marker = file.createMarker(IMarker.TEXT);
			marker.setAttributes(map);
			IDE.openEditor(page, marker); 
			marker.delete();

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
