/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer.questionnaire.wizards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.workspace.Configuration;

/**
 * @author liya
 *
 */
public class EvaluationWizard extends Wizard implements IWorkbenchWizard {

	private boolean canFinish;
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		List<Object> line = new ArrayList<Object>();
		line.add(QuestionnaireManager.getInstance().getVersion());
		line.add(QuestionnaireManager.getInstance().getTime());
		line.add(QuestionnaireManager.getInstance().getEvaluationResult());
		
		try {
			QuestionnaireManager.getInstance().getExporter().writeLine(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		EvaluatePage page = new EvaluatePage("Evaluation");
		addPage(page);
	}

}
