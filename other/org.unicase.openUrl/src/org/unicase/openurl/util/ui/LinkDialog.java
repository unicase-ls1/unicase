/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.openurl.util.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Custom dialog class that enables to select the generated model element URL.
 * 
 * @author emueller
 */
public class LinkDialog extends Dialog {

	private String labelText;
	private String textBoxContent;

	/**
	 * Initializes a new instance of the LinkDialog.
	 * 
	 * @param parent the parent shell of the dialog
	 * @param labelText the label text to be shown
	 * @param textBoxContent the text to be shown in the non editable TextBox
	 */
	public LinkDialog(Shell parent, String labelText, String textBoxContent) {
		super(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.ICON_INFORMATION);
		setLabelText(labelText);
		setText("Input Dialog");
		setTextBoxContent(textBoxContent);
	}

	/**
	 * Sets the of the non-editable TextBox of the dialog.
	 * 
	 * @param text the text to be shown with in the non-editable TextBox of the dialog
	 */
	public void setTextBoxContent(String text) {
		this.textBoxContent = text;
	}

	/**
	 * Returns the current text of the non-editable TextBox which is contained in the dialog.
	 * 
	 * @return the text of the non-editable TextBox
	 */
	public String getTextBoxConent() {
		return textBoxContent;
	}

	/**
	 * Sets the label text of the dialog.
	 * 
	 * @param labelText the label text to be shown.
	 */
	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	/**
	 * Gets the label text of the dialog.
	 * 
	 * @return the label text.
	 */
	public String getLabelText() {
		return labelText;
	}

	/**
	 * Opens the dialog.
	 */
	public void open() {
		Shell shell = new Shell(getParent(), getStyle());
		shell.setText(getText());
		createContents(shell);
		shell.pack();
		shell.open();
		Display display = getParent().getDisplay();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Creates the dialog's contents.
	 * 
	 * @param shell the dialog window
	 */
	private void createContents(final Shell shell) {
		shell.setLayout(new GridLayout(1, true));

		Label label = new Label(shell, SWT.NONE);
		label.setText(getLabelText());
		GridData data = new GridData();
		data.horizontalSpan = 1;
		label.setLayoutData(data);

		final Text text = new Text(shell, SWT.BORDER);
		data = new GridData(GridData.CENTER);
		data.horizontalSpan = 1;
		text.setLayoutData(data);
		text.setEditable(false);
		text.setText(textBoxContent);

		Button ok = new Button(shell, SWT.PUSH);
		ok.setText("OK");
		data = new GridData(GridData.CENTER);
		ok.setLayoutData(data);
		ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				shell.close();
			}
		});

		shell.setDefaultButton(ok);
	}

}
