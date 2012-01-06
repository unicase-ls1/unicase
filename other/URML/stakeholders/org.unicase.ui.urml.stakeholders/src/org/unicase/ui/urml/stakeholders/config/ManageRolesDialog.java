/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.config;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholders.StakeholderUtil;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Dialog for managing the stakeholder roles.
 * 
 * @author kterzieva
 */
public class ManageRolesDialog extends TitleDialogWithoutMinSize {

	private static final String EDIT_DIALOG = "Edit dialog";
	private static final String ADD_NEW_ROLE = "Add new role";
	private static final String EDIT_DIALOG_MESSAGE = "Edit the selected staleholder role";
	private static final String ADD_DIALOG_MESSAGE = "Create new stakeholder role";
	private static final String SELECT_STAKEHOLDER_ROLE = "Select stakeholder role";
	private static final String MANAGE_STAKEHOLDER_ROLES = "Manage stakeholder roles";
	private Button addButton, editButton;
	private Button removeSelectedButton;
	private ArrayList<UnicaseModelElement> stakeholderRoles;
	private Project activeProject;
	private TableViewer tableViewer;
	private TableViewerColumn viewerNameColumn;
	private ILabelProvider tableViewLabelProvider;
	private DeleteButtonListener dialogListener;

	/**
	 * The constructor. The list with the created roles is created.
	 * @param parentShell the shell
	 */
	public ManageRolesDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		activeProject = StakeholderUtil.getActiveProject();

	}

	private void setTableInput() {
		stakeholderRoles = new ArrayList<UnicaseModelElement>();
		Collection<EObject> basicList = activeProject
				.getAllModelElementsbyClass(
						UrmlPackage.eINSTANCE.getStakeholderRole(),
						new BasicEList<EObject>());

		for (EObject role : basicList) {
			stakeholderRoles.add((StakeholderRole) role);
		}
		tableViewer.setInput(stakeholderRoles);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

	}

	private void createEditDialog(StakeholderRole role) {
		EditRoleDialog editDialog = new EditRoleDialog(editButton.getShell(),
				role, EDIT_DIALOG, EDIT_DIALOG_MESSAGE);
		editDialog.open();

		// Refresh role, if currently active
		StakeholderRole activeRole = UrmlSettingsManager.INSTANCE
				.getActiveRole();
		if (role == activeRole) {
			UrmlSettingsManager.INSTANCE.setActiveRole(role);
		}
	}

	private void createAddDialog() {
		final StakeholderRole newRole = UrmlFactory.eINSTANCE
				.createStakeholderRole();
		EditRoleDialog addDialog = new EditRoleDialog(editButton.getShell(),
				newRole, ADD_NEW_ROLE, ADD_DIALOG_MESSAGE);
		addDialog.setBlockOnOpen(true);
		if (addDialog.open() == Window.OK) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					activeProject.addModelElement(newRole);
				}
			}.run();
			setTableInput();
		}

	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(MANAGE_STAKEHOLDER_ROLES);
		setMessage(SELECT_STAKEHOLDER_ROLE);
		Composite wrap = (Composite) super.createDialogArea(parent);

		Composite viewComposite = createViewComposite(wrap);
		tableViewSetUp(viewComposite);
		setTableInput();
		addListeners();
		createButtons(viewComposite);
		return viewComposite;
	}

	private Composite createViewComposite(Composite parent) {
		// Create composite
		Composite composite = new Composite(parent, SWT.NONE);
		// Layout stuff
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setFont(parent.getFont());
		return composite;
	}

	private void tableViewSetUp(Composite composite) {
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.MULTI);
		tableViewer.getControl().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 3, 0));
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		tableViewer.setLabelProvider(tableViewLabelProvider);
		viewerNameColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		viewerNameColumn.setLabelProvider(new CellLabelProvider() {
			public void update(ViewerCell cell) {
				cell.setText(tableViewLabelProvider.getText(cell.getElement()));
				cell.setImage(tableViewLabelProvider.getImage(cell.getElement()));
			}
		});
		viewerNameColumn.getColumn().setWidth(280);
	}

	private void addListeners() {
		dialogListener = new DeleteButtonListener(tableViewer, getShell(),
				activeProject);
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				createEditDialog(getSelection());
			}
		});
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						removeSelectedButton.setEnabled(true);
					}
				});
	}

	private void createButtons(Composite composite) {
		addButton = new Button(composite, SWT.PUSH);
		addButton.setText("Add role...");
		addButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false,
				false, 1, 1));
		addButton.setToolTipText("Add new stakeholder role");
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				createAddDialog();
			}
		});

		editButton = new Button(composite, SWT.PUSH);
		editButton.setText("Edit role...");
		editButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false,
				false, 1, 1));
		editButton.setToolTipText("Edit selected stakeholder role.");
		editButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				createEditDialog(getSelection());
			}
		});

		removeSelectedButton = new Button(composite, SWT.PUSH);
		removeSelectedButton.setText("Delete role");
		removeSelectedButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM,
				false, false, 1, 1));
		removeSelectedButton.setEnabled(false);
		removeSelectedButton
				.setToolTipText("Remove the selected role from the list");
		removeSelectedButton.addListener(SWT.Selection, dialogListener);
	}

	private StakeholderRole getSelection() {
		TableItem[] selects = tableViewer.getTable().getSelection();
		if (selects.length == 0) {
			return null;
		}
		TableItem firstSelection = selects[0];
		if (firstSelection.getData() instanceof StakeholderRole) {
			return (StakeholderRole) firstSelection.getData();

		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.urml.stakeholders.config.TitleDialogWithoutMinSize#getMinWidth()
	 */
	public int getMinWidth() {
		return 50;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.urml.stakeholders.config.TitleDialogWithoutMinSize#getMinHeight()
	 */
	public int getMinHeight() {
		return 400;
	}

}
