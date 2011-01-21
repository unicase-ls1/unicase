package org.unicase.changetracking.release;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jgit.revwalk.RevCommit;
import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.model.changetracking.ChangePackage;

public class ReleaseCheckReport {


	private final List<Problem> problems;	
	private final List<ChangePackage> changePackages;
	private final Map<ChangePackage,ChangePackageCheckEntry> changePackageResults;
	
	private final CheckEntry releaseBase;
	
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

	public List<ChangePackage> getChangePackages() {
		return changePackages;
	}

	public Map<ChangePackage, ChangePackageCheckEntry> getChangePackageResults() {
		return changePackageResults;
	}
	
	ReleaseCheckReport(List<ChangePackage> changePackages,
			List<Problem> errorMessages, boolean checkedOut) {
		this.problems = errorMessages;
		this.changePackages = changePackages;
		this.changePackageResults = new HashMap<ChangePackage, ChangePackageCheckEntry>();
		this.releaseBase = null;
		//All branches are erroneous
		for(ChangePackage cp : changePackages){
			ChangePackageCheckEntry entry = new ChangePackageCheckEntry(cp);
			entry.setState(BranchState.ERROR);
			changePackageResults.put(cp, entry);
		}
	}
	
	ReleaseCheckReport(List<ChangePackage> changePackages,
			List<Problem> errorMessages, boolean checkedOut, boolean upToDate, CheckEntry releaseBase, HashMap<ChangePackage, ChangePackageCheckEntry> resultMap) {
		this.problems = errorMessages;
		this.changePackages = changePackages;
		this.changePackageResults = resultMap;
		this.releaseBase = releaseBase;
}



}
