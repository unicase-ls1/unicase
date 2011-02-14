package org.unicase.errorreport.reporthandler;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

public interface IReportHandler {
	
	/**
	 * To handle just a single error log entry. 
	 * @param errorLogEntry
	 */
	void handleReport(IStatus errorLogEntry);
	
	/**
	 * If you are going to handle multiple related error log entries at once, use this. 
	 * @param errorLogEntries
	 */
	void handleReport(List<IStatus> errorLogEntries);

}
