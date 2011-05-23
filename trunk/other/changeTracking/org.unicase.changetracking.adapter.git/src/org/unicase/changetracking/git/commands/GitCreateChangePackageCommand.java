/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.commands;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.git.GitVCSAdapter;
import org.unicase.changetracking.git.common.GitWrapper;
import org.unicase.changetracking.git.common.SayYesCredentialsProvider;
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

	private final String myName;
	private final WorkItem myWorkItem;
	private final GitRepository myRemoteRepo;
	private String myShortDescription;
	private String myLongDescription;
	private CredentialsProvider myCredentials;
	private IProject workspaceProject;
	private GitVCSAdapter vcsAdapter;

	/**
	 * Default constructor.
	 * 
	 * @param adapter Git VCS adapter to be used
	 * @param workspaceProject project from which the change package is to be
	 *            created.
	 * @param workItem work item to which the change package will be attached
	 * @param remoteRepo remote repository on which the branch for this change
	 *            package will be stored.
	 * @param name name of the change package
	 * @param shortDescription short description of the package
	 * @param longDescription long description of the package
	 */
	public GitCreateChangePackageCommand(GitVCSAdapter adapter, IProject workspaceProject, WorkItem workItem, GitRepository remoteRepo, String name, String shortDescription, String longDescription) {
		this.myName = name;
		this.myShortDescription = shortDescription;
		this.myLongDescription = longDescription;
		this.myWorkItem = workItem;
		this.myRemoteRepo = remoteRepo;
		// FIXME correct credentials provider
		this.myCredentials = new SayYesCredentialsProvider("gexicide", "git2day");
		this.workspaceProject = workspaceProject;
		this.vcsAdapter = adapter;
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
		Repository repo = vcsAdapter.findRepo(workspaceProject);

		// Init progress Monitor
		IProgressMonitor progressMonitor = getProgressMonitor();
		progressMonitor.beginTask("Creating Change Package", 6);
		progressMonitor.subTask("Checking requirements");
		GitWrapper git = new GitWrapper(repo);

		try {

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
			git.checkout(name, true);
			progressMonitor.worked(1);
			progressMonitor.subTask("Creating and linking model elements");

			// Create and attach git branch
			GitBranch branch = GitFactory.eINSTANCE.createGitBranch();
			branch.setBranchName(name);
			branch.setName(name);
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
			// GitPushOperation pushOp = new GitPushBuilder(repo, remoteRepo,
			// credentials).build(name);
			// pushOp.run(progressMonitor);

			// Test.gitPushTest();

		} finally {
			progressMonitor.done();
		}

		// //FIXME make push work
		// //Push the git branch
		// try {
		// git.push().setRefSpecs(new RefSpec("refs/head/" +
		// name)).setRemote("https://gexicide@github.com/gexicide/testor.git").call();
		// } catch (JGitInternalException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (InvalidRemoteException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
