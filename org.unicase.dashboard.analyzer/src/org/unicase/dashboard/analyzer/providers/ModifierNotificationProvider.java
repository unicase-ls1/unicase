/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.analyzer.providers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.notification.provider.NotificationHelper;

/**
 * Provides creator notifications.
 * 
 * @author shterev
 */
public class ModifierNotificationProvider implements NotificationProvider {

	private ProjectSpace projectSpace;
	private String user;
	private List<ESNotification> result;
	private Set<ModelElementId> watchList;

	/**
	 * Default constructor.
	 */
	public ModifierNotificationProvider() {
		watchList = new HashSet<ModelElementId>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return "Modifier Notification Provider";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#provideNotifications(org.unicase.workspace.ProjectSpace,
	 *      java.util.List, java.lang.String)
	 */
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {

		this.projectSpace = projectSpace;
		this.user = currentUsername;
		this.result = new ArrayList<ESNotification>();

		if (projectSpace == null || user == null) {
			return result;
		}

		for (ChangePackage changePackage : changePackages) {
			final Date date = changePackage.getLogMessage().getClientDate();
			for (AbstractOperation operation : changePackage.getOperations()) {
				if (operation instanceof AttributeOperation) {
					AttributeOperation attributeOperation = (AttributeOperation) operation;
					ModelElementId modelElementId = attributeOperation.getModelElementId();
					createNotification(modelElementId, date);
				} else if (operation instanceof SingleReferenceOperation) {
					SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) operation;
					ModelElementId newValue = singleReferenceOperation.getNewValue();
					ModelElementId oldValue = singleReferenceOperation.getOldValue();
					ModelElementId referee = singleReferenceOperation.getModelElementId();
					createNotification(newValue, date);
					createNotification(oldValue, date);
					createNotification(referee, date);
				} else if (operation instanceof MultiReferenceOperation) {
					MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) operation;
					EList<ModelElementId> referencedModelElements = multiReferenceOperation
						.getReferencedModelElements();
					for (ModelElementId mid : referencedModelElements) {
						createNotification(mid, date);
					}
				}
				if (operation instanceof ReferenceOperation) {
					Set<ModelElementId> others = ((ReferenceOperation) operation).getOtherInvolvedModelElements();
					for (ModelElementId mid : others) {
						createNotification(mid, date);
					}
				}
			}
		}

		return result;

	}

	private void createNotification(ModelElementId mid, Date date) {

		ModelElement modelElement = projectSpace.getProject().getModelElement(mid);
		if (modelElement != null && watchList.contains(mid) && !ModelPackage.eINSTANCE.getNonDomainElement().isInstance(modelElement)) {
			ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
			notification.setCreationDate(date);
			notification.setSender(getName());
			notification.setName("Modifier notification");
			notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
			notification.setRecipient(user);
			notification.setSeen(false);
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("A");
			String className = modelElement.eClass().getName();
			if (className.startsWith("A")) {
				stringBuilder.append("n");
			}
			stringBuilder.append(" ");
			stringBuilder.append(className);
			stringBuilder.append(" ");
			stringBuilder.append("that you modified has been changed.");
			stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(mid, projectSpace, false));
			String message = stringBuilder.toString();
			notification.setMessage(message);
			notification.getRelatedModelElements().add((ModelElementId)EcoreUtil.copy(mid));
			result.add(notification);
		}
	}

	/**
	 * @return the watch list of modified objects
	 */
	public Set<ModelElementId> getWatchList() {
		return watchList;
	}
}
