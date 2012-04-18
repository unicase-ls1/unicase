/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.unicase.docExport.Activator;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UDocument;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.ULink;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UPageNumber;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.URef;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.elements.UTableOfContents;
import org.unicase.docExport.exportModel.renderers.elements.UTextPart;
import org.unicase.docExport.exportModel.renderers.options.FontFamily;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UColor;
import org.unicase.workspace.util.WorkspaceUtil;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Jpeg;
import com.lowagie.text.List;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;
import com.lowagie.text.Table;

/**
 * This class is the superclass of all DocWriters that use the iText library for writing an UDocument. The iText library
 * is a very fast and direct possibility to create documents. The main target is PDF, but it also supports other
 * document formats like RTF and HTML. see: http://www.lowagie.com/iText/
 * 
 * @author Sebastian Hoecht
 */
public abstract class ITextWriter {

	private static final String DEFAULT_ERROR_IMAGE = "ERROR.jpg";

	/**
	 * Defines the width of the left indention of sections. The real width normally is mulitplicated with the depth of
	 * the section.
	 */
	public static final int INDENTION_WIDTH = 15;

	private static final String DEFAULT_FONT = FontFactory.HELVETICA;;

	/**
	 * The iText document which has to be opened and closed in the subclass. The doc is used to write some information
	 * into the document like text, images, tables etc.
	 */
	private Document doc = new Document();

	/**
	 * @return the doc
	 */
	protected Document getDoc() {
		return doc;
	}

	/**
	 * @param doc the doc to set
	 */
	protected void setDoc(Document doc) {
		this.doc = doc;
	}

	/**
	 * @param parent the xml fo Element
	 * @param uDoc the document which shall be written
	 * @throws DocumentException -
	 */
	protected void writeUDocument(Object parent, UDocument uDoc) throws DocumentException {
		if (uDoc instanceof USection) {
			writeSection(parent, (USection) uDoc);
		} else if (uDoc instanceof UTextPart) {
			writeUTextPart(parent, (UTextPart) uDoc);
		} else if (uDoc instanceof UTableOfContents) {
			UTableOfContents tableOfContents = (UTableOfContents) uDoc;
			writeUTableOfContents(parent, tableOfContents.getRootSection(), tableOfContents.getTextOption());
		} else if (uDoc instanceof URef) {
			writeURef(parent, (URef) uDoc);
		} else if (uDoc instanceof ULink) {
			writeULink(parent, (ULink) uDoc);
		} else if (uDoc instanceof UPageNumber) {
			writePageNumber(parent, (UPageNumber) uDoc);
		} else if (uDoc instanceof UParagraph) {
			writeUParagraph(parent, (UParagraph) uDoc);
		} else if (uDoc instanceof UList) {
			writeUList(parent, (UList) uDoc);
		} else if (uDoc instanceof UTable) {
			writeUTable(parent, (UTable) uDoc);
		} else if (uDoc instanceof UImage) {
			writeUImage(parent, (UImage) uDoc);
		} else if (uDoc instanceof URootCompositeSection) {
			writeURootCompositeSection(parent, (URootCompositeSection) uDoc);
		} else if (uDoc instanceof UCompositeSection) {
			writeUCompositeSection(parent, (UCompositeSection) uDoc);
		} else {
			WorkspaceUtil.log(uDoc.getClass().getSimpleName() + "not implemented yet", new Exception(), IStatus.ERROR);
		}
	}

	private void writeURootCompositeSection(Object parent, URootCompositeSection root) throws DocumentException {
		for (UDocument child : root.getChildren()) {
			writeUDocument(getDoc(), child);
		}
	}

	private void writeUCompositeSection(Object parent, UCompositeSection uDoc) throws DocumentException {
		for (UDocument child : uDoc.getChildren()) {
			writeUDocument(getDoc(), child);
		}
	}

	private void writeUImage(Object parent, UImage uImage) throws DocumentException {
		try {
			Image image = new Jpeg(uImage.getPath().toFile().toURI().toURL());
			scaleImageToFit(image);
			addItextObject(parent, image);
		} catch (MalformedURLException e) {
			throw new DocumentException(e);
		} catch (IOException e) {
			handleErroneousImage(parent);
		} catch (BadElementException e) {
			handleErroneousImage(parent);
		} catch (DocumentException e) {
			throw new DocumentException(e);
		}
	}

	private void scaleImageToFit(Image image) {
		if (image.getWidth() > getDoc().right() - getDoc().rightMargin()) {
			float scaleRatio = ((getDoc().right() - getDoc().rightMargin())) / image.getWidth();
			image.scaleAbsoluteWidth(scaleRatio * image.getWidth());
			image.scaleAbsoluteHeight(scaleRatio * image.getHeight());
		}
	}

	private void handleErroneousImage(Object parent) throws BadElementException, DocumentException {
		URL location = FileLocator.find(Activator.getDefault().getBundle(), new Path("docExportImages"), null);
		try {
			Image image = new Jpeg(new File(FileLocator.resolve(location).getPath().toString() + File.separator
				+ DEFAULT_ERROR_IMAGE).toURI().toURL());
			scaleImageToFit(image);
			addItextObject(parent, image);
		} catch (MalformedURLException e) {
			throw new DocumentException(e);
		} catch (IOException e) {
			throw new DocumentException(e);
		}
	}

	private void writeUList(Object parent, UList doc2) {
		// TODO Auto-generated method stub
	}

	/**
	 * @param parent the iText parent object where the paragraph shall be added
	 * @param par the paragraph which shall be written
	 * @throws DocumentException -
	 */
	protected void writeUParagraph(Object parent, UParagraph par) throws DocumentException {
		if (par.getText() == null || par.getText().length() < 1) {
			return;
		}
		Paragraph paragraph = getParagraph(par);

		addItextObject(parent, paragraph);
	}

	private void writePageNumber(Object parent, UPageNumber doc2) {
		// TODO Auto-generated method stub

	}

	private void writeULink(Object parent, ULink doc2) {
		// TODO Auto-generated method stub

	}

	private void writeURef(Object parent, URef doc2) {
		// TODO Auto-generated method stub

	}

	private void writeUTableOfContents(Object parent, USection rootSection, TextOption textOption) {
		// TODO Auto-generated method stub

	}

	private void writeUTextPart(Object parent, UTextPart textPart) throws DocumentException {
		Chunk chunk = new Chunk(textPart.getText(), getFont(textPart.getOption()));

		addItextObject(parent, chunk);
	}

	/**
	 * Writing a section is very fundamental for the structure of a document. This function will be called recursively
	 * because an USection can also have children. The Problem in this function is the following: iText has three
	 * different types of parents, where an USection can be written: 1) The iText document itself: you have to create a
	 * new Chapter and supply the chapter number 2) An iText Chapter: you have to use the Chapter::addSection() function
	 * 3) An iText Section: you have to use the Section::addSection() function
	 * 
	 * @param parent the parent iText Object
	 * @param child the USection that shall be written in this function
	 * @throws DocumentException -
	 */
	protected void writeSection(Object parent, USection child) throws DocumentException {

		if (parent instanceof Document) {
			UParagraph titleUParagraph = child.getTitlParagraph();

			Paragraph chapterP = getParagraph(titleUParagraph);

			Chapter chapter = new Chapter(chapterP, child.getSectionNumber());
			chapter.setIndentationLeft(getIndentionDepth(child) * INDENTION_WIDTH);
			chapter.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);
			chapter.setNumberDepth(0);
			chapter.setTriggerNewPage(false);

			Vector<UDocument> children = child.getChildren();
			for (UDocument subChild : children) {
				writeUDocument(chapter, subChild);
			}

			((Document) parent).add(chapter);
		} else if (parent instanceof Chapter) {
			UParagraph titleUParagraph = child.getTitlParagraph();

			Paragraph chapterP = getParagraph(titleUParagraph);

			Chapter chapter = (Chapter) parent;
			Section subSection = chapter.addSection(chapterP);
			subSection.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);
			subSection.setIndentationLeft(getIndentionDepth(child) * INDENTION_WIDTH);
			if (child.getSectionOption().getSectionNumberingStyle().equals(SectionNumberingStyle.NONE)) {
				subSection.setNumberDepth(0);
			}

			Vector<UDocument> children = child.getChildren();
			for (UDocument subChild : children) {
				writeUDocument(subSection, subChild);
			}
		} else if (parent instanceof Section) {
			UParagraph titleUParagraph = child.getTitlParagraph();

			Paragraph chapterP = getParagraph(titleUParagraph);

			Section section = (Section) parent;
			Section subSection = section.addSection(chapterP);
			subSection.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);
			subSection.setIndentationLeft(getIndentionDepth(child) * INDENTION_WIDTH);
			if (child.getSectionOption().getSectionNumberingStyle().equals(SectionNumberingStyle.NONE)) {
				subSection.setNumberDepth(0);
			}

			Vector<UDocument> children = child.getChildren();
			for (UDocument subChild : children) {
				writeUDocument(subSection, subChild);
			}
		} else {
			WorkspaceUtil.log("unkown parent of USection: " + parent.getClass(), new Exception(), IStatus.WARNING);
		}
	}

	/**
	 * @param parent the iText parent object
	 * @param uList the uList with the information how to write the list
	 * @throws DocumentException -
	 */
	protected void writeList(Object parent, UList uList) throws DocumentException {

		ListStyle listStyle = uList.getListOption().getListStyle();
		if (listStyle == ListStyle.BULLETED) {
			List list = new List(false);
			list.setIndentationLeft(INDENTION_WIDTH * uList.getIndentionLeft());
			for (String text : uList.getContents()) {
				list.add(text);
			}
			addItextObject(parent, list);
		} else if (listStyle == ListStyle.ALPHA) {
			List list = new List(true, true);
			list.setIndentationLeft(INDENTION_WIDTH * uList.getIndentionLeft());
			for (String text : uList.getContents()) {
				list.add(text);
			}
			addItextObject(parent, list);
		} else if (listStyle == ListStyle.NUMBERED) {
			List list = new List(true);
			list.setIndentationLeft(INDENTION_WIDTH * uList.getIndentionLeft());
			for (String text : uList.getContents()) {
				list.add(text);
			}
			addItextObject(parent, list);
		} else if (listStyle == ListStyle.JUST_NEW_LINES) {
			for (String text : uList.getContents()) {
				Paragraph par = new Paragraph(text);
				par.setIndentationLeft(INDENTION_WIDTH * uList.getIndentionLeft());
				addItextObject(parent, par);
			}
		} else if (listStyle == ListStyle.SEPERATED_LIST) {
			String text = "";
			for (String innerText : uList.getContents()) {
				text += innerText + ", ";
			}
			if (text.length() > 3) {
				text = text.substring(0, text.length() - 3);
			}

			Paragraph par = new Paragraph(text);
			par.setIndentationLeft(INDENTION_WIDTH * uList.getIndentionLeft());
			addItextObject(parent, par);
		} else {
			WorkspaceUtil.log("The ListStyle " + listStyle.getLiteral() + " hasn't been implemented yet",
				new Exception(), IStatus.WARNING);
		}

	}

	/**
	 * @param uDoc the document of which the left indention is requested
	 * @return the correct indention depth concerning iText logic
	 */
	protected int getIndentionDepth(UDocument uDoc) {
		int ret = 0;

		UDocument parent = uDoc;
		while (parent != null) {
			if (parent instanceof UParagraph) {
				ret += ((UParagraph) parent).getIndentionLeft();
				parent = parent.getParent();
			} else if (parent instanceof USection) {
				USection section = (USection) parent;
				ret += section.getIndentionLeft();
				parent = null;
			} else {
				parent = parent.getParent();
			}
		}

		return ret;
	}

	/**
	 * Returns a new iText Paragraph which look is decorated by the TextoOption and the depth of the indention.
	 * Additionally, UTextParts are added as chunks of the Paragraph, if there are UTextParts contained in this
	 * UParagraph (same with UParagraph as child)
	 * 
	 * @param paragraph the paragraph containing the information to write
	 * @return a new iText Paragraph
	 * @throws DocumentException -
	 */
	protected Paragraph getParagraph(UParagraph paragraph) throws DocumentException {
		Paragraph ret = new Paragraph(paragraph.getText(), getFont(paragraph.getOption()));

		ret.setIndentationLeft(getIndentionDepth(paragraph) * INDENTION_WIDTH);
		for (UDocument child : paragraph.getChildren()) {
			if (child instanceof UParagraph) {
				writeUParagraph(ret, (UParagraph) child);
			} else if (child instanceof UTextPart) {
				writeUTextPart(ret, (UTextPart) child);
			} else {
				WorkspaceUtil.log("Only UParagraph and UTextPart are possible children of an UParagraph",
					new Exception(), IStatus.WARNING);
			}
		}

		if (paragraph.getOption().getTextAlign().equals(TextAlign.CENTER)) {
			ret.setAlignment(Paragraph.ALIGN_CENTER);
		} else if (paragraph.getOption().getTextAlign().equals((TextAlign.END))) {
			ret.setAlignment(Paragraph.ALIGN_RIGHT);
		}

		return ret;
	}

	/**
	 * Returns an iText Font using the information in the TextOption.
	 * 
	 * @param option the TextOption which contains size, font-family, color etc. information.
	 * @return the iText Font
	 */
	protected Font getFont(TextOption option) {
		if (option == null) {
			WorkspaceUtil.log("The TextOption is null - Helvetica will be used. This shouldn't happen!",
				new Exception(), IStatus.ERROR);
			return FontFactory.getFont(FontFactory.HELVETICA);
		}
		Font font = FontFactory.getFont(getFontName(option), option.getFontSize(), getColor(option.getFontColor()));
		font.setStyle(getFontStyle(option));
		return font;
	}

	/**
	 * converts a UColor to an awt Color.
	 * 
	 * @param color the color to convert
	 * @return the converted Color
	 */
	protected Color getColor(UColor color) {
		Color ret = new Color(color.getRed(), color.getGreen(), color.getBlue());
		return ret;
	}

	/**
	 * Returns the iText Font style bitmap using the information of the TextOption.
	 * 
	 * @param option contains some Font style information.
	 * @return the iText Font style bitmap.
	 */
	protected int getFontStyle(TextOption option) {
		int style;
		if (!option.isBold()) {
			style = Font.NORMAL;
		} else {
			style = Font.BOLD;
		}
		if (option.isUnderline()) {
			style |= Font.UNDERLINE;
		}

		return style;
	}

	/**
	 * Returns the iText FontName constant of the font-family store in the TextOption. The font Family default to
	 * DEFAULT_FONT it the font-family is unknown or empty
	 * 
	 * @param option the TextOption containing the font-family information
	 * @return the iText FontName
	 */
	protected String getFontName(TextOption option) {
		if (option.getFontFamily() == FontFamily.HELVETICA) {
			return FontFactory.HELVETICA;
		} else if (option.getFontFamily() == FontFamily.TIMES_NEW_ROMAN) {
			return FontFactory.TIMES_ROMAN;
		} else if (option.getFontFamily() == FontFamily.COURIER) {
			return FontFactory.COURIER;
		} else if (option.getFontFamily() == FontFamily.HELVETICA) {
			return FontFactory.HELVETICA;
		}
		return DEFAULT_FONT;
	}

	/**
	 * @param parent the iText parent object
	 * @param toAdd the iText object, which shall be added
	 * @param headingsOn true if headings should be written (necessary for the RtfHeadingWriter)
	 * @throws DocumentException -
	 */
	protected void addItextObject(Object parent, Object toAdd, boolean headingsOn) throws DocumentException {
		if (parent instanceof Document) {
			if (headingsOn) {
				((Document) parent).add((Element) toAdd);
			} else {
				Paragraph container = new Paragraph();
				container.add(toAdd);
				((Document) parent).add(container);
			}
		} else if (parent instanceof Chapter) {
			((Chapter) parent).add(toAdd);
		} else if (parent instanceof Section) {
			((Section) parent).add(toAdd);
		} else if (parent instanceof Paragraph) {
			((Paragraph) parent).add(toAdd);
		} else {
			WorkspaceUtil.log("The parent of the type " + parent.getClass().getSimpleName() + " "
				+ "can't be used here. Nothing will be written to the document.", new Exception(), IStatus.ERROR);
		}
	}

	/**
	 * @param parent the iText parent object
	 * @param toAdd the iText object, which shall be added
	 * @throws DocumentException -
	 */
	protected void addItextObject(Object parent, Object toAdd) throws DocumentException {
		addItextObject(parent, toAdd, false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.docWriter.ITextWriter#writeUTable(java.lang.Object,
	 *      org.unicase.docExport.exportModel.renderers.elements.UTable)
	 */
	protected void writeUTable(Object parent, UTable uTable) throws DocumentException {

		Table table = new Table(uTable.getColumnsCount());
		table.setBorderWidth((float) uTable.getBoxModel().getBorder());
		table.setBorderColor(new Color(uTable.getBoxModel().getBorderColor().getRed(), uTable.getBoxModel()
			.getBorderColor().getGreen(), uTable.getBoxModel().getBorderColor().getBlue()));
		table.setPadding(1);

		table.setBackgroundColor(getColor(uTable.getBoxModel().getBackgroundColor()));

		if (uTable.getColumnsCount() == uTable.getColumnsWidths().length) {
			table.setWidths(uTable.getColumnsWidths());
		}

		table.setLeft(getIndentionDepth(uTable) * INDENTION_WIDTH);
		table.setWidth(100);

		for (UTableCell uCell : uTable.getEntries()) {
			Cell cell;
			TextOption option = OptionsFactory.eINSTANCE.createTextOption();
			option.setFontSize(10);

			UDocument content = uCell.getContent();
			String contentString = "n/a";
			if (content instanceof UParagraph) {
				UParagraph paragraph = (UParagraph) content;

				if (paragraph.getChildren().size() > 0 && paragraph.getChildren().get(0) instanceof UImage) {
					UImage image = (UImage) paragraph.getChildren().get(0);
					if (image.getPath().lastSegment().startsWith("false")) {
						cell = new Cell("no");
					} else if (image.getPath().lastSegment().startsWith("true")) {
						cell = new Cell("yes");
					} else {
						cell = new Cell(image.getPath().lastSegment());
					}

				} else {
					contentString = getUParagraphStringRecursivly(paragraph);

					// cut out the last new line
					if (contentString.length() > 1) {
						contentString = contentString.substring(0, contentString.length() - 1);
					}

					Paragraph cellParagraph = new Paragraph(contentString, getFont(option));
					cell = new Cell(cellParagraph);

					if (uCell.getBoxModel().getBackgroundColor() != null) {
						cell.setBackgroundColor(getColor(uCell.getBoxModel().getBackgroundColor()));
					}
				}
			} else {
				cell = new Cell(new Paragraph(contentString, getFont(option)));
			}

			table.addCell(cell);
		}

		addItextObject(parent, table);
	}

	private String getUParagraphStringRecursivly(UParagraph paragraph) {
		String ret = "";
		if (paragraph.getText() != null && paragraph.getText().length() > 0) {
			ret = paragraph.getText() + "\n";
		}

		for (UDocument child : paragraph.getChildren()) {
			if (child instanceof UParagraph) {
				UParagraph subParagraph = (UParagraph) child;
				ret += getUParagraphStringRecursivly(subParagraph);
			}
		}

		return ret;
	}
}
