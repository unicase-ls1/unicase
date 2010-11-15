package org.unicase.iterationplanner.ui.wizard.output;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.unicase.iterationplanner.planner.IterationPlan;

public class IterationPlanningOutputWizard extends Wizard {

	private IterationPlan iterationPlan;

	public IterationPlanningOutputWizard(IterationPlan iterationPlan) {
		this.iterationPlan = iterationPlan;
	
	}
	
	
	

	@Override
	public void addPages() {
		WizardPage editSelectedIterationPlanPage = new EditSelecteIterationPlanPage("editSelectedIterationPlanPage", iterationPlan);
		addPage(editSelectedIterationPlanPage);
	}




	@Override
	public boolean performFinish() {
		return true;
	}

}
