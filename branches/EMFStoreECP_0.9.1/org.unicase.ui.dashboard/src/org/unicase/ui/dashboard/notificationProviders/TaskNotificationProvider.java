/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.properties.PropertyManager;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation;
import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.util.DashboardPropertyKeys;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * Provides notifications for new tasks.
 * 
 * @author shterev
 */
public class TaskNotificationProvider extends AbstractNotificationProvider {

	/**
	 * The name.
	 */
	public static final String NAME = "Task Notification Provider";

	private Map<EClass, Map<WorkItem, AbstractOperation>> reviewerItems;
	private Map<EClass, Map<WorkItem, AbstractOperation>> assigneeItems;
	private Map<EClass, Map<WorkItem, AbstractOperation>> readyForReviewItems;

	private List<EClass> clazzes;

	/**
	 * Default constructor.
	 */
	public TaskNotificationProvider() {
		super();
		assigneeItems = new HashMap<EClass, Map<WorkItem, AbstractOperation>>();
		reviewerItems = new HashMap<EClass, Map<WorkItem, AbstractOperation>>();
		readyForReviewItems = new HashMap<EClass, Map<WorkItem, AbstractOperation>>();
		clazzes = new ArrayList<EClass>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleOperation(AbstractOperation operation) {
		for (EClass clazz : clazzes) {
			handleOperation(operation, clazz);
		}
	}

	private void handleOperation(AbstractOperation operation, EClass clazz) {
		ModelElementId modelElementId = operation.getModelElementId();

		EObject modelElement = getProjectSpace().getProject().getModelElement(modelElementId);
		if (modelElement == null) {
			// the ME was deleted from the project.
			return;
		}
		if (clazz.isInstance(modelElement) || (OrganizationPackage.eINSTANCE.getUser().isInstance(modelElement))) {
			Set<Group> groupsOfOrgUnit = OrgUnitHelper.getAllGroupsOfOrgUnit(getUser());
			ReferenceOperation referenceOperation = getReferenceOperation(operation);
			if (referenceOperation != null) {
				String featureName = referenceOperation.getFeatureName();
				processAssignments(featureName, referenceOperation, modelElement, groupsOfOrgUnit, clazz);
				processReviewAssignments(featureName, referenceOperation, modelElement, groupsOfOrgUnit, clazz);
			} else if (operation instanceof AttributeOperation
				&& ((AttributeOperation) operation).getFeatureName().equalsIgnoreCase(
					TaskPackage.eINSTANCE.getWorkItem_Resolved().getName()) && modelElement instanceof WorkItem) {
				// Ready for review
				AttributeOperation op = (AttributeOperation) operation;
				WorkItem workItem = (WorkItem) modelElement;
				if (op.getNewValue().equals(new Boolean(true)) && workItem.getReviewer() != null
					&& workItem.getReviewer().equals(getUser())) {
					readyForReviewItems.get(clazz).put(workItem, op);
					getExcludedOperations().add(op.getOperationId());
				} else if (op.getNewValue().equals(new Boolean(false)) && workItem.getAssignee() != null
					&& (workItem.getAssignee().equals(getUser()) || groupsOfOrgUnit.contains(workItem.getAssignee()))) {
					assigneeItems.get(clazz).put(workItem, op);
					getExcludedOperations().add(op.getOperationId());
				}
			}
		}
	}

	private void processReviewAssignments(String featureName, ReferenceOperation referenceOperation,
		EObject modelElement, Set<Group> groupsOfOrgUnit, EClass clazz) {
		if (featureName.equalsIgnoreCase(TaskPackage.eINSTANCE.getWorkItem_Reviewer().getName())
			&& clazz.isInstance(modelElement)) {
			ModelElementId orgUnitId = ((SingleReferenceOperation) referenceOperation).getNewValue();
			EObject orgUnit = getProjectSpace().getProject().getModelElement(orgUnitId);
			if (orgUnit != null && orgUnit instanceof User && orgUnit.equals(getUser())) {
				reviewerItems.get(clazz).put((WorkItem) modelElement, referenceOperation);
				getExcludedOperations().add(referenceOperation.getOperationId());
			}
		} else if (featureName.equalsIgnoreCase(OrganizationPackage.eINSTANCE.getUser_WorkItemsToReview().getName())
			&& modelElement.equals(getUser())) {
			EList<ModelElementId> wiIds = ((MultiReferenceOperation) referenceOperation).getReferencedModelElements();
			for (ModelElementId wiId : wiIds) {
				EObject wi = getProjectSpace().getProject().getModelElement(wiId);
				if (wi != null && clazz.isInstance(wi)) {
					reviewerItems.get(clazz).put((WorkItem) wi, referenceOperation);
					getExcludedOperations().add(referenceOperation.getOperationId());
				}
			}
		}
	}

	private void processAssignments(String featureName, ReferenceOperation referenceOperation, EObject modelElement,
		Set<Group> groupsOfOrgUnit, EClass clazz) {
		if (featureName.equalsIgnoreCase(TaskPackage.eINSTANCE.getWorkItem_Assignee().getName())
			&& clazz.isInstance(modelElement)) {
			ModelElementId orgUnitId = ((SingleReferenceOperation) referenceOperation).getNewValue();
			EObject orgUnit = getProjectSpace().getProject().getModelElement(orgUnitId);
			if (orgUnit != null && (orgUnit.equals(getUser()) || groupsOfOrgUnit.contains(orgUnit))) {
				assigneeItems.get(clazz).put((WorkItem) modelElement, referenceOperation);
				getExcludedOperations().add(referenceOperation.getOperationId());
			}
		} else if (featureName.equalsIgnoreCase(OrganizationPackage.eINSTANCE.getOrgUnit_Assignments().getName())
			&& (modelElement.equals(getUser()) || groupsOfOrgUnit.contains(modelElement))) {
			EList<ModelElementId> wiIds = ((MultiReferenceOperation) referenceOperation).getReferencedModelElements();
			for (ModelElementId wiId : wiIds) {
				EObject wi = getProjectSpace().getProject().getModelElement(wiId);
				if (wi != null && clazz.isInstance(wi)) {
					assigneeItems.get(clazz).put((WorkItem) wi, referenceOperation);
					getExcludedOperations().add(referenceOperation.getOperationId());
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<DashboardNotification> createNotifications() {

		List<DashboardNotification> result = new ArrayList<DashboardNotification>();

		for (EClass clazz : clazzes) {

			if (!assigneeItems.get(clazz).isEmpty()) {
				DashboardNotification notification = createSingleNotification(assigneeItems.get(clazz), clazz,
					"You have been assigned ", "assignment");
				result.add(notification);
			}
			if (!readyForReviewItems.get(clazz).isEmpty()) {
				DashboardNotification notification = createSingleNotification(readyForReviewItems.get(clazz), clazz,
					"You can now review ", "ready-for-review");
				result.add(notification);
			}
			if (!reviewerItems.get(clazz).isEmpty()) {
				DashboardNotification notification = createSingleNotification(reviewerItems.get(clazz), clazz,
					"You have been assigned to review ", "review");
				result.add(notification);
			}

			assigneeItems.get(clazz).clear();
			reviewerItems.get(clazz).clear();
			readyForReviewItems.get(clazz).clear();
		}

		return result;

	}

	private DashboardNotification createSingleNotification(Map<WorkItem, AbstractOperation> workItemMap, EClass clazz,
		String message, String taskType) {
		Set<WorkItem> workItems = workItemMap.keySet();
		DashboardNotification notification = DashboardFactory.eINSTANCE.createDashboardNotification();
		notification.setName("New " + taskType + " items");
		notification.setProject(ModelUtil.clone(getProjectSpace().getProjectId()));
		notification.setRecipient(getUser().getName());
		notification.setSeen(false);
		notification.setProvider(getName());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(message);
		if (workItems.size() == 1) {
			stringBuilder.append("the");
			stringBuilder.append(" ");
			stringBuilder.append(clazz.getName());
			stringBuilder.append(" ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(workItems.iterator().next(),
				getProjectSpace()));
		} else if (workItems.size() == 2) {
			stringBuilder.append("the ");
			stringBuilder.append(clazz.getName());
			stringBuilder.append("s ");
			Iterator<WorkItem> it = workItems.iterator();
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(it.next(), getProjectSpace()));
			stringBuilder.append(" and ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(it.next(), getProjectSpace()));
		} else {
			stringBuilder.append("<a href=\"more\">");
			stringBuilder.append(workItems.size());
			stringBuilder.append(" ");
			stringBuilder.append(clazz.getName());
			stringBuilder.append("s</a> ");
		}
		String text = stringBuilder.toString();
		notification.setMessage(text);
		Date date = workItems.iterator().next().getCreationDate();
		ArrayList<OperationId> ops = new ArrayList<OperationId>();
		for (WorkItem workItem : workItems) {
			ModelElementId workItemId = ModelUtil.getProject(workItem).getModelElementId(workItem);
			notification.getRelatedModelElements().add(workItemId);
			AbstractOperation abstractOperation = workItemMap.get(workItem);
			ops.add(abstractOperation.getOperationId());
			Date newDate = abstractOperation.getClientDate();
			if (newDate != null && date != null && newDate.after(date)) {
				date = newDate;
			}
		}
		if (date == null) {
			date = new Date();
		}
		notification.setCreationDate(date);
		notification.getRelatedOperations().addAll(ops);
		return notification;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getKey() {
		return DashboardPropertyKeys.TASK_PROVIDER;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.dashboard.notificationProviders.AbstractNotificationProvider#init()
	 */
	@Override
	protected void init() {
		super.init();
		clazzes.clear();

		PropertyManager manager = getProjectSpace().getPropertyManager();

		String showBR = manager.getLocalStringProperty(DashboardPropertyKeys.SHOW_BR_TASKS);
		if (showBR != null && Boolean.parseBoolean(showBR)) {
			EClass bugClass = BugPackage.eINSTANCE.getBugReport();
			clazzes.add(bugClass);
			assigneeItems.put(bugClass, new HashMap<WorkItem, AbstractOperation>());
			reviewerItems.put(bugClass, new HashMap<WorkItem, AbstractOperation>());
			readyForReviewItems.put(bugClass, new HashMap<WorkItem, AbstractOperation>());
		}

		String showAI = manager.getLocalStringProperty(DashboardPropertyKeys.SHOW_AI_TASKS);
		if (showAI != null && Boolean.parseBoolean(showAI)) {
			EClass aiClass = TaskPackage.eINSTANCE.getActionItem();
			clazzes.add(aiClass);
			assigneeItems.put(aiClass, new HashMap<WorkItem, AbstractOperation>());
			reviewerItems.put(aiClass, new HashMap<WorkItem, AbstractOperation>());
			readyForReviewItems.put(aiClass, new HashMap<WorkItem, AbstractOperation>());
		}

		String showIssue = manager.getLocalStringProperty(DashboardPropertyKeys.SHOW_ISSUE_TASKS);
		if (showIssue != null && Boolean.parseBoolean(showIssue)) {
			EClass issueClass = RationalePackage.eINSTANCE.getIssue();
			clazzes.add(issueClass);
			assigneeItems.put(issueClass, new HashMap<WorkItem, AbstractOperation>());
			reviewerItems.put(issueClass, new HashMap<WorkItem, AbstractOperation>());
			readyForReviewItems.put(issueClass, new HashMap<WorkItem, AbstractOperation>());
		}

		String showWP = manager.getLocalStringProperty(DashboardPropertyKeys.SHOW_WP_TASKS);
		if (showWP != null && Boolean.parseBoolean(showWP)) {
			EClass wpClass = TaskPackage.eINSTANCE.getWorkPackage();
			clazzes.add(wpClass);
			assigneeItems.put(wpClass, new HashMap<WorkItem, AbstractOperation>());
			reviewerItems.put(wpClass, new HashMap<WorkItem, AbstractOperation>());
			readyForReviewItems.put(wpClass, new HashMap<WorkItem, AbstractOperation>());
		}
	}
}
