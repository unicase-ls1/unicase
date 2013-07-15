/**
 * 
 */
package org.unicase.scrm.review.ui.views;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * @author liya
 *
 */
public class ExportWizard extends Wizard implements IWorkbenchWizard {

	private ExportWizardPage page;
	private String incompleteNumber;
	private String path;
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		incompleteNumber = page.getNumberOfMissingReq().getText();
		path = page.getPath().getText();
		return true;
	}
	@Override
	public void addPages() {
		page = new ExportWizardPage("Export");
		addPage(page);
	}



	/**
	 * @return the incompleteNumber
	 */
	public String getIncompleteNumber() {
		return incompleteNumber;
	}



	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

}
