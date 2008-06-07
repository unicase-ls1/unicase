package org.unicase.emfstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.HistoryInfo;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.Version;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;
import org.unicase.emfstore.exceptions.DataBaseException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidProjectIdException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.model.Project;

public class EmfStoreImpl implements EmfStore {

	private ServerSpace serverSpace;
	
	private final static Logger logger = Logger.getLogger(EmfStoreImpl.class);
	
	private EmfStoreStub stub;
	
	private AuthorizationControl authorizationControl;
	
	public EmfStoreImpl(ServerSpace serverSpace, AuthorizationControl authorizationControl, Properties properties) {
				this.stub = new EmfStoreStub();
				this.serverSpace = serverSpace;
				this.authorizationControl=authorizationControl;
			}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException {
		//authorizationControl.checkWriteAccess(sessionId, projectId, modelElements);
		List<Version> versions = getProject(projectId).getVersions();
		if(versions.size()!=baseVersionSpec.getIdentifier()) {
			throw new InvalidVersionSpecException("");
		}
		
		PrimaryVersionSpec finalVersion = ChangemanagmentFactory.eINSTANCE.createPrimaryVersionSpec();
		finalVersion.setIdentifier(baseVersionSpec.getIdentifier()+1);
		
		Version version = ChangemanagmentFactory.eINSTANCE.createVersion();
		version.setChanges(changePackage);
		version.setLogMessage(logMessage);
		version.setPrimarySpec(finalVersion);
		version.setNextVersion(versions.get(0));
		versions.get(0).setPreviousVersion(version);
		version.setPreviousVersion(versions.get(versions.size()));
		versions.get(versions.size()).setNextVersion(version);
		
		versions.add(version);
		save();
		
		return finalVersion;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		//TODO: authorization
		List<ChangePackage> result = new ArrayList<ChangePackage>();
		boolean appropriateVersion = false;
		for(Version version : getProject(projectId).getVersions()) {
			if(version.getPrimarySpec().equals(source)) {
				appropriateVersion = true;
			} else if(version.getPrimarySpec().equals(target)) {
				appropriateVersion = false;
				break;
			}
			if(appropriateVersion) {
				result.add(version.getChanges());
			}
		}
		if(!appropriateVersion) {
			throw new InvalidVersionSpecException("");
		}
		return result;
	}

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		throw new UnsupportedOperationException();
	}

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		return stub.getProject(sessionId, projectId, versionSpec);
	}

	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		return stub.getProjectList(sessionId);
	}

	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		return stub.resolveVersionSpec(sessionId, projectId, versionSpec);
	}

	public Properties getServerSpace() {
		// TODO Auto-generated method stub
		return null;
	}
		
	private ProjectHistory getProject(ProjectId projectId) throws EmfStoreException {
		for(ProjectHistory project : serverSpace.getProjects()) {
			if(project.getProjectId().equals(projectId)) {
				return project;
			}
		}
		throw new InvalidProjectIdException("Project with the id:"+((projectId==null)?"null":projectId)+" doesn't exist.");
	}
	
	private void save() throws EmfStoreException {
		try {
			serverSpace.save();
		} catch (IOException e) {
			throw new DataBaseException(DataBaseException.NOSAVE,e);
		} catch (NullPointerException e) {
			throw new DataBaseException(DataBaseException.NOSAVE,e);
		}
	}
}

