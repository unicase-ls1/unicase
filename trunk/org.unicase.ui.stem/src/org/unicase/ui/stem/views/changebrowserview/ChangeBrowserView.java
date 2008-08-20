package org.unicase.ui.stem.views.changebrowserview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.ui.stem.views.AbstractSCMView;

public class ChangeBrowserView extends AbstractSCMView {

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
		
		return new ChangesComposite(tabFolder, SWT.NONE);
		
	}

}
