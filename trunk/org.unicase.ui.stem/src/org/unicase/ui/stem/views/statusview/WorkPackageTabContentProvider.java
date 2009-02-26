/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.ArrayList;
import java.util.List;

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
 * This is the ContentProvider.
 * 
 * @author Shterev
 */

public class WorkPackageTabContentProvider extends AdapterFactoryContentProvider {
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

	/**
	 * Constructor.
	 * 
	 * @param key determines which column is shown.
	 */
	public WorkPackageTabContentProvider(String key) {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
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
		for (WorkItem wi : wis) {
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

}
