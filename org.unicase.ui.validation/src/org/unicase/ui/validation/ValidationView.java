/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.EventUtil;
import org.unicase.ui.navigator.NoWorkspaceException;
import org.unicase.ui.navigator.WorkspaceManager;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelPackage;
import org.unicase.ui.validation.filter.FilterTableViewer;
import org.unicase.ui.validation.filter.ValidationFilter;
import org.unicase.ui.validation.providers.ConstraintLabelProvider;
import org.unicase.ui.validation.providers.CreatorLabelProvider;
import org.unicase.ui.validation.providers.DescriptionLabelProvider;
import org.unicase.ui.validation.providers.SeverityLabelProvider;
import org.unicase.ui.validation.providers.ValidationContentProvider;
import org.unicase.ui.validation.providers.ValidationFilterLabelProvider;
import org.unicase.ui.validation.providers.ValidationLabelProvider;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;
import org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy;
import org.unicase.util.UnicaseUtil;

/**
 * Validation view.
 * 
 * @author wesendonk
 * @author pfeifferc
 */
public class ValidationView extends ViewPart {

	private TableViewer tableViewer;

	private DialogSettings settings;

	private String filename;

	private final String viewId = getClass().getName();

	private AdapterImpl workspaceListenerAdapter;

	private Shell shell;

	private Table table;

	private ArrayList<ValidationFilter> validationFilters;

	private TableItem tableItem;

	private ECPWorkspace workspace;

	/**
	 * Default constructor.
	 */
	public ValidationView() {
		IPath path = org.unicase.ui.common.Activator.getDefault().getStateLocation();
		filename = path.append("settings.txt").toOSString();
		settings = new DialogSettings("Top");
		try {
			settings.load(filename);
		} catch (IOException e) {
			// Do nothing.
		}

		try {
			workspace = WorkspaceManager.getInstance().getWorkSpace();
		} catch (NoWorkspaceException e) {
			// TODO Chainsaw.
		}
		workspaceListenerAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				// TODO Chainsaw check rewrite
				if ((msg.getFeatureID(Workspace.class)) == WorkSpaceModelPackage.ECP_PROJECT) {
					if (msg.getOldValue() != null
						&& (msg.getOldValue() instanceof List<?> || msg.getOldValue() instanceof ECPProject)) {
						tableViewer.setInput(new ArrayList<IConstraintStatus>());
					}

				}
				super.notifyChanged(msg);
			}
		};
		workspace.eAdapters().add(workspaceListenerAdapter);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		tableViewer = new FilterTableViewer(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
			| SWT.FULL_SELECTION);
		createTable();
		this.shell = parent.getShell();
		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();
		OpenFilterDialogAction openFilterDialogAction = new OpenFilterDialogAction();
		openFilterDialogAction.setImageDescriptor(Activator.getImageDescriptor("icons/openfilterlist.png"));
		openFilterDialogAction.setToolTipText("Add one or more filters to be applied to the validation view.");
		menuManager.add(openFilterDialogAction);
		hookDoubleClickAction();
		tableViewer.getTable().addMenuDetectListener(new MenuDetectListenerImplementation());
	}

	private void createTable() {
		// CREATE TABLE
		table = tableViewer.getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 5;
		table.setLayoutData(gridData);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		TableViewerColumn column;

		// severity column
		column = new TableViewerColumn(tableViewer, SWT.CENTER, 0);
		column.getColumn().setText("Severity");
		column.getColumn().setWidth(50);
		setLabelProviderAndComparator(column, new SeverityLabelProvider());

		// constraint column
		column = new TableViewerColumn(tableViewer, SWT.LEFT, 1);
		column.getColumn().setText("Constraint");
		column.getColumn().setWidth(200);
		setLabelProviderAndComparator(column, new ConstraintLabelProvider());

		// description column
		column = new TableViewerColumn(tableViewer, SWT.LEFT, 2);
		column.getColumn().setText("Description");
		column.getColumn().setWidth(400);
		setLabelProviderAndComparator(column, new DescriptionLabelProvider());

		// affected model element column
		column = new TableViewerColumn(tableViewer, SWT.LEFT, 3);
		column.getColumn().setText("Affected ModelElement");
		column.getColumn().setWidth(200);
		setLabelProviderAndComparator(column, new ValidationLabelProvider());

		// creator column
		column = new TableViewerColumn(tableViewer, SWT.LEFT, 4);
		column.getColumn().setText("Creator");
		column.getColumn().setWidth(100);
		setLabelProviderAndComparator(column, new CreatorLabelProvider());

		// content provider
		tableViewer.setContentProvider(new ValidationContentProvider());
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		tableCursor.setVisible(false);
		table.addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				if (e.stateMask == SWT.ALT && e.keyCode == 'r') {
					tableItem = ((Table) e.getSource()).getSelection()[0];
					startRefactoring();
				}
			}

			public void keyPressed(KeyEvent e) {
				// nothing to do here
			}
		});
	}

	private void setLabelProviderAndComparator(TableViewerColumn column, ColumnLabelProvider labelProvider) {
		column.setLabelProvider(labelProvider);
		column.getViewer().setComparator(new TableViewerColumnSorter(tableViewer, column, labelProvider));
	}

	private void hookDoubleClickAction() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				IConstraintStatus constraintStatus = (IConstraintStatus) selection.getFirstElement();

				EObject me = constraintStatus.getTarget();
				Iterator<EObject> iterator = constraintStatus.getResultLocus().iterator();
				if (me instanceof EObject) {
					EStructuralFeature errorLocation = null;
					errorLocation = getErrorLocation(iterator, errorLocation);
					if (errorLocation != null) {
						// TODO: Chainsaw cast ok?
						ActionHelper.openModelElement(me, errorLocation, viewId, (ModelElementContext) UnicaseUtil
							.getParent(ECPProject.class, me));
					} else {
						ActionHelper.openModelElement(me, viewId);
					}
				}
			}

		});
	}

	private ArrayList<RefactoringStrategy> getRefactoringStrategiesFromExtensionPoint(IConstraintStatus status) {
		ArrayList<RefactoringStrategy> refactoringStrategies = new ArrayList<RefactoringStrategy>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.validation.refactoring.strategies");
		for (IConfigurationElement element : config) {
			try {
				if (element.getAttribute("applicableFor").equals(status.getConstraint().getDescriptor().getId())) {
					final Object object = element.createExecutableExtension("strategy");
					RefactoringStrategy strategy = (RefactoringStrategy) object;
					strategy.setConstraintStatus(status);
					refactoringStrategies.add(strategy);
				}
			} catch (CoreException e) {
				// TODO: ChainSaw
				// WorkspaceUtil.logWarning("Exception loading refactoring strategies from the extension point", e);
			}

		}
		return refactoringStrategies;
	}

	private EStructuralFeature getErrorLocation(Iterator<EObject> iterator, EStructuralFeature errorLocation) {
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof EStructuralFeature) {
				errorLocation = (EStructuralFeature) next;
				break;
			}
		}
		return errorLocation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		EventUtil.logFocusEvent(viewId);
	}

	/**
	 * Updates the validation view table.
	 * 
	 * @param validationResults validation results.
	 */
	public void updateTable(List<IConstraintStatus> validationResults) {
		tableViewer.setInput(validationResults);
		// this is added to fix the bug regarding context menu not being shown
		// correctly in navigator, after validation viewer was shown.
		tableViewer.getTable().setFocus();
	}

	private ArrayList<ValidationFilter> getFiltersFromExtensionPoint() {
		if (validationFilters == null) {
			validationFilters = new ArrayList<ValidationFilter>();
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.unicase.ui.validation.filters");
			for (IConfigurationElement element : config) {
				try {
					Object object = element.createExecutableExtension("filter");
					if (object instanceof ValidationFilter) {
						ValidationFilter validationFilter = (ValidationFilter) object;
						if (validationFilter.init()) {
							validationFilters.add(validationFilter);
						}
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		return validationFilters;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		workspace.eAdapters().remove(workspaceListenerAdapter);
		super.dispose();
	}

	private void startRefactoring() {
		IConstraintStatus constraintStatus = (IConstraintStatus) tableItem.getData();
		List<?> abstractRefactoringStrategies = getRefactoringStrategiesFromExtensionPoint(constraintStatus);
		if (abstractRefactoringStrategies.isEmpty()) {
			return;
		}
		RefactoringResult refactoringResult = RefactoringResult.ABORT;
		if (abstractRefactoringStrategies.size() == 1) {
			RefactoringStrategy refactoringStrategy = (RefactoringStrategy) abstractRefactoringStrategies.get(0);
			refactoringStrategy.setShell(shell);
			refactoringResult = refactoringStrategy.startRefactoring();
		} else {
			// otherwise show list dialog
			ListDialog listDialog = new ListDialog(shell);
			listDialog.setInput(abstractRefactoringStrategies);
			listDialog.setLabelProvider(new RefactoringStrategyLabelProvider());
			listDialog.setContentProvider(new SimpleContentProvider());
			listDialog.setTitle("Choose a refactoring strategy");
			listDialog.open();
			Object[] result = listDialog.getResult();
			if (result != null && result.length > 0) {
				RefactoringStrategy refactoringStrategy = (RefactoringStrategy) result[0];
				refactoringStrategy.setShell(shell);
				refactoringResult = refactoringStrategy.startRefactoring();
			}
		}
		if (refactoringResult == RefactoringResult.NO_VIOLATION
			|| refactoringResult == RefactoringResult.SUCCESS_CREATE) {
			tableItem.dispose();
		}
	}

	private void removeAllTableItemsForEObject(final IConstraintStatus status) {
		EObject deletee = status.getTarget();
		for (TableItem tableItem : tableViewer.getTable().getItems()) {
			IConstraintStatus constraintStatus = (IConstraintStatus) tableItem.getData();
			EObject modelElement = constraintStatus.getTarget();
			if (deletee == modelElement) {
				tableItem.dispose();
			}
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class MenuDetectListenerImplementation implements MenuDetectListener {

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
			List<RefactoringStrategy> refactoringStrategies = getRefactoringStrategiesFromExtensionPoint(status);
			if (refactoringStrategies.size() != 0) {
				final MenuItem refactorMenuItem = new MenuItem(leftClickMenu, SWT.NONE);
				// add the menu item
				refactorMenuItem.setData(tableItem);
				refactorMenuItem.setText("Perform refactoring");
				refactorMenuItem.setImage(Activator.getImageDescriptor("icons/bell.png").createImage());
				// refactorMenuItem.setData(data)
				refactorMenuItem.addSelectionListener(new RefactoringSelectionListener());
			}
			// ignore constraint menu item
			MenuItem ignoreMenuItem = new MenuItem(leftClickMenu, SWT.NONE);
			ignoreMenuItem.setData(refactoringStrategies);
			ignoreMenuItem.setText("Ignore violation");
			ignoreMenuItem.setImage(Activator.getImageDescriptor("icons/bell_delete.png").createImage());
			// delete model element menu item
			MenuItem deleteMenuItem = new MenuItem(leftClickMenu, SWT.NONE);
			deleteMenuItem.setData(refactoringStrategies);
			deleteMenuItem.setText("Delete underlying element");
			deleteMenuItem.setImage(Activator.getImageDescriptor("icons/delete.png").createImage());
			deleteMenuItem.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if (MessageDialog.openQuestion(shell, "Confirm deletion", "Do you really wish to delete "
						+ status.getTarget().getClass().getSimpleName() + "?")) {
						new ECPCommand(status.getTarget()) {

							@Override
							protected void doRun() {
								EObject target = status.getTarget();
								EcoreUtil.delete(target);
							}
						}.run();
					}
					removeAllTableItemsForEObject(status);
				}
			});
			// set menu to visible
			leftClickMenu.setVisible(true);
		}

		/**
		 * @author pfeifferc
		 */
		private final class RefactoringSelectionListener implements SelectionListener {
			public void widgetSelected(SelectionEvent e) {
				// only show selection dialog if there is more than one refactoring
				startRefactoring();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
		}
	}

	/**
	 * The filter dialog action.
	 * 
	 * @author pfeifferc
	 */
	private final class OpenFilterDialogAction extends Action {

		@Override
		public void run() {
			ValidationFilterList validationFilterList = new ValidationFilterList(shell, getFiltersFromExtensionPoint(),
				new SimpleContentProvider(), new ValidationFilterLabelProvider(), "Test");
			validationFilterList.setTitle("Choose one or more filters");
			validationFilterList.setInitialSelections(tableViewer.getFilters());
			validationFilterList.open();
			if (validationFilterList.getReturnCode() == Status.OK) {
				removeAllFilters();
				for (Object object : validationFilterList.getResult()) {
					if (object instanceof ValidationFilter) {
						ValidationFilter validationFilter = (ValidationFilter) object;
						applyFilter(validationFilter);
					}
				}
			}
		}

		private void applyFilter(ValidationFilter validationFilter) {
			tableViewer.addFilter(validationFilter);
		}

		private void removeAllFilters() {
			tableViewer.resetFilters();
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class RefactoringStrategyLabelProvider extends LabelProvider {

		@Override
		public Image getImage(Object element) {
			return Activator.getImageDescriptor("icons/bell.png").createImage();
		}

		@Override
		public String getText(Object element) {
			return ((RefactoringStrategy) ((Object[]) element)[0]).getDescription();
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class SimpleContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			List<?> list = (List<?>) inputElement;
			if (list.isEmpty()) {
				return new Object[0];
			}
			return list.toArray();
		}

		public void dispose() {
			// TODO Auto-generated method stub
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
		}
	}
}
