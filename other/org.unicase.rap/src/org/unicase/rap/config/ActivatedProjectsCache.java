/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.config;

import java.util.List;
import java.util.ArrayList;

import org.unicase.workspace.Workspace;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

import config.ConfigEntity;

/**
 * Activated project cache.
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public final class ActivatedProjectsCache {

	private static ActivatedProjectsCache instance;
	
	private List<ProjectSpace> activatedProjects;
	
	private List<IActivatedProjectsListener> projectsListeners;
	
	/**
	 * 
	 * @return instance of <code>AcitavatedProjectCahce</code>
	 */
	public static ActivatedProjectsCache getInstance() {
		
		if (instance == null) {
			instance = new ActivatedProjectsCache();
			instance.reloadActivatedProjects();
		}
		return instance;
	}
	
	/**
	 * Private constructor.
	 */
	private ActivatedProjectsCache() {
		activatedProjects = new ArrayList<ProjectSpace>();
		projectsListeners = new ArrayList<IActivatedProjectsListener>();
	}
	
	/**
	 * 
	 * @return activated projects.
	 */
	public List<ProjectSpace> getProjects() {
		return activatedProjects;
	}
	
	/**
	 * Reloads activated projects.
	 */
	public void reloadActivatedProjects() {
				
		ProjectKeysConfigEntity configEntity = new ProjectKeysConfigEntity();
		ConfigEntity entity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());
		activatedProjects.clear();
		
		if (entity != null) {
			
			ProjectKeysConfigEntity projectConfigEntity = new ProjectKeysConfigEntity(entity);
			Workspace currentWorskpace = WorkspaceManager.getInstance().getCurrentWorkspace();
			
			for (ProjectSpace pSpace : currentWorskpace.getProjectSpaces()) {

				if (projectConfigEntity.getProjectActivated(pSpace.getProjectName())) {
					activatedProjects.add(pSpace);
				}
			}
		}
		
		notifyListeners();
	}
	
	private void notifyListeners() {
		for (IActivatedProjectsListener listener : projectsListeners) {
			listener.activatedProjectsChangd(activatedProjects);
		}
	}
	
	/**
	 * 
	 * @param listener Project listener.
	 */
	public void addListener(IActivatedProjectsListener listener) {
		if (!projectsListeners.contains(listener)) {
			projectsListeners.add(listener);
		}
	}
	
	/**
	 * 
	 * @param listener Project listener.
	 */
	public void removeListener(IActivatedProjectsListener listener) {
		if (projectsListeners.contains(listener)) {
			projectsListeners.remove(listener);
		}
	}
	
}

