package org.unicase.changetracking.ui.createChangePackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.ui.Activator;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class CreateChangePackageWizard extends Wizard{

	private boolean canFinish;
	private Repository localRepository;
	private ChooseWorkItemPage chooseWorkItemPage;
	private ChooseNameAndDescriptionPage chooseNamePage;
	private static final ImageDescriptor PAGE_IMAGE = Activator.getImageDescriptor("icons/wizard/create_change_package_wiz.png");

	public CreateChangePackageWizard(Repository localRepository) {
		setFinishable(false);
		setWindowTitle("Create Change Package");
		this.localRepository = localRepository;
	}
	
	@Override
	public void addPages() {
		chooseWorkItemPage = new ChooseWorkItemPage("Choose Work Item", "Choose Work Item", PAGE_IMAGE, localRepository);
		addPage(chooseWorkItemPage);

		chooseNamePage = new ChooseNameAndDescriptionPage("Choose Work Item", "Set name and description for the change package", PAGE_IMAGE, localRepository);
		addPage(chooseNamePage);
	}
	@Override
	public boolean performFinish() {
		
		ProgressMonitorDialog progressMonitor = new ProgressMonitorDialog(PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getShell());
		progressMonitor.open();
		
		try {
			progressMonitor.run(true, true, new CreateChangePackageOperation(
				localRepository,
				chooseWorkItemPage.getSelectedWorkItem(),
				chooseWorkItemPage.getSelectedProject(),
				chooseWorkItemPage.getSelectedRepository(),
				chooseNamePage.getSelectedName(),
				chooseNamePage.getSelectedShortDescription(),
				chooseNamePage.getSelectedLongDescription(),
				chooseWorkItemPage.wantCreateWorkItem()
			));

		//Both exceptions are not possible.
		} catch (InvocationTargetException e) {
		} catch (InterruptedException e) {
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
