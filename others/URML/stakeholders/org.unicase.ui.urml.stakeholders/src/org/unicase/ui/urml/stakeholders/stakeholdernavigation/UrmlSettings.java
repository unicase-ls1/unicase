package org.unicase.ui.urml.stakeholders.stakeholdernavigation;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.UrmlProjectSettings;
import org.unicase.ui.urml.stakeholders.phases.DefaultPhases;
import org.unicase.workspace.ProjectSpace;

public class UrmlSettings {

	public static final UrmlSettings INSTANCE = new UrmlSettings();
	private StakeholderRole activeRole;
	private UrmlProjectSettings projectSettings;
	private ProjectSpace activeProject;
	private IDialogSettings diaSettings;

	public void initFromProject(ProjectSpace activeProject2){
		this.activeProject = activeProject2;
		
		EList<EObject> settings = activeProject.getProject().getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getUrmlProjectSettings(),
				new BasicEList<EObject>());
		if (settings.isEmpty()) {
			projectSettings = new DefaultPhases().createDefaultPhases(activeProject.getProject());
		} else {
			projectSettings = (UrmlProjectSettings) settings.get(0);
		}
		String curRoleName = diaSettings.get(activeProject.getIdentifier());
		EList<EObject> roles = activeProject.getProject().getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getStakeholderRole(),
				new BasicEList<EObject>());
		for(EObject role: roles){
			if (((StakeholderRole) role).getName().equals(curRoleName)){
				activeRole = ((StakeholderRole) role);
				break;
			}
		}
	}
	
	private UrmlSettings(){
		 diaSettings = Activator.getDefault().getDialogSettings();
	}
	
	public StakeholderRole getActiveRole() {
		return activeRole;
	}
	
	public Phase getActivePhase(){
		return projectSettings.getActivePhase();
	}
	
	public void setActiveRole(StakeholderRole activeRole) {
		this.activeRole = activeRole;
		diaSettings.put(activeProject.getIdentifier(), activeRole.getName());
	}
	
	public void setActivePhase(Phase phase){
		projectSettings.setActivePhase(phase);
	}
	
}
