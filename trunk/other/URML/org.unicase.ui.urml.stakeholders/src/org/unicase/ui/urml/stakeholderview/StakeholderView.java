/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.metamodel.Project;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.reviewview.ReviewView;
import org.unicase.ui.urml.reviewview.ReviewedTracker;
import org.unicase.ui.urml.stakeholderview.reviewview.input.UrmlTreeHandler;
import org.unicase.ui.urml.stakeholderview.roles.DefaultStakeholderRoles;

/**
 * The stakeholder view with navigation options.
 * 
 * @author kterzieva
 */

public class StakeholderView extends ViewPart implements Observer {

	private static final String MANAGE_STAKEHOLDER_ROLES = "Manage stakeholder roles";
	private static final String CHOOSE_STAKEHOLDER_ROLE = "Choose Stakeholder Role";
	private static final String UNREVIEWED_REQUIREMENTS = "Unreviewed Requirements:";
	private static final String REVIEWED_REQUIREMENTS = "Reviewed Requirements:";
	private static final String STATUS_VIEW_ID = "ReviewView";
	private IWorkbenchPage page;
	private Action openReviewView;
	private MenuManager chooseRole;
	private FilterManager filterManager = new FilterManager();
	private Project activeProject;
	private Link unreviewedReqirements, reviewedReqirements;
	public static StakeholderRole activeRole;

	@Override
	public void createPartControl(Composite parent) {

		try {
			parent.setLayout(new GridLayout(1, false));
			activeProject = UrmlTreeHandler.getTestProject();
			Activator.getTracker().addObserver(this);
			reviewedReqirements = reviewedRequirementSetup(parent, activeProject, true, REVIEWED_REQUIREMENTS);
			unreviewedReqirements = reviewedRequirementSetup(parent, activeProject, false, UNREVIEWED_REQUIREMENTS);

			createOpenReviewViewAction(UrmlTreeHandler.getTestProject());
			createFilterAction(UrmlTreeHandler.getTestProject());

		} catch (NoWorkspaceException e) {
			e.printStackTrace();
		}

	}

	private Link reviewedRequirementSetup(Composite parent, Project project, final boolean selectReviewed,
		String linkText) throws NoWorkspaceException {
		Link link = new Link(parent, SWT.WRAP);
		GridData data = new GridData(SWT.FILL, SWT.BEGINNING, false, false);
	//	data.widthHint = 300;
		link.setLayoutData(data);
		link.setText("<a>" + linkText + "</a> " + "<a>" + Activator.getTracker().getReviewedElements(selectReviewed)
			+ "</a>");
		link.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

				try {
					ReviewView reviewView = (ReviewView) page.showView(STATUS_VIEW_ID, null,
						IWorkbenchPage.VIEW_ACTIVATE);
					reviewView.showOnlyReviewedElements(selectReviewed);
				} catch (PartInitException e1) {
					e1.printStackTrace();
				}
			}
		});
		return link;
	}

	private void createOpenReviewViewAction(final Project project) {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menuManager = bars.getMenuManager();

		openReviewView = new Action() {

			@Override
			public void run() {

				page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

				try {
					page.showView(STATUS_VIEW_ID, null, IWorkbenchPage.VIEW_ACTIVATE);

				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}

		};
		openReviewView.setText("Open Review View...");
		openReviewView.setToolTipText("Open Review View");
		menuManager.add(openReviewView);

	}

	private void createFilterAction(final Project project) {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menuManager = bars.getMenuManager();

		chooseRole = new MenuManager(CHOOSE_STAKEHOLDER_ROLE, Activator.getImageDescriptor("icons/Stakeholder.gif"),
			"org.unicase.ui.urml.stakeholders.FilterToRole");
		menuManager.add(chooseRole);

		createDefaultRolesIfNotExist();
		createFilterMenuItems();

		createOtherItems();

	}

	private void createOtherItems() {
		chooseRole.add(new Separator());
		Action manageStakeholderRoles = new Action() {
			@Override
			public void run() {
				ManageRolesDialog t = new ManageRolesDialog(reviewedReqirements.getShell());
				t.open();
				if (t.isRoleListHasChanged()) {
					refreshRoleList();
				}
			}
		};
		manageStakeholderRoles.setText(MANAGE_STAKEHOLDER_ROLES);
		manageStakeholderRoles.setToolTipText("Manages the Stakeholder toles with Dialog for choosing the settings.");
		chooseRole.add(manageStakeholderRoles);

		// Add the "remove filters" entry
		Action resetFilters = new Action() {
			@Override
			public void run() {
				filterManager.removeFilters();
			}
		};
		resetFilters.setText("Reset role settings");
		resetFilters.setToolTipText("Reset maded role settings, hence showing all elements.");
		chooseRole.add(resetFilters);
	}

	/**
	 * Updated the role list.
	 */
	protected void refreshRoleList() {
		chooseRole.removeAll();
		createFilterMenuItems();
		createOtherItems();
	}

	private void createDefaultRolesIfNotExist() {
		if (activeProject.getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getStakeholderRole(),
			new BasicEList<EObject>()).isEmpty()) {
			new DefaultStakeholderRoles().createDefaultRoles(activeProject);
		}
	}

	private void createFilterMenuItems() {
		Collection<EObject> defaultRoles = activeProject.getAllModelElementsbyClass(UrmlPackage.eINSTANCE
			.getStakeholderRole(), new BasicEList<EObject>());
		for (EObject obj : defaultRoles) {
			final StakeholderRole role = (StakeholderRole) obj;
			Action a = createMenuAction(role);
			a.setText(role.getName());
			a.setToolTipText("Filter to elements that are important for the " + role.getName());
			chooseRole.add(a);
		}
	}

	private Action createMenuAction(final StakeholderRole role) {
		Action a = new Action() {
			@Override
			public void run() {
				activeRole = role;
				filterManager.applyFilter(new ViewerFilter() {
					@Override
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof UrmlModelElement) {
							return role.getFilterSet().contains(((UrmlModelElement) element).eClass().getName());
						}
						return true;	
					}

				});
				ReviewView reviewView = null;
				page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					reviewView = (ReviewView) page.showView(STATUS_VIEW_ID, null, IWorkbenchPage.VIEW_ACTIVATE);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
				reviewView.setInputFromRole(activeProject, role);
			}
		};
		return a;
	}

	@Override
	public void update(Observable o, Object arg) {
		ReviewedTracker tracker = (ReviewedTracker) o;
		reviewedReqirements.setText(REVIEWED_REQUIREMENTS + tracker.getReviewedElements(true));
		unreviewedReqirements.setText(UNREVIEWED_REQUIREMENTS + tracker.getReviewedElements(false));

	}

	@Override
	public void setFocus() {

	}

	/**
	 * Gets the current stakeholder role.
	 * @return activeRole the active stakeholder role
	 */
	public static StakeholderRole getActiveRole() {
		return activeRole;
	}

}
