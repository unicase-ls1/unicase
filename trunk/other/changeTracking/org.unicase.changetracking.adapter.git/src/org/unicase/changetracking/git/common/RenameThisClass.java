/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
