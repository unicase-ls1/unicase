/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.release;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.changetracking.release.ChangePackageState;

/**
 * Checks the state of change packages by assembling the set of commits which
 * are predecessors of the release's head commit. This set is the so-called
 * trunk set.
 * 
 * Next, it uses the trunk set to infer the change package states: If a change
 * package is in the trunk set, its status is MERGED (because it must already be
 * merged), otherwise it is checked if the change package has a predecessing
 * commit which is in the trunk set. If so, the state is UNMERGED, if not the
 * state is ERROR. This is because if even no predecessing commits are in the
 * trunk set, then the change package is not related at all to the revision
 * graph of the release commit. This cannot be the case, usually.
 * 
 * 
 * @author jfinis
 * 
 */
public class ChangePackageStateChecker {

	private RevWalk revWalk;

	/**
	 * Default constructor.
	 * 
	 * @param repo local repository from which the checking will be conducted.
	 */
	public ChangePackageStateChecker(Repository repo) {
		this.revWalk = new RevWalk(repo);
	}

	/**
	 * Does the checking. The change packages to be checked have to be passed as
	 * commits. These commits must be the head revisions of the change package
	 * branches. The result is returned as a mapping from commit to the
	 * respective result state.
	 * 
	 * @param baseHead head revision of the release
	 * @param set set of change package commits to be checked
	 * @return checking result
	 */
	public Map<RevCommit, ChangePackageState> checkStates(RevCommit baseHead, Collection<RevCommit> set) {
		Map<RevCommit, ChangePackageState> result = new HashMap<RevCommit, ChangePackageState>();
		Set<String> trunkSet = buildTrunkSet(baseHead);

		for (RevCommit c : set) {
			// If the commit is contained in the trunk set, it is already merged
			// in.
			if (trunkSet.contains(c.getName())) {
				result.put(c, ChangePackageState.MERGED);

				// Otherwise, check if it is connected with the trunk set
			} else if (checkConnection(trunkSet, c)) {
				result.put(c, ChangePackageState.UNMERGED);
			} else {
				result.put(c, ChangePackageState.ERROR);
			}
		}

		return result;
	}

	/**
	 * Checks if a commit is connected to the trunk set via its predecessing
	 * commits.
	 * 
	 * @param trunkSet the trunk set
	 * @param c the commit to be checked
	 * @return whether the commit is connected to the trunk set
	 */
	private boolean checkConnection(Set<String> trunkSet, RevCommit c) {
		if (trunkSet.contains(c.getName())) {
			// This node is in the trunk set, so it is obviously connected to it
			return true;
		} else {
			// Resolve parents
			c = resolveParentsIfNecessary(c);
			if (c.getParentCount() > 0) {
				int count = c.getParentCount();
				for (int i = 0; i < count; i++) {
					if (checkConnection(trunkSet, c.getParent(i))) {
						// Parent is connected, so this commit is, too
						return true;
					}
				}
				// No parent is connected? Then this is not connected, too
				return false;
			} else {
				// Still not connected and has no more parents? => Not connected
				return false;
			}
		}
	}

	/**
	 * Resolves the parents of a commit if they have not been resolved yet by
	 * parsing the commit header.
	 * 
	 * @param c the commit to resolve the parents
	 * @return the input commit
	 */
	private RevCommit resolveParentsIfNecessary(RevCommit c) {
		if (c.getParents() == null) {
			try {
				revWalk.parseHeaders(c);
				// old version, slower than only parsing headers
				// c = revWalk.parseCommit(c.getId());
				if (c.getParents() == null) {
					throw new UnexpectedGitException("Parents array is null after parsing");
				}
			} catch (MissingObjectException e) {
				throw new UnexpectedGitException(e);
			} catch (IncorrectObjectTypeException e) {
				throw new UnexpectedGitException(e);
			} catch (IOException e) {
				throw new UnexpectedGitException(e);
			}
		}
		return c;

	}

	/**
	 * Builds the trunk set by performing a graph traversal backwards the
	 * revision graph, starting from the base head revision (the head revision
	 * of the release branch).
	 * 
	 * @param baseHead the base head revision
	 * @return the trunk set, identified by the hashes of the commits in it
	 */
	private Set<String> buildTrunkSet(RevCommit baseHead) {
		ArrayList<RevCommit> queue = new ArrayList<RevCommit>();
		Set<String> result = new HashSet<String>();

		queue.add(baseHead);
		result.add(baseHead.getName());
		int i = 0;
		while (!queue.isEmpty()) {
			i++;

			// Unqueue current node and add to result
			RevCommit cur = resolveParentsIfNecessary(queue.remove(queue.size() - 1));

			// Add all parents into queue
			if (cur.getParents() != null) {
				for (RevCommit parent : cur.getParents()) {
					if (!result.contains(parent.getName())) {
						result.add(parent.getName());
						queue.add(parent);
					}
				}
			}
		}
		return result;
	}

}
