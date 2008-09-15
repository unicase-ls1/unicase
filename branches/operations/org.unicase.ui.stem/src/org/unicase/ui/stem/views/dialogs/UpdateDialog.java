/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.stem.views.ChangesTreeComposite;

/**.
 * This is the update dialog. It shows just a ChangesTreeComposite
 * @author Hodaie
 *
 */

public class UpdateDialog extends TitleAreaDialog {

	/**.
	 * Constructor
	 * @param parentShell
	 */
	public UpdateDialog(Shell parentShell) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE );
	}

	

	/**.
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(2, false));
			
		//changes tree
		ChangesTreeComposite changesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, true);
		changesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		//TODO final implementation (set input to changes tree)
		
		
		//show number of changes on dialog title
		setTitle("Changes from repository");
		setMessage("Number of changes: " + changesTree.getNumOfChanges());
		
		return contents;
		
	}
	
	/**.
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Update");
	}
	
	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public int open() {
		this.getButton(TitleAreaDialog.OK).setText("Update");
		return super.open();
	}
	
	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	protected void okPressed() {
		// TODO final implementation
		super.okPressed();
	}

}

