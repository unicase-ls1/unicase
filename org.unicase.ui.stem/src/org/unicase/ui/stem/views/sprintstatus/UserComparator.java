/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import java.util.Comparator;

import org.eclipse.emf.ecore.EReference;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.task.WorkItem;

/**
 * Compares two work items acc. to the name of their user.
 * 
 * @author Shterev
 */
public class UserComparator implements Comparator<WorkItem> {

	private EReference ref;

	/**
	 * Default constructor.
	 * 
	 * @param ref the {@link EReference} - e.g. the Assignee reference or the Reviewer reference.
	 */
	public UserComparator(EReference ref) {
		if (!OrganizationPackage.eINSTANCE.getOrgUnit().isSuperTypeOf(ref.getEReferenceType())) {
			throw new IllegalArgumentException("This filter accepts ONLY references of type OrgUnit!");
		}
		this.ref = ref;
	}

	/**
	 * {@inheritDoc}
	 */
	public int compare(WorkItem o1, WorkItem o2) {
		OrgUnit user1 = (OrgUnit) o1.eGet(ref);
		OrgUnit user2 = (OrgUnit) o2.eGet(ref);
		if (user1 == null && user2 == null) {
			return 0;
		} else if (user1 == null) {
			return 1;
		} else if (user2 == null) {
			return -1;
		}
		return user1.getName().compareTo(user2.getName());

	}

	/**
	 * @return the user reference this comparator is base upon.
	 */
	public EReference getUserReference() {
		return ref;
	}
}
