package org.unicase.errorreportclient.reporthandlers;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.errorreport.reporthandler.ErrorReportDialog;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class RSSReportHandler implements IReportHandler {

	public RSSReportHandler() {

	}

	public void handleReport(IStatus errorLogEntry) {
		System.out.println("rss report handler in client called");
		
		//Testing opening an email client
		reportError(errorLogEntry);
		//Testing opening a MessageDialog
//		new MessageDialog(null, "Error", null, "Testing Dialog", MessageDialog.ERROR, new String[] { "OK" }, 0).open();
		//Testing opening the ErrorReportDialog
//		new ErrorReportDialog (null, errorLogEntry).open();
		
	}

	public void handleReport(List<IStatus> errorLogEntries) {
		// TODO Auto-generated method stub

	}
	
	private void reportError(IStatus status) {
		StringBuilder sb = new StringBuilder("mailto:Ulli@java-tutor.com");
		// email address will be used in the DefaultReportHandler.
//		sb.append(email);
		sb.append("?");
		// subject
		sb.append("subject=Error%20in%20");
		sb.append(status.getPlugin());
		sb.append("&");
		// body
		// There is still a problem with inserting the body. Maybe it is depended on the program. I used Thunderbird.
		sb.append("body=hello");
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
