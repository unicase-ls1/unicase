/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Provides notifications for new tasks.
 * 
 * @author shterev
 */
public class TaskNotificationProvider extends AbstractNotificationProvider {

	private Map<WorkItem, AbstractOperation> reviewerItems;
	private Map<WorkItem, AbstractOperation> assigneeItems;
	private Map<WorkItem, AbstractOperation> readyForReviewItems;
	private EClass clazz;

	/**
	 * Default constructor.
	 * 
	 * @param clazz the WorkItem class.
	 */
	public TaskNotificationProvider(EClass clazz) {
		super();
		this.clazz = clazz;
		assigneeItems = new HashMap<WorkItem, AbstractOperation>();
		reviewerItems = new HashMap<WorkItem, AbstractOperation>();
		readyForReviewItems = new HashMap<WorkItem, AbstractOperation>();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return "Task Notification Provider";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleOperation(AbstractOperation operation, User user, Project project) {
		ModelElementId modelElementId = operation.getModelElementId();

		ModelElement modelElement = project.getModelElement(modelElementId);
		if (modelElement == null) {
			// the ME was deleted from the project.
			return;
		}
		if (this.clazz.isInstance(modelElement) || (OrganizationPackage.eINSTANCE.getUser().isInstance(modelElement))) {
			Set<Group> groupsOfOrgUnit = OrgUnitHelper.getAllGroupsOfOrgUnit(user);
			ReferenceOperation referenceOperation = getReferenceOperation(operation);
			if (referenceOperation != null) {
				String featureName = referenceOperation.getFeatureName();
				processAssignments(featureName, referenceOperation, project, user, modelElement, groupsOfOrgUnit);
				processReviewAssignments(featureName, referenceOperation, project, user, modelElement, groupsOfOrgUnit);
			} else if (operation instanceof AttributeOperation
				&& ((AttributeOperation) operation).getFeatureName().equalsIgnoreCase("resolved")
				&& modelElement instanceof WorkItem) {
				// Ready for review
				AttributeOperation op = (AttributeOperation) operation;
				WorkItem workItem = (WorkItem) modelElement;
				if (op.getNewValue().equals(new Boolean(true)) && workItem.getReviewer().equals(user)) {
					readyForReviewItems.put(workItem, op);
				} else if (op.getNewValue().equals(new Boolean(false))
					&& (workItem.getAssignee().equals(user) || groupsOfOrgUnit.contains(workItem.getAssignee()))) {
					assigneeItems.put(workItem, op);
				}
			}
		}
	}

	private void processReviewAssignments(String featureName, ReferenceOperation referenceOperation, Project project,
		User user, ModelElement modelElement, Set<Group> groupsOfOrgUnit) {
		if (featureName.equalsIgnoreCase("reviewer")) {
			ModelElementId orgUnitId = ((SingleReferenceOperation) referenceOperation).getNewValue();
			ModelElement orgUnit = project.getModelElement(orgUnitId);
			if (orgUnit != null && orgUnit instanceof User && orgUnit.equals(user)) {
				reviewerItems.put((WorkItem) modelElement, referenceOperation);
			}
		} else if (featureName.equalsIgnoreCase("workItemsToReview") && modelElement.equals(user)) {
			EList<ModelElementId> wiIds = ((MultiReferenceOperation) referenceOperation).getReferencedModelElements();
			for (ModelElementId wiId : wiIds) {
				ModelElement wi = project.getModelElement(wiId);
				if (wi != null) {
					reviewerItems.put((WorkItem) wi, referenceOperation);
				}
			}
		}
	}

	private void processAssignments(String featureName, ReferenceOperation referenceOperation, Project project,
		User user, ModelElement modelElement, Set<Group> groupsOfOrgUnit) {
		if (featureName.equalsIgnoreCase("assignee")) {
			ModelElementId orgUnitId = ((SingleReferenceOperation) referenceOperation).getNewValue();
			ModelElement orgUnit = project.getModelElement(orgUnitId);
			if (orgUnit != null && (orgUnit.equals(user) || groupsOfOrgUnit.contains(orgUnit))) {
				assigneeItems.put((WorkItem) modelElement, referenceOperation);
			}
		} else if (featureName.equalsIgnoreCase("assignments")
			&& (modelElement.equals(user) || groupsOfOrgUnit.contains(modelElement))) {
			EList<ModelElementId> wiIds = ((MultiReferenceOperation) referenceOperation).getReferencedModelElements();
			for (ModelElementId wiId : wiIds) {
				ModelElement wi = project.getModelElement(wiId);
				if (wi != null) {
					assigneeItems.put((WorkItem) wi, referenceOperation);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<ESNotification> createNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {

		List<ESNotification> result = new ArrayList<ESNotification>();

		HashMap<WorkItem, AbstractOperation> workItems = new HashMap<WorkItem, AbstractOperation>();
		workItems.putAll(assigneeItems);
		workItems.putAll(readyForReviewItems);
		workItems.putAll(reviewerItems);

		TaskChangeNotificationProvider changeNotificationProvider = new TaskChangeNotificationProvider(this.clazz);
		changeNotificationProvider.addToFilter(workItems.keySet());
		List<ESNotification> notifications = changeNotificationProvider.provideNotifications(projectSpace,
			changePackages, currentUsername);
		result.addAll(notifications);

		if (!assigneeItems.isEmpty()) {
			ESNotification notification = createSingleNotification(projectSpace, getUser(), assigneeItems,
				"You have been assigned ", "assignment");
			result.add(notification);
		}
		if (!readyForReviewItems.isEmpty()) {
			ESNotification notification = createSingleNotification(projectSpace, getUser(), readyForReviewItems,
				"You can now review ", "ready-for-review");
			result.add(notification);
		}
		if (!reviewerItems.isEmpty()) {
			ESNotification notification = createSingleNotification(projectSpace, getUser(), reviewerItems,
				"You have been assigned to review ", "review");
			result.add(notification);
		}

		return result;

	}

	private ESNotification createSingleNotification(ProjectSpace projectSpace, User user,
		Map<WorkItem, AbstractOperation> workItemMap, String message, String taskType) {
		Set<WorkItem> workItems = workItemMap.keySet();
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setName("New " + taskType + " items");
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(user.getName());
		notification.setSeen(false);
		notification.setSender(getName());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(message);
		if (workItems.size() == 1) {
			stringBuilder.append("the");
			stringBuilder.append(" ");
			stringBuilder.append(this.clazz.getName());
			stringBuilder.append(" ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(workItems.iterator().next(),
				projectSpace));
		} else if (workItems.size() == 2) {
			stringBuilder.append("the ");
			stringBuilder.append(this.clazz.getName());
			stringBuilder.append("s ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(workItems.iterator().next(),
				projectSpace));
			stringBuilder.append(" and ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(workItems.iterator().next(),
				projectSpace));
		} else {
			stringBuilder.append(" <a href=\"more\">");
			stringBuilder.append(workItems.size());
			stringBuilder.append(clazz.getName());
			stringBuilder.append("</a>s ");
		}
		String text = stringBuilder.toString();
		notification.setMessage(text);
		Date date = workItems.iterator().next().getCreationDate();
		ArrayList<OperationId> ops = new ArrayList<OperationId>();
		for (WorkItem workItem : workItems) {
			notification.getRelatedModelElements().add(workItem.getModelElementId());
			AbstractOperation abstractOperation = workItemMap.get(workItem);
			ops.add(abstractOperation.getOperationId());
			Date newDate = abstractOperation.getClientDate();
			if (newDate != null && newDate.after(date)) {
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
}
