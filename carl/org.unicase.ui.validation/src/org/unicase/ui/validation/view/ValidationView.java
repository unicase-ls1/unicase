/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.EventUtil;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.common.validation.listeners.ValidationListener;
import org.unicase.ui.common.validation.preferences.ValidationPreferenceConstants;
import org.unicase.ui.common.validation.providers.ValidationResultProvider;
import org.unicase.ui.validation.Activator;
import org.unicase.ui.validation.refactoring.RefactoringStrategy;
import org.unicase.ui.validation.view.actions.GroupRefactoringAction;
import org.unicase.ui.validation.view.actions.OpenFilterDialogAction;
import org.unicase.ui.validation.view.providers.ConstraintLabelProvider;
import org.unicase.ui.validation.view.providers.CreatorLabelProvider;
import org.unicase.ui.validation.view.providers.DescriptionLabelProvider;
import org.unicase.ui.validation.view.providers.SeverityLabelProvider;
import org.unicase.ui.validation.view.providers.ValidationContentProvider;
import org.unicase.ui.validation.view.providers.ValidationLabelProvider;
import org.unicase.ui.validation.view.util.ValidationViewHelper;

/**
 * Validation view.
 * 
 * @author wesendonk
 * @author pfeifferc
 */
public class ValidationView extends ViewPart implements ValidationListener {

	/**
	 * The default width of the creator column.
	 */
	private static final int CREATOR_COLUMN_WIDTH = 100;

	/**
	 * The default width of the affected object column.
	 */
	private static final int AFFECTED_OBJECT_COLUMN_WIDTH = 200;

	/**
	 * The default width of the constraint column.
	 */
	private static final int CONSTRAINT_COLUMN_WIDTH = 250;

	/**
	 * The default width of the severity column.
	 */
	private static final int SEVERITY_COLUMN_WIDTH = 20;

	/**
	 * The table viewer column.
	 */
	private TableViewerColumn columnDescription;

	/**
	 * The last {@link ValidationResultProvider} registered with.
	 */
	private ValidationResultProvider validationResultProvider;

	/**
	 * The root object for the elements displayed in the validation view, i.e. where did the validation start.
	 */
	private EObject selectedEObject;

	/**
	 * The shell.
	 */
	private Shell shell;

	/**
	 * The table.
	 */
	private Table table;

	/**
	 * The table item.
	 */
	private TableItem tableItem;

	/**
	 * The table viewer.
	 */
	private TableViewer tableViewer;

	/**
	 * The view ID.
	 */
	private final String viewId = getClass().getName();

	/**
	 * The root object for the {@link ValidationResultProvider}.
	 */
	private EObject root;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.shell = parent.getShell();
		setTableViewer(new TableViewer(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
			| SWT.FULL_SELECTION));
		// create table
		createTable();
		// add listeners and providers
		addTableListenersAndProviders();
		// the dialog to show possible validation filter
		addMenuBarContributions();
		// to open objects on double click
		addDoubleClickAction();
		// add the context menu
		getTableViewer().getTable().addMenuDetectListener(new MenuDetectListenerImplementation());
	}

	/**
	 * Creates the table.
	 */
	private void createTable() {
		// create table
		setTable(getTableViewer().getTable());
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 5;
		getTable().setLayoutData(gridData);
		getTable().setLinesVisible(true);
		getTable().setHeaderVisible(true);

		// column counter
		int columnNumber = 0;

		// severity column
		TableViewerColumn column = createColumn(" !", SEVERITY_COLUMN_WIDTH, columnNumber++);
		setLabelProviderAndComparator(column, new SeverityLabelProvider());

		// constraint column
		column = createColumn("Constraint", CONSTRAINT_COLUMN_WIDTH, columnNumber++);
		setLabelProviderAndComparator(column, new ConstraintLabelProvider());

		columnDescription = createColumn("Description", 500, columnNumber++);
		setLabelProviderAndComparator(columnDescription, new DescriptionLabelProvider());

		// affected model element column
		column = createColumn("Affected object", AFFECTED_OBJECT_COLUMN_WIDTH, columnNumber++);
		setLabelProviderAndComparator(column, new ValidationLabelProvider());

		// creator column
		column = createColumn("Creator", CREATOR_COLUMN_WIDTH, columnNumber++);
		setLabelProviderAndComparator(column, new CreatorLabelProvider());
	}

	/**
	 * Adds the table listeners and providers.
	 */
	private void addTableListenersAndProviders() {
		// content provider and key listener
		getTableViewer().setContentProvider(new ValidationContentProvider());
		getTable().addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				if (e.stateMask == SWT.CONTROL && e.keyCode == '1') {
					tableItem = ((Table) e.getSource()).getSelection()[0];
					ValidationViewHelper.performRefactoring(shell, tableItem);
				}
			}

			public void keyPressed(KeyEvent e) {
				// nothing to do here
			}
		});
		// to automatically resize the validation view when resizing the window
		getTable().addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Rectangle area = getTable().getClientArea();
				Point preferredSize = getTable().computeSize(SWT.DEFAULT, SWT.DEFAULT);
				int width = area.width - 2 * getTable().getBorderWidth();
				if (preferredSize.y > area.height + getTable().getHeaderHeight()) {
					// Subtract the scrollbar width from the total column width
					// if a vertical scrollbar will be required
					Point vBarSize = getTable().getVerticalBar().getSize();
					width -= vBarSize.x;
				}
				int width2 = area.width - AFFECTED_OBJECT_COLUMN_WIDTH - CONSTRAINT_COLUMN_WIDTH - CREATOR_COLUMN_WIDTH
					- SEVERITY_COLUMN_WIDTH;
				if (width2 < 200) {
					width2 = 200;
				}
				columnDescription.getColumn().setWidth(width2);
			}
		});
	}

	/**
	 * Create the table column.
	 * 
	 * @param name of the {@link TableViewerColumn}
	 * @param width of the {{@link TableViewerColumn}
	 * @param index of the {@link TableViewerColumn}
	 * @return the {@link TableViewerColumn}
	 */
	private TableViewerColumn createColumn(String name, int width, int index) {
		TableViewerColumn column = new TableViewerColumn(getTableViewer(), SWT.LEFT, index);
		column.getColumn().setText(name);
		column.getColumn().setWidth(width);
		return column;
	}

	/**
	 * Set the label providers and comparators.
	 * 
	 * @param column
	 * @param labelProvider
	 */
	private void setLabelProviderAndComparator(TableViewerColumn column, ColumnLabelProvider labelProvider) {
		column.setLabelProvider(labelProvider);
		column.getViewer().setComparator(new TableViewerColumnSorter(getTableViewer(), column, labelProvider));
	}

	/**
	 * Add double click action.
	 */
	private void addDoubleClickAction() {
		// on double click open object in editor
		getTableViewer().addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				IConstraintStatus constraintStatus = (IConstraintStatus) selection.getFirstElement();
				EObject me = constraintStatus.getTarget();
				ActionHelper.openModelElement(me, viewId);
			}
		});
	}

	/**
	 * Show the validation filters that can be added.
	 */
	private void addMenuBarContributions() {
		// show button to open filter dialog and choose filters to apply to table
		IToolBarManager menuManager = getViewSite().getActionBars().getToolBarManager();
		OpenFilterDialogAction openFilterDialogAction = new OpenFilterDialogAction(shell, getTableViewer());
		openFilterDialogAction.setImageDescriptor(Activator.getImageDescriptor("icons/openfilterlist.png"));
		openFilterDialogAction.setToolTipText("Add one or more filters to be applied to the validation view.");
		menuManager.add(openFilterDialogAction);
		GroupRefactoringAction groupRefactoringAction = new GroupRefactoringAction(this);
		groupRefactoringAction.setImageDescriptor(Activator.getImageDescriptor("icons/bell_go.png"));
		groupRefactoringAction.setToolTipText("Execute group refactorings.");
		menuManager.add(groupRefactoringAction);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		EventUtil.logFocusEvent(viewId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * @author pfeifferc
	 */
	private final class MenuDetectListenerImplementation implements MenuDetectListener {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.events.MenuDetectListener#menuDetected(org.eclipse.swt.events.MenuDetectEvent)
		 */
		public void menuDetected(MenuDetectEvent e) {
			// get the table
			Table table = (Table) e.getSource();
			if (table.getSelection() == null || table.getSelection().length == 0) {
				return;
			}
			// get the first table item that was selected (no multiple select)
			tableItem = table.getSelection()[0];
			// extract the violation status
			final IConstraintStatus status = (IConstraintStatus) tableItem.getData();
			// create the menu
			Menu leftClickMenu = new Menu(shell, SWT.POP_UP);
			// add refactoring menu item if refactoring strategies are available
			List<RefactoringStrategy> refactoringStrategies = ValidationViewHelper
				.getRefactoringStrategiesFromExtensionPoint(status);
			if (refactoringStrategies.size() != 0) {
				final MenuItem refactorMenuItem = new MenuItem(leftClickMenu, SWT.NONE);
				// add the menu item
				refactorMenuItem.setData(tableItem);
				refactorMenuItem.setText("Perform refactoring");
				refactorMenuItem.setImage(Activator.getImageDescriptor("icons/bell.png").createImage());
				// refactorMenuItem.setData(data)
				refactorMenuItem.addSelectionListener(new SelectionAdapter() {

					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
					 */
					@Override
					public void widgetSelected(SelectionEvent e) {
						ValidationViewHelper.performRefactoring(shell, tableItem);
					}
				});
			}
			leftClickMenu.setVisible(true);
		}

		/**
		 * @return the provider
		 */
		@SuppressWarnings("unused")
		public AdapterFactoryLabelProvider getLabelProvider() {
			AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			return provider;
		}
	}

	/**
	 * Updates the validation view table.
	 * 
	 * @param eObjectToShowFor the
	 */
	public void updateTable(EObject eObjectToShowFor) {
		if (validationResultProvider != null) {
			validationResultProvider.unregisterListener(root, this);
		}
		if (eObjectToShowFor == null) {
			return;
		}
		this.seteObjectToShowFor(eObjectToShowFor);
		validationResultProvider = ValidationResultProviderRegistry.getInstance().getValidationResultProvider(
			eObjectToShowFor);
		if (validationResultProvider == null) {
			return;
		}
		root = validationResultProvider.getRootElement();
		validationResultProvider.registerListener(this);
		Set<IConstraintStatus> violations;
		if (PreferenceHelper.getPreference(ValidationPreferenceConstants.VALIDATION_VIEW_FLAT, "false").equals("true")) {
			violations = validationResultProvider.getViolations(eObjectToShowFor);
		} else {
			violations = validationResultProvider.getViolationsRecursively(eObjectToShowFor);
		}
		getTableViewer().setInput(sortStati(violations));
		// this is added to fix the bug regarding context menu not being shown
		// correctly in navigator, after validation viewer was shown.
		getTableViewer().getTable().setFocus();
	}

	private List<IConstraintStatus> sortStati(Set<IConstraintStatus> set) {
		List<IConstraintStatus> constraintStati = new ArrayList<IConstraintStatus>(set);
		Collections.sort(constraintStati, new Comparator<IConstraintStatus>() {

			/**
			 * {@inheritDoc}
			 */
			public int compare(IConstraintStatus o1, IConstraintStatus o2) {
				if (o1.getSeverity() > o2.getSeverity()) {
					return -1;
				}
				if (o1.getSeverity() < o2.getSeverity()) {
					return 1;
				}
				return 0;
			}
		});
		return constraintStati;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.validation.listeners.ValidationListener#elementValidated(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.validation.model.IConstraintStatus, java.util.Set)
	 */
	public void objectValidated(EObject project, EObject eObject, Set<IConstraintStatus> constraintStati) {
		if (getTable().isDisposed()) {
			validationResultProvider.unregisterListener(project, this);
			return;
		}
		getTable().clearAll();
		updateTable(geteObjectToShowFor());
	}

	/**
	 * @return the root {@link EObject} used for retrieving violations
	 */
	public EObject getRoot() {
		return root;
	}

	/**
	 * @return the {@link Shell}
	 */
	public Shell getShell() {
		return shell;
	}

	/**
	 * @param eObjectToShowFor the eObjectToShowFor to set
	 */
	public void seteObjectToShowFor(EObject eObjectToShowFor) {
		this.selectedEObject = eObjectToShowFor;
	}

	/**
	 * @return the eObjectToShowFor
	 */
	public EObject geteObjectToShowFor() {
		return selectedEObject;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.validation.listeners.ValidationListener#rootRemoved(org.eclipse.emf.ecore.EObject)
	 */
	public void rootRemoved(EObject rootElement) {
		validationResultProvider.unregisterListener(this);
		getTable().clearAll();
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @param tableViewer the tableViewer to set
	 */
	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	/**
	 * @return the tableViewer
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}
}
