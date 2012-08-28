/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import java.util.ArrayList;

import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * A simple list of strings.
 * 
 * @author Sebastian Hoecht
 */
public class UList extends UDocument {

	private static final int INDENTION_LEFT_DEFAULT = 0;
	private ListOption listOption = OptionsFactory.eINSTANCE.createListOption();
	private TextOption textOption = OptionsFactory.eINSTANCE.createTextOption();
	private int indentionLeft = INDENTION_LEFT_DEFAULT;

	private ArrayList<String> contents = new ArrayList<String>();

	/**
	 * default constructor.
	 */
	public UList() {

	}

	/**
	 * @param listOption the listOption which decorates the list
	 */
	public UList(ListOption listOption) {
		this.setListOption(listOption);
	}

	/**
	 * @param listOption the listOption which decorates the list
	 * @param textOption the TextOption which decorates the text of the list entries
	 */
	public UList(ListOption listOption, TextOption textOption) {
		this.setListOption(listOption);
		this.setTextOption(textOption);
	}

	/**
	 * add a single text item to the list.
	 * 
	 * @param text the text to add
	 */
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
