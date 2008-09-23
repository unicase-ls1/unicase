/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.ui.stem.views.ChangesTreeComposite;
import org.unicase.ui.stem.views.MergeTreeComposite;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;

/**.
 * This is the merge dialog. It shows three ChangesTreeComposites (my changes, 
 * merged changes, and their changes)
 * 
 * @author Hodaie
 *
 */
public class MergeDialog extends TitleAreaDialog {

	private List<ChangePackage> newChangePackages;

	/**.
	 * Constructor
	 * @param parentShell shell
	 */
	public  MergeDialog(Shell parentShell, List<ChangePackage> changePackages) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE );
		this.newChangePackages = changePackages;
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
		contents.setLayout(new GridLayout(4, false));
		
		//lblMyChanges
		Label lblMyChanges = new Label(contents, SWT.NONE);
		lblMyChanges.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false, 2, 1));
		lblMyChanges.setText("My changes: ");
		
		//lblTheirChanges
		Label lblTheirChanges = new Label(contents, SWT.NONE);
		lblTheirChanges.setLayoutData(new GridData(SWT.END, SWT.CENTER, false,
				false, 2, 1));
		lblTheirChanges.setText("Their changes: ");
		
		//my changes tree
		ChangesTreeComposite myChangesTree = new ChangesTreeComposite(contents,
				SWT.BORDER);
		myChangesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		//FIXME AS MK: add the correct operations  
		changePackage.getOperations().addAll(((ProjectSpaceImpl)WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace()).getOperations());
		ArrayList<ChangePackage> changePackages = new ArrayList<ChangePackage>();
		changePackages.add(changePackage);
		myChangesTree.setInput(changePackages);
						
		//their changes
		MergeTreeComposite theirChangesTree = new MergeTreeComposite(contents,
				SWT.BORDER);
		theirChangesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		theirChangesTree.setInput(newChangePackages);
		
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
		return super.open();
	}

}
