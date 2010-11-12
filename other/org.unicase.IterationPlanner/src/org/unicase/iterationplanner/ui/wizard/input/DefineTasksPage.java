package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class DefineTasksPage extends AbstractInputPage {
	
	private static final String PAGE_TITLE = "Define Tasks";
	private static final String PAGE_DESCRIPTION= "Define tasks page description";
	
	
	public DefineTasksPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}


	@Override
	protected void createSourceControl(Composite sourceControlComposite) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void createTargetControl(Composite targetControlComposite) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void onAddAllClicked() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void onAddClicked() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void onRemoveAllClicked() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void onRemoveClicked() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void createExtraControls(Composite extraControlsComposite) {
		extraControlsComposite.setLayout(new GridLayout(2, false));
		
		Label lblNumOfIterations = new Label(extraControlsComposite, SWT.NONE);
		lblNumOfIterations.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		lblNumOfIterations.setText("Number of Iterations: ");
		
		Spinner spnrNumOfIterations = new Spinner(extraControlsComposite, SWT.BORDER);
		spnrNumOfIterations.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		spnrNumOfIterations.setMaximum(5);
		spnrNumOfIterations.setMinimum(1);
		spnrNumOfIterations.setIncrement(1);

	}


	@Override
	protected boolean hasExtraControls() {
		return true;
	}


	@Override
	protected String getSourceControlDescription() {
		return "All work items in the project: ";
	}


	@Override
	protected String getTargetContorlDescription() {
		return "Tasks to be planned: ";
	}

}
