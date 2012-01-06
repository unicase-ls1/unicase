/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.config;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.UrmlProjectSettings;
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.StakeholderUtil;
import org.unicase.ui.urml.stakeholders.filtering.NavigatorFilterManager;
import org.unicase.ui.urml.stakeholders.filtering.NavigatorViewerFilter;
import org.unicase.ui.urml.stakeholders.navigation.ReviewCountPublisher;
import org.unicase.workspace.ProjectSpace;

/**
 * The settings manager related to the current active project.
 * Configuration settings such as active stakeholder role settings and
 * active development phase settings are initiated for global use.
 * @author kterzieva
 */
public final class UrmlSettingsManager {

	/**
	 * The singleton instance.
	 */
	public static final UrmlSettingsManager INSTANCE = new UrmlSettingsManager();

	
	private StakeholderRole activeRole;
	private UrmlProjectSettings projectSettings;
	private ProjectSpace activeProject;
	private IDialogSettings dialogSettings;
	private NavigatorFilterManager filterManager = new NavigatorFilterManager();
	private ReviewCountPublisher reviewCountPublisher = new ReviewCountPublisher();

	/**
	 * Initiates the project settings. 
	 * @param activeProject the project which is current active
	 */
	public void initFromProject(ProjectSpace activeProject) {
		this.activeProject = activeProject;
		reviewCountPublisher.init(activeProject.getProject());
		StakeholderUtil.resolveAll(activeProject.getProject());
		EList<UrmlProjectSettings> settings = activeProject.getProject().getAllModelElementsbyClass(
			UrmlPackage.eINSTANCE.getUrmlProjectSettings(), new BasicEList<UrmlProjectSettings>());
		// settings.isEmpty() -> never empty - at least one UrmlProjectSettings
		if (settings.size() != 1) {
			projectSettings = settings.get(0);
		}
		Activator.getPhaseChangedPublisher().notifyObservers(projectSettings.getActivePhase());
		String curRoleName = dialogSettings.get(activeProject.getIdentifier());
		if (curRoleName != null) {
			EList<EObject> roles = activeProject.getProject().getAllModelElementsbyClass(
				UrmlPackage.eINSTANCE.getStakeholderRole(), new BasicEList<EObject>());
			for (EObject role : roles) {
				if (((StakeholderRole) role).getName().equals(curRoleName)) {
					setActiveRole((StakeholderRole) role);
					break;
				}
			}
		}
	}

	private UrmlSettingsManager() {
		dialogSettings = Activator.getDefault().getDialogSettings();
	}

	/**
	 * Gets the current active stakeholder role.
	 * @return activeRole the active role. 
	 */
	public StakeholderRole getActiveRole() {
		return activeRole;
	}

	/**
	 * Gets the current active development phase.
	 * @return the active phase or null for no active phase. 
	 */
	public Phase getActivePhase() {
		if (projectSettings == null) {
			return null;
		}
		return projectSettings.getActivePhase();
	}

	/**
	 * Sets the currently active role and informs all parts of the plug-in which 
	 * need to be updated once the active role changes. A null value sets "no role" as active.
	 * 
	 * @param activeRole a role to be active or null for no active role.
	 */
	public void setActiveRole(StakeholderRole activeRole) {
		this.activeRole = activeRole;
		if (activeRole == null) {
			dialogSettings.put(activeProject.getIdentifier(), (String) null);
			filterManager.removeFilters();
		} else {

			dialogSettings.put(activeProject.getIdentifier(), activeRole.getName());
			filterManager.applyFilter(new NavigatorViewerFilter(activeRole));
		}
		Activator.getRoleChangedPublisher().notifyObservers(activeRole);
	}
	
	/**
	 * Sets a specific phase as active for the current project.
	 * @param phase the development phase to be set as active
	 */
	public void setActivePhase(Phase phase) {
		projectSettings.setActivePhase(phase);
		Activator.getPhaseChangedPublisher().notifyObservers(projectSettings.getActivePhase());

	}

	/**
	 * Gets the review count publisher. 
	 * @return reviewCountPublisher the publisher which deals with changes related to the number of
	 * reviewed model elements.
	 */
	public ReviewCountPublisher getReviewCountPublisher() {
		return reviewCountPublisher;
	}

}
