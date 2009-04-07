/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import org.apache.fop.apps.MimeConstants;

/**
 * @author Sebastian Hoecht
 */
public class FopTxtWriter extends FopWriter {

	/**
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return "txt";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.docWriter.FopWriter#getOutputFormat()
	 */
	@Override
	protected String getOutputFormat() {
		return MimeConstants.MIME_PLAIN_TEXT;
	}
}
