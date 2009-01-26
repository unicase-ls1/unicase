package org.unicase.docExport.exportModel.renderers.elements;

import java.awt.Color;

/**
 * @author Sebastian Hoecht
 */
public class USeperator extends UDocument {

	private int widthPercentage = 80;
	private int height = 1;

	/**
	 * default constructor.
	 */
	public USeperator() {

	}

	/**
	 * @return the widthPercentage
	 */
	public int getWidthPercentage() {
		return widthPercentage;
	}

	/**
	 * @param widthPercentage the widthPercentage to set
	 */
	public void setWidthPercentage(int widthPercentage) {
		this.widthPercentage = widthPercentage;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	private Color color = new Color(0, 0, 0);

}
