/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.paper.imperative;

import org.eclipse.emf.common.util.BasicEList;
import org.unicase.model.Project;
import org.unicase.model.bug.BugReport;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.iterationplanner.paper.TriageAccuracyAnalyzer;
import org.unicase.ui.iterationplanner.provider.AssigneeProvider;

import java.util.List;

/**
 * @author Hodaie
 */
public class ImperativeTriageAccuracyAnalyzer extends TriageAccuracyAnalyzer {

	private static int totalPredictions = 0;
	private static int correctPredictions = 0;
	private static int nullassignee = 0;

	private Project clonedProject;
	private AssigneeProvider assigneeProvider;

	/**
	 * @param assigneeProvider
	 * @param taskProvider
	 */
	public ImperativeTriageAccuracyAnalyzer(AssigneeProvider assigneeProvider) {
		this.assigneeProvider = assigneeProvider;
	}

	@Override
	protected void predictAssigneee(Object wi, Object assignee) {
		if (!(wi instanceof BugReport || wi instanceof ActionItem || wi instanceof Issue)) {
			return;
		}
		if (((WorkItem) wi).getAnnotatedModelElements().size() == 0) {
			return;
		}
		if (!(assignee instanceof OrgUnit)) {
			return;
		}
		totalPredictions++;

		assigneeProvider.setAssignees(getAssignees());
		User suggestedAssignee = assigneeProvider.getAppropriateAssignee((WorkItem) wi);

		if (suggestedAssignee != null && assignee != null && suggestedAssignee.equals(assignee)) {
			correctPredictions++;
		}

	}

	/**
	 * @return
	 */
	private List<User> getAssignees() {
		List<User> allAssignees = clonedProject.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		return allAssignees;
	}

}
