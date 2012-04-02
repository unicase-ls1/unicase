/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.releasechecking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.TrackingRefUpdate;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.common.PrintfFormat;
import org.unicase.changetracking.exceptions.ErrorInModelException;
import org.unicase.changetracking.git.common.GitFetchOperation;
import org.unicase.changetracking.git.common.GitNameUtil;
import org.unicase.changetracking.git.common.GitUtil;
import org.unicase.changetracking.release.ChangePackageState;
import org.unicase.changetracking.release.Problem;
import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.ReleaseUtil;
import org.unicase.changetracking.release.WorkItemStatistics;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;

/**
 * This class conducts the release checking for the Git implementation.
 * 
 * Performs all checks to find as many problems as possible.
 * 
 * Provides a static convenience method "check" which constructs a new release
 * checker and calls its check method.
 * 
 * @author jfinis
 * 
 */
public final class ReleaseChecker {

	/*
	 * Problem messages. The %s are used as placeholders for problem instance
	 * specific data
	 */
	private static final String ERROR_LOCAL_REPO_STATE_NOT_SAFE = "Your local repository is not in a safe state. Put it into a safe state before building a release.\nCurrent state: %s";
	private static final String ERROR_UNCOMMITED_CHANGES_IN_WORKSPACE = "Your working directory or index contains uncommited changes. Revert or commit the changes before building a release.\n\nFollowing changes were found:\n%s";
	private static final String ERROR_RELEASE_ALREADY_BUILT = "The release has already been built.";
	private static final String WARNING_THE_BRANCH_COULD_NOT_BE_UPDATED = "The branch '%s' could not be updated(%s). Its content might be out of date.";
	private static final String WARNING_LONELY_WORK_ITEM = "The %s '%s' is resolved but has no change package attached.";
	private static final String WARNING_REPO_NOT_UP_TO_DATE = "Your local repository is not up to date. Some information might be outdated.";
	private static final String WARNING_NOT_ALL_BRANCHES_UPDATED = "Not all branches of the release could be updated. Some data might be out of date.\nPossible reason: %s";
	private static final String ERROR_INCOMPATIBLE_CHANGE_PACKAGE = "The change package '%s' is not a Git branch change package." + "Only these are allowed at the moment";
	private static final String ERROR_MISSING_BRANCH = "The change package '%s' has no branch set.";
	private static final String ERROR_MISSING_LOCATION = "The branch '%s' which is used by the change package '%s' has no repository location.";
	private static final String ERROR_DIFFERENT_LOCATIONS = "The change packages use different locations. All change packages must use the same location.\nLocations used:\n%s\n%s";
	private static final String ERROR_BRANCH_NOT_IN_LOCAL_REPO = "The branch 'refs/heads/%s' (label: '%s', used by change package '%s') was not found in the local repository. If you haven't updated, the branch might not be pulled yet. Please update.";
	private static final String ERROR_DUPLICATE_BRANCH = "The branch '%s' is used by more than one change package (%s, %s).";
	private static final String ERROR_DUPLICATE_BRANCH_MAPPING = "Two unicase branches (%s, %s) use the same git branch (%s).";
	private static final String ERROR_INCOMPATIBLE_REPO_STREAM = "The repository stream '%s' associated with the stream of the release is no Git branch. Only these are supported at the moment.";
	private static final String ERROR_LOCATION_MISMATCH = "The repository location '%s' used for the change packages is not the same as the stream location of the release (%s).";
	private static final String ERROR_IO_EXCEPTION_WHILE_PARSING_COMMIT = "An IO Exception occurred while parsing the branch '%s' from the local repository. Retry and check that the local repository is not inaccessible.";
	private static final String ERROR_REF_IS_NO_COMMIT = "The branch head '%s' is no commit. Your local repository seems to be severly damaged. Reclone from remote.";
	private static final String ERROR_MISSING_COMMIT = "The commit to which the branch head '%s' points is missing.  Your local repository seems to be severly damaged. Reclone from remote.";
	private static final String ERROR_RELEASE_BRANCH_NOT_FOUND = "The git branch associated with the stream of the release does not exist in the local repository.";

	private Release release;
	private Repository localRepo;
	private List<Problem> errorMessages = new ArrayList<Problem>();
	private RepositoryLocation releaseRepoLoc;
	private GitBranch releaseBranch;
	private RevWalk revWalk;
	private Map<String, Ref> refMap;
	private boolean wantUpdateBeforeCheck;
	private HashMap<ChangePackage, ChangePackageCheckEntry> changePackageResults;
	private CheckEntry releaseBase;

	/**
	 * Convenience method for checking a release. Constructs a new checker,
	 * calls its check method, and returns the result.
	 * 
	 * @param localRepo local repository containing the release code
	 * @param release the release to be checked
	 * @param wantUpdateBeforeCheck whether the repository should be updated before the
	 *            checking is conducted
	 * @param monitor progress monitor
	 * @return the report
	 */
	public static ReleaseCheckReport check(Repository localRepo, Release release, boolean wantUpdateBeforeCheck, IProgressMonitor monitor) {
		return new ReleaseChecker(localRepo, release, wantUpdateBeforeCheck).check(monitor);
	}

	private ReleaseChecker(Repository localRepo, Release release, boolean wantUpdateBeforeCheck) {
		this.localRepo = localRepo;
		this.release = release;
		this.wantUpdateBeforeCheck = wantUpdateBeforeCheck;
		if (localRepo != null) {
			this.revWalk = new RevWalk(localRepo);
			this.refMap = localRepo.getAllRefs();
		}
	}

	/*
	 * Methods for adding errors and warnings to the resulting report
	 */
	private void addError(String errorString) {
		errorMessages.add(new Problem(Severity.ERROR, errorString));
	}

	private void addError(String formatString, String argument) {
		errorMessages.add(new Problem(Severity.ERROR, new PrintfFormat(formatString).sprintf(argument)));
	}

	private void addError(String formatString, Object... arguments) {
		errorMessages.add(new Problem(Severity.ERROR, new PrintfFormat(formatString).sprintf(arguments)));
	}

	private void addWarning(String errorString) {
		errorMessages.add(new Problem(Severity.WARNING, errorString));
	}

	private void addWarning(String string, Object... arguments) {
		errorMessages.add(new Problem(Severity.WARNING, new PrintfFormat(string).sprintf(arguments)));
	}

	/**
	 * Conducts the actual checking.
	 * 
	 * @return the report
	 */
	private ReleaseCheckReport check(IProgressMonitor progressMonitor) {
		
		if(progressMonitor == null){
			progressMonitor = new NullProgressMonitor();
		}
		progressMonitor.beginTask("Checking release", 9);
		
		// Check that the release is not built yet
		if (release.isBuilt()) {
			addError(ERROR_RELEASE_ALREADY_BUILT);
		}

		// Check the local repository and workspace for changes that disallow
		// release building
		checkWorkspace();
		progressMonitor.worked(1);

		// Calculate work item statistics
		WorkItemStatistics workItemStats = ReleaseUtil.getWorkItemStatisticsFromRelease(release);

		// Retrieve all change packages
		Map<ChangePackage, WorkItem> changePackages = ReleaseUtil.getChangePackagesFromRelease(release);

		// Check for resolved work items without change packages
		checkLonelyWorkItems(ReleaseUtil.getWorkItemsWithoutChangePackagesFromRelease(release));

		// Create result map
		initChangePackageResultMap(changePackages.keySet());

		// Check the release itself (its stream and the streams location)
		checkReleaseModel();

		// Check the change packages and their referenced branches and locations
		Map<GitBranch, ChangePackage> branchMap = checkChangePackages(changePackages.keySet());
		progressMonitor.worked(1);

		// If the repository is not checked out, we cannot do further checks.
		if (localRepo == null) {
			progressMonitor.worked(7);
			return new GitReport(releaseRepoLoc, workItemStats, changePackages.keySet(), errorMessages, false);
		}

		// Now, the release and change package contents can be update if desired
		featchIfDesired(branchMap, progressMonitor);

		// If a repo exists and is not up to date, add this as error Message
		if(!wantUpdateBeforeCheck){
			addWarning(WARNING_REPO_NOT_UP_TO_DATE);
		}
		
		// Check if the branches exist in the local repository and do not
		// collide
		Map<Ref, GitBranch> branchMapping = checkLocalBranches(branchMap);

		// Check that all referenced Refs are actually commits and build
		// the mapping from RevCommit to change package which will be used
		// to determine which packages are merged.
		Map<RevCommit, List<ChangePackage>> commitMapping = checkForCommits(branchMap, branchMapping);

		// Check release branch
		releaseBase = checkReleaseBranch();

		// Using all the gathered information,
		// we can now check which branches are already merged
		Map<RevCommit, ChangePackageState> mergeStatus = calcMergeState(releaseBase, commitMapping);

		// From the branch state mapping, we can infer the state mapping of the
		// change packages
		calcChangePackageState(commitMapping, mergeStatus, changePackages.keySet());

		// All relevant information has been gathered, create and return a
		// report
		GitReport report = new GitReport(releaseRepoLoc, workItemStats, errorMessages, true, wantUpdateBeforeCheck, getChangePackageStates(changePackageResults));
		setGitData(report);
		progressMonitor.worked(1);
		return report;
	}

	private void featchIfDesired(Map<GitBranch, ChangePackage> branchMap, IProgressMonitor progressMonitor) {
		// Return if no update is desired
		if (!wantUpdateBeforeCheck) {
			progressMonitor.worked(6);
			return;
		}

		ArrayList<RefSpec> branchesToFetch = new ArrayList<RefSpec>();
		
		// Add the release branch
		branchesToFetch.add(GitNameUtil.getRefSpecFromGitBranch(releaseBranch, true));

		// Add all change package branches
		for (GitBranch branch : branchMap.keySet()) {
			branchesToFetch.add(GitNameUtil.getRefSpecFromGitBranch(branch, true));
		}

		// Perform the update
		GitFetchOperation fetchOp = new GitFetchOperation((GitRepository) releaseRepoLoc, localRepo, GitUtil.getDefaultCredentialsProvider(), 30000, branchesToFetch);
		fetchOp.setProgressMonitor(new SubProgressMonitor(progressMonitor, 6));
		FetchResult updates = new GitFetchOperation((GitRepository) releaseRepoLoc, localRepo, GitUtil.getDefaultCredentialsProvider(), 30000, branchesToFetch).run();

		//check the result
		boolean warning = false;
		for(TrackingRefUpdate updateResult : updates.getTrackingRefUpdates()){
			if(!GitUtil.isRefUpdateSuccessful(updateResult)){
				addWarning(WARNING_THE_BRANCH_COULD_NOT_BE_UPDATED,updateResult.getLocalName(),updateResult.getResult().toString());
				warning = true;
			}
		}
		if(warning){
			addWarning(WARNING_NOT_ALL_BRANCHES_UPDATED,updates.getMessages());
		}
	}

	/**
	 * Performs some checks on the local repository, like checking if the
	 * repository has no changes in the working copy (which would make building
	 * impossible).
	 */
	private void checkWorkspace() {
		// Check that the repo has no changes
		boolean indexClean = GitUtil.isIndexAndWorkDirClean(localRepo);
		if (!indexClean) {
			addError(ERROR_UNCOMMITED_CHANGES_IN_WORKSPACE, GitUtil.getModificationsAsString(localRepo, 10));
		}

		// Check that it is in a safe state
		if (RepositoryState.SAFE != localRepo.getRepositoryState()) {
			addError(ERROR_LOCAL_REPO_STATE_NOT_SAFE, localRepo.getRepositoryState().getDescription());
		}
	}

	/**
	 * Builds the list of change packages which have to be merged.
	 * 
	 * @param results the change package state check results
	 * @return list of refs to be merged
	 */
	private List<Ref> buildMergeSet(Map<ChangePackage, ChangePackageCheckEntry> results) {
		List<Ref> mergeList = new ArrayList<Ref>();

		for (Entry<ChangePackage, ChangePackageCheckEntry> e : results.entrySet()) {
			ChangePackageCheckEntry result = e.getValue();
			if (result.getState() == ChangePackageState.UNMERGED) {
				mergeList.add(result.getRef());
			}
		}

		return mergeList;
	}

	/**
	 * Sets the git specific part of data in the resulting report.
	 * 
	 * @param report the report
	 */
	private void setGitData(GitReport report) {
		Ref baseRef = null;
		if (releaseBase != null) {
			baseRef = releaseBase.getRef();
		}
		List<Ref> mergeSet = buildMergeSet(changePackageResults);
		report.setGitData(localRepo, baseRef, mergeSet);
	}

	/**
	 * Retrieves the change package states as a map from change package to its
	 * state.
	 * 
	 * @param rMap results of the change package checking
	 * @return mapping from change package to its state
	 */
	private HashMap<ChangePackage, ChangePackageState> getChangePackageStates(HashMap<ChangePackage, ChangePackageCheckEntry> rMap) {
		HashMap<ChangePackage, ChangePackageState> result = new HashMap<ChangePackage, ChangePackageState>();
		for (Entry<ChangePackage, ChangePackageCheckEntry> e : rMap.entrySet()) {
			result.put(e.getKey(), e.getValue().getState());
		}
		return result;
	}

	/**
	 * Adds warnings for work items which do not have change packages attached
	 * but are resolved.
	 * 
	 * @param items work items without change packages
	 */
	private void checkLonelyWorkItems(List<WorkItem> items) {
		for (WorkItem w : items) {
			if (w.isResolved()) {
				addWarning(WARNING_LONELY_WORK_ITEM, w.eClass().getName(), w.getName());
			}
		}
	}

	/**
	 * Initiates the change package result map by entering an initial check
	 * entry for each change package.
	 * 
	 * @param set set of change packages
	 */
	private void initChangePackageResultMap(Set<ChangePackage> set) {
		changePackageResults = new HashMap<ChangePackage, ChangePackageCheckEntry>();
		for (ChangePackage cp : set) {
			changePackageResults.put(cp, new ChangePackageCheckEntry(cp));
		}

	}

	/**
	 * Calculates the change package states and enters them into the change
	 * package result map.
	 * 
	 * @param commitMapping mapping from commit to change packages which use
	 *            this commit as head
	 * @param mergeStatus mapping from commit to change package state
	 * @param set set of change packages
	 */
	private void calcChangePackageState(Map<RevCommit, List<ChangePackage>> commitMapping, Map<RevCommit, ChangePackageState> mergeStatus, Set<ChangePackage> set) {

		Set<ChangePackage> done = new HashSet<ChangePackage>();

		// For the registered commits, register the packages
		for (Entry<RevCommit, ChangePackageState> e : mergeStatus.entrySet()) {
			ChangePackageState mergeState = e.getValue();
			for (ChangePackage cp : commitMapping.get(e.getKey())) {
				done.add(cp);
				changePackageResults.get(cp).setState(mergeState);
			}
		}

		// For all other packages, add the error state
		for (ChangePackage cp : set) {
			if (!done.contains(cp)) {
				changePackageResults.get(cp).setState(ChangePackageState.ERROR);
			}
		}
	}

	/**
	 * Performs checks of the branch on which the release is located.
	 * 
	 * @return a check entry for the branch of the release
	 */
	private CheckEntry checkReleaseBranch() {
		// If either the release branch or its location couldn't be calculated,
		// the commit cannot be inferred.
		if (releaseBranch == null || releaseRepoLoc == null) {
			return null;
		}

		// Retrieve the branch head
		String branchName = releaseBranch.getBranchName();
		String refName = "refs/heads/" + branchName;

		Ref ref = refMap.get(refName);
		if (ref == null) {
			addError(ERROR_RELEASE_BRANCH_NOT_FOUND);
			return null;
		}

		// parse the branch head as commit
		RevCommit c;
		try {
			c = revWalk.parseCommit(ref.getObjectId());
		} catch (MissingObjectException e) {
			addError(ERROR_MISSING_COMMIT, ref.getName());
			return null;
		} catch (IncorrectObjectTypeException e) {
			addError(ERROR_REF_IS_NO_COMMIT, ref.getName());
			return null;
		} catch (IOException e) {
			addError(ERROR_IO_EXCEPTION_WHILE_PARSING_COMMIT, ref.getName());
			return null;
		}

		// everything fine, create the check entry
		CheckEntry releaseBase = new CheckEntry();
		releaseBase.setRef(ref);
		releaseBase.setCommit(c);
		return releaseBase;
	}

	/**
	 * Calculates the merge state of commits belonging to change packages. The
	 * result of this method is a mapping from commit to change package state.
	 * This mapping is later used to infer the change package states of the
	 * change packages.
	 * 
	 * @param releaseBase check entry of the release branch head
	 * @param commitMapping mapping from commit to change packages which use
	 *            this commit as head revision
	 * @return mapping from commit to change package state
	 */
	private Map<RevCommit, ChangePackageState> calcMergeState(CheckEntry releaseBase, Map<RevCommit, List<ChangePackage>> commitMapping) {
		if (releaseBase == null) {
			return new HashMap<RevCommit, ChangePackageState>();
		}

		return new ChangePackageStateChecker(localRepo).checkStates(releaseBase.getCommit(), commitMapping.keySet());

	}

	private Map<RevCommit, List<ChangePackage>> checkForCommits(Map<GitBranch, ChangePackage> branchMap, Map<Ref, GitBranch> branchMapping) {
		Map<RevCommit, List<ChangePackage>> result = new HashMap<RevCommit, List<ChangePackage>>();

		for (Entry<Ref, GitBranch> e : branchMapping.entrySet()) {

			// Check that this ref is a valid commit
			Ref ref = e.getKey();
			RevCommit commit;
			try {
				commit = revWalk.parseCommit(ref.getObjectId());
			} catch (MissingObjectException e1) {
				addError(ERROR_MISSING_COMMIT, ref.getName());
				continue;
			} catch (IncorrectObjectTypeException e1) {
				addError(ERROR_REF_IS_NO_COMMIT, ref.getName());
				continue;
			} catch (IOException e1) {
				addError(ERROR_IO_EXCEPTION_WHILE_PARSING_COMMIT, ref.getName());
				continue;
			}

			// No error. Build the mapping for this commit
			ChangePackage changePackage = branchMap.get(e.getValue());
			List<ChangePackage> list = result.get(commit);
			if (list == null) {
				list = new ArrayList<ChangePackage>();
				result.put(commit, list);
			}
			list.add(changePackage);
			changePackageResults.get(changePackage).setCommit(commit);
		}

		return result;
	}

	/**
	 * Performs general release model specific checks like checking if the
	 * release has an associated branch. Only checks which do not need the local
	 * repository but only the unicase model are conducted here.
	 */
	private void checkReleaseModel() {

		try {
			RepositoryStream repoStream = ChangeTrackingUtil.getRepoStreamOfRelease(release);

			// Repo stream is a git branch?
			if (!(repoStream instanceof GitBranch)) {
				addError(ERROR_INCOMPATIBLE_REPO_STREAM, repoStream.getName());
				return;
			}
			releaseBranch = (GitBranch) repoStream;

			// Repo stream has a location?
			releaseRepoLoc = ChangeTrackingUtil.getRepoLocationOfRelease(release);
		} catch (ErrorInModelException m) {
			addError(m.getMessage());
		}

	}

	/**
	 * Perfroms per change package checks, which may reveal problems associated
	 * to them, like the change package being of the wrong type (no Git CP) or
	 * the branch of the package being missing.
	 * 
	 * Since this method infers the branch model element of the change packages,
	 * it is also used to save a mapping from change package to its branch and
	 * return this mapping for later use.
	 * 
	 * @param set set of change packages
	 * @return mapping from branch to the associated change package
	 */
	private Map<GitBranch, ChangePackage> checkChangePackages(Set<ChangePackage> set) {
		Map<GitBranch, ChangePackage> branchMap = new HashMap<GitBranch, ChangePackage>();
		RepositoryLocation lastLocation = null;
		for (ChangePackage cp : set) {

			// Only git branch change packages are allowed at the moment
			if (!(cp instanceof GitBranchChangePackage)) {
				addError(ERROR_INCOMPATIBLE_CHANGE_PACKAGE, cp.getName());
				continue;
			}

			// The branch may not be missing
			GitBranchChangePackage gbcp = (GitBranchChangePackage) cp;
			GitBranch branch = gbcp.getBranch();
			if (branch == null) {
				addError(ERROR_MISSING_BRANCH, cp.getName());
				continue;
			}

			// The branch needs a location
			RepositoryLocation location = branch.getLocation();
			if (location == null) {
				addError(ERROR_MISSING_LOCATION, branch.getName(), cp.getName());
				continue;
			}

			// All locations must match
			if (lastLocation != null && lastLocation != location) {
				addError(ERROR_DIFFERENT_LOCATIONS, location.getName(), lastLocation.getName());
				continue;
			}
			lastLocation = location;

			// Check that the locations of the branches match the location of
			// the release stream.
			if (releaseRepoLoc != null && location != releaseRepoLoc) {
				addError(ERROR_LOCATION_MISMATCH, lastLocation.getName(), releaseRepoLoc.getName());
			}

			// No two changepackages may use the same branch
			if (branchMap.containsKey(branch)) {
				addError(ERROR_DUPLICATE_BRANCH, branch.getName(), branchMap.get(branch).getName(), cp.getName());
				continue;
			}

			// No errors? Then add to branch map and to the result
			branchMap.put(branch, cp);
			changePackageResults.get(cp).setBranch(branch);

		}

		return branchMap;
	}

	/**
	 * Performs per branch checks. In this stage, the focus is laid on branches
	 * and their embodyment in the local repository. It is checked that the
	 * branch is properly represented in it.
	 * 
	 * The head revision of each branch is inferred in this step and saved in a
	 * map from head revision to its branch.
	 * 
	 * @param branchMap mapping from branches to change packages
	 * @return mapping from head revision to its branch
	 */
	private Map<Ref, GitBranch> checkLocalBranches(Map<GitBranch, ChangePackage> branchMap) {

		Map<Ref, GitBranch> map = new HashMap<Ref, GitBranch>();

		for (Entry<GitBranch, ChangePackage> e : branchMap.entrySet()) {
			GitBranch branch = e.getKey();
			String refName = "refs/heads/" + branch.getBranchName();

			// Check that the branch exists in the repo
			if (!refMap.containsKey(refName)) {
				addError(ERROR_BRANCH_NOT_IN_LOCAL_REPO, branch.getBranchName(), branch.getName(), e.getValue().getName());
				continue;
			}

			// Check for duplicate branch mappings
			Ref ref = refMap.get(refName);
			if (map.containsKey(ref)) {
				addError(ERROR_DUPLICATE_BRANCH_MAPPING, branch.getName(), map.get(ref).getName(), ref.getName());
				continue;
			}

			// Everything okay. So put it into the result
			map.put(ref, branch);
			changePackageResults.get(e.getValue()).setRef(ref);
		}

		return map;
	}

}
