/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Wizard for adding a new repository.
 * 
 * @author shterev
 */
public class NewRepositoryWizard extends Wizard implements INewWizard {

	private ServerInfo serverInfo;

	private NewRepositoryWizardPageOne mainPage;

	private IStructuredSelection selection;

	private IWorkbench workbench;

	private boolean edit;

	/**
	 * Default constructor.
	 * 
	 * @param view
	 *            callback to the repository view
	 */
	public NewRepositoryWizard() {
		super();
	}

	/**
	 * Adds all pages in the wizard.
	 */
	@Override
	public void addPages() {
		mainPage = new NewRepositoryWizardPageOne(workbench, selection);
		addPage(mainPage);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param workbench
	 *            the workbench
	 * @param selection
	 *            the selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
	}

	/**
	 *{@inheritDoc}
	 * 
	 * @param workbench
	 *            the workbench
	 * @param selection
	 *            the selection
	 * @param serverInfo
	 *            the serverInfo that would be modified
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection,
			ServerInfo serverInfo) {
		init(workbench, selection);
		this.serverInfo = serverInfo;
		this.edit = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canFinish() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		if (this.getContainer().getCurrentPage().canFlipToNextPage()) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					// save serverInfo to workspace
					Workspace workspace = WorkspaceManager.getInstance()
							.getCurrentWorkspace();
					if (!NewRepositoryWizard.this.edit) {
						workspace.getServerInfos().add(
								NewRepositoryWizard.this.serverInfo);
					}
					workspace.save();
				}
			}.run();
			dispose();
		} else {
			MessageDialog.openError(workbench.getActiveWorkbenchWindow()
					.getShell(), "Error", "Field(s) were left blank!");
			return false;
		}
		return true;
	}

	/**
	 * Getter for the ServerInfo.
	 * 
	 * @return the {@link ServerInfo}
	 */
	public ServerInfo getServerInfo() {
		return serverInfo;
	}

}