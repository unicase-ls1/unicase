/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import org.apache.fop.apps.MimeConstants;
import org.unicase.docExport.exportModel.renderers.elements.UDocument;
import org.unicase.docExport.exportModel.renderers.elements.ULink;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.w3c.dom.Element;

/**
 * Uses the RTF renderer of Apache FOP.
 * 
 * @author Sebastian Hoecht
 */
public class FopRtfWriter extends FopWriter {

	private static final int RTF_CONTENT_WIDTH = 505;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.docWriter.FopWriter#createUTableOfContentsColumns(org.w3c.dom.Element)
	 */
	@Override
	protected void createUTableOfContentsColumns(Element table) {
		// no column specification in RTF
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createColumnWidths(Element sectionNumberCell, Element sectionTitleCell, Element sectionPageCell) {
		sectionNumberCell.setAttribute("width", Math.ceil(15. / 100. * RTF_CONTENT_WIDTH) + "pt");
		sectionTitleCell.setAttribute("width", Math.ceil(75. / 100. * RTF_CONTENT_WIDTH) + "pt");
		sectionPageCell.setAttribute("width", Math.ceil(10. / 100. * RTF_CONTENT_WIDTH) + "pt");

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
	 * {@inheritDoc}
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
					applyBoxModel(text2, child.getBoxModel());
					text2.setAttribute("white-space-collapse", "false");
					text2.setAttribute("margin-top", child.getOption().getFontSize() * emptyBlockCount + "pt");
					text2.setAttribute("margin-bottom", "0pt");
					emptyBlockCount = 0;
					parent.appendChild(text2);
					setParagraphOptions(text2, child);
					text2.setTextContent(textPart);
				}
			}
		}

		if (i == 0) {
			Element text2 = getDoc().createElement("fo:block");
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

		if (foElement.getNodeName().equals("fo:table") || foElement.getNodeName().equals("fo:table-cell")) {
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
	 * @param parent the parent XML-FO node where the link shall be added
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.docWriter.FopWriter#getOutputFormat()
	 */
	@Override
	protected String getOutputFormat() {
		return MimeConstants.MIME_RTF;
	}
}
