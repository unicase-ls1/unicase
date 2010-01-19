/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.security.AccessControlException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.exceptions.ClientVersionOutOfDateException;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.emfstore.exceptions.SessionTimedOutException;
import org.unicase.emfstore.exceptions.UnknownSessionException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A super class to handle all requests made to the server.
 * 
 * @author Shterev
 */
public abstract class ServerRequestHandler extends AbstractHandler {

	private String taskTitle = "Executing server request...";

	private Usersession usersession;

	private ExecutionEvent event;

	private Shell shell;

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.setEvent(event);
		return handleRun();
	}

	/**
	 * @return the usersession
	 */
	protected Usersession getUsersession() {
		if (usersession == null) {
			initUsersession();
		}
		return usersession;
	}

	/**
	 * inits the proper usersession.
	 */
	protected void initUsersession() {
		ProjectSpace projectSpace = ActionHelper.getProjectSpace(getEvent());
		if (projectSpace != null && projectSpace.getUsersession() != null) {
			usersession = projectSpace.getUsersession();
		} else {
			ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace();
			if (activeProjectSpace != null && activeProjectSpace.getUsersession() != null) {
				usersession = activeProjectSpace.getUsersession();
			}
		}
	}

	/**
	 * @param usersession the usersession to set
	 */
	protected void setUsersession(Usersession usersession) {
		this.usersession = usersession;
	}

	// BEGIN SUPRESS CATCH EXCEPTION
	/**
	 * Wraps the run procedures and handles exceptions.
	 * 
	 * @return the return value of the handler.
	 * @throws ExecutionException the {@link ExecutionException} if the LoginHandler throws one.
	 */
	protected Object handleRun() throws ExecutionException {
		shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		Object ret = null;
		Usersession session = getUsersession();
		if (session == null) {
			MessageDialog.openInformation(shell, "Information",
				"Could not determine a proper usersession. Please make sure you have selected a project.");
			return null;
		}

		LoginHandler loginHandler = new LoginHandler(session);

		ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(shell);
		progressDialog.open();
		progressDialog.getProgressMonitor().beginTask(taskTitle, IProgressMonitor.UNKNOWN);

		try {
			session.updateACUser();
			try {
				ret = run();
			} catch (ClientVersionOutOfDateException e) {
				MessageDialog
					.openError(shell, "Client version outdated",
						"The client version is incompatible with the server. Please update your plugins via the Update Manager.");
			} catch (InvalidVersionSpecException e) {
				DialogHandler.showErrorDialog("The requested revision was invalid");
			}
		} catch (SessionTimedOutException e) {
			if (loginHandler.execute(getEvent()).equals(Window.OK)) {
				handleRun();
			}
		} catch (UnknownSessionException e) {
			if (loginHandler.execute(getEvent()).equals(Window.OK)) {
				handleRun();
			}
		} catch (AccessControlException e) {
			DialogHandler.showErrorDialog(e.getMessage());
			if (loginHandler.execute(getEvent()).equals(Window.OK)) {
				handleRun();
			}
		} catch (ConnectionException e) {
			if (loginHandler.execute(getEvent()).equals(Window.OK)) {
				handleRun();
			}
		} catch (EmfStoreException e) {
			DialogHandler.showErrorDialog(e.getMessage());
		} catch (RuntimeException e) {

			DialogHandler.showExceptionDialog(e);
			WorkspaceUtil.logWarning("RuntimeException in " + ServerRequestHandler.class.getName(), e);
		}

		progressDialog.close();
		return ret;
	}

	// END SUPRESS CATCH EXCEPTION

	/**
	 * Runs the actions that should be carried out by this handler. Replaces the standard execute() method, which it is
	 * actually wrapped in.
	 * 
	 * @throws EmfStoreException forwards any server exceptions that may be thrown.
	 * @return the return object for this handler.
	 */
	protected abstract Object run() throws EmfStoreException;

	/**
	 * @param taskTitle the taskTitle to set
	 */
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	/**
	 * @return the taskTitle
	 */
	public String getTaskTitle() {
		return taskTitle;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(ExecutionEvent event) {
		this.event = event;
	}

	/**
	 * @return the event
	 */
	public ExecutionEvent getEvent() {
		return event;
	}

	/**
	 * @return the active shell.
	 */
	protected Shell getShell() {
		return shell;
	}

}
