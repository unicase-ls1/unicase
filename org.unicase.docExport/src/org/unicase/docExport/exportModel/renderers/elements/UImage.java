/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import org.eclipse.core.runtime.Path;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;

/**
 * An Image with some options.
 * 
 * @author Sebastian Hoecht
 */
public class UImage extends UDocument {

	private static final int DEFAULT_HEIGHT = 0;
	private static final int DEFAULT_WIDTH = 0;
	private Path location;
	private int indentionLeft;
	private int width = DEFAULT_WIDTH;
	private int height = DEFAULT_HEIGHT;
	private boolean fitToPage;
	private TextAlign textAlign = TextAlign.START;

	/**
	 * @param location the path of the image
	 */
	public UImage(Path location) {
		this.location = location;
	}

	/**
	 * @return the image
	 */
	public Path getPath() {
		return location;
	}

	/**
	 * @param indentionLeft the indentionLeft to set
	 */
	public void setIndentionLeft(int indentionLeft) {
		this.indentionLeft = indentionLeft;
	}

	/**
	 * @return the indentionLeft
	 */
	public int getIndentionLeft() {
		return indentionLeft;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param fitToPage the fitToPage to set
	 */
	public void setFitToPage(boolean fitToPage) {
		this.fitToPage = fitToPage;
	}

	/**
	 * @return the fitToPage
	 */
	public boolean isFitToPage() {
		return fitToPage;
	}

	/**
	 * @param textAlign the textAlign to set
	 */
	public void setTextAlign(TextAlign textAlign) {
		this.textAlign = textAlign;
	}

	/**
	 * @return the textAlign
	 */
	public TextAlign getTextAlign() {
		return textAlign;
	}
}
