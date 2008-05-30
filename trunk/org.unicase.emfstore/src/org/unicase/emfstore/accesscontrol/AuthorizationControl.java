package org.unicase.emfstore.accesscontrol;

import java.util.Set;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.model.ModelElement;

public interface AuthorizationControl {
	
	public void checkSession(SessionId sessionId);
	
	public Role getRole(SessionId sessionId);
	
	public void checkReadAccess(SessionId sessionId, ProjectId projectId);
	
	public void checkWriteAccess(SessionId sessionId, ProjectId projectId, Set<ModelElement> modelElements);
	
	
	

}
