package org.unicase.emfstore.accesscontrol;

import java.util.Set;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.model.ModelElement;

public interface AuthorizationControl {
	
	public void checkSession(SessionId sessionId) throws AccessControlException;
	
	public void checkProjectAdminAccess(SessionId sessionId, ProjectId projectId) throws AccessControlException;
	
	public void checkServerAdminAccess(SessionId sessionId) throws AccessControlException;
	
	public void checkReadAccess(SessionId sessionId, ProjectId projectId, Set<ModelElement> modelElements) throws AccessControlException;
	
	public void checkWriteAccess(SessionId sessionId, ProjectId projectId, Set<ModelElement> modelElements) throws AccessControlException;
	
	
	

}
