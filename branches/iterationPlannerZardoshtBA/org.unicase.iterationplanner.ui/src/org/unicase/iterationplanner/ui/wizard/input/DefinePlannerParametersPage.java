package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.unicase.iterationplanner.ui.wizard.PlannerController;
import org.unicase.iterationplanner.ui.wizard.ProjectController;

public class DefinePlannerParametersPage extends WizardPage {

	private static final String PAGE_TITLE = "Define AbstractPlanner Parameters";
	private static final String PAGE_DESCRIPTION= "Define planner parameters page description";
	@SuppressWarnings("unused")
	private ProjectController projectBridge;
	@SuppressWarnings("unused")
	private PlannerController plannerBridge;
	
	
	protected DefinePlannerParametersPage(String pageName, ProjectController projectBridge, PlannerController plannerBridge) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		this.projectBridge = projectBridge;
		this.plannerBridge = plannerBridge;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(new GridLayout(1, false));
		container.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
		
		setControl(container);
	}

	@Override
	public IWizardPage getNextPage() {
		// TODO Auto-generated method stub
		return super.getNextPage();
	}

	
}
