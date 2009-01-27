/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.unicase.docExport.exportModel.renderers.elements.UDocument;
import org.unicase.docExport.exportModel.renderers.elements.ULink;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.w3c.dom.Element;

/**
 * @author Sebastian Hoecht
 */
public class FopRtfWriter extends FopWriter {
	// configure fopFactory as desired
	private FopFactory fopFactory = FopFactory.newInstance();

	private static final int RTF_CONTENT_WIDTH = 505;

	/**
	 * {@inheritDoc}
	 */
	public void export(String fileName, URootCompositeSection doc) {

		setURoot(doc);

		File fo = createFOFile(doc);

		OutputStream out = null;

		try {
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			// configure foUserAgent as desired

			// Setup output stream. Note: Using BufferedOutputStream
			// for performance reasons (helpful with FileOutputStreams).
			out = new FileOutputStream(fileName);
			out = new BufferedOutputStream(out);

			// Construct fop with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_RTF, foUserAgent, out);

			// Setup JAXP using identity transformer
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(); // identity transformer

			// Setup input stream
			Source src = new StreamSource(fo);

			// Resulting SAX events (the generated FO) must be piped through to FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Start XSLT transformation and FOP processing
			transformer.transform(src, res);

		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (FOPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param parent the parent element where the table of contents shall be written
	 * @param uSection the section containing the document structure, which is the content of the table of contents
	 * @param textOption the TextOption which decorates the text of the TOC
	 * @see org.unicase.docExport.docWriter.FopWriter#writeUTableOfContents(org.w3c.dom.Element,
	 *      org.unicase.docExport.exportModel.renderers.elements.USection,
	 *      org.unicase.docExport.exportModel.renderers.options.TextOption)
	 */
	@Override
	protected void writeUTableOfContents(Element parent, USection uSection, TextOption textOption) {
		Element toc = getDoc().createElement("fo:block");
		toc.setAttribute("id", "table_of_contents");
		toc.setAttribute("font-size", "22pt");
		toc.setTextContent("Table of Contents");
		toc.setAttribute("text-align", "center");
		toc.setAttribute("break-before", "page");
		parent.appendChild(toc);

		Element table = getDoc().createElement("fo:table");
		parent.appendChild(table);
		table.setAttribute("margin-top", "10pt");

		Element tableBody = getDoc().createElement("fo:table-body");
		table.appendChild(tableBody);

		writeUTableOfContentsEntry(tableBody, uSection, textOption);
	}

	/**
	 * @param tableBody the fo:table-body xml node element
	 * @param uSection the section containing the document structure, which is the content of the table of contents
	 * @param textOption the TextOption which decorates the text of the TOC
	 * @see org.unicase.docExport.docWriter.FopWriter#writeUTableOfContentsEntry(org.w3c.dom.Element,
	 *      org.unicase.docExport.exportModel.renderers.elements.USection,
	 *      org.unicase.docExport.exportModel.renderers.options.TextOption)
	 */
	@Override
	protected void writeUTableOfContentsEntry(Element tableBody, USection uSection, TextOption textOption) {
		for (USection section : uSection.getSubSections()) {
			if (!section.getSectionOption().isLeaveOutPreviousSectionNumbering()) {
				Element tableRow = getDoc().createElement("fo:table-row");
				tableBody.appendChild(tableRow);
				setTextOption(tableRow, textOption);

				Element sectionNumberCell = getDoc().createElement("fo:table-cell");
				Element sectionTitleCell = getDoc().createElement("fo:table-cell");
				Element sectionPageCell = getDoc().createElement("fo:table-cell");
				tableRow.appendChild(sectionNumberCell);
				tableRow.appendChild(sectionTitleCell);
				tableRow.appendChild(sectionPageCell);

				sectionNumberCell.setAttribute("width", Math.ceil(15. / 100. * RTF_CONTENT_WIDTH) + "pt");
				sectionTitleCell.setAttribute("width", Math.ceil(75. / 100. * RTF_CONTENT_WIDTH) + "pt");
				sectionPageCell.setAttribute("width", Math.ceil(10. / 100. * RTF_CONTENT_WIDTH) + "pt");

				Element sectionNumberBlock = getDoc().createElement("fo:block");
				Element sectionTitleBlock = getDoc().createElement("fo:block");
				Element sectionPageBlock = getDoc().createElement("fo:block");
				sectionNumberCell.appendChild(sectionNumberBlock);
				sectionTitleCell.appendChild(sectionTitleBlock);
				sectionPageCell.appendChild(sectionPageBlock);
				setTextOption(sectionNumberBlock, textOption);
				setTextOption(sectionTitleBlock, textOption);
				setTextOption(sectionPageBlock, textOption);

				sectionNumberBlock.setAttribute("text-align", "right");
				sectionNumberBlock.setAttribute("margin-right", "15pt");
				sectionPageBlock.setAttribute("text-align", "right");
				sectionPageBlock.setAttribute("margin-left", "5pt");

				if (section.getDepth() == 1 && !section.getSectionNumberAsString().equals("")) {
					sectionNumberBlock.setTextContent("Chapter  " + section.getFullSectionNumbering());
				} else {
					sectionNumberBlock.setTextContent(section.getFullSectionNumbering());
				}

				Element link = getDoc().createElement("fo:basic-link");
				sectionTitleBlock.appendChild(link);
				link.setAttribute("internal-destination", String.valueOf(section.hashCode()));
				link.setTextContent(section.getTitlParagraph().getText());

				if (section.getDepth() == 1) {
					sectionNumberBlock.setAttribute("margin-top", "10pt");
					sectionTitleBlock.setAttribute("margin-top", "10pt");
					sectionPageBlock.setAttribute("margin-top", "10pt");
				} else {
					sectionNumberBlock.setAttribute("color", "rgb(0,0,0)");
					sectionTitleBlock.setAttribute("color", "rgb(0,0,0)");
					sectionPageBlock.setAttribute("color", "rgb(0,0,0)");
				}

				writeUTableOfContentsEntry(tableBody, section, textOption);
			}
		}
	}

	private double getMarginLeft(UDocument doc) {
		if (doc != null) {
			return getMarginLeft(doc.getParent()) + doc.getBoxModel().getMarginLeft()
				+ doc.getBoxModel().getPaddingLeft() + doc.getBoxModel().getBorderLeft();
		} else {
			return 0.;
		}
	}

	/**
	 * @see org.unicase.docExport.docWriter.FopWriter#writeUTable(org.w3c.dom.Element,
	 *      org.unicase.docExport.exportModel.renderers.elements.UTable)
	 * @param parent .
	 * @param uTable .
	 */
	@Override
	protected void writeUTable(Element parent, UTable uTable) {
		// Element tableAndCaption = doc.createElement("fo:table-and-caption");
		// parent.appendChild(tableAndCaption);

		uTable.getBoxModel().setMarginLeft(getMarginLeft(uTable.getParent()));

		Element table = getDoc().createElement("fo:table");
		applyBoxModel(table, uTable.getBoxModel());
		parent.appendChild(table);
		table.setAttribute("border-collapse", "collpase");

		Element tableBody = getDoc().createElement("fo:table-body");
		table.appendChild(tableBody);

		int i = 0;
		Element row = getDoc().createElement("fo:table-row");
		tableBody.appendChild(row);

		float[] width = uTable.getColumnsWidths();

		for (UTableCell entry : uTable.getEntries()) {
			if (i % uTable.getColumnsCount() == 0 && i != 0) {
				row = getDoc().createElement("fo:table-row");
				tableBody.appendChild(row);
			}

			Element tableCell = getDoc().createElement("fo:table-cell");
			int dynamicTableWidth = (int) (Math.ceil(RTF_CONTENT_WIDTH) - Math.ceil(uTable.getBoxModel()
				.getMarginLeft()));
			int tableWidth = dynamicTableWidth / uTable.getColumnsCount();

			if (width.length > i % uTable.getColumnsCount()) {
				tableCell.setAttribute("width", Math
					.ceil(width[i % uTable.getColumnsCount()] / 100 * dynamicTableWidth)
					+ "pt");
			} else {
				tableCell.setAttribute("width", tableWidth + "pt");
			}

			row.appendChild(tableCell);
			applyBoxModel(tableCell, entry.getBoxModel());
			if (entry.getColspan() > 1) {
				tableCell.setAttribute("number-columns-spanned", String.valueOf(entry.getColspan()));
				i = i + entry.getColspan() - 1;
			}

			tableCell.setAttribute("keep-together", "auto");
			writeUDocument(tableCell, entry.getContent());

			i++;
		}
	}

	/**
	 * @param parent the parent fo xml node
	 * @param child the paragraph which shall be written
	 * @see org.unicase.docExport.docWriter.FopWriter#writeUParagraph(org.w3c.dom.Element,
	 *      org.unicase.docExport.exportModel.renderers.elements.UParagraph)
	 */
	@Override
	protected void writeUParagraph(Element parent, UParagraph child) {
		int emptyBlockCount = 0;
		int i = 0;
		if (child.getText() != null) {
			for (String textPart : child.getText().split("\n")) {
				if (textPart.equals("")) {
					emptyBlockCount++;
				} else {
					i++;
					Element text2 = getDoc().createElement("fo:block");
					text2.setAttribute("white-space-collapse", "false");
					text2.setAttribute("margin-top", child.getOption().getFontSize() * emptyBlockCount + "pt");
					emptyBlockCount = 0;
					parent.appendChild(text2);
					setParagraphOptions(text2, child);
					text2.setTextContent(textPart);
				}
			}
		}

		if (i == 0) {
			Element text2 = getDoc().createElement("fo:block");
			// text2.setTextContent(child.getText());
			parent.appendChild(text2);
		}

		for (UDocument subChild : child.getChildren()) {
			writeUDocument(parent, subChild);
		}
	}

	/**
	 * @param option the option which containts padding, border and margin
	 * @param foElement the formating objects DOM element
	 */
	@Override
	protected void applyBoxModel(Element foElement, BoxModelOption option) {
		setAttribute(foElement, "padding", option.getPadding());
		setAttribute(foElement, "padding-top", option.getPaddingTop());
		setAttribute(foElement, "padding-left", option.getPaddingLeft());
		setAttribute(foElement, "padding-bottom", option.getPaddingBottom());
		setAttribute(foElement, "padding-right", option.getPaddingRight());

		foElement.setAttribute("margin", String.valueOf(option.getMargin()));
		setAttribute(foElement, "margin-top", option.getMarginTop());
		setAttribute(foElement, "margin-left", option.getMarginLeft());
		setAttribute(foElement, "margin-bottom", option.getMarginBottom());
		setAttribute(foElement, "margin-right", option.getMarginRight());

		if (option.isKeepTogether()) {
			foElement.setAttribute("keep-together", "always");
		}

		if (option.isKeepWithNext()) {
			foElement.setAttribute("keep-with-next", "always");
		}

		if (option.isKeepWithPrevious()) {
			foElement.setAttribute("keep-with-previous", "always");
		}

		if (foElement.getNodeName().equals("fo:table")) {
			// the border always has to be set, because if only one side of the border is set, the rest
			// have the default border width = 1..
			foElement.setAttribute("border", String.valueOf(option.getBorder()) + "pt");
			setAttribute(foElement, "border-top", option.getBorderTop());
			setAttribute(foElement, "border-left", option.getBorderLeft());
			setAttribute(foElement, "border-bottom", option.getBorderBottom());
			setAttribute(foElement, "border-right", option.getBorderRight());

			if (option.getBorderStyle() != UBorderStyle.HIDDEN) {
				foElement.setAttribute("border-style", option.getBorderStyle().getLiteral());
			}

			foElement.setAttribute("border-color", "rgb(" + option.getBorderColor().getRed() + ", "
				+ option.getBorderColor().getGreen() + ", " + option.getBorderColor().getBlue() + ")");

		}

		if (option.getBackgroundColor() != null) {
			foElement.setAttribute("background-color", "rgb(" + option.getBackgroundColor().getRed() + ", "
				+ option.getBackgroundColor().getGreen() + ", " + option.getBackgroundColor().getBlue() + ")");
		}

		if (option.isBreakBefore()) {
			foElement.setAttribute("break-before", "page");
		}

		if (option.getWidth() > 0) {
			foElement.setAttribute("width", option.getWidth() + "pt");
		}
	}

	/**
	 * @param parent the parent fo xml node where the link shall be added
	 * @param uLink the uLink object
	 * @see org.unicase.docExport.docWriter.FopWriter#writeULink(org.w3c.dom.Element,
	 *      org.unicase.docExport.exportModel.renderers.elements.ULink)
	 */
	@Override
	protected void writeULink(Element parent, ULink uLink) {
		Element blockContainer = getDoc().createElement("fo:block");
		parent.appendChild(blockContainer);

		setParagraphOptions(blockContainer, uLink);

		Element text = getDoc().createElement("fo:basic-link");
		applyBoxModel(text, uLink.getBoxModel());
		blockContainer.appendChild(text);
		setParagraphOptions(text, uLink);
		text.setAttribute("internal-destination", uLink.getInternalLinkId());
		text.setTextContent(uLink.getText());

		for (UDocument subChild : uLink.getChildren()) {
			writeUDocument(text, subChild);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return "rtf";
	}
}
