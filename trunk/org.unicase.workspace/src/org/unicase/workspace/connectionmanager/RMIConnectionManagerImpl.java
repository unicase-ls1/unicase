package org.unicase.workspace.connectionmanager;

import java.util.List;

import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.ChangePackage;
import org.unicase.esmodel.changemanagment.HistoryInfo;
import org.unicase.esmodel.changemanagment.LogMessage;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.Project;
import org.unicase.model.ProjectId;
import org.unicase.workspace.ServerInfo;

public class RMIConnectionManagerImpl implements ConnectionManager {

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws ConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProjectInfo> getProjectList(SessionId sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionId logIn(String username, String password,
			ServerInfo severInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId, VersionSpec versionSpec) {
		// TODO Auto-generated method stub
		return null;
	}

}
