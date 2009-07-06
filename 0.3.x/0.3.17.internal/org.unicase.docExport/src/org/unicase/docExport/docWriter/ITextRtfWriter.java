/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.USeperator;

import com.lowagie.text.DocumentException;

/**
 * This class is a strategy of writing a Document. This class contains a strategy to write an UDocument to a file using
 * the RTF (Rich Text Format).
 * 
 * @author Sebastian Höcht
 */
public class ITextRtfWriter extends ITextWriter implements DocWriter {

	private static final String FILE_TYPE = "rtf";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeSeperator(Object parent, USeperator doc2) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return FILE_TYPE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.docWriter.DocWriter#export(java.lang.String,
	 *      org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection)
	 */
	public void export(String fileName, URootCompositeSection uDoc) {

		try {
			com.lowagie.text.rtf.RtfWriter2.getInstance(getDoc(), new FileOutputStream(fileName));
			getDoc().open();

			writeUDocument(getDoc(), uDoc);

			getDoc().close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
