package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.swt.widgets.Composite;

public class DefineAssigneesPage extends AbstractInputPage {

	private static final String PAGE_TITLE = "Define Assignees";
	private static final String PAGE_DESCRIPTION= "Define Assignees page description";

	public DefineAssigneesPage(String pageName) {
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
	protected boolean hasExtraControls() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getSourceControlDescription() {
		return "All users/groups in the project: ";
	}

	@Override
	protected String getTargetContorlDescription() {
		return "Assignees for iteration planning: ";
	}

	
	
}
