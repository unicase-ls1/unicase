/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.eclipseworkspace;

import org.eclipse.core.resources.IFile;
import org.unicase.emfstore.jdt.configuration.Entry;

/**
 * A tuple that carries the information of an eclipse workspace file and the corresponding entry in the EMF Store JDT
 * configuration.
 * 
 * @author Adrian Staudt
 */
public class IFileEntryTuple {

	public final IFile file;
	public final Entry entry;

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

}
