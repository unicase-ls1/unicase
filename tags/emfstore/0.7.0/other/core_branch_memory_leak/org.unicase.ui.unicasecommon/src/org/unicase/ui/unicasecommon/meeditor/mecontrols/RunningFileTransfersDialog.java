/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.unicasecommon.meeditor.mecontrols;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.workspace.ProjectSpace;

/**
 * The modified ElementListSelectionDialog. Includes further functionality to import certificates from files instead of
 * choosing from the list.
 * 
 * @author pfeifferc
 */
public class RunningFileTransfersDialog extends ElementListSelectionDialog {

	// private ProjectSpace projectSpace;

	/**
	 * The constructor.
	 * 
	 * @param parent Parent
	 * @param renderer Renderer
	 * @param projectSpace project space
	 */
	public RunningFileTransfersDialog(Shell parent, ILabelProvider renderer, ProjectSpace projectSpace) {
		super(parent, renderer);
		// this.projectSpace = projectSpace;
	}

	/**
	 * Overridden method to allow adding further elements onto the dialog composite.
	 * 
	 * @see org.eclipse.ui.dialogs.ElementListSelectionDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * @return Control
	 * @param parent Parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// standard layout used by dialogue area
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);

		// two column layout composite
		Composite grid = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(grid);

		// left column composite
		Composite left = new Composite(grid, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(left);

		// left column: dialogue area composite (displays certificates and filter)
		Composite dialogArea = new Composite(left, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(dialogArea);
		Control control = super.createDialogArea(dialogArea);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);

		// left column: import button, composite used to ensure correct alignment
		Composite certButtonsComposite = new Composite(grid, SWT.NONE);
		GridLayoutFactory.createFrom(layout).numColumns(3).equalWidth(false).margins(layout.marginWidth, 0).applyTo(
			certButtonsComposite);
		applyDialogFont(certButtonsComposite);
		Button pause = new Button(certButtonsComposite, SWT.NONE);
		pause.setText("Pause");

		// Delete certificate
		Button resume = new Button(certButtonsComposite, SWT.NONE);
		resume.setText("Resume");
		resume.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do
			}

			public void widgetSelected(SelectionEvent e) {

			}
		});

		// Delete certificate
		Button remove = new Button(certButtonsComposite, SWT.NONE);
		remove.setText("Remove");

		fFilteredList.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do
			}

			public void widgetSelected(SelectionEvent e) {
			}
		});
		// setListElements(projectSpace.getPendingFileTransfers().toArray());

		return control;
	}
}