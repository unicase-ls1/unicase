package org.unicase.changetracking.release;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.model.changetracking.ChangePackage;

public class ReleaseCheckReport {


	private final List<Problem> problems;	
	private final List<ChangePackage> changePackages;
	private final Map<ChangePackage,BranchState> changePackageStates;
	
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

	public Map<ChangePackage, BranchState> getChangePackageStates() {
		return changePackageStates;
	}
	
	ReleaseCheckReport(List<ChangePackage> changePackages,
			List<Problem> errorMessages, boolean checkedOut) {
		this.problems = errorMessages;
		this.changePackages = changePackages;
		this.changePackageStates = new HashMap<ChangePackage, BranchState>();
		
		//All branches are erroneous
		for(ChangePackage cp : changePackages){
			changePackageStates.put(cp, BranchState.ERROR);
		}
	}
	
	ReleaseCheckReport(List<ChangePackage> changePackages,
			List<Problem> errorMessages, boolean checkedOut, boolean upToDate, Map<ChangePackage,BranchState> changePackageStates) {
		this.problems = errorMessages;
		this.changePackages = changePackages;
		this.changePackageStates = changePackageStates;
	}



}
