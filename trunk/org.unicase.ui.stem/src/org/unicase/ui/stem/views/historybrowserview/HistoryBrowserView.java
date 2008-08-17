package org.unicase.ui.stem.views.historybrowserview;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.ui.stem.views.SCMView;

public class HistoryBrowserView extends SCMView {

	public HistoryBrowserView() {
		
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		browserTab.setText("History");
	}

	@Override
	public void setFocus() {
	
		
	}

	@Override
	protected void refreshClicked() {
		
		
	}

	@Override
	protected Control setBrowserTabControl() {
		return new HistoryComposite(tabFolder, SWT.NONE);
	}

}
