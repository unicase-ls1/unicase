package org.unicase.changetracking.release;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.Attachment;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.task.WorkItem;

public final class ReleaseUtil {

	private ReleaseUtil(){}
	
	public static Map<ChangePackage, WorkItem> getChangePackagesFromRelease(ChangeTrackingRelease release){
		LinkedHashMap<ChangePackage, WorkItem> result = new LinkedHashMap<ChangePackage, WorkItem>();
		EList<WorkItem> workItems = release.getIncludedWorkItems();
		for(WorkItem w : workItems){
			for(Attachment a : w.getAttachments()){
				if(a instanceof ChangePackage){
					result.put((ChangePackage) a,w);
				}
			}
		}
		return result;
	}
	
	public static List<WorkItem> getWorkItemsWithoutChangePackagesFromRelease(ChangeTrackingRelease release){
		List<WorkItem> result = new ArrayList<WorkItem>();
		EList<WorkItem> workItems = release.getIncludedWorkItems();
		outer: for(WorkItem w : workItems){
			for(Attachment a : w.getAttachments()){
				if(a instanceof ChangePackage){
					continue outer;
				}
			}
			result.add(w);
		}
		return result;
	}
	
	public static WorkItemStatistics getWorkItemStatisticsFromRelease(ChangeTrackingRelease release){
		List<ChangePackage> result = new ArrayList<ChangePackage>();
		EList<WorkItem> workItems = release.getIncludedWorkItems();
		int num = workItems.size();
		int numResolved = 0;
		for(WorkItem w : workItems){
			if(w.isResolved())
				numResolved++;
		}
		return new WorkItemStatistics(num, numResolved);
	}
	


	public static boolean workItemHasChangePackage(WorkItem workItem) {
		for(Attachment a : workItem.getAttachments()){
			if(a instanceof ChangePackage){
				return true;
			}
		}
		return false;
	}
	
}
