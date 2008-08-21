package org.unicase.ui.stem.views.historybrowserview;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.ui.stem.views.AbstractSCMView;
import org.unicase.ui.stem.views.dialogs.CommitDialog;
import org.unicase.ui.stem.views.dialogs.UpdateDialog;

public class HistoryBrowserView extends AbstractSCMView {

	private Composite parent;
	
	public HistoryBrowserView() {
		
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		browserTab.setText("History");
		this.parent = parent;
	}

	@Override
	public void setFocus() {
	
		
	}

	@Override
	protected void refreshClicked() {
//		lblCriteria.setText(queryComposite.getQuery().getDescription());

//		CommitDialog commitDialog = new CommitDialog(parent.getShell());
//		commitDialog.create();
//		commitDialog.open();
		
		UpdateDialog updateDialog = new UpdateDialog(parent.getShell());
		updateDialog.create();
		updateDialog.open();
	}

	@Override
	protected Control setBrowserTabControl() {
		return new HistoryComposite(tabFolder, SWT.NONE);
	}

}
