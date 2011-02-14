package org.unicase.iterationplanner.ui.wizard.output;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.unicase.iterationplanner.entities.IIterationPlan;
import org.unicase.iterationplanner.planner.Planner;

public class IterationPlanningOutputWizard extends Wizard {

	private IIterationPlan iterationPlan;
	private Planner planner;

	public IterationPlanningOutputWizard(IIterationPlan iterationPlan2, Planner planner) {
		this.iterationPlan = iterationPlan2;
		this.planner = planner;
	
	}
	
	
	

	@Override
	public void addPages() {
		WizardPage editSelectedIterationPlanPage = new EditSelectedIterationPlanPage("editSelectedIterationPlanPage", iterationPlan, planner);
		addPage(editSelectedIterationPlanPage);
	}




	@Override
	public boolean performFinish() {
		return true;
	}

}
