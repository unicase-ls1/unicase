/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.commands;

import java.util.Date;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.Activator;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.stem.views.dialogs.CommitDialog;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.edit.dialogs.LoginDialog;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.util.CommitObserver;

/**
 * 
 * @author Hodaie
 * @author Shterev
 * 
 * This handler handles CommitWorkspace command. This command is
 *         shown in UC View context menu only for Projects
 * 
 */
public class CommitProjectHandler extends ProjectActionHandler implements CommitObserver{

	private Shell shell;
	private Usersession usersession;
	private LogMessage logMessage;
	
	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace = getProjectSpace(event);


		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");																																																																																																																							  
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				commitWithoutCommand(projectSpace);
			}

			
		});
		return null;
	}
	
	private void commitWithoutCommand(final ProjectSpace projectSpace) {
		usersession = projectSpace.getUsersession();
		shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			       .getActiveWorkbenchWindow().getShell());
		LoginDialog login;
		// initially setting the status as successful in case the user
		// is already logged in
		int loginStatus = LoginDialog.SUCCESSFUL;
		try{
			if (!usersession.isLoggedIn()) {
				login = new LoginDialog(shell, usersession, usersession.getServerInfo());
				loginStatus = login.open();
			}
			if (loginStatus == LoginDialog.SUCCESSFUL) {
				progressDialog.open();
				progressDialog.getProgressMonitor().beginTask("Commit project...", 100);
				progressDialog.getProgressMonitor().worked(10);
				logMessage = VersioningFactory.eINSTANCE.createLogMessage();
				PrimaryVersionSpec oldVersion = projectSpace.getBaseVersion();
				PrimaryVersionSpec newVersion = projectSpace.commit(logMessage,CommitProjectHandler.this);
				if(!oldVersion.equals(newVersion)){
					MessageDialog.openInformation(shell, null, "Commit completed.");
				}
			}
		} catch (BaseVersionOutdatedException e) {
			MessageDialog dialog = new MessageDialog(null, "Confirmation",
					null, "Your project is outdated, you need to update before commit. Do you want to update now?",
					MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
			int result = dialog.open();
			if (result == 0) {
				new UpdateProjectHandler().update(projectSpace);
			}
		} catch (NoLocalChangesException e) {
			MessageDialog.openInformation(shell, null, "No local changes in your project. No need to commit.");
			
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		// BEGIN SUPRESS CATCH EXCEPTION
		} catch (Exception e) {
			DialogHandler.showExceptionDialog(e);
			
		}
		// END SUPRESS CATCH EXCEPTION
		finally {
			progressDialog.getProgressMonitor().done();
			progressDialog.close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean inspectChanges(ChangePackage changePackage) {
		CommitDialog commitDialog = new CommitDialog(shell,changePackage);
		int returnCode = commitDialog.open();
		if(returnCode==Window.OK){
			logMessage.setAuthor(usersession.getUsername());
			logMessage.setClientDate(new Date());
			logMessage.setMessage(commitDialog.getLogText());
			return true;
		}
		return false;
	}

}
