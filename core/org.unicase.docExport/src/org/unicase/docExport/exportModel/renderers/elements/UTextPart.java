/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * A short text part, which can be decorated by a TextOption. This element should not trigger a new line, hence it
 * behaves like span in HTML.
 * 
 * @author Sebastian Hoecht
 */
public class UTextPart extends UDocument {
	private TextOption option = OptionsFactory.eINSTANCE.createTextOption();

	private String text = "";
	private int indentionLeft;

	/**
	 * @param text the content of the paragraph
	 */
	public UTextPart(String text) {
		this.setText(text);
	}

	/**
	 * @param text the content of the paragraph
	 * @param option the TextOption which decorates the content
	 */
	public UTextPart(String text, TextOption option) {
		this.setOption(option);
		this.setText(text);
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
			WorkspaceUtil.log("Can't set null as TextOption", new Exception(), IStatus.WARNING);
		} else {
			this.option = EcoreUtil.copy(option);
		}
	}

	/**
	 * @return the option
	 */
	public TextOption getOption() {
		return option;
	}
}
