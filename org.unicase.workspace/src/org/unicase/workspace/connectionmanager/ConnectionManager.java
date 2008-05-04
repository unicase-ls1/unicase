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
import org.unicase.workspace.ConnectionException;
import org.unicase.workspace.ServerInfo;

public interface ConnectionManager {

	public SessionId logIn(String username, String password,
			ServerInfo severInfo) throws ConnectionException;

	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws ConnectionException;

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws ConnectionException;

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws ConnectionException;

	public PrimaryVersionSpec resolveVersionSpec(VersionSpec versionSpec);
	
	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws ConnectionException;

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId) throws ConnectionException;
}
