/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.commands;

import org.unicase.changetracking.release.ReleaseCheckReport;

/**
 * Abstract base class of all check release commands. Specifies the
 * CheckReleaseReport which was the result of the check.
 * 
 * @author jfinis
 * 
 */
public abstract class CheckReleaseCommand extends ChangeTrackingCommand {

	/**
	 * The report.
	 */
	private ReleaseCheckReport report;

	/**
	 * Sets the resulting report.
	 * 
	 * @param report the report.
	 */
	protected void setReport(ReleaseCheckReport report) {
		this.report = report;
	}

	/**
	 * Returns the resulting report. If the result of the command is not
	 * SUCCESS, then this method might return null.
	 * 
	 * @return the report or null if command was not successful.
	 */
	public ReleaseCheckReport getReport() {
		return report;
	}

}
