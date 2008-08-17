package org.unicase.ui.stem.views.changebrowserview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.stem.views.SCMView;

public class ChangeBrowserView extends SCMView {

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
		
		
	}

	@Override
	protected Control setBrowserTabControl() {
		
		return new ChangesComposite(tabFolder, SWT.NONE);
		
	}

}
