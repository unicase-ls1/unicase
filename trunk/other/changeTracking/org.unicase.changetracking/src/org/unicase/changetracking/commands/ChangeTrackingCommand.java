/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.unicase.changetracking.common.IUserInterfaceRunnable;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Abstract base class of all commands used by the change tracking plug-in and
 * its adapters. It is a subclass of Unicase command and thus is able to alter
 * model elements of a Unicase project.
 * 
 * It mainly adds the behaviour that a change tracking result can be obtained
 * after the command has run. In addition, ALL runtime exceptions which may be
 * thrown by the command execution are caught and saved in an error result.
 * 
 * In addition, a change tracking command can specify its progress display kind.
 * This means that the command can specify if it should be run with a progress
 * monitor, busy cursor, or no visible progress display support. The method to
 * be used is progress monitor by default but can be changed by implementations
 * by overwriting the
 * {@link ChangeTrackingCommand#getPreferredProgressDisplayKind()} method. The
 * command can obtain the progress monitor by calling
 * {@link ChangeTrackingCommand#getProgressMonitor()}.
 * The command will ensure that {@link IProgressMonitor#done()} is called after
 * the command execution, even if an exception has been thrown. This ensures
 * that no progress monitor dialog will stay open after the command was aborted
 * somehow.
 * 
 * 
 * @author jfinis
 * 
 */
public abstract class ChangeTrackingCommand extends UnicaseCommandWithResult<ChangeTrackingCommandResult> implements IUserInterfaceRunnable {

	/**
	 * Creates a new CANCEL result.
	 * 
	 * @return CANCEL result.
	 */
	protected ChangeTrackingCommandResult cancelResult() {
		return new ChangeTrackingCommandResult(ChangeTrackingCommandResult.ResultType.CANCELLED, null);
	}

	/**
	 * Returns a new ERROR result from an exception.
	 * 
	 * @param e exception which caused the error.
	 * @return ERROR result.
	 */
	protected ChangeTrackingCommandResult errorResult(Throwable e) {
		return new ChangeTrackingCommandResult(e);
	}

	/**
	 * Returns a SUCCESS result.
	 * 
	 * @param message The success message which will be shown in a message box.
	 *            If now message should be shown, use null.
	 * @return SUCCESS result.
	 */
	protected ChangeTrackingCommandResult successResult(String message) {
		return new ChangeTrackingCommandResult(ChangeTrackingCommandResult.ResultType.SUCCESS, message);
	}

	/**
	 * Returns a new MISUSE result, stating that the user used the tool wrongly.
	 * 
	 * @param message Message stating the misuse.
	 * @return MISUSE result.
	 */
	protected ChangeTrackingCommandResult misuseResult(String message) {
		return new ChangeTrackingCommandResult(ChangeTrackingCommandResult.ResultType.MISUSE, message);
	}

	/**
	 * Returns a new WARNING result, stating that the command was executed but a
	 * warning occurred.
	 * 
	 * @param message the warning message.
	 * @return WARNING result.
	 */
	protected ChangeTrackingCommandResult warningResult(String message) {
		return new ChangeTrackingCommandResult(ChangeTrackingCommandResult.ResultType.WARNING, message);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProgressDisplayKind getPreferredProgressDisplayKind() {
		return ProgressDisplayKind.PROGRESS_MONITOR;
	}

	/**
	 * The progress monitor of this command.
	 */
	private IProgressMonitor progressMonitor;

	/**
	 * The result of this command.
	 */
	private ChangeTrackingCommandResult result;

	/**
	 * {@inheritDoc}
	 */
	public void run(IProgressMonitor monitor) {
		this.progressMonitor = monitor;
		this.setResult(run(true));
	}

	/**
	 * Returns the progress monitor which was set for this command. If no
	 * monitor was set, a NullProgressMonitor is returned.
	 * 
	 * @return progress monitor
	 */
	protected IProgressMonitor getProgressMonitor() {
		if (progressMonitor == null) {
			progressMonitor = new NullProgressMonitor();
		}
		return progressMonitor;
	}

	/**
	 * Sets the result for this command.
	 * 
	 * @param result the result
	 */
	public void setResult(ChangeTrackingCommandResult result) {
		this.result = result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void commandBody() {
		try {
			result = doRun();
		} catch (MisuseException e) {
			result = misuseResult(e.getMessage());
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (CancelledByUserException e) {
			result = cancelResult();
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			result = errorResult(e);
		} finally {
			// In all cases, finish the progress monitor if one exists
			if (progressMonitor != null) {
				progressMonitor.done();
			}
		}
	}

	/**
	 * Returns the change tracking result which was the result of the command's
	 * execution.
	 * 
	 * @return result
	 */
	public ChangeTrackingCommandResult getCTResult() {
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public ChangeTrackingCommandResult run(boolean ignoreExceptions) {
		super.aRun(ignoreExceptions);
		return this.result;
	}
}
