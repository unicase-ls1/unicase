/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.TaxonomyAccess;

/**
 * This is the ContentProvider for Users tab.
 * 
 * @author helming
 */
public class UserTabContentProvider extends AdapterFactoryContentProvider {

	// input model element to status view
	private UnicaseModelElement root;

	/**
	 * @return the root
	 */
	public UnicaseModelElement getRoot() {
		return root;
	}

	/**
	 * Constructor.
	 */
	public UserTabContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object object) {
		Object[] assignees = getAssignees(object);
		List<Object> ret = new ArrayList<Object>();
		ret.add(new NotAssigned());
		for (Object o : assignees) {
			ret.add(o);
		}

		return ret.toArray();
	}

	/**
	 * This returns a recursive list of all OrgUnits participating in progress of a model element.
	 * 
	 * @param object input model element
	 * @return
	 */
	private Object[] getAssignees(Object object) {
		Set<OrgUnit> ret = new HashSet<OrgUnit>();
		if (object instanceof UnicaseModelElement) {
			UnicaseModelElement me = (UnicaseModelElement) object;
			// then check its openers (the openers are considered hierarchical)
			Set<UnicaseModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(me);
			for (UnicaseModelElement opener : openers) {
				if (opener instanceof Checkable && opener instanceof WorkItem) {
					OrgUnit assignee = ((WorkItem) opener).getAssignee();
					if (assignee != null) {
						ret.add(assignee);
					}
				}
			}
		}

		return ret.toArray(new Object[ret.size()]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof NotAssigned) {
			return TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getUnassignedWorkItems(root).size() > 0;
		}
		if (object instanceof OrgUnit) {
			return TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getWorkItems(root, (OrgUnit) object).size() > 0;
		} else {
			return super.hasChildren(object);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof NotAssigned) {
			Set<Checkable> unassignedWorkItems = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
				.getUnassignedWorkItems(root);
			return unassignedWorkItems.toArray(new Object[unassignedWorkItems.size()]);
		}
		if (object instanceof OrgUnit) {
			Set<Checkable> workItems = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getWorkItems(root,
				(OrgUnit) object);
			return workItems.toArray(new Object[workItems.size()]);

		} else {
			return super.getChildren(object);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		super.inputChanged(viewer, oldInput, newInput);

		// keep track of input to status view
		// this will be used in getAssignables() method
		this.root = (UnicaseModelElement) newInput;
	}

}
