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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
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
import org.unicase.ui.validation.providers.ValidationLableProvider;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;


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
							&& (msg.getOldValue() instanceof List<?> || msg
									.getOldValue() instanceof ProjectSpace)) {
						tableViewer
						.setInput(new ArrayList<IConstraintStatus>());
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
		tableViewer = new TableViewer(parent, SWT.SINGLE | SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
		createTable();
		this.shell = parent.getShell();
		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();
		OpenFilterDialogAction openFilterDialogAction = new OpenFilterDialogAction();
		openFilterDialogAction.setImageDescriptor(Activator
				.getImageDescriptor("icons/openfilterlist.png"));
		openFilterDialogAction.setToolTipText("Add one or more filters to be applied to the validation view.");
		menuManager.add(openFilterDialogAction);
		hookDoubleClickAction();
		hookLeftClickAction();
	}

	private void createTable() {
		// CREATE TABLE
		Table table = tableViewer.getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 5;
		table.setLayoutData(gridData);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		TableViewerColumn column;

		// severity column
		column = new TableViewerColumn(tableViewer,
				SWT.CENTER, 0);
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
		setLabelProviderAndComparator(column, new ValidationLableProvider());

		// creator column
		column = new TableViewerColumn(tableViewer, SWT.LEFT, 4);
		column.getColumn().setText("Creator");
		column.getColumn().setWidth(100);
		setLabelProviderAndComparator(column, new CreatorLabelProvider());

		// content provider
		tableViewer.setContentProvider(new ValidationContentProvider());
	}

	private void setLabelProviderAndComparator(TableViewerColumn column,
			ColumnLabelProvider labelProvider) {
		column.setLabelProvider(labelProvider);
		column.getViewer().setComparator(new TableViewerColumnSorter(tableViewer, column, labelProvider));
	}

	private void hookDoubleClickAction() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
				IConstraintStatus constraintStatus = (IConstraintStatus) selection
				.getFirstElement();

				EObject me = constraintStatus.getTarget();
				Iterator<EObject> iterator = constraintStatus.getResultLocus()
				.iterator();
				if (me instanceof ModelElement) {
					EStructuralFeature errorLocation = null;
					errorLocation = getErrorLocation(iterator, errorLocation);
					if (errorLocation != null) {
						ActionHelper.openModelElement((ModelElement) me,
								errorLocation, viewId);
					} else {
						ActionHelper
						.openModelElement((ModelElement) me, viewId);
					}
				}
			}

		});
	}

	private void hookLeftClickAction() {
		tableViewer.getTable().addMenuDetectListener(new MenuDetectListener() {

			public void menuDetected(MenuDetectEvent e) {
				Table table = (Table) e.getSource();
				TableItem[] tableItems = table.getSelection();
				final ArrayList<IConstraintStatus> stati = new ArrayList<IConstraintStatus>();
				for(TableItem tableItem : tableItems) {
					stati.add((IConstraintStatus) (tableItem.getData()));
				}
				Menu leftClickMenu = new Menu(shell, SWT.POP_UP);
				MenuItem refactorMenuItem = new MenuItem(leftClickMenu, SWT.NONE);
				refactorMenuItem.setText("Refactor the violation");
				refactorMenuItem.setImage(Activator.getImageDescriptor("icons/bell_go.png").createImage());
				refactorMenuItem.addListener(SWT.Selection, new Listener() {

					public void handleEvent(Event event) {
						for(AbstractRefactoringStrategy refactoringStrategy : getRefactoringStrategiesFromExtensionPoint(stati)) {
							refactoringStrategy.startRefactoring(shell);
						}
					}

				});
				leftClickMenu.setVisible(true);
			}
			
		});
	}

	private ArrayList<AbstractRefactoringStrategy> getRefactoringStrategiesFromExtensionPoint(ArrayList<IConstraintStatus> stati) {
		ArrayList<AbstractRefactoringStrategy> refactoringStrategies = new ArrayList<AbstractRefactoringStrategy>();
		for(IConstraintStatus status: stati) {
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor("org.unicase.ui.validation.refactoring.strategies");
			for (IConfigurationElement element : config) {
				try {
					if(element.getAttribute("applicableFor").equals(status.getConstraint().getDescriptor().getId())){
						final Object object = element.createExecutableExtension("strategy");
						AbstractRefactoringStrategy strategy = (AbstractRefactoringStrategy) object;
						strategy.setConstraintStatus(status);
						strategy.setId(element.getAttribute("id"));
						refactoringStrategies.add(strategy);
					}
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return refactoringStrategies;
	}

	private EStructuralFeature getErrorLocation(Iterator<EObject> iterator,
			EStructuralFeature errorLocation) {
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
	 * @param validationResults
	 *            validation results.
	 */
	public void updateTable(List<IConstraintStatus> validationResults) {
		tableViewer.setInput(validationResults);
		// this is added to fix the bug regarding context menu not being shown
		// correctly in navigator, after validation viewer was shown.
		tableViewer.getTable().setFocus();
	}

	private ArrayList<ValidationFilter> getFiltersFromExtensionPoint() {
		final ArrayList<ValidationFilter> validationFilters = new ArrayList<ValidationFilter>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor("org.unicase.ui.validation.filters");
		for (IConfigurationElement element : config) {
			try {
				Object object = element.createExecutableExtension("filter");
				if(object instanceof ValidationFilter) {
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

	/**
	 * The filter dialog action.
	 * 
	 * @author pfeifferc
	 */
	private final class OpenFilterDialogAction extends Action {

		@Override
		public void run() {
			ValidationFilterList validationFilterList = new ValidationFilterList(shell, new ValidationFilterLabelProvider());
			validationFilterList.setElements(getFiltersFromExtensionPoint().toArray());
			validationFilterList.setEmptySelectionMessage("No filter selected");
			validationFilterList.setMultipleSelection(true);
			validationFilterList.setTitle("Choose one or more filters");
			validationFilterList.setImage(Activator
					.getImageDescriptor("icons/openfilterlist.png").createImage());
			validationFilterList.open();
			if(validationFilterList.getReturnCode() == Status.OK) {
				removeAllFilters();
				for(Object object : validationFilterList.getResult()) {
					if(object instanceof ValidationFilter) {
						applyFilter((ValidationFilter) object);
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
}
