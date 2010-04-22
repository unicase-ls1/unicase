/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status.ui.tabs;

import java.util.List;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;

import org.unicase.metamodel.Project;
import org.unicase.model.organization.User;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.model.UnicaseModelElement;
import org.unicase.rap.ui.tabs.ProjectAwareTab;
import org.unicase.rap.status.ui.filters.OpenItemsViewFilter;
import org.unicase.rap.status.ui.viewers.WorkItemsTableViewer;
import org.unicase.rap.status.ui.filters.DoneViewFilter;
import org.unicase.rap.status.ui.filters.BlockedItemsViewFilter;
import org.unicase.rap.status.ui.filters.ResolvedItemsViewFilter;

/**
 * A tab that shows open work items.
 * 
 * @author Edgar Müller
 */
public class WorkItemsTab extends ProjectAwareTab {
	
	private OpenItemsViewFilter openItemsFilter;
	
	private DoneViewFilter closedItemsFilter;
	
	private BlockedItemsViewFilter blockedItemsFilter;
	
	private ResolvedItemsViewFilter resolvedItemsFilter;
	
	private WorkItemsTableViewer workItemsTableViewer;	
	
	/**
	 * Initializes a new instance of the WorkItemsTab. 
	 * 
	 * @param projectSpace The project space this tab depends on
	 * @param tabFolder The parent tab folder of this tab
	 */
	public WorkItemsTab(ProjectSpace projectSpace, CTabFolder tabFolder) {
		super(projectSpace, tabFolder, "Task View");
		// openItemsFilter = new OpenItemsViewFilter();
		closedItemsFilter = new DoneViewFilter();
		blockedItemsFilter = new BlockedItemsViewFilter();
		resolvedItemsFilter = new ResolvedItemsViewFilter();

 		createFiltersPart(composite);
 		
		workItemsTableViewer = new WorkItemsTableViewer(composite);
		
		addFilter(blockedItemsFilter);
		addFilter(closedItemsFilter);
		addFilter(resolvedItemsFilter);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void createTab(Composite parent) {
		workItemsTableViewer.setInput(getProjectSpace().getProject());
	}
	
	private void createFiltersPart(final Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText("Filters");
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);		
		group.setLayoutData(gridData);
		
		GridLayout gridLayout = new GridLayout(3, false);
		group.setLayout(gridLayout);
		
		
		final Button showClosedButton = new Button(group, SWT.CHECK);
		showClosedButton.setText("Show Done Items");
		showClosedButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(final SelectionEvent e) {
				boolean isShowClosedItems = showClosedButton.getSelection();
				if(!isShowClosedItems) {
					addFilter(closedItemsFilter);
				} else {
					removeFilter(closedItemsFilter);
				}
				workItemsTableViewer.refresh();
			}
		});
		
		final Button showResolvedButton = new Button(group, SWT.CHECK);
		showResolvedButton.setText("Show Resolved Items");
		showResolvedButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(final SelectionEvent e) {
				boolean isShowResolvedItems = showResolvedButton.getSelection();
				if(!isShowResolvedItems) {
					addFilter(resolvedItemsFilter);
				} else {
					removeFilter(resolvedItemsFilter);
				}
				workItemsTableViewer.refresh();
			}
		});
		
		final Button showblockedButton = new Button(group, SWT.CHECK);
		showblockedButton.setText("Show Blocked Items");
		showblockedButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(final SelectionEvent e) {
				boolean isShowBlockedItems = showblockedButton.getSelection();
				if(!isShowBlockedItems) {
					addFilter(blockedItemsFilter);
				} else {
					removeFilter(blockedItemsFilter);
				}
				workItemsTableViewer.refresh();
			}
		});
		
	}
	
	/**
	 * adds a filter to table viewer.
	 * 
	 * @param filter filter
	 */
	public void addFilter(ViewerFilter filter) {
		if (filter != null) {
			if (hasFilter(filter)) {
				workItemsTableViewer.refresh();
			} else {
				workItemsTableViewer.addFilter(filter);
			}
		}
	}

	/**
	 * removes a filter from viewer.
	 * 
	 * @param filter filter
	 */
	public void removeFilter(ViewerFilter filter) {
		if (filter != null) {
			workItemsTableViewer.removeFilter(filter);
		}

	}
	
	/**
	 * if viewer has this filter.
	 * 
	 * @param filter filter
	 * @return boolean
	 */
	private boolean hasFilter(ViewerFilter filter) {
		for (int i = 0; i < workItemsTableViewer.getFilters().length; i++) {
			if (workItemsTableViewer.getFilters()[i] == filter) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param parent Parent composite for buttons.
	 */
	protected void createControlButtons(final Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		gridData.horizontalSpan = 2;
		group.setLayoutData(gridData);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.horizontalSpacing = 2;
		gridLayout.verticalSpacing = 2;
		group.setLayout(gridLayout);
		final Button equalWidthButton = new Button(group, SWT.CHECK);
		equalWidthButton.setText("Make all columns equal width");
		final Button preferredSizeButton = new Button(group, SWT.CHECK);
		preferredSizeButton.setText("Shrink container to its preferred size");
	}
	
	/**
	 * 
	 */
	public void refreshInput() {
		final List<? extends Checkable> taskItems = projectSpace.getProject().getAllModelElementsbyClass(
			TaskPackage.eINSTANCE.getCheckable(), new BasicEList<Checkable>());

		final WritableList list = (WritableList) (workItemsTableViewer.getInput());
		if (list == null) {
			// the case of first time of input setting to table
			WritableList emfList = new WritableList(Realm.getDefault(), taskItems, UnicaseModelElement.class);
			workItemsTableViewer.setInput(emfList);
		} else {
			list.getRealm().asyncExec(new Runnable() {

				public void run() {
					WritableList emfList = new WritableList(Realm.getDefault(), taskItems, User.class);
					workItemsTableViewer.setInput(emfList);
					// remove all elements
//					list.retainAll(new BasicEList<UnicaseModelElement>());
//					// adds new task items
//					list.addAll(taskItems);
				}
			});
		}
	}

	/**
	 * 
	 * @param project Project
	 */
	public void projectDeleted(Project project) {
		refreshInput();
	}

}


