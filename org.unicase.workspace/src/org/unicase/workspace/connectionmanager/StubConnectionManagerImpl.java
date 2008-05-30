package org.unicase.workspace.connectionmanager;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.EmfStoreStub;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.HeadVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.HistoryInfo;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentFactoryImpl;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.model.Project;
import org.unicase.workspace.ServerInfo;

public class StubConnectionManagerImpl implements ConnectionManager {

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws ConnectionException {
		throw new UnsupportedOperationException();
	}

	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws ConnectionException {
		throw new UnsupportedOperationException();
	}

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target) throws ConnectionException {
		throw new UnsupportedOperationException();
	}

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws ConnectionException {
		return EmfStoreStub.createDummyProject();
	}

	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws ConnectionException {
		List<ProjectInfo> ret = new ArrayList<ProjectInfo>();
		
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		
		HeadVersionSpec headVersionSpec = ChangemanagmentFactoryImpl.eINSTANCE.createHeadVersionSpec();
		
		ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("TestProject");
		projectInfo.setDescription("A test Project");
		projectInfo.setProjectId(projectId);
		projectInfo.setVersion(resolveVersionSpec(sessionId, headVersionSpec));
		
		ret.add(projectInfo);
		return ret;
	}

	public SessionId logIn(String username, String password,
			ServerInfo severInfo) throws ConnectionException {
		return EsmodelFactory.eINSTANCE.createSessionId();
	}

	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId, VersionSpec versionSpec) {
		PrimaryVersionSpec primaryVersionSpec = ChangemanagmentFactory.eINSTANCE.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(1);
		return primaryVersionSpec;
	}
	
	

}
