package org.unicase.changetracking.commands;

import org.unicase.changetracking.release.ReleaseCheckReport;


public abstract class CheckReleaseCommand extends ChangeTrackingCommand {

	private ReleaseCheckReport report;

	protected void setReport(ReleaseCheckReport report) {
		this.report = report;
	}

	public ReleaseCheckReport getReport() {
		return report;
	}
	
}
