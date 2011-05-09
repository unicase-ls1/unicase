/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;

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
	protected List<ESNotification> createNotifications() {

		List<ESNotification> result = new ArrayList<ESNotification>();

		for (EClass clazz : clazzes) {

			if (!assigneeItems.get(clazz).isEmpty()) {
				ESNotification notification = createSingleNotification(assigneeItems.get(clazz), clazz,
					"You have been assigned ", "assignment");
				result.add(notification);
			}
			if (!readyForReviewItems.get(clazz).isEmpty()) {
				ESNotification notification = createSingleNotification(readyForReviewItems.get(clazz), clazz,
					"You can now review ", "ready-for-review");
				result.add(notification);
			}
			if (!reviewerItems.get(clazz).isEmpty()) {
				ESNotification notification = createSingleNotification(reviewerItems.get(clazz), clazz,
					"You have been assigned to review ", "review");
				result.add(notification);
			}

			assigneeItems.get(clazz).clear();
			reviewerItems.get(clazz).clear();
			readyForReviewItems.get(clazz).clear();
		}

		return result;

	}

	private ESNotification createSingleNotification(Map<WorkItem, AbstractOperation> workItemMap, EClass clazz,
		String message, String taskType) {
		Set<WorkItem> workItems = workItemMap.keySet();
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
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
	public DashboardKey getKey() {
		return DashboardKey.TASK_PROVIDER;
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
		if (PreferenceManager.INSTANCE.getProperty(getProjectSpace(), DashboardKey.SHOW_BR_TASKS).getBooleanProperty()) {
			EClass bugClass = BugPackage.eINSTANCE.getBugReport();
			clazzes.add(bugClass);
			assigneeItems.put(bugClass, new HashMap<WorkItem, AbstractOperation>());
			reviewerItems.put(bugClass, new HashMap<WorkItem, AbstractOperation>());
			readyForReviewItems.put(bugClass, new HashMap<WorkItem, AbstractOperation>());
		}
		if (PreferenceManager.INSTANCE.getProperty(getProjectSpace(), DashboardKey.SHOW_AI_TASKS).getBooleanProperty()) {
			EClass aiClass = TaskPackage.eINSTANCE.getActionItem();
			clazzes.add(aiClass);
			assigneeItems.put(aiClass, new HashMap<WorkItem, AbstractOperation>());
			reviewerItems.put(aiClass, new HashMap<WorkItem, AbstractOperation>());
			readyForReviewItems.put(aiClass, new HashMap<WorkItem, AbstractOperation>());
		}
		if (PreferenceManager.INSTANCE.getProperty(getProjectSpace(), DashboardKey.SHOW_ISSUE_TASKS)
			.getBooleanProperty()) {
			EClass issueClass = RationalePackage.eINSTANCE.getIssue();
			clazzes.add(issueClass);
			assigneeItems.put(issueClass, new HashMap<WorkItem, AbstractOperation>());
			reviewerItems.put(issueClass, new HashMap<WorkItem, AbstractOperation>());
			readyForReviewItems.put(issueClass, new HashMap<WorkItem, AbstractOperation>());
		}
		if (PreferenceManager.INSTANCE.getProperty(getProjectSpace(), DashboardKey.SHOW_WP_TASKS).getBooleanProperty()) {
			EClass wpClass = TaskPackage.eINSTANCE.getWorkPackage();
			clazzes.add(wpClass);
			assigneeItems.put(wpClass, new HashMap<WorkItem, AbstractOperation>());
			reviewerItems.put(wpClass, new HashMap<WorkItem, AbstractOperation>());
			readyForReviewItems.put(wpClass, new HashMap<WorkItem, AbstractOperation>());
		}
	}
}
