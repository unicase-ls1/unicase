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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.stem.views.dialogs.CommitDialog;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.edit.dialogs.LoginDialog;
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
	protected Usersession usersession;
	protected LogMessage logMessage;
	
	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		final ProjectSpace projectSpace = getProjectSpace(event);


		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");																																																																																																																							  
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			protected void doExecute() {
				usersession = projectSpace.getUsersession();
				shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
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
						logMessage = VersioningFactory.eINSTANCE.createLogMessage();
						projectSpace.commit(logMessage,CommitProjectHandler.this);
						MessageDialog.openInformation(shell, null, "Commit completed.");
					}
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}catch(NullPointerException np){
					//usersession was null -> fail silently
				}
			}
		});
		return null;
	}

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
