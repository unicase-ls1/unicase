/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.dialogs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This dialog takes a status object and shows its message. The dialog has details button that if an exception is also
 * included in status object when clicked shows its stack trace. It also includes a rport button which automatically
 * opens email client with a message to unicase-bug mailing list.
 * 
 * @author Hodaie
 */
public class ErrorReportDialog extends MessageDialog {

	private IStatus status;
	private Text txtDetails;

	private int detailButtonID = -1;
	private int reportButtonID = -1;
	private String detailText;

	/**
	 * Size of the text in lines.
	 */
	private static final int TEXT_LINE_COUNT = 15;

	/**
	 * Constructor.
	 * 
	 * @param parentShell shell
	 * @param status status
	 */
	public ErrorReportDialog(Shell parentShell, IStatus status) {
		super(parentShell, "Error", null, status.getMessage(), MessageDialog.ERROR,
			new String[] { IDialogConstants.OK_LABEL }, 0);
		this.status = status;
		if (status.getException() != null) {
			setButtonLabels(new String[] { IDialogConstants.OK_LABEL, "Report", IDialogConstants.SHOW_DETAILS_LABEL });
			reportButtonID = 1;
			detailButtonID = 2;
			extractDetailText();
		}
		setShellStyle(getShellStyle() | SWT.RESIZE | SWT.APPLICATION_MODAL);
	}

	private void extractDetailText() {
		// print the stacktrace in the text field
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			status.getException().printStackTrace(ps);
			ps.flush();
			baos.flush();
			detailText = baos.toString();
		} catch (IOException e) {
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int open() {
		create();
		// focus problem in SWT.
		Button btnOk = getButton(0);
		btnOk.setFocus();
		btnOk.getShell().setDefaultButton(btnOk);
		return super.open();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.MessageDialog#buttonPressed(int)
	 */
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == detailButtonID) {
			toggleDetailsArea();
		} else if (buttonId == reportButtonID) {
			reportError();
		} else {
			super.buttonPressed(buttonId);
		}
	}

	/**
	 * Toggles the unfolding of the details area. This is triggered by the user pressing the details button.
	 */
	private void toggleDetailsArea() {
		Point windowSize = getShell().getSize();
		Point oldSize = getContents().computeSize(SWT.DEFAULT, SWT.DEFAULT);

		if (txtDetails != null) {
			txtDetails.dispose();
			txtDetails = null;
			getButton(detailButtonID).setText(IDialogConstants.SHOW_DETAILS_LABEL);
		} else {
			createDropDownText((Composite) getContents());
			getButton(detailButtonID).setText(IDialogConstants.HIDE_DETAILS_LABEL);
		}

		Point newSize = getContents().computeSize(SWT.DEFAULT, SWT.DEFAULT);
		getShell().setSize(new Point(windowSize.x, windowSize.y + (newSize.y - oldSize.y)));
	}

	/**
	 * Create this dialog's drop-down text component.
	 * 
	 * @param parent the parent composite
	 */
	protected void createDropDownText(Composite parent) {
		// create the list
		txtDetails = new Text(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		txtDetails.setFont(parent.getFont());
		txtDetails.setText(detailText);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gridData.heightHint = txtDetails.getLineHeight() * TEXT_LINE_COUNT;
		txtDetails.setLayoutData(gridData);
	}

	/**
	 * Summarizes status in an email message and opens default email client.
	 */
	private void reportError() {
		StringBuilder sb = new StringBuilder("mailto:unicase-bugs@in.tum.de?");
		// subject
		sb.append("subject=Error in ");
		sb.append(status.getPlugin());
		sb.append("&");
		// body
		sb.append("body=");
		sb.append("Statck trace: %0A");
		sb.append(detailText);

		String message = sb.toString();

		boolean successful = false;

		successful = Program.launch(message);

		if (!successful) {
			MessageDialog
				.openInformation(
					getShell(),
					"Error",
					"An error occured when trying to launch your email client. You can click on details button to copy the problem description and then send it to unicase-bugs@in.tum.de ");
		}

	}
}
