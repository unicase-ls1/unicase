package org.unicase.docExport.docWriter;

import java.io.File;
import java.io.IOException;

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
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.IStatus;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UDocument;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.ULink;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.URef;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.elements.UTableOfContents;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.workspace.util.WorkspaceUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 
 * @author Sebastian Hoecht
 *
 */
public abstract class FopWriter implements DocWriter {

	private static final int INDENTION_WIDTH = 15;
	private Element root;
	private Document doc;
	private Element pageSequence;
	private URootCompositeSection uRoot;
	
	/**
	 * 
	 * @param uDoc the rootSection which contains all information needed to render a Document
	 * @return an XML File containing an XML tree with XSL-FO syntax ready to be transformed
	 * 	to a Document
	 */
	protected File createFOFile(URootCompositeSection uDoc) {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			
			doc = parser.newDocument();
			
			
			root = doc.createElement("fo:root");
			doc.appendChild(root);
			root.setAttribute("xmlns:fo", "http://www.w3.org/1999/XSL/Format");
			createLayoutMasterSet();

			pageSequence = doc.createElement("fo:page-sequence");
			root.appendChild(pageSequence);
			pageSequence.setAttribute("master-reference", "pageLayout");
			
			insertHeaderAndFooter();
			
			Element flow = doc.createElement("fo:flow");
			pageSequence.appendChild(flow);
			flow.setAttribute("flow-name", "xsl-region-body");
			
			
			
			writeUDocument(flow, uDoc);
			
			final File tmpFoFile = File.createTempFile("docExportFoFile", null);
			

	        Transformer tFormer = TransformerFactory.newInstance().newTransformer();
//		        Output Types (text/xml/html)
	        tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
//		        Write the document to a file
	        Source source = new DOMSource(doc);
//		        Create File  to view your xml data as       vk.txt/vk.doc/vk.xls/vk.shtml/vk.html)
	        Result result = new StreamResult(tmpFoFile);
	        tFormer.transform(source, result);
	        
	        return tmpFoFile;
			
		    

		    } catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerFactoryConfigurationError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}


	private void writeUDocument(Element parent, UDocument uDoc) {
		
		if (uDoc instanceof USection) {
			writeSection(parent, (USection) uDoc);
		}
		else if (uDoc instanceof UTableOfContents) {
			writeUTableOfContents(
					parent, 
					((UTableOfContents) uDoc).getRootSection(),
					((UTableOfContents) uDoc).getTextOption()
				);
		}
		else if (uDoc instanceof URef) {
			writeURef(parent, (URef) uDoc);
		}
		else if (uDoc instanceof ULink) {
			writeULink(parent, (ULink) uDoc);
		}
		else if (uDoc instanceof UParagraph){
			writeUParagraph(parent, (UParagraph) uDoc);
		} 
		else if (uDoc instanceof UList) {
			writeUList(parent, (UList) uDoc);
		} 
		else if (uDoc instanceof UTable) {
			writeUTable(parent, (UTable) uDoc);
		} 
		else if (uDoc instanceof UImage) {
			writeUImage(parent, (UImage) uDoc);
		}
		else if (uDoc instanceof UCompositeSection) {
			writeUCompositeSection(parent, (UCompositeSection) uDoc);
		}
		else {
			WorkspaceUtil.log(
					uDoc.getClass().getSimpleName() + "not implemented yet", 
					new Exception(),
					IStatus.ERROR
				);
		}
	}


	private void writeUTableOfContents(
			Element parent, 
			USection uSection, 
			TextOption textOption
		) {
		Element toc = doc.createElement("fo:block");
		toc.setAttribute("font-size", "22pt");
		toc.setTextContent("Table of Contents");
		toc.setAttribute("text-align", "center");
		toc.setAttribute("break-before", "page");
		parent.appendChild(toc);
		
		Element table = doc.createElement("fo:table");
		parent.appendChild(table);
		table.setAttribute("margin-top", "10pt");

		Element sectionColumn = doc.createElement("fo:table-column");
		Element sectionTitleColumn = doc.createElement("fo:table-column");
		Element sectionPageColumn = doc.createElement("fo:table-column");
		table.appendChild(sectionColumn);
		table.appendChild(sectionTitleColumn);
		table.appendChild(sectionPageColumn);
		
		sectionColumn.setAttribute("column-width", "15%");
		sectionTitleColumn.setAttribute("column-width", "85%");
		sectionPageColumn.setAttribute("column-width", "5%");
		
		Element tableBody = doc.createElement("fo:table-body");
		table.appendChild(tableBody);
		
		writeUTableOfContentsEntry(tableBody, uSection, textOption);
	}
	
	private void writeUTableOfContentsEntry(
			Element tableBody,
			USection uSection,
			TextOption textOption
	) {
		for (USection section : uSection.getSubSections()) {
			if (!section.getSectionOption().isLeaveOutPreviousSectionNumbering()) {
				Element tableRow = doc.createElement("fo:table-row");
				tableBody.appendChild(tableRow);
				setTextOption(tableRow, textOption);
				
				Element sectionNumberCell = doc.createElement("fo:table-cell");
				Element sectionTitleCell = doc.createElement("fo:table-cell");
				Element sectionPageCell = doc.createElement("fo:table-cell");
				tableRow.appendChild(sectionNumberCell);
				tableRow.appendChild(sectionTitleCell);
				tableRow.appendChild(sectionPageCell);
				
				Element sectionNumberBlock = doc.createElement("fo:block");
				Element sectionTitleBlock = doc.createElement("fo:block");
				Element sectionPageBlock = doc.createElement("fo:block");
				sectionNumberCell.appendChild(sectionNumberBlock);
				sectionTitleCell.appendChild(sectionTitleBlock);
				sectionPageCell.appendChild(sectionPageBlock);
				
				sectionNumberBlock.setAttribute("text-align", "right");
				sectionNumberBlock.setAttribute("margin-right", "15pt");
				sectionPageBlock.setAttribute("text-align", "right");
				sectionPageBlock.setAttribute("margin-left", "5pt");
				
				
				
				if (section.getDepth() == 1 && !section.getSectionNumberAsString().equals("")) {
					sectionNumberBlock.setTextContent("Chapter " + section.getFullSectionNumbering());
				} else {
					sectionNumberBlock.setTextContent(section.getFullSectionNumbering());
				}

				Element page = doc.createElement("fo:page-number-citation");
				sectionPageBlock.appendChild(page);
				page.setAttribute("ref-id", String.valueOf(section.hashCode()));
				
				Element link = doc.createElement("fo:basic-link");
				sectionTitleBlock.appendChild(link);
				link.setAttribute("internal-destination", String.valueOf(section.hashCode()));
				link.setTextContent(section.getTitlParagraph().getText());
				
				if (section.getDepth() == 1) {
					sectionNumberBlock.setAttribute("margin-top", "10pt");
					sectionTitleBlock.setAttribute("margin-top", "10pt");
					sectionPageBlock.setAttribute("margin-top", "10pt");
					sectionNumberBlock.setAttribute("color", "rgb(0, 40, 90)");
					sectionTitleBlock.setAttribute("color", "rgb(0, 40, 90)");
					sectionPageBlock.setAttribute("color", "rgb(0, 40, 90)");
					
//						sectionTitleBlock.setAttribute("border-bottom", "0.3pt dashed black");
				}

				writeUTableOfContentsEntry(tableBody, section, textOption);					
			}
		}		
	}


	private void writeUImage(Element parent, UImage uImage) {
		Element block = doc.createElement("fo:block");
		applyBoxModel(block, uImage.getBoxModel());
		parent.appendChild(block);
		Element image = doc.createElement("fo:external-graphic");
		image.setAttribute("src", uImage.getPath().toString());
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
		
		if (uImage.isCenter()) {
			block.setAttribute("text-align", "center");
		}

		block.appendChild(image);
	}


	private void writeURef(Element parent, URef uRef) {
		Element text = doc.createElement("fo:block");
		parent.appendChild(text);
		text.setAttribute("id", uRef.getRefId());	
	}


	private void writeULink(Element parent, ULink uLink) {
		Element text = doc.createElement("fo:basic-link");
		applyBoxModel(text, uLink.getBoxModel());
		parent.appendChild(text);
		setParagraphOptions(text, uLink);
		text.setAttribute("internal-destination", uLink.getInternalLinkId());
		text.setTextContent(uLink.getText());
		
		Element pageRefBlock = doc.createElement("fo:inline");
		text.appendChild(pageRefBlock);
		setParagraphOptions(pageRefBlock, uLink);
		pageRefBlock.setAttribute("text-decoration", "italics");
		pageRefBlock.setAttribute("font-size", uLink.getOption().getFontSize() - 3 + "pt");
		pageRefBlock.setTextContent("  Page ");
		
		Element pageRef = doc.createElement("fo:page-number-citation");
		pageRef.setAttribute("ref-id", uLink.getInternalLinkId());
		pageRefBlock.appendChild(pageRef);

	}


	private void writeUTable(Element parent, UTable uTable) {
//			Element tableAndCaption = doc.createElement("fo:table-and-caption");
//			parent.appendChild(tableAndCaption);
		
		Element table = doc.createElement("fo:table");
		applyBoxModel(table, uTable.getBoxModel());
		parent.appendChild(table);
		table.setAttribute("border-collapse", "collpase");
		
		for (float width : uTable.getColumnsWidths()) {
			Element col1 = doc.createElement("fo:table-column");
			table.appendChild(col1);
			col1.setAttribute("column-width", width + "%");		
		}


		
		Element tableBody = doc.createElement("fo:table-body");
		table.appendChild(tableBody);
		
		
		int i = 0;
		Element row = doc.createElement("fo:table-row");
		tableBody.appendChild(row);
		
		for (UTableCell entry : uTable.getEntries()) {
			if (i % uTable.getColumnsCount() == 0 && i != 0) {
				row = doc.createElement("fo:table-row");
				tableBody.appendChild(row);
			}

			Element tableCell = doc.createElement("fo:table-cell");
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
		Element listBlock = doc.createElement("fo:list-block");
		parent.appendChild(listBlock);
		
		for (String entry :list.getContents()) {

			Element listItem = doc.createElement("fo:list-item");
			listBlock.appendChild(listItem);
			
			Element listItemLabel = doc.createElement("fo:list-item-label");
			listItem.appendChild(listItemLabel);
			listItemLabel.setAttribute("end-indent", "label-end()");
			
			Element bulletBlock = doc.createElement("fo:block");
			listItemLabel.appendChild(bulletBlock);
			
			Element bulletSymbol = doc.createElement("fo:inline");
			bulletBlock.appendChild(bulletSymbol);
			setTextOption(bulletSymbol, list.getTextOption());
//				bulletSymbol.setAttribute("font-family", "Symbol");
			bulletSymbol.setTextContent("-");
			
			
			Element listItemBody = doc.createElement("fo:list-item-body");
			listItem.appendChild(listItemBody);
			listItemBody.setAttribute("start-indent", "body-start()");
			
			Element textBlock = doc.createElement("fo:block");
			setTextOption(textBlock, list.getTextOption());
			listItemBody.appendChild(textBlock);
			textBlock.setTextContent(entry);
		}

	}


	private void writeUCompositeSection(Element parent,
			UCompositeSection uDoc) {
		
		for (UDocument child : uDoc.getChildren()) {
			writeUDocument(parent, child);
		}
	}


	private void writeUParagraph(Element parent, UParagraph child) {
		
		Element text = doc.createElement("fo:block");
		applyBoxModel(text, child.getBoxModel());
		parent.appendChild(text);
		setParagraphOptions(text, child);
		
		int emptyBlockCount = 0;
		if (child.getText() != null) {
			for (String textPart : child.getText().split("\n")) {
				if (textPart.equals("")) {
					emptyBlockCount++;
				} else {
					Element text2 = doc.createElement("fo:block");
					text2.setAttribute("white-space-collapse", "false");
					text2.setAttribute("margin-top", child.getOption().getFontSize() * emptyBlockCount + "pt");
					text.appendChild(text2);
					setParagraphOptions(text2, child);
					text2.setTextContent(textPart);							
				}
			}			
		}


		
		
		for (UDocument subChild : child.getChildren()) {
			Element test = doc.createElement("fo:block");
			text.appendChild(test);
			writeUDocument(text, subChild);
		}
	}


	private void writeSection(Element parent, USection child) {

		Element section = doc.createElement("fo:block");
		section.setAttribute("white-space-collapse", "false");
		section.setAttribute("id", String.valueOf(child.hashCode()));
		
		parent.appendChild(section);	
		setTextOption(section, child.getTitlParagraph().getOption());
		applyBoxModel(section, child.getBoxModel());
		section.setTextContent(child.getFullSectionNumbering() + " " + child.getTitlParagraph().getText());
		
		
		for (UDocument subChild : child.getChildren()) {
			writeUDocument(section, subChild);
		}
	}


	private void insertHeaderAndFooter() {
		//header
		Element header = doc.createElement("fo:static-content");
		pageSequence.appendChild(header);
		header.setAttribute("flow-name", "xsl-region-before");
		
		Element headerBlock = doc.createElement("fo:block");
		header.appendChild(headerBlock);
		headerBlock.setAttribute("text-align", "center");
		headerBlock.setAttribute("font-size", "10pt");
		headerBlock.setAttribute("font-family", "times new roman");
		headerBlock.setAttribute("font-weight", "normal");
		headerBlock.setAttribute("margin-top", "10pt");
		headerBlock.setTextContent(getURoot().getLayoutOptions().getCoverText());

		
		//footer
		Element footer = doc.createElement("fo:static-content");
		pageSequence.appendChild(footer);
		footer.setAttribute("flow-name", "xsl-region-after");
		
		Element page = doc.createElement("fo:block");
		footer.appendChild(page);
		page.setAttribute("text-align", "center");
		page.setAttribute("font-size", "10pt");
		page.setAttribute("font-family", "times new roman");
		page.setTextContent(getURoot().getLayoutOptions().getFooterText() + " - Page ");
		
		Element pageNumber = doc.createElement("fo:page-number");
		page.appendChild(pageNumber);
	}


	private void createLayoutMasterSet() {
		Element layoutMasterSet = doc.createElement("fo:layout-master-set");
		root.appendChild(layoutMasterSet);
		
		//master page
		Element simplePageMaster = doc.createElement("fo:simple-page-master");
		layoutMasterSet.appendChild(simplePageMaster);
		simplePageMaster.setAttribute("master-name", "pageLayout");
		
		//body
		Element regionBody = doc.createElement("fo:region-body");
		simplePageMaster.appendChild(regionBody);
		regionBody.setAttribute("margin-top", "45pt");
		regionBody.setAttribute("margin-bottom", "45pt");
		regionBody.setAttribute("margin-left", "45pt");
		regionBody.setAttribute("margin-right", "70pt");
		
		//header
		Element regionBefore = doc.createElement("fo:region-before");
		simplePageMaster.appendChild(regionBefore);
		regionBefore.setAttribute("extent", "100pt");
		
		//footer
		Element regionAfter = doc.createElement("fo:region-after");
		simplePageMaster.appendChild(regionAfter);
		regionAfter.setAttribute("extent", "22pt");	
		
		//master for all pages
//			Element pageSequenceMaster = doc.createElement("fo:page-sequence-master");
//			layoutMasterSet.appendChild(pageSequenceMaster);
//			pageSequenceMaster.setAttribute("master-name", "pageLayout");
	}

	private void setTextOption(Element element, TextOption option) {
		if (option.isBold()) {
			element.setAttribute("font-weight", "bold");
		} else {
			element.setAttribute("font-weight", "normal");
		}
		
		if (option.isUnderline()) {
			element.setAttribute("text-decoration", "underline");
		}
		element.setAttribute("font-size", option.getFontSize() + "pt");
		element.setAttribute("font-family", option.getFontFamily().getLiteral());
		if (option.getFontColor() != null) {
			element.setAttribute("color", "rgb(" +
					option.getFontColor().getRed() + ", " +
					option.getFontColor().getGreen() + ", " +
					option.getFontColor().getBlue()	+ ")"			
				);			
		}
		
		element.setAttribute("text-align", option.getTextAlign().getLiteral());

	}
	
	private void setParagraphOptions(Element block, UParagraph par) {
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
		
		//the border always has to be set, because if only one side of the border is set, the rest
		//have the default border width = 1..
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
		
		foElement.setAttribute("border-color", "rgb(" + 
				option.getBorderColor().getRed() + ", " +
				option.getBorderColor().getGreen() + ", " +
				option.getBorderColor().getBlue() + ")"
			);
		
		if (option.getBackgroundColor() != null) {
			foElement.setAttribute("background-color", 
					"rgb(" + 
						option.getBackgroundColor().getRed() + ", " + 
						option.getBackgroundColor().getGreen() + ", " +
						option.getBackgroundColor().getBlue() +
					")");
		}
		
		if (option.isBreakBefore()) {
			foElement.setAttribute("break-before", "page");
		}
	}
	
	private void setAttribute(Element foElement, String foAttributeName, double foAttributeValue) {
		if (foAttributeValue != 0) {
			foElement.setAttribute(foAttributeName, String.valueOf(foAttributeValue) + "pt");
		}
	}
}
