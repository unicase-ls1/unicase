/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult.ResultType;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.vcs.IVCSAdapter;

/**
 * Wizard for creating change packages.
 * 
 * @author jfinis
 * 
 */
public class CreateChangePackageWizard extends Wizard {

	private boolean canFinish;
	private ChooseWorkItemPage chooseWorkItemPage;
	private ChooseNameAndDescriptionPage chooseNamePage;
	private IVCSAdapter vcs;
	private IProject[] selectedProjects;
	private static final ImageDescriptor PAGE_IMAGE = Activator.getImageDescriptor("icons/wizard/create_change_package_wiz.png");

	/**
	 * Default constructor.
	 * 
	 * @param vcs VCS adapter
	 * @param selectedProject the selected project
	 */
	public CreateChangePackageWizard(IVCSAdapter vcs, IProject[] selectedProjects) {
		setFinishable(false);
		setWindowTitle("Create Change Package");
		this.vcs = vcs;
		this.selectedProjects = selectedProjects;
	}

	@Override
	public void addPages() {
		chooseWorkItemPage = new ChooseWorkItemPage("Choose Work Item", "Choose Work Item", PAGE_IMAGE, vcs, selectedProjects);
		addPage(chooseWorkItemPage);

		chooseNamePage = new ChooseNameAndDescriptionPage("Choose Work Item", "Set name and description for the change package", PAGE_IMAGE);
		addPage(chooseNamePage);
	}

	@Override
	public boolean performFinish() {
		//If a <<create new X>> entry was chosen, perform the placement of this entry
		chooseWorkItemPage.performWorkItemPlacement();
		
		//Create the package and open it if everything went fine
		if (UIUtil.runCommand(vcs.createChangePackage(selectedProjects, chooseWorkItemPage.getSelectedWorkItem(), chooseWorkItemPage.getSelectedRepository(), chooseNamePage.getChosenName(), chooseNamePage.getChosenShortDescription(), chooseNamePage.getChosenLongDescription())).getResultType() == ResultType.SUCCESS) {
			UIUtil.openUnicaseAndModelElement(chooseWorkItemPage.getSelectedWorkItem());
		}
		return true;

	}

	@Override
	public boolean canFinish() {
		return canFinish;
	}

	/**
	 * Sets whether this dialog is able to be finished, i.e. if the Finish
	 * button is able to be pressed.
	 * 
	 * @param finishable whether this dialog is finishable
	 */
	void setFinishable(boolean finishable) {
		canFinish = finishable;
		if (getContainer() != null && getContainer().getCurrentPage() != null) {
			getContainer().updateButtons();
		}
	}

}
