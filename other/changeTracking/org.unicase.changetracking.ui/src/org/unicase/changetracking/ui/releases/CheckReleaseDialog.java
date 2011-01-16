package org.unicase.changetracking.ui.releases;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class CheckReleaseDialog extends TitleAreaDialog {

	private ChangeTrackingRelease release;

	public CheckReleaseDialog(Shell parentShell, ChangeTrackingRelease release) {
		super(parentShell);
		this.release = release;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		ReleaseOverviewWidget releaseWidget = new ReleaseOverviewWidget(parent, SWT.NONE, release);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(releaseWidget);
		return releaseWidget;
	}
}
