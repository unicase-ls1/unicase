/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
	
	/**
	 * Returns the file.
	 * @return file
	 */
	
	public IFile getFile() {
		return file;
	}
	
	/**
	 * Returns the number of line.
	 * @return the line number
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	
	/**
	 * The constructor.
	 * @param file file contain the code location
	 * @param lineNumber number of line with the code location 
	 */
	public FoundLocation(IFile file, int lineNumber) {
		super();
		this.file = file;
		this.lineNumber = lineNumber;
	}
	
}
