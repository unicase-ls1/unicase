/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.Attachment;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.Release;
import org.unicase.model.task.WorkItem;

/**
 * 
 * A content provider for the check release views. It provides the contents of a
 * release as a tree like structure:
 * 
 * The release is the root. Its children are the included work items and their
 * children are the attached change packages.
 * 
 * The content can be configured by leaving out the root (i.e. the release)
 * and/or the work items (thus just showing the change packages.
 * 
 * @author jfinis
 * 
 */
public class FullReleaseContentProvider implements ITreeContentProvider {

	private static final Object[] EMPTY = new Object[0];

	/**
	 * Whether the root (the release) is to be shown.
	 */
	private boolean showRoot;

	/**
	 * Whether work items are to be shown.
	 */
	private boolean showWorkItems = true;

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Release) {
			EList<WorkItem> workItems = ((Release) parentElement).getIncludedWorkItems();
			if (showWorkItems) {
				return workItems.toArray();
			} else {
				ArrayList<Object> result = new ArrayList<Object>();
				for (WorkItem o : workItems) {
					Object[] children = getChildren(o);
					for (Object o2 : children) {
						result.add(o2);
					}
				}
				return result.toArray();
			}
		} else if (parentElement instanceof WorkItem) {
			EList<Attachment> list = ((WorkItem) parentElement).getAttachments();
			List<ChangePackage> result = new ArrayList<ChangePackage>();
			for (Attachment a : list) {
				if (a instanceof ChangePackage) {
					result.add((ChangePackage) a);
				}
			}
			return result.toArray();
		}
		return EMPTY;
	}

	/**
	 * 
	 * Parent retrieval is not supported by this provider.
	 * 
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof Release) {
			EList<WorkItem> workItems = ((Release) element).getIncludedWorkItems();
			if (showWorkItems) {
				return !workItems.isEmpty();
			} else {
				for (WorkItem w : workItems) {
					if (hasChildren(w)) {
						return true;
					}
				}
				return false;
			}
		} else if (element instanceof WorkItem) {
			EList<Attachment> list = ((WorkItem) element).getAttachments();
			for (Attachment a : list) {
				if (a instanceof ChangePackage) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Object[]) {
			Object[] input = (Object[]) inputElement;
			if (showRoot) {
				return input;
			} else if (input.length == 0) {
				return null;
			} else if (input.length == 1) {
				return getChildren(input[0]);
			} else {
				ArrayList<Object> result = new ArrayList<Object>();
				for (Object o : input) {
					Object[] children = getChildren(o);
					for (Object o2 : children) {
						result.add(o2);
					}
				}
				return result.toArray();
			}
		}
		return EMPTY;
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {}

	/**
	 * This provider does not respond to input changes because the input does
	 * not change during the checking of a release.
	 * 
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

	/**
	 * Whether the root of the tree (the release) is to be shown.
	 * 
	 * @param show whether to show the release
	 */
	public void setShowRoot(boolean show) {
		showRoot = show;
	}

	/**
	 * Whether to show work items. If false is used, then the change packages
	 * are shown as direct descendants of the root, instead of descendants of
	 * the work package.
	 * 
	 * @param show whether to show work items
	 */
	public void setShowWorkItems(boolean show) {
		showWorkItems = show;
	}

}
