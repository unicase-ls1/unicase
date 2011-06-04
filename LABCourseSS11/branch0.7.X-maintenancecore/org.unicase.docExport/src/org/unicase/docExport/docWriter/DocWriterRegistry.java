/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import java.util.ArrayList;

/**
 * This is registry class for all available DocWriters.
 * 
 * @see DocWriter
 * @author Sebastian Hoecht
 */
public final class DocWriterRegistry {

	private DocWriterRegistry() {

	}

	/**
	 * returns all possible DocWriter instances.
	 * 
	 * @return instances of the DocWriters
	 */
	public static ArrayList<DocWriter> getDocWriters() {
		ArrayList<DocWriter> docWriters = new ArrayList<DocWriter>();
		docWriters.add(new FopPdfWriter());
		docWriters.add(new FopRtfWriter());
		docWriters.add(new FopHTMLWriter());
		docWriters.add(new ITextPdfWriter());
		docWriters.add(new ITextRtfWriter());
		docWriters.add(new ITextRtfHeadingWriter());

		return docWriters;
	}
}
