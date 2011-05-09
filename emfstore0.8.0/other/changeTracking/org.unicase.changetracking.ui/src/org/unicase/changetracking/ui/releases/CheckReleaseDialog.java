package org.unicase.changetracking.ui.releases;


import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.ui.Activator;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class CheckReleaseDialog extends TitleAreaDialog implements IDialogHead  {


	private static final Image PAGE_IMAGE = Activator.getImageDescriptor("icons/wizard/check_release.png").createImage();
	
	private ChangeTrackingRelease release;
	private ReleaseCheckReport report;

	public CheckReleaseDialog(Shell parentShell, ChangeTrackingRelease release, ReleaseCheckReport report) {
		super(parentShell);
		this.release = release;
		this.report = report;
		
		
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Release Checking Report");
		setShellStyle(getShellStyle() | SWT.CLOSE | SWT.TITLE | SWT.BORDER

				| SWT.APPLICATION_MODAL | SWT.RESIZE);
	}

	@Override
	protected Button createButton(Composite parent, int id, String label,
			boolean defaultButton) {
		if(id == Window.CANCEL){
			return null;
		}
		return super.createButton(parent, id, label, defaultButton);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitleImage(PAGE_IMAGE);
		setTitle("Release Checking Report");
	
		ReleaseOverviewWidget releaseWidget = new ReleaseOverviewWidget(parent, SWT.NONE,release, report);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(releaseWidget);

		configureDialogHead(report);
		
		return releaseWidget;
	}
	
	private void configureDialogHead(ReleaseCheckReport report) {
		
		if(report.hasErrors()){
			setMessage("There are errors in the release. Check the 'problems' tab for details.", IMessageProvider.ERROR);
		} else if(report.hasWarnings()){
			setMessage("There are warnings in the release. Check the 'problems' tab for details.", IMessageProvider.WARNING);
		} else {
			setMessage("No errors were found in this release.", IMessageProvider.INFORMATION);
		}
		
		
	}
}
