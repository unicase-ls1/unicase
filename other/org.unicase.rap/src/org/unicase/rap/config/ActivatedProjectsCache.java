package org.unicase.rap.config;

import java.util.ArrayList;
import java.util.List;

import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

import config.ConfigEntity;

public class ActivatedProjectsCache {

	private static ActivatedProjectsCache instance;
	
	public static ActivatedProjectsCache getInstance() {
		
		if (instance == null) {
			instance = new ActivatedProjectsCache();
			instance.reloadActivatedProjects();
		}
		
		return instance;
	}

	private List<ProjectSpace> activatedProjects;
	private List<IActivatedProjectsListener> projectsListeners;
	
	/**
	 * Private constructor
	 */
	private ActivatedProjectsCache() {
		activatedProjects = new ArrayList<ProjectSpace>();
		projectsListeners = new ArrayList<IActivatedProjectsListener>();
	}
	
	public List<ProjectSpace> getProjects() {
		return activatedProjects;
	}
	
	public void reloadActivatedProjects() {
				
		ProjectKeysConfigEntity configEntity = new ProjectKeysConfigEntity();
		ConfigEntity entity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());
		activatedProjects.clear();
		
		if (entity != null) {
			
			ProjectKeysConfigEntity projectConfigEntity = new ProjectKeysConfigEntity(entity);
			
			for (ProjectSpace pSpace : WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces()) {

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
	
	public void addListener(IActivatedProjectsListener listener) {
		if (!projectsListeners.contains(listener)) {
			projectsListeners.add(listener);
		}
	}
	
	public void removeListener(IActivatedProjectsListener listener) {
		if (projectsListeners.contains(listener)) {
			projectsListeners.remove(listener);
		}
	}
}
