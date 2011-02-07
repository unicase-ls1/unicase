package org.unicase.errorreportclient.reporthandlers;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class TweeterReportHandler implements IReportHandler {

	public TweeterReportHandler() {
	}

	public void handleReport(IStatus errorLogEntry) {
		// tweet this entry
		System.out.println("tweet report handler in client called");
	}

	public void handleReport(List<IStatus> errorLogEntries) {

	}

}
