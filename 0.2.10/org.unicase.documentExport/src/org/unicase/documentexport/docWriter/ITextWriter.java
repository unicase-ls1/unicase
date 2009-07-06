package org.unicase.documentexport.docWriter;

import java.awt.Color;
import java.util.Vector;

import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.elements.UDocument;
import org.unicase.documentexport.renderers.elements.UEntry;
import org.unicase.documentexport.renderers.elements.UParagraph;
import org.unicase.documentexport.renderers.elements.USection;
import org.unicase.documentexport.renderers.elements.UTable;
import org.unicase.documentexport.renderers.options.LayoutOptions;
import org.unicase.documentexport.renderers.options.TextOption;

import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

public class ITextWriter {

	public static final int INDENTION_WIDTH = 15;
	
	Document doc = new Document();
	LayoutOptions layoutOptions;
	
	/**
	 * write the root UCompositeSection.
	 * @throws DocumentException 
	 */
	protected void writeDocument(UCompositeSection uDoc) throws DocumentException {
		if (uDoc.option != null && uDoc.option instanceof LayoutOptions)
			this.layoutOptions = (LayoutOptions)uDoc.option;
		
		int chapterNumber = 1;
		for (UDocument child : uDoc.getChildren()) {
			if (child instanceof USection) {
				writeSection(doc, (USection)child, chapterNumber);
				chapterNumber++;
			}
			else {
				writeUDocument(doc, child);
			} 
		}
	}
	

	protected void writeCompositeSection(Object parent, UCompositeSection compositeSection) throws DocumentException {
		for (UDocument child : compositeSection.getChildren()) {
			writeUDocument(parent, child);
		}
	}

	protected void writeSection(Object parent, USection child, int chapterNumber) throws DocumentException {
		
		if (parent instanceof Document) {
			Paragraph chapterP = new Paragraph(
					(child).getTitle(), 
					getFont(layoutOptions.sectionTextOption)
				);
			Chapter chapter = new Chapter(chapterP, chapterNumber);
			chapter.setTriggerNewPage(false);		
			
			
			Vector<UDocument> children = child.getChildren();
			for (UDocument subChild : children) {
				writeUDocument(chapter, subChild);
			}

			((Document)parent).add(chapter);		
		}
		else if (parent instanceof Chapter) {
			Chapter chapter = (Chapter) parent;
			Section subSection = chapter.addSection(new Paragraph(
					(child).getTitle(), 
					getFont(layoutOptions.sectionTextOption)
				));

			Vector<UDocument> children = child.getChildren();
			for (UDocument subChild : children) {
				writeUDocument(subSection, subChild);
			}
		}
		else if (parent instanceof Section) {
			Section section = (Section) parent;
			Section subSection = section.addSection(new Paragraph(
					(child).getTitle(), 
					getFont(child.option)
				));

			Vector<UDocument> children = child.getChildren();
			for (UDocument subChild : children) {
				writeUDocument(subSection, subChild);
			}			
		}
	}

	protected void writeUDocument(Object parent, UDocument uDoc) throws DocumentException {
		if (uDoc instanceof USection) {
			writeSection(parent, (USection)uDoc, 0);
		} else if (uDoc instanceof UTable) {
			writeTable(parent, (UTable)uDoc);
		} else if (uDoc instanceof UParagraph) {
			writeParagraph(parent, (UParagraph)uDoc);
		} else if (uDoc instanceof UCompositeSection) {
			writeCompositeSection(parent, (UCompositeSection)uDoc);
		} 
	}

	protected void writeParagraph(Object parent, UParagraph child) throws DocumentException {
		Paragraph paragraph = getParagraph(child.getText(), child.option, child.getIndentionLeft());
		
		if (parent instanceof Document) {
			((Document)parent).add(paragraph);
		} else if (parent instanceof Chapter) {
			((Chapter)parent).add(paragraph);
		} else if (parent instanceof Section) {
			((Section)parent).add(paragraph);
		}
	}
	
	
	protected void writeTable(Object parent, UTable child) throws DocumentException {
		PdfPTable table = null;

		table = new PdfPTable(child.columnsCount);
		table.setWidthPercentage(100);
		table.setHeaderRows(1);
		table.setSplitRows(true);
		table.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
		table.getDefaultCell().setBackgroundColor(new Color(230, 230, 230));
		table.getDefaultCell().setBorderWidth((float)1.2);
		table.getDefaultCell().setBottom(5);
		table.setSpacingBefore(10);
		table.setSpacingAfter(10);
		
		for (UEntry entry: child.entries) {
			PdfPCell cell = new PdfPCell(new Paragraph(entry.text));
			cell.setColspan(entry.colspan);
			cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
			cell.setBorderWidth(entry.borderWidth);
			cell.setBackgroundColor(entry.backgroundColor);
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
	

	
	
	
	/*
	 * Help functions
	 */
	protected Paragraph getParagraph(String text, TextOption option) {
		return getParagraph(text, option, 0);
	}
	
	protected Paragraph getParagraph(String text, TextOption option, int indentionLeft) {
		Paragraph ret = new Paragraph(text, getFont(option));
		ret.setIndentationLeft(indentionLeft * INDENTION_WIDTH);
		return ret;
	}

	protected Font getFont(TextOption option) {
		Font font = FontFactory.getFont(getFontName(option), option.size, option.color);
		font.setStyle(getFontStyle(option));
		return font;
	}
	
	
	protected int getFontStyle(TextOption option) {
		int style;
		if (!option.bold)
			style = Font.NORMAL;
		else 
			style = Font.BOLD;
		
		if (option.italics)
			style |= Font.ITALIC;
		if (option.underline)
			style |= Font.UNDERLINE;
		if (option.strikethrough)
			style |= Font.STRIKETHRU;
		
		return style;
	}
	
	protected String getFontName(TextOption option) {
		if (option.fontFamily == TextOption.ARIAL)
			return FontFactory.HELVETICA;
		if (option.fontFamily == TextOption.TIMES_NEW_ROMAN)
			return FontFactory.TIMES_ROMAN;
		if (option.fontFamily == TextOption.COURIER)
			return FontFactory.COURIER;
		
		return FontFactory.HELVETICA;
	}
}
