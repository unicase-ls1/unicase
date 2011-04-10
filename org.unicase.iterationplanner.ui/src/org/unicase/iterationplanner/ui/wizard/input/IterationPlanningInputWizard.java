/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.iterationplanner.ui.wizard.input;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.unicase.iterationplanner.ui.wizard.PlannerController;
import org.unicase.iterationplanner.ui.wizard.ProjectController;
import org.unicase.metamodel.Project;
import org.unicase.model.requirement.FunctionalRequirement;

/**
 * @author Hodaie
 */
public class IterationPlanningInputWizard extends Wizard {

	private ProjectController projectBridge;
	private PlannerController plannerBridge;
	private AbstractInputPage defineAssigneesPage;
	private AbstractInputPage defineTasksPage;
	//private AbstractInputPage defineReqsPage;
	private WizardPage definePlannerParametersPage;
	private boolean saveSession;

	/**
	 * Constructor.
	 */
	public IterationPlanningInputWizard(Project project) {
		setWindowTitle("Define Inputs to Iteration Planning Algorithm");
		this.projectBridge = new ProjectController(project);
		this.plannerBridge = new PlannerController(project);
		this.saveSession = true;
	
	}


	@Override
	public void addPages() {
		
		//defineReqsPage = new DefineRequirementsPage("defineRequirementsPage", projectBridge, plannerBridge);
		defineTasksPage = new DefineTasksPage("defineTasksPage", projectBridge, plannerBridge);
		defineAssigneesPage = new DefineAssigneesPage("defineAssigneesPage", projectBridge, plannerBridge);
		definePlannerParametersPage = new DefinePlannerParametersPage("definePlannerParametersPage", projectBridge, plannerBridge);
		//addPage(defineReqsPage);
		addPage(defineTasksPage);
		addPage(defineAssigneesPage);
		addPage(definePlannerParametersPage);
	}

	@Override
	public boolean performFinish() {
		plannerBridge.startPlanner();
		return true;
	}


	@Override
	public boolean canFinish() {
		boolean result = false;
		if(getContainer().getCurrentPage().equals(getDefineAssigneesPage())){
			result = getDefineAssigneesPage().isPageComplete();
		}else if(getContainer().getCurrentPage().equals(getDefinePlannerParametersPage())){
			result = getDefinePlannerParametersPage().isPageComplete();
		}
		
		return result;
	}


	public void setSaveSession(boolean saveSession) {
		this.saveSession = saveSession;
	}


	public boolean isSaveSession() {
		return saveSession;
	}
	
	
	public AbstractInputPage getDefineAssigneesPage() {
		return defineAssigneesPage;
	}


	public AbstractInputPage getDefineTasksPage() {
		return defineTasksPage;
	}


//	public AbstractInputPage getDefineReqsPage() {
//		return defineReqsPage;
//	}


	public WizardPage getDefinePlannerParametersPage() {
		return definePlannerParametersPage;
	}


	public void loadPreviousSession() {
		//check if saved active project is still in workspace. if yes go further.
		
		// all the methods should check if values being set as target, 
		// are still valid with this project state
		// 
		// first check if the target ME is still in project
		// if yes, take its newest value (but how? using ME.id?)
		
		//get requirements 
		//reqsPage.setTargetReqs()
		
		//get tasks 
		//tasksPage.setTargetTasks()
		
		//get users availabilities 
		//usersPage.setTargetUsers()
		
		//get parameters 
		//paramsPage.setTargetParams()
		
	}


	public void saveRequirements(List<FunctionalRequirement> list) {
		if(isSaveSession()){
			//saveSession
		}
	}

}
