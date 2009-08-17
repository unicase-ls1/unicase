/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.wizard;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.util.UnicaseUiUtil;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;
import org.unicase.workspace.WorkspaceManager;

/**
 * Sprint attributes page.
 * 
 * @author hodaie
 * 
 */
public class SprintAttributesPage extends WizardPage implements Listener {

	private IterationPlannerManager iterationPlanner;
	private Text txtSprintName;
	private Text txtStartDate;
	private Text txtEndDate;
	private Text txtPredecessor;

	/**
	 * Constructor.
	 * 
	 * @param planner
	 *            iteration planner
	 */
	public SprintAttributesPage(IterationPlannerManager planner) {
		super("sprint attributes page");
		this.iterationPlanner = planner;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return !txtPredecessor.getText().equals("")
				&& !txtSprintName.getText().equals("")
				&& txtStartDate.getText() != "" && txtEndDate.getText() != "";
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		Composite contents = new Composite(parent, SWT.NONE);

		contents.setLayout(new GridLayout(3, false));

		Label lblPred = new Label(contents, SWT.NONE);
		lblPred.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		lblPred.setText("Predecessor:");

		txtPredecessor = new Text(contents, SWT.BORDER);
		txtPredecessor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		txtPredecessor.setText("");
		txtPredecessor.setEnabled(false);

		Button btnPredecessor = new Button(contents, SWT.PUSH);
		btnPredecessor.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false));
		btnPredecessor.setText("Select...");
		btnPredecessor.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				Object[] result = UnicaseUiUtil.showMESelectionDialog(
						getShell(), TaskPackage.eINSTANCE.getWorkPackage(),
						WorkspaceManager.getInstance().getCurrentWorkspace()
								.getActiveProjectSpace().getProject(), false);
				if (result.length > 0) {
					iterationPlanner.setLastSprint((WorkPackage) result[0]);
					txtPredecessor.setText(((WorkPackage) result[0]).getName());
					txtStartDate.setText(iterationPlanner.getLastSprint()
							.getEndDate().toString());
					txtEndDate.setText(getEndDate(
							iterationPlanner.getLastSprint()).toString());
				}
			}

		});

		// sprint name
		Label lblSprintName = new Label(contents, SWT.NONE);
		lblSprintName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false));
		lblSprintName.setText("Sprint name:");

		txtSprintName = new Text(contents, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtSprintName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1));
		txtSprintName.setText("");
		txtSprintName.addListener(SWT.KeyUp, this);

		// sprint start date
		Label lblStartDate = new Label(contents, SWT.NONE);
		lblStartDate.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false));
		lblStartDate.setText("Start date:");

		txtStartDate = new Text(contents, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtStartDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		txtStartDate.setText("");
		txtStartDate.addListener(SWT.Modify, this);

		// sprint end date
		Label lblEndDate = new Label(contents, SWT.NONE);
		lblEndDate.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		lblEndDate.setText("End date: ");

		txtEndDate = new Text(contents, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtEndDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1));
		txtEndDate.setText("");
		txtEndDate.addListener(SWT.Modify, this);

		setControl(contents);
		setPageComplete(true);

	}

	/**
	 * 
	 * @param lastSprint
	 * @return
	 */
	private Date getEndDate(WorkPackage lastSprint) {
		long lastSprintEnd = lastSprint.getEndDate().getTime();
		long lastSprintDuration = lastSprint.getEndDate().getTime()
				- lastSprint.getStartDate().getTime();
		long endDate = lastSprintEnd + lastSprintDuration;
		Date ret = new Date(endDate);

		return ret;

	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		iterationPlanner.getSprint().setName(txtSprintName.getText());
		try {
			iterationPlanner.getSprint().setStartDate(
					DateFormat.getInstance().parse(txtStartDate.getText()));
			iterationPlanner.getSprint().setEndDate(
					DateFormat.getInstance().parse(txtEndDate.getText()));

		} catch (ParseException e) {
			e.printStackTrace();
		}

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
