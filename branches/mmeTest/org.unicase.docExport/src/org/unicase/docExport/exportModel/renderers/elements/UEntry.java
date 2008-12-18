package org.unicase.docExport.exportModel.renderers.elements;

import java.awt.Color;

import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * This class represents an entry in an UTable.
 * 
 * @see UTable
 * @author Sebastian Höcht
 */
public class UEntry {
	private static final int FLOAT_NULL = 0;

	private String text = "";
	
	private int colspan = 1;
	private Color backgroundColor = new Color(255, 255, 255);
	
	private float borderLeft = FLOAT_NULL;
	private float borderBottom = FLOAT_NULL;
	private float borderRight = FLOAT_NULL;
	private float borderTop = FLOAT_NULL;
	
	private Color borderColor = new Color(0, 0, 0);
	
	private TextOption textOption = OptionsFactory.eINSTANCE.createTextOption();
	
	/**
	 * @param text the content of the cell
	 */
	public UEntry(String text) {
		this.setText(text);
	}
	
	/**
	 * @param text the content of the cell
	 * @param textOption the textOption which shall decorate the table entry
	 */
	public UEntry(String text, TextOption textOption) {
		this.setText(text);
		this.textOption = textOption;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param colspan the colspan to set
	 */
	public void setColspan(int colspan) {
		this.colspan = colspan;
	}

	/**
	 * @return the colspan
	 */
	public int getColspan() {
		return colspan;
	}

	/**
	 * @param backgroundColor the backgroundColor to set
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	/**
	 * @return the backgroundColor
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * @param borderWidth the borderWidth to set
	 */
	public void setBorderWidth(float borderWidth) {
		borderLeft = borderWidth;
		borderRight = borderWidth;
		borderTop = borderWidth;
		borderBottom = borderWidth;
	}


	/**
	 * @param borderColor the borderColor to set
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	/**
	 * @return the borderColor
	 */
	public Color getBorderColor() {
		return borderColor;
	}
	
	/**
	 * @return the borderLeft
	 */
	public float getBorderLeft() {
		return borderLeft;
	}

	/**
	 * @param borderLeft the borderLeft to set
	 */
	public void setBorderLeft(float borderLeft) {
		this.borderLeft = borderLeft;
	}

	/**
	 * @return the borderBottom
	 */
	public float getBorderBottom() {
		return borderBottom;
	}

	/**
	 * @param borderBottom the borderBottom to set
	 */
	public void setBorderBottom(float borderBottom) {
		this.borderBottom = borderBottom;
	}

	/**
	 * @return the borderRight
	 */
	public float getBorderRight() {
		return borderRight;
	}

	/**
	 * @param borderRight the borderRight to set
	 */
	public void setBorderRight(float borderRight) {
		this.borderRight = borderRight;
	}

	/**
	 * @return the borderTop
	 */
	public float getBorderTop() {
		return borderTop;
	}

	/**
	 * @param borderTop the borderTop to set
	 */
	public void setBorderTop(float borderTop) {
		this.borderTop = borderTop;
	}

	/**
	 * @param textOption the textOption to set
	 */
	public void setTextOption(TextOption textOption) {
		this.textOption = textOption;
	}

	/**
	 * @return the textOption
	 */
	public TextOption getTextOption() {
		return textOption;
	}
	
}
