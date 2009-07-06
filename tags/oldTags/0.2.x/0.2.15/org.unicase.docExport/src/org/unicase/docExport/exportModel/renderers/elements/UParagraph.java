package org.unicase.docExport.exportModel.renderers.elements;

import org.eclipse.core.runtime.IStatus;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.workspace.util.WorkspaceUtil;


/**
 * This class represents a Paragraph with some text.
 * 
 * @author Sebastian Höcht
 */
public class UParagraph extends UCompositeSection {
	
	private TextOption option = OptionsFactory.eINSTANCE.createTextOption();
	
	private String text = "";
	private int indentionLeft;
	
	/**
	 * @param text the content of the paragraph
	 */
	public UParagraph(String text) {
		this.setText(text);
	}
	
	/**
	 * 
	 * @param text the content of the paragraph
	 * @param option the TextOption which decorates the content
	 */
	public UParagraph(String text, TextOption option) {
		this.setOption(option);
		this.setText(text);
	}
	
	/**
	 * @param option the TextOption which decorates the content
	 */
	public UParagraph(TextOption option) {
		this.setOption(option);
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
	 * @param option the option to set
	 */
	public void setOption(TextOption option) {
		if (option == null) {
			WorkspaceUtil.log(
					"Can't set null as TextOption", 
					new Exception(), 
					IStatus.WARNING
				);
		} else {
			this.option = option;
		}
	}

	/**
	 * @return the option
	 */
	@Override
	public TextOption getOption() {
		return option;
	}	
}
