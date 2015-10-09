/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

// Java
import org.apache.fop.apps.MimeConstants;

/**
 * Uses the PDF renderer of Apache FOP.
 * 
 * @author Sebastian Hoecht
 */
public class FopPdfWriter extends FopWriter {
	/**
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return "pdf";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.docWriter.FopWriter#getOutputFormat()
	 */
	@Override
	protected String getOutputFormat() {
		return MimeConstants.MIME_PDF;
	}
}
