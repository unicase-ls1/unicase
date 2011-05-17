/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.releases;

import org.eclipse.jface.dialogs.IPageChangeProvider;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.Wizard;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.RepositoryLocation;

public class BuildReleaseWizard extends Wizard{

	private ChangeTrackingRelease release;
	private ReleaseCheckReport report;
	private boolean canFinish;
	private BuildSettingsPage buildSettingsPage;
	private RepositoryLocation repoLocation;
	private VCSAdapter vcs;
	public BuildReleaseWizard(ChangeTrackingRelease release, ReleaseCheckReport report, VCSAdapter vcs) {
		this.release = release;
		this.report = report;
		canFinish = false;
		this.repoLocation = report.getRepoLocation();
		this.vcs = vcs;
	}
	
	@Override
	public void addPages() {
		ReviewReleasePage reviewReleasePage = new ReviewReleasePage("Build Release", "Review Release", null, release, report);
		addPage(reviewReleasePage);
		buildSettingsPage = new BuildSettingsPage("Build Release", "Review Release", null, release, report, vcs, repoLocation);
		addPage(buildSettingsPage);
		
	}
	
	@Override
	public void setContainer(IWizardContainer wizardContainer) {
		super.setContainer(wizardContainer);
		final IWizardContainer container = getContainer();
		if(container instanceof IPageChangeProvider){
			((IPageChangeProvider) container).addPageChangedListener(new IPageChangedListener() {

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
			
			BuildReleaseCommand command = vcs.buildRelease(release, buildSettingsPage.getTagName(), report);
			new BuildReleaseOperation(command,false).run();
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
