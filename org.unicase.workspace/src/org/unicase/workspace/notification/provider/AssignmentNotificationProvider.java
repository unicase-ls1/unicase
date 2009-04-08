/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Provides assignment notifications.
 * 
 * @author koegel
 * @author shterev
 */
public class AssignmentNotificationProvider implements NotificationProvider {

	private EClass clazz;

	/**
	 * Default constructor.
	 * 
	 * @param assignmentClass the class of the assignment - e.g. ActionItem, BugReport, etc.
	 */
	public AssignmentNotificationProvider(EClass assignmentClass) {
		this.clazz = assignmentClass;
	}

	private void processOrgUnit(AbstractOperation operation, ReferenceOperation referenceOperation,
		ModelElement userElement, User user, Set<ModelElementId> workItems, ProjectSpace projectSpace) {
		Set<Group> allCurrentGroups = OrgUnitHelper.getAllGroupsOfOrgUnit(user);
		if (allCurrentGroups.contains(userElement)) {
			workItems.addAll(referenceOperation.getOtherInvolvedModelElements());
		}
		if (OrganizationPackage.eINSTANCE.getUser().isInstance(userElement)) {
			ModelElement modelElement = projectSpace.getProject().getModelElement(
				referenceOperation.getModelElementId());
			if (user.getName().equalsIgnoreCase(userElement.getName()) && modelElement != null
				&& clazz.isInstance(modelElement)) {
				workItems.add(operation.getModelElementId());
			}
		}
	}

	private void processWorkItem(AbstractOperation operation, ReferenceOperation referenceOperation, User user,
		Set<ModelElementId> workItems, Project project) {
		Set<OrgUnit> impactedOrgUnits = new HashSet<OrgUnit>();
		for (ModelElementId modelElementId : referenceOperation.getOtherInvolvedModelElements()) {
			ModelElement element = project.getModelElement(modelElementId);
			impactedOrgUnits.add((OrgUnit) element);
		}
		Set<Group> allCurrentGroups = OrgUnitHelper.getAllGroupsOfOrgUnit(user);
		for (OrgUnit impactedOrgUnit : impactedOrgUnits) {
			if (allCurrentGroups.contains(impactedOrgUnit)) {
				workItems.add(operation.getModelElementId());
			}
			if (OrganizationPackage.eINSTANCE.getUser().isInstance(impactedOrgUnit)) {
				if (user.getName().equalsIgnoreCase(impactedOrgUnit.getName())) {
					workItems.add(operation.getModelElementId());
				}
			}
		}
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
		return "Assignement Notification Provider";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#provideNotifications(org.unicase.workspace.ProjectSpace,
	 *      java.util.List, java.lang.String)
	 */
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {
		List<ESNotification> result = new ArrayList<ESNotification>();
		User user = null;
		try {
			user = OrgUnitHelper.getUser(projectSpace);
		} catch (NoCurrentUserException e) {
			return result;
		} catch (CannotMatchUserInProjectException e) {
			return result;
		}
		Set<ModelElementId> workItems = new HashSet<ModelElementId>();

		if (projectSpace == null || user == null) {
			return result;
		}

		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {

				ReferenceOperation referenceOperation = getReferenceOperation(operation);
				if (referenceOperation == null) {
					continue;
				}

				String featureName = referenceOperation.getFeatureName();

				Project project = projectSpace.getProject();
				ModelElement modelElement = project.getModelElement(operation.getModelElementId());
				if (modelElement == null) {
					// the ME was deleted from the project.
					continue;
				}

				// if we have a change of an orgunit feature in a work item
				if (clazz.isInstance(modelElement)) {
					if (!(featureName.equalsIgnoreCase("assignee"))) {
						continue;
					}
					processWorkItem(operation, referenceOperation, user, workItems, project);

				}
				// if we have a change in a workitem related feature in a org unit
				else if (OrganizationPackage.eINSTANCE.getOrgUnit().isInstance(modelElement)) {
					if (!(featureName.equalsIgnoreCase("assignments"))) {
						continue;
					}

					processOrgUnit(operation, referenceOperation, modelElement, user, workItems, projectSpace);
				}

				else {
					continue;
				}
			}
		}

		TaskChangeNotificationProvider changeNotificationProvider = new TaskChangeNotificationProvider(this.clazz);
		changeNotificationProvider.addToFilter(workItems);
		List<ESNotification> notifications = changeNotificationProvider.provideNotifications(projectSpace,
			changePackages, currentUsername);
		result.addAll(notifications);

		if (workItems.isEmpty()) {
			return result;
		}

		// create a notification for the new work items
		ESNotification notification = createNotification(projectSpace, user, workItems);

		result.add(notification);
		return result;

	}

	private ESNotification createNotification(ProjectSpace projectSpace, User user, Set<ModelElementId> workItems) {
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setName("New work items");
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(user.getName());
		notification.setSeen(false);
		notification.setSender("unicase assignment notification generator");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("You have been assigned");
		ModelElementId[] wis = workItems.toArray(new ModelElementId[0]);
		if (workItems.size() == 1) {
			stringBuilder.append(" a");
			String className = this.clazz.getName();
			if (className.startsWith("A")) {
				stringBuilder.append("n");
			}
			stringBuilder.append(" ");
			stringBuilder.append(className);
			stringBuilder.append(" ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(wis[0], projectSpace));
		} else if (workItems.size() == 2) {
			stringBuilder.append("the ");
			stringBuilder.append(this.clazz.getName());
			stringBuilder.append("s ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(wis[0], projectSpace));
			stringBuilder.append(" and ");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(wis[1], projectSpace));
		} else {
			stringBuilder.append(" <a href=\"more\">");
			stringBuilder.append(workItems.size());
			stringBuilder.append("</a> ");
			stringBuilder.append(clazz.getName() + "s");
		}
		String message = stringBuilder.toString();
		notification.setMessage(message);
		notification.getRelatedModelElements().addAll(workItems);
		Date date = new Date();
		if (wis.length > 0) {
			ModelElement me = projectSpace.getProject().getModelElement(wis[0]);
			date = me.getCreationDate();
			for (ModelElementId wi : wis) {
				Date newDate = projectSpace.getProject().getModelElement(wi).getCreationDate();
				if (newDate != null && newDate.after(date)) {
					date = newDate;
				}
			}
		}
		notification.setCreationDate(date);
		return notification;
	}
}
