package org.unicase.changetracking.release;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jgit.lib.Ref;
import org.unicase.model.Attachment;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.task.WorkItem;

public final class ReleaseUtil {

	private ReleaseUtil(){}
	
	public static List<ChangePackage> getChangePackagesFromRelease(ChangeTrackingRelease release){
		List<ChangePackage> result = new ArrayList<ChangePackage>();
		EList<WorkItem> workItems = release.getIncludedWorkItems();
		for(WorkItem w : workItems){
			for(Attachment a : w.getAttachments()){
				if(a instanceof ChangePackage){
					result.add((ChangePackage) a);
				}
			}
		}
		return result;
	}
	
	public static List<Ref> buildMergeSetFromReport(ReleaseCheckReport report){
		List<Ref> mergeList = new ArrayList<Ref>();
		
		Map<ChangePackage, ChangePackageCheckEntry> results = report.getChangePackageResults();
		for(Entry<ChangePackage, ChangePackageCheckEntry> e : results.entrySet()){
			ChangePackageCheckEntry result = e.getValue();
			if(result.getState() == BranchState.UNMERGED){
				mergeList.add(result.getRef());
			}
		}
		
		return mergeList;
	}
	
}
