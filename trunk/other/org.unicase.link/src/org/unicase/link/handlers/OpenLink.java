package org.unicase.link.handlers;

import java.util.Date;
import java.util.Set;

import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.ProjectUrlFragment;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ProjectUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Help class for resolving project or
 * model element in a workspace
 * 
 * @author svetlana
 *
 */
public class OpenLink {
	private static final String EXTERNAL_URL = "EXTERNAL_URL"; 

	
	public static ProjectSpace getLatestProjectSpace(ProjectUrlFragment projectUrl){
		
		ProjectSpace currProjectSpace = null;
		try {
			Set<ProjectSpace> set = WorkspaceManager.getInstance()
				.getCurrentWorkspace().resolve(projectUrl);
						
			if (!set.isEmpty()) {
				
				// fetch latest project
				currProjectSpace = set.iterator().next();
				
				for (ProjectSpace space : set) {
					Date lastUpdated = space.getLastUpdated();
					Date currProjectDate = currProjectSpace.getLastUpdated();
					
					if (lastUpdated.after(currProjectDate)) {
						currProjectSpace = space;
					}
				}
			}	
				

	}
		catch (ProjectUrlResolutionException e) {
			//WorkspaceUtil.logException(e.getMessage(), e);
			return null;
		} 
		
return currProjectSpace;
}
	
	public static void openME(ProjectSpace projectSpace, ModelElementUrlFragment meUrl){
		
		
		final ModelElement me = projectSpace.getProject().getModelElement(meUrl.getModelElementId());
		if(me != null){
				// when the according element is found, open it 
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						ActionHelper.openModelElement(me, EXTERNAL_URL);
					}});; 
			}
		}
	
	public static void openURL(ModelElementUrl url){
		ProjectSpace projectSpace = null; 
						
		projectSpace = OpenLink.getLatestProjectSpace(
				url.getProjectUrlFragment());
		
		if(projectSpace != null){
			OpenLink.openME(projectSpace, 
					url.getModelElementUrlFragment());
		}
		else{
			EMFStoreConnection esConnection = new EMFStoreConnection();
			esConnection.checkout(url);
			projectSpace = OpenLink.getLatestProjectSpace(
					url.getProjectUrlFragment());
			if(projectSpace != null){
				OpenLink.openME(projectSpace, url.getModelElementUrlFragment());
			}
		}
	

	}
	
	
	
}
