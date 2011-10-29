package org.unicase.ui.urml.stakeholders.config;

import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.UrmlProjectSettings;
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.StakeholderUtil;
import org.unicase.ui.urml.stakeholders.filtering.NavigatorFilterManager;
import org.unicase.ui.urml.stakeholders.filtering.NavigatorViewerFilter;
import org.unicase.workspace.ProjectSpace;

public class UrmlSettingsManager {

	public static final UrmlSettingsManager INSTANCE = new UrmlSettingsManager();
	private StakeholderRole activeRole;
	private UrmlProjectSettings projectSettings;
	private ProjectSpace activeProject;
	private IDialogSettings dialogSettings;
	private NavigatorFilterManager filterManager = new NavigatorFilterManager();

	public void initFromProject(ProjectSpace activeProject){
		
		this.activeProject = activeProject;
		
		StakeholderUtil.resolveAll(activeProject.getProject());
		
		EList<EObject> settings = activeProject.getProject().getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getUrmlProjectSettings(),
				new BasicEList<EObject>());
		if (settings.isEmpty()) {
			projectSettings = new DefaultPhases().createDefaultPhases(activeProject.getProject());
		} else {
			projectSettings = new DefaultPhases().createDefaultPhases(activeProject.getProject());
			//projectSettings = (UrmlProjectSettings) settings.get(0);
		}
		String curRoleName = dialogSettings.get(activeProject.getIdentifier());
		if(curRoleName != null){
			EList<EObject> roles = activeProject.getProject().getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getStakeholderRole(),
					new BasicEList<EObject>());
			for(EObject role: roles){
				if (((StakeholderRole) role).getName().equals(curRoleName)){
					setActiveRole((StakeholderRole) role);
					break;
				}
			}
		}
	}
	
	private UrmlSettingsManager(){
		 dialogSettings = Activator.getDefault().getDialogSettings();
	}
	
	public StakeholderRole getActiveRole() {
		return activeRole;
	}
	
	public Phase getActivePhase(){
		return projectSettings.getActivePhase();
	}
	
	/**
	 * Sets the currently active role and informs all
	 * parts of the plug-in which need to be updated
	 * once the active role changes.
	 * A null value sets "no role" as active
	 * @param activeRole a role to be active or null for no active role.
	 */
	public void setActiveRole(StakeholderRole activeRole) {
		this.activeRole = activeRole;
		if(activeRole == null){
			dialogSettings.put(activeProject.getIdentifier(), (String)null);
			filterManager.removeFilters();	
		} else {
			
			dialogSettings.put(activeProject.getIdentifier(), activeRole.getName());
			filterManager.applyFilter(new NavigatorViewerFilter(activeRole));	
		}
		Activator.getRoleChangedPublisher().notifyObservers(activeRole);
	}
	
	public void setActivePhase(Phase phase){
		projectSettings.setActivePhase(phase);
	}
	
}
