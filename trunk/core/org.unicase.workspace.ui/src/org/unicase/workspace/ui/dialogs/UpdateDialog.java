/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.views.changes.TabbedChangesComposite;

/**
 * This is the update dialog. It shows just a ChangesTreeComposite.
 * 
 * @author Hodaie
 */

public class UpdateDialog extends TitleAreaDialog {

	private List<ChangePackage> changes;
	private ProjectSpace activeProjectSpace;

	/**
	 * Constructor.
	 * 
	 * @param parentShell the parent shell
	 * @param changes the list of changes
	 */
	public UpdateDialog(Shell parentShell, List<ChangePackage> changes) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
		this.changes = changes;
		activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(2, false));

		// changes tree
		if (changes != null) {
			TabbedChangesComposite changesComposite = new TabbedChangesComposite(contents, SWT.BORDER, changes,
				activeProjectSpace.getProject());
			changesComposite.setReverseNodes(false);
			changesComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		}

		// show number of changes on dialog title
		setTitle("Changes from repository");
		return contents;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Update");

		Rectangle area = newShell.getShell().getParent().getClientArea();
		int width = area.width * 2 / 3;
		int height = area.height * 2 / 3;
		newShell.setBounds((area.width - width) / 2, (area.height - height) / 2, width, height);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		// TODO final implementation
		super.okPressed();
	}

}
