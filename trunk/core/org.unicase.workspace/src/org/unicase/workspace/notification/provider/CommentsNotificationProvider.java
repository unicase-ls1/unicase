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

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Comment;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Provides notifications for new comments.
 * 
 * @author shterev
 */
public class CommentsNotificationProvider implements NotificationProvider {

	private HashMap<Comment, Date> comments;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return "Comments Notification Provider";
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

		Project project = projectSpace.getProject();
		comments = new HashMap<Comment, Date>();
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

		for (Comment comment : comments.keySet()) {
			result.add(createNotification(projectSpace, user, comment));
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

		Comment comment = extractComment(operation);
		if (comment != null) {

		}

	}

	private Comment extractComment(AbstractOperation operation) {
		if (operation instanceof CreateDeleteOperation) {
			CreateDeleteOperation createOperation = (CreateDeleteOperation) operation;
			if (createOperation.getModelElement() instanceof Comment) {
				return (Comment) createOperation.getModelElement();
			}
		}
		return null;
	}

	private ESNotification createNotification(ProjectSpace projectSpace, User user, Comment comment) {
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setName("New comment");
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(user.getName());
		notification.setSeen(false);
		notification.setSender(getName());
		StringBuilder stringBuilder = new StringBuilder();
		String text = stringBuilder.toString();
		notification.setMessage(text);
		Date date = comments.get(comment);
		if (date == null) {
			date = new Date();
		}
		notification.setCreationDate(date);
		return notification;
	}
}
