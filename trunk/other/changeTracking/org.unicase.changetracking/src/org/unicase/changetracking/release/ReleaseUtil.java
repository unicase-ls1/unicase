/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.release;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.Attachment;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.Release;
import org.unicase.model.task.WorkItem;

/**
 * Utility class for release checking and building.
 * 
 * @author jfinis
 * 
 */
public final class ReleaseUtil {

	private ReleaseUtil() {}

	/**
	 * Gets all change package of a release by following the transitive link
	 * from release to work item to change package.
	 * 
	 * The result is a mapping from change package to work item stating which
	 * change package is associated to which work item. If a change package is
	 * associated to more than one work item in the release, only one of them is
	 * shown in the mapping.
	 * 
	 * @param release the release
	 * @return a mapping from change package to work item
	 */
	public static Map<ChangePackage, WorkItem> getChangePackagesFromRelease(Release release) {
		LinkedHashMap<ChangePackage, WorkItem> result = new LinkedHashMap<ChangePackage, WorkItem>();
		EList<WorkItem> workItems = release.getIncludedWorkItems();
		for (WorkItem w : workItems) {
			for (Attachment a : w.getAttachments()) {
				if (a instanceof ChangePackage) {
					result.put((ChangePackage) a, w);
				}
			}
		}
		return result;
	}

	/**
	 * Returns a list of included work items from a release. Only work items
	 * which do not have attached change packages are included.
	 * 
	 * @param release the release
	 * @return list of work items without change packages
	 */
	public static List<WorkItem> getWorkItemsWithoutChangePackagesFromRelease(Release release) {
		List<WorkItem> result = new ArrayList<WorkItem>();
		EList<WorkItem> workItems = release.getIncludedWorkItems();
		outer: for (WorkItem w : workItems) {
			for (Attachment a : w.getAttachments()) {
				if (a instanceof ChangePackage) {
					continue outer;
				}
			}
			result.add(w);
		}
		return result;
	}

	/**
	 * Builds work item statistics from a release. The statistics contain the
	 * number of work item and the number of resolved ones.
	 * 
	 * @param release the release
	 * @return work item statistics
	 */
	public static WorkItemStatistics getWorkItemStatisticsFromRelease(Release release) {
		EList<WorkItem> workItems = release.getIncludedWorkItems();
		int num = workItems.size();
		int numResolved = 0;
		for (WorkItem w : workItems) {
			if (w.isResolved()) {
				numResolved++;
			}
		}
		return new WorkItemStatistics(num, numResolved);
	}

	/**
	 * Returns whether a work item has at least one change package attached.
	 * 
	 * @param workItem a work item
	 * @return whether at least one change package is attached
	 */
	public static boolean workItemHasChangePackage(WorkItem workItem) {
		for (Attachment a : workItem.getAttachments()) {
			if (a instanceof ChangePackage) {
				return true;
			}
		}
		return false;
	}

}
