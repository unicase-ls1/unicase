package org.unicase.changetracking.ui.releases;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.dialogs.IPageChangeProvider;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.ReleaseUtil;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.createChangePackage.CreateChangePackageOperation;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class BuildReleaseWizard extends Wizard{

	private ChangeTrackingRelease release;
	private ReleaseCheckReport report;
	private Repository localRepo;
	private boolean canFinish;
	private BuildSettingsPage buildSettingsPage;
	public BuildReleaseWizard(ChangeTrackingRelease release, ReleaseCheckReport report, Repository localRepo) {
		this.release = release;
		this.report = report;
		this.localRepo = localRepo;
		canFinish = false;
		
	}
	
	@Override
	public void addPages() {
		ReviewReleasePage reviewReleasePage = new ReviewReleasePage("Build Release", "Review Release", null, release, report);
		addPage(reviewReleasePage);
		buildSettingsPage = new BuildSettingsPage("Build Release", "Review Release", null, release, report, localRepo);
		addPage(buildSettingsPage);
		
	}
	
	@Override
	public void setContainer(IWizardContainer wizardContainer) {
		super.setContainer(wizardContainer);
		final IWizardContainer container = getContainer();
		if(container instanceof IPageChangeProvider){
			((IPageChangeProvider) container).addPageChangedListener(new IPageChangedListener() {
				@Override
				public void pageChanged(PageChangedEvent event) {
					container.getShell().pack();
				}
			});
		}
	}

	
	@Override
	public boolean performFinish() {
		boolean wantBuild = false;
		if(report.hasWarnings()){
			if (UIUtil.openQuestion("Build with warnings?", "The release contains warnings. Do you really want to build it?")){
				
				wantBuild = true;
			}
		} else {
			wantBuild = true;
		}
		
		if(wantBuild){
			try {
				ProgressMonitorDialog progressMonitor = new ProgressMonitorDialog(PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell());
				BuildReleaseOperation op;
				progressMonitor.run(true, true, op = new BuildReleaseOperation(
						release, localRepo, report.getReleaseBase().getRef(), ReleaseUtil.buildMergeSetFromReport(report), buildSettingsPage.getTagName())
					);
				if(op.isSuccessful()){
					UIUtil.openInformation("Success!",
					"Release was built successfully.");
				}
					
						
			//Both exceptions are not possible.
			} catch (InvocationTargetException e) {
			} catch (InterruptedException e) {
			}	
		}
		return true;
	}

	@Override
	public boolean canFinish() {
		return canFinish && getContainer().getCurrentPage() == buildSettingsPage;
	}
	
	void setFinishable(boolean finishable){
		canFinish = finishable;
		if(getContainer() != null && getContainer().getCurrentPage() != null){
			getContainer().updateButtons();
		}
	}
	
	
}
