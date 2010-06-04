/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import java.util.ArrayList;
import java.util.Comparator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * @author Shterev
 */
public class SprintStatusComposite extends Composite implements ProjectChangeObserver {

	private Workspace workspace;
	private AdapterImpl adapterImpl;
	private SprintStatusDropAdapter wpTabDropAdapter;
	private ArrayList<TableViewer> tables = new ArrayList<TableViewer>();
	private SashForm sash;
	private ArrayList<SprintStatusCategory> categories;
	private Label hiddenText;
	private SprintStatusCategory testing;
	private SprintStatusCategory blocked;
	private SprintStatusCategory assigned;
	private SprintStatusCategory unassigned;
	private SprintStatusCategory done;

	/**
	 * Constructor.
	 * 
	 * @param parent parent
	 * @param style style
	 */
	public SprintStatusComposite(Composite parent, int style) {
		super(parent, style);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).applyTo(this);
		hiddenText = new Label(this, SWT.NONE);
		GridDataFactory.fillDefaults().hint(0, 0).applyTo(hiddenText);
		// hiddenText.
		sash = new SashForm(this, SWT.BORDER);
		sash.setSashWidth(2);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(sash);
		setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));

		SprintStatusContentProvider unassignedContentProvider = new SprintStatusContentProvider(
			SprintStatusContentProvider.UNASSIGNED);
		SprintStatusContentProvider assignedContentProvider = new SprintStatusContentProvider(
			SprintStatusContentProvider.ASSIGNED);
		SprintStatusContentProvider blockedContentProvider = new SprintStatusContentProvider(
			SprintStatusContentProvider.BLOCKED);
		SprintStatusContentProvider doneContentProvider = new SprintStatusContentProvider(
			SprintStatusContentProvider.DONE);
		SprintStatusContentProvider testingContentProvider = new SprintStatusContentProvider(
			SprintStatusContentProvider.TESTING);

		unassigned = new SprintStatusCategory(sash, SWT.NONE);
		unassigned.setContentProvider(unassignedContentProvider);
		assigned = new SprintStatusCategory(sash, SWT.NONE);
		assigned.setContentProvider(assignedContentProvider);
		blocked = new SprintStatusCategory(sash, SWT.NONE);
		blocked.setContentProvider(blockedContentProvider);
		testing = new SprintStatusCategory(sash, SWT.NONE);
		testing.setContentProvider(testingContentProvider);
		done = new SprintStatusCategory(sash, SWT.NONE);
		done.setContentProvider(doneContentProvider);

		categories = new ArrayList<SprintStatusCategory>();
		categories.add(assigned);
		categories.add(unassigned);
		categories.add(blocked);
		categories.add(done);
		categories.add(testing);

		sash.setWeights(new int[] { 20, 20, 20, 20, 20 });

		addDnDSupport();
		hookDoubleClick();

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		if (workspace.getActiveProjectSpace() != null) {
			workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(SprintStatusComposite.this);
		}
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {

					// remove old listeners
					Object oldValue = msg.getOldValue();
					if (oldValue instanceof ProjectSpace) {
						((ProjectSpace) oldValue).getProject().removeProjectChangeObserver(SprintStatusComposite.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProjectSpace() != null) {
						workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(
							SprintStatusComposite.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);

	}

	private void addDnDSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };

		wpTabDropAdapter = new SprintStatusDropAdapter();
		for (final TableViewer table : tables) {
			table.addDropSupport(dndOperations, transfers, wpTabDropAdapter);
		}

	}

	// on double-click open the selection
	private void hookDoubleClick() {
		for (final TableViewer table : tables) {
			table.addDoubleClickListener(new IDoubleClickListener() {
				public void doubleClick(DoubleClickEvent event) {
					IStructuredSelection sel = (IStructuredSelection) event.getSelection();
					ActionHelper.openModelElement((UnicaseModelElement) sel.getFirstElement(), table.getClass()
						.getName());
				}

			});
		}
	}

	/**
	 * . set input to TreeViewer
	 * 
	 * @param me input model element
	 */
	public void setInput(UnicaseModelElement me) {
		// hierachieTabDropAdapter.setCurrentOpenME(me);
		for (SprintStatusCategory cat : categories) {
			cat.setInput((WorkPackage) me);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		for (SprintStatusCategory cat : categories) {
			cat.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementRemoved(Project project, ModelElement modelElement) {
		// nothing to do;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.model.UnicaseModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		for (SprintStatusCategory cat : categories) {
			cat.refresh();
		}
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {

		workspace.eAdapters().remove(adapterImpl);
		if (workspace.getActiveProjectSpace() != null && workspace.getActiveProjectSpace().getProject() != null) {
			workspace.getActiveProjectSpace().getProject().removeProjectChangeObserver(SprintStatusComposite.this);
		}
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setFocus() {
		boolean ret = super.setFocus();
		hiddenText.forceFocus();
		return ret;
	}

	/**
	 * Adds a filter to each category.
	 * 
	 * @param filter the filter
	 */
	public void addFilter(SprintFilter filter) {
		for (SprintStatusCategory cat : categories) {
			cat.getContentProvider().addFilter(filter);
		}
	}

	/**
	 * Adds a comparator to each category.
	 * 
	 * @param comparator the comparator
	 * @param index the priority
	 */
	public void addComparator(int index, Comparator<WorkItem> comparator) {
		for (SprintStatusCategory cat : categories) {
			if (comparator instanceof UserComparator) {
				if (cat.equals(testing)) {
					cat.getContentProvider().addComparator(index,
						new UserComparator(TaskPackage.eINSTANCE.getWorkItem_Reviewer()));
				} else {
					cat.getContentProvider().addComparator(index, comparator);
				}
			}
		}
	}

	/**
	 * Removes a filter from each category.
	 * 
	 * @param filter the filter
	 */
	public void removeFilter(SprintFilter filter) {
		for (SprintStatusCategory cat : categories) {
			cat.getContentProvider().removeFilter(filter);
		}
	}

	/**
	 * Adds a comparator to each category.
	 * 
	 * @param comparator the comparator
	 */
	public void removeComparator(Comparator<WorkItem> comparator) {
		for (SprintStatusCategory cat : categories) {
			cat.getContentProvider().removeComparator(comparator);
		}
	}

	/**
	 * Turns the group captions on/off.
	 * 
	 * @param b the visibility
	 */
	public void setShowGroups(boolean b) {
		for (SprintStatusCategory cat : categories) {
			cat.setShowGroups(b);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#projectDeleted(org.unicase.metamodel.Project)
	 */
	public void projectDeleted(Project project) {
		// TODO Auto-generated method stub

	}
}
