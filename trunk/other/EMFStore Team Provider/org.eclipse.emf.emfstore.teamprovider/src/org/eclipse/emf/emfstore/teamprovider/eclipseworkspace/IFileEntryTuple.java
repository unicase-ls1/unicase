/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.eclipseworkspace;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.emfstore.teamprovider.configuration.Entry;

/**
 * A tuple that carries the information of an eclipse workspace file and the corresponding entry in the EMF Store JDT
 * configuration.
 * 
 * @author Adrian Staudt
 */
public class IFileEntryTuple {

	/**
	 * The eclipse workspace file part.
	 */
	private final IFile file;

	/**
	 * The EMF Store JDT entry that corresponds to the file part.
	 */
	private final Entry entry;

	/**
	 * Constructor.
	 * 
	 * @param file An eclipse workspace file.
	 * @param entry An EMF Store JDT entry.
	 */
	public IFileEntryTuple(IFile file, Entry entry) {
		this.file = file;
		this.entry = entry;
	}

	/**
	 * Returns the eclipse workspace file part.
	 * 
	 * @return The eclipse workspace file part.
	 */
	public IFile getFile() {
		return file;
	}

	/**
	 * Returns the EMF Store JDT entry part.
	 * 
	 * @return The EMF Store JDT entry part.
	 */
	public Entry getEntry() {
		return entry;
	}

}
