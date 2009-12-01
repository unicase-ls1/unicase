/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.meeditor.AbstractMEEditorPage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.mecontrols.MERichTextControl;
import org.unicase.workspace.Configuration;

/**
 * The editor page for the description feature.
 * 
 * @author shterev
 */
public class MEDescriptionPage extends AbstractMEEditorPage {

	private static final String ID = "org.unicase.ui.unicasecommon.meeditor.descriptionpage";
	private static final String NAME = "Description";

	private UnicaseModelElement modelElement;
	private FormToolkit toolkit;

	private ScrolledForm form;
	private Composite body;
	private MERichTextControl textControl;
	private Control textWidget;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(MEEditor editor, EditingDomain editingDomain, ModelElement modelElement) {
		if (modelElement instanceof UnicaseModelElement) {
			this.modelElement = (UnicaseModelElement) modelElement;
		} else {
			throw new IllegalArgumentException("This page is valid only for UnicaseModelElements");
		}

		FormPage page = new FormPage(editor, ID, NAME) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected void createFormContent(IManagedForm managedForm) {
				super.createFormContent(managedForm);

				toolkit = this.getEditor().getToolkit();
				form = managedForm.getForm();
				toolkit.decorateFormHeading(form.getForm());
				GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(form.getBody());
				form.setText(getEditor().getTitle() + ": Description");
				createWidget();
				form.pack();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void dispose() {
				if (textControl != null) {
					textControl.dispose();
				}
				super.dispose();
			}

			/**
			 * {@inheritDoc} This method is added to solve the focus bug of navigator. Every time that a ME is opened in
			 * editor, navigator has to lose focus so that its action contributions are set correctly for next time.
			 */
			@Override
			public void setFocus() {
				textWidget.setFocus();
			}
		};
		setPage(page);

	}

	private void createWidget() {
		if (body != null) {
			body.dispose();
		}
		body = new Composite(form.getBody(), SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(body);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(body);

		TransactionalEditingDomain domain = Configuration.getEditingDomain();
		textControl = new MERichTextControl();
		textControl.init(ModelPackage.eINSTANCE.getUnicaseModelElement_Description(), modelElement, domain, toolkit);
		(textControl).setShowExpand(false);
		textWidget = textControl.createControl(body, SWT.NONE);
		GridDataFactory.fillDefaults().hint(200, -1).grab(true, true).applyTo(textWidget);
	}

}