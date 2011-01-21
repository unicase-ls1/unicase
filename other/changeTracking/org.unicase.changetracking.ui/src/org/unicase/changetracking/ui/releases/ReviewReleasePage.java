package org.unicase.changetracking.ui.releases;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.ui.ReleaseTreeViewer;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.ui.navigator.ContentProvider;

public class ReviewReleasePage extends WizardPage implements IDialogHead{

	private ChangeTrackingRelease release;
	private ReleaseCheckReport report;

	protected ReviewReleasePage(String pageName, String title,
			ImageDescriptor titleImage, ChangeTrackingRelease release, ReleaseCheckReport report) {
		super(pageName, title, titleImage);
		this.release = release;
		this.report = report;
	}

	@Override
	public void createControl(Composite parent) {
		ReleaseOverviewWidget composite = new ReleaseOverviewWidget(parent, SWT.NONE, release, report);
		setControl(composite);
		configureDialogHead(report);
	}
	
	
	
	
	
	private void configureDialogHead(ReleaseCheckReport report) {
			
		if(report.hasErrors()){
			setMessage("You cannot build the release because errors where found.\nCheck the 'problems' tab for details.", IMessageProvider.ERROR);
		} else if(report.hasWarnings()){
			setMessage("It is discouraged to build the release with warnings.\nCheck the 'problems' tab for details.", IMessageProvider.WARNING);
		} else {
			setMessage("The release is ready to be built.\nNo errors or warnings were found.", IMessageProvider.INFORMATION);
		}
		
		
	}

	

	@Override
	public boolean canFlipToNextPage() {
		return !report.hasErrors();
	}
}
