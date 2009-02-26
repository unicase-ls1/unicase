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
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * This is the ContentProvider.
 * 
 * @author Shterev
 */

public class WorkPackageTabContentProvider extends AdapterFactoryContentProvider {
	/**
	 * Constant for the unassigned column.
	 */
	public static final String UNASSIGNED = "unassigned";
	/**
	 * Constant for the assigned column.
	 */
	public static final String ASSIGNED = "assigned";
	/**
	 * Constant for the blocked column.
	 */
	public static final String BLOCKED = "blocked";
	/**
	 * Constant for the done column.
	 */
	public static final String DONE = "done";
	/**
	 * Column for the testing column.
	 */
	public static final String TESTING = "testing";

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
			if (wi instanceof WorkPackage) {
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
		if (!((Checkable) wi).isChecked() && wi.getAssignee() == null && wi.getParticipants().isEmpty()
			&& wi.getPredecessors().isEmpty()) {
			ret.add(wi);
		}
	}

	private void handleDoneColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (((Checkable) wi).isChecked()) {
			ret.add(wi);
		}
	}

	private void handleTestingColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (!wi.getParticipants().isEmpty() && !((Checkable) wi).isChecked() && wi.getPredecessors().isEmpty()) {
			ret.add(wi);
		}
	}

	private void handleBlockedColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (!wi.getPredecessors().isEmpty() && !((Checkable) wi).isChecked()) {
			ret.add(wi);
		}
	}

	private void handleAssigneColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (wi.getAssignee() != null && wi.getParticipants().isEmpty() && !((Checkable) wi).isChecked()
			&& wi.getPredecessors().isEmpty()) {
			ret.add(wi);
		}
	}

}
