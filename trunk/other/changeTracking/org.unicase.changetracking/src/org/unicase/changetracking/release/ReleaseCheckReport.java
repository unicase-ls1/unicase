/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.release;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryLocation;

/**
 * A release check report is the result of a release checking operation.
 * 
 * It features:
 * - the list of problems found
 * - the states of the change packages (i.e. merged, unmerged or erroneous)
 * - a statistics about how many work items of the release are already resolved.
 * - a repository location where the release is located.
 * 
 * @author gex
 *
 */
public class ReleaseCheckReport {


	private final List<Problem> problems;	
	private final Map<ChangePackage,ChangePackageState> changePackageResults;
	
	private final WorkItemStatistics workItemStats;
	private RepositoryLocation repoLoc;
	
	/**
	 * Returns the work item statistics.
	 * @return work item statistics
	 */
	public WorkItemStatistics getWorkItemStats() {
		return workItemStats;
	}


	/**
	 * Returns the list of problems.
	 * The returned list is unmodifiable.
	 * @return list of problems.
	 */
	public List<Problem> getProblems() {
		return Collections.unmodifiableList(problems);
	}
	
	/**
	 * Returns true if any problem which is an error is in this report.
	 * @return whether an error occurred
	 */
	public boolean hasErrors(){
		for(Problem p : problems){
			if(p.getSeverity() == Severity.ERROR){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns true if any problem which is an warning is in this report.
	 * @return whether a warning occurred
	 */
	public boolean hasWarnings(){
		for(Problem p : problems){
			if(p.getSeverity() == Severity.WARNING){
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the change package results as a map from change package
	 * to its result.
	 * The returned map is unmodifiable.
	 * @return change package results.
	 */
	public Map<ChangePackage, ChangePackageState> getChangePackageResults() {
		return Collections.unmodifiableMap(changePackageResults);
	}
	
	/**
	 * Constructor for reports for which an error prevented the status retrieval
	 * of the change packages. Therefore, all change packages are flagged with the
	 * ERROR status.
	 * 
	 * @param repoLoc repository location of the release
	 * @param workItemStats work item statistics
	 * @param set change packages in the release
	 * @param errorMessages problems
	 * @param checkedOut currently not used
	 */
	public ReleaseCheckReport(RepositoryLocation repoLoc, WorkItemStatistics workItemStats, Set<ChangePackage> set,
			List<Problem> errorMessages, boolean checkedOut) {
		this.repoLoc = repoLoc;
		this.problems = errorMessages;
		this.changePackageResults = new HashMap<ChangePackage, ChangePackageState>();
		this.workItemStats = workItemStats;
		//All branches are erroneous
		for(ChangePackage cp : set) {
			changePackageResults.put(cp, ChangePackageState.ERROR);
		}
	}
	
	/**
	 * Standard constructor.
	 * @param repoLoc repository location of the release
	 * @param workItemStats work item statistics
	 * @param errorMessages list of problems
	 * @param checkedOut currently not used
	 * @param upToDate whether the source code was updated before the checking
	 * @param resultMap the change package results
	 */
	public ReleaseCheckReport(RepositoryLocation repoLoc, WorkItemStatistics workItemStats, List<Problem> errorMessages, boolean checkedOut, boolean upToDate, HashMap<ChangePackage, ChangePackageState> resultMap) {
		this.problems = errorMessages;
		this.repoLoc = repoLoc;
		this.changePackageResults = resultMap;
		this.workItemStats = workItemStats;
	}
	
	
	/**
	 * Counts the number of change packages in a given state.
	 * @param state change package state
	 * @return number of packages with that state
	 */
	public int getNumChangePackagesOfState(ChangePackageState state){
		int result = 0;
		for(Entry<ChangePackage, ChangePackageState> e : changePackageResults.entrySet()){
			if(e.getValue() == state){
				result++;
			}
		}
		return result;
	}

	
	/**
	 * Retrieves the repository location of the release.
	 * @return repository location
	 */
	public RepositoryLocation getRepoLocation() {
		return repoLoc;
	}



}
