/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.vcs;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.commands.CheckReleaseCommand;
import org.unicase.changetracking.commands.CreateStreamCommand;
import org.unicase.changetracking.commands.CreateStreamFromCurrentBranchCommand;
import org.unicase.changetracking.common.IDecisionProvider;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.exceptions.NotSupportedByAdapterException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.release.ReleaseBuildingSettings;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.task.WorkItem;

/**
 * Basic implemenation of a VCS adapter which does not support any opperation.
 * All operations will either directly throw a not supported exception or return
 * a command which throws this exception upon execution.
 * 
 * Check methods do not throw an exception but return the default case.
 * 
 * The only meaningful implementation provided by this adapter is for the
 * createStreamFromCurrentBranch method, which can be realized independently of
 * the VCS. However, it can be overridden for further individualization
 * 
 * @author jfinis
 * 
 */
public abstract class BasicVCSAdapter implements IVCSAdapter {

	/**
	 * {@inheritDoc}
	 */
	public CreateStreamCommand createStreamFromCurrentBranch(IDecisionProvider decisionProvider, IProject workspaceProject) {
		return new CreateStreamFromCurrentBranchCommand(this, decisionProvider, workspaceProject);
	}

	private RuntimeException notSupported(String s) {
		return new RuntimeException(new NotSupportedByAdapterException(s));
	}

	private ChangeTrackingCommand notSupportedCommand(final String s) {
		return new ChangeTrackingCommand() {

			@Override
			protected ChangeTrackingCommandResult doRun() {
				throw notSupported(s);
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	public ChangeTrackingCommand applyChangePackage(ChangePackage changePackage) {
		return notSupportedCommand("change package application");
	}

	/**
	 * {@inheritDoc}
	 */
	public BuildReleaseCommand buildRelease(Release release, ReleaseBuildingSettings settings, ReleaseCheckReport checkReport) {
		return new BuildReleaseCommand() {

			@Override
			protected ChangeTrackingCommandResult doRun() {
				throw notSupported("release building");
			}

			@Override
			public boolean hadConflicts() {
				return false;
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	public CheckReleaseCommand checkRelease(IDecisionProvider decisionProvider, Release release) {
		return new CheckReleaseCommand() {

			@Override
			protected ChangeTrackingCommandResult doRun() {
				throw notSupported("release checking");
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	public ChangeTrackingCommand createChangePackage(IProject[] localProjects, WorkItem workItem, RepositoryLocation remoteRepo, String name, String shortDescription, String longDescription) {
		return notSupportedCommand("change package creation");
	}

	/**
	 * {@inheritDoc}
	 */
	public RepositoryLocation createRepositoryLocation(IProject[] workspaceProjects) throws VCSException, CancelledByUserException {
		throw new NotSupportedByAdapterException("repository location creation");
	}

	/**
	 * {@inheritDoc}
	 */
	public RepositoryStream createRepositoryStream(IProject localProject, RepositoryLocation repoLocation) throws NotSupportedByAdapterException {
		throw new NotSupportedByAdapterException("repository stream creation");
	}

	/**
	 * {@inheritDoc}
	 */
	public RepositoryLocation findRepoLocation(IProject[] workspaceProjects, org.eclipse.emf.emfstore.common.model.Project unicaseProject) throws VCSException {
		throw new NotSupportedByAdapterException("repository location retrieval");
	}

	/**
	 * {@inheritDoc}
	 */
	public INameValidator getNameValidator() {
		return new INameValidator() {

			public String isNewTagNameValid(String text, RepositoryLocation repoLoc) {
				return null;
			}

			public String cleanName(String name) {
				return name;
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	public String performEarlyCreateChangePackageChecks(IProject[] localProjects) throws VCSException {
		return null;
	}

}
