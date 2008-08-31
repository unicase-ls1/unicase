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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.ui.stem.views.ChangesTreeComposite;

/**.
 * This class shows a ChangesTreeComposite and a Text control to enter
 * commit message.
 * 
 * @author Hodaie
 *
 */
public class CommitDialog extends TitleAreaDialog {

	/**.
	 * Constructor
	 * 
	 * @param parentShell shell
	 */
	public CommitDialog(Shell parentShell) {

		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE );
		

	}

	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(2, false));
		
		//ChangesTree	
		ChangesTreeComposite changesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, true);
		changesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		//TODO final implementation (set input for ChangesTreeComposite)
		
		//Log message
		Label lblLogMsg = new Label(contents, SWT.NONE);
		lblLogMsg.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false, 2, 1));
		lblLogMsg.setText("Log message:");
		
		Text txtLogMsg = new Text(contents, SWT.MULTI | SWT.LEAD | SWT.BORDER);
		txtLogMsg.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		txtLogMsg.setText("");
		
		//set number of chnages on dialog title
		setTitle("Uncommited changes");
		setMessage("Number of changes: " + changesTree.getNumOfChanges());
		
		return contents;

	}
	
	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	protected void configureShell(Shell newShell) {
		
		super.configureShell(newShell);
		newShell.setText("Commit");
	}


	/**.
	 * {@inheritDoc}
	 * 
	 * 
	 */
	@Override
	protected void okPressed() {
		// TODO final implementation
		super.okPressed();
	}

	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public int open() {
		this.getButton(TitleAreaDialog.OK).setText("Commit");
		return super.open();
	}
	
}

