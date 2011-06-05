package org.eclipse.emf.emfstore.client.model;

import java.util.List;

public interface WorkspaceData {

	List<ServerInfo> getServerInfos();
	
	List<Usersession> getUsersessions();
}
