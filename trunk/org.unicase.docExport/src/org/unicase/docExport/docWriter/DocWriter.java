package org.unicase.docExport.docWriter;

import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;

/**
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
	 */
	void export(String fileName, URootCompositeSection doc);

	/**
	 * Returns the file type, which will be used for this export. For example "pdf"
	 * 
	 * @return the String of the file type
	 */
	String getFileType();
}
