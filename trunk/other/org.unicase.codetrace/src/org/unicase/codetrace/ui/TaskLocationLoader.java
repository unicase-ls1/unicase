package org.unicase.codetrace.ui;

import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;

public class TaskLocationLoader {
	
	public static void openTaskLocation(IFile file, int lineNumber, IWorkbenchPage page){
	//	IFile file = <choose the file to open>;
	//	IWorkbenchPage page = <the page to open the editor in>;
		HashMap map = new HashMap();
		map.put(IMarker.LINE_NUMBER, lineNumber);
	
		IMarker marker;
		try {
			marker = file.createMarker(IMarker.TEXT);
			marker.setAttributes(map);
			IDE.openEditor(page, marker); // gotoMarker(editor, marker); // .openEditor(marker, file); //3.0 API
			marker.delete();

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   //page.openEditor(marker); //2.1 API
	
		
	}

}
