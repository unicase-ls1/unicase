/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.MergeCommand;
import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.api.TagCommand;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.InvalidMergeHeadsException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidTagNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.errors.UnmergedPathException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTag;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;

/**
 * Wrapper class which eases the use of Git functions. Mainly catches all
 * exceptions and wraps them in an unexpected exception.
 * 
 * @author jfinis
 * 
 */
public class GitWrapper {

	private Repository repo;
	private Git git;

	/**
	 * Creates a wrapper from a repository.
	 * 
	 * @param repo repo to be wrapped
	 */
	public GitWrapper(Repository repo) {
		this.repo = repo;
		this.git = new Git(repo);
	}

	/**
	 * Executes a Git checkout.
	 * 
	 * @param nameToCheckout name of the branch to be checked out
	 * @param createBranch whether a new branch should be created
	 * @return a ref to the checked out branch
	 */
	public Ref checkout(String nameToCheckout, boolean createBranch) {
		try {
			return git.checkout().setCreateBranch(createBranch).setName(nameToCheckout).call();
		} catch (JGitInternalException e) {
			throw new UnexpectedGitException("Checking out the branch failed.", e);
		} catch (RefAlreadyExistsException e) {
			throw new UnexpectedGitException("Checking out the branch failed.", e);
		} catch (RefNotFoundException e) {
			throw new UnexpectedGitException("Checking out the branch failed.", e);
		} catch (InvalidRefNameException e) {
			throw new UnexpectedGitException("Checking out the branch failed.", e);
		}
	}

	/**
	 * Executes a Git checkout.
	 * 
	 * @param nameToCheckout name of the branch to be checked out
	 * @return a ref to the checked out branch
	 */
	public Ref checkout(String nameToCheckout) {
		return checkout(nameToCheckout, false);
	}

	/**
	 * Executes a Git commit.
	 * 
	 * @param shortDescription short description of the commit
	 * @param longDescription long description of the commit
	 * @return the commit
	 */
	public RevCommit commit(String shortDescription, String longDescription) {
		return commit(shortDescription + "\n\n" + longDescription);
	}

	/**
	 * Commits resolved conflicts with a default commit message. Can only be
	 * used if the repository is in the MERGING_RESOLVED state.
	 * 
	 * @return the commit
	 */
	public RevCommit commitResolvedMergeConflicts() {
		if (repo.getRepositoryState() != RepositoryState.MERGING_RESOLVED) {
			throw new UnexpectedGitException("Cannot do a resolved merge commit if the repo is not in the MERGING_RESOLVED state");
		}

		return commit(getMergeResolveMessage());
	}

	/**
	 * Executes a git commit.
	 * 
	 * @param message commit message
	 * @return the commit
	 */
	private RevCommit commit(String message) {
		// Commit changes
		RevCommit commit = null;
		try {
			commit = git.commit().setAll(true).setMessage(message).call();
		} catch (NoHeadException e) {
			throw new UnexpectedGitException("Could not create new branch", e);
		} catch (NoMessageException e) {
			throw new UnexpectedGitException("Could not create new branch", e);
		} catch (UnmergedPathException e) {
			throw new UnexpectedGitException("Could not create new branch", e);
		} catch (ConcurrentRefUpdateException e) {
			throw new UnexpectedGitException("Could not create new branch", e);
		} catch (JGitInternalException e) {
			throw new UnexpectedGitException("Could not create new branch", e);
		} catch (WrongRepositoryStateException e) {
			throw new UnexpectedGitException("Could not create new branch", e);
		}
		return commit;
	}

	/**
	 * Builds the commit message for a resolved merge conflicts commit.
	 * 
	 * @return the commit message
	 */
	private String getMergeResolveMessage() {
		File mergeMsg = new File(repo.getDirectory(), Constants.MERGE_MSG);
		FileReader reader;
		try {
			reader = new FileReader(mergeMsg);
			BufferedReader br = new BufferedReader(reader);
			try {
				StringBuilder message = new StringBuilder();
				String s;
				String newLine = newLine();
				while ((s = br.readLine()) != null) {
					message.append(s).append(newLine);
				}
				return message.toString();
			} catch (IOException e) {
				throw new UnexpectedGitException(e);
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					// Empty
				}
			}
		} catch (FileNotFoundException e) {
			throw new UnexpectedGitException(e);
		}
	}

	private String newLine() {
		return System.getProperty("line.separator"); //$NON-NLS-1$
	}

	/**
	 * Performs a git merge of the current branch with the specified one.
	 * 
	 * @param branchToMerge branch to be merged.
	 * @return the merge result
	 */
	public MergeResult mergeWithResolve(Ref branchToMerge) {
		MergeCommand merge = git.merge();
		merge.setStrategy(MergeStrategy.RESOLVE);
		merge.include(branchToMerge);
		MergeResult mergeRes;
		try {
			mergeRes = merge.call();
		} catch (NoHeadException e) {
			throw new UnexpectedGitException(e.getMessage(), e);
		} catch (ConcurrentRefUpdateException e) {
			throw new UnexpectedGitException(e.getMessage(), e);
		} catch (CheckoutConflictException e) {
			throw new UnexpectedGitException(e.getMessage(), e);
		} catch (InvalidMergeHeadsException e) {
			throw new UnexpectedGitException(e.getMessage(), e);
		} catch (WrongRepositoryStateException e) {
			throw new UnexpectedGitException(e.getMessage(), e);
		} catch (NoMessageException e) {
			throw new UnexpectedGitException(e.getMessage(), e);
		}
		return mergeRes;
	}

	/**
	 * Creates a Git tag from the current HEAD revision.
	 * 
	 * @param tagName tag name
	 * @param message tag message
	 * @return the tag
	 */
	public RevTag createTag(String tagName, String message) {
		TagCommand tagCommand = git.tag().setName(tagName);
		tagCommand.setMessage(message);
		RevTag tag;
		try {
			tag = tagCommand.call();
		} catch (JGitInternalException e) {
			throw new UnexpectedGitException("Creating a tag failed.", e);
		} catch (ConcurrentRefUpdateException e) {
			throw new UnexpectedGitException("Creating a tag` failed.", e);
		} catch (InvalidTagNameException e) {
			throw new UnexpectedGitException("Creating a tag failed.", e);
		} catch (NoHeadException e) {
			throw new UnexpectedGitException("Creating a tag failed.", e);
		}
		return tag;
	}

	/**
	 * Performs a Git add on all unadded files in the working copy.
	 */
	public void addAllFiles() {
		try {
			git.add().addFilepattern(".").call();
		} catch (NoFilepatternException e1) {}
	}

}
