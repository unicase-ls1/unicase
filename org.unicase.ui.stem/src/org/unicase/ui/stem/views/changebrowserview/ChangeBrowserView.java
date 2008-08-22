package org.unicase.ui.stem.views.changebrowserview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.ui.stem.views.AbstractSCMView;

public class ChangeBrowserView extends AbstractSCMView {

	private ChangePackage changePackage;
	private ChangesComposite changesComposite;
	
	public ChangeBrowserView() {
		
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		browserTab.setText("Changes");

	}

	@Override
	public void setFocus() {
		

	}

	@Override
	protected void refreshClicked() {
		lblCriteria.setText(queryComposite.getQuery().getDescription());
		
	}

	@Override
	protected Control setBrowserTabControl() {
		
		 
		changesComposite = new ChangesComposite(tabFolder, SWT.NONE);
		changesComposite.setInput(this.changePackage);
		return changesComposite;
	}
	
	public void setInput(ChangePackage input){
		this.changePackage = input;
		changesComposite.setInput(input);
	}
	
	public ChangePackage getInput(){
		return this.changePackage;
	}

}
