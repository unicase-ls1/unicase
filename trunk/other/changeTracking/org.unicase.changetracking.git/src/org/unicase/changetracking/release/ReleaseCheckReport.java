package org.unicase.changetracking.release;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.jgit.revwalk.RevCommit;
import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.model.changetracking.ChangePackage;

public class ReleaseCheckReport {


	private final List<Problem> problems;	
	private final Set<ChangePackage> changePackages;
	private final Map<ChangePackage,ChangePackageCheckEntry> changePackageResults;
	
	private final CheckEntry releaseBase;
	private final WorkItemStatistics workItemStats;
	
	public WorkItemStatistics getWorkItemStats() {
		return workItemStats;
	}

	public CheckEntry getReleaseBase() {
		return releaseBase;
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

	public Set<ChangePackage> getChangePackages() {
		return changePackages;
	}

	public Map<ChangePackage, ChangePackageCheckEntry> getChangePackageResults() {
		return changePackageResults;
	}
	
	ReleaseCheckReport(WorkItemStatistics workItemStats, Set<ChangePackage> set,
			List<Problem> errorMessages, boolean checkedOut) {
		this.problems = errorMessages;
		this.changePackages = set;
		this.changePackageResults = new HashMap<ChangePackage, ChangePackageCheckEntry>();
		this.releaseBase = null;
		this.workItemStats = workItemStats;
		//All branches are erroneous
		for(ChangePackage cp : set){
			ChangePackageCheckEntry entry = new ChangePackageCheckEntry(cp);
			entry.setState(BranchState.ERROR);
			changePackageResults.put(cp, entry);
		}
	}
	
	ReleaseCheckReport(WorkItemStatistics workItemStats, Set<ChangePackage> changePackages,
			List<Problem> errorMessages, boolean checkedOut, boolean upToDate, CheckEntry releaseBase, HashMap<ChangePackage, ChangePackageCheckEntry> resultMap) {
		this.problems = errorMessages;
		this.changePackages = changePackages;
		this.changePackageResults = resultMap;
		this.releaseBase = releaseBase;
		this.workItemStats = workItemStats;
}
	
	public int getNumChangePackagesOfState(BranchState state){
		int result = 0;
		for(Entry<ChangePackage, ChangePackageCheckEntry> e : changePackageResults.entrySet()){
			ChangePackageCheckEntry entry = e.getValue();
			if(entry.getState() == state){
				
				result++;
			}
		}
		return result;
	}



}
