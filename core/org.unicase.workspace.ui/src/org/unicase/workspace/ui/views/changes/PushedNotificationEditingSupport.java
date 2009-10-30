/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.model.organization.User;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.common.util.OrgUnitHelper;
import org.unicase.ui.common.util.URLHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.NoCurrentUserException;

/**
 * Editing support for pushed notifications.
 * 
 * @author Shterev
 */
public class PushedNotificationEditingSupport extends EditingSupport {

	private PushedNotificationCellEditor cellEditor;
	private HashMap<AbstractOperation, ArrayList<ESNotification>> notificationMap;

	/**
	 * Default constructor.
	 * 
	 * @param viewer
	 *            a viewer
	 * @param notificationMap
	 *            the map containing the lists of notifications per operation
	 */
	public PushedNotificationEditingSupport(
			ColumnViewer viewer,
			HashMap<AbstractOperation, ArrayList<ESNotification>> notificationMap) {
		super(viewer);
		this.notificationMap = notificationMap;
		ProjectSpace projectSpace = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace();
		String currentUser;
		try {
			User currentOrgUnit = OrgUnitHelper.getUser(projectSpace);
			currentUser = URLHelper.getHTMLLinkForModelElement(currentOrgUnit,
					projectSpace, URLHelper.UNLTD);
		} catch (NoCurrentUserException e) {
			currentUser = projectSpace.getUsersession().getUsername();
		} catch (CannotMatchUserInProjectException e) {
			currentUser = projectSpace.getUsersession().getUsername();
		}

		cellEditor = new PushedNotificationCellEditor(((TreeViewer) viewer)
				.getTree(), projectSpace, currentUser);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean canEdit(Object element) {
		return (element instanceof AbstractOperation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getValue(Object element) {
		if (!OperationsPackage.eINSTANCE.getAbstractOperation().isInstance(
				element)) {
			// return the element itself if the element does not apply
			return element;
		}
		AbstractOperation abstractOperation = (AbstractOperation) element;
		return notificationMap.get(abstractOperation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValue(Object element, Object value) {
		getViewer().refresh(true);
	}
}
