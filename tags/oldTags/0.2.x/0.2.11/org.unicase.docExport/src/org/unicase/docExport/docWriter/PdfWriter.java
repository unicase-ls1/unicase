package org.unicase.docExport.docWriter;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UEntry;
import org.unicase.docExport.exportModel.renderers.elements.USeperator;
import org.unicase.docExport.exportModel.renderers.elements.UTable;

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

		PdfPTable containerTable = new PdfPTable(1);
		containerTable.setWidthPercentage(child.getWidthPercentage());
		containerTable.setSpacingBefore(10);
		containerTable.setSpacingAfter(10);
		containerTable.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
		containerTable.getDefaultCell().setBorderWidthLeft(child.getBorderLeft());
		containerTable.getDefaultCell().setBorderWidthRight(child.getBorderRight());
		containerTable.getDefaultCell().setBorderWidthTop(child.getBorderTop());
		containerTable.getDefaultCell().setBorderWidthBottom(child.getBorderBottom());
		
		PdfPTable table = null;

		table = new PdfPTable(child.getColumnsCount());
		table.setWidthPercentage(100);
		table.setHeaderRows(1);
		table.setSplitRows(true);
		table.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
		table.getDefaultCell().setBorderWidthLeft(child.getCellBorderLeft());
		table.getDefaultCell().setBorderWidthRight(child.getCellBorderRight());
		table.getDefaultCell().setBorderWidthTop(child.getCellBorderTop());
		table.getDefaultCell().setBorderWidthBottom(child.getCellBorderBottom());
		table.getDefaultCell().setBackgroundColor(new Color(230, 230, 230));
		table.getDefaultCell().setBottom(5);
		if (child.getColumnsWidths() != null) {
			table.setWidths(child.getColumnsWidths());
		}
		table.setSpacingBefore(10);
		table.setSpacingAfter(10);
		
		for (UEntry entry: child.getEntries()) {
			PdfPCell cell = new PdfPCell(new Paragraph(entry.getText(), getFont(entry.getTextOption())));
			cell.setColspan(entry.getColspan());
			cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
			cell.setBorderWidthLeft(entry.getBorderLeft());
			cell.setBorderWidthRight(entry.getBorderRight());
			cell.setBorderWidthTop(entry.getBorderTop());
			cell.setBorderWidthBottom(entry.getBorderBottom());
			cell.setBackgroundColor(entry.getBackgroundColor());
			table.addCell(cell);
		}
		
		containerTable.addCell(table);
		
		if (parent instanceof Document) {
			((Document)parent).add(containerTable);
		} else if (parent instanceof Chapter) {
			((Chapter)parent).add(containerTable);
		} else if (parent instanceof Section) {
			((Section)parent).add(containerTable);
		}
	}

	@Override
	protected void writeSeperator(Object parent, USeperator uSeperator) throws DocumentException {


		PdfPTable containerTable = new PdfPTable(1);
		containerTable.setSpacingBefore(5);
		containerTable.setSpacingAfter(5);
		containerTable.setWidthPercentage(uSeperator.getWidthPercentage());
		containerTable.getDefaultCell().setBorder(Rectangle.TOP);
		containerTable.getDefaultCell().setBorderWidth(uSeperator.getHeight());
		
		containerTable.addCell(new PdfPTable(1));
		
		
		if (parent instanceof Document) {
			((Document)parent).add(containerTable);
		} else if (parent instanceof Chapter) {
			((Chapter)parent).add(containerTable);
		} else if (parent instanceof Section) {
			((Section)parent).add(containerTable);
		}
	}

}
