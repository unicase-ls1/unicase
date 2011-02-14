package org.unicase.errorreport.reporthandler;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

/**
 * This is the default implementation of reporting mechanism. This shows a dialog which send the error report to an email address specified by the clients of reporting plugin. 
 * @author zardosht
 *
 */
public class DefaultReportHandler implements IReportHandler {
	
	private String email;
	
	public DefaultReportHandler(String email) {
		this.email = email;
	}

	public void handleReport(IStatus errorLogEntry) {
		
		
		System.out.println("defualt report hander called.");
		new ErrorReportDialog (null, errorLogEntry, email).open();
	}

	public void handleReport(List<IStatus> errorLogEntries) {
		
	}

}
