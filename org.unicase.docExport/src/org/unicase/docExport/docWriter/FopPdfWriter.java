/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

// Java
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

/**
 * @author Sebastian Hoecht
 */
public class FopPdfWriter extends FopWriter {

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
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

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
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return "pdf";
	}
}
