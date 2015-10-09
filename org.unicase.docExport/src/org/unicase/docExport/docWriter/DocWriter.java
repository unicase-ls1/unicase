/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import org.unicase.docExport.exceptions.DocumentExportException;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;

/**
 * This is the strategy class of the Strategy Design Pattern. There are several strategies for writing a rendered Model
 * Element to a document. Depending on the strategy itself, different libraries can be used to fulfill this task. There
 * even may be several DocWriters for one file type, using different libraries which have pros and cons. Each DocWriter
 * has to be registered in the DocWriterRegistry in order to be able to selected in the Export Document Dialog.
 * 
 * @see DocWriterRegistry
 * @author Sebastian Hoecht
 */
public interface DocWriter {

	/**
	 * Writes the document to a file. The filename is normally entered by the user with a SWT FileDialog. The look of
	 * the written document depends on the DocWriter itself and the RendererOptions of the UDocuments (Composite
	 * pattern!)
	 * 
	 * @see org.unicase.docExport.renderers.elements
	 * @param fileName the filename where the document shall be saved
	 * @param doc the document which shall be written to a file
	 * @throws DocumentExportException export failed
	 */
	void export(String fileName, URootCompositeSection doc) throws DocumentExportException;

	/**
	 * Returns the file type, which will be used for this export. For example "pdf"
	 * 
	 * @return the String of the file type
	 */
	String getFileType();
}
