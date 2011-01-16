package org.unicase.changetracking.ui.releases;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.changetracking.ui.ReleaseTreeViewer;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class ReleaseOverviewWidget extends Composite {

	public ReleaseOverviewWidget(Composite parent, int style, ChangeTrackingRelease release) {
		super(parent, style);
		this.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		GridLayoutFactory.fillDefaults().margins(0, 0).applyTo(this);
		ReleaseTreeViewer treeViewer = new ReleaseTreeViewer(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(treeViewer);
		
		treeViewer.setInput(release);
		treeViewer.expandAll();
	}

}
