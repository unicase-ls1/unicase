/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.views;

import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Workspace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

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
	 * @param workbench the workbench
	 * @param selection the selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		serverInfo = ModelFactory.eINSTANCE.createServerInfo();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param workbench the workbench
	 * @param selection the selection
	 * @param serverInfo the serverInfo that would be modified
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection, ServerInfo serverInfo) {
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
			new EMFStoreCommand() {
				@Override
				protected void doRun() {
					// save serverInfo to workspace
					Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
					if (!NewRepositoryWizard.this.edit) {
						workspace.getServerInfos().add(NewRepositoryWizard.this.serverInfo);
					}
					workspace.save();
				}
			}.run();
			dispose();
		} else {
			MessageDialog.openError(workbench.getActiveWorkbenchWindow().getShell(), "Error",
				"Field(s) were left blank!");
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
