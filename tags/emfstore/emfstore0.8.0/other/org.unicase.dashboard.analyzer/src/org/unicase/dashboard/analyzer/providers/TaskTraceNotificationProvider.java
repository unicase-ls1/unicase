/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.analyzer.providers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.dashboard.analyzer.DashboardAnalyzerHelper;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.organization.User;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.util.OpeningLinkHelper;
import org.unicase.model.util.ModelElementPath;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.notification.provider.NotificationHelper;

/**
 * This provider creates notifications about task objects.
 * 
 * @author helming
 * @author shterev
 */
public class TaskTraceNotificationProvider implements NotificationProvider {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return "Task Trace Notifier";
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
		User user = DashboardAnalyzerHelper.getUser(projectSpace, currentUsername);
		if (projectSpace == null || user == null) {
			return result;
		}
		Map<ModelElementId, ModelElementPath> objectsOfWork = OpeningLinkHelper.getObjectsOfWork(user);
		Map<ModelElementId, List<AbstractOperation>> changes = new HashMap<ModelElementId, List<AbstractOperation>>();

		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				if (filter(operation)) {
					continue;
				}
				ModelElementId modelElementId = operation.getModelElementId();
				if (objectsOfWork.containsKey(modelElementId)) {
					addChangePackage(modelElementId, operation, changes);
				}
			}
		}

		for (ModelElementId meId : changes.keySet()) {
			ESNotification createNotification = createNotification(meId, changes.get(meId), objectsOfWork.get(meId),
				projectSpace);
			createNotification.setProject((ProjectId) EcoreUtil.copy(projectSpace.getProjectId()));
			createNotification.setName("Task Object Change");
			createNotification.setRecipient(currentUsername);
			createNotification.setSender(getName());
			ModelElement me = projectSpace.getProject().getModelElement(createNotification.getRelatedModelElements().get(0));
			if(!(TaskPackage.eINSTANCE.getWorkPackage().isInstance(me) || ModelPackage.eINSTANCE.getNonDomainElement().isInstance(me))){
				result.add(createNotification);
			}
		}

		return result;
	}

	private boolean filter(AbstractOperation operation) {
		if (OperationsPackage.eINSTANCE.getReferenceOperation().isInstance(operation)) {
			ReferenceOperation referenceOperation = (ReferenceOperation) operation;
			ArrayList<String> features = new ArrayList<String>();
			features.add(TaskPackage.eINSTANCE.getWorkPackage_ContainedWorkItems().getName());
			if (features.contains(referenceOperation.getFeatureName())
				|| (referenceOperation.getOppositeFeatureName() != null && features.contains(referenceOperation.getOppositeFeatureName()))) {
				return true;
			}
		}
		return false;
	}

	private ESNotification createNotification(ModelElementId meId, List<AbstractOperation> list,
		ModelElementPath modelElementPath, ProjectSpace projectSpace) {
		Project project = projectSpace.getProject();
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setCreationDate(NotificationHelper.getLastDate(list));
		ModelElement modelElement = project.getModelElement(meId);
		StringBuilder message = new StringBuilder();
		message.append(modelElement.eClass().getName());
		message.append(" ");
		message.append(NotificationHelper.getHTMLLinkForModelElement(meId, projectSpace, false));
		message.append(" has been modified.");
		message.append("\n");

		message.append("Trace to the changed element: ");

		message
			.append(NotificationHelper.getHTMLLinkForModelElement(modelElementPath.getSource(), projectSpace, false));
		message.append(" => ");
		for (ModelElementId traceId : modelElementPath.getPath()) {
			message.append(NotificationHelper.getHTMLLinkForModelElement(traceId, projectSpace, false));
			message.append(" => ");
		}
		message
			.append(NotificationHelper.getHTMLLinkForModelElement(modelElementPath.getTarget(), projectSpace, false));
		notification.setMessage(message.toString());
		ModelElementId modelElementId = (ModelElementId) EcoreUtil.copy(modelElementPath.getTarget());
		notification.getRelatedModelElements().add(modelElementId);
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
