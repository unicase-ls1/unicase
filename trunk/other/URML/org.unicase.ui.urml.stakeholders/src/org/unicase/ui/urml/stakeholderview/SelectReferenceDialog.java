/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * Dialog for selecting the reference elements for the review view.
 * 
 * @author kterzieva
 */
public class SelectReferenceDialog extends TitleDialogWithoutMinSize {

	private EList<EReference> references;

	/**
	 * The construct.
	 * 
	 * @param parentShell the parent shell
	 * @param references list with the references
	 */
	public SelectReferenceDialog(Shell parentShell, EList<EReference> references) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.references = references;
	}

	@Override
	protected void configureShell(Shell parent) {
		super.configureShell(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		setTitle("Test");
		setMessage("Choose a reference for the review view");
		// Create composite
		Composite wrap = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(wrap, SWT.NONE);
		// Layout stuff
		GridLayout gridLayout = new GridLayout(1, false);
		composite.setLayout(gridLayout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		composite.setFont(parent.getFont());

		Group group = new Group(composite, SWT.HORIZONTAL);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));
		group.setText("Reference list");

		for (EReference re : references) {
			Button b = new Button(group, SWT.RADIO);
			b.setLayoutData(new GridData());
			b.setText(re.getName());
		}
		Label titleBarSeparator = new Label(wrap, SWT.HORIZONTAL | SWT.SEPARATOR);
		titleBarSeparator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return group;
	}

}
