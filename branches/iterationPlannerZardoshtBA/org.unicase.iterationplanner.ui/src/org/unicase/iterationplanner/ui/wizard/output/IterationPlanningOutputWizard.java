package org.unicase.iterationplanner.ui.wizard.output;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.unicase.iterationplanner.planner.AbstractPlanner;
import org.unicase.iterationplanner.planner.IIterationPlan;

public class IterationPlanningOutputWizard extends Wizard {

	private IIterationPlan iterationPlan;
	private AbstractPlanner planner;

	public IterationPlanningOutputWizard(IIterationPlan iterationPlan2, AbstractPlanner planner) {
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
