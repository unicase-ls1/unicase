package org.unicase.docExport.exportModel.renderers.elements;

import org.unicase.docExport.exportModel.renderers.options.PageCitationStyle;

/**
 * @author Sebastian Hoecht
 */
public class UPageNumber extends UDocument {

	private PageCitationStyle pageCitationStyle;

	/**
	 * @param pageCitationStyle the style option which defines the look of the page citation
	 */
	public UPageNumber(PageCitationStyle pageCitationStyle) {
		this.pageCitationStyle = pageCitationStyle;
	}

	/**
	 * @param pageCitationStyle the pageCitationStyle to set
	 */
	public void setPageCitationStyle(PageCitationStyle pageCitationStyle) {
		this.pageCitationStyle = pageCitationStyle;
	}

	/**
	 * @return the pageCitationStyle
	 */
	public PageCitationStyle getPageCitationStyle() {
		return pageCitationStyle;
	}
}
