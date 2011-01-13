package org.unicase.changetracking.ui.buildRelease;

import org.eclipse.jface.wizard.Wizard;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class BuildReleaseWizard extends Wizard{

	private ChangeTrackingRelease release;
	public BuildReleaseWizard(ChangeTrackingRelease release) {
		this.release = release;
	}
	
	@Override
	public void addPages() {
		ReviewReleasePage buildReleasePage = new ReviewReleasePage("Build Release", "Build Release", null, release);
		addPage(buildReleasePage);
	}
	@Override
	public boolean performFinish() {
		return true;
	}

}
