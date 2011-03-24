/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.AdminBroker;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.util.DialogHandler;

/**
 * This is the right side of OrgUnitManagementGUI. It shows the properties of
 * selected item.
 * 
 * @author Hodaie
 */
public class PropertiesForm extends Form {

	private EObject input;
	private StackLayout stackLayout;
	private ProjectComposite projectComposite;
	private GroupComposite groupComposite;
	private UserComposite userComposite;
	private AdminBroker adminBroker;

	/**
	 * This is a place holder for object being dragged. Actually we should have
	 * used the Transfer class to extract drag source. But it is not guaranteed
	 * to work always.
	 */
	private static EObject dragNDropObject;

	/**
	 * This is a string variable indicating from where drag and drop operation
	 * started.
	 */
	private static String dragSource = "";

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            parent
	 * @param style
	 *            SWT style
	 * @param adminBroker
	 *            AdminBroker used to communicate with server
	 * @param orgUnitManagementGUI
	 *            This is used by OrgUnit properties composites to get currently
	 *            selected tab and if needed refresh its ListViewer.
	 */
	public PropertiesForm(Composite parent, int style, AdminBroker adminBroker,
			OrgUnitManagementGUI orgUnitManagementGUI) {
		super(parent, style);

		stackLayout = new StackLayout();
		getBody().setLayout(stackLayout);
		this.adminBroker = adminBroker;
		initComposites(orgUnitManagementGUI, getBody());

	}

	private void initComposites(OrgUnitManagementGUI orgUnitMgmtGUI,
			Composite body) {
		projectComposite = new ProjectComposite(body, SWT.NONE, adminBroker);
		groupComposite = new GroupComposite(body, SWT.NONE, adminBroker,
				orgUnitMgmtGUI);
		userComposite = new UserComposite(body, SWT.NONE, adminBroker,
				orgUnitMgmtGUI);

		stackLayout.topControl = projectComposite;

	}

	/**
	 * This is used from tab contents to set input of properties form.
	 * 
	 * @param input
	 *            input
	 */
	public void setInput(EObject input) {
		String title = "";
		if (input != null && !(getBody().isVisible())) {
			getBody().setVisible(true);
		}

		if (input instanceof ProjectInfo) {
			ProjectInfo projectInfo = (ProjectInfo) input;
			title = "Project: " + projectInfo.getName();
			stackLayout.topControl = projectComposite;
			projectComposite.updateControls(projectInfo);

		} else if (input instanceof ACGroup) {
			ACGroup group;
			try {
				group = (ACGroup) adminBroker.getOrgUnit(((ACGroup) input)
						.getId());
				title = "Group: " + group.getName();
				stackLayout.topControl = groupComposite;
				groupComposite.updateControls(group);
			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
			}

		} else if (input instanceof ACUser) {
			ACUser user;
			try {
				user = (ACUser) adminBroker
						.getOrgUnit(((ACUser) input).getId());
				title = "User: " + user.getName();
				stackLayout.topControl = userComposite;
				userComposite.updateControls(user);
			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}
		if (input == null) {
			if (getBody().isVisible()) {
				getBody().setVisible(false);
			}

		}
		getBody().layout();
		this.setText(title);
		this.input = input;

	}

	/**
	 * This will be called from a tabContents to handle following situation. If
	 * form input is a project, and from users of groups tab one of participants
	 * of this project is deleted, then the table viewer on project properties
	 * must be updated. Accordingly, if a group is open and one of its users is
	 * deleted, or if a user is open and one of its groups is deleted.
	 * 
	 * @return tableViewer on properties form.
	 */
	public TableViewer getTableViewer() {

		return ((PropertiesComposite) stackLayout.topControl).getTableViewer();

	}

	/**
	 * This is used by tab contents upon deleting an OrgUnit. If current input
	 * is the same as deleted OrgUnit, the input will be set to null.
	 * 
	 * @return current input of properties form.
	 */
	public EObject getCurrentInput() {
		return input;
	}

	/**
	 * This is a place holder for object being dragged. Actually we should have
	 * used the Transfer class to extract drag source. But it is not guaranteed
	 * to work always.
	 * 
	 * @param dragNDropObject
	 *            object being drag and dropped
	 */
	public static void setDragNDropObject(EObject dragNDropObject) {
		PropertiesForm.dragNDropObject = dragNDropObject;
	}

	/**
	 * This is a place holder for object being dragged. Actually we should have
	 * used the Transfer class to extract drag source. But it is not guaranteed
	 * to work always.
	 * 
	 * @return object being drag and dropped
	 */
	public static EObject getDragNDropObject() {
		return dragNDropObject;
	}

	/**
	 * This is a string variable indicating from which tab drag and drop
	 * operation started. Drag and drop operations starting from properties form
	 * do not need to indicate it, because they involve just a delete (removing
	 * some element, e.g. a user from a group).
	 * 
	 * @param dragSource
	 *            drag source
	 */
	public static void setDragSource(String dragSource) {
		PropertiesForm.dragSource = dragSource;
	}

	/**
	 * This is used by drop adapter of properties form to find out from which
	 * tab DnD operation started.
	 * 
	 * @return a string indicating drag source
	 */
	public static String getDragSource() {
		return dragSource;
	}

}
