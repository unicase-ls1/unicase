/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;

/**
 * This is the label provider for status column on user tab of status view.
 * 
 * @author Hodaie
 */
public class UserTabStatusColumnLabelProvider extends ColumnLabelProvider {

	private UnicaseModelElement currentOpenME;
	private Map<String, Image> images;
	private static final String OPEN = "open";
	private static final String CLOSED = "closed";
	private static final String BLOCKED = "blocked";
	private static final String OPEN_RESOLVED = "open_resolved";

	/**
	 * Constructor.
	 */
	public UserTabStatusColumnLabelProvider() {
		images = new HashMap<String, Image>();

		String path = "icons/open.png";
		URL url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path(path), null);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(OPEN, imageDescriptor.createImage());

		path = "icons/closed.gif";
		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path(path), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(CLOSED, imageDescriptor.createImage());

		path = "icons/blocked.gif";
		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path(path), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(BLOCKED, imageDescriptor.createImage());

		path = "icons/open_resolved.png";
		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path(path), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(OPEN_RESOLVED, imageDescriptor.createImage());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {

		images.get(OPEN).dispose();
		images.get(CLOSED).dispose();
		images.get(BLOCKED).dispose();
		images.get(OPEN_RESOLVED).dispose();

		images.clear();

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof UnicaseModelElement) {
			UnicaseModelElement me = (UnicaseModelElement) element;
			String status = MEState.CLOSED;
			try {

				if (me instanceof OrgUnit) {
					status = getStatus((OrgUnit) me);
				} else {
					status = me.getMEState().getStatus();
				}

			} catch (CircularDependencyException e) {
				ModelUtil.logException(e);
			}

			if (status.equals(MEState.OPEN)) {
				if (me instanceof WorkItem && ((WorkItem) me).isResolved()) {
					return images.get(OPEN_RESOLVED);
				}
				return images.get(OPEN);

			} else if (status.equals(MEState.CLOSED)) {
				return images.get(CLOSED);

			} else if (status.equals(MEState.BLOCKED)) {
				return images.get(BLOCKED);
			}

		}
		return null;
	}

	private String getStatus(OrgUnit assignee) {

		for (WorkItem workItem : getWorkItems(assignee)) {

			if (workItem.getState() == MEState.BLOCKED) {
				return MEState.BLOCKED;
			}
		}
		for (WorkItem workItem : getWorkItems(assignee)) {

			if (workItem.getState() == MEState.OPEN) {
				return MEState.OPEN;
			}
		}

		return MEState.CLOSED;
	}

	/**
	 * This goes through openers hierarchy and gathers all Assignables assigned
	 * to this Assignee. I think it would be more convenient to change the
	 * model, so that any OrgUnit maintains a list of all its assigned tasks.
	 * 
	 * @param assignee
	 *            OrgUnit assignee
	 * @return
	 */
	private List<WorkItem> getWorkItems(OrgUnit assignee) {

		List<WorkItem> workItems = new ArrayList<WorkItem>();
		// then check its openers (hierarchical)
		Set<UnicaseModelElement> openers = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getLeafOpeners(currentOpenME);
		for (UnicaseModelElement opener : openers) {
			if (opener instanceof WorkItem) {
				OrgUnit assignee2 = ((WorkItem) opener).getAssignee();
				if (assignee2 != null && assignee.equals(assignee2)) {
					workItems.add((WorkItem) opener);
				}
			}
		}
		return workItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return "";

	}

	/**
	 * This keeps track of model element currently open in status view. This is
	 * used to extract work items each user has relating this currently model
	 * element.
	 * 
	 * @param me
	 *            Model element that is currently open in status view.
	 */
	public void setCurrentOpenME(UnicaseModelElement me) {
		this.currentOpenME = me;
	}

}
