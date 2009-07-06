/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.views.changes.CheckboxTreeComposite;
import org.unicase.workspace.edit.views.changes.MergeChangesComposite;
import org.unicase.workspace.impl.ProjectSpaceImpl;

/**
 * . This is the merge dialog. It shows three ChangesTreeComposites (my changes,
 * merged changes, and their changes)
 * 
 * @author Hodaie
 * 
 */
public class MergeDialog extends TitleAreaDialog implements
		ICheckStateListener, ISelectionChangedListener {

	private List<ChangePackage> newChangePackages;
	private CheckboxTreeComposite myChangesTree;
	private CheckboxTreeComposite theirChangesTree;

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 *            shell
	 * @param changePackages
	 *            a the list of changes that are merged into the workspace
	 */
	public MergeDialog(Shell parentShell, List<ChangePackage> changePackages) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
		this.newChangePackages = changePackages;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Merge");
		Rectangle area = Display.getCurrent().getClientArea();
		int width = area.width * 8 / 9;
		int height = area.height * 8 / 9;
		newShell.setBounds((area.width - width) / 2,
				(area.height - height) / 2, width, height);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(2, false));

		// lblMyChanges
		Label lblMyChanges = new Label(contents, SWT.NONE);
		lblMyChanges.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false, 1, 1));
		lblMyChanges.setText("My changes: ");

		// lblTheirChanges
		Label lblTheirChanges = new Label(contents, SWT.NONE);
		lblTheirChanges.setLayoutData(new GridData(SWT.END, SWT.CENTER, false,
				false, 1, 1));
		lblTheirChanges.setText("Their changes: ");

		// Sash
		ChangePackage changePackage = VersioningFactory.eINSTANCE
		.createChangePackage();
		// FIXME AS MK: add the correct operations
		changePackage.getOperations().addAll(
				((ProjectSpaceImpl) WorkspaceManager.getInstance()
						.getCurrentWorkspace().getActiveProjectSpace())
						.getOperations());
		ArrayList<ChangePackage> myChangePackages = new ArrayList<ChangePackage>();
		myChangePackages.add(changePackage);
		MergeChangesComposite composite = new MergeChangesComposite(contents,SWT.NONE,myChangePackages,newChangePackages);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2,
				1));
//		List<AbstractOperation> myOperations = new ArrayList<AbstractOperation>();
//		for (ChangePackage chPackage : myChangePackages) {
//			myOperations.addAll(chPackage.getOperations());
//		}
		// myChangesEditingSupport.setMyOperations(myOperations);

//		List<AbstractOperation> theirOperations = new ArrayList<AbstractOperation>();
//		for (ChangePackage chPackage : newChangePackages) {
//			theirOperations.addAll(chPackage.getOperations());
//		}
		// myChangesEditingSupport.setTheirOperations(theirOperations);
		//		
		// myChangesTree.getStatusColumn().setEditingSupport(
		// myChangesEditingSupport);

//		sashForm.setWeights(new int[] { 50, 50 });

		return contents;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		// TODO final implementation
		super.okPressed();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int open() {
		return super.open();
	}

	/**
	 * {@inheritDoc}
	 */
	public void checkStateChanged(CheckStateChangedEvent event) {
		Object element = event.getElement();
		if (element instanceof ChangePackage) {
			ChangePackage cp = (ChangePackage) element;
			for (AbstractOperation op : cp.getOperations()) {
				checkOperation(op);
			}
		}
		if (element instanceof AbstractOperation) {
			AbstractOperation op = (AbstractOperation) element;
			checkOperation(op);
		}
	}

	private void checkOperation(AbstractOperation op) {

	}

	public void selectionChanged(SelectionChangedEvent event) {
		// TODO Auto-generated method stub

	}

}
