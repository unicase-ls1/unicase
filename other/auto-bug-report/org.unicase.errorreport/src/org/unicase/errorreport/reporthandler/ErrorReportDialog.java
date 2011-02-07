package org.unicase.errorreport.reporthandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ErrorReportDialog extends MessageDialog {
	
	private IStatus status;
	private Text txtDetails;

	private int detailButtonID = -1;
	private int reportButtonID = -1;
	private String detailText;
	private String email;
	
	/**
	 * Size of the text in lines.
	 */
	private static final int TEXT_LINE_COUNT = 15;
	
	/**
	 * Constructor.
	 * 
	 * @param parentShell shell
	 * @param status status
	 * @param email 
	 */
	public ErrorReportDialog(Shell parentShell, IStatus status, String email) {
		super(parentShell, "Error", null, status.getMessage(), MessageDialog.ERROR, new String[] { "OK" }, 0);
		this.status = status;
		this.email = email;
		if (status.getException() != null) {
			setButtonLabels(new String[] { "OK", "Report", "&Details >>" });
			reportButtonID = 1;
			detailButtonID = 2;
			extractDetailText();
		}
		setShellStyle(getShellStyle() | SWT.RESIZE | SWT.APPLICATION_MODAL);
	}

	private void extractDetailText() {
		// print the stack trace in the text field
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
			getButton(detailButtonID).setText("&Details >>");
		} else {
			createDropDownText((Composite) getContents());
			getButton(detailButtonID).setText("&Details >>");
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
	
	private void reportError() {
		StringBuilder sb = new StringBuilder("mailto:");
		// email address will be used in the DefaultReportHandler.
		sb.append(email);
		sb.append("?");
		// subject
		sb.append("subject=Error%20in%20");
		sb.append(status.getPlugin());
		sb.append("&");
		// body
		// There is still a problem with inserting the body. Maybe it is depended on the program. I used Thunderbird.
		sb.append("body=");
		sb.append("Stack%20trace:%0A");
		// detailText has a blank space. The email client will not start.
//		sb.append(detailText);

		String message = sb.toString();
		
		// open an external email client, ProcessBuilder used because java.awt.Desktop is included up Java 6.
		try {
			new ProcessBuilder( "cmd", "/c", "start", "/B", message).start();
		} catch (IOException e) {
			e.printStackTrace();
			MessageDialog.openInformation(
				null,
				"Error",
				"An error occurred when trying to launch your email client. You can click on details button to copy the problem description and then send it to ");
		}
	}

}
