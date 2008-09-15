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
import org.unicase.ui.stem.views.ChangesTreeComposite;

/**.
 * This is the merge dialog. It shows three ChangesTreeComposites (my changes, 
 * merged changes, and their changes)
 * 
 * @author Hodaie
 *
 */
public class MergeDialog extends TitleAreaDialog {

	/**.
	 * Constructor
	 * @param parentShell shell
	 */
	public  MergeDialog(Shell parentShell) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE );
	}

	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Merge");
	}

	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(5, true));
		
		//lblMyChanges
		Label lblMyChanges = new Label(contents, SWT.NONE);
		lblMyChanges.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false, 2, 1));
		lblMyChanges.setText("My changes: ");
		
		//lblMergedChanges
		Label lblMergedChanges = new Label(contents, SWT.NONE);
		lblMergedChanges.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false));
		lblMergedChanges.setText("Merged changes");
		
		//lblTheirChanges
		Label lblTheirChanges = new Label(contents, SWT.NONE);
		lblTheirChanges.setLayoutData(new GridData(SWT.END, SWT.CENTER, false,
				false, 2, 1));
		lblTheirChanges.setText("Their changes: ");
		
		//my changes tree
		ChangesTreeComposite myChangesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, true);
		myChangesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		//TODO final implementation (set input to my changes tree)
		
		//merged changes
		ChangesTreeComposite mergedChangesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, false);
		mergedChangesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		//TODO final implementation (set input to merged changes tree)
		
		//their changes
		ChangesTreeComposite theirChangesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, true);
		theirChangesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		//TODO final implementation (set input to their changes tree)
		
		//set number of changes on my and their changes
		lblMyChanges.setText("My changes: " + mergedChangesTree.getNumOfChanges());
		lblTheirChanges.setText("Their changes: " + mergedChangesTree.getNumOfChanges());
		
		//set number of merged changes on dialog title
		setTitle("Merge");
		setMessage("Number of merged changes: " + mergedChangesTree.getNumOfChanges());
		
		return contents;
		
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

	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public int open() {
		this.getButton(TitleAreaDialog.OK).setText("Merge");
		return super.open();
	}

}
