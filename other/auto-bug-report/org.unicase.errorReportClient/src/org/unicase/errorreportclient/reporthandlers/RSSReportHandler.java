package org.unicase.errorreportclient.reporthandlers;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class RSSReportHandler implements IReportHandler {

	public RSSReportHandler() {

	}

	public void handleReport(IStatus errorLogEntry) {
		System.out.println("rss report handler in client called");
		
	}

	public void handleReport(List<IStatus> errorLogEntries) {
		// TODO Auto-generated method stub

	}
	
}
