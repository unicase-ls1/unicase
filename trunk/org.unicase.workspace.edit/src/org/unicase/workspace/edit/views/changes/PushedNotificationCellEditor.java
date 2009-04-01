/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.views.changes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.model.ModelElementId;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.ui.common.util.URLHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * Cell editor for choosing the user for the pushed notifications.
 * 
 * @author Shterev
 */
public class PushedNotificationCellEditor extends DialogCellEditor {

	private Label label;
	private ProjectSpace projectSpace;
	private String currentUser;
	private Tree tree;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent composite.
	 * @param projectSpace the project space - is resolved in the editing support to reduce redundant calls.
	 * @param currentUser the user sending the notifications - is resolved in the editing support to reduce redundant
	 *            calls.
	 */
	public PushedNotificationCellEditor(final Composite parent, ProjectSpace projectSpace, String currentUser) {
		super(parent, SWT.NONE);
		this.tree = (Tree) parent;
		this.projectSpace = projectSpace;
		this.currentUser = currentUser;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Object openDialogBox(final Control cellEditorWindow) {
		Object value = getValue();
		if (value instanceof ArrayList) {
			final ArrayList<ESNotification> operations = ((ArrayList<ESNotification>) value);
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(cellEditorWindow.getShell(),
				labelProvider);
			EList<OrgUnit> users = new BasicEList<OrgUnit>();
			projectSpace.getProject().getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getOrgUnit(), users,
				true);
			dialog.setElements(users.toArray());
			dialog.setTitle("User selection");
			dialog.setMessage("Please select the users that should be notified:");
			dialog.setMultipleSelection(true);
			if (dialog.open() == IDialogConstants.OK_ID) {
				Object[] results = dialog.getResult();
				operations.clear();
				handleResults(operations, results);
				return operations;
			}
		}
		return null;
	}

	private void handleResults(final ArrayList<ESNotification> operations, final Object[] results) {
		String comment = null;
		if (results.length > 0) {
			if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Notification comment",
				"Do you want to send a comment with this notification?")) {
				InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(),
					"Notification comment", "Your comment on this notification:", null, null);
				if (inputDialog.open() == IDialogConstants.OK_ID) {
					comment = inputDialog.getValue();
				}
			}
		}
		for (Object o : results) {
			OrgUnit orgUnit = (OrgUnit) o;
			ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
			notification.setCreationDate(new Date());
			notification.setName("Pushed name");
			ProjectId projectIdCopy = (ProjectId) EcoreUtil.copy(projectSpace.getProjectId());
			notification.setProject(projectIdCopy);
			notification.setRecipient(orgUnit.getName());
			StringBuilder msgBuilder = new StringBuilder();
			msgBuilder.append(currentUser);
			msgBuilder.append(" sent you a notification about this change: ");
			Object data = tree.getSelection()[0].getData();
			if (data instanceof AbstractOperation) {
				AbstractOperation op = (AbstractOperation) data;
				ModelElementId modelElementIdCopy = (ModelElementId) EcoreUtil.copy(op.getModelElementId());
				msgBuilder.append(shortenDescription(op.getDescription()));
				msgBuilder.append(" in ");
				msgBuilder.append(URLHelper.getHTMLLinkForModelElement(modelElementIdCopy, projectSpace,
					URLHelper.UNLTD));
				notification.getRelatedModelElements().add(modelElementIdCopy);
				if (OperationsPackage.eINSTANCE.getReferenceOperation().isInstance(op)) {
					ReferenceOperation referenceOp = (ReferenceOperation) op;
					Set<ModelElementId> otherInvolvedModelElements = referenceOp.getOtherInvolvedModelElements();
					if (otherInvolvedModelElements.size() > 0) {
						msgBuilder.append(" (<a href=\"more\">details</a>) ");
						for (ModelElementId id : otherInvolvedModelElements) {
							ModelElementId idCopy = (ModelElementId) EcoreUtil.copy(id);
							notification.getRelatedModelElements().add(idCopy);
						}
					}
				}
			}
			if (comment != null) {
				msgBuilder.append("%%%");
				msgBuilder.append(comment);
			}
			notification.setMessage(msgBuilder.toString());
			operations.add(notification);
		}
	}

	private String shortenDescription(String description) {
		String ret = description.trim();
		String[] fromTo = ret.split("\" to \"");
		if (fromTo.length == 2) {
			String[] fromLines = fromTo[0].split("\n");
			String[] toLines = fromTo[1].split("\n");
			if (fromLines.length > 1) {
				ret = fromLines[1] + " ... " + fromLines[fromLines.length - 1];
			} else {
				ret = fromLines[0];
			}
			ret += "\" to \"";
			if (toLines.length > 1) {
				ret += toLines[1] + " ... " + toLines[toLines.length - 1];
			} else {
				ret += toLines[0];
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(final Composite cell) {
		// return the control on an edit-request
		this.label = new Label(cell, SWT.NONE);
		return this.label;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void updateContents(final Object value) {
		// updating the control
		if (label != null && value != null && value instanceof ArrayList) {
			StringBuilder ret = new StringBuilder();
			ArrayList<ESNotification> notifications = (ArrayList<ESNotification>) value;
			for (ESNotification n : notifications) {
				ret.append(n.getRecipient());
				ret.append("  ");
			}
			label.setText(ret.toString());
		}
	}

}
