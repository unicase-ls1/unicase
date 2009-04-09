/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.analyzer.exceptions.ItertorException;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.model.Project;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author liya
 * 
 */
public class ProjectVersionIterator implements Iterator<ProjectAnalysisData> {

	private final Usersession usersession;
	private final ProjectId projectId;
	private final int stepLength;
	private ConnectionManager connectionManager;
	private PrimaryVersionSpec nextSpec;
	private PrimaryVersionSpec sourceSpec;
	private final boolean isForward;
	private final PrimaryVersionSpec start;
	private final PrimaryVersionSpec end;
	private Project currentState;
	private final boolean returnProjectDataCopy;

	public ProjectVersionIterator(Usersession usersession, ProjectId projectId,
			int stepLength) throws ItertorException {
		this(usersession, projectId, stepLength, VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec(), VersioningFactory.eINSTANCE
				.createHeadVersionSpec(), true, true);
	}

	public ProjectVersionIterator(Usersession usersession, ProjectId projectId,
			int stepLength, VersionSpec start, VersionSpec end,
			boolean isForward, boolean returnProjectDataCopy)
			throws ItertorException {
		this.usersession = usersession;
		this.projectId = projectId;
		this.stepLength = stepLength;
		this.returnProjectDataCopy = returnProjectDataCopy;
		this.connectionManager = WorkspaceManager.getInstance()
				.getConnectionManager();
		this.isForward = isForward;
		try {
			this.start = this.connectionManager.resolveVersionSpec(usersession
					.getSessionId(), projectId, start);
			this.end = this.connectionManager.resolveVersionSpec(usersession
					.getSessionId(), projectId, end);
			this.currentState = this.connectionManager.getProject(usersession
					.getSessionId(), projectId, this.start);
		} catch (InvalidVersionSpecException e) {
			throw new ItertorException(
					"Could not resolve start or end version.", e);
		} catch (EmfStoreException e) {
			throw new ItertorException("Cannot connect to server.", e);
		}

		// sanity checks
		if (isForward) {
			if (this.start.compareTo(this.end) >= 0) {
				throw new ItertorException(
						"Start must be before end if foward is set to true!");
			}
		} else {
			if (this.start.compareTo(this.end) <= 0) {
				throw new ItertorException(
						"Start must be after end if foward is set to false!");
			}
		}

		this.nextSpec = EsModelUtil.clone(this.start);
		this.sourceSpec = EsModelUtil.clone(this.start);
		updateSpecifier(sourceSpec, stepLength, !isForward);
		if (isForward) {
			if (sourceSpec.getIdentifier()<0) {
				sourceSpec.setIdentifier(0);
			}
		}
		else {
			if (sourceSpec.compareTo(this.end)>0) {
				sourceSpec.setIdentifier(this.end.getIdentifier());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {

		if (isForward) {
			return nextSpec.compareTo(end) <= 0;
		} else {
			return nextSpec.compareTo(end) >= 0;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.Iterator#next()
	 */
	public ProjectAnalysisData next() {
		ProjectAnalysisData projectdata = AnalyzerFactory.eINSTANCE
				.createProjectAnalysisData();

		if (!hasNext()) {
			throw new NoSuchElementException("There is no more Versions.");
		}

		List<ChangePackage> changes;
		try {
			changes = connectionManager.getChanges(usersession
					.getSessionId(), projectId, sourceSpec, nextSpec);
		} catch (EmfStoreException e) {
			String message = "Could not get changes from server";
			WorkspaceUtil.logException(message, e);
			throw new NoSuchElementException(message + ":\n" + e);
		}

		List<ChangePackage> changePackages = projectdata.getChangePackages();
		for (ChangePackage changePackage: changes) {
			changePackage.apply(currentState);
			changePackages.add(changePackage);
		}
		
		projectdata.setPrimaryVersionSpec(nextSpec);
		projectdata.setProjectId(projectId);
		projectdata.setProjectState(currentState);
		
		//increase counter
		sourceSpec.setIdentifier(nextSpec.getIdentifier());		
		updateSpecifier(nextSpec, stepLength, isForward);
		
		if (returnProjectDataCopy) {
			return (ProjectAnalysisData) EcoreUtil.copy(projectdata);
		} else {
			return projectdata;
		}
	}

	private void updateSpecifier(PrimaryVersionSpec specifier, int stepLength, boolean isForward) {
		int currentIdentifier = specifier.getIdentifier();
		if (isForward) {
			specifier.setIdentifier(currentIdentifier + stepLength);
		} else {
			specifier.setIdentifier(currentIdentifier - stepLength);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
