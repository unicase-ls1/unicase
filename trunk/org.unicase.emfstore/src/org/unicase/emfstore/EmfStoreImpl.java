package org.unicase.emfstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.HeadVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.HistoryInfo;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.Version;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;
import org.unicase.emfstore.exceptions.DataBaseException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidProjectIdException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;

public class EmfStoreImpl implements EmfStore {

	private ServerSpace serverSpace;

	private final static Logger logger = Logger.getLogger(EmfStoreImpl.class);

	private EmfStoreStub stub;

	private AuthorizationControl authorizationControl;

	public EmfStoreImpl(ServerSpace serverSpace,
			AuthorizationControl authorizationControl, Properties properties) {
		this.stub = new EmfStoreStub();
		this.serverSpace = serverSpace;
		this.authorizationControl = authorizationControl;
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException {
		// authorizationControl.checkWriteAccess(sessionId, projectId,
		// modelElements);
		// TODO: authorization
		List<Version> versions = getProject(projectId).getVersions();
		if (versions.size() - 1 != baseVersionSpec.getIdentifier()) {
			throw new InvalidVersionSpecException("");
		}

		PrimaryVersionSpec finalVersion = ChangemanagmentFactory.eINSTANCE
				.createPrimaryVersionSpec();
		finalVersion.setIdentifier(baseVersionSpec.getIdentifier() + 1);

		Version version = ChangemanagmentFactory.eINSTANCE.createVersion();
		version.setChanges(changePackage);
		version.setLogMessage(logMessage);
		version.setPrimarySpec(finalVersion);
		version.setNextVersion(null);
		version.setPreviousVersion(versions.get(versions.size() - 1));
		versions.get(versions.size() - 1).setNextVersion(version);

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
		// TODO: authorization

		List<ChangePackage> result = new ArrayList<ChangePackage>();
		for (Version version : getVersions(projectId, resolveVersionSpec(
				projectId, source), resolveVersionSpec(projectId, target))) {
			result.add(version.getChanges());
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		// TODO: authorization
		List<HistoryInfo> result = new ArrayList<HistoryInfo>();
		for (Version version : getVersions(projectId, resolveVersionSpec(
				projectId, source), resolveVersionSpec(projectId, target))) {
			HistoryInfo history = ChangemanagmentFactory.eINSTANCE
					.createHistoryInfo();
			history.setLogMessage(version.getLogMessage());
			history.setPrimerySpec(version.getPrimarySpec());
			result.add(history);
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		// TODO: authorization
		return getVersion(projectId, resolveVersionSpec(projectId, versionSpec))
				.getProjectState();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		// TODO: authorization
		List<ProjectInfo> result = new ArrayList<ProjectInfo>();
		for (ProjectHistory project : serverSpace.getProjects()) {
			result.add(getProjectInfo(project));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException {
		// TODO: authorization
		return resolveVersionSpec(projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionId, String name,
			String description, LogMessage logMessage) throws EmfStoreException {
		// TODO: authorization
		ProjectHistory projectHistory = EsmodelFactory.eINSTANCE
				.createProjectHistory();
		projectHistory.setProjectName(name);
		projectHistory.setProjectDescription(description);
		projectHistory.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());

		Version firstVersion = ChangemanagmentFactory.eINSTANCE.createVersion();
		firstVersion.setLogMessage(logMessage);

		PrimaryVersionSpec primary = ChangemanagmentFactory.eINSTANCE
				.createPrimaryVersionSpec();
		primary.setIdentifier(0);
		firstVersion.setPrimarySpec(primary);

		firstVersion.setProjectState(ModelFactory.eINSTANCE.createProject());

		projectHistory.getVersions().add(firstVersion);
		serverSpace.getProjects().add(projectHistory);
		save();

		return getProjectInfo(projectHistory);
	}

	public Properties getServerSpace() {
		// TODO Auto-generated method stub
		return null;
	}

	private ProjectHistory getProject(ProjectId projectId)
			throws EmfStoreException {
		for (ProjectHistory project : serverSpace.getProjects()) {
			if (project.getProjectId().equals(projectId)) {
				return project;
			}
		}
		throw new InvalidProjectIdException("Project with the id:"
				+ ((projectId == null) ? "null" : projectId)
				+ " doesn't exist.");
	}

	private ProjectInfo getProjectInfo(ProjectHistory project) {
		ProjectInfo info = EsmodelFactory.eINSTANCE.createProjectInfo();
		info.setName(project.getProjectName());
		info.setDescription(project.getProjectDescription());
		info.setProjectId(project.getProjectId());
		info.setVersion(project.getVersions().get(0).getPreviousVersion()
				.getPrimarySpec());
		return info;
	}

	private PrimaryVersionSpec resolveVersionSpec(ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		ProjectHistory projectHistory = getProject(projectId);

		// PrimaryVersionSpec
		if (versionSpec instanceof PrimaryVersionSpec
				&& 0 <= ((PrimaryVersionSpec) versionSpec).getIdentifier()
				&& ((PrimaryVersionSpec) versionSpec).getIdentifier() <= projectHistory
						.getVersions().size()) {
			return ((PrimaryVersionSpec) versionSpec);

			// HeadVersionSpec
		} else if (versionSpec instanceof HeadVersionSpec) {
			PrimaryVersionSpec primary = ChangemanagmentFactory.eINSTANCE
					.createPrimaryVersionSpec();
			primary.setIdentifier(projectHistory.getVersions().size());
			return primary;

		} else {
			// TODO: Tag- and DateVersionSpec
			throw new InvalidVersionSpecException("");
		}
	}

	private Version getVersion(ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException {
		for (Version version : getProject(projectId).getVersions()) {
			if (version.getPreviousVersion().equals(versionSpec)) {
				return version;
			}
		}
		throw new InvalidVersionSpecException("");
	}

	private List<Version> getVersions(ProjectId projectId, VersionSpec source,
			VersionSpec target) throws EmfStoreException {
		List<Version> result = new ArrayList<Version>();
		boolean appropriateVersion = false;
		for (Version version : getProject(projectId).getVersions()) {
			if (version.getPrimarySpec().equals(source)) {
				appropriateVersion = true;
			} else if (version.getPrimarySpec().equals(target)) {
				appropriateVersion = false;
				break;
			}
			if (appropriateVersion) {
				result.add(version);
			}
		}
		if (!appropriateVersion) {
			throw new InvalidVersionSpecException("");
		}
		return result;
	}

	private void save() throws EmfStoreException {
		try {
			serverSpace.save();
		} catch (IOException e) {
			throw new DataBaseException(DataBaseException.NOSAVE, e);
		} catch (NullPointerException e) {
			throw new DataBaseException(DataBaseException.NOSAVE, e);
		}
	}

}
