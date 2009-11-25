package org.unicase.link.util;

import java.util.Date;
import java.util.Set;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.link.handlers.EMFStoreConnection;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ProjectUrlResolutionException;

public class ProjectProxy {
	
	private static ProjectProxy projectProxy = null;
	private EMFStoreConnection emfStoreConnection;
	
	public static ProjectProxy getInstance() {
		
		if (projectProxy == null) {
			projectProxy = new ProjectProxy();
		}
		
		return projectProxy;
	}
	
	private ProjectProxy() {
		emfStoreConnection = new EMFStoreConnection();
	}

	/**
	 * Returns the latest project with the given URL.
	 * 
	 * @param projectUrl The URL of the project, for which to find the 
	 * @return The ProjectSpace in which the project with the given URL
	 * 		   is embedded. 
	 */
	public static ProjectSpace getLatestProjectSpace(ModelElementUrl url) {
				
		ProjectSpace currProjectSpace = null;
				
		try {
			Set<ProjectSpace> set = WorkspaceManager.getInstance()
				.getCurrentWorkspace().resolve(url.getProjectUrlFragment());
								
			if (!set.isEmpty()) {
				currProjectSpace = set.iterator().next();
						
				for (ProjectSpace space : set) {
					Date lastUpdated = space.getLastUpdated();
					Date currProjectDate = currProjectSpace.getLastUpdated();
							
					if (lastUpdated.after(currProjectDate)) {
						currProjectSpace = space;
					}
				}
			}	
		} catch (ProjectUrlResolutionException e) {
			currProjectSpace = getInstance().emfStoreConnection
				.checkoutProjectFromServer(url);					
		} 
				
		return currProjectSpace;
	}
}
