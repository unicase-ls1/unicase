/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
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
import org.unicase.model.task.TaskPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Provides assignment notifications.
 * 
 * @author koegel
 */
public class AssignmentNotificationProvider implements NotificationProvider {

	private ProjectSpace projectSpace;
	private User user;
	private Set<ModelElementId> workItems;
	private Map<ModelElementId, ModelElement> createdElementsMap;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#clear()
	 */
	public void clear() {
		this.projectSpace = null;
		this.user = null;
		this.workItems.clear();
		this.workItems = null;
		this.createdElementsMap.clear();
		this.createdElementsMap = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getCurrentResult()
	 */
	public List<ESNotification> getCurrentResult() {
		List<ESNotification> result = new ArrayList<ESNotification>();

		// create a notification for the new work items
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setCreationDate(new Date());
		notification.setName("New work items");
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(user.getName());
		notification.setSeen(false);
		notification.setSender("unicase assignment notification generator");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("You have been assigned ");
		stringBuilder.append(workItems.size());
		stringBuilder.append(" new work items.");
		String message = stringBuilder.toString();
		notification.setMessage(message);
		notification.getRelatedModelElements().addAll(workItems);

		result.add(notification);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#init()
	 */
	public void init(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
		try {
			this.user = OrgUnitHelper.getUser(projectSpace);
		} catch (NoCurrentUserException e) {
			clear();
		} catch (CannotMatchUserInProjectException e) {
			clear();
		}
		this.workItems = new HashSet<ModelElementId>();
		this.createdElementsMap = new HashMap<ModelElementId, ModelElement>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#processOperation(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void processOperation(AbstractOperation operation) {
		if (projectSpace == null || user == null) {
			return;
		}

		updateCreatedModelElementsMap(operation);

		ReferenceOperation referenceOperation = getReferenceOperation(operation);
		if (referenceOperation == null) {
			return;
		}

		String featureName = referenceOperation.getFeatureName();

		Project project = projectSpace.getProject();
		ModelElement modelElement = getModelElement(operation, project);

		// if we have a change of an orgunit feature in a work item
		if (TaskPackage.eINSTANCE.getWorkItem().isInstance(modelElement)) {
			if (!(featureName.equalsIgnoreCase("assignee") || featureName.equalsIgnoreCase("participants"))) {
				return;
			}
			processWorkItem(operation, referenceOperation, project);

		}
		// if we have a change in a workitem related feature in a org unit
		else if (OrganizationPackage.eINSTANCE.getOrgUnit().isInstance(modelElement)) {
			if (!(featureName.equalsIgnoreCase("assignments") || featureName.equalsIgnoreCase("participations"))) {
				return;
			}

			processOrgUnit(operation, referenceOperation, modelElement);
		}

		else {
			return;
		}
	}

	private void processOrgUnit(AbstractOperation operation, ReferenceOperation referenceOperation,
		ModelElement modelElement) {
		Set<Group> allCurrentGroups = OrgUnitHelper.getAllGroupsOfOrgUnit(user);
		if (allCurrentGroups.contains(modelElement)) {
			workItems.addAll(referenceOperation.getOtherInvolvedModelElements());
		}
		if (OrganizationPackage.eINSTANCE.getUser().isInstance(modelElement)) {
			if (user.getName().equalsIgnoreCase(modelElement.getName())) {
				workItems.add(operation.getModelElementId());
			}
		}
	}

	private void processWorkItem(AbstractOperation operation, ReferenceOperation referenceOperation, Project project) {
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

	private void updateCreatedModelElementsMap(AbstractOperation operation) {
		if (OperationsPackage.eINSTANCE.getCreateDeleteOperation().isInstance(operation)) {
			CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation) operation;
			if (!createDeleteOperation.isDelete()) {
				createdElementsMap.put(createDeleteOperation.getModelElementId(), createDeleteOperation
					.getModelElement());
			}
		}
	}

	private ModelElement getModelElement(AbstractOperation operation, Project project) {
		ModelElementId modelElementId = operation.getModelElementId();
		if (project.contains(modelElementId)) {
			return project.getModelElement(modelElementId);
		} else {
			return createdElementsMap.get(modelElementId);
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
}
