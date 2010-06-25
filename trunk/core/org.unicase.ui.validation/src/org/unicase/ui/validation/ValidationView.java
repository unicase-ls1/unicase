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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.DialogSettings;
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
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.EventUtil;
import org.unicase.ui.validation.filter.ValidationFilter;
import org.unicase.ui.validation.providers.ConstraintLabelProvider;
import org.unicase.ui.validation.providers.CreatorLabelProvider;
import org.unicase.ui.validation.providers.DescriptionLabelProvider;
import org.unicase.ui.validation.providers.SeverityLabelProvider;
import org.unicase.ui.validation.providers.ValidationContentProvider;
import org.unicase.ui.validation.providers.ValidationFilterLabelProvider;
import org.unicase.ui.validation.providers.ValidationLabelProvider;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.util.WorkspaceUtil;

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

	private Workspace workspace;

	private AdapterImpl workspaceListenerAdapter;

	private Shell shell;

	private Table table;

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
		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		workspaceListenerAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__PROJECT_SPACES) {
					if (msg.getOldValue() != null
						&& (msg.getOldValue() instanceof List<?> || msg.getOldValue() instanceof ProjectSpace)) {
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
		tableViewer = new TableViewer(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
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
					TableItem tableItem = ((Table) e.getSource()).getSelection()[0];
					startRefactoring(getRefactoringStrategiesFromExtensionPoint((IConstraintStatus) tableItem.getData()));
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
				if (me instanceof ModelElement) {
					EStructuralFeature errorLocation = null;
					errorLocation = getErrorLocation(iterator, errorLocation);
					if (errorLocation != null) {
						ActionHelper.openModelElement((ModelElement) me, errorLocation, viewId,
							new EMFStoreModelelementContext((ModelElement) me));
					} else {
						ActionHelper.openModelElement(me, viewId);
					}
				}
			}

		});
	}

	private ArrayList<AbstractRefactoringStrategy> getRefactoringStrategiesFromExtensionPoint(IConstraintStatus status) {
		ArrayList<AbstractRefactoringStrategy> refactoringStrategies = new ArrayList<AbstractRefactoringStrategy>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.validation.refactoring.strategies");
		for (IConfigurationElement element : config) {
			try {
				if (element.getAttribute("applicableFor").equals(status.getConstraint().getDescriptor().getId())) {
					final Object object = element.createExecutableExtension("strategy");
					AbstractRefactoringStrategy strategy = (AbstractRefactoringStrategy) object;
					strategy.setConstraintStatus(status);
					refactoringStrategies.add(strategy);
				}
			} catch (CoreException e) {
				WorkspaceUtil.logWarning("Exception loading refactoring strategies from the extension point", e);
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
		final ArrayList<ValidationFilter> validationFilters = new ArrayList<ValidationFilter>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.validation.filters");
		for (IConfigurationElement element : config) {
			try {
				Object object = element.createExecutableExtension("filter");
				if (object instanceof ValidationFilter) {
					ValidationFilter validationFilter = (ValidationFilter) object;
					validationFilters.add(validationFilter);
				}
			} catch (CoreException e) {
				e.printStackTrace();
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

	private void startRefactoring(List<?> abstractRefactoringStrategies) {
		if (abstractRefactoringStrategies.isEmpty()) {
			return;
		}
		if (abstractRefactoringStrategies.size() == 1) {
			AbstractRefactoringStrategy abstractRefactoringStrategy = (AbstractRefactoringStrategy) abstractRefactoringStrategies
				.get(0);
			abstractRefactoringStrategy.setShell(shell);
			abstractRefactoringStrategy.startRefactoring();
		} else {
			// otherwise show list dialog
			ListDialog listDialog = new ListDialog(shell);
			listDialog.setInput(abstractRefactoringStrategies.toArray());
			listDialog.setLabelProvider(new RefactoringStrategyLabelProvider());
			listDialog.setContentProvider(new RefactoringStrategyContentProvider());
			listDialog.setTitle("Choose a refactoring strategy");
			listDialog.open();
			Object[] result = listDialog.getResult();
			if (result != null && result.length > 0) {
				AbstractRefactoringStrategy abstractRefactoringStrategy = (AbstractRefactoringStrategy) result[0];
				abstractRefactoringStrategy.setShell(shell);
				abstractRefactoringStrategy.startRefactoring();
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
			TableItem tableItem = table.getSelection()[0];
			// extract the violation status
			final IConstraintStatus status = (IConstraintStatus) tableItem.getData();
			// create the menu
			Menu leftClickMenu = new Menu(shell, SWT.POP_UP);
			// add refactoring menu item if refactoring strategies are available
			List<AbstractRefactoringStrategy> refactoringStrategies = getRefactoringStrategiesFromExtensionPoint(status);
			if (refactoringStrategies.size() != 0) {
				final MenuItem refactorMenuItem = new MenuItem(leftClickMenu, SWT.NONE);
				// add the menu item
				refactorMenuItem.setData(refactoringStrategies);
				refactorMenuItem.setText("Perform refactoring");
				refactorMenuItem.setImage(Activator.getImageDescriptor("icons/bell.png").createImage());
				// refactorMenuItem.setData(data)
				refactorMenuItem.addSelectionListener(new RefactoringSelectionListener());
			}
			// ignore constraint menu item
			// MenuItem ignoreMenuItem = new MenuItem(leftClickMenu, SWT.NONE);
			// ignoreMenuItem.setData(refactoringStrategies);
			// ignoreMenuItem.setText("Ignore violation");
			// ignoreMenuItem.setImage(Activator.getImageDescriptor("icons/bell_delete.png").createImage());
			// refactorMenuItem.setData(data)

			// set menu to visible
			leftClickMenu.setVisible(true);
		}

		/**
		 * @author pfeifferc
		 */
		private final class RefactoringSelectionListener implements SelectionListener {
			public void widgetSelected(SelectionEvent e) {
				// get the source data
				MenuItem menuItem = (MenuItem) e.getSource();
				List<?> abstractRefactoringStrategies = (List<?>) menuItem.getData();
				// only show selection dialog if there is more than one refactoring
				startRefactoring(abstractRefactoringStrategies);
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
			ValidationFilterList validationFilterList = new ValidationFilterList(shell,
				new ValidationFilterLabelProvider());
			validationFilterList.setElements(getFiltersFromExtensionPoint().toArray());
			validationFilterList.setEmptySelectionMessage("No filter selected");
			validationFilterList.setMultipleSelection(true);
			validationFilterList.setTitle("Choose one or more filters");
			validationFilterList.setImage(Activator.getImageDescriptor("icons/openfilterlist.png").createImage());
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
			return ((AbstractRefactoringStrategy) ((Object[]) element)[0]).getDescription();
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class RefactoringStrategyContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			return new Object[] { inputElement };
		}

		public void dispose() {
			// TODO Auto-generated method stub
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
		}
	}
}
