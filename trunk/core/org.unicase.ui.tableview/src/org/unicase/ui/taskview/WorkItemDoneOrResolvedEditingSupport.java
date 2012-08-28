/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.taskview;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;

/**
 * Editing support for a checkbox column.
 * 
 * @author helming
 */
public class WorkItemDoneOrResolvedEditingSupport extends EditingSupport {

	private CheckboxCellEditor cellEditor;
	private User currentUser;

	/**
	 * default constructor.
	 * 
	 * @param viewer
	 *            The viewer
	 * @param currentUser
	 *            the current user of task view
	 */
	public WorkItemDoneOrResolvedEditingSupport(TableViewer viewer,
			User currentUser) {
		super(viewer);
		this.setCurrentUser(currentUser);
		cellEditor = new CheckboxCellEditor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean canEdit(Object element) {
		return (element instanceof Checkable);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		if (element instanceof Checkable) {
			return cellEditor;
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TableViewer getViewer() {
		return (TableViewer) super.getViewer();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getValue(Object element) {
		if (element instanceof WorkItem) {
			WorkItem workItem = (WorkItem) element;
			if (((Checkable) element).isChecked()) {
				return true;
			}
			if (isCurrentUserReviewer(workItem)) {
				return ((Checkable) element).isChecked();
			} else if (isCurrentUserAssigneeOrCreator(workItem)) {
				return workItem.isResolved();
			}
		}
		if (element instanceof Checkable) {
			return ((Checkable) element).isChecked();
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValue(final Object element, final Object value) {
		if (!(element instanceof Checkable) || !(value instanceof Boolean)) {
			return;
		}
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				doSetValue(element, value);
			}
		}.run();

		getViewer().refresh();
	}

	private void doSetValue(Object element, Object value) {

		boolean isChecked = (Boolean) value;
		if (element instanceof WorkItem) {
			WorkItem workItem = (WorkItem) element;
			if (workItem.getReviewer() != null) {
				// if current user is the reviewer of work item, then set work
				// item to done
				// else, set it to resolved.
				if (isCurrentUserReviewer(workItem)) {
					((Checkable) workItem).setChecked(isChecked);
				} else if (isCurrentUserAssigneeOrCreator(workItem)) {
					// maybe if current user is assignee or creator of work
					// item. but generally:
					workItem.setResolved(isChecked);
				}
			} else {
				// work item has no reviewer. Show reviewer selection dialog if
				// it is checked, or set it not done and
				// not resolved regardless of who unchecks it.
				if (isChecked) {
					showReviewerSelectionDialog(workItem);
				} else {
					if (isCurrentUserReviewer(workItem)
							|| isCurrentUserAssigneeOrCreator(workItem)) {
						// set not checked (not done)
						// set not resolved
						((Checkable) workItem).setChecked(false);
						workItem.setResolved(false);
					}
				}
			}
		} else if (element instanceof Checkable) {
			final Checkable c = (Checkable) element;
			c.setChecked(isChecked);

		}
	}

	/**
	 * @param workItem
	 * @return
	 */
	private boolean isCurrentUserAssigneeOrCreator(WorkItem workItem) {
		if (currentUser == null) {
			return false;
		}
		OrgUnit assignee = workItem.getAssignee();
		String creator = workItem.getCreator();
		return currentUser.equals(assignee)
				|| currentUser.getName().equals(creator);
	}

	/**
	 * @param workItem
	 * @return
	 */
	private boolean isCurrentUserReviewer(WorkItem workItem) {
		if (currentUser == null) {
			return false;
		}
		if (workItem.getReviewer() == null) {
			return false;
		}
		return getCurrentUser().equals(workItem.getReviewer());
	}

	/**
	 * @param workItem
	 */
	private void showReviewerSelectionDialog(WorkItem workItem) {
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		ReviewerSelectionDialog reviwerSelectionDialog = new ReviewerSelectionDialog(
				this.getViewer().getControl().getShell(), labelProvider,
				workItem);
		reviwerSelectionDialog
				.setMessage(ReviewerSelectionDialog.REVIEWERSELECTIONDIALOG_MESSAGE);

		Project project = ModelUtil.getProject(workItem);
		List<User> users = project
				.getAllModelElementsbyClass(
						OrganizationPackage.eINSTANCE.getUser(),
						new BasicEList<User>());
		reviwerSelectionDialog.setElements(users.toArray());
		reviwerSelectionDialog.open();
	}

	/**
	 * @param currentUser
	 *            the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}

}
