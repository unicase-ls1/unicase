/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.model.UnicaseModelElement;

/**
 * The history page for the {@link MEEditor}.
 * 
 * @author shterev
 */
public class MEHistoryPage extends FormPage {

	private UnicaseModelElement modelElement;

	private ScrolledForm form;

	private FormToolkit toolkit;

	/**
	 * Default constructor.
	 * 
	 * @param editor the {@link MEEditor}
	 * @param id the {@link FormPage#id}
	 * @param title the title
	 * @param modelElement the modelElement
	 */
	public MEHistoryPage(MEEditor editor, String id, String title, UnicaseModelElement modelElement) {
		super(editor, id, title);
		this.modelElement = modelElement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		if (modelElement == null) {
			return;
		}
		toolkit = this.getEditor().getToolkit();
		form = managedForm.getForm();
		form.setText("History for " + modelElement.getName());
		toolkit.decorateFormHeading(form.getForm());
		Composite body = form.getBody();
		body.setLayout(new GridLayout());

		// TreeViewer viewer = new TreeViewer(body);
		// viewer.setContentProvider();
		// viewer.setLabelProvider();
	}

}