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

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.organization.User;
import org.unicase.model.task.util.OpeningLinkHelper;
import org.unicase.model.util.ModelElementPath;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * This provider creates notifications about task objects.
 * 
 * @author helming
 */
public class TaskObjectNotificationProvider implements NotificationProvider {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return "Task Object Change Notifier";
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
		if (projectSpace == null || user == null) {
			return result;
		}
		Map<ModelElementId, ModelElementPath> objectsOfWork = OpeningLinkHelper.getObjectsOfWork(user);
		Map<ModelElementId, List<AbstractOperation>> changes = new HashMap<ModelElementId, List<AbstractOperation>>();

		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				ModelElementId modelElementId = operation.getModelElementId();
				if (objectsOfWork.containsKey(modelElementId)) {
					addChangePackage(modelElementId, operation, changes);
				}
			}
		}

		for (ModelElementId meId : changes.keySet()) {
			ESNotification createNotification = createNotification(meId, changes.get(meId), objectsOfWork.get(meId),
				projectSpace);
			createNotification.setProject(projectSpace.getProjectId());
			createNotification.setName("Task Object Change");
			result.add(createNotification);
		}

		return result;
	}

	private ESNotification createNotification(ModelElementId meId, List<AbstractOperation> list,
		ModelElementPath modelElementPath, ProjectSpace projectSpace) {
		Project project = projectSpace.getProject();
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setCreationDate(new Date());
		for (AbstractOperation operation : list) {
			notification.getRelatedModelElements().add(operation.getModelElementId());
		}
		ModelElement modelElement = project.getModelElement(meId);
		StringBuilder message = new StringBuilder();
		message.append(modelElement.eClass().getName());
		message.append(" ");
		message.append(NotificationHelper.getHTMLLinkForModelElement(meId, projectSpace));
		message.append(" has been modified: ");
		message.append("\n");

		message.append("Trace to the changed element: ");

		message.append(NotificationHelper.getHTMLLinkForModelElement(modelElementPath.getSource(), projectSpace));
		message.append(" => ");
		for (ModelElementId traceId : modelElementPath.getPath()) {
			message.append(NotificationHelper.getHTMLLinkForModelElement(traceId, projectSpace));
			message.append(" => ");
		}
		message.append(NotificationHelper.getHTMLLinkForModelElement(modelElementPath.getTarget(), projectSpace));
		notification.setMessage(message.toString());
		return notification;
	}

	private void addChangePackage(ModelElementId modelElementId, AbstractOperation operation,
		Map<ModelElementId, List<AbstractOperation>> changes) {
		if (changes.containsKey(modelElementId)) {
			changes.get(modelElementId).add(operation);
		} else {
			ArrayList<AbstractOperation> arrayList = new ArrayList<AbstractOperation>();
			arrayList.add(operation);
			changes.put(modelElementId, arrayList);
		}

	}
}
