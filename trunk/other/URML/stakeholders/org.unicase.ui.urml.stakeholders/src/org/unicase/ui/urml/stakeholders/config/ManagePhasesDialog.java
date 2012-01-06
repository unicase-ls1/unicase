/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
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
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholders.StakeholderUtil;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * This dialog allows the management of development phases according to the current active project.
 * @author kterzieva
 *
 */
public class ManagePhasesDialog extends TitleDialogWithoutMinSize {

	private static final String ADD_NEW_PHASE = "Add new development phase";
	private static final String ADD_DIALOG_MESSAGE = "Create new development phase";
	private static final String SELECT_DEVELOPMENT_PHASE = "Select development phase";
	private static final String MANAGE_DEVELOPMENT_PHASES = "Manage development phases";
	private Button addPhaseButton, removePhaseButton;
	private List<UnicaseModelElement> developmentPhases;
	private Project activeProject;
	private TableViewer tableViewer;
	private TableViewerColumn viewerNameColumn;
	private ILabelProvider tableViewLabelProvider;
	private DeleteButtonListener dialogListener;
	

	/**
	 * The construct.
	 * @param parentShell the parent shell
	 */
	public ManagePhasesDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		activeProject = StakeholderUtil.getActiveProject();

	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(MANAGE_DEVELOPMENT_PHASES);
		setMessage(SELECT_DEVELOPMENT_PHASE);
		Composite wrap = (Composite) super.createDialogArea(parent);
		Composite viewComposite = createViewComposite(wrap);
		tableViewSetUp(viewComposite);
		setTableInput();
		addListeners();
		createButtons(viewComposite);
		return viewComposite;
	}

	/**
	 * Sets the current available development phases to be shown within the dialog.
	 */
	private void setTableInput() {
		developmentPhases = new ArrayList<UnicaseModelElement>();

		Collection<EObject> basicList = activeProject
				.getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getPhase(),
						new BasicEList<EObject>());

		for (EObject phase : basicList) {
			developmentPhases.add((Phase) phase);
		}
		tableViewer.setInput(developmentPhases);
	}


	private void createAddDialog() {
		final Phase newPhase = UrmlFactory.eINSTANCE.createPhase();
		final AddPhaseDialog addPhaseDialog = new AddPhaseDialog(
				addPhaseButton.getShell(), newPhase, ADD_NEW_PHASE,
				ADD_DIALOG_MESSAGE);
		addPhaseDialog.setBlockOnOpen(true);
		if (addPhaseDialog.open() == Window.OK) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					newPhase.setName(addPhaseDialog.getSelectedName());
					activeProject.addModelElement(newPhase);
				}
			}.run();
			setTableInput();
		}
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

	private void addListeners() {
		dialogListener = new DeleteButtonListener(tableViewer, getShell(),
				activeProject);
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						removePhaseButton.setEnabled(true);
					}
				});
	}

	private void createButtons(Composite composite) {
		addPhaseButton = new Button(composite, SWT.PUSH);
		addPhaseButton.setText("Add phase...");
		addPhaseButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false,
				false, 1, 1));
		addPhaseButton.setToolTipText("Add new development phase");
		addPhaseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				createAddDialog();
			}
		});

		removePhaseButton = new Button(composite, SWT.PUSH);
		removePhaseButton.setText("Delete phase");
		removePhaseButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM,
				false, false, 1, 1));
		removePhaseButton.setEnabled(false);
		removePhaseButton
				.setToolTipText("Remove the selected development phase from the list");
		removePhaseButton.addListener(SWT.Selection, dialogListener);
	}
}
