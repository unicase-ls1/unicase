/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.visualization.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecp.common.MEClassLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.unicasecommon.navigator.wizards.ModelClassFilter;
import org.unicase.ui.unicasecommon.navigator.wizards.ModelTreeContentProvider;
import org.unicase.ui.visualization.views.VisualizationView;

/**
 * 
 * @author Julian Sommerfeldt
 *
 */
public class FilterEClassType extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {		
		if(Boolean.parseBoolean(event.getParameter("org.unicase.ui.visualization.filterEClassType.filterPar"))){
			new WizardDialog(HandlerUtil.getActiveShell(event), new FilterEClassTypeWizard((VisualizationView) HandlerUtil.getActivePart(event))).open();
		} else {
			((VisualizationView) HandlerUtil.getActivePart(event)).showFiltered(null);
		}
		return null;
	}
	
	/**
	 * Wizard for type filtering. 
	 */
	class FilterEClassTypeWizard extends Wizard implements IWorkbenchWizard {
		
		private List<EClass> eClassTypes;

		private boolean treePageCompleted;
		
		private VisualizationView view;
		
		/**
		 * Constructor.
		 * 
		 * @param view The {@link VisualizationView}
		 */
		public FilterEClassTypeWizard(VisualizationView view){
			this.view = view;
		}

		@Override
		public void addPages() {
			addPage(new FilterEClassPage("SelectEClassPage"));
		}

		@Override
		public boolean performFinish() {
			if (eClassTypes != null){
				view.showFiltered(eClassTypes);
			}
			return true;
		}
		
		@Override
		public void init(IWorkbench workbench, IStructuredSelection selection) {}

		@Override
		public boolean canFinish() {
			return treePageCompleted;
		}
		
		/**
		 * The wizardPage.
		 */
		class FilterEClassPage extends WizardPage implements Listener {

			private TreeViewer treeViewer;
			private static final String PAGE_TITLE = "Filter for model element types";
			private static final String PAGE_DESCRIPTION = "Select model element types";
			
			/**
			 * Constructor.
			 *  
			 * @param pageName The name of the page.
			 */
			protected FilterEClassPage(String pageName) {
				super(pageName);
				setTitle(PAGE_TITLE);
				setDescription(PAGE_DESCRIPTION);
			}
			
			/**
			 * @param parent The parent.
			 */
			public void createControl(Composite parent) {

				Composite composite = new Composite(parent, SWT.NULL);

				GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(composite);

				Label filterLabel = new Label(composite, SWT.LEFT);
				filterLabel.setText("Search:");
				final Text filterInput = new Text(composite, SWT.SEARCH);
				filterInput.setMessage("Model Element class");
				GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(filterInput);
				Tree tree = new Tree(composite, SWT.MULTI);
				final ModelClassFilter filter = new ModelClassFilter();
				filterInput.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						String text = filterInput.getText();
						filter.setSearchTerm(text);
						treeViewer.expandAll();
						if (text != null && text.length() == 0) {
							treeViewer.collapseAll();
						}
						treeViewer.refresh();
					}
				});

				treeViewer = new TreeViewer(tree);
				GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(treeViewer.getControl());
				treeViewer.setContentProvider(new ModelTreeContentProvider());
				treeViewer.setLabelProvider(new MEClassLabelProvider());
				treeViewer.addFilter(filter);
				treeViewer.setInput(new Object());
				treeViewer.getTree().addListener(SWT.Selection, this);
				
				setControl(composite);
			}

			@Override
			public boolean canFlipToNextPage() {
				return false;
			}

			@SuppressWarnings({ "rawtypes", "unchecked" })
			private boolean checkSelection() {

				boolean canFinish = false;
				ISelection sel = treeViewer.getSelection();
				
				if (sel == null || !(sel instanceof IStructuredSelection)){
					canFinish = false;
				}
				
				IStructuredSelection ssel = (IStructuredSelection) sel;
				if (ssel.isEmpty()){
					canFinish = false;
				}
							
				List list = ssel.toList();
				canFinish = true;
				for (Object o : list){
					if(!(o instanceof EClass)){
						canFinish = false;
					}
				}
				
				if (canFinish) {			
					eClassTypes = list;
					treePageCompleted = true;
					return true;
				} else {
					eClassTypes = null;
					treePageCompleted = false;
					return false;
				}
			}
			
			/**
			 * @param event the event.
			 */
			public void handleEvent(Event event) {
				checkSelection();
				getWizard().getContainer().updateButtons();
			}
		}
	}
}
