/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.exportModel.Template;

/**
 * A custom Dialog for the export template command.
 * 
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
	 */
	public ExportTemplateDialog(Shell parentShell, Template template) {
		super(parentShell);
		setHelpAvailable(false);

		this.template = (Template) EcoreUtil.copy(template);
	}

	// /**
	// * {@inheritDoc}
	// *
	// * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	// */
	// @Override
	// protected Point getInitialSize() {
	// return new Point(500, 250);
	//
	// }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
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

		return parent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Export template");
		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		((GridLayout) parent.getLayout()).numColumns = 2;
		Button saveButton = new Button(parent, SWT.PUSH);
		saveButton.setText("Export");
		saveButton.addSelectionListener(new SaveSelectionListener());

		Button close = new Button(parent, SWT.PUSH);
		close.setText("cancel");
		close.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent arg0) {
				close();
			}

		});
	}

	/**
	 * Listener for the save button which exports a template.
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
					MessageBox finished = new MessageBox(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
						SWT.OK | SWT.ICON_INFORMATION);
					finished.setText("Export failed");
					finished.setMessage("The selected file could not be selected for some reason.");
					finished.open();
				}
			}
		}
	}

	/**
	 * Listener for the file selection button.
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