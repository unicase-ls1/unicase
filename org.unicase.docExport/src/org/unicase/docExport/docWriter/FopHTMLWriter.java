/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.MimeConstants;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.unicase.docExport.Activator;
import org.unicase.docExport.exceptions.DocumentExportException;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;

/**
 * This Strategy uses a free and open source XSLT transformation from xsl-fo to HTML. This renderer is currently causing
 * problems with extensive layouts.
 * 
 * @author Sebastian Hoecht
 */
public class FopHTMLWriter extends FopWriter {

	/**
	 * {@inheritDoc}
	 * 
	 * @throws DocumentExportException
	 */
	@Override
	public void export(String fileName, URootCompositeSection doc) throws DocumentExportException {
		try {
			setURoot(doc);

			File xmlFile = createFOFile(doc);

			URL htmlXsltFile = FileLocator.find(Activator.getDefault().getBundle(), new Path("xslt/fo2html.xsl"),
				Collections.EMPTY_MAP);

			File xsltFile = new File(FileLocator.resolve(htmlXsltFile).getPath());

			Source xmlSource = new StreamSource(xmlFile);
			Source xsltSource = new StreamSource(xsltFile);

			TransformerFactory transFact = TransformerFactory.newInstance();
			Transformer trans = transFact.newTransformer(xsltSource);

			trans.transform(xmlSource, new StreamResult(fileName));
		} catch (TransformerException e) {
			throw new DocumentExportException(e);
		} catch (IOException e) {
			throw new DocumentExportException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return "html";
	}

	/**
	 * {@inheritDoc} This function won't be used in this DocWriter, because it uses a simple XSLT transformation.
	 * 
	 * @see org.unicase.docExport.docWriter.FopWriter#getOutputFormat()
	 */
	@Override
	protected String getOutputFormat() {
		return MimeConstants.MIME_PLAIN_TEXT;
	}
}
