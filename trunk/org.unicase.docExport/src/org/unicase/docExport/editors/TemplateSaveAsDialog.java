/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exceptions.TemplatesFileNotFoundException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author Sebastian Hoecht
 */
public class TemplateSaveAsDialog extends TitleAreaDialog {

	private Text templateName;
	private Template template;

	/**
	 * the constructor.
	 * 
	 * @param parentShell the parent shell object
	 * @param template the template to save
	 */
	public TemplateSaveAsDialog(Shell parentShell, Template template) {
		super(parentShell);
		setHelpAvailable(false);
		this.template = template;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		parent.setLayout(layout);
		templateName = new Text(parent, SWT.BORDER);
		return parent;
	}

	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(Text templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return the templateName
	 */
	public Text getTemplateName() {
		return templateName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Save Template");
		setMessage("Prompt a new template name", IMessageProvider.INFORMATION);
		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		((GridLayout) parent.getLayout()).numColumns = 3;
		Button button = new Button(parent, SWT.PUSH);
		button.setText("OK");
		button.setFont(JFaceResources.getDialogFont());
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (templateName.getText().length() != 0) {
					template.setName(templateName.getText());
					try {
						TemplateRegistry.saveTemplate(template);
					} catch (TemplatesFileNotFoundException e1) {
						WorkspaceUtil.log("could not save the Template", e1, IStatus.ERROR);
					}
					close();
				} else {
					setErrorMessage("Please maintain the last name");
				}
			}
		});

		Button button2 = new Button(parent, SWT.PUSH);
		button2.setText("cancel");
		button2.setFont(JFaceResources.getDialogFont());
		button2.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
	}

	/**
	 * @return the template
	 */
	public Template getTemplate() {
		return template;
	}

}
