/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.taskview;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.model.organization.User;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;

/**
 * This dialog is shown when in TaskView checkbox is selected for a WorkItem which does not have a reviewer. The user
 * can select a reviewer, or set the WorkItem to resolved or done without a reviewer.
 * 
 * @author zardosht
 */
public class ReviewerSelectionDialog extends ElementListSelectionDialog {

	/**
	 * Message shown on {@link ReviewerSelectionDialog}.
	 */
	public static final String REVIEWERSELECTIONDIALOG_MESSAGE = "This work item has currently no reviewer. Please select a reviewer. \nYou can also set the work item to resolved or done without setting the reviewer (not recommended).";
	private static final int SET_RESOLVED_BUTTON_ID = 2;
	private static final int SET_DONE_BUTTON_ID = 3;

	/**
	 * return code for the case user selected set resolve without setting reviewer.
	 */
	public static final int RESOLVED_SET = 8;

	/**
	 * return code for the case user selected set done without setting reviewer.
	 */
	public static final int DONE_SET = 16;

	private WorkItem workItem;

	/**
	 * Constructor.
	 * 
	 * @param parent parent shell
	 * @param labelProvider label provider
	 * @param workItem the work item whose checkbox is clicked in task view
	 */
	public ReviewerSelectionDialog(Shell parent, ILabelProvider labelProvider, WorkItem workItem) {
		super(parent, labelProvider);
		this.workItem = workItem;

	}

	/**
	 *{@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 */
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == SET_RESOLVED_BUTTON_ID) {
			workItem.setResolved(true);
			setReturnCode(RESOLVED_SET);
			close();
		} else if (buttonId == SET_DONE_BUTTON_ID) {
			// set done without setting reviewer
			((Checkable) workItem).setChecked(true);
			setReturnCode(DONE_SET);
			close();
		}
		super.buttonPressed(buttonId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.dialogs.AbstractElementListSelectionDialog#createMessageArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Label createMessageArea(Composite composite) {
		Label label = super.createMessageArea(composite);
		if (getMessage() != null) {
			label.setText(getMessage());
		}
		label.setFont(composite.getFont());
		GridData labelLayoutData = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
		// labelLayoutData.widthHint = 500;
		label.setLayoutData(labelLayoutData);
		composite.getShell().setMinimumSize(500, 400);
		return label;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.dialogs.SelectionDialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		Button btnSetResolved = this.createButton(getOkButton().getParent(), SET_RESOLVED_BUTTON_ID, "Set resolved",
			false);
		btnSetResolved
			.setToolTipText("Sets this work item to resolved without setting its reviewer (not recommanded).");
		Button btnSetDone = this.createButton(getOkButton().getParent(), SET_DONE_BUTTON_ID, "Set done", false);
		btnSetDone.setToolTipText("Sets this work item to done without setting its reviewer (not recommanded).");

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#okPressed()
	 */
	@Override
	protected void okPressed() {

		User reviewer = (User) getSelectedElements()[0];
		workItem.setReviewer(reviewer);
		if (workItem.getAssignee() != null) {
			if (workItem.getAssignee().equals(reviewer)) {
				((Checkable) workItem).setChecked(true);
			} else {
				workItem.setResolved(true);
			}
		}
		super.okPressed();
	}

}
