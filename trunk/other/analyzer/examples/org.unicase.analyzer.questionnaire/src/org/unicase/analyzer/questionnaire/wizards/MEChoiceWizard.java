/**
 * 
 */
package org.unicase.analyzer.questionnaire.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * @author liya
 */
public class MEChoiceWizard extends Wizard implements IWorkbenchWizard {

	private boolean canFinish;
	private MEChoicePage page;

	/**
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		QuestionnaireManager.getInstance().addMEResult(QuestionnaireManager.getInstance().getCurrentMEResult());
		return true;
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPages() {
		page = new MEChoicePage("ME page");
		addPage(page);
	}

	@Override
	public boolean canFinish() {
		return true;
	}

	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}

}
