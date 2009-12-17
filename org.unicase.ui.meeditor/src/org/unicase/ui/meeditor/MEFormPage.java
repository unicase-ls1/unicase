/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.meeditor;

import org.eclipse.ui.forms.editor.FormPage;

/**
 * @author pfeifferc
 */
public class MEFormPage extends FormPage {

	private AbstractMEEditorPage page;

	/**
	 * @param id id
	 * @param title title
	 */
	public MEFormPage(String id, String title) {
		super(id, title);
	}

	/**
	 * @param editor editor
	 * @param id id
	 * @param name name
	 */
	public MEFormPage(MEEditor editor, String id, String name) {
		super(editor, id, name);
	}

	/**
	 * Sets the parent MEPage.
	 * 
	 * @param page parent page
	 */
	public void setParentMEPage(AbstractMEEditorPage page) {
		this.page = page;
	}

	/**
	 * @return the parent MEPage
	 */
	public AbstractMEEditorPage getParentMEPage() {
		return page;
	}

}
