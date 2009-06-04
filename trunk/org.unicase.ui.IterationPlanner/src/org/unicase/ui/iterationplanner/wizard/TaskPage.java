/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.wizard;


import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.core.IterationPlanner;

import java.util.List;

/**
 * In this page user selects backlog, and last sprint.
 * 
 * @author hodaie
 * 
 */
public class TaskPage extends WizardPage implements Listener {

	private IterationPlanner iterationPlanner;
	private TableViewer tableViewer;

	
	
	
	/**
	 * Constructor.
	 * 
	 * @param planner
	 *            iteration planner.
	 */
	protected TaskPage(IterationPlanner planner) {
		super("task page");
		this.iterationPlanner = planner;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		
		Composite contents = new Composite(parent, SWT.NONE);
		
		contents.setLayout(new GridLayout(2, false));
		
		Label lblLastSprint = new Label(contents, SWT.NONE);
		lblLastSprint.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false, 2, 1));
		lblLastSprint.setText("Select work packages to include in planning (you will be normally selecting project backlog and last sprint):");
		
		Button btnAdd = new Button(contents, SWT.PUSH);
		btnAdd.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnAdd.setText("Add work package....");
		
		Button btnRemove = new Button(contents, SWT.PUSH);
		btnRemove.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnRemove.setText("Remove");
		
		
		tableViewer = new TableViewer(contents, SWT.NONE);
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(iterationPlanner.getWorkPackages().toArray());
		
		setControl(contents);
		setPageComplete(true);
		

		
		
	}
	
	
	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {

		return super.canFlipToNextPage();
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IWizardPage getNextPage() {
		iterationPlanner.setWorkPackages((List<WorkPackage>) tableViewer.getInput());
		
		return super.getNextPage();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	

}
