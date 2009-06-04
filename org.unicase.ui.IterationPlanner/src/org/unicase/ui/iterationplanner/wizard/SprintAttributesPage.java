/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.wizard;



import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unicase.ui.iterationplanner.core.IterationPlanner;

/**
 * Sprint attributes page.
 * @author hodaie
 *
 */
public class SprintAttributesPage extends WizardPage implements Listener {


	private IterationPlanner iterationPlanner;
	private Text txtSprintName;
	private Text txtSprintDuration;

	/**
	 * Constructor.
	 * @param planner iteration planner
	 */
	public SprintAttributesPage(IterationPlanner planner){
		super("sprint attributes page");
		this.iterationPlanner = planner;
	}
	
	/**
	 * 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return txtSprintName.getText() != "" && txtSprintDuration.getText().matches("[1-9]");
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		
		Composite contents = new Composite(parent, SWT.NONE);
		
		contents.setLayout(new GridLayout(2, false));
		
		//sprint name
		Label lblSprintName = new Label(
				contents, SWT.NONE);
		lblSprintName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		lblSprintName.setText("Sprint name:");
		
		txtSprintName = new Text(contents, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtSprintName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtSprintName.setText("");
		txtSprintName.addListener(SWT.KeyUp, this);
		
		//sprint duration
		Label lblSprintDuration = new Label(contents, SWT.NONE);
		lblSprintDuration.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		lblSprintDuration.setText("Sprint duration (weeks):");
		
		txtSprintDuration = new Text(contents, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtSprintDuration.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtSprintDuration.setText("");
		txtSprintDuration.addListener(SWT.KeyUp, this);
		
		setControl(contents);
		setPageComplete(true);
		
		
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		iterationPlanner.setSprintName(txtSprintName.getText());
		iterationPlanner.setSprintDuration(Integer.parseInt(txtSprintDuration.getText()));

		return super.getNextPage();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		getWizard().getContainer().updateButtons();
	}

	
	

}
