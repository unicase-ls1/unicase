package org.unicase.errorreportclient.reporthandlers;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class TweeterReportHandler implements IReportHandler {

	public TweeterReportHandler() {
	}

	@Override
	public void handleReport(IStatus errorLogEntry) {
		// tweet this entry
	}

	@Override
	public void handleReport(List<IStatus> errorLogEntries) {

	}

}
