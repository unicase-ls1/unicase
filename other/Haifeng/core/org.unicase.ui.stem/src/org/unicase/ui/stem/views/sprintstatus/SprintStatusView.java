/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import java.util.Comparator;
import java.util.HashSet;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.observer.FocusEventObserver;
import org.unicase.ui.stem.Activator;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * A view that displays the status of a given sprint (work package). It is mainly used to plan the sprint and
 * (re-)assign the work items.
 * 
 * @author Shterev
 */
public class SprintStatusView extends ViewPart {

	/**
	 * An Action to filter the contents to a specific user.
	 * 
	 * @author Shterev
	 */
	private final class FilterByUserAction extends Action {
		private final AdapterFactoryLabelProvider adapterFactoryLabelProvider;
		private final SprintUserFilter userFilter;

		private FilterByUserAction(String text, int style, AdapterFactoryLabelProvider adapterFactoryLabelProvider) {
			super(text, style);
			this.adapterFactoryLabelProvider = adapterFactoryLabelProvider;
			this.userFilter = new SprintUserFilter();
		}

		@Override
		public void run() {
			if (isChecked()) {
				if (input != null && TaskPackage.eINSTANCE.getWorkPackage().isInstance(input)) {
					WorkPackage workPackage = (WorkPackage) input;
					HashSet<OrgUnit> userSet = new HashSet<OrgUnit>();
					for (WorkItem wi : workPackage.getAllContainedWorkItems()) {
						userSet.add(wi.getAssignee());
						userSet.add(wi.getReviewer());
						userSet.addAll(wi.getParticipants());
					}
					userSet.remove(null);
					ElementListSelectionDialog dlg = new ElementListSelectionDialog(getSite().getShell(),
						adapterFactoryLabelProvider);
					dlg.setMultipleSelection(false);
					dlg.setElements(userSet.toArray());
					dlg.setTitle("Select User");
					dlg.setBlockOnOpen(true);
					if (dlg.open() == Window.OK) {
						userFilter.setUser((OrgUnit) dlg.getFirstResult());
					}

				}
				statusComposite.addFilter(userFilter);
			} else {
				statusComposite.removeFilter(userFilter);
			}
			setInput(input);
		}
	}

	/**
	 * Compares two work items acc. to their priority.
	 * 
	 * @author Shterev
	 */
	private class PriorityComparator implements Comparator<WorkItem> {

		public int compare(WorkItem o1, WorkItem o2) {
			int prio1 = o1.getPriority();
			int prio2 = o2.getPriority();
			if (prio1 == prio2) {
				return 0;
			} else if (prio1 > prio2) {
				return -1;
			}
			return 1;
		}
	}

	/**
	 * Compares two work items acc. to their names.
	 * 
	 * @author Shterev
	 */
	private class NameComparator implements Comparator<WorkItem> {

		public int compare(WorkItem o1, WorkItem o2) {
			return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
		}
	}

	/**
	 * ID for this view.
	 */
	public static final String ID = "org.unicase.ui.stem.views.sprintstatus.SprintStatusView";

	private UnicaseModelElement input;

	private SprintStatusComposite statusComposite;

	/**
	 * Constructor.
	 */
	public SprintStatusView() {
		this.input = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		final AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		statusComposite = new SprintStatusComposite(parent, SWT.NONE);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(statusComposite);

		statusComposite.addComparator(0, new NameComparator());
		statusComposite.addComparator(0, new PriorityComparator());

		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();
		Action refresh = new Action() {
			@Override
			public void run() {
				setInput(input);
			}
		};
		refresh.setImageDescriptor(Activator.getImageDescriptor("/icons/refresh.png"));
		refresh.setToolTipText("Refresh");
		menuManager.add(refresh);

		Action filterByUser = new FilterByUserAction("", SWT.TOGGLE, adapterFactoryLabelProvider);
		filterByUser.setChecked(false);

		filterByUser.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertouser.png"));
		filterByUser.setToolTipText("Filter to a user");
		menuManager.add(filterByUser);

		final UserComparator assigneeComparator = new UserComparator(TaskPackage.eINSTANCE.getWorkItem_Assignee());
		Action groupByUser = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				if (isChecked()) {
					statusComposite.addComparator(0, assigneeComparator);

					statusComposite.setShowGroups(true);
				} else {
					statusComposite.removeComparator(assigneeComparator);
					statusComposite.setShowGroups(false);
				}
				setInput(input);
			}
		};
		groupByUser.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertomyteam.png"));
		groupByUser.setToolTipText("Group by user");
		groupByUser.setChecked(false);
		menuManager.add(groupByUser);

	}

	/**
	 * Refresh top composite and tabs based on input.
	 */
	public void refreshView() {
		if (input == null) {
			return;
		}

		if (TaskPackage.eINSTANCE.getWorkPackage().isInstance(input) && statusComposite != null) {
			statusComposite.setInput(input);
		}
	}

	/**
	 * Set input to the view. currently input is set using drag and drop on top composite. Later we implement a context
	 * menu command for it too.
	 * 
	 * @param me input model element
	 */
	public void setInput(UnicaseModelElement me) {
		UnicaseModelElement newInput = me;
		if (newInput == null) {
			newInput = UnicaseActionHelper.getSelectedModelElement();
		}
		if (input == null || newInput != null) {
			input = newInput;
		}
		statusComposite.setFocus();
		refreshView();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		ECPWorkspaceManager.getObserverBus().notify(FocusEventObserver.class).onFocusEvent(ID);
		// getViewSite().getPart().setFocus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		statusComposite.dispose();
		super.dispose();
	}
}
