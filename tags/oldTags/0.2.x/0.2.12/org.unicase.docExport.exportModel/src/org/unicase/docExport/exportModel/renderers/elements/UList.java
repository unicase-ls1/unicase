package org.unicase.docExport.exportModel.renderers.elements;

import java.util.ArrayList;

import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

public class UList extends UDocument {

	private ListOption listOption = OptionsFactory.eINSTANCE.createListOption();
	private TextOption textOption = OptionsFactory.eINSTANCE.createTextOption();
	private int indentionLeft = 0;
	
	private ArrayList<String> contents = new ArrayList<String>();
	
	public UList() {
		
	}
	
	public UList(ListOption listOption) {
		this.setListOption(listOption);
	}
	
	public UList(ListOption listOption, TextOption textOption) {
		this.setListOption(listOption);
		this.setTextOption(textOption);
	}
	
	public void add(String text) {
		getContents().add(text);
	}

	/**
	 * @param listOption the listOption to set
	 */
	public void setListOption(ListOption listOption) {
		this.listOption = listOption;
	}

	/**
	 * @return the listOption
	 */
	public ListOption getListOption() {
		return listOption;
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

	/**
	 * @param contents the contents to set
	 */
	public void setContents(ArrayList<String> contents) {
		this.contents = contents;
	}

	/**
	 * @return the contents
	 */
	public ArrayList<String> getContents() {
		return contents;
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
