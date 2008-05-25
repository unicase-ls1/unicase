package org.unicase.emfstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.storage.ResourceStorage;
import org.unicase.esmodel.EsmodelFactory;
import org.unicase.esmodel.ProjectId;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.ChangePackage;
import org.unicase.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.esmodel.changemanagment.HeadVersionSpec;
import org.unicase.esmodel.changemanagment.HistoryInfo;
import org.unicase.esmodel.changemanagment.LogMessage;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.esmodel.changemanagment.impl.ChangemanagmentFactoryImpl;
import org.unicase.model.CompositeSection;
import org.unicase.model.FunctionalRequirement;
import org.unicase.model.LeafSection;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.task.ActionItem;

public class EmfStoreImpl implements EmfStore {

	private final Resource resource;
	
	private final static Logger logger = Logger.getLogger(EmfStoreImpl.class);
	
	private EmfStoreStub stub;
	
	public EmfStoreImpl(ResourceStorage storage, Properties properties) {
		
		URI resourceUri = storage.init(properties);
		ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(resourceUri);
		
		stub = new EmfStoreStub();

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
