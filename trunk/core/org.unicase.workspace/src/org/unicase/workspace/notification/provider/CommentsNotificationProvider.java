/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Comment;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Provides notifications for new comments.
 * 
 * @author shterev
 */
public class CommentsNotificationProvider extends AbstractNotificationProvider {

	private HashMap<Comment, Date> personalComments;
	private HashMap<Comment, Date> directReplies;
	private HashMap<Comment, Date> threadReplies;
	private HashMap<Comment, Date> taskComments;

	/**
	 * The name.
	 */
	public static final String NAME = "Comments Notification Provider";

	/**
	 * Default constructor.
	 */
	public CommentsNotificationProvider() {
		personalComments = new HashMap<Comment, Date>();
		directReplies = new HashMap<Comment, Date>();
		threadReplies = new HashMap<Comment, Date>();
		taskComments = new HashMap<Comment, Date>();
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
	protected List<ESNotification> createNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {
		List<ESNotification> result = new ArrayList<ESNotification>();
		if (projectSpace.hasProperty(DashboardKey.COMMENTS_PROVIDER)) {
			OrgUnitProperty commentsProviderProperty = PreferenceManager.INSTANCE.getProperty(projectSpace,
				DashboardKey.COMMENTS_PROVIDER);
			if (commentsProviderProperty.getBooleanProperty()) {
				for (Comment comment : personalComments.keySet()) {
					result.add(createPersonalCommentNotification(projectSpace, getUser(), comment));
				}
				for (Comment comment : directReplies.keySet()) {
					result.add(createDirectReplyNotification(projectSpace, getUser(), comment));
				}
				for (Comment comment : taskComments.keySet()) {
					result.add(createTaskCommentNotification(projectSpace, getUser(), comment));
				}
				OrgUnitProperty threadRepliesProperty = PreferenceManager.INSTANCE.getProperty(projectSpace,
					DashboardKey.SHOW_CONTAINMENT_REPLIES);
				if (threadRepliesProperty.getBooleanProperty()) {
					for (Comment comment : threadReplies.keySet()) {
						result.add(createThreadCommentNotification(projectSpace, getUser(), comment));
					}
				}
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleOperation(AbstractOperation operation, User user, Project project) {
		ModelElement modelElement = project.getModelElement(operation.getModelElementId());
		if (modelElement == null) {
			// the ME was deleted from the project.
			return;
		}

		if (operation instanceof CreateDeleteOperation && modelElement instanceof Comment) {
			handleCreateDeleteOperation(operation, user, modelElement);
		}
	}

	private void handleCreateDeleteOperation(AbstractOperation operation, User user, ModelElement modelElement) {
		Comment localComment = (Comment) modelElement;
		if (localComment.getCommentedElement() instanceof Comment
			&& ((Comment) localComment.getCommentedElement()).getSender() != null
			&& ((Comment) localComment.getCommentedElement()).getSender().equals(user)) {
			directReplies.put(localComment, operation.getClientDate());
			return;
		}
		if (localComment.getRecipients().contains(user)) {
			personalComments.put(localComment, operation.getClientDate());
			return;
		}
		ModelElement firstParent = localComment.getFirstParent();
		Set<Group> groups = OrgUnitHelper.getAllGroupsOfOrgUnit(user);
		if (firstParent instanceof WorkItem && ((WorkItem) firstParent).getAssignee().equals(user)
			|| groups.contains(((WorkItem) firstParent).getAssignee())
			|| ((WorkItem) firstParent).getReviewer().equals(user)) {
			taskComments.put(localComment, operation.getClientDate());
			return;
		}
		List<ModelElement> parents = localComment.getParents();
		for (ModelElement me : parents) {
			if (me instanceof Comment && ((Comment) me).getSender() != null && ((Comment) me).getSender().equals(user)) {
				threadReplies.put(localComment, operation.getClientDate());
			}
		}
	}

	private ESNotification createNotification(ProjectSpace projectSpace, User user, Comment comment, Date date) {
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setName("New comment notification");
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(user.getName());
		notification.setSeen(false);
		notification.setProvider(getName());
		notification.getRelatedModelElements().add(comment.getModelElementId());
		if (date == null) {
			date = new Date();
		}
		notification.setCreationDate(date);
		return notification;
	}

	private ESNotification createDirectReplyNotification(ProjectSpace projectSpace, User user, Comment comment) {
		Date date = directReplies.get(comment);
		ESNotification notification = createNotification(projectSpace, user, comment, date);
		ModelElement rootElement = comment.getFirstParent();

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(comment.getSender(), projectSpace));
		stringBuilder.append(" replied to a comment of yours in the discussion thread for ");
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(rootElement, projectSpace));
		String text = stringBuilder.toString();
		notification.setMessage(text);
		return notification;
	}

	private ESNotification createPersonalCommentNotification(ProjectSpace projectSpace, User user, Comment comment) {
		Date date = personalComments.get(comment);
		ESNotification notification = createNotification(projectSpace, user, comment, date);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(comment.getSender(), projectSpace));
		stringBuilder.append(" sent you a comment: ");
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(comment, projectSpace));
		String text = stringBuilder.toString();
		notification.setMessage(text);
		return notification;
	}

	private ESNotification createTaskCommentNotification(ProjectSpace projectSpace, User user, Comment comment) {
		Date date = personalComments.get(comment);
		ESNotification notification = createNotification(projectSpace, user, comment, date);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(comment.getSender(), projectSpace));
		stringBuilder.append(" commented on a WorkItem of yours: ");
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(comment.getFirstParent(), projectSpace));
		String text = stringBuilder.toString();
		notification.setMessage(text);
		return notification;
	}

	private ESNotification createThreadCommentNotification(ProjectSpace projectSpace, User user, Comment comment) {
		Date date = personalComments.get(comment);
		ESNotification notification = createNotification(projectSpace, user, comment, date);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(comment.getSender(), projectSpace));
		stringBuilder.append(" commented in the thread for ");
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(comment.getFirstParent(), projectSpace));
		String text = stringBuilder.toString();
		notification.setMessage(text);
		return notification;
	}
}
