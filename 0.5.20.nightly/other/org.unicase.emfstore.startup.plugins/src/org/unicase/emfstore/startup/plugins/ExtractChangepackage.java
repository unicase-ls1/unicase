package org.unicase.emfstore.startup.plugins;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.startup.StartupListener;
import org.unicase.metamodel.Project;

public class ExtractChangepackage implements StartupListener {

	public void startedUp(List<ProjectHistory> projects) {
		if(true){
			return;
		}
		for(ProjectHistory projectHistory : projects) {
			System.out.println("Checking project: "+projectHistory.getProjectName());
			for(Version version : projectHistory.getVersions()){
				if(version.getProjectState()!=null) {
					try {
						checkProjectState(version,projectHistory);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(version.getChanges()!=null) {
					try {
						checkChangepackage(version,projectHistory);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void checkChangepackage(Version version, ProjectHistory projectHistory) throws Exception {
		Resource changePackageResource = version.getChanges().eResource();
		if(!version.eResource().equals(changePackageResource)) {
			return;
		}
		String cpPath = getProjectFolder(projectHistory.getProjectId())+getChangePackageFile(version.getPrimarySpec().getIdentifier());
		Resource resource = version.eResource().getResourceSet().createResource(URI.createFileURI(cpPath));
		ChangePackage changes = version.getChanges();
		version.setChanges(null);
		version.eResource().save(null);
		resource.getContents().add(changes);
		resource.save(null);
		version.setChanges(changes);
		version.eResource().save(null);
	}

	private void checkProjectState(Version version, ProjectHistory projectHistory) throws Exception {
		Resource projectStateResource = version.getProjectState().eResource();
		if(!version.eResource().equals(projectStateResource)) {
			return;
		}
		String cpPath = getProjectFolder(projectHistory.getProjectId())+getProjectFile(version.getPrimarySpec().getIdentifier());
		Resource resource = version.eResource().getResourceSet().createResource(URI.createFileURI(cpPath));
		Project projectState = version.getProjectState();
		version.setProjectState(null);
		version.eResource().save(null);
		resource.getContents().add(projectState);
		resource.save(null);
		version.setProjectState(projectState);
		version.eResource().save(null);
	}
	
	public String getProjectFolder(ProjectId projectId) {
		return ServerConfiguration.getServerHome() + ServerConfiguration.FILE_PREFIX_PROJECTFOLDER + projectId.getId()
			+ File.separatorChar;
	}

	private String getProjectFile(int versionNumber) {
		return ServerConfiguration.FILE_PREFIX_PROJECTSTATE + versionNumber
			+ ServerConfiguration.FILE_EXTENSION_PROJECTSTATE;
	}

	private String getChangePackageFile(int versionNumber) {
		return ServerConfiguration.FILE_PREFIX_CHANGEPACKAGE + versionNumber
			+ ServerConfiguration.FILE_EXTENSION_CHANGEPACKAGE;
	}
}
