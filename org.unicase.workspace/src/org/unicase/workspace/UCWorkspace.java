package org.unicase.workspace;

import java.net.URI;

import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.model.Project;
import org.unicase.model.ProjectId;

public class UCWorkspace {
	
	private PrimaryVersionSpec baseVersion;
	private ProjectId projectId;
	private UserSession userSession;
	
	private URI workspaceURI;
	
	private Resource resource;
	
	public void update(PrimaryVersionSpec primaryVersionSpec) {
		
	}
	
	public void commit() {
		
	}
	
	public void revert() {
		
	}
	
	public Project getProject() {
		return null;
	}
	
	
	
}
