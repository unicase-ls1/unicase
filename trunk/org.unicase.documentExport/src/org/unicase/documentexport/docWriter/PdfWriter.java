package org.unicase.documentexport.docWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.unicase.documentexport.renderers.elements.UCompositeSection;
import com.lowagie.text.DocumentException;

public class PdfWriter extends ITextWriter implements DocWriter {


	
	public PdfWriter() {
	}

	public void export(String fileName, UCompositeSection uDoc) {
		
		try {
			com.lowagie.text.pdf.PdfWriter.getInstance(doc, new FileOutputStream(fileName));
			doc.open();

			writeDocument(uDoc);
			
			doc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
