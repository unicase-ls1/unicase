/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.commands;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteRefUpdate;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.git.common.GitNameUtil;
import org.unicase.changetracking.git.common.GitPushOperation;
import org.unicase.changetracking.git.common.GitRepoFindUtil;
import org.unicase.changetracking.git.common.GitUtil;
import org.unicase.changetracking.git.common.GitWrapper;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;

/**
 * Git implementation of the "create change package" use case.
 * 
 * @author jfinis
 * 
 */
public class GitCreateChangePackageCommand extends ChangeTrackingCommand {

	private static final String CHANGE_PACKAGE_BRANCH_NAME_PREFIX = "cp_";
	private final String myName;
	private final WorkItem myWorkItem;
	private final GitRepository myRemoteRepo;
	private String myShortDescription;
	private String myLongDescription;
	private CredentialsProvider myCredentials;
	private IProject[] workspaceProjects;

	/**
	 * Default constructor.
	 * 
	 * @param localProjects project from which the change package is to be
	 *            created.
	 * @param workItem work item to which the change package will be attached
	 * @param remoteRepo remote repository on which the branch for this change
	 *            package will be stored.
	 * @param name name of the change package
	 * @param shortDescription short description of the package
	 * @param longDescription long description of the package
	 */
	public GitCreateChangePackageCommand(IProject[] localProjects, WorkItem workItem, GitRepository remoteRepo, String name, String shortDescription, String longDescription) {
		this.myName = name;
		this.myShortDescription = shortDescription;
		this.myLongDescription = longDescription;
		this.myWorkItem = workItem;
		this.myRemoteRepo = remoteRepo;
		this.myCredentials = GitUtil.getDefaultCredentialsProvider();
		this.workspaceProjects = localProjects;
	}

	@Override
	protected ChangeTrackingCommandResult doRun() {
		try {
			createChangePackage(myWorkItem, myRemoteRepo, myName, myShortDescription, myLongDescription, myCredentials);
		} catch (VCSException e) {
			return errorResult(e);
		}
		return successResult("Change package created successfully.");
	}

	private void createChangePackage(WorkItem workItem, GitRepository remoteRepo, String name, String shortDescription, String longDescription, CredentialsProvider credentials) throws VCSException {
		// Find repository
		Repository repo = GitRepoFindUtil.findRepoForProjects(workspaceProjects);

		// Init progress Monitor
		IProgressMonitor progressMonitor = getProgressMonitor();
		progressMonitor.beginTask("Creating Change Package", 7);
		progressMonitor.subTask("Checking requirements");
		GitWrapper git = new GitWrapper(repo);

		// Check repository state
		if (!repo.getRepositoryState().canCommit()) {
			throw new MisuseException("The local repository is in a state which does not allow committing");
		}

		// Retrieve project
		Project p = ModelUtil.getProject(workItem);
		if (p == null) {
			throw new MisuseException("The supplied work item does not belong to a project");
		}

		// check that no branch with that name already exists
		try {
			ObjectId objId = repo.resolve(name);
			if (objId != null) {
				throw new MisuseException("A branch named'" + name + "' already exists");
			}
		} catch (AmbiguousObjectException e1) {
			throw new UnexpectedGitException(e1);
		} catch (IOException e1) {
			throw new UnexpectedGitException(e1);
		}

		// Create and checkout a new branch
		String branchName = CHANGE_PACKAGE_BRANCH_NAME_PREFIX + name;
		git.checkout(branchName, true);
		progressMonitor.worked(1);
		progressMonitor.subTask("Creating and linking model elements");

		// Create and attach git branch
		GitBranch branch = GitFactory.eINSTANCE.createGitBranch();
		branch.setBranchName(branchName);
		branch.setName(branchName);
		branch.setLocation(remoteRepo);
		ChangeTrackingUtil.addToProjectRelative(branch, workItem, false);

		// Create Change Package model element
		GitBranchChangePackage changePackage = GitFactory.eINSTANCE.createGitBranchChangePackage();
		changePackage.setName(name);
		changePackage.setDescription(longDescription);
		changePackage.setShortDescription(shortDescription);
		changePackage.setBranch(branch);
		ChangeTrackingUtil.addToProjectRelative(changePackage, branch, false);

		// Attach change package to work item
		workItem.getAttachments().add(changePackage);

		// Adding all files
		progressMonitor.worked(1);
		progressMonitor.subTask("Adding...");

		git.addAllFiles();

		progressMonitor.worked(1);
		progressMonitor.subTask("Committing...");

		// Commit changes
		git.commit(shortDescription, longDescription);

		progressMonitor.worked(1);
		progressMonitor.subTask("Pushing new branch to remote repository...");

		// Push to remote repo
		try {
			URIish repoURI;
			try {
				repoURI = GitUtil.getURIFromRemote(remoteRepo);
			} catch (URISyntaxException e) {
				throw new MisuseException(e);
			}
			List<RefSpec> pushSpec = Arrays.asList(GitNameUtil.getRefSpecFromGitBranch(branch,false));
			PushResult pushResult = new GitPushOperation(repo, repoURI, pushSpec, false, 15000, credentials).run(new SubProgressMonitor(progressMonitor, 3));
			for (RemoteRefUpdate updateResult : pushResult.getRemoteUpdates()) {
				if (!GitUtil.isRemoteRefUpdateSuccessful(updateResult)) {
					throw new UnexpectedGitException("Was unable to push the created branch to the remote repository.\nReason: " + updateResult.getMessage() + " (" + updateResult.getStatus() + ")");
				}
			}
		} catch (UnexpectedGitException e) {
			throw new UnexpectedGitException("The change package was created successfully, but the pushing to the remote repository failed (see error log for details). Push the created branch '" + branchName + "' manually to the remote repository.", e);
		}

	}

}
