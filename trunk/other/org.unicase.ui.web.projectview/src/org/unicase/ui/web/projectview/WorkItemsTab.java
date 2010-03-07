package org.unicase.ui.web.projectview;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.web.projectview.filters.BlockedItemsViewFilter;
import org.unicase.ui.web.projectview.filters.ClosedItemsViewFilter;
import org.unicase.ui.web.projectview.filters.OpenItemsViewFilter;
import org.unicase.ui.web.projectview.filters.ResolvedItemsViewFilter;
import org.unicase.ui.web.views.ProjectAwareTab;
import org.unicase.workspace.ProjectSpace;

/**
 * A tab that shows open work items.
 * 
 * @author emueller
 *
 */
public class WorkItemsTab extends ProjectAwareTab {
	
	private OpenItemsViewFilter openItemsFilter;
	
	private ClosedItemsViewFilter closedItemsFilter;
	
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
		super(projectSpace, tabFolder, "Open work items");
		openItemsFilter = new OpenItemsViewFilter();
		closedItemsFilter = new ClosedItemsViewFilter();
		blockedItemsFilter = new BlockedItemsViewFilter();
		resolvedItemsFilter = new ResolvedItemsViewFilter();
		createFiltersPart(composite);
		workItemsTableViewer = new WorkItemsTableViewer(composite);
	}
	
	public void createTabContent() {
		workItemsTableViewer.setInput(getProjectSpace().getProject());
		
		
		
	}
	
	private void createFiltersPart(final Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText("Filters");
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);		
		
		group.setLayoutData(gridData);
		GridLayout gridLayout = new GridLayout(4, false);
		group.setLayout(gridLayout);
		
		final Button showOpenButton = new Button(group, SWT.CHECK);
		showOpenButton.setText("Show Open Items");
		showOpenButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(final SelectionEvent e) {
				boolean isShowOpenItems = showOpenButton.getSelection();
				if(isShowOpenItems) {
					addFilter(openItemsFilter);
				} else {
					removeFilter(openItemsFilter);
				}
				workItemsTableViewer.refresh();
			}
		});
		
		
		final Button showClosedButton = new Button(group, SWT.CHECK);
		showClosedButton.setText("Show Closed Items");
		showClosedButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(final SelectionEvent e) {
				boolean isShowClosedItems = showClosedButton.getSelection();
				if(isShowClosedItems) {
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
				if(isShowResolvedItems) {
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
				if(isShowBlockedItems) {
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
	
	public void modelElementAdded(Project project, ModelElement modelElement) {
		refreshInput();
	}

	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		refreshInput();
	}

	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		refreshInput();
	}

	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		refreshInput();
	}
	
	public void refreshInput() {
			final List<? extends Checkable> taskItems = projectSpace
					.getProject().getAllModelElementsbyClass(
							TaskPackage.eINSTANCE.getCheckable(),
							new BasicEList<Checkable>());

			for (Iterator<? extends Checkable> iterator = taskItems.iterator(); iterator
					.hasNext();) {
				Checkable item = iterator.next();
				if (item instanceof ActionItem) {
					if (((ActionItem) item).isDone()) {
						iterator.remove();
					}
				} else if (item instanceof BugReport) {
					if (((BugReport) item).isDone()) {
						iterator.remove();
					}
				} else if (item instanceof Issue) {
					if (((Issue) item).getSolution() != null) {
						iterator.remove();
					}
				}
			}
			
			final WritableList list = (WritableList) (workItemsTableViewer.getInput());
			if (list == null) {
				// the case of first time of input setting to table
				WritableList emfList = new WritableList(Realm.getDefault(),
						taskItems, UnicaseModelElement.class);
				workItemsTableViewer.setInput(emfList);
			} else {
				list.getRealm().asyncExec(new Runnable() {

					public void run() {
						// remove all elements
						list.retainAll(new BasicEList<UnicaseModelElement>());
						// adds new task items
						list.addAll(taskItems);
					}
				});
			}
	}

}
