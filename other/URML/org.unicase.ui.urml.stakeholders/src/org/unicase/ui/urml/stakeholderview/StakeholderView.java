/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeNodeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ui.urml.stakeholderview.reviewview.input.TestLabelProvider;
import org.unicase.ui.urml.stakeholderview.reviewview.input.TestTree;
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

	private TreeViewer treeViewer;
	private ILabelProvider labelProvider;
	private Action openReviewView;
	private MenuManager filterToRole;
	
	private StakeholderRegistry registry = new StakeholderRegistry();
	private FilterManager filterManager = new FilterManager();
	
	@Override
	public void createPartControl(Composite parent) {
		
		setupTreeViewe(parent);
		
		try {
			//TODO createTestTree must be modified, because no children are visible now
			// poniter of the roots
			treeViewer.setInput(TestTree.createTestTree());

			createAction(UrmlTreeHandler.getTestProject());
			createFilterAction(UrmlTreeHandler.getTestProject());
			
		} catch (NoWorkspaceException e) {
			e.printStackTrace();
		}
		  
	}

	private void setupTreeViewe(Composite parent) {
		labelProvider = new TestLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				   ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		
		treeViewer = new TreeViewer(parent);
		//default content provider
		treeViewer.setContentProvider(new TreeNodeContentProvider());
		treeViewer.setLabelProvider(labelProvider);
	}
	
	@Override
	public void setFocus() {
		
	}

	private void createAction(final ECPProject project){
		IActionBars bars = getViewSite().getActionBars();
	//	IToolBarManager toolbarManager = bars.getToolBarManager();
		IMenuManager menuManager = bars.getMenuManager();

		
		openReviewView = new Action() {
			
			@Override
			public void run() {
			
				page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			
				try {
					//wie kann man das anders machen ohne warning
					 page.showView(STATUS_VIEW_ID, null,
								IWorkbenchPage.VIEW_ACTIVATE);
					
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

 		};
 		openReviewView.setText("Open Review View...");
		openReviewView.setToolTipText("Open Review View");
		menuManager.add(openReviewView);
 		
	}	
 		
 		private void createFilterAction(final ECPProject project){
 			IActionBars bars = getViewSite().getActionBars();
 		//	IToolBarManager toolbarManager = bars.getToolBarManager();
 			IMenuManager menuManager = bars.getMenuManager();

 						
 			filterToRole = new MenuManager("Filter to role...",Activator.getImageDescriptor("icons/Stakeholder.gif"),"org.unicase.ui.urml.stakeholders.FilterToRole");
 	 	 	menuManager.add(filterToRole);
 	 		
 	 	 	//Add the "remove filters" entry
 	 	 	Action resetFilters = new Action(){
 	 	 		@Override
 	 	 		public void run() {
 	 	 			filterManager.removeFilters();
 	 	 		}
 	 	 	};
 	 	 	resetFilters.setText("<< remove filters >>");
 	 	 	resetFilters.setToolTipText("Removes all filters, hence showing all elements.");
 	 	 	filterToRole.add(resetFilters);
 	 	 	
 	 	 	//Add stakeholder role entries
 	 	 	for(StakeholderRole r : registry.getRoles()){
 	 	 		final StakeholderRole r2 = r;
 	 	 		Action a = new Action(){
 	 	 			@Override
 	 	 			public void run() {
 	 	 				filterManager.applyFilter(r2.getViewerFilter());
 	 	 			}
 	 	 		};
 	 	 		a.setText(r.getName());
 	 	 		a.setToolTipText("Filter to elements that are important for the " + r.getName());
 	 	 		filterToRole.add(a);
 	 	 	}
 		}
}
