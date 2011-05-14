package org.unicase.changetracking.git.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.unicase.model.Attachment;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.task.WorkItem;

public class RenameThisClass {

	public void getANameForThisMethod(ChangeTrackingRelease release){
		EList<WorkItem> workItems = release.getIncludedWorkItems();
		List<ChangePackage> changePackages = new ArrayList<ChangePackage>();
		for(WorkItem w: workItems){
			EList<Attachment> attachments = w.getAttachments();
			for(Attachment a: attachments){
				if(a instanceof ChangePackage){
					changePackages.add((ChangePackage) a);
				}
			}
		}
		
	}
}
