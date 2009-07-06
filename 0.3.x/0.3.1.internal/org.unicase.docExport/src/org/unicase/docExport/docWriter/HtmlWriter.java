package org.unicase.docExport.docWriter;

import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;

/**
 * @author Sebastian Höcht
 */
public class HtmlWriter implements DocWriter{

	private static final String FILE_TYPE = "html";

	/**
	 * {@inheritDoc}
	 * @see org.unicase.documentExport.docWriter.DocWriter#export(String, UCompositeSection)
	 */
	public void export(String fileName, URootCompositeSection doc) {
		// TODO Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return FILE_TYPE;
	}

}
