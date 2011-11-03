/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.navigation;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
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
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.StakeholderUtil;
import org.unicase.ui.urml.stakeholders.config.DefaultStakeholderRoles;
import org.unicase.ui.urml.stakeholders.config.ManageRolesDialog;
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;
import org.unicase.ui.urml.stakeholders.review.ReviewView;

/**
 * The stakeholder view with navigation options.
 * 
 * @author kterzieva
 */

public class NavigationView extends ViewPart {

	private static final String NO_STAKEHOLDER = "[no stakeholder]";
	private static final String MANAGE_STAKEHOLDER_ROLES = "Manage stakeholder roles";
	private static final String CHOOSE_STAKEHOLDER_ROLE = "Choose Stakeholder Role";
	private static final String UNREVIEWED_ELEMENTS = "Unreviewed Modelelements:";
	private static final String REVIEWED_ELEMENTS = "Reviewed Modelelements:";
	private static final String STATUS_VIEW_ID = "ReviewView";
	private IWorkbenchPage page;
	private Action openReviewView;
	private MenuManager chooseRole;
	private Project activeProject;
	private Observer roleChangedObserver;
	// private static StakeholderRole activeRole;
	private Text txtUser;
	private Link link;
	private Label label;

	@Override
	public void createPartControl(Composite parent) {
			Color white = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
			parent.setLayout(new GridLayout(1, false));
			parent.setBackground(white);
			activeProject = StakeholderUtil.getActiveProject();
			
			roleChangedObserver = new Observer() {
				
				@Override
				public void update(Observable o, Object arg) {
					StakeholderRole role = (StakeholderRole) arg;
					if(role == null){				
						txtUser.setText(NO_STAKEHOLDER);
						label.setText("Active role : " + NO_STAKEHOLDER);
					} else {	
						label.setText("Active role : " + UrmlSettingsManager.INSTANCE.getActiveRole().getName());
						txtUser.setText(UrmlSettingsManager.INSTANCE.getActiveRole().getName());
					}
				}
			};
			Activator.getRoleChangedPublisher().addObserver(roleChangedObserver);

			Label l = new Label(parent, SWT.None);
			l.setText("Project Status Overview");
			l.setBackground(white);
			ReviewStatusControl reviewSatus = new ReviewStatusControl(parent, SWT.NONE);
			reviewSatus.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			
			createActiveRoleLabel(parent,white);
			createShowPropertyRoleButton(parent);
			createOpenReviewViewAction();
			createFilterAction(activeProject);

		

	}

	private void createShowPropertyRoleButton(Composite parent) {
		Button showProp = new Button(parent, SWT.NONE);
		showProp.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING,
				false, false));
		showProp.setText("Show role properties");
		showProp.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), "Test",
						"Active role: " + "\n\n" + "Review set settings: \n"
								+ "\n\n" + "Filter set settings: \n\n" + "");
			}
		});
	}

	private void createActiveRoleLabel(Composite parent, Color white) {
		label = new Label(parent, SWT.NONE);
		label.setBackground(white);
		label.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
		if (UrmlSettingsManager.INSTANCE.getActiveRole() == null) {
			label.setText("Active role : " + NO_STAKEHOLDER);
		} else {
			label.setText("Active role : "
					+ UrmlSettingsManager.INSTANCE.getActiveRole().getName()
							.toString());
		}

	}

	private void createOpenReviewViewAction() {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menuManager = bars.getMenuManager();

		openReviewView = new Action() {

			@Override
			public void run() {

				page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage();

				try {
					page.showView(STATUS_VIEW_ID, null,
							IWorkbenchPage.VIEW_ACTIVATE);

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

		chooseRole = new MenuManager(CHOOSE_STAKEHOLDER_ROLE,
				Activator.getImageDescriptor("icons/Stakeholder.gif"),
				"org.unicase.ui.urml.stakeholders.FilterToRole");
		menuManager.add(chooseRole);

		createDefaultRolesIfNotExist();
		createFilterMenuItems();
		createOtherItems();

		ControlContribution userTextToolbarContribution = new ControlContribution(
				"userTextl") {

			@Override
			protected Control createControl(Composite parent) {
				Composite composite = new Composite(parent, SWT.NONE);
				GridLayoutFactory.fillDefaults().margins(1, 0).spacing(0, 0)
						.applyTo(composite);
				txtUser = new Text(composite, SWT.NONE);
				GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true,
						true);
				layoutData.widthHint = 100;
				txtUser.setLayoutData(layoutData);
				txtUser.setEditable(false);
				if (UrmlSettingsManager.INSTANCE.getActiveRole() != null) {
					txtUser.setText(UrmlSettingsManager.INSTANCE
							.getActiveRole().getName());
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
				ManageRolesDialog t = new ManageRolesDialog(txtUser.getShell());
				t.open();
				refreshRoleList();
			}
		};
		manageStakeholderRoles.setText(MANAGE_STAKEHOLDER_ROLES);
		manageStakeholderRoles
				.setToolTipText("Manages the Stakeholder toles with Dialog for choosing the settings.");
		chooseRole.add(manageStakeholderRoles);

		// Add the "remove filters" entry
		Action resetFilters = new Action() {
			@Override
			public void run() {
				UrmlSettingsManager.INSTANCE.setActiveRole(null);
			}
		};
		resetFilters.setText("No active role");
		resetFilters
				.setToolTipText("Sets no role as active, hence all elements are shown.");
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
		if (activeProject.getAllModelElementsbyClass(
				UrmlPackage.eINSTANCE.getStakeholderRole(),
				new BasicEList<EObject>()).isEmpty()) {
			new DefaultStakeholderRoles().createDefaultRoles(activeProject);
		}
	}

	private void createFilterMenuItems() {
		Collection<StakeholderRole> roles = activeProject
				.getAllModelElementsbyClass(
						UrmlPackage.eINSTANCE.getStakeholderRole(),
						new BasicEList<StakeholderRole>());
		for (StakeholderRole role : roles) {
			Action a = createSelectedRoleAction(role);
			a.setText(role.getName());
			a.setToolTipText("Filter to elements that are important for the "
					+ role.getName());
			chooseRole.add(a);
		}
	}

	private Action createSelectedRoleAction(final StakeholderRole role) {
		Action a = new Action() {
			@Override
			public void run() {
				UrmlSettingsManager.INSTANCE.setActiveRole(role);

			}
		};
		return a;
	}

	@Override
	public void setFocus() {

	}

	@Override
	public void dispose() {
		super.dispose();
		Activator.getRoleChangedPublisher().deleteObserver(roleChangedObserver);
	}

}
