package org.unicase.docExport.docWriter;

import org.apache.fop.apps.MimeConstants;

public class FopPngWriter extends FopWriter {

	public String getFileType() {
		return "png";
	}

	@Override
	protected String getOutputFormat() {
		return MimeConstants.MIME_PNG;
	}

}
