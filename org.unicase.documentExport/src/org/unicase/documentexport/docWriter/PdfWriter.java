package org.unicase.documentexport.docWriter;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.elements.UEntry;
import org.unicase.documentexport.renderers.elements.UTable;

import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

/**
 * This class is a strategy of writing a Document. 
 * This class contains a strategy to write an UDocument to a file using the
 * PDF (Portable Document Format).
 * 
 * @author Sebastian Höcht
 */
public class PdfWriter extends ITextWriter implements DocWriter {

	/**
	 * {@inheritDoc}
	 * @see org.unicase.documentExport.docWriter.DocWriter#export(String, UCompositeSection)
	 */
	public void export(String fileName, UCompositeSection uDoc) {
		
		try {
			com.lowagie.text.pdf.PdfWriter.getInstance(getDoc(), new FileOutputStream(fileName));
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
	protected void writeTable(Object parent, UTable child) throws DocumentException {
		PdfPTable table = null;

		table = new PdfPTable(child.getColumnsCount());
		table.setWidthPercentage(100);
		table.setHeaderRows(1);
		table.setSplitRows(true);
		table.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
		table.getDefaultCell().setBackgroundColor(new Color(230, 230, 230));
		table.getDefaultCell().setBorderWidth((float)1.2);
		table.getDefaultCell().setBottom(5);
		table.setSpacingBefore(10);
		table.setSpacingAfter(10);
		
		for (UEntry entry: child.getEntries()) {
			PdfPCell cell = new PdfPCell(new Paragraph(entry.getText()));
			cell.setColspan(entry.getColspan());
			cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
			cell.setBorderWidth(entry.getBorderWidth());
			cell.setBackgroundColor(entry.getBackgroundColor());
			table.addCell(cell);
		}
		
		if (parent instanceof Document) {
			((Document)parent).add(table);
		} else if (parent instanceof Chapter) {
			((Chapter)parent).add(table);
		} else if (parent instanceof Section) {
			((Section)parent).add(table);
		}
	}

}
