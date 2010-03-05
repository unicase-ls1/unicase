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
public class CreateDeleteMEWizard extends Wizard implements IWorkbenchWizard {

	private CreateDeleteMEPage page;
	private int index;
	private boolean canFinish;

	/**
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		// QuestionnaireManager.getInstance().addCreateDeleteResult(
		// QuestionnaireManager.getInstance().getCreateDeleteResult());
		return true;
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	public void setIndex(int value) {
		this.index = value;

	}

	@Override
	public void addPages() {
		for (index = 0; index < 2; index++) {
			page = new CreateDeleteMEPage("Page", index);
			addPage(page);
		}
	}

	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;

	}

	@Override
	public boolean canFinish() {
		return canFinish;
	}

}
