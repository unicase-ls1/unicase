/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.common;

import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * Runnable class which supports displaying the progress of the runnable with
 * either a busy cursor or a progress monitor.
 * 
 * Implementations must implement the getPreferredProgressDisplay to decide
 * which kind of progress display is desired.
 * 
 * To run such command with the desired progess display kind, use
 * UIUtil.run(IUserInterfaceRunnable runnable).
 * 
 * @author jfinis
 * 
 */
public interface IUserInterfaceRunnable extends IRunnableWithProgress {

	/**
	 * Way to display the progress of a command's execution.
	 * 
	 * Can either not display the progress at all, use a busy cursor, or a
	 * progress monitor.
	 * 
	 * @author jfinis
	 * 
	 */
	public static enum ProgressDisplayKind {
		/**
		 * Do not display the progress. The command is run without any UI
		 * interaction.
		 */
		NONE,

		/**
		 * Display the progress with a busy cursor while the command is running.
		 */
		BUSY_CURSOR,

		/**
		 * Display the progress with a progress monitor.
		 */
		PROGRESS_MONITOR
	}

	/**
	 * Returns the preferred progress display kind of this runnable. If executed
	 * with UIUtil.run, this method will be invoked and the command will be run
	 * accordingly to its preferred display kind.
	 * 
	 * @return preferred display kind
	 */
	ProgressDisplayKind getPreferredProgressDisplayKind();

}
