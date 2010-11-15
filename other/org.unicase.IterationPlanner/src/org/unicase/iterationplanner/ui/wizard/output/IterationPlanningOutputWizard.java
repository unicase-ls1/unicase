package org.unicase.iterationplanner.ui.wizard.output;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.Planner;

public class IterationPlanningOutputWizard extends Wizard {

	private IterationPlan iterationPlan;
	private Planner planner;

	public IterationPlanningOutputWizard(IterationPlan iterationPlan, Planner planner) {
		this.iterationPlan = iterationPlan;
		this.planner = planner;
	
	}
	
	
	

	@Override
	public void addPages() {
		WizardPage editSelectedIterationPlanPage = new EditSelecteIterationPlanPage("editSelectedIterationPlanPage", iterationPlan, planner);
		addPage(editSelectedIterationPlanPage);
	}




	@Override
	public boolean performFinish() {
		return true;
	}

}
