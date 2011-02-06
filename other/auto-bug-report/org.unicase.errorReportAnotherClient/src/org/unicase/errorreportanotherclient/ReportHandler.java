package org.unicase.errorreportanotherclient;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class ReportHandler implements IReportHandler {

	public ReportHandler() {
	}

	@Override
	public void handleReport(IStatus errorLogEntry) {
		System.out.println("report handler in another client called");
	}

	@Override
	public void handleReport(List<IStatus> errorLogEntries) {
		
	}

}
