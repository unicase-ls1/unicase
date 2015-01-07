/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.commands;

import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * This is the handler for assign new action item command in status view.
 * 
 * @author Hodaie
 */
public class AssignNewActionItemHandler extends AssignWorkItemHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.stem.commands.AssignWorkItemHandler#assignWorkItem(org.unicase.model.UnicaseModelElement,
	 *      org.unicase.model.organization.OrgUnit, org.unicase.metamodel.Project)
	 */
	protected WorkItem assignWorkItem(UnicaseModelElement currentOpenME, OrgUnit user,
		org.eclipse.emf.emfstore.common.model.Project project) {
		ActionItem ai = TaskFactory.eINSTANCE.createActionItem();

		if (currentOpenME instanceof WorkPackage) {
			((WorkPackage) currentOpenME).getContainedWorkItems().add(ai);
		} else {
			project.addModelElement(ai);
			currentOpenME.getAnnotations().add(ai);
		}
		ai.setName("New action item relating " + currentOpenME.getName());
		ai.setAssignee(user);
		return ai;

	}

}
