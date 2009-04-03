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
 * This is the super class for all subinterfaces of emfstore. Main interfaces, such as {@link EmfStoreImpl}, check and
 * than delegates method calls to these subinterfaces, where the actual functionality is implemented. Subinterfaces
 * shouldn't be accessed without the corresponding main interface, because they rely on the sanity checks of the main
 * interfaces. The idea behind subinterfaces is to divide an emfstore interface into logical pieces and to avoid huge
 * classes.
 * 
 * @author wesendon
 */
public abstract class AbstractSubEmfstoreInterface {

	private final AbstractEmfstoreInterface parentInterface;

	/**
	 * Default constructor.
	 * 
	 * @param parentInterface parentInterface
	 * @throws FatalEmfStoreException if serverspace is null
	 */
	public AbstractSubEmfstoreInterface(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		if (parentInterface == null) {
			throw new FatalEmfStoreException();
		}
		this.parentInterface = parentInterface;
	}

	/**
	 * Saves an eObject.
	 * 
	 * @param object the object
	 * @throws FatalEmfStoreException in case of failure
	 */
	protected void save(EObject object) throws FatalEmfStoreException {
		try {
			object.eResource().save(null);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (Exception e) {
			throw new FatalEmfStoreException(StorageException.NOSAVE, e);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	/**
	 * Returns the serverspace. Please always use a monitor ({@link #getMonitor()}) when operating on the serverspace.
	 * 
	 * @return serverspace
	 */
	protected ServerSpace getServerSpace() {
		return parentInterface.getServerSpace();
	}

	/**
	 * Return a monitor object which should be used when operating on the serverspace.
	 * 
	 * @return monitor object
	 */
	protected Object getMonitor() {
		return parentInterface.getMonitor();
	}

	/**
	 * This method gets a subinterface from the parent interface. Can be used if you need some functionality from
	 * another subinterface.
	 * 
	 * @param <T> subinterface type
	 * @param clazz class of subinterface
	 * @return subinterface
	 */
	protected <T> T getSubInterface(Class<T> clazz) {
		return parentInterface.getSubInterface(clazz);
	}

	/**
	 * Returns the corresponding project.
	 * 
	 * @param projectId project id
	 * @return a project or throws exception
	 * @throws EmfStoreException if project couldn't be found
	 */
	protected ProjectHistory getProject(ProjectId projectId) throws EmfStoreException {
		for (ProjectHistory project : getServerSpace().getProjects()) {
			if (project.getProjectId().equals(projectId)) {
				return project;
			}
		}
		throw new InvalidProjectIdException("Project with the id:" + ((projectId == null) ? "null" : projectId)
			+ " doesn't exist.");
	}

	/**
	 * Returns the specified version of a project.
	 * 
	 * @param projectId project id
	 * @param versionSpec versionSpec
	 * @return the version
	 * @throws EmfStoreException if version couldn't be found
	 */
	protected Version getVersion(ProjectId projectId, PrimaryVersionSpec versionSpec) throws EmfStoreException {
		EList<Version> versions = getProject(projectId).getVersions();
		if (versionSpec.getIdentifier() < 0 || versionSpec.getIdentifier() > versions.size() - 1) {
			throw new InvalidVersionSpecException();
		}
		return versions.get(versionSpec.getIdentifier());
	}

	/**
	 * Returns a list of versions starting from source and ending with target. This method returns the version always in
	 * an ascanding order. So if you need it ordered differently you have to reverse the list.
	 * 
	 * @param projectId project id
	 * @param source source
	 * @param target target
	 * @return list of versions
	 * @throws EmfStoreException if source or target are out of range or any other problem occurs
	 */
	protected List<Version> getVersions(ProjectId projectId, PrimaryVersionSpec source, PrimaryVersionSpec target)
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
