/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.CreateDeleteOperation;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.MultiReferenceOperation;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationId;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.ReferenceOperation;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.SingleReferenceOperation;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.model.organization.User;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * Abstract class to define common structure and behavior of the notification providers.
 * 
 * @author Shterev
 */
public abstract class AbstractNotificationProvider implements NotificationProvider {

	private User user;
	private Set<OperationId> excludedList;
	private ProjectSpace projectSpace;

	/**
	 * Default constructor.
	 */
	public AbstractNotificationProvider() {
		excludedList = new HashSet<OperationId>();
	}

	/**
	 * Implements the common sanity checks and delegates to {@link #createNotifications(List, String)} and
	 * {@link #handleOperation(AbstractOperation)}.<br>
	 * <br>
	 * All subclasses should mainly implement two methods:<br>
	 * {@link #handleOperation(AbstractOperation)} - to process a single operation and acquire information and
	 * {@link #createNotifications(List, String)} - to create notification from the gathered data. <br>
	 * <br>
	 * These methods are separated in order to introduce flexibility in each provider's implementation. Instead of
	 * feeding a single list with elements and returning it as a value, {@link #handleOperation(AbstractOperation)} can
	 * divide the elements in groups which can later on be used to generate different types of notifications.<br>
	 * As an example - the task notification provider gathers data and saves it in 3 categories, which will be
	 * responsible for 3 different notification types. {@inheritDoc}
	 */
	public List<DashboardNotification> provideNotifications(ProjectSpace projectSpace,
		List<ChangePackage> changePackages) {
		List<DashboardNotification> result = new ArrayList<DashboardNotification>();

		try {
			User currentUser = OrgUnitHelper.getUser(projectSpace);
			return provideNotifications(projectSpace, changePackages, currentUser.getName());
		} catch (NoCurrentUserException e) {
			return result;
		} catch (CannotMatchUserInProjectException e) {
			return result;
		}
	}

	/**
	 * Implements the common sanity checks and delegates to {@link #createNotifications(List, String)} and
	 * {@link #handleOperation(AbstractOperation)}.<br>
	 * <br>
	 * All subclasses should mainly implement two methods:<br>
	 * {@link #handleOperation(AbstractOperation)} - to process a single operation and acquire information and
	 * {@link #createNotifications(List, String)} - to create notification from the gathered data. <br>
	 * <br>
	 * These methods are separated in order to introduce flexibility in each provider's implementation. Instead of
	 * feeding a single list with elements and returning it as a value, {@link #handleOperation(AbstractOperation)} can
	 * divide the elements in groups which can later on be used to generate different types of notifications.<br>
	 * As an example - the task notification provider gathers data and saves it in 3 categories, which will be
	 * responsible for 3 different notification types. {@inheritDoc}
	 */
	public List<DashboardNotification> provideNotifications(ProjectSpace projectSpace,
		List<ChangePackage> changePackages, String username) {
		// sanity checks
		List<DashboardNotification> result = new ArrayList<DashboardNotification>();
		if (projectSpace == null || username == null) {
			return result;
		}
		this.projectSpace = projectSpace;

		try {
			user = OrgUnitHelper.getUser(projectSpace, username);
		} catch (CannotMatchUserInProjectException e) {
			return result;
		}

		init();
		for (ChangePackage changePackage : changePackages) {
			if (changePackage == null) {
				continue;
			}
			if (changePackage.getLogMessage() != null
				&& changePackage.getLogMessage().getAuthor().equals(user.getName())) {
				continue;
			}
			for (AbstractOperation operation : changePackage.getOperations()) {
				if (operation instanceof CompositeOperation) {
					for (AbstractOperation op : ((CompositeOperation) operation).getSubOperations()) {
						checkAndHandleOperation(op);
					}
				} else if (operation instanceof CreateDeleteOperation) {
					checkAndHandleOperation(operation);
					for (AbstractOperation op : ((CreateDeleteOperation) operation).getSubOperations()) {
						checkAndHandleOperation(op);
					}
				} else {
					checkAndHandleOperation(operation);
				}
			}
		}

		result.addAll(createNotifications());

		return result;
	}

	private void checkAndHandleOperation(AbstractOperation op) {
		if (!getExcludedOperations().contains(op.getOperationId())) {
			handleOperation(op);
		}
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
	 */
	protected abstract void handleOperation(AbstractOperation operation);

	/**
	 * Creates the notifications.
	 * 
	 * @return the list of generated notifications
	 */
	protected abstract List<DashboardNotification> createNotifications();

	/**
	 * @return the user.
	 */
	protected User getUser() {
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<OperationId> getExcludedOperations() {
		return excludedList;
	}

	/**
	 * @return the projectspace.
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * initializes this provider.
	 */
	protected void init() {
	}

}
