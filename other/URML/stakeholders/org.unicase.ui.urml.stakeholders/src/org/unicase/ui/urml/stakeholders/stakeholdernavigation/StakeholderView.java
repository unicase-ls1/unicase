/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.stakeholdernavigation;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
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
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.config.DefaultStakeholderRoles;
import org.unicase.ui.urml.stakeholders.config.ManageRolesDialog;
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;
import org.unicase.ui.urml.stakeholders.filtering.FilterManager;
import org.unicase.ui.urml.stakeholders.review.ReviewView;
import org.unicase.ui.urml.stakeholders.review.input.UrmlTreeHandler;

/**
 * The stakeholder view with navigation options.
 * 
 * @author kterzieva
 */

public class StakeholderView extends ViewPart implements Observer {

	private static final String NO_STAKEHOLDER = "[no stakeholder]";
	private static final String MANAGE_STAKEHOLDER_ROLES = "Manage stakeholder roles";
	private static final String CHOOSE_STAKEHOLDER_ROLE = "Choose Stakeholder Role";
	private static final String UNREVIEWED_ELEMENTS = "Unreviewed Modelelements:";
	private static final String REVIEWED_ELEMENTS = "Reviewed Modelelements:";
	private static final String STATUS_VIEW_ID = "ReviewView";
	private IWorkbenchPage page;
	private Action openReviewView;
	private MenuManager chooseRole;
	private FilterManager filterManager = new FilterManager();
	private Project activeProject;
	private Link unreviewedRequirements, reviewedRequirements;
	//private static StakeholderRole activeRole;
	private Text txtUser;
	private Link link;
	private Label label;
	private ReviewView test;

	@Override
	public void createPartControl(Composite parent) {

		try {
			parent.setLayout(new GridLayout(1, false));
			parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
			activeProject = UrmlTreeHandler.getTestProject();
			Activator.getTracker().addObserver(this);
			reviewedRequirements = reviewedRequirementSetup(parent, activeProject, true, REVIEWED_ELEMENTS, UrmlSettingsManager.INSTANCE.getActiveRole());
			unreviewedRequirements = reviewedRequirementSetup(parent, activeProject, false, UNREVIEWED_ELEMENTS,
				UrmlSettingsManager.INSTANCE.getActiveRole());

			createActiveRoleLabel(parent);
			createShowPropertyRoleButton(parent);
			createOpenReviewViewAction();
			createFilterAction(UrmlTreeHandler.getTestProject());

		} catch (NoWorkspaceException e) {
			e.printStackTrace();
		}

	}

	private void createShowPropertyRoleButton(Composite parent) {
		Button showProp = new Button(parent, SWT.NONE);
		showProp.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));
		showProp.setText("Show role properties");
		showProp.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Test", 
					"Active role: " +
					"\n\n" +
					"Review set settings: \n" +
					"\n\n" + 
					"Filter set settings: \n\n" +
					"");
			}
		});
	}
	
	private void createActiveRoleLabel(Composite parent) {
		label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
		if (UrmlSettingsManager.INSTANCE.getActiveRole() == null) {
			label.setText("Active role : " + NO_STAKEHOLDER);
		} else {
			label.setText("Active role : " + UrmlSettingsManager.INSTANCE.getActiveRole().getName().toString());
		}

	}

	private Link reviewedRequirementSetup(Composite parent, Project project, final boolean selectReviewed,
		String linkText, StakeholderRole activeRole) throws NoWorkspaceException {
		link = new Link(parent, SWT.WRAP);
		GridData data = new GridData(SWT.FILL, SWT.BEGINNING, false, false);
		// data.widthHint = 300;
		link.setLayoutData(data);
		//+ Activator.getTracker().getReviewedElements(selectReviewed)
		link.setText("<a>" + linkText + "</a> ");

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

	private void createOpenReviewViewAction() {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menuManager = bars.getMenuManager();

		openReviewView = new Action() {

			@Override
			public void run() {

				page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

				try {
					test = (ReviewView) page.showView(STATUS_VIEW_ID, null, IWorkbenchPage.VIEW_ACTIVATE);

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
		IToolBarManager toolbarManager = bars.getToolBarManager();

		chooseRole = new MenuManager(CHOOSE_STAKEHOLDER_ROLE, Activator.getImageDescriptor("icons/Stakeholder.gif"),
			"org.unicase.ui.urml.stakeholders.FilterToRole");
		menuManager.add(chooseRole);

		createDefaultRolesIfNotExist();
		createFilterMenuItems();
		createOtherItems();
		
		ControlContribution userTextToolbarContribution = new ControlContribution("userTextl") {

			@Override
			protected Control createControl(Composite parent) {
				Composite composite = new Composite(parent, SWT.NONE);
				GridLayoutFactory.fillDefaults().margins(1, 0).spacing(0, 0).applyTo(composite);
				txtUser = new Text(composite, SWT.NONE);
				GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, true);
				layoutData.widthHint = 100;
				txtUser.setLayoutData(layoutData);
				txtUser.setEditable(false);
				if (UrmlSettingsManager.INSTANCE.getActiveRole() != null) {
					txtUser.setText(UrmlSettingsManager.INSTANCE.getActiveRole().getName());
				} else {
					txtUser.setText(NO_STAKEHOLDER);
				}
				return composite;
			}

		};

		toolbarManager.add(userTextToolbarContribution);
	}

	private void createOtherItems() {
		chooseRole.add(new Separator());
		Action manageStakeholderRoles = new Action() {
			@Override
			public void run() {
				ManageRolesDialog t = new ManageRolesDialog(reviewedRequirements.getShell());
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
				txtUser.setText(NO_STAKEHOLDER);
				label.setText("Active role : " + NO_STAKEHOLDER);
				
				// TODO stakeholder view should be updated! Number of reviewed/unreviewed elem.is 0.

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
			Action a = createSelectedRoleAction(role);
			a.setText(role.getName());
			a.setToolTipText("Filter to elements that are important for the " + role.getName());
			chooseRole.add(a);
		}
	}

	private Action createSelectedRoleAction(final StakeholderRole role) {
		Action a = new Action() {
			@Override
			public void run() {
				setRoleProperties(role);
				filterManager.applyFilter(new ViewerFilter() {
					@Override
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof UrmlModelElement) {
							EMap<EClass, EList<EStructuralFeature>> filterSet = role.getFilterSet();
							for (Entry<EClass, EList<EStructuralFeature>> entry : filterSet) {		
								 if(entry.getKey().getName().equals(((UrmlModelElement) element).eClass().getName())){
									 return true;
								 }
							}
							return false;
						}
						return true;
					}
				});				
				if(test != null){
					test.setInputFromRole(activeProject, role);
				}
			}
		};
		return a;
	}

	private void setRoleProperties(final StakeholderRole role) {
		UrmlSettingsManager.INSTANCE.setActiveRole(role);
		label.setText("Active role : " + UrmlSettingsManager.INSTANCE.getActiveRole().getName());
		txtUser.setText(UrmlSettingsManager.INSTANCE.getActiveRole().getName());
	}
	
	@Override
	public void update(Observable o, Object arg) {
	//	ReviewedTracker tracker = (ReviewedTracker) o;
		reviewedRequirements.setText(REVIEWED_ELEMENTS);
		// + tracker.getReviewedElements(true)
		unreviewedRequirements.setText(UNREVIEWED_ELEMENTS);
		//tracker.getReviewedElements(false)

	}

	@Override
	public void setFocus() {

	}

//	/**
//	 * Gets the current stakeholder role.
//	 * 
//	 * @return activeRole the active stakeholder role
//	 */
//	public static StakeholderRole getActiveRole() {
//		return activeRole;
//	}

//	/**
//	 * Sets the active role.
//	 * @param role the role to be set
//	 * @return activeRole the active role
//	 */
//	public static StakeholderRole setActiveRole(StakeholderRole role) {
//		activeRole = role;
//		return activeRole;
//	}

}
