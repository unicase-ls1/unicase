package org.unicase.ui.urml.stakeholders.config;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.model.requirement.Actor;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.UrmlProjectSettings;
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.ChangeObserverAdapter;
import org.unicase.ui.urml.stakeholders.StakeholderUtil;
import org.unicase.ui.urml.stakeholders.filtering.NavigatorFilterManager;
import org.unicase.ui.urml.stakeholders.filtering.NavigatorViewerFilter;
import org.unicase.ui.urml.stakeholders.navigation.ReviewCountListener;
import org.unicase.ui.urml.stakeholders.navigation.ReviewCountPublisher;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.observers.OperationListener;

public class UrmlSettingsManager {

	public static final UrmlSettingsManager INSTANCE = new UrmlSettingsManager();
	private StakeholderRole activeRole;
	private UrmlProjectSettings projectSettings;
	private ProjectSpace activeProject;
	private IDialogSettings dialogSettings;
	private NavigatorFilterManager filterManager = new NavigatorFilterManager();
	private ReviewCountPublisher reviewCountpublisher = new ReviewCountPublisher();

	
	public void initFromProject(ProjectSpace activeProject){
		
		this.activeProject = activeProject;
		
		reviewCountpublisher.init(activeProject.getProject());
		

		
//		activeProject.getProject().addProjectChangeObserver(new ChangeObserverAdapter() {
//			
//			@Override
//			public void projectDeleted(Project project) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void notify(Notification notification, Project project,
//					EObject modelElement) {
//
//				if (notification.getEventType() == Notification.RESOLVE) {
//					return;
//				}
//				//if review check box was selected or deselected
//				if ((notification.getFeature().equals(ReviewCountListener.REVIEWED_FEATURE))) {
//					System.out.println("Reviewed changed!");
//				}
//			
//
//			}
//			
//			@Override
//			public void modelElementRemoved(Project project, EObject modelElement) {
//				if(modelElement instanceof UrmlModelElement){
//					System.out.println("---- Removed " + modelElement);
//				}
//			}
//			
//			@Override
//			public void modelElementAdded(Project project, EObject modelElement) {
//				if(modelElement instanceof UrmlModelElement){
//					System.out.println("++++ Added " + modelElement);
//				}
//			}
//		});
		
		StakeholderUtil.resolveAll(activeProject.getProject());
		
		EList<UrmlProjectSettings> settings = activeProject.getProject().getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getUrmlProjectSettings(),
				new BasicEList<UrmlProjectSettings>());
		if (settings.isEmpty()) {
			projectSettings = new DefaultPhases().createDefaultPhases(activeProject.getProject());
		} else {
			//projectSettings = new DefaultPhases().createDefaultPhases(activeProject.getProject());
			projectSettings = settings.get(0);
		}
		Activator.getPhaseChangedPublisher().notifyObservers(projectSettings.getActivePhase());
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
		if(projectSettings == null){
			return null;
		}
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
		Activator.getPhaseChangedPublisher().notifyObservers(projectSettings.getActivePhase());
		
		
	}

	public ReviewCountPublisher getReviewCountpublisher() {
		return reviewCountpublisher;
	}

}
