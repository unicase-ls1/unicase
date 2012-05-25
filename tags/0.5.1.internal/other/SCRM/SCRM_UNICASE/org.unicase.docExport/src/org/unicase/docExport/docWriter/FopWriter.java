/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.eclipse.core.runtime.IStatus;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.exceptions.DocumentExportException;
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
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.PageCitationStyle;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.workspace.util.WorkspaceUtil;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * This DocWriter generates a XSL-FO document based on the W3C recommendation. Afterwards the XSL-FO file is transformed
 * into a document like PDF or RTF using Apache FOP.
 * 
 * @author Sebastian Hoecht
 */
public abstract class FopWriter implements DocWriter {

	private static final int INDENTION_WIDTH = 15;

	private Element root;
	private Document doc;
	private Element pageSequence;
	private URootCompositeSection uRoot;
	private FopFactory fopFactory = FopFactory.newInstance();

	/**
	 * Returns the type of the Apache FOP transformation, i.e. MimeConstants.MIME_PLAIN_TEXT
	 * 
	 * @return the Mime constant of fop
	 */
	protected abstract String getOutputFormat();

	/**
	 * {@inheritDoc}
	 * 
	 * @throws DocumentExportException
	 */
	public void export(String fileName, URootCompositeSection doc) throws DocumentExportException {
		setURoot(doc);
		File xslFo = createFOFile(doc);
		OutputStream out = null;

		try {
			DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
			Configuration cfg;
			try {
				cfg = cfgBuilder.build(getClass().getResourceAsStream("/lib/conf.xml"));
			} catch (ConfigurationException e) {
				throw new DocumentExportException("Couldn't read/write the files", e);
			} catch (SAXException e) {
				throw new DocumentExportException("Couldn't read/write the files", e);
			}
			fopFactory.setUserConfig(cfg);

			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

			// Setup output stream. Note: Using BufferedOutputStream
			// for performance reasons (helpful with FileOutputStreams).
			out = new FileOutputStream(fileName);
			out = new BufferedOutputStream(out);

			// Construct fop with desired output format
			Fop fop = fopFactory.newFop(this.getOutputFormat(), foUserAgent, out);

			// Setup JAXP using identity transformer
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(); // identity transformer

			Source src = new StreamSource(xslFo);

			// Resulting SAX events (the generated FO) must be piped through to FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Start XSLT transformation and FOP processing
			transformer.transform(src, res);

		} catch (IOException e) {
			throw new DocumentExportException("Couldn't read/write the files", e);
		} catch (FOPException e) {
			throw new DocumentExportException("FOP error: " + e.getMessage(), e);
		} catch (TransformerException e) {
			throw new DocumentExportException("Transformation error", e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// nothing to do here
			}
		}
	}

	/*
	 * Exports the given document to a stream that can be read e.g. as a buffered image.
	 */
	public ByteArrayOutputStream exportToStream(URootCompositeSection doc) throws DocumentExportException {
		setURoot(doc);
		File xslFo = createFOFile(doc);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		try {
			DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
			Configuration cfg;
			try {
				InputStream configurationStream = getClass().getResourceAsStream("/lib/conf.xml");
				cfg = cfgBuilder.build(configurationStream);
			} catch (ConfigurationException e) {
				throw new DocumentExportException("Couldn't read/write the files", e);
			} catch (SAXException e) {
				throw new DocumentExportException("Couldn't read/write the files", e);
			}
			fopFactory.setUserConfig(cfg);

			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

			// Construct fop with desired output format
			Fop fop = fopFactory.newFop(this.getOutputFormat(), foUserAgent, outputStream);

			// Setup JAXP using identity transformer
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(); // identity transformer

			Source src = new StreamSource(xslFo);

			// Resulting SAX events (the generated FO) must be piped through to FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Start XSLT transformation and FOP processing
			transformer.transform(src, res);
			return outputStream;

		} catch (IOException e) {
			throw new DocumentExportException("Couldn't read/write the files", e);
		} catch (FOPException e) {
			throw new DocumentExportException("FOP error: " + e.getMessage(), e);
		} catch (TransformerException e) {
			throw new DocumentExportException("Transformation error", e);
		}
	}

	/**
	 * Create the XSL-FO File from the internal document model.
	 * 
	 * @param uDoc the rootSection which contains all information needed to render a Document
	 * @return an XML File containing an XML tree with XSL-FO syntax ready to be transformed to a Document
	 * @throws DocumentExportException xsl-fo file creation failed
	 */
	protected File createFOFile(URootCompositeSection uDoc) throws DocumentExportException {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();

			setDoc(parser.newDocument());

			root = getDoc().createElement("fo:root");
			getDoc().appendChild(root);
			root.setAttribute("xmlns:fo", "http://www.w3.org/1999/XSL/Format");
			createLayoutMasterSet();

			pageSequence = getDoc().createElement("fo:page-sequence");
			root.appendChild(pageSequence);
			pageSequence.setAttribute("master-reference", "document");

			insertHeaderAndFooter(uDoc.getHeader(), uDoc.getFooter());

			Element content = getDoc().createElement("fo:flow");
			pageSequence.appendChild(content);
			content.setAttribute("flow-name", "xsl-region-body");

			writeUDocument(content, uDoc);

			final File tmpFoFile = File.createTempFile("docExportFoFile", null);
			System.out.println(tmpFoFile.getAbsolutePath().toString());

			Transformer tFormer = TransformerFactory.newInstance().newTransformer();
			// Output Types (text/xml/html)
			tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
			// Write the document to a file
			Source source = new DOMSource(getDoc());
			// Create File to view your xml data as vk.txt/vk.doc/vk.xls/vk.shtml/vk.html)
			Result result = new StreamResult(tmpFoFile);
			tFormer.transform(source, result);

			return tmpFoFile;

		} catch (TransformerConfigurationException e) {
			throw new DocumentExportException(e);
		} catch (TransformerFactoryConfigurationError e) {
			throw new DocumentExportException();
		} catch (TransformerException e) {
			throw new DocumentExportException(e);
		} catch (ParserConfigurationException e) {
			throw new DocumentExportException(e);
		} catch (IOException e) {
			throw new DocumentExportException(e);
		}
	}

	/**
	 * Write a UDocument to the XSL-FO tree.
	 * 
	 * @param parent the XSL-FO Element
	 * @param uDoc the document which shall be written
	 */
	protected void writeUDocument(Element parent, UDocument uDoc) {
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
		} else if (uDoc instanceof UCompositeSection) {
			writeUCompositeSection(parent, (UCompositeSection) uDoc);
		} else {
			WorkspaceUtil.log(uDoc.getClass().getSimpleName() + "not implemented yet", new Exception(), IStatus.ERROR);
		}
	}

	private void writeUTextPart(Element parent, UTextPart child) {
		Element text = getDoc().createElement("fo:inline");
		parent.appendChild(text);
		setTextOption(text, child.getOption());
		text.setTextContent(child.getText());
	}

	/**
	 * create the column specification of the table of contents table.
	 * 
	 * @param table the XSL-FO table element
	 */
	protected void createUTableOfContentsColumns(Element table) {
		Element sectionColumn = getDoc().createElement("fo:table-column");
		Element sectionTitleColumn = getDoc().createElement("fo:table-column");
		Element sectionPageColumn = getDoc().createElement("fo:table-column");
		table.appendChild(sectionColumn);
		table.appendChild(sectionTitleColumn);
		table.appendChild(sectionPageColumn);

		sectionColumn.setAttribute("column-width", "15%");
		sectionTitleColumn.setAttribute("column-width", "75%");
		sectionPageColumn.setAttribute("column-width", "10%");
	}

	/**
	 * @param parent the parent element where the table of contents shall be written
	 * @param uSection the section containing the document structure, which is the content of the table of contents
	 * @param textOption the TextOption which decorates the text of the TOC
	 */
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

		createUTableOfContentsColumns(table);

		Element tableBody = getDoc().createElement("fo:table-body");
		table.appendChild(tableBody);

		writeUTableOfContentsEntry(tableBody, uSection, textOption);
	}

	/**
	 * @param tableBody the fo:table-body xml node element
	 * @param uSection the section containing the document structure, which is the content of the table of contents
	 * @param textOption the TextOption which decorates the text of the TOC
	 */
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

				createColumnWidths(sectionNumberCell, sectionTitleCell, sectionPageCell);

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

				Element page = getDoc().createElement("fo:page-number-citation");
				sectionPageBlock.appendChild(page);
				page.setAttribute("ref-id", String.valueOf(section.hashCode()));

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

	/**
	 * creates the column widths for each column manually by absolute values for the table of contents.
	 * 
	 * @param sectionNumberCell the cell for the section number.
	 * @param sectionTitleCell the cell for the section title
	 * @param sectionPageCell the cell for the page number.
	 */
	protected void createColumnWidths(Element sectionNumberCell, Element sectionTitleCell, Element sectionPageCell) {
		// normally this is done in the table definition.
	}

	private void writeUImage(Element parent, UImage uImage) {
		Element block = getDoc().createElement("fo:block");
		applyBoxModel(block, uImage.getBoxModel());
		block.setAttribute("text-align", uImage.getTextAlign().getLiteral());
		parent.appendChild(block);
		Element image = getDoc().createElement("fo:external-graphic");
		image.setAttribute("src", uImage.getPath().toString());
		image.setAttribute("text-align", uImage.getTextAlign().getLiteral());
		if (uImage.isFitToPage()) {
			image.setAttribute("content-width", "scale-to-fit");
			image.setAttribute("content-height", "100%");
			image.setAttribute("width", "100%");

		} else {
			if (uImage.getWidth() > 0) {
				image.setAttribute("content-width", uImage.getWidth() + "pt");
			}

			if (uImage.getHeight() > 0) {
				image.setAttribute("content-height", uImage.getHeight() + "pt");
			}
		}
		image.setAttribute("scaling", "uniform");

		if (uImage.getTextAlign().equals(TextAlign.CENTER)) {
			block.setAttribute("text-align", "center");
		}

		block.appendChild(image);
	}

	private void writeURef(Element parent, URef uRef) {
		Element text = getDoc().createElement("fo:block");
		parent.appendChild(text);
		text.setAttribute("id", uRef.getRefId());
	}

	/**
	 * @param parent the parent XSL-FO node where the link shall be added
	 * @param uLink the uLink object
	 */
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

		if (!uLink.isHideLinkedPage()) {
			Element pageRefBlock = getDoc().createElement("fo:inline");
			text.appendChild(pageRefBlock);
			setParagraphOptions(pageRefBlock, uLink);
			pageRefBlock.setAttribute("font-style", "italic");
			pageRefBlock.setAttribute("font-size", uLink.getOption().getFontSize() - 3 + "pt");
			if (DocumentExport.hasAlreadyBeenRendered(uLink.getInternalLinkId())) {
				pageRefBlock.setTextContent("  Page ");
			}

			Element pageRef = getDoc().createElement("fo:page-number-citation");
			pageRef.setAttribute("ref-id", uLink.getInternalLinkId());
			pageRefBlock.appendChild(pageRef);
		}

		for (UDocument subChild : uLink.getChildren()) {
			writeUDocument(text, subChild);
		}
	}

	/**
	 * @param parent the parent XSL-FO Element
	 * @param uTable the table which shall be written to the document
	 */
	protected void writeUTable(Element parent, UTable uTable) {
		if (uTable.getEntries().size() < 1) {
			return;
		}

		Element table = getDoc().createElement("fo:table");
		applyBoxModel(table, uTable.getBoxModel());
		parent.appendChild(table);
		table.setAttribute("border-collapse", "collpase");

		for (float width : uTable.getColumnsWidths()) {
			Element col1 = getDoc().createElement("fo:table-column");
			table.appendChild(col1);
			col1.setAttribute("column-width", width + "%");
		}

		Element tableBody = getDoc().createElement("fo:table-body");
		table.appendChild(tableBody);

		int i = 0;
		Element row = getDoc().createElement("fo:table-row");
		tableBody.appendChild(row);

		for (UTableCell entry : uTable.getEntries()) {
			if (i % uTable.getColumnsCount() == 0 && i != 0) {
				row = getDoc().createElement("fo:table-row");
				tableBody.appendChild(row);
			}

			Element tableCell = getDoc().createElement("fo:table-cell");
			// tableCell.setAttribute("width", "400pt");
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

	private void writeUList(Element parent, UList list) {
		Element listBlock = getDoc().createElement("fo:list-block");
		parent.appendChild(listBlock);

		for (String entry : list.getContents()) {

			Element listItem = getDoc().createElement("fo:list-item");
			listBlock.appendChild(listItem);

			Element listItemLabel = getDoc().createElement("fo:list-item-label");
			listItem.appendChild(listItemLabel);
			listItemLabel.setAttribute("end-indent", "label-end()");

			Element bulletBlock = getDoc().createElement("fo:block");
			listItemLabel.appendChild(bulletBlock);

			Element bulletSymbol = getDoc().createElement("fo:inline");
			bulletBlock.appendChild(bulletSymbol);
			setTextOption(bulletSymbol, list.getTextOption());
			// bulletSymbol.setAttribute("font-family", "Symbol");
			bulletSymbol.setTextContent("-");

			Element listItemBody = getDoc().createElement("fo:list-item-body");
			listItem.appendChild(listItemBody);
			listItemBody.setAttribute("start-indent", "body-start()");

			Element textBlock = getDoc().createElement("fo:block");
			setTextOption(textBlock, list.getTextOption());
			listItemBody.appendChild(textBlock);
			textBlock.setTextContent(entry);
		}

	}

	private void writeUCompositeSection(Element parent, UCompositeSection uDoc) {

		for (UDocument child : uDoc.getChildren()) {
			writeUDocument(parent, child);
		}
	}

	/*
	 * Renders a line containing both beginning and ending latex clauses.
	 * @param parentElement Uppermost parent element representing the UParagraph.
	 * @param textBlock The text block that the parsed line is to be added to.
	 * @param latexMatcher The input string that has been matched to the latex pattern.
	 * @param latexPattern The pattern used to match the input line.
	 * @param emptyBlockCount Number of consecutive empty blocks before this.
	 * @param paragraph The input UParagraph
	 */
	private void createLatexLine(Element parentElement, Element textBlock, Matcher latexMatcher, Pattern latexPattern,
		int emptyBlockCount, UParagraph paragraph) {
		String textBefore = latexMatcher.group(1);
		String latexText = latexMatcher.group(3);
		String textAfter = latexMatcher.group(5);
		// add the text before the latex expression.
		if (!textBefore.equals("")) {
			Element textBeforeLatex = getDoc().createElement("fo:inline");
			textBeforeLatex.setAttribute("white-space-collapse", "false");
			textBeforeLatex.setAttribute("margin-top", paragraph.getOption().getFontSize() * emptyBlockCount + "pt");
			emptyBlockCount = 0;
			setParagraphOptions(textBeforeLatex, paragraph);
			textBlock.appendChild(textBeforeLatex);
			textBeforeLatex.setTextContent(textBefore);
		}
		// add the latex expression
		createLatexPart(parentElement, latexText, textBlock);
		// see if there are more latex expressions in this line. If yes, parse it.
		latexMatcher = latexPattern.matcher(textAfter);
		if (latexMatcher.matches()) {
			createLatexLine(parentElement, textBlock, latexMatcher, latexPattern, emptyBlockCount, paragraph);
		}
		// case there is no more latex. add the normal text to the element.
		else if (!textAfter.equals("")) {
			Element textAfterLatex = getDoc().createElement("fo:inline");
			textAfterLatex.setAttribute("white-space-collapse", "false");
			textAfterLatex.setAttribute("margin-top", paragraph.getOption().getFontSize() * emptyBlockCount + "pt");
			emptyBlockCount = 0;
			setParagraphOptions(textAfterLatex, paragraph);
			textBlock.appendChild(textAfterLatex);
			textAfterLatex.setTextContent(textAfter + "\n");
		}
	}

	/**
	 * Renders a line containing a beginning latex clause.
	 * 
	 * @param parentElement Uppermost parent element representing the UParagraph.
	 * @param textBlock The text block that the parsed line is to be added to.
	 * @param latexMatcher The input string that has been matched to the latex pattern.
	 * @param emptyBlockCount Number of consecutive empty blocks before this.
	 * @param paragraph The input UParagraph
	 */
	private void createLatexBegin(Element parentElement, Element textBlock, Matcher latexMatcher, int emptyBlockCount,
		UParagraph paragraph) {
		String textBefore = latexMatcher.group(1);
		String textAfter = latexMatcher.group(3);
		/* add the text before the \begin{latex} clause */
		if (!textBefore.equals("")) {
			Element textBeforeLatex = getDoc().createElement("fo:inline");
			textBeforeLatex.setAttribute("white-space-collapse", "false");
			textBeforeLatex.setAttribute("margin-top", paragraph.getOption().getFontSize() * emptyBlockCount + "pt");
			emptyBlockCount = 0;
			setParagraphOptions(textBeforeLatex, paragraph);
			textBlock.appendChild(textBeforeLatex);
			textBeforeLatex.setTextContent(textBefore);
		}
		/* add the text after the latex clause */
		if (!textAfter.equals("")) {
			createLatexPart(parentElement, textAfter, textBlock);
		}
	}

	/**
	 * /** Renders a line containing an ending latex clause.
	 * 
	 * @param parentElement Uppermost parent element representing the UParagraph.
	 * @param textBlock The text block that the parsed line is to be added to.
	 * @param latexMatcher The input string that has been matched to the latex pattern.
	 * @param emptyBlockCount Number of consecutive empty blocks before this.
	 * @param paragraph The input UParagraph
	 */
	private void createLatexEnd(Element parentElement, Element textBlock, Matcher latexMatcher, int emptyBlockCount,
		UParagraph paragraph) {
		String textBefore = latexMatcher.group(1);
		String textAfter = latexMatcher.group(3);
		/* add the text before the \end{latex} clause */
		if (!textBefore.equals("")) {
			createLatexPart(parentElement, textBefore, textBlock);
		}
		/* add the text after the latex clause */
		if (!textAfter.equals("")) {
			Element textAfterLatex = getDoc().createElement("fo:inline");
			textAfterLatex.setAttribute("white-space-collapse", "false");
			textAfterLatex.setAttribute("margin-top", paragraph.getOption().getFontSize() * emptyBlockCount + "pt");
			emptyBlockCount = 0;
			setParagraphOptions(textAfterLatex, paragraph);
			textBlock.appendChild(textAfterLatex);
			textAfterLatex.setTextContent(textAfter + "\n");
		}
	}

	/**
	 * Renders a UParagraph element of a document. This modified method also supports the parsing of latex expressions.
	 * 
	 * @param parent the parent fo xml node
	 * @param child the paragraph which shall be written
	 */
	protected void writeUParagraph(Element parent, UParagraph child) {
		Element paragraphElement = getDoc().createElement("fo:block");
		applyBoxModel(paragraphElement, child.getBoxModel());
		parent.appendChild(paragraphElement);
		setParagraphOptions(paragraphElement, child);

		/* initializing variables */
		Matcher latexLineMatcher;
		Matcher latexBeginMatcher;
		Matcher latexEndMatcher;
		Pattern latexLinePattern = createLatexLinePattern();
		Pattern latexBeginPattern = createLatexBeginPattern();
		Pattern latexEndPattern = createLatexEndPattern();
		boolean isLatex = false;
		int emptyBlockCount = 0;

		if (child.getText() != null) {
			for (String textPart : child.getText().split("\n")) {
				latexLineMatcher = latexLinePattern.matcher(textPart);
				latexBeginMatcher = latexBeginPattern.matcher(textPart);
				latexEndMatcher = latexEndPattern.matcher(textPart);
				if (textPart.equals("")) {
					emptyBlockCount++;
				}
				/* case when the line looks like this: [...]\begin{latex}[...]\end{latex}[...] */
				else if (latexLineMatcher.find()) {
					Element blockElement = getDoc().createElement("fo:block");
					blockElement.setAttribute("white-space-collapse", "false");
					blockElement.setAttribute("margin-top", child.getOption().getFontSize() * emptyBlockCount + "pt");
					setParagraphOptions(blockElement, child);
					paragraphElement.appendChild(blockElement);
					createLatexLine(paragraphElement, blockElement, latexLineMatcher, latexLinePattern,
						emptyBlockCount, child);
				}
				/* case when there is a beginning but no ending latex clause */
				else if (latexBeginMatcher.find()) {
					isLatex = true;
					Element blockElement = getDoc().createElement("fo:block");
					blockElement.setAttribute("white-space-collapse", "false");
					blockElement.setAttribute("margin-top", child.getOption().getFontSize() * emptyBlockCount + "pt");
					setParagraphOptions(blockElement, child);
					paragraphElement.appendChild(blockElement);
					createLatexBegin(paragraphElement, blockElement, latexBeginMatcher, emptyBlockCount, child);
				}
				/* case when there is a ending but no beginning latex clause */
				else if (latexEndMatcher.find()) {
					isLatex = false;
					Element blockElement = getDoc().createElement("fo:block");
					blockElement.setAttribute("white-space-collapse", "false");
					blockElement.setAttribute("margin-top", child.getOption().getFontSize() * emptyBlockCount + "pt");
					setParagraphOptions(blockElement, child);
					paragraphElement.appendChild(blockElement);
					createLatexEnd(paragraphElement, blockElement, latexEndMatcher, emptyBlockCount, child);
				}
				/* case when there is no latex expression at all */
				else {
					Element blockElement = getDoc().createElement("fo:block");
					blockElement.setAttribute("white-space-collapse", "false");
					blockElement.setAttribute("margin-top", child.getOption().getFontSize() * emptyBlockCount + "pt");
					emptyBlockCount = 0;
					setParagraphOptions(blockElement, child);
					if (isLatex) {
						createLatexPart(paragraphElement, textPart, blockElement);
						paragraphElement.appendChild(blockElement);
					} else {
						paragraphElement.appendChild(blockElement);
						blockElement.setTextContent(textPart + "\n");
					}
				}
			}
		}
		for (UDocument subChild : child.getChildren()) {
			writeUDocument(paragraphElement, subChild);
		}
	}

	/**
	 * Returns a pattern for detecting lines with beginning and ending latex clauses.
	 */
	private Pattern createLatexLinePattern() {
		String pattern = "(.*?)(\\\\begin\\{latex\\})(.*?)(\\\\end\\{latex\\})(.*)";
		Pattern latexPattern = Pattern.compile(pattern);
		return latexPattern;
	}

	/**
	 * Returns a pattern for detecting lines containing beginning latex clauses.
	 */
	private Pattern createLatexBeginPattern() {
		String pattern = "(.*?)(\\\\begin\\{latex\\})(.*)";
		Pattern latexPattern = Pattern.compile(pattern);
		return latexPattern;
	}

	/**
	 * Returns a pattern for detecting lines containing ending latex clauses.
	 */
	private Pattern createLatexEndPattern() {
		String pattern = "(.*?)(\\\\end\\{latex\\})(.*)";
		Pattern latexPattern = Pattern.compile(pattern);
		return latexPattern;
	}

	/**
	 * Creates a latex section and inserts it into the output file.
	 * 
	 * @param parentElement The parent element that the latex part will be attached to.
	 * @param latexPart The string to be interpreted as latex.
	 * @param currentBlockElement The current fo block that is to contain the text.
	 */
	private void createLatexPart(Element parentElement, String latexPart, Element currentBlockElement) {
		Element first = getDoc().createElement("fo:instream-foreign-object");
		currentBlockElement.appendChild(first);
		// parentElement.appendChild(first);
		Element latexContainer;

		latexContainer = getDoc().createElement("latex");
		latexContainer.setAttribute("style", "display");
		latexContainer.setAttribute("xmlns", "http://forge.scilab.org/p/jlatexmath");

		CDATASection cdata = getDoc().createCDATASection(latexPart);

		latexContainer.appendChild(cdata);
		first.appendChild(latexContainer);
	}

	private void writeSection(Element parent, USection child) {
		Element section = getDoc().createElement("fo:block");
		section.setAttribute("white-space-collapse", "false");
		section.setAttribute("id", String.valueOf(child.hashCode()));

		parent.appendChild(section);
		setTextOption(section, child.getTitlParagraph().getOption());
		applyBoxModel(section, child.getBoxModel());
		section.setTextContent(child.getFullSectionNumbering() + " " + child.getTitlParagraph().getText());

		for (UDocument subChild : child.getTitlParagraph().getChildren()) {
			writeUDocument(section, subChild);
		}

		for (UDocument subChild : child.getChildren()) {
			writeUDocument(section, subChild);
		}
	}

	private void insertHeaderAndFooter(UDocument headerDoc, UDocument footerDoc) {
		// header
		Element header = getDoc().createElement("fo:static-content");
		pageSequence.appendChild(header);
		header.setAttribute("flow-name", "xsl-region-before");
		header.setAttribute("margin-left", "30pt");
		header.setAttribute("margin-right", "30pt");

		writeUDocument(header, headerDoc);

		// footer
		Element footer = getDoc().createElement("fo:static-content");
		pageSequence.appendChild(footer);
		footer.setAttribute("flow-name", "xsl-region-after");
		footer.setAttribute("margin-left", "30pt");
		footer.setAttribute("margin-right", "30pt");

		writeUDocument(footer, footerDoc);
	}

	private void writePageNumber(Element parent, UPageNumber uPageNumber) {
		if (uPageNumber.getPageCitationStyle().equals(PageCitationStyle.EMPTY)) {
			return;
		}

		Element page = getDoc().createElement("fo:inline");
		page.setTextContent("");
		parent.appendChild(page);

		Element pageNumber = getDoc().createElement("fo:page-number");
		page.appendChild(pageNumber);

		if (uPageNumber.getPageCitationStyle().equals(PageCitationStyle.PAGE_AND_LAST_PAGE)) {
			Element of = getDoc().createElement("fo:inline");
			of.setTextContent(" / ");
			page.appendChild(of);

			Element pageRef = getDoc().createElement("fo:page-number-citation");
			pageRef.setAttribute("ref-id", "last_page");
			page.appendChild(pageRef);
		}
	}

	private void createLayoutMasterSet() {
		Element layoutMasterSet = getDoc().createElement("fo:layout-master-set");
		root.appendChild(layoutMasterSet);

		// cover page
		Element coverPage = getDoc().createElement("fo:simple-page-master");
		layoutMasterSet.appendChild(coverPage);
		coverPage.setAttribute("master-name", "coverPage");

		// master page
		Element content = getDoc().createElement("fo:simple-page-master");
		layoutMasterSet.appendChild(content);
		content.setAttribute("master-name", "content");

		createBodyRegion(coverPage);
		createBodyRegion(content);

		createHeaderAndFooterRegion(content);

		if (!uRoot.getLayoutOptions().isHideHeaderAndFooterOnCoverPage()) {
			createHeaderAndFooterRegion(coverPage);
		}

		// page sequence master
		Element pageSequenceMaster = getDoc().createElement("fo:page-sequence-master");
		pageSequenceMaster.setAttribute("master-name", "document");
		layoutMasterSet.appendChild(pageSequenceMaster);

		Element alternatives = getDoc().createElement("fo:repeatable-page-master-alternatives");
		pageSequenceMaster.appendChild(alternatives);

		Element coverMaster = getDoc().createElement("fo:conditional-page-master-reference");
		coverMaster.setAttribute("master-name", "covcerPage");
		coverMaster.setAttribute("page-position", "first");
		coverMaster.setAttribute("master-reference", "coverPage");
		alternatives.appendChild(coverMaster);

		Element contentMaster = getDoc().createElement("fo:conditional-page-master-reference");
		contentMaster.setAttribute("master-name", "content");
		contentMaster.setAttribute("page-position", "rest");
		contentMaster.setAttribute("master-reference", "content");
		alternatives.appendChild(contentMaster);

		// it is recommended to do this
		Element fallBack = getDoc().createElement("fo:conditional-page-master-reference");
		fallBack.setAttribute("master-name", "content");
		fallBack.setAttribute("master-reference", "content");
		alternatives.appendChild(fallBack);
	}

	private void createHeaderAndFooterRegion(Element parent) {
		// header
		Element regionBefore = getDoc().createElement("fo:region-before");
		parent.appendChild(regionBefore);
		// buggy.. this doesn't work..
		// regionBefore.setAttribute("extent", "100pt");

		// footer
		Element regionAfter = getDoc().createElement("fo:region-after");
		parent.appendChild(regionAfter);
		regionAfter.setAttribute("extent", "35pt");
	}

	private void createBodyRegion(Element parent) {
		// body
		Element regionBody = getDoc().createElement("fo:region-body");
		parent.appendChild(regionBody);
		regionBody.setAttribute("margin-top", "75pt");
		regionBody.setAttribute("margin-bottom", "45pt");
		regionBody.setAttribute("margin-left", "45pt");
		regionBody.setAttribute("margin-right", "45pt");

	}

	/**
	 * @param element the element containing some text
	 * @param option the TextOption decorating the text
	 */
	protected void setTextOption(Element element, TextOption option) {
		if (option.isBold()) {
			element.setAttribute("font-weight", "bold");
		} else {
			element.setAttribute("font-weight", "normal");
		}

		if (option.isUnderline()) {
			element.setAttribute("text-decoration", "underline");
		}

		if (option.isItalics()) {
			element.setAttribute("font-style", "italic");
		}

		element.setAttribute("font-size", option.getFontSize() + "pt");
		element.setAttribute("font-family", option.getFontFamily().getLiteral());

		if (option.getFontColor() != null) {
			element.setAttribute("color", "rgb(" + option.getFontColor().getRed() + ", "
				+ option.getFontColor().getGreen() + ", " + option.getFontColor().getBlue() + ")");
		}

		element.setAttribute("text-align", option.getTextAlign().getLiteral());

	}

	/**
	 * @param block the parent fo xml node
	 * @param par the paragraph
	 */
	protected void setParagraphOptions(Element block, UParagraph par) {
		String indentionLeft = par.getIndentionLeft() * INDENTION_WIDTH + "pt";
		block.setAttribute("margin-left", indentionLeft);
		setTextOption(block, par.getOption());
	}

	/**
	 * @param uRoot the uRoot to set
	 */
	protected void setURoot(URootCompositeSection uRoot) {
		this.uRoot = uRoot;
	}

	/**
	 * @return the uRoot
	 */
	protected URootCompositeSection getURoot() {
		return uRoot;
	}

	/**
	 * @param option the option which containts padding, border and margin
	 * @param foElement the formating objects DOM element
	 */
	protected void applyBoxModel(Element foElement, BoxModelOption option) {
		setAttribute(foElement, "padding", option.getPadding());
		setAttribute(foElement, "padding-top", option.getPaddingTop());
		setAttribute(foElement, "padding-left", option.getPaddingLeft());
		setAttribute(foElement, "padding-bottom", option.getPaddingBottom());
		setAttribute(foElement, "padding-right", option.getPaddingRight());

		// the border always has to be set, because if only one side of the border is set, the rest
		// have the default border width = 1..
		foElement.setAttribute("border", String.valueOf(option.getBorder()) + "pt");
		setAttribute(foElement, "border-top", option.getBorderTop());
		setAttribute(foElement, "border-left", option.getBorderLeft());
		setAttribute(foElement, "border-bottom", option.getBorderBottom());
		setAttribute(foElement, "border-right", option.getBorderRight());
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

		if (option.getBorderStyle() != UBorderStyle.HIDDEN) {
			foElement.setAttribute("border-style", option.getBorderStyle().getLiteral());
		}

		foElement.setAttribute("border-color", "rgb(" + option.getBorderColor().getRed() + ", "
			+ option.getBorderColor().getGreen() + ", " + option.getBorderColor().getBlue() + ")");

		if (option.getBackgroundColor() != null) {
			foElement.setAttribute("background-color", "rgb(" + option.getBackgroundColor().getRed() + ", "
				+ option.getBackgroundColor().getGreen() + ", " + option.getBackgroundColor().getBlue() + ")");
		}

		if (option.getWidth() > 0) {
			foElement.setAttribute("width", option.getWidth() + "pt");
		}

		applyPageBreaks(foElement, option);
	}

	private void applyPageBreaks(Element foElement, BoxModelOption option) {

		if (option.isBreakBefore()) {
			foElement.setAttribute("break-before", "page");
		}

		if (option.isBreakAfter()) {
			foElement.setAttribute("break-after", "page");
		}
	}

	/**
	 * @param foElement the xml fo element
	 * @param foAttributeName the name of the xml attribute
	 * @param foAttributeValue the value of the xml attribute
	 */
	protected void setAttribute(Element foElement, String foAttributeName, double foAttributeValue) {
		if (foAttributeValue != 0) {
			foElement.setAttribute(foAttributeName, String.valueOf(foAttributeValue) + "pt");
		}
	}

	/**
	 * @param doc the doc to set
	 */
	public void setDoc(Document doc) {
		this.doc = doc;
	}

	/**
	 * @return the doc
	 */
	protected Document getDoc() {
		return doc;
	}
}
