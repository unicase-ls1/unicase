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

public class WorkPackageStatusContentProvider extends AdapterFactoryContentProvider {

	private WorkPackage root;

	public static final String UNASSIGNED = "unassigned";
	public static final String ASSIGNED = "assigned";
	public static final String BLOCKED = "blocked";
	public static final String DONE = "done";
	public static final String TESTING = "testing";

	private String key;

	/**
	 * Constructor.
	 */
	public WorkPackageStatusContentProvider(String key) {
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
			if (key.equals(ASSIGNED)) {
				if (wi.getAssignee() != null && wi.getParticipants().isEmpty() && !((Checkable) wi).isChecked()
					&& wi.getPredecessors().isEmpty()) {
					ret.add(wi);
				}
			} else if (key.equals(BLOCKED)) {
				if (!wi.getPredecessors().isEmpty() && !((Checkable) wi).isChecked()) {
					ret.add(wi);
				}
			} else if (key.equals(TESTING)) {
				if (!wi.getParticipants().isEmpty() && !((Checkable) wi).isChecked() && wi.getPredecessors().isEmpty()) {
					ret.add(wi);
				}
			} else if (key.equals(DONE)) {
				if (((Checkable) wi).isChecked()) {
					ret.add(wi);
				}
			} else if (key.equals(UNASSIGNED)) {
				if (!((Checkable) wi).isChecked() && wi.getAssignee() == null && wi.getParticipants().isEmpty()
					&& wi.getPredecessors().isEmpty()) {
					ret.add(wi);
				}
			}
		}
		return ret.toArray();
	}

}
