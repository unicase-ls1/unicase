package org.unicase.documentexport.renderers.elements;

import org.unicase.documentexport.renderers.options.BooleanOption;
import org.unicase.documentexport.renderers.options.TextOption;

public class UParagraph extends UDocument {
	
	public TextOption option = new TextOption();
	public BooleanOption booleanOption;
	
	private String text = "";
	private int indentionLeft;
	
	public UParagraph(String text) {
		this.setText(text);
	}
	
	public UParagraph(String text, TextOption option) {
		this.option = option;
		this.setText(text);
	}
	
	public UParagraph(TextOption option) {
		this.option = option;
	}
	
	public UParagraph(String text, BooleanOption booleanOption) {
		this.text = text;
		this.booleanOption = booleanOption;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	/**
	 * Depth of the indention. This is relative to the indention width in the docWriter;
	 * If you want to indent an UParagraph, so just set the indention to "1".
	 * If you want to go depper, set it to "2" etc..
	 */
	public void setIndentionLeft(int indentionLeft) {
		this.indentionLeft = indentionLeft;
	}
	
	public int getIndentionLeft() {
		return this.indentionLeft;
	}
}
