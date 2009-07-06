package org.unicase.docExport.exportModel.renderers.elements;

import org.eclipse.swt.graphics.Image;

public class UImage extends UDocument {

	private Image image;
	private int indentionLeft;
	
	
	public UImage(Image image) {
		this.image = image;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
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
}
