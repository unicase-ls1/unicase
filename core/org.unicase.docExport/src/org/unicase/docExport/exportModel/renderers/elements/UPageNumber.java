/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import org.unicase.docExport.exportModel.renderers.options.PageCitationStyle;

/**
 * This element represents the current page.
 * 
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
