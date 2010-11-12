package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.swt.widgets.Composite;

public class DefineRequirementsPage extends AbstractInputPage {

	private static final String PAGE_TITLE = "Define Requirements";
	private static final String PAGE_DESCRIPTION= "define requirements page description";
	
	
	public DefineRequirementsPage(String pageName) {
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
		return "All requirements in the project: ";
	}


	@Override
	protected String getTargetContorlDescription() {
		return "Requirements to be planned: ";
	}

}
