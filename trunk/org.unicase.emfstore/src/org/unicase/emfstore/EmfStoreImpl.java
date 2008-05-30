package org.unicase.emfstore;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.HistoryInfo;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.storage.ResourceStorage;
import org.unicase.model.Project;

public class EmfStoreImpl implements EmfStore {

	private final Resource resource;
	
	private ServerSpace serverSpace;
	
	private final static Logger logger = Logger.getLogger(EmfStoreImpl.class);
	
	private EmfStoreStub stub;
	
	public EmfStoreImpl(ResourceStorage storage, Properties properties) {
		
		URI resourceUri = storage.init(properties);
		ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(resourceUri);
		
		stub = new EmfStoreStub();
		
		EList<EObject> contents = resource.getContents();
		for (EObject content: contents) {
			if (content instanceof ServerSpace) {
				this.serverSpace=(ServerSpace)content;
				return;
			}
		}

		//if no serverspace can be loaded, create one
		logger.debug("Creating dummy server space...");
		serverSpace = EsmodelFactory.eINSTANCE.createServerSpace();
		stub.createDummyProjectHistories(serverSpace);
		resource.getContents().add(serverSpace);
		try {
			resource.save(null);
		} catch (IOException e) {
			// MK Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException {
		throw new UnsupportedOperationException();
	}

	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		throw new UnsupportedOperationException();
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

	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			VersionSpec versionSpec) throws EmfStoreException {
		return stub.resolveVersionSpec(sessionId, versionSpec);
	}
}
