/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.util.TaxonomyAccess;

/**
 * Content Provider for the activity centric view.
 * 
 * @author helming
 */
public class ActivityTabContentProvider extends AdapterFactoryContentProvider {
	private UnicaseModelElement root;

	/**
	 * Default constructor.
	 */
	public ActivityTabContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof ActivityType) {
			return getActivity((ActivityType) object).toArray();
		}
		return super.getChildren(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object object) {
		Set<ActivityType> ret = new HashSet<ActivityType>();
		ActivityType[] values = ActivityType.values();
		for (ActivityType activityType : values) {
			ret.add(activityType);
		}
		Object[] array = ret.toArray(new Object[ret.size()]);
		return array;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof ActivityType) {
			return getActivity((ActivityType) object).size() > 0;
		}
		return false;
	}

	private Set<Checkable> getActivity(ActivityType activityType) {
		Set<Checkable> ret = new HashSet<Checkable>();
		Set<UnicaseModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(root);
		for (UnicaseModelElement opener : openers) {
			if (opener instanceof Checkable) {
				if (opener instanceof BugReport) {
					if (activityType.equals(ActivityType.IMPLEMENTATION)) {
						ret.add((Checkable) opener);
					}
				}
				if (opener instanceof ActionItem) {
					if (((ActionItem) opener).getActivity().equals(activityType)) {
						ret.add((Checkable) opener);
					}
				}
				if (opener instanceof Issue) {
					if (((Issue) opener).getActivity().equals(activityType)) {
						ret.add((Checkable) opener);
					}
				}
			}
		}

		return ret;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);

		// keep track of input to status view
		this.root = (UnicaseModelElement) newInput;
	}

}
