/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;

/**
 * @author liya
 *
 */
public class ProjectAnalyzerWizard extends Wizard implements IWorkbenchWizard {

	
	private boolean canFinish;
	private boolean loggedIn;
	private IteratorPage iteratorPage;
	private ExporterPage exporterPage;
	private AnalyzerPage analyzerPage;
	private VersionIteratorPage versionIteratorPage;
	private TimeIteratorPage timeIteratorPage;
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
		canFinish = false;
		
		
		Object firstElement;
		if (!selection.isEmpty()) {
			firstElement = selection.getFirstElement();
			if (firstElement instanceof ProjectSpace) {
				Usersession selectedUsersession = ((ProjectSpace) firstElement).getUsersession();
				if (!selectedUsersession.isLoggedIn()) {
					loggedIn = false;
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Login required", "Log in first!");
				}else{
					loggedIn = true;
				}
			} else {
				throw new IllegalArgumentException("No Project selected!");
			}
		} else {
			throw new IllegalArgumentException("Nothing selected!");
		}
	}
	
    /** 
     * {@inheritDoc}
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    @Override
	public void addPages(){
    	
    	analyzerPage = new AnalyzerPage("AnalyzerPage");
		addPage(analyzerPage);
		iteratorPage = new IteratorPage("IteratorPage");
		addPage(iteratorPage);
		versionIteratorPage = new VersionIteratorPage("");
		addPage(versionIteratorPage);
		timeIteratorPage = new TimeIteratorPage("");
		addPage(timeIteratorPage);
		exporterPage = new ExporterPage("ExporterPage");
		addPage(exporterPage);
		
    }
	
    /** 
     * {@inheritDoc}
     * @see org.eclipse.jface.wizard.Wizard#canFinish()
     */
    @Override
	public boolean canFinish(){
    	return canFinish;
    }

	/**
	 * @param canFinish the canFinish to set
	 */
	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}

	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * @return the versionIteratorPage
	 */
	public VersionIteratorPage getVersionIteratorPage() {
		return versionIteratorPage;
	}

	/**
	 * @return the timeIteratorPage
	 */
	public TimeIteratorPage getTimeIteratorPage() {
		return timeIteratorPage;
	}

	/**
	 * @return the iteratorPage
	 */
	public IteratorPage getIteratorPage() {
		return iteratorPage;
	}

	/**
	 * @return the exporterPage
	 */
	public ExporterPage getExporterPage() {
		return exporterPage;
	}

	/**
	 * @return the analyzerPage
	 */
	public AnalyzerPage getAnalyzerPage() {
		return analyzerPage;
	}


}
