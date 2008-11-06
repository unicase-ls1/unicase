package org.unicase.documentexport.docWriter;


import org.unicase.documentexport.renderers.elements.UCompositeSection;
/**
 * 
 * @author Sebastian Höcht
 *
 */
public interface DocWriter {
	
	/**
	 * Writes the document to a file. The filename is normally entered by the user with a
	 * SWT FileDialog. The look of the written document depends on the DocWriter itself and
	 * the RendererOptions of the UDocuments (Composite pattern!)
	 * @see org.unicase.documentexport.renderers.elements
	 * 
	 * @param fileName the filename where the document shall be saved
	 * @param doc the document which shall be written to a file
	 */
	 public void export(String fileName, UCompositeSection doc);
}
