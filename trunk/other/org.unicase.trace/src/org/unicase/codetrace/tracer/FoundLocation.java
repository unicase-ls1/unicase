package org.unicase.codetrace.tracer;

import org.eclipse.core.resources.IFile;

/**
 * This class represents a found location.
 * It is returned by the LocationFinder.find method and
 * can be handed to the EclipseWorkspaceManager class to
 * open the found location.
 * @author jfinis
 *
 */
public class FoundLocation {

	private IFile file;
	private int lineNumber;
	public IFile getFile() {
		return file;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public FoundLocation(IFile file, int lineNumber) {
		super();
		this.file = file;
		this.lineNumber = lineNumber;
	}


	
}
