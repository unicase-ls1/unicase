package org.unicase.changetracking.ui.createChangePackage;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult.Result;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.vcs.VCSAdapter;

public class CreateChangePackageWizard extends Wizard{

	private boolean canFinish;
	private ChooseWorkItemPage chooseWorkItemPage;
	private ChooseNameAndDescriptionPage chooseNamePage;
	private VCSAdapter vcs;
	private IProject selectedProject;
	private static final ImageDescriptor PAGE_IMAGE = Activator.getImageDescriptor("icons/wizard/create_change_package_wiz.png");

	public CreateChangePackageWizard(VCSAdapter vcs, IProject selectedProject) {
		setFinishable(false);
		setWindowTitle("Create Change Package");
		this.vcs = vcs;
		this.selectedProject = selectedProject;
	}
	
	
	@Override
	public void addPages() {
		chooseWorkItemPage = new ChooseWorkItemPage("Choose Work Item", "Choose Work Item", PAGE_IMAGE, vcs, selectedProject);
		addPage(chooseWorkItemPage);

		chooseNamePage = new ChooseNameAndDescriptionPage("Choose Work Item", "Set name and description for the change package", PAGE_IMAGE);
		addPage(chooseNamePage);
	}
	@Override
	public boolean performFinish() {
		if(UIUtil.runCommand(vcs.createChangePackage(
				selectedProject,
				chooseWorkItemPage.getSelectedWorkItem(),
				chooseWorkItemPage.getSelectedRepository(),
				chooseNamePage.getSelectedName(),
				chooseNamePage.getSelectedShortDescription(),
				chooseNamePage.getSelectedLongDescription()
			)).getResult() == Result.SUCCESS){
			
			UIUtil.openUnicaseAndModelElement(chooseWorkItemPage.getSelectedWorkItem());
			
		}
		return true;

	}
	
	@Override
	public boolean canFinish() {
		return canFinish;
	}
	
	void setFinishable(boolean finishable){
		canFinish = finishable;
		if(getContainer() != null && getContainer().getCurrentPage() != null){
			getContainer().updateButtons();
		}
	}
	
	
	
	

}
