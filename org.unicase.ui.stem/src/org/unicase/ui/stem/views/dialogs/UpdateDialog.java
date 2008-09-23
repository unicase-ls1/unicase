/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.ui.stem.views.ChangesTreeComposite;

/**.
 * This is the update dialog. It shows just a ChangesTreeComposite
 * @author Hodaie
 *
 */

public class UpdateDialog extends TitleAreaDialog {

	private List<ChangePackage> changes;


	/**.
	 * Constructor.
	 * @param parentShell the parent shell
	 * @param changes the list of changes
	 */
	public UpdateDialog(Shell parentShell, List<ChangePackage> changes) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE );
		this.changes = changes;
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
				SWT.BORDER);
		changesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		if(changes!=null){
			changesTree.setInput(changes);
		}
		
		//show number of changes on dialog title
		setTitle("Changes from repository");
		setMessage(changesTree.getNumOfChanges() + " changes will be merged in your project.");
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
	protected void okPressed() {
		// TODO final implementation
		super.okPressed();
	}

}

