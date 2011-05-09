/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import java.util.Vector;

import org.unicase.docExport.exportModel.renderers.elements.UDocument;
import org.unicase.docExport.exportModel.renderers.elements.USection;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.rtf.style.RtfParagraphStyle;

/**
 * Uses iText to render a RTF document with the RTF heading styles for sections.
 * 
 * @author Sebastian Hoecht
 */
public class ITextRtfHeadingWriter extends ITextRtfWriter {

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
	@Override
	protected void writeSection(Object parent, USection child) throws DocumentException {

		RtfParagraphStyle style;

		if (child.getDepth() == 1) {
			style = RtfParagraphStyle.STYLE_HEADING_1;
		} else if (child.getDepth() == 2) {
			style = RtfParagraphStyle.STYLE_HEADING_2;
		} else {
			style = RtfParagraphStyle.STYLE_HEADING_3;
		}

		Paragraph paragraph = new Paragraph(child.getTitlParagraph().getText(), style);

		addItextObject(parent, paragraph, true);

		Vector<UDocument> children = child.getChildren();
		for (UDocument subChild : children) {
			writeUDocument(getDoc(), subChild);
		}
	}
}
