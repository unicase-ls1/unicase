/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer.questionnaire.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * @author liya
 *
 */
public class QuestionnaireWizard extends Wizard implements IWorkbenchWizard {

	private ChooseUserPage chooseUserPage;
	private int user;
	private boolean canFinish;
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		QuestionnaireManager.dispose();
		QuestionnaireManager.getInstance().setUser(user);
		QuestionnaireManager.getInstance().initCommitMap();
		QuestionnaireManager.getInstance().initExporter();
		return super.performCancel();
	}
	
	@Override
	public boolean canFinish() {
		return canFinish;
	}
	
	public void setCanFinish(boolean canFinish){
		this.canFinish = canFinish;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void addPages() {
		chooseUserPage = new ChooseUserPage("ChooseUserPage");
		addPage(chooseUserPage);
	}

	/**
	 * @return the user
	 */
	public int getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(int user) {
		this.user = user;
	}

}
