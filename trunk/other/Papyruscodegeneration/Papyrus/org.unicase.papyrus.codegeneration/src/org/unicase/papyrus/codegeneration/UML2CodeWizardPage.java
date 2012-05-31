/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.codegeneration;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * A new wizard page to the select the output folder and which code should be generated.
 */
public class UML2CodeWizardPage extends WizardPage {
	private String format;
	private String destDir;
	private Text destinationDirField;

	/**
	 * Constructor.
	 */
	protected UML2CodeWizardPage() {
		super("UML Code Generation");

		// set title and description for the page
		this.setTitle("Format selection");
		this.setDescription("Please select the format you would like to export to.");
		setPageComplete(false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);

		// create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		gl.numColumns = 3;
		content.setLayout(gl);

		// destination folder
		new Label(content, SWT.NONE).setText("Destination folder: ");
		final GridData gdPath = new GridData();
		gdPath.horizontalAlignment = GridData.BEGINNING;

		destinationDirField = new Text(content, SWT.BORDER);
		destinationDirField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		destinationDirField.setEditable(false);
		destinationDirField.addListener(0, new Listener() {
			public void handleEvent(Event event) {
				browseForDestinationDir();

			}
		});

		final Button destinationBrowseButton = new Button(content, SWT.NONE);
		destinationBrowseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				browseForDestinationDir();

			}
		});
		destinationBrowseButton.setText("Browse");

		// Export format selection
		new Label(content, SWT.NONE).setText("Format:");
		final Combo formats = new Combo(content, SWT.BORDER | SWT.READ_ONLY);

		// set the formats available for exporting to
		formats.setItems(new String[] { "ecore", "Java", "C++" });
		formats.select(0);
		format = formats.getItem(0);

		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		gd.widthHint = 75;
		formats.setLayoutData(gd);

		formats.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				format = formats.getItem(formats.getSelectionIndex());

			}
		});

		setControl(content);
	}

	/**
	 * Check if page is finished.
	 * 
	 * @return true, if all is valid, otherwise false
	 */
	protected boolean validatePage() {
		if (destDir.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Let the user browse for a destination dir and save the selection in the text box.
	 */
	public void browseForDestinationDir() {
		IPath path = browse();
		if (path == null) {
			return;
		}
		destDir = path.toString();
		destinationDirField.setText(destDir);
		setPageComplete(validatePage());
	}

	/**
	 * Let the user select a path from the workspace.
	 * 
	 * @return the selected path
	 */
	public IPath browse() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), null, true,
			"Select the export folder:");
		dialog.setTitle("Export folder selection");
		if (dialog.open() != Dialog.OK) {
			return null;
		}
		Object[] result = dialog.getResult();
		if (result == null || result.length == 0 || !(result[0] instanceof IPath)) {
			return null;
		}

		return (IPath) result[0];
	}

	/**
	 * The format the user wants to generate. e.g. Java, C++
	 * 
	 * @return the format selected by the user
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * The directory where the code should be generated.
	 * 
	 * @return the destination directory selected by the user
	 */
	public String getDestinationDir() {
		return destDir;
	}
}
