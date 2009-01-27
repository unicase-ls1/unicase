/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.commands;

import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exportModel.Template;

/**
 * @author Sebastian Hoecht
 */
public class ExportTemplateDialog extends TitleAreaDialog {

	private Template template;

	private Text templateName;
	private Text fileLocation;

	/**
	 * the constructor.
	 * 
	 * @param parentShell the parent shell object
	 * @param template the template which shall be exported
	 * @throws TemplateSaveException -
	 */
	public ExportTemplateDialog(Shell parentShell, Template template) throws TemplateSaveException {
		super(parentShell);
		setHelpAvailable(false);

		this.template = (Template) EcoreUtil.copy(template);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// return super.createDialogArea(parent);

		GridLayout layout0 = new GridLayout();
		layout0.numColumns = 1;
		parent.setLayout(layout0);

		Group container = new Group(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);
		GridData gData1 = new GridData(GridData.FILL_HORIZONTAL);
		container.setLayoutData(gData1);

		Label label1 = new Label(container, SWT.None);
		label1.setText("Template name");
		templateName = new Text(container, SWT.BORDER);
		GridData gData2 = new GridData(GridData.FILL_HORIZONTAL);
		templateName.setLayoutData(gData2);
		templateName.setText(template.getName());

		Label label2 = new Label(container, SWT.READ_ONLY);
		label2.setText("File location");
		Composite fileChooser = new Composite(container, SWT.NONE);
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		fileChooser.setLayout(gLayout);
		fileChooser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fileLocation = new Text(fileChooser, SWT.BORDER);
		fileLocation.setText(System.getProperty("user.home"));
		fileLocation.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button selectFileLocation = new Button(fileChooser, SWT.PUSH);
		selectFileLocation.setText("choose...");
		selectFileLocation.addSelectionListener(new FileLocationSelectionListener());

		fileChooser.layout();
		fileChooser.pack();

		Button saveButton = new Button(container, SWT.PUSH);
		saveButton.setText("Export");
		saveButton.addSelectionListener(new SaveSelectionListener());

		return parent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// Set the title
		setTitle("Export template");
		// Set the message
		// setMessage("Please select a enter a file.", IMessageProvider.INFORMATION);
		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {

	}

	/**
	 * @author Sebastian Höcht
	 */
	class SaveSelectionListener extends SelectionAdapter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			if (templateName.getText().length() < 1) {
				setErrorMessage("Please enter a file name");
			} else {
				template.setName(templateName.getText());
				try {
					ExportTemplate.exportTemplate(template, fileLocation.getText() + "/" + templateName.getText());
					close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * @author Sebastian Höcht
	 */
	class CancelSelectionListener extends SelectionAdapter {
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			close();
		}
	}

	/**
	 * @author Sebastian Höcht
	 */
	class FileLocationSelectionListener extends SelectionAdapter {
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			DirectoryDialog fd = new DirectoryDialog(((Button) e.widget).getParent().getShell());
			fd.setText("select the folder where you want to save the template");
			String selected = fd.open();

			if (selected != null) {
				fileLocation.setText(selected);
			}
		}
	}
}