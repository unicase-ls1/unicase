package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.unicase.iterationplanner.ui.wizard.PlannerBridge;
import org.unicase.iterationplanner.ui.wizard.ProjectBridge;

public class DefinePlannerParametersPage extends WizardPage {

	private static final String PAGE_TITLE = "Define Planner Parameters";
	private static final String PAGE_DESCRIPTION= "Define planner parameters page description";
	private ProjectBridge projectBridge;
	private PlannerBridge plannerBridge;
	
	
	protected DefinePlannerParametersPage(String pageName, ProjectBridge projectBridge, PlannerBridge plannerBridge) {
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
