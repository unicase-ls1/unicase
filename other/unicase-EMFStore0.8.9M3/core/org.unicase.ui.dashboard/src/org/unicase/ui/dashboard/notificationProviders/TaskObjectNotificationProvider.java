/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.preferences.DashboardKey;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.notification.ESNotification;
import org.eclipse.emf.emfstore.server.model.notification.NotificationFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.util.OpeningLinkHelper;
import org.unicase.model.util.ModelElementPath;

/**
 * This provider creates notifications about task objects.
 * 
 * @author helming
 * @author shterev
 */
public class TaskObjectNotificationProvider extends AbstractNotificationProvider {

	/**
	 * The name.
	 */
	public static final String NAME = "Task Object Change Notifier";
	private Map<ModelElementId, List<AbstractOperation>> changes;
	private Map<ModelElementId, ModelElementPath> objectsOfWork;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * Default constructor.
	 */
	public TaskObjectNotificationProvider() {
		changes = new HashMap<ModelElementId, List<AbstractOperation>>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.dashboard.notificationProviders.AbstractNotificationProvider#handleOperation(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	@Override
	protected void handleOperation(AbstractOperation operation) {
		if (filter(operation)) {
			return;
		}
		ModelElementId modelElementId = operation.getModelElementId();
		if (objectsOfWork.containsKey(modelElementId)) {
			if (changes.containsKey(modelElementId)) {
				changes.get(modelElementId).add(operation);
			} else {
				ArrayList<AbstractOperation> arrayList = new ArrayList<AbstractOperation>();
				arrayList.add(operation);
				changes.put(modelElementId, arrayList);
			}
			getExcludedOperations().add(operation.getOperationId());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.dashboard.notificationProviders.AbstractNotificationProvider#createNotifications()
	 */
	@Override
	protected List<ESNotification> createNotifications() {
		List<ESNotification> result = new ArrayList<ESNotification>();
		for (ModelElementId meId : changes.keySet()) {
			ESNotification createNotification = createNotification(meId, changes.get(meId), objectsOfWork.get(meId),
				getProjectSpace());
			result.add(createNotification);
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.dashboard.notificationProviders.AbstractNotificationProvider#init()
	 */
	@Override
	protected void init() {
		super.init();
		objectsOfWork = OpeningLinkHelper.getObjectsOfWork(getUser());
		changes.clear();

	}

	private boolean filter(AbstractOperation operation) {
		if (OperationsPackage.eINSTANCE.getReferenceOperation().isInstance(operation)) {
			ReferenceOperation referenceOperation = (ReferenceOperation) operation;
			String featureName = TaskPackage.eINSTANCE.getWorkPackage_ContainedWorkItems().getName();
			if (referenceOperation.getFeatureName().equals(featureName)
				|| (referenceOperation.getOppositeFeatureName() != null && referenceOperation.getOppositeFeatureName()
					.equals(featureName))) {
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
		Set<ModelElementId> relatedElementSet = new HashSet<ModelElementId>();
		for (AbstractOperation operation : list) {
			relatedElementSet.add(operation.getModelElementId());
			notification.getRelatedOperations().add(operation.getOperationId());
		}
		notification.getRelatedModelElements().addAll(relatedElementSet);
		EObject modelElement = project.getModelElement(meId);
		StringBuilder message = new StringBuilder();
		message.append(modelElement.eClass().getName());
		message.append(" ");
		message.append(NotificationHelper.getHTMLLinkForModelElement(meId, projectSpace));
		message.append(" has been modified.");
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
		notification.setProject(EcoreUtil.copy(getProjectSpace().getProjectId()));
		notification.setName("Task Object Change");
		notification.setRecipient(getUser().getName());
		notification.setProvider(getName());
		return notification;
	}

	/**
	 * {@inheritDoc}
	 */
	public DashboardKey getKey() {
		return DashboardKey.TASK_TRACE_PROVIDER;
	}
}
