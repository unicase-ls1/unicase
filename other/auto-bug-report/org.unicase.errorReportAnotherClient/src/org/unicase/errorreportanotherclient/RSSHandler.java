package org.unicase.errorreportanotherclient;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class RSSHandler implements IReportHandler {

	public RSSHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleReport(IStatus errorLogEntry) {
		System.out.println("rss report handler in another client called");

	}

	@Override
	public void handleReport(List<IStatus> errorLogEntries) {
		// TODO Auto-generated method stub

	}

}
