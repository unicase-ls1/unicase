package org.unicase.changetracking.release;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryLocation;

public class ReleaseCheckReport {


	private final List<Problem> problems;	
	private final Map<ChangePackage,ChangePackageState> changePackageResults;
	
	private final WorkItemStatistics workItemStats;
	private RepositoryLocation repoLoc;
	
	public WorkItemStatistics getWorkItemStats() {
		return workItemStats;
	}


	public List<Problem> getProblems() {
		return problems;
	}
	
	public boolean hasErrors(){
		for(Problem p : problems){
			if(p.getSeverity() == Severity.ERROR){
				return true;
			}
		}
		return false;
	}
	
	public boolean hasWarnings(){
		for(Problem p : problems){
			if(p.getSeverity() == Severity.WARNING){
				return true;
			}
		}
		return false;
	}

	public Map<ChangePackage, ChangePackageState> getChangePackageResults() {
		return changePackageResults;
	}
	
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
	
	public ReleaseCheckReport(RepositoryLocation repoLoc, WorkItemStatistics workItemStats, List<Problem> errorMessages, boolean checkedOut, boolean upToDate, HashMap<ChangePackage, ChangePackageState> resultMap) {
		this.problems = errorMessages;
		this.repoLoc = repoLoc;
		this.changePackageResults = resultMap;
		this.workItemStats = workItemStats;
}
	
	public int getNumChangePackagesOfState(ChangePackageState state){
		int result = 0;
		for(Entry<ChangePackage, ChangePackageState> e : changePackageResults.entrySet()){
			if(e.getValue() == state){
				result++;
			}
		}
		return result;
	}


	public RepositoryLocation getRepoLocation() {
		return repoLoc;
	}



}
