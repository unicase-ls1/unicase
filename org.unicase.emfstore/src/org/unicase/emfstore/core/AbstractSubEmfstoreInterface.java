/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidProjectIdException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.emfstore.exceptions.StorageException;

/**
 * todo.
 * 
 * @author wesendon
 */
public abstract class AbstractSubEmfstoreInterface {

	private final ServerSpace serverSpace;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace serverspace
	 * @throws FatalEmfStoreException if serverspace is null
	 */
	public AbstractSubEmfstoreInterface(ServerSpace serverSpace) throws FatalEmfStoreException {
		if (serverSpace == null) {
			throw new FatalEmfStoreException();
		}
		this.serverSpace = serverSpace;
	}

	/**
	 * Saves an eObject.
	 * 
	 * @param object the object
	 * @throws FatalEmfStoreException in case of failure
	 */
	public void save(EObject object) throws FatalEmfStoreException {
		try {
			object.eResource().save(null);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (Exception e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	private ServerSpace getServerSpace() {
		return serverSpace;
	}

	public ProjectHistory getProject(ProjectId projectId) throws EmfStoreException {
		for (ProjectHistory project : getServerSpace().getProjects()) {
			if (project.getProjectId().equals(projectId)) {
				return project;
			}
		}
		throw new InvalidProjectIdException("Project with the id:" + ((projectId == null) ? "null" : projectId)
			+ " doesn't exist.");
	}

	public Version getVersion(ProjectId projectId, PrimaryVersionSpec versionSpec) throws EmfStoreException {
		EList<Version> versions = getProject(projectId).getVersions();
		if (versionSpec.getIdentifier() < 0 || versionSpec.getIdentifier() > versions.size() - 1) {
			throw new InvalidVersionSpecException();
		}
		return versions.get(versionSpec.getIdentifier());
	}

	public List<Version> getVersions(ProjectId projectId, PrimaryVersionSpec source, PrimaryVersionSpec target)
		throws EmfStoreException {
		if (source.compareTo(target) < 1) {
			EList<Version> versions = getProject(projectId).getVersions();
			if (source.getIdentifier() < 0 || source.getIdentifier() > versions.size() - 1
				|| target.getIdentifier() < 0 || target.getIdentifier() > versions.size() - 1) {
				throw new InvalidVersionSpecException();
			}
			List<Version> result = new ArrayList<Version>();
			Iterator<Version> iter = versions.listIterator(source.getIdentifier());
			int steps = target.getIdentifier() - source.getIdentifier();
			while (iter.hasNext() && steps-- >= 0) {
				result.add(iter.next());
			}
			return result;
		} else {
			return getVersions(projectId, target, source);
		}
	}
}
