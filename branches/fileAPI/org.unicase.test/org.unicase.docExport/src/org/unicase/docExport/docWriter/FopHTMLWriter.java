/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.unicase.docExport.Activator;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;

/**
 * @author Sebastian Hoecht
 */
public class FopHTMLWriter extends FopWriter {

	/**
	 * {@inheritDoc}
	 */
	public void export(String fileName, URootCompositeSection doc) {
		try {
			setURoot(doc);

			File xmlFile = createFOFile(doc);

			URL htmlXsltFile = FileLocator.find(Activator.getDefault().getBundle(), new Path("xslt/fo2html.xsl"),
				Collections.EMPTY_MAP);

			File xsltFile = new File(FileLocator.resolve(htmlXsltFile).getPath());

			// JAXP liest Daten über die Source-Schnittstelle
			Source xmlSource = new StreamSource(xmlFile);
			Source xsltSource = new StreamSource(xsltFile);

			// das Factory-Pattern unterstützt verschiedene XSLT-Prozessoren
			TransformerFactory transFact = TransformerFactory.newInstance();
			Transformer trans = transFact.newTransformer(xsltSource);

			trans.transform(xmlSource, new StreamResult(fileName));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return "html";
	}

}
