/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.multiaction.navigator.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.ui.common.util.ShortLabelProvider;
import org.unicase.ui.multiaction.MultiActionGenerator;

/**
 * @author jfinis Main wizard page of the MultiactionWizard. Contains a list of future assignees.
 */
public class ChooseAssigneePage extends WizardPage {

	// Title and description
	private static final String PAGE_TITLE = "Multiple Assignees";
	private static final String PAGE_DESCRIPTION = "Select assignees for this action item.";

	// The currently selected users, see getSelected() method for more details
	private List<User> selected;

	// The wizard containing this page
	private MultiactionWizard parentWizard;

	private AdapterFactoryLabelProvider labelProvider;

	// The table containing the selected list
	private Table table;

	// Control buttons and their listener
	private Button addButton;
	private Button removeSelectedButton;
	private Button removeAllButton;
	private AssigneePageListener listener;

	/**
	 * Returns the current list of assignees selected for the ActionItem. This list exactly reflects the users visible
	 * in the dialog's table.
	 * 
	 * @return Current list of assignees.
	 */
	List<User> getSelected() {
		return selected;
	}

	/**
	 * Default Constructor.
	 * 
	 * @param pageName page name, to be handed to the super constructor
	 * @param multiactionWizard the wizard containing this page
	 */
	protected ChooseAssigneePage(String pageName, MultiactionWizard multiactionWizard) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		selected = new ArrayList<User>();
		parentWizard = multiactionWizard;
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		listener = new AssigneePageListener();
	}

	/**
	 * . ({@inheritDoc}) Note that after the control creation, the add-user-dialog is immediately shown. This is done
	 * because everybody using this dialog wants to add users and thus wants to open the add user dialog, so it is done
	 * automatically at the beginning.
	 */
	public void createControl(Composite parent) {
		// Create composite
		Composite composite = new Composite(parent, SWT.NULL);

		// Layout stuff
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);

		// The table displaying the currently selected assignees
		table = new Table(composite, SWT.BORDER | SWT.MULTI);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		table.addSelectionListener(listener);

		// Buttons
		addButton = new Button(composite, SWT.PUSH);
		addButton.setText("Add..");
		addButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		addButton.setToolTipText("Add additional assignees or groups of assignees to the list");
		addButton.addListener(SWT.Selection, listener);

		removeSelectedButton = new Button(composite, SWT.PUSH);
		removeSelectedButton.setText("Remove Selected");
		removeSelectedButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		removeSelectedButton.setEnabled(false);
		removeSelectedButton.setToolTipText("Remove the selected assignees from the list");
		removeSelectedButton.addListener(SWT.Selection, listener);

		removeAllButton = new Button(composite, SWT.PUSH);
		removeAllButton.setText("Remove All");
		removeAllButton.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		removeAllButton.setEnabled(false);
		removeAllButton.setToolTipText("Remove all assignees from the list");
		removeAllButton.addListener(SWT.Selection, listener);

		// Set control, update table (clear it) and show the user-add-dialog
		setControl(composite);
		updateUI();
		showUserDialog();
	}

	/**
	 * Shows the user-add-dialog.
	 */
	private void showUserDialog() {
		ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
		String name = shortLabelProvider.getText(parentWizard.getSelectedActionItem());
		AddUserDialog au = new AddUserDialog(ModelUtil.getProject(parentWizard.getSelectedActionItem()),
			"Choose users and/or groups as assignees for action item \"" + name + "\"");
		if (au.open() == Window.OK) {
			Object[] result = au.getResult();

			if (result.length > 0) {
				// If users/groups were selected, flatten them and add them to the selected users.
				// Afterwards update the user interface
				List<OrgUnit> list = new ArrayList<OrgUnit>(result.length);
				for (Object o : result) {
					if (o instanceof OrgUnit) {
						list.add((OrgUnit) o);
					}
				}
				list.addAll(selected);
				selected = MultiActionGenerator.flattenOrgList(list);
				updateUI();
			}
		}

	}

	/**
	 * Updates the user table and all buttons (enabling or disabling them) and sets an error message if only one user is
	 * currently selected.
	 */
	private void updateUI() {
		// Turn off drawing to avoid flicker
		table.setRedraw(false);

		// Truncate table
		table.removeAll();

		// Repopulate table from selection
		for (User u : selected) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(u);
			item.setImage(labelProvider.getImage(u));
			item.setText(u.getName());
		}

		// Turn drawing back on!
		table.setRedraw(true);

		// If the table is not empty, the wizard may finish and the remove all button may be used
		if (!selected.isEmpty()) {
			removeAllButton.setEnabled(true);
			if (selected.size() == 1) {
				setErrorMessage("Only one assignee selected. No need to split up the action item!");
				parentWizard.setCanFinish(false);
				setPageComplete(false);
			} else {
				parentWizard.setCanFinish(true);
				setErrorMessage(null);
				setPageComplete(true);
			}

		} else {
			parentWizard.setCanFinish(false);
			removeAllButton.setEnabled(false);
			setErrorMessage(null);
			setPageComplete(false);
		}

		// Since we just rebuilt the table, there cannot be any selected items, so disable the remove selected button
		removeSelectedButton.setEnabled(false);
	}

	/**
	 * Listener handling button pressed events and selection events in the table.
	 * 
	 * @author jfinis
	 */
	private class AssigneePageListener implements Listener, SelectionListener {

		public void handleEvent(Event event) {
			Widget w = event.widget;
			if (w == addButton) {
				showUserDialog();
			} else if (w == removeAllButton) {
				selected.clear();
				updateUI();
			} else if (w == removeSelectedButton) {

				// O(n²) complexity, but we won't have more than a dozen users in the table, so it's okay I guess
				// Otherwise, we could refactor it to a linked hashmap or something similar
				TableItem[] selects = table.getSelection();
				for (TableItem t : selects) {
					if (t.getData() instanceof User) {
						User u = (User) t.getData();
						selected.remove(u);
					}
				}

				updateUI();
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			// Button is only enabled if objects are selected
			removeSelectedButton.setEnabled(table.getSelection().length > 0);
		}

	}
}