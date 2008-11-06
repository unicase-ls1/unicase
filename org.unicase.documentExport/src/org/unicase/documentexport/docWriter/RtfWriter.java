package org.unicase.documentexport.docWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.elements.UTable;

import com.lowagie.text.DocumentException;

/**
 * This class is a strategy of writing a Document. 
 * This class contains a strategy to write an UDocument to a file using the
 * RTF (Rich Text Format).
 * 
 * @author Sebastian Höcht
 */
public class RtfWriter extends ITextWriter implements DocWriter {
	/**
	 * {@inheritDoc}
	 * @see org.unicase.documentExport.docWriter.DocWriter#export(String, UCompositeSection)
	 */
	public void export(String fileName, UCompositeSection uDoc) {
		
		try {
			com.lowagie.text.rtf.RtfWriter2.getInstance(getDoc(), new FileOutputStream(fileName));
			getDoc().open();

			writeDocument(uDoc);
			
			getDoc().close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeTable(Object parent, UTable child)
			throws DocumentException {
		// TODO Auto-generated method stub
		
	}
}
