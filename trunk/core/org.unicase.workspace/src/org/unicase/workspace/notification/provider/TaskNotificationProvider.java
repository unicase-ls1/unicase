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
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
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
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Provides notifications for new tasks.
 * 
 * @author shterev
 */
public class TaskNotificationProvider implements NotificationProvider {

	private EClass clazz;
	private Map<WorkItem, Date> reviewerItems;
	private Map<WorkItem, Date> assigneeItems;
	private Map<WorkItem, Date> readyForReviewItems;

	/**
	 * Default constructor.
	 * 
	 * @param assignmentClass the class of the assignment - e.g. ActionItem, BugReport, etc.
	 */
	public TaskNotificationProvider(EClass assignmentClass) {
		this.clazz = assignmentClass;
	}

	/**
	 * Filters all unwanted operation and returns a reference operation if applicable.
	 * 
	 * @param operation abstract operation
	 * @return the reference operation or null if there is no reference operation
	 */
	private ReferenceOperation getReferenceOperation(AbstractOperation operation) {
		// filter all operations other than reference operations
		if (!OperationsPackage.eINSTANCE.getReferenceOperation().isInstance(operation)) {
			return null;
		}

		ReferenceOperation referenceOperation = (ReferenceOperation) operation;

		// filter remove reference operations
		if (OperationsPackage.eINSTANCE.getMultiReferenceOperation().isInstance(referenceOperation)) {
			MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) referenceOperation;
			if (!multiReferenceOperation.isAdd()) {
				return null;
			}
		}
		if (OperationsPackage.eINSTANCE.getSingleReferenceOperation().isInstance(referenceOperation)) {
			SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) referenceOperation;
			if (singleReferenceOperation.getNewValue() == null) {
				return null;
			}
		}
		return referenceOperation;
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
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#provideNotifications(org.unicase.workspace.ProjectSpace,
	 *      java.util.List, java.lang.String)
	 */
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {

		// sanity checks
		List<ESNotification> result = new ArrayList<ESNotification>();
		User user = null;
		try {
			user = OrgUnitHelper.getUser(projectSpace);
		} catch (NoCurrentUserException e) {
			return result;
		} catch (CannotMatchUserInProjectException e) {
			return result;
		}

		if (projectSpace == null || user == null) {
			return result;
		}

		assigneeItems = new HashMap<WorkItem, Date>();
		reviewerItems = new HashMap<WorkItem, Date>();
		readyForReviewItems = new HashMap<WorkItem, Date>();

		Project project = projectSpace.getProject();
		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				if (operation instanceof CompositeOperation) {
					for (AbstractOperation op : ((CompositeOperation) operation).getSubOperations()) {
						handleOperation(op, user, project);
					}
				} else {
					handleOperation(operation, user, project);
				}
			}
		}

		HashMap<WorkItem, Date> workItems = new HashMap<WorkItem, Date>();
		workItems.putAll(assigneeItems);
		workItems.putAll(readyForReviewItems);
		workItems.putAll(reviewerItems);

		TaskChangeNotificationProvider changeNotificationProvider = new TaskChangeNotificationProvider(this.clazz);
		changeNotificationProvider.addToFilter(workItems.keySet());
		List<ESNotification> notifications = changeNotificationProvider.provideNotifications(projectSpace,
			changePackages, currentUsername);
		result.addAll(notifications);

		if (!assigneeItems.isEmpty()) {
			ESNotification notification = createNotification(projectSpace, user, assigneeItems,
				"You have been assigned ", "assignment");
			result.add(notification);
		}
		if (!readyForReviewItems.isEmpty()) {
			ESNotification notification = createNotification(projectSpace, user, readyForReviewItems,
				"You can now review ", "ready-for-review");
			result.add(notification);
		}
		if (!reviewerItems.isEmpty()) {
			ESNotification notification = createNotification(projectSpace, user, reviewerItems,
				"You have been assigned to review ", "review");
			result.add(notification);
		}

		return result;

	}

	private void handleOperation(AbstractOperation operation, User user, Project project) {
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
					readyForReviewItems.put(workItem, op.getClientDate());
				} else if (op.getNewValue().equals(new Boolean(false))
					&& (workItem.getAssignee().equals(user) || groupsOfOrgUnit.contains(workItem.getAssignee()))) {
					assigneeItems.put(workItem, op.getClientDate());
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
				reviewerItems.put((WorkItem) modelElement, referenceOperation.getClientDate());
			}
		} else if (featureName.equalsIgnoreCase("workItemsToReview") && modelElement.equals(user)) {
			EList<ModelElementId> wiIds = ((MultiReferenceOperation) referenceOperation).getReferencedModelElements();
			for (ModelElementId wiId : wiIds) {
				ModelElement wi = project.getModelElement(wiId);
				if (wi != null) {
					reviewerItems.put((WorkItem) wi, referenceOperation.getClientDate());
				}
			}
		}
	}

	private void processAssignments(String featureName, ReferenceOperation referenceOperation, Project project,
		User user, ModelElement modelElement, Set<Group> groupsOfOrgUnit) {
		if (featureName.equalsIgnoreCase("assignee")) {
			ModelElementId orgUnitId = ((SingleReferenceOperation) referenceOperation).getNewValue();
			ModelElement orgUnit = project.getModelElement(orgUnitId);
			if (orgUnit != null
				&& ((orgUnit instanceof User && orgUnit.equals(user)) || (orgUnit instanceof Group && groupsOfOrgUnit
					.contains(orgUnit)))) {
				assigneeItems.put((WorkItem) modelElement, referenceOperation.getClientDate());
			}
		} else if (featureName.equalsIgnoreCase("assignments")
			&& (modelElement.equals(user) || groupsOfOrgUnit.contains(modelElement))) {
			EList<ModelElementId> wiIds = ((MultiReferenceOperation) referenceOperation).getReferencedModelElements();
			for (ModelElementId wiId : wiIds) {
				ModelElement wi = project.getModelElement(wiId);
				if (wi != null) {
					assigneeItems.put((WorkItem) wi, referenceOperation.getClientDate());
				}
			}
		}
	}

	private ESNotification createNotification(ProjectSpace projectSpace, User user, Map<WorkItem, Date> workItemMap,
		String message, String taskType) {
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
		for (WorkItem workItem : workItems) {
			notification.getRelatedModelElements().add(workItem.getModelElementId());
			Date newDate = workItemMap.get(workItem);
			if (newDate != null && newDate.after(date)) {
				date = newDate;
			}
		}
		if (date == null) {
			date = new Date();
		}
		notification.setCreationDate(date);
		return notification;
	}
}
