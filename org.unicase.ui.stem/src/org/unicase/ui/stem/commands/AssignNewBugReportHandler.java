/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.commands;

import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * This is the handler for assign new bug report command in status view.
 * 
 * @author Hodaie
 */
public class AssignNewBugReportHandler extends AssignWorkItemHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.stem.commands.AssignWorkItemHandler#assignWorkItem(org.unicase.model.UnicaseModelElement,
	 *      org.unicase.model.organization.OrgUnit,
	 *      org.unicase.metamodel.Project)
	 */
	@Override
	protected WorkItem assignWorkItem(UnicaseModelElement currentOpenME,
			OrgUnit user, Project project) {
		BugReport br = BugFactory.eINSTANCE.createBugReport();

		if (currentOpenME instanceof WorkPackage) {
			((WorkPackage) currentOpenME).getContainedWorkItems().add(br);
		} else {
			project.addModelElement(br);
			currentOpenME.getAnnotations().add(br);
		}
		br.setName("New bug report relating " + currentOpenME.getName());
		br.setAssignee(user);
		return br;
	}
}
