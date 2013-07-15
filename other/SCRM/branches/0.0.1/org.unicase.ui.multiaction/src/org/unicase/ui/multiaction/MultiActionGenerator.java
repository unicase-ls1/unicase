/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.multiaction;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.document.LeafSection;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author jfinis This static class contains utility methods for creating multi-asignee-actions.
 */
public final class MultiActionGenerator {

	private MultiActionGenerator() {
	}

	private static void copyValues(ActionItem from, WorkItem to) {
		if (to instanceof ActionItem) {
			ActionItem toA = (ActionItem) to;
			toA.setActivity(from.getActivity());
			toA.setChecked(from.isChecked());
			toA.setDone(from.isDone());
		}
		to.setCreationDate(from.getCreationDate());
		to.setCreator(from.getCreator());
		to.setDescription(from.getDescription());
		to.setDueDate(from.getDueDate());
		to.setEffort(from.getEffort());
		to.setEstimate(from.getEstimate());
		to.setName(from.getName());
		to.setPriority(from.getPriority());
		to.setResolved(from.isResolved());
		to.setReviewer(from.getReviewer());
		to.getSuccessors().addAll(from.getSuccessors());
		to.getAnnotatedModelElements().addAll(from.getAnnotatedModelElements());
		to.getAnnotations().addAll(from.getAnnotations());
		to.getAttachments().addAll(from.getAttachments());
		to.getComments().addAll(from.getComments());
		to.getIncomingDocumentReferences().addAll(from.getIncomingDocumentReferences());
		to.getPredecessors().addAll(from.getPredecessors());
		to.getParticipants().addAll(from.getParticipants());

	}

	/**
	 * private recursive method used by flattenOrgList. Not to be used anywhere else.
	 * 
	 * @param out The resulting user set
	 * @param visitedGroups A set containing visited groups
	 * @param toAdd A list to be flattened recursively
	 */
	private static void flattenRecursive(Set<User> out, Set<Group> visitedGroups, List<OrgUnit> toAdd) {
		for (OrgUnit o : toAdd) {
			if (o instanceof User) {
				out.add((User) o);
			} else if (o instanceof Group) {
				// Track visited groups for circular-group-looping-recursion-avoidance
				if (!visitedGroups.contains(o)) {
					visitedGroups.add((Group) o);
					flattenRecursive(out, visitedGroups, ((Group) o).getOrgUnits());
				}
			}
		}
	}

	/**
	 * Flattens an organization list, i.e. a list of user and/or groups. The flattened list is returned as a user list.
	 * Flattening means all groups are "unpacked" recursively and all users in them are added to the result list. The
	 * method keeps track of visited groups, so cycles between groups will not create an endlessly looping recursion
	 * (resulting in a stack overflow).
	 * 
	 * @param in a List of OrgUnits to be flattened
	 * @return the flattened List
	 */
	public static List<User> flattenOrgList(List<OrgUnit> in) {
		LinkedHashSet<User> out = new LinkedHashSet<User>();
		HashSet<Group> visited = new HashSet<Group>();
		flattenRecursive(out, visited, in);
		EList<User> result = new BasicEList<User>();
		result.addAll(out);
		return result;
	}

	/**
	 * The core action that is execute when the MultiactionWizard is finished. It splits an action item into many copies
	 * (one for each User in the assignee input list). The copies are exact copies of the old action item, only the
	 * assignee is set to the one taken from the list. In addition, a WorkPackage is created at the location of the
	 * input actionItem. This WorkPackage also gets copied most values from the input actionItem. All copies of
	 * actionItem are inserted into the newly created work package. Finally, the input actionItem is deleted. All this
	 * is done in a composite operation, so the history isn't spammed with a huge amount of actions.
	 * 
	 * @param baseAction An action item to be assigned to many users, will be split and deleted.
	 * @param assignees A list of assignees for this task
	 * @return The resulting WorkPackage containing all newly created ActionItems.
	 */
	public static WorkPackage generateMultiAction(ActionItem baseAction, List<User> assignees) {
		// Leaf Section
		// Project
		// Work Package
		final WorkPackage result = TaskFactory.eINSTANCE.createWorkPackage();
		final EObject parentPackage = baseAction.eContainer();
		final Project project = ModelUtil.getProject(baseAction);
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(project);

		// Begin composite operation
		CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();

		// Add resulting work package into parent
		if (parentPackage instanceof Project) {
			project.addModelElement(result);
		} else if (parentPackage instanceof LeafSection) {
			((LeafSection) parentPackage).getModelElements().add(result);
		} else if (parentPackage instanceof WorkPackage) {
			((WorkPackage) parentPackage).getContainedWorkItems().add(result);
		}

		// Set values for the resulting work package to those of the old Work Item
		copyValues(baseAction, result);

		for (User curAssignee : assignees) {
			// Create copied action item
			ActionItem curAI = TaskFactory.eINSTANCE.createActionItem();

			// Add to resulting section
			result.getContainedWorkItems().add(curAI);

			// Set assignee
			curAI.setAssignee(curAssignee);

			// Copy values (not good if ActionItem gets new attributes, a .clone method would be better...)
			copyValues(baseAction, curAI);

			curAI.setName(curAI.getName() + " (" + curAssignee.getName() + ")");
		}

		// Delete old action item
		project.deleteModelElement(baseAction);

		try {
			operationHandle.end("Assign action item to group", "Assigned action item " + baseAction.getName()
				+ " to multiple assignees.", project.getModelElementId(result));
		} catch (InvalidHandleException e) {
			WorkspaceUtil.logException("Composite Operation failed!", e);
		}

		return result;
	}

}
