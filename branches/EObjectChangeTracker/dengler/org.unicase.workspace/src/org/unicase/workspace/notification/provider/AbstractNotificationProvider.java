/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.Project;
import org.unicase.model.organization.User;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Abstract class to define common structure and behavior of the notification providers.
 * 
 * @author Shterev
 */
public abstract class AbstractNotificationProvider implements NotificationProvider {

	private User user;

	/**
	 * Implements the common sanity checks and delegates to {@link #createNotifications(ProjectSpace, List, String)} and
	 * {@link #handleOperation(AbstractOperation, User, Project)}.<br>
	 * <br>
	 * All subclasses should mainly implement two methods:<br> {@link #handleOperation(AbstractOperation, User, Project)} -
	 * to process a single operation and acquire information and
	 * {@link #createNotifications(ProjectSpace, List, String)} - to create notification from the gathered data. <br>
	 * <br>
	 * These methods are separated in order to introduce flexibility in each provider's implementation. Instead of
	 * feeding a single list with elements and returning it as a value,
	 * {@link #handleOperation(AbstractOperation, User, Project)} can divide the elements in groups which can later on
	 * be used to generate different types of notifications.<br>
	 * As an example - the task notification provider gathers data and saves it in 3 categories, which will be
	 * responsible for 3 different notification types. {@inheritDoc}
	 */
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {
		// sanity checks
		List<ESNotification> result = new ArrayList<ESNotification>();
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
		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				if (operation instanceof CompositeOperation) {
					for (AbstractOperation op : ((CompositeOperation) operation).getSubOperations()) {
						handleOperation(op, user, project);
					}
				} else if (operation instanceof CreateDeleteOperation) {
					handleOperation(operation, user, project);
					for (AbstractOperation op : ((CreateDeleteOperation) operation).getSubOperations()) {
						handleOperation(op, user, project);
					}
				} else {
					handleOperation(operation, user, project);
				}
			}
		}

		result.addAll(createNotifications(projectSpace, changePackages, currentUsername));

		return result;
	}

	/**
	 * Filters all unwanted operation and returns a reference operation if applicable.
	 * 
	 * @param operation abstract operation
	 * @return the reference operation or null if there is no reference operation
	 */
	protected ReferenceOperation getReferenceOperation(AbstractOperation operation) {
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
	 * Handles a single operation.
	 * 
	 * @param operation the operation
	 * @param user the user
	 * @param project the project
	 */
	protected abstract void handleOperation(AbstractOperation operation, User user, Project project);

	/**
	 * Creates .
	 * 
	 * @param projectSpace the projectSpace
	 * @param changePackages the changePackages
	 * @param currentUsername the currentUsername
	 * @return the list of generated notifications
	 */
	protected abstract List<ESNotification> createNotifications(ProjectSpace projectSpace,
		List<ChangePackage> changePackages, String currentUsername);

	/**
	 * @return the user.
	 */
	protected User getUser() {
		return user;
	}

}
