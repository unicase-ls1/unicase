/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import java.util.Collection;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.model.urml.requirement.Requirement;
import org.unicase.ui.urml.stakeholderview.reviewview.input.UrmlTreeHandler;
import org.unicase.ui.urml.stakeholderview.roles.StakeholderRegistry;
import org.unicase.ui.urml.stakeholderview.roles.StakeholderRole;

/**
 * The stakeholder view with navigation options.
 * 
 * @author kterzieva
 */

public class StakeholderView extends ViewPart {

	private static final String STATUS_VIEW_ID = "ReviewView";
	private IWorkbenchPage page;

//	private TreeViewer treeViewer;
//	private ILabelProvider labelProvider;
	private Action openReviewView;
	private MenuManager createRole;
//	private int reviewedReq;

	private StakeholderRegistry registry = new StakeholderRegistry();
	private FilterManager filterManager = new FilterManager();

	@Override
	public void createPartControl(Composite parent) {

		// setupTreeViewer(parent);

		try {
			// treeViewer.setInput(TestTree.createTestTree());
			parent.setLayout(new GridLayout(1, false));
			Label reviewedReqirements = new Label(parent, SWT.BORDER);
			reviewedReqirements.getParent().setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
			reviewedReqirements.setText("Reviewed Requirements: " + getReviewedElements());
			reviewedReqirements.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false));
			Label unreviewedReqirements = new Label(parent, SWT.BORDER);
			unreviewedReqirements.getParent().setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
			unreviewedReqirements.setText("Unreviewed Requirements: ");
			unreviewedReqirements.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, false, false));
			createAction(UrmlTreeHandler.getTestProject());
			createFilterAction(UrmlTreeHandler.getTestProject());

		} catch (NoWorkspaceException e) {
			e.printStackTrace();
		}

	}

	private int getReviewedElements() throws NoWorkspaceException {
		Collection<Requirement> requirements = UrmlTreeHandler.getRequirementsFromProject(UrmlTreeHandler.getTestProject());
		int reviewed = 0;
		for (Requirement r : requirements){
			if (r.isReviewed()){
				reviewed++;
			}else{
				continue;
			}
		}
		return reviewed;
	}


	// private void setupTreeViewer(Composite parent) {
	// labelProvider = new TestLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
	// ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
	//		
	// treeViewer = new TreeViewer(parent);
	// //default content provider
	// treeViewer.setContentProvider(new TreeNodeContentProvider());
	// treeViewer.setLabelProvider(labelProvider);
	// }

	@Override
	public void setFocus() {

	}

	private void createAction(final ECPProject project) {
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

	private void createFilterAction(final ECPProject project) {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menuManager = bars.getMenuManager();

		createRole = new MenuManager("Create role...", Activator.getImageDescriptor("icons/Stakeholder.gif"),
			"org.unicase.ui.urml.stakeholders.FilterToRole");
		menuManager.add(createRole);

		// Add the "remove filters" entry
		Action resetFilters = new Action() {
			@Override
			public void run() {
				filterManager.removeFilters();
			}
		};
		resetFilters.setText("<< remove filters >>");
		resetFilters.setToolTipText("Removes all filters, hence showing all elements.");
		createRole.add(resetFilters);

		// Add stakeholder role entries
		for (StakeholderRole r : registry.getRoles()) {
			final StakeholderRole r2 = r;
			Action a = new Action() {
				@Override
				public void run() {
					filterManager.applyFilter(r2.getViewerFilter());
				}
			};
			a.setText(r.getName());
			a.setToolTipText("Filter to elements that are important for the " + r.getName());
			createRole.add(a);
		}
	}
}
