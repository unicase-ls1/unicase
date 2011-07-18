/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.vcs;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.CheckReleaseCommand;
import org.unicase.changetracking.commands.CreateStreamCommand;
import org.unicase.changetracking.common.IDecisionProvider;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.exceptions.NotSupportedByAdapterException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.release.ReleaseBuildingSettings;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.metamodel.Project;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.task.WorkItem;

/**
 * The adapter interface to be implemented by each adapter plug-in.
 * 
 * It defines methods which the adapter must provide to ensure the
 * functionality.
 * 
 * Shorter operations must return a result right away. Longer operations instead
 * return an appropriate command. The command must implement the functionality
 * which is triggered upon execution.
 * 
 * If a VCS Adapter does not support some functionality, it may throw a
 * NotSupportedByAdapterException or return a command which throws such
 * exception upon execution. The easiest way to achieve this is to inherit from
 * the BasicVCSAdapter class which implements all methods this way.
 * 
 * Note that all methods which work on workspace projects can assume that this
 * project is under the correct version control. This must be the case, because
 * otherwise this adapter's methods would not have been called.
 * 
 * @author jfinis
 * 
 */
public interface IVCSAdapter {

	/**
	 * Returns a name validator which is used to validate tag names for this
	 * version control system.
	 * 
	 * @return name validator
	 */
	INameValidator getNameValidator();

	/**
	 * Given a unicase project and local projects in the workspace, this method
	 * must return the repository location in the unicase project which matches
	 * the local projects. "Matches" here means that the source code of these
	 * projects must be connected with a remote repository which has this
	 * location.
	 * 
	 * For Git, for example, this can be done by first obtaining the local
	 * repository from the workspace project and then checking the first commit
	 * hash against the hashes of each GitRepositoryLocation in the unicase
	 * project.
	 * 
	 * If no matching repository is found in the unicase project, this method
	 * must return null.
	 * 
	 * @param workspaceProjects projects under version control
	 * @param unicaseProject a unicase project
	 * @return the repository location in the unicase project, which is
	 *         associated to the workspace project, or null if no such
	 *         repository location exists
	 * @throws VCSException if a VCS specific exception occurs
	 */
	RepositoryLocation findRepoLocation(IProject[] workspaceProjects, Project unicaseProject) throws VCSException;

	/**
	 * Creates a repository location from a set of workspace project. This may
	 * also include asking the user for additional information.
	 * 
	 * For git, this can be done by searching the local repository and asking
	 * the user for the url of the remote one. For SVN, this can be done by
	 * checking the SVN config for the remote repo URL
	 * 
	 * @param workspaceProjects projects in the workspace under version control
	 * @return the repository location of that project
	 * @throws VCSException if a VCS specific exception occurs
	 * @throws CancelledByUserException if the user cancels the process
	 */
	RepositoryLocation createRepositoryLocation(IProject[] workspaceProjects) throws VCSException, CancelledByUserException;

	/**
	 * Returns a create change package command.
	 * 
	 * This command has the following tasks which have to be implemented by the
	 * returned command:
	 * 
	 * - The change package ( and additional model elements if needed ) must be
	 * created
	 * 
	 * - The change package must be set up to contain all changes in the
	 * workspace project.
	 * 
	 * - The name, short description, and long description must be set for the
	 * change package
	 * 
	 * - The change package must be attached to the work item
	 * 
	 * - The change package and all additionally created files must be added in
	 * the project at the location where the work item is located.
	 * 
	 * If the creation of a change package with this adapter needs a repository
	 * location (i.e. if doesChangePackageNeedRepoLocation returns true), then
	 * the location will be set as input parameter. Otherwise, this parameter
	 * will be null.
	 * 
	 * @param localProjects workspace projects from which to take the changes
	 * @param workItem work item to which the change package is to be attached
	 * @param remoteRepo repository location if this adapter needs one;
	 *            otherwise null
	 * @param name name for the change package
	 * @param shortDescription short description for the change package
	 * @param longDescription long description for the change package
	 * @return the command which conducts the creation
	 */
	ChangeTrackingCommand createChangePackage(IProject[] localProjects, WorkItem workItem, RepositoryLocation remoteRepo, String name, String shortDescription, String longDescription);

	/**
	 * Indicates whether the creation of a change package needs a repository
	 * location. If this method returns true, then findRepoLocation will be
	 * called before the creation of a change package to retrieve a location for
	 * it. Otherwise, the repoLocation parameter during the creation of a change
	 * package will be null.
	 * 
	 * @return whether this adapter needs a repository location for the creation
	 *         of a change package.
	 */
	boolean doesChangePackageNeedRepoLocation();

	/**
	 * Returns a command which executes the check release use case.
	 * 
	 * This command must perform the following steps:
	 * 
	 * - It must ask the user to refresh his local code. This is to be done by
	 * calling the decision provider's appropriate method. If he wants to
	 * refresh it, it must do this before the check. Otherwise, it must add a
	 * warning that the code might be outdated. - It must create a check report
	 * and provide it when its getReport method is called For details about the
	 * contents of the report, see the report class
	 * 
	 * @param decisionProvider a decision provider which determines if the user
	 *            wants to
	 * @param release the release to be checked
	 * @return the command conducting the checking
	 */
	CheckReleaseCommand checkRelease(IDecisionProvider decisionProvider, Release release);

	/**
	 * Returns a command which executes the build release use case. The checking
	 * of the release is already done at this step and the result is provided as
	 * parameter.
	 * 
	 * The command must perform the following tasks:
	 * 
	 * - merge all unmerged change packages into the local source code
	 * 
	 * - commit the result to the remote repository
	 * 
	 * - create a tag in the remote repository (if allowed by the VCS) - create
	 * a model element in the unicase project which can be used to retrieve the
	 * commit of the release. This model element must be a subclass of
	 * RepositoryRevision.
	 * 
	 * - set the built flag of the release to true, set the build date, and
	 * attach the created repository revision as built revision to the release.
	 * 
	 * @param release the relase to be built
	 * @param settings the release building settings as chosen by the user
	 * @param checkReport the report from checking the release
	 * @return the command which conducts the build release use case
	 */
	BuildReleaseCommand buildRelease(Release release, ReleaseBuildingSettings settings, ReleaseCheckReport checkReport);

	/**
	 * Creates a stream from the currently checked out branch of a workspace
	 * project.
	 * 
	 * @param decisionProvider decision provider to ask the user for updates
	 * @param workspaceProject the workspace project from which the branch
	 *            should be inferred
	 * @return the command conduction the creation
	 */
	CreateStreamCommand createStreamFromCurrentBranch(IDecisionProvider decisionProvider, IProject workspaceProject);

	/**
	 * This method can be used to conduct early checks which are executed even
	 * before the create change package wizard is shown.
	 * 
	 * For example, it can be checked if the local project is in a state which
	 * allows change package creation (e.g. no unresolved conflicts!)
	 * 
	 * If a check fails, then a message should be returned stating the problem.
	 * The creation will be aborted and the user will be shown the message. If
	 * all checks succeed, then null must be returned.
	 * 
	 * @param localProjects the local projects from which the change package is
	 *            to be created
	 * @return a problem message or null if all checks succeeded
	 * @throws VCSException if a VCS specific exception occurs
	 */
	String performEarlyCreateChangePackageChecks(IProject[] localProjects) throws VCSException;

	/**
	 * Creates and sets up a repository stream by examining a local project and
	 * using its current branch as stream. For a git project for example, the
	 * currently checked out branch will be taken to create the repository
	 * stream. The stream also gets linked to the repository location.
	 * 
	 * @param localProject the project from which to infer the branch
	 * @param repoLocation a repository location on which the stream should be
	 *            created
	 * @return fully set-up repository stream matching the local project.
	 * @throws NotSupportedByAdapterException if this operation is not supported
	 *             by the adapter
	 */
	RepositoryStream createRepositoryStream(IProject localProject, RepositoryLocation repoLocation) throws NotSupportedByAdapterException;

	/**
	 * Creates a command which conducts the application of a change package
	 * 
	 * The command must perform the following steps: - Do necessary pre-checks,
	 * e.g. if the local source code is in a state which allows to apply the
	 * change package - apply the change package. Afterwards, the local source
	 * code must contain all changes contained in the package.
	 * 
	 * @param changePackage the change package to be applied
	 * @return the command conducting the application
	 */
	ChangeTrackingCommand applyChangePackage(ChangePackage changePackage);

}
