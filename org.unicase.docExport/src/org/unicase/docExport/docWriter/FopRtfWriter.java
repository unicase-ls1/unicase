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
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.w3c.dom.Element;

/**
 * @author Sebastian Hoecht
 */
public class FopRtfWriter extends FopWriter {
	// configure fopFactory as desired
	private FopFactory fopFactory = FopFactory.newInstance();

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
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

		Element table = getDoc().createElement("fo:table");
		applyBoxModel(table, uTable.getBoxModel());
		parent.appendChild(table);
		table.setAttribute("border-collapse", "collpase");

		for (int i = 1; i <= uTable.getColumnsCount(); i++) {
			Element col1 = getDoc().createElement("fo:table-column");
			table.appendChild(col1);
			// col1.setAttribute("column-width", width[i] / 100 * 500 + "pt");
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
			System.out.println("entry: " + entry.getContent().getClass().getSimpleName());

			writeUDocument(tableCell, entry.getContent());

			Element block = getDoc().createElement("fo:block");
			tableCell.appendChild(block);
			block.setTextContent("test");
			i++;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return "rtf";
	}
}
