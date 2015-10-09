/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;

/**
 * This is the ContentProvider for the sprint status view.
 * 
 * @author Shterev
 */

public class SprintStatusContentProvider extends AdapterFactoryContentProvider {
	/**
	 * Constant for the unassigned column.
	 */
	public static final String UNASSIGNED = "Unassigned";
	/**
	 * Constant for the assigned column.
	 */
	public static final String ASSIGNED = "Assigned";
	/**
	 * Constant for the blocked column.
	 */
	public static final String BLOCKED = "Blocked";
	/**
	 * Constant for the done column.
	 */
	public static final String DONE = "Done";
	/**
	 * Column for the testing column.
	 */
	public static final String TESTING = "Testing";

	private String key;
	private SprintItemComparator sprintItemComparator;
	private List<Comparator<WorkItem>> comparators;
	private List<SprintFilter> filters;
	private EReference userReference;
	private int userComparatorIndex = Integer.MAX_VALUE;

	/**
	 * Compares two WorkItems by their priority.
	 * 
	 * @author Shterev
	 */
	private final class SprintItemComparator implements Comparator<WorkItem> {

		public int compare(WorkItem o1, WorkItem o2) {
			for (Comparator<WorkItem> c : comparators) {
				int ret = c.compare(o1, o2);
				if (ret != 0) {
					return ret;
				}
			}
			return 0;
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param key determines which column is shown.
	 */
	public SprintStatusContentProvider(String key) {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		comparators = new ArrayList<Comparator<WorkItem>>();
		filters = new ArrayList<SprintFilter>();
		sprintItemComparator = new SprintItemComparator();
		this.key = key;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object object) {
		ArrayList<WorkItem> ret = new ArrayList<WorkItem>();
		if (!(object instanceof WorkPackage)) {
			return new Object[0];
		}
		WorkPackage wp = (WorkPackage) object;
		List<WorkItem> wis = wp.getAllContainedWorkItems();
		workitems: for (WorkItem wi : wis) {
			for (SprintFilter f : filters) {
				if (!f.accept(wi)) {
					continue workitems;
				}
			}
			if (!(wi instanceof Checkable)) {
				continue;
			}
			if (key.equals(ASSIGNED)) {
				handleAssigneColumn(ret, wi);
			} else if (key.equals(BLOCKED)) {
				handleBlockedColumn(ret, wi);
			} else if (key.equals(TESTING)) {
				handleTestingColumn(ret, wi);
			} else if (key.equals(DONE)) {
				handleDoneColumn(ret, wi);
			} else if (key.equals(UNASSIGNED)) {
				handleUnassignedColumn(ret, wi);
			}
		}
		Collections.sort(ret, sprintItemComparator);
		return ret.toArray();
	}

	private void handleUnassignedColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (isUnassigned(wi)) {
			ret.add(wi);
		}
	}

	private boolean isUnassigned(WorkItem wi) {
		OrgUnit assignee = wi.getAssignee();
		if (assignee == null) {
			return true;
		}
		if (assignee instanceof Group) {
			return true;
		}
		return false;
	}

	private void handleDoneColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (isUnassigned(wi)) {
			return;
		}
		if (((Checkable) wi).isChecked()) {
			ret.add(wi);
		}
	}

	private void handleTestingColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (isUnassigned(wi)) {
			return;
		}
		if (((Checkable) wi).isChecked()) {
			return;
		}
		if (isBlocked(wi)) {
			return;
		}

		if (!(wi.getReviewer() == null) && wi.isResolved()) {
			ret.add(wi);
		}
	}

	private void handleBlockedColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (isUnassigned(wi)) {
			return;
		}
		if (((Checkable) wi).isChecked()) {
			return;
		}
		if (isBlocked(wi)) {
			ret.add(wi);
		}
	}

	private boolean isBlocked(WorkItem wi) {
		String status;
		try {
			status = wi.getMEState().getStatus();
		} catch (CircularDependencyException e) {
			status = MEState.CLOSED;
		}
		return (status.equals(MEState.BLOCKED));
	}

	private void handleAssigneColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (isUnassigned(wi)) {
			return;
		}
		if (((Checkable) wi).isChecked()) {
			return;
		}
		if (isBlocked(wi)) {
			return;
		}
		if (!(wi.isResolved()) || (wi.getReviewer() == null)) {
			ret.add(wi);
		}
	}

	/**
	 * Getter.
	 * 
	 * @return the key.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Adds a new comparator to the content provider.
	 * 
	 * @param comparator the comparator.
	 * @param index the priority for this comparator (0 being the highest).
	 */
	public void addComparator(int index, Comparator<WorkItem> comparator) {
		comparators.add(index, comparator);
		if (comparator instanceof UserComparator) {
			if (index < userComparatorIndex) {
				userReference = ((UserComparator) comparator).getUserReference();
				userComparatorIndex = index;
			}
		}
	}

	/**
	 * @return The reference the user comparator for this category is based upon. If no user comparator has been set, a
	 *         null will be returned.
	 */
	public EReference getUserReference() {
		return userReference;
	}

	/**
	 * Adds a new filter to the content provider.
	 * 
	 * @param filter the filter.
	 */
	public void addFilter(SprintFilter filter) {
		filters.add(filter);
	}

	/**
	 * Removes a filter from the content provider.
	 * 
	 * @param filter the filter.
	 */
	public void removeFilter(SprintFilter filter) {
		filters.remove(filter);
	}

	/**
	 * Removes a comparator from the content provider.
	 * 
	 * @param comparator the comparator.
	 */
	public void removeComparator(Comparator<WorkItem> comparator) {
		comparators.remove(comparator);
	}

}
