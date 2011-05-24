/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egit.core.IteratorService;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.IndexDiff;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate.Result;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteRefUpdate;
import org.eclipse.jgit.transport.RemoteRefUpdate.Status;
import org.eclipse.jgit.transport.TrackingRefUpdate;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRepository;

/**
 * Utility class for Git related operations.
 * 
 * Operations for Git naming and repository finding are located in dedicated
 * Util classes which are GitNameUtil and GitRepoFindUtil, respectively.
 * 
 * @author jfinis
 * 
 */
public final class GitUtil {

	private GitUtil() {}

	/**
	 * Converts a string which must contain a 40 byte SHA hash in hex to a
	 * mutable object id.
	 * 
	 * @param s string containing a 40 byte SHA hash
	 * @return correspondent object id
	 */
	public static MutableObjectId stringToObjectId(String s) {
		MutableObjectId mo = new MutableObjectId();
		mo.fromString(s);
		return mo;
	}

	/**
	 * Retrieves a RefSpec correspondent to a Git branch model element.
	 * 
	 * @param branch Git branch model element
	 * @return corresponding RefSpec
	 */
	public static RefSpec getRefSpecFromGitBranch(GitBranch branch) {
		String refSpec = Constants.R_HEADS + branch.getBranchName();
		return new RefSpec(refSpec + ":" + refSpec);
	}

	/**
	 * Retrieves a thoroughly parsed commit from a repository with a specified
	 * hash.
	 * 
	 * @param hash hash of the commit
	 * @param repo Git repository
	 * @return the parsed commit
	 * @throws UnexpectedGitException if the commit cannot be retrieved for
	 *             various reasons
	 */
	public static RevCommit getCommitByHash(String hash, Repository repo) throws UnexpectedGitException {
		MutableObjectId objId = stringToObjectId(hash);
		RevWalk r = new RevWalk(repo);
		try {
			RevCommit c = r.parseCommit(objId);
			return c;
		} catch (MissingObjectException e) {
			throw new UnexpectedGitException("Could not obtain a commit from a repository", e);
		} catch (IncorrectObjectTypeException e) {
			throw new UnexpectedGitException("Could not obtain a commit from a repository", e);
		} catch (IOException e) {
			throw new UnexpectedGitException("Could not obtain a commit from a repository", e);
		}

	}

	/**
	 * Checks whether there are no changes in the working directory and the
	 * index. This method is computationally intensive as it checks the whole
	 * repository. Cache the result rather than calling it more than once.
	 * 
	 * @param repository local repository to check
	 * @return true iff no changes exist in the index and the working directory
	 */
	public static boolean isIndexAndWorkDirClean(Repository repository) {
		IndexDiff indexDiff;
		try {
			indexDiff = new IndexDiff(repository, Constants.HEAD, IteratorService.createInitialIterator(repository));
			indexDiff.diff();
		} catch (IOException e) {
			throw new UnexpectedGitException("IO Exception while examining local repository", e);
		}

		return indexDiff.getAdded().isEmpty() && indexDiff.getChanged().isEmpty() && indexDiff.getMissing().isEmpty() && indexDiff.getModified().isEmpty() && indexDiff.getRemoved().isEmpty() && indexDiff.getUntracked().isEmpty();
	}

	/**
	 * Retrieves all modifications contained in the working copy of a local
	 * repository. Retrieves them as a list of strings with each string
	 * corresponding to one modification.
	 * 
	 * @param repository local Git repository
	 * @return list of modifications
	 */
	public static List<String> getModifications(Repository repository) {
		IndexDiff indexDiff;
		try {
			indexDiff = new IndexDiff(repository, Constants.HEAD, IteratorService.createInitialIterator(repository));
			indexDiff.diff();
		} catch (IOException e) {
			throw new UnexpectedGitException("IO Exception while examining local repository", e);
		}
		List<String> result = new ArrayList<String>();
		result.addAll(indexDiff.getAdded());
		result.addAll(indexDiff.getChanged());
		result.addAll(indexDiff.getModified());
		result.addAll(indexDiff.getMissing());
		result.addAll(indexDiff.getRemoved());
		result.addAll(indexDiff.getUntracked());
		return result;
	}

	/**
	 * Retrieves all modifications contained in the working copy of a local
	 * repository. Retrieves the modifications as one string where each line
	 * contains one modification. The maximum amount of modifications can be
	 * chosen. If the number of modifications exceeds this maximum, it the
	 * exceeding modifications are omitted and a "(... X more)" line is appended
	 * to the string, with X being the number of omitted changes.
	 * 
	 * This method can be used for conveniently printing the list of
	 * modifications to the user.
	 * 
	 * @param repository local Git repository
	 * @param max maximum amount of displayed modifications
	 * @return modifications as a multi-line string (one modification per line)
	 */
	public static String getModificationsAsString(Repository repository, int max) {
		List<String> mods = getModifications(repository);
		StringBuilder result = new StringBuilder();
		int count = 0;
		for (Iterator<String> it = mods.iterator(); it.hasNext();) {
			String s = it.next();
			result.append(s);
			if (it.hasNext()) {
				result.append("\n");
			}
			if (++count >= max) {
				result.append("... (" + (mods.size() - max) + " more)");
				break;
			}
		}
		return result.toString();
	}

	/**
	 * Returns all commits in a local Git repository.
	 * 
	 * @param repository local Git repository
	 * @return all commits.
	 */
	public static Iterable<RevCommit> getAllCommits(Repository repository) {
		try {
			RevWalk rw = new RevWalk(repository);
			for (Ref ref : repository.getAllRefs().values()) {
				try {
					rw.markStart(rw.parseCommit(ref.getObjectId()));
				} catch (IncorrectObjectTypeException notACommit) {
					continue;
				}
			}
			return rw;

		} catch (MissingObjectException e) {
			throw new UnexpectedGitException(e);
		} catch (IOException e) {
			throw new UnexpectedGitException(e);
		}
	}

	/**
	 * Returns the identifying commit hash of this repository. This hash is used
	 * to identify the repository to link it to a repository location. It
	 * represents the commit hash of the earliest commit in the repository. Note
	 * that this earliest commit should not be deleted from the repository, as
	 * this would change the identifying hash.
	 * 
	 * The repository must contain at least one commit. If it doesn't, null is
	 * returned.
	 * 
	 * @param repository local Git repository
	 * @return identifying commit hash
	 */
	public static String getIdentifyingCommitHash(Repository repository) {
		RevCommit lastCommit = null;
		for (RevCommit c : getAllCommits(repository)) {
			lastCommit = c;
		}

		if (lastCommit == null) {
			return null;
		}

		return lastCommit.getId().getName();
	}

	/**
	 * Creates and initializes a Git repository location from a local
	 * repository. This is done by retrieving the identifying hash of this
	 * repository and entering it into the newly created loation.
	 * 
	 * @param repo local Git repository
	 * @return repository location corresponding to the local repository
	 */
	public static GitRepository initGitRepoModelFromRepo(Repository repo) {
		GitRepository gitRepoModel = GitFactory.eINSTANCE.createGitRepository();
		gitRepoModel.setIdentifyingCommitHash(getIdentifyingCommitHash(repo));
		return gitRepoModel;
	}

	/**
	 * Retrieves the URI from a repository location.
	 * 
	 * @param remote Git repository location
	 * @return the URI of that remote repository
	 * @throws URISyntaxException if the string contained in the repository
	 *             location is no valid URI
	 */
	public static URIish getURIFromRemote(GitRepository remote) throws URISyntaxException {
		return new URIish(remote.getUrl());
	}

	
	
	/**
	 * Returns whether a tracking ref update was successful.
	 * 
	 * @param updateResult the result of a ref update
	 * @return whether the update was successful
	 */
	public static boolean isRefUpdateSuccessful(TrackingRefUpdate updateResult){
		Result res = updateResult.getResult();
		switch(res){
		case IO_FAILURE:
		case LOCK_FAILURE:
		case REJECTED:
		case REJECTED_CURRENT_BRANCH:
			return false;
		default:
			return true;
		}
	}
	
	/**
	 * Returns whether a remote ref update was successful.
	 * 
	 * @param updateResult the result of a ref update
	 * @return whether the update was successful
	 */
	public static boolean isRemoteRefUpdateSuccessful(RemoteRefUpdate updateResult){
		Status res = updateResult.getStatus();
		switch(res){
		case AWAITING_REPORT:
		case NON_EXISTING:
		case NOT_ATTEMPTED:
		case REJECTED_NODELETE:
		case REJECTED_NONFASTFORWARD:
		case REJECTED_OTHER_REASON:
		case REJECTED_REMOTE_CHANGED:
			return false;
		default:
			return true;
		}
	}

}
